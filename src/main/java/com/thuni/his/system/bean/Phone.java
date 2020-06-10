package com.thuni.his.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.system.bean.enums.PhoneStatus;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SYS_PHONE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phone extends BaseBusEntity {

    /**
     * 主键编号
     */
    @Id
    @Column(name = "id",nullable=false,unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 状态
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 20)
    private PhoneStatus status;
    /**
     * 电话
     */
    @Column(name = "phone", nullable = false, length = 25)
    private String phone;

}
