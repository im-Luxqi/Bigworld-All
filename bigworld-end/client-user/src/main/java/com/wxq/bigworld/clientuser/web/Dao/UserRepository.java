package com.wxq.bigworld.clientuser.web.Dao;


import com.wxq.bigworld.clientuser.common.base.BaseRepository;
import com.wxq.bigworld.clientuser.web.entity.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User, String> {
    List<User> findByUsername(String username);
}
