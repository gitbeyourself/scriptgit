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

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    LimitLessTask timingActivity;
    Util util;

    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }
    //招募
    public void single_recruit()throws Exception{
        new TimingActivity(mFairy){
            boolean half=false;
            @Override
            public void create() throws Exception {
                if(AtFairyConfig.getOption("recruit").equals("2")){
                    half=true;
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn recruit.png");
                mFairy.onTap(0.8f,result,"进入招募界面",1000);

                result=mFairy.findPic("word mingjiang interface.png");
                result1=mFairy.findPic(37,81,108,235,"word mingjiang.png");
                //良将界面
                if(result.sim<0.8f){
                    mFairy.onTap(0.8f,result1,"切换名将分页",1000);
                }else{
                    //名将界面
                    if(half){
                        result=mFairy.findPic("word recruit half.png");
                        result1=mFairy.findPic(626,533,666,585,"word recruit free1.png");
                        if(result.sim>0.8f||result1.sim>0.8f){
                            mFairy.onTap(0.8f,result,"半价招募一次",1000);
                            mFairy.onTap(0.8f,result1,"免费招募一次",1000);
                        }else{
                            LtLog.e(mFairy.getLineInfo("半价招募完成"));
                            util.close();
                            setTaskEnd();
                            return;
                        }
                    }else{
                        result=mFairy.findPic(626,533,666,585,"word recruit free1.png");
                        mFairy.onTap(0.8f,result,"免费招募一次",1000);
                    }
                }

                //查看还有没红点
                if (!half&&result1.sim>0.8f){
                    result=mFairy.findPic(result1.x+208,result1.y-18,result1.x+242,result1.y+5,"pic tip red.png");
                    //免费招募完成
                    if(result.sim<0.8f){
                        util.close();
                        LtLog.e(mFairy.getLineInfo("免费招募完成"));
                        setTaskEnd();
                        return;
                    }
                }

                //不在招募界面，点击返回
                result=mFairy.findPic(519,547,586,587,"word btn recruit1.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(new String[]{"word return.png","word return1.png"});
                    mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);
                }

                if(half){
                    overtime(30,0);
                }else{
                    overtime(20,0);
                }
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"招募");
    }

    //试炼 简单(5-10) 普通(20-25) 困难(30-35) 极难(40-45) 噩梦(50)
    public void single_trial()throws Exception{
        new SingleTask(mFairy){
            int trial_hard=1,failCount=0;
            @Override
            public void create() throws Exception {
                //选择难度
                if(!AtFairyConfig.getOption("trial_hard").equals("")){
                    trial_hard=Integer.parseInt(AtFairyConfig.getOption("trial_hard"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn more.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word btn trial.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"进入试炼",1000);
                    }else{
                        mFairy.onTap(0.8f,result,"展开更多",1000);
                    }
                }

                //试炼界面
                result=mFairy.findPic("word trial interface.png");
                if(result.sim>0.8f){
                    //选择试炼难度
                    result=mFairy.findPic("word trial easy.png");
                    if(picCount(0.8f,result,"trial easy")>4){
                        LtLog.e(mFairy.getLineInfo("没有解锁前面等级，无法执行难度"+trial_hard+"的试炼"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,134+(trial_hard-1)*249,549,135+(trial_hard-1)*249,550,"选择难度"+trial_hard,1000);
                        return;
                    }

                    //挑战
                    result=mFairy.findPic("word btn challenge.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"挑战",1000);
                    }else{
                        for(int i=1;i<=7;i++){
                            result=mFairy.findPic(139+178*(i-1),87,171+178*(i-1),123,"word trial success.png");
                            if(result.sim<0.8f){
                                mFairy.onTap(128+178*(i-1),104,129+178*(i-1),105,"选中第"+i+"关",1000);
                                break;
                            }
                            if(i==7&&result.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("试炼完成"));
                                setTaskEnd();
                                return;
                            }
                        }
                    }
                }

                //部队配置
                result=mFairy.findPic("word team setting interface.png");
                if(result.sim>0.8f){
                    for (int i=1;i<=3;i++){
                        result=mFairy.findPic(396+(i-1)*217,239,453+(i-1)*217,297,"pic team setting add.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"配置主将/副将",1000);
                            return;
                        }
                    }
                    result=mFairy.findPic("word btn challenge1.png");
                    mFairy.onTap(0.8f,result,"试炼挑战",1000);
                }
                result=mFairy.findPic(1199,188,1268,405,"word btn shangzhen.png");
                mFairy.onTap(0.8f,result,"上阵",1000);

                result=mFairy.findPic("pic trial victory.png");
                if(result.sim>0.8f){
                    failCount=0;
                    mFairy.onTap(0.8f,result,1109,624,1116,632,"继续挑战",1000);
                }

                result=mFairy.findPic("pic trial failure.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1109,624,1116,632,"继续挑战",1000);
                    if(++failCount>=3){
                        LtLog.e(mFairy.getLineInfo("失败3次，结束任务"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word hint trial.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn hint affirm.png");
                        mFairy.onTap(0.8f,result,"确认",1000);
                        return;
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"试炼");
    }

    //税赋
    public void single_fushui()throws Exception{
        new TimingActivity(mFairy){
            int soctType=1;//征收类型
            @Override
            public void create() throws Exception {
                if (!AtFairyConfig.getOption("soctType").equals("")){
                    soctType=Integer.parseInt(AtFairyConfig.getOption("soctType"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn zhengting.png");
                mFairy.onTap(0.8f,result,"进入政厅",1000);

                result=mFairy.findPic("word zhengting interface.png");
                if(picCount(0.8f,result,"zhengting")>=5){
                    LtLog.e(mFairy.getLineInfo("没有解锁税赋，结束任务"));
                }
                mFairy.onTap(0.8f,result,883,549,897,561,"进入税赋",1000);

                result=mFairy.findPic("word soct free.png");
                mFairy.onTap(0.8f,result,622,547,632,557,"免费征收",1000);

                //免费征收
                if(soctType==1){
                    result=mFairy.findPic("word zheng.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("免费征收完成"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }
                //强征
                if(soctType==2){
                    for(int i=0;i<=2;i++){
                        result=mFairy.findPic(838+170*i,470,877+170*i,545,"word qiangzheng.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"强征"+(i+1),1000);
                            return;
                        }
                    }

                    List list = mFairy.findPic(588, 522, 1187, 582, 0.8f, "word zheng.png");
                    if (list.size()==4){
                        LtLog.e(mFairy.getLineInfo("强征完成"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }
                overtime(15,0);
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"税赋");
    }

    //快速分兵
    //94,613,168,656
    public void single_fenbing()throws Exception{
        new TimingActivity(mFairy){
            @Override
            public void create() throws Exception {
                result=mFairy.findPic("word city build.png");
                if(result.sim>0.8f){
                    setTaskName(1);
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                util.back_city();
                setTaskName(1);
            }
            int teamIndex=1;
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word city build.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(94+255*(teamIndex-1),613,168+255*(teamIndex-1),656,new String[]{"word bianzhi.png","word dengji.png"});
                    if(result.sim>0.8f){
                        teamIndex++;
                        if(teamIndex>=6){
                            LtLog.e(mFairy.getLineInfo("所有部队都分兵完成"));
                            setTaskEnd();
                            return;
                        }
                    }else{
                        mFairy.onTap(94+255*(teamIndex-1),613,168+255*(teamIndex-1),656,"进入部队"+teamIndex,1000);
                    }
                }

                //部队配置界面
                result=mFairy.findPic("word config interface.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,132,670,145,682,"快速分兵",1000);
                    mFairy.onTap(0.8f,result,1113,593,1129,603,"确认分兵",1000);
                    mFairy.onTap(0.8f,result,1199,21,1208,29,"返回",1000);
                    teamIndex++;
                    if(teamIndex>=6){
                        LtLog.e(mFairy.getLineInfo("所有部队都分兵完成"));
                        setTaskEnd();
                        return;
                    }
                }
                overtime(50,0);
            }
        }.taskContent(mFairy,"快速分兵");
    }

    //无限征兵
    public void lissLess_conscription()throws Exception{
        new TimingActivity(mFairy){
            int zbNum=0;
            int task=1;
            @Override
            public void create() throws Exception {
                zbNum=Integer.parseInt(AtFairyConfig.getOption("zbNum1"));
                task=1;
            }
            @Override
            public void content_0() throws Exception {
                util.close();
                util.back_city();
                setTaskName(task);
            }

            @Override
            public void content_1() throws Exception {
                single_fenbing();
                task=2;
                setTaskName(2);
                return;
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word idle.png");
                mFairy.onTap(0.8f,result,"进入征兵界面",1000);

                //输入数量
                result=mFairy.findPic("word btn finish.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,70,106,71,107,"全选1",50);
                    mFairy.onTap(0.8f,result,70,106,71,107,"全选2",50);
                    mFairy.inputText(zbNum+"");
                    mFairy.sleep(1000);
                }

                result=mFairy.findPic(1153,165,1223,212,"word btn finish.png");
                mFairy.onTap(0.8f,result,"完成",1000);

                //在征兵界面
                result=mFairy.findPic("word conscription interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word zbTime.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word btn conscription.png");
                        mFairy.onTap(0.8f,result,"开始征兵",1000);
                        return;
                    }

                    if(zbNum==0){
                        result=mFairy.findPic("word conscription max.png");
                        mFairy.onTap(0.8f,result,"最大",1000);
                    }else{
                        result=mFairy.findPic(544,522,569,556,"pic coord.png");
                        mFairy.onTap(0.8f,result,result.x+20,result.y,result.x+21,result.y+1,"打开输入数量",1000);
                    }
                }


                result=mFairy.findPic(new String[]{"word conscription close.png","word btn zb cancel.png"});
                result1=mFairy.findPic("word draft already full.png");
                if(result.sim>0.8f||result1.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"征兵中"));
                    LtLog.e(mFairy.getLineInfo(0.8f,result1,"兵力已满"));
                    util.close();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(390,286,530,323,"word hint expend.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn hint affirm.png");
                        mFairy.onTap(0.8f,result,"确认",1000);
                        return;
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"无限征兵");
    }

    //每日签到
    public void single_sign()throws Exception{
        new TimingActivity(mFairy){

        }.taskContent(mFairy,"每日签到");
    }

    //扫荡
    public void hang_saodang()throws Exception{
        new TimingActivity(mFairy){
            String coordStr="0,0";
            int teamIndex=0;
            @Override
            public void create() throws Exception {
                String strX="",strY="";
                if(!AtFairyConfig.getOption("sdCoordX").equals("")){
                    strX=AtFairyConfig.getOption("sdCoordX");
                }
                if(!AtFairyConfig.getOption("sdCoordY").equals("")){
                    strY=AtFairyConfig.getOption("sdCoordY");
                }
                coordStr=strX+","+strY;
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                util.coord(coordStr);
                setTaskName(2);
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word btn task.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(873,165,916,283,"word btn attack1.png");
                    result1=mFairy.findPic("word special.png");
                    if(result.sim>0.8f||result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo(0.8f,result,"该土地未被占领，任务结束"));
                        LtLog.e(mFairy.getLineInfo(0.8f,result1,"特殊地形，选址错误，任务结束"));
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic(867,286,919,519,"word btn sao.png");
                    mFairy.onTap(0.8f,result,"扫荡",1000);
                }

                result=mFairy.findPic(869,280,918,580,"word btn sao1.png");
                mFairy.onTap(0.8f,result,"进入确认屯田界面",1000);

                result=mFairy.findPic("word saodang.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(1047,577,1087,614,"pic unselect.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"勾选完成后自动回城",1000);
                        return;
                    }

                    result=mFairy.findPic("word btn sao1.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"扫荡",1000);
                        LtLog.e(mFairy.getLineInfo("确认扫荡完成"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }
                overtime(20,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint xuanshu.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,746,467,758,480,"兵力悬殊，取消扫荡",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }

//                result=mFairy.findPic(540,143,608,231,new String[]{"word hint tired.png","word hint serious.png"});
                result=mFairy.findPic("word cannot.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("重伤或疲惫，切换下个部队"));
                    teamIndex++;
                }

//                result=mFairy.findPic("word cannot.png");
//                if(result.sim>0.8f){
//                    mFairy.onTap(1183,38,1192,46,"部队无法行动，任务结束",1000);
//                    setTaskEnd();
//                    return;
//                }

                //选择部队
                result=mFairy.findPic(new String[]{"word team select.png","word team select1.png"});
                if(result.sim>0.8f){
                    //选中可用待命部队
                    result=mFairy.findPic(1243,197,1272,450,"pic selected.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word none use.png");//没有待命的部队
                        if(result.sim>0.8f){
                            mFairy.onTap(1183,38,1192,46,"没有待命的部队，放弃出征，点击返回",1000);
                            setTaskEnd();
                            return;
                        }
                        result=mFairy.findPic("word remain.png");
                        mFairy.onTap(0.8f,result,"选中停留部队",1000);


                        List<FindResult> list=mFairy.findPic(3,562,1280,593,0.8f,"word await orders.png");
                        if(list.size()!=0){
                            //teamIndex 0 1 2 3
                            //size 5
                            // 1 2 3 4 5      5
                            if((teamIndex+1)<=list.size()){
                                result=list.get(teamIndex);
                            }
                            if((teamIndex+1)>list.size()){
                                LtLog.e(mFairy.getLineInfo("没有可用部队，扫荡结束"));
                                util.close();
                                setTaskEnd();
                                return;
                            }


                            mFairy.onTap(0.8f,result,"选中待命部队",1000);
                        }
                        return;
                    }else{
                        result=mFairy.findPic(1243,197,1272,450,"pic unselect.png");
                        mFairy.onTap(0.8f,result,"只显示待命部队",1000);
                    }
                    return;
                }



                super.inOperation();
            }
        }.taskContent(mFairy,"扫荡");
    }

    //屯田 1木材 2铁块 3石料 4粮食 地块等级
    public void hang_tuntian()throws Exception{
        new TimingActivity(mFairy){
            int step=1,level=1;//分步进行
            String manor_type="";//屯田资源类型
            int exeCount=1;//屯田次数
            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("manor_level").equals("")){
                    level=Integer.parseInt(AtFairyConfig.getOption("manor_level"));
                }

                if(!AtFairyConfig.getOption("manor_type").equals("")){
                    manor_type=AtFairyConfig.getOption("manor_type");
                }

                if(!AtFairyConfig.getOption("exeCount").equals("")){
                    exeCount=Integer.parseInt(AtFairyConfig.getOption("exeCount"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                step=1;
            }

            //选择屯田的地块
            int find=0;
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn task.png");
                mFairy.onTap(0.8f,result,833,8,843,17,"进入领地",1000);

                //领地界面
                result=mFairy.findPic("word manor interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word manor.png");
                    if(result.sim>0.8f){
                        //第一步 清空所有选择
                        if(step==1){
                            //全选后反选
                            result=mFairy.findPic("word select all.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"全选",1000);
                                mFairy.onTap(0.8f,result,"反选",1000);
                                step=2;
                            }

                            //反选
                            result=mFairy.findPic("word select fan.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"反选",1000);
                                step=2;
                            }
                        }

                        //第二步 选择地块等级
                        if(step==2){
                            result=mFairy.findPic(833,172,1083,593,"word manor level "+level+".png");
                            if(result.sim>0.9f){
                                mFairy.onTap(0.9f,result,"选中"+level+"级土地",1000);
                                step=3;
                                find=0;
                            }
                            if(find++>7){
                                LtLog.e(mFairy.getLineInfo("没有找到"+level+"级领地，结束屯田"));
                                util.close();
                                setTaskEnd();
                                return;
                            }
                        }

                        //第三步 选择土地类型
                        if(step==3){
                            result=mFairy.findPic(323,161,383,666,"word manor type "+manor_type+".png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,result.x+283,result.y,result.x+288,result.y+1,"点击坐标",1000);
                            }else{
                            //向上滑动寻找
                                if(find++>2){
                                    LtLog.e(mFairy.getLineInfo("没有找到"+manor_type+"资源，结束屯田"));
                                    util.close();
                                    setTaskEnd();
                                    return;
                                }
                                LtLog.e(mFairy.getLineInfo("没有找到"+manor_type+"向上滑动"));
                                mFairy.ranSwipe(430,611,464,275,500,1500l,0);

                            }

                            //土地跳转
                            result=mFairy.findPic(513,328,596,374,"word hint skip.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,519,468,531,478,"确认跳转到该土地",1000);
                                step=4;
                                setTaskName(2);
                            }
                        }

                        overtime(25,0);
                    }else{
                        result=mFairy.findPic("word manor1.png");
                        mFairy.onTap(0.8f,result,"切换领地分页",1000);
                    }
                }
            }

            //设置屯田次数 回城 执行
            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic(869,280,918,580,"word btn tun.png");
                mFairy.onTap(0.8f,result,"进入确认屯田界面",1000);

                result=mFairy.findPic("word tuntian.png");
                if(result.sim>0.8f){
                    //屯田确认 选择次数 完成自动回城
                    result=mFairy.findPic(1047,577,1087,614,"pic unselect.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"勾选完成后自动回城",1000);
                        return;
                    }

                    result=mFairy.findPic("pic manor up.png");
                    mFairy.onTap(0.8f,result,736,357+(exeCount-1)*28,737,358+(exeCount-1)*28,"选择"+exeCount+"次",1000);

                    result=mFairy.findPic("word manor exeCount "+exeCount+".png");
                    if(result.sim<0.8f){
                        mFairy.onTap(746,330,753,336,"展开",1000);
                        return;
                    }

                    result=mFairy.findPic("word btn tun1.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"屯田",1000);
                        LtLog.e(mFairy.getLineInfo("确认屯田完成"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    //不点击
                    result=mFairy.findPic(513,328,596,374,"word hint skip.png");
                    if(result.sim>0.8f)return;

                    //点击 确认 等级较低
                    result=mFairy.findPic(new String[]{"word hint lower.png"});
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn hint affirm.png");
                        mFairy.onTap(0.8f,result,"确认",1000);
                        return;
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"屯田");
    }

    //征兵
    public void hang_conscription()throws Exception{
        new TimingActivity(mFairy){
            int zbNum=0;
            @Override
            public void create() throws Exception {
                zbNum=strSplit(AtFairyConfig.getOption("zbNum")).count;
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                util.back_city();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word idle.png");
                mFairy.onTap(0.8f,result,"进入征兵界面",1000);

                //输入数量
                result=mFairy.findPic("word btn finish.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,70,106,71,107,"全选1",50);
                    mFairy.onTap(0.8f,result,70,106,71,107,"全选2",50);
                    mFairy.inputText(zbNum+"");
                    mFairy.sleep(1000);
                }

                result=mFairy.findPic(1153,165,1223,212,"word btn finish.png");
                mFairy.onTap(0.8f,result,"完成",1000);

                //在征兵界面
                result=mFairy.findPic("word conscription interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word zbTime.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word btn conscription.png");
                        mFairy.onTap(0.8f,result,"开始征兵",1000);
                        return;
                    }

                    if(zbNum==0){
                        result=mFairy.findPic("word conscription max.png");
                        mFairy.onTap(0.8f,result,"最大",1000);
                    }else{
                        result=mFairy.findPic(544,522,569,556,"pic coord.png");
                        mFairy.onTap(0.8f,result,result.x+20,result.y,result.x+21,result.y+1,"打开输入数量",1000);
                    }
                }


                result=mFairy.findPic(new String[]{"word conscription close.png","word btn zb cancel.png"});
                result1=mFairy.findPic("word draft already full.png");
                if(result.sim>0.8f||result1.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"征兵中"));
                    LtLog.e(mFairy.getLineInfo(0.8f,result1,"兵力已满"));
                    util.close();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(390,286,530,323,"word hint expend.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn hint affirm.png");
                        mFairy.onTap(0.8f,result,"确认",1000);
                        return;
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"征兵");
    }

    //城建
    public void hang_chengjian()throws Exception{
        new TimingActivity(mFairy){
            int buildType=1;//城建的类型(君王殿 内政 军事 守备)
            //内政（1仓库 2农场 采石处 3伐木场 冶铁台 4居民 5集市 6铁匠铺 7演武场 8寻访台 9驯马场 10圆丘坛）
            //军事（1军舍 2兵战-武 兵战-谋 3征兵处 兵战-防 兵战-速 4点将台 5协力-魏 协力-蜀 协力-吴 6协力-群 7军营 8帅令坛 9盾兵营 骑兵营 10弓兵营 枪兵营 器械营）
            //守备（4工程营 军机营 5城墙 6烽火台 7城防军 8工事营 校尉府 9九宫图 八卦阵 10士气坛）

            List<String> buildList=new ArrayList<String>();
            int overTime=0;
            boolean linshi=false;
            @Override
            public void create() throws Exception {
                //君王殿
                if(AtFairyConfig.getOption("linshi").equals("1")){
                    linshi=true;
                }

                //君王殿
                if(AtFairyConfig.getOption("build-0-jwd").equals("1")){
                    buildList.add("0-jwd-0");
                }

                //内政
                //1 仓库
                if(AtFairyConfig.getOption("build-1-ck").equals("1")){
                    buildList.add("1-ck-1");
                }
                //农场
                if(AtFairyConfig.getOption("build-1-nc").equals("1")){
                    buildList.add("1-nc-2");
                }
                //采石处
                if(AtFairyConfig.getOption("build-1-csc").equals("1")){
                    buildList.add("1-csc-2");
                }
                //3伐木场
                if(AtFairyConfig.getOption("build-1-fmc").equals("1")){
                    buildList.add("1-fmc-3");
                }
                //冶铁台
                if(AtFairyConfig.getOption("build-1-ytt").equals("1")){
                    buildList.add("1-ytt-3");
                }
                //4居民
                if(AtFairyConfig.getOption("build-1-jm").equals("1")){
                    buildList.add("1-jm-4");
                }
                //5集市
                if(AtFairyConfig.getOption("build-1-js").equals("1")){
                    buildList.add("1-js-5");
                }
                //6铁匠铺
                if(AtFairyConfig.getOption("build-1-tjp").equals("1")){
                    buildList.add("1-tjp-6");
                }
                //7演武场
                if(AtFairyConfig.getOption("build-1-ywc").equals("1")){
                    buildList.add("1-ywc-7");
                }
                //8寻访台
                if(AtFairyConfig.getOption("build-1-xft").equals("1")){
                    buildList.add("1-xft-8");
                }
                //9驯马场
                if(AtFairyConfig.getOption("build-1-xmc").equals("1")){
                    buildList.add("1-xmc-9");
                }
                //10圆丘坛
                if(AtFairyConfig.getOption("build-1-yqt").equals("1")){
                    buildList.add("1-yqt-10");
                }


                //军事
                //1军舍 2兵战-武 兵战-谋 3征兵处 兵战-防 兵战-速 4点将台 5协力-魏 协力-蜀 协力-吴 6协力-群 7军营 8帅令坛 9盾兵营 骑兵营 10弓兵营 枪兵营 器械营
                if(AtFairyConfig.getOption("build-2-js").equals("1")){
                    buildList.add("2-js-1");
                }
                //2兵战-武
                if(AtFairyConfig.getOption("build-2-bzw").equals("1")){
                    buildList.add("2-bzw-2");
                }
                //2兵战-谋
                if(AtFairyConfig.getOption("build-2-bzm").equals("1")){
                    buildList.add("2-bzm-2");
                }
                //3征兵处
                if(AtFairyConfig.getOption("build-2-zbc").equals("1")){
                    buildList.add("2-zbc-3");
                }
                //3兵战-防
                if(AtFairyConfig.getOption("build-2-bzf").equals("1")){
                    buildList.add("2-bzf-3");
                }
                //3兵战-速
                if(AtFairyConfig.getOption("build-2-bzs").equals("1")){
                    buildList.add("2-bzs-3");
                }
                //4点将台
                if(AtFairyConfig.getOption("build-2-djt").equals("1")){
                    buildList.add("2-djt-4");
                }
                //5协力-魏
                if(AtFairyConfig.getOption("build-2-xlw").equals("1")){
                    buildList.add("2-xlw-5");
                }
                //5协力-蜀
                if(AtFairyConfig.getOption("build-2-xls").equals("1")){
                    buildList.add("2-xls-5");
                }
                //5协力-吴
                if(AtFairyConfig.getOption("build-2-xlw1").equals("1")){
                    buildList.add("2-xlw1-5");
                }
                //6协力-群
                if(AtFairyConfig.getOption("build-2-xlq").equals("1")){
                    buildList.add("2-xlq-6");
                }
                //7军营
                if(AtFairyConfig.getOption("build-2-jy").equals("1")){
                    buildList.add("2-jy-7");
                }
                //8帅令坛
                if(AtFairyConfig.getOption("build-2-slt").equals("1")){
                    buildList.add("2-slt-8");
                }
                //9盾兵营
                if(AtFairyConfig.getOption("build-2-dby").equals("1")){
                    buildList.add("2-dby-9");
                }
                //9骑兵营
                if(AtFairyConfig.getOption("build-2-qby").equals("1")){
                    buildList.add("2-qby-9");
                }
                //10弓兵营
                if(AtFairyConfig.getOption("build-2-gby").equals("1")){
                    buildList.add("2-gby-10");
                }
                //10枪兵营
                if(AtFairyConfig.getOption("build-2-qby").equals("1")){
                    buildList.add("2-qby-10");
                }
                //10器械营
                if(AtFairyConfig.getOption("build-2-qxy").equals("1")){
                    buildList.add("2-qxy-10");
                }

                //守备
                //4工程营 军机营 5城墙 6烽火台 7城防军 8工事营 校尉府 9九宫图 八卦阵 10士气坛
                if(AtFairyConfig.getOption("build-3-gcy").equals("1")){
                    buildList.add("3-gcy-4");
                }
                //4军机营
                if(AtFairyConfig.getOption("build-4-jjy").equals("1")){
                    buildList.add("3-jjy-4");
                }
                //5城墙
                if(AtFairyConfig.getOption("build-3-cq").equals("1")){
                    buildList.add("3-cq-5");
                }
                //6烽火台
                if(AtFairyConfig.getOption("build-3-fht").equals("1")){
                    buildList.add("3-fht-6");
                }
                //7城防军
                if(AtFairyConfig.getOption("build-3-cfj").equals("1")){
                    buildList.add("3-cfj-7");
                }
                //8工事营
                if(AtFairyConfig.getOption("build-3-gsy").equals("1")){
                    buildList.add("3-gsy-4");
                }
                //8校尉府
                if(AtFairyConfig.getOption("build-3-xwf").equals("1")){
                    buildList.add("3-xwf-8");
                }
                //9九宫图
                if(AtFairyConfig.getOption("build-3-jgt").equals("1")){
                    buildList.add("3-jgt-9");
                }
                //9八卦阵
                if(AtFairyConfig.getOption("build-3-bgz").equals("1")){
                    buildList.add("3-bgz-9");
                }
                //10士气坛
                if(AtFairyConfig.getOption("build-3-sqt").equals("1")){
                    buildList.add("3-sqt-10");
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
//                test();
                util.back_city();
                setTaskName(1);
                overTime=0;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word city build.png");
                mFairy.onTap(0.8f,result,"进入城建",1000);

                if(buildList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有建筑升级完成"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                String strBuild=buildList.get(0);
                String buildArr []=strBuild.split("-");
                int buildType=Integer.parseInt(buildArr[0]);//城建类型
                String build=buildArr[1];//城建名称
                int buildLevel=Integer.parseInt(buildArr[2]);//城建等级

                //城建界面
                result=mFairy.findPic("word city build interface.png");
                if(result.sim>0.8f){
                    int buildPic=0;
                    //不是君王殿
                    if(buildType!=0){
                        //寻找城建的类型
                        result=mFairy.findPic("pic buildType"+buildType+".png");
                        if(result.sim>0.9f){
                            //是否选中城建
                            result=mFairy.findPic("word build "+buildType+"-"+build+" t.png");
                            buildPic=picCount(0.8f,result,"build");
                            if(result.sim>0.8f){
                                result=mFairy.findPic("word btn at once.png");
                                if(result.sim>0.8f){
                                    LtLog.e(mFairy.getLineInfo("已经在升级中"));
                                    buildList.remove(0);
                                    return;
                                }

                                result=mFairy.findPic(new String[]{"word btn upgrade.png","word btn build.png"});
                                mFairy.onTap(0.8f,result,"升级/建造",1000);
                            }else{
                                //查找相应的建筑
                                result=mFairy.findPic(421,97,903,670,"word build "+buildType+"-"+build+".png");
                                if(result.sim>0.8f){
                                    overTime=0;
                                    mFairy.onTap(0.8f,result,"选中"+build,1000);
                                }else{
                                    result=mFairy.findPic("word build top.png");
                                    if(result.sim>0.8f){
                                        initHeight();
                                        return;
                                    }
                                    //没找到，向下滑动 查找次数+1 >10的话 setTaskName(0);
                                    mFairy.ranSwipe(927,600,927,200,1500,1000l,0);
                                }
                            }
                        }else{
                            mFairy.onTap(273,243+100*(buildType-1),285,253+100*(buildType-1),"切换到城建类型"+buildType+"类型",1000);
                        }
                    }else{
                        result=mFairy.findPic("word build 0-jwd t.png");
                        buildPic=picCount(0.8f,result,"build");
                        if(result.sim>0.8f){
                            result=mFairy.findPic(new String[]{"word btn upgrade.png","word btn build.png"});
                            mFairy.onTap(0.8f,result,"升级/建造",1000);
                        }else{
                            result=mFairy.findPic("word build 0-jwd.png");
                            mFairy.onTap(0.8f,result,"选中君王殿",1000);
                        }
                    }
                    if(buildPic>=5){
                        LtLog.e(mFairy.getLineInfo(build+"材料不足，或条件不足"));
                        buildList.remove(0);
                    }
                    if(++overTime>=20){
                        LtLog.e(mFairy.getLineInfo("城建超时，重新任务"));
                        setTaskName(0);
                    }
                }
            }

            public void test() throws Exception{
                while(buildList.size()!=0){
                    String strBuild=buildList.get(0);
                    String buildArr []=strBuild.split("-");
                    int buildType=Integer.parseInt(buildArr[0]);//城建类型
                    String build=buildArr[1];//城建名称
                    int buildLevel=Integer.parseInt(buildArr[2]);//城建等级
                    result=mFairy.findPic("word build "+buildType+"-"+build+" t.png");//是否选中
                    result=mFairy.findPic("word build "+buildType+"-"+build+".png"); //查找相应的建筑
                    buildList.remove(0);
                }
                LtLog.e(mFairy.getLineInfo("测试结束"));
                setTaskEnd();
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(639,325,744,376,"word hint linshi.png");
                if(result.sim>0.8f){
                    if(linshi){
                        mFairy.onTap(0.8f,result,506,463,525,480,"确定增加队列",1000);
                    }else{
                        mFairy.onTap(0.8f,result,748,464,763,479,"取消增加队列，任务结束",1000);
                        util.close();
                        setTaskEnd();
                    }
                    return;
                }

                result=mFairy.findPic(663,132,726,244,"word build duilie.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("没用可用队列，任务结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                super.inOperation();
            }

            public void initHeight()throws Exception{
                overTime=0;
                int i=5;
                while(--i>=0){
                    LtLog.e(mFairy.getLineInfo("初始化滑动"+i));
                    //向上滑动
                    mFairy.ranSwipe(927,200,927,600,1500,1000l,0);
                    result=mFairy.findPic(new String[]{"word build bottom.png","word build bottom1.png"});
                    if(result.sim>0.8f)break;
                }
                LtLog.e(mFairy.getLineInfo("初始化完成"));
            }
        }.taskContent(mFairy,"城建");
    }

    //寻访
    public void hang_xunfang()throws Exception{
        new TimingActivity(mFairy){
            int lookCount=-1;
            @Override
            public void create() throws Exception {
                lookCount=strSplit(AtFairyConfig.getOption("lookCount")).count;
            }
            @Override
            public void content_0() throws Exception {
                util.close();
                util.back_city();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn look for.png");
                mFairy.onTap(0.8f,result,"进入寻访",1000);

                int picCount=picCount(0.8f,result,"look for");
                if(picCount>=5){
                    LtLog.e(mFairy.getLineInfo("没有建造寻访台，任务结束"));
                    setTaskEnd();
                }

                result=mFairy.findPic("pic look get.png");
                mFairy.onTap(0.8f,result,"寻访获得",1000);

                //寻访界面
                result=mFairy.findPic("word look for interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(612,157,724,240,"word hint unable execute.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("铜币不足，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word look zero.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("达到最大次数，寻访结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    //寻访一次
                    result=mFairy.findPic("word btn look for1.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"寻访一次，还剩"+lookCount+"次",1000);
                        if(--lookCount==0){
                            setTaskEnd();
                            LtLog.e(mFairy.getLineInfo("寻访完成"));
                        }
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"寻访");
    }

    //练兵
    public void hang_lianbin()throws Exception{
        new TimingActivity(mFairy){
            int trainNum=1;
            int trainCount=1;
            @Override
            public void create() throws Exception {
                //练兵人数
                if(!AtFairyConfig.getOption("trainNum").equals("")){
                    trainNum=Integer.parseInt(AtFairyConfig.getOption("trainNum"));
                }
                //练几次
                if(!AtFairyConfig.getOption("trainCount").equals("")){
                    trainCount=Integer.parseInt(AtFairyConfig.getOption("trainCount"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                util.back_city();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn lianbing.png");
                mFairy.onTap(0.8f,result,"进入练兵场",1000);

                //练兵界面
                result=mFairy.findPic("word lianbing interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word train stop.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("正在练兵中"));
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    //查看人数
                    List<FindResult> list1=mFairy.findPic(678,112,1211,159,0.8f,"word btn xiazhen.png");
                    LtLog.e(mFairy.getLineInfo("当前人数="+list1.size()+"，目标人数="+trainNum));
                    //人数相等
                    if(list1.size()==trainNum){
                        //当前次数
                        int currentCount=0;
                        for(int i=1;i<=5;i++){
                            result=mFairy.findPic("word lianbing "+i+".png");
                            if(result.sim>0.9f){
                                currentCount=i;
                                break;
                            }
                        }
                        LtLog.e(mFairy.getLineInfo("当前次数="+currentCount+"，目标次数="+trainCount));
                        //次数相等
                        if(currentCount==trainCount){
                            result=mFairy.findPic("word btn start train.png");
                            int picCount=picCount(0.8f,result,"train");
                            if(picCount>2){
                                LtLog.e(mFairy.getLineInfo("铜币不足，无法继续，任务结束"));
                                util.close();
                                setTaskEnd();
                                return;
                            }
                            mFairy.onTap(0.8f,result,"开始练兵",1000);
                        }else if(currentCount<trainCount){
                            result=mFairy.findPic("pic train add.png");
                            mFairy.onTap(0.8f,result,"加一次",1000);
                        }else if(currentCount>trainCount){
                            result=mFairy.findPic("pic train subtract.png");
                            mFairy.onTap(0.8f,result,"减一次",1000);
                        }

                    }else if(list1.size()>trainNum){
                        //人数多余
                        result=result=list1.get(0);
                        mFairy.onTap(0.8f,result,"下阵",1000);
                        return;

                    }else if(list1.size()<trainNum){
                        //人数不足
                        List<FindResult> list=mFairy.findPic(567,222,1171,334,0.8f,"pic lianbing add.png");
                        if(list.size()!=0){
                            result=list.get(0);
                            mFairy.onTap(0.8f,result,"进入筛选界面",1000);
                        }
                        return;
                    }
                }

                //筛选上阵界面
                result=mFairy.findPic("word shaixuan.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(1187,183,1274,622,"word btn shangzhen.png");
                    mFairy.onTap(0.8f,result,"上阵",1000);
                }
                overtime(30,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint train stop.png");
                mFairy.onTap(0.8f,result,511,469,525,481,"确认继续练兵",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"练兵");
    }

    //驯马
    public void hang_xunma()throws Exception{
        new TimingActivity(mFairy){
            int level=1;
            int tapCount=0;
            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("xmLevel").equals("")){
                    level=Integer.parseInt(AtFairyConfig.getOption("xmLevel"));
                }
            }

            @Override
            public void content_0() throws Exception {
                tapCount=0;
                util.close();
                util.back_city();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn xunma.png");
                mFairy.onTap(0.8f,result,"进入驯马",1000);

                int picCount=picCount(0.8f,result,"xunma");
                if(picCount>=5){
                    LtLog.e(mFairy.getLineInfo("没有建造驯马场，任务结束"));
                    setTaskEnd();
                }
                //驯马界面
                result=mFairy.findPic("word xunma interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word xunma get.png");
                    mFairy.onTap(0.8f,result,"领取驯马奖励",1000);

                    //驯马中
                    result=mFairy.findPic(new String[]{"word xunma ing.png","word xunma stop.png"});
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("驯马中，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    result =mFairy.findPic("pic xunma level"+level+".png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word xunma start.png");
                        mFairy.onTap(0.8f,result,"开始驯马",1000);
                        if(++tapCount>6){
                            LtLog.e(mFairy.getLineInfo("驯马场没有升级/或者资源不足，结束任务"));
                            util.close();
                            setTaskEnd();
                            return;
                        }
                    }else{
                        mFairy.onTap(116,111+72*(level-1),131,125+72*(level-1),"选中"+level+"级驯马",1000);
                    }
                }
                overtime(30,0);
            }
        }.taskContent(mFairy,"驯马");
    }

    //木流流马
    public void hang_liuma()throws Exception{
        new TimingActivity(mFairy){
            @Override
            public void create() throws Exception {
                super.create();
            }

            @Override
            public void content_0() throws Exception {
                util.back_city();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);

                //主界面
                result=mFairy.findPic("word btn task.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word event.png");
                    mFairy.onTap(0.8f,result,"查看事件",1000);

                    //选择木流流马经过地
                    mFairy.onTap(0.8f,result,926,515,938,525,"选择木流流马经过地",1000);
                }
            }
        }.taskContent(mFairy,"木流流马");
    }

    @Override
    public void inOperation() throws Exception {
        result=mFairy.findPic(599,440,677,519,"word btn hint affirm.png");
        mFairy.onTap(0.8f,result,"确认",1000);

        result=mFairy.findPic("word title jinzhu none.png");
        if(result.sim>0.8f){
            LtLog.e(mFairy.getLineInfo("金珠不足，无法继续任务，任务结束"));
            setTaskEnd();
            return;
        }

        //选择部队
        result=mFairy.findPic(new String[]{"word team select.png","word team select1.png"});
        if(result.sim>0.8f){
            //选中可用待命部队
            result=mFairy.findPic(1243,197,1272,450,"pic selected.png");
            if(result.sim>0.8f){
                result=mFairy.findPic("word none use.png");//没有待命的部队
                if(result.sim>0.8f){
                    mFairy.onTap(1183,38,1192,46,"没有待命的部队，放弃出征，点击返回",1000);
                    setTaskEnd();
                    return;
                }
                result=mFairy.findPic("word remain.png");
                mFairy.onTap(0.8f,result,"选中停留部队",1000);


                List<FindResult> list=mFairy.findPic(3,562,1280,593,0.8f,"word await orders.png");
                if(list.size()!=0){
                    mFairy.onTap(0.8f,list.get(0),"选中待命部队",1000);
                }
                return;
            }else{
                result=mFairy.findPic(1243,197,1272,450,"pic unselect.png");
                mFairy.onTap(0.8f,result,"只显示待命部队",1000);
            }
        }

        result=mFairy.findPic("word hint.png");
        if(result.sim>0.8f){
            result=mFairy.findPic(420,286,530,323,"word hint expend.png");
            if(result.sim>0.8f){
                result=mFairy.findPic("word btn hint affirm.png");
                mFairy.onTap(0.8f,result,"确认",1000);
                return;
            }

            result=mFairy.findPic("word btn hint cancel.png");
            mFairy.onTap(0.8f,result,"取消",1000);

            if(result.sim<0.8f){
                mFairy.onTap(751,469,759,478,"取消行动",1000);
            }
        }
    }
}
