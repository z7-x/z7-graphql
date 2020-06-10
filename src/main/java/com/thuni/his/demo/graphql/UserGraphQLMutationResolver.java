package com.thuni.his.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.demo.bean.Authority;
import com.thuni.his.demo.bean.Users;
import com.thuni.his.demo.graphql.converters.UserConverter;
import com.thuni.his.demo.graphql.inputs.UserAuthorityInput;
import com.thuni.his.demo.service.AuthorityService;
import com.thuni.his.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserGraphQLMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;
    @Autowired
    private UserConverter userConverter;

    public Users createUser(Users user) {
        return userService.save(user);
    }

    public Authority createMicroserviceAuthority(Authority authority) {
        return authorityService.saveAuthority(authority);
    }

    public Authority updateMicroserviceAuthority(Long id,Boolean merge,Authority authority){
        authority.setId(id);
        return authorityService.updateAuthority(authority,merge);
    }

    public Users createMicroserviceUserAuthority(UserAuthorityInput userAuthorityInput){
        Users user = userConverter.toUser(userAuthorityInput);
        return userService.saveUserAuthority(user);
    }

    public Authority createMicroserviceAuthorityUser(Authority authority){
        return authorityService.saveAuthorityUser(authority);
    }

}
