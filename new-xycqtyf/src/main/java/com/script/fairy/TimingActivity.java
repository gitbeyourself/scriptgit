package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    LimitlessTask limitlessTask;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    GameUtil gameUtil;
    boolean zchd=true,hejiu=true,ylwq=true,qllj=true,jiuyousan=true,ljp=true,ljp1=true,xhyx=true,yslm=true,mqzs=true,jzwz=true,jdp=true,bwzq=true;
    TaskContent.ControlSplit  begin =null;
    public TimingActivity(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
    }

    public int timingActivity() throws Exception {
        int h = mFairy.dateHour();
        int m = mFairy.dateMinute();
        int w = mFairy.week();
        int s=(h*60+m)*60;
        int sm = s*1000;
        int back=0;
        for (int i=0 ;i<=1;i++) {
            LtLog.e("查看限时任务！！！！！"+i);

            if (!AtFairyConfig.getOption("optime6").equals("")) {
                begin = strSplit(AtFairyConfig.getOption("optime6"));
                LtLog.e("============" + begin.timeMillis);
            }
            //周常活动
            if (AtFairyConfig.getOption("zchd").equals("1") && zchd && h == 20 && m >= 1) {//h==20 && m>=1
                gameUtil.goCity("轩辕");
                if (w == 1) {
                    judianzhan();
                }
                if (w == 2 && sm >= begin.timeMillis) {
                    swl();
                }
                if (w == 3) {
                    jitian();
                }
                if (w == 4) {
                    bqlt();
                }
                if (w == 5) {
                    judianzhan();
                }
                zchd = false;
                back = 1;
            }
            //千里良驹 12:00-15 18:00-15
            if (AtFairyConfig.getOption("qllj").equals("1") && qllj && (h == 12 || h == 18) && m < 13) {
                gameUtil.goCity("轩辕");
                paoma();
                paoma();
                qllj = false;
                back = 1;
            }
            //千里良驹 20:30-45
            if (AtFairyConfig.getOption("qllj").equals("1") && qllj && h == 20 && m < 43 && m > 28) {
                gameUtil.goCity("轩辕");
                paoma();
                paoma();
                qllj = false;
                back = 1;
            }
       /* //九幽界 12:15-45 18:15-45
        if (AtFairyConfig.getOption("jiuyousan").equals("1")&& jiuyousan  &&  (h==12 || h==18) && m>13 && m<45){
            gameUtil.goCity("轩辕");
            jiuyou();
            jiuyou();
            jiuyousan=false;
            back=1;
        }*/
            //九幽界                      20:45   21:15                 12:15 12:45     18:15  18:45
            if (AtFairyConfig.getOption("jiuyousan").equals("1") && jiuyousan && (s > 74700 && s < 76500 || s > 44100 && s < 45900 || s > 65700 && s < 67500)) {
                gameUtil.goCity("轩辕");
                jiuyou();
                jiuyou();
                jiuyousan = false;
                back = 1;
            }
            //云乐温泉 h>19
            if (AtFairyConfig.getOption("ylwq").equals("1") && ylwq && h >= 19) {
                gameUtil.goCity("轩辕");
                wenquan();
                ylwq = false;
                back = 1;
            }
            //喝酒神兽 19:30 20:30
            if (AtFairyConfig.getOption("hejiu").equals("1") && hejiu && s > 70200 && s < 73800) {
                gameUtil.goCity("轩辕");//图腾回盟
                // hejiu();
                hejiu();
                hejiu = false;
                back = 1;
            }
            //比武招亲竞猜 18:00 -- 19:00
            if (AtFairyConfig.getOption("bwzq").equals("1") && bwzq && h == 18) {
                // hejiu();
                bwzq();
                bwzq = false;
                back = 1;
            }

            if (AtFairyConfig.getOption("gxrc").equals("1")  && h==5  && m==1){
                zchd=true;hejiu=true;ylwq=true;qllj=true;jiuyousan=true;ljp=true;
                ljp1=true;xhyx=true;yslm=true;jzwz=true;mqzs=true;jdp=true;bwzq=true;
                limitlessTask.eliminate = false;
                limitlessTask.sevenStar = false;
                LtLog.e("5点重置任务" );
                limitlessTask.create();
                setTaskName(0);
            }
            //灵宠夺宝
            if (AtFairyConfig.getOption("lcdb").equals("1") && (w == 5 || w == 6 || w == 7) && ((s > 45000 && s < 54000) || (s > 64800 && s < 84600))) {
                gameUtil.goCity("轩辕");
                spoil();
                back = 1;
            }
            //玄海演习场
            if (AtFairyConfig.getOption("xhyx").equals("1") && xhyx && (w == 6 || w == 7) && s > 54000 && s < 84600) {
                gameUtil.goCity("轩辕");
                xuanhai();
                xhyx = false;
                back = 1;
            }
            //	跃升龙门//	诸神之战
            if (AtFairyConfig.getOption("8781").equals("1") && yslm && s > 36000 && s < 85800) {

                boolean n = false;//判断是否开始剑指王者活动

                if (AtFairyConfig.getOption("yslmjjc").equals("2")) {
                    LtLog.e(mFairy.getLineInfo("用户勾选无限打 - 开始活动"));
                    n = true;
                }

                if (!AtFairyConfig.getOption("yslm_start_time").equals("") && !AtFairyConfig.getOption("yslm_stop_time").equals("")) {//是否设置了时间
                    ControlSplit start_time = strSplit(AtFairyConfig.getOption("yslm_start_time"));//开始时间
                    ControlSplit stop_time = strSplit(AtFairyConfig.getOption("yslm_stop_time"));//结束时间

                    if ((h > start_time.h && h < stop_time.h) || (h == start_time.h && m >= start_time.m) || (h == stop_time.h && m < stop_time.m)) {
                        n = true;
                    }
                } else {
                    LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                }
                if (n) {
                    gameUtil.goCity("轩辕");
                    yslm();
                    yslm = false;
                    back = 1;
                }
            }
            //	秘潜铸身
            if (AtFairyConfig.getOption("8855").equals("1") && mqzs && s>61200 && s<85800) {

                boolean n = false;//判断是否开始剑指王者活动

                if (AtFairyConfig.getOption("mqzsjjc").equals("2")) {
                    LtLog.e(mFairy.getLineInfo("用户勾选无限打 - 开始活动"));
                    n = true;
                }

                if (AtFairyConfig.getOption("mqzsjjc").equals("1") || AtFairyConfig.getOption("mqzsDIYsj").equals("1")) {//是否勾选 diy 或者 首胜
                    if (!AtFairyConfig.getOption("mqzs_start_time").equals("") && !AtFairyConfig.getOption("mqzs_stop_time").equals("")) {//是否设置了时间
                        ControlSplit start_time = strSplit(AtFairyConfig.getOption("mqzs_start_time"));//开始时间
                        ControlSplit stop_time = strSplit(AtFairyConfig.getOption("mqzs_stop_time"));//结束时间

                        if ((h > start_time.h && h < stop_time.h) || (h == start_time.h && m >= start_time.m) || (h == stop_time.h && m < stop_time.m)) {
                            n = true;
                        }
                    } else {
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }
                if (n) {
                    gameUtil.goCity("轩辕");
                    mqzs();
                    mqzs = false;
                    back = 1;
                }
            }

            //	剑指王者  (s > 45000 && s < 54000) || (s > 75600 && s < 85800)
            if (AtFairyConfig.getOption("5219").equals("1") && jzwz && s > 36000 && s < 85800) {

                boolean j = false;//判断是否开始剑指王者活动

                if (AtFairyConfig.getOption("jjc").equals("2")) {
                    LtLog.e(mFairy.getLineInfo("用户勾选无限打 - 开始活动"));
                    j = true;
                }

                if (AtFairyConfig.getOption("jjc").equals("1") || AtFairyConfig.getOption("DIYsj").equals("1")) {//是否勾选 diy 或者 首胜
                    if (!AtFairyConfig.getOption("start_time").equals("") && !AtFairyConfig.getOption("stop_time").equals("")) {//是否设置了时间
                        ControlSplit start_time = strSplit(AtFairyConfig.getOption("start_time"));//开始时间
                        ControlSplit stop_time = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间

                        if ((h > start_time.h && h < stop_time.h) || (h == start_time.h && m >= start_time.m) || (h == stop_time.h && m < stop_time.m)) {
                            j = true;
                        }
                    } else {
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }
                if (j) {
                    gameUtil.goCity("轩辕");
                    jzwz();
                    jzwz = false;
                    back = 1;
                }
            }
            //决斗牌在线
            if (jdp && AtFairyConfig.getOption("7764").equals("1") && !AtFairyConfig.getOption("jdpzx").equals("3")) {
                gameUtil.goCity("轩辕");
                jdp();
                jdp = false;
            }
            //领金票
            if (AtFairyConfig.getOption("ljp").equals("1") && ljp && s > 45000 && s < 50400) {
                gameUtil.cifu();
                ljp = false;
                back = 1;
            }
            //领金票
            if (AtFairyConfig.getOption("ljp").equals("1") && ljp1 && s > 66600 && s < 72000) {
                gameUtil.cifu();
                ljp1 = false;
                back = 1;
            }

           /* //领金票
            if (AtFairyConfig.getOption("ljp").equals("1") && ljp && s > 45000 && s < 50400) {
                gameUtil.tansuo();
                ljp = false;
                back = 1;
            }*/

        }
        return back;

    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("smOverGraph.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("In transmission.png");
        if (result.sim > 0.7f) {
            LtLog.e(mFairy.getLineInfo("传送中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("road.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "complete.png");
        mFairy.onTap(0.8f, result, "完成", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "accept.png");
        mFairy.onTap(0.8f, result, "接受", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }



    public void mqzs() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("hu1.png");
                mFairy.onTap(0.8f,result,986,122,1002,134,"关闭图腾界面",1000);
                int s1 =0;
                int s2 =0;
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s=(h*60+m)*60;

                if (!(s>61200 && s<85800)){        //(（当前时间大于10点小于24点）取反
                    LtLog.e(mFairy.getLineInfo("活动时间未到结束"));
                    setTaskEnd();return;
                }

                if(AtFairyConfig.getOption("mqzsjjc").equals("1") || AtFairyConfig.getOption("mqzsDIYsj").equals("1")){//是否勾选 diy 或者首胜
                    if(!AtFairyConfig.getOption("mqzs_start_time").equals("") && !AtFairyConfig.getOption("mqzs_stop_time").equals("")){//是否设置了时间
                        ControlSplit stop_time = strSplit(AtFairyConfig.getOption("mqzs_stop_time"));//结束时间

                        if( (h>stop_time.h) || (h==stop_time.h && m>stop_time.m)) {
                            LtLog.e(mFairy.getLineInfo("已经达到设置的时间,结束任务!"));
                            setTaskEnd();
                            return;
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }
            }

            @Override
            public void create() throws Exception {
               /* if (AtFairyConfig.getOption("rbt").equals("1")) {
                    back = strSplit(AtFairyConfig.getOption("jzsj"));
                }*/
            }
            int ydcount=0,x11=0,x12=0,n=0;
            int x=179,y=479,x1=173,y1=662,a=0;
            boolean jjtime=true;
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(18, 0)) return;

                if (a==10){
                    a=0;
                    setTaskEnd();return;
                }
                result = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png","bahuang.png","bh.png"});
                mFairy.onTap(0.8f, result, "天外山海图标", 1500);

                result = mFairy.findPic(400,458,1145,683, new String[]{"bhjc.png"});
                mFairy.onTap(0.8f, result, "八荒进程", 1500);

                result = mFairy.findPic(72,151,1227,423, new String[]{"mqzs.png"});
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, "秘潜铸身", Sleep);
                    n=0;
                    setTaskName(2);
                    return;
                }else{
                    a++;
                }

                result = mFairy.findPic(481,42,807,248, new String[]{"bnbm.png"});
                if (result.sim>0.8f) {
                    LtLog.e("不能报名!!!");
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30,0))return;


                result=mFairy.findPic(673,124,772,221,"3v3 dont match.png");
                mFairy.onTap(0.8f,result,"战场逃出，无法报名,等待5分钟",1000);
                //mFairy.onTap(0.8f,result,1241,60,1257,78,"关闭",1000);
                if(result.sim>0.8f){
                    mFairy.sleep(300000);
//                    setTaskEnd();
//                    return;
                }


                result =mFairy.findPic("zhanpao.png");
                mFairy.onTap(0.8f,result,641,437,650,443,"战袍模式",Sleep);

                result =mFairy.findPic("zhanpao.png");
                mFairy.onTap(0.8f,result,641,437,650,443,"战袍模式",Sleep);

                result =mFairy.findPic(646,237,1269,646,new String[]{"new_jymatching.png","grpp.png"});
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result =mFairy.findPic(369,265,920,500,"zp.png");
                mFairy.onTap(0.8f,result,625,428,659,448,"战袍确认",Sleep);

                result =mFairy.findPic(349,253,913,518,"yjzdwz.png");
                if (result.sim >0.8f) {
                    result = mFairy.findPic(657, 392, 913, 503, "Intheteam.png");
                    mFairy.onTap(0.8f, result, "队伍中确定", Sleep);
                }

                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }
                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }



                result =mFairy.findPic(646,237,1269,646,"pipeizhong.png");
                if (result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                }
                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);
                if (result.sim>0.8f) {
                    jjtime = true;
                }


                result1 =mFairy.findPic(506,3,830,70,"js.png");
                result =mFairy.findPic(1115,2,1280,32,"mqzs1.png");
                if (result.sim > 0.8f  || result1.sim > 0.8f) {
                    err=0;
                    LtLog.e(mFairy.getLineInfo("秘潜铸身中"));

                    int x = new Random().nextInt(170) + 87;
                    int y = new Random().nextInt(164) + 493;
                    mFairy.ranSwipe(172, 570, x, y, 2000, (long) 1000, 2);

                    mFairy.onTap(0.8f, result, 1177, 608, 1197, 624, "普工一下", 100);
                    mFairy.onTap(0.8f, result, 1177, 608, 1197, 624, "普工一下", 100);
                    mFairy.onTap(0.8f, result, 1177, 608, 1197, 624, "普工一下", 100);
                    mFairy.onTap(0.8f, result, 1049,653,1058,664, "技能攻击", 100);


                    result = mFairy.findPic("Openbox.png");
                    mFairy.onTap(0.8f, result, "开箱", 5000);

                    result = mFairy.findPic( 302,172,1037,576,"xueren.png");
                    mFairy.onTap(0.8f, result, "打雪 人", Sleep);

                }


                result =mFairy.findPic(393,146,948,510,"zb.png");
                if (result.sim>0.8f){
                    jjtime=true;
                    LtLog.e("竞技结束");
                    if (AtFairyConfig.getOption("jjc").equals("1")) {
                        result =mFairy.findPic(393,146,948,510,"zb.png");
                        if (result2.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("胜利一次完成"));
                            result =mFairy.findPic("chakanshuju.png");
                            mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                            result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                            mFairy.onTap(0.8f,result,"退出副本",Sleep);

                            result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                            mFairy.onTap(0.8f,result,"退出战场",Sleep);
                            if (result.sim > 0.8f || result2.sim > 0.8f) {
                                setTaskEnd();
                                return;
                            }
                        }
                    }


                    result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);


                    result =mFairy.findPic(393,146,948,510,"zb.png");
                    mFairy.onTap(0.8f,result,669,433,682,444,"离开",Sleep);

                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    if(result.sim>0.8f){
                        mFairy.sleep(5000);
                        mFairy.onTap(0.8f,result,"退出战场",Sleep);
                    }

                }

            }

        }.taskContent(mFairy, "秘潜铸身中");
    } //秘潜铸身

    public void yslm() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("hu1.png");
                mFairy.onTap(0.8f,result,986,122,1002,134,"关闭图腾界面",1000);
                int s1 =0;
                int s2 =0;
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s=(h*60+m)*60;



                if(!AtFairyConfig.getOption("mqzs_start_time").equals("") && !AtFairyConfig.getOption("mqzs_stop_time").equals("")){//是否设置了时间
                    ControlSplit stop_time = strSplit(AtFairyConfig.getOption("mqzs_stop_time"));//结束时间

                    if( (h>stop_time.h) || (h==stop_time.h && m>stop_time.m)) {
                        LtLog.e(mFairy.getLineInfo("已经达到设置的时间,结束任务!"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                }

            }

            @Override
            public void create() throws Exception {
               /* if (AtFairyConfig.getOption("rbt").equals("1")) {
                    back = strSplit(AtFairyConfig.getOption("jzsj"));
                }*/
            }
            int n=0;
            int a=0;
            int tc=0;
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(18, 0)) return;
                if (a==10 || a==20){
                    gameUtil.close(1);
                }

                if (a>=30){
                    setTaskEnd();return;
                }
                result1 = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png","bahuang.png","bh.png","bh1.png"});
                mFairy.onTap(0.8f, result1, "天外山海图标", 1500);

                result2 = mFairy.findPic(400,458,1145,683, new String[]{"bhjc.png","bhjc1.png"});
                mFairy.onTap(0.8f, result2, "八荒进程", 1500);

                result = mFairy.findPic(55,127,1197,340, new String[]{"zsld1.png","zsld3.png"});
                if (result.sim>0.8f||result1.sim>0.8f||result2.sim>0.8f){
                    a=0;
                }else{
                    a++;
                }
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, "诸神乱斗", Sleep);
                    n=0;
                    setTaskName(2);
                    return;
                }
                result1 =mFairy.findPic(1104,1,1280,34,"zsld2.png");
                if (result1.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("诸神之战中"));
                    a=0;
                    setTaskName(2);
                    return;
                }

                result1 =mFairy.findPic(587,149,744,212,new String[]{"jiesuan.png","jiesuan1.png"});
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result1, 665, 433, 682, 441, "确定", Sleep);
                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    if(result.sim>0.8f){
                        mFairy.sleep(5000);
                        mFairy.onTap(0.8f,result,"退出战场",Sleep);
                        tc=0;
                    }
                }
                result = mFairy.findPic(481,42,807,248, new String[]{"bnbm.png","jiesuo.png"});
                if (result.sim>0.8f) {
                    LtLog.e("不能报名!!!");
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30,0))return;

                result=mFairy.findPic(673,124,772,221,"3v3 dont match.png");
                mFairy.onTap(0.8f,result,"战场逃出，无法报名,等待5分钟",1000);
                if(result.sim>0.8f){
                    mFairy.sleep(300000);
//                    setTaskEnd();
//                    return;
                }

                result =mFairy.findPic(862,501,1200,648,new String[]{"new_jymatching.png","grpp.png"});
                if (result.sim>0.8f){
                    result1 =mFairy.findPic(1087,534,1135,570,"wjl.png");
                    if (result1.sim>0.8f){
                        LtLog.e("无奖励次数");
                        setTaskEnd();
                    }else{
                        mFairy.onTap(0.8f,result,"个人匹配",Sleep);
                    }
                }

                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }


                result =mFairy.findPic(868,499,1206,654,"pipeizhong1.png");
                if (result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                }


                result =mFairy.findPic(662,381,894,500,"jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);

                result =mFairy.findPic(1104,1,1280,34,"zsld2.png");
                if (result.sim > 0.8f) {
                    err=0;
                    LtLog.e(mFairy.getLineInfo("诸神之战中"));

                    mFairy.onTap(0.8f, result, 1173,609,1191,630, "普工一下", 500);
                    mFairy.onTap(0.8f, result, 1173,609,1191,630, "普工一下", 500);
                    result =mFairy.findPic(471,79,810,247,"shifang.png");
                    if (result.sim>0.8f){
                        mFairy.onTap(0.8f, result, 1200,90,1208,96,"打开地图", 1000);
                        mFairy.onTap(0.8f, result, 419,363,424,365,"选择地图", 1000);
                        mFairy.onTap(0.8f, result, 1242,44,1249,52,"关闭地图", 1000);
                    }
                    mFairy.onTap(0.8f, result, 1173,609,1191,630, "普工一下", 500);
                    mFairy.onTap(0.8f, result, 1173,609,1191,630, "普工一下", 500);

                    result = mFairy.findPic("Openbox.png");
                    mFairy.onTap(0.8f, result, "开箱", 5000);

                }


                result =mFairy.findPic(481,1,788,76,"tuichu.png");
                result1 =mFairy.findPic(587,149,744,212,new String[]{"jiesuan.png","jiesuan1.png"});
                if (result.sim>0.8f || result1.sim>0.8f){
                    LtLog.e("竞技结束");
                    tc=1;
                    mFairy.onTap(0.8f,result1,665,433,682,441,"确定",Sleep);

                    result =mFairy.findPic(1157,149,1278,270,new String[]{"3v3leave.png","3v3leave1.png"});
                    mFairy.onTap(0.8f,result,"退出副本",Sleep);

                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    if(result.sim>0.8f){
                        mFairy.sleep(5000);
                        mFairy.onTap(0.8f,result,"退出战场",Sleep);
                        tc=0;
                    }

                    result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);


                    result =mFairy.findPic(393,146,948,510,"zb.png");
                    mFairy.onTap(0.8f,result,669,433,682,444,"离开",Sleep);

                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    if(result.sim>0.8f){
                        mFairy.sleep(5000);
                        mFairy.onTap(0.8f,result,"退出战场",Sleep);
                        tc=0;
                    }

                }

            }

        }.taskContent(mFairy, "诸神乱斗中");
    } //诸神乱斗

   /* 1
    public void yslm() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("hu1.png");
                mFairy.onTap(0.8f,result,986,122,1002,134,"关闭图腾界面",1000);
                int s1 =0;
                int s2 =0;
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s=(h*60+m)*60;

                if (!(s>36000 && s<85800)){        //(（当前时间大于10点小于24点）取反
                    LtLog.e(mFairy.getLineInfo("活动时间未到剑指王者结束"));
                    setTaskEnd();return;
                }*//*else if (AtFairyConfig.getOption("DIYsj").equals("1") || AtFairyConfig.getOption("jjc").equals("1")) {
                    if (!AtFairyConfig.getOption("start_time").equals("")){

                        if (strSplit(AtFairyConfig.getOption("start_time")) != null) {
                            start = strSplit(AtFairyConfig.getOption("start_time"));//开始时间
                            s1 = (start.h * 60 + start.m) * 60;

                            stop = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间
                            s2 = (stop.h * 60 + stop.m) * 60;

                            if (!(s >= s1 && s < s2)) {
                                LtLog.e(mFairy.getLineInfo("不在开始和结束时间以内剑指王者结束"));
                                setTaskEnd();
                                return;
                            }
                        }
                }
                }*//*

                if(AtFairyConfig.getOption("yslmjjc").equals("1") || AtFairyConfig.getOption("yslmDIYsj").equals("1")){//是否勾选 diy 或者首胜
                    if(!AtFairyConfig.getOption("yslm_start_time").equals("") && !AtFairyConfig.getOption("yslm_stop_time").equals("")){//是否设置了时间
                        ControlSplit stop_time = strSplit(AtFairyConfig.getOption("yslm_stop_time"));//结束时间

                        if( (h>stop_time.h) || (h==stop_time.h && m>stop_time.m)) {
                            LtLog.e(mFairy.getLineInfo("已经达到设置的时间,结束任务!"));
                            setTaskEnd();
                            return;
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }

            }

            @Override
            public void create() throws Exception {
               *//* if (AtFairyConfig.getOption("rbt").equals("1")) {
                    back = strSplit(AtFairyConfig.getOption("jzsj"));
                }*//*
            }
            int ydcount=0,x11=0,x12=0,n=0;
            int x=179,y=479,x1=173,y1=662,a=0;
            boolean jjtime=true;
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(8, 0)) return;

                if (a==10){
                    a=0;
                    setTaskEnd();return;
                }
                result = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png","bahuang.png","bh.png"});
                mFairy.onTap(0.8f, result, "天外山海图标", 1500);

                result = mFairy.findPic(400,458,1145,683, new String[]{"bhjc.png"});
                mFairy.onTap(0.8f, result, "八荒进程", 1500);

                result = mFairy.findPic(72,151,1227,423, new String[]{"ydlm.png"});
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, "跃斗龙门", Sleep);
                    n=0;
                    setTaskName(2);
                    return;
                }else{
                    a++;
                }

                result = mFairy.findPic(481,42,807,248, new String[]{"bnbm.png"});
                if (result.sim>0.8f) {
                    LtLog.e("不能报名!!!");
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30,0))return;


                result=mFairy.findPic(673,124,772,221,"3v3 dont match.png");
                mFairy.onTap(0.8f,result,"战场逃出，无法报名,等待5分钟",1000);
                //mFairy.onTap(0.8f,result,1241,60,1257,78,"关闭",1000);
                if(result.sim>0.8f){
                    mFairy.sleep(300000);
//                    setTaskEnd();
//                    return;
                }


                result =mFairy.findPic("zhanpao.png");
                mFairy.onTap(0.8f,result,641,437,650,443,"战袍模式",Sleep);

                result =mFairy.findPic(646,237,1269,646,new String[]{"new_jymatching.png","grpp.png"});
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result =mFairy.findPic(369,265,920,500,"zp.png");
                mFairy.onTap(0.8f,result,625,428,659,448,"战袍确认",Sleep);

                result =mFairy.findPic(349,253,913,518,"yjzdwz.png");
                if (result.sim >0.8f) {
                    result = mFairy.findPic(657, 392, 913, 503, "Intheteam.png");
                    mFairy.onTap(0.8f, result, "队伍中确定", Sleep);
                }

                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }
                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }



                result =mFairy.findPic(646,237,1269,646,"pipeizhong.png");
                if (result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                }
                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);
                if (result.sim>0.8f) {
                    jjtime = true;
                }
                result =mFairy.findPic(584,4,700,99,"vs.png");
                if (result.sim>0.8f){
                    result =mFairy.findPic(419,58,488,105,"wofang.png");
                    result1 =mFairy.findPic(1119,4,1280,37,new String[]{"1d1jjc.png","jlpk.png"});
                    if (result.sim>0.8f){
                        if (result1.sim>0.8f){
                            LtLog.e("竞技场我方在左边 直走");
                            x=174;
                            y=500;
                            x1=174;
                            y1=630;
                        }else {
                            LtLog.e("竞技场我方在左边");
                            x = 253;
                            y = 556;
                            x1 = 89;
                            y1 = 572;
                        }
                    }
                    result =mFairy.findPic(778,65,845,99,"wofang.png");
                    result1 =mFairy.findPic(1119,4,1280,37,new String[]{"1d1jjc.png","jlpk.png"});
                    if (result.sim>0.8f){
                        if (result1.sim>0.8f){
                            LtLog.e("竞技场我方在左边 直走");
                            x=174;
                            y=500;
                            x1=174;
                            y1=630;
                        }else {
                            LtLog.e("竞技场我方在左边");
                            x = 90;
                            y = 593;
                            x1 = 257;
                            y1 = 576;
                        }
                    }
                }

                result1 =mFairy.findPic(509,0,803,128,"vs.png");
                result =mFairy.findPic(1118,2,1280,33,new String[]{"gp.png","jjc.png",});
                result2 =mFairy.findPic(593,69,694,103,"zdjd.png");
                if (result2.sim>0.8f){
                    if (jjtime){
                        Thread.sleep(12000);
                        jjtime=false;
                    }
                    err=0;
                    LtLog.e(mFairy.getLineInfo("竞技场中"));
                    result3 = mFairy.findPic(1040, 201, 1272, 354,"duishou.png");
                    if (result3.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("有敌人"));
                        mFairy.onTap(0.8f, result3,  "选择对手", Sleep);
                        mFairy.onTap(1172, 610, 1191, 622, "普攻下", 50);
                        mFairy.onTap(1172, 610, 1191, 622, "普攻下", 50);
                        mFairy.onTap(1118, 483, 1138, 497, "技能1", 50);
                        mFairy.onTap(1223, 473, 1242, 489, "技能2", 50);
                        mFairy.onTap(1039, 552, 1057, 569, "技能3", 50);
                        mFairy.onTap(1049, 646, 1065, 663, "技能4", 50);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    }else {
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        LtLog.e(mFairy.getLineInfo("没有敌人，移动一下"));
                        ydcount++;
                        if (ydcount<15){

                            mFairy.ranSwipe(174,572,x,y,1500, (long) 100,1);
                        }else if (ydcount>=15 && ydcount<=18){
                            mFairy.ranSwipe(174,572,x1,y1,1500, (long) 100,1);
                        }
                        if (ydcount>18){
                            ydcount=0;
                        }
                    }
                }
                result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                if (result.sim>0.8f){
                    jjtime=true;
                    LtLog.e("竞技结束");
                    if (AtFairyConfig.getOption("jjc").equals("1")) {
                        result2 =mFairy.findPic(459,5,865,186,new String[]{"3v3victory.png","shengli.png","sheng.png"});
                        if (result2.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("胜利一次完成"));
                            result =mFairy.findPic("chakanshuju.png");
                            mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                            result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                            mFairy.onTap(0.8f,result,"退出副本",Sleep);

                            result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                            mFairy.onTap(0.8f,result,"退出战场",Sleep);
                            if (result.sim > 0.8f || result2.sim > 0.8f) {
                                setTaskEnd();
                                return;
                            }
                        }
                    }


                    result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);


                    result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                    mFairy.onTap(0.8f,result,"退出副本",Sleep);

                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    if(result.sim>0.8f){
                        mFairy.sleep(5000);
                        mFairy.onTap(0.8f,result,"退出战场",Sleep);
                    }

                }
            }

        }.taskContent(mFairy, "跃升龙门中");
    } //跃升龙门
1*/

    public void jzwz() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("hu1.png");
                mFairy.onTap(0.8f,result,986,122,1002,134,"关闭图腾界面",1000);
                int s1 =0;
                int s2 =0;
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s=(h*60+m)*60;

                if (!(s>36000 && s<85800)){        //(（当前时间大于10点小于24点）取反
                    LtLog.e(mFairy.getLineInfo("活动时间未到剑指王者结束"));
                    setTaskEnd();return;
                }/*else if (AtFairyConfig.getOption("DIYsj").equals("1") || AtFairyConfig.getOption("jjc").equals("1")) {
                    if (!AtFairyConfig.getOption("start_time").equals("")){

                        if (strSplit(AtFairyConfig.getOption("start_time")) != null) {
                            start = strSplit(AtFairyConfig.getOption("start_time"));//开始时间
                            s1 = (start.h * 60 + start.m) * 60;

                            stop = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间
                            s2 = (stop.h * 60 + stop.m) * 60;

                            if (!(s >= s1 && s < s2)) {
                                LtLog.e(mFairy.getLineInfo("不在开始和结束时间以内剑指王者结束"));
                                setTaskEnd();
                                return;
                            }
                        }
                }
                }*/

                if(AtFairyConfig.getOption("jjc").equals("1") || AtFairyConfig.getOption("DIYsj").equals("1")){//是否勾选 diy 或者首胜
                    if(!AtFairyConfig.getOption("start_time").equals("") && !AtFairyConfig.getOption("stop_time").equals("")){//是否设置了时间
                        ControlSplit stop_time = strSplit(AtFairyConfig.getOption("stop_time"));//结束时间

                        if( (h>stop_time.h) || (h==stop_time.h && m>stop_time.m)) {
                            LtLog.e(mFairy.getLineInfo("已经达到设置的时间,结束任务!"));
                            setTaskEnd();
                            return;
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("玩家没有设置时间！！！"));
                    }
                }

                /*if (back != null  && timekeep(0, back.timeMillis, "剑指王者打多久")) {
                    LtLog.e(mFairy.getLineInfo("时间到了剑指王者结束"));
                   *//* result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                    result =mFairy.findPic(1003,484,1175,540,"tuichuzhanchang.png");
                    mFairy.onTap(0.8f,result,"退出战场",Sleep);
                    if (result.sim > 0.8f){

                    }*//*
                    setTaskEnd();return;
                }else {
                   *//* result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                    result =mFairy.findPic(1003,484,1175,540,"tuichuzhanchang.png");
                    mFairy.onTap(0.8f,result,"退出战场",Sleep);*//*
                }*/

            }

            @Override
            public void create() throws Exception {
               /* if (AtFairyConfig.getOption("rbt").equals("1")) {
                    back = strSplit(AtFairyConfig.getOption("jzsj"));
                }*/
            }
            int ydcount=0,x11=0,x12=0,n=0;
            int x=179,y=479,x1=173,y1=662,a=0;
            boolean jjtime=true;
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                if (a==10){
                    a=0;
                    setTaskEnd();return;
                }

                //  if(overtime(30,99))return;
                int ret = gameUtil.mission("3v3Arena.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    gameUtil.close(1);
                    setTaskName(3);
                    return;
                }

              /*  result =mFairy.findPic("jiahao.png");
                mFairy.onTap(0.8f,result,"展开",Sleep);

                result =mFairy.findPic(281,2,1109,231,"jianzhi.png");
                mFairy.onTap(0.8f,result,"剑指王者",Sleep);

                result =mFairy.findPic("jianzhi2.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }*/
            }

            public void content_2() throws Exception {
                if (overtime(30,0))return;


                result=mFairy.findPic(673,124,772,221,"3v3 dont match.png");
                mFairy.onTap(0.8f,result,"战场逃出，无法报名,等待5分钟",1000);
                //mFairy.onTap(0.8f,result,1241,60,1257,78,"关闭",1000);
                if(result.sim>0.8f){
                    mFairy.sleep(300000);
//                    setTaskEnd();
//                    return;
                }


                result =mFairy.findPic("zhanpao.png");
                mFairy.onTap(0.8f,result,641,437,650,443,"战袍模式",Sleep);

                result =mFairy.findPic(646,237,1269,646,new String[]{"new_jymatching.png","grpp.png"});
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result =mFairy.findPic(369,265,920,500,"zp.png");
                mFairy.onTap(0.8f,result,625,428,659,448,"战袍确认",Sleep);

                result =mFairy.findPic(349,253,913,518,"yjzdwz.png");
                if (result.sim >0.8f) {
                    result = mFairy.findPic(657, 392, 913, 503, "Intheteam.png");
                    mFairy.onTap(0.8f, result, "队伍中确定", Sleep);
                }

                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }
                result =mFairy.findPic("nobao.png");
                if (result.sim>0.8f) {
                    LtLog.e("当前时间段不能报名");
                    setTaskEnd();
                }



                result =mFairy.findPic(646,237,1269,646,"pipeizhong.png");
                if (result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                }
                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);
                if (result.sim>0.8f) {
                    jjtime = true;
                }
                result =mFairy.findPic(584,4,700,99,"vs.png");
                if (result.sim>0.8f){
                    result =mFairy.findPic(419,58,488,105,"wofang.png");
                    result1 =mFairy.findPic(1119,4,1280,37,new String[]{"1d1jjc.png","jlpk.png"});
                    if (result.sim>0.8f){
                        if (result1.sim>0.8f){
                            LtLog.e("竞技场我方在左边 直走");
                            x=174;
                            y=500;
                            x1=174;
                            y1=630;
                        }else {
                            LtLog.e("竞技场我方在左边");
                            x = 253;
                            y = 556;
                            x1 = 89;
                            y1 = 572;
                        }
                    }
                    result =mFairy.findPic(778,65,845,99,"wofang.png");
                    result1 =mFairy.findPic(1119,4,1280,37,new String[]{"1d1jjc.png","jlpk.png"});
                    if (result.sim>0.8f){
                        if (result1.sim>0.8f){
                            LtLog.e("竞技场我方在左边 直走");
                            x=174;
                            y=500;
                            x1=174;
                            y1=630;
                        }else {
                            LtLog.e("竞技场我方在左边");
                            x = 90;
                            y = 593;
                            x1 = 257;
                            y1 = 576;
                        }
                    }
                }

                result1 =mFairy.findPic(509,0,803,128,"vs.png");
                result =mFairy.findPic(1118,2,1280,33,new String[]{"gp.png","jjc.png",});
                result2 =mFairy.findPic(593,69,694,103,"zdjd.png");
                if (result2.sim>0.8f){
                    if (jjtime){
                        Thread.sleep(12000);
                        jjtime=false;
                    }
                    err=0;
                    LtLog.e(mFairy.getLineInfo("竞技场中"));
                    result3 = mFairy.findPic(1040, 201, 1272, 354,"duishou.png");
                    if (result3.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("有敌人"));
                        mFairy.onTap(0.8f, result3,  "选择对手", Sleep);
                        mFairy.onTap(1172, 610, 1191, 622, "普攻下", 50);
                        mFairy.onTap(1172, 610, 1191, 622, "普攻下", 50);
                        mFairy.onTap(1118, 483, 1138, 497, "技能1", 50);
                        mFairy.onTap(1223, 473, 1242, 489, "技能2", 50);
                        mFairy.onTap(1039, 552, 1057, 569, "技能3", 50);
                        mFairy.onTap(1049, 646, 1065, 663, "技能4", 50);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                        mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    }else {
                    mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    mFairy.onTap(0.8f,result,1172,610,1191,622,"普攻下",100);
                    LtLog.e(mFairy.getLineInfo("没有敌人，移动一下"));
                    ydcount++;
                    if (ydcount<15){

                        mFairy.ranSwipe(174,572,x,y,1500, (long) 100,1);
                    }else if (ydcount>=15 && ydcount<=18){
                        mFairy.ranSwipe(174,572,x1,y1,1500, (long) 100,1);
                    }
                    if (ydcount>18){
                        ydcount=0;
                    }
                    }
                }
                result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                if (result.sim>0.8f){
                    jjtime=true;
                    LtLog.e("竞技结束");
                    if (AtFairyConfig.getOption("jjc").equals("1")) {
                        result2 =mFairy.findPic(459,5,865,186,new String[]{"3v3victory.png","shengli.png","sheng.png"});
                        if (result2.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("胜利一次完成"));
                            result =mFairy.findPic("chakanshuju.png");
                            mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);

                            result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                            mFairy.onTap(0.8f,result,"退出副本",Sleep);

                            result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                            mFairy.onTap(0.8f,result,"退出战场",Sleep);
                            if (result.sim > 0.8f || result2.sim > 0.8f) {
                                setTaskEnd();
                                return;
                            }
                        }
                    }


                    result =mFairy.findPic("chakanshuju.png");
                    mFairy.onTap(0.8f,result,1242,115,1259,130,"关闭查看数据",Sleep);


                    result =mFairy.findPic(839,5,1277,125,new String[]{"3v3leave.png","3v3leave1.png"});
                    mFairy.onTap(0.8f,result,"退出副本",Sleep);

                    result =mFairy.findPic(913,429,1269,704,"tuichuzhanchang.png");
                    if(result.sim>0.8f){
                        mFairy.sleep(5000);
                        mFairy.onTap(0.8f,result,"退出战场",Sleep);
                    }

                }
            }

            public void content_3() throws Exception {
                if (overtime(8, 0)) return;

                result = mFairy.findPic(950,4,1120,156,"daily.png");
                mFairy.onTap(0.8f,result,1077,44,1081,56,"打开日常扩展栏",1000);

                result = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png","bahuang.png","bh.png"});
                mFairy.onTap(0.8f, result, "天外山海图标", Sleep);

                result = mFairy.findPic(384,430,1139,695, new String[]{"jz.png"});
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "剑指王者", 500);
                    for (int i = 0; i < 20; i++){
                        result = mFairy.findPic(493,56,805,258, new String[]{"wkq.png"});
                        if (result.sim>0.8f){
                            n=1;
                            break;
                        }
                    }
                }


                if (n==1){
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"bhjc.png"});
                    mFairy.onTap(0.8f, result, "八荒进程", 1500);

                    result = mFairy.findPic(72,151,1227,423, new String[]{"ydlm.png"});
                    if (result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, "跃斗龙门", Sleep);
                        n=0;
                        setTaskName(2);
                        return;
                    }else{
                        a++;
                    }

                }
                result = mFairy.findPic(481,42,807,248, new String[]{"bnbm.png"});
                if (result.sim>0.8f) {
                    LtLog.e("不能报名!!!");
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "剑指王者中");
    } //剑指王者

    public void jdp() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("ling.png");
                if (result.sim > 0.8f){
                    LtLog.e("匹配中。。。");
                    return;
                }

                result = mFairy.findPic(1,631,91,712,"Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic(236,538,1003,632,"juedoupai.png");
                mFairy.onTap(0.8f, result, "打开决斗牌", Sleep);

                result = mFairy.findPic(1139,86,1265,199,"jingji.png");
                mFairy.onTap(0.8f, result, "竞技", Sleep);

                result = mFairy.findPic(199,532,1015,696,"pipei.png");
                mFairy.onTap(0.8f, result, "匹配", Sleep);

              /*  result1 = mFairy.findPic("mianfei.png");
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(424, 86, 1057, 554, "box.png");
                    mFairy.onTap(0.8f, result, "挖矿2", Sleep);
                }*/
                result1 = mFairy.findPic("null.png");
                if (result1.sim > 0.8f){
                    LtLog.e("没有牌结束");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("isme.png");
                LtLog.e("我方回合相似度"+result.sim);
                if (result.sim > 0.9f){
                    result = mFairy.findPic("roundzero.png");//412,644,900,676,
                    mFairy.onTap(0.8f,result,"上牌",Sleep);
                    mFairy.onTap(0.8f,result,1198,402,1207,415,"回合结束",3000);
                }else{
                    LtLog.e("不是我方回合");
                }

               /* result = mFairy.findPic("nome.png");
                LtLog.e("不是我方回合相似度"+result.sim);
                */

                if (AtFairyConfig.getOption("jdpzx").equals("1")) {
                    result1 = mFairy.findPic("win.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e("赢了结束了");
                        gameUtil.close(1);
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic( "jixu.png");
                mFairy.onTap(0.8f, result, "继续结束了", Sleep);

                result = mFairy.findPic(437,529,556,628,"suo.png");
                if (result.sim > 0.8f){
                    LtLog.e("还没开启");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "决斗牌");
    } //决斗牌匹配

    public void paoma() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {

                result =mFairy.findPic(533,301,775,406,"csqr.png");
                mFairy.onTap(0.8f,result,771,433,782,444,"传送确认",Sleep);

                int ret = gameUtil.mission("HorseRacing1.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (mFairy.dateMinute()>20  &&mFairy.dateMinute()<30){
                    LtLog.e(mFairy.getLineInfo("跑马超时结束"));
                    setTaskEnd();return;
                }
                if (mFairy.dateMinute()>50){
                    LtLog.e(mFairy.getLineInfo("跑马超时结束"));
                    setTaskEnd();return;
                }


                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 40) {

                    result =mFairy.findPic(45,33,187,317,"cfd.png");
                    result1 =mFairy.findPic(1099,2,1280,39,"cfd1.png");
                    if (result.sim>0.8f || result1.sim>0.8f) {
                        mFairy.initMatTime();
                    }else{
                        mFairy.initMatTime();
                        setTaskName(1);
                        return;
                    }
                }

                result =mFairy.findPic(18,116,532,607,"TakehorseRace.png");
                mFairy.onTap(0.8f,result,"参加跑马",Sleep);

                result =mFairy.findPic("hcSure.png");
                mFairy.onTap(0.8f,result,"回城确定",Sleep);


                result =mFairy.findPic(533,301,775,406,"csqr.png");
                mFairy.onTap(0.8f,result,771,433,782,444,"传送确认",Sleep);


                result =mFairy.findPic("pmxsyd.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);

                result =mFairy.findPic("Replica.png");
                result1 =mFairy.findPic(1099,2,1280,39,"cfd1.png");
                if (result.sim>0.8f || result1.sim>0.8f) {
                    mFairy.onTap(1200, 76,1201, 77,"打开地图",Sleep);
                }

/*
                result =mFairy.findPic(1120,5,1276,150,"dtzb.png");
                mFairy.onTap(0.8f,result,1200, 76,1201, 77,"蓝点打开地图",Sleep);*/

                result = mFairy.findPic("hcWorld.png");
                if (result.sim>0.8f){
                    err=0;
                }
                result =mFairy.findPic(546,1,742,49,new String[]{"startGame.png","startGame1.png","bsks.png","bsks1.png"});
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("比赛开始"));
                    result =mFairy.findPic("Replica.png");
                    result1 =mFairy.findPic(1099,2,1280,39,"cfd1.png");
                    if (result.sim>0.8f || result1.sim>0.8f) {
                        mFairy.onTap(1200, 76,1201, 77,"打开地图",Sleep);
                    }
                    for (int i = 0; i < 2; i++) {
                        List<Integer> list = new ArrayList<>();
                        list.add(442);
                        list.add(522);

                        list.add(535);
                        list.add(521);

                        list.add(606);
                        list.add(421);

                        list.add(499);//474,313,518,350
                        list.add(333);

                        list.add(526);//501,264, 545, 301
                        list.add(284);

                        list.add(363);
                        list.add(208);//338,188, 382,225

                        list.add(616);//591,191, 635, 228
                        list.add(211);

                        /*list.add(349);//324,128,368,165
                        list.add(148);*/

                        list.add(315);
                        list.add(208);//290,188,334,225           新改动

                        list.add(270);
                        list.add(510);//245,490,289,527

                        list.add(389);
                        list.add(520);

                        while (list.size()!=0){
                            mFairy.tap(list.get(0),list.get(1));
                            LtLog.e("x"+list.get(0)+",y"+list.get(1));
                            for (int j=0;j<100;j++){
                                mFairy.condit();
                                result =mFairy.findPic(list.get(0)-25,list.get(1)-20,list.get(0)+19,list.get(1)+17,new String[]{"weizhi.png","weizhi1.png","weizhi2.png","blue.png"});
                                LtLog.e(mFairy.getLineInfo(0.1f,result,"蓝色坐标相似度")+result.sim);
                                if (result.sim>=0.7f){
                                    list.remove(0);
                                    list.remove(0);
                                    break;
                                }
                            }
                            result =mFairy.findPic("xiulian.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("挂机修炼了移动一下"));
                                mFairy.ranSwipe(173,569,216,570,100, (long) 100,2);
                                return;
                            }
                        }
                    }
                    Thread.sleep(20000);
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "跑马中");

    } //跑马

    public void jiuyou() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (!((h==12 || h==18) && m>15 && m<45)  && !(  s>74700 && s<76500 )) {
                    LtLog.e(mFairy.getLineInfo("九幽结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("jiuyou1.png",2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result =mFairy.findPic("jymatching.png");
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);

                result =mFairy.findPic(1084,0,1277,39,"xmld.png");
                if (result.sim>0.8f) {
                    setTaskName(1);
                    return;
                }

                result1 =mFairy.findPic(456,118,860,213,"taochu.png");
                result =mFairy.findPic(418,300,885,496,"jiuyoufinish.png");
                mFairy.onTap(0.8f,result,619,432,655,442,"九幽无法匹配了",Sleep);
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    LtLog.e(mFairy.getLineInfo("九幽无法匹配了"));
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Intheteam.png");
                mFairy.onTap(0.8f,result,"队伍中确定",Sleep);

                result =mFairy.findPic(6,245,1194,484,"death.png");
                mFairy.onTap(0.8f,result,"复活",Sleep);

                result =mFairy.findPic("gjSafetyZone.png");
                if (picCount(0.65f,result,"九幽安全区")>6){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Replica.png");
                if (result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png", "NoBattle4.png"});
                    if (result.sim < 0.8f){
                        mFairy.onTap(1133, 329, 1141, 337, "开启自动战斗", Sleep);
                    }
                }
            }
        }.taskContent(mFairy, "九幽中");
    }//九幽

    public void wenquan() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("hotSpring.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(60, 0))return;
                result =mFairy.findPic(18,116,532,607,"wqValley.png");
                mFairy.onTap(0.8f,result,"左侧温泉",Sleep);

                result =mFairy.findPic(482,135,620,184,new String[]{"jrwq.png","jrwq1.png"});
                mFairy.onTap(0.7f,result,875,416,942,438,"进入温泉选择",Sleep);
                mFairy.onTap(0.7f,result,899,563,930,577,"进入温泉",Sleep);

                result =mFairy.findPic(392,188,1090,541,new String[]{"ls.png","hs.png"});
                mFairy.onTap(0.7f,result,"颜色进入温泉选择",Sleep);
                mFairy.onTap(0.7f,result,899,563,930,577,"颜色进入温泉",Sleep);

                result =mFairy.findPic(1136,3,1231,33,"xhmap.png");
                mFairy.onTap(0.8f,result,1178,82,1194,97,"打开地图",Sleep);

                result =mFairy.findPic("hcWorld.png");
                mFairy.onTap(0.8f,result,904,166,937,183,"点击地图入口",Sleep);

                result =mFairy.findPic(18,116,532,607,"EnterHotSpring.png");
                mFairy.onTap(0.8f,result,"进入温泉",Sleep);

                result =mFairy.findPic(688,402,879,480,"hcSure.png");
                mFairy.onTap(0.8f,result,764,433,777,438,"回城确定",Sleep);
                mFairy.onTap(0.8f,result,1235,41,1254,52,"关闭地图",Sleep);
                if (result.sim>0.8f){
                    setTaskName(3);return;
                }
            }


            public void content_3() throws Exception {
                result = mFairy.findPic(368,408,911,610, "HoTspringTickets.png");
                if (result.sim>0.8f){
                    List<FindResult> listResult = mFairy.findPic(368,408,911,610, 0.8f,"HoTspringTickets.png");
                    if (listResult.size() != 0) {
                        mFairy.onTap(0.8f, listResult.get(listResult.size()-1), listResult.get(listResult.size()-1).x, listResult.get(listResult.size()-1).y, listResult.get(listResult.size()-1).x + 1, listResult.get(listResult.size()-1).y + 1, "温泉道具", Sleep);
                    }
                }
                result =   mFairy.findPic(368,408,911,610, "HoTspringTickets3.png");
                if (result.sim>0.8f){
                    List<FindResult> listResult = mFairy.findPic(368,408,911,610, 0.8f, "HoTspringTickets3.png");
                    if (listResult.size() != 0) {
                        mFairy.onTap(0.8f, listResult.get(listResult.size()-1), listResult.get(listResult.size()-1).x, listResult.get(listResult.size()-1).y, listResult.get(listResult.size()-1).x + 1, listResult.get(listResult.size()-1).y + 1, "温泉道具", Sleep);
                    }
                }



                result =mFairy.findPic(25,157,272,292,"wenquanStop.png");
                if (picCountS(0.8f,result,"温泉stop")>20){
                    LtLog.e(mFairy.getLineInfo("温泉结束"));
                    gameUtil.goCity("轩辕");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "温泉中");
    } //温泉

    public void judianzhan() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                if (m>=20){//20
                    LtLog.e(mFairy.getLineInfo("据点战结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png","bahuang.png"});
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("有天外山海图标去天外据点战"));
                        setTaskName(3);
                    }else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标去本服据点战"));
                        setTaskName(3);
                    }
                }
            }
            public void content_2() throws Exception {
                int ret=gameUtil.tymission("tyjdz.png");
                if (ret == 1) {
                    setTaskName(4);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_3() throws Exception {
                int ret=gameUtil.mission("tyjdz.png",3);
                if (ret == 1) {
                    setTaskName(4);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_4() throws Exception {
                result =mFairy.findPic(945,578,1165,671,"jrjdz.png");
                mFairy.onTap(0.8f,result,"进入据点战",Sleep);

                result =mFairy.findPic(684,395,865,471,"jdzqr.png");
                mFairy.onTap(0.8f,result,"进入据点战确定",10000);

                result = mFairy.findPic(757,224,992,419,"zys.png");
                mFairy.onTap(0.7f, result, "采集资源", 5000);

                result =mFairy.findPic(1182,160,1275,250,"Replica.png");
                if (picCountS(0.8f,result,"不在据点战内")>30){
                    LtLog.e(mFairy.getLineInfo("据点战结束"));
                    setTaskEnd();return;
                }
                if (result.sim>0.8f){
                    result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png", "NoBattle4.png"});

                    if (result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("战斗中"));
                       /* mFairy.onTap(0.8f,result,"据点进攻中",Sleep);
                        setTaskName(5);return;
                        result1= mFairy.findPic("nodiren.png");*/
                       result1 = mFairy.findPic(34,174,262,314,"Hangup.png");
                        if (result1.sim>0.8f){
                            mFairy.onTap(0.8f,result,"据点进攻中",Sleep);
                            setTaskName(5);return;
                        }
                    }else {
                        mFairy.onTap(0.8f,result,97,224,113,236,"据点进攻中",Sleep);
                        setTaskName(5);return;
                    }
                }
                result =mFairy.findPic(684,395,865,471,"jdzqr.png");
                mFairy.onTap(0.8f,result,"进入据点战确定",10000);

                result =mFairy.findPic(517,318,770,545,"jdSure.png");
                mFairy.onTap(0.8f,result,"据点战奖励确定",Sleep);
            }
            public void content_5() throws Exception {
                long dazeTime=mFairy.mMatTime(1215,128,61,16,0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间="+dazeTime));
                if (dazeTime>5){
                    mFairy.initMatTime();
                    result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png", "NoBattle4.png"});
                    if (result.sim < 0.8f){
                        mFairy.onTap(1133, 329, 1141, 337, "开启自动战斗", Sleep);
                    }
                    setTaskName(4);return;
                }
            }
        }.taskContent(mFairy, "据点战中");
    }//据点战

    public void hejiu() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {

                super.inOperation();
                int m = mFairy.dateMinute();
                if (m>=59){
                    LtLog.e(mFairy.getLineInfo("喝酒神兽结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(2);
                return;
            }
            public void content_1() throws Exception {
//                int ret = gameUtil.mission("dtfd.png", 2);
//                if (ret == 1) {
//                    setTaskName(2);
//                    return;
//                } else {
//                    setTaskEnd();return;
//                }
            }
            public void content_3() throws Exception{
//                result = mFairy.findPic("xmld.png");
//                if (result.sim>0.7f){
//                    setTaskName(2);
//                }else {
//                    gameUtil.huimeng();
//                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("tuteng2.png");
                mFairy.onTap(0.8f, result, 990,125,1001,132,"关闭", Sleep);

                result =   mFairy.findPic(365,438,956,587, new String[]{"jiu.png", "jiu1.png", "jiu2.png"});
                if (result.sim>0.8f){
                    List<FindResult> listResult = mFairy.findPic(365,438,956,587, 0.8f, "jiu.png");
                    if (listResult.size() != 0) {
                        mFairy.onTap(0.8f, listResult.get(listResult.size()-1), listResult.get(listResult.size()-1).x, listResult.get(listResult.size()-1).y, listResult.get(listResult.size()-1).x + 1, listResult.get(listResult.size()-1).y + 1, "喝酒道具", Sleep);
                        result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png", "NoBattle4.png"});
                        if (result.sim < 0.8f) {
                            mFairy.onTap(1132,331,1141,337, "开启自动战斗", Sleep);


                        }

                    }
                }
                result =mFairy.findPic(427,313,666,384,"xmld2.png");

                if (result.sim > 0.8f) {
                    result =mFairy.findPic(427,404,615,477,"hdld.png");
                    mFairy.onTap(0.8f,result,"回到领地",Sleep);

                }

                result =mFairy.findPic("hjGoAlcohol.png");
                mFairy.onTap(0.8f,result,"继续喝",Sleep);


                result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png", "NoBattle4.png"});
                if (result.sim < 0.8f) {
                    mFairy.onTap(1132,331,1141,337, "开启自动战斗", Sleep);
                }
            }
        }.taskContent(mFairy, "喝酒神兽中");
    }//喝酒神兽

    public void swl() throws Exception {

        new TimingActivity(mFairy) {

            public void inOperation() throws Exception {
                super.inOperation();
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                int s=(h*60+m)*60;
                int sm = s*1000;
                if (h >22 || sm > (begin.timeMillis+1200000)){
                    LtLog.e(mFairy.getLineInfo("山无棱结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret=gameUtil.mission("tyjdz.png",3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
               if (overtime(50, 99))return;
                Thread.sleep(2000);
                result =mFairy.findPic("swljrfb.png");
                mFairy.onTap(0.8f,result,"山无棱进入副本",Sleep);

                result =mFairy.findPic(548,321,739,379,"csm.png");
                mFairy.onTap(0.8f,result,771,434,784,444,"山无棱传送进入副本",Sleep);

                result =mFairy.findPic(1069,173,1220,263,"need.png");
                mFairy.onTap(0.8f,result,"需求",Sleep);

                result =mFairy.findPic("backa.png");
                mFairy.onTap(0.8f,result,"击退",Sleep);

                result =mFairy.findPic(1099,277,1173,348,"NoBattle.png");
                mFairy.onTap(0.8f,result,"开启自动战斗",Sleep);

                result =mFairy.findPic(681,399,874,483,"swlqrcs.png");
                mFairy.onTap(0.8f,result,"山无棱确认传送",Sleep);
                if (result.sim>0.8f){
                    err=-10000;
                }
                result =mFairy.findPic(466,89,816,212,"wfjr.png");
                mFairy.onTap(0.8f,result,"山无棱未开启",Sleep);
                if (result.sim>0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("swlstop.png");
                mFairy.onTap(0.8f,result,"山无棱结束",Sleep);
                if (result.sim>0.8f){
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "山无棱中");
    } //山无棱

    public void jitian() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void inOperation() throws Exception {
                super.inOperation();
                result =mFairy.findPic("death.png");
                mFairy.onTap(0.8f,result,"复活",Sleep);
                if (result.sim>0.8f){
                    setTaskName(4);return;
                }
                int m = mFairy.dateMinute();
                if (m>=20){
                    LtLog.e(mFairy.getLineInfo("祭天结束"));
                    setTaskEnd();return;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png","bahuang.png"});
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("有天外山海图标去天外据点战"));
                        setTaskName(2);
                    }else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标去本服据点战"));
                        setTaskName(3);
                    }
                }
            }
            public void content_2() throws Exception {
                int ret=gameUtil.tymission("jitian.png");
                if (ret == 1) {
                    setTaskName(4);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_3() throws Exception {
                int ret=gameUtil.mission("jitian.png",3);
                if (ret == 1) {
                    setTaskName(4);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_4() throws Exception {
                result =mFairy.findPic("jitianqianwang.png");
                mFairy.onTap(0.8f,result,"立即前往",10000);

                result =mFairy.findPic(1182,160,1275,250,"Replica.png");
                if (picCountS(0.8f,result,"不在祭天内")>30){
                    LtLog.e(mFairy.getLineInfo("祭天结束"));
                    setTaskEnd();return;
                }
                if (result.sim>0.8f){
                    result1 = mFairy.findPic("Hangup1.png");
                    if (result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("战斗中"));
                        result1= mFairy.findPic("nodiren.png");
                        if (result1.sim>0.8f){
                            mFairy.onTap(0.8f,result,146,251,167,262,"祭天副本中",Sleep);
                            setTaskName(5);return;
                        }
                    }else {
                        mFairy.onTap(0.8f,result,146,251,167,262,"祭天副本中",Sleep);
                        setTaskName(5);return;
                    }
                }
            }
            public void content_5() throws Exception {
                long dazeTime=mFairy.mMatTime(1215,128,61,16,0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间="+dazeTime));
                if (dazeTime>5){
                    mFairy.initMatTime();
                    result =mFairy.findPic(1099,277,1173,348,"NoBattle.png");
                    mFairy.onTap(0.8f,result,"开启自动战斗",Sleep);
                    setTaskName(4);return;
                }
            }
        }.taskContent(mFairy, "祭天中");
    }//祭天

    public void bqlt() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                if (m>=30){
                    LtLog.e(mFairy.getLineInfo("版权擂台结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(50, 99))return;
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                if (dazeTime > 5) {

                    result = mFairy.findPic("daily.png");
                    mFairy.onTap(0.8f, result, "日常",1000);

                    result = mFairy.findPic("xshd.png");
                    mFairy.onTap(0.8f, result, "限时活动",1000);

                    result = mFairy.findPic("bqlt.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "版权擂台点击", 500);

                        result = mFairy.findPic("bqltqw.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, 955, 587, 1106, 641, "版权擂台点击", 500);
                            setTaskName(2);
                            return;
                        } else {
                            setTaskEnd();
                            return;
                        }
                    }
                }
                /*int ret=gameUtil.mission("tyjdz.png",3);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }*/
            }
            public void content_2() throws Exception {
                if (overtime(60, 99))return;
                Thread.sleep(2000);

                result = mFairy.findPic(589,556,820,673,"wbm.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();return;
                }
                result =mFairy.findPic("bqlt_jrbs.png");
                mFairy.onTap(0.8f,result,"版权擂台进入比赛",Sleep);

                result =mFairy.findPic("bqlt_sure.png");
                mFairy.onTap(0.8f,result,"版权擂台确认传送",Sleep);
                if (result.sim>0.8f){
                    err=-10000;
                }
                result =mFairy.findPic("bqlt_sure1.png");
                mFairy.onTap(0.8f,result,"版权擂台确认奖励结束",Sleep);
                if (result.sim>0.8f){
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "版权擂台中");
    }//版权擂台


    public void spoil() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s=(h*60+m)*60;
                if (!((s>45000 && s<54000) || (s>64800 && s<84600))){
                    LtLog.e(mFairy.getLineInfo("灵宠夺宝结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret=gameUtil.mission("xsSpoil.png",2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(50, 0))return;
                result =mFairy.findPic("jymatching.png");
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);

                result =mFairy.findPic("jiuyoufinish.png");
                mFairy.onTap(0.8f,result,619,432,655,442,"灵宠无法匹配了",Sleep);
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("灵宠夺宝匹配了"));
                    setTaskEnd();return;
                }

                result=mFairy.findPic("word hint pet fight.png");
                mFairy.onTap(0.8f,result,645,438,654,448,"确定",1000);
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("没有灵宠出战，任务结束"));
                    setTaskEnd();return;
                }

                result =mFairy.findPic("matching.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                    err=0;
                }

                result =mFairy.findPic("Intheteam.png");
                mFairy.onTap(0.8f,result,"队伍中确定",Sleep);


                result =mFairy.findPic("Openbox.png");
                mFairy.onTap(0.8f,result,"开箱",10000);


                result =mFairy.findPic("Replica.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    err=0;
                }

                result =mFairy.findPic(1078,1,1278,158,"Spoilwithin.png");
                result1 =mFairy.findPic(1078,1,1278,158,new String[]{"gjSafetyZone.png","gjSafetyZone1.png"});
                if (result1.sim > 0.65 && result.sim>0.8f) {
                    err=0;
                    mFairy.onTap(1198, 81,1199, 82, "打开地图",2000);
                    mFairy.onTap(423, 351,424, 352,"去中间",2000);
                    gameUtil.close(0);
                }
            }
        }.taskContent(mFairy, "灵宠夺宝中");
    }//灵宠夺宝

    public void xuanhai() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                if (h==23 && m>=30){
                    LtLog.e(mFairy.getLineInfo("玄海结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                int ret=gameUtil.mission("Genkai.png",2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();return;
                }
            }
            int x=0;
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                if (overtime(50, 0))return;
                result =mFairy.findPic("jymatching.png");
                mFairy.onTap(0.8f,result,"个人匹配",Sleep);

                result1 =mFairy.findPic(402,4,637,109,"wof.png");
                result2 =mFairy.findPic(751,43,836,116,"wof.png");
                if (result1.sim>0.8f){
                    x=1;
                }
                if (result2.sim>0.8f){
                    x=2;
                }

                result =mFairy.findPic("matching.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                    err=0;
                }

                result =mFairy.findPic("jybattle.png");
                mFairy.onTap(0.8f,result,"加入战斗",Sleep);

                result =mFairy.findPic("jiuyoufinish.png");
                mFairy.onTap(0.8f,result,619,432,655,442,"玄海无法匹配了",Sleep);
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("玄海不能匹配了"));
                    setTaskEnd();return;
                }

                result =mFairy.findPic(349,253,913,518,"yjzdwz.png");
                if (result.sim >0.8f) {
                    result = mFairy.findPic(657, 392, 913, 503, "Intheteam.png");
                    mFairy.onTap(0.8f, result, "队伍中确定", Sleep);
                }

                result1 = mFairy.findPic(377,272,905,480,"zpms1.png");
                if (result1.sim > 0.75f) {
                    mFairy.onTap(0.75f, result1, 763,430,782,447, "开启战袍确认", Sleep);
                }

                result1 =mFairy.findPic("Replica.png");
                result =mFairy.findPic("gjSafetyZone.png");
                if (result.sim > 0.65 && result1.sim > 0.8f) {
                    result =mFairy.findPic(4,173,243,412,"gong.png");
                    if (result.sim > 0.8f){
                        mFairy.onTap(0.8f, result, result.x,result.y+24,result.x+33,result.y+48,"玄海指引 攻", 6000);
                    }else {
                        if (x == 1) {
                            result = mFairy.findPic(4, 173, 243, 412, new String[]{"zise1.png", "xuanhai.png"});
                            mFairy.onTap(0.8f, result, "玄海指引 紫色", 6000);
                        } else if (x == 2) {
                            result = mFairy.findPic(4, 173, 243, 412, new String[]{"huangse.png", "xuanhai.png"});
                            mFairy.onTap(0.8f, result, "玄海指引 黄色", 6000);
                        } else {
                            mFairy.onTap(121, 293, 122, 294, "玄海指引 中间！", 6000);
                        }
                    }
                }
                result =mFairy.findPic(830,599,1036,658,"xhleave.png");
                result1 =mFairy.findPic("xhfail.png");
                if (result.sim > 0.8f && result1.sim > 0.8f) {
                    mFairy.onTap(0.8f,result,"离开",Sleep);
                } else if (result.sim > 0.8f && result1.sim < 0.8f) {
                    mFairy.onTap(0.8f,result,"离开",Sleep);
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Replica.png");
                if (result.sim>0.8f){
                    result =mFairy.findPic(4,173,243,412,"gong.png");
                    if (result.sim > 0.8f){
                        mFairy.onTap(0.8f, result, result.x,result.y+24,result.x+33,result.y+48,"玄海指引 攻", 10000);
                    }else {
                        if (x == 1) {
                            result = mFairy.findPic(4, 173, 243, 412, new String[]{"zise1.png", "xuanhai.png"});
                            mFairy.onTap(0.8f, result, "玄海指引 紫色", 10000);
                        } else if (x == 2) {
                            result = mFairy.findPic(4, 173, 243, 412, new String[]{"huangse.png", "xuanhai.png"});
                            mFairy.onTap(0.8f, result, "玄海指引 黄色", 10000);
                        } else {
                            result = mFairy.findPic("xuanhai.png");
                            mFairy.onTap(0.8f, result, 13, 184, 237, 404, "玄海指引", 10000);
                        }
                    }
                    err=0;
                    LtLog.e(mFairy.getLineInfo("副本中"));

                }


                result =mFairy.findPic(1116,2,1279,32,"xuanhaidt.png");
                if (result.sim > 0.8f){
                    if (dazeTime > 2) {
                        mFairy.initMatTime();
                        result = mFairy.findPic(389, 458, 876, 526, new String[]{"NoBattle.png", "NoBattle3.png", "NoBattle4.png"});
                        if (result.sim < 0.8f) {
                            mFairy.onTap(1133, 329, 1141, 337, "开启自动战斗", Sleep);
                        }
                    }
                }

            }

        }.taskContent(mFairy, "玄海中");
    }//玄海

    public void bwzq()throws Exception{
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                overtime(30,0);
                int hour = mFairy.dateHour();
                if (hour >= 19){
                    setTaskEnd();return;
                }
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1074,34,1085,49, "日常", Sleep);

                result = mFairy.findPic(518,2,1116,233,"zhaoq.png");
                mFairy.onTap(0.8f, result, "比武招亲", Sleep);

                result = mFairy.findPic(743,575,1162,689,"filljc.png");
                mFairy.onTap(0.8f, result, "免费竞猜", Sleep);
                result = mFairy.findPic(506,111,784,234,"repeat.png");
                if(result.sim > 0.8f){
                    LtLog.e(mFairy.getLineInfo("竞猜过了"));
                    setTaskEnd();return;
                }

                result = mFairy.findPic(725,161,1033,594,"lookgood.png");
                mFairy.onTap(0.8f, result, "看好他", Sleep);

                result = mFairy.findPic(361,253,934,502,"marriage.png");
                mFairy.onTap(0.8f, result, 766,433,773,442,"确定", Sleep);


                //
                result=mFairy.findPic("seeover.png");
                if(result.sim>0.8f) {
                    LtLog.e(mFairy.getLineInfo("任务完成"));
                    setTaskEnd();
                    return;
                }
                result=mFairy.findPic("closehuodong.png");
                mFairy.onTap(0.8f, result,640,426,658,439,"没人报名任务结束", Sleep);
                if(result.sim>0.8f) {
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy,"招亲竞猜");
    }//比武招亲

    public void demo() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                if (m>=59){
                    LtLog.e(mFairy.getLineInfo("喝酒神兽结束"));
                    setTaskEnd();return;
                }
            }
            @Override
            public void content_0() throws Exception {
                gameUtil.huimeng();
                setTaskName(2);
                return;
            }
            public void content_1() throws Exception {
//                int ret = gameUtil.mission("dtfd.png", 2);
//                if (ret == 1) {
//                    setTaskName(2);
//                    return;
//                } else {
//                    setTaskEnd();return;
//                }
            }
            public void content_3() throws Exception{
//                result = mFairy.findPic("xmld.png");
//                if (result.sim>0.7f){
//                    setTaskName(2);
//                }else {
//                    gameUtil.huimeng();
//                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("tuteng2.png");
                mFairy.onTap(0.8f, result, 990,125,1001,132,"关闭", Sleep);

                result =   mFairy.findPic(365,438,956,587, "jiu.png");
                if (result.sim>0.8f){
                    List<FindResult> listResult = mFairy.findPic(365,438,956,587, 0.8f, "jiu.png");
                    if (listResult.size() != 0) {
                        mFairy.onTap(0.8f, listResult.get(listResult.size()-1), listResult.get(listResult.size()-1).x, listResult.get(listResult.size()-1).y, listResult.get(listResult.size()-1).x + 1, listResult.get(listResult.size()-1).y + 1, "喝酒道具", Sleep);
                        result =mFairy.findPic(1099,277,1173,348,"NoBattle.png");
                        mFairy.onTap(0.8f,result,"开启自动战斗",Sleep);
                    }
                }
                result =mFairy.findPic("hjGoAlcohol.png");
                mFairy.onTap(0.8f,result,"继续喝",Sleep);


                result =mFairy.findPic(1099,277,1173,348,"NoBattle.png");
                mFairy.onTap(0.8f,result,"开启自动战斗",Sleep);
            }
        }.taskContent(mFairy, "喝酒神兽中测试");
    }//测试

}
