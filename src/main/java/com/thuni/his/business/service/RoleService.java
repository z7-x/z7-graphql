package com.thuni.his.business.service;

import com.thuni.his.business.bean.Role;
import com.thuni.his.business.bean.User;
import com.thuni.his.business.dao.RoleDao;
import com.thuni.his.business.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserDao userDao;

    public Role addMRole(Role role){
        Role save = roleDao.save(role);
        List<User> users = userDao.saveAll(role.getUsers());
        if(!CollectionUtils.isEmpty(users)){
           save.setUsers(users);
        }
        return save;
    }
}
