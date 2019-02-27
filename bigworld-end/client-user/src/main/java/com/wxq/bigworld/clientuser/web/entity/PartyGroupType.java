package com.wxq.bigworld.clientuser.web.entity;

import com.wxq.bigworld.pub.common.BaseEntity;

import javax.persistence.Entity;

/**
 * 组织类型
 */
@Entity
public class PartyGroupType extends BaseEntity {

    private String code;//编码
    private String name;//名称


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
}
