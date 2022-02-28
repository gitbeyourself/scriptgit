package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends  TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    FindResult result1;
    Util util;
    static List<String> taskList = new ArrayList<>();
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        mFairy1 = ypFairy;
    }
    //精英试炼
    public void jysl()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            String task="";
            int failureCount=0;
            /**1、不组队 2、创建队伍 3、匹配跟随*/
            int teamType=1;
            List<String> list=new ArrayList();
            @Override
            public void create() throws Exception {
                if(AtFairyConfig.getOption("jysl_whz").equals("1"))list.add("whz");//王宏照
                if(AtFairyConfig.getOption("jysl_qyx").equals("1"))list.add("qyx");//秦以璇
                if(AtFairyConfig.getOption("jysl_cy").equals("1"))list.add("cy");//陈玉
                if(AtFairyConfig.getOption("jysl_hl").equals("1"))list.add("hl");//贺玲
                if(AtFairyConfig.getOption("jysl_zh").equals("1"))list.add("zh");//赵环
                if(AtFairyConfig.getOption("jysl_wy").equals("1"))list.add("wy");//王娅
                if(AtFairyConfig.getOption("jysl_qym").equals("1"))list.add("qym");//秦以玫
                if(AtFairyConfig.getOption("jysl_lqq").equals("1"))list.add("lqq");//冷清秋
                if(AtFairyConfig.getOption("jysl_wm").equals("1"))list.add("wm");//王茂
                if(AtFairyConfig.getOption("jysl_lh").equals("1"))list.add("lh");//林婳
                if(AtFairyConfig.getOption("jysl_lmc").equals("1"))list.add("lmc");//李明成

                if(!AtFairyConfig.getOption("teamType").equals("")){
                    teamType =Integer.parseInt(AtFairyConfig.getOption("teamType"));
                }
                if(list.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有挑战对象了，任务结束"));
                    setTaskEnd();
                    return;
                }
                exit_team();
            }

            @Override
            public void content_0() throws Exception {
                if(list.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有挑战对象了，任务结束"));
                    setTaskEnd();
                    return;
                }
                if(!list.get(0).equals(task)){
                    task=list.get(0);
                    failureCount=0;
                }
                util.close();
                util.initDaze();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(812,51,934,74,"word btn daily.png");
                mFairy.onTap(0.8f,result,"进入日常",1000);

                result=mFairy.findPic("word jysl.png");
                mFairy.onTap(0.8f,result,"切换精英试炼分页",1000);

                //精英试炼分页
                result=mFairy.findPic("word jysl1.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word jysl count zero.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1143,88,1151,98,"没有奖励次数了，任务结束",1000);
                        setTaskEnd();
                        return;
                    }

                    //已经选中
                    result=mFairy.findPic("word jysl "+task+"1.png");
                    if(result.sim>0.8f){
                        if(teamType==1){
                            result=mFairy.findPic(898,594,979,651,"word btn go1.png");
                            mFairy.onTap(0.8f,result,"一个人前往",1000);
                        }
                        if(teamType==2||teamType==3){
                            result=mFairy.findPic(680,594,760,645,"word btn go1.png");
                            mFairy.onTap(0.8f,result,"前往组队",1000);
                        }
                        util.initDaze();
                        setTaskName(2);
                        return;
                    }

                    result=mFairy.findPic(245,140,341,610,"word jysl "+task+".png");
                    if(result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, "选中" + task, 1000);
                        return;
                    }else{
                        mFairy.ranSwipe(311,548,316,332,1000,1500l,1);
                        LtLog.e(mFairy.getLineInfo("没有找到，向下滑动"));
                    }

                    //滑到最底部了
                    result=mFairy.findPic("word jysl whz.png");
                    if(result.sim>0.8f){
                        if(task.equals("whz")){
                            mFairy.onTap(0.8f, result, "选中" + task, 1000);
                            return;
                        }

                        LtLog.e(mFairy.getLineInfo("初始化滑动"));
                        for(int i=1;i<=2;i++){
                            mFairy.ranSwipe(311,232,311,548,1000,500l,1);
                        }
                        return;
                    }
                }
                overtime(15,0);
            }

            @Override
            public void content_2() throws Exception {
                if(teamType==1){
                    result=mFairy.findPic(898,594,979,651,"word btn go1.png");
                    int picCount=picCount(0.8f,result,"jysl go");
                    mFairy.onTap(0.8f,result,"一个人前往",1000);
                    if(picCount>=3){
                        LtLog.e(mFairy.getLineInfo("无法前往，执行下一个"));
                        list.remove(0);
                        setTaskName(0);
                        return;
                    }
                }

                result=mFairy.findPic("word jysl role zero.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1085,240,1098,251,task+"没有挑战次数，切换下一个",1000);
                    list.remove(0);
                    setTaskName(0);
                    return;
                }

                result=mFairy.findPic("word dont challenge.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1085,240,1098,251,task+"等级差距过大，无法挑战",1000);
                    list.remove(0);
                    setTaskName(0);
                    return;
                }

                result=mFairy.findPic(684,492,778,543,"word btn challenge.png");
                mFairy.onTap(0.8f,result,"挑战",1000);

                if(daze>10){
                    LtLog.e(mFairy.getLineInfo("任务超时，重新找任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("pic failure.png");
                int picCount=picCount(0.8f,result,"failure");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"失败"+failureCount+"次",1000);
                    if(picCount==1&&++failureCount>=2){
                        LtLog.e(mFairy.getLineInfo("连续失败两次，任务结束"));
                        list.remove(0);
                        setTaskName(0);
                        return;
                    }
                }

                result=mFairy.findPic("pic success.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"成功",1000);
                    failureCount=0;
                    setTaskName(1);
                }
                daze = util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"精英试炼");
    }

    //退出队伍
    public void exit_team()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                return;
            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic("pic team.png");
                mFairy.onTap(0.8f,result,"切换队伍分页",1000);

                result=mFairy.findPic("word search team.png");
                mFairy.onTap(0.8f,result,1130,89,1143,101,"关闭搜索队伍界面",1000);

                result=mFairy.findPic("pic team1.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic team match.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("退出队伍完成"));
                        setTaskEnd();
                        return;
                    }else{
                        result=mFairy.findPic(26,323,78,448,"word team leave.png");
                        mFairy.onTap(0.8f,result,"离队",1000);
                    }
                }
                overtime(10,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint exit team.png");
                mFairy.onTap(0.8f,result,632,520,640,528,"确定",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"退出队伍");
    }
}
