package com.yds.educationaladministrationsystem.module.evaluatingcontent;

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

/**
 * Created by Song on 2016/5/25.
 * Email:songxueliang@huiqu.co
 */
public class SuggestFragment extends BaseFragment{

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_content,container,false);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if(parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

}
