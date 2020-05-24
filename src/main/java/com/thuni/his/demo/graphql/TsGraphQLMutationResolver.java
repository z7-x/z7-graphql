package com.thuni.his.demo.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.demo.bean.Article;
import com.thuni.his.demo.bean.Author;
import com.thuni.his.demo.bean.People;
import com.thuni.his.demo.graphql.converters.ArticleConverter;
import com.thuni.his.demo.graphql.converters.AuthorConverter;
import com.thuni.his.demo.graphql.inputs.ArticleBatchInput;
import com.thuni.his.demo.graphql.inputs.AuthorBatchInput;
import com.thuni.his.demo.service.ArticleService;
import com.thuni.his.demo.service.AuthorService;
import com.thuni.his.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TsGraphQLMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PeopleService peopleService;
    @Autowired
    public AuthorService authorService;
    @Autowired
    public ArticleService articleService;
    @Autowired
    private AuthorConverter authorConverter;
    @Autowired
    private ArticleConverter articleConverter;

    public People createMicroservicePeople(People people) {
        return peopleService.addPeople(people);
    }

    public People updateMicroservicePeople(Long id, People people, Boolean merge) {
        return peopleService.updatePeople(id, people, merge);
    }

    public Boolean deleteMicroservicePeople(Long id) {
        return peopleService.deletePeople(id);
    }

    public Author createMicroserviceAuthor(Author author) {
        return authorService.addAuthor(author);
    }

    public Author updateMicroserviceAuthor(Long id, Boolean merge, AuthorBatchInput input) {
        Author author = authorConverter.toAuthor(input);
        return authorService.updateAuthor(id, merge, author);
    }

    public Boolean deleteMicroserviceAuthor(Long id) {
        return authorService.deleteAuthor(id);
    }

    /**
     * 功能：新增文章的同时指定作者
     * @param article
     * @return
     */
    public Article createMicroserviceArticle(Article article) {
        return articleService.addArticle(article);
    }

    /**
     * 功能：更新文章
     * @param id
     * @param merge
     * @param input
     * @return
     */
    public Article updateMicroserviceArticle(Long id, Boolean merge, ArticleBatchInput input) {
        input.setId(id);
        Article article = articleConverter.toArticle(input);
        return articleService.updateArticle(article,merge);
    }
}
