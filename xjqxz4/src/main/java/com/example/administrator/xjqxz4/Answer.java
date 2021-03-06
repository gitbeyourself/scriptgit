package com.example.administrator.xjqxz4;

import android.graphics.Bitmap;

import com.script.opencvapi.AtFairy2;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018-08-14.
 */

public class Answer {
    private xjqxz4 mFairy;
    FindResult result;
    private Random rand = new Random();
    private String pathAnswer = "/sdcard/yunpai_files/answer.png";
    private String game_id;
    private List<Integer> title_Range;
    private List<Integer> answer_Range;
    private List<Integer> answer_Range1;
    private int selectIndex=0;//้้กนๆฐ้
    private int answer_Range_w;
    private int answer_Range_h;
    private List<Integer> title_toValue_min;
    private List<Integer> title_toValue_max;
    private List<Integer> answer_toValue_min;
    private List<Integer> answer_toValue_max;
    private List<Integer> pic_range;
    private List<Integer> right_pic_Relative_range;
    private String right_pic;
    private PublicFunction publicFunction;
    CommonFunction commonFunction;
    public Answer(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        publicFunction = new PublicFunction(mFairy);
        commonFunction = new CommonFunction(mFairy);
    }

    public Map<String,List<Integer>> initializationMap(){
        Map<String,List<Integer>> mMap= new HashMap<>();
        mMap.put("game_id", null);
        mMap.put("title_Range",null);
        mMap.put("answer_Range",null);
        mMap.put("title_toValue_min",null);
        mMap.put("title_toValue_max",null);
        mMap.put("answer_toValue_min", null);
        mMap.put("answer_toValue_max",null);
        mMap.put("pic_range",null);
        mMap.put("right_pic_Relative_range",null);
        return mMap;
    }

    public void mAnswer(Map<String,List<Integer>> mMap,String picName) throws Exception {
        LtLog.i(publicFunction.getLineInfo() + "----------------------------mMap>" + mMap);
        game_id=Integer.toString(mMap.get("game_id").get(0)); //ๆธธๆid
        if(game_id==null){
            game_id= AtFairyConfig.getGameID();
        }
        title_Range=mMap.get("title_Range");//้ข็ฎ่ๅด x1,y1,w,h
        answer_Range=mMap.get("answer_Range");//็ญๆก่ๅด A x1,y1 B x1,y1 ..... ๆๅไธคไธชๅๆฐไธบ ๅฎฝ้ซ w , hใใใใๆณจๆ็ญๆก่ๅดๅฟ้กป ๅจๅฏ็นๅป้ไธญ็่ๅดๅ
        answer_Range1=mMap.get("answer_Range1");//็ญๆก็่ๅด A็ๅบๅ B็ๅบๅ.....
        title_toValue_min=mMap.get("title_toValue_min");//้ข็ฎไบๅผๅ่ๅดๆๅฐๅผ R,G,B
        title_toValue_max=mMap.get("title_toValue_max");//้ข็ฎไบๅผๅ่ๅด ๆๅคงๅผ R,G,B
        answer_toValue_min=mMap.get("answer_toValue_min");//็ญๆกไบๅผๅ่ๅด ๆๅฐๅผ R,G,B
        answer_toValue_max=mMap.get("answer_toValue_max");//็ญๆกไบๅผๅ่ๅด ๆๅคงๅผ R,G,B
        answer_toValue_max=mMap.get("answer_toValue_max");//็ญๆกไบๅผๅ่ๅด ๆๅคงๅผ R,G,B
        pic_range=mMap.get("pic_range");//ๅคๆญๆญฃ็กฎ็ญๆก่ฏๅซๅพ็่ๅด
        right_pic_Relative_range=mMap.get("right_pic_Relative_range"); //ๅคๆญๆญฃ็กฎ็ญๆกๅๅ็งปๅผ ๅๆญฃ็กฎ็ญๆก็่ๅด x,y,w,h
        right_pic=picName;//ๅคๆญๆญฃ็กฎ็ญๆก็่ฏๅซๅพ

        answer_Range_w=answer_Range.get(answer_Range.size()-2);
        answer_Range_h=answer_Range.get(answer_Range.size()-1);
        selectIndex=(answer_Range.size()-2)/2;
        AIAnswer();
    }


    public void AIAnswer() throws Exception {
            LtLog.e(commonFunction.getLineInfo("ๆฒกๆๆพๅฐ้ข็ฎ,้ป่ฎค้A"));
            publicFunction.rndTapWH(answer_Range.get(0),answer_Range.get(1),answer_Range_w,answer_Range_h);
            Thread.sleep(3000);
            return;
    }


    //ๅพๅฐไบๅผๅocr

    public String getAnswerOcr(int x_1, int y_1, int width, int height,List<Integer> min_colorRange,List<Integer> max_colorRange) {
        String mStr;
        int min_r,min_g,min_b,max_r,max_g,max_b;
        min_r=min_colorRange.get(0);
        min_g=min_colorRange.get(1);
        min_b=min_colorRange.get(2);
        max_r=max_colorRange.get(0);
        max_g=max_colorRange.get(1);
        max_b=max_colorRange.get(2);
        LtLog.i(getLineInfo() + "-----------+++---------min_r=" + min_r +",min_g=" + min_g + ",min_b=" + min_b);
        LtLog.i(getLineInfo() + "-----------+++---------max_r=" + max_r +",max_g=" + max_g + ",max_b=" + max_b);
        //Mat mat1 = mFairy.getScreenMat(x_1, y_1, width, height, 1, 0, 0, 1);
        if (!publicFunction.fileIsExists(pathAnswer)) {
            LtLog.i(getLineInfo() + "-----------+++--------- not  answer pic=");
            return "";
        }
        LtLog.i(getLineInfo() + "-----------+++--------- x_1=" + x_1 +",y_1=" + y_1 + ",w=" + width + ",h=" + height);
        Rect rect = new Rect(x_1, y_1, width, height);
        Mat mat1 = new Mat(Imgcodecs.imread(pathAnswer), rect);
        Imgcodecs.imwrite("/sdcard/test1.png",mat1);
        Scalar minValues = new Scalar(min_b, min_g, min_r);
        Scalar maxValues = new Scalar(max_b, max_g, max_r);
        Core.inRange(mat1, minValues, maxValues, mat1);
        Imgcodecs.imwrite("/sdcard/test2.png",mat1);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat1, bitmap);
        mStr = mFairy.ocr(bitmap);
        LtLog.i(getLineInfo() + "-----------+++---------str=" + mStr);
        mat1.release();
        return mStr;
    }

/*    public String getAnswerOcr1(int x_1, int y_1, int width, int height) {
        String mStr;
//      Mat mat1 = mFairy.getScreenMat(x_1, y_1, width, height, 1, 0, 0, 1);
 *//*       if (!publicFunction.fileIsExists(pathAnswer)) {
            LtLog.i(getLineInfo() + "-----------+++--------- not  answer pic=");
            return "";
        }
        Rect rect = new Rect(x_1, y_1, width, height);
        Mat mat1 = new Mat(Imgcodecs.imread(pathAnswer), rect);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat1, bitmap);
        mStr = mFairy.ocr(bitmap);
        LtLog.i(getLineInfo() + "-----------+++---------str=" + mStr);
        mat1.release();*//*
        String mStr = mFairy.ocr(x_1, y_1, width, height);
        return mStr;
    }*/

    private void rndTap(int x_1, int y_1, int x_2, int y_2) throws Exception{
        //่ๅด็นๅป
        int rndx = rand.nextInt(x_2 - x_1 + 1) + x_1;
        int rndy = rand.nextInt(y_2 - y_1 + 1) + y_1;
        mFairy.tap(rndx, rndy);
    }

    private void rndTapWH(int x_1, int y_1, int w_1, int h_1) throws Exception{
        //ๅๆ?็นๅ็งปๅฎฝ้ซ้ๆบ็นๅป
        int rndx = rand.nextInt(w_1 + 1) + x_1;
        int rndy = rand.nextInt(h_1 + 1) + y_1;
        mFairy.tap(rndx, rndy);
    }

    private static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }


}
