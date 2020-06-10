package com.thuni.his.demo.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thuni.his.demo.bean.Users;
import com.thuni.his.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UserGraphQLResolver implements GraphQLResolver<Users> {

    @Autowired
    private UserService userService;


}
