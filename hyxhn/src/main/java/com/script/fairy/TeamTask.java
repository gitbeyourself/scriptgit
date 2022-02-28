package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result,result1;
    Util util;
    List<String> taskList = new ArrayList<>();
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        mFairy1 = ypFairy;
    }

    public  void teamTask() throws Exception{
        new TeamTask(mFairy){
            String task="",taskName="";//任务名缩写，任务全名
            int colorNum=0,picCount=0,teamNumber=1,failureCount=0,successCount=0,failOver=0;//颜色数量，队伍人数,图片出现次数，战斗失败次数，
            int yqcelCount=0;//一气惩恶令作战次数
            long dazeTime=0;//发呆计时
            boolean createTeam=false,lmtb_common=true;//创建队伍，灵猫探宝品质
            HashMap<String,String> taskHash=new HashMap<String,String >();
            @Override
            void create() throws Exception {
                if(AtFairyConfig.getOption("createTeam").equals("1")){
                    createTeam=true;
                }
                //组队人数
                String option=AtFairyConfig.getOption("teamNumber");
                if(!option.equals("")){
                    teamNumber=Integer.parseInt(option);
                }

                //失败多少次结束
                option=AtFairyConfig.getOption("failOver");
                if(option.split("\\|\\|")[0].equals("1")){
                    failOver=Integer.parseInt(option.split("\\|\\|")[1]);
                }

                //*****日常
                //一气惩恶令
                if(AtFairyConfig.getOption("yqcel").equals("1")){
                    taskList.add("1:yqcel");
                    yqcelCount=10;
                }

                //除虫行动
                if(AtFairyConfig.getOption("ccxd").equals("1")){
                    taskList.add("1:ccxd");
                }

                //灵猫探宝
                option=AtFairyConfig.getOption("lmtb common");
                if(!option.equals("")){
                    taskList.add("1:lmtb");
                    if(option.equals("0")){
                        lmtb_common=false;
                    }
                }

                //土狗快递
                if(AtFairyConfig.getOption("tgkd").equals("1")){
                    taskList.add("1:tgkd");
                }

                //幕后黑狐
                if(AtFairyConfig.getOption("mhhh").equals("1")){
                    taskList.add("1:mhhh");
                }

                //*****秘闻
                //求婚大作战 一三五 40-49
                if(AtFairyConfig.getOption("qhdzz").equals("1")){
                    taskList.add("2:qhdzz");
                }

                //大破傀儡阵 二四六 40-49
                if(AtFairyConfig.getOption("dpklz").equals("1")){
                    taskList.add("2:dpklz");
                }

                //夜捕假火神 一三五 50-59
                if(AtFairyConfig.getOption("ybjhs").equals("1")){
                    taskList.add("2:ybjhs");
                }

                //突围王权府 二四六50-59
                if(AtFairyConfig.getOption("twwqf").equals("1")){
                    taskList.add("2:twwqf");
                }

                //幻影四象镜 一三五 60-60
                if(AtFairyConfig.getOption("hysxj").equals("1")){
                    taskList.add("2:hysxj");
                }

                //两界大乱斗 二四六 60-60
                if(AtFairyConfig.getOption("ljdld").equals("1")){
                    taskList.add("2:ljdld");
                }


                //*****试炼
                //拯救王权府普通 35-49
                if(AtFairyConfig.getOption("zjwqf").equals("1")){
                    taskList.add("3:zjwqf");
                }
                //拯救涂山城普通 50-59
                if(AtFairyConfig.getOption("zjtsc").equals("1")){
                    taskList.add("3:zjtsc");
                }
                //讨伐厄喙兽普通 60-65
                if(AtFairyConfig.getOption("tfehs").equals("1")){
                    taskList.add("3:tfehs");
                }
                //拯救王权府冒险 45-54
                if(AtFairyConfig.getOption("zjwqf1").equals("1")){
                    taskList.add("3:zjwqf1");
                }
                //拯救涂山城冒险 55-60
                if(AtFairyConfig.getOption("zjtsc1").equals("1")){
                    taskList.add("3:zjtsc1");
                }
                //讨伐厄喙兽冒险 65-65
                if(AtFairyConfig.getOption("tfehs1").equals("1")){
                    taskList.add("3:tfehs1");
                }

                //*****转轮幻境
                for(int i=1;i<=6;i++){
                    if(AtFairyConfig.getOption("hj"+i).equals("1")){
                        taskList.add("4:hj"+i);
                    }
                }


                //日常副本
                taskHash.put("yqcel","一气惩恶令");
                taskHash.put("ccxd","除虫行动");
                taskHash.put("lmtb","灵猫探宝");
                taskHash.put("tgkd","土狗快递");
                taskHash.put("mhhh","幕后黑狐");
                //秘闻副本
                taskHash.put("twwqf","突围王权府");//1 二四六50-59
                taskHash.put("ybjhs","夜捕假火神");//1 一三五 50-59
                taskHash.put("qhdzz","求婚大作战");//1 一三五 40-49
                taskHash.put("dpklz","大破傀儡阵");//1 二四六 40-49
                taskHash.put("ljdld","两界大乱斗");
                taskHash.put("hysxj","幻影四象镜");
                //试炼副本
                taskHash.put("zjwqf","拯救王权府-普通");//1 35-49
                taskHash.put("zjtsc","拯救涂山城-普通");//1 50-59
                taskHash.put("tfehs","讨伐厄喙兽-普通");// 60-65
                taskHash.put("zjwqf1","拯救王权府-冒险");//1 45-54
                taskHash.put("zjtsc1","拯救涂山城-冒险");//1 55-60
                taskHash.put("tfehs","讨伐厄喙兽-冒险");// 60-60
                //转轮幻境
                taskHash.put("hj1","幻境1层");
                taskHash.put("hj2","幻境2层");
                taskHash.put("hj3","幻境3层");
                taskHash.put("hj4","幻境4层");
                taskHash.put("hj5","幻境5层");
                taskHash.put("hj6","幻境6层");
            }

            @Override
            void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务已完成"));
                    setTaskEnd();
                    return;
                }

                //退出副本
                result=mFairy.findPic("word exit copy.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"content0_退出副本",500);
                    return;
                }

                if(AtFairyConfig.getOption("createTeam").equals("1")){
                    createTeam=true;
                }

                mFairy.initDaze();//初始化发呆计时
                setTaskName(1);
                riskType=Integer.parseInt(taskList.get(0).split(":")[0]);//任务类型
                task=taskList.get(0).split(":")[1];//任务名缩写
                taskName=taskHash.get(task);//任务全名
                find=any=failureCount=0;
                if(task.equals("qhdzz"))createTeam=false;//只能匹配 求婚大作战
                util.close("回到大厅");
                return;
            }

            int find=0;//0打开活动列表，1寻找指定任务，3没到达等级没开启
            int riskType=0;
            int any=0;//在每一个任务中，含义各不相同,为了减少声明变量，所以共用
            boolean isJoinTeam=false;
            //检查副本是否完成，没完成去组队
            @Override
            void content_1() throws Exception {
                switch (riskType){
                    //***日常副本
                    case 1:
                        //打开红线天书 日常任务
                        if(find==0){
                            result=mFairy.findPic("pic tianshu.png");
                            mFairy.onTap(0.8f,result,"打开天书",500);
                            if(result.sim<0.8f){
                                if(mFairy.findPic("word red.png").sim<0.8f){
                                    setTaskName(0);
                                    LtLog.e(mFairy.getLineInfo("没有找到日常，重回大厅继续"));
                                    return;
                                }
                            }

                            result=mFairy.findPic("word daily.png");
                            mFairy.onTap(0.8f,result,"打开日常",500);

                            result=mFairy.findPic("word daily activity.png");
                            if(result.sim>0.8f){
                                //领取活跃度奖励，领取完后进行下一步
                                colorNum=mFairy.getColorNum(132,621,220,720,"253,240,115",0.9f);
                                if(colorNum>200){
                                    mFairy.onTap(168,665,177,678,"领取活跃奖励1",500);
                                    mFairy.onTap(168,665,177,678,"领取活跃奖励2",500);
                                }else{
                                    find=1;
                                }
                            }
                        }

                        if(find==1||find==2) {
                            result = mFairy.findPic("word daily activity.png");
                            if (result.sim < 0.8f) {
                                find = 0;
                                return;
                            }

                            result = mFairy.findPic(167, 168, 647, 625, "pic daily "+task+".png");
                            if (result.sim > 0.8f) {
                                colorNum=mFairy.getColorNum(result.x,result.y-71,result.x+114,result.y+10,"187,75,75",0.9f);
                                if(colorNum>150){
                                    over(taskName+"完成");
                                    return;
                                }

                                mFairy.onTap(0.8f, result, "选中"+taskName, 200);
                                if(isJoinTeam){
                                    result=mFairy.findPic("word join.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"参加",2000);
                                        setTaskName(3);
                                    }
                                }else{
                                    setTaskName(2);
                                    find=0;
                                    util.close("回到大厅，前往组队");
                                }
                            } else {
                                mFairy.touchDown(0, 332, 582);
                                mFairy.touchMove(0, 339, 238, 200);
                                mFairy.touchUp(0);
                                mFairy.sleep(1000);
                                mFairy.condit();
                                LtLog.e("向上滑动一次");
                                find++;
                            }
                        }

                        if(find==3){
                            //等级不够，没有开启任务
                            over(taskName+"没找到，结束当前任务");
                            return;
                        }
                    break;


                    //***秘闻副本
                    case 2:
                        //打开红线天书 冒险任务
                        if(find==0){
                            result=mFairy.findPic("pic tianshu.png");
                            mFairy.onTap(0.8f,result,"打开天书",500);
                            if(result.sim<0.8f){
                                if(mFairy.findPic("word red.png").sim<0.8f){
                                    setTaskName(0);
                                    LtLog.e(mFairy.getLineInfo("没有找到日常，重回大厅继续"));
                                    return;
                                }
                            }

                            result=mFairy.findPic("word risk.png");
                            mFairy.onTap(0.8f,result,"打开冒险",500);

                            result=mFairy.findPic("word risk challenge.png");
                            if(result.sim>0.8f){
                                find=1;
                            }
                        }

                        if(find>=1&&find<4) {
                            result = mFairy.findPic("word risk challenge.png");
                            if (result.sim < 0.8f) {
                                find = 0;
                                return;
                            }

                            result = mFairy.findPic(167, 168, 647, 625, "pic risk "+task+".png");
                            if (result.sim > 0.8f) {
                                colorNum=mFairy.getColorNum(result.x,result.y-71,result.x+114,result.y+10,"187,75,75",0.9f);
                                if(colorNum>150){
                                    over(taskName+"完成");
                                    return;
                                }

                                mFairy.onTap(0.8f, result, "选中"+taskName, 500);
                                colorNum=mFairy.getColorNum(830,597,1006,655,0.9f,0,"243,213,150");
                                if(colorNum<7000){
                                    over(taskName+"没有开启");
                                    return;
                                }
                                if(isJoinTeam){
                                    result=mFairy.findPic("word join.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"参加",200);
                                        setTaskName(3);
                                    }
                                }else{
                                    setTaskName(2);
                                    find=0;
                                    util.close("回到大厅，前往组队");
                                }
                            } else {
                                mFairy.touchDown(0, 332, 582);
                                mFairy.touchMove(0, 339, 238, 200);
                                mFairy.touchUp(0);
                                mFairy.sleep(1000);
                                mFairy.condit();
                                LtLog.e("向上滑动一次");
                                find++;
                            }
                        }

                        if(find==4){
                            //等级不够，没有开启任务
                            over(taskHash.get(task)+"没找到，结束当前任务");
                            return;
                        }
                    break;


                    //***试炼副本
                    case 3:
                        //打开红线天书 冒险任务
                        if(find==0){
                            result=mFairy.findPic("pic tianshu.png");
                            mFairy.onTap(0.8f,result,"打开天书",500);
                            if(result.sim<0.8f){
                                if(mFairy.findPic("word red.png").sim<0.8f){
                                    setTaskName(0);
                                    LtLog.e(mFairy.getLineInfo("没有找到日常，重回大厅继续"));
                                    return;
                                }
                            }

                            result=mFairy.findPic("word risk.png");
                            mFairy.onTap(0.8f,result,"打开冒险",500);

                            result=mFairy.findPic("word risk challenge.png");
                            if(result.sim>0.8f){
                                find=1;
                            }
                        }

                        if(find>=1&&find<4) {
                            result = mFairy.findPic("word risk challenge.png");
                            if (result.sim < 0.8f) {
                                find = 0;
                                return;
                            }

                            result = mFairy.findPic(167, 168, 647, 625, "pic risk "+task+".png");
                            if (result.sim > 0.9f) {
                                colorNum=mFairy.getColorNum(result.x,result.y-71,result.x+114,result.y+10,"187,75,75",0.9f);
                                if(colorNum>150){
                                    over(taskName+"完成");
                                    return;
                                }
                                mFairy.onTap(0.8f, result, "选中"+taskName, 200);
                                colorNum=mFairy.getColorNum(830,597,1006,655,0.9f,0,"243,213,150");
                                if(colorNum<7000){
                                    over(taskName+"没有开启");
                                    return;
                                }

                                if(isJoinTeam){
                                    result=mFairy.findPic("word join.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"参加",200);
                                        setTaskName(3);
                                    }
                                }else{
                                    setTaskName(2);
                                    find=0;
                                    util.close("回到大厅，前往组队");
                                }
                            } else {
                                mFairy.touchDown(0, 332, 582);
                                mFairy.touchMove(0, 339, 238, 200);
                                mFairy.touchUp(0);
                                mFairy.sleep(1000);
                                mFairy.condit();
                                LtLog.e("向上滑动一次");
                                find++;
                            }
                        }

                        if(find==4){
                            //等级不够，没有开启任务
                            over(taskName+"没找到，结束当前任务");
                            return;
                        }
                    break;


                    //***轮转幻境
                    case 4:
                        //打开红线天书 冒险任务
                        if(find==0){
                            result=mFairy.findPic("pic tianshu.png");
                            mFairy.onTap(0.8f,result,"打开天书",500);
                            if(result.sim<0.8f){
                                if(mFairy.findPic("word red.png").sim<0.8f){
                                    setTaskName(0);
                                    LtLog.e(mFairy.getLineInfo("没有找到日常，重回大厅继续"));
                                    return;
                                }
                            }

                            result=mFairy.findPic("word risk.png");
                            mFairy.onTap(0.8f,result,"打开冒险",500);

                            result=mFairy.findPic("word risk challenge.png");
                            if(result.sim>0.8f){
                                find=1;
                            }
                        }

                        if(find>=1&&find<4) {
                            result = mFairy.findPic("word risk challenge.png");
                            if (result.sim < 0.8f) {
                                find = 0;
                                return;
                            }

                            result = mFairy.findPic(167, 168, 647, 625, "pic risk zlhj.png");
                            if (result.sim > 0.8f) {
                                colorNum=mFairy.getColorNum(result.x,result.y-71,result.x+114,result.y+10,"187,75,75",0.9f);
                                result1 = mFairy.findPic(result.x + 53, result.y - 43, result.x + 116, result.y +6, "wancheng.png");
                                if(result1.sim>0.8f){
                                    over(taskName+"完成");
                                    return;
                                }
//                                if(colorNum>150){
//                                    over(taskName+"完成");
//                                    return;
//                                }
                                mFairy.onTap(0.8f, result, "选中"+taskName, 200);
                                if(isJoinTeam){
                                    result=mFairy.findPic("word join.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"参加",200);
                                        setTaskName(3);
                                    }
                                }else{
                                    setTaskName(2);
                                    find=0;
                                    util.close("回到大厅，前往组队");
                                }
                            } else {
                                mFairy.touchDown(0, 332, 582);
                                mFairy.touchMove(0, 339, 238, 200);
                                mFairy.touchUp(0);
                                mFairy.sleep(1000);
                                mFairy.condit();
                                LtLog.e("向上滑动一次");
                                find++;
                            }
                        }

                        if(find==4){
                            //等级不够，没有开启任务
                            over(taskName+"没找到，结束当前任务");
                            return;
                        }
                    break;
                }

            }

            //组队（创建队伍或匹配）完成后，去打副本
            @Override
            void content_2() throws Exception {
                result=mFairy.findPic("word team.png");
                mFairy.onTap(0.8f,result,"切换队伍分页",200);

                //打开组队大厅阶段
                if(find==0){
                    //退出队伍
                    result=mFairy.findPic("word team1.png");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic("pic team box.png");
                        if(result1.sim>0.8f){
                            mFairy.onTap(0.8f,result,"打开组队大厅",200);
                        }else{
                            mFairy.onTap(171,311,178,321,"退队1",200);
                            mFairy.onTap(166,343,175,356,"退队2",500);
                        }
                    }

                    result=mFairy.findPic("word team zu.png");
                    if(result.sim>0.8f){
                        find=1;
                    }
                }

                //寻找副本并选中阶段
                if(find==1){
                    result=mFairy.findPic("word team zu.png");
                    if(result.sim>0.8f){
                        //初始化滑动
                        result=mFairy.findPic("word da1.png");
                        picCount=picCount(0.8f,result,"hall");
                        if(picCount==1){
                            mFairy.touchDown(0, 235,232 );
                            mFairy.touchMove(235, 658, 200);
                            mFairy.touchUp(0);
                            mFairy.sleep(1000);
                            LtLog.e(mFairy.getLineInfo("初始化副本列表"));
                        }

                        //组队大厅界面
                        result = mFairy.findPic("pic match teammate.png");
                        if (result.sim < 0.8f) {
                            if(any==0){
                                switch (riskType){
                                    //日常副本
                                    case 1:
                                        result = mFairy.findPic(166, 140, 354, 667, "word team " + task + ".png");
                                        if (result.sim > 0.8f) {
                                            mFairy.onTap(0.8f, result, "选中" + taskName, 1000);
                                            any=1;
                                        } else {
                                            mFairy.touchDown(0, 235, 658);
                                            mFairy.touchMove(235, 232, 200);
                                            mFairy.touchUp(0);
                                            mFairy.sleep(1000);
                                            LtLog.e(mFairy.getLineInfo("向上滑动查找一次"));
                                            overtime(5,1);
                                            return;
                                        }
                                        break;

                                    //秘闻副本
                                    case 2:
                                        result = mFairy.findPic(166, 140, 354, 667, "word team mwfb.png");
                                        mFairy.onTap(0.8f, result, "选中秘闻副本", 200);

                                        result = mFairy.findPic(435, 84, 662, 439, "word team " + task + ".png");
                                        if (result.sim > 0.8f) {
                                            mFairy.onTap(0.8f, result, "选中" + taskName, 200);
                                            any=1;
                                        }
                                        break;

                                    //试炼副本
                                    case 3:
                                        result = mFairy.findPic(166, 140, 354, 667, "word team slfb.png");
                                        mFairy.onTap(0.8f, result, "选中试炼副本", 200);

                                        result = mFairy.findPic(435, 84, 662, 439, "word team " + task + ".png");
                                        if (result.sim > 0.8f) {
                                            mFairy.onTap(0.8f, result, "选中" + taskName, 200);
                                            any=1;
                                        }
                                        break;

                                    //轮转幻境
                                    case 4:
                                        result = mFairy.findPic(166, 140, 354, 667, new String []{"word team zlhj.png","word team zlhj1.png"});
                                        if(result.sim>0.8f){
                                            mFairy.onTap(0.8f, result, "选中转轮幻境", 200);

                                            result=mFairy.findPic(477,127,615,528,"word team "+task+".png");
                                            if(result.sim>0.8f){
                                                mFairy.onTap(0.8f,result,"选中",200);
                                                any=1;
                                            }
                                        }else {
                                            mFairy.touchDown(0, 235, 658);
                                            mFairy.touchMove(235, 232, 200);
                                            mFairy.touchUp(0);
                                            mFairy.sleep(1000);
                                            LtLog.e(mFairy.getLineInfo("向上滑动查找一次"));
                                            overtime(5,1);
                                            return;
                                        }
                                        break;
                                }
                            }else{
                                //创建队伍
                                if(createTeam){
                                    result=mFairy.findPic("word create team.png");
                                    mFairy.onTap(0.8f,result,"创建队伍",200);
                                }else{
                                    //自动匹配
                                    result=mFairy.findPic(new String [] {"word team auto match1.png"});
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
                                }
                            }
                        }
                    }else{
                        if(!createTeam){
                            result=mFairy.findPic("word team1.png");
                            if(result.sim>0.8f){
                                result=mFairy.findPic("pic team box.png");
                                if(result.sim>0.8f){
                                    find=0;
                                }else{
                                    setTaskName(3);
                                    isJoinTeam=true;
                                    any=0;
                                    util.close("加入队伍成功，跟随队长，前往"+taskName+"副本");
                                    return;
                                }
                            }
                        }
                    }
                }

                //组队详情界面
                result = mFairy.findPic("pic match teammate.png");
                if(result.sim>0.8f){
                    //入队申请界面
                    result=mFairy.findPic("word apply for.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(863,195,962,542,"word accept.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"接受入队申请",200);
                        }else{
                            result=mFairy.findPic(753,0,1280,317,new String[]{"pic close1.png","pic close3.png"});
                            mFairy.onTap(0.8f,result,"team_关闭组队申请",1000);
                        }
                    }else{
                        //开启匹配队员
                        colorNum=mFairy.getColorNum(1109,5,1185,80,"253,255,255",0.9f);
                        if(colorNum<200){
                            mFairy.onTap(1144,33,1158,45,"匹配队员",200);
                        }else{
                            //判断组满几个人了
                            switch (teamNumber){
                                case 1:
                                    result=mFairy.findPic(220,329,369,474,"word team invite.png");
                                    break;
                                case 2:
                                    result=mFairy.findPic("word team invite.png");
                                    break;
                                case 3:
                                    result=mFairy.findPic(943,357,1011,421,"word team invite.png");
                                    break;
                            }
                            if(result.sim>0.8f){
                                //输出日志
                                picCount=picCount(0.8f,result,"auto match");
                                if(picCount%5==0)LtLog.e(mFairy.getLineInfo("组满"+teamNumber+"人进入"+taskName+"副本"));
                            }else{
                                //组满人前往副本
                                setTaskName(1);
                                isJoinTeam=true;
                                util.close("组满"+teamNumber+"人，回到大厅，前往副本");
                                return;
                            }

                            result=mFairy.findPic("pic team call.png");
                            if(result.sim>0.8f){
                                boolean timekeep=timekeep(1,31*1000,"call");
                                if(timekeep)mFairy.onTap(0.8f,result,"一键喊话",200);
                            }

                            colorNum=mFairy.getColorNum(1109,5,1185,80,0.9f,0,"233,84,84");
                            if(colorNum>50){
                                mFairy.onTap(566,660,581,674,"打开组队申请",200);
                            }
                        }
                    }
                }
            }

            //执行副本阶段
            @Override
            void content_3() throws Exception {
                if(createTeam){
                    result=mFairy.findPic("word task1.png");
                    mFairy.onTap(0.8f,result,"切换到任务分页",200);

                    switch(riskType){
                        //日常副本
                        case 1:
                            //一气惩恶令
                            if(task.equals("yqcel")){
                                //回应对话
                                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                                if(result.sim>0.8f){
                                    result1=mFairy.findPic(1061,269,1218,495,new String[]{"word weituo.png"});
                                    if(result1.sim>0.8){
                                        mFairy.onTap(0.8f,result1,"开始答题,委托战斗",200);
                                    }else{
                                        mFairy.onTap(0.8f,result,"点击回应对话",200);
                                    }
                                }

                                //取消
                                result=mFairy.findPic("word yqcel cancel.png");
                                picCount=picCount(0.8f,result,"yqcel cancel");
                                if(result.sim>0.8f){
                                    mFairy.initDaze();
                                    if(picCount==1){
                                        if(successCount>=yqcelCount){
                                            mFairy.onTap(0.8f,result,"停止一气惩恶令，一气惩恶令完成",200);
                                            over("一气惩恶令完成");
                                            return;
                                        }
                                    }
                                }

                                //连续失败3次结束任务
                                if(failureCount>=3){
                                    setTaskName(0);
                                    taskList.remove(0);
                                    successCount=failureCount=0;
                                    LtLog.e(mFairy.getLineInfo("一气惩恶令连续失败3次，结束任务"));
                                    return;
                                }

                                result=mFairy.findPic("pic yu.png");
                                if(result.sim>0.8f){
                                    LtLog.e(mFairy.getLineInfo("一气惩恶令战斗加载"));
                                    mFairy.initDaze();
                                }

                                //一气惩恶令发呆超时
                                result=mFairy.findPic("pic main open.png");
                                if(result.sim>0.8f){
                                    colorNum=mFairy.getColorNum(553,575,723,605,"102,102,204",0.9f);
                                    if(colorNum>100){
                                        mFairy.initDaze();//初始化发呆
                                        LtLog.e(mFairy.getLineInfo("寻路中"));
                                    }
                                    dazeTime=mFairy.dazeTime(625,634,693,674,0.8f,0,"120,115,136");
                                    if(dazeTime>=8){
                                        LtLog.e(mFairy.getLineInfo("一气惩恶令任务结束"));
                                        setTaskName(0);
                                        return;
                                    }
                                }
                            }

                            //除虫行动
                            if(task.equals("ccxd")){
                                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                                if(result.sim>0.8){
                                    result1=mFairy.findPic(1070,383,1190,504,new String[]{"word chuchongxingdong.png","word dialogue jiequ.png"});
                                    if(result1.sim<0.8){
                                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                                    }else{
                                        mFairy.onTap(0.8f,result1,"除虫行动,接取除虫行动",100);
                                    }
                                }

                                //已经完成20次
                                result=mFairy.findPic(400,306,870,396,"word hint already finish.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(458,442,562,523,"word cancel1.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"已经完成20次，完成任务",200);
                                        successCount=failureCount=0;
                                        taskList.remove(0);
                                        setTaskName(0);
                                        return;
                                    }
                                }

                                //已经完成20次
                                result=mFairy.findPic(400,306,870,396,"word hint already finish.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(458,442,562,523,"word cancel1.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"已经完成20次，完成任务",200);
                                        successCount=failureCount=0;
                                        return;
                                    }
                                }

                                //主界面
                                result = mFairy.findPic("word task.png");
                                if (result.sim > 0.8f) {
                                    //寻路
                                    colorNum = mFairy.getColorNum(553, 575, 723, 605, 0.9f, 0, "102,102,204");
                                    if (colorNum > 100) {
                                        failureCount=0;
                                        mFairy.initDaze();
                                        LtLog.e(mFairy.getLineInfo("寻路中.."));
                                        mFairy.sleep(3000);
                                    }
                                    //计算超时
                                    dazeTime = mFairy.dazeTime(7, 375, 45, 403, 0.8f, 0, "255,255,255");
                                    if(dazeTime>=5){
                                        //活动指引
                                        result=mFairy.findPic(5,201,217,366,"word huodong deal worm action.png");
                                        if(result.sim>0.8f) {
                                            if (any == 1) {
                                                failureCount++;
                                                LtLog.e(mFairy.getLineInfo("除虫行动失败" + failureCount));
                                                any = 0;
                                            }
                                            //连续失败
                                            if(failureCount>=3){
                                                taskList.remove(0);
                                                setTaskName(0);
                                                LtLog.e(mFairy.getLineInfo("连续失败3次，除虫行动结束"));
                                                return;
                                            }
                                            if(any==0){
                                                mFairy.onTap(0.8f,result,"除虫行动指引",200);
                                            }
                                        }else{
                                            LtLog.e(mFairy.getLineInfo("除虫行动超时，重新启动任务"));
                                            setTaskName(0);
                                            return;
                                        }
                                    }else{
                                        LtLog.e(mFairy.getLineInfo("除虫行动发呆超时="+dazeTime));
                                    }
                                }

                                //进入战斗的状态
                                result=mFairy.findPic("pic yu.png");
                                if(result.sim>0.8f){
                                    mFairy.initDaze();
                                    any=1;
                                    LtLog.e(mFairy.getLineInfo("any==1，进入战斗中"));
                                    mFairy.sleep(3000);
                                }
                            }

                            //灵猫探宝
                            if(task.equals("lmtb")){
                                //回应对话
                                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                                if(result.sim>0.8){
                                    if(lmtb_common){
                                        //1000铜钱
                                        result=mFairy.findPic("word lmtb common.png");
                                        mFairy.onTap(0.8f,result,"打探普通线索",100);
                                    }else{
                                        //2000铜钱
                                        result=mFairy.findPic("word lmtb rare.png");
                                        mFairy.onTap(0.8f,result,"打探稀有线索",100);
                                    }
                                    if(result.sim<0.8){
                                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                                    }
                                }

                                //线索地图
                                result=mFairy.findPic("pic yemei.png");
                                if(result.sim>0.8f){
                                    if(lmtb_common){
                                        //普通线索
                                        result=mFairy.findPic("pic common clues none.png");
                                        if(result.sim>0.8f){
                                            LtLog.e(mFairy.getLineInfo("普通寻宝符不足，任务结束"));
                                            result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                                            mFairy.onTap(0.8f,result,"关闭窗口",200);
                                            over(taskName+"完成");
                                            return;
                                        }else{
                                            result=mFairy.findPic(76,101,1187,674,"pic common clues.png");
                                            mFairy.onTap(0.8f,result,"普通线索",200);
                                        }
                                    }else{
                                        //稀有线索
                                        result=mFairy.findPic("pic rare clues none.png");
                                        if(result.sim>0.8f){
                                            LtLog.e(mFairy.getLineInfo("稀有寻宝符不足，任务结束"));
                                            result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                                            mFairy.onTap(0.8f,result,"关闭窗口",200);
                                            over(taskName+"完成");
                                            return;
                                        }else{
                                            result=mFairy.findPic(76,101,1187,674,"pic rare clues.png");
                                            mFairy.onTap(0.8f,result,"稀有线索",200);
                                        }
                                    }

                                    result=mFairy.findPic("pic main open.png");
                                    if(result.sim>0.8f){
                                        colorNum=mFairy.getColorNum(553,575,723,605,"102,102,204",0.9f);
                                        if(colorNum>100){
                                            mFairy.initDaze();//初始化发呆
                                            LtLog.e(mFairy.getLineInfo("寻路中"));
                                        }
                                        dazeTime=mFairy.dazeTime(710,640,780,689,0.8f,0,"68,124,83");
                                        if(dazeTime>10){
                                            setTaskName(0);
                                            return;
                                        }
                                    }

                                    result=mFairy.findPic("word exit copy.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"退出副本，继续寻宝",200);
                                        setTaskName(0);
                                        return;
                                    }

                                    result=mFairy.findPic(new String[]{"pic common xunbaofu.png","pic rare xunbaofu.png"});
                                    picCount=picCount(0.8f,result,"xunbao");
                                    if(picCount==1){
                                        mFairy.onTap(0.8f,result,"寻宝",200);
                                    }

                                    if(picCount>=10){
                                        over("夜魅寻宝符不足，灵猫探宝结束");
                                        return;
                                    }
                                }

                                //发呆超时
                                result=mFairy.findPic("word task1.png");
                                if(result.sim>0.8f){
                                    dazeTime=mFairy.dazeTime(609,618,750,679,0.8f,0,"86,118,83");
                                    if(dazeTime>=10){
                                        setTaskName(0);
                                        LtLog.e(mFairy.getLineInfo("灵猫探宝_发呆超时"));
                                    }
                                }
                            }

                            //土狗快递
                            if(task.equals("tgkd")){
                                //回应对话
                                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                                if(result.sim>0.8){
                                    result1=mFairy.findPic(new String[]{"word kuaidi.png"});
                                    if(result1.sim<0.8){
                                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                                    }else{
                                        mFairy.onTap(0.8f,result1,"土狗快递",100);
                                    }
                                }

                                result=mFairy.findPic("word huodong.png");
                                mFairy.onTap(0.8f,result,"活动指引",200);

                                //敲击忆梦锤
                                result=mFairy.findPic("pic yichui.png");
                                if(result.sim>0.8){
                                    while(mFairy.condit()){
                                        mFairy.onTap(113,622,133,640,"左边 忆梦锤",100);
                                        mFairy.onTap(1145,632,1159,649,"右边 忆梦锤",100);
                                        result=mFairy.findPic("pic yichui.png");
                                        if(result.sim<0.8)break;
                                    }
                                }

                                //沙狐城 超时 结束任务
                                result=mFairy.findPic("pic shahucheng.png");
                                picCount=picCount(0.8f,result,"shahucheng");
                                if(picCount>=7){
                                    successCount=failureCount=0;
                                    LtLog.e(mFairy.getLineInfo("忆梦锤不足，无法继续任务，结束任务"));
                                    over("忆梦锤不足，无法继续任务，结束任务");
                                    return;
                                }

                                //连续失败3次结束任务
                                if(failureCount>=3){
                                    setTaskName(0);
                                    taskList.remove(0);
                                    successCount=failureCount=0;
                                    LtLog.e(mFairy.getLineInfo("土狗快递失败3次，结束任务"));
                                    return;
                                }
                            }

                            //幕后黑狐
                            if(task.equals("mhhh")){
                                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                                if(result.sim>0.8){
                                    result1=mFairy.findPic(1070,383,1190,504,new String[]{"word chuchongxingdong.png","word dialogue jiequ.png"});
                                    if(result1.sim<0.8){
                                        result1=mFairy.findPic("word dialogue yield monster.png");
                                        if(result1.sim>0.8f){
                                            //对战黑狐
                                            picCount=picCount(0.8f,result1,"yield monster");
                                            picCount++;
                                            if(picCount>3&&3!=0){
                                                mFairy.onTap(0.8f,result,718,361,729,372,"已经对战黑狐"+3+"次，结束幕后黑狐任务",200);
                                                setTaskName(0);
                                                taskList.remove(0);
                                                return;
                                            }else{
                                                mFairy.onTap(0.8f,result,"对战黑狐，降服妖怪次数="+picCount,1000);
                                            }
                                        }else{
                                            //普通对话
                                            mFairy.onTap(0.8f,result,"点击回应对话",100);
                                        }
                                    }else{
                                        mFairy.onTap(0.8f,result1,"除虫行动,接取除虫行动",100);
                                    }
                                }

                                //已经完成20次
                                result=mFairy.findPic(400,306,870,396,"word hint already finish.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(458,442,562,523,"word cancel1.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"已经完成20次，完成任务",200);
                                        successCount=failureCount=0;
                                        return;
                                    }
                                }

                                //主界面
                                result = mFairy.findPic("word task.png");
                                if (result.sim > 0.8f) {
                                    //寻路
                                    colorNum = mFairy.getColorNum(553, 575, 723, 605, 0.9f, 0, "102,102,204");
                                    if (colorNum > 100) {
                                        failureCount=0;
                                        mFairy.initDaze();
                                        LtLog.e(mFairy.getLineInfo("寻路中.."));
                                        mFairy.sleep(3000);
                                    }
                                    //计算超时
                                    dazeTime = mFairy.dazeTime(7, 375, 45, 403, 0.8f, 0, "255,255,255");
                                    if(dazeTime>=5){
                                        //活动指引
                                        result=util.findPic(5,201,217,366,new String[]{"word huodong muhou.png","word huodong deal worm action.png"});
                                        if(result.sim>0.8f) {
                                            if (any == 1) {
                                                failureCount++;
                                                LtLog.e(mFairy.getLineInfo("幕后黑狐失败" + failureCount));
                                                any = 0;
                                            }
                                            //连续失败
                                            if(failureCount>=3){
                                                taskList.remove(0);
                                                setTaskName(0);
                                                LtLog.e(mFairy.getLineInfo("连续失败3次，幕后黑狐结束"));
                                                return;
                                            }
                                            if(any==0){
                                                mFairy.onTap(0.8f,result,"幕后黑狐指引",200);
                                            }
                                        }else{
                                            LtLog.e(mFairy.getLineInfo("幕后黑狐超时，重新启动任务"));
                                            setTaskName(0);
                                            return;
                                        }
                                    }else{
                                        LtLog.e(mFairy.getLineInfo("幕后黑狐发呆超时="+dazeTime));
                                    }
                                }

                                //进入战斗的状态
                                result=mFairy.findPic("pic yu.png");
                                if(result.sim>0.8f){
                                    mFairy.initDaze();
                                    any=1;
                                    LtLog.e(mFairy.getLineInfo("any==1，进入战斗中"));
                                    mFairy.sleep(3000);
                                }
                            }
                            break;

                        //秘闻副本
                        case 2:
                            //回应对话
                            result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                            if(result.sim>0.8f){
                                result1=mFairy.findPic(1077,288,1195,518,new String[]{"word dialogue miwen.png"});
                                if(result1.sim>0.8){
                                    mFairy.onTap(0.8f,result1,"选中秘闻副本",200);
                                }else{
                                    mFairy.onTap(0.8f,result,"回应对话",200);
                                }
                            }

                            //选择副本任务
                            result=mFairy.findPic("word mi.png");
                            if(result.sim>0.8f){
                                result=mFairy.findPic(109,113,293,684,"pic risk "+task+".png");
                                if(result.sim>0.8f){
                                    mFairy.onTap(0.8f,result,"选中"+taskName,500);

                                    result=mFairy.findPic(1023,551,1144,668,"word kaizhan.png");
                                    mFairy.onTap(0.8f,result,"开战",500);
                                }
                            }

                            //突围王权府
                            if(task.equals("twwqf")){
                                result=mFairy.findPic("pic caiji1.png");
                                mFairy.onTap(0.8f,result,"打开宝箱",4000);

                                //在副本中
                                result=mFairy.findPic("word exit copy.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                                    if(result.sim<0.8f){
                                        result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                                        mFairy.onTap(0.8f,result,"活动指引",200);
                                    }
                                }
                            }

                            //求婚大作战
                            if(task.equals("qhdzz")){
                                //在副本中
                                result=mFairy.findPic("word exit copy.png");
                                if(result.sim>0.8f){
                                    result1=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});

                                    result=mFairy.findPic("word huodong huayao.png");
                                    if(result.sim<0.8f){
                                        picCount=picCount(0.8f,result,"activity");
                                        if(picCount%5==0)mFairy.onTap(0.8f,result,"活动指引",200);
                                    }
                                    colorNum=mFairy.getColorNum(553,575,723,605,"102,102,204",0.9f);
                                    if(colorNum>100){
                                        LtLog.e(mFairy.getLineInfo("自动寻路中"));
                                        mFairy.sleep(2000);
                                    }
                                    switch(any){
                                        //向上走
                                        case 0:
                                            mFairy.touchDown(0,567,431);
                                            mFairy.touchMove(515,376,500);
                                            mFairy.sleep(5000);
                                            mFairy.touchUp(0);
                                            break;
                                        //向右走
                                        case 1:
                                            mFairy.touchDown(0,567,431);
                                            mFairy.touchMove(685,431,500);
                                            mFairy.sleep(5000);
                                            mFairy.touchUp(0);
                                            break;
                                        //向左走
                                        case 2:
                                            mFairy.touchDown(0,567,431);
                                            mFairy.touchMove(500,431,500);
                                            mFairy.sleep(5000);
                                            mFairy.touchUp(0);
                                            break;
                                    }
                                    any++;
                                    if(any==3){
                                        any=0;
                                    }
                                    result=mFairy.findPic(0,0,1280,720,new String[]{"pic copy huayao.png","pic copy huayao1.png"});
                                    mFairy.onTap(0.8f,result,"找到花妖",200);
                                }
                            }

                            //夜捕假火神
                            if(task.equals("ybjhs")){
                                //在副本中
                                result=mFairy.findPic("word exit copy.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                                    if(result.sim<0.8f){
                                        result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                                        mFairy.onTap(0.8f,result,"活动指引",1000);

                                        //选择法阵继续追击
                                        result=mFairy.findPic("word huodong csfz.png");
                                        if(result.sim>0.8f){
                                            String change=util.change(173,198,1144,470,"选中一个法阵");
                                            if(!change.equals("0,0")){
                                                mFairy.sleep(2000);
                                            }
                                        }

                                        result=mFairy.findPic("word huodong baowuku.png");
                                        if(result.sim>0.8f){
                                            result=mFairy.findPic(639,69,1255,657,"pic caiji1.png");
                                            if(result.sim>0.8f){
                                                mFairy.onTap(0.8f,result,"打开宝箱",2000);
                                            }else{
                                                String change=util.change(173,198,1144,470,"选中一个法阵");
                                                if(!change.equals("0,0")){
                                                    mFairy.sleep(2000);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            //大破傀儡阵
                            if(task.equals("dpklz")){
                                //在副本中
                                result=mFairy.findPic("word exit copy.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(454,132,1280,279,"pic duel.png");
                                    if(result.sim>0.8f){
                                        mFairy.onTap(0.8f,result,"决斗",5000);
                                    }else{
                                        result=mFairy.findPic(550,527,585,620,"word auto.png");
                                        if(result.sim<0.8f){
                                            result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                                            mFairy.onTap(0.8f,result,"活动指引",200);
                                        }
                                    }
                                }
                            }
                            break;

                        //试炼副本
                        case 3:
                            //回应对话
                            result1=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                            if(result1.sim>0.8f){
                                result1=mFairy.findPic(1077,288,1195,518,new String[]{"word dialogue shilian.png"});
                                if(result1.sim>0.8){
                                    mFairy.onTap(0.8f,result,"选中试炼副本",100);
                                }
                            }

                            //切换副本分页
                            result=mFairy.findPic("word shi.png");
                            if(result.sim>0.8f){
                                String risk=task.substring(task.length()-1);//冒险
                                if(risk.equals("1")){
                                    result=mFairy.findPic("word team risk.png");
                                    mFairy.onTap(0.8f,result,"切换冒险分页",200);
                                }else{
                                    result=mFairy.findPic("word team common.png");
                                    mFairy.onTap(0.8f,result,"切换普通分页",200);
                                }

                                result=mFairy.findPic(114,166,235,520,"pic team "+task+".png");
                                if(result.sim>0.8f){
                                    mFairy.onTap(0.8f,result,"选中"+taskName,500);

                                    result=mFairy.findPic(1023,551,1144,668,"word kaizhan.png");
                                    mFairy.onTap(0.8f,result,"开战",500);
                                }
                            }



                            //拯救涂山城-普通/冒险
                            if(task.contains("zjtsc")){
                                //在副本中
                                result=mFairy.findPic("word exit copy.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                                    if(result.sim<0.8f){
                                        result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                                        mFairy.onTap(0.8f,result,"活动指引",200);
                                    }
                                }

                                result=mFairy.findPic(47,134,1253,601,"pic caiji1.png");
                                mFairy.onTap(0.8f,result,"打开宝箱",4000);
                            }


                            //拯救王权府-普通/冒险
                            if(task.contains("zjwqf")){
                                //在副本中
                                result=mFairy.findPic("word exit copy.png");
                                if(result.sim>0.8f){
                                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                                    if(result.sim<0.8f){
                                        result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                                        mFairy.onTap(0.8f,result,"活动指引",200);
                                    }

                                    result=mFairy.findPic(47,134,1253,601,"pic caiji1.png");
                                    mFairy.onTap(0.8f,result,"打开宝箱",4000);
                                }
                            }
                            break;

                        //转轮幻境
                        case 4:
                            //回应对话
                            result1=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                            if(result1.sim>0.8f){
                                result1=mFairy.findPic(1077,288,1195,518,new String[]{"word dialogue zhuanlun.png"});
                                if(result1.sim>0.8){
                                    mFairy.onTap(0.8f,result,"选中试炼副本",100);
                                }
                            }

                            result=mFairy.findPic("word zhuanlun.png");
                            if(result.sim>0.8f){
                                result=mFairy.findPic(275,122,363,615,"word zl "+task+".png");
                                if(result.sim>0.9f){
                                    mFairy.onTap(0.8f,result,"选中"+taskName,500);
                                    result=mFairy.findPic(result.x+34,result.y+30,result.x+83,result.y+75,"word open lock.png");
                                    if(result.sim>0.8f){
                                        over(taskName+"没有解锁，任务结束");
                                        return;
                                    }

                                    result=mFairy.findPic(1023,551,1144,668,"word kaizhan.png");
                                    mFairy.onTap(0.8f,result,"开战",500);
                                }else{
                                    mFairy.touchDown(0, 332, 582);
                                    mFairy.touchMove(0, 339, 238, 200);
                                    mFairy.touchUp(0);
                                    mFairy.sleep(1000);
                                    mFairy.condit();
                                    LtLog.e("向上滑动一次");
                                }
                            }

                            result=mFairy.findPic(550,527,585,620,"word auto.png");
                            if(result.sim>0.8f){
                                mFairy.sleep(1000);
                                LtLog.e(mFairy.getLineInfo("自动寻路中"));
                            }else{
                                result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                                mFairy.onTap(0.8f,result,"活动指引",200);
                            }

                            result=mFairy.findPic("pic zl monster.png");
                            picCount=picCount(0.8f,result,"zl monster");
                            if(picCount<=3)mFairy.onTap(0.8f,result,"转轮，锁定优先",200);
                            break;
                    }

                    result=mFairy.findPic("word chuzhan.png");
                    mFairy.onTap(0.8f,result,"出战",200);

                    //失败5次结束任务
                    if(failOver!=0){
                        if(failureCount>=failOver){
                            over(taskName+"失败"+failOver+"次，结束任务");
                            return;
                        }
                    }

                    //副本已经结束
                    result=mFairy.findPic("word team exit copy.png");
                    if(result.sim>0.8f){
                        over(taskName+"已完成，进行下一个任务");
                    }
                }
                else
                {
                    //主界面长时间不动，3分钟以上，退出队伍，重启任务
                    result=mFairy.findPic("pic main open.png");
                    if(result.sim>0.8f) {
                        result=mFairy.findPic("word team.png");
                        mFairy.onTap(0.8f,result,"切换到队伍分页",200);

                        //被踢出队伍
                        result=mFairy.findPic("word team1.png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic("word team back team.png");
                            mFairy.onTap(0.8f,result,"归队",200);

                            result=mFairy.findPic("word team box.png");
                            if(result.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("被踢出队伍，重启任务"));
                                isJoinTeam=false;//没有加入队伍
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

                //战斗场景
                result=mFairy.findPic(new String[]{"direction.png","direction1.png"});
                picCount=picCount(0.8f,result,"direction");
                if(result.sim>0.8f){
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
            }

            //全局执行
            @Override
            void inOperation() throws Exception {
                super.inOperation();
                //打开任务列表
                result=mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"打开任务列表",200);

                //提示 确定或取消选项
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    //不选择
                    result=mFairy.findPic(397,305,865,400,new String[]{"word hint already finish.png"});//已经完成
                    if(result.sim>0.8f){
                        return;
                    }

                    //点击确定（退出退伍，退出退伍并退出副本，退出未结束的副本，不加好友，退出战斗）
                    result=util.findPic(397,305,865,400,
                            new String[]{"word hint exit team.png","word hint exit copy.png","word later.png","word weituo1.png","word hint already full.png",
                                    "word hint schedule.png","word none over.png","word hint no friend.png","word hint exit fight.png"});
                    if(result.sim>0.8f){
                        result=mFairy.findPic(702,468,818,524,"word affirm.png");
                        mFairy.onTap(0.8f,result,"确定",500);
                        return;
                    }

                    result=mFairy.findPic(430,439,583,550,new String []{"word cancel.png","word cancel1.png"});
                    mFairy.onTap(0.8f,result,"取消",200);
                }

                result=mFairy.findPic(new String[]{"pic word award.png","word get award.png"});
                mFairy.onTap(0.8f,result,"领取奖励",200);

                //获得物品，使用
                result=mFairy.findPic("word use.png");
                if(result.sim>0.8f){
                    result1=util.findPic(972,489,1112,524,new String[]{"word use zixuanhe.png","word use zixuan.png"});
                    if(result1.sim>0.8f){
                        result = mFairy.findPic(1111, 342, 1167, 403, "pic close1.png");
                        mFairy.onTap(0.8f,result,"不使用",100);
                    }else{
                        mFairy.onTap(0.8f,result,"使用",100);
                    }
                }

                //使用道具
                result=mFairy.findPic("word use2.png");
                if(result.sim>0.8){
                    result=mFairy.findPic("word max.png");
                    mFairy.onTap(0.8f,result,"最大",200);

                    result=mFairy.findPic("word affirm use.png");
                    mFairy.onTap(0.8f,result,"确认使用",200);
                }
            }

            void over(String info) throws  Exception{
                LtLog.e(mFairy.getLineInfo(info));
                successCount=failureCount=0;
                taskList.remove(0);
                isJoinTeam=false;
                setTaskName(0);
            }
        }.taskContent(mFairy);
    }
}
