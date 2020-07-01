package com.thuni.his.business.graphql.inputs;

import com.thuni.his.business.bean.Department;
import lombok.Data;

import java.util.List;


@Data
public class DepartmentInput extends Department {
    private List<Long> longs;
}
