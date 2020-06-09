package com.thuni.his.demo.service;

import com.thuni.his.demo.bean.People;
import com.thuni.his.demo.dao.PeopleDao;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.dao.jpa.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


@Service
@Transactional(rollbackFor = Exception.class)
public class PeopleService {
//    ConcurrentHashMap concurrentHashMap =  new ConcurrentHashMap();
//
//        concurrentHashMap.clear();

    @Autowired
   private PeopleDao peopleDao;

   public People addPeople(People people){
       return peopleDao.save(people);
   }

   public People updatePeople(Long id,People people,Boolean merge){
       people.setId(id);
       return peopleDao.update(people,merge);
   }

   public Boolean deletePeople(Long id){
       peopleDao.deleteById(id);
       return true;
   }

   public Optional<People> findPeopleById(Long id){
       Optional<People> people = peopleDao.findById(id);
       return people;
   }

    public List<People> findPeople(){
        List<People> peopleList = peopleDao.findAll();
        return peopleList;
    }

    public Pager<People> findPage(Pager<People> pager, List<PropertyFilter> filters) {
        return peopleDao.findPager(pager, filters);
    }
}
