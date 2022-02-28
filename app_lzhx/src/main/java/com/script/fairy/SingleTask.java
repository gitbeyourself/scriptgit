package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;


public class SingleTask {
    public GamePublicFuntion gamePublicFuntion;
    public FindResult result;
    public AtFairyImpl mFairy;
    private int hour;
    private int minute;
    private int week;

    public SingleTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gamePublicFuntion = new GamePublicFuntion(atFairy);
    }

    public void nn() throws Exception {
        new TaskContent(mFairy, "新手引导") {
            void create() throws Exception {
                super.create();
                Abnormal.HONG = true;
            }

            void init() throws Exception {
                gamePublicFuntion.qx();
                if (gamePublicFuntion.close()) {
                    return;
                }
                setTaskName(1);
            }

            void battle1() throws Exception {
                boolean bat = false;

                result = mFairy.findPic(
                        new String[]{"bat1.png", "bat2.png", "bat8.png", "bat9.png",
                                "bat10.png", "bat12.png", "bat14.png", "bat15.png", "bat16.png"});
                if (result.sim > 0.8f) {
                    bat = true;
                }

                result = mFairy.findPic(989, 62, 1229, 176,
                        new String[]{"bat3.png", "bat6.png", "bat7.png", "bat11.png", "bat13.png"});
                if (result.sim > 0.8f) {
                    bat = true;
                }

                result = mFairy.findPic(972, 37, 1220, 147,
                        new String[]{"bat4.png", "bat5.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(1058, 77, 1101, 99, "", 800);
                    if (mapCount(0.9f, 654, 51, 772, 318, "lv1.png")) {
                        mFairy.ranSwipe(489, 164, 922, 219, 1, 2000, (long)1000);
                        LtLog.e(mFairy.getLineInfo("滑动寻找目标"));

                        mFairy.onTap(1193, 534, 1216, 560, "跳", 500);
                        mFairy.onTap(1193, 534, 1216, 560, "跳", 500);
                    }
                    bat = true;
                }

                if (bat) {
                    err = 0;
                    result = mFairy.findPic("bat.png");
                    if (result.sim > 0.85f) {
                        battle();
                    } else {
                        for (int i = 0; i < 2; i++) {
                            mFairy.onTap(1082, 518, 1120, 549, "A", 200);
                        }
                        mFairy.onTap(980, 613, 1004, 637, "技能1", 200);
                        mFairy.onTap(963, 519, 989, 547, "技能2", 200);
                        mFairy.onTap(996, 424, 1022, 455, "技能3", 200);
                        mFairy.onTap(1088, 399, 1114, 421, "技能4", 200);
                        mFairy.onTap(1182, 406, 1210, 430, "技能5", 200);

                        for (int i = 0; i < 5; i++) {
                            mFairy.onTap(1082, 518, 1120, 549, "A", 200);
                        }
                    }
                }
            }

            void n() throws Exception {
                result = mFairy.findPic("nn1.png");
                mFairy.onTap(0.85f, result, "确认", 300);

                result = mFairy.findPic("nn24.png");
                mFairy.onTap(0.85f, result, "标准升级", 300);

                result = mFairy.findPic("nn23.png");
                mFairy.onTap(0.85f, result, "err 聊天", 300);

                result = mFairy.findPic("nn20.png");
                mFairy.onTap(0.85f, result, 1227, 23, 1251, 46, "关闭机器人界面", 300);

                result = mFairy.findPic("nn2.png");
                mFairy.onTap(0.85f, result, "立刻穿戴", 1000);

                result = mFairy.findPic("nn22.png");
                mFairy.onTap(0.85f, result, "指纹", 3000);

                result = mFairy.findPic(new String[]{"nn4.png","nn25.png"});
                mFairy.onTap(0.85f, result, "跳过新手剧情", 300);

                result = mFairy.findPic("nn21.png");
                mFairy.onTap(0.85f, result, 1018, 651, 1091, 663, "没事", 300);

                result = mFairy.findPic("nn3.png");
                mFairy.onTap(0.85f, result, 712, 427, 747, 450, "终止探索", 300);

                result = mFairy.findPic("nn5.png");
                mFairy.onTap(0.85f, result, "确定", 300);

                result = mFairy.findPic("nn7.png");
                mFairy.onTap(0.85f, result, "赠送", 300);

                result = mFairy.findPic("use.png");
                mFairy.onTap(0.85f, result, "使用", 300);

                result = mFairy.findPic("nn14.png");
                mFairy.onTap(0.85f, result, "领取", 300);

                result = mFairy.findPic("nn17.png");
                mFairy.onTap(0.85f, result, "投票", 300);

                result = mFairy.findPic("nn19.png");
                mFairy.onTap(0.85f, result, "执行ss任务", 300);

                result = mFairy.findPic("nn18.png");
                mFairy.onTap(0.85f, result, 926, 179, 953, 201, "关闭新闻", 300);

                result = mFairy.findPic("nn6.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "确定购买", 1000);
                    mFairy.onTap(656, 391, 692, 406, "", 500);
                    mFairy.onTap(1171, 30, 1189, 50, "", 500);
                }

                result = mFairy.findPic("nn11.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(894, 386, 942, 422, "", 500);
                    mFairy.onTap(0.85f, result, "确认领取", 1000);
                }

                result = mFairy.findPic("nn15.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(820, 243, 868, 262, "升级好礼", 500);
                    mFairy.onTap(1218, 24, 1240, 42, "", 500);
                }

                result = mFairy.findPic(new String[]{"nn12.png", "nn13.png"});
                if (result.sim > 0.85f) {
                    mFairy.onTap(1061, 88, 1094, 113, "", 1500);
                    mFairy.onTap(694, 164, 726, 190, "", 300);
                    mFairy.onTap(740, 162, 757, 176, "", 300);
                    mFairy.onTap(685, 224, 705, 245, "", 300);
                }

                result = mFairy.findPic("nn16.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "重置", 500);
                    mFairy.onTap(712, 313, 756, 353, "", 500);
                    mFairy.onTap(883, 311, 916, 345, "", 500);
                    mFairy.onTap(882, 471, 919, 507, "", 500);
                    mFairy.onTap(1037, 484, 1080, 518, "", 500);
                }
            }

            void content_01() throws Exception {
                if (timeCount(6, 0)) {

                    result = mFairy.findPic(507, 301, 779, 666, "ok1.png");
                    mFairy.onTap(0.85f, result, "确认1", 1000);

                    if (gamePublicFuntion.mainScene()) {
                        mFairy.ranSwipe(163, 446, 336, 471, 1, 1000, (long)500);
                    }
                }

                result = mFairy.findPic("activity1.png");
                LtLog.e("******"+result.sim);
                if (result.sim > 0.85f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("nn8.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic("nn10.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(832, 43, 854, 66, "关闭通讯", 500);
                        return;
                    }
                    mFairy.onTap(596, 555, 671, 572, "", 500);
                    mFairy.onTap(804, 653, 833, 670, "", 500);
                    mFairy.onTap(526, 650, 608, 665, "", 500);
                    return;
                }

                n();

                battle1();
                long l = mFairy.getColorNum(4, 710, 242, 719, "248,248,248", 0.98f);
                if (l > 200) {
                    err = 0;
                    frequencyInit("skip");
                    initTaskContent("主线");
                }

                result = mFairy.findPic("skip1.png");
                mFairy.onTap(0.85f, result, "跳过剧情", 300);

                result = mFairy.findPic("rank0.png");
                mFairy.onTap(0.96f, result, 1240, 94, 1251, 118, "目标", 500);

                result = mFairy.findPic(409, 240, 836, 385, "jia1.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(558, 344, 574, 364, "不在提示", 500);
                    mFairy.onTap(529, 418, 568, 427, "拒绝添加好友", 500);
                }

                result = mFairy.findPic("name.png");
                if (result.sim > 0.85f) {
                    //输入名字
                    LtLog.e("遇到输入ID");
                    mFairy.finish(AtFairyConfig.getTaskID(), 28102);
                    return;
                }

                result = mFairy.findPic(624, 191, 670, 267, "lv.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    initTaskContent("主线");
                    frequencyInit("无法寻路");
                }

                if (gamePublicFuntion.mainScene()) {
                    frequencyInit("skip");
                    frequencyInit("cui");
                } else {
                    result = mFairy.findPic(new String[]{"chat.png", "chat1.png", "chat2.png"});
                    if (result.sim > 0.85f) {
                        err = 0;
                        mFairy.onTap(0.85f, result, "聊天", 200);
                        return;
                    }

                    result = mFairy.findPic("skip.png");
                    if (result.sim > 0.8f) {
                        err = 0;
                        if (frequencyMap("skip", 3)) {
                            mFairy.onTap(996, 311, 1059, 325, "skip >>> err", 500);
                        } else {
                            mFairy.onTap(0.8f, result, "skip", 200);
                        }
                        return;
                    }

                    if (gamePublicFuntion.mainScene() == false) {
                        if (frequencyMap("cui", 3)) {
                            mFairy.onTap(1176, 7, 1193, 21, "点击画面", 600);
                        }
                    }
                }

                if (gamePublicFuntion.fuben()) {
                    battle();
                }

                if (frequencyMap("主线", 3)) {
                   /* result = mFairy.findPic(987, 13, 1065, 272, new String[]{"zhuxian.png", "zhuxian1.png", "zhuxian2.png"});
                    LtLog.e("主线sim :" + result.sim);*/

                    result = mFairy.findPic("mub1.png");
                    if (result.sim > 0.92f) {
                        mFairy.onTap(1059, 85, 1112, 99, "主线", 800);

                        if (mapCount(0.8f, 661, 54, 756, 214, "lv1.png")) {
                            if (frequencyMap("无法寻路", 3)) {
                                gamePublicFuntion.tuoli();
                                gamePublicFuntion.close();
                            }
                        } else {
                            if (gamePublicFuntion.judgeStop(2)) {

                                mFairy.onTap(42, 145, 59, 158, "开启灵视", 1000);

                                battle();
                            } else {
                                frequencyInit("无法寻路");
                                Thread.sleep(4000);
                            }
                        }
                    }
                }
            }

        };
    }//新手引导

    private int buke = 1;
    private int activityType = 1;
    private String activityName = "";
    class singleTaskContent extends TaskContent {

        public singleTaskContent(AtFairyImpl mFairy, String name) throws Exception {
            super(mFairy, name);
        }

        void create() throws Exception {
            super.create();
            activityType = 1;
            if (!AtFairyConfig.getOption("zhao").equals("")) {
                buke = Integer.parseInt(AtFairyConfig.getOption("zhao"));
            }
        }

        Boolean activityEnd(FindResult result) throws Exception {

            return false;
        }

        void init() throws Exception {
            super.init();
            oneSecond = 0;
            gamePublicFuntion.actInitSlide = true;
            gamePublicFuntion.init(1, true);
            setTaskName(1);
        }

        void st(String name) throws Exception {
            if (gamePublicFuntion.mainScene()) {
                result = mFairy.findPic(1023, 486, 1269, 710, "shetuan.png");
                if (result.sim > 0.75f) {
                    err = 0;
                    mFairy.onTap(0.75f, result, "社团", 1000);
                } else {
                    mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                }
            }

            result = mFairy.findPic("shetuan1.png");
            mFairy.onTap(0.95f, result, "信息", 500);

            result = mFairy.findPic("shetuan2.png");
            if (result.sim > 0.85f) {

                result = mFairy.findPic("st3.png");
                mFairy.onTap(0.98f, result, "今日活动", 200);

                FindResult st = mFairy.findPic(636, 124, 849, 628, name);
                if (st.sim > 0.85f) {
                    result = mFairy.findPic(
                            st.x + 370, st.y - 41,
                            st.x + 505, st.y + 65, "st1.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "已完成", 1000);
                        setTaskEnd();
                        return;
                    }


                    result = mFairy.findPic(
                            st.x + 370, st.y - 41,
                            st.x + 505, st.y + 65, "shetuan3.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "参加", 1000);
                        setTaskName(2);
                        return;
                    }
                }

                if (frequencyMap("activityCount", 2)) {
                    mFairy.ranSwipe(747, 220, 778, 443, 2, 500, (long)500);
                }
            }


        }//社团

        void content_01() throws Exception {
            if (timeCount(8, 0)) {
                if (frequencyMap("活动", 1)) {
                    setTaskEnd();
                    return;
                }
            }

            result = mFairy.findPic("rank0.png");
            mFairy.onTap(0.96f, result, 1240, 94, 1251, 118, "目标", 500);

            if (Abnormal.HONG) {
                if (gamePublicFuntion.hong()) {
                    setTaskName(0);
                    Thread.sleep(1000);
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

            result = mFairy.findPic("buke2.png");
            if (result.sim > 0.85f) {

                result = mFairy.findPic("buke1.png");
                mFairy.onTap(0.85f, result, "补课-ok", 500);

                switch (buke) {
                    case 1:
                        mFairy.onTap(890, 618, 945, 630, "金币找回", 1000);
                        break;
                    case 2:
                        mFairy.onTap(1048, 617, 1092, 636, "钻石找回", 1000);
                        break;
                }

                result = mFairy.findPic(326, 263, 798, 396, "buke3.png");
                mFairy.onTap(0.85f, result, 723, 429, 738, 451, "确定消耗", 500);

                mFairy.onTap(1127, 51, 1145, 68, "关闭找回界面", 5000);
            }


            result = mFairy.findPic("err5.png");
            if (result.sim > 0.85f) {
                buke=0;
                mFairy.onTap(514,489,557,501,"",500);
                mFairy.onTap(1130,52,1149,73,"",500);
                return;
            }


            result = mFairy.findPic("activity1.png");
            if (result.sim > 0.85f) {
                if (buke != 0) {
                    result = mFairy.findPic("buke.png");
                    if (result.sim > 0.85f) {
                        err = 0;
                        mFairy.onTap(0.85f, result, "补课", 300);
                        return;
                    }
                }

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
                if (act.sim > 0.85f) {
                    if (activityEnd(act)) {
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70, "can.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "参加", 1000);
                        oneSecond = 0;
                        frequencyInit("活动");
                        setTaskName(2);
                        return;
                    }

                    if (activityName.equals("ddjy.png")) {
                        mFairy.onTap(1213, 46, 1230, 62, "", 500);
                        oneSecond = 0;
                        frequencyInit("活动");
                        setTaskName(2);
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

        void new_inOperation() throws Exception {
            result = mFairy.findPic(new String[]{"xiazai.png", "xiazai1.png", "xiazai3.png"});
            if (result.sim > 0.85f) {
                mFairy.onTap(720, 436, 744, 447, "确定", 500);
            } else {
                gamePublicFuntion.qx();
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

            new_inOperation();

            result = mFairy.findPic("fuhuo.png");
            mFairy.onTap(0.85f, result, "复活", 300);

            result = mFairy.findPic("zanli.png");
            mFairy.onTap(0.85f, result, "暂离执行", 300);

            result = mFairy.findPic("rank0.png");
            mFairy.onTap(0.96f, result, 1240, 94, 1251, 118, "目标", 500);

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
    }

    public void wpzl() throws Exception {
        new singleTaskContent(mFairy, "王牌之旅") {

            void create() throws Exception {
                super.create();
                activityName = "wpzl.png";
            }

            void content_02() throws Exception {
                timeCount(7, 0);

                //gamePublicFuntion.judgeChat();

                result = mFairy.findPic("wpzl7.png");
                mFairy.onTap(0.8f, result, "对话", 100);


                gm();

                result = mFairy.findPic("bsylx8.png");
                mFairy.onTap(0.85f, result, 792, 573, 858, 586, "通话", 200);

                result = mFairy.findPic("wpzl3.png");
                mFairy.onTap(0.8f, result, "eva", 200);

                result = mFairy.findPic("wpzl6.png");
                if (result.sim > 0.85f) {
                    result = mFairy.findPic(507, 301, 779, 666, "ok1.png");
                    mFairy.onTap(0.85f, result, "确认1", 200);
                    setTaskEnd();
                    return;
                }


                result = mFairy.findPic("wpzl2.png");
                mFairy.onTap(0.8f, result, "随机拨号", 1000);

                result = mFairy.findPic("wpzl4.png");
                mFairy.onTap(0.8f, result, 377, 188, 416, 209, "愿望", 500);

                if (gamePublicFuntion.judgeStop(3)) {

                    result = mFairy.findPic("oxjx4.png");
                    mFairy.onTap(0.85f, result, "关掉", 200);

                    result = mFairy.findPic(1052, 35, 1129, 305,
                            new String[]{"wpzl1.png", "wpzl5.png"});
                    LtLog.e(mFairy.getLineInfo("sim: " + result.sim));
                    if (result.sim > 0.7f) {
                        err = 0;
                        mFairy.onTap(0.7f, result, "王牌", 1000);
                        if (mapCount(0.9f, 661, 54, 756, 214, "lv1.png")) {
                            if (frequencyMap("无法寻路", 3)) {
                                gamePublicFuntion.tuoli();
                                gamePublicFuntion.close();
                            }
                        }else{
                            Thread.sleep(1000);
                        }
                    }
                } else {
                    err = 0;
                }





                result = mFairy.findPic("mub1.png");
                if (result.sim > 0.8f) {
                    taskSlide.slideRange(new int[]{3, 4, 5}, 2, 0);
                }
            }
        };
    }//王牌之旅

    public void zhsl() throws Exception {
        new singleTaskContent(mFairy, "智慧沙龙") {

            void create() throws Exception {
                super.create();
                activityName = "zhsl.png";

            }

            void content_02() throws Exception {
                if (timeCount(5, 0)) {
                    if (actBools) {
                        setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic("zhsl3.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

                result = mFairy.findPic("zhsl1.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    actBools = true;
                    mFairy.onTap(251,451,320,472, "D", 2500);
                }
            }
        };
    }//智慧沙龙

    public void tlkh() throws Exception {
        new singleTaskContent(mFairy, "屠龙考核") {

            void create() throws Exception {
                super.create();
                activityName = "tlkh.png";
            }

            Boolean activityEnd(FindResult result) throws Exception {
                result = mFairy.findPic(result.x, result.y + 10, result.x + 150, result.y + 65, "tlkh7.png");
                if (result.sim > 0.85f) {
                    return true;
                }
                return false;
            }

            void content_02() throws Exception {
                timeCount(5, 0);
                result = mFairy.findPic(996, 246, 1149, 559, "tlkh1.png");
                mFairy.onTap(0.85f, result, "屠龙考核", 1000);

                result = mFairy.findPic(944, 3, 1276, 277, "close2.png");
                mFairy.onTap(0.88f, result, "关闭", 500);

                result = mFairy.findPic("tlkh6.png");
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 5; i++) {
                        result = mFairy.findPic(782, 60, 975, 651, "tlkh5.png");
                        if (result.sim > 0.85f) {
                            i = 0;
                            mFairy.onTap(0.85f, result, "领取", 500);
                        } else {
                            if (frequencyMap("领取计次", 2)) {
                                mFairy.ranSwipe(743, 313, 773, 491, 0, 500, (long)1000);
                            }
                        }
                    }
                    mFairy.onTap(944, 52, 956, 66, "", 1000);
                }

                result = mFairy.findPic("tlkh2.png");
                if (result.sim > 0.85f) {
                    long l = mFairy.getColorNum(1233, 584, 1271, 616, "232,71,63", 0.95f);
                    if (l > 50) {
                        mFairy.onTap(1170, 613, 1212, 632, "奖励", 1000);
                        return;
                    }
                    result = mFairy.findPic("tlkh4.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(1239, 66, 1250, 77, "次数不足,end!", 500);
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic("tlkh3.png");
                    mFairy.onTap(0.85f, result, "挑战", 1000);
                }

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }

                if (gamePublicFuntion.judgeStop(2) == false) {
                    err = 0;
                }


            }
        };
    }//屠龙考核

    public void bsylx() throws Exception {
        new singleTaskContent(mFairy, "不思议历险") {

            void create() throws Exception {
                super.create();
                activityName = "bsylx.png";
            }

            void content_02() throws Exception {
                timeCount(8, 0);

                if (gamePublicFuntion.mainScene() == false) {
                    result = mFairy.findPic(new String[]{"chat.png", "chat1.png", "chat2.png"});
                    if (result.sim > 0.8f) {
                        err = 0;
                        mFairy.onTap(0.8f, result, "聊天", 200);
                        return;
                    }
                }

                result = mFairy.findPic(757, 392, 854, 684, "bsylx9.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic("nn10.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(832, 43, 854, 66, "关闭通讯", 500);
                        return;
                    }
                    mFairy.onTap(596, 555, 671, 572, "", 500);
                    mFairy.onTap(804, 653, 833, 670, "", 500);
                    mFairy.onTap(526, 650, 608, 665, "", 500);
                    return;
                }

                FindResult ys = mFairy.findPic(1044, 585, 1225, 692, "bsylx1.png");
                if (ys.sim > 0.8f) {
                    err = 0;

                    result = mFairy.findPic(431, 223, 795, 398, "bsylx4.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "不思议", 500);
                    } else {
                        mFairy.onTap(0.85f, ys, "投掷", 500);

                        if (mapCount(0.8f, 610, 135, 679, 356, "bsylx10.png")) {
                            setTaskEnd();
                            return;
                        }

                        if (mapCount(0.8f, 551, 104, 641, 333, "baoman.png")) {
                            /**
                             * 背包已满 */
                            LtLog.e(mFairy.getLineInfo("背包已满"));
                            mFairy.finish(AtFairyConfig.getTaskID(), 28101);
                        } else {
                            Thread.sleep(2000);
                        }
                    }
                }

                result = mFairy.findPic("bsylx2.png");
                mFairy.onTap(0.85f, result, "立刻前往", 3000);

                result = mFairy.findPic("bsylx8.png");
                mFairy.onTap(0.85f, result, 792, 573, 858, 586, "通话", 500);

                if (gamePublicFuntion.judgeStop(1)) {

                    result = mFairy.findPic("oxjx4.png");
                    mFairy.onTap(0.85f, result, "关掉", 200);

                    result = mFairy.findPic(714, 345, 747, 378, "bsylx7.png");
                    mFairy.onTap(0.85f, result, "手", 3500);

                    result = mFairy.findPic(1070, 47, 1148, 252, new String[]{"bsylx3.png", "bsylx5.png"});
                    LtLog.e(mFairy.getLineInfo("sim: " + result.sim));
                    if (result.sim > 0.7f) {
                        err = 0;
                        mFairy.initMatTime();
                        mFairy.onTap(40, 144, 55, 159, "灵视", 1000);
                        mFairy.onTap(0.7f, result, "不思议", 800);
                        if (mapCount(0.9f, 661, 54, 756, 214, "lv1.png")) {
                            if (frequencyMap("无法寻路", 3)) {
                                gamePublicFuntion.tuoli();
                                gamePublicFuntion.close();
                            }
                        }
                    }
                } else {
                    err = 0;
                }

            }
        };
    }//不思议历险

    public void jskb() throws Exception {
        new singleTaskContent(mFairy, "极速狂飙") {

            void create() throws Exception {
                super.create();
                activityName = "jskb.png";
                gamePublicFuntion.liRank(1);
            }

            void content_02() throws Exception {
                timeCount(8, 0);
                result = mFairy.findPic(971, 194, 1158, 566, "jskb1.png");
                mFairy.onTap(0.85f, result, "极速狂飙", 1000);

                result = mFairy.findPic(996, 576, 1176, 704, "jskb2.png");
                mFairy.onTap(0.85f, result, "比赛", 300);

                result = mFairy.findPic("jskb3.png");
                mFairy.onTap(0.85f, result, "确定选择", 50000);

                result = mFairy.findPic("jskb5.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "确定选择", 1500);
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic("jskb4.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

                result = mFairy.findPic(449, 271, 765, 439, "cszy2.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

            }
        };
    }//极速狂飙

    public void jyzh() throws Exception {
        new singleTaskContent(mFairy, "记忆找回") {

            void create() throws Exception {
                super.create();
                activityName = "jyzh.png";
            }

            void qx() throws Exception {
                result = mFairy.findPic("jyzh2.png");
                if (result.sim > 0.85f) {
                    err = 0;

                    mFairy.onTap(0.85f, result, 708, 432, 742, 446, "确定消费", 500);

                    if (mapCount(0.8f, 619, 120, 670, 360, "jyzh3.png")) {
                        setTaskEnd();
                        return;
                    }
                    setTaskName(1);
                } else {
                    gamePublicFuntion.qx();
                }
            }

            void content_02() throws Exception {
                timeCount(8, 0);

                result = mFairy.findPic(971, 194, 1158, 566, "jyzh1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "丢失记忆找回", 500);
                    if (mapCount(0.8f, 636, 112, 694, 302, "jyzh4.png")) {
                        mFairy.onTap(1167, 637, 1252, 682, "", 100);
                        setTaskEnd();
                        return;
                    }
                }

            }
        };
    }//记忆找回

    private int ddjy_o = 1;
    private int ddjy_t = 1;
    private boolean ddjyfb = false;
    public void ddjy() throws Exception {
        new singleTaskContent(mFairy, "嘀嗒解忧") {
            void create() throws Exception {
                super.create();
                activityName = "ddjy.png";

                if (!AtFairyConfig.getOption("ddjy").equals("")) {
                    ddjy_o = Integer.parseInt(AtFairyConfig.getOption("ddjy"));
                }
                ddjyfb = false;
            }

            void new_inOperation() throws Exception {
                result = mFairy.findPic(424, 271, 849, 428, "okgm.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(711, 428, 746, 448, "确定花费", 500);
                } else {
                    gamePublicFuntion.qx();
                }
            }

            void content_02() throws Exception {
                if (timeCount(13, 2)) {
                    if (frequencyMap("jy", 2)) {
                        setTaskEnd();
                        return;
                    } else {
                        gamePublicFuntion.init(0, true);
                    }
                }

                result = mFairy.findPic(628,23,984,342,"ddjy3.png");
                if (result.sim > 0.8f) {

                    result = mFairy.findPic(685, 302, 983, 448, "ddjy7.png");
                    if (result.sim > 0.85f) {

                        switch (ddjy_t) {
                            case 1:
                                result = mFairy.findPic("ddjy5.png");
                                mFairy.onTap(0.85f, result, "前往购买", 500);
                                break;
                            case 2:
                                /**
                                 * 推送消息 遇到购买暂停
                                 */
                                setTaskEnd();
                                return;
                        }
                    }

                    switch (ddjy_o) {
                        case 1:
                            result = mFairy.findPic("ddjy4.png");
                            mFairy.onTap(0.85f, result, "前往搜寻", 1500);
                            break;
                        case 2:
                            result = mFairy.findPic("ddjy5.png");
                            mFairy.onTap(0.85f, result, "前往购买", 1500);
                            break;
                    }

                    result = mFairy.findPic("bsylx8.png");
                    mFairy.onTap(0.85f, result, 792, 573, 858, 586, "通话", 500);

                    result = mFairy.findPic("ddjy1.png");
                    mFairy.onTap(0.85f, result, "开始接单", 500);

                    result = mFairy.findPic("ddjy3.png");
                    mFairy.onTap(0.85f, result, 960, 86, 970, 99, "关闭接单界面", 500);
                }


                result = mFairy.findPic("bsylx8.png");
                mFairy.onTap(0.85f, result, 792, 573, 858, 586, "通话", 500);


                if(gm()){
                    if(frequencyMap("gmerr",3)){
                        for(int i =0;i<3;i++) {
                            gamePublicFuntion.close();
                        }
                    }
                }

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                    gamePublicFuntion.close();

                    if (timeMap("ddjyTime", 300000)) {
                        ddjyfb = false;
                    }

                    if (ddjyfb) {
                        mFairy.initMatTime();
                    }
                } else {
                    if (frequencyMap("战斗判断", 2)) {
                        battle = true;
                    }
                }

                result = mFairy.findPic(1039, 61, 1100, 285, "ddjy8.png");
                if (result.sim > 0.85f) {
                    result = mFairy.findPic(result.x - 60, result.y - 30, result.x + 200, result.y + 40, "ddjy6.png");
                    mFairy.onTap(0.8f, result, "已过期", 1000);
                }

                if (gamePublicFuntion.judgeStop(2)) {

                    result = mFairy.findPic(1039, 61, 1100, 285, "ddjy8.png");
                    if (result.sim > 0.7f) {
                        err = 0;
                        ddjyfb = true;
                        frequencyInit("jy");
                        frequencyInit("gmerr");
                        mFairy.initMatTime();
                        mFairy.onTap(0.7f, result, "滴", 1000);
                        return;
                    }


                    for (int i = 0; i < 2; i++) {
                        result = mFairy.findPic(951, 53, 1007, 282, "ddjy2.png");
                        if (result.sim > 0.7f) {
                            err = 0;
                            ddjyfb = true;
                            frequencyInit("jy");
                            frequencyInit("gmerr");
                            mFairy.initMatTime();
                            mFairy.onTap(0.7f, result, result.x + 150, result.y, result.x + 160, result.y + 1, "滴", 1000);
                            return;
                        }
                    }
                } else {
                    err = 0;
                }

                result = mFairy.findPic("mub1.png");
                if (result.sim > 0.92f) {
                    taskSlide.slideRange(new int[]{6, 8, 10}, 2, 0);
                }

            }
        };
    }//嘀嗒解忧

    /**
     * 社团任务
     */
    public void djxmzs() throws Exception {
        new singleTaskContent(mFairy, "刀剑相鸣之时") {

            void init() throws Exception {
                gamePublicFuntion.init(0, true);
                setTaskName(1);
            }

            void new_inOperation() throws Exception {
                result = mFairy.findPic(316, 207, 618, 383, "djxmzs3.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(720, 437, 738, 442, "确定开始挑战", 2000);
                } else {
                    gamePublicFuntion.qx();
                }

                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(8, 0);
                st("djxmzs.png");
            }

            void content_02() throws Exception {
                timeCount(10, 0);

                result = mFairy.findPic(650, 559, 908, 640, "djxmzs1.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    result = mFairy.findPic("djxmzs8.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(1125, 587, 1172, 602, "领奖", 1500);

                        result = mFairy.findPic(575, 294, 840, 415, "djxmzs7.png");
                        mFairy.onTap(0.8f, result, 995, 139, 1014, 153, "", 500);

                        mFairy.onTap(1237, 90, 1250, 104, "次数不足,End!", 200);
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic("djxmzs2.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "挑战", 500);
                        if (frequencyMap("tiaozhan", 3)) {
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result = mFairy.findPic(406, 236, 647, 485, "djxmzs4.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(801, 489, 822, 511, "挑战结束", 200);
                    setTaskName(1);
                    return;
                }

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }


                result = mFairy.findPic(208, 442, 513, 537, "djxmzs6.png");
                mFairy.onTap(0.85f, result, 928, 588, 963, 608, "", 500);


            }

        };
    }//刀剑相鸣之时

    public void stzl() throws Exception {
        new singleTaskContent(mFairy, "社团之力") {

            void init() throws Exception {
                gamePublicFuntion.init(0, true);
                setTaskName(1);
            }

            void inOperation() throws Exception {
                super.inOperation();
                gamePublicFuntion.qx();

                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(10, 99);

                if (gamePublicFuntion.mainScene()) {
                    if (frequencyMap("packageClick", 2)) {
                        mFairy.onTap(1140, 304, 1153, 323, "点击背包", 500);
                    }
                }
                result = mFairy.findPic("stzl3.png");
                if (result.sim > 0.85f) {

                    if (oneSecond()) {
                        err = 0;
                    }

                    result = mFairy.findPic(778, 71, 1197, 224, "stzl5.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(1233, 22, 1252, 41, "", 500);
                        setTaskEnd();
                        return;
                    }

                    result = mFairy.findPic(784, 74, 1194, 622, "stzl4.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.8f, result, "社团之力", 1000);

                        result = mFairy.findPic(647, 52, 1214, 629, "qing3.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, "使用", 5000);
                            setTaskName(2);
                            return;
                        }

                        return;
                    }

                    mFairy.ranSwipe(987, 251, 1023, 455, 2, 500, (long)1000);
                }

            }

            void content_02() throws Exception {
                timeCount(10, 0);

                result = mFairy.findPic(548, 183, 849, 495, "stzl6.png");
                mFairy.onTap(0.8f, result, "chat", 1000);


                result = mFairy.findPic("stzl1.png");
                mFairy.onTap(0.8f, result, "社团之力", 1000);

                result = mFairy.findPic(740, 504, 992, 573, "stzl7.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    for (int i = 0; i < 20; i++) {
                        mFairy.onTap(768, 423, 797, 435, "", 200);

                        long l = mFairy.getColorNum(806, 417, 816, 438, "54,63,78", 0.98f);
                        if (l > 100) {
                            break;
                        }
                    }
                    mFairy.onTap(1051, 102, 1066, 119, "关闭", 500);
                    setTaskEnd();
                    return;
                }
            }
        };
    }//社团之力

    public void stfh() throws Exception {
        new singleTaskContent(mFairy, "社团分红") {

            void init() throws Exception {
                result = mFairy.findPic("shetuan1.png");
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void new_inOperation() throws Exception {
                gamePublicFuntion.qx();
                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(8, 99);
                if (gamePublicFuntion.mainScene()) {
                    result = mFairy.findPic(1023, 486, 1269, 710, "shetuan.png");
                    if (result.sim > 0.75f) {
                        err = 0;
                        mFairy.onTap(0.75f, result, "社团", 1000);
                    } else {
                        mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                    }
                }

                result = mFairy.findPic("shetuan1.png");
                mFairy.onTap(0.95f, result, "信息", 500);

                result = mFairy.findPic("shetuan2.png");
                if (result.sim > 0.85f) {
                    result = mFairy.findPic("stfh1.png");
                    if (result.sim > 0.9f) {
                        err = 0;
                        mFairy.onTap(0.9f, result, "社团分红", 500);
                    } else {
                        if (frequencyMap("分红计次", 3)) {
                            setTaskEnd();
                            return;
                        }
                    }

                    result = mFairy.findPic("stfh4.png");
                    mFairy.onTap(0.85f, result, "拍卖分红", 500);

                }

                result = mFairy.findPic("stfh2.png");
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(1082, 113, 1140, 576, "stfh5.png");
                        if (result.sim > 0.9f) {
                            i = 0;
                            mFairy.onTap(0.9f, result, result.x - 40, result.y + 30, result.x - 35, result.y + 35, "领取", 200);
                        }
                    }
                    mFairy.onTap(1132, 54, 1151, 67, "", 500);
                    mFairy.onTap(440, 88, 492, 99, "", 500);
                    setTaskEnd();
                    return;
                }
            }

            void content_02() throws Exception {
                timeCount(10, 0);

                if (err >= 5) {
                    if (gamePublicFuntion.mainScene()) {
                        mFairy.onTap(632, 413, 653, 442, "点击人物", 1000);
                    }
                }

                result = mFairy.findPic("stzl1.png");
                mFairy.onTap(0.8f, result, "社团之力", 1000);

                result = mFairy.findPic("stzl2.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    for (int i = 0; i < 20; i++) {
                        mFairy.onTap(768, 423, 797, 435, "", 200);

                        long l = mFairy.getColorNum(806, 417, 816, 438, "54,63,78", 0.98f);
                        if (l > 100) {
                            break;
                        }
                    }
                    mFairy.onTap(1051, 102, 1066, 119, "关闭", 500);
                    setTaskEnd();
                    return;
                }
            }
        };
    }//社团分红

    public void stmnzlj() throws Exception {
        new singleTaskContent(mFairy, "社团模拟战") {

            void init() throws Exception {
                gamePublicFuntion.init(0, true);
                setTaskName(1);
            }

            void new_inOperation() throws Exception {
                gamePublicFuntion.qx();
                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("stmnz2.png");
                mFairy.onTap(0.85f, result, "", 500);
            }

            void content_01() throws Exception {
                timeCount(8, 99);
                st("stmnzlj.png");
            }

            void content_02() throws Exception {
                timeCount(10, 99);


                result = mFairy.findPic("stmnzlj2.png");
                mFairy.onTap(0.8f, result, "", 500);

                result = mFairy.findPic("stmnz3.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic("stmnz1.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.95f, result, "参与活动", 300);
                    } else {
                        result = mFairy.findPic("stmnzlj1.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.95f, result, "领奖", 1500);

                            result = mFairy.findPic("stmnzlj2.png");
                            mFairy.onTap(0.8f, result, "", 500);

                            mFairy.onTap(1214, 22, 1245, 48, "", 100);
                            setTaskEnd();
                            return;
                        }
                    }

                    result = mFairy.findPic("stmnz4.png");
                    mFairy.onTap(0.8f, result, 1013, 294, 1036, 317, "", 500);
                }

                result = mFairy.findPic(133, 36, 1132, 669, "stmnz5.png");
                mFairy.onTap(0.8f, result, "选择任务", 1000);

                FindResult tz = mFairy.findPic(644, 467, 907, 554, "stmnz6.png");
                if (tz.sim > 0.85f) {

                    result = mFairy.findPic("stmnz7.png");
                    if (result.sim > 0.9f) {
                        mFairy.onTap(918, 187, 933, 201, "", 300);
                        mFairy.onTap(1128, 62, 1141, 77, "", 300);
                        mFairy.onTap(1233, 27, 1247, 41, "", 300);
                        setTaskEnd();
                        return;
                    }

                    mFairy.onTap(0.85f, tz, "挑战", 300);

                }


                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }
            }
        };
    }//社团模拟战

    public void stgz() throws Exception {
        new singleTaskContent(mFairy, "社团工资") {

            void init() throws Exception {
                result = mFairy.findPic("shetuan1.png");
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(8, 0);

                if (gamePublicFuntion.mainScene()) {
                    result = mFairy.findPic(1023, 486, 1269, 710, "shetuan.png");
                    if (result.sim > 0.75f) {
                        err = 0;
                        mFairy.onTap(0.75f, result, "社团", 1000);
                    } else {
                        mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                    }
                }

                result = mFairy.findPic("shetuan4.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "福利", 500);
                    mFairy.onTap(102, 118, 159, 127, "社团工资", 1000);
                }

                result = mFairy.findPic("shetuan6.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(333, 636, 406, 656, "领取宝箱", 300);
                    setTaskEnd();
                    return;
                }
            }
        };
    }//社团工资

    private int stmj = 1;

    public void stmj() throws Exception {
        new singleTaskContent(mFairy, "社团募捐") {
            void create() throws Exception {
                super.create();
                if (!AtFairyConfig.getOption("stmj").equals("")) {
                    stmj = Integer.parseInt(AtFairyConfig.getOption("stmj"));
                }
            }

            void init() throws Exception {
                result = mFairy.findPic("shetuan1.png");
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(8, 0);

                if (gamePublicFuntion.mainScene()) {
                    result = mFairy.findPic(1023, 486, 1269, 710, "shetuan.png");
                    if (result.sim > 0.75f) {
                        err = 0;
                        mFairy.onTap(0.75f, result, "社团", 1000);
                    } else {
                        mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                    }
                }

                result = mFairy.findPic("shetuan4.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "福利", 500);
                    mFairy.onTap(615, 117, 654, 126, "社团募捐", 1000);
                }

                result = mFairy.findPic(886, 114, 1171, 196, "shetuan7.png");
                if (result.sim > 0.85f) {
                    switch (stmj) {
                        case 1:
                            mFairy.onTap(582, 592, 622, 602, "金币", 1000);
                            break;
                        case 2:
                            mFairy.onTap(970, 590, 1002, 602, "物品", 500);
                            if (mapCount(0.75f, 676, 134, 726, 339, "shetuan9.png")) {
                                stmj = 1;
                                return;
                            }
                            break;
                    }
                    result = mFairy.findPic("shetuan8.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(1220, 20, 1247, 48, "", 200);
                        setTaskEnd();
                        return;
                    }
                }
            }

        };
    }//社团募捐

    private int colorType = 1;

    public void hkxdt() throws Exception {
        new singleTaskContent(mFairy, "骇客兄弟团") {

            void create() throws Exception {
                if (!AtFairyConfig.getOption("colorType").equals("")) {
                    colorType = Integer.parseInt(AtFairyConfig.getOption("colorType"));
                }
            }
            void init() throws Exception {
                oneSecond = 0;
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_01() throws Exception {
                timeCount(8, 99);

                if (!AtFairyConfig.getOption("colorType").equals("")) {
                    colorType = Integer.parseInt(AtFairyConfig.getOption("colorType"));
                }

                st("hkxdt.png");

            }

            boolean colorTools(int x, int y, int x1, int y1) throws Exception {
                String color1 = "144,253,130";
                String color3 = "189,94,255";
                String color4 = "254,196,81";
                long l;

                switch (colorType) {
                    case 1:
                        return true;
                    case 2:
                        l = mFairy.getColorNum(x, y, x1, y1, color1, 0.98f);
                        if (l < 300) {
                            return true;
                        }
                        break;
                    case 3:
                        l = mFairy.getColorNum(x, y, x1, y1, color3, 0.98f);
                        if (l > 300) {
                            return true;
                        }

                        l = mFairy.getColorNum(x, y, x1, y1, color4, 0.98f);
                        if (l > 300) {
                            return true;
                        }
                        break;
                    case 4:
                        l = mFairy.getColorNum(x, y, x1, y1, color4, 0.98f);
                        if (l > 300) {
                            return true;
                        }
                        break;
                }
                return false;
            }

            void content_02() throws Exception {
                timeCount(10, 0);

                result = mFairy.findPic("syrxs9.png");
                mFairy.onTap(0.85f, result, "返回查看", 500);

                result = mFairy.findPic("hkxdt2.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    for (int i = 0; i < 4; i++) {
                        result = mFairy.findPic(284, 223, 956, 548, "hkxdt3.png");
                        mFairy.onTap(0.98f, result, "上传结果", 2000);
                    }

                    result = mFairy.findPic("hkxdt8.png");
                    if (result.sim > 0.92f) {
                        LimitlessTask.HK = false;
                        setTaskEnd();
                        return;
                    }

                    for (int i = 1; i <= 4; i++) {
                        switch (i) {
                            case 1:
                                result = mFairy.findPic(270, 128, 543, 319, "hkxdt4.png");
                                if (result.sim > 0.8f) {
                                    if (colorTools(270, 128, 543, 319)) {
                                        mFairy.onTap(372, 275, 430, 291, "点击>" + i, 2000);
                                    }
                                }
                                break;
                            case 2:
                                result = mFairy.findPic(749, 125, 982, 330, "hkxdt4.png");
                                if (result.sim > 0.8f) {
                                    if (colorTools(749, 125, 982, 330)) {
                                        mFairy.onTap(841, 275, 880, 286, "点击>" + i, 2000);
                                    }
                                }
                                break;
                            case 3:
                                result = mFairy.findPic(287, 333, 499, 546, "hkxdt4.png");
                                if (result.sim > 0.8f) {
                                    if (colorTools(287, 333, 499, 546)) {
                                        mFairy.onTap(366, 482, 439, 491, "点击>" + i, 2000);
                                    }
                                }
                                break;
                            case 4:
                                result = mFairy.findPic(742, 336, 990, 546, "hkxdt4.png");
                                if (result.sim > 0.8f) {
                                    if (colorTools(742, 336, 990, 546)) {
                                        mFairy.onTap(840, 483, 874, 493, "点击>" + i, 2000);
                                    }
                                }
                                break;
                        }
                    }

                    result = mFairy.findPic(301, 231, 968, 552, "hkxdt4.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic(926, 562, 1153, 616, "hkxdt6.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(1023, 631, 1061, 647, "刷新", 1000);
                        } else {
                            if (AtFairyConfig.getOption("hkzuan").equals("1")) {
                                mFairy.onTap(1023, 631, 1061, 647, "刷新", 1000);
                            } else {
                                colorType = 1;
                            }
                        }

                        result = mFairy.findPic("hkxdt7.png");
                        mFairy.onTap(0.85f, result, 712, 430, 747, 442, "确定", 1000);


                        result = mFairy.findPic(354, 227, 905, 451, "syrxs11.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, 513, 434, 580, 448, "", 500);
                            colorType = 1;
                            return;
                        }

                    } else {
                        if (frequencyMap("a", 2)) {
                            mFairy.onTap(1134, 51, 1148, 69, "", 300);
                            mFairy.onTap(1226, 25, 1243, 44, "", 300);
                            setTaskEnd();
                        }
                    }
                }
            }
        };
    }//骇客兄弟团

    public void syrxs() throws Exception {
        new singleTaskContent(mFairy, "守夜人悬赏") {

            void init() throws Exception {
                oneSecond = 0;
                gamePublicFuntion.actInitSlide = true;
                gamePublicFuntion.init(1, false);
                setTaskName(1);
            }

            void create() throws Exception {
                activityName = "syrxs.png";

                if (!AtFairyConfig.getOption("syrxsColor").equals("")) {
                    colorType = Integer.parseInt(AtFairyConfig.getOption("syrxsColor"));
                }
            }

            void content_01() throws Exception {
                if (timeCount(8, 0)) {
                    if (frequencyMap("活动", 2)) {
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic("rank0.png");
                mFairy.onTap(0.96f, result, 1240, 94, 1251, 118, "目标", 500);

                if (Abnormal.HONG) {
                    if (gamePublicFuntion.hong()) {
                        setTaskName(0);
                        Thread.sleep(1000);
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

                result = mFairy.findPic("buke2.png");
                if (result.sim > 0.85f) {

                    result = mFairy.findPic("buke1.png");
                    mFairy.onTap(0.85f, result, "补课-ok", 500);

                    switch (buke) {
                        case 1:
                            mFairy.onTap(890, 618, 945, 630, "金币找回", 1000);
                            break;
                        case 2:
                            mFairy.onTap(1048, 617, 1092, 636, "钻石找回", 1000);
                            break;
                    }

                    result = mFairy.findPic(326, 263, 798, 396, "buke3.png");
                    mFairy.onTap(0.85f, result, 723, 429, 738, 451, "确定消耗", 500);

                    mFairy.onTap(1127, 51, 1145, 68, "关闭找回界面", 5000);
                }

                result = mFairy.findPic("activity1.png");
                if (result.sim > 0.85f) {
                    if (buke != 0) {
                        result = mFairy.findPic("buke.png");
                        if (result.sim > 0.85f) {
                            err = 0;
                            mFairy.onTap(0.85f, result, "补课", 300);
                            return;
                        }
                    }

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
                    if (act.sim > 0.85f) {
                        if (activityEnd(act)) {
                            setTaskEnd();
                            return;
                        }

                        result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70, "can.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(0.85f, result, "参加", 1000);
                            oneSecond = 0;
                            setTaskName(2);
                            return;
                        }

                        if (activityName.equals("ddjy.png")) {
                            mFairy.onTap(1213, 46, 1230, 62, "", 500);
                            oneSecond = 0;
                            setTaskName(2);
                            return;
                        }

                        result = mFairy.findPic(act.x + 110, act.y - 10, act.x + 400, act.y + 70,
                                new String[]{"wan.png", "ji.png"});
                        if (result.sim > 0.85f) {
                            LimitlessTask.SYR = false;
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

            boolean colorTools(int x, int y, int x1, int y1) throws Exception {
                String color1 = "56,83,119";
                String color3 = "188,148,81";
                String color4 = "146,55,63";

                long l;

                switch (colorType) {
                    case 1:
                        return true;
                    case 2:
                        l = mFairy.getColorNum(x, y, x1, y1, color1, 0.98f);
                        if (l < 300) {
                            return true;
                        }
                    case 3:
                        l = mFairy.getColorNum(x, y, x1, y1, color3, 0.98f);
                        if (l > 300) {
                            return true;
                        }
                        l = mFairy.getColorNum(x, y, x1, y1, color4, 0.98f);
                        if (l > 300) {
                            return true;
                        }
                        break;
                    case 4:
                        l = mFairy.getColorNum(x, y, x1, y1, color4, 0.98f);
                        if (l > 300) {
                            return true;
                        }
                        break;
                }

                return false;

            }

            void content_02() throws Exception {
                timeCount(7, 0);

                result = mFairy.findPic("syrxs3.png");
                mFairy.onTap(0.85f, result, "确定", 500);

                result = mFairy.findPic("syrxs1.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    result = mFairy.findPic(980, 174, 1156, 666, "syrxs2.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "领奖", 500);
                        return;
                    }

                    result = mFairy.findPic(991, 181, 1154, 660, "syrxs4.png");
                    if (result.sim > 0.8f) {

                        result = mFairy.findPic("syrxs12.png");
                        if (result.sim > 0.95f) {
                            setTaskEnd();
                            return;
                        }

                        if (modularLookup > 3) {
                            modularLookup = 0;
                            result = mFairy.findPic(1023, 71, 1100, 110, "syrxs7.png");
                            if (result.sim > 0.8f) {
                                mFairy.onTap(1049, 120, 1087, 131, "免费", 500);
                            } else {
                                if (AtFairyConfig.getOption("syrs").equals("1")) {
                                    mFairy.onTap(1049, 120, 1087, 131, "钻石刷新", 800);

                                    result = mFairy.findPic(421, 292, 667, 382, "syrxs8.png");
                                    mFairy.onTap(0.85f, result, 712, 430, 738, 444, "", 500);
                                } else {
                                    colorType = 1;
                                    return;
                                }
                            }

                            result = mFairy.findPic(421, 292, 667, 382, "syrxs8.png");
                            mFairy.onTap(0.85f, result, 712, 430, 738, 444, "", 500);

                            result = mFairy.findPic("syrxs10.png");
                            mFairy.onTap(0.85f, result, 533, 430, 572, 444, "", 500);

                            result = mFairy.findPic(354, 227, 905, 451, "syrxs11.png");
                            if (result.sim > 0.85f) {
                                mFairy.onTap(0.85f, result, 528, 434, 564, 447, "", 500);
                                colorType = 1;
                                return;
                            }

                        }

                        FindResult syr = modularLookup(998, 198, 1155, 304, "syrxs4.png");
                        if (syr.sim > 0.85f) {
                            switch (modularLookup) {
                                case 0:
                                    if (colorTools(44, 198, 83, 235)) {
                                        mFairy.onTap(0.85f, syr, "点击派遣", 500);
                                    }
                                    break;
                                case 1:
                                    if (colorTools(42, 306, 84, 348)) {
                                        mFairy.onTap(0.85f, syr, "点击派遣", 500);
                                    }
                                    break;
                                case 2:
                                    if (colorTools(42, 420, 84, 458)) {
                                        mFairy.onTap(0.85f, syr, "点击派遣", 500);
                                    }
                                    break;
                                case 3:
                                    if (colorTools(45, 530, 82, 570)) {
                                        mFairy.onTap(0.85f, syr, "点击派遣", 500);
                                    }
                                    break;
                            }
                        }

                        if(frequencyMap("m",2)) {
                            modularLookup++;
                        }
                    } else {
                        if (frequencyMap("syr", 3)) {
                            setTaskEnd();
                            return;
                        }
                    }

                    result = mFairy.findPic(778,546,1048,694,"syrxs5.png");
                    if (result.sim > 0.8f) {

                        mFairy.onTap(185, 552, 207, 570, "", 200);
                        mFairy.onTap(295, 555, 316, 569, "", 200);
                        mFairy.onTap(414, 552, 434, 565, "", 200);
                        mFairy.onTap(527, 551, 544, 570, "", 200);
                        mFairy.onTap(625, 549, 644, 570, "", 200);

                        mFairy.onTap(0.8f, result, "确定", 500);
                        if (mapCount(0.8f, 641, 129, 750, 399, "syrxs6.png")) {
                            mFairy.onTap(1103, 74, 1117, 87, "", 300);
                            mFairy.onTap(1228, 27, 1249, 46, "", 300);
                            setTaskEnd();
                            return;
                        }
                    }


                }
            }
        };
    }//守夜人悬赏

    /**
     * 限时
     */
    public void yxls() throws Exception {
        new singleTaskContent(mFairy, "游行猎手") {

            void create() throws Exception {
                super.create();
                activityName = "yxls.png";
                activityType = 2;
            }

            void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
                minute = mFairy.dateMinute();
                if (minute > 50) {
                    setTaskEnd();
                    return;
                }
            }

            void content_02() throws Exception {
                timeCount(8, 0);


                FindResult qian = mFairy.findPic(693, 530, 860, 652, "yxls1.png");
                if (qian.sim > 0.85f) {
                    err = 0;
                    battle();
                    if (gamePublicFuntion.stop()) {
                        mFairy.onTap(0.85f, qian, "点击前往", 1000);
                    }
                }

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                }

                result = mFairy.findPic(429, 489, 573, 572, "yxls2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(630, 666, 644, 689, "离开", 800);
                    mFairy.onTap(713, 428, 744, 442, "", 1000);
                    setTaskEnd();
                    return;
                }
            }
        };
    }//游行猎手

    public void bhst() throws Exception {
        new singleTaskContent(mFairy, "崩坏社团") {

            void create() throws Exception {
                super.create();
                activityName = "bhst.png";
                activityType = 2;
            }

            void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
                minute = mFairy.dateMinute();
                if (minute > 50) {
                    setTaskEnd();
                    return;
                }
            }

            void content_02() throws Exception {
                timeCount(8, 0);

                FindResult qian = mFairy.findPic(693, 530, 860, 652, "bhst1.png");
                if (qian.sim > 0.85f) {
                    err = 0;
                    battle();
                    if (gamePublicFuntion.stop()) {
                        mFairy.onTap(0.85f, qian, "点击前往", 1000);
                    }
                }

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                }

                result = mFairy.findPic(429, 489, 573, 572, "yxls2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(630, 666, 644, 689, "离开", 800);
                    mFairy.onTap(713, 428, 744, 442, "", 1000);
                    setTaskEnd();
                    return;
                }
            }
        };
    }//崩坏社团

    public void jjbwt() throws Exception {
        new singleTaskContent(mFairy, "紧急保卫团") {

            void create() throws Exception {
                super.create();
                activityName = "jjbwt.png";
                activityType = 2;
            }

            void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
                hour = mFairy.dateHour();
                minute = mFairy.dateMinute();
                if (hour == 21 && minute > 30) {
                    setTaskEnd();
                    return;
                }
            }

            void content_02() throws Exception {
                timeCount(8, 0);

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }
            }
        };
    }//紧急保卫团

    public void stjs() throws Exception {
        new singleTaskContent(mFairy, "社团竞赛") {

            void create() throws Exception {
                super.create();
                activityName = "stjs.png";
                activityType = 2;
            }

            void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("st.png");
                if (result.sim > 0.85f) {
                    TaskMain.ST = false;
                    setTaskEnd();
                    return;
                }
                hour = mFairy.dateHour();
                minute = mFairy.dateMinute();
                if (hour == 21 && minute > 30) {
                    setTaskEnd();
                    return;
                }
            }

            void content_02() throws Exception {
                timeCount(8, 0);

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }
            }
        };
    }//社团竞赛

    public void sxjjc() throws Exception {
        new singleTaskContent(mFairy, "实训竞技场") {

            void create() throws Exception {
                super.create();
                activityName = "sxjjc.png";
                activityType = 3;
            }

            void inOperation() throws Exception {
                super.inOperation();
                minute = mFairy.dateMinute();
                if (minute > 30) {
                    setTaskEnd();
                    return;
                }

            }

            void content_02() throws Exception {
                timeCount(10, 0);

                result = mFairy.findPic(982, 275, 1178, 545, "sxjjc2.png");
                mFairy.onTap(0.85f, result, "进入竞技场", 500);

                if (gamePublicFuntion.fuben()) {
                    err = 0;
                    battle();
                }

                result = mFairy.findPic("sxjjc3.png");
                if (result.sim > 0.85f) {
                    err = 0;

                    result = mFairy.findPic(523, 585, 887, 643, "sxjjc7.png");
                    mFairy.onTap(0.85f, result, result.x - 13, result.y + 30, result.x - 10, result.y + 32, "领取宝箱", 500);

                }

                result = mFairy.findPic(603, 86, 680, 155, "sxjjc6.png");
                mFairy.onTap(0.85f, result, "点击匹配图标", 500);

                result = mFairy.findPic(572, 599, 675, 688, "sxjjc4.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

                result = mFairy.findPic(487, 279, 659, 439, "sxjjc5.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    mFairy.onTap(634, 473, 672, 510, "战斗结束", 500);

                }
            }
        };
    }//实训竞技场

    public boolean cszy() throws Exception {

        new singleTaskContent(mFairy, "车神之役") {
            void create() throws Exception {
                super.create();
                activityName = "cszy.png";
                gamePublicFuntion.liRank(1);
                activityType = 2;
                actBools = true;
            }

            void inOperation() throws Exception {
                super.inOperation();

                minute = mFairy.dateMinute();
                if (minute > 40) {
                    actBools = false;
                    setTaskEnd();
                    return;
                }
            }

            void content_02() throws Exception {
                timeCount(8, 0);
                result = mFairy.findPic(971, 194, 1158, 566, "cszy1.png");
                mFairy.onTap(0.85f, result, "竞速比赛", 1000);

                result = mFairy.findPic(996, 576, 1176, 704, "jskb2.png");
                mFairy.onTap(0.85f, result, "比赛", 300);

                result = mFairy.findPic("jskb3.png");
                mFairy.onTap(0.85f, result, "确定选择", 50000);

                result = mFairy.findPic("jskb5.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "确定选择", 1500);
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic("jskb4.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

                result = mFairy.findPic(449, 271, 765, 439, "cszy2.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

            }
        };
        return TaskContent.actBools;
    }//车神之役

    public void bgsq() throws Exception {
        new singleTaskContent(mFairy, "八卦社区") {

            void create() throws Exception {
                super.create();
                activityName = "bgsq.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(5, 0)) {
                    if (actBools) {
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic(180, 487, 310, 558, "bgsq1.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    mFairy.onTap(0.85f, result, 510, 333, 546, 391, "A", 2500);
                    actBools = true;
                }
            }
        };
    }//八卦社区

    public void bgzw() throws Exception {
        new singleTaskContent(mFairy, "八卦之王") {

            void create() throws Exception {
                super.create();
                activityName = "bgzw.png";
                activityType = 2;
            }

            void content_02() throws Exception {
                if (timeCount(5, 0)) {
                    if (actBools) {
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic(180, 487, 310, 558, "bgsq1.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    mFairy.onTap(0.85f, result, 510, 333, 546, 391, "A", 2500);
                    actBools = true;
                }

            }
        };
    }//八卦之王

    public void jdbyj() throws Exception {
        new singleTaskContent(mFairy, "京东白月境") {

            void create() throws Exception {
                super.create();
                activityName = "jdbyj.png";
                activityType = 2;
            }

            void inOperation() throws Exception {
                super.inOperation();
                minute = mFairy.dateMinute();
                if (minute > 40) {
                    setTaskEnd();
                    return;
                }

            }

            void content_02() throws Exception {
                if (timeCount(10, 0)) {
                    oneSecond = 0;
                    return;
                }

                result = mFairy.findPic(982, 275, 1178, 545, "jdbyj1.png");
                mFairy.onTap(0.85f, result, "京东白月境", 500);

                result = mFairy.findPic(1164, 27, 1198, 54, new String[]{"jdbyj2.png", "jdbyj3.png"});
                if (result.sim > 0.72f) {
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

                }

            }
        };
    }//京东白月境
    /*** 招募
     */
    public void mfzm() throws Exception {
        new singleTaskContent(mFairy, "免费招募") {

            void init() throws Exception {
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void content_01() throws Exception {
                timeCount(8, 99);

                if (gamePublicFuntion.mainScene()) {
                    result = mFairy.findPic(912, 364, 1272, 706, "zm.png");
                    if (result.sim > 0.75f) {
                        err = 0;
                        mFairy.onTap(0.75f, result, "招募", 1000);
                    } else {
                        mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                    }
                }

                result = mFairy.findPic("zm10.png");
                mFairy.onTap(0.85f, result, 1228, 31, 1244, 49, "err 关闭", 500);

                result = mFairy.findPic("zm6.png");
                mFairy.onTap(0.85f, result, "确定", 500);

                result = mFairy.findPic("zm1.png");
                mFairy.onTap(0.85f, result, "招", 500);

                result = mFairy.findPic("zm4.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    mFairy.onTap(0.85f, result, 625, 342, 670, 414, "本次免费", 800);
                    if (mapCount(0.8f, 456, 56, 628, 404, "zm12.png")) {
                        /**
                         * 消息推送 */
                        setTaskEnd();
                        return;
                    } else {
                        Thread.sleep(5000);
                    }
                }
                result = mFairy.findPic(new String[]{"zm5.png", "zm13.png"});
                if (result.sim > 0.85f) {
                    err = 0;
                    mFairy.onTap(0.85f, result, 1137, 521, 1183, 561, "获得伙伴", 500);
                }
                result = mFairy.findPic("zm2.png");
                if (result.sim > 0.85f) {
                    err = 0;

                    if (oneSecond()) {
                        mFairy.onTap(72, 344, 86, 379, "上一页", 1000);
                    }

                    result = mFairy.findPic(148, 258, 698, 371, "zm11.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "免费", 2000);
                        result = mFairy.findPic("zm10.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(559, 149, 594, 188, "", 500);
                        }
                        return;
                    }

                    result = mFairy.findPic(77, 340, 646, 507, "zm11.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "免费", 2000);
                        result = mFairy.findPic("zm10.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(664, 478, 693, 519, "", 500);
                        }
                        return;
                    }
                    if (frequencyMap("one", 3)) {
                        mFairy.onTap(1205, 346, 1222, 372, "下一页", 2000);
                    }
                    if (frequencyMap("two", 6)) {
                        mFairy.onTap(1230, 24, 1247, 42, "", 300);
                        mFairy.onTap(1230, 24, 1247, 42, "", 300);
                        setTaskEnd();
                        return;
                    }

                }


            }
        };
    }//免费招募
    /*** other
     */
    private boolean zb = false;
    private boolean zhuang = false;
    public void zhuangbei() throws Exception {
        new singleTaskContent(mFairy, "转移和分解") {

            void init() throws Exception {
                gamePublicFuntion.init(0, false);
                setTaskName(1);
                zb = false;
            }

            void content_01() throws Exception {
                timeCount(10, 0);

                if (gamePublicFuntion.mainScene()) {
                    if (frequencyMap("packageClick", 2)) {
                        mFairy.onTap(1140, 304, 1153, 323, "点击背包", 500);
                    }
                }


                result = mFairy.findPic("zhuangbei2.png");
                if (result.sim > 0.85f) {
                    err = 0;
                }

                result = mFairy.findPic("zhuangbei3.png");
                if (result.sim > 0.85f) {
                    zb = true;
                }

                if (zb) {
                    for (int j = 0; j < 6; j++) {
                        int c = mFairy.getColorNum(805, 105 + (j * 80), 845, 145 + (j * 80), "36,48,65", 0.98f);
                        if (c > 100) {
                            setTaskEnd();
                            return;
                        }

                        for (int i = 0; i < 5; i++) {

                            result = mFairy.findPic(785 + (i * 80), 75 + (j * 80), 865 + (i * 80), 145 + (j * 80)
                                    , "zhuangbei15.png");
                            if (result.sim > 0.85f) {
                                zhuang = true;
                            }

                            mFairy.onTap(825 + (i * 80), 125 + (j * 80), 830 + (i * 80), 130 + (j * 80),
                                    "(" + (j + 1) + "," + (i + 1) + ")", 1000);

                            FindResult zb = mFairy.findPic(716, 5, 1206, 714, "zhuangbei7.png");
                            if (zb.sim > 0.85f) {

                                if (zhuang) {
                                    result = mFairy.findPic(744, 53, 1194, 616, "zhuangbei14.png");
                                    if (result.sim > 0.85f) {
                                        mFairy.onTap(0.85f, result, "装备", 1500);
                                        i--;
                                    }
                                    zhuang = false;
                                } else {

                                    result = mFairy.findPic(744, 53, 1194, 616, "zhuangbei8.png");
                                    if (result.sim > 0.85f) {
                                        mFairy.onTap(0.85f, result, "转移", 1500);
                                    } else {
                                        mFairy.onTap(0.85f, zb, "分解", 500);
                                    }
                                }
                            }

                            boolean zhuan = false;
                            for (int o = 0; o < 7; o++) {
                                result = mFairy.findPic("zhuangbei9.png");
                                if (result.sim > 0.85f) {
                                    zhuan = true;
                                    result = mFairy.findPic(730, 196, 789, 566, "zhuangbei10.png");
                                    if (result.sim > 0.95f) {
                                        mFairy.tap(result.x, result.y);
                                        mFairy.onTap(622, 641, 653, 654, "转移", 500);

                                        if (mapCount(0.85f, 593, 98, 699, 377, "zhuangbei16.png")) {
                                            zhuan = false;
                                            break;
                                        }
                                    }

                                    result = mFairy.findPic(new String[]{"zhuangbei11.png", "zhuangbei12.png"});
                                    if (result.sim > 0.85f) {
                                        mFairy.onTap(706, 431, 747, 447, "确定", 1000);
                                        zhuan = false;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }

                            if (zhuan) {
                                i--;
                            }

                            result = mFairy.findPic("zhuangbei13.png");
                            mFairy.onTap(0.85f, result, "close", 1000);
                        }
                    }
                } else {
                    result = mFairy.findPic("zhuangbei4.png");
                    mFairy.onTap(0.85f, result, "全部", 1500);

                    result = mFairy.findPic("zhuangbei5.png");
                    mFairy.onTap(0.85f, result, "装备", 1000);
                }


            }
        };
    }//转移和分解

    private boolean qing = false;

    public void qingbao() throws Exception {
        new singleTaskContent(mFairy, "清理背包") {

            void init() throws Exception {
                gamePublicFuntion.init(0, false);
                setTaskName(1);
                qing = false;
            }

            void use() throws Exception {

                if (AtFairyConfig.getOption("qing1").equals("1")) {//称号
                    result = mFairy.findPic(790, 87, 1191, 610, "q1.png");
                    if (result.sim > 0.85f) {
                        err = 0;
                        mFairy.onTap(0.85f, result, "q1", 700);
                        return;
                    }
                }

                /*if (AtFairyConfig.getOption("qing2").equals("1")) {//礼包
                    result = mFairy.findPic(790, 87, 1191, 610, "q2.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q2", 700);
                        return;
                    }

                    result = mFairy.findPic(790, 87, 1191, 610, "q11.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q11", 700);
                        return;
                    }

                    result = mFairy.findPic(790, 87, 1191, 610, "q3.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q3", 700);
                        return;
                    }

                    result = mFairy.findPic(790, 87, 1191, 610, "q8.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q8", 700);
                        return;
                    }

                    result = mFairy.findPic(790, 87, 1191, 610, "q9.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q9", 700);
                        return;
                    }
                }*/

                if (AtFairyConfig.getOption("qing3").equals("1")) {//言灵
                    result = mFairy.findPic(790, 87, 1191, 610, "q4.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q4", 700);
                        return;
                    }
                    result = mFairy.findPic(790, 87, 1191, 610, "q5.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q5", 700);
                        return;
                    }
                    result = mFairy.findPic(790, 87, 1191, 610, "q6.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q6", 700);
                        return;
                    }
                    result = mFairy.findPic(790, 87, 1191, 610, "q7.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "q7", 700);
                        return;
                    }
                }

                if (AtFairyConfig.getOption("qing4").equals("1")) {//钻石
                    result = mFairy.findPic(790, 87, 1191, 610, "q10.png");
                    if (result.sim > 0.85f) {
                        err = 0;
                        mFairy.onTap(0.85f, result, "q10", 700);
                        return;
                    }
                }
                if (frequencyMap("背包", 2)) {
                    setTaskEnd();
                    return;
                }

            }//使用

            void content_01() throws Exception {
                timeCount(10, 99);

                if (gamePublicFuntion.mainScene()) {
                    if (frequencyMap("packageClick", 2)) {
                        mFairy.onTap(1140, 304, 1153, 323, "点击背包", 500);
                    }
                }

                result = mFairy.findPic("qing2.png");
                if (result.sim > 0.85f) {
                    qing = true;
                }

                if (qing) {

                    use();

                    result = mFairy.findPic(647, 52, 1214, 629, "qing3.png");
                    mFairy.onTap(0.85f, result, "使用", 1000);

                    result = mFairy.findPic("qing4.png");
                    mFairy.onTap(0.85f, result, "批量使用", 3000);
                } else {
                    result = mFairy.findPic("zhuangbei4.png");
                    mFairy.onTap(0.85f, result, "全部", 1500);

                    result = mFairy.findPic("qing1.png");
                    mFairy.onTap(0.85f, result, "消耗", 1000);
                }
            }
        };

    }//清理背包

    public void qian() throws Exception {
        new singleTaskContent(mFairy, "签到") {

            void init() throws Exception {
                gamePublicFuntion.init(0, false);
                setTaskName(1);
            }

            void inOperation() throws Exception {
                result = mFairy.findPic("use.png");
                mFairy.onTap(0.85f, result, "使用", 300);

                result = mFairy.findPic("nn14.png");
                mFairy.onTap(0.85f, result, "领取", 300);

                result = mFairy.findPic("nn2.png");
                mFairy.onTap(0.85f, result, "立刻穿戴", 1000);

                gamePublicFuntion.qx();
            }

            void fl() throws Exception {
                result = mFairy.findPic("fl2.png");
                if (result.sim > 0.85f) {
                    while (mFairy.condit()) {
                        mFairy.onTap(1109, 273, 1130, 300, "", 500);
                        mFairy.onTap(1109, 273, 1130, 300, "", 500);
                        mFairy.onTap(1111, 467, 1140, 491, "", 500);
                        mFairy.onTap(916, 545, 944, 573, "", 500);
                        mFairy.onTap(742, 478, 769, 507, "", 500);
                        mFairy.onTap(739, 294, 766, 311, "", 500);
                        mFairy.onTap(911, 182, 939, 201, "", 500);

                        result = mFairy.findPic("use.png");
                        if (result.sim > 0.8f) {
                            for (int i = 0; i < 3; i++) {
                                result = mFairy.findPic("use.png");
                                if (result.sim > 0.8f) {
                                    i = 0;
                                    mFairy.onTap(0.8f, result, "使用", 500);
                                }
                            }
                            continue;
                        }
                        return;
                    }
                }

                result = mFairy.findPic(749, 554, 878, 687, "fl3.png");
                if (result.sim > 0.85f) {
                    while (mFairy.condit()) {
                        mFairy.onTap(1143, 530, 1186, 546, "领取连续签到奖励", 500);
                        mFairy.onTap(1141, 622, 1176, 641, "签到", 500);
                        result = mFairy.findPic("use.png");
                        if (result.sim > 0.8f) {
                            for (int i = 0; i < 5; i++) {
                                result = mFairy.findPic(1115,602,1200,665,"fl11.png");
                                mFairy.onTap(0.95f, result, "补签", 500);

                                result = mFairy.findPic("use.png");
                                if (result.sim > 0.8f) {
                                    i = 0;
                                    mFairy.onTap(0.8f, result, "使用", 500);
                                }
                            }
                            continue;
                        }
                        return;
                    }
                }

                result = mFairy.findPic("fl12.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(365, 514, 399, 553, "", 500);
                    mFairy.onTap(519, 387, 560, 429, "", 500);
                    mFairy.onTap(700, 422, 733, 458, "", 500);
                    mFairy.onTap(851, 490, 878, 520, "", 500);
                    mFairy.onTap(988, 345, 1011, 369, "", 500);
                    mFairy.onTap(1155, 380, 1175, 397, "", 500);
                }


                result = mFairy.findPic("fl4.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(367, 574, 390, 598, "每日福利", 500);
                    mFairy.onTap(686,328,713,357, "每日福利", 500);
                    mFairy.onTap(852,330,877,355, "每日福利", 500);
                    mFairy.onTap(1005,329,1041,354, "每日福利", 500);

                    return;
                }

                result = mFairy.findPic("nn15.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(820, 243, 868, 262, "升级好礼", 500);
                    return;
                }

                result = mFairy.findPic("fl5.png");
                mFairy.onTap(0.8f,result,962, 625, 995, 640, "收获", 500);

                result = mFairy.findPic("fl13.png");
                if (result.sim > 0.85f) {
                    for(int i =0;i<2;i++){
                        mFairy.onTap(961,628,993,642,"灌溉",6000);
                    }
                    mFairy.onTap(961,628,993,642,"灌溉",500);
                    return;
                }


                result = mFairy.findPic("fl6.png");
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 8; i++) {
                        result = mFairy.findPic("use.png");
                        mFairy.onTap(0.85f, result, "使用", 300);

                        result = mFairy.findPic(313, 273, 1222, 625, "fl7.png");
                        if (result.sim > 0.85f) {
                            mFairy.onTap(result.x, result.y - 70, result.x + 1, result.y - 65, "领取周礼包", 500);
                        } else {
                            i = i + 2;
                        }
                    }
                    return;
                }

                result = mFairy.findPic(278, 551, 1267, 689, "fl8.png");
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(278, 551, 1267, 689, "fl8.png");
                        mFairy.onTap(0.85f, result, "领取", 500);
                    }
                    return;
                }

                result = mFairy.findPic("fl9.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "领取推送奖励", 300);
                    return;
                }
            }//福利

            void content_01() throws Exception {
                timeCount(10, 0);

                result = mFairy.findPic(660, 9, 936, 118, "fl.png");
                mFairy.onTap(0.8f, result, "福利", 500);

                result = mFairy.findPic("fl1.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    if (oneSecond()) {
                        mFairy.ranSwipe(172, 236, 190, 521, 0, 200, (long)1500);
                    }

                    for (int j = 1; j <= 7; j++) {

                        for (int l = 0; l < 3; l++) {
                            result = mFairy.findPic("use.png");
                            if (result.sim > 0.85f) {
                                mFairy.onTap(0.85f, result, "使用", 300);
                                l = 0;
                            }
                        }

                        switch (j) {
                            case 1:
                                result = mFairy.findPic(94, 63, 277, 716, "f1.png");
                                mFairy.onTap(0.8f, result, "在线不发", 1500);
                                break;
                            case 2:
                                result = mFairy.findPic(94, 63, 277, 716, "f9.png");
                                mFairy.onTap(0.8f, result, "y计划", 1500);
                                break;
                            case 3:
                                result = mFairy.findPic(94, 63, 277, 716, "f2.png");
                                mFairy.onTap(0.8f, result, "每日签到", 1500);
                                break;
                            case 4:
                                result = mFairy.findPic(94, 63, 277, 716, "f3.png");
                                mFairy.onTap(0.8f, result, "每周活跃", 1500);
                                break;
                            case 5:
                                result = mFairy.findPic(94, 63, 277, 716, "f4.png");
                                mFairy.onTap(0.8f, result, "每周狂欢", 1500);
                                break;
                            case 6:
                                mFairy.ranSwipe(172, 236, 190, 521, 2, 200, (long)1000);
                                result = mFairy.findPic(94, 63, 277, 716, "f5.png");
                                mFairy.onTap(0.8f, result, "等级奖励", 1500);
                                break;
                            case 7:
                                mFairy.ranSwipe(172, 236, 190, 521, 2, 200, (long)1000);
                                result = mFairy.findPic(94, 63, 277, 716, "f6.png");
                                mFairy.onTap(0.8f, result, "许愿树", 1500);
                                break;
                           /* case 7:
                                mFairy.ranSwipe(172,236,190,521,2,200,300);
                                result = mFairy.findPic(94,63,277,716, "f7.png");
                                mFairy.onTap(0.8f, result, "功能预告", 1000);
                                break;*/
                            case 8:
                                result = mFairy.findPic(94, 63, 277, 716, "f8.png");
                                mFairy.onTap(0.8f, result, "推送礼包", 1500);
                                break;

                        }
                        fl();
                    }
                    mFairy.onTap(1219, 21, 1244, 49, "", 200);
                    setTaskEnd();
                    return;
                }
            }
        };
    }//签到

    /**
     * 身份 */
    public void llzl() throws Exception {
        new singleTaskContent(mFairy, "料理之路") {

            void create() throws Exception {
                super.create();
                activityName = "llzl.png";
                activityType = 5;
            }

            void content_02() throws Exception {
                timeCount(7, 0);
                result = mFairy.findPic("llzl1.png");
            }
        };
    }//料理之路

    private int oxjx = 1;
    public void oxjx() throws Exception {
        new singleTaskContent(mFairy, "偶像巨星") {

            void create() throws Exception {
                super.create();
                activityName = "oxjx.png";
                activityType = 5;
                if (!AtFairyConfig.getOption("oxjx").equals("")) {
                    oxjx = Integer.parseInt(AtFairyConfig.getOption("oxjx"));
                }
            }

            void new_inOperation() throws Exception {
                result = mFairy.findPic("yx2.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, 720, 432, 747, 446, "确定退出本轮", 500);
                } else {
                    gamePublicFuntion.qx();

                }
            }

            void content_02() throws Exception {
                if (timeCount(8, 0)) {
                    result = mFairy.findPic("oxjx4.png");
                    mFairy.onTap(0.85f, result, "关掉", 200);
                }

                result = mFairy.findPic("shenfen2.png");
                if (result.sim > 0.85f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("yx1.png");
                mFairy.onTap(0.85f, result, "关掉", 500);

                result = mFairy.findPic("oxjx2.png");
                if (result.sim > 0.85f) {
                    err = 0;
                    switch (oxjx) {
                        case 1:
                            mFairy.onTap(1228, 213, 1252, 226, "才艺", 300);
                            break;
                        case 2:
                            mFairy.onTap(1223, 317, 1248, 336, "形象", 300);
                            break;
                        case 3:
                            mFairy.onTap(1223, 429, 1252, 442, "演出", 300);
                            break;
                    }

                    result = mFairy.findPic("oxjx1.png");
                    if (result.sim > 0.85f) {
                        mFairy.onTap(0.85f, result, "前往", 500);
                        if (mapCount(0.8f, 524, 121, 609, 377, "shenfen1.png")) {
                            LtLog.e(mFairy.getLineInfo("精力不足"));
                            setTaskEnd();
                            return;
                        } else {
                            Thread.sleep(3000);
                        }
                    }
                }
                result = mFairy.findPic(new String[]{"oxjx3.png", "oxjx5.png", "oxjx7.png"});
                if (result.sim > 0.85f) {
                    err = 0;
                }
            }
        };
    }//偶像巨星


    public void qh() throws Exception {
        int err = 0;
        while (mFairy.condit()) {
            LtLog.e(mFairy.getLineInfo("切换角色 >>>"));
            err++;
            if (err > 10) {
                gamePublicFuntion.init(0, false);
            }

            if (gamePublicFuntion.mainScene()) {
                result = mFairy.findPic(820, 270, 1271, 714, "setup.png");
                if (result.sim > 0.85f) {

                    mFairy.onTap(0.85f, result, "设置", 1000);
                } else {
                    mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                }
            }

            result = mFairy.findPic(419, 574, 1130, 695, "qh.png");
            if (result.sim > 0.85f) {
                err = 0;
                mFairy.onTap(0.85f, result, "切换角色", 500);
                mFairy.onTap(711, 431, 748, 447, "", 2000);
            }


            result = mFairy.findPic("qh1.png");
            if (result.sim > 0.85f) {
                err = 0;
                switch (TaskMain.QH) {
                    case 1:
                        mFairy.onTap(91, 93, 152, 114, "切换到角色" + TaskMain.QH, 500);
                        break;
                    case 2:
                        mFairy.onTap(84, 173, 149, 188, "切换到角色" + TaskMain.QH, 500);
                        break;
                    case 3:
                        mFairy.onTap(90, 265, 144, 275, "切换到角色" + TaskMain.QH, 500);
                        break;
                    case 4:
                        mFairy.onTap(96, 346, 155, 362, "切换到角色" + TaskMain.QH, 500);
                        break;
                }

                result = mFairy.findPic("kaishi.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "开始", 1000);
                    return;
                }
            }
        }


    }//切换

    public void test() throws Exception {
        new TaskContent(mFairy, "test") {
            @Override
            void init() throws Exception {

                LtLog.e("+++++++");

                if (frequencyMap("队伍计次", 5)) {
                    LtLog.e("-----------------------");
                }

                Thread.sleep(2000);
            }
        };
    }
}