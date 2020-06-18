package com.thuni.his.business.service;

import com.thuni.his.business.bean.Position;
import com.thuni.his.business.dao.PositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;

@Service
@Transactional
public class PositionService {
    @Autowired
    private PositionDao positionDao;

    public Position addMPosition(Position position){
        if(StringUtils.isEmpty(position)){
            return null;
        }
        return positionDao.save(position);
    }
}
