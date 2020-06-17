package com.thuni.his.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 地址表
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SYS_ADDRESS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address extends BaseBusEntity {

    /**
     * 主键编号
     */
    @Id
    @Column(name = "id",nullable=false,unique=true)
    @GeneratedValue(generator = "fantasy-sequence")
    @GenericGenerator(name = "fantasy-sequence", strategy = "fantasy-sequence")
    private Long id;
    /**
     * 国家
     */
    @Column(name = "COUNTRY", length = 30)
    private String country;
    /**
     * 省
     */
    @Column(name = "PROVINCE", length = 30)
    private String province;
    /**
     * 城市
     */
    @Column(name = "CITY", length = 30)
    private String city;
    /**
     * 区
     */
    @Column(name = "DISTRICT", length = 30)
    private String district;
    /**
     * 街道
     */
    @Column(name = "STREET", length = 30)
    private String street;
    /**
     * 邮编
     */
    @Column(name = "POSTAL_CODE", length = 10)
    private String postalCode;

}
