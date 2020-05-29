package com.thuni.his.demo.bean.correlationmapping;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 商品类 Product -->书籍 Book
 * -->衣服 Cloth
 * 三个个类主要 学习 "继承关系"
 */
@Data
@Entity //数据持久化
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ts_product")
//默认使用SINGLE_TABLE策略生成表,一张表维护所有的父类和子类的数据
//在表中添加一个鉴别器列,用来区分数据的类型
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//TABLE_PER_CLASS每个实体都生成一张表，需要修改主键生成策略
@DiscriminatorColumn(name="type")//鉴别器的列字段
@DiscriminatorValue("1")//鉴别器的值
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
