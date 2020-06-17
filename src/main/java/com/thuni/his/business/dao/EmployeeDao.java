package com.thuni.his.business.dao;

import com.thuni.his.business.bean.Employee;
import org.jfantasy.framework.dao.jpa.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
}
