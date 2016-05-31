package com.yds.educationaladministrationsystem.entity;

import java.io.Serializable;

public class Teacher implements Serializable{

    private String teacherid;
    private String code;
    private String name;
    private String sex;
    private String birthday;
    private String idcard;
    private String protitle;
    private String position;
    private String phone;
    private String mobile;

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherid='" + teacherid + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idcard='" + idcard + '\'' +
                ", protitle='" + protitle + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
