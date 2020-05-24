package com.thuni.his.demo.graphql.converters;

import com.thuni.his.demo.bean.Author;
import com.thuni.his.demo.graphql.inputs.AuthorBatchInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorConverter {
    AuthorConverter INSTANCE = Mappers.getMapper(AuthorConverter.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    Author toAuthor(AuthorBatchInput input);
}
