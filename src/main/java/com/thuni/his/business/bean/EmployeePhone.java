package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.system.bean.Phone;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 员工电话表
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_PHONE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employeePositions", "links"})
public class EmployeePhone extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IS_PRIMARY", nullable = false)
    private Boolean primary;

    @Column(name = "LABEL", length = 30)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PHONE_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_PHONE_VID"), nullable = false, updatable = false)
    private Phone phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_PHONE_EID"), nullable = false, updatable = false)
    private Employee employee;
}
