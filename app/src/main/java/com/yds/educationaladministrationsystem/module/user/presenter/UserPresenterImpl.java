package com.yds.educationaladministrationsystem.module.user.presenter;

import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.UserConstant;
import com.yds.educationaladministrationsystem.entity.Student;
import com.yds.educationaladministrationsystem.entity.Teacher;
import com.yds.educationaladministrationsystem.entity.User;
import com.yds.educationaladministrationsystem.module.user.model.UserModel;
import com.yds.educationaladministrationsystem.module.user.model.UserModelImpl;
import com.yds.educationaladministrationsystem.module.user.view.QueryInfoView;
import com.yds.educationaladministrationsystem.module.user.view.UserLoginView;
import com.yds.educationaladministrationsystem.module.user.view.UserUpdateView;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public class UserPresenterImpl implements UserPresenter,OnUserListener {

    private UserModel userModel;
    private UserLoginView loginView;
    private UserUpdateView userUpdateView;
    private QueryInfoView queryInfoView;

    public UserPresenterImpl(UserLoginView loginView) {

        this.loginView = loginView;
        userModel = new UserModelImpl();
    }

    public UserPresenterImpl(QueryInfoView queryInfoView) {

        this.queryInfoView = queryInfoView;
        userModel = new UserModelImpl();
    }

    public UserPresenterImpl(UserUpdateView userUpdateView) {

        this.userUpdateView = userUpdateView;
        userModel = new UserModelImpl();
    }

    @Override
    public void login(String name, String pass) {

        loginView.showLoading();
        userModel.login(name,pass,this);
    }

    @Override
    public void updatePwd(String userId,String defaultPwd, String newPass) {
        userUpdateView.showLoading();
        userModel.updatePwd(userId,defaultPwd,newPass,this);
    }

    @Override
    public void querySelfInfo(String userId) {
        queryInfoView.showLoading();
        userModel.querySelfInfo(userId,this);
    }

    @Override
    public void updatePhone(String userId, String mobile) {

        userUpdateView.showLoading();
        userModel.updatePhone(userId, mobile, this);
    }

    @Override
    public void loginSuccess(User user) {
        loginView.hideLoading();
        loginView.loginSuccess();
        //保存用户信息
        saveUserInfo(user);
    }

    @Override
    public void loginError(String error) {
        loginView.hideLoading();
        loginView.loginError(error);
    }

    @Override
    public void updatePhoneSuccess() {

        userUpdateView.hideLoading();
        userUpdateView.updatePhoneSuccess();
    }

    @Override
    public void updatePhoneError() {

        userUpdateView.hideLoading();
        userUpdateView.updatePhoneError();
    }

    @Override
    public void updatePwdSuccess() {
        userUpdateView.hideLoading();
        userUpdateView.updatePwdSuccess();
    }

    @Override
    public void updatePwdError() {
        userUpdateView.hideLoading();
        userUpdateView.updatePwdError();
    }

    @Override
    public void queryStudentInfoSuccess(Student student) {
        queryInfoView.hideLoading();
        queryInfoView.queryStudentSuccess(student);
    }

    @Override
    public void queryTeacherInfoSuccess(Teacher teacher) {
        queryInfoView.hideLoading();
        queryInfoView.queryTeacherSuccess(teacher);
    }

    @Override
    public void queryInfoError() {
        queryInfoView.hideLoading();
        queryInfoView.queryError();
    }

    /**
     * save userinfo
     * @param user
     */
    private void saveUserInfo(User user) {

        UserParams.getInstance().setString(UserConstant.USER_ID,user.getUserid());
        UserParams.getInstance().setString(UserConstant.USER_NAME,user.getUsername());
        UserParams.getInstance().setInt(UserConstant.USER_LEVEL, user.getLevel());
    }
}
