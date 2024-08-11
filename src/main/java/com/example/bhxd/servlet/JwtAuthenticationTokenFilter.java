package com.example.bhxd.servlet;

import com.example.bhxd.utils.CacheClientUtills;
import com.example.bhxd.utils.RedisCache;
import com.example.bhxd.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Service
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    CacheClientUtills cacheClientUtills;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token = request.getHeader("Authorization");
        //判断token是否存在
        if (token==null) {
            filterChain.doFilter(request, response);
            return;
        }
        //获取用户信息
        Claims claims = TokenUtil.parsePayload(token);
        String id =(String)claims.get("name");
        //从redis中获取用户信息
        LoginUser loginUser = cacheClientUtills.get("token:" + id,LoginUser.class);
        //判断用户是否存在
        if (loginUser == null) {
            throw new RuntimeException("用户不存在");
        }
        //存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //放行
        filterChain.doFilter(request, response);
    }
}
