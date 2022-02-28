package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    LimitLessTask timingActivity;
    Util util;

    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }

    //答题 每天12:00-13:30
    public void timing_answer()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn answer.png");
                if(result.sim>0.8f){
                    setTaskName(2);
                    return;
                }

                int resu=util.mission1("word timing answer.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                //答题界面
                result=mFairy.findPic(213,56,265,99,"word answer interface.png");
                if(result.sim>0.8f){
                    //已答完
                    result=mFairy.findPic(970,601,1078,653,"word already answer.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("已答完，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic(920,584,972,669,"pic button.png");
                    mFairy.onTap(0.8f,result,"前往",1000);

                    result=mFairy.findPic("word answer A.png");
                    mFairy.onTap(0.8f,result,"答题 A",2000);
                    util.initDaze();
                }

                result=mFairy.findPic("word btn answer.png");
                mFairy.onTap(0.8f,result,"开始答题",1000);

                result=mFairy.findPic(716,485,808,536,"word btn go1.png");
                mFairy.onTap(0.8f,result,"前往下一处答题",1000);

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint answer.png");
                mFairy.onTap(0.8f,result,"开始答题",1000);

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-答题");
    }

    //游龙戏凤 三 日 20:00-20:30
    public void timing_ylxf()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word btn answer.png");
                if(result.sim>0.8f){
                    setTaskName(2);
                    return;
                }
                int resu=util.mission1("word timing answer.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word ylxf match.png");
                if(result.sim>0.8f)util.initDaze();

                result=mFairy.findPic("word guide.png");
                mFairy.onTap(0.8f,result,859,50,882,64,"关闭活动指引",1000);

                result=mFairy.findPic("word detail.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn huoqu.png");
                    mFairy.onTap(0.8f,result,"获取",10000);
                    util.initDaze();
                }

                //游龙戏凤 对战界面
                result=mFairy.findPic("pic ylxf fight interface.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,333,477,342,486,"对战中",2000);
                    util.initDaze();
                }

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-游龙戏凤");
    }

    //奇人异士 二 四 六 日 12:30-12:50
    public void timing_qrys()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                int resu=util.mission1("word timing qrys.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                int hour=mFairy.dateHour();
                int min=mFairy.dateMinute();

                if((hour==12&&min>45)||hour!=12){
                    LtLog.e(mFairy.getLineInfo("活动结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("pic zhidian.png");
                mFairy.onTap(0.8f,result,"掷点",1000);

                result=mFairy.findPic("word dialogue qiren.png");
                mFairy.onTap(0.8f,result,"奇人异士录",10000);

                result=mFairy.findPic(444,560,529,617,"word btn challenge.png");
                mFairy.onTap(0.8f,result,"选择挑战",1000);

                result=mFairy.findPic("word ranking.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("在活动中"));
                    util.initDaze();
                }

                result=mFairy.findPic("pic qrys fight.png");
                mFairy.onTap(0.8f,result,"前往挑战",1000);

                result=mFairy.findPic("word qrysl over.png");
                mFairy.onTap(0.8f,result,517,543,701,716,"战斗结束",1000);

                if(daze>=20){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(605,456,672,595,"word hint affirm.png");
                mFairy.onTap(0.8f,result,"确认",1000);

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-奇人异士");
    }

    //万花典  一三五 12:30-12:45
    public void timing_whd()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                int resu=util.mission1("word timing whd.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                int hour=mFairy.dateHour();
                int min=mFairy.dateMinute();

                if((hour==12&&min>45)||hour!=12){
                    LtLog.e(mFairy.getLineInfo("活动结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word dialogue enter.png");
                mFairy.onTap(0.8f,result,"进入花谷",1000);

                result=mFairy.findPic("word whd over.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.6f,result,971,690,982,699,"活动结束",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }

                //花谷界面
                result=mFairy.findPic("word huagu interface.png");
                if(result.sim>0.8f){
                    util.initDaze();
                }

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint answer.png");
                mFairy.onTap(0.8f,result,"开始答题",1000);

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-万花典");
    }

    //九重之围 二 20:00-20:30
    public void timing_jczw()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                result=mFairy.findPic("word team state.png");
                if(result.sim>0.8f){
                    setTaskName(3);
                    return;
                }

                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                int resu=util.mission1("word timing sjgh.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                int hour=mFairy.dateHour();
                int min=mFairy.dateMinute();

                result=mFairy.findPic("word btn enter.png");
                mFairy.onTap(0.8f,result,"进入活动",1000);

                result=mFairy.findPic("word btn bianjie.png");
                mFairy.onTap(0.8f,result,"便捷组队",1000);

                result=mFairy.findPic("word search team.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn create team.png");
                    mFairy.onTap(0.8f,result,"创建队伍",1000);
                }

                result=mFairy.findPic("word create team interface.png");
                mFairy.onTap(0.8f,result,625,628,638,641,"创建队伍-确定",1000);

                //队伍管理界面
                result=mFairy.findPic("word team manager.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    LtLog.e(mFairy.getLineInfo("匹配队伍中"));
                    result=mFairy.findPic("pic team invite.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word btn go goal.png");
                        mFairy.onTap(0.8f,result,"前往目标",1000);
                    }
                }

                //队伍概况
                result=mFairy.findPic("word team state.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    LtLog.e(mFairy.getLineInfo("活动执行中，等待匹配"));
                }

                if((hour==20&&min>30)||hour!=20){
                    LtLog.e(mFairy.getLineInfo("活动结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-九重之围");
    }

    //世家篝火 二四六 21:00-21:15
    public void timing_sjgh()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                int resu=util.mission1("word timing sjgh.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                int hour=mFairy.dateHour();
                int min=mFairy.dateMinute();

                result=mFairy.findPic("word btn sjgh.png");
                mFairy.onTap(0.8f,result,"世家篝火",1000);

                result=mFairy.findPic("pic award.png");
                if(result.sim>0.8f){
                    util.close();
                    result=mFairy.findPic("word sjgh wait.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("世家篝火，等待中"));
                    }else{
                        LtLog.e(mFairy.getLineInfo("世家篝火，进行中"));
                    }
                }

                if((hour==21&&min>15)||hour!=21){
                    LtLog.e(mFairy.getLineInfo("活动结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-世家篝火");
    }

    //世家试炼 六日 00:00-23:59
    public void timing_sjsl()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                int resu=util.mission1("word timing sjsl.png");
                if(resu==1){
                    setTaskName(2);
                    return;
                }else{
                    setTaskEnd();
                }
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word btn sjsl.png");
                mFairy.onTap(0.8f,result,"世家试炼",1000);

                result=mFairy.findPic("pic sjsl fight.png");
                mFairy.onTap(0.8f,result,"前往挑战",1000);

                result=mFairy.findPic(new String []{"word sjsl over.png","word sjsl award.png"});
                mFairy.onTap(0.8f,result,971,690,982,699,"战斗结束",1000);

                result=mFairy.findPic("word sjsl zero.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1215,39,1229,52,"剩余次数0，活动结束",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时,重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                int week=mFairy.week();
                if(week!=6&&week!=7){
                    util.close();
                    LtLog.e(mFairy.getLineInfo("不在活动时间，任务结束"));
                    setTaskEnd();
                    return;
                }
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"限时活动-世家试炼");
    }

    //成就领奖
    public void timing_cjlj()throws Exception{
        new TimingActivity(mFairy){
            long daze=0;
            @Override
            public void create() throws Exception {
            }

            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
               result= mFairy.findPic("pic open more.png");
               mFairy.onTap(0.8f,result,"展开更多",1000);

               result=mFairy.findPic("word chengjiu.png");
               mFairy.onTap(0.8f,result,"成就",1000);

                result=mFairy.findPic("word chengjiu interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(366,121,386,142,"pic red tip1.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn get1.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"领取",1000);
                            return;
                        }
                    }else{
                        mFairy.onTap(1141,90,1152,99,"奖励领完，关闭成就界面",1000);
                        setTaskEnd();
                    }
                }
                overtime(15,0);
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"成就领奖");
    }

    //在线奖励
    public void timing_zxlj()throws Exception{
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(new String[]{"pic open active.png","pic open active1.png"});
                mFairy.onTap(0.8f,result,"展开更多活动",1000);

                result=mFairy.findPic("word welfare.png");
                mFairy.onTap(0.8f,result,"进入福利",1000);

                result=mFairy.findPic("word online gift.png");
                mFairy.onTap(0.8f,result,"切换在线好礼分页",1000);

                result=mFairy.findPic("word btn a key get.png");
                result1=mFairy.findPic(285,239,302,258,"pic red tip3.png");
                if(result.sim>0.8f){
                    if(result1.sim<0.8f){
                        mFairy.onTap(0.8f,result1,1193,80,1209,93,"在线奖励，领取完成，任务结束",1000);
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f,result,"一键领取",1000);
                }

                overtime(15,0);
            }
        }.taskContent(mFairy,"在线奖励");
    }

    //七天好礼
    public void timing_qthl()throws Exception{
        new TimingActivity(mFairy){
            int task=1;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(task);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word qrdl interface.png");
                mFairy.onTap(0.8f,result,135,179,142,187,"切换达成好礼分页",1000);

                result=mFairy.findPic("word dchl interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(240,143,257,162,"pic red tip3.png");
                    if(result.sim<0.75f){
                        LtLog.e(mFairy.getLineInfo("达成好礼分页，领取完成"));
                        task=2;
                        setTaskName(2);
                    }

                    result=mFairy.findPic(1111,363,1194,416,"word btn get1.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"领取",1000);
                        return;
                    }

                    result=mFairy.findPic(650,320,670,482,"pic red tip3.png");
                    if(result.sim>0.75f){
                        mFairy.onTap(0.75f,result,result.x-10,result.y+10,result.x-9,result.y+11,"切换类型分页",1000);
                        return;
                    }

                    result=mFairy.findPic(584,264,1247,285,"pic red tip3.png");
                    mFairy.onTap(0.8f,result,result.x-10,result.y+10,result.x-9,result.y+11,"切换第几天分页",1000);
                }
                overtime(15,0);
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word dchl interface.png");
                mFairy.onTap(0.8f,result,122,255,131,266,"切换达成好礼分页",1000);

                result=mFairy.findPic("word qrdl interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(239,218,259,239,"pic red tip3.png");
                    if(result.sim<0.75f){
                        mFairy.onTap(1219,111,1230,124,"七日登录分页，领取完成，任务结束",1000);
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic(716,144,1133,170,"pic red tip3.png");
                    mFairy.onTap(0.7f,result,result.x-15,result.y+20,result.x-14,result.y+21,"切换领奖",1000);

                    result=mFairy.findPic(621,313,1231,334,"pic red tip3.png");
                    mFairy.onTap(0.7f,result,result.x-15,result.y+20,result.x-14,result.y+21,"切换领奖",1000);

                    result=mFairy.findPic(1122,535,1202,592,"word btn get1.png");
                    mFairy.onTap(0.8f,result,"领取",1000);
                }
                overtime(15,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word active.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"进入活动",1000);

                    result=mFairy.findPic(764,181,1200,243,"pic award jchd.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic qthl.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"进入七天好礼",1000);
                        }else{
                            LtLog.e(mFairy.getLineInfo("已经过了七天好礼，任务结束"));
                            setTaskEnd();
                            return;
                        }
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"七天好礼");
    }

    //广储司
    public void timing_gcs()throws Exception{
        new TimingActivity(mFairy){
            int task=1;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(task);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(new String[]{"pic open active.png","pic open active1.png"});
                mFairy.onTap(0.8f,result,"展开更多活动",1000);

                result=mFairy.findPic("word welfare.png");
                mFairy.onTap(0.8f,result,"进入福利",1000);

                result=mFairy.findPic("word gcs interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word gcs get.png");
                    mFairy.onTap(0.8f,result,"领取",1000);

                    result=mFairy.findPic("word find back.png");
                    mFairy.onTap(0.8f,result,"找回",1000);
                }
                overtime(15,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word active.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"进入活动",1000);

                    result=mFairy.findPic(764,181,1200,243,"pic award jchd.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic qthl.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"进入七天好礼",1000);
                        }else{
                            LtLog.e(mFairy.getLineInfo("已经过了七天好礼，任务结束"));
                            setTaskEnd();
                            return;
                        }
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"广储司");
    }

    //当差
    public void single_dc()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
            }

            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(2);
                return;
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily dc.png");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                //随从当差界面
                result=mFairy.findPic("word scdc interface.png");
                if(result.sim>0.8f){
                    //领取奖励
                    result=mFairy.findPic(1151,233,1166,250,"pic red tip3.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word dcdl.png");
                        mFairy.onTap(0.8f,result,"切换当差队列分页",1000);

                        result=mFairy.findPic("word dcdl1.png");
                        mFairy.onTap(0.8f,result,314,308,319,313,"切换当差队列分页",1000);
                        return;
                    }

                    result=mFairy.findPic("word dcdl1.png");
                    mFairy.onTap(0.8f,result,1094,168,1103,180,"切换当差任务分页",1000);

                    //派遣随从
                    result=mFairy.findPic("word sc dispatch interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(835,299,885,476,"pic sc add.png");
                        mFairy.onTap(0.8f,result,"进入选择随从",1000);
                        if(result.sim<0.8f){
                            result=mFairy.findPic(611,500,696,552,"word start.png");
                            mFairy.onTap(0.8f,result,"开始",1000);
                        }
                        return;
                    }

                    //选择随从
                    result=mFairy.findPic("word sc select interface.png");
                    if(result.sim>0.8f){
                        //计算随从数量
                        int num=0;
                        for(int i=1;i<=4;i++){
                            result=mFairy.findPic(348+(i-1)*156,209,362+(i-1)*156,222,"pic select box.png");
                            if(result.sim<0.8f){
                                num=i-1;
                                break;
                            }
                            if(i==4)num=i;
                        }
                        if(num<3){
                            result=mFairy.findPic(327,186,365,224,"pic selected1.png");
                            if(result.sim<0.8f){
                                mFairy.onTap(948,122,955,133,"随从不足，无法继续，任务结束",1000);
                                util.close();
                                setTaskEnd();
                                return;
                            }
                        }


                        //查看有没选完
                        result=mFairy.findPic(348+3*156,209,362+3*156,222,"pic select box.png");
                        result1=mFairy.findPic(348+2*156,209,362+2*156,222,"pic select box.png");
                        if(result.sim>0.8f&&result1.sim>0.8f){
                            result=mFairy.findPic(327,186,365,224,"pic selected1.png");
                            if(result.sim<0.8f){
                                mFairy.onTap(342,202,348,209,"选择第一个随从",1000);
                                return;
                            }

                            result=mFairy.findPic(483,186,521,224,"pic selected1.png");
                            if(result.sim<0.8f){
                                mFairy.onTap(500,202,502,204,"选择第二个随从",1000);
                                return;
                            }

                            result=mFairy.findPic(639,187,675,222,"pic selected1.png");
                            if(result.sim<0.8f){
                                mFairy.onTap(656,202,659,206,"选择第三个随从",1000);
                                return;
                            }
                        }else{
                            result=mFairy.findPic(593,552,678,604,"word affirm.png");
                            mFairy.onTap(0.8f,result,"确定",1000);
                        }
                        return;
                    }

                    //可接任务次数0
                    result=mFairy.findPic("word sc zero.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word sc reset zero.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,1147,87,1155,99,"没有重置次数了，任务结束",1000);
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic(524,587,594,641,"word btn pj reset.png");
                        mFairy.onTap(0.8f,result,"重置任务",1000);
                        mFairy.onTap(0.8f,result,639,485,649,494,"确定重置",1000);
                    }else{
                        result=mFairy.findPic("word dc spend time.png");
                        mFairy.onTap(0.8f,result,"选中任务",1000);
                    }
                }
                overtime(20,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(625,95,678,250,"word hint duilie.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("队列已满，任务结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"当差");
    }

    @Override
    public void inOperation() throws Exception {
        //战斗中
        result=mFairy.findPic("word speed up.png");
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
