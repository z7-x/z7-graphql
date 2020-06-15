package com.thuni.his.business.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.business.bean.Organization;
import com.thuni.his.business.bean.RoleScope;
import com.thuni.his.business.dao.OrganizationDao;
import com.thuni.his.business.service.OrganizationService;
import com.thuni.his.business.service.RoleScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessGraphQLMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private RoleScopeService roleScopeService;
    @Autowired
    private OrganizationService organizationService;

    public RoleScope createAndUpdateRoleScope(RoleScope roleScope){
        return roleScopeService.createAndUpdateRoleScope(roleScope);
    }

    public Boolean deleteRoleScope(Long id){
        return roleScopeService.deleteRoleScope(id);
    }

    public Organization createAndUpdateOrganization(Organization organization){
        return organizationService.createAndUpdateOrganization(organization);
    }

    public Boolean deleteOrganization(Long id){
        return  organizationService.deleteOrganization(id);
    }
}
