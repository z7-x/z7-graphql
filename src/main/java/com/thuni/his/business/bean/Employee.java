package com.thuni.his.business.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.business.bean.enums.Sex;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;
import org.jfantasy.framework.dao.hibernate.converter.StringArrayConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 员工表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "ORG_EMPLOYEE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","employee"})
public class Employee extends BaseBusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "ID")
    private Long id;
    /**
     * 状态
     */
    @Transient
    private String status;
    /**
     * 工号
     */
    @Column(name = "SN", nullable = false, precision = 20)
    private String jobNumber;
    /**
     * 用户标签，用于筛选用户
     */
    @Column(name = "TAGS", precision = 300)
    @Convert(converter = StringArrayConverter.class)
    private String[] tags;
    /**
     * 名称
     */
    @Column(name = "NAME", length = 30)
    private String name;
    /**
     * 生日
     */
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    /**
     * 性别
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "SEX", length = 10)
    private Sex sex;
    /**
     * 移动电话
     */
    @Column(name = "MOBILE", length = 20)
    private String mobile;
    /**
     * 固定电话
     */
    @Column(name = "TEL", length = 20)
    private String tel;
    /**
     * E-mail
     */
    @Column(name = "EMAIL", length = 50)
    private String email;

    /**
     * 地址列表
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<EmployeeAddress> addresses;

    /**
     * 邮箱列表
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<EmployeeEmail> emails;

    /**
     * 电话列表
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<EmployeePhone> phones;

    /**
     * 职位
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<EmployeePosition> employeePositions;

    /**
     * 链接到的账户
     */
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private List<EmployeeLink> links;

    /**
     * 管理用户
     */
    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private User user;
}
