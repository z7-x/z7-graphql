package com.thuni.his.business.graphql.converters;

import com.thuni.his.business.bean.EmployeeEmail;
import com.thuni.his.business.graphql.inputs.EmployeeEmailInput;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeEmailConverter {
    EmployeeEmailConverter INSTANCE = Mappers.getMapper(EmployeeEmailConverter.class);

    EmployeeEmail toEmployeeAddress(EmployeeEmailInput input);
}
