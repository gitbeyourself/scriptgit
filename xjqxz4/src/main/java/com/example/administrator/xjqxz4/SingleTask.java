package com.example.administrator.xjqxz4;


import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/13.
 */

public class SingleTask {

    xjqxz4 mFairy;
    FindResult result;
    FindResult result1;
    CommonFunction commonFunction;
    GamePublicFunction gamePublicFunction;
    public SingleTask(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        commonFunction = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
    }
    //新手引导
    public void Novice() throws Exception{
        int bj = 0,bj_1=0;
        int ret;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("新手任务中bj="+bj));

            Thread.sleep(1);
            if (bj==0){

                result = commonFunction.FindManyPic(889,162,1246,296, new String[]{"Novice.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧主线"));
                commonFunction.RndCompare(0.8f, result.x+20,result.y+30,result, commonFunction.getImg());
                commonFunction.delays(0.8f,result,5000);


                result = mFairy.findPic2(874,163,1252,281,commonFunction.setImg("Next step.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "下一步"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(3,5,1277,715,commonFunction.setImg("Click on.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "点击前往"));
                    commonFunction.RndCompare(0.8f, result.x,result.y,result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("General attack.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "普工"));
                if (result.sim>0.8f){
                    mFairy.tap(1128,563);
                    mFairy.tap(1128,563);
                    mFairy.tap(1128,563);
                    mFairy.tap(1128,563);
                    mFairy.tap(1225,439);
                    js_2++;
                    if (js_2>5){
                        commonFunction.RanSwipe(132,587,196,595,1,1000);
                        js_2=0;
                    }
                }
                result = mFairy.findPic2(commonFunction.setImg("Novicestop.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "新手结束"));
                if (result.sim>0.8f){
                    break;
                }
                result = mFairy.findPicRange(commonFunction.setImg("szhl.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "上阵幻灵"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPicRange(commonFunction.setImg("hlcz.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幻灵出站"));
                commonFunction.RndCompare(0.8f, 325,96,result, commonFunction.getImg());

                result = mFairy.findPicRange(commonFunction.setImg("Projectile frame.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "随机题"));
                commonFunction.RndCompare(0.8f, 772,377,result, commonFunction.getImg());

                result = commonFunction.FindManyPic(390,219,966,541, new String[]{"pickup.png","pickup1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拾取"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("namesure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "名字"));
                commonFunction.RndCompare(0.8f, 781,438,result, commonFunction.getImg());
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hbsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "伙伴确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                commonFunction.FindManyPicRange(0.8f,20, new String[]{"Click and view.png","other1.png","other2.png","other3.png","other4.png","other5.png","other6.png","other7.png","fbfail.png"});

                result = mFairy.findPic2(commonFunction.setImg("Garbage copy.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "垃圾副本"));
                commonFunction.RndCompare(0.8f, 161,130,result, commonFunction.getImg());


                result = mFairy.findPic2(129,371,1216,708,commonFunction.setImg("Letter of letter.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "寄收信"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

               /* result = mFairy.findPicRange (commonFunction.setImg("Letter of letter1.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "收信"));
                commonFunction.RndCompare(0.8f, 629,618,result, commonFunction.getImg());*/

                result = mFairy.findPic2(3,5,1277,715,commonFunction.setImg("down arrow.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.9f, "向下箭头"));
                commonFunction.RndCompare(0.9f, result.x+3,result.y+30,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("xmAgree.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "同意"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Repainting.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "重画"));
                if (result.sim>0.8f){
                    mFairy.touchDown(2,763,285);
                    mFairy.touchMove(2,630,350,1000);
                    mFairy.touchMove(2,612,248,1000);
                    mFairy.touchMove(2,461,402,1000);
                    mFairy.touchMove(2,674,456,1000);
                    mFairy.touchMove(2,627,380,1000);
                    mFairy.touchUp(2);
                }


                result = commonFunction.FindManyPic(442,5,1270,394, new String[]{"fork1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "发现一个叉子="+js_1));
                if (result.sim>0.8f){
                    js_1++;
                    if (js_1>3){
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }
                }else {
                    js_1=0;
                }
                result = mFairy.findPic2(commonFunction.setImg("Replica.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
                if (result.sim>0.8f){
                    result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                }
            }

        }

    }
    //仙缘
    public void Novice1() throws Exception{
        int bj = 0,bj_1=0;
        int ret;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0;
        int  numcolor,numcolor1;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("仙缘任务中bj="+bj));
            Thread.sleep(1);
            if (bj==0){
                numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));



                result = commonFunction.FindManyPic(889,162,1246,296, new String[]{"xyNovice.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧仙缘"));
                commonFunction.RndCompare(0.8f, result.x+20,result.y+30,result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_3=0;
                }else {
                    js_3++;
                    if (js_3>13){
                        break;
                    }
                }
                commonFunction.delays(0.8f,result,5000);

                result = mFairy.findPic2(874,163,1252,281,commonFunction.setImg("Next step.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "下一步"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(3,5,1277,715,commonFunction.setImg("Click on.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "点击前往"));
                commonFunction.RndCompare(0.8f, result.x,result.y,result, commonFunction.getImg());


                result = mFairy.findPicRange(commonFunction.setImg("dianshicj.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "点石成金"));
                if (result.sim>0.8f){
                    result = commonFunction.FindManyPic(889,162,1246,296, new String[]{"xyNovice.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧仙缘"));
                    commonFunction.RndCompare(0.8f, result.x+20,result.y+30,result, commonFunction.getImg());
                    commonFunction.delays(0.8f,result,5000);
                    for (int i=0 ;i<6;i++){
                        commonFunction.RndCompare(0.8f, 988,389,result, commonFunction.getImg());
                        commonFunction.RndCompare(0.8f, 766,372,result, commonFunction.getImg());
                    }
                }

                result = mFairy.findPicRange(commonFunction.setImg("dianshicj1.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "点石成金"));
                if (result.sim>0.8f){
                    result = commonFunction.FindManyPic(889,162,1246,296, new String[]{"xyNovice.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧仙缘"));
                    commonFunction.RndCompare(0.8f, result.x+20,result.y+30,result, commonFunction.getImg());
                    commonFunction.delays(0.8f,result,5000);
                    for (int i=0 ;i<6;i++){
                        commonFunction.RndCompare(0.8f, 988,389,result, commonFunction.getImg());
                        commonFunction.RndCompare(0.8f, 766,372,result, commonFunction.getImg());
                    }
                }

                result = mFairy.findPicRange(commonFunction.setImg("Projectile frame.png"),100);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "随机题"));
                commonFunction.RndCompare(0.8f, 772,377,result, commonFunction.getImg());

                result = commonFunction.FindManyPic(390,219,966,541, new String[]{"pickup.png","pickup1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拾取"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("namesure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "名字"));
                commonFunction.RndCompare(0.8f, 781,438,result, commonFunction.getImg());
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hbsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "伙伴确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

               // commonFunction.FindManyPicRange(0.8f,20, new String[]{"Click and view.png","other1.png","other2.png","other3.png","other4.png","other5.png","other6.png","other7.png","fbfail.png"});
                 commonFunction.FindManyPicRange(0.8f,200 , new String[]{"xyother2.png"});

                result = mFairy.findPic2(576,317,1248,618,commonFunction.setImg("xyother.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "舞女"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(6,2,1277,709,commonFunction.setImg("Photograph.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拍照"));
                if (result.sim>0.8f){
                    result = mFairy.findPic2(6,2,1277,709,commonFunction.setImg("Photograph1.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拍照1"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                }

                result = mFairy.findPic2(commonFunction.setImg("Photograph2.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拍照2"));
                commonFunction.RndCompare(0.8f, 1235,36,result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("xyother1.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "舞者1"));
                commonFunction.RndCompare(0.8f, 755,507,result, commonFunction.getImg());




                result = mFairy.findPic2(3,5,1277,715,commonFunction.setImg("down arrow.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.9f, "向下箭头"));
                commonFunction.RndCompare(0.9f, result.x+3,result.y+30,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("xmAgree.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "同意"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Repainting.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "重画"));
                if (result.sim>0.8f){
                    mFairy.touchDown(2,763,285);
                    mFairy.touchMove(2,630,350,1000);
                    mFairy.touchMove(2,612,248,1000);
                    mFairy.touchMove(2,461,402,1000);
                    mFairy.touchMove(2,674,456,1000);
                    mFairy.touchMove(2,627,380,1000);
                    mFairy.touchUp(2);
                }


                result = commonFunction.FindManyPic(442,5,1270,394, new String[]{"fork1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "发现一个叉子="+js_1));
                if (result.sim>0.8f){
                    js_1++;
                    if (js_1>3){
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }
                }else {
                    js_1=0;
                }

                numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
                if (numcolor == numcolor1) {
                    js_2++;
                    if (js_2 > 5) {
                        result = mFairy.findPic2(commonFunction.setImg("General attack.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "普工"));
                        if (result.sim>0.8f){
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            commonFunction.RanSwipe(132,587,196,595,1,1000);
                        }
                        js_2 = 0;
                    }
                } else {
                    js_2 = 0;
                }
            }

        }

    }
    //六界美酒
    public void Master() throws Exception{
        int bj = 0;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("六界美酒任务中bj="+bj));
            Thread.sleep(2000);
            if (bj == 0) {
                gamePublicFunction.init();
                js_1=0;
                js_3=0;
                js_5=0;
                js_6=0;
                bj = 1;
                if (js_4>0){
                    break;
                }
            }
            if (bj == 1) {
                ret = gamePublicFunction.mission("liujiemeijiu.png","liujiemeijiu1.png", 1);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {
                js_3++;
                if (js_3>80){
                    bj=0;
                }
                numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));

                result = mFairy.findPic2(363,231,915,466,commonFunction.setImg("jiuxianwen.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "酒仙翁"));
                commonFunction.RndCompare(0.8f, 755,506,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("ljmjSubmission.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "提交"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=0;
                    js_2++;
                    if (js_2>10){
                        commonFunction.RndCompare(0.8f, 1069,625,result, commonFunction.getImg());
                        js_4++;
                        js_2=0;
                    }
                }
                 result = mFairy.findPic2(commonFunction.setImg("ljmjaccept.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "接受"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=0;
                }

                result = mFairy.findPic2(commonFunction.setImg("Hang in the air.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "未完成确定"));
                commonFunction.RndCompare(0.8f, 758,505,result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=-15;
                }
                result = mFairy.findPic2(731,104,876,586,commonFunction.setImg("ljmjcollect.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "收集"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=0;
                }

                result = mFairy.findPic2(731,104,876,586,commonFunction.setImg("ljmjcollection.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "采集"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=0;
                }

                result = mFairy.findPic2(commonFunction.setImg("ljmjSeek help.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "求助"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=0;
                }
                result = mFairy.findPic2(commonFunction.setImg("ljmjcomplete.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "完成"));
                commonFunction.RndCompare(0.8f, 1069,625,result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_1=0;
                }

                result = mFairy.findPic2(574,317,1242,546,commonFunction.setImg("ljmjTask.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "交任务"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    break;
                }


                numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
                if (numcolor == numcolor1) {
                    js_1++;
                    if (js_1 > 10) {
                        result = mFairy.findPic2(commonFunction.setImg("General attack.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "普工"));
                        if (result.sim>0.8f){
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            mFairy.tap(1128,563);
                            commonFunction.RanSwipe(132,587,196,595,1,2000);
                        }
                        js_1 = 0;
                        bj=0;
                    }
                } else {
                    js_1 = 0;
                }
            }
        }

    }
    //宝图任务
    public void treasureMap() throws Exception{
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        bj_1 = bj;
        while (true) {
            if (bj_1 == bj ) {
                cs_1++;
            } else if (bj_1 != bj) {
                cs_1 = 0;
                bj_1 = bj;
                LtLog.e(commonFunction.getLineInfo("标记发生变化"));
            }
            if (cs_1 > 100) {
                cs_1 = 0;
                bj = 0;
                LtLog.e(commonFunction.getLineInfo("标记长时间未发生变化"));
            }
            LtLog.e(commonFunction.getLineInfo("宝图任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.init();
                js_1=0;
                js_2=0;
                js_3=0;
                js_4=0;
                js_5=0;
                js_6=0;
                bj = 1;
            }
            if (bj == 1) {
                ret = gamePublicFunction.mission("treasureMap.png","treasureMap1.png", 1);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {
                result = mFairy.findPic2(commonFunction.setImg("other4.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "进入副本"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("General attack.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "移动计次="+js_2));
                if (result.sim>0.8f){
                    js_2++;
                    if (js_2>1){
                        if (js_1==0){
                            mFairy.touchDown(2,136,594);
                            mFairy.touchMove(2,225,600,3000);
                            mFairy.touchUp(2);
                            js_1=1;
                        }else if (js_1==1){
                            mFairy.touchDown(2,136,594);
                            mFairy.touchMove(2,136,514,3000);
                            mFairy.touchUp(2);
                            js_1=2;
                        }else if (js_1==2){
                            mFairy.touchDown(2,136,594);
                            mFairy.touchMove(2,59,598,3000);
                            mFairy.touchUp(2);
                            js_1=3;
                        }else if (js_1==3){
                            mFairy.touchDown(2,136,594);
                            mFairy.touchMove(2,135,681,3000);
                            mFairy.touchUp(2);
                            js_1=0;
                        }
                        js_2=0;
                    }

                }
                result = mFairy.findPic2(202,84,1168,617,commonFunction.setImg("bzopen.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启宝箱"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(19,37,1264,695,commonFunction.setImg("Transmission gate.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "传送门"));
                commonFunction.RndCompare(0.8f, result.x,result.y+130,result, commonFunction.getImg());

                result = mFairy.findPic2(19,37,1264,695,commonFunction.setImg("Treasure box.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "开启宝箱"));
                commonFunction.Compare(0.7f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Replica.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
                if (result.sim>0.8f){
                    js_3=0;
                }else {
                    js_3++;
                    if (js_3>8){
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "失败两次结束"));
                        break;
                    }
                }
            }
        }

    }
    //昆仑之巅
    public void klzd() throws Exception{
        int bj = 0;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("昆仑之巅任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.backCity();
                js_1=0;
                js_2=0;
                js_3=0;
                js_4=0;
                js_5=0;
                js_6=0;
                bj = 1;
            }
            if (bj == 1) {
                ret = gamePublicFunction.mission("klzd.png","klzd1.png", 1);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {

                result = mFairy.findPic2(115,49,1172,247,commonFunction.setImg("tjtz.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "挑战"));
                commonFunction.RndCompare(0.8f, 1082,637,result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, 168,640,result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, result.x-59,result.y+400,result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("Start challenge.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开始挑战"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("klzdsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("klzdEnd.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "结束"));
               if (result.sim>0.8f){
                   break;
               }

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                if (result.sim>0.8f){
                    Thread.sleep(10000);
                    result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                    if (result.sim>0.8f){
                        break;
                    }
                }
                result = mFairy.findPic2(commonFunction.setImg("klsx.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "刷新"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
        }

    }
    //英雄擂台
    public void arena() throws Exception{
        int bj = 0;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("英雄擂台任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.backCity();
                js_1=0;
                js_2=0;
                js_3=0;
                js_4=0;
                js_5=0;
                js_6=0;
                bj = 1;
            }
            if (bj == 1) {
                ret = gamePublicFunction.mission("yxlt.png","yxlt1.png", 1);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {
                Thread.sleep(4000);
                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                if (result.sim>0.8f){
                    break;
                }

                result = mFairy.findPic2(commonFunction.setImg("zdtz.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "自动挑战"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("zdtz1.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "自动挑战1"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("yxslsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "失败确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());


            }
        }

    }
    //答题
    public void answerDay() throws Exception{
        int bj = 0;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        Answer answer = new Answer(mFairy);
        Map<String, List<Integer>> answerMap = answer.initializationMap();
        answerMap.put("game_id", Arrays.asList(222));

        answerMap.put("title_Range", Arrays.asList(512,169,469,32));
        answerMap.put("answer_Range", Arrays.asList(388,436, 785,436,384,539,783,532,   303,88));
        answerMap.put("answer_Range1", Arrays.asList(388,436,772,523,   785,436,1175,525,   384,539,776,625,  783,532,1172,626));
        answerMap.put("answer_Range2", Arrays.asList(520,481,  949,481, 552,578,   958,580));
        answerMap.put("pic_range", Arrays.asList(352,398,1193,645));
        answerMap.put("right_pic_Relative_range", Arrays.asList(-200, -10, 232, 33));//没用
        while (true) {
            LtLog.e(commonFunction.getLineInfo("答题任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.init();
                js_1=0;
                js_2=0;
                js_3=0;
                js_4=0;
                js_5=0;
                js_6=0;
                bj = 1;
            }
            if (bj == 1) {
                ret = gamePublicFunction.mission("answerDay.png","answerDay1.png", 1);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {


                result = mFairy.findPic2(355,181,927,540,commonFunction.setImg("dtsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "确定书中仙"));
                commonFunction.RndCompare(0.8f, 758,503,result, commonFunction.getImg());



                result = mFairy.findPic2(574,317,1242,546,commonFunction.setImg("dtTask.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "交任务"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("kjAnswerAA.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启智能答题模式"));
                if (result.sim > 0.8f) {
                    try {
                        answer.mAnswer(answerMap, "rightkey.png");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Thread.sleep(5000);
                    js_1=0;
                }else {
                    js_1++;
                    if (js_1>30){
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "答题超时"));
                        bj=0;
                    }
                }

                result = mFairy.findPic2(471,143,1110,293,commonFunction.setImg("dtwan.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "答题结束"));
                if (result.sim > 0.8f) {
                    break;
                }
            }
        }

    }
    //降妖谱
    public void xyp() throws Exception{
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        bj_1 = bj;
        while (true) {
            if (bj_1 == bj && bj != 3) {
                cs_1++;
            } else if (bj_1 != bj) {
                cs_1 = 0;
                bj_1 = bj;
                LtLog.e(commonFunction.getLineInfo("标记发生变化"));
            }
            if (cs_1 > 100) {
                cs_1 = 0;
                bj = 0;
                LtLog.e(commonFunction.getLineInfo("标记长时间未发生变化"));
            }
            LtLog.e(commonFunction.getLineInfo("降妖谱任务中bj="+bj+",js_2="+js_2));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.init();
                js_1=0;
                js_3=0;
                js_4=0;
                js_5=0;
                js_6=0;
                bj = 1;
            }
            if (bj == 1) {
                ret = gamePublicFunction.mission("xyp.png","xyp1.png", 1);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {

                result = mFairy.findPic2(commonFunction.setImg("other5.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "前往降妖"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    Thread.sleep(2000);
                    result = mFairy.findPic2(commonFunction.setImg("Continue to challenge.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "继续挑战"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    result = mFairy.findPic2(commonFunction.setImg("other5.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "前往降妖"));
                    if (result.sim>0.8f){
                        break;
                    }
                }

                result = mFairy.findPic2(commonFunction.setImg("other6.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "封印妖物"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    bj=3;
                }

                result = mFairy.findPic2(commonFunction.setImg("other7.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "领取奖励"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_2--;
                }


            }
            if (bj==3){
                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("other7.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "领取奖励"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_2--;
                }

                result = mFairy.findPic2(446,354,801,531,commonFunction.setImg("Demon demon.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "降妖"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Replica.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
                if (result.sim>0.8f){
                        js_1=0;
                }else {
                    js_1++;
                    if (js_1>6){
                        js_2++;
                        if (js_2>2){
                            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "失败两次结束"));
                            break;
                        }
                        bj=0;
                    }
                }
            }
        }

    }
   //挖宝图
   public void treasureMap1() throws Exception{
       int bj = 0;
       int ret;
       int  numcolor,numcolor1;
       int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
       while (true) {
           LtLog.e(commonFunction.getLineInfo("挖宝图任务中bj="+bj));
           Thread.sleep(1000);
           if (bj == 0) {
               js_1=0;
               js_2=0;
               js_3=0;
               js_4=0;
               js_5=0;
               js_6=0;
               bj = 1;
           }
           if (bj == 1) {
               ret = gamePublicFunction.mission("wcbt.png","wcbt1.png", 1);
               if (ret == 0) {
                   break;
               } else if (ret == 1) {
                   bj = 2;
               }

           }
           if (bj==2) {


               numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
               LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));

               result = mFairy.findPic2(347,216,1249,670,commonFunction.setImg("btUse.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "宝图使用"));
               commonFunction.Compare(0.8f, result, commonFunction.getImg());

               result = mFairy.findPic2(347,216,1249,670,commonFunction.setImg("cbtNo.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "宝图没了"));
               commonFunction.RndCompare(0.8f, 644,506,result, commonFunction.getImg());
               if (result.sim>0.8f) {
                 break;
               }
               result = commonFunction.FindManyPic(1036,84,1277,393, new String[]{"fb.png","fb1.png"}, 0);
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
               if (result.sim>0.8f) {
                   js_1 = 0;
               }

               numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
               LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
               if (numcolor == numcolor1) {
                   js_1++;
                   if (js_1 > 10) {
                       result = mFairy.findPic2(commonFunction.setImg("General attack.png"));
                       LtLog.e(commonFunction.getLineInfo(result, 0.8f, "普工"));
                       if (result.sim>0.8f){
                           commonFunction.RanSwipe(132,587,196,595,1,2000);
                       }
                       result = mFairy.findPic2(347,216,1249,670,commonFunction.setImg("btUse1.png"));
                       LtLog.e(commonFunction.getLineInfo(result, 0.8f, "宝图使用1"));
                       commonFunction.Compare(0.8f, result, commonFunction.getImg());
                       if (result.sim>0.8f){
                           Thread.sleep(5000);
                           commonFunction.Compare(0.8f, result, commonFunction.getImg());
                       }else {
                           bj=0;
                       }
                       js_1 = 0;
                   }
               } else {
                   js_1 = 0;
               }
           }
       }

   }
   //签到
    public void signIn() throws Exception{
        int bj = 0;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("签到任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.init();
                bj = 1;
            }
            if (bj == 1) {
                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("welfare.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "福利"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());


                result = mFairy.findPic2(15,61,271,660,commonFunction.setImg("fljm.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "福利界面"));
               if (result.sim>0.8f){
                   commonFunction.RanSwipe(121,120,130,595,2,2000);
                   commonFunction.RanSwipe(121,120,130,595,2,2000);
                   bj=2;
               }


            }
            if (bj==2) {
                for (int i=0;i<3;i++){
                    result = commonFunction.FindManyPic(15,61,271,660, new String[]{"Welfare attendance.png","Welfare attendance1.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "签到"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    commonFunction.RndCompare(0.8f, 1202,555,result, commonFunction.getImg());
                }

                for (int i=0;i<3;i++){
                    result = commonFunction.FindManyPic(15,61,271,660, new String[]{"Welfare attendance.png","Welfare attendance1.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "签到"));
                    commonFunction.RndCompare(0.8f, 142,419,result, commonFunction.getImg());

                    result = mFairy.findPic2(commonFunction.setImg("Recruit money.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "招财免费"));
                    commonFunction.RndCompare(0.8f, 1090,362,result, commonFunction.getImg());

                }

                for (int i=0;i<3;i++){
                    result = commonFunction.FindManyPic(15,61,271,660, new String[]{"Welfare attendance.png","Welfare attendance1.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "签到"));
                    commonFunction.RndCompare(0.8f, 144,498,result, commonFunction.getImg());
                    commonFunction.RndCompare(0.8f, 644,502,result, "领取离线经验");
                }
                for (int i=0;i<10;i++){
                    result = commonFunction.FindManyPic(15,61,271,660, new String[]{"Welfare attendance.png","Welfare attendance1.png"}, 0);
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "签到"));
                    commonFunction.RndCompare(0.8f, 154,572,result, commonFunction.getImg());
                    commonFunction.RndCompare(0.8f, 1118,84,result, "普通找回");


                    result = mFairy.findPic2(968,138,1162,665,commonFunction.setImg("Retrieve.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "找回"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(349,178,919,310,commonFunction.setImg("Retrieve1.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "找回确定"));
                    commonFunction.RndCompare(0.8f, 783,500,result, commonFunction.getImg());
                }
                 gamePublicFunction.init();
                for (int i=0;i<15;i++){
                    result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                    commonFunction.RndCompare(0.8f, 1095,107,result, commonFunction.getImg());

                     result = mFairy.findPic2(1052,325,1258,601,commonFunction.setImg("recruit.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "招募"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(508,573,640,672,commonFunction.setImg("recruit1.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.1f, "招募1"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(commonFunction.setImg("recruit2.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "招募2"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    commonFunction.RndCompare(0.8f, 1254,24,result, commonFunction.getImg());

                    result = mFairy.findPic2(commonFunction.setImg("recruit3.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "招募3"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    commonFunction.RndCompare(0.8f, 1254,24,result, commonFunction.getImg());
                }
                Thread.sleep(5000);
                result = mFairy.findPic2(commonFunction.setImg("hlqd.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幻灵确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                Thread.sleep(3000);
                commonFunction.RndCompare(1254,25, "返回");
                commonFunction.RndCompare(1254,25, "返回");
                gamePublicFunction.init();
                break;
            }
        }



    }
}




