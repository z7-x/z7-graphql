package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 职位
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORG_POSITION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Position extends BaseBusEntity {
    /**
     * 职位编码
     */
    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 职位名称
     */
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    /**
     * 职位描述信息
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 对应的职务
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID", foreignKey = @ForeignKey(name = "FK_POSITION_JID"))
    private Job job;
    /**
     * 职位拥有的角色
     */
    @JsonIgnore
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinTable(name = "AUTH_ROLE_POSITION", joinColumns = @JoinColumn(name = "POSITION_ID", foreignKey = @ForeignKey(name = "FK_AUTH_ROLE_POSITION_PID")), inverseJoinColumns = @JoinColumn(name = "ROLE_CODE"), foreignKey = @ForeignKey(name = "FK_ROLE_POSITION_RID"))
    private List<Role> roles;
    /**
     * 所属部门
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "FK_POSITION_PID"))
    private Department department;
    /**
     * 所属组织
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORG_POSITION_OID"), updatable = false, nullable = false)
    private Organization organization;

}
