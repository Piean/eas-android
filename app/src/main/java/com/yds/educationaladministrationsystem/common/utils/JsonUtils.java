package com.yds.educationaladministrationsystem.common.utils;

import android.util.Log;

import com.google.gson.Gson;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public class JsonUtils {

    public static  <T> T jsonToObject (String jsonStr, Class<T> clazz){

        if(ValidateUtils.isNotEmptyString(jsonStr)) {
            T t = null;
            try{
                t = new Gson().fromJson(jsonStr,clazz);
            }catch(Exception e){
                Log.e("ERROR","jsonToObject is error!");
            }
            return t;
        }

        return null;
    }

    public static <T> String objectToJsonStr(T clazz) {

        String jsonStr = new Gson().toJson(clazz);
        return jsonStr;
    }
}
