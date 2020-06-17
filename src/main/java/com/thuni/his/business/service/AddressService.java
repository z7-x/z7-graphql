package com.thuni.his.business.service;

import com.thuni.his.system.bean.Address;
import com.thuni.his.system.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    public Address createAndUpdateAddress(Address address){
            return addressDao.save(address);
    }
}
