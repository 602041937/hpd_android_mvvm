package com.hpd.hpd_android_mvvm.mvvm_base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseCellViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable;

    public BaseCellViewModel(CompositeDisposable compositeDisposable) {
        this.compositeDisposable = compositeDisposable;
    }
}
