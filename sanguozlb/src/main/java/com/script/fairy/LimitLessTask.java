package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitLessTask extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    int picCount=0;
    ArrayList <String> taskList=null;
    TimingActivity timingActivity;
    public LimitLessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity=new TimingActivity(mFairy);
    }
    //无限挂机
    public void hang() throws Exception{
        new LimitLessTask(mFairy){
            boolean build=false,saodang=false,zhengbing=false;
            long buildInter=5*60*1000,sdInter=5*60*1000,zbInter=5*60*1000;
            @Override
            public void create() throws Exception {
                taskList=new ArrayList<String>();

                //试炼
                if(!AtFairyConfig.getOption("trial_hard").equals("")&&!AtFairyConfig.getOption("trial_hard").equals("0")){
                    taskList.add("trial");
                }
                //赋税
                if(!AtFairyConfig.getOption("soctType").equals("")&&!AtFairyConfig.getOption("soctType").equals("0")){
                    taskList.add("fushui");
                }
                //招募
                if(!AtFairyConfig.getOption("recruit").equals("")&&!AtFairyConfig.getOption("recruit").equals("0")){
                    taskList.add("recruit");
                }
                //驯马
                if(!AtFairyConfig.getOption("xmLevel").equals("")&&!AtFairyConfig.getOption("xmLevel").equals("0")){
                    taskList.add("xunma");
                }

                //寻访
                if(!AtFairyConfig.getOption("lookCount").equals("")){
                    if(strSplit(AtFairyConfig.getOption("lookCount")).choice==1){
                        taskList.add("xunfang");
                    }
                }


                //快速分兵
                if(AtFairyConfig.getOption("fenbing").equals("1")){
                    taskList.add("fenbing");
                }

                //征兵
                if(!AtFairyConfig.getOption("zbNum").equals("")){
                    if(strSplit(AtFairyConfig.getOption("zbNum")).choice==1){
                        taskList.add("conscription");
                    }
                }

                //屯田
                if(AtFairyConfig.getOption("5701").equals("1")){
                    taskList.add("tuntian");
                }

                //城建
                if(AtFairyConfig.getOption("5699").equals("1")){
                    if(!AtFairyConfig.getOption("buildInter").equals("")){
                        build=true;
                        buildInter=strSplit(AtFairyConfig.getOption("buildInter")).timeMillis;
                    }
                }

                //扫荡
                if(AtFairyConfig.getOption("5717").equals("1")){
                    if(!AtFairyConfig.getOption("sdInter").equals("")){
                        saodang=true;
                        sdInter=strSplit(AtFairyConfig.getOption("sdInter")).timeMillis;
                    }

                }

                //无限征兵
                if(AtFairyConfig.getOption("5755").equals("1")){
                    if(!AtFairyConfig.getOption("zbInter").equals("")&&!AtFairyConfig.getOption("zbNum1").equals("")){
                        zhengbing=true;
                        zbInter=strSplit(AtFairyConfig.getOption("zbInter")).timeMillis;
                    }
                }

                //寻访
                if(AtFairyConfig.getOption("xunfang").equals("1")){
                    taskList.add("xunfang");
                }
                //练兵
                if(AtFairyConfig.getOption("5711").equals("1")){
                    taskList.add("lianbing");
                }

            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if(taskList.size()==0){
                    setTaskName(2);
                    return;
                }

                //试炼
                if(taskList.get(0).equals("trial")){
                    timingActivity.single_trial();
                    taskList.remove(0);
                    return;
                }

                //赋税
                if(taskList.get(0).equals("fushui")){
                    timingActivity.single_fushui();
                    taskList.remove(0);
                    return;
                }

                //招募
                if(taskList.get(0).equals("recruit")){
                    timingActivity.single_recruit();
                    taskList.remove(0);
                    return;
                }

                //驯马
                if(taskList.get(0).equals("xunma")){
                    timingActivity.hang_xunma();
                    taskList.remove(0);
                    return;
                }

                //扫荡
                if(taskList.get(0).equals("saodang")){
                    timingActivity.hang_saodang();
                    taskList.remove(0);
                    return;
                }

                //屯田
                if(taskList.get(0).equals("tuntian")){
                    timingActivity.hang_tuntian();
                    taskList.remove(0);
                    return;
                }

                //分兵
                if(taskList.get(0).equals("fenbing")){
                    timingActivity.single_fenbing();
                    taskList.remove(0);
                    return;
                }

                //征兵
                if(taskList.get(0).equals("conscription")){
                    timingActivity.hang_conscription();
                    taskList.remove(0);
                    return;
                }

                //城建
                if(taskList.get(0).equals("chengjian")){
                    timingActivity.hang_chengjian();
                    taskList.remove(0);
                    return;
                }

                //寻访
                if(taskList.get(0).equals("xunfang")){
                    timingActivity.hang_xunfang();
                    taskList.remove(0);
                    return;
                }

                //练兵
                if(taskList.get(0).equals("lianbing")){
                    timingActivity.hang_lianbin();
                    taskList.remove(0);
                    return;
                }

                //驯马
                if(taskList.get(0).equals("xunma")){
                    timingActivity.hang_xunma();
                    taskList.remove(0);
                    return;
                }

                //扫荡
                if(taskList.get(0).equals("saodang")){
                    timingActivity.hang_saodang();
                    taskList.remove(0);
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                if(!build&&!saodang&&!zhengbing){
                    setTaskEnd();
                    LtLog.e(mFairy.getLineInfo("没有无限执行的任务，任务结束"));
                    return;
                }

                if(build){
                    boolean timekeep=timekeep(1,buildInter,"build");
                    if(timekeep){
                        timingActivity.hang_chengjian();
                        timekeepInit("build");
                    }
                }

                if(saodang){
                    boolean timekeep=timekeep(1,sdInter,"saodang");
                    if(timekeep){
                        timingActivity.hang_saodang();
                        timekeepInit("saodang");
                    }
                }

                if(zhengbing){
                    boolean timekeep=timekeep(1,zbInter,"zhengbing");
                    if(timekeep){
                        timingActivity.lissLess_conscription();
                        timekeepInit("zhengbing");
                    }
                }
            }

        }.taskContent(mFairy,"无限挂机");
    }
}
