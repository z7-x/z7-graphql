package com.thuni.his.demo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thuni.his.demo.bean.User;
import com.thuni.his.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UserGraphQLResolver implements GraphQLResolver<User> {

    @Autowired
    private UserService userService;


}
