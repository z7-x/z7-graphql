package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.thuni.his.business.bean.Organization;

import java.io.IOException;

public class OrgSerializer extends JsonSerializer<Organization> {
    @Override
    public void serialize(Organization organization, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString((SerializableString) (organization.getId() != null ? organization.getId() : ""));
    }
}