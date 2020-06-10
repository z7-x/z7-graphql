package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.DepartmentDeserializer;
import com.thuni.his.business.bean.databind.DepartmentSerializer;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 部门属性表
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_DEPARTMENT_ATTRIBUTE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "children", "employees", "positions", "roles", "links", "grants"})
public class DepartmentAttribute extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 部门
     */
    @JsonSerialize(using = DepartmentSerializer.class)
    @JsonDeserialize(using = DepartmentDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "FK_AUTH_DEPARTMENT_ATTRIBUTE_ID"),nullable = false, updatable = false)
    private Department department;

    /**
     * 属性名称
     */
    @Column(name = "attribute_name", length = 50)
    private String attributeName;
    /**
     * 属性值
     */
    @Column(name = "attribute_value", length = 50)
    private String attributeValue;
    /**
     * 描述信息
     */
    @Column(name = "DESCRIPTION", length = 150)
    private String description;
}