package com.thuni.his.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.demo.bean.User;
import com.thuni.his.demo.service.UserService;
import org.jfantasy.framework.spring.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGraphQLMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(User user) {
        return userService.save(user);
    }

}
