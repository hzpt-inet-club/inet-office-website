package com.example.inetofficewebsite.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@TableName("messages")
public class Message {
    @TableId
    private String messageId;
    private String userId;
    private String messageText;
    private Date MessageDate;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getMessageDate() {
        return MessageDate;
    }

    public void setMessageDate(Date messageDate) {
        MessageDate = messageDate;
    }
}
