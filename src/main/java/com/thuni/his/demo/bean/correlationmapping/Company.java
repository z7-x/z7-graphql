package com.thuni.his.demo.bean.correlationmapping;


import lombok.*;

import javax.persistence.*;

/**
 * Company 与 CompanyAddress 两个类主要 学习 "组件关系"
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ts_company")
public class Company {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    //公司地址
    private CompanyAddress companyAddress;

    //注册地址
    @AttributeOverrides({
            @AttributeOverride(name = "province",column = @Column(name = "reg_province")),
            @AttributeOverride(name = "city",column = @Column(name = "reg_city")),
            @AttributeOverride(name = "street",column = @Column(name = "reg_street"))
    })
    private CompanyAddress regCompanyAddress;
}
