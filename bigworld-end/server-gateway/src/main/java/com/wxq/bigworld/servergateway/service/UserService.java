package com.wxq.bigworld.servergateway.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wxq.bigworld.servergateway.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserServiceFeign userServiceFeign;

    @HystrixCommand(fallbackMethod = "fallback")
    public String test() {
        return userServiceFeign.test();
    }

    public String fallback() {
        return "fallback";
    }

}
