package com.yds.educationaladministrationsystem.module.user.view;

import com.yds.educationaladministrationsystem.entity.Student;
import com.yds.educationaladministrationsystem.entity.Teacher;
import com.yds.educationaladministrationsystem.module.BaseView;

/**
 * Created by Song on 2016/4/28.
 * Email:songxueliang@huiqu.co
 */
public interface QueryInfoView extends BaseView{

    void queryStudentSuccess(Student student);
    void queryTeacherSuccess(Teacher teacher);
    void queryError();
}
