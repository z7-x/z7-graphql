package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thuni.his.business.bean.databind.EmployeeDeserializer;
import com.thuni.his.business.bean.databind.OrgDeserializer;
import com.thuni.his.business.bean.databind.OrganizationEmployeeStatusDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;

/**
 *  组织人员
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORG_ORGANIZATION_EMPLOYEE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrganizationEmployee extends BaseBusEntity {
    /**
     * ID
     */
    @Id
    @Column(name = "ID",length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = OrgDeserializer.class)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_OID"), updatable = false, nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = EmployeeDeserializer.class)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_EID"), nullable = false, updatable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = OrganizationEmployeeStatusDeserializer.class)
    @JoinColumn(name = "STATUS_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_SID"), nullable = false)
    private OrganizationEmployeeStatus status;

    /**
     * 主部门
     */
    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID",foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_DEPARTMENT_ID"),nullable = false)
    private Department department;

    /**
     * 主职务
     */
    @OneToOne
    @JoinColumn(name = "POSITION_ID",foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_POSITION_ID"),nullable = false)
    private Position position;

    /**
     * 岗位
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status", cascade = CascadeType.REMOVE)
    private List <EmployeePosition> positions;
}
