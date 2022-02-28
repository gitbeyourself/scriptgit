package com.example.administrator.yys;

import android.os.Bundle;


import com.script.opencvapi.RequestPermissionActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
        RequestPermissionActivity.startActivity(this);

    }
}
