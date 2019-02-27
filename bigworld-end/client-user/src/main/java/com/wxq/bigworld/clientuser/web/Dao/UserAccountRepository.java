package com.wxq.bigworld.clientuser.web.Dao;

import com.wxq.bigworld.clientuser.common.base.BaseRepository;
import com.wxq.bigworld.clientuser.web.entity.UserAccount;

import java.util.List;

public interface UserAccountRepository extends BaseRepository<UserAccount,String> {
    List<UserAccount> findByUsername(String username);
}
