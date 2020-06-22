package com.thuni.his.business.graphql.types;

import com.thuni.his.business.bean.RoleScope;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.graphql.Edge;
import org.jfantasy.graphql.PageInfo;
import org.jfantasy.graphql.types.BaseConnection;

import java.util.List;

@Data
/**
 * 使用 extends BaseConnection<PeopleConnection.PeopleEdge> 或者
 * implements Connection<PeopleConnection.PeopleEdge>, Pagination  均可
 */
public class RoleScopeConnection extends BaseConnection<RoleScopeConnection.RoleScopeEdge> {
    private Integer totalCount;
    private Integer pageSize;
    private Integer totalPage;
    private Integer currentPage;
    private PageInfo pageInfo;
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
