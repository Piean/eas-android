package com.yds.educationaladministrationsystem.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private String studentid;
    private String userid;
    private String code;
    private String name;
    private String sex;
    private String nation;
    private String birthday;
    private String idcard;
    private String address;
    private String picture;
    private String nativeplace;
    private String origin;
    private String politicalstatus;
    private String enterdate;
    private String major;
    private int schoollength;
    private String learnmode;
    private String trainmode;
    private String mobile;

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", userid='" + userid + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday='" + birthday + '\'' +
                ", idcard='" + idcard + '\'' +
                ", address='" + address + '\'' +
                ", picture='" + picture + '\'' +
                ", nativeplace='" + nativeplace + '\'' +
                ", origin='" + origin + '\'' +
                ", politicalstatus='" + politicalstatus + '\'' +
                ", enterdate='" + enterdate + '\'' +
                ", major='" + major + '\'' +
                ", schoollength=" + schoollength +
                ", learnmode='" + learnmode + '\'' +
                ", trainmode='" + trainmode + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
