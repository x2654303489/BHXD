package com.example.bhxd.servlet;

import com.alibaba.fastjson.annotation.JSONField;
import com.example.bhxd.entity.Users;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails {
    private Users users;
    private List<String> permissions;

    public LoginUser(Users users, List<String> permissions) {
        this.users = users;
        this.permissions = permissions;
    }
    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> collect;
    @Override
    @JSONField(serialize = false)
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (collect != null){
            return collect;
        }
        //把permissions封装成对象
        collect = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
