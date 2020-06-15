package com.thuni.his.business.graphql.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jfantasy.graphql.inputs.QueryFilter;

public class RoleScopeFilter extends QueryFilter {

    @JsonProperty("name")
    public void setName(String name){
        builder.contains("name",name);
    }

    @JsonProperty("enabled")
    public void setName(Boolean enabled){
        builder.equal("enabled",enabled);
    }
}
