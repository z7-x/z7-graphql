package com.thuni.his.business.service;


import com.thuni.his.business.bean.User;
import com.thuni.his.business.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public User createAndUpdateUser(User user){
        return userDao.save(user);
    }
}
