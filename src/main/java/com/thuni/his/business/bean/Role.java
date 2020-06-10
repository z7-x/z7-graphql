package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;


/**
 * 角色
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTH_ROLE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "menus", "permissions", "users", "roleAuthorities"})
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role extends BaseBusEntity {

    private static final long serialVersionUID = 4870450046611332600L;

    /**
     * 主键id
     */
    @Id
    @Column(name = "ID", length = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色编码
     */
    @Column(name = "CODING", length = 32)
    private String coding;
    /**
     * 角色名称
     */
    @Column(name = "NAME", length = 50)
    private String name;

    /**
     * 角色范围
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCOPE", foreignKey = @ForeignKey(name = "FK_ROLE_SCOPE"), updatable = false, nullable = false)
    private RoleScope scope;

    /**
     * 是否启用 0-禁用 1-启用
     */Z
    @Column(name = "ENABLED")
    private Boolean enabled;
    /**
     * 所属组织
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ROLE_ORGANIZATION"), updatable = false, nullable = false)
    private Organization organization;
    /**
     * 描述信息
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 对应的用户
     */
    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinTable(
        name = "AUTH_ROLE_USER",
        joinColumns = @JoinColumn(name = "ROLE_CODE", foreignKey = @ForeignKey(name = "FK_AUTH_ROLE_USER_ROLE")),
        inverseJoinColumns = @JoinColumn(name = "USER_ID"), foreignKey = @ForeignKey(name = "FK_ROLE_USER_RCODE")
    )
    private List<User> users;
}