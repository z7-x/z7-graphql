package com.thuni.his.demo.dao;

import com.thuni.his.demo.bean.Authority;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityDao extends JpaRepository<Authority,Long> {
}
