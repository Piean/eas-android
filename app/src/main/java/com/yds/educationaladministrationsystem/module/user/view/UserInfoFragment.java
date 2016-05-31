package com.yds.educationaladministrationsystem.module.user.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.common.views.CircleImageView;
import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.AppConstant;
import com.yds.educationaladministrationsystem.constant.UserConstant;
import com.yds.educationaladministrationsystem.entity.Student;
import com.yds.educationaladministrationsystem.entity.Teacher;
import com.yds.educationaladministrationsystem.module.BaseFragment;
import com.yds.educationaladministrationsystem.module.home.view.HomeActivity;
import com.yds.educationaladministrationsystem.module.user.presenter.UserPresenterImpl;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public class UserInfoFragment extends BaseFragment implements QueryInfoView {

    @Bind(R.id.tv_id)
    TextView tvId;
    @Bind(R.id.lly_id)
    LinearLayout llyId;
    @Bind(R.id.tv_code)
    TextView tvCode;
    @Bind(R.id.lly_code)
    LinearLayout llyCode;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.lly_name)
    LinearLayout llyName;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.lly_sex)
    LinearLayout llySex;
    @Bind(R.id.tv_nation)
    TextView tvNation;
    @Bind(R.id.lly_nation)
    LinearLayout llyNation;
    @Bind(R.id.tv_birthday)
    TextView tvBirthday;
    @Bind(R.id.lly_birthday)
    LinearLayout llyBirthday;
    @Bind(R.id.tv_address)
    TextView tvAddress;
    @Bind(R.id.lly_address)
    LinearLayout llyAddress;
    @Bind(R.id.cv_head)
    CircleImageView cvHead;
    @Bind(R.id.lly_head)
    LinearLayout llyHead;
    @Bind(R.id.tv_place)
    TextView tvPlace;
    @Bind(R.id.lly_place)
    LinearLayout llyPlace;
    @Bind(R.id.tv_origin)
    TextView tvOrigin;
    @Bind(R.id.lly_origin)
    LinearLayout llyOrigin;
    @Bind(R.id.tv_politicalstatus)
    TextView tvPoliticalstatus;
    @Bind(R.id.lly_politicalstatus)
    LinearLayout llyPoliticalstatus;
    @Bind(R.id.tv_enterdate)
    TextView tvEnterdate;
    @Bind(R.id.lly_enterdate)
    LinearLayout llyEnterdate;
    @Bind(R.id.tv_major)
    TextView tvMajor;
    @Bind(R.id.lly_major)
    LinearLayout llyMajor;
    @Bind(R.id.tv_schoollength)
    TextView tvSchoollength;
    @Bind(R.id.lly_schoollength)
    LinearLayout llySchoollength;
    @Bind(R.id.tv_learnmode)
    TextView tvLearnmode;
    @Bind(R.id.lly_learnmode)
    LinearLayout llyLearnmode;
    @Bind(R.id.tv_trainmode)
    TextView tvTrainmode;
    @Bind(R.id.lly_trainmode)
    LinearLayout llyTrainmode;
    @Bind(R.id.tv_mobile)
    TextView tvMobile;
    @Bind(R.id.lly_mobile)
    LinearLayout llyMobile;
    @Bind(R.id.tv_protitle)
    TextView tvProtitle;
    @Bind(R.id.lly_protitle)
    LinearLayout llyProtitle;
    @Bind(R.id.tv_position)
    TextView tvPosition;
    @Bind(R.id.lly_position)
    LinearLayout llyPosition;
    @Bind(R.id.v_head)
    View vHead;
    @Bind(R.id.v_sex)
    View vSex;
    @Bind(R.id.v_nation)
    View vNation;
    @Bind(R.id.v_birthday)
    View vBirthday;
    @Bind(R.id.v_address)
    View vAddress;
    @Bind(R.id.v_place)
    View vPlace;
    @Bind(R.id.v_origin)
    View vOrigin;
    @Bind(R.id.v_politicalstatus)
    View vPoliticalstatus;
    @Bind(R.id.v_enterdate)
    View vEnterdate;
    @Bind(R.id.v_major)
    View vMajor;
    @Bind(R.id.v_schoollength)
    View vSchoollength;
    @Bind(R.id.v_learnmode)
    View vLearnmode;
    @Bind(R.id.v_trainmode)
    View vTrainmode;
    @Bind(R.id.v_mobile)
    View vMobile;
    @Bind(R.id.v_protitle)
    View vProtitle;
    @Bind(R.id.lly_loading)
    LinearLayout llyLoading;
    private View rootView;
    private HomeActivity mHomeActivity;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mHomeActivity = (HomeActivity) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_selfinfo, container, false);
            initView();
            initData();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {

                parent.removeView(rootView);
            }
        }
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initData() {

        new UserPresenterImpl(this).querySelfInfo(UserParams.getInstance().getString(UserConstant.USER_ID));
    }

    private void initView() {
        ButterKnife.bind(this, rootView);

        if (UserParams.getInstance().getInt(UserConstant.USER_LEVEL, 0) == AppConstant.LEVEL_STUDENT) {

            llyProtitle.setVisibility(View.GONE);
            llyPosition.setVisibility(View.GONE);
            vProtitle.setVisibility(View.GONE);

        } else if (UserParams.getInstance().getInt(UserConstant.USER_LEVEL, 0) == AppConstant.LEVEL_TEACHER) {

            llyNation.setVisibility(View.GONE);
            vNation.setVisibility(View.GONE);
            llyAddress.setVisibility(View.GONE);
            vAddress.setVisibility(View.GONE);
            llyTrainmode.setVisibility(View.GONE);
            vTrainmode.setVisibility(View.GONE);
            llyLearnmode.setVisibility(View.GONE);
            vLearnmode.setVisibility(View.GONE);
            llySchoollength.setVisibility(View.GONE);
            vSchoollength.setVisibility(View.GONE);
            llyEnterdate.setVisibility(View.GONE);
            vEnterdate.setVisibility(View.GONE);
            llyPoliticalstatus.setVisibility(View.GONE);
            vPoliticalstatus.setVisibility(View.GONE);
            llyOrigin.setVisibility(View.GONE);
            vOrigin.setVisibility(View.GONE);
            llyHead.setVisibility(View.GONE);
            vHead.setVisibility(View.GONE);
            llyPlace.setVisibility(View.GONE);
            vPlace.setVisibility(View.GONE);
            llyMajor.setVisibility(View.GONE);
            vMajor.setVisibility(View.GONE);
        }
    }

    @Override
    public void queryStudentSuccess(Student student) {

        tvId.setText(student.studentid);
        tvCode.setText(student.code);
        tvName.setText(student.name);
        tvSex.setText(student.sex);
        tvNation.setText(student.nation);
        tvBirthday.setText(student.birthday);
        tvAddress.setText(student.address);
        tvPlace.setText(student.nativeplace);
        tvOrigin.setText(student.origin);
        tvPoliticalstatus.setText(student.politicalstatus);
        tvEnterdate.setText(student.enterdate);
        tvMajor.setText(student.major);
        tvSchoollength.setText(student.schoollength + "");
        tvLearnmode.setText(student.learnmode);
        tvTrainmode.setText(student.trainmode);
        tvMobile.setText(student.mobile);
    }

    @Override
    public void queryTeacherSuccess(Teacher teacher) {

        tvId.setText(teacher.teacherid);
        tvCode.setText(teacher.code);
        tvName.setText(teacher.name);
        tvSex.setText(teacher.sex);
        tvBirthday.setText(teacher.birthday);
        tvProtitle.setText(teacher.protitle);
        tvPosition.setText(teacher.position);
        tvMobile.setText(teacher.mobile);
    }

    @Override
    public void queryError() {
        mHomeActivity.showShortToast("查询失败");
    }

    @Override
    public void showLoading() {
        showLoadingDialog(rootView);
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog(rootView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
