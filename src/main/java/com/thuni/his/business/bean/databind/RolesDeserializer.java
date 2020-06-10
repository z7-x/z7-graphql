package com.thuni.his.business.bean.databind;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.Role;
import org.jfantasy.framework.util.common.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RolesDeserializer extends JsonDeserializer<List<Role>> {

    @Override
    public List<Role> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if(jp.isExpectedStartArrayToken()){
            List<Role> roles = new ArrayList<>();
            String value = jp.nextTextValue();
            do {
                if (StringUtil.isNotBlank(value)) {
                    roles.add(Role.builder().coding(value).build());
                }
                value = jp.nextTextValue();
            }while (StringUtil.isNotBlank(value));
            return roles;
        }
        return null;

    }

}
