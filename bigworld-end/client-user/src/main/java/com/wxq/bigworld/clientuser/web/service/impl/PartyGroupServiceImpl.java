package com.wxq.bigworld.clientuser.web.service.impl;

import com.wxq.bigworld.clientuser.web.Dao.PartyGroupRepository;
import com.wxq.bigworld.clientuser.web.entity.PartyGroup;
import com.wxq.bigworld.clientuser.web.Dao.PartyGroupMapper;
import com.wxq.bigworld.clientuser.web.service.PartyGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PartyGroupServiceImpl implements PartyGroupService {

    @Autowired
    PartyGroupMapper partyGroupMapper;
    @Autowired
    PartyGroupRepository partyGroupRepository;

    @Override
    public String[] getRolesByUsername(String username) {
        Set<String> roles = new HashSet<String>();
        partyGroupMapper.getListByUsername(username)
                .forEach(partyGroup -> roles.add(partyGroup.getCode()));
        return roles.toArray(new String[roles.size()]);
    }

    @Override
    public void save(PartyGroup partyGroup) {
        partyGroupRepository.save(partyGroup);
    }
}
