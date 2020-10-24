package com.hpd.hpd_android_mvvm.router;

import com.alibaba.android.arouter.launcher.ARouter;

public class Router {

    public static final String studentMain = "/student/main";
    public static final String studentDetail = "/student/detail";

    public static Router shared = new Router();

    public void student() {
        ARouter.getInstance().build("/student/main").navigation();
    }

    public void studentDetail(int studentId) {
        ARouter.getInstance().build(Router.studentDetail)
                .withInt("studentId", studentId)
                .navigation();
    }
}
