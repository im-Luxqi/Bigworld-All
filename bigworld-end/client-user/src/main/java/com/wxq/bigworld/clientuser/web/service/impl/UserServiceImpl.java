package com.wxq.bigworld.clientuser.web.service.impl;

import com.wxq.bigworld.clientuser.web.Dao.UserAccountRepository;
import com.wxq.bigworld.clientuser.web.entity.UserAccount;
import com.wxq.bigworld.clientuser.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserAccountRepository userAccountRepository;

    /**
     * 账号密码加密
     * @param user
     */
    private void encryptPassword(UserAccount user){
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }

    @Override
    public UserAccount getByUsername(String username) {
        List<UserAccount> userAccounts = userAccountRepository.findByUsername(username);
        return userAccounts==null?null:userAccounts.get(0);
    }

    @Override
    public void save(UserAccount userAccount) {
        encryptPassword(userAccount);
        userAccountRepository.save(userAccount);
    }
}
