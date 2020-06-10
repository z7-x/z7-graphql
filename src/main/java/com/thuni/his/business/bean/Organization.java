package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.OrgDeserializer;
import com.thuni.his.business.bean.databind.OrgSerializer;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 组织机构
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ORG_ORGANIZATION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "children", "employees"})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Organization extends BaseBusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "ID")
    private Long id;
    /**
     * 机构简写
     */
    @Column(name = "LOGOGRAM", length = 10)
    private String logoGram;
    /**
     * 机构名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 排序字段
     */
    @Column(name = "SORT")
    private Integer sort;
    /**
     * 机构描述信息
     */
    @Column(name = "DESCRIPTION", length = 150)
    private String description;
    /**
     * 上级机构
     */
    @JsonProperty("parent_id")
    @JsonSerialize(using = OrgSerializer.class)
    @JsonDeserialize(using = OrgDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "PID", foreignKey = @ForeignKey(name = "FK_AUTH_ORGANIZATION_PID"))
    private Organization parent;
    /**
     * 下属机构
     */
    @JsonInclude(content = JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @OrderBy("sort ASC")
    private List<Organization> children;
    /**
     * 部门类型
     */

    @JsonManagedReference
    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<DepartmentType> departmentTypes;
    /**
     * 用户组范围
     */
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<EmployeeGroupScope> employeeGroupScopes;

    /**
     * 是否支持多部门
     */
    @Column(name = "MULTI_SECTORAL")
    private Boolean multiSectoral;

    /**
     * 支持最多部门数
     */
    @Column(name = "MULTI_SECTORAL_NUMBER")
    private Long multiSectoralNumber;
}
