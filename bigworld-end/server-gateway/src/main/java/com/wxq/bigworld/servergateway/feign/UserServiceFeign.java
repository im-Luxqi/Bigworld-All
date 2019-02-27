package com.wxq.bigworld.servergateway.feign;

import com.wxq.bigworld.pub.user.UserAccountPub;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("client-user")
public interface UserServiceFeign {
    @RequestMapping(value = "getByUsername", method = RequestMethod.POST)
    UserAccountPub getByUsername(@RequestParam("username") String username);

    @RequestMapping(value = "tt", method = RequestMethod.POST)
    String test();
}
