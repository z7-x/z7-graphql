package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.RoleScope;
import org.jfantasy.framework.util.common.StringUtil;

import java.io.IOException;

public class RoleScopeDeserializer extends JsonDeserializer<RoleScope> {
    @Override
    public RoleScope deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (StringUtil.isBlank(p.getValueAsString())) {
            return null;
        }
        return RoleScope.builder().id(p.getValueAsLong()).build();
    }
}
