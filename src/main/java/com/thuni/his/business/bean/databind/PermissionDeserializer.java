package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.Permission;

import java.io.IOException;


public class PermissionDeserializer  extends JsonDeserializer<Permission> {
    @Override
    public Permission deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = jp.getValueAsString();
        if (value == null) {
            return null;
        }
        return Permission.builder().id(new Long(value)).build();
    }
}