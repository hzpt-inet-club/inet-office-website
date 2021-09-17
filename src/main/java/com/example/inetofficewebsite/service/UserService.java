package com.example.inetofficewebsite.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.User;

/**
 * <p>
 *     服务类
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
public interface UserService {
    public Integer managerLogin(String userId, String password);
    public Integer userRegister(String userId, String username, String password);
    public Integer userLogin(String userId, String password);
    public Integer updatePassword(String userId,String oldPassword,String newPassword);
    public Integer updateUserRoot(String userId,String newMangerId,Integer root);
    public IPage<User> listUsers(Integer currentPage , Integer pageSize);
}