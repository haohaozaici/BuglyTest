package com.hao.buglytest;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by hao on 2017/2/23.
 */

public class MyApplication extends Application {
    private static final String APP_ID = "651bb6d58c";

    private static MyApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
        strategy.setAppChannel("9527");
        strategy.setAppReportDelay(8000);//8s


        CrashReport.initCrashReport(getApplicationContext(), APP_ID, true, strategy);

    }

    public static MyApplication getInstance() {
        return instance;
    }
}
