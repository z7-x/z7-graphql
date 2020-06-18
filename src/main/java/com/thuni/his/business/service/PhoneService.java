package com.thuni.his.business.service;


import com.thuni.his.system.bean.Phone;
import com.thuni.his.system.dao.PhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PhoneService {
    @Autowired
    private PhoneDao phoneDao;

    public Phone addMPhone(Phone phone){
        return phoneDao.save(phone);
    }
}
