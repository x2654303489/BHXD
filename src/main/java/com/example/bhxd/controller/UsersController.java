package com.example.bhxd.controller;


import com.example.bhxd.Response;
import com.example.bhxd.entity.Users;
import com.example.bhxd.service.impl.UsersServiceImpl;
import com.example.bhxd.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@RestController
@RequestMapping("/users")
//@Api(value = "用户表", description = "用户表")
public class UsersController {
    @Autowired
    UsersServiceImpl usersServiceImpl;
    @PostMapping("/login")
    //@ApiOperation(value = "登录接口", notes = "Returns a list of sample data.")
    public Response loginUser(@RequestBody Users users) {
        return usersServiceImpl.loginUser(users);
    }
    @GetMapping("/logout")
    //@ApiOperation(value = "登录接口", notes = "Returns a list of sample data.")
    public Response logoutUser() {
        return usersServiceImpl.logoutUser();
    }

    @GetMapping ("/verify")
    public Response getUsername(@RequestParam String username) {
        return usersServiceImpl.getUsername(username);
    }
    @PostMapping("/verify")
    public Response verifyUser(@RequestBody Users users) {
        return usersServiceImpl.verifyUser(users);
    }
    @PostMapping("/select")
    @PreAuthorize("hasAuthority('admin')")
    public Response getUser(@RequestBody Users users) {return usersServiceImpl.selectUser(users);}
    @PutMapping("/revise")
    public Response reviseUser(
            @RequestBody Users users,
            @RequestParam(value = "status", required = false, defaultValue = "") String status) {
        return usersServiceImpl.reviseUser(users,status);
    }
//    @PostMapping("/revise")
//    public Response removeUser(@RequestBody UserStatus userStatus) {return usersServiceImpl.reviseStatuson(userStatus);}

    @DeleteMapping("/delete")
    public Response deleteUser(@RequestParam int id) {return usersServiceImpl.removeUser(id);}
}
