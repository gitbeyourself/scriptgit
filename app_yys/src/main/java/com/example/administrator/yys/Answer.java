package com.example.administrator.yys;

import android.graphics.Bitmap;

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
    private yys mFairy;
    private Random rand = new Random();
    private String pathAnswer = "/sdcard/yunpai_files/answer.png";
    private String game_id;
    private List<Integer> title_Range;
    private List<Integer> answer_Range;
    private List<Integer> answer_Range1;
    private int selectIndex=0;//选项数量
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
    public Answer(yys ypFairy) {
        mFairy = ypFairy;
        publicFunction = new PublicFunction(mFairy);
        commonFunction = new CommonFunction(mFairy);
    }

    public Map<String,List<Integer>> initializationMap(){
        Map<String,List<Integer>> mMap= new HashMap<>();
        mMap.put("game_id", null);
        mMap.put("title_Range",null);
        mMap.put("answer_Range",null);
        mMap.put("answer_Range1",null);
       /* mMap.put("title_toValue_min",null);
        mMap.put("title_toValue_max",null);
        mMap.put("answer_toValue_min", null);
        mMap.put("answer_toValue_max",null);*/
        mMap.put("pic_range",null);
        //mMap.put("right_pic_Relative_range",null);
        return mMap;
    }

    public void mAnswer(Map<String,List<Integer>> mMap,String picName) throws Exception {
        LtLog.i(publicFunction.getLineInfo() + "----------------------------mMap>" + mMap);
        game_id=Integer.toString(mMap.get("game_id").get(0)); //游戏id
        if(game_id==null){
            game_id= AtFairyConfig.getGameID();
        }
        title_Range=mMap.get("title_Range");//题目范围 x1,y1,w,h
        answer_Range=mMap.get("answer_Range");//答案范围 A x1,y1 B x1,y1 ..... 最后两个参数为 宽高 w , h。。。。注意答案范围必须 在可点击选中的范围内
        answer_Range1=mMap.get("answer_Range1");//答案的范围 A的区域 B的区域.....


        /*title_toValue_min=mMap.get("title_toValue_min");//题目二值化范围最小值 R,G,B
        title_toValue_max=mMap.get("title_toValue_max");//题目二值化范围 最大值 R,G,B
        answer_toValue_min=mMap.get("answer_toValue_min");//答案二值化范围 最小值 R,G,B
        answer_toValue_max=mMap.get("answer_toValue_max");//答案二值化范围 最大值 R,G,B
        answer_toValue_max=mMap.get("answer_toValue_max");//答案二值化范围 最大值 R,G,B*/



        pic_range=mMap.get("pic_range");//判断正确答案识别图的范围
        //right_pic_Relative_range=mMap.get("right_pic_Relative_range"); //判断正确答案后偏移值 取正确答案的范围 x,y,w,h
        right_pic=picName;//判断正确答案的识别图
     /*   LtLog.i(publicFunction.getLineInfo() + "----------------------------game_id>" + game_id);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------title_Range>" + title_Range);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------answer_Range>" + answer_Range);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------title_toValue_min>" + title_toValue_min);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------title_toValue_max>" + title_toValue_max);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------answer_toValue_min>" + answer_toValue_min);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------answer_toValue_max>" + answer_toValue_max);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------pic_range>" + pic_range);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------right_pic_Relative_range>" + right_pic_Relative_range);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------right_pic>" + right_pic);
        LtLog.i(publicFunction.getLineInfo() + "----------------------------answer_Range>" + answer_Range.size());*/

        answer_Range_w=answer_Range.get(answer_Range.size()-2);
        answer_Range_h=answer_Range.get(answer_Range.size()-1);
      /*  LtLog.i(publicFunction.getLineInfo() + "----------------------------answer_Range_w>" + answer_Range_w + ",answer_Range_h=" + answer_Range_h);*/
        selectIndex=(answer_Range.size()-2)/2;
      /*  LtLog.i(publicFunction.getLineInfo() + "----------------------------selectIndex>" + selectIndex);*/
        AIAnswer();
    }


    public void AIAnswer() throws Exception {
        //int[][] rangeArray = {{519, 228}, {864, 225}, {522, 360}, {862, 361}};
        String answerStr = "";
        String mStr;
        List<String> answerStrABCD = new ArrayList<String>();
     /*   Imgcodecs.imwrite("/sdcard/" + Integer.toString((int)System.currentTimeMillis()) + ".png", mFairy.getScreenMat(0, 0, 1280, 720, 1, 0, 0, 1));//保存当前截图
        Imgcodecs.imwrite(pathAnswer, mFairy.getScreenMat(0, 0, 1280, 720, 1, 0, 0, 1));//保存当前截图*/
        if(title_toValue_min != null && title_toValue_max != null){
          //  LtLog.i(publicFunction.getLineInfo() + "----------------------------title_toValue_min" );
            mStr=getAnswerOcr(title_Range.get(0), title_Range.get(1), title_Range.get(2), title_Range.get(3),title_toValue_min,title_toValue_max);
            Thread.sleep(100);
        }else {
          //  LtLog.i(publicFunction.getLineInfo() + "----------------------------not  title_toValue_min" );
            mStr = mFairy.ocr(title_Range.get(0), title_Range.get(1), title_Range.get(2), title_Range.get(3));
            LtLog.e(commonFunction.getLineInfo("题目是="+mStr));
        }
      //  LtLog.i(publicFunction.getLineInfo() + "----------------------------" + mStr);
        if(mStr.isEmpty()){
            LtLog.e(commonFunction.getLineInfo("没有找到题目,默认选A"));
            publicFunction.rndTapWH(answer_Range.get(0),answer_Range.get(1),answer_Range_w,answer_Range_h);
            Thread.sleep(3000);
            return;
        }
       // List<String> answerStrABCD=null;
        for (int j = 0; j < answer_Range.size()-2; j=j+2) {
            if(answer_toValue_min != null && answer_toValue_max!= null){
                answerStr = getAnswerOcr(answer_Range.get(j), answer_Range.get(j+1), answer_Range_w, answer_Range_h,answer_toValue_min,answer_toValue_max);
            }else {
                Thread.sleep(10000);
                LtLog.e(commonFunction.getLineInfo("x="+answer_Range.get(j)+",y="+ answer_Range.get(j+1)+",w="+ answer_Range_w+",h="+ answer_Range_h));
                answerStr=mFairy.ocr(answer_Range.get(j), answer_Range.get(j+1), answer_Range_w, answer_Range_h);
               // LtLog.e(commonFunction.getLineInfo("answerStr="+answerStr));
            }
            if (j==0){
                answerStrABCD.add(answerStr);
                LtLog.e(commonFunction.getLineInfo("A是="+answerStr));
            }
            if (j==2){
                answerStrABCD.add(answerStr);
                LtLog.e(commonFunction.getLineInfo("B是="+answerStr));
            }
            if (j==4){
                answerStrABCD.add(answerStr);
                LtLog.e(commonFunction.getLineInfo("C是="+answerStr));
            }
            if (j==6){
                answerStrABCD.add(answerStr);
                LtLog.e(commonFunction.getLineInfo("D是="+answerStr));
            }

        }
        String[] answer = findAnswer(mStr, game_id);//查找答案
       // LtLog.i(publicFunction.getLineInfo() + "----------------------------" + answer + ",length=" + answer.length);
        Thread.sleep(100);
        if (answer.length == 0) {
            LtLog.e(commonFunction.getLineInfo("找到题目了但没有答案,开始上传"));
            upDown(mStr,answerStrABCD);
            Thread.sleep(100);
            return;
        } else {
          //  LtLog.i(publicFunction.getLineInfo() + "----------------------------" + answer + "," + answer.length);
            for (int j = 0; j < answerStrABCD.size(); j++) {
                for (int i = 0; i < answer.length; i++) {
                    LtLog.e(commonFunction.getLineInfo("-----answer=" + answer[i] + "," +"answerStrABCD.get=="+answerStrABCD.get(j)+","+ answer[i].equals(answerStrABCD.get(j))));
                  //  LtLog.i(publicFunction.getLineInfo() + "----------------------------answer=" + answer[i] + "," + answer[i].equals(answerStr));
                    if (answer[i].equals(answerStrABCD.get(j))) {
                       // LtLog.i(publicFunction.getLineInfo() + "----------------------------answer=" + answer[i] + ",j=" + j);
                        if (j==0){
                            LtLog.e(commonFunction.getLineInfo("正确答案A是="+answerStrABCD.get(j)));
                            publicFunction.rndTapWH(answer_Range.get(0), answer_Range.get(1), answer_Range_w, answer_Range_h);
                        }
                        if (j==1){
                            LtLog.e(commonFunction.getLineInfo("正确答案B是="+answerStrABCD.get(j)));
                            publicFunction.rndTapWH(answer_Range.get(2), answer_Range.get(3), answer_Range_w, answer_Range_h);
                        }
                        if (j==2){
                            LtLog.e(commonFunction.getLineInfo("正确答案C是="+answerStrABCD.get(j)));
                            publicFunction.rndTapWH(answer_Range.get(4), answer_Range.get(5), answer_Range_w, answer_Range_h);
                        }
                        if (j==3){
                            LtLog.e(commonFunction.getLineInfo("正确答案D是="+answerStrABCD.get(j)));
                            publicFunction.rndTapWH(answer_Range.get(6), answer_Range.get(7), answer_Range_w, answer_Range_h);
                        }
                        Thread.sleep(1000);
                        return;
                    }
                }
            }
            upDown(mStr,answerStrABCD);
        }
     //   publicFunction.fileDelete(pathAnswer);//删除图片
    }

    //选择答案并且上传题目和答案
    public void upDown(String mAswer, List<String> answerStrABCD) throws Exception {
        LtLog.i(publicFunction.getLineInfo() + "----------------------------upDown>" );
        FindResult result;
        String answerStr = "";
        String mStr = mAswer;
        rndTapWH(answer_Range.get(0), answer_Range.get(1), answer_Range_w, answer_Range_h);//选择A
        for (int i = 0; i < 50; i++) {
            result = mFairy.findPic2(pic_range.get(0), pic_range.get(1), pic_range.get(2), pic_range.get(3), right_pic);
            if (result.sim >= 0.7) {
               /* LtLog.i(publicFunction.getLineInfo() + "----------------------------cancel2>" + result);
                answerStr = mFairy.ocr(result.x +right_pic_Relative_range.get(0), result.y+right_pic_Relative_range.get(1), right_pic_Relative_range.get(2), right_pic_Relative_range.get(3));*/
                if ((result.x > answer_Range1.get(0) && result.y > answer_Range1.get(1) && result.x <  answer_Range1.get(2) && result.y < answer_Range1.get(3)) && answer_Range1.size()>1) {
                    LtLog.e(commonFunction.getLineInfo( "正确答案是A"));
                    answerStr=answerStrABCD.get(0);
                }
                if ((result.x > answer_Range1.get(4) && result.y > answer_Range1.get(5) && result.x <answer_Range1.get(6) && result.y <answer_Range1.get(7))  && answer_Range1.size()>4) {
                    LtLog.e(commonFunction.getLineInfo( "正确答案是B"));
                    answerStr=answerStrABCD.get(1);
                }

                if ((result.x >answer_Range1.get(8) && result.y >answer_Range1.get(9) && result.x < answer_Range1.get(10) && result.y < answer_Range1.get(11)) && answer_Range1.size()>8) {
                    LtLog.e(commonFunction.getLineInfo( "正确答案是C"));
                    answerStr=answerStrABCD.get(2);
                }
                    if(answer_Range1.size()>12) {
                        if ((result.x > answer_Range1.get(12) && result.y > answer_Range1.get(13) && result.x < answer_Range1.get(14) && result.y < answer_Range1.get(15)) && answer_Range1.size() > 12) {
                            LtLog.e(commonFunction.getLineInfo("正确答案是D"));
                            answerStr = answerStrABCD.get(3);
                        }
                    }
                break;
            }
            Thread.sleep(100);
        }
      //  LtLog.i(publicFunction.getLineInfo() + "----------------------------上传的正确答案是=" + answerStr);
        if (answerStr != "") {
            UpAnswerAndTitle(mStr, answerStr, game_id);
        }
    }

    //查找题目
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
          //  LtLog.i(getLineInfo() + "-----------+++---------response=" + resultStr);
        } catch (IOException e) {

            e.printStackTrace();
            return new String[0];
        }

        try {
            resultStr = new org.json.JSONTokener(resultStr).nextValue().toString();
            LtLog.e(commonFunction.getLineInfo( "正确答案题库==="+resultStr));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject = new JSONObject(resultStr);
            if (jsonObject.getString("data").equals("false")) {
                LtLog.i(getLineInfo() + "-----------+++---------not title");
                return new String[0];
            } else {
                String arr;
                arr = jsonObject.getString("data").replaceAll("\\[", "");
                arr = arr.replaceAll("\\]", "");
                arr = arr.replaceAll("\"", "");
                String[] array = arr.split(",");
                LtLog.i(getLineInfo() + "-----------+++---------array=" + array);
                return array;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    //上传题目和答案
    public void UpAnswerAndTitle(String title, String answer, String game_id) throws Exception {
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
            LtLog.i(getLineInfo() + "-----------+++---------response=" + resultStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(100);
    }

    //得到二值化ocr

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

    private void rndTap(int x_1, int y_1, int x_2, int y_2) throws Exception{
        //范围点击
        int rndx = rand.nextInt(x_2 - x_1 + 1) + x_1;
        int rndy = rand.nextInt(y_2 - y_1 + 1) + y_1;
        mFairy.tap(rndx, rndy);
    }

    private void rndTapWH(int x_1, int y_1, int w_1, int h_1) throws Exception {
        //坐标点偏移宽高随机点击
        int rndx = rand.nextInt(w_1 + 1) + x_1;
        int rndy = rand.nextInt(h_1 + 1) + y_1;
        mFairy.tap(rndx, rndy);
    }

    private static String getLineInfo() {
        StackTraceElement ste = new Throwable().getStackTrace()[1];
        return ste.getFileName() + ": Line " + ste.getLineNumber();
    }


}
