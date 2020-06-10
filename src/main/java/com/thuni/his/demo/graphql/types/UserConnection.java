package com.thuni.his.demo.graphql.types;

import com.thuni.his.demo.bean.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.graphql.Edge;
import org.jfantasy.graphql.types.BaseConnection;

import java.util.List;

@Data
public class UserConnection extends BaseConnection<UserConnection.UserEdge> {
    private List<UserEdge> edges;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserEdge implements Edge<Users> {
        private String cursor;
        private Users node;
    }
}
