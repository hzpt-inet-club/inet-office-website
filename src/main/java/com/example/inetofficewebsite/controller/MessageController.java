package com.example.inetofficewebsite.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.Message;
import com.example.inetofficewebsite.result.Result;
import com.example.inetofficewebsite.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *    前端控制器
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @PutMapping(value = "/addMessage")
    public Result addMessage(@RequestParam("user_id") String userId,
                             @RequestParam("message_text") String messageText){
        return new Result().result200(messageService.addMessage(userId,messageText));
    }

    @GetMapping(value = "/listMessages")
    public Result addMessage(@RequestParam("current_page") Integer currentPage,
                                     @RequestParam("page_size") Integer pageSize){
        return new Result().result200(messageService.listMessages(currentPage,pageSize));
    }


}
