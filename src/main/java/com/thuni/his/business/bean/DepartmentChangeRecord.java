package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.business.bean.enums.InOrOutStatus;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * @Description 部门更换记录表
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_DEPARTMENT_CHANGE_RECORD")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class DepartmentChangeRecord extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID",foreignKey = @ForeignKey(name = "FK_ORG_DEPARTMENT_CHANGE_RECORD_DEPARTMENT_ID"))
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID",foreignKey = @ForeignKey(name = "FK_ORG_DEPARTMENT_CHANGE_RECORD_EMPLOYEE_ID"))
    private Employee employee;

    @Column(name = "year")
    private String year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID",foreignKey = @ForeignKey(name = "FK_ORG_DEPARTMENT_CHANGE_RECORD_ORGANIZATION_ID"))
    private Organization organization;

    @Column(name = "STATUS",length = 20)
    private InOrOutStatus status;
}
