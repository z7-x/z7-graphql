package com.thuni.his.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ts_people")
public class People  extends BaseBusEntity {
    /**
     * 主键编号
     */
    @Id
    @Column(name = "id",nullable=false,unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 地址
     * optional = false指明 Address 不可为空
     * people 中的 address_id 字段参考 address 表中的id字段,referencedColumnName="id" 实际可以省略
     */
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "addressId",referencedColumnName="id",unique = true)
    private Addresss address;
}
