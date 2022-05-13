package com.lv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lv.entity.Article;
import com.lv.entity.Model;
import com.lv.mapper.ArticleMapper;
import com.lv.result.Result;
import com.lv.result.ResultFactory;
import com.lv.service.ArticleService;
import com.lv.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-13
 */
@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleMapper articleMapper;


//    //获取所有文章
//    @GetMapping("/articles/{size}/{page}")
//    public Result getAllArticle(@PathVariable("size") int size, @PathVariable("page") int page){
//
//        return ResultFactory.buildSuccessResult(articleService.list());
//
//    }

    //保存文章
    @PostMapping("/admin/content/article")
    public Result saveArticle(@RequestBody Article article){

        articleService.saveOrUpdate(article);
        return ResultFactory.buildSuccessResult("保存成功！");
    }



    //分页获取所有文章,按照时间最新排序
    @GetMapping("/articles/{currentPage}/{pageSize}")
    public Result getAllArticle(@PathVariable("currentPage") int currentPage,@PathVariable("pageSize") int pageSize, Article article){


        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByDesc("create_time");

        IPage<Article> page = new Page<>(currentPage,pageSize);
        IPage<Article> articleIPage = articleMapper.selectPage(page, queryWrapper);
        return ResultFactory.buildSuccessResult(articleIPage);



//        //如果当前页码值大于了总页码值，就重新执行查询操作，使用最大页码值作为当前页码值
//        if( currentPage > myPage.getPages()){
//            myPage = articleService.getPage((int)myPage.getPages(), pageSize,article);
//        }





    }

    //搜索文章
    @GetMapping("/admin/article/search")
    public Result searchResult( String keywords){
        QueryWrapper<Article> result = new QueryWrapper<Article>().like("article_title", keywords);


        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(articleService.list());
        } else {
            return ResultFactory.buildSuccessResult(articleService.list(result));
        }

    }



    //文章详情
    @GetMapping("/admin/article/{id}")
    public Result getOneArticle(@PathVariable("id") int id) {
        return ResultFactory.buildSuccessResult(articleService.getById(id));
    }



    //上传文章封面
    @PostMapping("/admin/article/covers")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "/Users/levi_bee/Desktop/Levi的学习之路/VogueZone/voguezone-vue/workspace/image";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, StringUtils.getRandomString(6) + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8091/api/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }









}
