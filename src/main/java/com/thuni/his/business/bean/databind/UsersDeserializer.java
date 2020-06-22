package com.thuni.his.business.bean.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thuni.his.business.bean.User;
import org.jfantasy.framework.util.common.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersDeserializer extends JsonDeserializer<List<User>> {

    @Override
    public List<User> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (jp.isExpectedStartArrayToken()) {
            List<User> users = new ArrayList<>();
            String value = jp.nextTextValue();
            Long vLong =Long.parseLong(value);
            do {
                if (StringUtil.isNotBlank(value)) {
                    users.add(User.builder().id(vLong).build());
                }
                value = jp.nextTextValue();
            } while (StringUtil.isNotBlank(value));
            return users;
        }
        return null;
    }
}
