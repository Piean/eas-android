package com.yds.educationaladministrationsystem.module.home.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.*;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.yds.educationaladministrationsystem.R;
import com.yds.educationaladministrationsystem.config.UserParams;
import com.yds.educationaladministrationsystem.constant.UserConstant;
import com.yds.educationaladministrationsystem.module.BaseActivity;
import com.yds.educationaladministrationsystem.module.course.CourseFragment;
import com.yds.educationaladministrationsystem.module.evaluating.EvaluatingFragment;
import com.yds.educationaladministrationsystem.module.evaluatingcontent.SuggestFragment;
import com.yds.educationaladministrationsystem.module.score.ScoreFragment;
import com.yds.educationaladministrationsystem.module.select.SelectFragment;
import com.yds.educationaladministrationsystem.module.test.TestFragment;
import com.yds.educationaladministrationsystem.module.user.view.UpdateFragment;
import com.yds.educationaladministrationsystem.module.user.view.UserInfoFragment;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2016/4/25.
 */
public class HomeActivity extends BaseActivity {

    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.fl_content)
    FrameLayout flContent;
    @Bind(R.id.lly_browse)
    LinearLayout llyBrowse;
    @Bind(R.id.lly_update)
    LinearLayout llyUpdate;
    @Bind(R.id.lly_course)
    LinearLayout llyCourse;
    @Bind(R.id.lly_jselect)
    LinearLayout llyJselect;
    @Bind(R.id.lly_eselect)
    LinearLayout llyEselect;
    @Bind(R.id.lly_repair)
    LinearLayout llyRepair;
    @Bind(R.id.lly_score_browse)
    LinearLayout llyScoreBrowse;
    @Bind(R.id.lly_score_manage)
    LinearLayout llyScoreManage;
    @Bind(R.id.lly_exam_browse)
    LinearLayout llyExamBrowse;
    @Bind(R.id.lly_online)
    LinearLayout llyOnline;
    @Bind(R.id.lly_result)
    LinearLayout llyResult;
    @Bind(R.id.btn_exit)
    Button btnExit;
    @Bind(R.id.left_drawer)
    ScrollView leftDrawer;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private Fragment mContent;
    private Fragment[] mFragments;
    private int currentFragmentIndex = 0;
    private FragmentManager mFragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();
        initViews();
        initData();
        EventBus.getDefault().register(this);
    }

    private void initViews() {

        int level = UserParams.getInstance().getInt(UserConstant.USER_LEVEL,0);
//        if(level == AppConstant.LEVEL_TEACHER) {
//            llyJselect.setVisibility(View.GONE);
//            llyEselect.setVisibility(View.GONE);
//            llyRepair.setVisibility(View.GONE);
//            llyOnline.setVisibility(View.GONE);
//        }
//
//        if(level == AppConstant.LEVEL_STUDENT) {
//
//            llyScoreManage.setVisibility(View.GONE);
//            llyResult.setVisibility(View.GONE);
//        }

    }

    private void initData() {
        //根据身份来new出需要的Fragment
        mFragments = new Fragment[10];
        mFragments[0] = new UpdateFragment();
        mFragments[1] = new UserInfoFragment();
        mFragments[2] = new CourseFragment();
        mFragments[3] = new SelectFragment();
        mFragments[4] = new TestFragment();
        mFragments[5] = new EvaluatingFragment();
        mFragments[6] = new SuggestFragment();
        mFragments[7] = new ScoreFragment();
        setTitle("课程表-{第15周}");
        switchFragment(mFragments[currentFragmentIndex], mFragments[2]);
        drawerLayout.closeDrawers();
        currentFragmentIndex = 2;
    }

    /**
     * 切换Fragment
     * @param from:从哪个Fragment切换
     * @param to:切换到目标Fragment
     */
    private void switchFragment(Fragment from, Fragment to) {

        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        //.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);

        if (null == mContent) {
            mContent = to;
            mFragmentTransaction.add(R.id.fl_content, to).commitAllowingStateLoss();
        } else if (mContent != to) {
            mContent = to;
            // 先判断是否被add过
            if (!to.isAdded()) {
                // 隐藏当前的fragment，add下一个到Activity中
                mFragmentTransaction.hide(from).add(R.id.fl_content, to).commit();
            } else {
                // 隐藏当前的fragment，显示下一个
                mFragmentTransaction.hide(from).show(to).commit();
            }
        }
    }

    @OnClick({R.id.lly_browse, R.id.lly_update, R.id.lly_course, R.id.lly_jselect, R.id.lly_eselect, R.id.lly_repair, R.id.lly_score_browse, R.id.lly_score_manage, R.id.lly_exam_browse, R.id.lly_online, R.id.lly_result, R.id.btn_exit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lly_browse:
                switchFragment(mFragments[currentFragmentIndex], mFragments[1]);
                drawerLayout.closeDrawers();
                setTitle("个人信息");
                currentFragmentIndex = 1;
                break;
            case R.id.lly_update:
                switchFragment(mFragments[currentFragmentIndex], mFragments[0]);
                drawerLayout.closeDrawers();
                setTitle("信息修改");
                currentFragmentIndex = 0;
                break;
            case R.id.lly_course:
                setTitle("课程表-{第15周}");
                switchFragment(mFragments[currentFragmentIndex], mFragments[2]);
                drawerLayout.closeDrawers();
                currentFragmentIndex = 2;
                break;
            case R.id.lly_jselect:
                setTitle("正选");
                switchFragment(mFragments[currentFragmentIndex], mFragments[3]);
                drawerLayout.closeDrawers();
                currentFragmentIndex = 3;
                break;
            case R.id.lly_eselect:
                break;
            case R.id.lly_repair:
                break;
            case R.id.lly_score_browse:
                setTitle("成绩查看");
                switchFragment(mFragments[currentFragmentIndex], mFragments[7]);
                drawerLayout.closeDrawers();
                currentFragmentIndex = 7;
                break;
            case R.id.lly_score_manage:
                break;
            case R.id.lly_exam_browse:
                setTitle("考试信息");
                switchFragment(mFragments[currentFragmentIndex], mFragments[4]);
                drawerLayout.closeDrawers();
                currentFragmentIndex = 4;
                break;
            case R.id.lly_online:
                setTitle("在线评教");
                switchFragment(mFragments[currentFragmentIndex], mFragments[5]);
                drawerLayout.closeDrawers();
                currentFragmentIndex = 5;
                break;
            case R.id.lly_result:
                break;
            case R.id.btn_exit:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void skipFragment(String fragmentNumber) {

        switchFragment(mFragments[currentFragmentIndex], mFragments[Integer.parseInt(fragmentNumber)]);
        drawerLayout.closeDrawers();
        currentFragmentIndex = Integer.parseInt(fragmentNumber);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
