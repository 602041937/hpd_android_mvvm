package com.hpd.hpd_android_mvvm.stduent_detail.viewmodels;

import com.hpd.hpd_android_mvvm.mvvm_base.BaseViewModel;

import io.reactivex.subjects.BehaviorSubject;

public class StudentInfoViewModel extends BaseViewModel {

    public BehaviorSubject<String> title = BehaviorSubject.createDefault("");

    private int studentId;

    public void setData(int studentId) {
        this.studentId = studentId;
        title.onNext("info studentId: " + studentId);
    }
}
