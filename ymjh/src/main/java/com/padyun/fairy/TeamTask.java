package com.padyun.fairy;

import android.nfc.tech.NfcA;
import android.test.LoaderTestCase;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends  TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    FindResult result1;
    Util util;
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        mFairy1 = ypFairy;
    }
    long daze=0;
    Integer header=0;//带队1 跟队0
    Integer teamNum=3;//队伍人数
    //副本任务 //先查看任务有没完成 前往组队目标 组满人前往
    public void team()throws Exception{
        new TeamTask(mFairy){
            List<String> taskList=new ArrayList();
            @Override
            public void create() throws Exception {
                int week=mFairy.week();
                //带队
                if(!AtFairyConfig.getOption("header").equals("")){
                    header=Integer.parseInt(AtFairyConfig.getOption("header"));
                }

                //队伍人数
                if(!AtFairyConfig.getOption("teamNum").equals("")){
                    teamNum=Integer.parseInt(AtFairyConfig.getOption("teamNum"));
                }

                //万里听风
                if(AtFairyConfig.getOption("wltf").equals("1")){
                    taskList.add("wltf");
                }

                //江湖纪事
                if(!AtFairyConfig.getOption("jhjs").equals("")&&!AtFairyConfig.getOption("jhjs").equals("0")){
                    taskList.add("jhjs");
                }

                //江湖行商 二四五六日
                if(AtFairyConfig.getOption("jhxs").equals("1")){
                    if(week==2||week==4||week==5||week==6||week==7){
                        taskList.add("jhxs");
                    }
                }

                //聚义平冤 二四五六日
                if(AtFairyConfig.getOption("jhxs").equals("1")){
                    if(week==2||week==4||week==5||week==6||week==7){
                        taskList.add("jhxs");
                    }
                }

                //弈中幻境 一三四六日
                if(AtFairyConfig.getOption("yzhj").equals("1")){
                    if(week==1||week==3||week==4||week==6||week==7){
                        taskList.add("yzhj");
                    }
                }

                //山珍海味 一三五六日
                if(AtFairyConfig.getOption("szhw").equals("1")){
                    if(week==1||week==3||week==5||week==6||week==7){
                        taskList.add("szhw");
                    }
                }
            }

            //初始化阶段
            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务做完，没有任务了"));
                    setTaskEnd();
                    return;
                }

                //万里听风
                if(taskList.get(0).equals("wltf")){
                    jh_wltf();
                    taskList.remove(0);
                    return;
                }

                //江湖纪事
                if(taskList.get(0).equals("jhjs")){
                    jh_jhjs();
                    taskList.remove(0);
                    return;
                }

                //江湖行商
                if(taskList.get(0).equals("jhxs")){
                    hd_jhxs();
                    taskList.remove(0);
                    return;
                }

                //弈中幻境
                if(taskList.get(0).equals("yzhj")){
                    hd_yzhj();
                    taskList.remove(0);
                    return;
                }

                //聚义平冤
                if(taskList.get(0).equals("jypy")){
                    hd_jypy();
                    taskList.remove(0);
                    return;
                }

                //山珍海味
                if(taskList.get(0).equals("szhw")){
                    hd_szhw();
                    taskList.remove(0);
                    return;
                }
            }
        }.taskContent(mFairy,"副本任务");
    }

    //万里听风
    public void jh_wltf()throws Exception{
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close();
               // daze=util.initDaze();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                int res=util.mission("pic task jh wanlitingfeng.png","jianghu","pic exit copy.png");
                if (res==1){
                    util.task("wanli tingfeng");
                    daze=util.initDaze();
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_2() throws Exception {
                daze = mFairy.mMatTime(1217,4,59,11, 0.9f);


                super.content_2();

                if(daze>5){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task yi.png"});
                    mFairy.onTap(0.8f,result,"点击副本指引",1000);
                    if (result.sim < 0.8f){
                        result=mFairy.findPic("word task jh.png");
                        mFairy.onTap(0.65f,result,"切换江湖分页",1000);

                        result=mFairy.findPic("tanji.png");
                        mFairy.onTap(0.75f,result,"tanji",1000);
                    }

                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(904,435,955,490,"pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);

                    }

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"选择对话",1000);

                    result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                    mFairy.onTap(0.8f,result,1235,34,1243,43,"关闭答题",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                    }else{
                        setTaskName(1);
                    }
                    return;
                }

            }
        }.taskContent(mFairy,"万里听风");
    }

    //江湖纪事
    public void jh_jhjs()throws Exception{
        new TeamTask(mFairy){
            String detailCopy="xianyugang";
            int hard=1;//难度
            Integer need=3;//需求(放弃 贪婪 需求)
            @Override
            public void create() throws Exception {
                detailCopy=AtFairyConfig.getOption("jhjs").split("-")[0];
                if(detailCopy.equals("xyg"))detailCopy="xianyugang";
                if(detailCopy.equals("wjsz"))detailCopy="wanjie shanzhuang";
                if(detailCopy.equals("wrg"))detailCopy="wurengu";

                hard=Integer.parseInt(AtFairyConfig.getOption("jhjs").split("-")[1]);

                //物品需求
                if(!AtFairyConfig.getOption("need").equals("")){
                    need=Integer.parseInt(AtFairyConfig.getOption("need"));
                }
            }

            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }


            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                int ret =util.mission("pic task jh jianghujishi.png","jianghu","pic exit copy.png");
                if (ret==1){
                    daze=util.initDaze();
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_2() throws Exception {
                overtime(15,0);
                //江湖纪事界面 选择任务
                result=mFairy.findPic("word jhjs interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(1145,190+(hard-1)*97,1190,218+(hard-1)*97,"pic jhjs hard.png");
                    if(picCount(0.8f,result,"jsjs hard")==1)initRan();//初始化滑动
                    if(result.sim>0.8f){
                        //找任务
                        result=mFairy.findPic(218,163,885,242,"word jhjs "+detailCopy+".png");
                        if(result.sim>0.8f){
                            //满足自动战斗条件 then 切换队伍目标
                            result1=mFairy.findPic(result.x+138,result.y-15,result.x+205,result.y+33,"pic jhjs can auto.png");
                            if(result1.sim>0.8f) {
                                mFairy.onTap(0.8f,result,result.x+94,result.y+384,result.x+114,result.y+399,"前往",1000);
                                util.task("jianghu jishi",detailCopy+" "+hard);//切换队伍目标
                                daze=util.initDaze();
                                setTaskName(3);
                                return;
                            }

                            //不满足自动战斗条件 then 任务结束
                            result1=mFairy.findPic(result.x+138,result.y-15,result.x+205,result.y+33,"pic jhjs cant auto.png");
                            if(result1.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("无法自动战斗，任务结束"));
                                util.close();
                                setTaskEnd();
                                return;
                            }
                        }else{
                            //没找到 右滑动
                            LtLog.e(mFairy.getLineInfo(detailCopy+"没找到，右滑动一次"));
                            mFairy.ranSwipe(500,580,300,580,1000,1500l,1);
                        }
                    }else{
                        switch (hard){
                            case 1:
                                mFairy.onTap(1118,169,1124,174,"切换新秀分页",1000);
                                break;
                            case 2:
                                mFairy.onTap(1118,264,1122,272,"切换侠士分页",1000);
                                break;
                            case 3:
                                mFairy.onTap(1114,347,1121,354,"切换宗师分页",1000);
                                break;
                        }
                    }
                }
            }

            @Override
            public void content_3() throws Exception {
                super.content_2();
                //对话选择难度
                result=mFairy.findPic(1015,441,1093,481,"word btn dialogue xinxiu.png");
                if(result.sim>0.8f){
                    if(hard==1)mFairy.onTap(1047,459,1053,466,"对话-新秀",2000);
                    if(hard==2)mFairy.onTap(1007,382,1013,389,"对话-侠士",2000);
                    if(hard==3)mFairy.onTap(1001,311,1008,318,"对话-宗师",2000);
                    return;
                }

                //主页界面
                result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){
                    //一键操作(放弃，贪婪，需求)
                    result=mFairy.findPic("word a key operate.png");
                    if(result.sim>0.8f){
                        if(need==1)mFairy.onTap(1099,180,1112,191,"放弃",1000);
                        if(need==2)mFairy.onTap(1169,178,1178,188,"贪婪",1000);
                        if(need==3)mFairy.onTap(1235,179,1242,188,"需求",1000);
                        mFairy.onTap(1247,31,1252,39,"关闭 一键操作界面",1000);
                        daze=0;
                    }
                }

                result=mFairy.findPic("word jhjs wait affirm.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("等待队友确认"));
                    daze=util.dazeTime();
                }

                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(904,435,955,490,"pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);

                    result=mFairy.findMultiColor(933,188,956,213,0.9f,"166,167,167",
                            "0|3|162,163,163&0|6|155,156,157&0|9|155,156,158&0|12|158,159,161&4|0|169,170,170&9|0|156,158,159&4|3|164,164,164&11|3|163,164,164&6|6|172,172,172");
                    mFairy.onTap(0.85f,result,1000,200,1006,206,"任务通过，退出副本",1000);
                    mFairy.onTap(0.85f,result,847,507,852,514,"确定退出副本",1000);
                }

                if(daze>5){
                    result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png"});
                    mFairy.onTap(0.7f,result,"副本指引",Sleep);
                }

                if(daze>45){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
                result=mFairy.findPic("word map new.png");
                mFairy.onTap(0.8f,result,1231,34,1243,48,"误点出现的地图关闭",Sleep);

            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint need all.png");
                mFairy.onTap(0.8f,result,848,504,859,517,"需求所有",1000);

                result=mFairy.findPic("word hint call friend.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,418,508,424,515,"取消",1000);
                    setTaskName(1);
                    return;
                }

                result=mFairy.findPic("word hitn back copy.png");
                mFairy.onTap(0.8f,result,"回到副本",10000);
                super.inOperation();
            }

            public void initRan()throws Exception{
                LtLog.e(mFairy.getLineInfo("初始化滑动"));
                for(int i=1;i<=4;i++){
                    result=mFairy.findPic(new String[]{"word jhjs xianyugang.png"});
                    if(result.sim>0.8f)break;
                    mFairy.ranSwipe(253,580,931,580,500,1500l,1);
                }
                LtLog.e(mFairy.getLineInfo("初始化滑动完成"));
            }
        }.taskContent(mFairy,"江湖纪事");
    }

    //江湖行商
    public void hd_jhxs()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }

            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                int ret =util.mission("pic task hd jianghuxingshang.png","hangdang","pic exit copy.png");
                if (ret==1){
                    util.task("hangdang wanfa","jianghu xingshang");
                    daze=util.initDaze();
                    setTaskName(2);
                }else {
                    setTaskEnd();
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                super.content_2();
                //自动寻路
                result1=mFairy.findPic("word way.png");
                if(result1.sim>0.8f){
                    result=mFairy.findMultiColor(1133,280,1170,317,0.9f,"212,212,216"
                            ,"3|0|216,217,222&7|0|215,216,220&9|2|215,217,220&0|7|216,218,220&-1|11|216,218,220&-1|15|217,219,224&0|19|220,225,232&9|15|216,217,220&11|15|215,217,220");
                    mFairy.onTap(0.85f,result,"上马",1000);

                    result=mFairy.findMultiColor(1210,278,1251,316,0.9f,"213,208,206",
                            "0|1|212,208,205&-1|3|212,208,205&-3|5|212,208,206&-6|8|213,208,206&-9|9|214,209,207&-14|5|162,153,146&-16|1|141,130,122&-12|-3|143,132,125&-12|1|212,207,204");
                    mFairy.onTap(0.85f,result,"疾跑",1000);
                }else{
                    result=mFairy.findPic("word btn a key hand in.png");
                    mFairy.onTap(0.8f,result,"一键上缴",1000);

                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task walk.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                        if(result.sim>0.8f)return;
                    }

                    //世界地图
                    result=mFairy.findPic("pic world map.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn all clear.png");
                        mFairy.onTap(0.8f,result,"清除标记",1000);

                        List<FindResult> list=mFairy.findPic(94,72,1250,610,0.85f,"pic jhxs world goal.png");
                        if(list.size()!=0){
                            int size=list.size();
                            size=new Random().nextInt(size-1);//随机前往一个地方
                            result=list.get(size);
                            mFairy.onTap(0.85f,result,"world 选择下一个交易点",1000);
                        }
                    }

                    //区域地图
                    result1=mFairy.findPic("pic area map.png");
                    if(result1.sim>0.8f){
                        result=mFairy.findPic(94,35,1250,610, "pic jhxs area goal.png");
                        mFairy.onTap(0.85f,result,"world 选择下一个交易点",1000);
                        if(result.sim<0.85f)mFairy.onTap(0.8f,result1,"返回世界地图",1000);
                    }

                    //等待队友确认
                    result=mFairy.findPic("word jhxs wait.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("等待队友确认"));
                        result=mFairy.findPic("word btn affirm join.png");
                        mFairy.onTap(0.8f,result,"确认参与",1000);
                        daze=util.initDaze();
                        return;
                    }

                    //对话选择
                    result=mFairy.findPic("pic dialogue select.png");
                    if(result.sim>0.8f){
                        //等待组队界面
                        result1=mFairy.findPic("word jhxs.png");
                        if(result1.sim>0.8f){
                            result=mFairy.findPic(414,471,546,513,"word btn speedy form.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,971,690,982,699,"关闭",500);
                                mFairy.onTap(0.8f,result,1234,22,1247,36,"关闭对话",500);
                                setTaskName(1);
                            }

                            if(daze>15){
                                result=mFairy.findPic("word btn team system.png");
                                mFairy.onTap(0.8f,result,"打开队伍系统",1000);
                                return;
                            }

                            result=mFairy.findPic("word btn affirm start.png");
                            mFairy.onTap(0.8f,result,"确认发起",1000);

                            int size=mFairy.findPic(409,239,439,334,0.8f,"pic copy condition.png").size();
                            if(size==3){
                                result=mFairy.findPic("word btn affirm join.png");
                                mFairy.onTap(0.8f,result,"确认参与",1000);
                            }
                        }else{
                            result=mFairy.findPic("word dialogue join walk.png");
                            mFairy.onTap(0.8f,result,"参与行商",1000);

                            if(result.sim<0.8f){
                                daze=6;
                                mFairy.onTap(1236,25,1246,36,"关闭对话选择",1500);
                                return;
                            }
                        }
                    }

                    //江湖行商 购买和出售 界面
                    result=mFairy.findPic("word jhxs interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(788,551,887,615,"word btn buy.png");
                        if(result.sim>0.8f){
                            for(int i=1;i<=7;i++){
                                mFairy.onTap(0.8f,result,978,452,990,464,"数量+",300);
                            }
                        }
                        mFairy.onTap(0.8f,result,789,551,867,603,"购买",1000);
                        mFairy.onTap(0.8f,result,1112,61,1124,75,"关闭行商界面",1000);

                        result=mFairy.findPic("word btn sell.png");
                        mFairy.onTap(0.8f,result,"出售",1000);
                        mFairy.onTap(0.8f,result,1112,61,1124,75,"关闭行商界面",1000);
                    }

                    if(daze>6){
                        result=mFairy.findPic("pic btn dialogue.png");
                        mFairy.onTap(0.8f,result,"对话",1000);
                    }
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint huodan.png");
                int picCount=picCount(0.8f,result,"tongbi");
                if(result.sim>0.8f){
                    if(picCount>=5){
                        mFairy.onTap(0.8f,result,929,167,936,174,"铜币不足，任务结束",1000);
                        mFairy.onTap(0.8f,result,1236,24,1244,34,"铜币不足，关闭对话",1000);
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(636,493,644,504,"3w铜币购买货单",1000);
                    return;
                }

                result=mFairy.findPic("word hint leave protect.png");
                mFairy.onTap(0.8f,result,843,509,848,518,"离开护镖范围",1000);

                result=mFairy.findPic(616,280,702,337,"word hint deal.png");
                mFairy.onTap(0.8f,result,848,506,857,517,"确定下一个交易点",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"江湖行商");
    }

    //弈中幻境
    public void hd_yzhj()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }


            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                int ret =util.mission("pic task hd yizhonghuanjing.png","hangdang","pic exit copy.png");
                if (ret==1){
                    util.task("hangdang wanfa","yizhong huanjing");
                    daze=util.initDaze();
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                super.content_2();
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task tian.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                    }

                    result=mFairy.findPic("word byhj.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(418,468,545,517,"word btn team system.png");
                        mFairy.onTap(0.8f,result,792,488,795,494,"确认参与",1000);
                    }else{
                        result=mFairy.findPic("pic btn dialogue.png");
                        mFairy.onTap(0.8f,result,"对话",1000);

                        result=mFairy.findPic("pic dialogue select.png");
                        mFairy.onTap(0.8f,result,"选择对话",2000);
                    }

                    result=mFairy.findPic("pic random pick.png");
                    mFairy.onTap(0.8f,result,"掷骰子",1000);
                    if(result.sim>0.8f)daze=util.initDaze();

                    result=mFairy.findPic("pic hand pick.png");
                    mFairy.onTap(0.8f,result,"推开",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                        daze=util.initDaze();
                    }else{
                        setTaskName(1);
                    }
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word byhj.png");
                if(result.sim>0.8f)return;

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"弈中幻境");
    }

    //山珍海味
    public void hd_szhw()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }


            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                int ret =util.mission("pic task hd shanzhenhaiwei.png","hangdang","pic exit copy.png");
                if (ret==1){
                    daze=util.initDaze();
                    util.task("hangdang wanfa","shanzhen haiwei");
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word fight.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic up tip.png");
                    mFairy.onTap(0.8f,result,1133,536,1141,544,"自动战斗-普攻",200);
                    return;
                }

                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn a key call.png");
                    mFairy.onTap(0.8f,result,"一键喊话",1000);

                    result=mFairy.findPic("word team apply list.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn invite.png");
                        mFairy.onTap(0.8f,result,"邀请",1000);
                    }else{
                        daze=util.initDaze();
                        LtLog.e(mFairy.getLineInfo("组队中"));

                        result=mFairy.findPic("word btn auto match1.png");
                        mFairy.onTap(0.8f,result,"自动匹配",1000);

                        int colorNum=mFairy.getColorNum(217,550,244,581,0.9f,0,"197,48,48");
                        if(colorNum>100){
                            mFairy.onTap(173,584,175,588,"打开申请列表",1000);
                            return;
                        }

                        switch (teamNum){
                            case 3:
                                result=mFairy.findPic(606,332,670,394,"pic team invite.png");
                                break;
                            case 4:
                                result=mFairy.findPic(818,336,883,393,"pic team invite.png");
                                break;
                            case 5:
                                result=mFairy.findPic(1027,337,1087,392,"pic team invite.png");
                                break;
                        }
                        if(result.sim<0.8f){
                            mFairy.onTap(1114,62,1123,72,"组满"+teamNum+"人，关闭队伍界面",1000);
                            isFind=false;
                            setTaskName(3);
                            return;
                        }
                    }
                }

                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);

                        result=mFairy.findPic(47,146,86,376,"word task zhi.png");
                        LtLog.e(mFairy.getLineInfo(0.8f,result,"等待队友完成"));
                        if(result.sim>0.8f)daze=util.initDaze();
                    }

                    result=mFairy.findPic("word szhw.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(418,468,545,517,"word btn speedy form.png");
                        if(result.sim>0.8f)setTaskName(1);

                        result=mFairy.findPic(411,242,435,268,"pic copy condition.png");
                        if(result.sim<0.8f){
                            result=mFairy.findPic(418,468,545,517,"word btn team system.png");
                            mFairy.onTap(0.8f,result,"打开队伍系统",1000);
                            return;
                        }

                        result=mFairy.findPic(731,468,857,517,"word btn affirm start.png");
                        mFairy.onTap(0.8f,result,"确认发起",1000);

                        result=mFairy.findPic(731,468,857,517,"word btn affirm join.png");
                        mFairy.onTap(0.8f,result,"确认参与",1000);
                        if(result.sim>0.8f)daze=util.initDaze();
                    }

                    result=mFairy.findPic("word pick ing.png");
                    if(result.sim>0.8f){
                        daze=util.initDaze();
                        LtLog.e(mFairy.getLineInfo("采集中"));
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
                            LtLog.e(mFairy.getLineInfo("拼图"));
                        }
                    }

                    result=mFairy.findPic(new String[]{"pic guide jsb.png","pic szhw sort.png"});
                    mFairy.onTap(0.8f,result,1237,25,1245,34,"关闭诗词排序",1000);

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"选择对话",1000);

                    result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                    mFairy.onTap(0.8f,result,1235,34,1243,43,"关闭答题",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                        daze=util.initDaze();
                    }else{
                        setTaskName(1);
                    }
                    return;
                }
            }

            boolean isFind=true;
            @Override
            public void content_3()throws Exception{
                result=mFairy.findPic("word dialogue szhw.png");
                mFairy.onTap(0.8f,result,"对话-山珍海味",2000);
                if(result.sim>0.8f){
                    setTaskName(2);
                    daze=util.initDaze();
                    return;
                }

                result=mFairy.findPic("word way.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("寻路中"));
                    return;
                }

                result=mFairy.findPic("pic up tip.png");
                mFairy.onTap(0.8f,result,1216,51,1223,57,"打开地图",3000);

                //区域地图
                result=mFairy.findPic("pic area map.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic map open.png");
                    mFairy.onTap(0.8f,result,"展开",1000);

                    result=mFairy.findPic("word map task.png");
                    mFairy.onTap(0.8f,result,"切换任务分页",1000);

                    result=mFairy.findPic("word map task page.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic map open detail.png");
                        mFairy.onTap(0.8f,result,"展开更多",1000);

                        result=mFairy.findPic(248,409,355,658,"word map szhw.png");
                        mFairy.onTap(0.8f,result,"点击前往",1000);
                        mFairy.onTap(0.8f,result,"点击前往",1000);
                        mFairy.onTap(0.8f,result,1229,36,1242,47,"关闭地图",1000);
                        if(result.sim>0.8f)isFind=true;
                    }
                }

                if(isFind){
                    result=mFairy.findPic("pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);
                }

                result=mFairy.findPic("pic world map.png");
                mFairy.onTap(0.8f,result,"返回区域地图",1000);
                overtime(10,2);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word szhw.png");
                if(result.sim>0.8f)return;

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖页面",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"山珍海味");
    }

    //聚义平冤
    public void hd_jypy()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }


            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                int ret =util.mission("pic task hd juyipingyuan.png","hangdang","pic exit copy.png");
                if (ret==1){
                    util.task("hangdang wanfa","juyi pingyuan");
                    daze=util.initDaze();
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                super.content_2();
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task yi.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                    }

                    result=mFairy.findPic(902,432,963,494,"pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"选择对话",1000);

                    result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                    mFairy.onTap(0.8f,result,1235,34,1243,43,"关闭答题",1000);

                    result=mFairy.findPic("word byhj.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(418,468,545,517,"word btn speedy form.png");
                        if(result.sim>0.8f)setTaskName(1);

                        result=mFairy.findPic(418,468,545,517,"word btn team system.png");
                        mFairy.onTap(0.8f,result,792,488,795,494,"确认发起/参与",1000);
                    }
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                    }else{
                        setTaskName(1);
                    }
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"聚义平冤");
    }

    //悬赏的行当

    //万里听风
    public void xs_wltf()throws Exception{
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close();
                daze=util.initDaze();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                util.task("wanli tingfeng");
                daze=util.initDaze();
                setTaskName(2);
            }

            @Override
            public void content_2() throws Exception {
                super.content_2();
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(904,435,955,490,"pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);

                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task yi.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                    }

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"选择对话",1000);

                    result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                    mFairy.onTap(0.8f,result,1235,34,1243,43,"关闭答题",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                    }else{
                        setTaskName(1);
                    }
                    return;
                }

            }
        }.taskContent(mFairy,"万里听风");
    }

    //江湖行商
    public void xs_jhxs()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }

            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                super.content_1();
                result=mFairy.findPic("pic reward interface.png");
                if(result.sim>0.8) {
                    result=mFairy.findPic("word reward head jhxs.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(320,487,405,531,"word btn go.png");
                        mFairy.onTap(0.8f,result,"前往",1000);
                        if(result.sim>0.8f){
                            util.task("hangdang wanfa","jianghu xingshang");
                            setTaskName(2);
                            return;
                        }
                    }
                    if(overtime(10,0)){
                        LtLog.e(mFairy.getLineInfo("江湖行商执行完成一次"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    overtime(10,0);
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                super.content_2();
                //自动寻路
                result1=mFairy.findPic("word way.png");
                if(result1.sim>0.8f){
                    result=mFairy.findMultiColor(1133,280,1170,317,0.9f,"212,212,216"
                            ,"3|0|216,217,222&7|0|215,216,220&9|2|215,217,220&0|7|216,218,220&-1|11|216,218,220&-1|15|217,219,224&0|19|220,225,232&9|15|216,217,220&11|15|215,217,220");
                    mFairy.onTap(0.85f,result,"上马",1000);

                    result=mFairy.findMultiColor(1210,278,1251,316,0.9f,"213,208,206",
                            "0|1|212,208,205&-1|3|212,208,205&-3|5|212,208,206&-6|8|213,208,206&-9|9|214,209,207&-14|5|162,153,146&-16|1|141,130,122&-12|-3|143,132,125&-12|1|212,207,204");
                    mFairy.onTap(0.85f,result,"疾跑",1000);
                }else{
                    result=mFairy.findPic("word btn a key hand in.png");
                    mFairy.onTap(0.8f,result,"一键上缴",1000);

                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task walk.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                        if(result.sim>0.8f)return;
                    }

                    //世界地图
                    result=mFairy.findPic("pic world map.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn all clear.png");
                        mFairy.onTap(0.8f,result,"清除标记",1000);

                        List<FindResult> list=mFairy.findPic(94,72,1250,610,0.85f,"pic jhxs world goal.png");
                        if(list.size()!=0){
                            int size=list.size();
                            size=new Random().nextInt(size-1);//随机前往一个地方
                            result=list.get(size);
                            mFairy.onTap(0.85f,result,"world 选择下一个交易点",1000);
                        }
                    }

                    //区域地图
                    result1=mFairy.findPic("pic area map.png");
                    if(result1.sim>0.8f){
                        result=mFairy.findPic(94,35,1250,610, "pic jhxs area goal.png");
                        mFairy.onTap(0.85f,result,"world 选择下一个交易点",1000);
                        if(result.sim<0.85f)mFairy.onTap(0.8f,result1,"返回世界地图",1000);
                    }

                    //等待队友确认
                    result=mFairy.findPic("word jhxs wait.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("等待队友确认"));
                        result=mFairy.findPic("word btn affirm join.png");
                        mFairy.onTap(0.8f,result,"确认参与",1000);
                        daze=util.initDaze();
                        return;
                    }

                    //对话选择
                    result=mFairy.findPic("pic dialogue select.png");
                    if(result.sim>0.8f){
                        //等待组队界面
                        result1=mFairy.findPic("word jhxs.png");
                        if(result1.sim>0.8f){
                            result=mFairy.findPic(414,471,546,513,"word btn speedy form.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,971,690,982,699,"关闭",500);
                                mFairy.onTap(0.8f,result,1234,22,1247,36,"关闭对话",500);
                                setTaskName(1);
                            }

                            if(daze>15){
                                result=mFairy.findPic("word btn team system.png");
                                mFairy.onTap(0.8f,result,"打开队伍系统",1000);
                                return;
                            }

                            result=mFairy.findPic("word btn affirm start.png");
                            mFairy.onTap(0.8f,result,"确认发起",1000);

                            int size=mFairy.findPic(409,239,439,334,0.8f,"pic copy condition.png").size();
                            if(size==3){
                                result=mFairy.findPic("word btn affirm join.png");
                                mFairy.onTap(0.8f,result,"确认参与",1000);
                            }
                        }else{
                            result=mFairy.findPic("word dialogue join walk.png");
                            mFairy.onTap(0.8f,result,"参与行商",1000);

                            if(result.sim<0.8f){
                                daze=6;
                                mFairy.onTap(1236,25,1246,36,"关闭对话选择",1500);
                                return;
                            }
                        }
                    }

                    //江湖行商 购买和出售 界面
                    result=mFairy.findPic("word jhxs interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(789,551,867,603,"word btn buy.png");
                        if(result.sim>0.8f){
                            for(int i=1;i<=7;i++){
                                mFairy.onTap(0.8f,result,978,452,990,464,"数量+",300);
                            }
                        }
                        mFairy.onTap(0.8f,result,789,551,867,603,"购买",1000);
                        mFairy.onTap(0.8f,result,1112,61,1124,75,"关闭行商界面",1000);

                        result=mFairy.findPic("word btn sell.png");
                        mFairy.onTap(0.8f,result,"出售",1000);
                        mFairy.onTap(0.8f,result,1112,61,1124,75,"关闭行商界面",1000);
                    }

                    if(daze>6){
                        result=mFairy.findPic("pic btn dialogue.png");
                        mFairy.onTap(0.8f,result,"对话",1000);
                    }
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint huodan.png");
                int picCount=picCount(0.8f,result,"tongbi");
                if(result.sim>0.8f){
                    if(picCount>=5){
                        mFairy.onTap(0.8f,result,929,167,936,174,"铜币不足，任务结束",1000);
                        mFairy.onTap(0.8f,result,1236,24,1244,34,"铜币不足，关闭对话",1000);
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(636,493,644,504,"3w铜币购买货单",1000);
                    return;
                }

                result=mFairy.findPic("word hint leave protect.png");
                mFairy.onTap(0.8f,result,843,509,848,518,"离开护镖范围",1000);

                result=mFairy.findPic(616,280,702,337,"word hint deal.png");
                mFairy.onTap(0.8f,result,848,506,857,517,"确定下一个交易点",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"江湖行商");
    }

    //弈中幻境
    public void xs_yzhj()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }

            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                super.content_1();
                result=mFairy.findPic("pic reward interface.png");
                if(result.sim>0.8) {
                    result=mFairy.findPic("word reward head yzhj.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(320,487,405,531,"word btn go.png");
                        mFairy.onTap(0.8f,result,"前往",1000);
                        if(result.sim>0.8f){
                            util.task("hangdang wanfa","yizhong huanjing");
                            setTaskName(2);
                            daze=util.initDaze();
                            return;
                        }
                    }
                    if(overtime(10,0)){
                        LtLog.e(mFairy.getLineInfo("弈中幻境执行完成一次"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    overtime(10,0);
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                super.content_2();
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task tian.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                    }

                    result=mFairy.findPic("word byhj.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(418,468,545,517,"word btn team system.png");
                        mFairy.onTap(0.8f,result,792,488,795,494,"确认参与",1000);
                        if(result.sim>0.8f)daze=util.initDaze();
                    }else{
                        result=mFairy.findPic("pic btn dialogue.png");
                        mFairy.onTap(0.8f,result,"对话",1000);

                        result=mFairy.findPic("pic dialogue select.png");
                        mFairy.onTap(0.8f,result,"选择对话",2000);
                    }

                    result=mFairy.findPic("pic random pick.png");
                    mFairy.onTap(0.8f,result,"掷骰子",1000);
                    if(result.sim>0.8f)daze=util.initDaze();

                    result=mFairy.findPic("pic hand pick.png");
                    mFairy.onTap(0.8f,result,"推开",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                        daze=util.initDaze();
                    }else{
                        setTaskName(1);
                    }
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word byhj.png");
                if(result.sim>0.8f)return;

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖分页",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"弈中幻境");
    }

    //山珍海味
    public void xs_szhw()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }


            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                super.content_1();
                result=mFairy.findPic("pic reward interface.png");
                if(result.sim>0.8) {
                    result=mFairy.findPic("word reward head szhw.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(320,487,405,531,"word btn go.png");
                        mFairy.onTap(0.8f,result,"前往",1000);
                        if(result.sim>0.8f){
                            util.task("hangdang wanfa","shanzhen haiwei");
                            setTaskName(2);
                            return;
                        }
                    }
                    if(overtime(10,0)){
                        LtLog.e(mFairy.getLineInfo("山珍海味执行完成一次"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    overtime(10,0);
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word fight.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic up tip.png");
                    mFairy.onTap(0.8f,result,1133,536,1141,544,"自动战斗-普攻",200);
                    return;
                }

                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn a key call.png");
                    mFairy.onTap(0.8f,result,"一键喊话",1000);

                    result=mFairy.findPic("word team apply list.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn invite.png");
                        mFairy.onTap(0.8f,result,"邀请",1000);
                    }else{
                        daze=util.initDaze();
                        LtLog.e(mFairy.getLineInfo("组队中"));

                        result=mFairy.findPic("word btn auto match1.png");
                        mFairy.onTap(0.8f,result,"自动匹配",1000);

                        int colorNum=mFairy.getColorNum(217,550,244,581,0.9f,0,"197,48,48");
                        if(colorNum>100){
                            mFairy.onTap(173,584,175,588,"打开申请列表",1000);
                            return;
                        }

                        switch (teamNum){
                            case 3:
                                result=mFairy.findPic(606,332,670,394,"pic team invite.png");
                                break;
                            case 4:
                                result=mFairy.findPic(818,336,883,393,"pic team invite.png");
                                break;
                            case 5:
                                result=mFairy.findPic(1027,337,1087,392,"pic team invite.png");
                                break;
                        }
                        if(result.sim<0.8f){
                            mFairy.onTap(1114,62,1123,72,"组满"+teamNum+"人，关闭队伍界面",1000);
                            isFind=false;
                            setTaskName(3);
                            return;
                        }
                    }
                }

                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);

                        result=mFairy.findPic(47,146,86,376,"word task zhi.png");
                        LtLog.e(mFairy.getLineInfo(0.8f,result,"等待队友完成"));
                        if(result.sim>0.8f)daze=util.initDaze();
                    }

                    result=mFairy.findPic("word szhw.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(418,468,545,517,"word btn speedy form.png");
                        if(result.sim>0.8f)setTaskName(1);

                        result=mFairy.findPic(411,242,435,268,"pic copy condition.png");
                        if(result.sim<0.8f){
                            result=mFairy.findPic(418,468,545,517,"word btn team system.png");
                            mFairy.onTap(0.8f,result,"打开队伍系统",1000);
                            return;
                        }

                        result=mFairy.findPic(731,468,857,517,"word btn affirm start.png");
                        mFairy.onTap(0.8f,result,"确认发起",1000);

                        result=mFairy.findPic(731,468,857,517,"word btn affirm join.png");
                        mFairy.onTap(0.8f,result,"确认参与",1000);
                        if(result.sim>0.8f)daze=util.initDaze();
                    }

                    result=mFairy.findPic("word pick ing.png");
                    if(result.sim>0.8f){
                        daze=util.initDaze();
                        LtLog.e(mFairy.getLineInfo("采集中"));
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
                            LtLog.e(mFairy.getLineInfo("拼图"));
                        }
                    }

                    result=mFairy.findPic(new String[]{"pic guide jsb.png","pic szhw sort.png"});
                    mFairy.onTap(0.8f,result,1237,25,1245,34,"关闭诗词排序",1000);

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"选择对话",1000);

                    result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                    mFairy.onTap(0.8f,result,1235,34,1243,43,"关闭答题",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                        daze=util.initDaze();
                    }else{
                        setTaskName(1);
                    }
                    return;
                }
            }

            boolean isFind=true;
            @Override
            public void content_3()throws Exception{
                result=mFairy.findPic("word dialogue szhw.png");
                mFairy.onTap(0.8f,result,"对话-山珍海味",2000);
                if(result.sim>0.8f){
                    setTaskName(2);
                    daze=util.initDaze();
                    return;
                }

                result=mFairy.findPic("word way.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("寻路中"));
                    return;
                }

                result=mFairy.findPic("pic up tip.png");
                mFairy.onTap(0.8f,result,1216,51,1223,57,"打开地图",3000);

                //区域地图
                result=mFairy.findPic("pic area map.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic map open.png");
                    mFairy.onTap(0.8f,result,"展开",1000);

                    result=mFairy.findPic("word map task.png");
                    mFairy.onTap(0.8f,result,"切换任务分页",1000);

                    result=mFairy.findPic("word map task page.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("pic map open detail.png");
                        mFairy.onTap(0.8f,result,"展开更多",1000);

                        result=mFairy.findPic(248,409,355,658,"word map szhw.png");
                        mFairy.onTap(0.8f,result,"点击前往",1000);
                        mFairy.onTap(0.8f,result,"点击前往",1000);
                        mFairy.onTap(0.8f,result,1229,36,1242,47,"关闭地图",1000);
                        if(result.sim>0.8f)isFind=true;
                    }
                }

                if(isFind){
                    result=mFairy.findPic("pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);
                }

                result=mFairy.findPic("pic world map.png");
                mFairy.onTap(0.8f,result,"返回区域地图",1000);
                overtime(10,2);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word szhw.png");
                if(result.sim>0.8f)return;

                result=mFairy.findPic("word task jh.png");
                mFairy.onTap(0.8f,result,"切换江湖页面",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"山珍海味");
    }

    //聚义平冤
    public void xs_jypy()throws Exception{
        new TeamTask(mFairy){
            //初始化阶段
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }


            //找任务 切换队伍目标阶段
            @Override
            public void content_1() throws Exception {
                super.content_1();
                result=mFairy.findPic("pic reward interface.png");
                if(result.sim>0.8) {
                    result=mFairy.findPic("word reward head jypy.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(320,487,405,531,"word btn go.png");
                        mFairy.onTap(0.8f,result,"前往",1000);
                        if(result.sim>0.8f){
                            util.task("hangdang wanfa","juyi pingyuan");
                            setTaskName(2);
                            return;
                        }
                    }
                    if(overtime(10,0)){
                        LtLog.e(mFairy.getLineInfo("聚义平冤执行完成一次"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    overtime(10,0);
                }
            }

            //执行副本阶段
            @Override
            public void content_2() throws Exception {
                super.content_2();
                result=mFairy.findPic("word way.png");
                if(result.sim<0.8f){
                    if(daze>5){
                        result=mFairy.findPic(51,140,81,332,new String[]{"word task copy.png","word task yi.png"});
                        mFairy.onTap(0.8f,result,"点击副本指引",1000);
                    }

                    result=mFairy.findPic(902,432,963,494,"pic btn dialogue.png");
                    mFairy.onTap(0.8f,result,"对话",1000);

                    result=mFairy.findPic("pic dialogue select.png");
                    mFairy.onTap(0.8f,result,"选择对话",1000);

                    result=mFairy.findPic(new String[]{"word keye answer.png","word bprw answer.png"});
                    mFairy.onTap(0.8f,result,1235,34,1243,43,"关闭答题",1000);

                    result=mFairy.findPic("word byhj.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(418,468,545,517,"word btn speedy form.png");
                        if(result.sim>0.8f)setTaskName(1);

                        result=mFairy.findPic(418,468,545,517,"word btn team system.png");
                        mFairy.onTap(0.8f,result,792,488,795,494,"确认发起/参与",1000);
                    }
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    util.close();
                    result=mFairy.findPic("pic exit copy.png");
                    if(result.sim>0.8f){
                        setTaskName(2);
                    }else{
                        setTaskName(1);
                    }
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"聚义平冤");
    }

    @Override
    public void content_1() throws Exception {
        //进入活动界面
        result=mFairy.findPic("pic up tip.png");
        if(result.sim>0.8f){
            result=mFairy.findPic("pic activity.png");
            mFairy.onTap(0.8f,result,"进入活动",1000);
            if(result.sim<0.8f){
                result=mFairy.findPic("pic activity1.png");
                mFairy.onTap(0.8f,result,"进入活动1",1000);

                result=mFairy.findPic("pic open system.png");
                mFairy.onTap(0.8f,result,"展开系统",1000);
            }
        }

        result=mFairy.findPic("word reward.png");
        mFairy.onTap(0.8f,result,"进入悬赏",1000);
    }

    @Override
    public void content_2() throws Exception {
        result=mFairy.findPic("word fight.png");
        if(result.sim>0.8f){
            result=mFairy.findPic("pic up tip.png");
            mFairy.onTap(0.8f,result,1133,536,1141,544,"自动战斗-普攻",200);
            return;
        }

        result=mFairy.findPic("word team interface.png");
        if(result.sim>0.8f){
            result=mFairy.findPic("word btn a key call.png");
            mFairy.onTap(0.8f,result,"一键喊话",1000);

            result=mFairy.findPic("word team apply list.png");
            if(result.sim>0.8f){
                result=mFairy.findPic("word btn invite.png");
                mFairy.onTap(0.8f,result,"邀请",1000);
            }else{
                util.initDaze();
                LtLog.e(mFairy.getLineInfo("组队中"));

                result=mFairy.findPic("word btn auto match1.png");
                mFairy.onTap(0.8f,result,"自动匹配",1000);

                int colorNum=mFairy.getColorNum(217,550,244,581,0.9f,0,"197,48,48");
                if(colorNum>100){
                    mFairy.onTap(173,584,175,588,"打开申请列表",1000);
                    return;
                }

                switch (teamNum){
                    case 3:
                        result=mFairy.findPic(606,332,670,394,"pic team invite.png");
                        break;
                    case 4:
                        result=mFairy.findPic(818,336,883,393,"pic team invite.png");
                        break;
                    case 5:
                        result=mFairy.findPic(1027,337,1087,392,"pic team invite.png");
                        break;
                }
                if(result.sim<0.8f){
                    mFairy.onTap(1114,62,1123,72,"组满"+teamNum+"人，关闭队伍界面",1000);
                }
            }
        }
    }

    @Override
    public void inOperation() throws Exception {
        daze=util.dazeTime();
        result=mFairy.findMultiColor(7,339,35,376,0.95f,"167,175,176",
                "0|-13|219,219,219&5|-7|212,220,220&9|-3|216,220,220&10|0|216,216,216&13|0|211,219,219&9|3|211,220,221&7|5|212,220,220&5|7|208,217,217&3|9|213,215,216");
        mFairy.onTap(0.9f,result,"打开任务栏",1000);

        result=mFairy.findPic("pic change task.png");
        mFairy.onTap(0.8f,result,"切换任务分页",1000);

        result=mFairy.findPic("word btn use.png");
        mFairy.onTap(0.8f,result,"使用",1000);

        result=mFairy.findPic("word btn drink.png");
        mFairy.onTap(0.8f,result,"饮用",1000);

        result=mFairy.findPic("word hint btn affirm use.png");
        mFairy.onTap(0.8f,result,"确定使用",1000);

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

        result=mFairy.findPic("word serious.png");
        mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);
    }
}
