package com.example.inetofficewebsite.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.Introduce;
import com.example.inetofficewebsite.pojo.Message;

/**
 * <p>
 *     服务类
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
public interface IntroduceService {
    public Integer addIntroduceService(String introduceText);
    public IPage<Introduce> listIntroduces(Integer currentPage, Integer pageSize);
    public Integer deleteIntroduce(Integer id);

}
