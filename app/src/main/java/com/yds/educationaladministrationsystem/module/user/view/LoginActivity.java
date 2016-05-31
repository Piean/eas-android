package com.yds.educationaladministrationsystem.module.user.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.common.utils.ValidateUtils;
import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.UserConstant;
import com.yds.educationaladministrationsystem.module.BaseActivity;
import com.yds.educationaladministrationsystem.module.home.view.HomeActivity;
import com.yds.educationaladministrationsystem.module.user.presenter.UserPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements UserLoginView {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.cb_save)
    CheckBox cbSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBaseContentView(R.layout.activity_login);
        hideBackBtn();
        setTitle("登录");
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        //登录
        String userName = etUsername.getText().toString();
        String userPwd = etPwd.getText().toString();
        UserParams.getInstance().setInt(UserConstant.USER_LEVEL,2);
        startActivityByClass(HomeActivity.class);
        if (ValidateUtils.isEmptyString(userName) || ValidateUtils.isEmptyString(userPwd)) {
            showShortToast("用户名和密码不能为空");
            return;
        }

        if (cbSave.isChecked()) {
            showShortToast("保存用户名和密码");
        }
        new UserPresenterImpl(this).login(userName, userPwd);
    }

    @Override
    public void loginSuccess() {

        showShortToast("登录成功");
        startActivityByClass(HomeActivity.class);
        finish();
    }

    @Override
    public void loginError(String error) {
        showShortToast(error);
    }

    @Override
    public void showLoading() {

        showLoadingDialog();
    }

    @Override
    public void hideLoading() {

        hideLoadingDialog();
    }
}
