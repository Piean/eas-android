package com.yds.educationaladministrationsystem.module.user.view;

import com.yds.educationaladministrationsystem.module.BaseView;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public interface UserLoginView extends BaseView {

    void loginSuccess();
    void loginError(String error);
}
