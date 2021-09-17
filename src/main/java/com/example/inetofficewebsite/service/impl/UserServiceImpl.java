package com.example.inetofficewebsite.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.inetofficewebsite.mapper.UserMapper;
import com.example.inetofficewebsite.pojo.User;
import com.example.inetofficewebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     服务实现类
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 注册
     * @param userId 学生的学号
     * @param username 学生姓名
     * @param password 密码
     * @return  返回1为注册成功,0为失败,-1为账号已存在
     */
    @Override
    public Integer userRegister(String userId, String username, String password) {
        if (userMapper.selectById(userId)==null){
        User newUser=new User();
        newUser.setUserId(userId);
        newUser.setUsername(username);
        newUser.setPassword(password);
            return userMapper.insert(newUser);
        }
        return -1;
    }

    /**
     * 登录
     * @param userId 学生的学号
     * @param password 学生密码
     * @return 返回 1为登录成功,0为失败
     */
    @Override
    public Integer userLogin(String userId, String password) {
        Map<String ,Object> map=new HashMap<>();
        map.put("user_id",userId);
        map.put("password",password);
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.allEq(map);
        return userMapper.selectCount(queryWrapper);
    }

    /**
     * 修改密码
     * @param userId 学生的学号
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 返回 1为修改成功,0为失败
     */
    @Override
    public Integer updatePassword(String userId, String oldPassword,String newPassword) {
        if (oldPassword.equals(userMapper.selectById(userId).getPassword())){
            User user=new User();
            user.setUserId(userId);
            user.setPassword(newPassword);
            return userMapper.updateById(user);
        }
        return 0;
    }


    /**
     * 管理员添加权限
     * @param userId 管理员id
     * @param newMangerId 被授予权限的用户
     * @param root  被授予的权限等级
     * @return 返回码 1 为添加成功,0为失败
     */
    @Override
    public Integer updateUserRoot(String userId,String newMangerId, Integer root) {
        if (userMapper.selectById(userId).getUserRoot()==2){
            User user=new User();
            user.setUserId(newMangerId);
            user.setUserRoot(root);
            userMapper.updateById(user);
            return 1;
        }
        return 0;
    }

    /**
     * 登录
     * @param userId 管理员学号
     * @param password 管理员密码
     * @return 返回码 1 为登录成功,0为失败,-1为没有权限
     */
    @Override
    public Integer managerLogin(String userId, String password) {
        if (1==userMapper.selectById(userId).getUserRoot()){
           return userLogin(userId,password);
        }
        return -1;
    }

    /**
     * 分页查询
     * @param currentPage 页数
     * @param pageSize 每次查询的到人
     * @return 查询出的人的信息
     */
    @Override
    public IPage<User> listUsers(Integer currentPage, Integer pageSize) {
        IPage<User> iPage = new Page<>();
        iPage.setCurrent(currentPage);
        iPage.setSize(pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("user_root");
        return userMapper.selectPage(iPage, queryWrapper);
    }
}
