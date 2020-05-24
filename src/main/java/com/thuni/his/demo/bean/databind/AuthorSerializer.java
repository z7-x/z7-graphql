package com.thuni.his.demo.bean.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.thuni.his.demo.bean.Author;

import java.io.IOException;

/**
 * @author limaofeng
 */
public class AuthorSerializer extends JsonSerializer<Author> {

    @Override
    public void serialize(Author department, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (department.getId() != null) {
            jgen.writeNull();
        } else {
            jgen.writeNumber(department.getId());
        }

    }
}