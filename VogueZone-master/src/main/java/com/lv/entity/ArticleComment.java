package com.lv.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章评论表
 * </p>
 *
 * @author levi_bee
 * @since 2022-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ArticleComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 被评论文章id
     */
    private Long articleId;

    /**
     * 评论用户id
     */
    private Long fromId;

    /**
     * 评论者昵称
     */
    private String fromAlias;

    /**
     * 点赞数
     */
    private Integer likeNum;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private LocalDateTime creatTime;

    /**
     * 评论者头像
     */
    private String fromAvatar;


}
