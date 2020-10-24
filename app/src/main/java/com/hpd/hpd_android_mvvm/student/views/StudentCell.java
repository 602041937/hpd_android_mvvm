package com.hpd.hpd_android_mvvm.student.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseCell;
import com.hpd.hpd_android_mvvm.router.Router;
import com.hpd.hpd_android_mvvm.student.viewmodels.StudentCellViewModel;
import com.jakewharton.rxbinding3.view.RxView;

import butterknife.BindView;

public class StudentCell extends BaseCell {

    public StudentCellViewModel vm;

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
    protected Integer initLayout() {
        return R.layout.student_cell;
    }

    @Override
    protected void initSetup() {
        super.initSetup();

    }

    @Override
    protected void initBindView() {
        super.initBindView();

        compositeDisposable.add(RxView.clicks(parentView).subscribe(unit -> {
            Router.shared.studentDetail(1);
        }));

        compositeDisposable.add(RxView.clicks(btnClick).subscribe(unit -> {
            vm.name.onNext(vm.name.getValue() + vm.name.getValue());
        }));
    }

    @Override
    protected void initBindVM() {
        super.initBindVM();

        vm = new StudentCellViewModel(compositeDisposable);

        compositeDisposable.add(vm.name.subscribe(s -> tvUsername.setText(s)));
        compositeDisposable.add(vm.age.subscribe(s -> tvAge.setText(s)));
    }
}
