package com.wxq.bigworld.clientuser.web.service.impl;

import com.wxq.bigworld.clientuser.web.Dao.PartyGroupTypeRepository;
import com.wxq.bigworld.clientuser.web.entity.PartyGroupType;
import com.wxq.bigworld.clientuser.web.service.PartyGroupTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyGroupTypeServiceImpl implements PartyGroupTypeService {

    @Autowired
    PartyGroupTypeRepository partyGroupTypeRepository;

    @Override
    public void save(PartyGroupType partyGroupType) {
        partyGroupTypeRepository.save(partyGroupType);
    }
}
