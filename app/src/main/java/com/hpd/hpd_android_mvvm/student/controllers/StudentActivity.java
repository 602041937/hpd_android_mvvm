package com.hpd.hpd_android_mvvm.student.controllers;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hpd.hpd_android_mvvm.R;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseActivity;
import com.hpd.hpd_android_mvvm.mvvm_base.BaseAdapter;
import com.hpd.hpd_android_mvvm.student.views.StudentCell;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentActivity extends BaseActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentAdapter());
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
            cell.vm.setData();
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}
