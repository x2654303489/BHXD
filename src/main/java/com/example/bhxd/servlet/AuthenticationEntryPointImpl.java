package com.example.bhxd.servlet;

import com.example.bhxd.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
@Service
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Response result = new Response(401, "认证失败");
        response.setContentType("application/json;charset=UTF-8");
        ObjectMapper mapper = new ObjectMapper(); // 或者使用 Gson gson = new Gson();
        String jsonResult = mapper.writeValueAsString(result);
        response.getWriter().write(jsonResult);

    }
}
