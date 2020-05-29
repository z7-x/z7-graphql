package com.thuni.his.demo.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.demo.bean.Author;
import org.jfantasy.framework.util.common.StringUtil;

import java.io.IOException;

/**
 * 转JSON处理
 */
public class AuthorDeserializer extends JsonDeserializer<Author> {

    @Override
    public Author deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (StringUtil.isBlank(jp.getValueAsString())) {
            return null;
        }
        return Author.builder().id(jp.getValueAsLong()).build();
    }

}