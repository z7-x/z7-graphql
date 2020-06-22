package com.thuni.his.business.graphql.inputs;
import lombok.Data;

import java.util.List;

@Data
public class RolesInput {
    private Long id;
    private String name;
    private String coding;
    private Long scope;
    private Long organization;
    private Boolean enabled;
    private String description;
    private List<Long> users;
}
