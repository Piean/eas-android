package com.yds.educationaladministrationsystem.module.user.model;

import com.yds.educationaladministrationsystem.module.user.presenter.OnUserListener;

/**
 * Created by yds on 2016/4/27.
 */
public interface UserModel {

    //登录
    void login(String name, String pass,OnUserListener onUserLoginListener);
    //查询个人信息
    void querySelfInfo(String userId,OnUserListener onUserLoginListener);
    //修改密码
    void updatePwd(String userId,String defaultPwd,String newPass,OnUserListener onUserLoginListener);
    //修改电话
    void updatePhone(String userId,String mobile,OnUserListener onUserLoginListener);
}
