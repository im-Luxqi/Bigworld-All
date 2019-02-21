package com.wxq.bigworld.servergateway.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("client-user")
public interface UserServiceFeign {
    @RequestMapping(value="/test",method= RequestMethod.GET)
    String test();
}
