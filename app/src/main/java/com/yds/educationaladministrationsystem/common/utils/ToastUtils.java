package com.yds.educationaladministrationsystem.common.utils;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.yds.educationaladministrationsystem.MyApplication;

/**
 *
 * @Description:Toast工具类
 * @author song
 * @date 2015年11月4日
 */
public class ToastUtils {

    private ToastUtils(){
		/* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static Toast mToast = null;

    /**
     * Toast
     */
    private static Handler mHandler = new Handler(Looper.getMainLooper()){
        public void handleMessage(android.os.Message msg) {
            if(null != mToast){
                mToast.cancel();
            }
            String message =  (String)msg.obj;
            int duration = msg.arg2;
            mToast = Toast.makeText(MyApplication.getInstance(), message, Toast.LENGTH_LONG);
            mToast.show();
        };
    };

    public static void showShortToast(String message){
        showToast(message,Toast.LENGTH_SHORT);
    }

    public static void showShortToast(int resId){
        showToast(MyApplication.getInstance().getString(resId),Toast.LENGTH_SHORT);
    }

    public static void showLongToast(String message){
        showToast(message,Toast.LENGTH_LONG);
    }

    public static void showLongToast(int resId){
        showToast(MyApplication.getInstance().getString(resId),Toast.LENGTH_LONG);
    }

    private static void showToast(String message,int duration){
        mHandler.sendMessage(mHandler.obtainMessage(0,0,duration,message));
    }

}
