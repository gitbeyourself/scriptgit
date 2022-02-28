package com.example.administrator.xjqxz4;

import android.graphics.Bitmap;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.script.opencvapi.ScreenInfo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * Created by Administrator on 2018-11-06.
 */

public class OcrNumber {
    private xjqxz4 mFairy;
    TessBaseAPI tessBaseAPI;
    public OcrNumber(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        tessBaseAPI = new TessBaseAPI();
        tessBaseAPI.setDebug(true);
        tessBaseAPI.init("/sdcard/yunpai_files/", "eng"); //eng为识别语言
        //ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
        tessBaseAPI.setVariable(TessBaseAPI.VAR_CHAR_WHITELIST, "0123456789,"); // 识别白名单
        tessBaseAPI.setVariable(TessBaseAPI.VAR_CHAR_BLACKLIST, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%^&*()_+=-[]}{;:'\"\\|~`./<>?"); // 识别黑名单
        tessBaseAPI.setPageSegMode(TessBaseAPI.PageSegMode.PSM_AUTO_OSD);
    }

    public String getNumber(int x, int y, int width, int height){
        ScreenInfo screenInfo = mFairy.captureInterval();
        if(screenInfo.height>720){
            System.out.println("error Screen height >720");
            return null;
        }
        Mat mat=mFairy.getScreenMat(x,y,width,height,1, 0, 0, 1);
        Imgcodecs.imwrite("/sdcard/test.png", mat);
        Bitmap bitmap = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat, bitmap);
        mat.release();
        tessBaseAPI.setImage(bitmap);
        String number = tessBaseAPI.getUTF8Text();
        System.out.println("number=" + number);
        tessBaseAPI.clear();
        return number;
    }

    public String getNumber(int x, int y, int width, int height,Scalar minValue ,Scalar maxValue){
        ScreenInfo screenInfo = mFairy.captureInterval();
        if(screenInfo.height>720){
            System.out.println("error Screen height >720");
            return null;
        }
        Mat mat=mFairy.getScreenMat(x,y,width,height,1, 0, 0, 1);
        Scalar minValues = minValue;
        Scalar maxValues = maxValue;
        Core.inRange(mat, minValues, maxValues, mat);
        //        Imgcodecs.imwrite("/sdcard/test.png", mat);
        Bitmap bitmap = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat, bitmap);
        mat.release();
        tessBaseAPI.setImage(bitmap);
        String number = tessBaseAPI.getUTF8Text();
        System.out.println("number=" + number);
        tessBaseAPI.clear();
        return number;
    }




}
