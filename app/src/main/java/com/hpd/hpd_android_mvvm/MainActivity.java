package com.hpd.hpd_android_mvvm;

import com.hpd.hpd_android_mvvm.databinding.ActivityMainBinding;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseActivity;
import com.hpd.hpd_android_mvvm.router.Router;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void initSetup() {
        super.initSetup();
    }

    @Override
    protected void initBindView() {
        super.initBindView();

        binding.studentTV.setOnClickListener(view -> {
            Router.shared.student();
        });
    }
}
