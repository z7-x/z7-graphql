package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.Department;
import org.jfantasy.framework.util.common.StringUtil;

import java.io.IOException;

public class DepartmentDeserializer extends JsonDeserializer<Department> {

    @Override
    public Department deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (StringUtil.isBlank(jp.getValueAsString())) {
            return null;
        }
        return Department.builder().id(jp.getValueAsLong()).build();
    }

}