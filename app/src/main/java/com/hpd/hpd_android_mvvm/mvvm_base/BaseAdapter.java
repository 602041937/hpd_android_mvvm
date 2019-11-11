package com.hpd.hpd_android_mvvm.mvvm_base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
