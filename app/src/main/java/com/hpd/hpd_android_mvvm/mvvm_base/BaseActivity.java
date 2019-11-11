package com.hpd.hpd_android_mvvm.mvvm_base;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity extends AppCompatActivity {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
