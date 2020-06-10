package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.Organization;
import org.jfantasy.framework.util.common.StringUtil;

import java.io.IOException;

public class OrgDeserializer extends JsonDeserializer<Organization> {

    @Override
    public Organization deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (StringUtil.isBlank(jp.getValueAsString())) {
            return null;
        }
        return Organization.builder().id(new Long(jp.getValueAsString())).build();
    }

}