package com.lv.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lv.entity.Model;
import com.lv.result.Result;
import com.lv.result.ResultFactory;
import com.lv.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author levi_bee
 * @since 2022-04-10
 */
@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    ModelService modelService;

    @GetMapping("/models")
    public Result listModels(){
        //
        return ResultFactory.buildSuccessResult(modelService.list());

    }
    @GetMapping("/search")
    public Result searchResult( String keywords){
        QueryWrapper<Model> result = new QueryWrapper<Model>().like("name", keywords);
        QueryWrapper<Model> fail = new QueryWrapper<Model>().notIn("name",keywords);

        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return ResultFactory.buildSuccessResult(modelService.list());}
       else {
            return ResultFactory.buildSuccessResult(modelService.list(result));
        }

    }

    //@PathVariable是用来获得请求url中的动态参数的，从路径中获得变量
    @GetMapping("/gender/{gender}/models")
    public Result listByGender(@PathVariable("gender") int gender){
        //根据url中的参数获得数据
        QueryWrapper<Model> result = new QueryWrapper<Model>().eq("gender", gender);
        if (gender!=0){
            return ResultFactory.buildSuccessResult(modelService.list(result));
        }else{
            return ResultFactory.buildSuccessResult(modelService.list());
        }

    }

}
