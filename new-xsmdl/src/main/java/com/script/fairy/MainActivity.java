package com.script.fairy;


import android.os.Bundle;

import com.script.opencvapi.AtFairyService;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AtFairyService.startService(this);
        finish();
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;

    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };

    //然后通过一个函数来申请

    /*@Override
    protected void onResume() {
        super.onResume();
        boolean flag= YpSdk.getInstance().init(this);
        if(flag){
            finish();
        }
    }*/

}
