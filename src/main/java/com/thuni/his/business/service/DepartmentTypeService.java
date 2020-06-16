package com.thuni.his.business.service;

import com.thuni.his.business.bean.DepartmentType;
import com.thuni.his.business.bean.Organization;
import com.thuni.his.business.dao.DepartmentTypeDao;
import com.thuni.his.business.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DepartmentTypeService {

    @Autowired
    private DepartmentTypeDao departmentTypeDao;
    @Autowired
    private OrganizationDao organizationDao;

    public DepartmentType createAndUpdateDepartmentType(DepartmentType departmentType){
        if(StringUtils.isEmpty(departmentType)){
            return null;
        }
        DepartmentType save = departmentTypeDao.save(departmentType);
        Optional<Organization> optionalOrganization = organizationDao.findById(save.getOrganization().getId());
        save.setOrganization(optionalOrganization.get());
        return save;
    }
}
