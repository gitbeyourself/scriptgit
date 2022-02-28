package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

public class GamePublicFuntion {
    public AtFairyImpl mFairy;
    public FindResult result;
    public long time = System.currentTimeMillis();
    public static boolean actInitSlide = true;

    public GamePublicFuntion(AtFairyImpl atFairy) {
        mFairy = atFairy;
    }

    public boolean close() throws Exception {
        boolean bool = false;
        result = mFairy.findPic("close1.png");
        if (result.sim > 0.85f) {
            mFairy.onTap(0.85f, result, "关闭1", 1000);
            bool=true;
        }
        result = mFairy.findPic(944, 3, 1276, 277, "close2.png");
        if (result.sim > 0.85f) {
            mFairy.onTap(0.85f, result, "关闭2", 1000);
            bool=true;
        }
        result = mFairy.findPic(773, 7, 1273, 382, "close4.png");
        if (result.sim > 0.85f) {
            mFairy.onTap(0.85f, result, "关闭4", 1000);
            bool=true;
        }
        result = mFairy.findPic(773, 7, 1273, 382, "close3.png");
        if (result.sim > 0.85f) {
            mFairy.onTap(0.85f, result, "关闭3", 1000);
            bool=true;
        }

        result = mFairy.findPic("close5.png");
        if (result.sim > 0.85f) {
            mFairy.onTap(0.85f, result, "关闭5", 1000);
            bool=true;
        }

        result = mFairy.findPic("xiazai2.png");
        if (result.sim > 0.85f) {
            mFairy.onTap(0.85f, result, "关闭下载界面", 1000);
            bool=true;
        }

        return bool;
    }

    public void init(int type, boolean likai) throws Exception {
        int count = 0;
        int err  = 0;
        while (mFairy.condit()) {
            err++;
            if(err>6){
                mFairy.onTap(607,334,636,357,"点击空白处",1500);
                if (mainScene()) {
                    mFairy.ranSwipe(163, 446, 336, 471, 1, 1000, (long)500);
                }
                err=0;
            }
            Thread.sleep(100);
            LtLog.e(mFairy.getLineInfo("init >>>"));

            result = mFairy.findPic("oxjx4.png");
            mFairy.onTap(0.85f, result, "关掉", 200);

            result = mFairy.findPic("hong1.png");
            if (result.sim > 0.85f && Abnormal.HONG) {
                Thread.sleep(3000);
                continue;
            }

            result = mFairy.findPic("close1.png");
            mFairy.onTap(0.85f, result, "关闭1", 500);

            result = mFairy.findPic(586,310,668,711,"ok3.png");
            mFairy.onTap(0.85f, result, "ok3", 500);

            if (fuben() && likai) {

                result = mFairy.findPic("zanli.png");
                mFairy.onTap(0.85f, result, "暂离执行", 1000);

                mFairy.onTap(630, 666, 644, 689, "离开", 1000);
                mFairy.onTap(713, 428, 744, 442, "", 1000);
            } else {
                if (type == 1) {
                    result = mFairy.findPic(545, 18, 911, 94,
                            new String[]{"activity.png", "activity4.png", "activity6.png","activity7.png"});
                    LtLog.e(mFairy.getLineInfo("活动sim: "+result.sim));
                    if (result.sim > 0.68f) {
                        actInitSlide = false;
                        mFairy.onTap(0.68f, result, "活动按钮", 1500);
                    }
                    result = mFairy.findPic("activity1.png");
                    if (result.sim > 0.85f) {
                        return;
                    }
                }
            }

            close();

            qx();

            result = mFairy.findPic(409, 240, 836, 385, "jia1.png");
            if (result.sim > 0.85f) {
                mFairy.onTap(558, 344, 574, 364, "不在提示", 500);
                mFairy.onTap(529, 418, 568, 427, "拒绝添加好友", 500);
            }

            result = mFairy.findPic("fuhuo.png");
            mFairy.onTap(0.85f, result, "复活", 300);

            result = mFairy.findPic("use.png");
            mFairy.onTap(0.85f, result, "使用", 300);

            result = mFairy.findPic("activity2.png");
            mFairy.onTap(0.85f, result, "提示框", 300);

            result = mFairy.findPic(507, 301, 779, 666, "ok1.png");
            mFairy.onTap(0.85f, result, "确认1", 1000);

            result = mFairy.findPic("bsylx8.png");
            mFairy.onTap(0.85f, result, 792, 573, 858, 586, "通话", 500);

            if (type != 1) {
                if (mainScene()) {
                    count++;
                    if (count >= 2) {
                        return;
                    }
                }
            }
        }
    }

    public void clickRank() throws Exception {
        for (int i = 0; i < 3; i++) {
            result = mFairy.findPic("rank21.png");
            mFairy.onTap(0.72f, result, "组队", 500);
        }
    }//点击队伍

    public void ChoiceActivityType(int num) throws Exception {
        switch (num) {
            case 1:
                mFairy.onTap(146, 146, 198, 163, "历练", 300);
                break;
            case 2:
                mFairy.onTap(173, 242, 209, 257, "限时", 300);
                break;
            case 3:
                mFairy.onTap(167, 328, 203, 344, "竞技", 300);
                break;
            case 4:
                mFairy.onTap(170, 423, 216, 442, "挑战", 300);
                break;
            case 5:
                mFairy.onTap(179, 517, 232, 538, "身份", 300);
                break;
        }
    }

    public void qx() throws Exception {
        result = mFairy.findPic(254, 164, 647, 653, new String[]{"qx.png", "qx1.png"});
        mFairy.onTap(0.8f, result, "取消", 500);
    }//取消

    public FindResult qxBool() throws Exception {
        return mFairy.findPic(254, 164, 647, 653, new String[]{"qx.png", "qx1.png"});
    }//取消

    public void tuoli() throws Exception {
        for (int i = 0; i < 10; i++) {

            if (mainScene()) {
                result = mFairy.findPic(820, 270, 1271, 714, "setup.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(0.85f, result, "设置", 1000);
                } else {
                    mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                }
            }

            result = mFairy.findPic("tuoli1.png");
            if (result.sim > 0.85f) {
                mFairy.onTap(0.85f, result, "脱离卡死", 1500);
                mFairy.onTap(714, 426, 756, 447, "确定", 1000);
                return;
            }

        }
    }//脱离

    public void setUp() throws Exception {
        int err = 10;
        while (mFairy.condit()) {
            err++;
            if (err >= 10) {
                init(0, false);
                err = 0;
            }

            result = mFairy.findPic("use.png");
            mFairy.onTap(0.85f, result, "使用", 300);

            result = mFairy.findPic("nn14.png");
            mFairy.onTap(0.85f, result, "领取", 300);

            result = mFairy.findPic("nn2.png");
            mFairy.onTap(0.85f, result, "立刻穿戴", 1000);


            result = mFairy.findPic("mub1.png");
            if (result.sim > 0.75f) {
                result = mFairy.findPic(820, 270, 1271, 714, "setup.png");
                if (result.sim > 0.75f) {
                    mFairy.onTap(0.75f, result, "设置", 1000);
                } else {
                    mFairy.onTap(1218, 299, 1247, 327, "点击缩放栏", 1500);
                }
            }

            result = mFairy.findPic(1091, 89, 1174, 685, "setup1.png");
            if (result.sim > 0.85f) {
                for (int i = 1; i <= 3; i++) {
                    switch (i) {
                        case 1:
                            mFairy.onTap(1112, 130, 1142, 162, "基础", 1000);
                            for (int j = 1; j <= 7; j++) {
                                result = mFairy.findPic("set" + j + ".png");
                                mFairy.onTap(0.95f, result, "Set", 500);

                                result = mFairy.findPic("set" + j + ".png");
                                mFairy.onTap(0.95f, result, "Set", 500);
                            }
                            break;
                        case 2:
                            mFairy.onTap(1113, 233, 1152, 269, "战斗", 1000);
                            mFairy.onTap(582, 447, 597, 461, "优先攻击最近目标", 300);
                            break;
                        case 3:
                            mFairy.onTap(1112, 343, 1147, 377, "画面", 1000);
                            result = mFairy.findPic("setup2.png");
                            mFairy.onTap(0.85f, result, "省电画质", 300);
                            mFairy.onTap(1115, 49, 1141, 76, "", 300);
                            return;
                    }
                }
            }
        }
    }//设置

    public int ranksNum() throws Exception {
        for (int i = 0; i < 2; i++) {

            result = mFairy.findPic(355, 339, 471, 441, "rank12.png");
            if (result.sim > 0.85f) {
                LtLog.e(mFairy.getLineInfo("当前队伍人数：1"));
                return 1;
            }
            result = mFairy.findPic(543, 344, 652, 429, "rank12.png");
            if (result.sim > 0.85f) {
                LtLog.e(mFairy.getLineInfo("当前队伍人数：2"));
                return 2;
            }
            result = mFairy.findPic(734, 343, 828, 427, "rank12.png");
            if (result.sim > 0.85f) {
                LtLog.e(mFairy.getLineInfo("当前队伍人数：3"));
                return 3;
            }
            result = mFairy.findPic(912, 349, 1014, 424, "rank12.png");
            if (result.sim > 0.85f) {
                LtLog.e(mFairy.getLineInfo("当前队伍人数：4"));
                return 4;
            }
        }
        LtLog.e(mFairy.getLineInfo("当前队伍人数：满人"));
        return 5;
    }//人数

    public boolean stop() throws Exception {
        result = mFairy.findPic(new String[]{"fb2.png", "fb3.png"});
        if (result.sim > 0.8f) {
            return true;
        }
        return false;
    }

    public boolean mainScene() throws Exception {
        result = mFairy.findPic("mub1.png");
        if (result.sim > 0.75f) {
            return true;
        }
        return false;
    }//

    public void liRank(int i) throws Exception {
        int err = 10;
        while (mFairy.condit()) {
            if (err >= 10) {
                init(0, false);
                err = 0;
            }

            if (i == 0) {
                result = mFairy.findPic("rank1.png");
                mFairy.onTap(0.9f, result, "组队", 1000);

                result = mFairy.findPic("zanli.png");
                mFairy.onTap(0.85f, result, "暂离执行", 300);

                return;
            } else {
                result = mFairy.findPic("rank2.png");
                if (result.sim > 0.85f) {
                    return;
                }

                result = mFairy.findPic("rank3.png");
                if (result.sim > 0.85f) {
                    mFairy.onTap(1116, 56, 1143, 77, "", 300);
                    return;
                }

                result = mFairy.findPic("rank1.png");
                mFairy.onTap(0.75f, result, "组队", 1000);

                result = mFairy.findPic("lirank.png");
                mFairy.onTap(0.85f, result, "离开队伍", 1000);

                result = mFairy.findPic("lirank1.png");
                mFairy.onTap(0.85f, result, 713, 429, 745, 446, "确定离开", 1000);

                err++;
            }
        }
    }//离队

    public boolean fuben() throws Exception {
        result = mFairy.findPic(563, 668, 725, 715, "fb1.png");
        if (result.sim > 0.7f) {
            return true;
        }
        return false;
    }//是否在副本

    public Boolean judgeStop(int m) throws Exception {

        long num = mFairy.mMatTime(1218, 32, 53, 11,0.98f);
        //long num = mFairy.dazeTime(1218, 32, 1271, 43, 1f, 0, "212,235,245");
        if (num >= m) {
            return true;
        }
        return false;
    }//发呆判断

    int chat = 0;
    public void judgeChat() throws Exception {
        result = mFairy.findPic("mub1.png");
        if (result.sim > 0.8f) {
            chat = 0;
        } else {
            chat++;
            if (chat > 2) {
                chat = 0;
                mFairy.onTap(1086, 521, 1118, 552, "judgeChat >>>>>", 200);
            }
        }


    }//

    public boolean hong()throws Exception{
        result = mFairy.findPic(new String[]{"hong1.png", "hong2.png","hong3.png","hong4.png"});
        if (result.sim > 0.85f) {
            return true;
        }
        return false;
    }//
}
