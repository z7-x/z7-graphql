package com.thuni.his.business.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thuni.his.business.bean.RoleScope;
import com.thuni.his.business.graphql.inputs.RoleScopeFilter;
import com.thuni.his.business.graphql.types.RoleScopeConnection;
import com.thuni.his.business.service.RoleScopeService;
import org.jfantasy.framework.dao.OrderBy;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.util.common.ObjectUtil;
import org.jfantasy.graphql.util.Kit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BusinessGraphQLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private RoleScopeService roleScopeService;

    public List<RoleScope> findRoleScopes(){
        return roleScopeService.findRoleScopes();
    }

    public RoleScopeConnection findRoleScopePage(RoleScopeFilter filter, int page, int pageSize, OrderBy orderBy){
        Pager<RoleScope> pager = new Pager<>(page, pageSize, orderBy);
        filter = ObjectUtil.defaultValue(filter,new RoleScopeFilter());
       return Kit.connection(roleScopeService.findPages(pager,filter.build()),RoleScopeConnection.class);
    }
}
