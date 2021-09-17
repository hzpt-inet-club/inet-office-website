package com.example.inetofficewebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inetofficewebsite.mapper.IntroduceMapper;
import com.example.inetofficewebsite.pojo.Introduce;

import com.example.inetofficewebsite.service.IntroduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *<p>
 *     服务实现类
 *</p>
 * @author zcl
 * @since 2021/9/7
 */
@Service
public class IntroduceServiceImpl implements IntroduceService {
    @Autowired
    IntroduceMapper introduceMapper;

    /**
     * 添加介绍信息
     * @param introduceText 介绍信息
     * @return 返回码是1为成功，0为失败
     */
    @Override
    public Integer addIntroduceService(String introduceText) {
        Introduce introduce=new Introduce();
        introduce.setIntroduceId(null);
        introduce.setIntroduceText(introduceText);
        return introduceMapper.insert(introduce);
    }

    /**
     *
     * @param currentPage 页数
     * @param pageSize 一页所选的介绍信息条数
     * @return 返回介绍信息
     */
    @Override
    public IPage<Introduce> listIntroduces(Integer currentPage, Integer pageSize) {
        IPage<Introduce> iPage=new Page<>();
        iPage.setCurrent(currentPage);
        iPage.setSize(pageSize);
        QueryWrapper<Introduce> queryWrapper=new QueryWrapper<>();
        return introduceMapper.selectPage(iPage,null);
    }

    @Override
    public Integer deleteIntroduce(Integer id) {
        return introduceMapper.deleteById(id);
    }
}
