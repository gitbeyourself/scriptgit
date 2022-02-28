
package com.example.administrator.xjqxz4;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class GamePublicFunction {
    xjqxz4 mFairy;
    FindResult result;
    FindResult result1;
    CommonFunction commonFunction;
    public  GamePublicFunction(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        commonFunction = new CommonFunction(mFairy);
    }
    //开始任务
    public int mission(String str,String str1, int option) throws Exception {
        int bj = 0, js_2 = 0,js_3=0;
        int cs_1 = 0;
        while (true) {
            Thread.sleep(3000);
            LtLog.e(commonFunction.getLineInfo("接取任务中bj="+bj));
            if (bj == 0) {
                init();
                js_2=0;
                bj = 1;
            }
            if (bj == 1) {
//                result = mFairy.findPic2(commonFunction.setImg("YK.png"));
//                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "御空"));
//                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Activeinterface.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动界面"));
                if (result.sim>0.8f){
                    commonFunction.RanSwipe(350,80,368,536, 0, 1500);
                    commonFunction.RanSwipe(350,80,368,536, 0, 1500);
                    commonFunction.RanSwipe(350,80,368,536, 0, 1500);
                    result =   commonFunction.FindManyPic(376,586,1031,661, new String[]{"hylq.png","hylq2.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.75f, "活跃领取"));
                    commonFunction.Compare(0.75f, result, commonFunction.getImg());
                    if (result.sim>0.75f){
                    }else {
                        bj = 2;
                    }

                    result = mFairy.findPic2(commonFunction.setImg("hylq1.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "领取"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                }
                cs_1++;
                if (cs_1 > 50) {
                    cs_1 = 0;
                    bj = 0;
                }
            }
            if (bj == 2) {
                result = mFairy.findPic2(commonFunction.setImg("Activeinterface.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动界面"));
                if (option==1){
                    //单人
                    commonFunction.RndCompare(0.8f, 79, 137, result, commonFunction.getImg());
                }
                if (option==2){
                    //组队
                    commonFunction.RndCompare(0.8f, 81, 228, result, commonFunction.getImg());
                }
                if (option==3){
                    //定时
                    commonFunction.RndCompare(0.8f, 81, 321, result, commonFunction.getImg());
                }


                result1 = commonFunction.FindManyPic(179,30,577,584, new String[]{str,str1}, 0);
                // LtLog.e(commonFunction.getLineInfo("图片"+str+"的sim="+result1.sim));
                LtLog.e(commonFunction.getLineInfo(result1, 0.1f, commonFunction.getImg()));
                if (result1.sim >= 0.8f) {
                    result = mFairy.findPic2(result1.x + 185, result1.y + 16, result1.x + 386, result1.y + 88, commonFunction.setImg("participatein.png"));
                    // LtLog.e(commonFunction.getLineInfo("图片的sim="+result.sim));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动参加"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    if (result.sim >= 0.8f) {
                        Thread.sleep(5000);
                        return 1;
                    }
                    result = commonFunction.FindManyPic(result1.x + 185, result1.y + 16, result1.x + 386, result1.y + 88, new String[]{"Finished.png","Finished1.png"}, 0);
                    // LtLog.e(commonFunction.getLineInfo("图片的sim="+result.sim));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动结束"));
                    if (result.sim >= 0.8f) {
                        Thread.sleep(5000);
                        return 0;
                    }
                }
                js_2++;

                result = mFairy.findPic2(124,35,340,167,commonFunction.setImg("laba.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "有喇叭"));
                if (result.sim >= 0.8f) {
                    js_2=0;
                }
                LtLog.e(commonFunction.getLineInfo("js_2=" + js_2));
                if (js_2 == 3 || js_2 == 6 || js_2 == 9  ) {
                    result = mFairy.findPic2(commonFunction.setImg("Activeinterface.png"));
                    if (result.sim > 0.8f) {
                      /*  mFairy. touchDown(2,506,582);
                        mFairy.  touchMove(2,549, 210, 1000);
                        mFairy.  touchUp(2);*/
                        commonFunction.RanSwipe(350,80,368,536, 2, 1500);
                        LtLog.e(commonFunction.getLineInfo("滑动一下"));
                        Thread.sleep(2000);
                        option=0;
                    } else {
                        bj = 0;
                    }
                } else if (js_2 >= 12) {
                    LtLog.e(commonFunction.getLineInfo("任务结束"));
                    return 0;
                }
            }
        }
    }

    //不需要取消挂机初始化
    public void init() throws Exception {
        int js_1=0;
        for (int i=0;i<150;i++){
            LtLog.e(commonFunction.getLineInfo( "初始化中"));
            Thread.sleep(1000);
            //   commonFunction.FindManyPicRange(0.9f, 300, new String[]{"fork1.png"});
            result = mFairy.findPic2(4,6,1290,562,commonFunction.setImg("Dialog box.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "对话框"));
            commonFunction.RndCompare(0.8f, 1254,25,result, commonFunction.getImg());

            result = mFairy.findPic2(commonFunction.setImg("smlk.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "神魔离开"));
            commonFunction.Compare(0.8f, result, commonFunction.getImg());

            result = mFairy.findPic2(commonFunction.setImg("Replica.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
            commonFunction.Compare(0.8f, result, commonFunction.getImg());

            result = commonFunction.FindManyPic(442,5,1270,394, new String[]{"fork1.png"}, 0);
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "发现一个叉子"));
            commonFunction.Compare(0.8f, result, commonFunction.getImg());
            if (result.sim>0.8f){
                js_1=0;
            }else {
                js_1++;
                if (js_1>1){
                    result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                    if (result.sim>0.8f){
                        result = mFairy.findPic2(commonFunction.setImg("3d.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "切换到2.5d"));
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                        break;
                    }
                }
            }

        }
    }
    //回城
    public void backCity() throws Exception {
        int bj = 0, js_2 = 0,js_3=0;
        int cs_1 = 0;
        while (true) {
            Thread.sleep(3000);
            LtLog.e(commonFunction.getLineInfo("回城中bj="+bj));
            if (bj == 0) {
                init();
                js_2=0;
                bj = 1;
            }
            if (bj == 1) {
                result = mFairy.findPic2(commonFunction.setImg("stophang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "关闭挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("YK.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "御空"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(1161,1,1279,132,commonFunction.setImg("yaochi.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "瑶池"));
                if (result.sim>0.7f){
                    break;
                }else {
                    bj=2;
                }

            }
            if (bj == 2) {
                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                commonFunction.RndCompare(0.8f, 1196,76,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("backyaochi.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "返回瑶池"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    Thread.sleep(5000);
                    bj=0;
                }
            }
        }
    }
    //退队
    public void WithdrawTeam() throws Exception {
        int bj = 0, js_2 = 0,js_3=0;
        int cs_1 = 0;
        while (true) {
            Thread.sleep(3000);
            LtLog.e(commonFunction.getLineInfo("退队中bj="+bj));
            if (bj == 0) {
                init();
                bj = 1;
            }
            if (bj == 1) {
                result = commonFunction.FindManyPic(1121,152,1280,193, new String[]{"rightteam.png","rightteam2.png","rightteam1.png","rightteam3.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧队伍"));
                commonFunction.RndCompare(0.8f, 1155,170, result, commonFunction.getImg());




                result = mFairy.findPic2(commonFunction.setImg("Single.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "一个人结束"));
                if (result.sim>0.8f){
                    break;
                }


                result = mFairy.findPic2(commonFunction.setImg("Quit the team.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "退出队伍"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Create team.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "创建队伍"));
                if (result.sim>0.8f){
                    break;
                }
                cs_1++;
                if (cs_1>30){
                    cs_1=0;
                    bj=0;
                }
            }
        }
    }
    //拉跟站
    public void pullAndStop() throws Exception {

        for (int i=0;i<3;i++){
            LtLog.e(commonFunction.getLineInfo( "拉跟站中"));
            result = commonFunction.FindManyPic(1121,152,1280,193, new String[]{"rightteam.png","rightteam2.png","rightteam1.png","rightteam3.png"}, 0);
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧队伍"));
            commonFunction.RndCompare(0.8f, 1155,170, result, commonFunction.getImg());


            result = mFairy.findPic2(commonFunction.setImg("Quit the team.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拉跟站"));
            commonFunction.RndCompare(0.8f, 1128, 182, result, commonFunction.getImg());
        }
    }

    //仙盟领奖
    public void xmlj() throws Exception {

        for (int i=0;i<3;i++){
            LtLog.e(commonFunction.getLineInfo( "仙盟领奖中"));

            result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "打开仙盟"));
            commonFunction.RndCompare(0.8f, 1030,106, result, commonFunction.getImg());

            result = mFairy.findPic2(commonFunction.setImg("cjg.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "藏金阁"));
            commonFunction.Compare(0.8f, result, commonFunction.getImg());

            result = mFairy.findPic2(commonFunction.setImg("dh.png"));
            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "兑换"));
            commonFunction.Compare(0.8f, result, commonFunction.getImg());
        }
    }
    //智能答题
    public void answer() throws Exception{
        Mat mat;
        String str1="";
        //答案ABCD的4个范围
        int range[]={ 557,429,221,67,     837,429,222,68,   556,511,222,67,   837,511,221,69 };
        int count=0;
        boolean sign=false;
        mat = mFairy.getScreenMat(0,0,1280,720, 1, 0, 0, 1);
        Imgcodecs.imwrite("/sdcard/screen.png", mat);
        //获取题目
        String str=mFairy.ocr(508,186,572,147);
        LtLog.e(commonFunction.getLineInfo("题目是="+str));
        if (!(str.equals(""))){
            //获取答案
            String answer[]=commonFunction.findAnswer(str,"25");
            //如果没有答案
            LtLog.e(commonFunction.getLineInfo("答案有几个="+answer.length));
            if (answer.length==0){
                //没有答案
                mFairy.tap(585,458);
                LtLog.e(commonFunction.getLineInfo("没有答案选A"));
                for (int i=0;i<10;i++) {
                    result = mFairy.findPic2(517,420,1064,584, commonFunction.setImg("rightkey.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案"));
                    if (result.sim > 0.9f) {
                        break;
                    }
                }
                if (result.sim>0.9f){

                    if (result.x>520 && result.y>423 && result.x<785 && result.y<503){
                        LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是A"));
                        count=0;
                    }

                    if (result.x>797 && result.y>424 && result.x<1065 && result.y<500){
                        LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是B"));
                        count=4;
                    }

                    if (result.x>514 && result.y>509 && result.x<784 && result.y<584){
                        LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是c"));
                        count=8;
                    }
                    if (result.x>798 && result.y>510 && result.x<1062 && result.y<586){
                        LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是d"));
                        count=12;
                    }
                    str1=commonFunction.getAnswerOcr(range[count],range[count+1],range[count+2],range[count+3],mat);
                    LtLog.e(commonFunction.getLineInfo("答案是="+str1));
                    commonFunction.UpAnswerAndTitle(str,str1,"25");
                    LtLog.e(commonFunction.getLineInfo("答案上传成功进行下一题"));
                }else {
                    LtLog.e(commonFunction.getLineInfo("没有获取到答案进行下一题"));
                }
            } else {
                for (int i=0;i<range.length;i++){
                    String str2=mFairy.ocr(range[i],range[i+1],range[i+2],range[i+3]);
                    i=i+3;
                    for (int j=0;j<answer.length;j++){
                        if (str2.equals(answer[j])){
                            if (i==3){
                                commonFunction.RndCompare(585,458,"正确答案为A");
                                sign=true;
                                return;
                            }
                            if (i==7){
                                commonFunction.RndCompare(876,462,"正确答案为B");
                                sign=true;
                                return;
                            }
                            if (i==11){
                                commonFunction.RndCompare(631,549,"正确答案为C");
                                sign=true;
                                return;
                            }
                            if (i==15){
                                commonFunction.RndCompare(919,545,"正确答案为D");
                                sign=true;
                                return;
                            }
                        }
                    }
                }
                //有答案但是没有匹配到
                if (sign==false){
                    //没有答案
                    mFairy.tap(585,458);
                    LtLog.e(commonFunction.getLineInfo("没有答案选A"));
                    for (int i=0;i<10;i++) {
                        result = mFairy.findPic2(517,420,1064,584, commonFunction.setImg("rightkey.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案"));
                        if (result.sim > 0.9f) {
                            break;
                        }
                    }
                    if (result.sim>0.9f){

                        if (result.x>520 && result.y>423 && result.x<785 && result.y<503){
                            LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是A"));
                            count=0;
                        }

                        if (result.x>797 && result.y>424 && result.x<1065 && result.y<500){
                            LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是B"));
                            count=4;
                        }

                        if (result.x>514 && result.y>509 && result.x<784 && result.y<584){
                            LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是c"));
                            count=8;
                        }
                        if (result.x>798 && result.y>510 && result.x<1062 && result.y<586){
                            LtLog.e(commonFunction.getLineInfo(result, 0.9f, "正确答案是d"));
                            count=12;
                        }
                        str1=commonFunction.getAnswerOcr(range[count],range[count+1],range[count+2],range[count+3],mat);
                        LtLog.e(commonFunction.getLineInfo("答案是="+str1));
                        commonFunction.UpAnswerAndTitle(str,str1,"25");
                        LtLog.e(commonFunction.getLineInfo("答案上传成功进行下一题"));
                    }else {
                        LtLog.e(commonFunction.getLineInfo("没有获取到答案进行下一题"));
                    }

                }
            }
        }else {
            LtLog.e(commonFunction.getLineInfo("题目都没找到选A"));
            mFairy.tap(585,458);
        }
    }

}
