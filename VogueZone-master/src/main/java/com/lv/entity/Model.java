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
 * @since 2022-04-08
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
    private String modelName;

    /**
     * 模特简介
     */
    private String modelIntroduction;

    /**
     * 模特图片
     */
    private String modelImage;

    /**
     * 分类id
     */
    private Integer cid;


}
