package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thuni.his.business.bean.databind.EmployeeDeserializer;
import com.thuni.his.business.bean.databind.OrgDeserializer;
import com.thuni.his.business.bean.databind.RolesDeserializer;
import com.thuni.his.business.bean.enums.UserType;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.jfantasy.framework.dao.BaseBusEntity;
import org.jfantasy.framework.dao.hibernate.converter.MapConverter;
import org.jfantasy.framework.spring.validation.RESTful;
import org.jfantasy.framework.util.common.ClassUtil;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * 用户表
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTH_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user_groups", "website", "menus", "authorities"})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseBusEntity {
    @Id
    @Column(name = "ID", nullable = false, updatable = false, precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户登录名称
     */
    @Size(min=3, max=20)
    @NotEmpty(message = "账号不能为空",groups = {RESTful.POST.class, RESTful.PUT.class})
    @Length(min = 6, max = 20, groups = {RESTful.POST.class, RESTful.PUT.class})
    @Column(name = "USERNAME", length = 20, updatable = false, nullable = false, unique = true)
    private String username;
    /**
     * 登录密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PASSWORD", length = 50, nullable = false)
    private String password;

    /**
     * 用户类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE", length = 20, nullable = false)
    private UserType userType;
    /**
     * 用户显示昵称
     */
    @Column(name = "NICK_NAME", length = 50)
    private String nickName;
    /**
     * 是否启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;
    /**
     * 未过期
     */
    @Column(name = "NON_EXPIRED")
    private Boolean accountNonExpired;
    /**
     * 未锁定
     */
    @Column(name = "NON_LOCKED")
    private Boolean accountNonLocked;
    /**
     * 未失效
     */
    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private Boolean credentialsNonExpired;
    /**
     * 锁定时间
     */
    @Column(name = "LOCK_TIME")
    private Date lockTime;
    /**
     * 最后登录时间
     */
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;
    /**
     * 用户对应的角色
     */
    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Role)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为 AUTH_ROLE_USER
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即 USER_ID
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即 ROLE_CODE
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    @JsonDeserialize(using = RolesDeserializer.class)
    @ManyToMany(targetEntity = Role.class, fetch = FetchType.LAZY)
    @JoinTable(name = "AUTH_ROLE_USER",
            joinColumns = @JoinColumn(name = "USER_ID", foreignKey = @ForeignKey(name = "FK_AUTH_ROLE_USER_USER")),
            inverseJoinColumns = @JoinColumn(name = "ROLE_CODE"), foreignKey = @ForeignKey(name = "FK_ROLE_USER_UID"))
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Role> roles;

    /**
     * 管理人员
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = EmployeeDeserializer.class)
    @JoinColumn(name = "EMPLOYEE_ID", foreignKey = @ForeignKey(name = "FK_AUTH_USER_EMPLOYEE"))
    private Employee employee;

    /**
     * 所属组织
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = OrgDeserializer.class)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_USER_ORGANIZATION"), updatable = false, nullable = false)
    private Organization organization;

    /**
     * 扩展字段
     */
    @Convert(converter = MapConverter.class)
    @Column(name = "PROPERTIES", columnDefinition = "Text")
    private Map<String,Object> properties;

    @JsonAnySetter
    public void set(String key, Object value) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, value);
    }

    @Transient
    public String get(String key) {
        if (this.properties == null || !this.properties.containsKey(key)) {
            return null;
        }
        return this.properties.getOrDefault(key, "").toString();
    }

    @Transient
    public <T> T get(String key, Class<T> toClass) {
        String value = this.get(key);
        if (value == null) {
            return null;
        }
        return ClassUtil.newInstance(toClass, value);
    }
}