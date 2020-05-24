package com.thuni.his.demo.graphql.inputs;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jfantasy.graphql.inputs.QueryFilter;

//注意，这里只需要跟java的实体层对应上就行了
public class PeopleFilter extends QueryFilter {

    /**
     * 根据名称模糊
     * @param name 姓名
     */
    @JsonProperty("name")
    public void setName(String name) {
        builder.contains("name", name);
    }

    /**
     * @param sex 性别
     */
    @JsonProperty("sex")
    public void setSex(String sex) {
        builder.contains("sex", sex);
    }

    /**
     * @param birthday 出生日期
     */
    @JsonProperty("birthday")
    public void setBirthday(String birthday) {
        builder.contains("birthday", birthday);
    }

    /**
     * @param phone 电话
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        builder.contains("address.phone", phone);
    }

    /**
     * @param address 地址
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        builder.contains("address.address", address);
    }
}
