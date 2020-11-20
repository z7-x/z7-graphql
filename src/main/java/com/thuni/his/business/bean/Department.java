package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.DepartmentDeserializer;
import com.thuni.his.business.bean.databind.DepartmentSerializer;
import com.thuni.his.business.bean.databind.OrgSerializer;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 部门表
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_DEPARTMENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "children", "employees", "positions", "roles", "links", "grants"})
public class Department extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 简写
     */
    @Column(name = "sn", length = 10)
    private String sn;
    /**
     * 名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 路径
     */
    @Column(name = "PATH", length = 50)
    private String path;
    /**
     * 排序字段
     */
    @Column(name = "SORT")
    private Integer sort;
    /**
     * 描述信息
     */
    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY) // 懒加载
    @Column(name = "DESCRIPTION", length = 150)
    private String description;
    /**
     * 是否启用 0禁用 1 启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;
    /**
     * 部门类型
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPE", foreignKey = @ForeignKey(name = "FK_ORG_DEPARTMENT_TID"))
    private DepartmentType type;
    /**
     * 上级部门
     */
    @JsonSerialize(using = DepartmentSerializer.class)
    @JsonDeserialize(using = DepartmentDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PID", foreignKey = @ForeignKey(name = "FK_AUTH_DEPARTMENT_PID"))
    private Department parent;
    /**
     * 下属部门
     */
    @JsonInclude(content = JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("sort ASC")
    private List<Department> children;
    /**
     * 组织机构
     */
    @JsonSerialize(using = OrgSerializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_DEPARTMENT_ORGANIZATION"), updatable = false, nullable = false)
    private Organization organization;
    /**
     * 部门拥有的角色
     */
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinTable(name = "AUTH_ROLE_DEPARTMENT",
            joinColumns = @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "FK_AUTH_ROLE_DEPARTMENT_DID")),
            inverseJoinColumns = @JoinColumn(name = "ROLE_CODE"), foreignKey = @ForeignKey(name = "FK_ROLE_DEPARTMENT_RID"))
    private List<Role> roles;

    /**
     * 链接到的账户
     */
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "department",cascade = {CascadeType.REMOVE})
    private List<DepartmentLink> links;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<DepartmentAttribute> attributes;

    /**
     * 部门人员更改记录
     */
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department",cascade = CascadeType.REMOVE)
    private List<DepartmentChangeRecord> records;

    /**
     * 组织人员
     */
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department", cascade = {CascadeType.REMOVE})
    private List<OrganizationEmployee> organizationEmployees;

    /**
     * 本部门成员
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<EmployeePosition> employees;
    /**
     * 对应的岗位
     */
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "department",cascade = {CascadeType.REMOVE})
    private List<Position> positions;

}