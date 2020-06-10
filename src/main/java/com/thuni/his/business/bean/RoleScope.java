package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 *  角色范围表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORG_BUSINESS_SCOPE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RoleScope extends BaseBusEntity {
    @Id
    @Column(name = "ID",length = 50)
    private Long id;

    /**
     * 名称
     */
    @Column(name = "NAME" , length = 50)
    private String name;

    /**
     * 是否启用
     */
    @Column(name = "ENABLED")
    private Boolean enabled;


}
