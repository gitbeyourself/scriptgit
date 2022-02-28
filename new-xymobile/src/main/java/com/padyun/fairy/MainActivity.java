package com.padyun.fairy;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.scriptsdkproxy.LocalFairyService;
import com.script.opencvapi.AtFairyService;
import com.padyun.scriptsdk.ui.YpSdk;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        AtFairyService.startService(this);
        finish();*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*AtFairyService.startService(this);
        finish();*/
        AtFairyService.startService(this, LocalFairyService.class);
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    //然后通过一个函数来申请

    @Override
    protected void onResume() {
        super.onResume();
        boolean flag= YpSdk.getInstance().init(this);
        if(flag){
            finish();
        }
    }

}
