package com.hpd.hpd_android_mvvm.mvvm_base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import io.reactivex.disposables.CompositeDisposable;

public class BaseCell<T extends ViewBinding> extends FrameLayout {

    protected T binding;

    public CompositeDisposable compositeDisposable = new CompositeDisposable();

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

    protected void setup() {
        initLayout();
        initSetup();
        initBindView();
        initBindVM();
    }

    public void resetBind() {
        Log.i("BaseCell", "resetBind: ");
        compositeDisposable.clear();
        compositeDisposable = new CompositeDisposable();
        initSetup();
        initBindView();
        initBindVM();
    }

    private void initLayout() {

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            Method inflate = cls.getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
            binding = (T) inflate.invoke(null, LayoutInflater.from(getContext()), this, true);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void initSetup() {

    }

    protected void initBindView() {

    }

    protected void initBindVM() {

    }
}
