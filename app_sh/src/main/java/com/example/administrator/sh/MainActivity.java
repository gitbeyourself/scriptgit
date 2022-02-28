package com.example.administrator.sh;

import android.os.Bundle;

import com.padyun.opencvapi.RequestPermissionActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
        RequestPermissionActivity.startActivity(this);

    }
}
