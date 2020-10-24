package com.hpd.hpd_android_mvvm.student.viewmodels;

import com.hpd.hpd_android_mvvm.mvvm_base.BaseCellViewModel;
import com.hpd.hpd_android_mvvm.student.models.StudentBean;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.BehaviorSubject;

public class StudentCellViewModel extends BaseCellViewModel {

    public BehaviorSubject<String> name = BehaviorSubject.createDefault("1");
    public BehaviorSubject<String> age = BehaviorSubject.createDefault("2");
    public BehaviorSubject<String> bookCount = BehaviorSubject.createDefault("3");

    public StudentCellViewModel(CompositeDisposable compositeDisposable) {
        super(compositeDisposable);
    }

    public void setData(StudentBean bean) {
        name.onNext(bean.getName());
        age.onNext(bean.getAge());
    }
}
