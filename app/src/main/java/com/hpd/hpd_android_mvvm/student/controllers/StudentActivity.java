package com.hpd.hpd_android_mvvm.student.controllers;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseActivity;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseAdapter;
import com.hpd.hpd_android_mvvm.student.viewmodels.StudentVM;
import com.hpd.hpd_android_mvvm.student.views.StudentCell;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/student/main")
public class StudentActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private StudentVM vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);

        vm = ViewModelProviders.of(this).get(StudentVM.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentAdapter());

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
