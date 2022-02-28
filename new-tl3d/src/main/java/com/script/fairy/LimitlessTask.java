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

    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        singleTask = new SingleTask(mFairy);
        teamTask = new TeamTask(mFairy);
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("guotu.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            err = 0;
        }
       /* for (int i = 0; i < 1; i++) {
            result = mFairy.findPic("Dialogbox.png");
            mFairy.onTap(0.8f, result, result.x, result.y + 50, result.x + 1, result.y + 51, "对话框", Sleep);
            if (result.sim > 0.8f) {
                err = 0;
                i = 0;
            }
        }*/
        result = mFairy.findPic( "submit.png");
        mFairy.onTap(0.8f, result,  "提交任务", 200);

        result = mFairy.findPic( "jiequ.png");
        mFairy.onTap(0.8f, result,  "接取任务", 200);

        result = mFairy.findPic("death.png");
        if (result.sim > 0.8f) {
            err = 0;
        }
    }

    //定点挂机
    public void fixedPoint() throws Exception {
        new LimitlessTask(mFairy) {
            int ditu = 0, gw = 0;
            String str;
            ControlSplit optime1 = null, optime2 = null, optime3 = null;

            @Override
            public void create() throws Exception {

                if(!AtFairyConfig.getOption("gw").equals("")){
                    gw = Integer.parseInt(AtFairyConfig.getOption("gw"));
                    if (gw != 1) {
                        str = gameUtil.map(gw, 10);
                    }
                }

                if (!AtFairyConfig.getOption("optime1").equals("")) {
                    optime1 = strSplit(AtFairyConfig.getOption("optime1"));
                }
                if (!AtFairyConfig.getOption("optime2").equals("")) {
                    optime2 = strSplit(AtFairyConfig.getOption("optime2"));
                }

                if (!AtFairyConfig.getOption("optime3").equals("")) {
                    optime3 = strSplit(AtFairyConfig.getOption("optime3"));
                }

                timingActivity.timingActivity();
            }

            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("death.png");
                if (result.sim > 0.8f) {
                    setTaskName(0);
                    return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.close(0);
                if (gw == 1) {
                    setTaskName(5);
                    return;
                }
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    for (int i = 1; i < 25; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(97,12,395,152,"dt" + i + ".png");
                        LtLog.e(mFairy.getLineInfo(0.85f, result, "dt" + i + ".png"));
                        if (result.sim > 0.85f) {
                            ditu = i;
                            break;
                        }
                    }
                    if (ditu == (gw / 10) || (ditu > 20 && (gw / 10) > 20 && ditu <= 23)) {
                        LtLog.e(mFairy.getLineInfo("在同一个地图，直接去怪物地点"));
                        setTaskName(4);
                        return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("不在同一个地图，开启传送机制"));
                        gameUtil.close(0);
                        setTaskName(2);
                        return;
                    }
                }

            }

            public void content_2() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png", "dt.png"});
                mFairy.onTap(0.8f, result, "挂机中取消", Sleep);

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                mFairy.onTap(0.8f, result, "地图界面", Sleep);

                result = mFairy.findPic("Mapworld.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    gameUtil.tapMap(gw, 10);
                    Thread.sleep(5000);
                    mFairy.condit();
                    result = mFairy.findPic("OverGraph.png");
                    mFairy.onTap(0.8f, result, 351,263,913,399, "过图提醒", 500);

                    result = mFairy.findPic(373, 271, 907, 392, "Delivery.png");
                    mFairy.onTap(0.8f, result, 538, 454, 537, 455, "传送确定", 500);

                    if (result.sim > 0.8f) {
                        setTaskName(3);
                        return;
                    } else {
                        setTaskName(0);
                        return;
                    }
                }
            }

            public void content_3() throws Exception {
                if (overtime(6, 0)) return;

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    for (int i = 1; i < 25; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(97,12,395,152,"dt" + i + ".png");
                        LtLog.e(mFairy.getLineInfo(0.85f, result, "dt" + i + ".png"));
                        if (result.sim > 0.85f) {
                            ditu = i;
                            break;
                        }
                    }
                    if (ditu == (gw / 10) || (ditu > 20 && (gw / 10) > 20 && ditu <= 23)) {
                        LtLog.e(mFairy.getLineInfo("在同一个地图，直接去怪物地点"));
                        setTaskName(4);
                        return;
                    } else {
                        for (int i = 0; i < 5; i++) {
                            mFairy.condit();
                            LtLog.e(mFairy.getLineInfo("还不在同一个地图，去上个地图的安全区吧"));
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            mFairy.onTap(0.8f, result, 1085, 195, 1086, 196, "地图界面", 2000);

                            result = mFairy.findPic(688,2,1274,173,"jj3.png");
                            mFairy.onTap(0.8f, result, "收起", Sleep);

                            result = mFairy.findPic("jj2.png");
                            mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            LtLog.e(mFairy.getLineInfo(0.9f, result, "地图界面"));
                            if (result.sim < 0.9f) {
                                break;
                            }
                            Thread.sleep(2000);
                        }

                        setTaskName(2);
                        return;
                    }
                }

            }

            public void content_4() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                mFairy.onTap(0.8f, result, "挂机中取消", Sleep);


                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    if ((ditu > (gw / 10)) && (ditu > 20 && (gw / 10) > 20 && ditu <= 23)) {
                        for (int i = 0; i < 5; i++) {
                            mFairy.condit();
                            LtLog.e(mFairy.getLineInfo("还不在同一个地图，去上个地图的安全区吧"));
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            mFairy.onTap(0.8f, result, 1085, 195, 1086, 196, "上个地图", 2000);

                            result = mFairy.findPic(688,2,1274,173,"jj3.png");
                            mFairy.onTap(0.8f, result, "收起", Sleep);

                            result = mFairy.findPic("jj2.png");
                            mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);


                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            LtLog.e(mFairy.getLineInfo(0.9f, result, "地图界面"));
                            if (result.sim < 0.9f) {
                                break;
                            }
                            Thread.sleep(2000);
                        }
                        setTaskName(1);
                        return;
                    }
                    if ((ditu < (gw / 10)) && (ditu > 20 && (gw / 10) > 20 && ditu <= 23)) {
                        for (int i = 0; i < 5; i++) {
                            mFairy.condit();
                            LtLog.e(mFairy.getLineInfo("还不在同一个地图，去上个地图的安全区吧"));
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            mFairy.onTap(0.8f, result, 1085, 250, 1086, 251, "上个地图", 2000);

                            result = mFairy.findPic(688,2,1274,173,"jj3.png");
                            mFairy.onTap(0.8f, result, "收起", Sleep);

                            result = mFairy.findPic("jj2.png");
                            mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            LtLog.e(mFairy.getLineInfo(0.9f, result, "地图界面"));
                            if (result.sim < 0.9f) {
                                break;
                            }
                            Thread.sleep(2000);
                        }
                        setTaskName(1);
                        return;
                    }
                    if (ditu == (gw / 10)) {
                        gameUtil.monster(gw, 10);
                        Thread.sleep(15000);
                        gameUtil.close(0);
                        setTaskName(5);
                        return;
                    }
                }
            }

            public void content_5() throws Exception {
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result,  "场景挂机", Sleep);

                if (optime1 != null && optime1.choice == 1 && timekeep(0, optime1.timeMillis, "野外挂机清包")) {
                    gameUtil.clearbag();
                }
                if (optime2 != null && optime2.choice == 1 && timekeep(0, optime2.timeMillis, "野外挂机领奖酒楼伙伴等")) {
                    if (AtFairyConfig.getOption("lingjing").equals("1")) {
                        gameUtil.prize();
                    }
                    if (AtFairyConfig.getOption("lingjing1").equals("1")) {
                        gameUtil.prize1();
                        gameUtil.prize4();
                    }
                    if (AtFairyConfig.getOption("lingjing2").equals("1")) {
                        gameUtil.prize2();
                    }
                    gameUtil.close(0);
                }
                if (optime3 != null && optime3.choice == 1 && timekeep(0, optime3.timeMillis, "野外挂机重新定位")) {
                    setTaskName(0);
                    return;
                }
                if (timingActivity.timingActivity() == 1) {
                    setTaskName(0);
                    return;
                }
            }
        }.taskContent(mFairy, "定点挂机中");
    }

    //无限匪首
    public void banditHead() throws Exception {
        new LimitlessTask(mFairy) {
            String str;
            ControlSplit optime1 = null, optime2 = null, optime3 = null;
            int fsrw = 0;

            @Override
            public void create() throws Exception {
                str = gameUtil.map(17, 1);
                if (!AtFairyConfig.getOption("fsrw").equals("")) {
                    fsrw = Integer.parseInt(AtFairyConfig.getOption("fsrw"));
                }else{
                    fsrw=2;
                }
                if (!AtFairyConfig.getOption("optime1").equals("")) {
                    optime1 = strSplit(AtFairyConfig.getOption("optime1"));
                }
                if (!AtFairyConfig.getOption("optime2").equals("")) {
                    optime2 = strSplit(AtFairyConfig.getOption("optime2"));
                }

                if (!AtFairyConfig.getOption("optime3").equals("")) {
                    optime3 = strSplit(AtFairyConfig.getOption("optime3"));
                }

                timingActivity.timingActivity();
            }

            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("death.png");
                if (result.sim > 0.8f) {
                    setTaskName(0);
                    return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.backCity(17, 1);//星宿草海
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 2)) {
                    gameUtil.close(0);
                    return;
                }
                result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                mFairy.onTap(0.8f, result, "挂机中取消", Sleep);

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                mFairy.onTap(0.8f, result, 1002, 309, 1003, 310, "范公", 10000);
                mFairy.onTap(0.8f, result, 1002, 309, 1003, 310, "范公", 10000);
            }

            public void content_2() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                mFairy.onTap(0.8f, result, "挂机中取消", 5000);

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("feishou").equals("1")) {
                        mFairy.tap(625, 276);
                    } else if (AtFairyConfig.getOption("feishou").equals("2")) {
                        mFairy.tap(275, 273);
                    } else if (AtFairyConfig.getOption("feishou").equals("3")) {
                        mFairy.tap(285, 436);
                    }
                    Thread.sleep(8000);
                    gameUtil.close(0);
                    setTaskName(3);
                    return;
                }
            }

            int hdcount = 0;


            public void content_3() throws Exception {
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result,  "场景挂机", Sleep);

                if (overtime(7, 0)) {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.8f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    setTaskEnd();
                    return;
                }
                if (fsrw == 1 || fsrw == 3) {
                    err = 0;
                }
                result = mFairy.findPic(41,206,264,515, new String[]{"Leftbandit.png", "Leftbandit1.png", "Leftbandit2.png"});
                if (result.sim > 0.75f) {
                    err=0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(41,206,264,515, new String[]{"Leftbandit.png", "Leftbandit1.png", "Leftbandit2.png"});
                    mFairy.onTap(0.75f,result,"左侧匪首",1000);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.8f) {
                        hdcount++;
                        if (hdcount >= 2) {
                            LtLog.e(mFairy.getLineInfo("滑动左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(47, 468, 66, 310, 500, (long) 1000, 2);
                            hdcount = 0;
                        }
                    }
                }
                result = mFairy.findPic(41,206,264,515, new String[]{"Leftbandit1.png"});
                if (result.sim > 0.75f) {
                    setTaskName(0);
                    return;
                }

                if (optime1 != null && optime1.choice == 1 && timekeep(0, optime1.timeMillis, "野外挂机清包")) {
                    gameUtil.clearbag();
                }
                if (optime2 != null && optime2.choice == 1 && timekeep(0, optime2.timeMillis, "野外挂机领奖酒楼伙伴等")) {
                    if (AtFairyConfig.getOption("lingjing").equals("1")) {
                        gameUtil.prize();
                    }
                    if (AtFairyConfig.getOption("lingjing1").equals("1")) {
                        gameUtil.prize1();
                        gameUtil.prize4();
                    }
                    if (AtFairyConfig.getOption("lingjing2").equals("1")) {
                        gameUtil.prize2();
                    }
                    gameUtil.close(0);
                }
                if (optime3 != null && optime3.choice == 1 && timekeep(0, optime3.timeMillis, "野外挂机重新定位")) {
                    setTaskName(0);
                    return;
                }
                if (timingActivity.timingActivity() == 1) {
                    setTaskName(0);
                    return;
                }
                if (mFairy.dateHour() == 0 && fsrw == 3) {
                    LtLog.e(mFairy.getLineInfo("0点停"));
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "无限匪首中");
    }

    //玄武岛
    public void xwd() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.backCity(24, 1);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                mFairy.onTap(0.8f, result, "挂机中取消", Sleep);

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);


                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                mFairy.onTap(0.8f, result, 1005, 310, 1006, 311, "墨问道", 7000);
                mFairy.onTap(0.8f, result, 1005, 310, 1006, 311, "墨问道", 7000);
                if (result.sim > 0.8f) {
                    gameUtil.close(0);
                    setTaskEnd();
                    return;
                }

            }

        }.taskContent(mFairy, "玄武岛中");
    }


}
