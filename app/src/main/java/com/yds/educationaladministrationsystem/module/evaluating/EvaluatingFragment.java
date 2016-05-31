package com.yds.educationaladministrationsystem.module.evaluating;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.module.BaseFragment;
import com.yds.educationaladministrationsystem.module.home.view.HomeActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Song on 2016/5/25.
 * Email:songxueliang@huiqu.co
 */
public class EvaluatingFragment extends BaseFragment{

    private View rootView;
    private ListView lvEvaluating;
    private HomeActivity mActivity;
    private ArrayList<HashMap<String, Object>> listItem =
            new ArrayList<>();
    private String[] course = new String[] {
            "软件工程","线性代数","软件测试","软件架构","设计模式","操作系统","音乐欣赏"
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
            rootView = inflater.inflate(R.layout.fragment_evaluating,container,false);
            initView();
            initData();
            setListener();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initView() {
       lvEvaluating = (ListView) rootView.findViewById(R.id.lv_evaluating);
    }

    private void initData() {

        for(int i=0;i<course.length;i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("course", course[i]);
            listItem.add(map);
        }
        SimpleAdapter mSimpleAdapter = new SimpleAdapter(mActivity,listItem,
                R.layout.layout_evaluating,
                new String[]{"course"},
                new int[]{R.id.tv_course});
        lvEvaluating.setAdapter(mSimpleAdapter);
    }

    private void setListener() {
        lvEvaluating.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EventBus.getDefault().post("6");
            }
        });
    }
}
