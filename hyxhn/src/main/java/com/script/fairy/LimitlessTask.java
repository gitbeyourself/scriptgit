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

public class LimitlessTask extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    Util util;
    List<String> taskList=null;
    int hour=0,min=0,colorNum=0,picCount=0,daze=0;
    int failureCount=0,successCount=0;
    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }

    @Override
    public void inOperation() throws Exception {
        hour=mFairy.dateHour();
        min=mFairy.dateMinute();
        //战斗场景
        result=mFairy.findPic(new String[]{"direction.png","direction1.png"});
        picCount=picCount(0.8f,result,"direction");
        if(result.sim>0.8f){
            mFairy.initDaze();
            daze=0;
            if(picCount<=3)mFairy.onTap(821,188,835,203,"锁定优先攻击",200);

            result=mFairy.findPic("word hand.png");
            picCount=picCount(0.8f,result,"manual");
            if(picCount==1){
                mFairy.onTap(0.8f,result,"打开自动",100);
            }

            result=mFairy.findPic("pic x1.png");
            picCount=picCount(0.8f,result,"x1");
            if(picCount==1){
                mFairy.onTap(0.8f,result,"开启2倍速",100);
            }
        }

        result=mFairy.findPic("pic word award.png");
        mFairy.onTap(0.8f,result,"获得奖励",200);

        //银两不足，结束当前任务
        result=mFairy.findPic("word money none1.png");
        if(result.sim>0.8f){
            LtLog.e(mFairy.getLineInfo(taskList.get(0)+"银两不足,结束当前任务"));
            setTaskEnd();
        }

        //计算作战胜利的次数
        result1=mFairy.findPic(new String[]{"pic victory.png","pic victory1.png"});
        picCount=picCount(0.8f,result1,"success");
        if(result1.sim>0.8f&&picCount==1){
            failureCount=0;
            successCount++;
            mFairy.onTap(0.8f,result1,"胜利次数="+successCount,200);
        }else{
            //计算作战失败的次数
            result1=mFairy.findPic("pic failure.png");
            picCount=picCount(0.8f,result1,"failure");
            if(result1.sim>0.8f&&picCount==1){
                failureCount++;
                mFairy.onTap(0.8f,result1,"失败次数="+failureCount,200);
            }
        }
        if(result1.sim<0.8f){
            result=mFairy.findPic(535,625,704,705,"tap.png");
            mFairy.onTap(0.8f,result,"点击屏幕继续",200);
        }

        //使用道具
        result=mFairy.findPic("word use2.png");
        if(result.sim>0.8){
            result=mFairy.findPic("word max.png");
            mFairy.onTap(0.8f,result,"最大",200);

            result=mFairy.findPic("word affirm use.png");
            mFairy.onTap(0.8f,result,"确认使用",200);
        }

        //确定和取消选择
        result=mFairy.findPic("word hint.png");
        if(result.sim>0.8){
            //不做处理
//            result=mFairy.findPic(400,306,870,396,new String[]{"word hint already finish.png"});
//            if(result.sim>0.8f){
//                return;
//            }

            //点击确定，退出，退出战斗，最后一环
            result=util.findPic(400,306,870,396,new String[]{"word weituo1.png","word jiequ.png","word exit.png",
                    "word wangluo.png","word hint exit fight.png","word hint no friend.png","word none over.png","word hint schedule.png"});
            if(result.sim>0.8f){
                result=mFairy.findPic(705,453,811,528,"word affirm.png");
                mFairy.onTap(0.8f,result,"点击确定",200);
                return;
            }

            result=mFairy.findPic(new String[]{"word cancel.png","word cancel1.png"});
            mFairy.onTap(0.8f,result,"点击取消",200);
        }

        result=mFairy.findPic("pic open task.png");
        mFairy.onTap(0.8f,result,"打开任务列表",200);

        //使用
        result=mFairy.findPic("word use.png");
        if(result.sim>0.8f){
            result1=util.findPic(972,489,1112,524,new String[]{"word use zixuanhe.png","word use zixuan.png","word use baoxiang.png"});
            if(result1.sim>0.8f) {
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(1111, 342, 1167, 403, "pic close1.png");
                    mFairy.onTap(0.8f, result, "不使用", 100);
                } else {
                    mFairy.onTap(0.8f, result, "使用", 100);
                }
            }
        }

        result=mFairy.findPic(new String[]{"pic word award.png","word get award.png"});
        mFairy.onTap(0.8f,result,"领取奖励",200);
    }

    //限时任务
    public void limit()throws Exception{
         new LimitlessTask(mFairy){
             @Override
             public void create() throws Exception {
                 taskList=new ArrayList<String>();
                 int week=mFairy.week();

                 //圈外来敌 每隔15分钟
                 if(AtFairyConfig.getOption("qwld").equals("1")){
                     taskList.add("qwld");
                 }

                 //妖盟试炼 每隔半小时
                 if(!AtFairyConfig.getOption("ymsl rank").equals("")){
                     taskList.add("ymsl");
                 }

                 //诛邪令 一 20:00-21:00
                 if(AtFairyConfig.getOption("zxl").equals("1")){
                     if(week==1){
                         taskList.add("zxl");
                     }
                 }


                 //妖祸降临 一二三六日 17:00-22:00
                 if(AtFairyConfig.getOption("yhjl").equals("1")){
                     if(week==1||week==2||week==3||week==6||week==7){
                         taskList.add("yhjl");
                     }
                 }

                 //拯救人质 五 20-21
                 if(AtFairyConfig.getOption("zjrz").equals("1")){
                     if(week==5){
                         taskList.add("zjrz");
                     }
                 }

                 //洗冤达人 六13-23:59
                 if(AtFairyConfig.getOption("xydr").equals("1")){
                     if(week==6){
                         taskList.add("xydr");
                     }
                 }

                 //谁才是真凶 六21-22
                 if(AtFairyConfig.getOption("scszx").equals("1")){
                     if(week==6){
                         taskList.add("scszx");
                     }
                 }

                 //决战妖帝 六/日 8-23
                 if(AtFairyConfig.getOption("jzyd").equals("1")){
                     if(week==6||week==7){
                         taskList.add("jzyd");
                     }
                 }

                 if(taskList.size()==0){
                     LtLog.e(mFairy.getLineInfo("没有任务要执行"));
                    setTaskEnd();
                    return;
                 }
                 util.close();
                 setTaskName(0);
             }

             @Override
             public void content_0() throws Exception {
                 if(taskList.size()==0){
                     LtLog.e(mFairy.getLineInfo("所有任务已执行完成"));
                     setTaskEnd();
                     return;
                 }
                 daze=failureCount=successCount=0;
                 LtLog.e(mFairy.getLineInfo("要执行的任务======"));
                 for (String task:taskList) {
                    LtLog.e(mFairy.getLineInfo(task));
                 }

                //诛邪令 20-21
                 if(taskList.contains("zxl")){
                     if(hour>=20&&hour<21){
                         limit_zxl();
                         taskList.remove("zxl");
                     }
                 }

                 //妖祸降临 一二三六日 17-22
                 if(taskList.contains("yhjl")){
                     if(hour>=17&&hour<22){
                        limit_yhjl();
                        taskList.remove("yhjl");
                        return;
                     }
                 }


                 //拯救人质 五 20-21
                 if(taskList.contains("zjrz")){
                     if(hour>=20&&hour<21){
                         limit_zjrz();
                         taskList.remove("zjrz");
                         return;
                     }
                 }

                 //决战妖帝 六/日 8-23
                 if(taskList.contains("jzyd")){
                     if(hour>=8&&hour<23){
                         if(min<30){
                             limit_jzyd();
                             return;
                         }
                     }
                 }

                 //洗冤达人 六13-23:59
                 if(taskList.contains("xydr")){
                     if(hour>=13&&hour<23&&min<59){
                         limit_xydr();
                         taskList.remove("xydr");
                         return;
                     }
                 }

                 //谁才是真凶 六21-22
                 if(taskList.contains("scszx")){
                     if(hour>=21&&hour<22){
                         limit_scszx();
                         taskList.remove("scszx");
                         return;
                     }
                 }


                 //圈外来敌 从八点起每隔十五分钟
                 if(taskList.contains("qwld")){
                     if(hour>=8&&hour<24){
                         if(min%15==0){
                             limit_qwld();
                             return;
                         }
                     }
                 }

                 //妖盟试炼 每隔半小时
                 if(taskList.contains("ymsl")){
                     if(min%30>=1&&min%30<14){
                         limit_ymsl();
                         return;
                     }
                 }
             }
         }.taskContent(mFairy,"限时任务");
    }

    //圈外来敌
    public void limit_qwld()throws Exception{
        new LimitlessTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                setTaskName(2);
                daze=0;
            }

            @Override
            public  void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret = util.mission("pic daily qwld.png", 0);
                if (ret == 1) {
                    setTaskName(3);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"点击回应对话",100);

                result=mFairy.findPic(535,625,704,705,"tap.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",200);

                result=mFairy.findPic( 670,652,790,707 ,"tap.png");
                mFairy.onTap(0.8f,result,"圈外来敌_胜利跳过",200);

                //主界面
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    //自动寻路
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        result=mFairy.findPic("word oppoent.png");
                        if(result.sim>0.7){
                            LtLog.e(mFairy.getLineInfo("等待黑狐娘娘挑选对手"));
                            daze=0;
                            mFairy.sleep(1000);
                            return;
                        }
                        //对决黑狐
                        result=mFairy.findPic(526,245,753,431,"pic qwld hhnn.png");
                        mFairy.onTap(0.8f,result,"对决黑狐",500);
                        if(result.sim<0.8f){
                            if(daze++>10){
                                setTaskName(0);
                                LtLog.e(mFairy.getLineInfo("圈外来敌重启超时，重启任务"));
                            }else{
                                mFairy.sleep(500);
                                LtLog.e(mFairy.getLineInfo("圈外来敌重启="+daze));
                            }
                        }
                    }

                    result=mFairy.findPic(932,303,1001,438,"word black fox.png");
                    mFairy.onTap(0.8f,result,"选择黑狐决斗",500);

                    if(min%15>2){
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy,"圈外来敌");
    }

    //妖盟试炼
    public void limit_ymsl()throws Exception{
        new LimitlessTask(mFairy){
            int rank=0;
            public void create(){
                rank=Integer.parseInt(AtFairyConfig.getOption("ymsl rank"));
            }
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=0;
               setTaskName(2);
            }

            //妖盟试炼
            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic daily ymsl.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word ymsl.png");
                    mFairy.onTap(0.8f,result1,"妖盟试炼",500);
                    switch(rank){
                        case 1:
                            //简单
                            result1=mFairy.findPic(1032,24,1097,511,"word ymsl jiandan.png");
                            break;
                        case 2:
                            //普通
                            result1=mFairy.findPic(1032,24,1097,511,"word ymsl putong.png");
                            break;
                        case 3:
                            //进阶
                            result1=mFairy.findPic(1032,24,1097,511,"word ymsl jinjie.png");
                            break;
                        case 4:
                            //困难
                            result1=mFairy.findPic(1032,24,1097,511,"word ymsl kunnan.png");
                            break;
                        case 5:
                            //噩梦
                            result1=mFairy.findPic(1032,24,1097,511,"word ymsl emeng.png");
                            break;
                        case 6:
                            //地狱
                            result1=mFairy.findPic(1032,24,1097,511,"word ymsl diyu.png");
                            break;
                        case 7:
                            //炼狱
                            result1=mFairy.findPic(1035,33,1101,510,"word ymsl lianyu.png");
                            break;
                    }
                    mFairy.onTap(0.8f,result1,"选择难度"+rank,200);
                }

                result=mFairy.findPic(535,625,704,705,"tap.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",200);

                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>10){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("妖盟试炼重启超时，重启任务"));
                        }else{
                            LtLog.e(mFairy.getLineInfo("妖盟试炼重启="+daze));
                        }
                        result=mFairy.findPic(257,146,1280,568,"pic duel.png");
                        mFairy.onTap(0.85f,result,"决斗",1000);
                    }

                    //误点-关闭
                    result=mFairy.findPic("word new system.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(753,0,1280,317,new String[]{"pic close1.png"});
                        mFairy.onTap(0.8f,result,"妖盟试炼_误点_新系统",500);
                    }

                    if(min%30>=14){
                        util.close("超过14分，妖盟按察使消失，结束妖盟试炼");
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy,"妖盟试炼");
    }

    //诛邪令
    public void limit_zxl()throws Exception{
        new LimitlessTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=0;
                setTaskName(2);
            }

            //诛邪令
            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic risk zxl.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f, result,"回应对话",500);

                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    if(hour>=21&&min>=30){
                        setTaskEnd();
                        LtLog.e(mFairy.getLineInfo("副本时间已结束，结束任务"));
                        return;
                    }

                    result=mFairy.findPic("word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                        mFairy.onTap(0.8f,result,"活动指引",200);
                        if(daze++>10){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("诛邪令重启超时，重启任务"));
                        }else{
                            LtLog.e(mFairy.getLineInfo("诛邪令重启="+daze));
                        }
                    }
                }

                result=mFairy.findPic(1012,568,1121,671,"word kaizhan.png");
                mFairy.onTap(0.8f,result,"开战",500);

                result=mFairy.findPic("word start.png");
                mFairy.onTap(0.8f,result,884,447,913,472,"选择一个buff",500);
                mFairy.onTap(0.8f,result,"开始",500);
            }
        }.taskContent(mFairy,"诛邪令");
    }

    //妖祸降临 34级
    public void limit_yhjl()throws Exception{
        new LimitlessTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=0;
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic risk yhjl.png",2);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
               mFairy.onTap(0.8f,result,"回应对话",200);

                result=mFairy.findPic(535,625,704,705,"tap.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",200);

                result=mFairy.findPic(748,652,790,707,"tap.png");
                mFairy.onTap(0.8f,result,"妖祸降临_胜利跳过",200);

                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                    mFairy.onTap(0.8f,result,"活动指引",200);

                    result=mFairy.findPic("word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>10){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("妖祸降临重启超时，重启任务"));
                        }else{
                            LtLog.e(mFairy.getLineInfo("妖祸降临炼重启="+daze));
                        }
                    }
                }

                result=mFairy.findPic(888,501,1012,617,"word kaizhan.png");
                mFairy.onTap(0.8f,result,"开战",200);
                picCount=picCount(0.8f,result,"fight");

                result=mFairy.findPic(1050,590,1275,710,"word chuzhan.png");
                mFairy.onTap(0.8f,result,"出战",200);
                int picCount1=picCount(0.8f,result,"fight1");
                if(picCount>=5||picCount1>=5){
                    LtLog.e(mFairy.getLineInfo("次数已经用完，结束任务"));
                    util.close();
                    setTaskEnd();
                    return;
                }


            }
        }.taskContent(mFairy,"妖祸降临");
    }

    //拯救人质 五 20-21 点击参加后 自动到达选择副本界面（已经选好），直接点击组队进入组队大厅，自动匹配或者点击申请
    public void limit_zjrz() throws Exception{
        new LimitlessTask(mFairy){
            int any=0;
            long dazeTime=0;
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=any=0;
                mFairy.initDaze();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word team.png");
                mFairy.onTap(0.8f,result,"切换队伍分页",200);

                //退出队伍
                result=mFairy.findPic("word team1.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("pic team box.png");
                    if(result1.sim>0.8f){
                        //寻找任务并且前往
                        int ret =util.mission("pic risk zjrz.png",2);
                        if (ret==1){
                            setTaskName(3);return;
                        }else {
                            setTaskEnd();return;
                        }
                    }else{
                        mFairy.onTap(171,311,178,321,"退队1",200);
                        mFairy.onTap(166,343,175,356,"退队2",500);
                    }
                }
                overtime(6,0);
            }

            @Override
            public void content_3() throws Exception {
                if(hour>=22){
                    LtLog.e(mFairy.getLineInfo("副本时间结束，拯救人质结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                //大厅界面
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>10){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("拯救人质重启超时，重启任务"));
                        }else{
                            LtLog.e(mFairy.getLineInfo("拯救人质重启="+daze));
                        }
                    }
                }

                //组队大厅
                result=mFairy.findPic("word team zu.png");
                if(result.sim>0.8f){
                    //自动匹配
                    result=mFairy.findPic("word team auto match1.png");
                    mFairy.onTap(0.8f,result,"申请",200);

                    //申请
                    result=mFairy.findPic(998,126,1129,589,"word team apply for.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"申请",200);
                    }else{
                        mFairy.touchDown(0,900,600);
                        mFairy.touchMove(900,200,500);
                        mFairy.touchUp(0);
                        any++;
                        if(any%3==1){
                            result=mFairy.findPic("word team refresh.png");
                            mFairy.onTap(0.8f,result,"刷新",200);
                        }
                    }
                }else{
                    result=mFairy.findPic("word team1.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic team box.png");
                        if(result.sim>0.8f){
                            //已经加入队伍
                        }
                    }
                }

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"回应对话",200);

                result=mFairy.findPic("word zu.png");
                mFairy.onTap(0.8f,result,"组队",500);

                result=mFairy.findPic(1050,590,1275,710,"word chuzhan.png");
                mFairy.onTap(0.8f,result,"出战",200);
            }

            //加入队伍，跟随队长
            @Override
            public void content_4() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"回应对话",200);

                result=mFairy.findPic("word zu.png");
                mFairy.onTap(0.8f,result,"组队",500);

                result=mFairy.findPic(1050,590,1275,710,"word chuzhan.png");
                mFairy.onTap(0.8f,result,"出战",500);

                //跟随队长 三分钟以上不动 被出队伍重新开始
                //主界面长时间不动，3分钟以上，退出队伍，重启任务
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f) {
                    result=mFairy.findPic("word team.png");
                    mFairy.onTap(0.8f,result,"切换到队伍分页",1000);

                    //被踢出队伍
                    result=mFairy.findPic("word team1.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word team back team.png");
                        mFairy.onTap(0.8f,result,"归队",500);

                        result=mFairy.findPic("word team box.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("被踢出队伍，重启任务"));
                            setTaskName(0);
                            return;
                        }
                    }

                    dazeTime=mFairy.dazeTime(580,635,656,680,0.8f,0,"255,255,255");
                    if(dazeTime>30){
                        LtLog.e(mFairy.getLineInfo("发呆时长="+dazeTime));
                        if(dazeTime>=60*3){
                            LtLog.e(mFairy.getLineInfo("发呆时长超过三分钟，重启任务"));
                            setTaskName(0);
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy,"解救人质");
    }

    //决战妖帝 六/日 8-23 每隔一小时出现，持续半小时
    public void limit_jzyd() throws  Exception{
        new LimitlessTask(mFairy){
            int dazeCount=0;
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=0;
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic risk jzyd.png",2);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word dialogue jzyd.png");
                    mFairy.onTap(0.8f,result1,"决战妖帝",500);
                }

                //有胜利跳过 胜利或失败回到大厅
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                    mFairy.onTap(0.8f,result,"活动指引",200);

                    result=mFairy.findPic("word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>10){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("决战妖帝重启超时，重启任务"));
                        }else{
                            mFairy.sleep(500);
                            LtLog.e(mFairy.getLineInfo("决战妖帝重启="+daze));
                        }
                    }
                }

                if(dazeCount>=4){
                    LtLog.e(mFairy.getLineInfo("妖帝通缉令不足"));
                    taskList.remove("jzyd");
                    setTaskEnd();
                }

                if(failureCount>=4){
                    LtLog.e(mFairy.getLineInfo("决战妖帝连续失败4次，任务结束，进行下一个任务"));
                    setTaskEnd();
                }

                result=mFairy.findPic("word team exit copy.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("谁才是真凶已完成，进行下一个任务"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"决战妖帝");
    }

    //洗冤达人 六13-23:59 点击参加后 自动到达选择副本界面（已经选好），直接点击组队进入组队大厅，自动匹配或者点击申请
    public void limit_xydr() throws Exception{
        new LimitlessTask(mFairy){
            int any=0;
            long dazeTime=0;
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=any=0;
                mFairy.initDaze();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word team.png");
                mFairy.onTap(0.8f,result,"切换队伍分页",200);

                //退出队伍
                result=mFairy.findPic("word team1.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("pic team box.png");
                    if(result1.sim>0.8f){
                        //寻找任务并且前往
                        int ret =util.mission("pic risk xydr.png",2);
                        if (ret==1){
                            setTaskName(3);return;
                        }else {
                            setTaskEnd();return;
                        }
                    }else{
                        mFairy.onTap(171,311,178,321,"退队1",200);
                        mFairy.onTap(166,343,175,356,"退队2",500);
                    }
                }
                overtime(6,0);
            }

            @Override
            public void content_3() throws Exception {
                if(hour<13){
                    LtLog.e(mFairy.getLineInfo("副本时间结束，洗冤达人结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }
                //大厅界面
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word auto.png");
                    if(result.sim>0.8){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>10){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("拯救人质重启超时，重启任务"));
                        }else{
                            LtLog.e(mFairy.getLineInfo("拯救人质重启="+daze));
                        }
                    }
                }

                //组队大厅
                result=mFairy.findPic("word team zu.png");
                if(result.sim>0.8f){
                    //自动匹配
                    result=mFairy.findPic("word team auto match1.png");
                    mFairy.onTap(0.8f,result,"申请",200);

                    //申请
                    result=mFairy.findPic(998,126,1129,589,"word team apply for.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"申请",200);
                    }else{
                        mFairy.touchDown(0,900,600);
                        mFairy.touchMove(900,200,500);
                        mFairy.touchUp(0);
                        any++;
                        if(any%3==1){
                            result=mFairy.findPic("word team refresh.png");
                            mFairy.onTap(0.8f,result,"刷新",200);
                        }
                    }
                }else{
                    result=mFairy.findPic("word team1.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic team box.png");
                        if(result.sim>0.8f){
                            //已经加入队伍
                            setTaskName(4);
                            LtLog.e(mFairy.getLineInfo("已经加入队伍"));
                            return;
                        }
                    }
                }
            }

            //加入队伍，跟随队长
            @Override
            public void content_4() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"回应对话",200);

                result=mFairy.findPic("word zu.png");
                mFairy.onTap(0.8f,result,"组队",500);

                result=mFairy.findPic(1050,590,1275,710,"word chuzhan.png");
                mFairy.onTap(0.8f,result,"出战",500);

                //跟随队长 三分钟以上不动 被出队伍重新开始
                //主界面长时间不动，3分钟以上，退出队伍，重启任务
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f) {
                    result=mFairy.findPic("word team.png");
                    mFairy.onTap(0.8f,result,"切换到队伍分页",1000);

                    //被踢出队伍
                    result=mFairy.findPic("word team1.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word team back team.png");
                        mFairy.onTap(0.8f,result,"归队",500);

                        result=mFairy.findPic("word team box.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("被踢出队伍，重启任务"));
                            setTaskName(0);
                            return;
                        }
                    }

                    dazeTime=mFairy.dazeTime(580,635,656,680,0.8f,0,"255,255,255");
                    if(dazeTime>30){
                        LtLog.e(mFairy.getLineInfo("发呆时长="+dazeTime));
                        if(dazeTime>=60*3){
                            LtLog.e(mFairy.getLineInfo("发呆时长超过三分钟，重启任务"));
                            setTaskName(0);
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy,"洗冤达人");
    }

    //谁才是真凶 六21-22
    public void limit_scszx() throws Exception{
        new LimitlessTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close("content_0回到大厅");
                daze=0;
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {

            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("pic risk scszx.png",2);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"回应对话",200);

                //执行副本中
                result=mFairy.findPic("word exit copy.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word huodong.png");
                    picCount=picCount(0.8f,result,"activity");
                    if(picCount%4==0){
                        mFairy.onTap(0.8f,result,"活动指引",200);
                    }

                    result=mFairy.findPic(230,115,1083,311,"pic duel.png");
                    mFairy.onTap(0.8f,result,"决斗",200);

                    result=mFairy.findPic(230,160,1083,311,"pic zhiren.png");
                    mFairy.onTap(0.8f,result,"指认凶手",200);

                    result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                    mFairy.onTap(0.8f,result,"点击回应对话",100);
                }else{
                    //寻找副本阶段
                    result=mFairy.findPic(1029,559,1135,664,"word kaizhan.png");
                    mFairy.onTap(0.8f,result,"开战",200);

                    result=mFairy.findPic(1050,590,1275,710,"word chuzhan.png");
                    mFairy.onTap(0.8f,result,"出战",200);

                    result=mFairy.findPic("pic main open.png");
                    if(result.sim>0.8f){
                        if(hour>=22){
                            LtLog.e(mFairy.getLineInfo("超过副本时间，任务结束"));
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("word auto.png");
                        if(result.sim>0.8){
                            daze=0;
                            LtLog.e(mFairy.getLineInfo("寻路中"));
                            mFairy.sleep(1000);
                        }else{
                            if(daze++>10){
                                setTaskName(0);
                                LtLog.e(mFairy.getLineInfo("谁才是真凶重启超时，重启任务"));
                            }else{
                                mFairy.sleep(500);
                                LtLog.e(mFairy.getLineInfo("谁才是真凶炼重启="+daze));
                            }
                        }
                    }
                }

                if(failureCount>=4){
                    LtLog.e(mFairy.getLineInfo("谁才是真凶失败次数过多，任务结束，进行下一个任务"));
                    setTaskEnd();
                }

                result=mFairy.findPic("word team exit copy.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("谁才是真凶已完成，进行下一个任务"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"谁才是真凶");
    }


}
