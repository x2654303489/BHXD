package com.example.bhxd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.bhxd.Response;
import com.example.bhxd.dto.*;
import com.example.bhxd.entity.Users;
import com.example.bhxd.mapper.UsersMapper;
import com.example.bhxd.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.bhxd.servlet.LoginUser;
import com.example.bhxd.utils.BCryptutils;
import com.example.bhxd.utils.CacheClientUtills;
import com.example.bhxd.utils.RedisCache;
import com.example.bhxd.utils.TokenUtil;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-07-12
 */
@Service

public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    RedisCache redisCache;
    @Autowired
    CacheClientUtills cacheClientUtills;
    public Response loginUser(Users users) {
        UsernamePasswordAuthenticationToken unauthenticated =
                UsernamePasswordAuthenticationToken.unauthenticated(users.getUsername(), users.getPassword());
        try {
            Authentication authenticate = authenticationManager.authenticate(unauthenticated);
           // SecurityContextHolder.getContext().setAuthentication(authenticate);
            if (authenticate == null){
                return Response.NO("用户名或密码错误");
            }
            LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
            System.out.println(loginUser);
            String userID = loginUser.getUsers().getUserID().toString();
            Map<String, String> map = new HashMap<>();
            String tokenByKey = TokenUtil.genAccessToken(userID);
            map.put("token", tokenByKey);
            cacheClientUtills.set("token:" + userID,loginUser , 3000L, TimeUnit.MINUTES);

            return Response.OK(map,"登录成功");

        } catch (AuthenticationException e){
            return Response.NO(e.getLocalizedMessage());
        }
    }

    public Response logoutUser() {
        //获取当前登录用户
        UsernamePasswordAuthenticationToken authentication =(UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer id = loginUser.getUsers().getUserID();
        //删除redis缓存
        try {
            redisCache.deleteObject("token:" + id);
        }catch (Exception e){
            return Response.NO(e.getLocalizedMessage());
        }

        return Response.OK("退出成功");

    }

    public Response getUsername(String username) {
        QueryWrapper UserQueryWrapper = new QueryWrapper<>();
        UserQueryWrapper.eq("Username", username);
        Users user = getOne(UserQueryWrapper);
        if (user == null)
           return Response.OK( "用户名不存在");
        else return Response.NO("用户名存在");
    }

    public Response verifyUser(Users users) {
        @Size(min = 6, message = "用户名长度必须至少为6个字符")
        @Min(value = 6, message = "用户名长度必须至少为6个字符")
        Users users1 =  users;
        if (users.getUsername() == null || users.getPassword() == null){
            return Response.NO("用户名或密码不能为空");
        }
        if (users.getPassword().length() < 6){
            return Response.NO("密码长度不能小于6");
        }
        if (users.getUsername().length() > 20 || users.getPassword().length() > 20)
            return Response.NO("用户名或密码长度不能大于20");
        if (users.getPassword().contains(" "))
            return Response.NO("密码不能包含空格");
        if (users.getUsername().contains(" "))
            return Response.NO("用户名不能包含空格");

        users.setPassword(BCryptutils.BCryjm(users.getPassword()));

        if (!save(users)){
            throw new RuntimeException("用户注册失败");
        }
        return Response.OK("注册成功");
    }

    public Response selectUser(Users users) {
        QueryWrapper UserQueryWrapper = new QueryWrapper<>();
        if (users.getUsername()!=null&&users.getUsername()!="")
        UserQueryWrapper.eq("Username", users.getUsername());
        if (users.getPhoneNumber()!=null&&users.getPhoneNumber()!="")
            UserQueryWrapper.eq("PhoneNumber", users.getPhoneNumber());
        List<Users> user = list(UserQueryWrapper);
        if (user.size() != 0)
        return Response.OK(user,"查询成功");
        else return Response.NO("用户不存在");
    }

    public Response reviseUser(Users users, String status) {
        if (status != ""){
            users.setStatus(status);
        }
        users.setPassword(BCryptutils.BCryjm(users.getPassword()));
        if (updateById(users))return Response.OK("修改成功");
        else return Response.NO("修改失败");

    }

    public Response removeUser(int id) {
        if (removeById(id)) return Response.OK("删除成功");
        else return Response.NO("删除失败");
    }

//    public Response reviseStatuson(UserStatus userStatus) {
//
//        Users users = new Users();
//        users.setUserID(userStatus.getId());
//        users = getById(users);
//        if (userStatus.getStatus() == 1)
//        users.setStatus("disabled");
//        else users.setStatus("active");
//        if (updateById(users))return Response.OK("修改成功");
//        else return Response.NO("修改失败");
//
//
//    }


}
