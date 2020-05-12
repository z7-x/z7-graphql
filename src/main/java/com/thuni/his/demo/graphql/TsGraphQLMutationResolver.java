package com.thuni.his.demo.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.thuni.his.demo.bean.People;
import com.thuni.his.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TsGraphQLMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PeopleService peopleService;

    public People addMicroservicePeople(People people) {
        return peopleService.addPeople(people);
    }

    public People updateMicroservicePeople(Long id,People people,Boolean merge){
        return peopleService.updatePeople(id,people,merge);
    }

    public Boolean deleteMicroservicePeople(Long id){
        return peopleService.deletePeople(id);
    }


}
