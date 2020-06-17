package com.thuni.his.business.service;

import com.thuni.his.business.bean.EmployeeEmail;
import com.thuni.his.business.dao.EmployeeEmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeEmailService {
    @Autowired
    private EmployeeEmailDao employeeEmailDao;

    public EmployeeEmail addAndModify(EmployeeEmail employeeEmail){
        return employeeEmailDao.save(employeeEmail);
    }

}
