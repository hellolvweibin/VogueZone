package com.lv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author levi_bee
 * @since 2022-03-30
 */
//@Data
//@EqualsAndHashCode(callSuper = false)
//@Accessors(chain = true)
//public class Demo implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * 标识id
//     */
//    @TableId(value = "id", type = IdType.AUTO)
//    private Integer id;
//
//    /**
//     * 用户名
//     */
//    private String username;
//
//    /**
//     * 密码
//     */
//    private String password;
//
//
//}
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demo {
    private int id;
    private String username;
    private String password;
}

