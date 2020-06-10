package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 用户组
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_GROUP")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeGroup extends BaseBusEntity {

    private static final long serialVersionUID = 7898475330929818969L;

    @Id
    @Column(name = "ID", nullable = false, precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户组名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 是否启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;
    /**
     * 描述
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 使用范围
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCOPE", foreignKey = @ForeignKey(name = "FK_EMPLOYEE_GROUP_SCOPEID"), updatable = false, nullable = false)
    private EmployeeGroupScope scope;
    /**
     * 群组成员
     */
    @ManyToMany(targetEntity = Employee.class, fetch = FetchType.LAZY)
    @JoinTable(name = "ORG_EMPLOYEE_GROUP_EMPLOYEE", joinColumns = @JoinColumn(name = "GROUP_ID"), inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"), foreignKey = @ForeignKey(name = "FK_EMPLOYEE_GROUP_GID"))
    private List<Employee> employees;
}