package com.thuni.his.demo.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;

/**
 * @author limaofeng
 * @version V1.0
 * @Description: TODO
 * @date 2019-03-15 15:38
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "SYS_USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseBusEntity {
    @Id
    @Column(name = "ID", nullable = false, updatable = false, precision = 22)
    @GeneratedValue(generator = "fantasy-sequence")
    @GenericGenerator(name = "fantasy-sequence", strategy = "fantasy-sequence")
    private Long id;
    @Column(name = "USERNAME", length = 18)
    private String username;
    @Column(name = "password", length = 21)
    private String password;
}
