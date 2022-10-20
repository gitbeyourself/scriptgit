package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    Util util;

    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }

    abstract class  limitlessTaskContent extends TaskContent {
        public limitlessTaskContent(AtFairyImpl mFairy) throws Exception {
            super(mFairy);
        }
        @Override
        void create() throws Exception {

        }

        @Override
        void init() throws Exception {
            util.signOutXX();
            setTaskName(1);
        }

        @Override
        void inOperation() throws Exception {
          //  LtLog.e(mFairy.getLineInfo("list===" + list.toString()));
        }

        @Override
        void content_01() throws Exception {
            setTaskName(2);
        }
        @Override
        void content_02() throws Exception {
            setTaskName(3);
        }
    }

    public void field() throws Exception {
        new limitlessTaskContent(mFairy) {
            long dazeTime = 0;
            long  lxtime=0;
            int hdcount=0;
            String strSub2="";
            String xxmap="";
            @Override
            void create() throws Exception {
                timingActivity.timingActivity();
                TASKNAME = "修行挂机中";
                super.create();
                if (AtFairyConfig.getOption("map").equals("1")){
                    strSub2="map1.png";
                    xxmap="xxmap1.png";
                }
                if (AtFairyConfig.getOption("map").equals("2")){
                    strSub2="map2.png";
                    xxmap="xxmap2.png";
                }
                if (AtFairyConfig.getOption("map").equals("3")){
                    strSub2="map3.png";
                    xxmap="xxmap3.png";
                }
                if (AtFairyConfig.getOption("map").equals("4")){
                    strSub2="map4.png";
                    xxmap="xxmap4.png";
                }
                if (AtFairyConfig.getOption("map").equals("5")){
                    strSub2="map5.png";
                    xxmap="xxmap5.png";
                }
                if (AtFairyConfig.getOption("map").equals("6")){
                    strSub2="map6.png";
                    xxmap="xxmap6.png";
                }
                if (AtFairyConfig.getOption("map").equals("7")){
                    strSub2="map7.png";
                    xxmap="xxmap7.png";
                }
            }

            void content_03() throws Exception {
                util.target("队长","日常","Practice.png","");
                setTaskName(4);
            }
            void content_04() throws Exception {
                int ret = util.findTask("xx.png", "前往","日常", "全部");
                if (ret == 1) {
                    mFairy.initMatTime();
                    setTaskName(5);
                    return;
                }
            }
            void content_05() throws Exception {
                overtime(10,0);
                result = mFairy.findPic("xx_inface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "修行场景"));
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("sb").equals("1")){
                        result = mFairy.findPic("double.png");
                        mFairy.onTap(0.8f, result, "开启双倍", 1000);
                    }
                    if (AtFairyConfig.getOption("sb").equals("2")){
                        result = mFairy.findPic("double.png");
                        if (result.sim<0.8f){
                            mFairy.onTap(458,549,475,564,"关闭双倍", 1000);
                        }
                    }
                    result = mFairy.findPic(170,397,1119,536,xxmap);
                    LtLog.e(mFairy.getLineInfo(0.95f, result, "找到地图" + xxmap));
                    if (result.sim > 0.95f) {
                        setTaskName(6);
                        return;
                    }
                    for (int i = 0; i < 2; i++) {
                        mFairy.touchDown(2,293,311);
                        mFairy.touchMove(2,987,309,2000);
                        mFairy.touchUp(2);
                    }
                    setTaskName(6);
                }
            }
            void content_06() throws Exception {
                overtime(20,0);
                result1 = mFairy.findPic("xx_inface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "修行场景"));
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(170,397,1119,536,xxmap);
                    LtLog.e(mFairy.getLineInfo(0.95f, result, "找到地图" + xxmap));
                    if (result.sim > 0.95f) {
                        mFairy.onTap(0.95f, result,result.x-42,result.y-208,result.x+3,result.y-166,"选择地图", 1000);
                        mFairy.onTap(0.95f, result,968,539,1022,565,"开始修行", 1000);
                        result = mFairy.findPic(310,216,988,281,"Inability to participate.png");
                        if (result.sim > 0.75f) {
                            LtLog.e(mFairy.getLineInfo("无法参与退队"));
                            util.outTeam();
                            setTaskName(0);
                        }
                        setTaskName(7);
                    }else {
                        hdcount++;
                        if (hdcount == 2 || hdcount == 4 || hdcount == 6 || hdcount == 8) {
                            mFairy.touchDown(2,1011,319);
                            mFairy.touchMove(2,273,326,2000);
                            mFairy.touchUp(2);
                            LtLog.e(mFairy.getLineInfo("没有找到滑动一下"));
                            Thread.sleep(1000);
                        }
                        if (hdcount >= 12) {
                            util.close();
                            hdcount=0;
                        }
                    }
                }

            }
            void content_07() throws Exception {
                result = mFairy.findPic(383,222,920,535,"High Scene.png");
                mFairy.onTap(0.8f, result,714,424,755,448,"场景高确定", 1000);

                result = mFairy.findPic(310,216,988,281,"Inability to participate.png");
                if (result.sim > 0.75f) {
                    LtLog.e(mFairy.getLineInfo("无法参与退队"));
                    util.outTeam();
                    setTaskName(0);
                }

                overtime(50,0);
                result = mFairy.findPic(203,3,783,289,"activity.png");
                if (result.sim > 0.8f) {
                    dazeTime = mFairy.mMatTime(117, 48, 41, 14, 0.9f);
                    LtLog.e(mFairy.getLineInfo("发呆时间===" + dazeTime));
                    if (dazeTime>20){
                        setTaskName(0);
                    }
                    err = 0;
                } else {
                    mFairy.initMatTime();
                    dazeTime=0;
                }
                result = mFairy.findPic("In battle.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    err = 0;
                }

                result = mFairy.findPic(383,222,920,535,"High Scene.png");
                mFairy.onTap(0.8f, result,714,424,755,448,"场景高确定", 1000);

                result = mFairy.findPic(383,222,920,535,"Multiple times.png");
                if (result.sim>0.8f){
                    if (AtFairyConfig.getOption("sb").equals("1")){
                        mFairy.onTap(0.8f, result,711,427,766,447,"多倍开", 1000);
                    }else {
                        mFairy.onTap(0.8f, result,517,425,567,446,"多倍取消", 1000);
                    }
                }
                int ret=timingActivity.timingActivity();
                if (ret==1){
                    setTaskName(0);
                    return;
                }
                if ((System.currentTimeMillis()-lxtime)>300000){
                    result = mFairy.findPic("taskbar.png");
                    mFairy.onTap(0.95f, result, 1164, 114, 1201, 128, "切换到队伍栏", 1000);

                    result = mFairy.findPic(new String[]{"teambar.png","teambar1.png"});
                    if (result.sim > 0.9f) {
                        LtLog.e(mFairy.getLineInfo("在队伍栏"));
                        for (int i1 = 0; i1 < 3; i1++) {
                            result = mFairy.findPic(1188, 147, 1269, 515, "Off-line.png");
                            mFairy.onTap(0.8f, result, "离线", 2000);
                            if (result.sim > 0.8f) {
                                i1 = 1;
                            }

                            result = mFairy.findPic(829, 117, 1042, 644, "Please leave the team.png");
                            mFairy.onTap(0.8f, result, "请离队伍", 1000);
                            if (result.sim > 0.8f) {
                                i1 = 1;
                            }

                            result = mFairy.findPic(383, 222, 920, 535, "Make sure you leave.png");
                            mFairy.onTap(0.8f, result, 710, 426, 765, 449, "确定请离", 1000);
                            if (result.sim > 0.8f) {
                                i1 = 1;
                            }
                        }
                    }
                    lxtime=System.currentTimeMillis();
                }
            }
        };
    }
}
