
package com.example.administrator.xjqxz4;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity {

    xjqxz4 mFairy;
    FindResult result;
    FindResult result1;
    CommonFunction commonFunction;
    GamePublicFunction gamePublicFunction;
    TeamTask teamTask;
    public TimingActivity(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        commonFunction = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
        teamTask=new TeamTask(mFairy);
    }
    public int timeLimitActivity() throws Exception {
        int h, m, w;

        h = commonFunction.DateHour();
        m = commonFunction.DateMinute();
        w = commonFunction.Week();
        if (h == 0 && m == 0) {
            TaskThread. xshd_1 = 0;
            TaskThread. xshd_2 = 0;
            TaskThread. xshd_3 = 0;
            TaskThread. xshd_4 = 0;
            TaskThread.  xshd_5 = 0;
            TaskThread.  xshd_6 = 0;
            TaskThread.  xshd_7 = 0;
            TaskThread.  xshd_8 = 0;
            TaskThread.  xshd_9 = 0;
            TaskThread.  xshd_10 = 0;
        }
        if (h==19 && m>=15  &&m <25  && AtFairyConfig.getOption("xmxl").equals("1") && TaskThread.xshd_1==0 ){
            TaskThread.xshd_1=1;
            xmxl();
            return 1;
        }
        if ( (h==12 || h==19) && m>=30 && m<42  && AtFairyConfig.getOption("tzhy").equals("1") && TaskThread.xshd_2==0 ){
            tzhy();
            return 1;
        }
        if ( (h==0 || h==11 || h==13 || h==15 || h==17 || h==20 ) && m>=0 && m<30  && AtFairyConfig.getOption("2248").equals("1") && TaskThread.xshd_3==0 ){
            fsl();
            return 1;
        }
        if ( (h==16 || h==20 || h==22  ) && m>=30 && m<55  && AtFairyConfig.getOption("smzc").equals("1") && TaskThread.xshd_4==0 ){
            smzc();
            return 1;
        }

        if ( (h==21 || h==23   ) && m>=0&& m<5 && (w==4 || w==7)  && AtFairyConfig.getOption("2250").equals("1") && TaskThread.xshd_5==0 ){
            xdh();
            return 1;
        }
        if ( (h==21   ) && m>=30 && (w==4 || w==6 || w==2)  && AtFairyConfig.getOption("lshs").equals("1") && TaskThread.xshd_6==0 ){
            TaskThread.xshd_6=1;
            lshs();
            return 1;
        }
        if ( h==23   && TaskThread.xshd_7==0 ){
            TaskThread.xshd_7=1;
            lqhyjl();
            return 1;
        }
        if ( h==21 && m<30 && (w==1 || w==5)  && AtFairyConfig.getOption("jmhdh").equals("1") && TaskThread.xshd_8==0 ){
            TaskThread.xshd_8=1;
            jmhdh();
            return 1;
        }
        if ( h==21 && m<30 && (w==2 || w==6)  && AtFairyConfig.getOption("dtfd").equals("1") && TaskThread.xshd_9==0 ){
            TaskThread.xshd_9=1;
            dtfd();
            return 1;
        }
        if ( (h==11|| h==13 || h==17  || h==21 ) && m>=30 && (w==6 || w==7) && AtFairyConfig.getOption("hmdzz").equals("1") ){
            hmdzz();
            return 1;
        }
        if ( h==21 &&  w==3  && AtFairyConfig.getOption("tmdf").equals("1")  && TaskThread.xshd_10==0 ){
            TaskThread.xshd_10=1;
            tmdf();
            return 1;
        }

        return 0;
    }
    //领取奖励
    public void  lqhyjl() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
          /*  if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("仙盟修炼任务中bj="+bj));
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
                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("Activeinterface.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动界面"));
                if (result.sim>0.8f){
                    result = mFairy.findPic2(403,596,995,650,commonFunction.setImg("hylq.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活跃领取"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    if (result.sim>0.8f){
                        js_1=0;
                    }else {
                        js_1++;
                    }

                    result = mFairy.findPic2(commonFunction.setImg("hylq1.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "领取"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                }
                if (js_1>5){
                    break;
                }
            }
            h = commonFunction.DateHour();
            if (h!=23){
                break;
            }
        }

    }
    //仙盟修炼
    public void  xmxl() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        Answer answer = new Answer(mFairy);
        Map<String, List<Integer>> answerMap = answer.initializationMap();
        answerMap.put("game_id", Arrays.asList(222));

        answerMap.put("title_Range", Arrays.asList(512,169,469,32));
        answerMap.put("answer_Range", Arrays.asList(388,436, 785,436,384,539,783,532,   303,88));
        answerMap.put("answer_Range1", Arrays.asList(388,436,772,523,   785,436,1175,525,   384,539,776,625,  783,532,1172,626));
        answerMap.put("answer_Range2", Arrays.asList(520,481,  949,481, 552,578,   958,580));
        answerMap.put("pic_range", Arrays.asList(352,398,1193,645));
        answerMap.put("right_pic_Relative_range", Arrays.asList(-200, -10, 232, 33));//没用

        bj_1 = bj;
        while (true) {
          /*  if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("仙盟修炼任务中bj="+bj));
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
                ret = gamePublicFunction.mission("xmxl.png","xmxl1.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            m = commonFunction.DateMinute();
            if (m>26){
                break;
            }
            if (bj==2) {

                result = mFairy.findPic2(commonFunction.setImg("qwxm.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "前往仙盟"));
                commonFunction.RndCompare(0.8f, 757,501,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("xmxldt.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙盟修炼答题选A"));
                commonFunction.RndCompare(0.8f, 411,428,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("xmdt.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙盟修炼答题"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(403,251,674,440,commonFunction.setImg("qrda.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "确认答案"));
                commonFunction.RndCompare(0.8f, 756,502,result, commonFunction.getImg());
                if (result.sim > 0.8f) {
                    Thread.sleep(10000);
                }

                result = mFairy.findPic2(commonFunction.setImg("xzjc.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "小猪竞猜"));
                commonFunction.RndCompare(0.8f, 138,256,result, commonFunction.getImg());
                if (result.sim > 0.8f) {
                    gamePublicFunction.init();
                }

            }
        }

    }

    //挑战幻妖
    public void  tzhy() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("挑战幻妖任务中bj="+bj));
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
                ret = gamePublicFunction.mission("tzhy.png","tzhy1.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            m = commonFunction.DateMinute();
            if (m>44){
                break;
            }
            if (bj==2) {
                result = mFairy.findPic2(commonFunction.setImg("tzhyjm.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "挑战幻妖界面"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic2(commonFunction.setImg("kytzhy.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "可以挑战幻妖"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(commonFunction.setImg("kyzdjf.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "可以争夺积分"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                }

                result = mFairy.findPic2(commonFunction.setImg("hykstz.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开始挑战"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hysure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "打完确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hyjfsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "积分确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hyzdsure.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "争夺胜利确定"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hytd.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幻妖投点"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hyzdwj.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "争夺玩家"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic2(928,113,1116,291,commonFunction.setImg("hyzd.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "争夺"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(903,306,1112,509,commonFunction.setImg("hyzd.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "争夺"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(908,527,1111,623,commonFunction.setImg("hyzd.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "争夺"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                }

                result = mFairy.findPic2(commonFunction.setImg("hyjsqs.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幻妖结束清算"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("hylj.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幻妖领奖"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

            }
        }

    }


    //封神陵
    public void  fsl() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        int rk=0;
        rk=Integer.parseInt(AtFairyConfig.getOption("rk"));
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("封神陵任务中bj="+bj));
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
                ret = gamePublicFunction.mission("fsl.png","fsl1.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
           /* m = commonFunction.DateMinute();
            if (m>30){
                break;
            }*/
            if (bj==2) {

                result = mFairy.findPic2(commonFunction.setImg("fsljrhd.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "封神陵进入活动"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    Thread.sleep(2000);
                    result = mFairy.findPic2(commonFunction.setImg("fsljrhd.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "封神陵进入活动"));
                    if (result.sim>0.8f){
                        TaskThread.xshd_3=1;
                        break;
                    }
                }
                result = mFairy.findPic2(commonFunction.setImg("xzrk.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "封神陵选择入口"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("rk1.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "入口"));
                if (result.sim > 0.8f) {
                    if (rk==1){
                        commonFunction.RndCompare(116,221,"入口1");
                    }
                    if (rk==2){
                        commonFunction.RndCompare(247,223,"入口2");
                    }
                    if (rk==3){
                        commonFunction.RndCompare(117,275,"入口3");

                    }
                    if (rk==4){
                        commonFunction.RndCompare(252,273,"入口4");
                    }
                    if (rk==5){
                        commonFunction.RndCompare(112,327,"入口5");
                    }
                    if (rk==6){
                        commonFunction.RndCompare(251,328,"入口6");
                    }
                    if (rk==7){
                        commonFunction.RndCompare(117,377,"入口7");
                    }
                    if (rk==8){
                        commonFunction.RndCompare(250,380,"入口8");
                    }
                }

                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "找到活动，死了任务结束"));
                if (result.sim > 0.8f) {
                    TaskThread.xshd_3=1;
                    break;
                }

            }
        }

    }


    //神魔战场
    public void  smzc() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;


        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("神魔战场任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.WithdrawTeam();
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
                ret = gamePublicFunction.mission("smzc.png","smzc1.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
             m = commonFunction.DateMinute();
            if (m>57){
                break;
            }
            if (bj==2) {


                result = mFairy.findPic2(commonFunction.setImg("smzcbmcj.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "神魔报名参加"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    Thread.sleep(2000);
                    result = mFairy.findPic2(commonFunction.setImg("smzcbmcj.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "神魔报名参加"));
                    if (result.sim>0.8f){
                        TaskThread.xshd_4=1;
                        break;
                    }
                }
                result = mFairy.findPic2(commonFunction.setImg("smstop.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "神魔没报名次数了"));
                commonFunction.RndCompare(0.8f, 523,502,result, commonFunction.getImg());
                if (result.sim > 0.8f) {
                    TaskThread.xshd_4=1;
                    break;
                }



                result = mFairy.findPic2(1161,1,1279,132,commonFunction.setImg("smzcn.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "神魔战场内"));
                if (result.sim>0.7f){
                    numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                    LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));
                    Thread.sleep(1000);
                    numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                    LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
                    if (numcolor == numcolor1) {
                        js_1++;
                        if (js_1 > 2) {
                            commonFunction.RndCompare(1200,76,"打开地图" );
                            Thread.sleep(2000);
                            commonFunction.RndCompare(660,347,"去中间" );
                            commonFunction.RndCompare(660,347,"去中间" );
                        }
                    } else {
                        js_1 = 0;
                    }
                }

                result = mFairy.findPic2(238,25,310,258,commonFunction.setImg("smzcmap.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "关闭战场地图"));
                commonFunction.RndCompare(0.8f, 1230,32,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("smlk.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "神魔离开"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim > 0.8f) {
                    TaskThread.xshd_4=1;
                    break;
                }

                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

            }
        }

    }

    //仙斗会
    public void  xdh() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        int zdms=0;
        if (AtFairyConfig.getOption("zdms").equals("1")) {
            zdms=1;
        }
        if (AtFairyConfig.getOption("zdms").equals("2")) {
            zdms=2;
        }
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("仙斗会任务中bj="+bj));
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
                ret = gamePublicFunction.mission("xdh1.png","xdh.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            m = commonFunction.DateMinute();
            if (m>55){
                break;
            }
            if (bj==2) {
                if (zdms==1){
                    result = mFairy.findPic2(commonFunction.setImg("drcj.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "单人参加"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(commonFunction.setImg("xdhstop.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙斗会结束了"));
                    if (result.sim>0.8f){
                        gamePublicFunction.WithdrawTeam();
                        TaskThread.xshd_5=1;
                        break;
                    }
                }
                if (zdms==2){
                    result = mFairy.findPic2(commonFunction.setImg("zdcj.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "组队参加"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());

                    result = mFairy.findPic2(commonFunction.setImg("xdhstop.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙斗会结束了"));
                    if (result.sim>0.8f){
                        TaskThread.xshd_5=1;
                        break;
                    }
                }



                result = mFairy.findPic2(359,225,922,471,commonFunction.setImg("Follow up station.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "同意跟站"));
                commonFunction.RndCompare(0.8f, 758,502, result, commonFunction.getImg());

                result = mFairy.findPic2(1161,1,1279,132,commonFunction.setImg("dxt.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "登仙台内"));
                if (result.sim>0.7f){
                    numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                    LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));
                    Thread.sleep(1000);
                    numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                    LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
                    if (numcolor == numcolor1) {
                        js_1++;
                        if (js_1 > 2) {
                            commonFunction.RndCompare(1200,76,"打开地图" );
                            Thread.sleep(2000);
                            commonFunction.RndCompare(658,342,"去中间" );
                            commonFunction.RndCompare(658,342,"去中间" );
                        }
                    } else {
                        js_1 = 0;
                    }
                }



                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

            }
        }

    }

    //灵石护送
    public void  lshs() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("灵石护送任务中bj="+bj));
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
                ret = gamePublicFunction.mission("lshs1.png","lshs.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            m = commonFunction.DateMinute();
            if (m>=58){
                break;
            }
            h = commonFunction.DateHour();
            if (h>=22){
                break;
            }
            if (bj==2) {

                result = mFairy.findPic2(558,300,1220,532,commonFunction.setImg("zgg.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "随处逛逛"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(1161,1,1279,132,commonFunction.setImg("30map.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "昆仑山"));
                commonFunction.RndCompare(0.7f, 1200,76, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("backyaochi.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "返回瑶池"));
                if (result.sim>0.8f){
                    result = mFairy.findPic2(335,24,982,675,commonFunction.setImg("ls.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "灵石"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    if (result.sim<0.8f){
                        js_1++;
                        if (js_1>2){
                            LtLog.e(commonFunction.getLineInfo("多次没有找到灵石结束"));
                            break;
                        }
                        bj=0;
                    }
                }
                result = mFairy.findPic2(commonFunction.setImg("lshscg.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "灵石护送成功"));
                commonFunction.RndCompare(0.8f, 639,484, result, commonFunction.getImg());
            }
        }

    }

    //即墨花灯会
    public void  jmhdh() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("即墨花灯会任务中bj="+bj));
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
                ret = gamePublicFunction.mission("jmhdh1.png","jmhdh.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            m = commonFunction.DateMinute();
            if (m>=31){
                break;
            }
            if (bj==2) {
                result = mFairy.findPic2(commonFunction.setImg("hdstop.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "花灯结束"));
                if (result.sim>0.8f){
                    break;
                }
                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
        }

    }

    //洞天福地
    public void  dtfd() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("洞天福地任务中bj="+bj));
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
                ret = gamePublicFunction.mission("dtfd1.png","dtfd.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            m = commonFunction.DateMinute();
            if (m>=31){
                break;
            }
            if (bj==2) {

                result = mFairy.findPic2(commonFunction.setImg("canzhan.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "参战"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(1161,1,1279,132,commonFunction.setImg("dtfdn.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "洞天福地内"));
                if (result.sim>0.7f){
                    numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                    LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));
                    Thread.sleep(1000);
                    numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                    LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
                    if (numcolor == numcolor1) {
                        js_1++;
                        if (js_1 > 2) {
                            commonFunction.RndCompare(1200,76,"打开地图" );
                            Thread.sleep(2000);
                            commonFunction.RndCompare(660,347,"去中间" );
                            commonFunction.RndCompare(660,347,"去中间" );
                        }
                    } else {
                        js_1 = 0;
                    }
                }
                result = mFairy.findPic2(commonFunction.setImg("fddt.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "关闭洞天地图"));
                commonFunction.RndCompare(0.8f, 1230,32,result, commonFunction.getImg());

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "找到活动，任务结束"));
                if (result.sim > 0.8f) {
                    break;
                }


                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
        }

    }


    //火猫大作战
    public void  hmdzz() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("火猫大作战任务中bj="+bj));
            Thread.sleep(1000);
            if (bj == 0) {
                gamePublicFunction.WithdrawTeam();
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
                ret = gamePublicFunction.mission("hmdzz1.png","hmdzz.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
        /*    m = commonFunction.DateMinute();
            if (m<30){
                break;
            }*/
            if (bj==2) {


                result = mFairy.findPic2(commonFunction.setImg("hmlk.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "离开活动"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    bj=0;
                }


                result = mFairy.findPic2(commonFunction.setImg("bmcj.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "报名参加"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    Thread.sleep(2000);
                    result = mFairy.findPic2(commonFunction.setImg("bmcj.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "报名参加"));
                    if (result.sim>0.8f){
                         break;
                    }
                }



                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "找到活动，任务结束"));
                if (result.sim > 0.8f) {
                    bj=0;
                }


                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
        }

    }

    //同门斗法
    public void  tmdf() throws Exception {
        int bj = 0,bj_1;
        int ret;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0,js_6=0,js_7=0;
        int cs_1=0;
        int h, m, w;
        bj_1 = bj;
        while (true) {
           /* if (bj_1 == bj ) {
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
            }*/
            LtLog.e(commonFunction.getLineInfo("同门斗法任务中bj="+bj));
            Thread.sleep(1000);
            h=commonFunction.DateHour();
            if (h!=21){
                break;
            }
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
                ret = gamePublicFunction.mission("tmdf1.png","tmdf.png", 3);
                if (ret == 0) {
                    break;
                } else if (ret == 1) {
                    bj = 2;
                }

            }
            if (bj==2) {

                result = mFairy.findPic2(commonFunction.setImg("tmbm.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "同门报名"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "找到活动，任务结束"));
                if (result.sim > 0.8f) {
                   break;
                }

                result = commonFunction.FindManyPic(442,5,1270,394, new String[]{"fork1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "发现一个叉子"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
        }

    }

}
