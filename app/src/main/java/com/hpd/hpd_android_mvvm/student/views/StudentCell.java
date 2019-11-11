package com.hpd.hpd_android_mvvm.student.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseCell;
import com.hpd.hpd_android_mvvm.student.viewmodels.StudentCellVM;
import com.jakewharton.rxbinding3.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentCell extends BaseCell {

    public StudentCellVM vm;

    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.btn_click)
    Button btnClick;

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
    public void setupView() {
        super.setupView();
        View cellView = LayoutInflater.from(getContext()).inflate(R.layout.student_cell, this);
        ButterKnife.bind(this, cellView);
    }

    @Override
    public void bindViewModel() {
        super.bindViewModel();

        vm = new StudentCellVM(compositeDisposable);

        compositeDisposable.add(vm.name.subscribe(s -> tvUsername.setText(s)));
        compositeDisposable.add(vm.age.subscribe(s -> tvAge.setText(s)));
        compositeDisposable.add(RxView.clicks(btnClick).subscribe(unit -> {
            vm.name.onNext(vm.name.getValue() + vm.name.getValue());
        }));
    }
}
