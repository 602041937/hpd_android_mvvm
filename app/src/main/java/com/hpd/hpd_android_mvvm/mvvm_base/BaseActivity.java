package com.hpd.hpd_android_mvvm.mvvm_base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.alibaba.android.arouter.launcher.ARouter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import io.reactivex.disposables.CompositeDisposable;

public class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    protected T binding;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);

        initLayout();
        initSetup();
        initBindView();
        initBindVM();
    }

    private void initLayout() {

        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class cls = (Class) type.getActualTypeArguments()[0];
        try {
            Method inflate = cls.getDeclaredMethod("inflate", LayoutInflater.class);
            binding = (T) inflate.invoke(null, getLayoutInflater());
            setContentView(binding.getRoot());
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
