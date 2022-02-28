package com.script.fairy;

import android.graphics.Bitmap;

import com.googlecode.tesseract.android.TessBaseAPI;
import com.script.opencvapi.ScreenInfo;
import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.LtLog;

import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by Administrator on 2019-03-07.
 */


public class Answer {

    AtFairyImpl mFairy;
    TessBaseAPI tessBaseAPI;



    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public static String getHtml(String path) throws Exception {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if (conn.getResponseCode() == 200) {
            InputStream inStream = conn.getInputStream();
            byte[] data = readInputStream(inStream);
            String html = new String(data, "UTF-8");
            return html;
        }
        return null;
    }

    public void sendTongTask(String mToken, String answer) throws Exception {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd|HHmmss");
        String date = sDateFormat.format(new java.util.Date());
        LtLog.i(mFairy.getLineInfo("") + "-------" + "-------------....." + date.split("\\|"));
        String[] dataTime = date.split("\\|");
        String keyStr = dataTime[0] + "_"+ AtFairyConfig.getGameID()+"_" + answer + "_" + dataTime[1] + ".png";
        LtLog.i(mFairy.getLineInfo("") + "-------" + "-------------....." + keyStr);
        String filePath = "/sdcard/screen.png";
        httpPost(filePath, keyStr, mToken);
        fileDelete(filePath);
        return;
    }

    public boolean fileDelete(String strFile) {
        try {
            File f = new File(strFile);
            if (f.exists()) {
                f.delete();
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public String httpPost(String filePath, String key, String mToken)throws Exception {

        LtLog.i(mFairy.getLineInfo("") + "-------" + "-------------httpPost....." + mToken);
        try {
            JSONObject UrlJson = new JSONObject(mToken);
            LtLog.i(mFairy.getLineInfo("") + "-------" + "-------------httpPost....." + UrlJson.optString("data"));
            OkHttpClient client = new OkHttpClient();
            File file = new File(filePath);
            RequestBody body = RequestBody.create(MediaType.parse("image/*"), file);
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", "head_image", body)
                    .addFormDataPart("token", UrlJson.optString("data"))
                    .addFormDataPart("key", key)
                    .build();
            Request request = new Request.Builder()
                    .url("http://up-z2.qiniu.com/")
                    .post(requestBody)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                LtLog.i(mFairy.getLineInfo("") + "-------" + "-------------response....." + response.body().string());
                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "error";
    }

    //请求TID
    public String TIDhttpPost(String host, String TID, String suiji) {
        System.out.println(TID);
        String answer1 = null;
        int js = 0;
        js++;
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("id", TID)
                .addFormDataPart("r", suiji)
                .build();
        Request request = new Request.Builder()
                .url("http://" + host + "/GetAnswer.aspx")
                .post(requestBody)
                .build();
        try {
            //for (int i = 0; i <10 ; i++) {
            Response response = client.newCall(request).execute();
            //LtLog.i(publicFunction.getLineInfo() + "-------" + "-------------response=" + response.body().string() );
            String result = response.body().string();

            answer1 = response.toString();
            try {
                //  LtLog.i(publicFunction.getLineInfo() + "-------" + "-------------response=" + result);
                Thread.sleep(3000);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            //}
//            return response.toString();

        } catch (IOException e) {
            // LtLog.i(publicFunction.getLineInfo() + "-------" + "-------------response.....");
            e.printStackTrace();
        }
        return "error";

    }



    public String getNumber(int x, int y, int width, int height, Scalar minValue, Scalar maxValue)throws Exception {
        ScreenInfo screenInfo = mFairy.captureInterval();
        if(screenInfo.height>720){
            System.out.println("error Screen height >720");
            return null;
        }
        Mat mat=mFairy.getScreenMat(x,y,width,height,1, 0, 0, 1);
//        mat= Imgcodecs.imread("/sdcard/20181010_16_1_000742.png");

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

    public static String httpGet(String url) {
        String result = null;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String httpPost(String host, String suiji)throws Exception {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userstr", "yunpai|ACMXGAHOAZNDCEED")
                .addFormDataPart("gameid", "5001")
                .addFormDataPart("timeout", "60")
                .addFormDataPart("rebate", "3739|6A1962CC9E02B5B9")
                .addFormDataPart("daiLi", "haoi")
                .addFormDataPart("kou", "0")
                .addFormDataPart("beizhu", "2222")
                .addFormDataPart("ver", "web2")
                .addFormDataPart("key", suiji)
                .addFormDataPart("img", GetImageStr("/sdcard/yunpai_files/111.png"))
                .build();
        Request request = new Request.Builder()
                .url("http://" + host + "/UploadBase64.aspx")
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
//            LtLog.i(publicFunction.getLineInfo() + "-------" + "-------------response....." + response.body().string() + "---" + response.toString());
            String str = response.body().string();

            return str;
        } catch (IOException e) {
            LtLog.i(mFairy.getLineInfo("") + "-------" + "-------------response.....");
            e.printStackTrace();
        }
        return "error";
    }

    public String GetImageStr(String imgpath) {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgpath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对字节数组Base64编码

        // LtLog.i(publicFunction.getLineInfo() + "-------" + new String(android.util.Base64.encode(data, android.util.Base64.DEFAULT)) + "-------------response.....");
        return new String(android.util.Base64.encode(data, android.util.Base64.DEFAULT));//返回Base64编码过的字节数组字符串
    }
}
