package com.yds.educationaladministrationsystem.module.user.presenter;

import com.yds.educationaladministrationsystem.entity.Student;
import com.yds.educationaladministrationsystem.entity.Teacher;
import com.yds.educationaladministrationsystem.entity.User;

/**
 * Created by Administrator on 2016/4/27.
 */
public interface OnUserListener {

    void loginSuccess(User user);
    void loginError(String error);

    void updatePhoneSuccess();
    void updatePhoneError();

    void updatePwdSuccess();
    void updatePwdError();

    void queryStudentInfoSuccess(Student student);

    void queryTeacherInfoSuccess(Teacher teacher);
    void queryInfoError();

}
