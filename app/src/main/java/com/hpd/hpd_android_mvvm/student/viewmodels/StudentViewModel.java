package com.hpd.hpd_android_mvvm.student.viewmodels;

import com.hpd.hpd_android_mvvm.mvvm_base.BaseViewModel;
import com.hpd.hpd_android_mvvm.student.models.StudentBean;

import java.util.ArrayList;

import io.reactivex.subjects.BehaviorSubject;

public class StudentViewModel extends BaseViewModel {

    public BehaviorSubject<ArrayList<StudentBean>> students = BehaviorSubject.createDefault(new ArrayList<>());

    public StudentViewModel() {
        ArrayList<StudentBean> studentBeans = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            StudentBean studentBean = new StudentBean();
            studentBean.setAge(String.valueOf(i));
            studentBean.setName("name" + i);
            studentBeans.add(studentBean);
        }
        students.onNext(studentBeans);
    }
}
