package com.wxq.bigworld.clientuser.web.entity;

import com.wxq.bigworld.pub.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 组织架构管理
 */
@Entity
public class PartyGroup extends BaseEntity {
    private String code;//编码
    private String name;//名称
    private PartyGroup parent;
    private String path;
    private PartyGroupType partyGroupType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public PartyGroup getParent() {
        return parent;
    }

    public void setParent(PartyGroup parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @ManyToOne
    public PartyGroupType getPartyGroupType() {
        return partyGroupType;
    }

    public void setPartyGroupType(PartyGroupType partyGroupType) {
        this.partyGroupType = partyGroupType;
    }
}
