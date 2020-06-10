package com.thuni.his.system.dao;


import com.thuni.his.demo.bean.Addresss;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Addresss, Long> {
}
