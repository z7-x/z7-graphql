package com.thuni.his.business.graphql.converters;


import com.thuni.his.business.bean.Department;
import com.thuni.his.business.bean.DepartmentType;
import com.thuni.his.business.bean.Role;
import com.thuni.his.business.graphql.inputs.DepartmentInput;
import org.mapstruct.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DepartmentConverter {

    @Mappings({
            @Mapping(source = "longs", target = "roles", qualifiedByName = "toRoles"),
            @Mapping(source = "organization", target = "organization.id"),
            @Mapping(source = "type", target = "type", qualifiedByName = "toDepartmentType"),
    })
    Department toDepartment(DepartmentInput input);

    @Named("toRoles")
    default List<Role> toRoles(List<Long> longs) {
        if (CollectionUtils.isEmpty(longs)) return null;
        List<Role> roleList = new ArrayList<>();
        longs.stream().forEach(aLong -> {
            roleList.add(Role.builder().id(aLong).build());
        });
        return roleList;
    }

    @Named("toDepartmentType")
    default DepartmentType toDepartmentType(DepartmentType type) {
        if (null == type) return null;
        DepartmentType build = DepartmentType.builder()
                .name(type.getName()).organization(type.getOrganization())
                .build();
        return build;
    }
}
