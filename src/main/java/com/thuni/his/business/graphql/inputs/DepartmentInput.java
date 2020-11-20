package com.thuni.his.business.graphql.inputs;

import lombok.Data;

import java.util.List;


@Data
public class DepartmentInput{
    private List<Long> longs;
    private String organization;
    private Long type;
}
