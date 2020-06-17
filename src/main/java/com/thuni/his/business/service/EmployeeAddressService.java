package com.thuni.his.business.service;

import com.thuni.his.business.bean.EmployeeAddress;
import com.thuni.his.business.dao.EmployeeAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeAddressService {
    @Autowired
    private EmployeeAddressDao employeeAddressDao;

    public EmployeeAddress employeeAddress(EmployeeAddress employeeAddress){
        return employeeAddressDao.save(employeeAddress);
    }
}
