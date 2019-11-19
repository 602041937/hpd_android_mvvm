package com.hpd.hpd_android_mvvm.student.viewmodels;

import com.hpd.hpd_android_mvvm.mvvm_base.BaseCellVM;
import com.hpd.hpd_android_mvvm.student.models.StudentBean;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

public class StudentCellVM extends BaseCellVM {

    public BehaviorSubject<String> name = BehaviorSubject.createDefault("1");
    public BehaviorSubject<String> age = BehaviorSubject.createDefault("2");
    public BehaviorSubject<String> bookCount = BehaviorSubject.createDefault("3");

    public StudentCellVM(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }

    public void setData(StudentBean bean) {
        name.onNext(bean.getName());
        age.onNext(bean.getAge());
    }
}
