package com.thuni.his.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thuni.his.system.bean.enums.EmailStatus;
import lombok.*;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;


/**
 * 邮件表
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SYS_EMAIL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Email extends BaseBusEntity {

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
    private EmailStatus status;
    /**
     * 邮箱
     */
    @Column(name = "EMAIL", nullable = false, length = 25)
    private String email;
}
