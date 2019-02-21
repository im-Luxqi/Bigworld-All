package com.wxq.bigworld.clientuser.web.entity;

import com.wxq.bigworld.clientuser.common.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class City extends BaseEntity {

    private Integer provinceId;
    private String cityName;
    private String description;

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}