package com.wxq.bigworld.clientuser.web.controller;

import com.wxq.bigworld.clientuser.web.entity.PartyGroup;
import com.wxq.bigworld.clientuser.web.entity.PartyGroupType;
import com.wxq.bigworld.clientuser.web.entity.UserAccount;
import com.wxq.bigworld.clientuser.web.service.PartyGroupService;
import com.wxq.bigworld.clientuser.web.service.PartyGroupTypeService;
import com.wxq.bigworld.clientuser.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    PartyGroupService partyGroupService;
    @Autowired
    PartyGroupTypeService partyGroupTypeService;

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String dc() {

        PartyGroupType partyGroupType = new PartyGroupType();
        partyGroupType.setCode("role");
        partyGroupType.setName("角色类型");
        partyGroupTypeService.save(partyGroupType);

        List ps = new ArrayList<PartyGroup>();
        PartyGroup partyGroup = new PartyGroup();
        partyGroup.setCode("admin");
        partyGroup.setName("管理员");
        partyGroup.setParent(null);
        partyGroup.setPartyGroupType(partyGroupType);
        partyGroupService.save(partyGroup);

        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("im_luxqi@163.com");
        userAccount.setPassword("123456");
        ps.add(partyGroup);
        userAccount.setPartyGroups(ps);
        userService.save(userAccount);
        return "ok";
    }
}
