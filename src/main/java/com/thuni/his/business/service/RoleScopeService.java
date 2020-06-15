package com.thuni.his.business.service;

import com.thuni.his.business.bean.RoleScope;
import com.thuni.his.business.dao.RoleScopeDao;
import com.thuni.his.business.graphql.inputs.RoleScopeFilter;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.dao.jpa.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleScopeService {
    @Autowired
    private RoleScopeDao roleScopeDao;

    public RoleScope createAndUpdateRoleScope(RoleScope roleScope){
        if(StringUtils.isEmpty(roleScope)){
            return null;
        }
        return roleScopeDao.save(roleScope);
    }

    public Boolean deleteRoleScope(Long id){
        Optional<RoleScope> roleScopeOptional = roleScopeDao.findById(id);
        if(roleScopeOptional.isPresent()){
            roleScopeDao.delete(roleScopeOptional.get());
            return true;
        }
        return false;
    }

    public List<RoleScope> findRoleScopes(){
        return roleScopeDao.findAll();
    }

    public Pager<RoleScope> findPages(Pager<RoleScope> pager, List<PropertyFilter> filters){
        return roleScopeDao.findPager(pager,filters);
    }

}
