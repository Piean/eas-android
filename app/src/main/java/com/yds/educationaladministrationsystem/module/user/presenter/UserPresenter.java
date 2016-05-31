package com.yds.educationaladministrationsystem.module.user.presenter;

/**
 * Created by yds on 2016/4/27.
 */
public interface UserPresenter {
    //登录
    void login(String name, String pass);
    //修改密码
    void updatePwd(String userId,String defaultPwd,String newPass);
    //查询个人信息
    void querySelfInfo(String userId);
    //修改个人信息
    void updatePhone(String userId,String mobile);
}
