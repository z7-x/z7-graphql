package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.OrgDeserializer;
import com.thuni.his.business.bean.databind.RoleScopeDeserializer;
import com.thuni.his.business.bean.databind.UsersDeserializer;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "menus", "permissions" ,"roleAuthorities"})//指定的字段不会序列化和反序列化
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
    @JsonDeserialize(using = RoleScopeDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCOPE", foreignKey = @ForeignKey(name = "FK_ROLE_SCOPE"), updatable = false, nullable = false)
    private RoleScope scope;

    /**
     * 是否启用 0-禁用 1-启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;
    /**
     * 所属组织
     */
    @JsonDeserialize(using = OrgDeserializer.class)
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
    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(User)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为 AUTH_ROLE_USER
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即 ROLE_CODE
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即 USER_ID
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    @ManyToMany(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinTable(
        name = "AUTH_ROLE_USER",
        joinColumns = @JoinColumn(name = "ROLE_CODE", foreignKey = @ForeignKey(name = "FK_AUTH_ROLE_USER_ROLE")),
        inverseJoinColumns = @JoinColumn(name = "USER_ID"), foreignKey = @ForeignKey(name = "FK_ROLE_USER_RCODE")
    )
    private List<User> users;
}