package com.thuni.his.demo.dao;


import com.thuni.his.demo.bean.User;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Long> {

}