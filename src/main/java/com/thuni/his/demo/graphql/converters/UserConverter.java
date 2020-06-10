package com.thuni.his.demo.graphql.converters;

import com.thuni.his.demo.bean.Users;
import com.thuni.his.demo.graphql.inputs.UserAuthorityInput;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);


    List<Users> toUser(List<UserAuthorityInput> input);


    @Mappings({
            @Mapping(source = "input.username", target = "username"),
            @Mapping(source = "input.password", target = "password"),
            @Mapping(source = "input.authorityList", target = "authorityList")
    })
    Users toUser(UserAuthorityInput input);

}
