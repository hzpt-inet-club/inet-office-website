package com.example.inetofficewebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inetofficewebsite.mapper.MessageMapper;
import com.example.inetofficewebsite.pojo.Message;
import com.example.inetofficewebsite.service.MessageService;
import com.example.inetofficewebsite.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *     服务实现类
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    /**
     * 添加留言
     * @param userId 留言用户id
     * @param messageText 留言信息
     * @return
     */
    @Override
    public Integer addMessage(String userId, String messageText) {
        Message message=new Message();
        message.setMessageId(UUIDUtils.getUUID());
        message.setUserId(userId);
        message.setMessageText(messageText);
        message.setMessageDate(new Date());
        return messageMapper.insert(message);
    }

    /**
     * 查看留言信息
     * @param currentPage 页数
     * @param pageSize 一页所选的留言信息条数
     * @return
     */
    @Override
    public IPage<Message> listMessages(Integer currentPage, Integer pageSize) {
        IPage<Message> iPage=new Page<>();
        iPage.setCurrent(currentPage);
        iPage.setSize(pageSize);
        QueryWrapper<Message> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("message_date");
        return messageMapper.selectPage(iPage,queryWrapper);
    }
}
