package com.thuni.his.business.graphql.inputs;

import com.thuni.his.business.bean.Employee;
import com.thuni.his.system.bean.Email;
import lombok.Data;

@Data
public class EmployeeEmailInput {
    private String label;
    private Boolean primary;
    private Email email;
    private Employee employee;
}
