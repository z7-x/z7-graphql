package com.thuni.his.demo.graphql.types;

import com.thuni.his.demo.bean.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.graphql.Edge;
import org.jfantasy.graphql.PageInfo;
import org.jfantasy.graphql.types.BaseConnection;

import java.util.List;

@Data
//extends BaseConnection<PeopleConnection.PeopleEdge>
//implements Connection<PeopleConnection.PeopleEdge>, Pagination
public class PeopleConnection extends BaseConnection<PeopleConnection.PeopleEdge> {

    private Integer totalCount;
    private Integer pageSize;
    private Integer totalPage;
    private Integer currentPage;
    private PageInfo pageInfo;
    private List<PeopleConnection.PeopleEdge> edges;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PeopleEdge implements Edge<People> {
        private String cursor;
        private People node;
    }
}
