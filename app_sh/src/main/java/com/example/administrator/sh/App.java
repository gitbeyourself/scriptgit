package com.example.administrator.sh;

import android.app.Application;

import com.script.opencvapi.LtLog;
import  com.padyun.opencvapi.AtFairyService;

import org.opencv.android.OpenCVLoader;

/**
 * Created by Administrator on 2018/3/13.
 */

public class App extends Application {
    static {
        LtLog.e("-------------------------------------opencv loader ");
        if (!OpenCVLoader.initDebug()) {
            LtLog.e("-------------------------------------opencv loader error");
        }
    }
    @Override
    public void onCreate(){
            super.onCreate();
            AtFairyService.setStarterClass(sh.class);
        LtLog.e("a-------------------------------进到app里了");
        }
}
