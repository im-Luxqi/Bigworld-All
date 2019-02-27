package com.wxq.bigworld.clientuser.web.service;

import com.wxq.bigworld.clientuser.web.entity.PartyGroup;

public interface PartyGroupService {
    String[] getRolesByUsername(String username);

    void save(PartyGroup partyGroup);
}
