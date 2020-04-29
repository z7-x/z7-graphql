package com.thuni.his.demo.dao;

import com.thuni.his.demo.bean.Address;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<Address,Long> {

}
