package com.thuni.his.business.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thuni.his.business.bean.Organization;
import com.thuni.his.business.bean.Role;
import com.thuni.his.business.bean.RoleScope;
import com.thuni.his.business.bean.User;
import com.thuni.his.business.dao.OrganizationDao;
import com.thuni.his.business.dao.RoleScopeDao;
import com.thuni.his.business.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleGraphqlQLResolver implements GraphQLResolver<Role> {
    @Autowired
    private RoleScopeDao roleScopeDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private UserDao userDao;

    public RoleScope scope(Role role) {
        if (null == role) {
            return null;
        }
        return roleScopeDao.findById(role.getScope().getId()).get();
    }

    public Organization organization(Role role) {
        if (null == role) {
            return null;
        }
        return organizationDao.getOne(role.getOrganization().getId());
    }

    public List<User> users(Role role) {
        List<User> userList = new ArrayList<>();
        if (CollectionUtils.isEmpty(role.getUsers())) {
            return null;
        }
        role.getUsers().stream().forEach(user -> {
            userList.add(userDao.findById(user.getId()).get());
        });
        return userList;
    }
}
