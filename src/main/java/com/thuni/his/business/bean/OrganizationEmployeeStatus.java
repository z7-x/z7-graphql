package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.business.bean.databind.OrgDeserializer;
import com.thuni.his.business.bean.databind.OrgSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * 组织用户状态
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORG_ORGANIZATION_EMPLOYEE_STATUS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrganizationEmployeeStatus extends BaseBusEntity {
    /**
     * ID
     */
    @Id
    @Column(name = "ID",length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",length = 255)
    private String name;

    @JsonSerialize(using = OrgSerializer.class)
    @JsonDeserialize(using = OrgDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_EMPLOYEE_STATUS_OID"), updatable = false, nullable = false)
    private Organization organization;
    /**
     *编码
     */
    @Column(name = "CODE",length = 255)
    private String code;
    /**
     * 是否是默认值
     */
    @Column(name = "is_default",length = 10)
    private Boolean isDefault;
}
