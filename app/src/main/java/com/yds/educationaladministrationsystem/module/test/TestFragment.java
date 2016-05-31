package com.yds.educationaladministrationsystem.module.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.module.BaseFragment;
import com.yds.educationaladministrationsystem.module.home.view.HomeActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Song on 2016/5/25.
 * Email:songxueliang@huiqu.co
 */
public class TestFragment extends BaseFragment{

    private View rootView;
    private ListView lvTest;
    private HomeActivity mActivity;
    private ArrayList<HashMap<String, Object>> listItem =
            new ArrayList<>();
    private String[] course = new String[] {
      "软件工程","线性代数","软件测试","软件架构","设计模式","体育"
    };

    private String[] time = new String[] {
            "9:30","2:30","17:30","20:00","21:00","22:00"
    };

    private String[] address = new String[] {
            "新教1","世纪楼5B","新教3","新教2","世纪楼1A","世纪楼3A"
    };

    private String[] number = new String[] {
            "10","7","5","3","8","6"
    };

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (HomeActivity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_test,container,false);
            initView();
            initData();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView() {

        lvTest = (ListView) rootView.findViewById(R.id.lv_test);
    }

    private void initData() {

        for(int i=0;i<course.length;i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("course", course[i]);
            map.put("time", time[i]);
            map.put("address", address[i]);
            map.put("num", number[i]);
            listItem.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(mActivity,listItem,R.layout.layout_test,new String[]{"course"
                ,"time", "address","num"},new int[]{R.id.tv_course,
                R.id.tv_time,
                R.id.tv_address,
                R.id.tv_number});
        lvTest.setAdapter(mSimpleAdapter);

    }
}
