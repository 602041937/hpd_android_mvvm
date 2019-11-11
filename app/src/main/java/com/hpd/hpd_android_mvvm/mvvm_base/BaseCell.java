package com.hpd.hpd_android_mvvm.mvvm_base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;

public class BaseCell extends FrameLayout {

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BaseCell(@NonNull Context context) {
        super(context);
        setupView();
    }

    public BaseCell(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupView();
    }

    public BaseCell(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView();
    }

    public void setupView() {

    }

    public void resetBind() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        compositeDisposable = new CompositeDisposable();
        bindViewModel();
    }

    public void bindViewModel() {

    }
}
