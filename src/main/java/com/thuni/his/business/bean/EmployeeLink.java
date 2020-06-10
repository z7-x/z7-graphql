package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thuni.his.business.bean.databind.PositionDeserializer;
import com.thuni.his.business.bean.enums.LinkType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 用户链接
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_EMPLOYEE_LINK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeLink extends BaseBusEntity {
    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = PositionDeserializer.class)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_EMPLOYEE_LINK_EID"))
    private Employee employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 10)
    private LinkType type;

    @Column(name = "LINK_ID", length = 32)
    private String linkId;

}
