package com.wxq.bigworld.pub.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class UserInfo implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private List<String> roleList;

    public UserInfo(UserAccountPub userAccountPub) {
        this.username = userAccountPub.getUsername();
        this.password = userAccountPub.getPassword();
        this.roleList = userAccountPub.getRoleList();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        roleList.forEach(role -> authorityList.add(new SimpleGrantedAuthority(role)));
        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
