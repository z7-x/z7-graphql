package com.thuni.his.demo.dao;

import com.thuni.his.demo.bean.Author;
import org.jfantasy.framework.dao.jpa.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author,Long> {
}
