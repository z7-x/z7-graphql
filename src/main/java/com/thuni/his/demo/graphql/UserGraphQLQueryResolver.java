package com.thuni.his.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thuni.his.demo.bean.User;
import com.thuni.his.demo.graphql.inputs.UserFilter;
import com.thuni.his.demo.graphql.types.UserConnection;
import com.thuni.his.demo.service.UserService;
import org.jfantasy.framework.dao.OrderBy;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.util.common.ObjectUtil;
import org.jfantasy.graphql.util.Kit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserGraphQLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public UserConnection users(UserFilter filter, int page, int pageSize, OrderBy orderBy) {
        Pager<User> pager = new Pager<>(page, pageSize, orderBy);
        filter = ObjectUtil.defaultValue(filter, new UserFilter());
        return Kit.connection(userService.findPager(pager, filter.build()), UserConnection.class);
    }

    public User findUserById(Long userId){
        Optional<User> userList = userService.get(userId);
       return userList.isPresent() ? userList.get() : null;
    }

}
