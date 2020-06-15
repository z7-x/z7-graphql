package com.thuni.his.business.graphql.types;

import com.thuni.his.business.bean.RoleScope;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.graphql.Edge;
import org.jfantasy.graphql.types.BaseConnection;

import java.util.List;

@Data
public class RoleScopeConnection extends BaseConnection<RoleScopeConnection.RoleScopeEdge> {
    private List<RoleScopeEdge> edges;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RoleScopeEdge implements Edge<RoleScope> {
        private String cursor;
        private RoleScope node;
    }
}
