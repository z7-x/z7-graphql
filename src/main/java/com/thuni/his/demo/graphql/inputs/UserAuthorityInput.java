package com.thuni.his.demo.graphql.inputs;

import com.thuni.his.demo.bean.Authority;
import lombok.Data;

import java.util.List;

@Data
public class UserAuthorityInput {
    private String username;
    private String password;
    private List<Authority> authorityList;
}
