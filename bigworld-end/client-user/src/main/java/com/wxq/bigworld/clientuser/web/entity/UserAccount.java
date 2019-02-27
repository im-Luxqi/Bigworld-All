package com.wxq.bigworld.clientuser.web.entity;

import com.wxq.bigworld.pub.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.List;

/**
 * 用户
 */
@Entity
public class UserAccount extends BaseEntity {
    private String username;
    private String password;
    private String nickname;
    private String birthday;
    private String address;
    private String mobilePhone;
    private String sex;
    private String status;

    private List<PartyGroup> partyGroups;
    private List<String> roleList;//角色列表

    @ManyToMany
    public List<PartyGroup> getPartyGroups() {
        return partyGroups;
    }

    public void setPartyGroups(List<PartyGroup> partyGroups) {
        this.partyGroups = partyGroups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Transient
    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}
