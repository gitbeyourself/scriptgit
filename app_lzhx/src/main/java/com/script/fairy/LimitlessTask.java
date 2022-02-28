package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask extends com.script.framework.TaskContent {//无限任务

    private AtFairyImpl mFairy;
    private FindResult result;
    private SingleTask singleTask;
    private GamePublicFuntion gamePublicFuntion;
    private TeamTask teamTask;
    private int hour;
    private int minute;
    private int week;

    public LimitlessTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gamePublicFuntion = new GamePublicFuntion(mFairy);
        teamTask = new TeamTask(mFairy);
        singleTask = new SingleTask(mFairy);
    }

    /**
     * guaji
     */
    private int map = 1;
    TaskContent.ControlSplit hkCos = null;
    TaskContent.ControlSplit syrCos = null;

    private boolean reset = true;
    private boolean qian = true;
    public static boolean HK = true;
    public static boolean SYR = true;

    public void guaji() throws Exception {
        new TaskContent(mFairy, "挂机") {

            void create() throws Exception {
                super.create();
                if (!AtFairyConfig.getOption("map").equals("")) {
                    map = Integer.parseInt(AtFairyConfig.getOption("map"));
                }

                if (!AtFairyConfig.getOption("hkTime").equals("")) {
                    hkCos = new ControlSplit(AtFairyConfig.getOption("hkTime"));
                }

                if (!AtFairyConfig.getOption("syrTime").equals("")) {
                    syrCos = new ControlSplit(AtFairyConfig.getOption("syrTime"));
                }
                HK = true;
                SYR = true;
                go1 = 0;
                go2 = 0;
                go3 = 0;
                go4 = 0;
                go5 = 0;
                go6 = 0;
                go7 = 0;
                go8 = 0;
                go9 = 0;
                go10 = 0;
                go11 = 0;
                go12 = 0;
                go13 = 0;
                go14=0;
            }

            void init() throws Exception {
                super.init();
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void inOperation() throws Exception {
                long l = mFairy.getColorNum(4, 710, 242, 719, "248,248,248", 0.98f);
                if (l > 200) {
                    err = 0;
                    gamePublicFuntion.chat = 0;
                    mFairy.initMatTime();
                }

                result = mFairy.findPic(409, 240, 836, 385, "jia1.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(558, 344, 574, 364, "不在提示", 500);
                    mFairy.onTap(529, 418, 568, 427, "拒绝添加好友", 500);
                }

                skip();

                result = mFairy.findPic("fuhuo.png");
                mFairy.onTap(0.85f, result, "复活", 300);

                result = mFairy.findPic("use.png");
                mFairy.onTap(0.85f, result, "使用", 300);

                result = mFairy.findPic("nn14.png");
                mFairy.onTap(0.85f, result, "领取", 300);

                result = mFairy.findPic("nn2.png");
                mFairy.onTap(0.85f, result, "立刻穿戴", 1000);

                result = mFairy.findPic("nn15.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(820, 243, 868, 262, "升级好礼", 500);
                    mFairy.onTap(1218, 24, 1240, 42, "", 500);
                }
                result = mFairy.findPic(new String[]{"xiazai.png","xiazai1.png","xiazai3.png"});
                if(result.sim>0.85f){
                    mFairy.onTap(720,436,744,447,"确定",500);
                }else {
                    gamePublicFuntion.qx();
                }
                if (guajiTask()) {
                    setTaskName(0);
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(10, 0);

                result = mFairy.findPic("rank4.png");
                mFairy.onTap(0.85f, result, "创建队伍", 500);

                result = mFairy.findPic("rank11.png");
                mFairy.onTap(0.95f, result, "队伍信息", 500);

                result = mFairy.findPic("rank7.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic(new String[]{"rank5.png", "rank6.png"});
                    if (result.sim > 0.85f) {
                        result = mFairy.findPic("lirank.png");
                        mFairy.onTap(0.85f, result, "离开队伍", 500);
                        mFairy.onTap(707, 430, 737, 447, "", 500);
                    } else {
                        result = mFairy.findPic(316, 432, 1136, 610, "lixian1.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, "踢出队伍", 500);
                            mFairy.onTap(712, 428, 738, 444, "", 1000);
                        }

                        result = mFairy.findPic(316, 285, 1097, 400, "lixian.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, "离线", 800);
                            return;
                        } else {
                            mFairy.onTap(814, 638, 889, 655, "发起跟随", 1200);
                            mFairy.onTap(713, 433, 743, 446, "", 500);
                            mFairy.onTap(1118, 47, 1144, 82, "人数达到需求", 200);
                            setTaskName(2);
                            return;
                        }
                    }
                } else {
                    gamePublicFuntion.clickRank();
                }

            }

            void content_02() throws Exception {
                timeCount(5, 0);

                result = mFairy.findPic("map.png");
                if (result.sim > 0.85f) {
                    err = 0;

                    result = mFairy.findPic(864, 266, 1085, 523, "map1.png");
                    if (result.sim > 0.85f) {
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(1076, 501, 1233, 628, "map2.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "进入", 3000);
                        setTaskName(3);
                        return;
                    }

                    switch (map) {
                        case 1:
                            mFairy.onTap(108, 233, 173, 249, "古龙冰洞", 2000);
                            break;
                        case 2:
                            mFairy.onTap(338, 204, 393, 211, "西伯利亚林地", 2000);
                            break;
                        case 3:
                            mFairy.onTap(546, 130, 599, 145, "尼伯龙根岩窟", 2000);
                            break;
                        case 4:
                            mFairy.onTap(506, 252, 561, 268, "海底高天原", 2000);
                            break;
                        case 5:
                            mFairy.onTap(346, 457, 410, 473, "东京街道", 2000);
                            break;
                        case 6:
                            mFairy.onTap(547, 420, 607, 433, "青铜宫殿", 2000);
                            break;
                        case 7:
                            mFairy.onTap(820, 547, 834, 576, "", 1000);
                            mFairy.onTap(120, 235, 178, 249, "东京窄巷", 2000);
                            break;
                        case 8:
                            mFairy.onTap(820, 547, 834, 576, "", 1000);
                            mFairy.onTap(327, 200, 384, 210, "命运十字", 2000);
                            break;
                    }

                    for (int i = 0; i < 2; i++) {
                        mFairy.onTap(1050, 383, 1093, 414, "", 200);
                    }

                    Thread.sleep(1000);
                } else {
                    if (gamePublicFuntion.mainScene()) {
                        mFairy.onTap(240, 47, 259, 57, "点击训练", 1500);
                    }
                }
            }

            void content_03() throws Exception {
                timeCount(10, 0);

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }

                result = mFairy.findPic(631, 138, 727, 274, "gj1.png");
                if (result.sim > 0.85f) {
                    if (frequencyMap("施法异常", 5)) {
                        gamePublicFuntion.tuoli();
                    }
                }

                if (gamePublicFuntion.judgeStop(5) == false) {
                    frequencyInit("施法异常");
                }

            }

            void content_04() throws Exception {
            }//content
        };

    }//挂机

    private int go1, go2, go3, go4, go5, go6, go7, go8, go9, go10, go11, go12, go13,go14 = 0;

    public boolean guajiTask() throws Exception {
        boolean bools = false;
        while (true) {
            week = mFairy.week();
            hour = mFairy.dateHour();
            minute = mFairy.dateMinute();

            if(hour == 0 || hour ==24){/**重置任务*/
                if(reset) {
                    create();
                    reset = false;
                    return true;
                }
            }else{
                reset=true;
            }


            if(hour == 23 && minute >=30){/**签到*/
                if(qian) {
                    singleTask.qian();
                    qian = false;
                    return true;
                }
            }else{
                qian=true;
            }

            if (AtFairyConfig.getOption("4869").equals("1") && HK) {
                if (TaskContent.timeMap("hktime",hkCos.timeMillis)) {
                    singleTask.hkxdt();
                    bools = false;
                    gamePublicFuntion.init(0,false);
                    continue;
                }
            }

            if (AtFairyConfig.getOption("4915").equals("1") && SYR) {
                if (TaskContent.timeMap("syrtime",syrCos.timeMillis)) {
                    singleTask.syrxs();
                    bools = false;
                    gamePublicFuntion.init(0,false);
                    continue;
                }
            }

            if (AtFairyConfig.getOption("yxls").equals("1") && go4 == 0) {/**游行猎手*/
                if ((week == 2 || week == 4) &&
                        hour == 12 &&
                        (minute >= 30 && minute < 50)) {
                    singleTask.yxls();
                    bools = true;
                    go4 = 1;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("bhst").equals("1") && go5 == 0) {/**崩坏社团*/
                if ((week == 1 || week == 3 || week == 5) &&
                        hour == 12 &&
                        (minute >= 30 && minute < 50)) {
                    singleTask.bhst();
                    bools = true;
                    go5 = 1;
                    continue;
                }
            }


            if (AtFairyConfig.getOption("zdzx").equals("1") && go1 == 0) {
                if (hour == 12 || hour == 13 || hour == 19 || hour == 20 || hour == 21) {/**躁动之血*/
                    teamTask.zdzx();
                    bools = true;
                    go1 = 1;
                    continue;
                }
            }


            if (AtFairyConfig.getOption("yhsj").equals("1") && go2 == 0) {
                if (hour == 12 || hour == 13 || hour == 19 || hour == 20 || hour == 21) {/**业海杀机*/
                    teamTask.yhsj();
                    bools = true;
                    go2 = 1;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("lzst").equals("1") && go3 == 0) {
                if ((hour >= 8 && hour <= 20) && (minute >= 0 && minute <= 10) || (minute >= 30 && minute <= 40)) {/**龙之使徒*/
                    teamTask.lzst();
                    bools = true;
                    go3 = 1;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("sxjjc").equals("1") && go6 == 0) {//实训竞技场
                if (week == 3 && hour == 22 && minute < 30) {
                    singleTask.sxjjc();
                    bools = true;
                    go6 = 1;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("cszy").equals("1") && go7 == 0) {//车神之役
                if ((week == 6 || week == 7)
                        && (hour >= 13 && hour <= 22)
                        && (minute >= 30 && minute < 40)) {
                    if (singleTask.cszy()) {
                        go7 = 1;
                    }
                    bools = true;
                    continue;
                }
            }


            if (AtFairyConfig.getOption("zhsl").equals("1") && go8 == 0) {/**智慧沙龙*/
                if (hour >= 12) {
                    singleTask.zhsl();
                    go8 = 1;
                    bools = true;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("bgsq").equals("1") && go9 == 0) {/**八卦社区*/
                if ((week >= 1 && week <= 4)
                        && (hour >= 20 && hour <= 24)) {
                    singleTask.bgsq();
                    go9 = 1;
                    bools = true;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("bgzw").equals("1") && go10 == 0) {/**八卦之王*/
                if ((week >= 5 && week <= 7)
                        && (hour >= 20 && hour <= 24)) {
                    singleTask.bgzw();
                    go10 = 1;
                    bools = true;
                    continue;
                }
            }


            if (AtFairyConfig.getOption("bgyx").equals("1") && go14 == 0) {//百鬼夜行
                if ((week == 3)
                        && (hour == 21)
                        && (minute < 30)) {
                    teamTask.bgyx();
                    go14 = 1;
                    bools = true;
                    continue;
                }
            }




            if (AtFairyConfig.getOption("jddf").equals("1") && go11 == 0) {//极道巅峰
                if ((week == 1 || week == 5)
                        && (hour == 21)
                        && (minute < 40)) {
                    teamTask.jddf();
                    go11 = 1;
                    bools = true;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("jdbyj").equals("1") && go12 == 0) {//京东·白月境
                if (week == 6
                        && (hour == 22)
                        && (minute < 40)) {
                    singleTask.jdbyj();
                    go12 = 1;
                    bools = true;
                    continue;
                }
            }

            if (AtFairyConfig.getOption("jjbwt").equals("1") && go13 == 0) {//紧急保卫团
                if (week == 6
                        && (hour == 20 && minute > 55)
                        || (hour == 21 && minute < 30)) {
                    singleTask.jjbwt();
                    go13 = 1;
                    bools = true;
                    continue;
                }
            }
            return bools;
        }
    }//挂机限时任务


}