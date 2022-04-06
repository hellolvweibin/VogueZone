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
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    /**
     * 文章标题
     */
    private String articleTitle;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章图片
     */
    private String image;

    /**
     * 文章点赞数
     */
    private Integer articleLikeCount;

    /**
     * 文章评论总数
     */
    private Integer articleCommentCount;

    /**
     * 文章收藏数
     */
    private Integer articleCollectCount;

    /**
     * 发表用户id
     */
    private Integer userId;

    /**
     * 文章分类
     */
    private Integer sortId;

    /**
     * 文章状态article
     */
    private Integer status;

    /**
     * 文章创建时间
     */
    private LocalDateTime articleCreatedTime;

    /**
     * 文章修改时间
     */
    private LocalDateTime articleUpdatedTime;


}
