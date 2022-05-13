package com.lv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模特名
     */
    private String name;

    /**
     * 模特性别
     */
    private Integer gender;

    /**
     * 模特国籍
     */
    private String nationality;

    /**
     * 模特简介
     */
    private String introduction;

    /**
     * 模特图片
     */
    private String image;


}
