package com.example.administrator.xjqxz4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;

import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/22 0022.
 */
public class CommonFunction {
    xjqxz4 mFairy;
    private String img;
    public CommonFunction(xjqxz4 ypFairy) {
        mFairy = ypFairy;
    }
    //做比较的并生成范围点击坐标
    public void Compare(float sim, FindResult result, String img) throws Exception{
        if (result.sim >= sim) {
            byte[] imgbyte = mFairy.getTemplateData(img);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgbyte, 0, imgbyte.length);
            //   LtLog.e("Test", "Bitmap Width == " +  bitmap.getWidth()  + "Bitmap Height ==" +   bitmap.getHeight()+","+img);
            Random random = new Random();
            int X = random.nextInt(bitmap.getWidth()) + (result.x);
            int Y = random.nextInt(bitmap.getHeight()) + (result.y);
           LtLog.e(getLineInfo(img+",==点击==="+X+","+Y));
            mFairy.tap(X, Y);
            Thread.sleep(1000);
        } else {
        }
    }
    //随机5个像素点点击
    public void RndCompare (float sim, int x, int y,FindResult result, String str)throws Exception {
        if (result.sim >= sim) {
            Random random = new Random();
            int X = random.nextInt(2) + x - 1;
            int Y = random.nextInt(2) + y - 1;
            LtLog.e(getLineInfo(str+",==点击==="+X+","+Y));
            mFairy.tap(X,Y);
            Thread.sleep(1000);
        }
    }
    //随机5个像素点点击
    public void RndCompare(int x, int y, String str)throws Exception {
        Random random = new Random();
        int X = random.nextInt(2) + x - 1;
        int Y = random.nextInt(2) + y - 1;
        LtLog.e(getLineInfo(str+",==点击==="+X+","+Y));
        mFairy.tap(X, Y);
        Thread.sleep(1000);
    }
    public void RanSwipe(int x, int y, int x1, int y1, int dir, int sleep) throws Exception{
        //x,y,x1,y1 这是范围
        //dir = 0从上往下滑动，dir = 1从左往右滑动，dir = 2从下往上滑动，dir = 3从右往左滑动
        //sleep 滑动延时
        if (dir == 0) {
            int result = x + (int) (Math.random() * ((x1 - x) + 1));
            mFairy. touchDown(result, y);
            mFairy.touchMove(result, y1, sleep);
            mFairy. touchUp();
        } else if (dir == 1) {
            int result = y + (int) (Math.random() * ((y1 - y) + 1));
            mFairy. touchDown(x, result);
            mFairy.  touchMove(x1, result, sleep);
            mFairy. touchUp();
        } else if (dir == 2) {
            int result = x + (int) (Math.random() * ((x1 - x) + 1));
            mFairy. touchDown(result, y1);
            mFairy.  touchMove(result, y, sleep);
            mFairy.  touchUp();
        } else if (dir == 3) {
            int result = y + (int) (Math.random() * ((y1 - y) + 1));
            mFairy. touchDown(x1,result);
            mFairy.  touchMove(x,result,sleep);
            mFairy. touchUp();
        }
    }
    public void delays (float sim, FindResult result, long s)throws Exception {
        if (result.sim >= sim) {
            Thread.sleep(s);
        }
    }
    public String setImg(String img_png)throws Exception {
        
        img = img_png;
        return img;
    }
    public String getImg() throws Exception{
        return this.img;
    }
    public  int Week(){
      Calendar cal= Calendar.getInstance();
      if (cal.get(Calendar.DAY_OF_WEEK)==1){
          return 7;
      }else {
          return (cal.get(Calendar.DAY_OF_WEEK))-1;
      }
  }
    public  int  DateHour(){
       SimpleDateFormat format1=new SimpleDateFormat("HH:mm:ss");
       String nowTime1=format1.format(new Date());
       int hour=Integer.parseInt(nowTime1.split(":")[0]);
       return hour;
   }
    public  int  DateMinute(){
        SimpleDateFormat format1=new SimpleDateFormat("HH:mm:ss");
        String nowTime1=format1.format(new Date());
        int minute=Integer.parseInt(nowTime1.split(":")[1]);
        return minute;
    }
    public  int  DateSecond(){
        SimpleDateFormat format1=new SimpleDateFormat("HH:mm:ss");
        String nowTime1=format1.format(new Date());
        int second=Integer.parseInt(nowTime1.split(":")[2]);
        return second;
    }
    public String getLineInfo(FindResult result, float usim, String str)throws Exception{
        int x1,y1;
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        if (result.sim>=usim){
          x1=result.x;
          y1=result.y;
            return ste.getFileName() + ": Line " + ste.getLineNumber()+":sim="+result.sim+": IntX="+x1+": IntY="+y1+":img="+str;
        }
       return "       ";
    }
    public String getLineInfo(String str){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber()+":other=="+str;
    }
    public String getLineInfo(String str,int x,int   y){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber()+": IntX="+x+": IntY="+y+":other=="+str;
    }
    public String getLineInfo(float usim,int x,int y,FindResult result,String str){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        if (result.sim>=usim){
            return ste.getFileName() + ": Line " + ste.getLineNumber()+":sim="+result.sim+": IntX="+x+": IntY="+y+":img="+str;
        }
      // return ste.getFileName() + ": Line " + ste.getLineNumber()+":sim="+result.sim+": IntX= -1: IntY= -1:img="+str;
        return "                            ";
    }
    public FindResult  FindManyPic( int x_1, int y_1, int x_2, int y_2,String[] picName,int dayin)throws Exception {
        //区域找多图返回最相似的那一张
        FindResult result;
        FindResult result1;
        int js_1=0;
        result = mFairy.findPic2( x_1, y_1,  x_2, y_2,setImg(picName[0]));
        for (int i = 1; i < picName.length; i++) {
              result1 = mFairy.findPic2( x_1, y_1,  x_2, y_2,setImg(picName[i]));
            if (result1.sim > result.sim) {
                result = result1;
                js_1=i;
            }
        }
        if (dayin==1){
            LtLog.e( getLineInfo("最相似的图=="+js_1+",img="+picName[js_1]));
        }
        return  result;
    }
    public  void FindManyPicRange(float usim,int  wide ,String[] picName)throws Exception {
        //区域找多图找到就点
        FindResult result;
        for (int i = 0; i < picName.length; i++) {
            result =  mFairy.findPicRange  (setImg(picName[i]),wide);
            if (result.sim > usim) {
                LtLog.e( getLineInfo(result, usim, getImg()));
                Compare(usim, result,getImg());
                Thread.sleep(1500);
            }
        }
    }
    public int getColorsNumber(int x,int y,int x_1,int y_1,String strColor, double simDouble) {
        ScreenInfo screenInfo = mFairy.captureInterval();
        if (screenInfo.height > 720) {
            return 0;
        }
        double[] match = new double[3];
        match[0] = Double.parseDouble(strColor.split(",")[2]);
        match[1] = Double.parseDouble(strColor.split(",")[1]);
        match[2] = Double.parseDouble(strColor.split(",")[0]);
        double simValue = 255 * (1 - simDouble);
        double min_r = match[0] - simValue;
        double min_g = match[1] - simValue;
        double min_b = match[2] - simValue;
        double max_r = match[0] + simValue;
        double max_g = match[1] + simValue;
        double max_b = match[2] + simValue;
        if (min_r < 0) {
            min_r = 0;
        }
        if (min_g < 0) {
            min_g = 0;
        }
        if (min_b < 0) {
            min_b = 0;
        }
        if (max_r > 255) {
            max_r = 255;
        }
        if (max_g > 255) {
            max_g = 255;
        }
        if (max_b > 255) {
            max_b = 255;
        }

        Mat mat;

        while (true){
            mat = mFairy.getScreenMat( x, y, x_1, y_1, 1, 0, 0, 1);
            if(mat!=null){
                break;
            }
        }
        Scalar minValues = new Scalar(min_r, min_g, min_b);
        Scalar maxValues = new Scalar(max_r, max_g, max_b);
//        System.out.println("------------" + min_r + "," + min_g + "," + min_b + "," + max_r + "," + max_g + "," + max_b + ",mat=" + mat);
        Core.inRange(mat, minValues, maxValues, mat);
        int number=Core.countNonZero(mat);
        mat.release();

        return number;
    }
    public int  GetColornum(String str, String color, double sim, int type) {
        //获取区域内颜色数量
        //参数str X1，Y1，X2，Y2范围。
        //参数color 颜色RGB值
        //参数 sim 相似度
        //参数 type   等于1的时候是竖屏 等于0的时候是横屏
        int Nownum = 0;
        byte[] rawpic = mFairy.captureInterval().raw;
        //这是获取给的范围的
        String[] arr = str.split(",");
        String[] btt = color.split(",");
        String setr = btt[0];
        String setg = btt[1];
        String setb = btt[2];
        int setir = Integer.parseInt(setr);
        int setig = Integer.parseInt(setg);
        int setib = Integer.parseInt(setb);
        double maxrRange = (1 - sim) * setir;
        double maxgRange = (1 - sim) * setig;
        double maxbRange = (1 - sim) * setib;
        int minw = Integer.parseInt(arr[0]);
        int maxw = Integer.parseInt(arr[2]);
        int minh = Integer.parseInt(arr[1]);
        int maxh = Integer.parseInt(arr[3]);
        int Totalspot = (maxw - minw) * (maxh - minh);
        //  LtLog.e("总点数是" + Totalspot);
        int w = 1280;
        if (type == 1) {
            w = 736;
        }
        int i = (w * 4) * Integer.parseInt(arr[1]) + Integer.parseInt(arr[0]) * 4;
        int proit = i;
        int eachrow = maxw - minw;
        int nowspot = 0;
        int begin = 0;
        do {
            nowspot = nowspot + 1;
            String sr = String.valueOf(rawpic[i] & 0xff);
            String sg = String.valueOf(rawpic[i + 1] & 0xff);
            String sb = String.valueOf(rawpic[i + 2] & 0xff);
//            LtLog.e("匹配第"+nowspot+"个点");
//            LtLog.e("---------------------------R=======" + String.valueOf(rawpic[i] & 0xff));
//            LtLog.e("---------------------------G=======" + String.valueOf(rawpic[i + 1] & 0xff));
//            LtLog.e("---------------------------B=======" + String.valueOf(rawpic[i + 2] & 0xff));
            int ir = Integer.parseInt(sr);
            int ig = Integer.parseInt(sg);
            int ib = Integer.parseInt(sb);
            if (setir - maxrRange <= ir && ir <= setir + maxrRange && setig - maxgRange <= ig && ig <= setig + maxgRange && ib >= setib - maxbRange && ib <= setib + maxbRange) {
                Nownum = Nownum + 1;
            }
            begin = begin + 1;
            if (begin >= eachrow) {
                proit = w * 4 + proit;
                i = proit;
                begin = 0;
            } else {
                i = i + 4;
            }
        } while (nowspot < Totalspot);
        //  LtLog.e("匹配成功的个数是" + Nownum);
        return Nownum;
    }

    public String[] findAnswer(String title, String game_id) {
        OkHttpClient client = new OkHttpClient();
        String resultStr = null;
        JSONObject jsonObject;
//        String[] array ;
        Request request = new Request.Builder()
                .url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/FindTheAnswer?title=" + title + "&game_id=" + game_id)
                .get()
                .build();
        try {
            Response response = client.newCall(request).execute();
            resultStr = response.body().string();
            //     LtLog.i(publicFunction.getLineInfo() + "-----------+++---------response=" + resultStr);
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }

        try {
            resultStr = new org.json.JSONTokener(resultStr).nextValue().toString();
            //     LtLog.i(publicFunction.getLineInfo() + "-----------+++---------resultStr=" + resultStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject = new JSONObject(resultStr);
            if (jsonObject.getString("data").equals("false")) {
                //  LtLog.i(publicFunction.getLineInfo() + "-----------+++---------not title");
                return new String[0];
            } else {
                String arr;
                arr = jsonObject.getString("data").replaceAll("\\[", "");
                arr = arr.replaceAll("\\]", "");
                arr = arr.replaceAll("\"", "");
                String[] array = arr.split(",");
                //  LtLog.i(publicFunction.getLineInfo() + "-----------+++---------array=" + array);
                return array;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new String[0];
    }
    //上传题目和答案
    public void UpAnswerAndTitle(String title, String answer, String game_id) {
        String resultStr = null;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "title=" + title + "&game_id=" + game_id + "&answer=" + answer);
        Request request = new Request.Builder()
                .url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/AddTitle")
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            resultStr = response.body().string();
            //   LtLog.i(publicFunction.getLineInfo() + "-----------+++---------response=" + resultStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAnswerOcr(int x_1, int y_1, int width, int height,Mat mMat) {
        String mStr;
//      Mat mat1 = mFairy.getScreenMat(x_1, y_1, width, height, 1, 0, 0, 1);

        Rect rect = new Rect(x_1, y_1, width, height);
        Mat mat1 = new Mat(mMat, rect);
        Imgcodecs.imwrite("/sdcard/test2.png",mat1);
     /*   Scalar minValues = new Scalar(127, 127, 127);
        Scalar maxValues = new Scalar(255, 255, 255);
        Core.inRange(mat1, minValues, maxValues, mat1);*/
       /* Imgcodecs.imwrite("/sdcard/test.png",mat1);*/
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat1, bitmap);
        mStr = mFairy.ocr(bitmap);
        //   LtLog.i(publicFunction.getLineInfo() + "-----------+++---------str=" + mStr);
        mat1.release();
        return mStr;
    }
}
