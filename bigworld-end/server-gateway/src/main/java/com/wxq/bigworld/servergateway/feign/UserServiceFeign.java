package com.wxq.bigworld.servergateway.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("client-user")
public interface UserServiceFeign {
    @GetMapping("/test")
    String test();
}
