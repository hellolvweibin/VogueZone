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
 * @since 2022-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签id
     */
    @TableId(value = "label_id", type = IdType.AUTO)
    private Integer labelId;

    /**
     * 标签名
     */
    private String labelName;

    /**
     * 标签描述
     */
    private String labelDescription;


}
