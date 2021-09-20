package com.example.inetofficewebsite.controller;

import com.example.inetofficewebsite.result.Result;
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
    public Result userRegister(@RequestParam("user_id") String userId,
                               @RequestParam("username") String username,
                               @RequestParam("password") String password){
        return new Result().result200(userService.userRegister(userId,username,password));
    }

    @GetMapping(value = "/userLogin")
    public Result userLogin(@RequestParam("user_id") String userId,
                          @RequestParam("password") String password){
        return new Result().result200(userService.userLogin(userId,password));
    }

    @GetMapping(value = "/managerLogin")
    public Result managerLogin(@RequestParam("user_id") String userId,
                          @RequestParam("password") String password){
        return new Result().result200(userService.managerLogin(userId,password));
    }

    @PatchMapping(value = "/updatePassword")
    public Result updatePassword(@RequestParam("user_id") String userId,
                                  @RequestParam("old_password") String oldPassword,
                                  @RequestParam("new_password") String newPassword){
        return new Result().result200(userService.updatePassword(userId,oldPassword,newPassword));
    }

    @PatchMapping(value = "/updateUserRoot")
    public Result updateUserRoot(@RequestParam("user_id")String userId,
                                  @RequestParam("new_manager_id") String newManagerId,
                                  @RequestParam("root") Integer root){
        return new Result().result200(userService.updateUserRoot(userId,newManagerId,root));
    }

    @GetMapping(value = "/listUsers")
    public Result listUsers(@RequestParam("current_page") Integer currentPage,
                                 @RequestParam("page_size") Integer pageSize){
        return new Result().result200(userService.listUsers(currentPage,pageSize));
    }

}
