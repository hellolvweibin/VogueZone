package com.lv.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lv.entity.Article;
import com.lv.mapper.ArticleMapper;
import com.lv.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-18
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public IPage<Article> getPage(int currentPage, int pageSize, Article article) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("article_title");
        IPage myPage = new Page(currentPage, pageSize);
        articleMapper.selectPage(myPage,queryWrapper);
        return myPage;

    }
}
