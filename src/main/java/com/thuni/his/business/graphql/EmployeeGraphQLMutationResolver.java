package com.thuni.his.business.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.business.bean.*;
import com.thuni.his.business.graphql.converters.*;
import com.thuni.his.business.graphql.inputs.*;
import com.thuni.his.business.service.*;
import com.thuni.his.system.bean.Address;
import com.thuni.his.system.bean.Email;
import com.thuni.his.system.bean.Phone;
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
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private UserService userService;
    @Autowired
    private JobService jobService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RolesConverter rolesConverter;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentConverter departmentConverter;

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

    public Phone addMPhone(Phone phone){
        return phoneService.addMPhone(phone);
    }

    public Job addMJob(Job job){
        return jobService.addMJob(job);
    }

    public Position addAndModifyPosition(Position position){
        return null;
    }

    /**
     * 关系:多对多 不创建bean实体
     * 新增/修改 部门-部门角色-部门类型
     * @param input
     * @return
     */
    public Department addAndModifyDepartment(DepartmentInput input){
//        return departmentService.addAndModifyDepartment(departmentConverter);
        return null;
    }

    /**
     * 关系:多对多 不创建bean实体
     * 新增/修改 角色信息的同时将角色信息绑定到用户
     * @param input
     * @return
     */
    public Role createAndUpdateRole(RolesInput input) {
        return roleService.createAndUpdateRole(rolesConverter.toRole(input));
    }
    /**
     * 关系:多对多 不创建bean实体
     * 新增/修改 用户信息的同时将用户信息绑定到角色
     * @param input
     * @return
     */
    public User createAndUpdateUser(UserInput input) {
        return userService.createAndUpdateUser(userConverter.toUser(input));
    }
}
