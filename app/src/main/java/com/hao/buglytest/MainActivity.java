package com.hao.buglytest;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.bugly.crashreport.CrashReport;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button JavaCrash;
    private Button ANRCrash;
    private Button NativeCrash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JavaCrash = (Button) findViewById(R.id.crash1);
        JavaCrash.setOnClickListener(this);
        ANRCrash = (Button) findViewById(R.id.crash2);
        ANRCrash.setOnClickListener(this);
        NativeCrash = (Button) findViewById(R.id.crash3);
        NativeCrash.setOnClickListener(this);

        CrashReport.setUserSceneTag(this, 37705);
        MainActivityPermissionsDispatcher.needPermissionsWithCheck(this);
    }

    @NeedsPermission(Manifest.permission.READ_PHONE_STATE)
    public void needPermissions() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.crash1:
                CrashReport.testJavaCrash();
                break;
            case R.id.crash2:
                CrashReport.testANRCrash();
                break;
            case R.id.crash3:
                CrashReport.testNativeCrash();
                break;
        }
    }
}
