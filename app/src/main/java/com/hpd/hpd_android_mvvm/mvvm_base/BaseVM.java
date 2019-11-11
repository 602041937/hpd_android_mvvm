package com.hpd.hpd_android_mvvm.mvvm_base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseVM {

    protected CompositeDisposable compositeDisposable;

    public BaseVM(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }
}
