package com.yds.educationaladministrationsystem;

import android.app.Application;

import com.yds.educationaladministrationsystem.config.SystemParams;
import com.yds.educationaladministrationsystem.config.UserParams;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MyApplication extends Application{

    private static MyApplication instance;
    private static final String BASE_URL = "http://localhost:9090/public/index.php/";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        UserParams.init(this);
        SystemParams.init(this);
    }

    public static MyApplication getInstance() {

        return instance;
    }

    public static String getBaseUrl() {

        return BASE_URL;
    }
}
