package com.thuni.his.demo.graphql.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.jfantasy.graphql.inputs.QueryFilter;

@Data
public class UserFilter extends QueryFilter {

    //username_contains为graphql配置文件里面的入参
    @JsonProperty("username_contains")
    public void setUsernameContains(String value) {
        builder.contains("username", value);
    }

}
