package com.thuni.his.business.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.business.bean.RoleScope;
import com.thuni.his.business.service.RoleScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessGraphQLMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private RoleScopeService roleScopeService;

    public RoleScope createAndUpdateRoleScope(RoleScope roleScope){
        return roleScopeService.createAndUpdateRoleScope(roleScope);
    }

    public Boolean deleteRoleScope(Long id){
        return roleScopeService.deleteRoleScope(id);
    }

}
