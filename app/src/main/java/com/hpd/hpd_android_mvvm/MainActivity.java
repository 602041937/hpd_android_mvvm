package com.hpd.hpd_android_mvvm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hpd.hpd_android_mvvm.router.Router;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.studentTV)
    TextView studentTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        studentTV.setOnClickListener(view -> {
            Router.shared.student();
        });
    }
}
