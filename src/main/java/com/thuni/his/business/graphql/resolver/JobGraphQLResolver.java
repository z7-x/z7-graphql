package com.thuni.his.business.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.thuni.his.business.bean.Job;
import com.thuni.his.business.bean.Organization;
import com.thuni.his.business.dao.OrganizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JobGraphQLResolver implements GraphQLResolver<Job> {

    @Autowired
    private OrganizationDao organizationDao;

    public Organization organization(Job job) {
        if (job == null) {
            return null;
        }
        Optional<Organization> optionalOrganization = organizationDao.findById(job.getOrganization().getId());
        return optionalOrganization.get();
    }


}
