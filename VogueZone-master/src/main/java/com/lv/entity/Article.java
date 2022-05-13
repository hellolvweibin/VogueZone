package com.lv.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Date;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章html
     */
    private String articleContentHtml;

    /**
     * 文章md
     */
    private String articleContentMd;

    /**
     * 文章摘要
     */
    private String articleAbstract;

    /**
     * 文章状态
     */
    private Integer status;

    /**
     * 文章封面
     */
    private String articleCover;

    /**
     * 文章创建时间，实现自动填充
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)//该注解表示在插入数据时开启自动生成
    private LocalDateTime createTime;


    /**
     * 文章修改时间,实现自动更新
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)//该注解表示在插入和修改数据时开启自动生成
    private LocalDateTime updateTime;


}
