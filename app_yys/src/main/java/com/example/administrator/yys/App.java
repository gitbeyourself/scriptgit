package com.example.administrator.yys;

import android.app.Application;

import com.script.opencvapi.AtFairyService;
import com.script.opencvapi.LtLog;

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
            AtFairyService.setStarterClass(yys.class);
        LtLog.e("a-------------------------------进到app里了");
        }
}
