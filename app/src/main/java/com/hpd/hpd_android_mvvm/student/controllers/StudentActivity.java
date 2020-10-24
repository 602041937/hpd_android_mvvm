package com.hpd.hpd_android_mvvm.student.controllers;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseActivity;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseAdapter;
import com.hpd.hpd_android_mvvm.router.Router;
import com.hpd.hpd_android_mvvm.student.viewmodels.StudentViewModel;
import com.hpd.hpd_android_mvvm.student.views.StudentCell;

import butterknife.BindView;

@Route(path = Router.studentMain)
public class StudentActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private StudentViewModel vm;

    @Override
    protected Integer initLayout() {
        return R.layout.activity_student;
    }

    @Override
    protected void initSetup() {
        super.initSetup();

        vm = ViewModelProviders.of(this).get(StudentViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentAdapter());
    }

    @Override
    protected void initBindView() {
        super.initBindView();
    }

    @Override
    protected void initBindVM() {
        super.initBindVM();

        compositeDisposable.add(vm.students.subscribe(studentBeans -> {
            recyclerView.getAdapter().notifyDataSetChanged();
        }));
    }

    class StudentAdapter extends BaseAdapter {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(new StudentCell(parent.getContext()));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            StudentCell cell = (StudentCell) holder.itemView;
            cell.resetBind();
            cell.vm.setData(vm.students.getValue().get(position));
        }

        @Override
        public int getItemCount() {
            return vm.students.getValue().size();
        }
    }
}
