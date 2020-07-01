package com.thuni.his.business.service;

import com.thuni.his.business.bean.Department;
import com.thuni.his.business.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public Department addAndModifyDepartment(Department department){
        return departmentDao.save(department);
    }
}
