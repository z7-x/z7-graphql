package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 职务
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORG_JOB")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Job extends BaseBusEntity {

    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 职务名称
     */
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    /**
     * 职务描述信息
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 职务所属组织
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORG_JOB_OID"), updatable = false, nullable = false)
    private Organization organization;
}
