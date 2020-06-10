package com.thuni.his.system.dao;
import com.thuni.his.system.bean.Phone;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneDao extends JpaRepository<Phone, Long> {
}
