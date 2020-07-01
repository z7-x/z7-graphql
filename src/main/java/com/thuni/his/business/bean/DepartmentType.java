package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 部门类型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_DEPARTMENT_TYPE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DepartmentType {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 组织
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JsonBackReference
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORG_DEPARTMENT_TYPE_OID"))
    private Organization organization;
    /**
     * 编码
     */
    @Column(name = "CODE",length = 20)
    private String code;

    /**
     * 多部门
     */
    @Column(name = "MULTI_SECTORAL")
    private Boolean multiSectoral;

    /**
     * 最大兼岗人数
     */
    @Column(name = "AND_POST")
    private Long andPost;
}
