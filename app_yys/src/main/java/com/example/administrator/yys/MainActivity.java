package com.example.administrator.yys;

import android.os.Bundle;
import com.auto.scriptsdk.ui.ATSdk;
import com.example.scriptsdkproxy.LocalFairyService;
import com.script.opencvapi.AtFairyService;
import com.script.opencvapi.RequestPermissionActivity;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*super.onCreate(savedInstanceState);
        finish();
        RequestPermissionActivity.startActivity(this);*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AtFairyService.startService(this, LocalFairyService.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean flag= ATSdk.getInstance().init(this);
        if(flag){
            finish();
        }
    }
}
