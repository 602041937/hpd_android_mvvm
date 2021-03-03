package com.hpd.hpd_android_mvvm.student.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hpd.hpd_android_mvvm.databinding.StudentCellBinding;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseCell;
import com.hpd.hpd_android_mvvm.router.Router;
import com.hpd.hpd_android_mvvm.student.viewmodels.StudentCellViewModel;
import com.jakewharton.rxbinding3.view.RxView;

public class StudentCell extends BaseCell<StudentCellBinding> {

    public StudentCellViewModel vm;

    public StudentCell(@NonNull Context context) {
        super(context);
    }

    public StudentCell(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StudentCell(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void initSetup() {
        super.initSetup();

        vm = new StudentCellViewModel(compositeDisposable);
    }

    @Override
    protected void initBindView() {
        super.initBindView();

        compositeDisposable.add(RxView.clicks(binding.getRoot()).subscribe(unit -> {
            Router.shared.studentDetail(1);
        }));

        compositeDisposable.add(RxView.clicks(binding.btnClick).subscribe(unit -> {
            vm.name.onNext(vm.name.getValue() + vm.name.getValue());
        }));
    }

    @Override
    protected void initBindVM() {
        super.initBindVM();

        compositeDisposable.add(vm.name.subscribe(s -> binding.tvUsername.setText(s)));
        compositeDisposable.add(vm.age.subscribe(s -> binding.tvAge.setText(s)));
    }
}
