package com.thuni.his.demo.service;

import com.thuni.his.demo.bean.Authority;
import com.thuni.his.demo.bean.Users;
import com.thuni.his.demo.dao.AuthorityDao;
import com.thuni.his.demo.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;
    @Autowired
    private UsersDao usersDao;

    /**
     * 保存权限
     */
   public Authority saveAuthority(Authority authority){
       return authorityDao.save(authority);
   }

    /**
     * 修改权限
     */
    public Authority updateAuthority(Authority authority,Boolean merge){
        return authorityDao.update(authority,merge);
    }

    /**
     * 多对多保存: 用户权限
     */
    public Authority saveAuthorityUser(Authority authority){
        Authority save = authorityDao.save(authority);
        List<Users> userList = usersDao.saveAll(save.getUserList());
        save.setUserList(userList);
        return save;
    }
}
