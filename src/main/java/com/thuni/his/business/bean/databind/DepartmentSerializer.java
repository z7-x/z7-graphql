package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.thuni.his.business.bean.Department;

import java.io.IOException;

public class DepartmentSerializer extends JsonSerializer<Department> {

    @Override
    public void serialize(Department department, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        if (department.getId() != null) {
            jgen.writeNull();
        } else {
            jgen.writeNumber(department.getId());
        }

    }
}