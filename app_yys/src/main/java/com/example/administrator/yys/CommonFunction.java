package com.example.administrator.yys;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;

import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/22 0022.
 */
public class CommonFunction {
    yys mFairy;
    FindResult result;
    private String img;
    private String pathAnswer = "/sdcard/yunpai_files/answer.png";

    public CommonFunction(yys ypFairy) {
        mFairy = ypFairy;
    }
    public String setImg(String img_png) throws Exception {
        Thread.sleep(10);
        img = img_png;
        return img;
    }
    public String getImg() throws Exception {
        Thread.sleep(10);
        return this.img;
    }

    /**
     * 计算出 img[]数组里 相似度最高的
     * @param sim
     * @param x
     * @param y
     * @param x1
     * @param y1
     * @param img
     * @return
     * @throws Exception
     */
    public FindResult arrayCompare(float sim, int x, int y, int x1, int y1, String[] img) throws Exception {
        FindResult result;
        FindResult result1;
        int index = 0;
        result = mFairy.findPic2(x, y, x1, y1, img[0]);
        for (int i = 1; i < img.length; i++) {
            result1 = mFairy.findPic2(x, y, x1, y1, img[i]);
            if (result1.sim > result.sim) {
                result = result1;
                index = i;
            }
        }
        if (result.sim > sim) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            LtLog.e(ste.getFileName() + "   Line:" + ste.getLineNumber() + "   sim:" + result.sim + "  【 最相似的图:" + img[index] + " 】");
        }
        return result;
    }

    public FindResult arrayCompare(float sim, String[] img) throws Exception {
        FindResult result;
        FindResult result1;
        int index = 0;
        result = mFairy.findPic2(img[0]);
        for (int i = 1; i < img.length; i++) {
            result1 = mFairy.findPic2(img[i]);
            if (result1.sim > result.sim) {
                result = result1;
                index = i;
            }
        }
        if (result.sim > sim) {
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            LtLog.e(ste.getFileName() + "   Line:" + ste.getLineNumber() + "   sim:" + result.sim + "  【 最相似的图:" + img[index] + " 】");
        }
        return result;


    }

    /**
     * 随机点击
     * @param sim
     * @param result
     * @param str
     * @param sheep
     * @throws Exception
     */
    public void arrayClick(float sim, FindResult result, String str, int sheep) throws Exception {
        if (result.sim >= sim) {
            Random random = new Random();
            int X = random.nextInt(2) + result.x - 1;
            int Y = random.nextInt(2) + result.y - 1;
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            LtLog.e(ste.getFileName() + "   Line:" + ste.getLineNumber() + "   sim:" + result.sim + "  X:" + X + "  Y:" + Y + "  【 " + str + " 】");
            mFairy.tap(X, Y);
            Thread.sleep(sheep);
        }
    }

    public void Click(float sim, FindResult result, String img, String str, int sheep) throws Exception {
        if (result.sim >= sim) {
            byte[] imgbyte = mFairy.getTemplateData(img);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgbyte, 0, imgbyte.length);
            Random random = new Random();
            int X = random.nextInt(bitmap.getWidth()) + (result.x);
            int Y = random.nextInt(bitmap.getHeight()) + (result.y);
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            LtLog.e(ste.getFileName() + "   Line:" + ste.getLineNumber() + "   sim:" + result.sim + "  X:" + X + "  Y:" + Y + "  img:" + img + "  【 " + str + " 】");
            mFairy.tap(X, Y);
            Thread.sleep(sheep);
        }
    }

//    public String getLineInfo(String str) throws Exception {
//        StackTraceElement ste = (new Throwable()).getStackTrace()[1];
//        return ste.getFileName() + ": Line " + ste.getLineNumber() + ":other==" + str;
//    }

    public void RndClick(float sim, int x, int y, FindResult result, String str, int sheep) throws Exception {
        if (result.sim >= sim) {
            Random random = new Random();
            int X = random.nextInt(2) + x - 1;
            int Y = random.nextInt(2) + y - 1;
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            LtLog.e(ste.getFileName() + "   Line:" + ste.getLineNumber() + "   sim:" + result.sim + "  X:" + X + "  Y:" + Y + "  img:" + img + "  【 " + str + " 】");
            mFairy.tap(X, Y);
            Thread.sleep(sheep);
        }


    }

    public void spot(int x, int y, String str, int sheep) throws Exception {
        Random random = new Random();
        int X = random.nextInt(2) + x - 1;
        int Y = random.nextInt(2) + y - 1;
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        LtLog.e(ste.getFileName() + "   Line:" + ste.getLineNumber() + "  X:" + X + "  Y:" + Y + "   【 " + str + " 】");
        mFairy.tap(X, Y);
        Thread.sleep(sheep);

    }

    public String getText(String str) {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + "   Line:" + ste.getLineNumber() + "【 " + str + " 】";
    }

    public void RanSwipe(int x, int y, int x1, int y1, int dir, int sleep,int sheep2) throws Exception {
        //x,y,x1,y1 这是范围
        //dir = 0从上往下滑动，dir = 1从左往右滑动，dir = 2从下往上滑动，dir = 3从右往左滑动
        //sleep 滑动延时
        if (dir == 0) {
            int result = x + (int) (Math.random() * ((x1 - x) + 1));
            mFairy.touchDown(result, y);
            mFairy.touchMove(result, y1, sleep);
            mFairy.touchUp();
            LtLog.e(getText("下滑"));
        } else if (dir == 1) {
            int result = y + (int) (Math.random() * ((y1 - y) + 1));
            mFairy.touchDown(x, result);
            mFairy.touchMove(x1, result, sleep);
            mFairy.touchUp();
            LtLog.e(getText("右滑"));
        } else if (dir == 2) {
            int result = x + (int) (Math.random() * ((x1 - x) + 1));
            mFairy.touchDown(result, y1);
            mFairy.touchMove(result, y, sleep);
            mFairy.touchUp();
            LtLog.e(getText("上滑"));
        } else if (dir == 3) {
            int result = y + (int) (Math.random() * ((y1 - y) + 1));
            mFairy.touchDown(x1, result);
            mFairy.touchMove(x, result, sleep);
            mFairy.touchUp();
            LtLog.e(getText("左滑"));
        }
        Thread.sleep(sheep2);
    }

    public int Week() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            return 7;
        } else {
            return (cal.get(Calendar.DAY_OF_WEEK)) - 1;
        }
    }

    public int DateHour() {
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        String nowTime1 = format1.format(new Date());
        int hour = Integer.parseInt(nowTime1.split(":")[0]);
        return hour;
    }

    public int DateMinute() {
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        String nowTime1 = format1.format(new Date());
        int minute = Integer.parseInt(nowTime1.split(":")[1]);
        return minute;
    }

    public int DateSecond() {
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        String nowTime1 = format1.format(new Date());
        int second = Integer.parseInt(nowTime1.split(":")[2]);
        return second;
    }

    public int getColorsNumber(int x, int y, int x_1, int y_1, String strColor, double simDouble) {

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

        while (true) {
            mat = mFairy.getScreenMat(x, y, x_1, y_1, 1, 0, 0, 1);
            if (mat != null) {
                break;
            }
        }
        Scalar minValues = new Scalar(min_r, min_g, min_b);
        Scalar maxValues = new Scalar(max_r, max_g, max_b);
//        System.out.println("------------" + min_r + "," + min_g + "," + min_b + "," + max_r + "," + max_g + "," + max_b + ",mat=" + mat);
        Core.inRange(mat, minValues, maxValues, mat);
        int number = Core.countNonZero(mat);
        mat.release();

        return number;
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

    public String getLineInfo(String str){
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + "   Line:" + ste.getLineNumber()+"       "+str;
    }

}
