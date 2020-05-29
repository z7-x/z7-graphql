package com.thuni.his.demo.bean.correlationmapping;

import lombok.Data;

import javax.persistence.*;


@Data
@Embeddable //表示当前对象是可植入的，作为其他对象的组件存在
public class CompanyAddress {
    private String province;//省
    private String city;//市
    private String street;//街道
}
