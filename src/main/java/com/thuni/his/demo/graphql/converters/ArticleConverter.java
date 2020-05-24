package com.thuni.his.demo.graphql.converters;

import com.thuni.his.demo.bean.Article;
import com.thuni.his.demo.graphql.inputs.ArticleBatchInput;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ArticleConverter {
    ArticleConverter INSTANCE = Mappers.getMapper(ArticleConverter.class);

    /**
     * source:输入参数   target：返回参数
     * @param articleBatchInput
     * @return
     */
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content")
    })
    Article toArticle(ArticleBatchInput articleBatchInput);
}
