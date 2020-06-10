package com.thuni.his.system.dao;

import com.thuni.his.system.bean.Email;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDao extends JpaRepository<Email, Long> {
}
