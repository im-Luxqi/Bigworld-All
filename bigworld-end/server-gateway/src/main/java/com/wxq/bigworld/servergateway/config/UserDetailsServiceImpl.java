package com.wxq.bigworld.servergateway.config;

import com.wxq.bigworld.pub.user.UserAccountPub;
import com.wxq.bigworld.pub.user.UserInfo;
import com.wxq.bigworld.servergateway.feign.UserServiceFeign;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private UserServiceFeign userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername:{}", username);
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }
        UserAccountPub byUsername = userService.getByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException("账号不存在");
        }
        return new UserInfo(byUsername);
    }
}
