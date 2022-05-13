package com.lv.mapper;

import com.lv.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-18
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
