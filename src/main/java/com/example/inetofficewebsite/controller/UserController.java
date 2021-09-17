package com.example.inetofficewebsite.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.inetofficewebsite.pojo.User;
import com.example.inetofficewebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *     前端控制类
 * </p>
 * @author zcl
 * @since 2021/9/7
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PutMapping(value = "/userRegister")
    public Integer userRegister(@RequestParam("user_id") String userId,
                                @RequestParam("username") String username,
                                @RequestParam("password") String password){
        return userService.userRegister(userId,username,password);
    }

    @GetMapping(value = "/userLogin")
    public Integer userLogin(@RequestParam("user_id") String userId,
                          @RequestParam("password") String password){
        return userService.userLogin(userId,password);
    }

    @GetMapping(value = "/managerLogin")
    public Integer managerLogin(@RequestParam("user_id") String userId,
                          @RequestParam("password") String password){
        return userService.managerLogin(userId,password);
    }

    @PatchMapping(value = "/updatePassword")
    public Integer updatePassword(@RequestParam("user_id") String userId,
                                  @RequestParam("old_password") String oldPassword,
                                  @RequestParam("new_password") String newPassword){
        return userService.updatePassword(userId,oldPassword,newPassword);
    }

    @PatchMapping(value = "/updateUserRoot")
    public Integer updateUserRoot(@RequestParam("user_id")String userId,
                                  @RequestParam("new_manager_id") String newManagerId,
                                  @RequestParam("root") Integer root){
        return userService.updateUserRoot(userId,newManagerId,root);
    }

    @GetMapping(value = "/listUsers")
    public IPage<User> listUsers(@RequestParam("current_page") Integer currentPage,
                                 @RequestParam("page_size") Integer pageSize){
        return userService.listUsers(currentPage,pageSize);
    }

}
