package com.thuni.his.business.service;

import com.thuni.his.system.bean.Email;
import com.thuni.his.system.dao.EmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EmailService {

    @Autowired
    private EmailDao emailDao;

    public Email addAndModify(Email email){
        return emailDao.save(email);
    }

    public Boolean removeEmail(Long id){
        Optional<Email> byId = emailDao.findById(id);
        if(byId.isPresent()){
            emailDao.delete(byId.get());
            return true;
        }
        return false;
    }
}
