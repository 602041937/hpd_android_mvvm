package com.hpd.hpd_android_mvvm.mvvm_base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

public class BaseCell extends FrameLayout {

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

    protected View parentView = null;

    public BaseCell(@NonNull Context context) {
        super(context);
        setup();
    }

    public BaseCell(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public BaseCell(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        if (initLayout() != null) {
            parentView = LayoutInflater.from(getContext()).inflate(initLayout(), this);
            ButterKnife.bind(this, parentView);
        }
        initSetup();
        initBindView();
        initBindVM();
    }

    public void resetBind() {
        Log.i("BaseCell", "resetBind: ");
        compositeDisposable.clear();
        compositeDisposable = new CompositeDisposable();
        initBindView();
        initBindVM();
    }

    protected Integer initLayout() {
        return null;
    }

    protected void initSetup() {

    }

    protected void initBindView() {

    }

    protected void initBindVM() {

    }
}
