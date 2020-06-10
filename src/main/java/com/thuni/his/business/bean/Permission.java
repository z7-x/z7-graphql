package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.business.bean.enums.PermissionCategory;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 权限配置信息
 *
 */
@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AUTH_PERMISSION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Permission extends BaseBusEntity {
    @Id
    @Column(name = "ID", length = 25)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 权限名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 资源描述
     */
    @Column(name = "DESCRIPTION", length = 250)
    private String description;
    /**
     * 是否启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;
    /**
     * 类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY", length = 20, nullable = false)
    private PermissionCategory category;
    /**
     * 资源类型
     */
    @Column(name = "RESOURCE_TYPE", length = 25)
    private String resourceType;
}
