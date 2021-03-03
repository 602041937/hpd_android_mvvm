package com.hpd.hpd_android_mvvm.mvvm_base;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

public class BaseViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PublishSubject finish = PublishSubject.create();

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("BaseVM", "onCleared: ");
        compositeDisposable.clear();
    }
}
