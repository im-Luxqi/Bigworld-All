package com.wxq.bigworld.clientuser.web.entity;

import com.wxq.bigworld.clientuser.common.base.BaseEntity;

import javax.persistence.*;

@Entity
public class Chat extends BaseEntity {
    private String code;
    private String code2;


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }
}