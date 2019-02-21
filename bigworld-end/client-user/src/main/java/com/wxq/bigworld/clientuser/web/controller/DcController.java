package com.wxq.bigworld.clientuser.web.controller;

import com.wxq.bigworld.clientuser.web.Dao.UserRepository;
import com.wxq.bigworld.clientuser.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/test")
    public String dc() {


        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);

        User user = new User();
        user.setUsername("wxq");
        user.setPassword("qqq");
        userRepository.save(user);
        return services;
    }

    @GetMapping("/hello")
    public void t(){
        User user = new User();
        user.setUsername("wxq");
        user.setPassword("qqq");

        userRepository.save(user);
    }
}
