package com.thuni.his.demo.service;

import com.thuni.his.demo.bean.Article;
import com.thuni.his.demo.bean.Author;
import com.thuni.his.demo.dao.ArticleDao;
import com.thuni.his.demo.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private AuthorDao authorDao;

    public Article addArticle(Article article){
        Article save= articleDao.save(article);
        if(!StringUtils.isEmpty(save.getAuthor().getId())){
            Author one = authorDao.getOne(save.getAuthor().getId());
            save.setAuthor(one);
        }
        return save;
    }

    public Article updateArticle(Article article,boolean merge){
        Article update = articleDao.update(article, merge);
        return update;
    }

}
