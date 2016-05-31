package com.yds.educationaladministrationsystem.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.yds.educationaladministrationsystem.constant.AppConstant;

/**
 * Created by Administrator on 2016/4/26.
 */
public class UserParams  {

    private static SharedPreferences mSharedPreferences;
    private static UserParams mUserParams;

    private UserParams(){

    }

    /**
     * 在Application中初始化
     * @param context
     */
    public static void init(Context context) {

        mSharedPreferences = context.getSharedPreferences(AppConstant.SHAREDPREFERENCES_USER,Context.MODE_PRIVATE);
    }

    public static UserParams getInstance() {

        if(mUserParams == null) {
            synchronized (UserParams.class) {
                if(mUserParams == null) {

                    mUserParams = new UserParams();
                }
            }
        }
        return mUserParams;
    }


    public void setBoolean(String key,boolean value) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.commit();
    }

    public void setString(String key,String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key,String value) {
        return mSharedPreferences.getString(key,value);
    }

    public String getString(String key) {
        return mSharedPreferences.getString(key,null);
    }

    public boolean getBoolean(String key, boolean value) {
        return mSharedPreferences.getBoolean(key, value);
    }

    public void setInt(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public int getInt(String key, int defValue) {

        return mSharedPreferences.getInt(key,defValue);
    }
}
