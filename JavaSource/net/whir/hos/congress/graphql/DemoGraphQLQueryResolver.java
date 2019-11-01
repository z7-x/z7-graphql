package net.whir.hos.congress.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class DemoGraphQLQueryResolver implements GraphQLQueryResolver {

    public String version() {
        return "1.1.1";
    }

}
