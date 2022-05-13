package com.lv.entity;

import java.time.LocalDateTime;
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
 * @since 2022-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentReply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 父评论id
     */
    private Long commentId;

    /**
     * 评论者id
     */
    private Long fromId;

    /**
     * 评论者昵称
     */
    private String fromAlias;

    /**
     * 评论者头像
     */
    private String fromAvatar;

    /**
     * 被评论者id
     */
    private Long toId;

    /**
     * 被评论者昵称
     */
    private String toAlias;

    /**
     * 被评论者头像
     */
    private String toAvatar;

    /**
     * 评论内容
     */
    private String commentCotent;

    /**
     * 评论时间
     */
    private LocalDateTime createTime;


}
