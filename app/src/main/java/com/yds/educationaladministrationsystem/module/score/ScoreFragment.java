package com.yds.educationaladministrationsystem.module.score;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.common.views.ListViewForScrollView;
import com.yds.educationaladministrationsystem.module.BaseFragment;
import com.yds.educationaladministrationsystem.module.home.view.HomeActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Song on 2016/5/25.
 * Email:songxueliang@huiqu.co
 */
public class ScoreFragment extends BaseFragment{

    private View rootView;
    private ListView lvScore;
    private HomeActivity mActivity;
    private ArrayList<HashMap<String, Object>> listItem =
            new ArrayList<>();
    private String[] course = new String[] {
            "软件工程","线性代数","软件测试","软件架构","设计模式","操作系统","音乐欣赏"
    };
    private String[] uscore = new String[] {
            "82","80","85","89","90","76","88"
    };
    private String[] score = new String[] {
            "81","67","65","76","80","80","93"
    };
    private String[] rscore = new String[] {
            "81","71","71","80","83","79","90.5"
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
            rootView = inflater.inflate(R.layout.fragment_score,container,false);
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
        lvScore = (ListViewForScrollView) rootView.findViewById(R.id.lv_score);
    }

    private void initData() {

        for(int i=0;i<course.length;i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("course", course[i]);
            map.put("uscore", uscore[i]);
            map.put("score", score[i]);
            map.put("rscore", rscore[i]);
            listItem.add(map);
        }

        SimpleAdapter mSimpleAdapter = new SimpleAdapter(mActivity,listItem,
                R.layout.layout_rank,
                new String[]{"course","uscore","score","rscore"},
                new int[]{R.id.tv_course,
                        R.id.tv_uscore,
                        R.id.tv_score,
                        R.id.tv_rscore});

        lvScore.setAdapter(mSimpleAdapter);
    }

}
