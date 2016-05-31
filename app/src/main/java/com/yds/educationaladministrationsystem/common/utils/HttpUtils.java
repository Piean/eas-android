package com.yds.educationaladministrationsystem.common.utils;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * 采用okhttp
 * created by administrator on 2016/4/25.
 */
public class HttpUtils {

    private static AsyncHttpClient mAsyncHttpClient = new AsyncHttpClient();

    private static RequestHandle mRequestHandle;

    static {

        mAsyncHttpClient.setTimeout(30000);
    }

    private HttpUtils(){

    }

    /**
     *
     *无参数
     */
    public static void post(String url,AsyncHttpResponseHandler handler) {
        post(url,null,null,handler);
    }

    public static void post(String url,Map<String,String> httpParams,AsyncHttpResponseHandler handler) {

        post(url,httpParams,null,handler);
    }

    public static void post(String url,Map<String,String> httpParams, Map<String,String> files, AsyncHttpResponseHandler handler) {

        RequestParams rp = null;
        if(httpParams != null) {
            rp = new RequestParams(httpParams);

            if(files != null) {

                for(String key:files.keySet()) {
                    try {
                        rp.put(key,new File(files.get(key)));
                    }
                    catch (FileNotFoundException e) {
                        Log.e("SONG","HTTPConnection FileNotFoundException " + e);
                    }

                }
            }
        }

        mRequestHandle = mAsyncHttpClient.post(url,rp,handler);
    }



    //GET

    public static void get(String url,AsyncHttpResponseHandler handler) {

        get(url,null,handler);
    }

    public static void get(String url,Map<String,String> params, AsyncHttpResponseHandler handler) {
        RequestParams mRequestParams = null;

        if(params != null) {
            mRequestParams = new RequestParams(params);
        }

        mRequestHandle = mAsyncHttpClient.get(url,mRequestParams,handler);
    }


    public static AsyncHttpClient getClient() {

        return mAsyncHttpClient;
    }

    public static void cancel() {

        if(mRequestHandle != null) {

            mRequestHandle.cancel(true);
        }
    }
}
