package com.hpd.hpd_android_mvvm.mvvm_base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

public class BaseFragment extends Fragment {

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(initLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ARouter.getInstance().inject(this);

        initSetup();
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
