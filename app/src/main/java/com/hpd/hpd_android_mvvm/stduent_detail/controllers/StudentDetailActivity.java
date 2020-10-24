package com.hpd.hpd_android_mvvm.stduent_detail.controllers;

import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseActivity;
import com.hpd.hpd_android_mvvm.router.Router;
import com.hpd.hpd_android_mvvm.stduent_detail.viewmodels.StudentDetailViewModel;
import com.jakewharton.rxbinding3.view.RxView;

import butterknife.BindView;

@Route(path = Router.studentDetail)
public class StudentDetailActivity extends BaseActivity {

    @BindView(R.id.tv_age)
    TextView tvAge;

    @BindView(R.id.flInfoFragment)
    FrameLayout flInfoFragment;

    private StudentInfoFragment studentInfoFragment;

    private StudentDetailViewModel vm;

    @Autowired
    int studentId;

    @Override
    protected Integer initLayout() {
        return R.layout.activity_student_detail;
    }

    @Override
    protected void initSetup() {
        super.initSetup();
        vm = ViewModelProviders.of(this).get(StudentDetailViewModel.class);
        vm.setData(studentId);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        studentInfoFragment = StudentInfoFragment.newInstance(2);
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flInfoFragment, studentInfoFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void initBindView() {
        super.initBindView();

        compositeDisposable.add(RxView.clicks(tvAge).subscribe(unit -> {
            vm.dealTap();
        }));
    }

    @Override
    protected void initBindVM() {
        super.initBindVM();

        compositeDisposable.add(vm.title.subscribe(s -> tvAge.setText(s)));
    }
}
