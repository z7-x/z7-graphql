package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.system.bean.Email;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * @Description: 员工Email
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_EMAIL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employee"})
public class EmployeeEmail extends BaseBusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id")
    private Long id;

    @Column(name = "IS_PRIMARY", nullable = false)
    private Boolean primary;

    @Column(name = "LABEL", length = 30)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMAIL_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_EMAIL_VID"), nullable = false, updatable = false)
    private Email email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "ORG_EMPLOYEE_EMAIL_EID"), nullable = false, updatable = false)
    private Employee employee;

}
