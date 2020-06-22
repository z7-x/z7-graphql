package com.thuni.his.business.graphql.converters;

import com.thuni.his.business.bean.Role;
import com.thuni.his.business.bean.User;
import com.thuni.his.business.graphql.inputs.RolesInput;
import org.mapstruct.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface RolesConverter {

    @Mappings({
            @Mapping(source = "scope",target = "scope.id"),
            @Mapping(source = "organization",target = "organization.id"),
            @Mapping(source = "users",target = "users",qualifiedByName = "toUsers")
    })
    Role toRole(RolesInput input);

    @Named("toUsers")
    default List<User> toUsers(List<Long> source){
        if(CollectionUtils.isEmpty(source)){
            return null;
        }
        List<User> userList = new ArrayList<User>();
        source.stream().forEach(aLong -> {
            userList.add(User.builder().id(aLong).build());
        });
        return userList;
    }


}
