package com.script.fairy;

import android.graphics.Bitmap;
import android.util.Base64;

import com.padyun.publicfunctionlibrary.FunctionClass;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }


    /**
     * 关闭影响接取任务的窗口（初始化）
     * @throws Exception
     */
    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                for (int i = 0; i < j; i++) {
                    result = mFairy.findPic("Yingling.png");
                    mFairy.onTap(0.8f,result,212,532,224,543,"",Sleep);
                    result = mFairy.findPic("quxiao.png");
                    mFairy.onTap(0.8f,result,"取消挂机",Sleep);
                    result = mFairy.findPic("introduction.png");
                    mFairy.onTap(0.8f,result,"退出",Sleep);
                    result = mFairy.findPic("introduction yes.png");
                    mFairy.onTap(0.8f,result,730,491,739,502,"确定退出",Sleep);
                    mFairy.condit();
                    result =mFairy.findPic(1033,2,1278,164,new String[]{"close right top.png","close right top2.png","cha.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);
                    result1 =mFairy.findPic(3,3,350,170,new String[]{"close left top.png","close left top2.png","close map.png"});
                    mFairy.onTap(0.7f,result1,"关闭",2000);
                    if (result.sim > 0.8f || result1.sim>0.7f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }
    int tastState = 0;
    /**
     * 日常入口
     * @param str
     * @throws Exception
     */
    public int mission(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public  void content_0() throws Exception {
                close();
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                setTaskName(1);

            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                mFairy.sleep(1000);
                result = mFairy.findPic("open.png");
                mFairy.onTap(0.8f, result, "展开", 2000);
                result = mFairy.findPic(new String[]{"schedule.png","schedule2.png"});
                mFairy.onTap(0.8f, result, "日程", 2000);

                result = mFairy.findPic(new String[]{"activity.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(21,183,698,860,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            //mFairy.onTap(106,144,136,160, "", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(240,604,248,613, "除魔", Sleep);
                        }
                        if (option == 2) {

                              mFairy.onTap(337,604,344,610, "对抗", Sleep);
                        }
                        if (option == 3) {

                            mFairy.onTap(426,605,435,611, "休闲", Sleep);
                        }
                    }
                    findtask++;
                    if (findtask > 2){
                        setTaskName(0);
                    }
                    setTaskName(2);
                }
            }
            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public   void content_2() throws Exception {
                result = mFairy.findPic("red.png");
                mFairy.onTap(0.8f,result,1171,150,1184,159,"活跃礼包",Sleep);
                result1 = mFairy.findPic(58,10,1224,710,str);
                LtLog.e("寻找任务相似度1"+result1.sim);
                if (result1.sim > 0.7f) {
                    LtLog.e("找到任务");// 891  395    875,529,958,665
                    LtLog.e("***"+(result1.x -16)+","+(result1.y +20)+","+(result1.x +67)+","+(result1.y +340));

                    result = mFairy.findPic(result1.x -16, result1.y +20, result1.x +67, result1.y +340, new String[]{"finished2.png"});//"Finished.png","over2.png",
                    LtLog.e("寻找任务相似度3"+result.sim);
                    if (result.sim >= 0.7f) {
                        LtLog.e("任务结束");
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(result1.x -16, result1.y +134, result1.x +67, result1.y +340,new String[]{"Go now.png","Go now2.png","canjia.png"});//128,281   627,287 "Go now.png","Go now2.png","canjia.png""hlsjoin.png"
                    mFairy.onTap(0.65f, result, "日常前往", 1000); // - 499   -6
                    LtLog.e("寻找任务相似度2"+result.sim);
                    if (result.sim >= 0.65f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                }
                if (overtime(15, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }


    public void srAIAnswer() throws Exception {
        List<String> answerStrABCD = new ArrayList();
        result = this.mFairy.findPic("pingmu.png");
        mFairy.onTap(0.8f,result,"点击屏幕继续",1000);
        String mStr = getPictureText(220,135,843,88);//题目范围x,y,w,h
        LtLog.e(this.mFairy.getLineInfo("题目是=" + mStr));
        if (mStr == null || mStr.equals("")) {
            this.mFairy.onTap(457,547,467,558, "没有识别到题目,默认", 1000);
        } else {
            answerStrABCD.add(getPictureText(371,468,295,67));//A范围x,y,w,h
            answerStrABCD.add(getPictureText(712,470,294,61));//B范围x,y,w,h

            String c = getPictureText(373,548,292,62);
            if (!c.equals("")) {
                answerStrABCD.add(c);//C范围x,y,w,h
            }
            String d = getPictureText(711,552,295,62);
            if (!d.equals("")) {
                answerStrABCD.add(d);//C范围x,y,w,h
            }

            String[] answer = this.findAnswer(mStr, AtFairyConfig.getGameID());
            if (answer != null) {
                LtLog.e(mFairy.getLineInfo("开始匹配答案："));
                for (int j = 0; j < answerStrABCD.size(); ++j) {
                    LtLog.e(j + " : " + answerStrABCD.get(j));

                    for (int i = 0; i < answer.length; ++i) {
                        if (answerStrABCD.get(j).equals(answer[i])) {
                            switch (j) {
                                case 0:
                                    mFairy.onTap(402,494,410,505, "匹配到正确答案A", 1000);
                                    break;
                                case 1:
                                    mFairy.onTap(777,492,789,503, "匹配到正确答案B", 1000);
                                    break;
                                case 2:
                                    mFairy.onTap(436,572,445,585, "匹配到正确答案C", 1000);
                                    break;
                                case 3:
                                    mFairy.onTap(775,572,788,583, "匹配到正确答案D", 1000);
                                    break;
                            }
                           // mFairy.onTap(604,278,611,287, "", 3000);
                            return;
                        }
                    }
                }
            }

            LtLog.e(this.mFairy.getLineInfo("没有匹配到,开始上传"));
            LtLog.i(this.mFairy.getLineInfo("----------------------------upDown>"));
            String answerStr = "";
            this.mFairy.onTap(457,547,467,558, "A", 1000);
            for (int i = 0; i < 10; ++i) {
                result = this.mFairy.findPic(556,455,689,540, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(0);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---A---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(906,449,1026,540, "str1.png");
                if (result.sim > 0.8f) {
                    answerStr = answerStrABCD.get(1);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---B---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(580,535,690,615, "str1.png");
                if (result.sim > 0.8f) {
                    answerStr = answerStrABCD.get(2);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---C---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(912,533,1035,621, "str1.png");
                if (result.sim > 0.8f) {
                    answerStr = answerStrABCD.get(3);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---D---" + answerStr));
                    break;
                }
                Thread.sleep(200);
            }

            if (answerStr != "") {
                this.UpAnswerAndTitle(mStr, answerStr, AtFairyConfig.getGameID());
            }
        }
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

    public String getPictureText(int x, int y, int width, int height) {
        //331, 165, 811, 109
        Mat mat = mFairy.getScreenMat(x, y, width, height, 1, 0, 0, 1);
        Bitmap bmpCanny = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(mat, bmpCanny);

        String str = trWebOCR("http://192.168.1.254:8089/api/tr-run/", bmpCanny);
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

    private String[] findAnswer(String title, String game_id) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String resultStr = null;
        Request request = (new Request.Builder()).url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/FindTheAnswer?title=" + title + "&game_id=" + game_id).get().build();
        Response response = client.newCall(request).execute();
        resultStr = response.body().string();
        resultStr = (new JSONTokener(resultStr)).nextValue().toString();
        JSONObject jsonObject = new JSONObject(resultStr);
        if (jsonObject.getString("data").equals("false")) {
            LtLog.i(this.mFairy.getLineInfo("-----------+++---------not title"));
            return null;
        } else {
            String arr = jsonObject.getString("data").replaceAll("\\[", "");
            arr = arr.replaceAll("\\]", "");
            arr = arr.replaceAll("\"", "");
            String[] array = arr.split(",");
            LtLog.i(this.mFairy.getLineInfo("-----------+++---------array=" + array));
            return array;
        }
    }

    private void UpAnswerAndTitle(String title, String answer, String game_id) throws InterruptedException {
        String resultStr = null;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "title=" + title + "&game_id=" + game_id + "&answer=" + answer);
        Request request = (new Request.Builder()).url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/AddTitle").post(body).build();

        try {
            Response response = client.newCall(request).execute();
            resultStr = response.body().string();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        Thread.sleep(100L);
    }



    //验证
    public void yanzheng() throws Exception {
        result = mFairy.findPic("password.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("验证中>>>"));
            err = 0;
            Thread.sleep(1000);
            String result_ha = haoai();
            if (!result_ha.equals("") && result_ha != null) {
                try {
                    String[] aa = result_ha.split("\\|");
                    for (String st : aa) {
                        mFairy.tap(Integer.parseInt(st.split(",")[0]) + 380, Integer.parseInt(st.split(",")[1]) + 44);
                        Thread.sleep(500);
                    }

                    mFairy.onTap(628,311,638,319, "确定", 3000);

                    result = mFairy.findPic("password.png");
                    mFairy.onTap(0.8f, result, 889,123,899,135,"没有验证出来,刷新", 5000);

                } catch (Exception e) {
                    LtLog.e(mFairy.getLineInfo("验证报错!!!"));
                    LtLog.e(mFairy.getLineInfo("验证报错!!!"));
                    LtLog.e(mFairy.getLineInfo("验证报错!!!"));
                }
            } else {
                LtLog.e(mFairy.getLineInfo("验证为空!!!"));
                LtLog.e(mFairy.getLineInfo("验证为空!!!"));
                LtLog.e(mFairy.getLineInfo("验证为空!!!"));
            }
        }
    }//验证

    private String haoai() throws Exception {
        Thread.sleep(500);

        String host, token1;
        String answerhui = null;

        Mat mat3, mat2;
        mat3 = mFairy.getScreenMat(0, 0, 1280, 720, 1, 0, 0, 1);
        //将图片存入路径
        //Mat转byte[]
        Imgcodecs.imwrite("/sdcard/screen.png", mat3);

        FunctionClass functionClass = new FunctionClass(mFairy, mFairy.getContext());

        //开始截图
        mat2 = mFairy.getScreenMat(381,45,557,640, 1, 0, 0, 1);
        //将图片存入路径
        //Mat转byte[]
        Imgcodecs.imwrite("/sdcard/yunpai_files/111.png", mat2);
//            byte[] grayData = new byte[mat2.cols() * mat2.rows()];
//            mat2.get(0, 0, grayData);
//            LtLog.i(publicFunction.getLineInfo() + "-------" + grayData[1] + "-------------response....." + grayData.length);
//            String byte64 = Bypass(grayData);
//            LtLog.i(publicFunction.getLineInfo() + "-------"+ byte64+ "-------------response.....");
        //System.out.println("字节是" + byte64);
        //这里获取好爱HOST
        LtLog.i(mFairy.getLineInfo("开始获取好爱的HOST"));
        try {
            host = getHtml("http://3.haoi23.net/svlist.html");
            if (host == null) {
                host = getHtml("http://3.haoi23.net/svlist.html");
            }
            String str = host;
            host = str.substring(3, 23);
            LtLog.i(mFairy.getLineInfo("host===" + host));
            //System.out.println(host);
            LtLog.i(mFairy.getLineInfo("获取完成"));
            LtLog.i(mFairy.getLineInfo("请求数据"));


            String a = String.valueOf((int) (1 + Math.random() * 9));
            String b = String.valueOf((int) (1 + Math.random() * 9));
            String c = String.valueOf((int) (1 + Math.random() * 9));
            String d = String.valueOf((int) (1 + Math.random() * 9));
            String e = String.valueOf((int) (1 + Math.random() * 9));
            String f = String.valueOf((int) (1 + Math.random() * 9));
            String g = String.valueOf((int) (1 + Math.random() * 9));
            String h = String.valueOf((int) (1 + Math.random() * 9));
            String ii = String.valueOf((int) (1 + Math.random() * 9));
            String j = String.valueOf((int) (1 + Math.random() * 9));
            String suiji = a + b + c + d + e + f + g + h + ii + j;
            LtLog.i(mFairy.getLineInfo("得到的随机数" + suiji));

            String fanhui = httpPost(host, suiji);

            LtLog.i(mFairy.getLineInfo("请求完成,开始请求TID,TID为" + fanhui));
            a = String.valueOf((int) (1 + Math.random() * 9));
            b = String.valueOf((int) (1 + Math.random() * 9));
            c = String.valueOf((int) (1 + Math.random() * 9));
            d = String.valueOf((int) (1 + Math.random() * 9));
            e = String.valueOf((int) (1 + Math.random() * 9));
            f = String.valueOf((int) (1 + Math.random() * 9));
            g = String.valueOf((int) (1 + Math.random() * 9));
            h = String.valueOf((int) (1 + Math.random() * 9));
            ii = String.valueOf((int) (1 + Math.random() * 9));
            j = String.valueOf((int) (1 + Math.random() * 9));
            suiji = a + b + c + d + e + f + g + h + ii + j;

            for (int i = 0; i < 15; i++) {
                answerhui = TIDhttpPost(host, fanhui, suiji);
                Thread.sleep(100);
                if (answerhui == "#编号不存在" || answerhui == "#超时") {
                    return null;
                }
                if (!answerhui.equals("")) {
                    LtLog.e("结果为：" + answerhui);
                    return answerhui;
                }

            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
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
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    private String httpPost(String host, String suiji) throws Exception {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userstr", "yunpai|ACMXGAHOAZNDCEED")
                .addFormDataPart("gameid", "6004")
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

    private String GetImageStr(String imgpath) {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
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
        return new String(Base64.encode(data, Base64.DEFAULT));//返回Base64编码过的字节数组字符串
    }

    private static String getHtml(String path) throws Exception {
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

    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    private String TIDhttpPost(String host, String TID, String suiji) {
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



    //传送城市
    int cityCount;

    public int goCity(final String str, final String x, final String y) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close();
                setTaskName(1);
                return;
            }


            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic("bag.png");
                mFairy.onTap(0.8f, result, 1176,101,1185,108, "打开地图", 3000);

                result1 = mFairy.findPic("twsh_inface.png");
                result = mFairy.findPic("World map.png");
                mFairy.onTap(0.8f, result, "切换到世界", 2000);
                if (result1.sim > 0.8f) {
                    switch (str) {
                        case "萤川郡":
                            mFairy.onTap(937,160,949,167, str, 2500);
                            break;
                        case "灵虚":
                            mFairy.onTap(756,337,767,347, str, 2500);
                            break;
                        case "伞村":
                            mFairy.onTap(708,503,717,510, str, 2500);
                            break;
                        case "云波之境":
                            mFairy.onTap(811,55,825,61, str, 2500);
                            break;
                        case "汐愿之海":
                            mFairy.onTap(865,644,879,650, str, 2500);
                            break;
                        case "亡命岛":
                            mFairy.onTap(1179,528,1188,538, str, 2000);
                            mFairy.onTap(1111,458,1125,465, str, 2500);
                            break;

                        case "苏澜郡":
                            mFairy.onTap(932,390,954,395, str, 2000);
                          //  mFairy.onTap(1111,458,1125,465, str, 2500);
                            break;

                    }
                    setTaskName(2);
                    return;
                }
            }
            public void content_2() throws Exception {

                mFairy.onTap(1062,95,1067,99,"坐标1",2000);
                mFairy.inputText(x);
                mFairy.onTap(1210,168,1220,177,"确定",2000);

                mFairy.onTap(1142,97,1150,103,"坐标2",2000);
                mFairy.inputText(y);
                mFairy.onTap(1210,168,1220,177,"确定",2000);

                mFairy.onTap(1222,101,1230,105,"前往",2000);
                setTaskName(3);return;


            }
            public void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(604,52,63,12, 0.9f);
                if (dazeTime > 3) {
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    GameUtil.this.cityCount = 1;
                    setTaskEnd();
                    return;
                }
                Thread.sleep(3000);
            }

        }.taskContent(mFairy, "传送城市中");
        return cityCount;
    }
}
