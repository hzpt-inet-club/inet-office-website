package com.example.inetofficewebsite.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * <p>
 *
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@TableName(value = "users")
public class User {
    /**
     * 学号
     */
    @TableId
    private String userId;
    /**
     * 姓名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 权限
     */
    private int userRoot;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRoot() {
        return userRoot;
    }

    public void setUserRoot(int userRoot) {
        this.userRoot = userRoot;
    }
}
