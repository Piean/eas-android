package com.yds.educationaladministrationsystem.db;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yds.educationaladministrationsystem.common.utils.HttpUtils;

import java.util.Map;

/**
 * Created by Administrator on 2016/4/27.
 */
public class BaseDB{

        protected void post(String url,AsyncHttpResponseHandler handler) {

            HttpUtils.post(url, handler);
        }

        protected void post(String url,Map<String,String> params,AsyncHttpResponseHandler handler){
            HttpUtils.post(url,params,handler);
        }

        protected void post(String url,Map<String,String> params,Map<String,String> files,AsyncHttpResponseHandler handler) {

            HttpUtils.post(url,params,files,handler);
        }

        protected void get(String url, AsyncHttpResponseHandler handler) {

            HttpUtils.get(url,handler);
        }

        protected void get(String url, Map<String,String> params, AsyncHttpResponseHandler handler) {

            HttpUtils.get(url,params,handler);
        }
}
