package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.PermissionDeserializer;
import com.thuni.his.business.bean.databind.PermissionSerializer;
import com.thuni.his.business.bean.enums.SecurityType;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = {"securityType", "value", "resource", "permission"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTH_GRANT_PERMISSION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GrantPermission extends BaseBusEntity {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 授权类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "SECURITY_TYPE", length = 20, nullable = false)
    private SecurityType securityType;
    /**
     * 授权
     */
    @Column(name = "VALUE", length = 25, nullable = false)
    private String value;
    /**
     * 资源
     */
    @Column(name = "RESOURCE", length = 25)
    private String resource;
    /**
     * 权限
     */
    @JsonProperty("permission")
    @JsonSerialize(using = PermissionSerializer.class)
    @JsonDeserialize(using = PermissionDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERMISSION", foreignKey = @ForeignKey(name = "FK_SECURE_GRANT_PERMISSION_PID"), nullable = false)
    private Permission permission;
    /**
     * 权限方案
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHEME", foreignKey = @ForeignKey(name = "FK_SECURE_GRANT_PERMISSION_SID"))
    private PermissionScheme scheme;
}
