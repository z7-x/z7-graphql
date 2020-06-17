package com.thuni.his.business.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.business.bean.Employee;
import com.thuni.his.business.bean.EmployeeAddress;
import com.thuni.his.business.bean.EmployeeEmail;
import com.thuni.his.business.graphql.converters.EmployeeAddressConverter;
import com.thuni.his.business.graphql.converters.EmployeeEmailConverter;
import com.thuni.his.business.graphql.inputs.EmployeeAddressInput;
import com.thuni.his.business.graphql.inputs.EmployeeEmailInput;
import com.thuni.his.business.service.*;
import com.thuni.his.system.bean.Address;
import com.thuni.his.system.bean.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeGraphQLMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private EmployeeAddressService employeeAddressService;
    @Autowired
    private EmployeeAddressConverter employeeAddressConverter;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmployeeEmailService employeeEmailService;
    @Autowired
    private EmployeeEmailConverter employeeEmailConverter;

    public Employee createAndUpdateEmployee(Employee employee){
        return employeeService.createAndUpdateEmployee(employee);
    }

    public Boolean deleteEmployee(Long id){
        return employeeService.deleteEmployee(id);
    }

    public Address createAndUpdateAddress(Address address){
        return addressService.createAndUpdateAddress(address);
    }

    public EmployeeAddress allotEmployeeAndAddress(EmployeeAddressInput employeeAddressInput){
       return employeeAddressService.employeeAddress(employeeAddressConverter.toEmployeeAddress(employeeAddressInput));
    }
    public Email addAndModifyEmail(Email email){
        return emailService.addAndModify(email);
    }

    public Boolean removeEmail(Long id){
        return emailService.removeEmail(id);
    }

    public EmployeeEmail allotEmployeeAndEmail(EmployeeEmailInput employeeEmailInput){
        return employeeEmailService.addAndModify(employeeEmailConverter.toEmployeeAddress(employeeEmailInput));
    }
}
