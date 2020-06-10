package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.thuni.his.business.bean.Permission;

import java.io.IOException;

public class PermissionSerializer extends JsonSerializer<Permission> {

    @Override
    public void serialize(Permission value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(String.valueOf(new Long(value.getId())));
    }
}
