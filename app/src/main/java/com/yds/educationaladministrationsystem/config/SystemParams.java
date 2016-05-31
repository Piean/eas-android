package com.yds.educationaladministrationsystem.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.yds.educationaladministrationsystem.constant.AppConstant;

/**
 * Created by Administrator on 2016/4/26.
 */
public class SystemParams {

    private static SharedPreferences mSharedPreferences;

    private static SystemParams mSystemParams;

    private SystemParams(){}


    public static void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(AppConstant.SHAREDPREFERENCES_SYSTEM,Context.MODE_PRIVATE);
    }

    public static SystemParams getInstance(){

        if(mSystemParams == null) {

            synchronized (SystemParams.class) {
                if(mSystemParams == null) {

                    mSystemParams = new SystemParams();
                }
            }
        }

        return mSystemParams;
    }

    public void setString(String key, String value) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String value) {

        return mSharedPreferences.getString(key, value);
    }

    public void setBoolean(String key, boolean value) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public Boolean getBoolean(String key, boolean value) {

        return mSharedPreferences.getBoolean(key, value);
    }
}
