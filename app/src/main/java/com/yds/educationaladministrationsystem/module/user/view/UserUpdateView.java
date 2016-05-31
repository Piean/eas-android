package com.yds.educationaladministrationsystem.module.user.view;

import com.yds.educationaladministrationsystem.module.BaseView;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public interface UserUpdateView extends BaseView {

    void updatePhoneSuccess();
    void updatePhoneError();

    void updatePwdSuccess();
    void updatePwdError();
}
