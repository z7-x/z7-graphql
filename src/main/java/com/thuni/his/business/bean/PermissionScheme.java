package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import java.util.List;


/**
 * 权限配置信息计划表
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AUTH_PERMISSION_SCHEME")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class PermissionScheme extends BaseBusEntity {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "ID", length = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 名称
     */
    @Column(name = "NAME", length = 50)
    private String name;
    /**
     * 描述
     */
    @Column(name = "DESCRIPTION", length = 50)
    private String description;
    /**
     * 权限
     */
    @OneToMany(mappedBy = "scheme", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<GrantPermission> grants;
}
