package com.hpd.hpd_android_mvvm.stduent_detail.controllers;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.databinding.ActivityStudentDetailBinding;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseActivity;
import com.hpd.hpd_android_mvvm.router.Router;
import com.hpd.hpd_android_mvvm.stduent_detail.viewmodels.StudentDetailViewModel;
import com.jakewharton.rxbinding3.view.RxView;

@Route(path = Router.studentDetail)
public class StudentDetailActivity extends BaseActivity<ActivityStudentDetailBinding> {

    private StudentInfoFragment studentInfoFragment;

    private StudentDetailViewModel vm;

    @Autowired
    int studentId;

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

        compositeDisposable.add(RxView.clicks(binding.tvAge).subscribe(unit -> {
            vm.dealTap();
        }));
    }

    @Override
    protected void initBindVM() {
        super.initBindVM();

        compositeDisposable.add(vm.title.subscribe(s -> binding.tvAge.setText(s)));
    }
}
