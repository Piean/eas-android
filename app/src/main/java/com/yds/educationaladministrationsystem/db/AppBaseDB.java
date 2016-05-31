package com.yds.educationaladministrationsystem.db;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yds.educationaladministrationsystem.MyApplication;
import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.UserConstant;

import java.util.Map;

/**
 * Created by Administrator on 2016/4/27.
 */
public class AppBaseDB extends BaseDB{

    public void post(String url, boolean isLogin,AsyncHttpResponseHandler handler) {
        this.post(url,isLogin,null,handler);
    }

    public void post(String url, boolean isLogin, Map<String,String> params,AsyncHttpResponseHandler handler) {
        this.post(url,isLogin,params,handler);
    }

    public void post(String url, Map<String,String> params,AsyncHttpResponseHandler handler) {
        this.post(url,false,params,null,handler);
    }

    public void post(String url, boolean isLogin, Map<String,String> params,Map<String,String> files,AsyncHttpResponseHandler handler) {
        url = MyApplication.getBaseUrl() + url;
        if(isLogin && params != null) {
            params.put(UserConstant.USER_TOKEN, UserParams.getInstance().getString(UserConstant.USER_TOKEN));
            params.put(UserConstant.USER_ID,UserParams.getInstance().getString(UserConstant.USER_ID));
        }
        super.post(url,params,files,handler);
    }

    public void get(String url,AsyncHttpResponseHandler handler){
        super.get(url,handler);
    }

    public void get(String url,Map<String,String> params, AsyncHttpResponseHandler handler){
        super.get(url,params,handler);
    }
}
