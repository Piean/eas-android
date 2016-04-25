package com.yds.educationaladministrationsystem.module;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.common.utils.ValidateUtils;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/4/25.
 */
public abstract class BaseActivity extends FragmentActivity{

    protected Context mContext;
    protected View parentView;
    private RelativeLayout rlContent;
    private TextView tvTitle;
    private TextView tvBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_base);
        initView();
        this.mContext = this;
        parentView = getWindow().getDecorView();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //开启透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    private void initView(){
        rlContent = (RelativeLayout) findViewById(R.id.rl_content);

    }

    protected void setBaseContentView(int layoutId){

//        rlContent.addView();
    }
    protected void setTitle(String title) {

        if(null == tvTitle) {
            tvTitle = (TextView) findViewById(R.id.tv_title);
        }

        if(ValidateUtils.isNotEmptyString(title)) {
            tvTitle.setText(title);
        }

    }


    protected void startActivityByClass(Class<? extends BaseActivity> activityClass) {

        startActivityByClass(activityClass,null);
    }

    protected void startActivityByClass(Class<? extends BaseActivity> activityClass,Bundle bundle) {

        startActivityByClass(activityClass,bundle,0);
    }

    protected void startActivityByClass(Class<? extends BaseActivity> activityClass,Bundle bundle,int flag) {
        Intent mIntent = new Intent();
        mIntent.setClass(this,activityClass);

        if(null != bundle) {
            mIntent.putExtras(bundle);
        }

        if(flag != 0) {
            mIntent.addFlags(flag);
        }
        startActivity(mIntent);

    }
}
