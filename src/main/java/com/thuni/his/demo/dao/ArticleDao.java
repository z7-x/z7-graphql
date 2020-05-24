package com.thuni.his.demo.dao;

import com.thuni.his.demo.bean.Article;
import org.jfantasy.framework.dao.jpa.JpaRepository;

public interface ArticleDao extends JpaRepository<Article,Long> {
}
