package com.thuni.his.demo.graphql.inputs;

import lombok.Data;

@Data
public class ArticleBatchInput{
    private Long id;
    private String title;
    private String content;
}
