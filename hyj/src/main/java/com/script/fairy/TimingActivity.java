package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    boolean scn=true;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }


    /**
     *  首领挑战 Chieftain challenge
     */
    public void  chieftainChallenge()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Chieftain challenge.png",2);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Chieftain challenge2.png",0);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim >= 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (result1.sim < 0.8f) {
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 541,284,550,305, "点击boss", 2000);
                }
                result = mFairy.findPic("boss tz.png");
                mFairy.onTap(0.8f,result,"开始挑战",2000);

                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",2000);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Chieftain challenge2.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"首领挑战");
    }

    /**
     *  众志成城 fortress
     */

    public void   fortress()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("fortress.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    LtLog.e("任务完成了");
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("fortress.png");
                mFairy.onTap(0.8f,result,"进入副本",Sleep);

                result = mFairy.findPic("Matching.png");
                if (result.sim > 0.8f){
                    LtLog.e("匹配中。。。。");
                    mFairy.initMatTime();
                }

                result = mFairy.findPic("Get ready.png");
                mFairy.onTap(0.8f,result,"准备",200);

                result1 = mFairy.findPic(new String[]{"leavezzcc.png","Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy,"众志成城");
    }

    /**
     *  沙场点兵 Battlefield troops
     */
    public void   battlefieldTroops()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("Battlefield troops.png",1);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    LtLog.e("任务完成了");
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Personal registration.png");
                mFairy.onTap(0.8f,result,"个人报名",Sleep);

                result = mFairy.findPic("Matching.png");
                if (result.sim > 0.8f){
                    LtLog.e("匹配中。。。。");
                    mFairy.initMatTime();
                }

                result = mFairy.findPic("Get ready.png");
                mFairy.onTap(0.8f,result,"准备",200);

                if (dazeTime >= 30){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
                    mFairy.onTap(0.75f,result,632,366,645,374,"去战场",2000);
                    mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 40 && result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("Activeinterface.png");
                if (result.sim > 0.8f){
                    gameUtil.close();
                }
            }
        }.taskContent(mFairy,"沙场点兵");
    }
}
