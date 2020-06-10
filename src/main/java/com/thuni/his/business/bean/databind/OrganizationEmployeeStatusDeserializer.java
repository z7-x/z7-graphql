package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.OrganizationEmployeeStatus;

import java.io.IOException;

public class OrganizationEmployeeStatusDeserializer extends JsonDeserializer<OrganizationEmployeeStatus> {
    @Override
    public OrganizationEmployeeStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return OrganizationEmployeeStatus.builder().code(p.getValueAsString()).build();
    }
}
