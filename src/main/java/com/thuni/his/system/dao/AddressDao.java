package com.thuni.his.system.dao;


import com.thuni.his.demo.bean.Addresss;
import com.thuni.his.system.bean.Address;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {
}
