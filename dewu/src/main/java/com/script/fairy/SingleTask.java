package com.script.fairy;

import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.Base64;

import com.qiniu.android.http.request.httpclient.MultipartBody;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import androidx.annotation.RequiresApi;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by Administrator on 2019/3/25 0025.
 */
public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;

    public SingleTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gameUtil = new GameUtil(mFairy);
    }
    //新手引导
    int sum = 0,n=1,x=1,s=1;
    String Price="";
    Mat mat;
    public void novice() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(579, 1181, 680, 1279, "me.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "我的", Sleep);
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 531, 185, 532, 586, 1000, 1500, 2);
                }


                result = mFairy.findPic(142, 281, 557, 413, "dl.png");
                if (result.sim > 0.8f) {
                    LtLog.e("需要登录！！！");
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(23, 516, 698, 725, new String[]{"xiangyao.png","sc.png"});
                mFairy.onTap(0.8f, result, "想要的", Sleep);

                if (x > 3) {
                    x=1;

                    mFairy.touchDown(272,1165);
                    mFairy.touchMove(270,314,1500);
                    mFairy.sleep(1000);
                    mFairy.touchUp();
                }

                switch (x) {
                    case 1:
                        result = mFairy.findPic(4,301,716,568, "dewu1.png");
                        mFairy.onTap(0.8f, result, "选择商品", Sleep);
                        break;
                    case 2:
                        result = mFairy.findPic(4,564,716,827, "dewu1.png");
                        mFairy.onTap(0.8f, result, "选择商品", Sleep);
                        break;
                    case 3:
                        result = mFairy.findPic(14,828,714,1090, "dewu1.png");
                        mFairy.onTap(0.8f, result, "选择商品", Sleep);
                        break;
                }
                result2 = mFairy.findPic(417, 47, 714, 143, "fenxiang.png");
                result1 = mFairy.findPic(15,237,335,1143, "probably.png");
                if (result.sim > 0.8f || result2.sim > 0.8f) {
                    sum=0;
                    setTaskName(2);
                    return;
                }else if (result1.sim > 0.8f){
                    LtLog.e("结束！！！");
                    setTaskEnd();
                    return;
                }

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void content_2() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(347, 919, 633, 1078, "agree.png");
                mFairy.onTap(0.8f, result, "err同意协议", Sleep);

                result = mFairy.findPic(378, 1146, 708, 1268, "goumai.png");
                if (result.sim > 0.8 && sum == 0) {
                    mFairy.onTap(0.8f, result, "购买", Sleep);
                }

                result = mFairy.findPic(195, 302, 400, 469, "yixuan.png");
                if (result.sim > 0.8 && sum == 0) {
                    Price = getPictureText(234,326,120,44);
                    if (Price == null || Price.equals("") || Price == "无售价" || Price.equals("无售价")){
                        Price = "0.0";
                    }
                    LtLog.e("价格界面截图第"+s+"个");
                    LtLog.e("商品价格"+Price);
                    mat = mFairy.getScreenMat(1, 1, 716,1100, 1, 0, 0, 1);
                    Imgcodecs.imwrite("/sdcard/Price_" + s + "_" + Price + ".png", mat);
                    sum = 1;
                    LtLog.e( sendTongTask( getToken(),"Price_" + s + "_" + Price));

                    /*upload(s);*/
                }

                result = mFairy.findPic(417, 47, 714, 143, "fenxiang.png");
                if (sum == 1 && result.sim > 0.8) {
                    result = mFairy.findPic(630, 301, 710, 391, "cha2.png");
                    mFairy.onTap(0.8f, result, "关叉2", Sleep);

                    result = mFairy.findPic(9, 362, 251, 1109, "zjgm.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "最近购买", Sleep);
                    }else{
                        LtLog.e("滑动");
                        mFairy.touchDown(294,950);
                        mFairy.touchMove(333,200,1500);
                        mFairy.sleep(1000);
                        mFairy.touchUp();
                    }
                    result = mFairy.findPic(193, 54, 523, 148, "zuijin.png");
                    if (result.sim > 0.8f) {
                        sum = 2;
                        for (int y=0;y<=n;y++) {
                            result = mFairy.findPic(23, 1200, 704, 1270, "money.png");
                            if (result.sim > 0.8f) {
                                LtLog.e("最近购买界面截图-第" + s+"个的第"+(y+1) + "张");
                                mat = mFairy.getScreenMat(1, 1, 716, 1100, 1, 0, 0, 1);
                                Imgcodecs.imwrite("/sdcard/Recent purchase_" + s + "_" + Price +" of "+(y+1)+ ".png", mat);
                                LtLog.e(sendTongTask( getToken(),"Recent purchase_" + s + "_" + Price +" of "+(y+1)));

                                mFairy.touchDown(191,1244);
                                mFairy.touchMove(191,441,1500);
                                mFairy.sleep(1000);
                                result = mFairy.findPic(225,906,498,1275, "expect.png");
                                if (result.sim > 0.8) {
                                }else{
                                    n++;
                                }
                                mFairy.touchUp();

                                /*upload(y);*/
                            }
                        }
                        x++;
                        s++;
                        result = mFairy.findPic(19, 52, 101, 132, "fanhui.png");
                        mFairy.onTap(0.85f, result, "返回", Sleep);
                        mFairy.onTap(0.85f, result, "返回", Sleep);
                        setTaskName(1);
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "全部截图中");
    }

    public void novice1() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(579, 1181, 680, 1279, "me.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "我的", Sleep);
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 531, 185, 532, 586, 1000, 1500, 2);
                }


                result = mFairy.findPic(142, 281, 557, 413, "dl.png");
                if (result.sim > 0.8f) {
                    LtLog.e("需要登录！！！");
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(23, 516, 698, 725, new String[]{"xiangyao.png","sc.png"});
                mFairy.onTap(0.8f, result, "想要的", Sleep);

                if (x > 3) {
                    x=1;

                    mFairy.touchDown(272,1165);
                    mFairy.touchMove(270,314,1500);
                    mFairy.sleep(1000);
                    mFairy.touchUp();
                }

                switch (x) {
                    case 1:
                        result = mFairy.findPic(4,301,716,568, "dewu1.png");
                        mFairy.onTap(0.8f, result, "选择商品", Sleep);
                        break;
                    case 2:
                        result = mFairy.findPic(4,564,716,827, "dewu1.png");
                        mFairy.onTap(0.8f, result, "选择商品", Sleep);
                        break;
                    case 3:
                        result = mFairy.findPic(14,828,714,1090, "dewu1.png");
                        mFairy.onTap(0.8f, result, "选择商品", Sleep);
                        break;
                }
                result2 = mFairy.findPic(417, 47, 714, 143, "fenxiang.png");
                result1 = mFairy.findPic(15,237,335,1143, "probably.png");
                if (result.sim > 0.8f || result2.sim > 0.8f) {
                    sum=0;
                    setTaskName(2);
                    return;
                }else if (result1.sim > 0.8f){
                    LtLog.e("结束！！！");
                    setTaskEnd();
                    return;
                }

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            public void content_2() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(347, 919, 633, 1078, "agree.png");
                mFairy.onTap(0.8f, result, "err同意协议", Sleep);

                result = mFairy.findPic(378, 1146, 708, 1268, "goumai.png");
                if (result.sim > 0.8 && sum == 0) {
                    mFairy.onTap(0.8f, result, "购买", Sleep);
                }

                result = mFairy.findPic(195, 302, 400, 469, "yixuan.png");
                if (result.sim > 0.8 && sum == 0) {
                    Price = getPictureText(234,326,120,44);
                    if (Price == null || Price.equals("") || Price == "无售价" || Price.equals("无售价")){
                        Price = "0.0";
                    }
                    LtLog.e("价格界面截图第"+s+"个");
                    LtLog.e("商品价格"+Price);
                    mat = mFairy.getScreenMat(1, 1, 716,1100, 1, 0, 0, 1);
                    Imgcodecs.imwrite("/sdcard/Price_" + Price + "_" + s + ".png", mat);
                    sum = 1;
                    LtLog.e( sendTongTask( getToken(),"Price_" + s + "_" + Price));

                    /*upload(s);*/
                }

                result = mFairy.findPic(417, 47, 714, 143, "fenxiang.png");
                if (sum == 1 && result.sim > 0.8) {
                    result = mFairy.findPic(630, 301, 710, 391, "cha2.png");
                    mFairy.onTap(0.8f, result, "关叉2", Sleep);

                    result = mFairy.findPic(9, 362, 251, 1109, "zjgm.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "最近购买", Sleep);
                    }else{
                        LtLog.e("滑动");
                        mFairy.touchDown(294,950);
                        mFairy.touchMove(333,200,1500);
                        mFairy.sleep(1000);
                        mFairy.touchUp();
                    }
                    result = mFairy.findPic(193, 54, 523, 148, "zuijin.png");
                    if (result.sim > 0.8f) {
                        sum = 2;
                       // for (int y=0;y<=n;y++) {
                            result = mFairy.findPic(23, 1200, 704, 1270, "money.png");
                            if (result.sim > 0.8f) {
                                LtLog.e("最近购买界面截图-价格_" + Price + "_第" + s+"个的第"+(1) + "张");
                                mat = mFairy.getScreenMat(1, 1, 716, 1100, 1, 0, 0, 1);
                                Imgcodecs.imwrite("/sdcard/Recent purchase_" + Price + "_" + s +" of "+(1)+ ".png", mat);
                                LtLog.e(sendTongTask( getToken(),"Recent purchase_" + Price + "_" + s +" of "+(1)));

                               /* mFairy.touchDown(191,1244);
                                mFairy.touchMove(191,441,1500);
                                mFairy.sleep(1000);
                                result = mFairy.findPic(225,906,498,1275, "expect.png");
                                if (result.sim > 0.8) {
                                }else{
                                    n++;
                                }
                                mFairy.touchUp();*/
                            }
                       // }
                        x++;
                        s++;
                        result = mFairy.findPic(19, 52, 101, 132, "fanhui.png");
                        mFairy.onTap(0.85f, result, "返回", Sleep);
                        mFairy.onTap(0.85f, result, "返回", Sleep);
                        setTaskName(1);
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "最新截图中");
    }

    public void inOperation() throws Exception {


    }


    public String getToken() {
        String access_key = "cCApuzlAtKeWBg6G0Ezt2Zpxv-Z4hnnYC53DJvnz";
        String secret_key = "MFOPlsyTpBlu_doiizNjSCTwRrhOlImITuGSmRMT";
        SecretKey secretKey = new SecretKeySpec(secret_key.getBytes(Charset.forName("UTF-8")), "HmacSHA1");
        JSONObject jsonObject = new JSONObject();
        long time = System.currentTimeMillis();

        try {
            jsonObject.put("scope", "padyunexcel");
            jsonObject.put("deadline", time);
        } catch (JSONException var18) {
            var18.printStackTrace();
        }

        String strBase64 = null;
        String data = jsonObject.toString();
        strBase64 = Base64.encodeToString(data.getBytes(Charset.forName("UTF-8")), 10);
        Mac mac = null;

        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKey);
        } catch (InvalidKeyException var16) {
            var16.printStackTrace();
        } catch (NoSuchAlgorithmException var17) {
            var17.printStackTrace();
        }

        byte[] digest = mac.doFinal(strBase64.getBytes(Charset.forName("UTF-8")));
        String encodedSign = Base64.encodeToString(digest, 10);
        JSONObject returnjsonObject = new JSONObject();

        try {
            returnjsonObject.put("code", 0);
            returnjsonObject.put("msg", "");
            returnjsonObject.put("data", access_key + ":" + encodedSign + ":" + strBase64);
        } catch (JSONException var15) {
            var15.printStackTrace();
        }

        String return_val = returnjsonObject.toString();
        return return_val;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String sendTongTask(String token, String imageName) throws Exception {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMdd|HHmmss");
        String date = sDateFormat.format(new java.util.Date());
        LtLog.e("-----------------....." + date.split("\\|"));
        String[] dataTime = date.split("\\|");

        String keyStr =imageName + "_" +AtFairyConfig.getGameID() + dataTime[1] + "_" +dataTime[0]+ ".png";
        LtLog.e("-----------------....." + keyStr);
        String filePath = "/sdcard/"+imageName+".png";

        String s = httpPost(filePath, keyStr, token);
        fileDelete(filePath);
        return s;
    }

    public String httpPost(String filePath, String key, String mToken) throws Exception {

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

    public boolean fileDelete(String strFile) {
        try {
            File f = new File(strFile);
            if (f.exists()) {
                f.delete();
                LtLog.e("删除成功");
                return true;
            }
        } catch (Exception e) {
            LtLog.e("删除失败");
            return false;


        }

        return false;
    }

    public String getPictureText(int x, int y, int width, int height) {

        Mat mat = mFairy.getScreenMat(x, y, width, height, 1, 0, 0, 1);

        Bitmap bmpCanny = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);

        org.opencv.android.Utils.matToBitmap(mat, bmpCanny);

        String str = trWebOCR("http://192.168.1.254:8089/api/tr-run/", bmpCanny);
        LtLog.e("bmpCanny:"+bmpCanny);
        LtLog.e("str:"+str);
        if (str == null || str.equals("")) {
            return "";
        }

        LtLog.e("trWebOCR :" + str);

        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) new JSONObject(new JSONObject(str).get("data").toString()).get("raw_out");
            String mStr = new JSONArray(jsonArray.get(0).toString()).get(1).toString();
            return mStr;
        } catch (JSONException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "";
    }

    public String trWebOCR(String url, Bitmap bitmap) {
        String result = null;
        String imgBase64 = bitmapToBase64(bitmap, 50);
        try {
            FormBody.Builder builder = new FormBody.Builder();

            builder.add("img", imgBase64);
            RequestBody formBody = builder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String bitmapToBase64(Bitmap bitmap, int quality) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
