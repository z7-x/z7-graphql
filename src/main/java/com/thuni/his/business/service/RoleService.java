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

    public Role createAndUpdateRole(Role role){
        //多对多批量保存 往中间表里面批量保存数据  一个userId对应多个roleId
        Role save = roleDao.save(role);
        return save;
    }
}
