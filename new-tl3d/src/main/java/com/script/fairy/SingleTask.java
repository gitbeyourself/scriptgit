package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    FindResult result4;
    FindResult result5;
    FindResult result6;
    GameUtil gameUtil;

    long time = System.currentTimeMillis();
    int nn_err = 0;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        judge_end = 0;
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic( "guotu.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            err = 0;
        }
        for (int i = 0; i < 1; i++) {
            result = mFairy.findPic("Dialogbox2.png" );//"Dialogbox.png"
            mFairy.onTap(0.8f, result, result.x, result.y + 50, result.x + 1, result.y + 51, "对话框", Sleep);
            if (result.sim > 0.8f) {
                err = 0;
                i = 0;
            }
        }

        result = mFairy.findPic( "submit.png");
        mFairy.onTap(0.8f, result,  "提交任务", 200);

        result = mFairy.findPic( "jiequ.png");
        mFairy.onTap(0.8f, result,  "接取任务", 200);

        result = mFairy.findPic( "death.png");
        if (result.sim > 0.8f) {
            err = 0;
        }
        result = mFairy.findPic( "death2.png");
        mFairy.onTap(0.8f, result,  "新手复活", 200);

        result = mFairy.findPic( "death.png");
        mFairy.onTap(0.8f, result,  "入口复活", 200);
    }

    //新手引导
    public void novice() throws Exception {
        new SingleTask(mFairy) {

            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "error进入副本确定", Sleep);
            }


            public void content_0() throws Exception {
                gameUtil.setUp();
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(7, 1)) {
                    gameUtil.close(0);
                }

                if (timekeep(1, 300000, "新手引导清包")) {
                    gameUtil.clearbag();
                }

                if (AtFairyConfig.getOption("20t").equals("1")) {
                    result = mFairy.findPic( "20stop.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("20级停"));
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic(789, 462, 1276, 715, new String[]{"Entergame.png", "Entergame1.png", "Entergame2.png"});
                mFairy.onTap(0.8f, result, "err角色登录界面", Sleep);

                result = mFairy.findPic( "namesure.png");
                mFairy.onTap(0.8f, result, 645, 452, 646, 453, "名字重复", Sleep);

                result = mFairy.findPic( "package1.png");
                mFairy.onTap(0.8f, result, 1052,632,1098,650, "药店", 1000);

                result = mFairy.findPic(757,150,997,376, "package2.png");
                mFairy.onTap(0.8f, result, "批量购买", 1000);

                result = mFairy.findPic(507,201,751,326, "package3.png");
                if(result.sim>0.8f) {
                    err=0;
                    for(int i =0;i<3;i++){
                        mFairy.onTap(742,351,760,364,"",500);
                    }
                    mFairy.onTap(510,440,548,454, "确定购买", 1000);
                }

                result = mFairy.findPic("nn1.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("镶嵌宝石界面"));
                    mFairy.onTap(167,253,196,276,"",1000);
                    mFairy.onTap(622,195,645,219,"",500);
                    mFairy.onTap(658,377,676,393,"",500);
                    mFairy.onTap(840,614,887,631,"",500);
                    gameUtil.close(0);
                }

                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本中"));

                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);
                }

                result = mFairy.findPic( "xsPartner.png");
                mFairy.onTap(0.8f, result, 65, 48, 66, 49, "新手伙伴", Sleep);

                result = mFairy.findPic( "xsStop.png");
                if (result.sim > 0.95f) {
                    LtLog.e(mFairy.getLineInfo("主线停"));
                    setTaskEnd();
                }

                //result = mFairy.findPic( "jj1.png");
                result = mFairy.findPic( "ai1.png");
                mFairy.onTap(0.85f, result, 46, 248, 47, 249, "左侧组队栏打开了切换回去", Sleep);

                result = mFairy.findPic( 869,410,1190,650,"Dothisdish.png");
                mFairy.onTap(0.8f, result, "制作这道菜", Sleep);

                for (int i = 0; i < 10; i++) {
                    result = mFairy.findPic(0, 0, 1279, 719, "Guidehand1.png");
                    LtLog.e(mFairy.getLineInfo("指引黄框："+result.sim));
                    mFairy.onTap(0.83f, result, result.x + 30, result.y - 20, result.x + 31, result.y - 19, "指引黄框", Sleep);
                    if (result.sim < 0.83f) {
                        break;
                    }
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));

                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(956, 128, 1133, 627, "jia8.png");
                        mFairy.onTap(0.8f, result, "完成", 500);
                    }


                    result = mFairy.findPic(948, 171, 1139, 599, "rcGiveUp.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("接到门派任务"));
                        gameUtil.close(0);
                    }
                }

                result = mFairy.findPic(54,303,252,505, new String[]{"jia12.png","Factions.png",  "Factions2.png", "Leftmenpai1.png", "Leftmenpai2.png","mp1.png"});
                //result = mFairy.findPic(51,306,267,469,  "Leftmenpai2.png");//"jia12.png","Factions.png",  "Factions2.png", "Leftmenpai1.png",,"mp1.png"
                LtLog.e(mFairy.getLineInfo("左侧门派 sim："+result.sim));
                mFairy.onTap(0.7f, result, "左侧门派", Sleep);
                if (result.sim > 0.7f) {
                    for (int i = 0; i < 30; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(54,303,252,505, new String[]{"jia12.png","Factions.png",  "Factions2.png", "Leftmenpai1.png", "Leftmenpai2.png","mp1.png"});
                        mFairy.onTap(0.7f, result, "左侧门派", Sleep);

                        result = mFairy.findPic(909, 173, 1146, 598, "rcComplete.png");
                        mFairy.onTap(0.8f, result, "日常完成", Sleep);
                        if (result.sim > 0.8f) {
                            gameUtil.close(0);
                            break;
                        }
                        Thread.sleep(2000);
                    }
                }else{
                    result = mFairy.findPic(39,223,268,471, new String[]{"leftMain.png", "leftMain1.png", "leftMain2.png", "leftMain3.png", "leftMain4.png"});
                    mFairy.onTap(0.7f, result, "左侧主线", Sleep);
                    if (result.sim > 0.7f) {
                        err = 0;
                        nn_err++;
                        if(nn_err>10){
                            nn_err=0;
                            mFairy.ranSwipe(143,570,366,447,500,1000);

                            result = mFairy.findPic(841,50,1261,213, "nn2.png");
                            mFairy.onTap(0.8f, result, "关闭挂机按钮", 3000);
                        }
                    }
                }
            }

        }.taskContent(mFairy, "新手引导");
    }

    //新手引导1
    public void novice1() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }



            @Override
            public void content_1() throws Exception {
                if (overtime(40, 99)) {
                    LtLog.e(mFairy.getLineInfo("支线结束"));
                    gameUtil.backCity(1, 1);//回苏州

                    result = mFairy.findPic(688,2,1274,173,"jj3.png");
                    mFairy.onTap(0.8f, result, "收起", Sleep);

                    result = mFairy.findPic("jj2.png");
                    mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                    result = mFairy.findPic(108, 546, 366, 703, "mapInterface.png");
                    mFairy.onTap(0.8f, result, 500, 360, 501, 361, "地图界面", 5000);
                    gameUtil.close(0);
                    return;
                }
                if (err == 10 || err == 20 || err == 30) {
                    gameUtil.close(0);
                }
                result = mFairy.findPic(46,230,158,469, "leftFeeder.png");
                mFairy.onTap(0.7f, result, "左侧支线", Sleep);
                if (result.sim > 0.7f) {
                    err = 0;
                }
                /*result = mFairy.findPic( "Leftteam.png");
                mFairy.onTap(0.95f, result, 46, 248, 47, 249, "左侧组队栏打开了切换回去", Sleep);*/

            }

        }.taskContent(mFairy, "支线结束");
    }

    private int judge_end = 0;

    //满活跃
    public void mhy() throws Exception {
        new SingleTask(mFairy) {
            int fqbj = 0;
            int fqcount = 0;

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }




            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                /*result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);*/

                result = mFairy.findPic(784,55,1139,222, "act.png");
                mFairy.onTap(0.8f, result,  "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {

                    if(fqbj==1 && fqcount >= 3){
                        LtLog.e("结束");
                        cactivity();
                        setTaskEnd();
                        return;
                    }


                    result3 = mFairy.findPic(416,123,1147,249, "mrl.png");
                    result2 = mFairy.findPic(416,123,1147,249, "fb2.png");
                    result1 = mFairy.findPic(416,123,1147,249, "qw.png");
                    result4 = mFairy.findPic(416,123,1147,249, "meiren.png");
                    result5 = mFairy.findPic(414,122,1144,230, "xingyun.png");
                    result6 = mFairy.findPic(416,123,1147,249, "dati.png");

                    if (result1.sim > 0.8f ) {
                        if (result2.sim > 0.8f || result3.sim > 0.8f) {

                            mFairy.onTap(0.8f, result1, "日常副本前往", 3000);
                            result = mFairy.findPic(688,216,942,349,"Luckdrawone.png");
                            if(result.sim>0.8f){
                                setTaskName(5);
                                return;
                            }else {
                                result3 = mFairy.findPic(936, 551, 1132, 639, "tz.png");
                                mFairy.onTap(0.8f, result3, "挑战", Sleep);
                                setTaskName(2);
                                return;
                            }
                        }else if(result4.sim > 0.8f){
                            mFairy.onTap(0.8f, result1, "日常副本前往", 500);
                            setTaskName(4);return;
                        }else if(result5.sim > 0.8f){
                            mFairy.onTap(0.8f, result1, "日常副本前往", 2000);
                            setTaskName(5);return;
                        }else if(result6.sim > 0.8f){
                            mFairy.onTap(0.8f, result1, "日常副本前往", 500);
                            setTaskName(6);return;
                        }else{
                            mFairy.onTap(0.8f, result1, "日常副本前往", 3000);



                            result1 = mFairy.findPic(435,25,863,197, "bnqw.png");
                            if (result1.sim > 0.8f) {
                                LtLog.e("等级不足！");
                                mFairy.ranSwipe(510, 440, 510, 350, 500, (long) 1000, 2);
                                fqbj=1;
                                setTaskName(1);
                                return;
                            }

                            result1 = mFairy.findPic(416,123,1147,249,  "tl.png");
                            if (result1.sim > 0.8f) {
                                LtLog.e("跳过童姥！");
                                mFairy.ranSwipe(510, 440, 510, 350, 500, (long) 1000, 2);
                                setTaskName(1);
                                return;
                            }

                            result = mFairy.findPic(688,216,942,349,"Luckdrawone.png");
                            if(result.sim>0.8f){
                                setTaskName(5);
                                return;
                            }
                            result = mFairy.findPic(417,179,647,324, "sycs.png");
                            if(result.sim>0.8f) {
                                result = mFairy.findPic(420,226,643,268, "ling.png");
                                if(result.sim>0.8f) {

                                }else{
                                    mFairy.onTap(0.8f, result1, "日常副本前往", 500);
                                    result3 = mFairy.findPic(936,551,1132,639, "tz.png");
                                    mFairy.onTap(0.8f, result3,  "挑战", Sleep);
                                    setTaskName(2);
                                    return;
                                }
                                mFairy.onTap(0.8f, result, 237,184,258,197,"每日活跃", Sleep);
                                mFairy.ranSwipe(510, 440, 510, 320, 500, (long) 1000, 2);
                                setTaskName(1);
                                return;
                            }else {
                                gameUtil.close(0);
                                setTaskName(3);
                                return;
                            }
                        }
                    }else {
                        result6 = mFairy.findPic(416,123,1147,249, "yiwancheng.png");
                        if (result.sim > 0.8f) {
                            LtLog.e("结束");
                            cactivity();
                            setTaskEnd();
                            return;
                        }
                        mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 0, 510, 440, 510, 335, 1000, 1500, 2);
                    }
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));

                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 24,269,31,277, "err切换到任务栏", 2000);

                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(420,226,643,268, "ling.png");
                if(result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, 237,184,258,197,"每日活跃", Sleep);
                    mFairy.ranSwipe(510, 440, 510, 320, 500, (long) 1000, 2);
                    setTaskName(1);
                    return;
                }else {
                    result = mFairy.findPic(new String[]{"fbGetinto.png", "jia2.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("进入副本"));
                        mFairy.onTap(0.8f, result, "进入副本", 5000);

                        result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            Thread.sleep(5000);
                        } else {
                            Thread.sleep(5000);
                        }

                    }

                    result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                    if (result.sim > 0.8f) {
                        err = 0;
                        mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                    }
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        err = 0;
                        LtLog.e(mFairy.getLineInfo("副本中"));
                        if (timekeep(1, 300000, "游戏bug取消挂机")) {
                            result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                            mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                        }
                        result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                        mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                        result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                        mFairy.onTap(0.8f, result, "场景挂机", Sleep);

                        result = mFairy.findPic(884, 53, 1172, 232, "8cfb.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, "8次副本完成", 3000);

                            result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                            mFairy.onTap(0.8f, result, "离开副本", 1500);
                            mFairy.onTap(514, 439, 561, 460, "", 3500);
                        }
                    }

                    result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                    mFairy.onTap(0.8f, result, "副本完成", Sleep);
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, "离开副本", 1500);
                            mFairy.onTap(514, 439, 561, 460, "", 3500);
                        }
                    }

                    result = mFairy.findPic("fbwl.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("副本完成"));
                        setTaskName(1);
                        return;
                    }

                    result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("活动界面"));

                        result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                        mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);

                        result = mFairy.findPic(388, 294, 899, 400, "jrts.png");
                        mFairy.onTap(0.8f, result, 508, 435, 570, 461, "进入提示", Sleep);

                        if (result.sim < 0.8f) {

                            result = mFairy.findPic(new String[]{"fbGetinto.png", "jia2.png"});
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("进入副本"));
                                fubennd();
                                mFairy.onTap(0.8f, result, "进入副本", 5000);

                                result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                                if (result.sim > 0.8f) {
                                    mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                                } else {
                                    Thread.sleep(5000);
                                }

                            }

                            result = mFairy.findPic(new String[]{"fbGetinto.png", "jia2.png"});
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                                fqbj = 1;
                                setTaskName(1);
                                return;
                            }
                        }
                    }
                    result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                    if (result.sim > 0.8f) {

                        mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                        mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);


                        LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                        fqbj = 1;
                        setTaskName(1);
                        return;
                    }


                    result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                    mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                    mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                        fqbj = 1;
                        setTaskName(1);
                        return;
                    }
                }

            }

            public void content_3() throws Exception{
                if (overtime(10, 0)) return;
                result = mFairy.findPic(679,3,1276,285, "shkzl.png");
                mFairy.onTap(0.8f, result,  "收回扩展栏", 1000);

                result = mFairy.findPic(679,3,1276,285, "dakzl.png");
                mFairy.onTap(0.8f, result, 1197, 86, 1204, 97, "打开地图", Sleep);

                result = mFairy.findPic(124,589,359,679, "sjdt.png");
                if(result.sim > 0.8f) {
                     long dazeTime = mFairy.mMatTime(1022, 605, 110, 35, 0.95f);
                     LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                    if(dazeTime>10){
                        gameUtil.close(0);
                        result = mFairy.findPic(749,12,1274,262, "gj1.png");
                        mFairy.onTap(0.8f,result,1061,120,1075,143,"自动战斗", 1000);

                        result = mFairy.findPic(749,12,1274,262, "cjgj.png");
                        mFairy.onTap(0.8f,result,"场景挂机", 20000);
                        mFairy.initMatTime();

                        setTaskName(1);
                        return;
                    }
                }
            }

            public void content_4() throws Exception{
                result = mFairy.findPic("Beautyinterface.png");
                mFairy.onTap(0.8f, result, 319, 368,320, 369,"美人界面", Sleep);
                if (result.sim > 0.8f) {
                    for (int i= 0; i < 6; i++) {
                        mFairy.onTap(803, 600, 804, 601, "亲密", Sleep);
                    }
                    mFairy.onTap(742, 452,743, 453,"亲密", Sleep);
                    mFairy.onTap(1129,52,1149,70,"",1000);
                    fqcount+=1;
                    setTaskName(1);return;
                }
            }

            public void content_5() throws Exception{
                if (overtime(7, 0)) {

                }

                result = mFairy.findPic(749,583,981,697, "qd.png");
                mFairy.onTap(0.8f, result,  "qd", 1000);
                    result = mFairy.findPic(688,216,942,349,"Luckdrawone.png");
                    if(result.sim >0.8f) {

                        mFairy.onTap(0.8f, result, "抽奖一次", Sleep);
                        mFairy.onTap(1129, 52, 1149, 70, "", 2000);

                        result = mFairy.findPic(749,583,981,697, "qd.png");
                        mFairy.onTap(0.8f, result,  "qd", 1000);
                        fqcount+=1;
                        setTaskName(1);
                        return;

                    }
            }

            public void content_6() throws Exception{
                result = mFairy.findPic(625,571,880,673,"kaishiky.png");
                mFairy.onTap(0.8f, result, "开始答题", Sleep);

                result = mFairy.findPic(398,269,749,433,"xuanze.png");
                mFairy.onTap(0.8f, result,567,402,575,413, "默认A", Sleep);

                result = mFairy.findPic(409,181,1137,536,"jifen.png");
                if (result.sim > 0.8f){
                    LtLog.e("答题结束");
                    fqcount+=1;
                     setTaskName(1);return;

                }

            }
        }.taskContent(mFairy, "满活跃");
    }

    public void fbrc111() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0;
            int fqcount = 0;

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                /*result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);*/

                result = mFairy.findPic(784,55,1139,222, "act.png");
                mFairy.onTap(0.8f, result,  "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd() > 170 || hyd1() >= 8) {
                        judge_end++;
                        if (judge_end > 1) {
                            LtLog.e(mFairy.getLineInfo("8次副本任务完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    } else {
                        judge_end = 0;
                    }
                    result1 = mFairy.findPic(393,109,1156,493, "Replicatask1.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("副本日常"));
                        result = mFairy.findPic(result1.x + 246, result1.y + 60, result1.x + 438, result1.y + 110, "fuben12.png");
                        if (result.sim > 0.9f) {
                            err = 0;
                            LtLog.e(mFairy.getLineInfo("活跃12"));
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                fqcount = 0;
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f && fqbj == 0) {
                                mFairy.onTap(0.8f, result1, "已接任务去做", Sleep);
                                setTaskName(2);
                                return;
                            } else if (result.sim > 0.8f && fqbj == 1) {
                                fqbj = 0;
                                mFairy.onTap(0.8f, result, "放弃任务", Sleep);
                                fqcount++;
                                if (fqcount > 9) {
                                    LtLog.e(mFairy.getLineInfo("放弃太多次了结束"));
                                }
                            }
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("8次副本任务完成"));
                                setTaskEnd();
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常前往", Sleep);
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5,6,7}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));

                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 24,269,31,277, "err切换到任务栏", 2000);

                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                if (result.sim > 0.75f) {
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                    mFairy.onTap(0.75f, result, "左侧副本", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
                        hdcount++;
                        if (hdcount >= 2) {
                            LtLog.e(mFairy.getLineInfo("滑动左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 24,269,31,277, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(90, 468, 90, 310, 500, (long) 1000, 2);
                            hdcount = 0;
                        }
                    }
                }


                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }
                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    if (timekeep(1, 300000, "游戏bug取消挂机")) {
                        result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                        mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                    }
                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);

                    result = mFairy.findPic(884, 53, 1172, 232, "8cfb.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "8次副本完成", 3000);

                        result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                }

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));

                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);

                    result = mFairy.findPic(388,294,899,400, "jrts.png");
                    mFairy.onTap(0.8f, result,508,435,570,461, "进入提示", Sleep);

                    if (result.sim < 0.8f) {

                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 5000);

                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(5000);
                            }

                        }

                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                            fqbj = 1;
                            setTaskName(1);
                            return;
                        }
                    }
                }
                result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                if (result.sim > 0.8f) {

                    mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                    mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);


                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }


                result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }

            }
        }.taskContent(mFairy, "8次副本");
    }

    //副本日常//4次副本的
    public void fbrc2() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0;
            int fqcount = 0;

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;

                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {

                    if (hyd1() >= 4) {
                        LtLog.e(mFairy.getLineInfo("4次副本任务完成"));
                        setTaskEnd();
                        return;
                    }

                    result1 = mFairy.findPic(393, 156, 1149, 608, "Replicatask.png");
                    if (result1.sim > 0.8f) {

                        LtLog.e(mFairy.getLineInfo("副本日常"));
                        result = mFairy.findPic(result1.x + 246, result1.y + 60, result1.x + 438, result1.y + 110, "fuben12.png");
                        if (result.sim > 0.9f) {
                            err = 0;
                            LtLog.e(mFairy.getLineInfo("活跃12"));
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                fqcount = 0;
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f && fqbj == 0) {
                                mFairy.onTap(0.8f, result1, "已接任务去做", Sleep);
                                setTaskName(2);
                                return;
                            } else if (result.sim > 0.8f && fqbj == 1) {
                                fqbj = 0;
                                mFairy.onTap(0.8f, result, "放弃任务", Sleep);
                                fqcount++;
                                if (fqcount > 12) {
                                    LtLog.e(mFairy.getLineInfo("放弃太多次了结束"));
                                }
                            }
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("8次副本任务完成"));
                                setTaskEnd();
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(9, 271, 89, 539, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                if (result.sim > 0.75f) {
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(9, 271, 89, 539, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                    mFairy.onTap(0.75f, result, "左侧副本", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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


                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    if (timekeep(1, 300000, "游戏bug取消挂机")) {
                        result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                        mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                    }
                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);
                }

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 5000);
                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(5000);
                            }

                        }
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                            fqbj = 1;
                            setTaskName(1);
                            return;
                        }
                    }
                }
                result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }

            }

        }.taskContent(mFairy, "4次副本");
    }

    //门派日常12次
    public void menpai() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("门派日常完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "questmaster.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("门派日常"));
                        err = 0;
                        result = mFairy.findPic(result1.x + 276, result1.y + 60, result1.x + 438, result1.y + 110, "menpai4.png");
                        if (result.sim < 0.9f) {

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            mFairy.onTap(0.8f, result, "日常放弃", Sleep);
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("已接任务去做"));
                                gameUtil.close(0);
                                setTaskName(2);
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("已接任务去做"));
                                gameUtil.close(0);
                                setTaskName(2);
                                return;
                            }
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftmenpai.png", "Leftmenpai1.png", "Leftmenpai2.png", "Leftmenpai3.png", "Leftmenpai4.png","mp1.png"});
                if (result.sim > 0.7f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftmenpai.png", "Leftmenpai1.png", "Leftmenpai2.png", "Leftmenpai3.png", "Leftmenpai4.png","mp1.png"});
                    mFairy.onTap(0.7f, result, "门派日常", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);


                if (timekeep(0, 300000, "门派日常清包") && AtFairyConfig.getOption("qb").equals("1")) {
                    gameUtil.clearbag();
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("小任务完成"));
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "门派日常12次");
    }

    //门派日常16次
    public void menpai1() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd1() >= 16) {
                        judge_end++;
                        if (judge_end > 1) {
                            LtLog.e(mFairy.getLineInfo("门派日常完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    } else {
                        judge_end = 0;
                    }

                    result1 = mFairy.findPic(393, 156, 1149, 608, "questmaster.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("门派日常"));
                        err = 0;
                        result = mFairy.findPic(result1.x + 276, result1.y + 60, result1.x + 438, result1.y + 110, "menpai4.png");
                        if (result.sim < 0.9f) {

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            mFairy.onTap(0.8f, result, "日常放弃", Sleep);
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("已接任务去做"));
                                gameUtil.close(0);
                                setTaskName(2);
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("已接任务去做"));
                                gameUtil.close(0);
                                setTaskName(2);
                                return;
                            }
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftmenpai.png", "Leftmenpai1.png", "Leftmenpai2.png", "Leftmenpai3.png", "Leftmenpai4.png","mp1.png"});
                if (result.sim > 0.7f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftmenpai.png", "Leftmenpai1.png", "Leftmenpai2.png", "Leftmenpai3.png", "Leftmenpai4.png","mp1.png"});
                    mFairy.onTap(0.7f, result, "门派日常", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);


                if (timekeep(0, 300000, "门派日常清包") && AtFairyConfig.getOption("qb").equals("1")) {
                    gameUtil.clearbag();
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("小任务完成"));
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "门派日常16次");
    }

    //副本日常//11次藏宝阁
    public void fbrc1() throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0;

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd() > 300 || hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("11次藏宝阁任务完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "Replicatask.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("副本日常"));
                        result = mFairy.findPic(result1.x + 246, result1.y + 60, result1.x + 438, result1.y + 110, "fuben12.png");
                        if (result.sim > 0.9f) {
                            err = 0;
                            LtLog.e(mFairy.getLineInfo("活跃12"));
                            result = mFairy.findPic(result1.x + 123, result1.y - 10, result1.x + 379, result1.y + 30, new String[]{"fastCopy1cjg.png", "fastCopy1cjg1.png"});
                            if (result.sim > 0.8f) {
                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                                mFairy.onTap(0.8f, result, "日常完成", Sleep);
                                if (result.sim > 0.8f) {
                                    return;
                                }
                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                                mFairy.onTap(0.8f, result, "日常接取", Sleep);

                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                                if (result.sim > 0.8f && fqbj == 0) {
                                    mFairy.onTap(0.8f, result1, "已接任务去做", Sleep);
                                    setTaskName(2);
                                    return;
                                } else if (result.sim > 0.8f && fqbj == 1) {
                                    fqbj = 0;
                                    mFairy.onTap(0.8f, result, "放弃任务", Sleep);

                                }
                            } else {
                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                                mFairy.onTap(0.8f, result, "日常完成", Sleep);

                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                                mFairy.onTap(0.8f, result, "日常接取", Sleep);

                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                                mFairy.onTap(0.8f, result, "日常放弃", Sleep);

                            }
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("8次副本任务完成"));
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(9, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                if (result.sim > 0.75f) {
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                    mFairy.onTap(0.75f, result, "左侧副本", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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


                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    if (timekeep(1, 300000, "游戏bug取消挂机")) {
                        result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                        mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                    }
                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);
                }

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                }
                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));

                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);

                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 5000);
                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(4000);
                            }

                        }
                        result = mFairy.findPic(new String[]{"fbGetinto.png", "jia2.png"});
                        mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            fqbj = 1;
                            setTaskName(1);
                            return;
                        }
                    }
                }
                result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("cbgcz").equals("1")) {
                        mFairy.onTap(0.8f, result, 507, 439, 567, 459, "藏宝阁重置", Sleep);

                    } else {
                        mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                        LtLog.e(mFairy.getLineInfo("藏宝阁进不了了结束"));
                        setTaskEnd();
                        return;
                    }

                }
                result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "11次藏宝阁");
    }

    //打怪日常
    public void blaming() throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0, fqcount = 0;

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("打怪日常完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "sgstrange.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("打怪日常"));
                        err = 0;
                        result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                        mFairy.onTap(0.8f, result, "日常完成", Sleep);
                        if (result.sim > 0.8f) {
                            return;
                        }

                        result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                        mFairy.onTap(0.8f, result, "日常接取", Sleep);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("已接任务去做"));
                            gameUtil.close(0);
                            setTaskName(2);
                            return;
                        }

                        result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("已接任务去做"));
                            gameUtil.close(0);
                            setTaskName(2);
                            return;
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(56,230,262,466, new String[]{"Leftshaguai.png", "Leftshaguai1.png", "Leftshaguai2.png", "Leftshaguai3.png", "Leftshaguai4.png"});
                LtLog.e("====="+result.sim);
                if (result.sim > 0.7f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(56,230,262,466, new String[]{"Leftshaguai.png", "Leftshaguai1.png", "Leftshaguai2.png", "Leftshaguai3.png", "Leftshaguai4.png","rc1.png"});
                    mFairy.onTap(0.7f, result, "左侧杀怪日常", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);


                if (timekeep(0, 300000, "杀怪日常清包") && AtFairyConfig.getOption("qb").equals("1")) {
                    gameUtil.clearbag();
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("小任务完成"));
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "打怪日常");
    }

    //指定打怪日常
    public void blaming1() throws Exception {
        new SingleTask(mFairy) {
            String str;

            @Override
            public void create() throws Exception {
                if (AtFairyConfig.getOption("sggw").equals("1")) {
                    str = "sgsb.png";
                }
                if (AtFairyConfig.getOption("sggw").equals("2")) {
                    str = "sggbmf.png";
                }
                if (AtFairyConfig.getOption("sggw").equals("3")) {
                    str = "sglb.png";
                }
                if (AtFairyConfig.getOption("sggw").equals("4")) {
                    str = "sgxxb.png";
                }
                if (AtFairyConfig.getOption("sggw").equals("5")) {
                    str = "sgdz.png";
                }
                if (AtFairyConfig.getOption("sggw").equals("6")) {
                    str = "sgxb.png";
                }
                if (AtFairyConfig.getOption("sggw").equals("7")) {
                    str = "sgbyl.png";
                }
            }

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }


            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("打怪日常完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "sgstrange.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("打怪日常"));
                        err = 0;
                        result = mFairy.findPic(result1.x + 123, result1.y - 10, result1.x + 379, result1.y + 30, str);
                        if (result.sim < 0.8f) {

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            mFairy.onTap(0.8f, result, "日常放弃", Sleep);
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("已接任务去做"));
                                gameUtil.close(0);
                                setTaskName(2);
                                return;
                            }

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("已接任务去做"));
                                gameUtil.close(0);
                                setTaskName(2);
                                return;
                            }
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(57,306,264,472, new String[]{"Leftshaguai.png", "Leftshaguai1.png", "Leftshaguai2.png", "Leftshaguai3.png", "Leftshaguai4.png"});
                if (result.sim > 0.7f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(57,306,264,472, new String[]{"Leftshaguai.png", "Leftshaguai1.png", "Leftshaguai2.png", "Leftshaguai3.png", "Leftshaguai4.png","rc1.png"});
                    mFairy.onTap(0.7f, result, "左侧杀怪日常", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);


                if (timekeep(0, 300000, "杀怪日常清包") && AtFairyConfig.getOption("qb").equals("1")) {
                    gameUtil.clearbag();
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("小任务完成"));
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "指定打怪日常");
    }

    //快速副本日常//8次副本的
    public void fbrc_ks() throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0, fqcount = 0;

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd() > 140 || hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("快速8次副本任务完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "Replicatask.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("副本日常"));
                        result = mFairy.findPic(result1.x + 246, result1.y + 60, result1.x + 438, result1.y + 110, "fuben12.png");
                        if (result.sim > 0.9f) {
                            err = 0;
                            LtLog.e(mFairy.getLineInfo("活跃12"));
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                fqcount = 0;
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f && fqbj == 0) {
                                mFairy.onTap(0.8f, result1, "已接任务去做", Sleep);
                                setTaskName(2);
                                return;
                            } else if (result.sim > 0.8f && fqbj == 1) {
                                fqcount++;
                                if (fqcount > 9) {
                                    LtLog.e(mFairy.getLineInfo("放弃太多次了结束"));
                                }
                                fqbj = 0;
                                mFairy.onTap(0.8f, result, "放弃任务", Sleep);
                            }
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("快速8次副本任务完成"));
                                setTaskEnd();
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                if (result.sim > 0.75f) {
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                    mFairy.onTap(0.75f, result, "左侧副本", 3000);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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


                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", 2000);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                mFairy.onTap(0.8f, result, "副本离开", 4000);
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                }

                result = mFairy.findPic("Exitcopy.png");
                mFairy.onTap(0.8f, result, 541, 453, 542, 454, "退出副本", Sleep);

                result = mFairy.findPic("Leaveacopy.png");
                mFairy.onTap(0.8f, result, 541, 453, 542, 454, "离开副本", Sleep);


                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 4000);
                    }
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 8000);

                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 15000);
                            }else{
                                Thread.sleep(8000);
                            }
                        }
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                            fqbj = 1;
                            setTaskName(1);
                            return;
                        }
                    }
                }
                result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "快速8次副本");
    }

    //快速副本日常//8次副本140活跃的
    public void fbrc_ks140() throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0, fqcount = 0;

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd() > 140 || hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("快速8次副本任务完成"));
                            cactivity();
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "Replicatask.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("副本日常"));
                        result = mFairy.findPic(result1.x + 246, result1.y + 60, result1.x + 438, result1.y + 110, "fuben12.png");
                        if (result.sim > 0.9f) {
                            err = 0;
                            LtLog.e(mFairy.getLineInfo("活跃12"));
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                fqcount = 0;
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);

                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                            if (result.sim > 0.8f && fqbj == 0) {
                                mFairy.onTap(0.8f, result1, "已接任务去做", Sleep);
                                setTaskName(2);
                                return;
                            } else if (result.sim > 0.8f && fqbj == 1) {
                                fqcount++;
                                if (fqcount > 9) {
                                    LtLog.e(mFairy.getLineInfo("放弃太多次了结束"));
                                }
                                fqbj = 0;
                                mFairy.onTap(0.8f, result, "放弃任务", Sleep);
                            }
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("快速8次副本任务完成"));
                                setTaskEnd();
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                if (result.sim > 0.75f) {
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                    mFairy.onTap(0.75f, result, "左侧副本", 3000);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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


                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", 2000);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                mFairy.onTap(0.8f, result, "副本离开", 4000);
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                }

                result = mFairy.findPic("Exitcopy.png");
                mFairy.onTap(0.8f, result, 541, 453, 542, 454, "退出副本", Sleep);

                result = mFairy.findPic("Leaveacopy.png");
                mFairy.onTap(0.8f, result, 541, 453, 542, 454, "离开副本", Sleep);


                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 4000);
                    }
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 8000);

                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 15000);
                            }else{
                                Thread.sleep(8000);
                            }
                        }
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                            fqbj = 1;
                            setTaskName(1);
                            return;
                        }
                    }
                }
                result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "快速8次副本140活跃度");
    }


    //快速副本日常//11次藏宝阁
    public void fbrc1_ks() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            int fqbj = 0;

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    if (hyd() > 300 || hyd1() > 19) {
                        judge_end++;
                        if(judge_end>1) {
                            LtLog.e(mFairy.getLineInfo("快速11次藏宝阁任务完成"));
                            setTaskEnd();
                        }
                        Thread.sleep(1000);
                        return;
                    }else{
                        judge_end=0;
                    }
                    result1 = mFairy.findPic(393, 156, 1149, 608, "Replicatask.png");
                    if (result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("副本日常"));
                        result = mFairy.findPic(result1.x + 246, result1.y + 60, result1.x + 438, result1.y + 110, "fuben12.png");
                        if (result.sim > 0.9f) {
                            err = 0;
                            LtLog.e(mFairy.getLineInfo("活跃12"));
                            result = mFairy.findPic(result1.x + 123, result1.y - 10, result1.x + 379, result1.y + 30, new String[]{"fastCopy1cjg.png", "fastCopy1cjg1.png"});
                            if (result.sim > 0.8f) {
                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                                mFairy.onTap(0.8f, result, "日常完成", Sleep);
                                if (result.sim > 0.8f) {
                                    return;
                                }
                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                                mFairy.onTap(0.8f, result, "日常接取", Sleep);

                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                                if (result.sim > 0.8f && fqbj == 0) {
                                    mFairy.onTap(0.8f, result1, "已接任务去做", Sleep);
                                    setTaskName(2);
                                    return;
                                } else if (result.sim > 0.8f && fqbj == 1) {
                                    fqbj = 0;
                                    mFairy.onTap(0.8f, result, "放弃任务", Sleep);

                                }
                            } else {
                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                                mFairy.onTap(0.8f, result, "日常完成", Sleep);

                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                                mFairy.onTap(0.8f, result, "日常接取", Sleep);

                                result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcGiveUp.png");
                                mFairy.onTap(0.8f, result, "日常放弃", Sleep);

                            }
                        } else {
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "hdcomplete.png");
                            mFairy.onTap(0.8f, result, "日常完成", Sleep);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("8次副本任务完成"));
                                setTaskEnd();
                                return;
                            }
                            result = mFairy.findPic(result1.x + 450, result1.y + 37, result1.x + 615, result1.y + 105, "rcPickup.png");
                            mFairy.onTap(0.8f, result, "日常接取", Sleep);
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 510, 460, 510, 270, 1000, 1500, 2);
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                if (result.sim > 0.75f) {
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(50,229,287,465, new String[]{"Leftcopy.png", "Leftcopy1.png", "Leftcopy2.png", "Leftcopy3.png", "Leftcopy4.png", "Leftcopy5.png", "Leftcopy6.png"});
                    mFairy.onTap(0.75f, result, "左侧副本", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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


                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                mFairy.onTap(0.8f, result, "副本离开", Sleep);
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));

                }
                result = mFairy.findPic("Exitcopy.png");
                mFairy.onTap(0.8f, result, 541, 453, 542, 454, "退出副本", Sleep);

                result = mFairy.findPic("Leaveacopy.png");
                mFairy.onTap(0.8f, result, 541, 453, 542, 454, "离开副本", Sleep);

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                }
                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 5000);
                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(5000);
                            }

                        }
                        result = mFairy.findPic(new String[]{"fbGetinto.png", "jia2.png"});
                        mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            fqbj = 1;
                            setTaskName(1);
                            return;
                        }
                    }
                }
                result = mFairy.findPic(642, 273, 863, 393, new String[]{"cbgFinished.png", "cbgFinished1.png"});
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("cbgcz").equals("1")) {
                        mFairy.onTap(0.8f, result, 507, 439, 567, 459, "藏宝阁重置", Sleep);

                    } else {
                        mFairy.onTap(0.8f, result, 738, 452, 739, 453, "藏宝阁完了", Sleep);
                        LtLog.e(mFairy.getLineInfo("藏宝阁进不了了结束"));
                        setTaskEnd();
                        return;
                    }

                }
                result = mFairy.findPic(116, 302, 223, 382, new String[]{"xscopy.png", "xscopy1.png"});
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "是个限时副本,没办法做", Sleep);
                mFairy.onTap(0.8f, result, 263, 192, 264, 193, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                    fqbj = 1;
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "快速11次藏宝阁");
    }

    //单人副本
    public void drfb(final String str) throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 257, 270, 258, 271, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(400, 133, 1147, 663, str);
                    if (result.sim > 0.9f) {
                        if (str.equals("drfbjjc.png")) {
                            mFairy.onTap(0.8f, result, 770, 203, 771, 204, "防bug点击", Sleep);
                            mFairy.onTap(0.8f, result, 263, 632, 264, 633, "防bug点击", Sleep);
                        }
                        mFairy.onTap(0.8f, result, str, Sleep);
                        setTaskName(2);
                        return;
                    }
                }
            }

            public void content_2() throws Exception {
                if (overtime(20, 0)) return;
                Thread.sleep(2000);
                result = mFairy.findPic(944, 515, 1120, 639, "jjcChallenge.png");
                mFairy.onTap(0.8f, result, "竞技场挑战", Sleep);

                result = mFairy.findPic(361, 237, 650, 431, "jjcstop.png");
                mFairy.onTap(0.8f, result, 738, 452, 739, 453, "竞技场完了", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(632, 554, 875, 673, "Starttest.png");
                mFairy.onTap(0.8f, result, "开始考验", Sleep);

                result = mFairy.findPic(690, 571, 870, 668, "Answerinterface.png");
                mFairy.onTap(0.8f, result, 545, 416, 546, 417, "日常答题界面", Sleep);
                if (result.sim > 0.8f) {
                    err = 0;
                }

                result = mFairy.findPic(689, 165, 1057, 254, "Completionanswer.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("答题完成"));
                    setTaskEnd();
                    return;
                }



                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    if (timekeep(1, 300000, "游戏bug取消挂机")) {

                        result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                        mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                    }
                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);
                }

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                mFairy.onTap(0.8f, result, 642, 451, 643, 452, "副本完成", 5000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));



                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            fubennd();
                            mFairy.onTap(0.8f, result, "进入副本", 5000);

                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(5000);
                            }

                        }
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                            setTaskEnd();
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy, "单人副本");
    }

    //惩奸除恶
    public void drfb_cjce(final String str) throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 257, 270, 258, 271, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(400, 133, 1147, 663, str);
                    if (result.sim > 0.9f) {
                        mFairy.onTap(0.8f, result, 770, 203, 771, 204, "防bug点击", Sleep);
                        mFairy.onTap(0.8f, result, 263, 632, 264, 633, "防bug点击", Sleep);
                        mFairy.onTap(0.8f, result, str, Sleep);
                        setTaskName(2);
                        return;
                    }
                }
            }

            int hdcount = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(9, 271, 89, 539, new String[]{"leftcjce.png"});
                if (result.sim > 0.72f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(9, 271, 89, 539, new String[]{"leftcjce.png"});
                    mFairy.onTap(0.72f, result, "左侧惩奸除恶", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic( "cjReceive.png");
                mFairy.onTap(0.8f, result, "惩奸领取任务", 5000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic( "cjReceive.png");
                    mFairy.onTap(0.8f, result, "惩奸任务完成", Sleep);
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                    gameUtil.close(0);
                }
                result = mFairy.findPic( "cjgiveup.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("惩奸放弃任务"));
                    gameUtil.close(0);
                }

                result = mFairy.findPic( "cjcomplete.png");
                mFairy.onTap(0.8f, result, "惩奸完成任务", Sleep);


                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);

                if (timekeep(0, 300000, "惩奸清包") && AtFairyConfig.getOption("qb").equals("1")) {
                    gameUtil.clearbag();
                }


            }
        }.taskContent(mFairy, "惩奸除恶");
    }

    //固定队副本
    public void gddfb(final String str) throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 257, 270, 258, 271, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(400, 133, 1147, 663, str);
                    if (result.sim > 0.9f) {
                        mFairy.onTap(0.8f, result, str, Sleep);
                        setTaskName(2);
                        return;
                    }
                }
            }

            public void content_2() throws Exception {
                if (overtime(20, 0)) return;

                Thread.sleep(2000);

                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));

                    if (timekeep(1, 300000, "游戏bug取消挂机")) {
                        result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                        mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                    }
                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);
                }

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                mFairy.onTap(0.8f, result, 642, 451, 643, 452, "副本完成", 5000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 3500);
                    }
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            mFairy.onTap(0.8f, result, 686, 370, 687, 371, "切换到队伍", Sleep);
                            fubennd();
                            if (AtFairyConfig.getOption("gy").equals("1")) {
                                mFairy.onTap(0.8f, result, 861, 576, 862, 577, "", Sleep);
                                mFairy.onTap(0.8f, result, 1014, 170, 1015, 171, "", Sleep);
                                mFairy.onTap(0.8f, result, 959, 616, 960, 617, "", Sleep);
                            }
                            mFairy.onTap(0.8f, result, "进入副本", 5000);


                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(5000);
                            }

                            for (int i = 0; i < 3; i++) {
                                result = mFairy.findPic(390,350,632,547,"ok1.png");
                                mFairy.onTap(0.8f,result,"确定",5000);
                            }

                            Thread.sleep(8000);

                            result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                                setTaskEnd();
                                return;
                            }

                        }

                    }
                }
            }
        }.taskContent(mFairy, "固定队副本");
    }

    //固定队限时副本
    public void gddfb1(final String str) throws Exception {
        new SingleTask(mFairy) {


            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }


            public void content_1() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 238, 346, 265, 357, "活动界面", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(400, 133, 1147, 663, str);
                    if (result.sim > 0.9f) {
                        mFairy.onTap(0.8f, result, str, Sleep);
                        setTaskName(2);
                        return;
                    }
                }
            }


            public void content_2() throws Exception {
                if (overtime(20, 0)) return;
                Thread.sleep(2000);
                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);
                }

                result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    if (timekeep(1, 300000, "游戏bug取消挂机")) {
                        result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                        mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                    }
                    result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                    mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                    result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                    mFairy.onTap(0.8f, result, "场景挂机", Sleep);
                }

                result = mFairy.findPic(941, 465, 1171, 643, "fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                mFairy.onTap(0.8f, result, 642, 451, 643, 452, "副本完成", 5000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514, 439, 561, 460, "", 5000);
                    }
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic( "fbwl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本完成"));
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    result = mFairy.findPic(859, 272, 1126, 421, "cbgChallenge.png");
                    mFairy.onTap(0.8f, result, "藏宝阁挑战", Sleep);
                    if (result.sim < 0.8f) {
                        result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("进入副本"));
                            mFairy.onTap(0.8f, result, 686, 370, 687, 371, "切换到队伍", Sleep);
                            fubennd();
                            if (AtFairyConfig.getOption("gy").equals("1")) {
                                mFairy.onTap(0.8f, result, 861, 576, 862, 577, "", 2000);
                                mFairy.onTap(0.8f, result, 1014, 170, 1015, 171, "", Sleep);
                                mFairy.onTap(0.8f, result, 959, 616, 960, 617, "", Sleep);
                            }
                            mFairy.onTap(0.8f, result, "进入副本", 5000);

                            result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                            if(result.sim>0.8f) {
                                mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                            }else{
                                Thread.sleep(5000);
                            }

                            result = mFairy.findPic(390,350,632,547,"ok1.png");
                            mFairy.onTap(0.8f,result,"确定",12000);


                            result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("这个副本不能进了放弃副本"));
                                setTaskEnd();
                                return;
                            }
                        }
                    }
                }
            }
        }.taskContent(mFairy, "固定队限时副本");
    }

    //领活跃奖励
    public void cactivity() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 213,184,329,191, "活动", Sleep);
                if (result.sim > 0.8f) {

                    for (int i = 0; i < 5; i++) {
                        result1 = mFairy.findPic(442+i*141,497,517+i*141,572, "lingqu.png");
                        mFairy.onTap(0.8f, result, 468+i*141,524,481+i*141,534,"活跃度领取", 3000);
                        result2 = mFairy.findPic(357,56,969,346, "gc.png");

                        if (result2.sim > 0.8f) {
                            mFairy.onTap(0.8f, result2, "关叉", 2000);
                            if(result1.sim<0.8f) {
                                setTaskEnd();
                                return;
                            }
                        }
                    }
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "领活跃奖励");
    }

    //成就领取
    public void achievement() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "achievement.png");
                mFairy.onTap(0.8f, result, "成就", Sleep);


                result = mFairy.findPic( "Achievementinterface.png");
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(20, 99)) return;
                result = mFairy.findPic(335, 139, 391, 650, "Leadachievement.png");
                mFairy.onTap(0.8f, result, "有成就", Sleep);

                result = mFairy.findPic(894, 123, 1145, 665, "Leadachievement1.png");
                mFairy.onTap(0.8f, result, "领取成就奖励", Sleep);

            }
        }.taskContent(mFairy, "成就领取");
    }

    ///跑商
    public void sportsBusiness() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.backCity(1, 1);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "Underworld.png");
                mFairy.onTap(0.8f, result, "帮会", 5000);

                result = mFairy.findPic( "Ganginterface.png");
                mFairy.onTap(0.8f, result, "帮会界面", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(910, 89, 550, 93, 500, (long) 500, 2);
                    mFairy.ranSwipe(910, 89, 550, 93, 500, (long) 1500, 2);
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(7, 0)) return;

                result = mFairy.findPic(291, 68, 1086, 118, "Gangproperty.png");
                mFairy.onTap(0.8f, result, "帮会财产", Sleep);


                result = mFairy.findPic( "paoshangmeet.png");
                if (result.sim > 0.8f) {
                    Thread.sleep(3000);
                    mFairy.condit();
                    result1 = mFairy.findPic( "paoshangstop.png");
                    if (result1.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    } else {
                        mFairy.onTap(0.8f, result, "跑商接取", Sleep);
                    }
                }

                result = mFairy.findPic( "paoshangSelection.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("nandu").equals("1")) {
                        mFairy.onTap(0.8f, result, 620, 440, 621, 441, "跑商难度1", Sleep);
                    }
                    if (AtFairyConfig.getOption("nandu").equals("2")) {
                        mFairy.onTap(0.8f, result, 930, 442, 931, 443, "跑商难度2", Sleep);
                    }
                    if (AtFairyConfig.getOption("nandu").equals("3")) {
                        mFairy.onTap(0.8f, result, 659, 530, 660, 531, "跑商难度3", Sleep);
                    }
                    result = mFairy.findPic( "man.png");
                    if (result.sim > 0.8f){
                        LtLog.e("背包满了 结束任务");
                        setTaskEnd();
                    }
                    gameUtil.close(0);
                    setTaskName(3);
                    return;
                }


                result = mFairy.findPic( 408,519,640,629,"phcomplete.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);

            }

            int hdcount = 0;

            public void content_3() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(46,226,276,467, new String[]{"LeftGang.png", "LeftGang1.png","LeftGang2.png"});
                if (result.sim > 0.7f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(46,226,276,467, new String[]{"LeftGang.png", "LeftGang1.png","LeftGang2.png"});
                    mFairy.onTap(0.7f, result, "左侧跑商", Sleep);
                } else {
                    result = mFairy.findPic("taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);

                if (timekeep(0, 300000, "跑商异常移动")) {
                    mFairy.ranSwipe(66, 310, 47, 468, 1000, (long) 500, 2);
                }


                result = mFairy.findPic( 408,519,640,629,"phcomplete.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);


            }
        }.taskContent(mFairy, "跑商");
    }

    ///跑环
    public void sportsBusiness1() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "Underworld.png");
                mFairy.onTap(0.8f, result, "帮会", 5000);

                result = mFairy.findPic( "Ganginterface.png");
                mFairy.onTap(0.8f, result, "帮会界面", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(910, 89, 550, 93, 500, (long) 500, 2);
                    mFairy.ranSwipe(910, 89, 550, 93, 500, (long) 1500, 2);
                    setTaskName(2);
                    return;
                }
            }

            int fqbj = 0;

            public void content_2() throws Exception {
                if (overtime(7, 0)) return;

                result = mFairy.findPic(291, 68, 1086, 118, "paohuan.png");
                mFairy.onTap(0.8f, result, "帮会任务", Sleep);

                result = mFairy.findPic(929, 528, 1134, 616, "phparticipate.png");
                mFairy.onTap(0.75f, result, "参与", Sleep);


                result = mFairy.findPic( "phgiveup.png");
                if (result.sim > 0.8f && fqbj == 0) {
                    gameUtil.close(0);
                    setTaskName(3);
                    return;
                }
                if (result.sim > 0.8f && fqbj == 1) {
                    mFairy.onTap(0.8f, result, "放弃", Sleep);
                    mFairy.onTap(0.8f, result, 547, 447, 548, 448, "放弃", Sleep);
                    Thread.sleep(190000);
                    fqbj = 0;
                }

                result = mFairy.findPic( "phPickup.png");
                mFairy.onTap(0.8f, result, "接取", 2000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic( "phPickup.png");
                    mFairy.onTap(0.8f, result, "接取", 2000);
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic( "phPickup.png");
                        mFairy.onTap(0.8f, result, "接取", 2000);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("任务完成"));
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result = mFairy.findPic( 408,519,640,629,"phcomplete.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);

            }

            int hdcount = 0;

            public void content_3() throws Exception {
                if (overtime(7, 0)) {
                    result = mFairy.findPic( 4,199,87,511,"taskbar.png");
                    if (result.sim > 0.95f) {
                        for (int i = 0; i < 3; i++) {
                            LtLog.e(mFairy.getLineInfo("左侧任务栏"));
                            result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
                            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", 2000);
                            mFairy.ranSwipe(66, 310, 47, 468, 500, (long) 1, 2);
                        }
                    }
                    return;
                }

                result = mFairy.findPic(31,201,297,505, new String[]{"LeftGang.png", "LeftGang1.png","LeftGang2.png","LeftGang3.png"});
                if (result.sim > 0.7f) {
                    err = 0;
                    hdcount = 0;
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(31,201,297,505, new String[]{"LeftGang.png", "LeftGang1.png","LeftGang2.png","LeftGang3.png"});
                    mFairy.onTap(0.7f, result, "左侧跑环", Sleep);
                } else {
                    result = mFairy.findPic( "taskbar.png");
                    if (result.sim > 0.95f) {
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
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result, "场景挂机", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("是个副本没法做"));
                    fqbj = 1;
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic( "phparticipate.png");
                mFairy.onTap(0.8f, result, "参与", Sleep);


                result = mFairy.findPic( "phgiveup.png");
                if (result.sim > 0.8f) {
                    gameUtil.close(0);
                }

                result = mFairy.findPic( "phPickup.png");
                mFairy.onTap(0.8f, result, "接取", 2000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic( "phPickup.png");
                    mFairy.onTap(0.8f, result, "接取", 2000);
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic( "phPickup.png");
                        mFairy.onTap(0.8f, result, "接取", 2000);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("任务完成"));
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result = mFairy.findPic( 408,519,640,629,"phcomplete.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);
            }
        }.taskContent(mFairy, "跑环");
    }

    //拜访侠客
    public void guest() throws Exception {
        new SingleTask(mFairy) {
            int xknum = 0, xiakeci = 0;

            public void create() throws Exception {
                xknum = Integer.parseInt(AtFairyConfig.getOption("xiake"));
                xiakeci = Integer.parseInt(AtFairyConfig.getOption("xiakeci"));
            }

            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "guest.png");
                mFairy.onTap(0.8f, result, "侠客", Sleep);

                result = mFairy.findPic( "o1.png");
                mFairy.onTap(0.8f,result,"",500);

                result = mFairy.findPic( "xkvisit.png");
                mFairy.onTap(0.8f, result, "拜访侠客", Sleep);

                result1 = mFairy.findPic( "xkOnekey.png");
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic( "xxlno.png");
                    if (result.sim > 0.78f) {
                        result = mFairy.findPic( "xhxxl.png");
                        mFairy.onTap(0.8f, result, 182, 630, 183, 631, "寻侠令勾选", Sleep);
                    } else {
                        result = mFairy.findPic( "xhxxl.png");
                        if (result.sim < 0.8f) {
                            mFairy.onTap(182, 630, 183, 631, "寻侠令勾选", Sleep);
                        }
                    }
                    if (xiakeci == 0) {
                        gameUtil.close(0);
                        setTaskEnd();
                        return;
                    }
                    xiakeci--;
                    LtLog.e(mFairy.getLineInfo("还剩几次" + xiakeci));
                    mFairy.onTap(0.8f, result1, "一键拜访", 3000);

                    result = mFairy.findPic( "o1.png");
                    mFairy.onTap(0.8f,result,"",800);

                    result = mFairy.findPic( "xkReturn.png");
                    mFairy.onTap(0.8f, result, "返回", Sleep);

                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic( "xkInterface.png");
                if (result.sim > 0.8f) {
                    if (xknum >= 1 && xknum <= 4) {
                        mFairy.onTap(0.8f, result, 204, 85 + (115 * xknum), 205, 86 + (115 * xknum), "侠客", Sleep);
                    }
                    if (xknum >= 5 && xknum <= 8) {
                        mFairy.onTap(0.8f, result, 513, 85 + (115 * (xknum - 4)), 514, 86 + (115 * (xknum - 4)), "侠客", Sleep);
                    }
                    if (xknum >= 9 && xknum <= 12) {
                        mFairy.onTap(0.8f, result, 361, 576, 362, 577, "侠客", 2000);
                        mFairy.onTap(0.8f, result, 204, 85 + (115 * (xknum - 8)), 205, 86 + (115 * (xknum - 8)), "侠客", Sleep);
                    }
                    if (xknum >= 13 && xknum <= 16) {
                        mFairy.onTap(0.8f, result, 361, 576, 362, 577, "侠客", 2000);
                        mFairy.onTap(0.8f, result, 513, 85 + (115 * (xknum - 12)), 514, 86 + (115 * (xknum - 12)), "侠客", Sleep);
                    }
                    mFairy.onTap(0.8f, result, 817, 563, 818, 564, "升级", 2000);
                    Thread.sleep(2000);
                    mFairy.condit();
                }

                result = mFairy.findPic( "o1.png");
                mFairy.onTap(0.8f,result,"",500);

                result = mFairy.findPic( "xkpower.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 754, 637, 755, 638, "智能选择", Sleep);
                    if (AtFairyConfig.getOption("xsys").equals("1")) {
                        mFairy.onTap(0.8f, result, 744, 425, 745, 426, "橙色一下", Sleep);
                    } else {
                        mFairy.onTap(0.8f, result, 745, 578, 746, 579, "所有", Sleep);
                    }
                    mFairy.onTap(0.8f, result, 1009,626,1053,641,"传功", 2000);

                    result = mFairy.findPic( "noknowcancel.png");
                    mFairy.onTap(0.8f, result, 542, 450, 543, 451, "传功确定", 2000);
                    mFairy.onTap(0.8f, result, 1147, 64, 1148, 65, "返回", 2000);
                    setTaskName(1);
                    return;
                }
            }

        }.taskContent(mFairy, "拜访侠客中");
    }

    //活跃度
    public int hyd() throws Exception {
        int hyd = 0;
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            result = mFairy.findPic(611, 123, 733, 166, "zd.png");
            if (result.sim > 0.7f) {
                LtLog.e(mFairy.getLineInfo("法力值不足遮挡"));
                gameUtil.close(0);
                result = mFairy.findPic(1029,95,1112,178, "gjz.png");
                mFairy.onTap(0.8f, result, 1058,124,1077,142,"取消挂机", Sleep);
            }

            mFairy.condit();
            result = mFairy.findPic(795,626,854,654, "hy" + i + ".png");
            if (result.sim > 0.9f) {
                tempMap.put(i, result.x);
            }

        }
        LtLog.e(mFairy.getLineInfo("有几位数=" + tempMap.size()));
        if (tempMap.size() == 3) {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(tempMap.entrySet());
            List<Integer> list1 = new ArrayList<>();
            //然后通过比较器来实现排序

            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                //升序排序
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            for (Map.Entry<Integer, Integer> mapping : list) {
                list1.add(mapping.getKey());
            }
            hyd = (list1.get(0)) * 100 + (list1.get(1)) * 10 + (list1.get(2));
            LtLog.e(mFairy.getLineInfo("活跃度为=" + hyd));
        }
        return hyd;
    }

    public int hyd1() throws Exception {
        int hyd = 0;
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            mFairy.condit();
            result = mFairy.findPic(1017, 120, 1066, 161, "hy" + i + ".png");
            if (result.sim > 0.9f) {
                tempMap.put(i, result.x);
            }
        }

        LtLog.e(mFairy.getLineInfo("任务次数几位数=" + tempMap.size()));

        if (tempMap.size() == 2) {

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(tempMap.entrySet());

            List<Integer> list1 = new ArrayList<>();

            //然后通过比较器来实现排序
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                //升序排序
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            for (Map.Entry<Integer, Integer> mapping : list) {
                list1.add(mapping.getKey());
            }

            hyd = (list1.get(0)) * 10 + (list1.get(1));
            LtLog.e(mFairy.getLineInfo("任务次数为=" + hyd));
        }
        return hyd;
    }

    public int qh = 0;
    ///切换角色
    public void switchedRoles1() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                qh=0;
            }

            public void content_1() throws Exception {
                if (overtime(150, 0)) return;

                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "setup.png");
                mFairy.onTap(0.8f, result, "设置", Sleep);

                if(qh==0){
                    result = mFairy.findPic(59, 15, 348, 173, new String[]{"Settinginterface.png", "jia3.png"});
                    mFairy.onTap(0.8f, result, 502,80,536,93, "挂机设置", 1500);

                    result = mFairy.findPic(140,477,502,620,"qh2.png");
                    if(result.sim>0.8f) {
                        result = mFairy.findPic( 140,477,502,620,"qh1.png");
                        mFairy.onTap(0.8f, result, "取消定点挂机的选项", Sleep);
                        qh=1;
                    }
                    return;
                }

                result = mFairy.findPic(59, 15, 348, 173, new String[]{"Settinginterface.png", "jia3.png"});
                mFairy.onTap(0.8f, result, 348,81,383,98, "系统设置", 1500);
                mFairy.onTap(0.8f, result, 1025, 304, 1026, 305, "设置界面", Sleep);

                result = mFairy.findPic( "Determineswitching.png");
                mFairy.onTap(0.8f, result, 538, 451, 539, 452, "确定切换", Sleep);


                result1 = mFairy.findPic( new String[]{"Entergame2.png","Entergame.png"});
                if (result1.sim > 0.8f) {
                    if (TaskMain.list.get(0).equals("1")) {
                        mFairy.onTap(0.8f, result1, 200, 93, 201, 94, "第一个角色", 5000);
                    }
                    if (TaskMain.list.get(0).equals("2")) {
                        mFairy.onTap(0.8f, result1, 129, 260, 130, 261, "第2个角色", 5000);
                    }
                    if (TaskMain.list.get(0).equals("3")) {
                        mFairy.onTap(0.8f, result1, 196, 424, 197, 425, "第3个角色", 5000);
                    }
                    if (TaskMain.list.get(0).equals("4")) {
                        mFairy.onTap(0.8f, result1, 131, 578, 132, 579, "第4个角色", 5000);
                    }

                    result = mFairy.findPic( new String[]{"Entergame.png","Establishjs2.png"});
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "返回", Sleep);
                        TaskMain.list.remove(0);
                        return;
                    } else {
                        mFairy.onTap(0.8f, result1, "进入游戏", Sleep);
                        setTaskEnd();
                        return;
                    }
                }
                Thread.sleep(1000);
            }
        }.taskContent(mFairy, "切换角色");
    }

    ///切换角色
    public void switchedRoles() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
            }

            int jsnum = 0;

            public void content_1() throws Exception {
                if (overtime(150, 0)) return;

                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "setup.png");
                mFairy.onTap(0.8f, result, "设置", Sleep);

                result = mFairy.findPic(59, 15, 348, 173, new String[]{"Settinginterface.png", "jia3.png"});
                mFairy.onTap(0.8f, result, 1025, 304, 1026, 305, "设置界面", Sleep);


                result = mFairy.findPic( "Determineswitching.png");
                mFairy.onTap(0.8f, result, 538, 451, 539, 452, "确定切换", Sleep);


                result1 = mFairy.findPic( new String[]{"Entergame.png","Entergame2.png"});
                if (result1.sim > 0.8f) {
                    if (TaskMain.list.get(0).equals("1")) {
                        mFairy.onTap(0.8f, result1, 200, 93, 201, 94, "第一个角色", 5000);
                    }
                    if (TaskMain.list.get(0).equals("2")) {
                        mFairy.onTap(0.8f, result1, 129, 260, 130, 261, "第2个角色", 5000);
                    }
                    if (TaskMain.list.get(0).equals("3")) {
                        mFairy.onTap(0.8f, result1, 196, 424, 197, 425, "第3个角色", 5000);
                    }
                    if (TaskMain.list.get(0).equals("4")) {
                        mFairy.onTap(0.8f, result1, 131, 578, 132, 579, "第4个角色", 5000);
                    }
                    result = mFairy.findPic( "Establishjs.png");
                    if (result.sim > 0.8f) {
                    } else {
                        mFairy.onTap(0.8f, result1, "进入游戏", Sleep);
                        novice();
                        setTaskEnd();
                        return;
                    }
                }

                result1 = mFairy.findPic("Establishjs.png");
                if (result1.sim > 0.8f) {
                    if (TaskMain.list.get(0).equals("1")) {
                        jsnum = Integer.parseInt(AtFairyConfig.getOption("zy"));
                    }
                    if (TaskMain.list.get(0).equals("2")) {
                        jsnum = Integer.parseInt(AtFairyConfig.getOption("zy1"));
                    }
                    if (TaskMain.list.get(0).equals("3")) {
                        jsnum = Integer.parseInt(AtFairyConfig.getOption("zy2"));
                    }
                    if (TaskMain.list.get(0).equals("4")) {
                        jsnum = Integer.parseInt(AtFairyConfig.getOption("zy3"));
                    }
                    LtLog.e(mFairy.getLineInfo("选择一个角色jsnum=" + jsnum));
                    String string = "js1.png";
                    if (jsnum == 1) {
                        string = "js1.png";
                    }
                    if (jsnum == 2) {
                        string = "js2.png";
                    }
                    if (jsnum == 3) {
                        string = "js3.png";
                    }
                    if (jsnum == 4) {
                        string = "js4.png";
                    }
                    if (jsnum == 5) {
                        string = "js5.png";
                    }
                    if (jsnum == 6) {
                        string = "js6.png";
                    }
                    if (jsnum == 7) {
                        string = "js7.png";
                    }
                    if (jsnum == 8) {
                        string = "js8.png";
                    }
                    if (jsnum == 9) {
                        string = "js9.png";
                    }
                    if (jsnum == 10) {
                        string = "js10.png";
                    }
                    if (jsnum == 11) {
                        string = "js11.png";
                    }
                    if (jsnum == 12) {
                        string = "js12.png";
                    }
                    if (jsnum == 12) {
                        string = "js12.png";
                    }
                    result = mFairy.findPic(66, 57, 256, 618, string);
                    mFairy.onTap(0.8f, result, string, 3000);
                    if (result.sim > 0.8f) {

                    } else {
                        for (int i = 0; i < 5; i++) {
                            mFairy.touchDown(2, 171, 152);
                            mFairy.touchMove(2, 174, 532, 1000);
                            mFairy.touchUp(2);
                        }
                        Thread.sleep(2000);
                        mFairy.condit();
                        for (int i = 0; i < 10; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(66, 57, 256, 618, string);
                            mFairy.onTap(0.8f, result, string, 3000);
                            if (result.sim > 0.8f) {
                                break;
                            } else {
                                mFairy.touchDown(2, 174, 532);
                                mFairy.touchMove(2, 171, 152, 2000);
                                mFairy.touchUp(2);
                                Thread.sleep(2000);
                            }
                        }
                    }

                    result = mFairy.findPic( "Entergame1.png");
                    mFairy.onTap(0.8f, result, "进入游戏界面", 3000);

                    result = mFairy.findPic( "namesure.png");
                    mFairy.onTap(0.8f, result, 645, 452, 646, 453, "名字重复", 3000);

                    result = mFairy.findPic( "Entergame1.png");
                    mFairy.onTap(0.8f, result, "进入游戏界面", 3000);
                    novice();
                    setTaskEnd();
                    return;
                }
                Thread.sleep(1000);
            }
        }.taskContent(mFairy, "切换角色");
    }

    public void fubennd() throws Exception {
        result2 = mFairy.findPic( 1035,207,1121,381,"xiuluo.png");
        if (result2.sim > 0.8f) {
            if (AtFairyConfig.getOption("fbnd").equals("1")) {
                mFairy.onTap(0.8f, result2, 794, 263, 811, 290, "普通", Sleep);
            }
            if (AtFairyConfig.getOption("fbnd").equals("2")) {
                mFairy.onTap(0.8f, result2, 881, 254, 905, 288, "困难", Sleep);
            }
            if (AtFairyConfig.getOption("fbnd").equals("3")) {
                mFairy.onTap(0.8f, result2, 975, 256, 997, 292, "精英", Sleep);
            }
            if (AtFairyConfig.getOption("fbnd").equals("4")) {
                mFairy.onTap(0.8f, result2, 1071, 256, 1088, 293, "修罗", Sleep);
            }
        } else {
            if (AtFairyConfig.getOption("fbnd").equals("1")) {
                mFairy.onTap(836, 274, 837, 275, "普通", Sleep);
            }
            if (AtFairyConfig.getOption("fbnd").equals("2")) {
                mFairy.onTap(949, 279, 950, 280, "困难", Sleep);
            }
            if (AtFairyConfig.getOption("fbnd").equals("3") || AtFairyConfig.getOption("fbnd").equals("4")) {
                mFairy.onTap(1064, 276, 1065, 277, "精英", Sleep);
            }

        }


    }


    //帮会任务
    public void bhrw() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                //gameUtil.backCity(1, 1);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "Underworld.png");
                mFairy.onTap(0.8f, result, "帮会", 5000);

                result = mFairy.findPic( "Ganginterface.png");
                mFairy.onTap(0.8f, result, "帮会界面", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(910, 89, 550, 93, 500, (long) 500, 2);
                    mFairy.ranSwipe(910, 89, 550, 93, 500, (long) 1500, 2);
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(20, 0)) return;

                result = mFairy.findPic(291, 68, 1086, 118, "task.png");
                mFairy.onTap(0.8f, result, "帮会任务", Sleep);

                result = mFairy.findPic( "canyu.png");
                mFairy.onTap(0.8f, result, "参与", Sleep);

                result = mFairy.findPic( "jiequ2.png");
                mFairy.onTap(0.8f, result, "接取", Sleep);

                result = mFairy.findPic( "fangqi.png");
               if (result.sim > 0.8f){
                   gameUtil.close(0);

               }

                result = mFairy.findPic( 73,229,244,463,new String[]{"gang.png","ganggreen.png"});
                mFairy.onTap(0.8f, result, "帮会左侧", Sleep);

                result = mFairy.findPic( "wancheng.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);

                result = mFairy.findPic( "shudi.png");
                if (result.sim > 0.8f){
                    setTaskName(1);return;
                }
                result = mFairy.findPic( "zero.png");
                if (result.sim > 0.8f){
                   setTaskEnd();return;
                }

                result = mFairy.findPic( new String[]{"fbGetinto.png", "jia2.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进入副本"));
                    fubennd();
                    mFairy.onTap(0.8f, result, "进入副本", 5000);

                    result = mFairy.findPic(378, 264, 900, 466, "EntercopySure.png");
                    if(result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, 536, 451, 537, 452, "进入副本确定", 12000);
                        Thread.sleep(5000);
                        setTaskName(1);return;
                    }else{
                        Thread.sleep(5000);
                    }

                }

            }

        }.taskContent(mFairy, "帮会任务");
    }

}
