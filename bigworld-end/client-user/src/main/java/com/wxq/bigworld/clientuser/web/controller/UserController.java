package com.wxq.bigworld.clientuser.web.controller;

import com.wxq.bigworld.clientuser.web.entity.UserAccount;
import com.wxq.bigworld.clientuser.web.service.PartyGroupService;
import com.wxq.bigworld.clientuser.web.service.UserService;
import com.wxq.bigworld.pub.common.HttpReply;
import com.wxq.bigworld.pub.user.UserAccountPub;
import com.wxq.bigworld.pub.util.CheckUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PartyGroupService partyGroupService;


    @ApiOperation("获取用户信息")
    @PostMapping("/getByUsername")
    public UserAccountPub getByUsername(@RequestParam("username") String username) throws Exception{
        UserAccount userAccount = userService.getByUsername(username);
        if (userAccount != null) {//获知用户相应的角色
            String[] roles = partyGroupService.getRolesByUsername(username);
            userAccount.setRoleList(Arrays.asList(roles));
        }
        return new UserAccountPub().copyFromObj(userAccount);
    }

    @PostMapping("/ttt")
    public UserAccountPub tet() throws Exception {
     String   username = "im_luxqi@163.com";
        UserAccount userAccount = userService.getByUsername(username);
        if (userAccount != null) {//获知用户相应的角色
            String[] roles = partyGroupService.getRolesByUsername(username);
            userAccount.setRoleList(Arrays.asList(roles));
        }
        return new UserAccountPub().copyFromObj(userAccount);
    }

    @ApiOperation(value = "注册用户信息")
    @PostMapping("register")
    public HttpReply register(@RequestBody UserAccount userAccount) {

        String username = userAccount.getUsername();
        if (!CheckUtil.checkEmaile(username)) {
            return new HttpReply("邮箱格式不正确");
        }
        if (userService.getByUsername(username) != null) {
            return new HttpReply("邮箱已被注册");
        }

        userAccount.setCreateTime(new Date());
        userAccount.setUpdateTime(new Date());
        userService.save(userAccount);
        return new HttpReply(HttpStatus.OK.value(), "注册成功");
    }


    @ApiOperation(value = "通过名称模糊搜索获取用户列表")
    @GetMapping("getList/{key}")
    public HttpReply getList(@PathVariable String key) {
        return null;
    }

}
