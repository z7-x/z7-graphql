package com.thuni.his.demo.dao;

import com.thuni.his.demo.bean.People;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleDao extends JpaRepository<People,Long> {

}
