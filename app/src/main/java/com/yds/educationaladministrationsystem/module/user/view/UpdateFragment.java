package com.yds.educationaladministrationsystem.module.user.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.common.utils.ValidateUtils;
import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.UserConstant;
import com.yds.educationaladministrationsystem.module.BaseFragment;
import com.yds.educationaladministrationsystem.module.home.view.HomeActivity;
import com.yds.educationaladministrationsystem.module.user.presenter.UserPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public class UpdateFragment extends BaseFragment implements UserUpdateView {

    @Bind(R.id.et_phone)
    EditText etPhone;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.btn_update)
    Button btnUpdate;
    @Bind(R.id.rb_phone)
    RadioButton rbPhone;
    @Bind(R.id.rb_pwd)
    RadioButton rbPwd;
    @Bind(R.id.rg_list)
    RadioGroup rgList;
    @Bind(R.id.et_defaultpwd)
    EditText etDefaultpwd;
    @Bind(R.id.et_comfirepwd)
    EditText etComfirepwd;
    private HomeActivity mHomeActivity;
    private View rootView;
    private int check = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mHomeActivity = (HomeActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_update, container, false);
            initView();
            setListener();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {

                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    private void setListener() {

        rgList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_phone:
                        etPhone.setEnabled(true);
                        etPwd.setEnabled(false);
                        etDefaultpwd.setEnabled(false);
                        etComfirepwd.setEnabled(false);
                        etPhone.setFocusable(true);
                        etPhone.requestFocus();
                        check = 1;
                        break;
                    case R.id.rb_pwd:
                        etPhone.setEnabled(false);
                        etPwd.setEnabled(true);
                        etPwd.setFocusable(true);
                        etDefaultpwd.setEnabled(true);
                        etComfirepwd.setEnabled(true);
                        etPwd.requestFocus();
                        check = 2;
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initView() {
        ButterKnife.bind(this, rootView);
        etPhone.setFocusable(true);
        etPhone.requestFocus();
        etPwd.setEnabled(false);
        etDefaultpwd.setEnabled(false);
        etComfirepwd.setEnabled(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_update)
    public void onClick() {

        String phone = etPhone.getText().toString();
        String pwd = etPwd.getText().toString();
        String defaultPwd = etDefaultpwd.getText().toString();

        if (ValidateUtils.isEmptyString(phone) && ValidateUtils.isEmptyString(pwd)) {
            mHomeActivity.showShortToast("请填写手机号或密码");

        }

        if (check == 1) {
            if (ValidateUtils.isNotEmptyString(phone)) {
                //修改手机号
                new UserPresenterImpl(this).updatePhone(UserParams.getInstance().getString(UserConstant.USER_ID), phone);
            } else {
                mHomeActivity.showShortToast("请填写手机号");
            }
        }

        if (check == 2) {
            if (ValidateUtils.isNotEmptyString(pwd) && ValidateUtils.isNotEmptyString(defaultPwd)) {
                //修改密码
                new UserPresenterImpl(this).updatePwd(UserParams.getInstance().getString(UserConstant.USER_ID), defaultPwd, pwd);
            } else {
                mHomeActivity.showShortToast("请填写原密码或新密码");
            }
        }
    }

    @Override
    public void updatePhoneSuccess() {

        mHomeActivity.showShortToast("手机号修改成功");
    }

    @Override
    public void updatePhoneError() {
        mHomeActivity.showShortToast("手机号修改失败");
    }

    @Override
    public void updatePwdSuccess() {
        mHomeActivity.showShortToast("密码修改成功");
    }

    @Override
    public void updatePwdError() {
        mHomeActivity.showShortToast("密码修改成功");
    }

    @Override
    public void showLoading() {

        showLoadingDialog(rootView);
    }

    @Override
    public void hideLoading() {

        hideLoadingDialog(rootView);
    }
}
