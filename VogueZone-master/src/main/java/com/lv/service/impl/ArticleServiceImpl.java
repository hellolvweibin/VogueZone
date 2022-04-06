package com.lv.service.impl;

import com.lv.entity.Article;
import com.lv.mapper.ArticleMapper;
import com.lv.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author levi_bee
 * @since 2022-03-27
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
