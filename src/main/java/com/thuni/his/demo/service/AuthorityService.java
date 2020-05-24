package com.thuni.his.demo.service;

import com.thuni.his.demo.bean.Authority;
import com.thuni.his.demo.dao.AuthorityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

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
}
