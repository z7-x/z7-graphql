package com.thuni.his.business.service;

import com.thuni.his.business.bean.Job;
import com.thuni.his.business.dao.JobDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class JobService {
    @Autowired
    private JobDao jobDao;

    public Job addMJob(Job job){
        if(job == null){
            return null;
        }
        return jobDao.save(job);
    }
}
