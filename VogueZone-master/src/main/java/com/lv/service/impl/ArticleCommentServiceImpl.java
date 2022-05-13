package com.lv.service.impl;

import com.lv.entity.ArticleComment;
import com.lv.mapper.ArticleCommentMapper;
import com.lv.service.ArticleCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 * @author levi_bee
 * @since 2022-05-13
 */
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment> implements ArticleCommentService {

}
