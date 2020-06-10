package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.DepartmentDeserializer;
import com.thuni.his.business.bean.databind.DepartmentSerializer;
import com.thuni.his.business.bean.databind.PositionDeserializer;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 员工职位
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_POSITION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeePosition extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 是否为主部门
     */
    @Column(name = "IS_PRIMARY")
    private Boolean primary;
    /**
     * 员工
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_POSITION_EID"), nullable = false, updatable = false)
    private Employee employee;
    /**
     * 员工所在部门的职位
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = PositionDeserializer.class)
    @JoinColumn(name = "POSITION_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_POSITION_PID"))
    private Position position;
    /**
     * 所在部门
     */
    @JsonSerialize(using = DepartmentSerializer.class)
    @JsonDeserialize(using = DepartmentDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_POSITION_DID"), nullable = false)
    private Department department;
    /**
     * 所属组织
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_EMPLOYEE_POSITION_OID"), updatable = false, nullable = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATIONEMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_TID"), updatable = false, nullable = false)
    private OrganizationEmployee status;
}
