package com.thuni.his.business.graphql.inputs;

import com.thuni.his.business.bean.User;

import lombok.Data;

import java.util.List;

@Data
public class UserInput extends User {
    private Long employeeId;
    private Long organizationId;
    private List<Long> roleIds;
}
