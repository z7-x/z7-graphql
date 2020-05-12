package com.thuni.his.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ts_address")
public class Address  extends BaseBusEntity {

    /**
     * 主键编号
     */
    @Id
    @Column(name = "id",nullable=false,unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 住宅电话
     */
    @Column(name = "phone", nullable = true, length = 11)
    private String phone;

    /**
     * 邮政编码
     */
    @Column(name = "zipcode", nullable = true, length = 6)
    private String zipcode;

    /**
     * 地址
     */
    @Column(name = "address", nullable = true, length = 100)
    private String address;
}
