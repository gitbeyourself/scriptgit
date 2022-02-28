package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    OtherGame otherGame;
    SingleTask singleTask;
    TeamTask teamTask;

    public LimitlessTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        singleTask = new SingleTask(mFairy);
        teamTask = new TeamTask(mFairy);
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic(895,410,1188,567,"dialogue.png");
        if (result.sim > 0.8f) {
            mFairy.onTap(0.8f, result, 681,685,695,695,"对话中", Sleep);
            mFairy.initMatTime();
        }

    }

    public void fieldHangMachine() throws Exception {
        new LimitlessTask(mFairy) {
            int h = mFairy.dateHour();
            int m = mFairy.dateMinute();
            int img = 0, yhsr = 0, record = 0, lgd = 0 , sum=0;//  入口/练功/记录
            //xzdt 选择地图 totem图腾 zb坐标 ditunum地图NO
            @Override
            public void create() throws Exception {

            }

            public void inOperation() throws Exception {
                super.inOperation();
            }

            public void content_0() throws Exception {

                gameUtil.close(0);

                        img = Integer.parseInt(AtFairyConfig.getOption("dtrk"));
                         LtLog.e(mFairy.getLineInfo("第一个入口=" + img));

                        if (!AtFairyConfig.getOption("jlddt").equals("")){
                            record = Integer.parseInt(AtFairyConfig.getOption("jlddt"));
                        }
                        LtLog.e(mFairy.getLineInfo("哪个记录点=" + record));


                        if (!AtFairyConfig.getOption("lgd").equals("")){
                            lgd = Integer.parseInt(AtFairyConfig.getOption("lgd"));
                            yhsr = Integer.parseInt(AtFairyConfig.getOption("xzdt"+lgd));
                        }
                        LtLog.e(mFairy.getLineInfo("哪个练功点=" + lgd +"第几个地图=" + yhsr));


                Thread.sleep(2000);
                if ((yhsr !=0 && lgd !=0)|| record !=0 ) {
                    setTaskName(1);
                    return;
                }else{
                    setTaskEnd();
                    return;
                }
            }

            public void content_1() throws Exception {
                if (overtime(10, 0)) return;

                result = mFairy.findPic(712,384,1279,717,"sheding.png");

                result1 = mFairy.findPic(168,102,258,151,"cs1.png");
                if (result.sim < 0.8f && result1.sim < 0.8f) {
                    mFairy.onTap(1236,671,1250,685,"打开下扩展栏", 500);
                }

                result = mFairy.findPic(712,384,1279,717,"cs.png");
                result1 = mFairy.findPic(168,102,258,151,"cs1.png");
                mFairy.onTap(0.8f, result, "传送", 500);
                if (result1.sim > 0.8f) {

                    if (img==1) {//记录点
                        result1 = mFairy.findPic(160,163,308,489,"jld.png");
                        if (result1.sim > 0.8f) {
                            mFairy.onTap(0.8f, result1, "记忆点", 1000);
                            if (record >= 5) {
                                mFairy.ranSwipe(700, 500, 700, 300, 500, (long) 1000);
                            } else {
                                mFairy.ranSwipe(700, 300, 700, 500, 500, (long) 1000);
                            }
                            switch (record) {
                                case 1:
                                    mFairy.onTap(1022, 204, 1037, 215, "记忆点1", 10000);
                                    break;
                                case 2:
                                    mFairy.onTap(1018, 279, 1052, 297, "记忆点2", 10000);
                                    break;
                                case 3:
                                    mFairy.onTap(1026, 360, 1047, 379, "记忆点3", 10000);
                                    break;
                                case 4:
                                    mFairy.onTap(1017, 445, 1045, 460, "记忆点4", 10000);
                                    break;
                                case 5:
                                    mFairy.onTap(1016, 526, 1045, 538, "记忆点5", 10000);
                                    break;
                                case 6:
                                    mFairy.onTap(1022, 204, 1037, 215, "记忆点6", 10000);
                                    break;
                                case 7:
                                    mFairy.onTap(1018, 279, 1052, 297, "记忆点7", 10000);
                                    break;
                                case 8:
                                    mFairy.onTap(1026, 360, 1047, 379, "记忆点8", 10000);
                                    break;
                                case 9:
                                    mFairy.onTap(1017, 445, 1045, 460, "记忆点9", 10000);
                                    break;
                                case 10:
                                    mFairy.onTap(1016, 526, 1045, 538, "记忆点10", 10000);
                                    break;
                            }
                            if(result1.sim<0.8f) {
                                setTaskName(3);
                                return;
                            }
                        }
                    }
                    if (img==2) {//练功点
                        result1 = mFairy.findPic(160, 163, 308, 489, "lgq.png");
                        mFairy.onTap(0.8f, result1, "练功区点击", 500);
                        if (result1.sim > 0.8f) {
                            LtLog.e("上滑");
                            mFairy.ranSwipe(235, 500, 235, 300, 500, (long) 1000);

                            result = mFairy.findPic(154,166,305,628, "lgd"+lgd+".png");
                            mFairy.onTap(0.8f, result, "练功点点击", 1000);
                            if (result.sim > 0.8f) {

                                if (yhsr > 5) {
                                    LtLog.e("上滑");
                                    mFairy.ranSwipe(700, 500, 700, 300, 500, (long) 1000);
                                } else {
                                    LtLog.e("下滑");
                                    mFairy.ranSwipe(700, 300, 700, 500, 500, (long) 1000);
                                }
                                switch (yhsr) {
                                    case 1:
                                        mFairy.onTap(1022, 204, 1037, 215, "地图1", 10000);
                                        break;
                                    case 2:
                                        mFairy.onTap(1018, 279, 1052, 297, "地图2", 10000);
                                        break;
                                    case 3:
                                        mFairy.onTap(1026, 360, 1047, 379, "地图3", 10000);
                                        break;
                                    case 4:
                                        mFairy.onTap(1017, 445, 1045, 460, "地图4", 10000);
                                        break;
                                    case 5:
                                        mFairy.onTap(1016, 526, 1045, 538, "地图5", 10000);
                                        break;
                                    case 6:
                                        mFairy.onTap(1022, 397, 1039, 410, "地图6", 10000);
                                        break;
                                    case 7:
                                        mFairy.onTap(1020, 480, 1046, 495, "地图7", 10000);
                                        break;
                                    case 8:
                                        mFairy.onTap(1019, 560, 1051, 569, "地图8", 10000);
                                        break;
                                    case 9:
                                        mFairy.onTap(1017, 445, 1045, 460, "地图9", 10000);
                                        break;
                                    case 10:
                                        mFairy.onTap(1016, 526, 1045, 538, "地图10", 10000);
                                        break;

                                }
                                if(result1.sim > 0.8f) {

                                    setTaskName(3);
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            public void content_3() throws Exception {


                long dazeTime = mFairy.mMatTime(1200, 45, 74, 10, 0.9f);

                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                result = mFairy.findPic(1185,386,1280,645, "Victory or defeat.png");
                if (result.sim > 0.8f) {
                    LtLog.e("战斗中");
                    mFairy.initMatTime();
                }

                result = mFairy.findPic(1163,385,1279,648,"knapsack.png");
                if(result.sim > 0.8f) {
                    result = mFairy.findPic(9,98,271,268,"battle.png");
                    mFairy.onTap(0.8f, result, "自动战斗", 1000);
                }

                if (dazeTime > 5) {
                    gameUtil.close(1);
                    switch (lgd) {
                        case 1:
                            if (yhsr > 0) {
                                result = mFairy.findPic(1053, 2, 1279, 44, "xzdt" + yhsr + ".png");
                                if (result.sim > 0.8f) {
                                    LtLog.e("到达目的地！");
                                    switch (yhsr) {
                                        case 1:
                                            mFairy.ranSwipe(132, 331, 170, 390, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 2:
                                            mFairy.ranSwipe(173, 350, 117, 290, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 3:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 4:
                                            mFairy.ranSwipe(150, 327, 82, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 5:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 6:
                                            mFairy.ranSwipe(168, 384, 229, 346, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 7:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 8:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;

                                    }

                                    mFairy.onTap(162, 127, 170, 142, "开启自动御敌", 1000);
                                    mFairy.initMatTime();
                                } else {
                                    sum++;
                                }
                                if (sum >= 5) {
                                    mFairy.initMatTime();
                                    sum = 0;
                                    setTaskName(1);
                                    return;
                                }
                            }
                            break;
                        case 2:
                            if (yhsr > 0) {
                                result = mFairy.findPic(1053, 2, 1279, 44, "xzdt2" + yhsr + ".png");
                                if (result.sim > 0.8f) {
                                    LtLog.e("到达目的地！");
                                    switch (yhsr) {
                                        case 1:
                                            mFairy.ranSwipe(132, 331, 170, 390, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 2:
                                            mFairy.ranSwipe(173, 350, 117, 290, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 3:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 4:
                                            mFairy.ranSwipe(150, 327, 82, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 5:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 6:
                                            mFairy.ranSwipe(168, 384, 229, 346, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 7:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 8:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;

                                    }

                                    mFairy.onTap(162, 127, 170, 142, "开启自动御敌", 1000);
                                    mFairy.initMatTime();
                                } else {
                                    sum++;
                                }
                                if (sum >= 5) {
                                    mFairy.initMatTime();
                                    sum = 0;
                                    setTaskName(1);
                                    return;
                                }
                            }
                            break;
                        case 3:
                            if (yhsr > 0) {
                                result = mFairy.findPic(1053, 2, 1279, 44, "xzdt3" + yhsr + ".png");
                                if (result.sim > 0.8f) {
                                    LtLog.e("到达目的地！");
                                    switch (yhsr) {
                                        case 1:
                                            mFairy.ranSwipe(132, 331, 170, 390, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 2:
                                            mFairy.ranSwipe(173, 350, 117, 290, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 3:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 4:
                                            mFairy.ranSwipe(150, 327, 82, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 5:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 6:
                                            mFairy.ranSwipe(168, 384, 229, 346, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 7:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 8:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;

                                    }

                                    mFairy.onTap(162, 127, 170, 142, "开启自动御敌", 1000);
                                    mFairy.initMatTime();
                                } else {
                                    sum++;
                                }
                                if (sum >= 5) {
                                    mFairy.initMatTime();
                                    sum = 0;
                                    setTaskName(1);
                                    return;
                                }
                            }
                            break;
                        case 4:
                            if (yhsr > 0) {
                                result = mFairy.findPic(1053, 2, 1279, 44, "xzdt4" + yhsr + ".png");
                                if (result.sim > 0.8f) {
                                    LtLog.e("到达目的地！");
                                    switch (yhsr) {
                                        case 1:
                                            mFairy.ranSwipe(132, 331, 170, 390, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 2:
                                            mFairy.ranSwipe(173, 350, 117, 290, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 3:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 4:
                                            mFairy.ranSwipe(150, 327, 82, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 5:
                                            mFairy.ranSwipe(200, 201, 150, 404, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 6:
                                            mFairy.ranSwipe(168, 384, 229, 346, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 7:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;
                                        case 8:
                                            mFairy.ranSwipe(187, 360, 136, 309, 1500, (long) 3000);
                                            LtLog.e("走一下！");
                                            break;

                                    }

                                    mFairy.onTap(162, 127, 170, 142, "开启自动御敌", 1000);
                                    mFairy.initMatTime();
                                } else {
                                    sum++;
                                }
                                if (sum >= 5) {
                                    mFairy.initMatTime();
                                    sum = 0;
                                    setTaskName(1);
                                    return;
                                }
                            }
                            break;

                    }
                    if (img == 1) {
                        mFairy.onTap(162, 127, 170, 142, "开启自动御敌", 1000);
                        mFairy.initMatTime();
                    }
                }
                }

        }.taskContent(mFairy, "定点挂机中");
    }//定点挂机


}
