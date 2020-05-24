package com.thuni.his.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.demo.bean.Authority;
import com.thuni.his.demo.bean.People;
import com.thuni.his.demo.bean.User;
import com.thuni.his.demo.dao.PeopleDao;
import com.thuni.his.demo.service.AuthorityService;
import com.thuni.his.demo.service.PeopleService;
import com.thuni.his.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Component
@Transactional
public class UserGraphQLMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;

    public User createUser(User user) {
        return userService.save(user);
    }

    public Authority createMicroserviceAuthority(Authority authority) {
        return authorityService.saveAuthority(authority);
    }

    public Authority updateMicroserviceAuthority(Long id,Boolean merge,Authority authority){
        authority.setId(id);
        return authorityService.updateAuthority(authority,merge);
    }

}
