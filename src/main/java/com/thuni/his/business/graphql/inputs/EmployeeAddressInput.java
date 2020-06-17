package com.thuni.his.business.graphql.inputs;

import lombok.Data;

@Data
public class EmployeeAddressInput {
    private String label;
    private Boolean primary;
    private Long addressesId;
    private Long employeeId;
}
