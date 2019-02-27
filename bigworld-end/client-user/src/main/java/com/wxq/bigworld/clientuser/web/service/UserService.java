package com.wxq.bigworld.clientuser.web.service;

import com.wxq.bigworld.clientuser.web.entity.UserAccount;

public interface UserService {

    UserAccount getByUsername(String username);

    void save(UserAccount userAccount);
}
