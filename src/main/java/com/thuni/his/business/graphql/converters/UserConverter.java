package com.thuni.his.business.graphql.converters;

import com.thuni.his.business.bean.Role;
import com.thuni.his.business.bean.User;
import com.thuni.his.business.graphql.inputs.UserInput;
import org.mapstruct.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserConverter {

    @Mappings({
            @Mapping(source = "employeeId",target = "employee.id"),
            @Mapping(source = "organizationId",target = "organization.id"),
            @Mapping(source = "roleIds",target = "roles",qualifiedByName = "toRoles")
    })
    User toUser(UserInput input);

    @Named("toRoles")
    default List<Role> toRoles(List<Long> longs) {
        List<Role> roleList = new ArrayList<>();
        if(CollectionUtils.isEmpty(longs)){
            return null;
        }
        longs.stream().forEach(aLong -> {
            roleList.add(Role.builder().id(aLong).build());
        });
        return roleList;
    }
}
