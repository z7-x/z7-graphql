package com.thuni.his.demo.service;

import com.thuni.his.demo.bean.Article;
import com.thuni.his.demo.bean.Author;
import com.thuni.his.demo.dao.ArticleDao;
import com.thuni.his.demo.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private ArticleDao articleDao;

    public Author addAuthor(Author author) {
        Author save = authorDao.save(author);
        if (!CollectionUtils.isEmpty(save.getArticleList())) {
            List<Article> articleList = save.getArticleList();
            List<Article> articles = new ArrayList<>();
            articles.addAll(articleList);
            articles.stream().forEach(article -> {
                article.setAuthor(save);
                articleDao.save(article);
            });
        }
        return save;
    }

    public Author updateAuthor(Long id, Boolean merge, Author author) {
        author.setId(id);
        return authorDao.update(author, merge);
    }

    public Boolean deleteAuthor(Long id) {
        authorDao.deleteById(id);
        return true;
    }


}
