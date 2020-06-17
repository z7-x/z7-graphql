package com.thuni.his.business.service;

import com.thuni.his.business.bean.Employee;
import com.thuni.his.business.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public Employee createAndUpdateEmployee(Employee employee){
            return employeeDao.save(employee);
    }

    public Boolean deleteEmployee(Long id){
        Optional<Employee> byId = employeeDao.findById(id);
        if(byId.isPresent()){
            employeeDao.delete(byId.get());
            return true;
        }
        return false;
    }
}
