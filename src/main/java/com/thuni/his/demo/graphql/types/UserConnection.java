package com.thuni.his.demo.graphql.types;

import com.thuni.his.demo.bean.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.graphql.Connection;
import org.jfantasy.graphql.Edge;
import org.jfantasy.graphql.PageInfo;
import org.jfantasy.graphql.Pagination;

import java.util.List;

@Data
public class UserConnection implements Connection<UserConnection.UserEdge>, Pagination {

    private Integer totalCount;
    private Integer pageSize;
    private Integer totalPage;
    private Integer currentPage;
    private PageInfo pageInfo;
    private List<UserEdge> edges;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserEdge implements Edge<User> {
        private String cursor;
        private User node;
    }
}
