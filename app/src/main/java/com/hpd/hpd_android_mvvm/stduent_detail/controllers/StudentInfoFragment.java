package com.hpd.hpd_android_mvvm.stduent_detail.controllers;

import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hpd.hpd_android_mvvm.databinding.StudentInfoFragmentBinding;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseFragment;
import com.hpd.hpd_android_mvvm.stduent_detail.viewmodels.StudentInfoViewModel;

@Route(path = "/student/infoFragment")
public class StudentInfoFragment extends BaseFragment<StudentInfoFragmentBinding> {

    @Autowired
    int studentId;

    private StudentInfoViewModel vm;

    public static StudentInfoFragment newInstance(int studentId) {

        StudentInfoFragment studentInfoFragment = (StudentInfoFragment) ARouter
                .getInstance()
                .build("/student/infoFragment")
                .withInt("studentId", studentId).navigation();
        return studentInfoFragment;
    }

    @Override
    protected void initSetup() {
        super.initSetup();
        vm = ViewModelProviders.of(this).get(StudentInfoViewModel.class);
        vm.setData(studentId);
    }

    @Override
    protected void initBindView() {
        super.initBindView();

    }

    @Override
    protected void initBindVM() {
        super.initBindVM();

        compositeDisposable.add(vm.title.subscribe(s -> binding.tvInfo.setText(s)));

        compositeDisposable.add(vm.finish.subscribe(o -> getActivity().finish()));
    }
}
