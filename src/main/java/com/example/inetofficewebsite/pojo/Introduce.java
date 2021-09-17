package com.example.inetofficewebsite.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * <p>
 *
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@TableName("introduces")
public class Introduce {
    @TableId(value = "introduce_id",type = IdType.AUTO)
    private Integer introduceId;
    private String introduceText;

    public Integer getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Integer introduceId) {
        this.introduceId = introduceId;
    }

    public String getIntroduceText() {
        return introduceText;
    }

    public void setIntroduceText(String introduceText) {
        this.introduceText = introduceText;
    }
}
