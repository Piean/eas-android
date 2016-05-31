package com.yds.educationaladministrationsystem.module;

import android.support.v4.app.Fragment;
import android.view.View;

import com.yds.educationaladministrationsystem.R;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/4/25.
 */
public class BaseFragment extends Fragment{

    protected void showLoadingDialog(View rootView){
        rootView.findViewById(R.id.lly_loading).setVisibility(View.VISIBLE);
    }

    protected void hideLoadingDialog(View rootView){
        rootView.findViewById(R.id.lly_loading).setVisibility(View.GONE);
    }

	@Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
