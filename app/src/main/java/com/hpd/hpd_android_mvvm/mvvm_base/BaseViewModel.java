package com.hpd.hpd_android_mvvm.mvvm_base;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel extends ViewModel {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("BaseVM", "onCleared: ");
        compositeDisposable.clear();
    }
}
