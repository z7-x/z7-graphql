package com.thuni.his.business.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thuni.his.business.bean.databind.PositionDeserializer;
import com.thuni.his.business.bean.enums.DepartmentLinkType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * @Description: 部门关联表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORG_DEPARTMENT_LINK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DepartmentLink extends BaseBusEntity {
    @Id
    @Column(name = "ID", precision = 22)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 内部部门
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonDeserialize(using = PositionDeserializer.class)
    @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "FK_DEPARTMENT_LINK_EID"))
    private Department department;
    /**
     * 链接类型
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 10)
    private DepartmentLinkType type;
    /**
     * 外部ID
     */
    @Column(name = "LINK_ID", length = 32)
    private String linkId;

}
