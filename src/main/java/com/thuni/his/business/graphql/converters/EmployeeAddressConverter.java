package com.thuni.his.business.graphql.converters;

import com.thuni.his.business.bean.EmployeeAddress;
import com.thuni.his.business.graphql.inputs.EmployeeAddressInput;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EmployeeAddressConverter {
    EmployeeAddressConverter INSTANCE = Mappers.getMapper(EmployeeAddressConverter.class);

    /**
     *
     * source:输入参数   target：返回参数
     * @param input
     * @return
     */
    @Mappings({
            @Mapping(source = "label", target = "label"),
            @Mapping(source = "primary", target = "primary"),
            @Mapping(source = "addressesId", target = "address.id"),
            @Mapping(source = "employeeId", target = "employee.id")
    })
    EmployeeAddress toEmployeeAddress(EmployeeAddressInput input);
}
