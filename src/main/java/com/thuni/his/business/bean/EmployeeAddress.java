package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.system.bean.Address;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 地址信息
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_ADDRESS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employee"})
public class EmployeeAddress extends BaseBusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id")
    private Long id;

    @Column(name = "IS_PRIMARY", nullable = false)
    private Boolean primary;

    @Column(name = "LABEL", length = 30)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_ADDRESS_VID"), nullable = false, updatable = false)
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_ADDRESS_EID"), nullable = false, updatable = false)
    private Employee employee;
}
