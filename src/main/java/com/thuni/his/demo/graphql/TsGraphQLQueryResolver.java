package com.thuni.his.demo.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.thuni.his.demo.bean.People;

import com.thuni.his.demo.graphql.inputs.PeopleFilter;
import com.thuni.his.demo.graphql.types.PeopleConnection;
import com.thuni.his.demo.service.PeopleService;
import org.jfantasy.framework.dao.OrderBy;
import org.jfantasy.framework.dao.Pager;
import org.jfantasy.framework.dao.jpa.PropertyFilterBuilder;
import org.jfantasy.framework.util.common.ObjectUtil;
import org.jfantasy.graphql.util.Kit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class TsGraphQLQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PeopleService peopleService;


    /**
     * 根据id查询
     * @param id 传入员工id
     * @return
     */
    public Optional<People> findMicroservicePeopleById(Long id){
        return peopleService.findPeopleById(id);
    }

    /**
     * 查询所有
     * @return
     */
    public List<People> findMicroservicePeople(){
        return peopleService.findPeople();
    }

    /**
     * 模糊查询
     * @param filter 过滤条件
     * @param page  页数
     * @param pageSize 每页显示数
     * @param orderBy
     * @return 返回查询列表
     */
    public PeopleConnection dimFindMicroservicePeople(PeopleFilter filter, int page, int pageSize, OrderBy orderBy){
        PropertyFilterBuilder builder = ObjectUtil.defaultValue(filter, new PeopleFilter()).getBuilder();
        return Kit.connection(peopleService.findPage(new Pager<>(page, pageSize, orderBy), builder.build()), PeopleConnection.class);
    }

}
