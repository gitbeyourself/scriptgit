package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitLessTask extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    int picCount=0;
    TimingActivity timingActivity;
    public LimitLessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity=new TimingActivity(mFairy);
    }
    public void limitLess()throws Exception{
        new TimingActivity(mFairy){
            List<String> taskList=new ArrayList();
             boolean answer=false,ylxf=false,qrys=false,whd=false,jczw=false,sjgh=false,sjsl=false,dc=false,jzxy=false;
            long dcInter=0,daze=0;
            String mateType="zhuangbei";
            @Override
            public void create() throws Exception {
                int week=mFairy.week();

                //九州巡游
                if(AtFairyConfig.getOption("5993").equals("1")){
                    jzxy=true;
                }
                //九州巡游
                if(!AtFairyConfig.getOption("mateType").equals("")){
                    mateType=AtFairyConfig.getOption("mateType");
                }
                //七天好礼
                if(AtFairyConfig.getOption("qtdl").equals("1")){
                    taskList.add("qtdl");
                }
                //在线领奖
                if(AtFairyConfig.getOption("zxlj").equals("1")){
                    taskList.add("zxlj");
                }
                //成就领奖
                if(AtFairyConfig.getOption("cjlj").equals("1")){
                    taskList.add("cjlj");
                }

                //每日答题
                if(AtFairyConfig.getOption("answer").equals("1")){
                    answer=true;
                }
                //游龙戏凤
                if(AtFairyConfig.getOption("ylxf").equals("1")){
                    ylxf=true;
                }
                if(AtFairyConfig.getOption("qrys").equals("1")){
                    if(week==2||week==4||week==6||week==7){
                        qrys=true;
                    }
                }
                if(AtFairyConfig.getOption("whd").equals("1")){
                    if(week==1||week==3||week==5){
                        whd=true;
                    }
                }
                if(AtFairyConfig.getOption("jczw").equals("1")){
                    if(week==2){
                        jczw=true;
                    }
                }
                if(AtFairyConfig.getOption("sjgh").equals("1")){
                    if(week==2||week==4||week==6){
                        sjgh=true;
                    }
                }
                if(AtFairyConfig.getOption("sjsl").equals("1")){
                    if(week==6||week==7){
                        sjsl=true;
                    }
                }
                ControlSplit split;
                //当差
                if(!AtFairyConfig.getOption("dcInter").equals("")){
                    split = strSplit(AtFairyConfig.getOption("dcInter"));
                    if(split.choice==1){
                        dc=true;
                        //每日远征间隔
                        dcInter=split.timeMillis;
                    }
                }
                hang();
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                util.initDaze();
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有任务了，执行挂机任务"));
                    setTaskName(2);
                }else{
                    LtLog.e(mFairy.getLineInfo("执行领奖"));
                    setTaskName(1);
                }
            }

            @Override
            public void content_1() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有任务了，执行挂机任务"));
                    setTaskName(0);
                    return;
                }
                //成就领奖
                if(taskList.get(0).equals("cjlj")){
                    timing_cjlj();
                    taskList.remove(0);
                }
                //在线领奖
                if(taskList.get(0).equals("zxlj")){
                    timing_zxlj();
                    taskList.remove(0);
                }
                //七天好礼
                if(taskList.get(0).equals("qthl")){
                    timing_qthl();
                    taskList.remove(0);
                }
            }

            @Override
            public void content_2() throws Exception {
                if(jzxy){
                    //寻找任务并且前往
                    int ret =util.mission("word daily jzxy.png",1);
                    if (ret==1){
                        util.initDaze();
                        setTaskName(3);return;
                    }else {
                       jzxy=false;
                    }
                }
                if(answer==false&&ylxf==false&&qrys==false&&whd==false&&jczw==false&&sjgh==false&&sjsl==false&&dc==false&&jzxy==false){
                    LtLog.e(mFairy.getLineInfo("没有限时活动要执行了，任务结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                hang();
            }
            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn jzxy.png");
                mFairy.onTap(0.8f,result,"九州巡游",1000);

                //九州巡游界面
                result=mFairy.findPic("word jzxy interface.png");
                if(result.sim>0.8f){
                    int colorNum=0;
                    if(mateType.equals("zhuangbei")) colorNum=mFairy.getColorNum(126,115,164,128,0.95f,0,"255,241,207");
                    if(mateType.equals("shizhuang"))colorNum=mFairy.getColorNum(124,254,162,271,0.95f,0,"255,241,207");
                    if(colorNum>500){
                        result=mFairy.findPic("word btn single hang.png");
                        mFairy.onTap(0.8f,result,"单人挂机",10000);
                    }else {
                        if (mateType.equals("zhuangbei"))
                            mFairy.onTap(142, 160, 147, 167, "切换装备分页", 1000);
                        if (mateType.equals("shizhuang"))
                            mFairy.onTap(142, 302, 149, 312, "切换时装分页", 1000);
                    }
                }

//                result=mFairy.findPic("word btn continue hang.png");

                result=mFairy.findPic(new String[]{"word btn lesson.png","word jzxy auto fight.png"});
                picCount=picCount(0.8f,result,"jzxy auto");
                mFairy.onTap(0.8f,result,"出手教训/自动战斗",1000);
                if(picCount>=6){
                    LtLog.e(mFairy.getLineInfo("体力不足，无法继续，挂机结束"));
                    jzxy=false;
                    util.close();
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(594,454,632,533,"word auto fight.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("自动战斗中"));
                    util.initDaze();
                }

                result=mFairy.findPic("word speed up.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word speed three.png");
                    if(result1.sim<0.8f)mFairy.onTap(0.8f,result,"更改倍速",1000);
                }
                hang();
                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }
            public void hang()throws Exception{
                int hour=mFairy.dateHour();
                int min=mFairy.dateMinute();
                //答题
                if(answer){
                    //12:00-13:30
                    if(hour==12||(hour==13&&min>0&&min<30)){
                        timing_answer();
                        answer=false;
                        return;
                    }
                }

                //游龙戏凤
                if(ylxf){
                    //20:00-20:30
                    if(hour==20&&min>0&&min<30){
                        timing_ylxf();
                        ylxf=false;
                        return;
                    }
                }
                //奇人异士
                if(qrys){
                    //12:30-12:50
                    if(hour==12&&min>30&&min<50){
                        timing_qrys();
                        qrys=false;
                        return;
                    }
                }
                //万花典
                if(whd){
                    //12:30-12:45
                    if(hour==12&&min>30&&min<40){
                        timing_whd();
                        whd=false;
                        return;
                    }
                }
                //九重之围
                if(jczw){
                    //20:00-20:30
                    if(hour==20&&min>0&&min<30){
                        timing_jczw();
                        jczw=false;
                        return;
                    }
                }
                //世家篝火
                if(sjgh){
                    //21:00-21:15
                    if(hour==21&&min>0&&min<15){
                        timing_sjgh();
                        sjgh=false;
                        return;
                    }
                }
                //世家试炼
                if(sjsl){
                    //六日全天
                    timing_sjsl();
                    sjsl=false;
                    return;
                }
                //当差
                if(dc){
                    boolean timekeep=timekeep(1,dcInter,"dcInter");
                    if(timekeep){
                        single_dc();
                        timekeepInit("dcInter");
                        return;
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("pic success.png");
                mFairy.onTap(0.8f,result,971,690,982,699,"胜利",1000);

                result=mFairy.findPic("pic failure.png");
                mFairy.onTap(0.8f,result,971,690,982,699,"失败",1000);
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"无限挂机");
    }
    @Override
    public void inOperation() throws Exception {
        //战斗中
        result=mFairy.findPic("word fight auto.png");
        if(result.sim>0.8f){
            util.initDaze();
            LtLog.e(mFairy.getLineInfo("战斗中"));
        }

        //跳过剧情
        result=mFairy.findPic("word btn continue.png");
        mFairy.onTap(0.8f,result,826,398,839,413,"今日不再提醒",1000);
        mFairy.onTap(0.8f,result,634,518,646,529,"确认跳过剧情",1000);

        //跳过对话
        result=mFairy.findPic("word hint dialogue.png");
        mFairy.onTap(0.8f,result,822,428,838,443,"今日不再提醒",1000);
        mFairy.onTap(0.8f,result,634,518,646,529,"确认跳过对话",1000);

        //关闭画面设置
        result=mFairy.findPic("word hint kadun.png");
        mFairy.onTap(0.8f,result,828,433,835,444,"今日不再提醒",1000);
        mFairy.onTap(0.8f,result,877,174,897,193,"关闭设置",1000);

        result=mFairy.findPic("word fight continue.png");
        mFairy.onTap(0.8f,result,"战斗跳过",1000);

        result=mFairy.findPic("word hand.png");
        mFairy.onTap(0.8f,result,"改为自动",1000);

        result=mFairy.findPic("word cancel.png");
        mFairy.onTap(0.8f,result,"取消",1000);
    }
}

