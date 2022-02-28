package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;


/**
 * Created by user on 2019/6/3.
 */

public class TeamTask {
    public GamePublicFuntion gamePublicFuntion;
    public FindResult result;
    public AtFairyImpl mFairy;
    public LimitlessTask limitlessTask;
    public SingleTask singleTask;
    private int hour;
    private int minute;
    private int week;
    public TeamTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gamePublicFuntion = new GamePublicFuntion(atFairy);
        singleTask = new SingleTask(atFairy);
    }

    private int activityType = 1;
    private String activityName = "";
    private boolean rankBool = false;
    private boolean gen = false;

    /**
     * 带队
     */
    class TeamTaskContent extends TaskContent {

        public TeamTaskContent(AtFairyImpl mFairy, String name) throws Exception {
            super(mFairy, name);
        }

        void create() throws Exception {
            super.create();
            activityType = 1;
        }

        Boolean activityEnd(FindResult result) throws Exception {

            return false;
        }

        void init() throws Exception {
            super.init();
            oneSecond = 0;
            gamePublicFuntion.actInitSlide = true;
            gamePublicFuntion.init(1,true);
            setTaskName(1);

        }

        void content_01() throws Exception {
            if (timeCount(8, 0)) {
                if (frequencyMap("活动计次1",2)) {
                    setTaskEnd();
                    return;
                }
            }

            result = mFairy.findPic("rank0.png");
            mFairy.onTap(0.96f, result,1240,94,1251,118, "目标", 500);

            if (Abnormal.HONG) {
                if (gamePublicFuntion.hong()) {
                    Thread.sleep(1000);
                    err = 0;
                    return;
                }
            }
            if (gamePublicFuntion.fuben()) {
                setTaskName(0);
                return;
            }

            result = mFairy.findPic(545, 18, 911, 94, new String[]{"activity.png", "activity4.png"});
            if (result.sim > 0.75f) {
                mFairy.onTap(0.75f, result, "活动按钮", 300);
                gamePublicFuntion.actInitSlide = false;
            }

            result = mFairy.findPic("activity2.png");
            mFairy.onTap(0.85f, result, "提示框", 300);

            result = mFairy.findPic("activity3.png");
            mFairy.onTap(0.85f, result, "eva 提示", 300);

            result = mFairy.findPic("use.png");
            mFairy.onTap(0.85f, result, "使用", 300);

            result = mFairy.findPic("activity1.png");
            if (result.sim > 0.85f) {

                if (oneSecond()) {
                    gamePublicFuntion.ChoiceActivityType(activityType);

                    for (int i = 0; i < 6; i++) {
                        result = mFairy.findPic(413, 638, 976, 671, "activity5.png");
                        if (result.sim > 0.85f) {
                            mFairy.tap(result.x - 20, result.y + 20);
                            Thread.sleep(300);
                            if (mapCount(0.8f, 584, 136, 650, 305, "man1.png")) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }

                }

                FindResult act = mFairy.findPic(383, 111, 1229, 481, activityName);
                if (act.sim > 0.9f) {

                    if (activityEnd(act)) {
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70, "can.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(1211, 45, 1229, 62, "次任务可以参加>>>", 500);
                        setTaskName(2);
                        oneSecond=0;
                        return;
                    }


                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70,
                            new String[]{"wan.png", "ji.png"});
                    if (result.sim > 0.85f) {
                        setTaskEnd();
                        return;
                    }
                }


                if (gamePublicFuntion.actInitSlide) {
                    activitySlide.slideRange(new int[]{2, 3, 4, 5, 6}, 2, 0);
                } else {
                    activitySlide.slideRange(new int[]{3, 4, 5, 6}, 2);
                }
            }
        }

        boolean rank(int i, String str1, String str2) throws Exception {

            result = mFairy.findPic("rank4.png");
            mFairy.onTap(0.85f, result, "创建队伍", 500);

            FindResult pp = mFairy.findPic("rank10.png");
            if (pp.sim > 0.85f && rankBool) {
                err = 0;
                if (str1 != null) {
                    result = mFairy.findPic(119, 53, 327, 640, str1);
                    if (result.sim > 0.95f) {
                        mFairy.onTap(0.95f, result, "str1 >>>", 500);
                        return false;
                    }
                }

                result = mFairy.findPic(119, 53, 327, 640, str2);
                if (result.sim > 0.7f) {
                    mFairy.onTap(0.7f, result, "找到匹配的任务", 500);

                    result = mFairy.findPic("rank17.png");
                    mFairy.onTap(0.85f, result, "自动匹配", 500);

                    rankBool = false;
                    return false;
                }

                if (frequencyMap("队伍计次",2)) {
                    mFairy.ranSwipe(218, 221, 246, 464, 2, 500, (long)500);
                }
                return false;
            } else {
                result = mFairy.findPic("rank11.png");
                mFairy.onTap(0.95f, result, "队伍信息", 500);
            }


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
                        return false;
                    } else {
                        if (gamePublicFuntion.ranksNum() >= i) {
                            mFairy.onTap(814, 638, 889, 655, "发起跟随", 1200);
                            mFairy.onTap(713, 433, 743, 446, "", 500);
                            mFairy.onTap(1118, 47, 1144, 82, "人数达到需求", 200);
                            return true;
                        }

                        if (timeMap("rankTime",30000)) {
                            rankBool = true;
                            result = mFairy.findPic(542, 587, 997, 708, "rank9.png");
                            mFairy.onTap(0.85f, result, "前往匹配", 500);
                        }
                    }
                }
            } else {
                gamePublicFuntion.clickRank();
            }
            return false;
        }//队伍

        void content_03() throws Exception {
            if (timeCount(8, 3)) {
                gamePublicFuntion.init(1,true);
                if (frequencyMap("活动计次2",2)) {
                    setTaskEnd();
                    return;
                }
            }

            result = mFairy.findPic("rank0.png");
            mFairy.onTap(0.96f, result,1240,94,1251,118, "目标", 500);

            if (Abnormal.HONG) {
                if (gamePublicFuntion.hong()) {
                    Thread.sleep(1000);
                    err = 0;
                    return;
                }
            }
            if (gamePublicFuntion.fuben()) {
                gamePublicFuntion.init(1,true);
                return;
            }

            result = mFairy.findPic(545, 18, 911, 94, new String[]{"activity.png", "activity4.png"});
            if (result.sim > 0.75f) {
                mFairy.onTap(0.75f, result, "活动按钮", 300);
                gamePublicFuntion.actInitSlide = false;
            }

            result = mFairy.findPic("activity2.png");
            mFairy.onTap(0.85f, result, "提示框", 300);

            result = mFairy.findPic("activity3.png");
            mFairy.onTap(0.85f, result, "eva 提示", 300);

            result = mFairy.findPic("use.png");
            mFairy.onTap(0.85f, result, "使用", 300);

            result = mFairy.findPic("activity1.png");
            if (result.sim > 0.85f) {

                if (oneSecond()) {
                    gamePublicFuntion.ChoiceActivityType(activityType);

                    for (int i = 0; i < 6; i++) {
                        result = mFairy.findPic(413, 638, 976, 671, "activity5.png");
                        if (result.sim > 0.85f) {
                            mFairy.tap(result.x - 20, result.y + 20);
                            Thread.sleep(300);
                            if (mapCount(0.8f, 584, 136, 650, 305, "man1.png")) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }

                FindResult act = mFairy.findPic(383, 111, 1229, 481, activityName);
                if (act.sim > 0.9f) {

                    if (activityEnd(act)) {
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70, "can.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "参加", 1000);
                        oneSecond=0;
                        setTaskName(4);
                        return;
                    }

                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70,
                            new String[]{"wan.png", "ji.png"});
                    if (result.sim > 0.85f) {
                        setTaskEnd();
                        return;
                    }
                }

                if (gamePublicFuntion.actInitSlide) {
                    activitySlide.slideRange(new int[]{2, 3, 4, 5, 6}, 2, 0);
                } else {
                    activitySlide.slideRange(new int[]{3, 4, 5, 6}, 2);
                }
            }
        }

        void inOperation() throws Exception {

            long l = mFairy.getColorNum(4, 710, 242, 719, "248,248,248", 0.98f);
            if (l > 200) {
                err = 0;
                gamePublicFuntion.chat = 0;
                mFairy.initMatTime();
            }
            result = mFairy.findPic(624, 191, 670, 267, "lv.png");
            if (result.sim > 0.8f) {
                err = 0;
            }

            result = mFairy.findPic(409, 240, 836, 385, "jia1.png");
            if (result.sim > 0.85f) {
                mFairy.onTap(558, 344, 574, 364, "不在提示", 500);
                mFairy.onTap(529, 418, 568, 427, "拒绝添加好友", 500);
            }

            skip();

            result = mFairy.findPic("fuhuo.png");
            mFairy.onTap(0.85f, result, "复活", 300);

            result = mFairy.findPic("zanli.png");
            mFairy.onTap(0.85f, result, "暂离执行", 300);

            result = mFairy.findPic("use.png");
            mFairy.onTap(0.85f, result, "使用", 300);

            result = mFairy.findPic("zudui.png");
            mFairy.onTap(0.85f, result, "继续", 300);

            result = mFairy.findPic("nn14.png");
            mFairy.onTap(0.85f, result, "领取", 300);

            result = mFairy.findPic("nn2.png");
            mFairy.onTap(0.85f, result, "立刻穿戴", 1000);

            result = mFairy.findPic("nn15.png");
            if (result.sim > 0.85f) {
                mFairy.onTap(820, 243, 868, 262, "升级好礼", 500);
                mFairy.onTap(1218, 24, 1240, 42, "", 500);
            }
        }

    }

    public void llxd() throws Exception {
        new TeamTaskContent(mFairy, "猎龙小队") {

            void create() throws Exception {
                super.create();
                activityName = "llxd.png";
                activityType = 1;
                tm.put("see", (long) 10);
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,true);
                }
                if (rank(3, null, "llxd1.png")) {
                    setTaskName(3);
                    return;
                }
            }

            Boolean activityEnd(FindResult result) throws Exception {
                if (AtFairyConfig.getOption("llxd").equals("2")) {
                    result = mFairy.findPic(result.x, result.y + 10, result.x + 150, result.y + 65, "llxd5.png");
                    if (result.sim > 0.95f) {
                        return true;
                    }
                }
                return false;
            }

            void inOperation() throws Exception {
                super.inOperation();

                FindResult qx = gamePublicFuntion.qxBool();
                if (qx.sim > 0.8f) {

                    result = mFairy.findPic(new String[]{"xiazai.png","xiazai1.png","xiazai3.png"});
                    if(result.sim>0.85f){
                        mFairy.onTap(720,436,744,447,"确定",500);
                        return;
                    }

                    result = mFairy.findPic("rank20.png");
                    if(result.sim>0.85f) {
                        mFairy.onTap(0.85f, result, 711,432,749,445,"确定发起跟随", 500);
                        return;
                    }

                    result = mFairy.findPic("llxd8.png");
                    if(result.sim>0.85f) {
                        mFairy.onTap(0.85f, result, "开启", 500);
                        return;
                    }

                    result = mFairy.findPic(624, 274, 911, 399, "dh5.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(721, 429, 762, 447, "确定放弃", 200);
                        return;
                    }

                    result = mFairy.findPic(439, 224, 871, 387, "rank8.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(715, 414, 740, 428, "同意入队", 500);
                        return;
                    }

                    result = mFairy.findPic( "llxd7.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(710,427,744,450, "开启行动力", 500);
                        return;
                    }

                    result = mFairy.findPic(384,293,833,379, "zudui1.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(713,434,750,450, "正在排队", 500);
                        return;
                    }

                    result = mFairy.findPic("dh6.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(715, 430, 743, 447, "确定匹配!", 500);
                        return;
                    }

                    mFairy.onTap(0.8f, qx, "取消", 500);
                }
            }

            boolean seeRank(String str1, String str2) throws Exception {
                result = mFairy.findPic("rank4.png");
                if (result.sim > 0.85f) {
                    setTaskName(0);
                    return true;
                }

                FindResult pp = mFairy.findPic("rank10.png");
                if (pp.sim > 0.85f) {
                    err = 0;
                    if (str1 != null) {
                        result = mFairy.findPic(119, 53, 327, 640, str1);
                        if (result.sim > 0.95f) {
                            mFairy.onTap(0.95f, result, "str1 >>>", 500);
                            return false;
                        }
                    }

                    result = mFairy.findPic(119, 53, 327, 640, str2);
                    if (result.sim > 0.7f) {
                        mFairy.onTap(0.7f, result, "找到匹配的任务", 500);

                        result = mFairy.findPic("rank17.png");
                        mFairy.onTap(0.85f, result, "自动匹配", 200);

                        return true;
                    }

                    if (frequencyMap("队伍计次2",2)) {
                        mFairy.ranSwipe(218, 221, 246, 464, 2, 500, (long)500);
                    }
                    return false;
                }


                result = mFairy.findPic("rank7.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic(new String[]{"rank5.png", "rank6.png"});
                    if (result.sim > 0.85f) {
                        result = mFairy.findPic("lirank.png");
                        mFairy.onTap(0.85f, result, "离开队伍", 500);
                        mFairy.onTap(707, 430, 737, 447, "", 500);
                        setTaskName(0);
                        return true;
                    } else {
                        result = mFairy.findPic(316, 432, 1136, 610, "lixian1.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, "踢出队伍", 500);
                            mFairy.onTap(712, 428, 738, 444, "", 1000);
                        }

                        result = mFairy.findPic(316, 285, 1097, 400, "lixian.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, "离线", 800);
                            return false;
                        } else {
                            result = mFairy.findPic(542, 587, 997, 708, "rank9.png");
                            mFairy.onTap(0.85f, result, "前往匹配", 500);
                        }
                    }
                } else {
                    gamePublicFuntion.clickRank();
                }
                return false;
            }//查看队伍

            void content_04() throws Exception {
                if (timeCount(10, 0)) {
                    gamePublicFuntion.init(0,false);
                    setTaskName(2);
                    return;
                }

                if (err > 3) {
                    oneSecond = 0;
                }

                if (timeMap("jihe",180000)) {
                    result = mFairy.findPic(946, 120, 985, 172, "jihe1.png");
                    mFairy.onTap(0.8f, result, "集合", 200);
                }


                result = mFairy.findPic(989, 225, 1142, 625, "llxd2.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    mFairy.onTap(0.85f, result, "猎龙小队", 500);
                    if (mapCount(0.8f, 620, 112, 675, 288, "llxd3.png")) {
                        mFairy.onTap(556, 521, 632, 570, "人数不足", 500);
                        setTaskName(2);
                    }
                }

                FindResult ll = mFairy.findPic("llxd4.png");
                if (ll.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic("llxd6.png");
                    if(result.sim>0.85f){
                        mFairy.onTap(0.85f,result,"开启双倍",500);
                        mFairy.onTap(709,428,752,443,"",500);
                    }

                    mFairy.onTap(0.85f, ll, "受命前往", 500);

                    if (mapCount(0.8f, 620, 112, 675, 288, "llxd3.png")) {
                        mFairy.onTap(556, 521, 632, 570, "人数不足", 500);
                        setTaskName(2);
                    }else{
                        Thread.sleep(3000);
                    }
                } else {
                    gamePublicFuntion.close();
                }

                result = mFairy.findPic(429, 268, 881, 393, "rank13.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(714, 429, 747, 447, "队伍没有跟随", 500);
                    mFairy.onTap(626, 285, 651, 306, "", 100);
                    mFairy.onTap(629, 374, 650, 394, "", 100);
                    mFairy.onTap(629, 459, 649, 479, "", 100);
                }

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();

                    if (oneSecond()) {
                        for (int i = 0; i < 3; i++) {
                            mFairy.ranSwipe(1096, 81, 1113, 229, 0, 500, (long)300);
                        }
                    }

                    if (gamePublicFuntion.judgeStop(3)) {
                        if (gamePublicFuntion.stop()) {
                            mFairy.onTap(1064, 78, 1124, 95, "点击任务区", 1000);
                        }
                    }

                    if (timeMap("see",300000)) {
                        for (int i = 0; i < 10; i++) {
                            inOperation();
                            if(seeRank(null, "llxd1.png")){
                                return;
                            }
                        }
                    }

                }

            }
        };
    }//猎龙小队

    public void mgsx() throws Exception {
        new TeamTaskContent(mFairy, "猛鬼苏醒") {

            void create() throws Exception {
                super.create();
                activityName = "mgsx.png";
                activityType = 1;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,true);
                }

                if (rank(3, null, "mgsx1.png")) {
                    setTaskName(3);
                    return;
                }
            }

            void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("rank7.png");
                if (result.sim < 0.85f) {
                    result = mFairy.findPic("rank0.png");
                    mFairy.onTap(0.96f, result,1240,94,1251,118, "目标", 500);
                }

                FindResult qx = gamePublicFuntion.qxBool();
                if (qx.sim > 0.8f) {

                    result = mFairy.findPic(new String[]{"xiazai.png","xiazai1.png","xiazai3.png"});
                    if(result.sim>0.85f){
                        mFairy.onTap(720,436,744,447,"确定",500);
                        return;
                    }

                    result = mFairy.findPic("rank20.png");
                    if(result.sim>0.85f) {
                        mFairy.onTap(0.85f, result, 711,432,749,445,"确定发起跟随", 500);
                        return;
                    }

                    result = mFairy.findPic(624, 274, 911, 399, "dh5.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(721, 429, 762, 447, "确定放弃", 200);
                        return;
                    }

                    result = mFairy.findPic(439, 224, 871, 387, "rank8.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(715, 414, 740, 428, "同意入队", 500);
                        return;
                    }

                    result = mFairy.findPic(384,293,833,379, "zudui1.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(713,434,750,450, "正在排队", 500);
                        return;
                    }

                    result = mFairy.findPic(354, 250, 645, 416, "dh6.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(715, 430, 743, 447, "确定匹配!", 500);
                        return;
                    }

                    mFairy.onTap(0.8f, qx, "取消", 500);
                }
            }

            void content_04() throws Exception {
                if (timeCount(8, 0)) {
                    gamePublicFuntion.init(0,true);
                    setTaskName(2);
                    return;
                }

                if (err > 3) {
                    oneSecond = 0;
                }

                result = mFairy.findPic(989, 206, 1144, 572, "mgsx2.png");
                mFairy.onTap(0.8f, result, "猛鬼苏醒", 5000);

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();


                    result = mFairy.findPic(714, 345, 747, 378, "bsylx7.png");
                    mFairy.onTap(0.85f, result, "手", 5000);


                    if (oneSecond()) {
                        for (int i = 0; i < 3; i++) {
                            mFairy.ranSwipe(1096, 81, 1113, 229, 0, 500, (long)300);
                        }
                    }

                    if (gamePublicFuntion.judgeStop(3)) {
                        if (gamePublicFuntion.stop()) {
                            mFairy.onTap(1064, 78, 1124, 95, "点击任务区", 1000);
                        }
                    }
                }

            }
        };
    }//猛鬼苏醒
    /**
     * 跟队*/
    class GenContent extends TaskContent {

        public GenContent(AtFairyImpl mFairy, String name) throws Exception {
            super(mFairy, name);
        }

        void create() throws Exception {
            super.create();
            activityType = 1;
            activitySlide = new Slide(821, 180, 855, 450);
        }

        Boolean activityEnd(FindResult result) throws Exception {

            return false;
        }

        void init() throws Exception {
            super.init();
            oneSecond = 0;
            gamePublicFuntion.actInitSlide = true;

            gamePublicFuntion.init(0,false);

            setTaskName(1);
        }

        void content_01() throws Exception {
            if (timeCount(8, 0)) {
                if (frequencyMap("活动计次",2)) {
                    setTaskEnd();
                    return;
                }
            }

            result = mFairy.findPic("rank0.png");
            mFairy.onTap(0.96f, result,1240,94,1251,118, "目标", 500);

            if (Abnormal.HONG) {
                if (gamePublicFuntion.hong()) {
                    Thread.sleep(1000);
                    err = 0;
                    return;
                }
            }

            result = mFairy.findPic(545, 18, 911, 94, new String[]{"activity.png", "activity4.png"});
            if (result.sim > 0.75f) {
                mFairy.onTap(0.75f, result, "活动按钮", 300);
                gamePublicFuntion.actInitSlide = false;
            }

            result = mFairy.findPic("activity2.png");
            mFairy.onTap(0.85f, result, "提示框", 300);

            result = mFairy.findPic("activity3.png");
            mFairy.onTap(0.85f, result, "eva 提示", 300);

            result = mFairy.findPic("use.png");
            mFairy.onTap(0.85f, result, "使用", 300);

            result = mFairy.findPic("activity1.png");
            if (result.sim > 0.85f) {

                if (oneSecond()) {
                    gamePublicFuntion.ChoiceActivityType(activityType);

                    for (int i = 0; i < 6; i++) {
                        result = mFairy.findPic(413, 638, 976, 671, "activity5.png");
                        if (result.sim > 0.85f) {
                            mFairy.tap(result.x - 20, result.y + 20);
                            Thread.sleep(300);
                            if (mapCount(0.8f, 584, 136, 650, 305, "man1.png")) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }

                FindResult act = mFairy.findPic(383, 111, 1229, 481, activityName);
                if (act.sim > 0.9f) {

                    if (activityEnd(act)) {
                        gamePublicFuntion.liRank(1);
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70, "can.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(1211, 45, 1229, 62, "次任务可以参加>>>", 500);
                        oneSecond=0;
                        setTaskName(2);
                        return;
                    }


                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70,
                            new String[]{"wan.png", "ji.png"});
                    if (result.sim > 0.85f) {
                        if (AtFairyConfig.getOption("gen2").equals("1")) {
                            gamePublicFuntion.liRank(1);
                        }
                        setTaskEnd();
                        return;
                    }
                }

                if (gamePublicFuntion.actInitSlide) {
                    activitySlide.slideRange(new int[]{2, 3, 4, 5, 6}, 2, 0);
                } else {
                    activitySlide.slideRange(new int[]{3, 4, 5, 6}, 2);
                }
            }
        }

        void rank(String str1, String str2) throws Exception {

            FindResult pp = mFairy.findPic("rank10.png");
            if (pp.sim > 0.85f && rankBool) {
                err = 0;
                if (str1 != null) {
                    result = mFairy.findPic(119, 53, 327, 640, str1);
                    if (result.sim > 0.95f) {
                        mFairy.onTap(0.95f, result, "str1 >>>", 500);
                        return;
                    }
                }
                result = mFairy.findPic(119, 53, 327, 640, str2);
                if (result.sim > 0.7f) {
                    mFairy.onTap(0.7f, result, "找到匹配的任务", 500);

                    for (int j = 0; j < 5; j++) {
                        result = modularLookup(934, 57, 1068, 137, "rank14.png");
                        mFairy.onTap(0.85f, result, "申请", 300);
                    }
                    modularLookup=0;

                    result = mFairy.findPic("rank17.png");
                    mFairy.onTap(0.85f, result, "自动匹配", 500);

                    rankBool = false;
                    return;
                }

                if (frequencyMap("队伍tc",2)) {
                    mFairy.ranSwipe(218, 221, 246, 464, 2, 500, (long)500);
                }
                return;

            } else {
                result = mFairy.findPic("rank11.png");
                mFairy.onTap(0.95f, result, "队伍信息", 500);
            }

            result = mFairy.findPic("rank7.png");
            LtLog.e("******"+result);
            if (result.sim > 0.8f) {
                err = 0;
                result = mFairy.findPic(709,565,1009,711,new String[]{"rank5.png", "rank6.png"});
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, 1108, 54, 1144, 70, "", 1000);
                    setTaskName(3);
                    gen = false;
                    return;
                } else {
                    if (frequencyMap("队伍判断",3)) {
                        result = mFairy.findPic("lirank.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, "离开队伍", 500);
                            mFairy.onTap(707, 430, 737, 447, "", 500);
                        } else {
                            if (timeMap("genRankTime",20000)) {
                                rankBool = true;
                                result = mFairy.findPic(542, 587, 997, 708, "rank9.png");
                                mFairy.onTap(0.85f, result, "前往匹配", 500);
                            }
                        }
                    }
                }
            } else {
                gamePublicFuntion.clickRank();
            }
        }//队伍

        void quxiao()throws Exception{
            FindResult qx = gamePublicFuntion.qxBool();
            if (qx.sim > 0.8f) {

                result = mFairy.findPic(new String[]{"xiazai.png","xiazai1.png","xiazai3.png"});
                if(result.sim>0.85f){
                    mFairy.onTap(720,436,744,447,"确定",500);
                    return;
                }

                result = mFairy.findPic("llxd8.png");
                if(result.sim>0.85f) {
                    mFairy.onTap(0.85f, result, "开启", 500);
                    return;
                }

                result = mFairy.findPic( "llxd7.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(710,427,744,450, "开启行动力", 500);
                    return;
                }

                result = mFairy.findPic(624, 274, 911, 399, "dh5.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(721, 429, 762, 447, "确定放弃", 200);
                    return;
                }
                result = mFairy.findPic(384,293,833,379, "zudui1.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(713,434,750,450, "正在排队", 500);
                    return;
                }

                result = mFairy.findPic(509,264,779,386,"rank15.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.8f, result, 706, 433, 745, 445, "确定归队", 500);
                    return;
                }

                result = mFairy.findPic(361,258,921,406,"gui.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 715,431,746,446, "确定归队", 500);
                    return;
                }

                mFairy.onTap(0.8f, qx, "取消", 500);
            }


        }//取消

        void inOperation() throws Exception {

            result = mFairy.findPic(1116, 61, 1206, 124, "rank18.png");
            if (result.sim > 0.85f) {
                setTaskName(1);
                return;
            }

            long l = mFairy.getColorNum(4, 710, 242, 719, "248,248,248", 0.98f);
            if (l > 200) {
                err = 0;
                gamePublicFuntion.chat = 0;
                mFairy.initMatTime();
            }
            result = mFairy.findPic(624, 191, 670, 267, "lv.png");
            if (result.sim > 0.8f) {
                err = 0;
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
        }

        void content_03() throws Exception {
            if (timeCount(20, 0)) {
                gamePublicFuntion.init(0,true);
                setTaskName(1);
                return;
            }

            Thread.sleep(1000);

            gamePublicFuntion.close();

            if (gamePublicFuntion.fuben()) {
                err = 0;
                gen = true;
            } else {
                if (gen) {
                    if (frequencyMap("查看任务状态",3)) {
                        setTaskName(1);
                        gen = false;
                        return;
                    }
                }
            }

            if (gamePublicFuntion.judgeStop(5)) {
                mFairy.initMatTime();
                result = mFairy.findPic("rank1.png");
                mFairy.onTap(0.95f, result, "队伍", 500);

                result = mFairy.findPic("rank16.png");
                mFairy.onTap(0.95f, result, "跟随", 500);

                result = mFairy.findPic("rank19.png");
                if(result.sim>0.85f){
                    setTaskName(0);
                    return;
                }

            } else {
                err = 0;
            }

        }
    }

    public void wyngzz() throws Exception {
        new GenContent(mFairy, "午夜南瓜之灾") {

            void create() throws Exception {
                super.create();
                activityName = "wyngzz.png";
                activityType = 1;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,false);
                }
                rank(null, "wyngzz1.png");
            }

            void inOperation() throws Exception {
                super.inOperation();
                quxiao();
            }
        };
    }//午夜南瓜之灾

    public void lzst() throws Exception {
        new GenContent(mFairy, "龙之使徒") {

            void create() throws Exception {
                super.create();
                activityName = "lzst.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,false);
                }
                rank(null, "lzst1.png");
            }

            void inOperation() throws Exception {
                super.inOperation();
                quxiao();
            }
        };

    }//龙之使徒

    public void zdzx() throws Exception {
        new GenContent(mFairy, "躁动之血") {

            void create() throws Exception {
                super.create();
                activityName = "zdzx.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,false);
                }
                rank("hl.png", "zdzx1.png");
            }

            void inOperation() throws Exception {
                super.inOperation();

                hour =mFairy.dateHour();
                if(hour ==14 || hour ==22){
                    setTaskEnd();
                    return;
                }

                quxiao();
            }
        };
    }//躁动之血

    public void yhsj() throws Exception {
        new GenContent(mFairy, "业海杀机") {

            void create() throws Exception {
                super.create();
                activityName = "yhsj.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,false);
                }
                rank("hl.png", "yhsj1.png");
            }

            void inOperation() throws Exception {
                super.inOperation();

                hour =mFairy.dateHour();
                if(hour ==14 || hour ==22){
                    setTaskEnd();
                    return;
                }

                quxiao();
            }
        };
    }//业海杀机

    public void jddf() throws Exception {
        new GenContent(mFairy, "极道巅峰") {

            void create() throws Exception {
                super.create();
                activityName = "jddf.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,false);
                }
                rank(null, "jddf1.png");
            }

            void inOperation() throws Exception {
                super.inOperation();

                minute = mFairy.dateMinute();
                if(minute>40){
                    setTaskEnd();
                    return;
                }
                quxiao();
            }
        };
    }//极道巅峰

    public void bgyx() throws Exception {
        new GenContent(mFairy, "百鬼夜行") {

            void create() throws Exception {
                super.create();
                activityName = "bgyx.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(6, 0)) {
                    gamePublicFuntion.init(0,false);
                }
                rank(null, "bgyx1.png");
            }

            void inOperation() throws Exception {
                super.inOperation();

                minute = mFairy.dateMinute();
                if(minute>30){
                    setTaskEnd();
                    return;
                }
                quxiao();
            }
        };
    }//百鬼夜行

    public void gen()throws Exception{
        new TaskContent(mFairy,"跟队"){

            void init() throws Exception {
                super.init();
                gamePublicFuntion.init(0,false);
                setTaskName(1);
            }
            void content_01() throws Exception {
                timeCount(20,0);

                Thread.sleep(1000);

                gamePublicFuntion.close();

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                }

                if (gamePublicFuntion.judgeStop(5)) {
                    mFairy.initMatTime();
                    result = mFairy.findPic("rank1.png");
                    mFairy.onTap(0.95f, result, "队伍", 500);

                    result = mFairy.findPic("rank16.png");
                    mFairy.onTap(0.95f, result, "跟随", 500);

                    result = mFairy.findPic("jihe.png");
                    if(result.sim>0.85f){
                        LtLog.e(mFairy.getLineInfo("发现成为队长"));
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic("rank19.png");
                    if(result.sim>0.85f){
                        LtLog.e(mFairy.getLineInfo("发现已经没有队伍"));
                        setTaskEnd();
                        return;
                    }
                } else {
                    err = 0;
                }
            }
        };
    }//跟队
}