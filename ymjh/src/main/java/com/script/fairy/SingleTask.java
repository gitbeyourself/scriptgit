package com.script.fairy;

import com.script.content.ScProxy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }
    public void setTaskName(int taskContentNum) throws Exception {
        super.setTaskName(taskContentNum);
        mFairy.condit();
    }
    //新手指引 序章和初章 1至10级
    public void novice ()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int blood=0,dazeFight=0;

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                util.initDaze();
                mFairy.initMatTime();
                return;
            }

            @Override
            public void content_1() throws Exception {
                ScProxy.config().Level().capturing(10);
                result=mFairy.findPic(new String[]{"pic btn fight.png","pic btn guide hand.png"});
                mFairy.onTap(0.8f,result,"战斗-互动指引",500);

                result=mFairy.findPic(1002,405,1042,458,"pic btn fight.png");
                mFairy.onTap(0.8f,result,"战斗-互动指引",500);

                result=mFairy.findPic(1005,481,1041,528,"pic btn fight.png");
                mFairy.onTap(0.8f,result,"战斗-互动指引",500);

                result=mFairy.findPic(480,130,520,153,"pic btn guide hand.png");
                mFairy.onTap(0.8f,result,"战斗-互动指引",500);

                if(daze>5){
                    dazeFight++;
                    if(dazeFight>=4){
                        result=mFairy.findPic("pic up tip.png");
                        mFairy.onTap(0.8f,result,1135,525,1146,534,"超时自动普攻",250);
                        dazeFight=0;
                    }

                    result=mFairy.findPic("pic up tip.png");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic("pic pick ing.png");
                        if(result1.sim<0.8f){
                            mFairy.onTap(0.8f,result,1070,297,1073,302,"切怪",500);
                        }
                    }

                    result=mFairy.findPic("pic task paging.png");
                    mFairy.onTap(0.8f,result,"进入任务分页",1000);
                }

                //任务界面
                result=mFairy.findPic(new String[]{"word task interface.png","task2.png"});
                if(result.sim>0.7f){
                    result=mFairy.findPic("pic task current.png");
                    mFairy.onTap(0.8f,result,"切换当前任务",1000);

                    result=mFairy.findPic("word btn go.png");
                    mFairy.onTap(0.8f,result,"前往",1000);
                    if(result.sim>0.8f)util.initDaze();
                }

                //指引教学
                result=mFairy.findPic("word new skill.png");
                mFairy.onTap(0.8f,result,1098,244,1104,251,"关闭领悟新技能",1000);

                result=mFairy.findPic(new String[]{"word guide drug.png","word guide use drug.png"});
                mFairy.onTap(0.8f,result,790,566,798,575,"选择气血药品",1000);

                result=mFairy.findPic(656,610,693,644,"word guide drug.png");
                mFairy.onTap(0.8f,result,792,664,798,672,"选择内力药品",1000);

                result=mFairy.findPic("word guide drug add.png");
                mFairy.onTap(0.8f,result,608,463,615,471,"气血药品添加",1000);

                result=mFairy.findPic(428,509,461,549,"word guide drug add.png");
                mFairy.onTap(0.8f,result,609,567,614,572,"内力药品添加",1000);

                result=mFairy.findPic(new String[]{"word guide run.png","word guide fast.png","word guide fast2.png"});
                mFairy.onTap(0.8f,result,1229,294,1234,300,"快跑模式",1000);

                result=mFairy.findPic("word guide gun.png");
                mFairy.onTap(0.8f,result,914,661,919,669,"翻滚",1000);

                result=mFairy.findPic("word guide slow.png");
                mFairy.onTap(0.8f,result,1228,292,1233,296,"慢跑",1000);

                result=mFairy.findPic(1000,394,1134,427,"word guide light.png");
                mFairy.onTap(0.8f,result,1229,414,1233,419,"跳起",1000);

                int blackNum=mFairy.getColorNum(908,364,1142,426,0.95f,0,"13,11,13");
                if(blackNum>1000){
                    int yellowNum=mFairy.getColorNum(908,364,1142,426,0.9f,0,"254,254,254");
                    int whiteNum=mFairy.getColorNum(908,364,1142,426,0.9f,0,"211,187,116");
                    if((yellowNum>200&&whiteNum>200)){
                        mFairy.onTap(1229,414,1233,419,"跳起",1000);
                    }
                }

                result=mFairy.findPic("word guide duan.png");
                mFairy.onTap(0.8f,result,1229,414,1233,419,"跳起",1000);

                result=mFairy.findPic("word guide tiao.png");
                mFairy.onTap(0.8f,result,1227,405,1231,408,"跳起",500);
                mFairy.onTap(0.8f,result,1035,425,1038,428,"释放技能",500);

                result=mFairy.findPic("word btn wear.png");
                mFairy.onTap(0.8f,result,"装备",1000);

                result=mFairy.findPic("word btn read.png");
                mFairy.onTap(0.8f,result,1098,243,1104,252,"关闭阅读",1000);

                //不在寻路
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic("word double hit.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(1140,534,1145,541,"连击",200);
                        util.initDaze();
                        return;
                    }

                    result=mFairy.findPic(52,168,78,378,"pic talk ing.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("对话中"));
                        util.initDaze();
                        return;
                    }

                    result=mFairy.findPic("pic up tip.png");
                    if(result.sim>0.8f){
                        int diffBlood;
                        int currentBlood=mFairy.getColorNum(89,35,272,39,0.95f,0,"178,70,69");
                        result=mFairy.findPic("pic fight obj.png");
                        if(result.sim>0.8f){
                            diffBlood=10;
                        }else{
                            diffBlood=Math.abs(currentBlood-blood);
                        }
                        if(diffBlood>=4){
                            if(blood!=0){
                                mFairy.onTap(1140,534,1145,541,"战斗"+diffBlood,500);
                                mFairy.onTap(1140,534,1145,541,"战斗"+diffBlood,500);
                                util.initDaze();
                            }
                            blood=currentBlood;
                        }
                    }

                    result=mFairy.findPic("word hint shijiao.png");
                    mFairy.onTap(0.8f,result,767,376,770,381,"3D视角",1000);
                    mFairy.onTap(0.8f,result,639,492,643,496,"确定",1000);

                    result=mFairy.findPic(new String[]{"word guide open.png","word guide task back.png"});
                    mFairy.onTap(0.8f,result,51,660,59,667,"展开，收回",1000);

                    result=mFairy.findPic(new String[]{"word guide ranswipe.png","word yao.png","word guide sha.png"});
                    if(result.sim>0.8f) mFairy.ranSwipe(133,585,228,489,1500,500l,0);

                    result=mFairy.findPic(new String[]{"word guide task.png","word guide task1.png"});
                    mFairy.onTap(0.8f,result,98,170,102,173,"点击任务栏寻路",1000);

                    result=mFairy.findPic("pic pick ing.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic(new String[]{"pic hand pick.png","pic eye pick.png","pic ear pick.png","pic bath pick.png","pic fist pick.png","pic mouth pick.png"});
                        mFairy.onTap(0.8f,result,"动作-互动",2500);

                        result=mFairy.findPic(new String[]{"pic drug pick.png","pic gun pick.png"});
                        mFairy.onTap(0.8f,result,"取药材/练习棍法",2500);
                    }else{
                        LtLog.e(mFairy.getLineInfo("采集中"));
                        mFairy.sleep(1000);
                        util.initDaze();
                        return;
                    }

                    //沐浴中
                    result=mFairy.findPic("word bath ing.png");
                    if(result.sim>0.8f){
                        mFairy.ranSwipe(133,585,250,499,1000,500l,0);
                        daze=6;
                        return;
                    }

                    //箭头指引
                    result=mFairy.findPic(670,340,716,390,"pic arrows.png");
                    if(result.sim>0.8f){
                        mFairy.touchDown(0,120,584);
                        mFairy.touchMove(0,200,463,500);
                        mFairy.sleep(1000);
                        mFairy.touchUp(0);
                        return;
                    }

                    //拼图
                    result=mFairy.findPic("word pin interface.png");
                    if(result.sim>0.8f){
                        int currentPic=0;
                        for(int i=1;i<=6;i++){
                            result=mFairy.findPic("pic guide pin"+i+".png");
                            if(result.sim>0.8f){
                                currentPic=i;
                                break;
                            }
                        }

                        if(currentPic!=0){
                            mFairy.touchDown(0,result.x,result.y);
                            switch (currentPic){
                                case 1:
                                    mFairy.touchMove(500,512,1500);
                                    break;
                                case 2:
                                    mFairy.touchMove(279,451,1500);
                                    break;
                                case 3:
                                    mFairy.touchMove(506,378,1500);
                                    break;
                                case 4:
                                    mFairy.touchMove(653,244,1500);
                                    break;
                                case 5:
                                    mFairy.touchMove(728,449,1500);
                                    break;
                                case 6:
                                    mFairy.touchMove(344,237,1500);
                                    break;
                            }
                            mFairy.touchUp(0);
                            util.initDaze();
                        }
                    }

                    //记事簿
                    result=mFairy.findPic("pic guide jsb.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        int currentMove=0;
                        for(int i=1;i<=5;i++){
                            result=mFairy.findPic(403+(i-1)*135,473,460+(i-1)*135,518,"pic guide jsb right.png");
                            if(result.sim<0.8f){
                                currentMove=i;
                                break;
                            }
                        }
                        if(currentMove!=0){
                            result=mFairy.findPic(405,151,1009,193,"word guide jsb"+currentMove+".png");
                            if(result.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("移动"+currentMove+"号纸牌"+result.x+","+result.y));
                                mFairy.touchDown(2,result.x,result.y);
                                mFairy.touchMove(2,430+(currentMove-1)*135,167,1000);
                                mFairy.touchUp(2);
                                LtLog.e(mFairy.getLineInfo("移动"+currentMove+"号纸牌到"+(430+(currentMove-1)*135)+","+167));
                                return;
                            }
                        }
                    }

                    result=mFairy.findPic("word guide discuss.png");
                    mFairy.onTap(0.8f,result,969,391,975,398,"讨论1",1000);

                    result=mFairy.findPic("word serious.png");
                    mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);

                    result=mFairy.findPic("word hint config.png");
                    mFairy.onTap(0.8f,result,906,352,909,357,"选择画质",1000);

                    result=mFairy.findPic("word btn submit.png");
                    mFairy.onTap(0.8f,result,"一键提交",1000);

                    result=mFairy.findPic("pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);

                    result=mFairy.findPic("pic dialogue select1.png");
                    mFairy.onTap(0.7f,result,"对话选择",1000);
                    if(result.sim>0.8f)util.initDaze();

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"对话选择",1000);

                    result=mFairy.findPic("word guide select goal.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("选择目标，10级指引完成"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    dazeFight=0;
                }
            }

            public void content_2() throws Exception{
                if (overtime(30,1))return;
                result=mFairy.findPic(new String[]{"pic btn fight.png","pic btn guide hand.png"});
                mFairy.onTap(0.8f,result,"战斗-互动指引1",100);

                result=mFairy.findPic(1002,405,1042,458,"pic btn fight.png");
                mFairy.onTap(0.8f,result,"战斗-互动指引2",100);

                result=mFairy.findPic(1005,481,1041,528,"pic btn fight.png");
                mFairy.onTap(0.8f,result,"战斗-互动指引3",100);

                result=mFairy.findPic(480,130,520,153,"pic btn guide hand.png");
                mFairy.onTap(0.8f,result,"战斗-互动指引4",100);

            }
            @Override
            public void inOperation() throws Exception {
                long datetime = mFairy.mMatTime(1179,4,89,13,0.9f);
                daze=util.dazeTime();
                if(datetime>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，初始化"));
                    setTaskName(0);
                    return;
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"新手指引");
    }

    //江湖目标 10到41级
    public void guide_goal()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int goalIndex=1;//侠义豪杰、绝世妖姬、天下第一、世外高人、博学雅士
            int blood=0,taskPaging=1;
            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("jhmb").equals("")){
                    goalIndex=Integer.parseInt(AtFairyConfig.getOption("jhmb"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                util.initDaze();
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(52,168,78,378,"pic talk ing.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("对话中"));
                    util.initDaze();
                    return;
                }

                result=mFairy.findPic("pic pick ing.png");
                result1=mFairy.findMultiColor(793,404,819,424,0.95f,"235,242,243","1|1|235,242,243&2|2|235,241,243&3|3|235,242,243&4|4|235,243,243&5|5|235,241,243&6|6|235,242,243&7|7|235,243,244&8|8|235,242,243&9|9|235,242,243");
                if(result1.sim>=0.95f||result.sim>0.85f){
                    LtLog.e(mFairy.getLineInfo("采集中result1"+result1.toString()));
                    LtLog.e(mFairy.getLineInfo("采集中"+result.toString()));
                    mFairy.sleep(1000);
                    util.initDaze();
                    return;
                }else{
                    result=mFairy.findPic(new String[]{"pic hand pick.png","pic eye pick.png","pic ear pick.png","pic bath pick.png","pic fist pick.png","pic mouth pick.png","pic kowtow pick.png","pic eat pick.png"});
                    mFairy.onTap(0.8f,result,"动作-互动",3500);
                }

                if(daze>5){
                    //主任务分页栏
                    result=mFairy.findPic("word task rw paging.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(115,185,162,350,"word task yugang.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("副本，需要组队进入，任务结束"));
                            setTaskEnd();
                            return;
                        }

                        //主线无法继续
                        result=mFairy.findPic(173,179,199,240,"word task new plot.png");
                        if(result.sim>0.8f){
                            int taskNum=mFairy.findPic(47,147,61,379,0.8f,"word task rw sign.png").size();
                            if(taskNum<=1){
                                taskPaging=2;
                                LtLog.e(mFairy.getLineInfo("主线没有可执行任务，切换江湖分页"));
                                return;
                            }else{
                                mFairy.onTap(0.8f,result,141,285,147,292,"执行其他主线任务",1000);
                            }
                        }else{
                            result=mFairy.findPic(270,144,295,171,"word task open.png");
                            if(result.sim>0.85f){
                                mFairy.onTap(158,188,163,193,"执行章节任务 下",1000);
                            }else{
                                mFairy.onTap(68,158,71,162,"执行章节任务 上",1000);
                            }
                        }
                    }

                    //江湖分页栏
                    result=mFairy.findPic("word task jh paging.png");
                    if(result.sim>0.8f){
                        int taskNum=mFairy.findPic(47,147,61,379,0.8f,"word task rw sign2.png").size();
                        if(taskNum==0){
                            taskPaging=3;
                            LtLog.e(mFairy.getLineInfo("江湖分页栏没有可执行任务，切换奇遇分页"));
                        }else {
                            mFairy.onTap(174,190,180,199,"江湖分页指引",1000);
                        }
                    }

                    //奇遇分页栏
                    result=mFairy.findPic("word task qy paging.png");
                    if(result.sim>0.8f){
                        int taskNum=mFairy.findPic(47,147,61,379,0.8f,"word task qy sign.png").size();
                        if(taskNum==0){
                            taskPaging=1;
                            LtLog.e(mFairy.getLineInfo("奇遇分页栏没有可执行任务，切换主任务分页"));
                        }else {
                            result=mFairy.findPic("word task tomorrow.png");
                            if(result.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("今日品茗任务完成，切换主任务分页"));
                                taskPaging=1;
                                return;
                            }
                            mFairy.onTap(174,190,180,199,"奇遇分页指引",1000);
                        }
                    }
                }

                //选择江湖目标
                result=mFairy.findPic("word guide select goal.png");
                mFairy.onTap(0.8f,result,171+(goalIndex)*229,600,180+(goalIndex)*229,610,"选择目标"+goalIndex,1000);
                mFairy.onTap(0.8f,result,171+(goalIndex)*229,600,180+(goalIndex)*229,610,"设为目标"+goalIndex,1000);

                result=mFairy.findPic("word btn wear.png");
                mFairy.onTap(0.8f,result,"装备",1000);

                result=mFairy.findPic("word btn use.png");
                mFairy.onTap(0.8f,result,"使用",1000);

                result=mFairy.findPic("word new skill.png");
                mFairy.onTap(0.8f,result,1098,244,1104,251,"关闭领悟新技能",1000);

                result=mFairy.findPic("word btn submit.png");
                mFairy.onTap(0.8f,result,"一键提交",1000);

                result=mFairy.findPic("word guide open system.png");
                mFairy.onTap(0.8f,result,1225,198,1231,208,"展开系统入口",1000);

                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(new String[]{"word double hit.png","zhan.png"});
                    if(result.sim>0.8f){
                        mFairy.onTap(1140,534,1145,541,"连击",250);
                        mFairy.onTap(1140,534,1145,541,"连击",250);
                        mFairy.onTap(1140,534,1145,541,"连击",250);
                        mFairy.onTap(1140,534,1145,541,"连击",250);
                        mFairy.onTap(1140,534,1145,541,"连击",250);
                        util.initDaze();
                        return;
                    }

                    result=mFairy.findPic("pic up tip.png");
                    if(result.sim>0.8f){
                        //通过血量减少 判断是否被打
                        int diffBlood;
                        int currentBlood=mFairy.getColorNum(89,35,272,39,0.95f,0,"178,70,69");
                        result=mFairy.findPic("pic fight obj.png");
                        if(result.sim>0.8f){
                            diffBlood=10;
                        }else{
                            diffBlood=Math.abs(currentBlood-blood);
                        }
                        //减少血量大于5 开始战斗
                        if(diffBlood>=5){
                            if(blood!=0){
                                mFairy.onTap(1140,534,1145,541,"战斗"+diffBlood,500);
                                mFairy.onTap(1140,534,1145,541,"战斗"+diffBlood,500);
                            }
                            blood=currentBlood;
                        }
                    }

                    result=mFairy.findPic("word task collide.png");
                    if(result.sim>0.8f)collide();

                    result=mFairy.findPic("word btn apply for.png");
                    mFairy.onTap(0.8f,result,"一键申请",1000);

                    result=mFairy.findPic("word faction interface.png");
                    mFairy.onTap(0.8f,result,1217,15,1228,25,"关闭帮派界面",1000);

                    result=mFairy.findPic("word tap.png");
                    mFairy.onTap(0.8f,result,"点击屏幕离开",1000);

                    result=mFairy.findPic("pic btn dialogue.png");
                    if(daze<6)mFairy.onTap(0.8f,result,"对话",1000);

                    result=mFairy.findPic("pic dialogue select1.png");
                    mFairy.onTap(0.8f,result,"对话选择",1000);
                    if(result.sim>0.8f)util.initDaze();

                    result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                    if(result.sim>0.8f){
                        result1=mFairy.findPic(new String[]{"word select fitment.png"});
                        if(result1.sim>0.8f){
                            mFairy.onTap(0.8f,result1,1238,26,1246,35,"不回复",1000);
                            daze=5;
                        }else{
                            mFairy.onTap(0.8f,result,"对话选择",1000);
                        }
                    }

                    result=mFairy.findPic("word guide discuss.png");
                    mFairy.onTap(0.8f,result,969,391,975,398,"讨论1",1000);

                    result=mFairy.findPic("word serious.png");
                    mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);

                    result=mFairy.findPic("pic world map.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(1233,33,1241,43,"关闭世界地图",1000);
                        daze=6;
                        return;
                    }

                    result1=mFairy.findPic("word face shop interface.png");
                    if(result1.sim>0.8f){
                        for(int i=1;i<=4;i++){
                            if(i==1)mFairy.onTap(0.8f,result1,321,234,327,241,"切换第一个脸谱",1000);
                            if(i==2)mFairy.onTap(0.8f,result1,644,237,651,243,"切换第二个脸谱",1000);
                            if(i==3)mFairy.onTap(0.8f,result1,324,340,331,346,"切换第三个脸谱",1000);
                            if(i==4)mFairy.onTap(0.8f,result1,640,343,646,349,"切换第四个脸谱",1000);

                            result=mFairy.findPic("word face shop one.png");
                            mFairy.onTap(0.8f,result,951,580,957,588,"购买",1000);
                            mFairy.onTap(0.8f,result,1112,61,1122,74,"购买完成",1000);
                            if(result.sim>0.8f){daze=6;break;}

                            result=mFairy.findPic("word sell out.png");
                            mFairy.onTap(0.8f,result,1112,61,1122,74,"售罄",500);
                            mFairy.onTap(0.8f,result,1112,61,1122,74,"售罄",1000);
                            if(result.sim>0.8f){daze=6;break;}
                        }
                    }

                    result=mFairy.findPic("word mingge interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic change face paging.png");
                        mFairy.onTap(0.8f,result,"切换脸谱分页",1000);

                        result=mFairy.findPic("word select face wear.png");
                        mFairy.onTap(0.8f,result,712,243,720,253,"选择脸谱试戴",1000);

                        result=mFairy.findPic("word btn face wear.png");
                        mFairy.onTap(0.8f,result,"脸谱装备",1000);

                        result=mFairy.findPic("word btn face discharge.png");
                        mFairy.onTap(0.8f,result,1216,15,1224,27,"关闭命格界面",1000);

                    }

                    //推荐好友界面
                    result=mFairy.findPic("word recommend friend.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(968,215,971,221,"添加好友",500);
                        mFairy.onTap(968,294,972,298,"添加好友",500);
                        mFairy.onTap(966,369,972,378,"添加好友",500);
                        mFairy.onTap(966,446,973,456,"添加好友",500);
                        mFairy.onTap(995,98,1003,108,"关闭界面",1000);
                        taskPaging=3;
                    }

                    //点香阁界面
                    result=mFairy.findPic("word dxg interface.png");
                    if(result.sim>0.8f) {
                        result=mFairy.findPic("word iron.png");
                        mFairy.onTap(0.8f,result,1216,20,1224,28,"关闭",1000);
                        mFairy.onTap(0.8f,result,"查看铁观音信息",1000);

                        result=mFairy.findPic("word guide gift.png");
                        mFairy.onTap(0.8f,result,1046,650,1052,655,"赠送礼物",1000);

                        result=mFairy.findPic("word dxg send interface.png");
                        mFairy.onTap(0.8f,result,994,409,1001,416,"送礼指引",1000);

                        result=mFairy.findPic("word close send.png");
                        mFairy.onTap(0.8f,result,585,666,590,674,"关闭赠礼界面",1000);

                        result=mFairy.findPic("word guide tea.png");
                        mFairy.onTap(0.8f,result,870,648,877,656,"浅欧新茶",1000);

                        result=mFairy.findPic("word dxg meet.png");
                        mFairy.onTap(0.8f,result,1216,20,1225,29,"退出点香阁",1000);
                        mFairy.onTap(0.8f,result,848,503,857,512,"确认退出",1000);
                    }

                    result=mFairy.findPic("word dxg interface.png");
                    mFairy.onTap(0.8f,result,1216,20,1225,29,"退出点香阁",1000);
                    mFairy.onTap(0.8f,result,848,503,857,512,"确认退出",1000);

                    result=mFairy.findPic("word txh ready.png");
                    mFairy.onTap(0.8f,result,"天下会 准备",1000);

                    result=mFairy.findPic("word txh fight.png");
                    mFairy.onTap(0.8f,result,1142,532,1146,535,"天下会 战斗",1000);

                    result=mFairy.findPic("word txh leave.png");
                    mFairy.onTap(0.8f,result,1205,45,1215,55,"天下会 离开",1000);

                    result=mFairy.findPic("word school.png");
                    mFairy.onTap(0.8f,result,344,309,349,315,"门派建设 选择任务",1000);

                    result=mFairy.findPic("word observe.png");
                    mFairy.onTap(0.8f,result,"守护",1000);

                    //开启第二套技能指引
                    result=mFairy.findPic(new String[]{"word guide panel.png","word guide first.png"});
                    if(result.sim>0.8f)mFairy.ranSwipe(1057,663,987,561,1000,1000l,0);

                    result=mFairy.findPic("word guide food.png");
                    mFairy.onTap(0.8f,result,43,34,50,41,"获得食品",1000);

                    result=mFairy.findPic("word role interface.png");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic("word renew setting.png");
                        if(result1.sim>0.8f){
                            mFairy.onTap(0.8f,result1,1107,306,1113,315,"一键添加上",1000);
                            mFairy.onTap(0.8f,result1,1103,590,1109,597,"一键添加下",1000);
                            mFairy.onTap(0.8f,result1,425,364,433,373,"关闭回复界面",1000);
                        }else {
                            mFairy.onTap(0.8f,result,1220,15,1228,24,"关闭角色界面",1000);
                            mFairy.onTap(0.8f,result,1099,392,1105,398,"进入气血",1000);
                        }
                    }

                    result=mFairy.findPic("word zbg interface.png");
                    mFairy.onTap(0.8f,result,836,595,841,600,"珍宝阁 铜币 购买",1000);

                    result=mFairy.findPic("word zhsr interface.png");
                    mFairy.onTap(0.8f,result,929,581,934,589,"杂货商人 铜币 购买",1000);

                    result=mFairy.findPic("word get way.png");
                    mFairy.onTap(0.8f,result,428,250,435,258,"获取途径",1000);

                    result=mFairy.findPic(657,301,709,345,"word hint dont enter.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("副本，需要组队进入，任务结束"));
                        setTaskEnd();
                    }
                }
            }

            //冲撞小虾米
            public void collide()throws Exception{
                int duration=100;
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findMultiColor(328,148,1045,299,0.95f,"255,243,184",
                            "-2|1|255,238,187&0|1|255,241,185&2|1|255,238,187&0|3|255,238,186&-6|-2|255,241,190&7|-2|255,241,190&-2|-8|248,232,181&0|-8|249,232,182&2|-8|254,236,185");
                    if(result.sim>=0.9f){
                        //(633,216)为中心点
                        //左右
                        int moveX=result.x-650;
                        //上下
                        int moveY=result.y-216;
                        String move="";
                        if(Math.abs(moveX)<=30){
                            move+=0;
                        }else{
                            //
                            move+=(moveX>0)?1:2;
                        }
                        if(Math.abs(moveY)<=10){
                            move+=0;
                        }else{
                            move+=(moveY>0)?1:2;
                        }
                        mFairy.touchDown(0,199,591);
                        // 右(1) 下(1)
                        switch (move){
                            case "00":
                                mFairy.touchMove(0,199,511,duration);//上
                                break;
                            case "01":
                                mFairy.touchMove(0,199,675,duration);//下
                                break;
                            case "02":
                                mFairy.touchMove(0,199,511,duration);//上
                                break;
                            case "10":
                                mFairy.touchMove(0,281,591,duration);//右
                                break;
                            case "11":
                                mFairy.touchMove(0,264,644,duration);//右下
                                break;
                            case "12":
                                mFairy.touchMove(0,257,535,duration);//右上
                                break;
                            case "20":
                                mFairy.touchMove(0,118,592,duration);//左
                                break;
                            case "21":
                                mFairy.touchMove(0,132,640,duration);//左下
                                break;
                            case "22":
                                mFairy.touchMove(0,145,532,duration);//左上
                                break;
                        }
                        mFairy.touchUp(0);
                        LtLog.e(mFairy.getLineInfo("向"+move+"移动"));
                        mFairy.onTap(1220,658,1228,668,"重置镜头",1000);
                    }
                }
            }
            @Override
            public void inOperation() throws Exception {
                switch (taskPaging){
                    case 1:
                        result=mFairy.findPic("word task rw.png");
                        mFairy.onTap(0.8f,result,"切换任务分页",1000);
                        break;
                    case 2:
                        result=mFairy.findPic("word task jh.png");
                        mFairy.onTap(0.8f,result,"切换江湖分页",1000);
                        break;
                    case 3:
                        result=mFairy.findPic("word task qy.png");
                        mFairy.onTap(0.8f,result,"切换奇遇分页",1000);
                        break;
                }

                daze=util.dazeTime();
                if(daze>20){
                    setTaskName(0);
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"江湖目标");
    }

    //单人日常
    public void daily()throws Exception{
        new SingleTask(mFairy){
            List<String> taskList=new ArrayList();
            @Override
            public void create() throws Exception {
            //江湖
                //课业
                if(AtFairyConfig.getOption("ky").equals("1")){
                    taskList.add("ky");
                }
                //茶馆说书
                if(AtFairyConfig.getOption("cgss").equals("1")){
                    taskList.add("cgss");
                }
                //江湖缥缈录
                if(AtFairyConfig.getOption("jhpml").equals("1")){
                    taskList.add("jhpml");
                }
                //鼓盆击水
                if(AtFairyConfig.getOption("gpjs").equals("1")){
                    taskList.add("gpjs");
                }

            //帮派

                //帮派任务
                if(AtFairyConfig.getOption("bprw").equals("1")){
                    taskList.add("bprw");
                }
                //势力任务
                if(AtFairyConfig.getOption("slrw").equals("1")){
                    taskList.add("slrw");
                }
                //门客设宴
                if(AtFairyConfig.getOption("mksy").equals("1")){
                    taskList.add("mksy");
                }

            //纷争

                //华山论剑
                if(AtFairyConfig.getOption("hslj").equals("1")){
                    taskList.add("hslj");
                }
                //江湖英雄榜
                if(AtFairyConfig.getOption("jhyxb").equals("1")){
                    taskList.add("jhyxb");
                }

            //行当

                //行侠仗义
                if(AtFairyConfig.getOption("xxzy").equals("1")){
                    taskList.add("xxzy");
                }
                //社交

            //游历

                //每日一卦
                if(AtFairyConfig.getOption("mryg").equals("1")){
                    taskList.add("mryg");
                }

                //每日签到
                if(AtFairyConfig.getOption("sign").equals("1")){
                    taskList.add("sign");
                }
                //江湖馈赠
                if(AtFairyConfig.getOption("jhkz").equals("1")){
                    taskList.add("jhkz");
                }
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务做完，没有任务了"));
                    setTaskEnd();
                    return;
                }
                //课业
                if(taskList.get(0).equals("ky")){
                    jh_ky();
                    taskList.remove(0);
                    return;
                }
                //茶馆说书
                if(taskList.get(0).equals("cgss")){
                    jh_cgss();
                    taskList.remove(0);
                    return;
                }
                //江湖缥缈录
                if(taskList.get(0).equals("jhpml")){
                    jh_jhpml();
                    taskList.remove(0);
                    return;
                }

                //鼓盆击水
                if(taskList.get(0).equals("gpjs")){
                    jh_gpjs();
                    taskList.remove(0);
                    return;
                }
                //帮派任务
                if(taskList.get(0).equals("bprw")){
                    bp_bprw();
                    taskList.remove(0);
                    return;
                }
                //势力任务
                if(taskList.get(0).equals("slrw")){
                    bp_slrw();
                    taskList.remove(0);
                    return;
                }
                //门课设宴
                if(taskList.get(0).equals("mksy")){
                    bp_mksy();
                    taskList.remove(0);
                    return;
                }
                //华山论剑
                if(taskList.get(0).equals("hslj")){
                    fz_hslj();
                    taskList.remove(0);
                    return;
                }
                //江湖英雄榜
                if(taskList.get(0).equals("jhyxb")){
                    fz_jhyxb();
                    taskList.remove(0);
                    return;
                }
                //行侠仗义
                if(taskList.get(0).equals("xxzy")){
                    hd_xxzy();
                    taskList.remove(0);
                    return;
                }
                //每日一卦
                if(taskList.get(0).equals("mryg")){
                    yl_mryg();
                    taskList.remove(0);
                    return;
                }
                //江湖馈赠
                if(taskList.get(0).equals("jhkz")){
                    jhkz();
                    taskList.remove(0);
                    return;
                }
                //每日签到
                if(taskList.get(0).equals("sign")){
                    sign();
                    taskList.remove(0);
                    return;
                }
            }
        }.taskContent(mFairy,"单人日常");
    }

    //生活采集
    public void pick_test()throws Exception{
        new SingleTask(mFairy){
            List<String> pickList=new ArrayList<String >();
            long daze;
            int current=0,currentDetail=0,reset_place=0;
            String pick="",pickType="",pickObj="";//采集的任务，类别，对象
            int picCount;
            //采草 伐木 挖矿 钓鱼 采风
            @Override
            public void create() throws Exception {
                //采草
                if(!AtFairyConfig.getOption("caicao").equals("")){
                    pickList.add("caicao-"+AtFairyConfig.getOption("caicao"));
                }
                //伐木
                if(!AtFairyConfig.getOption("famu").equals("")){
                    pickList.add("famu-"+AtFairyConfig.getOption("famu"));
                }
                //挖矿
                if(!AtFairyConfig.getOption("wakuang").equals("")){
                    pickList.add("wakuang-"+AtFairyConfig.getOption("wakuang"));
                }
                //钓鱼
                if(!AtFairyConfig.getOption("diaoyu").equals("")){
                    pickList.add("diaoyu-"+AtFairyConfig.getOption("diaoyu"));
                }
                //采风
                if(!AtFairyConfig.getOption("caifeng").equals("")){
                    pickList.add("caifeng-"+AtFairyConfig.getOption("caifeng"));
                }
                //种植
                if(!AtFairyConfig.getOption("zhongzhi").equals("")){
                    pickList.add("zhongzhi-"+AtFairyConfig.getOption("zhongzhi"));
                }
                //养殖
                if(!AtFairyConfig.getOption("yangzhi").equals("")){
                    pickList.add("yangzhi-"+AtFairyConfig.getOption("yangzhi"));
                }
            }

            @Override
            public void content_0() throws Exception {
                if(pickList.size()==0){
                    LtLog.e(mFairy.getLineInfo("采集全部完成"));
                    setTaskEnd();
                    return;
                }
                //获取任务
                if(!pick.equals(pickList.get(0))){
                    pick=pickList.get(0);//"caicao-yecao"
                    pickType=pick.split("-")[0];
                    pickObj=pick.split("-")[1];
                    LtLog.e(mFairy.getLineInfo("当前任务"+pick));
                }
                //初始化
                util.close();
                util.initDaze();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                daze=util.initDaze();
                overtime(10,0);
                if(reset_place>=5){
                    LtLog.e(mFairy.getLineInfo("脱离卡死一次"));
                    util.reset_place();
                    reset_place=0;
                    return;
                }

                //初始化
                result=mFairy.findPic("pic open system.png");
                mFairy.onTap(0.8f,result,"展开系统",1000);

                result=mFairy.findPic(new String[]{"word life skill.png","word life skill1.png"});
                mFairy.onTap(0.8f,result,"进入生活技能",1000);

                result=mFairy.findPic("word life skill interface.png");
                picCount = picCount(0.8f, result, "life skill interface");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word "+pickType+" paging.png");
                    if(result.sim>0.8f){
                        setTaskName(3);
                        return;
                    }

                    if(picCount==1)mFairy.ranSwipe(280,216,280,606,1000,1500l,0);//初始化滑动

                    result=mFairy.findPic("pic life skill task back.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"收回",1000);
                        return;
                    }else{
                        setTaskName(2);
                    }
                }
            }

            @Override
            public void content_2() throws Exception {
                daze=util.initDaze();
                overtime(8,0);

                result=mFairy.findPic("word life skill interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic life skill open.png");
                    mFairy.onTap(0.8f,result,"展开采集技能",1000);

                    //具体采集分页
                    result=mFairy.findPic("word "+pickType+" paging.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("找到"+pickType+"采集"));
                        setTaskName(3);
                        return;
                    }else{
                        result=mFairy.findPic("word "+pickType+".png");
                        mFairy.onTap(0.8f,result,"切换"+pickType+"分页",1000);
                        if(err%2==0)
                        if(result.sim<0.8f){
                            result=mFairy.findPic("word life skill bottom.png");
                            if(result.sim>0.8f)mFairy.ranSwipe(280,500,280,200,1000,1500l,0);
                            else mFairy.ranSwipe(280,200,280,500,1000,1500l,0);
                        }
                    }
                }
            }

            @Override
            public void content_3() throws Exception {
                daze=util.initDaze();
                overtime(7,0);
                //具体采集分页
                result=mFairy.findPic("word "+pickType+" paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn study.png");
                    mFairy.onTap(0.8f,result,"学习",1000);

                    result=mFairy.findPic("pic life skill lock.png");
                    if(result.sim>0.8f){
                        pickList.remove(0);
                        LtLog.e(mFairy.getLineInfo("暂未解锁，执行下一项"));
                        setTaskName(0);
                        return;
                    }

                    result=mFairy.findPic("word pick "+pickType+" "+pickObj+"1.png");
                    if(result.sim>0.8f){
                        if(pickType.equals("caifeng"))
                            mFairy.onTap(0.8f,result,result.x+90,result.y+1,result.x+111,result.y+20,pickObj+"前往采集",1000);
                        else
                            mFairy.onTap(0.8f,result,result.x+167,result.y+6,result.x+181,result.y+20,pickObj+"前往采集",1000);
                        setTaskName(4);
                        reset_place++;
                        daze=util.initDaze();
                        return;
                    }

                    //可采集界面
                    result=mFairy.findPic("pic can pick interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word pick "+pickType+" "+pickObj+".png");
                        mFairy.onTap(0.8f,result,"找到"+pickObj,1000);
                        if(result.sim<0.8f)mFairy.ranSwipe(811,526,853,220,1000,1500l,1);
                    }else{
                        result=mFairy.findPic("pic life skill can pick.png");
                        mFairy.onTap(0.8f,result,"查看可采集的",1000);
                    }
                }
            }

            @Override
            public void content_4() throws Exception {
               // long datetime = mFairy.mMatTime(1179,4,89,13,0.9f);
                //世界地图
                result=mFairy.findPic("pic world map.png");
                if(result.sim>0.8f){
                    List<FindResult> guide=null;
                    result.sim=0f;
                    switch (pickType){
                        case "caicao":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world caicao.png");
                            break;
                        case "famu":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world famu.png");
                            break;
                        case "wakuang":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world wakuang.png");
                            break;
                        case "diaoyu":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world diaoyu.png");
                            break;
                        case "caifeng":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world caifeng.png");
                            break;
                    }
                    if(guide!=null&&guide.size()!=0){
                        if(current>guide.size()-1){
                            current=0;
                        }
                        result=guide.get(current);
                    }
                    mFairy.onTap(0.85f,result,"采集 世界 选择门派",1000);
                    current++;
                }

                //区域地图
                result=mFairy.findPic("pic area map.png");
                if(result.sim>0.8f){
                    List<FindResult> guide=null;
                    result.sim=0f;
                    double sim=0.95;
                    switch (pickType){
                        case "caicao":
                            result=mFairy.findMultiColor(148,69,1206,595,sim,"255,255,255",
                                    "2|2|255,255,255&8|8|255,255,255&12|-5|255,255,255&17|-7|255,255,255&13|2|255,255,255&21|2|255,255,255&24|1|255,255,255&27|-2|255,255,255&19|8|255,255,255");
                            break;
                        case "famu":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area famu.png");
                            break;
                        case "wakuang":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area wakuang.png");
                            break;
                        case "diaoyu":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area diaoyu.png");
                            break;
                        case "caifeng":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area caifeng.png");
                            break;
                    }
                    if(guide!=null&&guide.size()!=0){
                        if(currentDetail>guide.size()-1){
                            currentDetail=0;
                        }
                        result=guide.get(currentDetail);
                    }
                    if(result.sim>0.82f){
                        mFairy.onTap(0.8f,result,"采集 区域 选择地点",100);
                        mFairy.onTap(0.8f,result,1234,33,1239,39,"关闭地图",2000);
                        mFairy.onTap(0.8f,result,1234,33,1239,39,"关闭采集界面",2000);
                        daze=util.initDaze();
                        mFairy.initDaze();
                    }
                    currentDetail++;
                }

                //自动寻路
                result=mFairy.findPic("word way.png");
                if(result.sim>0.8){
                    long dazeTime=
                            mFairy.dazeTime(1138,1,1256,18,0.9f,0,"246,246,245");
                    if(dazeTime>20){
                        LtLog.e(mFairy.getLineInfo("自动寻路卡死，脱离卡死一次"));
                        util.reset_place();
                        reset_place=0;
                        return;
                    }
                }

                result=mFairy.findPic("word life skill interface.png");
                mFairy.onTap(0.8f,result,1219,14,1228,26,"关闭采集界面",2000);

                result=mFairy.findPic("word btn buy.png");
                mFairy.onTap(0.8f,result,"购买工具",1000);

                result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic pick add.png");
                    mFairy.onTap(0.8f,result,"添加工具",1000);

                    result=mFairy.findPic("word way.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word diaoyu qigan.png");
                        mFairy.onTap(0.8f,result,932,461,937,468,"起竿",1000);

                        result=mFairy.findMultiColor(919,419,941,439,0.9f,"20,20,17",
                                "1|0|21,20,17&2|0|21,20,17&125|58|231,232,230&14|5|230,229,210&28|35|135,131,114&19|47|222,220,192&7|33|137,134,118&2|31|225,223,201&1|18|22,22,19");

                        result1=mFairy.findMultiColor(961,458,972,467,0.95f,"255,255,255",
                                "-1|-1|255,255,255&-2|-2|255,255,255&-3|-3|255,255,255&-4|-4|255,255,255&-5|-5|255,255,255&-6|-6|255,255,255&-7|-5|254,254,254&-6|-4|252,252,252&-5|-3|255,255,255");
                        if(result.sim<0.85f&&result1.sim<0.85f){
                            result=mFairy.findPic(895,330,973,500,"pic caiji pick.png");
                            mFairy.onTap(0.8f,result,"采集",2500);

                            if(pickType.equals("caicao"))result=mFairy.findPic(895,330,973,500,"pic caicao pick.png");
                            if(pickType.equals("famu")){
                                result=mFairy.findPic("pic tool famu.png");
                                mFairy.onTap(0.8f,result,"选择伐木工具",1000);
                                result=mFairy.findPic(895,330,973,500,"pic lumber pick.png");
                            }
                            if(pickType.equals("wakuang")){
                                result=mFairy.findPic("pic tool wakuang.png");
                                mFairy.onTap(0.8f,result,"选择挖矿工具",1000);
                                result=mFairy.findPic(895,330,973,500,new String[]{"pic caiji pick.png","pic wakuang pick.png"});
                            }
                            if(pickType.equals("diaoyu")){
                                result=mFairy.findPic("pic tool diaoyu.png");
                                mFairy.onTap(0.8f,result,"选择钓鱼工具",1000);
                                result=mFairy.findPic(895,330,973,500,new String[]{"pic fish pick.png","pic fish1 pick.png"});
                            }
                            if(pickType.equals("caifeng"))result=mFairy.findPic(895,330,973,500,"pic caiji pick.png");
                            mFairy.onTap(0.8f,result,"采集1",2500);
                        }else{
                            LtLog.e(mFairy.getLineInfo("采集中result="+result.toString()+",result1="+result1.toString()));
                            mFairy.sleep(1000);
                            daze=util.initDaze();
                            return;
                        }
                    }
                }
                if(daze>8&&daze<12){
                    result=mFairy.findPic("pic up tip.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("向前走一步"));
                        mFairy.ranSwipe(199,591,199,511,200,200l,1);
                    }
                }

                if(daze>18){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word serious.png");
                mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);

                result=mFairy.findPic("word hint buy affirm.png");
                mFairy.onTap(0.8f,result,848,507,854,513,"购买确认",1000);

                result=mFairy.findPic(546,200,601,340,"word dont find way.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"无法自动寻路"));
                    util.reset_place();
                    setTaskName(1);
                    reset_place=0;
                    return;
                }

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"生活采集-测试");
    }

    public void pick()throws Exception{
        new SingleTask(mFairy){
            List<String> pickList=new ArrayList<String >();
            long daze;
            int current=0,currentDetail=0;
            String pick="",pickType="",pickObj="";//采集的任务，类别，对象
            int picCount;
            //采草 伐木 挖矿 钓鱼 采风
            @Override
            public void create() throws Exception {
                //采草
                if(!AtFairyConfig.getOption("caicao").equals("")){
                    pickList.add("caicao-"+AtFairyConfig.getOption("caicao"));
                }
                //伐木
                if(!AtFairyConfig.getOption("famu").equals("")){
                    pickList.add("famu-"+AtFairyConfig.getOption("famu"));
                }
                //挖矿
                if(!AtFairyConfig.getOption("wakuang").equals("")){
                    pickList.add("wakuang-"+AtFairyConfig.getOption("wakuang"));
                }
                //钓鱼
                if(!AtFairyConfig.getOption("diaoyu").equals("")){
                    pickList.add("diaoyu-"+AtFairyConfig.getOption("diaoyu"));
                }
                //采风
                if(!AtFairyConfig.getOption("caifeng").equals("")){
                    pickList.add("caifeng-"+AtFairyConfig.getOption("caifeng"));
                }
                //种植
                if(!AtFairyConfig.getOption("zhongzhi").equals("")){
                    pickList.add("zhongzhi-"+AtFairyConfig.getOption("zhongzhi"));
                }
                //养殖
                if(!AtFairyConfig.getOption("yangzhi").equals("")){
                    pickList.add("yangzhi-"+AtFairyConfig.getOption("yangzhi"));
                }
            }

            @Override
            public void content_0() throws Exception {
                if(pickList.size()==0){
                    LtLog.e(mFairy.getLineInfo("采集全部完成"));
                    setTaskEnd();
                    return;
                }
                //获取任务
                if(!pick.equals(pickList.get(0))){
                    pick=pickList.get(0);//"caicao-yecao"
                    pickType=pick.split("-")[0];
                    pickObj=pick.split("-")[1];
                    LtLog.e(mFairy.getLineInfo("当前任务"+pick));
                }
                //初始化
                util.close();
                util.initDaze();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                daze=util.initDaze();
                overtime(10,0);
                //初始化
                result=mFairy.findPic("pic open system.png");
                mFairy.onTap(0.8f,result,"展开系统",1000);

                result=mFairy.findPic(new String[]{"word life skill.png","word life skill1.png"});
                mFairy.onTap(0.8f,result,"进入生活技能",1000);

                result=mFairy.findPic("word life skill interface.png");
                picCount = picCount(0.8f, result, "life skill interface");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word "+pickType+" paging.png");
                    if(result.sim>0.8f){
                        setTaskName(3);
                        return;
                    }

                    if(picCount==1)mFairy.ranSwipe(280,216,280,606,1000,1500l,0);//初始化滑动

                    result=mFairy.findPic("pic life skill task back.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"收回",1000);
                        return;
                    }else{
                        setTaskName(2);
                    }
                }
            }

            @Override
            public void content_2() throws Exception {
                daze=util.initDaze();
                overtime(8,0);

                result=mFairy.findPic("word life skill interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic life skill open.png");
                    mFairy.onTap(0.8f,result,"展开采集技能",1000);

                    //具体采集分页
                    result=mFairy.findPic("word "+pickType+" paging.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("找到"+pickType+"采集"));
                        setTaskName(3);
                        return;
                    }else{
                        result=mFairy.findPic("word "+pickType+".png");
                        mFairy.onTap(0.8f,result,"切换"+pickType+"分页",1000);
                        if(err%2==0)
                            if(result.sim<0.8f){
                                result=mFairy.findPic("word life skill bottom.png");
                                if(result.sim>0.8f)mFairy.ranSwipe(280,500,280,200,1000,1500l,0);
                                else mFairy.ranSwipe(280,200,280,500,1000,1500l,0);
                            }
                    }
                }
            }

            @Override
            public void content_3() throws Exception {
                daze=util.initDaze();
                overtime(7,0);
                //具体采集分页
                result=mFairy.findPic("word "+pickType+" paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn study.png");
                    mFairy.onTap(0.8f,result,"学习",1000);

                    result=mFairy.findPic("pic life skill lock.png");
                    if(result.sim>0.8f){
                        pickList.remove(0);
                        LtLog.e(mFairy.getLineInfo("暂未解锁，执行下一项"));
                        setTaskName(0);
                        return;
                    }

                    result=mFairy.findPic("word pick "+pickType+" "+pickObj+"1.png");
                    if(result.sim>0.8f){
                        if(pickType.equals("caifeng"))
                            mFairy.onTap(0.8f,result,result.x+90,result.y+1,result.x+111,result.y+20,pickObj+"前往采集",1000);
                        else
                            mFairy.onTap(0.8f,result,result.x+167,result.y+6,result.x+181,result.y+20,pickObj+"前往采集",1000);
                        setTaskName(4);
                        daze=util.initDaze();
                        return;
                    }

                    //可采集界面
                    result=mFairy.findPic("pic can pick interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word pick "+pickType+" "+pickObj+".png");
                        mFairy.onTap(0.8f,result,"找到"+pickObj,1000);
                        if(result.sim<0.8f)mFairy.ranSwipe(811,526,853,220,1000,1500l,1);
                    }else{
                        result=mFairy.findPic("pic life skill can pick.png");
                        mFairy.onTap(0.8f,result,"查看可采集的",1000);
                    }
                }
            }

            @Override
            public void content_4() throws Exception {
                //世界地图
                result=mFairy.findPic("pic world map.png");
                if(result.sim>0.8f){
                    List<FindResult> guide=null;
                    result.sim=0f;
                    switch (pickType){
                        case "caicao":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world caicao.png");
                            break;
                        case "famu":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world famu.png");
                            break;
                        case "wakuang":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world wakuang.png");
                            break;
                        case "diaoyu":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world diaoyu.png");
                            break;
                        case "caifeng":
                            guide=mFairy.findPic(148,69,1206,595,0.85f,"pic world caifeng.png");
                            break;
                    }
                    if(guide!=null&&guide.size()!=0){
                        if(current>guide.size()-1){
                            current=0;
                        }
                        result=guide.get(current);
                    }
                    mFairy.onTap(0.85f,result,"采集 世界 选择门派",1000);
                    current++;
                }

                //区域地图
                result=mFairy.findPic("pic area map.png");
                if(result.sim>0.8f){
                    List<FindResult> guide=null;
                    result.sim=0f;
                    double sim=0.95;
                    switch (pickType){
                        case "caicao":
                            result=mFairy.findMultiColor(148,69,1206,595,sim,"255,255,255",
                                    "2|2|255,255,255&8|8|255,255,255&12|-5|255,255,255&17|-7|255,255,255&13|2|255,255,255&21|2|255,255,255&24|1|255,255,255&27|-2|255,255,255&19|8|255,255,255");
                            break;
                        case "famu":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area famu.png");
                            break;
                        case "wakuang":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area wakuang.png");
                            break;
                        case "diaoyu":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area diaoyu.png");
                            break;
                        case "caifeng":
                            guide=mFairy.findPic(148,69,1206,595,0.82f,"pic area caifeng.png");
                            break;
                    }
                    if(guide!=null&&guide.size()!=0){
                        if(currentDetail>guide.size()-1){
                            currentDetail=0;
                        }
                        result=guide.get(currentDetail);
                    }
                    if(result.sim>0.82f){
                        mFairy.onTap(0.8f,result,"采集 区域 选择地点",100);
                        mFairy.onTap(0.8f,result,1234,33,1239,39,"关闭地图",1000);
                        mFairy.onTap(0.8f,result,1234,33,1239,39,"关闭采集界面",1000);
                    }
                    currentDetail++;
                }

                result=mFairy.findPic("word life skill interface.png");
                mFairy.onTap(0.8f,result,1219,14,1228,26,"关闭采集界面",1000);

                result=mFairy.findPic("word btn buy.png");
                mFairy.onTap(0.8f,result,"购买工具",1000);

                result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic pick add.png");
                    mFairy.onTap(0.8f,result,"添加工具",1000);

                    result=mFairy.findPic("word way.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word diaoyu qigan.png");
                        mFairy.onTap(0.8f,result,932,461,937,468,"起竿",1000);

                        result=mFairy.findMultiColor(919,419,941,439,0.9f,"20,20,17",
                                "1|0|21,20,17&2|0|21,20,17&125|58|231,232,230&14|5|230,229,210&28|35|135,131,114&19|47|222,220,192&7|33|137,134,118&2|31|225,223,201&1|18|22,22,19");

                        result1=mFairy.findMultiColor(961,458,972,467,0.95f,"255,255,255",
                                "-1|-1|255,255,255&-2|-2|255,255,255&-3|-3|255,255,255&-4|-4|255,255,255&-5|-5|255,255,255&-6|-6|255,255,255&-7|-5|254,254,254&-6|-4|252,252,252&-5|-3|255,255,255");
                        if(result.sim<0.85f&&result1.sim<0.85f){
                            result=mFairy.findPic(895,330,973,500,"pic caiji pick.png");
                            mFairy.onTap(0.8f,result,"采集",2500);

                            if(pickType.equals("caicao"))result=mFairy.findPic(895,330,973,500,"pic caicao pick.png");
                            if(pickType.equals("famu")){
                                result=mFairy.findPic("pic tool famu.png");
                                mFairy.onTap(0.8f,result,"选择伐木工具",1000);
                                result=mFairy.findPic(895,330,973,500,"pic lumber pick.png");
                            }
                            if(pickType.equals("wakuang")){
                                result=mFairy.findPic("pic tool wakuang.png");
                                mFairy.onTap(0.8f,result,"选择挖矿工具",1000);
                                result=mFairy.findPic(895,330,973,500,new String[]{"pic caiji pick.png","pic wakuang pick.png"});
                            }
                            if(pickType.equals("diaoyu")){
                                result=mFairy.findPic("pic tool diaoyu.png");
                                mFairy.onTap(0.8f,result,"选择钓鱼工具",1000);
                                result=mFairy.findPic(895,330,973,500,new String[]{"pic fish pick.png","pic fish1 pick.png"});
                            }
                            if(pickType.equals("caifeng"))result=mFairy.findPic(895,330,973,500,"pic caiji pick.png");
                            mFairy.onTap(0.8f,result,"采集1",2500);
                        }else{
                            LtLog.e(mFairy.getLineInfo("采集中result="+result.toString()+",result1="+result1.toString()));
                            mFairy.sleep(1000);
                            daze=util.initDaze();
                            return;
                        }
                    }
                }
                if(daze>8&&daze<12){
                    result=mFairy.findPic("pic up tip.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("向前走一步"));
                        mFairy.ranSwipe(199,591,199,511,200,200l,1);
                    }
                }

                if(daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word serious.png");
                mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);

                result=mFairy.findPic("word hint buy affirm.png");
                mFairy.onTap(0.8f,result,848,507,854,513,"购买确认",1000);

                result=mFairy.findPic(546,200,601,340,"word dont find way.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"无法自动寻路"));
                    util.reset_place();
                    setTaskName(1);
                    return;
                }

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"生活采集");
    }

    //课业
    public void jh_ky()throws Exception{
        new SingleTask(mFairy){
            int picCount;
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(6, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic(new String[]{"word task jh paging.png","word task jh paging2.png"});
                if(result.sim>0.7f){
                    result=mFairy.findPic(42,149,121,322,new String[]{"word task guan.png","word task guan1.png","word task ke.png","word task han.png",
                            "word task duan.png","word task xun.png","word task zhi1.png","su.png"});
                    mFairy.onTap(0.7f,result,"课业指引",Sleep);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 3, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task jh guanmeng.png","jianghu");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findMultiColor(808,420,816,429,0.95f,"235,241,243",
                        "1|0|235,242,243&1|1|235,242,243&2|1|235,243,243&2|2|235,244,244&3|2|235,241,243&3|3|235,241,243&4|3|235,242,243&4|4|235,242,243&5|4|235,244,244");
                if(result.sim>0.9f){
                    LtLog.e(mFairy.getLineInfo(0.9f,result,"采集中"));
                    mFairy.sleep(1000);
                    util.initDaze();
                    return;
                }

                result=mFairy.findPic(new String[]{"word lesson.png","word lesson1.png"});
                mFairy.onTap(0.8f,result,265,499,273,508,"课业前往",1000);

                result=mFairy.findPic("word school.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic(275,356,914,421,"word keye already.png");
                    mFairy.onTap(0.8f,result1,1115,61,1126,74,"已接取",1000);

                    if(result1.sim<0.8f)mFairy.onTap(0.8f,result,356,447,365,457,"选择任务",1000);
                }

                result=mFairy.findPic(777,533,1153,641,"pic tongbi.png");
                //template 钱不够 计数名  关闭界面
                picCount=picCount(0.8f,result,"tongbi");
                if(picCount>=5){
                    mFairy.onTap(0.8f,result,1113,61,1124,74,"铜币不足，任务结束",1000);
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.8f,result,"购买",1000);

                result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                mFairy.onTap(0.8f,result,966,485,973,495,"答题",1000);
                if(result.sim>0.8f)daze=util.initDaze();


                result=mFairy.findPic("word btn submit.png");
                mFairy.onTap(0.8f,result,"一键提交",1000);

                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                if(daze>5){
                    result=mFairy.findPic(42,149,121,322,new String[]{"word task guan.png","word task guan1.png","word task ke.png","word task han.png",
                            "word task duan.png","word task xun.png","word task zhi1.png","su.png"});
                    mFairy.onTap(0.7f,result,"课业指引",Sleep);
                    if(daze>15){
                        LtLog.e(mFairy.getLineInfo("任务超时"));
                        setTaskName(1);
                        return;
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn buy.png");
                mFairy.onTap(0.8f,result,"购买",1000);

                result=mFairy.findPic("word hint buy affirm.png");
                mFairy.onTap(0.8f,result,848,507,854,513,"购买确认",1000);


                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"课业");
    }

    //茶馆说书
    public void jh_cgss()throws Exception{
        new SingleTask(mFairy){
            long daze;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result=mFairy.findPic("word pinjie interface.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("品阶界面，跳转到3"));
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(3,244,50,442,"word task pinjie.png");
                mFairy.onTap(0.8f,result,"品阶指引",Sleep);
                if (result.sim>0.8f){
                    util.initDaze();
                    setTaskName(3);
                    return;
                }
                /**
                 1.initSlidCount初始化滑动次数
                 */
                mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 4, 125,400,125,320, 1000, 1500,1);
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task jh chaguanshuoshu.png","jianghu");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word guide discuss.png");
                mFairy.onTap(0.8f,result,969,391,975,398,"讨论1",1000);

                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                result=mFairy.findPic("word chaguan interface.png");
                if(result.sim>0.8f){
                    daze=util.initDaze();
                    result=mFairy.findMultiColor(349,17,366,41,0.9f,"254,58,79",
                            "2|0|254,58,79&4|0|254,58,79&6|0|254,58,79&-1|2|235,56,76&-1|5|253,58,79&4|5|254,58,79&6|8|254,58,79&6|11|254,58,79&2|13|253,58,79");
                    if(result.sim>0.85f){
                        mFairy.onTap(0.85f,result,1223,15,1235,27,"答对5次，退出茶馆",1000);
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("pic chaguan danmu.png");
                    mFairy.onTap(0.8f,result,"关闭弹幕",1000);

                    result=mFairy.findPic(486,302,1126,638,new String[]{"pic hand pick.png","pic fork pick.png"});
                    mFairy.onTap(0.8f,result,"入座/坐下",1000);

                    result=mFairy.findPic("word teahouse jia.png");
                    mFairy.onTap(0.8f,result,"甲",1000);

                    result=mFairy.findPic("word teahouse jia1.png");
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"答题选中甲"));
                }

                if(daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }


            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();

                result=mFairy.findPic("word hint exit teahouse.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"退出茶馆",1000);
                    setTaskEnd();
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"茶馆说书");
    }

    //江湖缥缈录
    public void jh_jhpml()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int rebuild=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,"word task piao.png");
                    mFairy.onTap(0.7f,result,"缥缈录指引",Sleep);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 2, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task jh jianghupiaomiaolu.png","jianghu");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                result=mFairy.findPic("word fight.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic up tip.png");
                    mFairy.onTap(0.8f,result,1133,536,1141,544,"自动战斗-普攻",200);
                    return;
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(1);
                    return;
                }

                //江湖缥缈录界面
                result=mFairy.findPic("word jhpml interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word jhpml two.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1115,63,1122,73,"今日次数已达上限，任务结束",1000);
                        setTaskEnd();
                        return;
                    }

                    List<FindResult> list=mFairy.findPic(1043,201,1120,554,0.8f,"word jhpml go.png");
                    if(list.size()==0){
                        return;
                    }
                    result=list.get(0);
                    mFairy.onTap(0.8f,result,"前往",1000);
                }

                result=mFairy.findPic("word serious.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);
                    if(++rebuild>=3){
                        LtLog.e(mFairy.getLineInfo("死亡三次，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"江湖缥缈录");
    }

    //鼓盆击水/躲猫猫
    public void jh_gpjs()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int count=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,"word task piao.png");
                    mFairy.onTap(0.7f,result,"缥缈录指引",Sleep);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 2, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task jh duomaomao.png","jianghu");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("pic activity interface.png");
                mFairy.onTap(0.8f,result,1213,44,1225,57,"关闭活动界面",1000);

                result=mFairy.findPic(new String[]{"word gpjs match ing.png","pic match ing.png"});
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                    util.initDaze();
                    return;
                }

                result=mFairy.findPic("pic rabbit.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("躲猫猫"));
                    util.initDaze();
                }

                result=mFairy.findPic("pic gpjs explain.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("活动中"));
                    util.initDaze();
                }

                result=mFairy.findPic("word gpjs su.png");
                mFairy.onTap(0.8f,result,"鼓盆击水-加速",1000);

                result=mFairy.findPic("pic dmm fight.png");
                mFairy.onTap(0.8f,result,"躲猫猫-狼攻击",1000);

                result=mFairy.findPic("word btn use.png");
                mFairy.onTap(0.8f,result,"使用",1000);

                result=mFairy.findPic(589,637,736,701,new String[]{"word gpjs leave.png","word txh leave.png"});
                int picCount=picCount(0.8f,result,"gpjs leave");
                if(picCount>=1){
                    mFairy.onTap(0.8f,result,"离开",1000);
                    if(picCount==1)count++;
                }

                if(count>=3){
                    LtLog.e(mFairy.getLineInfo("达到上限，任务结束"));
                    setTaskEnd();
                    return;
                }

                if (daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"鼓盆击水/躲猫猫");
    }

    //帮派任务
    public void bp_bprw()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int rebuild=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task bang.png","word task ri.png"});
                    mFairy.onTap(0.7f,result,"帮派指引",Sleep);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 3, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task bp bangpairenwu.png","bangpai");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word fight.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic up tip.png");
                    mFairy.onTap(0.8f,result,1133,536,1141,544,"自动战斗-普攻",200);
                    return;
                }

                result=mFairy.findPic("pic pick ing.png");
                if(result.sim>0.85f){
                    LtLog.e(mFairy.getLineInfo("采集中"));
                    mFairy.sleep(1000);
                    util.initDaze();
                    return;
                }

                result=mFairy.findPic("pic tongbi.png");
                int picCount=picCount(0.8f,result,"tongbi");
                if(picCount>=3){
                    LtLog.e(mFairy.getLineInfo("铜币不足，或背包已满，任务结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.8f,result,"购买",1000);

                result=mFairy.findPic("word btn submit.png");
                mFairy.onTap(0.8f,result,"一键提交",1000);

                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                result=mFairy.findPic("word serious.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);
                    if(++rebuild>=3){
                        LtLog.e(mFairy.getLineInfo("死亡三次，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                mFairy.onTap(0.8f,result,968,203,975,212,"答题",1000);
                if(result.sim>0.8f)daze=util.initDaze();

                if(daze>5){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task bang.png","word task ri.png"});
                    mFairy.onTap(0.7f,result,"帮派指引",1000);
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(1);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn buy.png");
                mFairy.onTap(0.8f,result,"购买",1000);

                result=mFairy.findPic("word hint buy affirm.png");
                mFairy.onTap(0.8f,result,848,507,854,513,"购买确认",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"帮派任务");
    }

    //势力任务
    public void bp_slrw()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int rebuild=0;
            int picCount;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task bang.png","word task ri.png"});
                    mFairy.onTap(0.7f,result,"帮派指引",Sleep);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 3, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task bp shilirenwu.png","bangpai");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word fight.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic up tip.png");
                    mFairy.onTap(0.8f,result,1133,536,1141,544,"自动战斗-普攻",200);
                    return;
                }

                result=mFairy.findPic("pic pick ing.png");
                if(result.sim>0.85f){
                    LtLog.e(mFairy.getLineInfo("采集中"));
                    mFairy.sleep(1000);
                    util.initDaze();
                    return;
                }


                result=mFairy.findPic(791,566,861,632,"pic tongbi.png");
                //template 钱不够 计数名  关闭界面
                picCount=picCount(0.8f,result,"tongbi");
                if(picCount>=5){
                    mFairy.onTap(0.8f,result,1113,61,1124,74,"铜币不足，任务结束",1000);
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.8f,result,"购买",1000);

                result=mFairy.findPic("word btn submit.png");
                mFairy.onTap(0.8f,result,"一键提交",1000);

                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                result=mFairy.findPic("word serious.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);
                    if(++rebuild>=3){
                        LtLog.e(mFairy.getLineInfo("死亡三次，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }

                if(daze>5){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task bang.png","word task ri.png"});
                    mFairy.onTap(0.7f,result,"帮派指引",1000);
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(1);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"势力任务");
    }

    //门客设宴
    public void bp_mksy()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task bang.png","word task ri.png"});
                    mFairy.onTap(0.7f,result,"帮派指引",Sleep);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 3, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task bp menkesheyan.png","bangpai");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn go invite.png");
                mFairy.onTap(0.8f,result,"前往邀约",1000);

                result=mFairy.findPic(831,160,896,201,"word btn go.png");
                mFairy.onTap(0.8f,result,"前往",1000);

                result=mFairy.findPic("word btn affirm invite.png");
                mFairy.onTap(0.8f,result,"确认邀约",1000);

                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                //门客设宴界面
                result=mFairy.findPic("word mksy interface.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    int submit=0,current=0;
                    for (int i=1;i<=4;i++){
                        result=mFairy.findPic(580+154*(i-1),252,621+154*(i-1),296,"word mksy already submit.png");
                        if(result.sim>0.8f){
                            submit++;
                        }else{
                            if(current==0){
                                current=i;
                                mFairy.onTap(580+154*(i-1),252,621+154*(i-1),296,"切换第"+i+"个",1000);
                            }
                        }
                    }

                    for (int i=1;i<=4;i++){
                        result=mFairy.findPic(578+154*(i-1),417,624+154*(i-1),460,"word mksy already submit.png");
                        if(result.sim>0.8f){
                            submit++;
                        }else{
                            if(current==0){
                                mFairy.onTap(578+154*(i-1),417,624+154*(i-1),460,"切换第"+(4+i)+"个",1000);
                            }
                            break;
                        }
                    }

                    if(submit>=8){
                        result=mFairy.findPic("word btn start banquet.png");
                        mFairy.onTap(0.8f,result,"开始设宴",1000);
                        return;
                    }

                    result=mFairy.findPic("word btn mksy submit.png");
                    mFairy.onTap(0.8f,result,"提交",1000);

                    result=mFairy.findPic("word btn mksy get.png");
                    mFairy.onTap(0.8f,result,"获取",1000);

                    result=mFairy.findPic(668,195,738,238,"word get way.png");
                    mFairy.onTap(0.8f,result,645,302,651,309,"获取途径",1000);
                }

                if(daze>10){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn buy.png");
                int picCount=picCount(0.8f,result,"tongbi");
                if(picCount>=3){
                    mFairy.onTap(0.8f,result,996,97,1004,108,"银两不足，任务结束",1000);
                    mFairy.onTap(0.8f,result,1117,63,1125,74,"银两不足，任务结束",1000);
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.8f,result,"购买",1000);

                result=mFairy.findPic("word hint buy affirm.png");
                mFairy.onTap(0.8f,result,848,507,854,513,"购买确认",1000);

                result=mFairy.findPic("word hint another reward.png");
                mFairy.onTap(0.8f,result,850,508,858,514,"确认开始设宴",1000);



                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"门客设宴");
    }

    //华山论剑
    public void fz_hslj()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                util.exitTeam();//退出队伍，不然没法执行
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,"word task bang.png");
                    mFairy.onTap(0.7f,result,"课业指引",1000);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 2, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task fz huashanlunjian.png","fenzheng");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word hslj interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(603,302,656,367,"word hint none world.png");
                    if(result.sim>0.8f)util.to_world();

                    result=mFairy.findPic("pic hslj match ing.png");
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"匹配中"));
                    if(result.sim>0.8f)util.initDaze();

                    result1=mFairy.findPic("word hslj five.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result,943,584,955,595,"取消匹配",1000);
                        result=mFairy.findPic("pic hslj award.png");
                        mFairy.onTap(0.8f,result,"领取奖励",1000);
                        LtLog.e(mFairy.getLineInfo("完成挑战5次，任务结束"));
                        setTaskEnd();
                        return;
                    }


                }
                result=mFairy.findPic(new String[]{"word btn match.png","word btn match1.png","word btn match2.png"});
                mFairy.onTap(0.8f,result,"匹配",1000);
                if(result.sim>0.8f)util.initDaze();

                result=mFairy.findPic("word txh ready.png");
                mFairy.onTap(0.8f,result,"准备",1000);

                result=mFairy.findPic("word hslj residue.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    result=mFairy.findPic("word double hit.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1053,662,1060,670,"技能1",500);
                        mFairy.onTap(0.8f,result,991,572,998,577,"技能2",500);
                        mFairy.onTap(0.8f,result,1014,448,1019,452,"技能3",500);
                        mFairy.onTap(0.8f,result,1105,390,1110,395,"技能4",500);
                        mFairy.onTap(0.8f,result,1134,532,1138,538,"普攻",500);
                        mFairy.onTap(0.8f,result,1134,532,1138,538,"普攻",500);
                    }else{
                        mFairy.onTap(1220,658,1228,668,"重置镜头",500);
                        mFairy.ranSwipe(199,591,199,511,1500,1000l,0);//向前走一步
                        LtLog.e(mFairy.getLineInfo("行走一步"));
                        mFairy.onTap(1134,532,1138,538,"普攻",200);
                        mFairy.onTap(1134,532,1138,538,"普攻",500);
                    }
                }

                result=mFairy.findPic("word txh leave.png");
                mFairy.onTap(0.8f,result,"离开",1000);

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint same strength.png");
                mFairy.onTap(0.8f,result,848,504,857,514,"匹配不同修为",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"华山论剑");
    }

    //江湖英雄榜
    public void fz_jhyxb()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                util.exitTeam();//退出队伍，不然没法执行
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,"word task bang.png");
                    mFairy.onTap(0.7f,result,"课业指引",1000);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 2, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task fz jianghuyingxiongbang.png","fenzheng");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word jhyxb interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word jhyxb can get.png");
                    mFairy.onTap(0.8f,result,163,581,170,591,"点击可领取",1000);

                    result=mFairy.findPic("word jhyxb finish.png");
                    mFairy.onTap(0.8f,result,429,592,435,598,"领取三战宝箱",1000);

                    result=mFairy.findPic("word jhyxb zero.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("剩余挑战次数0，任务结束"));
                        mFairy.onTap(0.8f,result,1113,61,1124,76,"关闭江湖英雄榜界面",1000);
                        setTaskEnd();
                    }

                    result=mFairy.findPic(1010,561,1089,618,new String[]{"word btn match.png","word btn match1.png"});
                    mFairy.onTap(0.8f,result,"匹配",1000);

                    result=mFairy.findPic(975,569,1060,610,"word btn jinji.png");
                    mFairy.onTap(0.8f,result,"晋级赛",1000);
                }

                result=mFairy.findPic("word txh ready.png");
                mFairy.onTap(0.8f,result,"准备",1000);

                result=mFairy.findPic("word jhyxb residue.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    result=mFairy.findPic("word double hit.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1053,662,1060,670,"技能1",500);
                        mFairy.onTap(0.8f,result,991,572,998,577,"技能2",500);
                        mFairy.onTap(0.8f,result,1014,448,1019,452,"技能3",500);
                        mFairy.onTap(0.8f,result,1105,390,1110,395,"技能4",500);
                        mFairy.onTap(0.8f,result,1134,532,1138,538,"普攻",500);
                        mFairy.onTap(0.8f,result,1134,532,1138,538,"普攻",500);
                    }else{
                        mFairy.onTap(1220,658,1228,668,"重置镜头",500);
                        mFairy.ranSwipe(199,591,199,511,1500,1000l,0);//向前走一步
                        LtLog.e(mFairy.getLineInfo("行走一步"));
                        mFairy.onTap(1134,532,1138,538,"普攻",200);
                        mFairy.onTap(1134,532,1138,538,"普攻",500);
                    }
                }

                result=mFairy.findPic("word txh leave.png");
                mFairy.onTap(0.8f,result,"离开",1000);

                if(daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint jinji.png");
                mFairy.onTap(0.8f,result,843,506,853,516,"确定晋级",1000);
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"江湖英雄榜");
    }

    //行侠仗义
    public void hd_xxzy()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int rebuild=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                daze=util.initDaze();
                result=mFairy.findPic("word yjjg interface.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("活动执行中"));
                    setTaskName(3);
                    return;
                }
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(6, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,"word task yi.png");
                    mFairy.onTap(0.7f,result,"侠义指引",1000);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 2, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task hd xingxiazhangyi.png","hangdang");
                if (ret==1){
                    daze=util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word dialogue mibao.png");
                mFairy.onTap(0.8f,result,1215,17,1226,29,"关闭秘宝",1000);

                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word xxzy none info.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("没有线索了"));
                        setTaskName(2);
                        return;
                    }

                    result=mFairy.findPic(760,193,825,254,"word btn find out.png");
                    mFairy.onTap(0.8f,result,"追查",1000);

                    if(daze!=0&&daze%4==0){
                        mFairy.onTap(1134,532,1138,538,"普攻",200);
                        mFairy.onTap(1134,532,1138,538,"普攻",200);
                    }

                    result=mFairy.findPic("word double hit.png");
                    if(result.sim>0.8f)daze=util.initDaze();
                    mFairy.onTap(0.8f,result,1053,662,1060,670,"技能1",200);
                    mFairy.onTap(0.8f,result,991,572,998,577,"技能2",200);
                    mFairy.onTap(0.8f,result,983,564,990,573,"技能3",200);
                    mFairy.onTap(0.8f,result,1105,390,1110,395,"技能4",200);
                    mFairy.onTap(0.8f,result,1134,532,1138,538,"普攻",200);
                }

                result=mFairy.findPic("word serious.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);
                    if(++rebuild>=3){
                        LtLog.e(mFairy.getLineInfo("死亡三次，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }
                //有间酒馆界面
                result=mFairy.findPic("word yjjg interface.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    //满五个线索
                    result=mFairy.findPic("pic yjjg info.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic yjjg open.png");
                        mFairy.onTap(0.8f,result,"展开线索",1000);

                        result=mFairy.findPic("word btn find out.png");
                        mFairy.onTap(0.8f,result,"追查",1000);
                    }else{
//                        result=mFairy.findMultiColor(510,236,713,379,0.9f,"172,139,78",
//                                "4|0|133,103,59&10|0|144,114,65&0|3|153,123,70&0|9|193,156,89&15|-2|166,135,76&21|-2|208,171,96&17|5|220,182,103&23|5|215,177,100&26|9|223,185,104");
//                        mFairy.onTap(0.8f,result,"对话乞丐，搜集线索",1000);
//                        if(result.sim>0.8f)return;
//
//                        result=mFairy.findMultiColor(750,283,1276,671,0.9f,"172,139,78",
//                                "4|0|133,103,59&10|0|144,114,65&0|3|153,123,70&0|9|193,156,89&15|-2|166,135,76&21|-2|208,171,96&17|5|220,182,103&23|5|215,177,100&26|9|223,185,104");
//                        mFairy.onTap(0.8f,result,"对话乞丐，搜集线索",1000);

                        result=mFairy.findPic("pic btn dialogue.png");
                        mFairy.onTap(0.8f,result,"对话",1000);

                        if(result.sim<0.8f){
                            mFairy.ranSwipe(199,591,264,644,500,1500l,0);
                            LtLog.e(mFairy.getLineInfo("向右下走一步"));
                        }
                    }
                }

                result=mFairy.findPic("word zhsr interface.png");
                mFairy.onTap(0.8f,result,1111,62,1123,75,"关闭杂货商人",1000);

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint xiayi.png");
                mFairy.onTap(0.8f,result,852,506,862,516,"开启侠义状态",1000);

                result=mFairy.findPic("word hint none learn.png");
                mFairy.onTap(0.8f,result,416,512,421,516,"未打听完,留在此处",1000);

                result=mFairy.findPic("word hint affirm leave.png");
                mFairy.onTap(0.8f,result,"确定离开",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"行侠仗义");
    }

    //每日一卦
    public void yl_mryg()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic change task.png");
                mFairy.onTap(0.8f,result,"切换任务分页",1000);

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);

                //江湖分页栏
                result=mFairy.findPic("word task jh paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(51,140,81,332,"word task bang.png");
                    mFairy.onTap(0.7f,result,"课业指引",1000);
                    if (result.sim>0.7f){
                        util.initDaze();
                        setTaskName(3);
                        return;
                    }
                    /**
                     1.initSlidCount初始化滑动次数
                     */
                    mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 2, 160,330,160,200, 1000, 1500,1);
                }
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic task yl meiriyigua.png","youli");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png"});
                mFairy.onTap(0.8f,result,"对话选择",1000);

                result=mFairy.findPic("word casual.png");
                mFairy.onTap(0.8f,result,"随缘",1000);
                if(result.sim>0.8f)util.initDaze();

                result=mFairy.findPic("word draw.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("画图"));
                    mFairy.ranSwipe(545,347,709,351,1000,1000l,0);
                }else{
                    result=mFairy.findPic("word drop.png");
                    int picCount=picCount(0.8f,result,"drop");
                    if(picCount>=3){
                        mFairy.onTap(0.8f,result,1073,136,1074,137,"铜币不足，任务结束",1000);
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f,result,"落笔",1000);
                }

                result=mFairy.findPic("word btn mryg accept.png");
                mFairy.onTap(0.8f,result,"接受",1000);

                if(daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint hexagram.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,836,505,842,513,"接受卦象",1000);
                    setTaskEnd();
                    return;
                }

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"每日一卦");
    }

    //悬赏
    public void reward()throws Exception{
        new SingleTask(mFairy){
            Integer wltf=0,jhxs=0,jypy=0,yzhj=0,szhw=0;
            String taskName="";
            @Override
            public void create() throws Exception {
                int week=mFairy.week();
                //万里听风
                ControlSplit split ;
                if(!AtFairyConfig.getOption("wltf").equals("")){
                    split =strSplit(AtFairyConfig.getOption("wltf"));
                    if(split.choice==1){
                        if(week==2||week==4||week==5||week==6||week==7){
                            wltf=split.count;
                        }
                    }
                }

                //江湖行商 二四五六日
                if(!AtFairyConfig.getOption("jhxs").equals("")){
                    split =strSplit(AtFairyConfig.getOption("jhxs"));
                    if(split.choice==1){
                        if(week==2||week==4||week==5||week==6||week==7){
                            jhxs=split.count;
                        }
                    }
                }

                //聚义平冤 二四五六日
                if(!AtFairyConfig.getOption("jypy").equals("")) {
                    split = strSplit(AtFairyConfig.getOption("jypy"));
                    if (split.choice == 1) {
                        if (week == 2 || week == 4 || week == 5 || week == 6 || week == 7) {
                            jypy = split.count;
                        }
                    }
                }

                //弈中幻境 一三四六日
                if(!AtFairyConfig.getOption("yzhj").equals("")) {
                    split = strSplit(AtFairyConfig.getOption("yzhj"));
                    if (split.choice == 1) {
                        if (week == 1 || week == 3 || week == 4 || week == 6 || week == 7) {
                            yzhj = split.count;
                        }
                    }
                }

                //山珍海味 一三五六日
                if(!AtFairyConfig.getOption("szhw").equals("")) {
                    split = strSplit(AtFairyConfig.getOption("szhw"));
                    if (split.choice == 1) {
                        if (week == 1 || week == 3 || week == 5 || week == 6 || week == 7) {
                            szhw = split.count;
                        }
                    }
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                if(wltf>0){taskName="wltf";LtLog.e(mFairy.getLineInfo("万里听风还剩余"+wltf+"次"));return;}
                if(jhxs>0){taskName="jhxs";LtLog.e(mFairy.getLineInfo("江湖行商还剩余"+jhxs+"次"));return;}
                if(jypy>0){taskName="jypy";LtLog.e(mFairy.getLineInfo("聚义平冤还剩余"+jypy+"次"));return;}
                if(szhw>0){taskName="szhw";LtLog.e(mFairy.getLineInfo("山珍海味还剩余"+szhw+"次"));return;}
                if(yzhj>0){taskName="yzhj";LtLog.e(mFairy.getLineInfo("弈中幻境还剩余"+yzhj+"次"));return;}
                LtLog.e(mFairy.getLineInfo("没有任务了，任务结束"));
                setTaskEnd();
            }

            @Override
            public void content_1() throws Exception {
                //进入活动界面
                result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic activity.png");
                    mFairy.onTap(0.8f,result,"进入活动",1000);
                    if(result.sim<0.8f){
                        result=mFairy.findPic("pic open system.png");
                        mFairy.onTap(0.8f,result,"展开系统",1000);

                        result=mFairy.findPic("pic activity1.png");
                        mFairy.onTap(0.8f,result,"进入活动1",1000);
                    }
                }

                result=mFairy.findPic("word reward.png");
                mFairy.onTap(0.8f,result,"进入悬赏",1000);

                //在悬赏界面
                result=mFairy.findPic("pic reward interface.png");
                if(result.sim>0.8){
                    //活跃度不够
                    result=mFairy.findPic(625,296,721,347,"word reward cant get.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1217,46,1224,55,"活跃度不满50，无法领取",1000);
                        mFairy.onTap(0.8f,result,1217,46,1224,55,"关闭",1000);
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word reward ten.png");
                    mFairy.onTap(0.8f,result,"今日接取10次，任务结束",1000);
                    if(result.sim>0.8f){
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word reward change receive.png");
                    mFairy.onTap(0.8f,result,"切换任务接取分页",1000);

                    //已分类
                    result=mFairy.findPic("pic reward sort selected.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,995,134,1005,145,"刷新",1000);

                        //找到这个任务
                        result=mFairy.findPic("word reward head "+taskName+".png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic("word btn reward receive.png");
                            mFairy.onTap(0.8f,result,"接取",1000);

                            result=mFairy.findPic(320,487,405,531,"word btn go.png");
                            if(result.sim>0.8f)setTaskName(2);
                            mFairy.onTap(0.8f,result,"前往",1000);
                        }else{
                            result=mFairy.findPic(302,296,1040,334,"word reward sort "+taskName+".png");
                            mFairy.onTap(0.8f,result,"选择"+taskName+"悬赏分类",1000);

                            result1=mFairy.findPic(317,483,1040,516,"word reward sort "+taskName+".png");
                            mFairy.onTap(0.8f,result1,"选择"+taskName+"悬赏分类",1000);
                        }return;
                    }
                    if(result.sim<0.8f)mFairy.onTap(790,134,799,144,"勾选分类显示",1000);
                    return;
                }

                if(result.sim<0.8f)overtime(10,0);
            }

            @Override
            public void content_2() throws Exception {
                if(taskName.equals("wltf")){new TeamTask(mFairy).xs_wltf();wltf--;}
                if(taskName.equals("jhxs")){new TeamTask(mFairy).xs_jhxs();jhxs--;}
                if(taskName.equals("jypy")){new TeamTask(mFairy).xs_jypy();jypy--;}
                if(taskName.equals("yzhj")){new TeamTask(mFairy).xs_yzhj();yzhj--;}
                if(taskName.equals("szhw")){new TeamTask(mFairy).xs_szhw();szhw--;}
                LtLog.e(mFairy.getLineInfo(taskName+"执行完成"));
                setTaskName(0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint cash.png");
                if(picCount(0.8f,result,"cash")>=3){
                    mFairy.onTap(0.8f,result,418,509,422,513,"铜币不足，任务结束",1000);
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.8f,result,811,506,818,514,"缴纳押金",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"悬赏");
    }

    //每日签到
    public void sign()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(10,0);
                result=mFairy.findPic(762,0,1157,232,"pic welfare.png");
                mFairy.onTap(0.8f,result,"进入福利",1000);

                if(result.sim<0.8f){
                    result=mFairy.findPic("pic open system.png");
                    mFairy.onTap(0.8f,result,"展开系统选项",1000);

                    result=mFairy.findPic("pic welfare1.png");
                    mFairy.onTap(0.8f,result,"进入福利",1000);
                }

                result=mFairy.findPic("pic welfare interface.png");
                mFairy.onTap(0.8f,result,454,472,460,478,"进入签到",1000);

                result=mFairy.findPic("word daily sign.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,148,492,156,501,"领取奖励",1000);
                    LtLog.e(mFairy.getLineInfo("每日签到完成"));
                    util.close();
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy,"每日签到");
    }

    //江湖馈赠
    public void jhkz()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(15,0);
                result=mFairy.findPic("word serious.png");
                mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);

                result=mFairy.findPic(751,4,1157,219,"pic shop.png");
                mFairy.onTap(0.8f,result,"进入珍宝阁",1000);

                result=mFairy.findPic("word btn use.png");
                mFairy.onTap(0.8f,result,"使用",1000);

                result=mFairy.findPic("word zbg interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic zbg shangcheng.png");
                    mFairy.onTap(0.8f,result,"切换商城分页",1000);

                    result=mFairy.findPic("word zbg jhkz.png");
                    mFairy.onTap(0.8f,result,"切换江湖馈赠分页",1000);

                    result=mFairy.findPic("word zbg jhkz1.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(205,205,602,415,"word zbg free.png");
                        mFairy.onTap(0.8f,result,"切换免费馈赠",1000);
                        mFairy.onTap(0.8f,result,858,592,866,601,"免费领取",1000);

                        if(result.sim<0.8f){
                            mFairy.onTap(1110,61,1124,75,"免费领取完成",1000);
                            setTaskEnd();
                        }
                    }
                }
            }

        }.taskContent(mFairy,"江湖馈赠");
    }

    @Override
    public void inOperation() throws Exception {
        result=mFairy.findPic("word hint continue plot.png");
        mFairy.onTap(0.8f,result,846,507,853,511,"确认跳过剧情",1000);

        result=mFairy.findPic("word btn jhqy refuse.png");
        mFairy.onTap(0.8f,result,"奇遇拒绝",1000);

        result=mFairy.findPic(new String[]{"word btn use.png","word btn eat.png","word btn drink.png"});
        mFairy.onTap(0.8f,result,"使用/实用/饮用",1000);

        result=mFairy.findPic("word hint btn affirm use.png");
        mFairy.onTap(0.8f,result,"确认使用",1000);

        result=mFairy.findPic(300,145,396,203,"pic hint1.png");
        if(result.sim>0.8f){
            result=mFairy.findPic("word hint affirm.png");
            mFairy.onTap(0.8f,result,"确定",1000);
            if(result.sim>0.8f)return;

            result=mFairy.findPic(new String[]{"word hint disabled.png","word hint planes.png","word hint dont find way.png"});
            mFairy.onTap(0.8f,result,852,505,860,513,"任务失效/离开位面/无法寻路",1000);
            if(result.sim>0.8f)return;

            mFairy.onTap(414,505,421,513,"关闭/取消",1000);
        }

        result=mFairy.findPic(546,297,601,340,"word dont find way.png");
        if(result.sim>0.8f){
            LtLog.e(mFairy.getLineInfo(0.8f,result,"无法自动寻路"));
            util.reset_place();
        }

        result=mFairy.findMultiColor(7,339,35,376,0.95f,"167,175,176",
                "0|-13|219,219,219&5|-7|212,220,220&9|-3|216,220,220&10|0|216,216,216&13|0|211,219,219&9|3|211,220,221&7|5|212,220,220&5|7|208,217,217&3|9|213,215,216");
        mFairy.onTap(0.9f,result,"打开任务栏",1000);

        result=mFairy.findPic("pic change task.png");
        mFairy.onTap(0.8f,result,"切换任务分页",1000);
    }

    public void test()throws Exception{
        while(mFairy.condit()){
            mFairy.sleep(500);
            LtLog.e(mFairy.getLineInfo("\ntest while..........."));
//            result=mFairy.findPic("pic up tip.png");
//            mFairy.onTap(0.8f,result,1133,536,1141,544,"战斗",200);

//            result=mFairy.findPic("word dxg interface.png");
//            LtLog.e(mFairy.getLineInfo("result1="+result.toString()));

            long dazeTime=
                    mFairy.dazeTime(1138,1,1256,18,0.9f,0,"246,246,245");
            LtLog.e(mFairy.getLineInfo("dazeTime="+dazeTime));

            result=mFairy.findPic(546,200,601,340,"word dont find way.png");
            LtLog.e(mFairy.getLineInfo("result="+result.toString()));
//
//            //疾跑
//            result=mFairy.findMultiColor(1210,278,1251,316,0.9f,"213,208,206",
//                    "0|1|212,208,205&-1|3|212,208,205&-3|5|212,208,206&-6|8|213,208,206&-9|9|214,209,207&-14|5|162,153,146&-16|1|141,130,122&-12|-3|143,132,125&-12|1|212,207,204");
//            LtLog.e(mFairy.getLineInfo("result2="+result.toString()));

//            LtLog.e(mFairy.getLineInfo("colorNum1="+mFairy.getColorNum(1161,633,1261,714,0.9f,0,"81,162,195")+""));
//            LtLog.e(mFairy.getLineInfo("colorNum2="+mFairy.getColorNum(1161,633,1261,714,0.95f,0,"81,162,195")+""));
//            LtLog.e(mFairy.getLineInfo("colorNum3="+mFairy.getColorNum(1161,633,1261,714,0.99f,0,"81,162,195")+""));
//            LtLog.e(mFairy.getLineInfo(mFairy.getColorNum(1161,633,1261,714,0.9f,0,"81,162,195")+""));
        }
    }
}
