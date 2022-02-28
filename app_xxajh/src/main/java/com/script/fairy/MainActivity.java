package com.script.fairy;

import android.os.Bundle;

import com.script.opencvapi.AtFairyService;
import com.script.opencvapi.LtLog;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LtLog.e("onCreate >>>>");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AtFairyService.startService(this);
        finish();
    }
}
