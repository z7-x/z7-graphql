package com.thuni.his.business.service;

import com.thuni.his.business.bean.Role;
import com.thuni.his.business.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role addMRole(Role role){
        return roleDao.save(role);
    }
}
