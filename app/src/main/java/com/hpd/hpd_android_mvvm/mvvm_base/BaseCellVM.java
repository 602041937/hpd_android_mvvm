package com.hpd.hpd_android_mvvm.mvvm_base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseCellVM {

    protected CompositeDisposable compositeDisposable;

    public BaseCellVM(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }
}
