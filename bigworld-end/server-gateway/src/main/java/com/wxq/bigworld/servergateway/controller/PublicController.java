package com.wxq.bigworld.servergateway.controller;

import com.wxq.bigworld.servergateway.feign.UserServiceFeign;
import com.wxq.bigworld.servergateway.util.JwtTokenUtilTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PublicController {

    @Autowired
    JwtTokenUtilTest jwtTokenUtil;

    @Autowired
    UserServiceFeign userServiceFeign;


    @PostMapping("/login")
    public Map<String,Object> Home(){

        String s = null;
        try {
            s = jwtTokenUtil.creatToken();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String,Object> map =  new HashMap<String, Object>();
        map.put("token",s);
        return map;
    }

    @GetMapping("/come")
    public void ac(){
        userServiceFeign.test();
    }



}
