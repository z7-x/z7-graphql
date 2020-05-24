package com.thuni.his.demo.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thuni.his.demo.bean.databind.AuthorDeserializer;
import com.thuni.his.demo.bean.databind.AuthorSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfantasy.framework.dao.BaseBusEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ts_artocle")
public class Article extends BaseBusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "标题不能为空")
    @Size(min = 2, max = 50)
    @Column(name = "title", nullable = false, length = 50) // 映射为字段，值不能为空
    private String title;

    @Lob  // 大对象，映射 MySQL 的 Long Text 类型
    @Basic(fetch = FetchType.LAZY) // 懒加载
    @NotEmpty(message = "内容不能为空")
    @Size(min = 2)
    @Column(name = "content", nullable = false) // 映射为字段，值不能为空
    private String content;//文章全文内容


    @JsonSerialize(using = AuthorSerializer.class)
    @JsonDeserialize(using = AuthorDeserializer.class)
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    //可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "FK_AUTHOR_ID"), updatable = true, nullable = true)
    //设置在article表中的关联字段(外键)
    private Author author;//所属作者
}
