package com.example.inetofficewebsite.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.Message;

/**
 * 服务类
 * @author zcl
 * @since 2021/9/7
 */
public interface MessageService {
    public Integer addMessage(String userId,String messageText);
    public IPage<Message> listMessages(Integer currentPage,Integer pageSize);
}
