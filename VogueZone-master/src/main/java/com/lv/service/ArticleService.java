package com.lv.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lv.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-18
 */
public interface ArticleService extends IService<Article> {

    IPage<Article> getPage(int currentPage, int pageSize, Article article);

}
