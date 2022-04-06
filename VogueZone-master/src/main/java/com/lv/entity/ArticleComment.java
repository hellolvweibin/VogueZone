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
 * 
 * </p>
 *
 * @author levi_bee
 * @since 2022-03-27
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
    private Integer id;

    /**
     * 评论用户id
     */
    private Integer userId;

    /**
     * 评论文章id
     */
    private Integer articleId;

    /**
     * 点赞数
     */
    private Integer commentLikeCount;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 父评论id
     */
    private Integer parentCommentId;

    /**
     * 评论时间
     */
    private LocalDateTime commentTime;


}
