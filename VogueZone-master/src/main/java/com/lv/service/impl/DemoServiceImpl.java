package com.lv.service.impl;

import com.lv.entity.Demo;
import com.lv.mapper.DemoMapper;
import com.lv.service.DemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author levi_bee
 * @since 2022-03-30
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {

}
