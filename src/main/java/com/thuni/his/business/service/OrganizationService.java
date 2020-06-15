package com.thuni.his.business.service;

import com.thuni.his.business.bean.Organization;
import com.thuni.his.business.dao.OrganizationDao;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.dao.jpa.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrganizationService {

    @Autowired
    private OrganizationDao organizationDao;

    public Organization createAndUpdateOrganization(Organization organization){
        if(StringUtils.isEmpty(organization)){
            return null;
        }
        return organizationDao.save(organization);
    }

    public Boolean deleteOrganization(Long id){
        Optional<Organization> byId = organizationDao.findById(id);
        if(byId.isPresent()){
            organizationDao.delete(byId.get());
            return true;
        }
        return false;
    }

    public Pager<Organization> findPages(Pager<Organization> pager, List<PropertyFilter> filters){
        return organizationDao.findPager(pager,filters);
    }
}
