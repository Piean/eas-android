package com.yds.educationaladministrationsystem.module.user.model;

import com.loopj.android.http.TextHttpResponseHandler;
import com.yds.educationaladministrationsystem.common.utils.JsonUtils;
import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.AppConstant;
import com.yds.educationaladministrationsystem.constant.UserConstant;
import com.yds.educationaladministrationsystem.db.AppBaseDB;
import com.yds.educationaladministrationsystem.entity.json.JsonBase;
import com.yds.educationaladministrationsystem.entity.json.StudentJson;
import com.yds.educationaladministrationsystem.entity.json.TeacherJson;
import com.yds.educationaladministrationsystem.entity.json.UserJson;
import com.yds.educationaladministrationsystem.module.user.presenter.OnUserListener;

import org.apache.http.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public class UserModelImpl extends AppBaseDB implements UserModel {

    @Override
    public void login(String name, String pass, final OnUserListener onUserLoginListener) {

        Map<String,String> params = new HashMap<>();
        params.put("name",name);
        params.put("pass",pass);
        post("user/login", params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                UserJson userJson = JsonUtils.jsonToObject(s,UserJson.class);
                if(userJson.status) {
                    onUserLoginListener.loginSuccess(userJson.result);
                } else {
                    onUserLoginListener.loginError(userJson.message);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                onUserLoginListener.loginError("登录失败");
            }
        });
    }

    @Override
    public void updatePwd(String userId,String defaultPwd, String newPass, final OnUserListener onUserLoginListener) {

        Map<String,String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("oldPass",defaultPwd);
        params.put("newPass",newPass);

        post("user/change_pass", params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                JsonBase jsonBase = JsonUtils.jsonToObject(s, JsonBase.class);
                if(jsonBase.status) {
                    onUserLoginListener.updatePwdSuccess();
                } else {
                    onUserLoginListener.updatePwdError();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                onUserLoginListener.updatePwdError();
            }
        });
    }

    @Override
    public void querySelfInfo(String userId, final OnUserListener onUserLoginListener) {


        Map<String,String> params = new HashMap<>();
        params.put("userId",userId);
        post("user/query_info", params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, String s) {

                if(UserParams.getInstance().getInt(UserConstant.USER_LEVEL,0) == AppConstant.LEVEL_STUDENT) {
                    StudentJson studentJson = JsonUtils.jsonToObject(s, StudentJson.class);
                    onUserLoginListener.queryStudentInfoSuccess(studentJson.result);
                } else if(UserParams.getInstance().getInt(UserConstant.USER_LEVEL,0) == AppConstant.LEVEL_TEACHER) {
                    TeacherJson teacherJson = JsonUtils.jsonToObject(s, TeacherJson.class);
                    onUserLoginListener.queryTeacherInfoSuccess(teacherJson.result);
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                onUserLoginListener.queryInfoError();
            }
        });
    }

    @Override
    public void updatePhone(String userId, String mobile, final OnUserListener onUserLoginListener) {


        Map<String,String> params = new HashMap<>();
        params.put("userId",userId);
        params.put("mobile", mobile);
        post("user/change_info", params, new TextHttpResponseHandler() {

            @Override
            public void onSuccess(int i, Header[] headers, String s) {
                JsonBase jsonBase = JsonUtils.jsonToObject(s, JsonBase.class);
                if (jsonBase.status) {
                    onUserLoginListener.updatePhoneSuccess();
                } else {
                    onUserLoginListener.updatePhoneError();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, String s, Throwable throwable) {
                onUserLoginListener.updatePhoneError();
            }

        });
    }
}
