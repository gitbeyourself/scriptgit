

package com.example.administrator.sh;


import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;

import org.opencv.core.Mat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/13.
 */

public class SingleTask {
    sh mFairy;
    FindResult result;
    private CommonFunction comm;
    private GamePublicFunction gamePublicFunction;
    Other other;
    private long time;
    int week;

    public SingleTask(sh ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        other = new Other(mFairy);
    }

    /*  单人任务  */
    public int thread() throws Exception {
        int bj = 0, count = 0, battleFailure = 0, num = 0;
        int c = 0;
        gamePublicFunction.switchRolesYools();
        while (true) {
            if (bj == 0) {
                gamePublicFunction.ranks(2);

                gamePublicFunction.decompose(1);

                if (AtFairyConfig.getOption("zdmq").equals("1")) {
                    gamePublicFunction.autoMQ();//自动装备铭切
                }
                if (AtFairyConfig.getOption("zdzb").equals("1")) {
                    gamePublicFunction.autoEquipment();//自动装备
                }
                if (AtFairyConfig.getOption("wqqh").equals("1")) {
                    other.strengthenArms();//强化武器10次
                }
                if ((AtFairyConfig.getOption("ym").equals("1"))) {
                    LtLog.e(comm.getText("***********************阎魔之路***********************"));
                    if (batt() == 1) {
                        ym();
                    }
                }
                if (AtFairyConfig.getOption("qq").equals("1")) {
                    gamePublicFunction.hhf();
                }
                gamePublicFunction.init("home.png");
                bj = 1;
                count = 0;
                num = 0;
                c = 0;
            }
            if (bj == 1) {
                gamePublicFunction.chat();
                gamePublicFunction.task();

                result = mFairy.findPic2(comm.setImg("tili.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足"));

                    if (AtFairyConfig.getOption("ssss").equals("1")) {

                        comm.spot(397, 357, "小份寿司", 2000);

                        result = mFairy.findPic2(comm.setImg("ssss.png"));
                        if (result.sim > 0.85f) {
                            while (true) {
                                result = mFairy.findPic2(comm.setImg("ssss.png"));
                                if (result.sim > 0.85f) {
                                    comm.Click(0.85f, result, comm.getImg(), "使用寿司", 700);
                                } else {
                                    break;
                                }
                            }
                        } else {
                            bj = 2;
                            continue;
                        }
                        comm.spot(927, 195, "关闭", 1000);
                    } else {
                        bj = 2;
                        continue;
                    }
                }
                //新手引导识别技能弹框
                for (int i = 0; i < 2; i++) {
                    result = comm.arrayCompare(2f, new String[]{"guide12.png", "guide13.png"});
                    if (result.sim > 0.85f) {
                        gamePublicFunction.autoSkill();
                    } else if (mFairy.findPic2(comm.setImg("guide14.png")).sim > 0.85f) {
                        gamePublicFunction.autoEquipment();
                        comm.spot(57, 673, "返回", 1000);
                    }
                }
                result = mFairy.findPic2(57, 135, 110, 287, comm.setImg("thread.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "主线", 6000);
                    count = 0;
                    num++;
                }

                result = mFairy.findPic2(comm.setImg("adventure.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    num = 0;
                    gamePublicFunction.battle();
                }

                result = mFairy.findPic2(comm.setImg("dy.png"));
                if (result.sim > 0.85f) {
                    gamePublicFunction.fishing();
                    result = mFairy.findPic2(57, 135, 110, 287, comm.setImg("thread.png"));
                    comm.Click(0.85f, result, comm.getImg(), "钓鱼", 2000);
                }

                //判断选择副本时,是否出现BUG
                result = mFairy.findPic2(comm.setImg("mx1.png"));
                if (result.sim > 0.85f) {
                    result = mFairy.findPic2(26, 87, 1215, 483, comm.setImg("guide2.png"));
                    if (result.sim > 0.85f) {
                        LtLog.e(comm.getText("冒险引导"));
                        mFairy.tap(result.x, result.y + 80);
                        Thread.sleep(2000);
                    }
                    c++;
                    if (c > 2) {
                        comm.spot(51, 655, "返回", 1000);
                        c = 0;
                    }
                } else {
                    c = 0;
                }

                result = mFairy.findPic2(comm.setImg("goTo.png"));
                comm.Click(0.85f, result, comm.getImg(), "前往", 1000);

                result = mFairy.findPic2(comm.setImg("getInto.png"));
                comm.Click(0.85f, result, comm.getImg(), "前往", 2000);

                /*
                  关闭*/
                result = mFairy.findPic2(comm.setImg("ling1.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "领取獠牙初现", 1000);
                    comm.spot(1130, 198, "关闭", 1000);
                }
                /**
                 *  复活>>>
                 */
                result = mFairy.findPic2(comm.setImg("resurrection2.png"));
                if (result.sim > 0.9f) {
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic2(comm.setImg("resurrection.png"));
                        comm.Click(0.85f, result, comm.getImg(), "回城复活", 2000);

                        result = mFairy.findPic2(comm.setImg("fuhuo.png"));
                        comm.RndClick(0.85f,499,426,result,"取消勾玉复活",1000);

                        result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                        comm.RndClick(0.85f, 792, 424, result, "确定", 1000);
                    }
                    LtLog.e(comm.getText("玩家没有复活道具,结束当前角色"));
                    bj = 2;
                    battleFailure++;
                    continue;
                } else {
                    result = mFairy.findPic2(985, 461, 1208, 517, comm.setImg("fh.png"));
                    comm.Click(0.85f, result, comm.getImg(), "原地复活", 1000);
                }

                guide();//0.0

                result = mFairy.findPic2(comm.setImg("lu.png"));
                if (result.sim > 0.8f) {
                    num = 0;
                }

                /**
                 *   主线遇到BUG,返回主城>>>清理背包
                 */
                if (num > 10) {
                    gamePublicFunction.init("home.png");
                    while (true) {
                        result = mFairy.findPic2(comm.setImg("map2.png"));
                        if (result.sim > 0.85f) {
                            result = mFairy.findPic2(comm.setImg("map.png"));
                            comm.RndClick(0.85f, 1195, 649, result, "世界", 1000);

                            result = mFairy.findPic2(comm.setImg("map1.png"));
                            if (result.sim > 0.85f) {
                                comm.RndClick(0.85f, 862, 385, result, "神木", 1000);
                                break;
                            }
                        } else {
                            gamePublicFunction.init("home.png");
                            comm.spot(1241, 35, "地图", 3000);
                        }
                    }
                        gamePublicFunction.decompose(0);
                        gamePublicFunction.email();
                    num = 0;
                }
                count++;
                if (count > 20) {
                    result = mFairy.findPic2(comm.setImg("man.png"));
                    if (result.sim > 0.88f) {
                        LtLog.e(comm.getText("角色已达到满级,主线。 End!"));
                        bj = 2;
                        continue;
                    }
                    bj=0;
                    count=0;
                }
            }

            if (bj == 2) {
                if (AtFairyConfig.getOption("em").equals("1")) {
                    gamePublicFunction.decompose(0);
                    gamePublicFunction.email();
                }

                /*
                    签到领奖
                     */
                if (AtFairyConfig.getOption("qq").equals("1")) {
                    signIn();//签到
                }
                gamePublicFunction.init("home.png");

                if (gamePublicFunction.QH1 == 1 || gamePublicFunction.QH2 == 1 ||
                        gamePublicFunction.QH3 == 1 || gamePublicFunction.QH4 == 1 ||
                        gamePublicFunction.QH5 == 1 || gamePublicFunction.QH6 == 1 ||
                        gamePublicFunction.QH7 == 1) {
                    LtLog.e(comm.getText("开始切换角色>>>"));
                    gamePublicFunction.switchRoles();
                    bj = 0;
                    continue;
                } else {
                    LtLog.e(comm.getText("没有角色可以切换,End!"));
                    if (battleFailure > 0) {
                        return 6001;
                    }
                    return 0;
                }

            }


        }
    }//主线任务

    public void guide() throws Exception {

        result = mFairy.findPic2(comm.setImg("guide18.png"));
        if (result.sim > 0.85f) {
            result = mFairy.findPic2(comm.setImg("exit.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "退出", 2000);
                comm.spot(789, 427, "确定退出", 1000);
            }
        }

        result = mFairy.findPic2(comm.setImg("guide6.png"));
        if (result.sim > 0.85f) {
            result = mFairy.findPic2(57, 135, 110, 287, comm.setImg("thread.png"));
            comm.Click(0.85f, result, comm.getImg(), "主线", 2000);
            for (int i = 0; i < 5; i++) {
                comm.spot(1035, 562, "跳", 300);
            }
        }

        result = mFairy.findPic2(comm.setImg("guide11.png"));
        if (result.sim > 0.85f) {
            comm.RndClick(0.85f, 876, 555, result, "右边的职业", 6000);
            result = mFairy.findPic2(comm.setImg("shoppingMall4.png"));
            comm.Click(0.85f, result, comm.getImg(), "点击使用", 2000);
            gamePublicFunction.reward();//获得奖励
            gamePublicFunction.autoSkill();//自动点技能
            gamePublicFunction.autoEquipment();//自动装备
            if (AtFairyConfig.getOption("wqqh").equals("1")) {
                other.strengthenArms();
            }
        } else {
            /* 关闭*/
            result = mFairy.findPic2(comm.setImg("zhuang2.png"));
            if (result.sim > 0.85f) {
                comm.RndClick(0.85f, 437,322, result, "选择职业", 6000);
            }else {
                result = comm.arrayCompare(2f, 742, 0, 1277, 529, new String[]{"close1.png",});
                comm.arrayClick(0.85f, result, "关闭", 1000);
            }
        }

        result = mFairy.findPic2(comm.setImg("resurrection1.png"));
        comm.RndClick(0.85f, 792, 424, result, "确定", 1000);

        result = mFairy.findPic2(711, 462, 1037, 628, comm.setImg("shoppingMall4.png"));
        comm.Click(0.85f, result, comm.getImg(), "点击使用", 2000);

        gamePublicFunction.reward();

        result = mFairy.findPic2(comm.setImg("pickup.png"));
        comm.Click(0.85f, result, comm.getImg(), "拾取", 5000);

        result = mFairy.findPic2(comm.setImg("guide5.png"));
        comm.Click(0.85f, result, comm.getImg(), "更衣", 5000);

        result = mFairy.findPic2(comm.setImg("ling.png"));
        comm.Click(0.85f, result, comm.getImg(), "领奖", 1000);

        result = mFairy.findPic2(comm.setImg("fail.png"));
        comm.RndClick(0.85f, 1152, 602, result, "战斗失败", 1000);

        result = mFairy.findPic2(comm.setImg("gm.png"));
        comm.Click(0.85f, result, comm.getImg(), "购买", 1000);

        result = mFairy.findPic2(comm.setImg("leave.png"));
        comm.Click(0.85f, result, comm.getImg(), "离开", 1000);

        result = mFairy.findPic2(comm.setImg("guide16.png"));
        comm.Click(0.85f, result, comm.getImg(), "找老人", 1000);

        result = mFairy.findPic2(comm.setImg("ide1.png"));
        comm.RndClick(0.85f, 641, 485, result, "ide", 1000);

        result = mFairy.findPic2(comm.setImg("guide17.png"));
        comm.RndClick(0.85f, 1242, 51, result, "关闭", 1000);

        result = mFairy.findPic2(comm.setImg("guide1.png"));
        comm.RndClick(0.85f, 275, 346, result, "选择2.5D", 1000);

        result = mFairy.findPic2(comm.setImg("guide3.png"));
        comm.Click(0.85f, result, comm.getImg(), "给予", 1000);

        result = mFairy.findPic2(comm.setImg("guide7.png"));
        comm.Click(0.85f, result, comm.getImg(), "相机", 1000);

        result = mFairy.findPic2(comm.setImg("guide8.png"));
        comm.Click(0.85f, result, comm.getImg(), "相机", 1000);

        result = mFairy.findPic2(comm.setImg("fan.png"));
        comm.Click(0.85f, result, comm.getImg(), "关闭相机", 1000);

        result = mFairy.findPic2(comm.setImg("task.png"));
        comm.RndClick(0.85f, 35, 225, result, "任务", 1000);

        result = mFairy.findPic2(57, 122, 252, 490, comm.setImg("task1.png"));
        comm.Click(0.85f, result, comm.getImg(), "退出队伍", 1000);

        result = mFairy.findPic2(390, 249, 860, 386, comm.setImg("ranks.png"));
        comm.RndClick(0.85f, 788, 426, result, "确定退出队伍", 1000);

        result = mFairy.findPic2(comm.setImg("guide9.png"));
        comm.Click(0.85f, result, comm.getImg(), "领取转职任务", 1000);
    }//guide

    public void signIn() throws Exception {
        LtLog.e(comm.getText("***********************签到领奖***********************"));
        int count;
        int num;
        int title;
        gamePublicFunction.ranks(2);
        for (int f = 1; f <= 5; f++) {
            gamePublicFunction.init("home.png");
            count = 0;
            num = 0;
            title = 0;
            switch (f) {
                case 1:
                    while (true) {
                        result = mFairy.findPic2(935, 180, 1273, 259, comm.setImg("rw.png"));
                        if (result.sim > 0.95f) {
                            comm.Click(0.95f, result, comm.getImg(), "任务", 1000);
                        } else {
                            num++;
                            if (num > 10) {
                                break;
                            }
                        }
                        result = mFairy.findPic2(comm.setImg("rw1.png"));
                        if (result.sim > 0.85f) {
                            while (true) {
                                result = mFairy.findPic2(503, 136, 1184, 573, comm.setImg("rw2.png"));
                                if (result.sim > 0.88f) {
                                    comm.Click(0.88f, result, comm.getImg(), "领取", 1000);
                                    gamePublicFunction.reward();
                                    title++;
                                    if (title > 10) {
                                        LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                                        break;
                                    }
                                    count = 0;
                                } else {
                                    count++;
                                    if (count == 3 || count == 6) {
                                        comm.RanSwipe(695, 290, 758, 513, 2, 1000, 2000);
                                    } else if (count > 8) {
                                        break;
                                    }
                                }
                            }
                            for (int i = 0; i < 4; i++) {
                                int s = (int) (Math.random() * 500);

                                comm.spot(492 + (i * 208), 623, "点击", 2200 + s);

                                gamePublicFunction.reward();
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        result = mFairy.findPic2(600, 6, 1173, 169, comm.setImg("signIn.png"));
                        comm.Click(0.85f, result, comm.getImg(), "福利", 5000);
            /*
                月签到
             */
                        result = mFairy.findPic2(comm.setImg("sign1.png"));
                        if (result.sim > 0.85f) {
                            count = 0;
                            while (true) {
                                result = mFairy.findPic2(comm.setImg("sign3.png"));
                                if (result.sim > 0.85f) {
                                    comm.Click(0.85f, result, comm.getImg(), "领取", 2000);
                                    gamePublicFunction.reward();
                                } else {
                                    break;
                                }
                            }
                            while (true) {
                                result = mFairy.findPic2(360, 569, 1091, 693, comm.setImg("sign2.png"));
                                if (result.sim > 0.96f) {
                                    comm.Click(0.96f, result, comm.getImg(), "领取", 1500);
                                    gamePublicFunction.reward();
                                    count = 0;
                                } else {
                                    count++;
                                    if (count == 2) {
                                        comm.RanSwipe(472, 610, 1001, 648, 3, 1000, 2000);
                                    } else if (count > 3) {
                                        break;
                                    }
                                }
                            }
                        }
            /*
                白狐面具
             */
                        result = mFairy.findPic2(comm.setImg("sign4.png"));
                        if (result.sim > 0.85f) {
                            comm.spot(1147, 628, "开启", 8000);
                            for (int i = 0; i < 5; i++) {
                                    int s = (int) (Math.random() * 500);
                                    comm.spot(489 + (i * 144), 653, "点击" + (i + 1) + "个", 2200+s);
                                    gamePublicFunction.reward();
                            }
                        }

           /*
                在线好礼
             */         title=0;
                        result = mFairy.findPic2(comm.setImg("sign5.png"));
                        if (result.sim > 0.85f) {
                            while (true) {
                                result = mFairy.findPic2(comm.setImg("sign6.png"));
                                if (result.sim > 0.85f) {
                                    comm.Click(0.85f, result, comm.getImg(), "领取", 1500);
                                    title++;
                                    if (title > 6) {
                                        LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                                        return;
                                    }
                                } else {
                                    break;
                                }
                                gamePublicFunction.reward();
                            }
                        }

            /*
                升级礼包
             */
                        title = 0;
                        result = mFairy.findPic2(comm.setImg("sign7.png"));
                        if (result.sim > 0.85f) {
                            while (true) {
                                result = mFairy.findPic2(comm.setImg("sign6.png"));
                                if (result.sim > 0.85f) {
                                    comm.Click(0.85f, result, comm.getImg(), "领取", 1500);
                                    title++;
                                    if (title > 5) {
                                        LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                                        return;
                                    }
                                } else {
                                    break;
                                }
                                gamePublicFunction.reward();
                            }
                        }
            /*
                七日签到
             */
                        result = mFairy.findPic2(comm.setImg("sign8.png"));
                        if (result.sim > 0.85f) {
                            for (int j = 0; j < 7; j++) {
                                int n = (int) (Math.random() * 100);
                                comm.spot(439 + (j * 110), 300+n, "七日签到", 500);
                            }

                            Thread.sleep(1000);
                            gamePublicFunction.reward();
                        }


                        result = mFairy.findPic2(comm.setImg("signEnd.png"));
                        if (result.sim > 0.85f) {
                            LtLog.e(comm.getText("福利领取完毕"));
                            break;
                        } else {
                            comm.spot(210, 555, "下一个", 2000);
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        gamePublicFunction.task();

                        result = mFairy.findPic2(154, 137, 350, 430, comm.setImg("ling2.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "终", 1000);
                        } else {
                            count++;
                            if (count == 2) {
                                comm.RanSwipe(148, 169, 191, 275, 2, 1000, 2000);
                            } else if (count > 3) {
                                LtLog.e(comm.getText("没有最终奖励"));
                                break;
                            }
                        }
                        result = mFairy.findPic2(comm.setImg("ling3.png"));
                        comm.Click(0.85f, result, comm.getImg(), "领取", 1000);
                    }
                    break;
                case 4:
                    while (true) {
                        /*
                                找图标
                         */
                        result = mFairy.findPic2(616, 6, 1177, 198, comm.setImg("bt1.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "八天奖励", 2000);
                        } else {
                            count++;
                            if (count > 2) {
                                break;
                            }
                        }


                        result = mFairy.findPic2(comm.setImg("bt2.png"));
                        if (result.sim > 0.85f) {

                            int t =gamePublicFunction.btTools();

                            for (int i = t; i <= 8; i++) {
                                switch (i) {
                                    case 1:
                                        comm.spot(214, 220, "", 2000);
                                        break;
                                    case 2:
                                        comm.spot(444, 227, "", 2000);
                                        break;
                                    case 3:
                                        comm.spot(778, 220, "", 2000);
                                        break;
                                    case 4:
                                        comm.spot(1064, 220, "", 2000);
                                        break;
                                    case 5:
                                        comm.spot(207, 496, "", 2000);
                                        break;
                                    case 6:
                                        comm.spot(439, 485, "", 2000);
                                        break;
                                    case 7:
                                        comm.spot(671, 485, "", 2000);
                                        break;
                                    case 8:
                                        comm.spot(996, 485, "", 2000);
                                        break;
                                }

                                gamePublicFunction.reward();
                            }
                            break;
                        }
                    }
                    break;
                case 5:
                    int tq=0;
                    while (true) {
                        result = mFairy.findPic2(616, 6, 1177, 198, comm.setImg("tq.png"));
                        comm.Click(0.85f, result, comm.getImg(), "特权", 1000);

                        result = mFairy.findPic2(42, 650, 1236, 711, comm.setImg("tq1.png"));
                        comm.Click(0.85f, result, comm.getImg(), "开服活动", 1000);

                        result = mFairy.findPic2(comm.setImg("tq2.png"));
                        if (result.sim > 0.85f) {

                            for (int i = 0; i < 3; i++) {
                                comm.RanSwipe(473, 339, 510, 507, 0, 500, 200);
                            }
                            Thread.sleep(2200);
                                while (true) {
                                    result = mFairy.findPic2(1086, 258, 1240, 592, comm.setImg("tq4.png"));
                                    if (result.sim > 0.8f) {
                                        comm.Click(0.8f, result, comm.getImg(), "可领取", 2000);
                                    } else {
                                        result = mFairy.findPic2(529,257,572,574,comm.setImg("tq5.png"));
                                        if(result.sim>0.85f){
                                            mFairy.tap(result.x-50,result.y+25);
                                        }else{
                                            tq++;
                                            if(tq==2 || tq==4) {
                                                comm.RanSwipe(473, 339, 510, 507, 2, 500, 2000);
                                            }
                                            if(tq>5){
                                                break;
                                            }
                                        }
                                    }
                                    gamePublicFunction.reward();
                                }

                            for (int i = 1; i <= 5; i++) {
                                switch (i) {
                                    case 1:
                                        comm.spot(709, 214, "", 1000);
                                        break;
                                    case 2:
                                        comm.spot(807, 216, "", 1000);
                                        break;
                                    case 3:
                                        comm.spot(901, 216, "", 1000);
                                        break;
                                    case 4:
                                        comm.spot(1004, 214, "", 1000);
                                        break;
                                    case 5:
                                        comm.spot(1154, 214, "", 1000);
                                        break;
                                }

                                if(gamePublicFunction.reward()==false){
                                    break;
                                }
                            }
                            break;
                        }
                        count++;
                        if (count > 8) {
                            LtLog.e(comm.getText("没有找到开服活动!"));
                            break;
                        }
                    }
                    break;
            }

        }
    }//签到

    public int batt() throws Exception {
        gamePublicFunction.init("home.png");
        while (true) {
            result = mFairy.findPic2(916, 158, 1279, 253, comm.setImg("batt.png"));
            comm.Click(0.85f, result, comm.getImg(), "战斗", 1000);

            result = mFairy.findPic2(46, 108, 196, 475, comm.setImg("ym4.png"));
            comm.Click(0.85f, result, comm.getImg(), "阎魔之路", 2000);

            result = mFairy.findPic2(741, 134, 915, 184, comm.setImg("ym6.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "分类-阎魔", 2000);

                result = mFairy.findPic2(comm.setImg("ym5.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.setImg("阎魔任务已经没有次数啦,End!"));
                    return 0;
                } else {
                    LtLog.e(comm.setImg("开始进行阎魔任务>>>"));
                    return 1;
                }
            } else {
                comm.spot(839, 112, "选择", 1500);
            }

        }
    }//战斗阎魔任务查看

    public void ym() throws Exception {
        int bj = 0;
        int count = 0;
        while (true) {
            if (bj == 0) {
                gamePublicFunction.ranks(1);
                gamePublicFunction.matchingTarget("ym.png", "ym1.png", "ym2.png", "ym3.png");
                bj = 1;
            }
            if (bj == 1) {
                MatTime matTime1 = new MatTime(mFairy);
                MatTime matTime2 = new MatTime(mFairy);
                MatTime matTime3 = new MatTime(mFairy);
                MatTime matTime4 = new MatTime(mFairy);
                MatTime matTime5 = new MatTime(mFairy);
                while (true) {
                    comm.spot(1181, 620, "", 200);

                    result = mFairy.findPic2(442, 222, 860, 641, comm.setImg("go.png"));
                    LtLog.e(comm.getText("识别go sim：" + result.sim));
                    if (result.sim > 0.85f) {
                        count = 0;
                        gamePublicFunction.go1(result);//识别go图标
                    }

                    result = mFairy.findPic2(comm.setImg("exit.png"));
                    if (result.sim < 0.85f) {
                        count++;
                        if (count > 20) {
                            break;
                        }
                    }
                    result = mFairy.findPic2(comm.setImg("home.png"));
                    if (result.sim > 0.85f) {
                        break;
                    }

                    for (int i = 0; i < 2; i++) {
                        result = mFairy.findPic2(comm.setImg("pickup.png"));
                        comm.Click(0.85f, result, comm.getImg(), "拾取", 1000);
                        comm.Click(0.85f, result, comm.getImg(), "拾取", 2000);
                    }
                    for (int i = 0; i < 1; i++) {
                        long a1 = matTime1.mMatTime(1044, 636, 38, 38, 0.92);
                        if (a1 > 0) {
                            comm.spot(1067, 685, "Skill One", 1000);
                            break;
                        }
                        long a2 = matTime2.mMatTime(1027, 533, 31, 28, 0.92);
                        if (a2 > 0) {
                            comm.spot(1043, 520, "Skill Two", 1000);
                            break;
                        }
                        long a3 = matTime3.mMatTime(1086, 432, 35, 37, 0.92);
                        if (a3 > 0) {
                            comm.spot(1101, 431, "Skill Three", 1000);
                            break;
                        }
                        long a4 = matTime4.mMatTime(1198, 424, 39, 31, 0.92);
                        if (a4 > 0) {
                            comm.spot(1216, 436, "Skill Four", 1000);
                            break;
                        }
                        long a5 = matTime5.mMatTime(1198, 289, 40, 41, 0.98);
                        if (a5 > 0) {
                            comm.spot(1224, 354, "Skill Five", 1000);
                            break;
                        }
                    }
                }

                for (int i = 0; i < 3; i++) {
                    result = mFairy.findPic2(comm.setImg("fb.png"));
                    comm.Click(0.85f, result, comm.getImg(), "自动关闭", 1000);
                }
                bj = 2;
            }
            if (bj == 2) {
                gamePublicFunction.ranks(2);
                break;
            }
        }

    }//阎魔

    public int GameCopy() throws Exception {
        int battleFailure = 0;
        gamePublicFunction.switchRolesYools();
        while (true) {
            gamePublicFunction.decompose(1);

            if (AtFairyConfig.getOption("zdmq").equals("1")) {
                gamePublicFunction.autoMQ();//自动装备铭切
            }

            if (AtFairyConfig.getOption("zdzb").equals("1")) {
                gamePublicFunction.autoEquipment();//自动装备
            }

            if (AtFairyConfig.getOption("wqqh").equals("1")) {
                other.strengthenArms();//武器强化10次
            }
            if (AtFairyConfig.getOption("qq").equals("1")) {
                gamePublicFunction.hhf();
            }

            if ((AtFairyConfig.getOption("ym").equals("1"))) {
                LtLog.e(comm.getText("***********************阎魔之路***********************"));
                if (batt() == 1) {
                    ym();
                }
            }

            if ((AtFairyConfig.getOption("jue").equals("1"))) {
                LtLog.e(comm.getText("***********************觉醒任务***********************"));
                awaken();
            }

            if ((AtFairyConfig.getOption("hm").equals("1"))) {
                LtLog.e(comm.getText("***********************购买红魔票***********************"));
                hm();
            }
            gamePublicFunction.init("home.png");
            result = mFairy.findPic2(54, 68, 325, 120, comm.setImg("tl.png"));
            if (result.sim < 0.95f) {
                String str = AtFairyConfig.getOption("mx");
                if ((!str.equals(""))) {
                    LtLog.e(comm.getText("***********************冒险副本***********************"));
                    if (fb() == 1) {
                        battleFailure++;
                    }
                }
            }
            if (AtFairyConfig.getOption("qq").equals("1")) {
                signIn();//签到
            }

            if (AtFairyConfig.getOption("em").equals("1")) {
                gamePublicFunction.decompose(0);
                gamePublicFunction.email();
            }
            gamePublicFunction.init("home.png");

            if (gamePublicFunction.QH1 == 1 || gamePublicFunction.QH2 == 1 ||
                    gamePublicFunction.QH3 == 1 || gamePublicFunction.QH4 == 1 ||
                    gamePublicFunction.QH5 == 1 || gamePublicFunction.QH6 == 1 ||
                    gamePublicFunction.QH7 == 1) {
                LtLog.e(comm.getText("开始切换角色>>>"));
                gamePublicFunction.switchRoles();
            } else {
                LtLog.e(comm.getText("没有角色可以切换,End!"));
                if (battleFailure > 0) {
                    return 6001;
                }
                return 0;
            }
        }
    }//副本

    public int GameAbyss() throws Exception {
        int battleFailure = 0;
        gamePublicFunction.switchRolesYools();
        while (true) {
            if (abyss() == 6002) {
                battleFailure++;
            }
            if (AtFairyConfig.getOption("em").equals("1")) {
                for (int i = 0; i < 2; i++) {
                    gamePublicFunction.email();
                    gamePublicFunction.decompose(0);
                }
            }
            if (AtFairyConfig.getOption("qq").equals("1")) {
                signIn();//签到
            }
            gamePublicFunction.init("home.png");
            if (gamePublicFunction.QH1 == 1 || gamePublicFunction.QH2 == 1 ||
                    gamePublicFunction.QH3 == 1 || gamePublicFunction.QH4 == 1 ||
                    gamePublicFunction.QH5 == 1 || gamePublicFunction.QH6 == 1 ||
                    gamePublicFunction.QH7 == 1) {
                LtLog.e(comm.getText("开始切换角色>>>"));
                gamePublicFunction.switchRoles();
            } else {
                LtLog.e(comm.getText("没有角色可以切换,End!"));
                if (battleFailure > 0) {
                    return 6002;
                }
                return 0;
            }
        }
    }//游戏深渊

    public int fb() throws Exception {
        int bj = 0;
        int count = 0;
        int num=0;
        int chapter;
        while (true) {
            if (bj == 0) {
                gamePublicFunction.ranks(2);
                gamePublicFunction.init("home.png");
                bj = 1;
                count = 0;
            }
            if (bj == 1) {
                gamePublicFunction.chat();
                gamePublicFunction.task();
                result = mFairy.findPic2(920, 171, 1274, 263, comm.setImg("mx.png"));
                comm.Click(0.85f, result, comm.getImg(), "冒险", 3000);

                result = mFairy.findPic2(comm.setImg("mx1.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    chapter=gamePublicFunction.chapterTools();
                    /**
                     *  选择副本>>>
                     */
                    if(gamePublicFunction.fbChoice(chapter)==-1){
                        num++;
                        if(num>1){
                            LtLog.e("选择的副本多次没有找到,End!");
                            return 0;
                        }
                    }

                    result = comm.arrayCompare(2f, new String[]{"goTo.png", "getInto.png"});
                    comm.arrayClick(0.85f, result, "前往", 5000);
                }

                result = mFairy.findPic2(comm.setImg("tili.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足"));

                    if (AtFairyConfig.getOption("ssss").equals("1")) {

                        comm.spot(397, 357, "小份寿司", 2000);

                        result = mFairy.findPic2(comm.setImg("ssss.png"));
                        if (result.sim > 0.85f) {
                            while (true) {
                                result = mFairy.findPic2(comm.setImg("ssss.png"));
                                if (result.sim > 0.85f) {
                                    comm.Click(0.85f, result, comm.getImg(), "使用寿司", 700);
                                } else {
                                    break;
                                }
                            }
                        } else {
                            return 0;

                        }
                        comm.spot(927, 195, "关闭", 1000);
                    } else {
                        return 0;
                    }
                }

                result = mFairy.findPic2(comm.setImg("adventure.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    gamePublicFunction.battle();
                }
                /**
                 *  复活>>>
                 */
                result = mFairy.findPic2(comm.setImg("resurrection2.png"));
                if (result.sim > 0.95f) {
                    result = mFairy.findPic2(comm.setImg("resurrection.png"));
                    comm.Click(0.85f, result, comm.getImg(), "回城复活", 2000);

                    result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                    comm.RndClick(0.85f, 792, 424, result, "确定", 1000);

                    LtLog.e(comm.getText("玩家没有复活道具,结束当前角色"));
                    return 1;
                } else {
                    result = mFairy.findPic2(985, 461, 1208, 517, comm.setImg("fh.png"));
                    comm.Click(0.85f, result, comm.getImg(), "原地复活", 1000);
                }

                result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                comm.RndClick(0.85f, 792, 424, result, "确定", 1000);

                result = mFairy.findPic2(comm.setImg("fail.png"));
                comm.RndClick(0.85f, 1152, 602, result, "战斗失败", 1000);

                result = comm.arrayCompare(2f, 742, 0, 1277, 529, new String[]{"close1.png",});
                comm.arrayClick(0.85f, result, "关闭", 1000);

                result = mFairy.findPic2(comm.setImg("pickup.png"));
                comm.Click(0.85f, result, comm.getImg(), "拾取", 3000);

                result = mFairy.findPic2(comm.setImg("fb1.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.Click(0.85f, result, comm.getImg(), "再次挑战", 1500);
                    comm.spot(784, 430, "确定", 1000);
                }
                result = mFairy.findPic2(comm.setImg("ling1.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.Click(0.85f, result, comm.getImg(), "领取獠牙初现", 1000);
                    comm.spot(1130, 198, "关闭", 1000);
                }

                count++;
                if (count > 30) {
                    bj = 0;
                    count = 0;
                }

            }
        }
    }//副本

    public void awaken() throws Exception {
        int bj = 0;
        int count = 0;
        while (true) {
            LtLog.e(comm.getText("觉醒任务,bj :" + bj));
            if (bj == 0) {
                gamePublicFunction.ranks(2);
                gamePublicFunction.hhf();
                gamePublicFunction.init("home.png");
                bj = 1;
                count = 0;
            }
            if (bj == 1) {
                gamePublicFunction.chat();
                gamePublicFunction.task();
                gamePublicFunction.reward();

                result = mFairy.findPic2(69, 192, 169, 416, comm.setImg("awaken1.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "觉醒任务", 3000);
                    count = 0;
                }

                result = mFairy.findPic2(comm.setImg("adventure.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    gamePublicFunction.battle();
                }

                result = mFairy.findPic2(comm.setImg("awaken2.png"));
                comm.RndClick(0.85f, 783, 425, result, "确定前往觉醒", 1000);

                result = mFairy.findPic2(comm.setImg("awaken3.png"));
                comm.Click(0.85f, result, comm.getImg(), "领奖", 1000);

                result = mFairy.findPic2(comm.setImg("awaken4.png"));
                comm.Click(0.85f, result, comm.getImg(), "执意前往", 5000);


                result = mFairy.findPic2(comm.setImg("resurrection2.png"));
                if (result.sim > 0.95f) {
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic2(comm.setImg("resurrection.png"));
                        comm.Click(0.85f, result, comm.getImg(), "回城复活", 2000);

                        result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                        comm.RndClick(0.85f, 792, 424, result, "确定", 1000);
                    }
                    LtLog.e(comm.getText("觉醒副本战斗失败,End!"));
                    return;
                } else {
                    result = mFairy.findPic2(985, 461, 1208, 517, comm.setImg("fh.png"));
                    comm.Click(0.85f, result, comm.getImg(), "原地复活", 1000);
                }

                result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                comm.RndClick(0.85f, 792, 424, result, "确定", 1000);

                result = mFairy.findPic2(comm.setImg("leave.png"));
                comm.Click(0.85f, result, comm.getImg(), "离开", 1000);

                count++;
                Thread.sleep(1000);
                if (count == 6 || count == 8) {
                    comm.RanSwipe(148, 169, 191, 275, 2, 1000, 2000);
                }
                if (count > 9) {
                    LtLog.e(comm.getText("没有发现觉醒任务,End!"));
                    break;
                }
            }
        }
    }//觉醒

    public void flowerCards() throws Exception {
        int bj = 0, num = 1, err = 0;
        while (true) {
            if (bj == 0) {
                gamePublicFunction.ranks(2);
                gamePublicFunction.init("home.png");
                bj = 1;
            }
            if (bj == 1) {
                err++;
                if (err > 80) {
                    err = 0;
                    bj = 0;
                    continue;
                }
                result = mFairy.findPic2(365, 524, 781, 709, comm.setImg("sy.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "生涯", 1000);
                } else {
                    result = mFairy.findPic2(comm.setImg("home.png"));
                    comm.Click(0.85f, result, comm.getImg(), "切换", 1000);
                }

                result = mFairy.findPic2(comm.setImg("sy3.png"));
                if (result.sim > 0.85f) {
                    if (gamePublicFunction.huaPai(num) == 1) {
                        num++;
                    } else {
                        comm.spot(896, 524, "前往", 8000);
                    }

                } else {
                    result = mFairy.findPic2(comm.setImg("sy1.png"));
                    comm.RndClick(0.85f, 143, 303, result, "花牌", 1000);

                    result = mFairy.findPic2(1063, 106, 1155, 190, comm.setImg("sy2.png"));
                    comm.Click(0.85f, result, comm.getImg(), "花牌名人录", 1000);
                }
                result = mFairy.findPic2(960, 333, 1187, 535, comm.setImg("sy5.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "花牌挑战", 3000);
                    bj = 2;
                    err = 0;
                }
            }
            if (bj == 2) {

                err++;
                if (err > 50) {
                    err = 0;
                    bj = 0;
                    continue;
                }

                result = mFairy.findPic2(960, 333, 1187, 535, comm.setImg("sy5.png"));
                comm.Click(0.85f, result, comm.getImg(), "花牌挑战", 3000);

                result = mFairy.findPic2(comm.setImg("sy7.png"));
                if (result.sim > 0.85f) {

                    Mat mat;
                    for (int i = 0; i < 2; ) {
                        mat = mFairy.getScreenMat(559 + (i * 110), 636, 48, 56, 1, 0, 0, 1);
                        Mat mat1 = mFairy.getScreenMat(325, 151, 629, 421, 1, 0, 0, 1);
                        result = mFairy.matchMat(0, 0, mat, mat1);
                        if (result.sim > 0.85f) {
                            comm.spot(559 + (i * 110), 636, "发现相同的牌", 3500);
                            i = 0;
                            continue;
                        }
                        i++;
                    }
                    while (true) {
                        result = mFairy.findPic2(361, 161, 923, 559, comm.setImg("sy6.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "翻牌", 3000);
                        } else {
                            comm.spot(583, 650, "无法翻牌点击手牌", 1000);
                            comm.spot(696, 650, "无法翻牌点击手牌", 1000);
                        }
                        result = mFairy.findPic2(comm.setImg("sy7.png"));
                        if (result.sim < 0.85f) {
                            break;
                        }
                    }
                }
                result = mFairy.findPic2(comm.setImg("sy8.png"));
                comm.Click(0.85f, result, comm.getImg(), "继续", 3000);

                result = mFairy.findPic2(3, 618, 117, 717, comm.setImg("close3.png"));
                if (result.sim < 0.85f) {
                    err = 0;
                    gamePublicFunction.close();
                }

                result = mFairy.findPic2(comm.setImg("home.png"));
                if (result.sim > 0.85f) {
                    bj = 1;
                }
            }
        }
    }//花牌

    public void hm() throws Exception {
        int bj = 0;
        int count = 0;
        int count1 = 0;
        gamePublicFunction.ranks(2);
        while (true) {
            if (bj == 0) {
                result = mFairy.findPic2(comm.setImg("map2.png"));
                if (result.sim > 0.85f) {

                    result = mFairy.findPic2(comm.setImg("hm1.png"));
                    if (result.sim > 0.85f) {
                        bj = 1;
                        count = 0;
                        count1 = 0;
                        continue;
                    }
                    result = mFairy.findPic2(comm.setImg("map.png"));
                    comm.RndClick(0.85f, 1195, 649, result, "世界", 1000);

                    result = mFairy.findPic2(comm.setImg("map1.png"));
                    if (result.sim > 0.85f) {
                        comm.spot(509, 208, "出云", 200);
                        for (int i = 0; i < 10; i++) {
                            result = mFairy.findPic2(640, 56, 711, 260, comm.setImg("gq.png"));
                            if (result.sim > 0.85f) {
                                LtLog.e(comm.getText("没有开放出云地图,End!"));
                                return;
                            }
                        }
                    }

                } else {
                    gamePublicFunction.init("home.png");
                    comm.spot(1241, 35, "地图", 3000);
                }
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("hm1.png"));
                if (result.sim > 0.85f) {
                    comm.RndClick(0.85f, 623, 195, result, "黑子", 3000);
                    count = 0;
                    count1++;
                    if (count1 > 6) {
                        LtLog.e("人物等级不足");
                        return;
                    }
                }
                result = mFairy.findPic2(897, 286, 1242, 549, comm.setImg("hm2.png"));
                comm.Click(0.85f, result, comm.getImg(), "购买挑战凭证", 1000);

                result = mFairy.findPic2(comm.setImg("hm3.png"));
                if (result.sim > 0.85f) {
                    while (true) {
                        result = mFairy.findPic2(comm.setImg("hm4.png"));
                        if (result.sim > 0.85f) {
                            comm.spot(1141, 53, "关闭", 1000);
                            return;
                        } else {
                            comm.spot(1003, 615, "购买", 300);
                        }
                    }
                }
                count++;
                if (count > 10) {
                    bj = 0;
                    count = 0;
                }
            }
        }
    }//购买红魔票

    public int abyss() throws Exception {
        int bj = 0;
        int count = 0;
        String name ="ts4.png";

        if(AtFairyConfig.getOption("shen").equals("2")){
            name = "ts8.png";
        }

        while (true) {
            if (bj == 0) {
                gamePublicFunction.ranks(2);
                gamePublicFunction.hhf();
                gamePublicFunction.init("home.png");
                bj = 1;
                count = 0;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("mb3.png"));
                comm.RndClick(0.85f, 491, 426, result, "立刻前往-取消", 1000);

                result = comm.arrayCompare(2f, new String[]{"rank.png", "rank6.png"});
                comm.arrayClick(0.85f, result, "队伍", 1000);


                result = comm.arrayCompare(2f, new String[]{"rank4.png", "rank5.png", "rr.png"});
                if (result.sim > 0.85f) {
                    result = mFairy.findPic2(comm.setImg("rank3.png"));
                    comm.Click(0.85f, result, comm.getImg(), "退出队伍", 1000);
                }

                result = mFairy.findPic2(comm.setImg("ts2.png"));
                if (result.sim > 0.85f) {

                    result = mFairy.findPic2(99, 85, 317, 688, comm.setImg("ts3.png"));
                    comm.Click(0.85f, result, comm.getImg(), "魔界深渊", 2000);

                    result = mFairy.findPic2(99, 85, 317, 688, comm.setImg(name));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "魔界深渊", 2000);
                        for (int i = 0; i < 5; i++) {
                            result = mFairy.findPic2(983, 94 + (i * 110), 1178, 201 + (i * 110), comm.setImg("ts5.png"));
                            comm.Click(0.85f, result, comm.getImg(), "加入", 300);
                            for (int l = 0; l < 5; l++) {
                                result = mFairy.findPic2(503, 150, 559, 257, comm.setImg("ts.png"));
                                if (result.sim > 0.85f) {
                                    LtLog.e(comm.getText("钥匙不足,End!"));
                                    return 6002;
                                }
                            }
                        }




                        result = mFairy.findPic2(comm.setImg("mb6.png"));
                        if (result.sim < 0.85f) {
                            comm.spot(1096, 645, "刷新", 1000);
                        }
                    }
                }

                result = mFairy.findPic2(comm.setImg("mb6.png"));
                if (result.sim > 0.85f) {
                    bj = 2;
                    count = 0;
                }

                /*if (abyssRanks() == 1) {
                    LtLog.e(comm.getText("钥匙不足,无法"));
                    return 6002;
                }*/
            }

            if (bj == 2) {


                result = mFairy.findPic2(54, 68, 325, 120, comm.setImg("tl.png"));
                if (result.sim > 0.95f) {
                    gamePublicFunction.ranks(2);
                    return 0;
                }

                result = mFairy.findPic2(comm.setImg("ts6.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.Click(0.85f, result, comm.getImg(), "同意", 1000);
                }
                result = mFairy.findPic2(comm.setImg("exit.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    mFairy.touchDown(2, 199, 570);
                    mFairy.touchMove(2, 74, 480, 200);
                    //Thread.sleep(300);自己打
                    Thread.sleep(1000);

                    mFairy.touchUp(2);
                   /* result = mFairy.findPic2(comm.setImg("shen1.png"));
                    comm.Click(0.85f, result, comm.getImg(), "开启", 4000);*/
                    while (true) {
                        comm.spot(1181, 620, "", 200);

                        result = mFairy.findPic2(comm.setImg("exit.png"));
                        if (result.sim < 0.85f) {
                            break;
                        }
                        for (int i = 0; i < 2; i++) {
                            result = mFairy.findPic2(comm.setImg("pickup.png"));
                            comm.Click(0.85f, result, comm.getImg(), "拾取", 1000);
                            comm.Click(0.85f, result, comm.getImg(), "拾取", 2000);
                        }
                        comm.spot(1067, 685, "Skill One", 500);
                        comm.spot(1043, 520, "Skill Two", 500);
                        comm.spot(1101, 431, "Skill Three", 500);
                        comm.spot(1216, 436, "Skill Four", 500);
                    }
                }

                result = mFairy.findPic2(985, 461, 1208, 517, comm.setImg("fh.png"));
                comm.Click(0.85f, result, comm.getImg(), "原地复活", 1000);

                result = mFairy.findPic2(comm.setImg("ts7.png"));
                comm.Click(0.85f, result, comm.getImg(), "跳过奖励界面", 1000);

                result = mFairy.findPic2(comm.setImg("fail.png"));
                comm.RndClick(0.85f, 1152, 602, result, "战斗失败", 1000);

                result = mFairy.findPic2(comm.setImg("leave.png"));
                comm.Click(0.85f, result, comm.getImg(), "离开", 5000);

                gamePublicFunction.close();

                result = mFairy.findPic2(comm.setImg("mb3.png"));
                if (result.sim > 0.85f) {
                    comm.RndClick(0.85f, 491, 426, result, "立刻前往-取消", 1000);
                    bj = 1;
                }

                count++;
                if (count > 15) {
                    bj = 1;
                }
            }


            /*if (bj == 2) {
                result = mFairy.findPic2(comm.setImg("shen.png"));
                if (result.sim > 0.85f) {
                    comm.RndClick(0.85f, 925, 494, result, "前往", 3000);
                    count = 0;
                }

                result = mFairy.findPic2(comm.setImg("ts1.png"));
                if (result.sim > 0.85f) {
                    comm.spot(496, 430, "钥匙不足,无法", 1000);
                    return 6002;
                }

                result = mFairy.findPic2(comm.setImg("tili.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足"));
                    return 0;
                }

                result = mFairy.findPic2(comm.setImg("dr.png"));
                if (result.sim > 0.85f) {
                    comm.spot(497, 426, "单人-取消", 1000);
                    bj = 0;
                    continue;
                }

                result = mFairy.findPic2(comm.setImg("mb3.png"));
                comm.RndClick(0.85f, 788, 430, result, "整装待发", 3000);

                result = mFairy.findPic2(comm.setImg("exit.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    mFairy.touchDown(2, 199, 570);
                    mFairy.touchMove(2, 74, 480, 200);
                    //Thread.sleep(300);自己打
                    Thread.sleep(1000);

                    mFairy.touchUp(2);
                   *//* result = mFairy.findPic2(comm.setImg("shen1.png"));
                    comm.Click(0.85f, result, comm.getImg(), "开启", 4000);*//*
                    while (true) {
                        comm.spot(1181, 620, "", 200);

                        result = mFairy.findPic2(comm.setImg("exit.png"));
                        if (result.sim < 0.85f) {
                            break;
                        }
                        for (int i = 0; i < 2; i++) {
                            result = mFairy.findPic2(comm.setImg("pickup.png"));
                            comm.Click(0.85f, result, comm.getImg(), "拾取", 1000);
                            comm.Click(0.85f, result, comm.getImg(), "拾取", 2000);
                        }
                        comm.spot(1067, 685, "Skill One", 500);
                        comm.spot(1043, 520, "Skill Two", 500);
                        comm.spot(1101, 431, "Skill Three", 500);
                        comm.spot(1216, 436, "Skill Four", 500);
                    }
                } else {

                }

                result = mFairy.findPic2(comm.setImg("resurrection2.png"));
                if (result.sim > 0.95f) {

                    result = mFairy.findPic2(comm.setImg("resurrection.png"));
                    comm.Click(0.85f, result, comm.getImg(), "回城复活", 2000);

                    result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                    comm.RndClick(0.85f, 792, 424, result, "确定", 1000);

                    LtLog.e(comm.getText("玩家没有复活道具,结束当前角色"));
                    return 6001;
                } else {
                    result = mFairy.findPic2(985, 461, 1208, 517, comm.setImg("fh.png"));
                    comm.Click(0.85f, result, comm.getImg(), "原地复活", 1000);
                }

                result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                comm.RndClick(0.85f, 792, 424, result, "确定", 1000);

                result = mFairy.findPic2(comm.setImg("fail.png"));
                comm.RndClick(0.85f, 1152, 602, result, "战斗失败", 1000);

                result = comm.arrayCompare(2f, 742, 0, 1277, 529, new String[]{"close1.png",});
                comm.arrayClick(0.85f, result, "关闭", 1000);

                result = mFairy.findPic2(comm.setImg("leave.png"));
                comm.Click(0.85f, result, comm.getImg(), "离开", 5000);

                result = mFairy.findPic2(comm.setImg("ling1.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.Click(0.85f, result, comm.getImg(), "领取獠牙初现", 1000);
                    comm.spot(1130, 198, "关闭", 1000);
                }
                count++;
                if (count > 30) {
                    bj = 0;
                    count = 0;
                }
            }*/

        }

    }//深渊狂热者

    public int abyssRanks() throws Exception {
        int bj = 0;
        int err = 0;
        int num = 0;
        while (true) {
            if (bj == 0) {
                gamePublicFunction.init("home.png");
                bj = 1;
                err = 0;
                num = 0;
            }
            if (bj == 1) {
                result = comm.arrayCompare(2f, new String[]{"rank.png", "rank6.png"});
                comm.arrayClick(0.85f, result, "队伍", 1000);

                result = mFairy.findPic2(comm.setImg("kr.png"));
                if (result.sim < 0.85) {
                    result = mFairy.findPic2(comm.setImg("mb.png"));
                    if (result.sim > 0.85f) {
                        while (true) {
                            result = mFairy.findPic2(295, 224, 406, 538, comm.setImg("shen2.png"));
                            if (result.sim > 0.85f) {
                                comm.Click(0.85f, result, comm.getImg(), "img1", 2000);
                                num = 0;
                            }
                            result = mFairy.findPic2(301, 188, 600, 517, comm.setImg("shen3.png"));
                            if (result.sim > 0.85f) {
                                comm.Click(0.85f, result, comm.getImg(), "img2", 1500);
                                comm.spot(637, 560, "确定", 300);
                                for (int i = 0; i < 10; i++) {
                                    result = mFairy.findPic2(536, 161, 729, 238, comm.setImg("ts.png"));
                                    if (result.sim > 0.85f) {
                                        return 1;
                                    }
                                }
                                break;
                            }
                            result = mFairy.findPic2(comm.setImg("mb3.png"));
                            if (result.sim > 0.85f) {
                                comm.RndClick(0.85f, 788, 430, result, "整装待发", 3000);
                                break;
                            }
                            num++;
                            if (num > 5) {
                                comm.RanSwipe(432, 253, 477, 486, 2, 1000, 2000);
                                num = 0;
                            }
                        }
                    } else {
                        result = mFairy.findPic2(comm.setImg("rank3.png"));
                        comm.RndClick(0.85f, 131, 638, result, "更改目标", 1000);
                    }
                }

                result = mFairy.findPic2(comm.setImg("mb3.png"));
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 30; i++) {
                        result = mFairy.findPic2(comm.setImg("mb3.png"));
                        if (result.sim > 0.85f) {
                            comm.RndClick(0.85f, 788, 430, result, "整装待发", 3000);
                            i = 0;
                        }
                        result = mFairy.findPic2(comm.setImg("exit.png"));
                        if (result.sim > 0.85f) {
                            return 0;
                        } else {
                            bj = 0;
                        }
                        Thread.sleep(1000);
                    }
                }

                result = mFairy.findPic2(comm.setImg("exit.png"));
                if (result.sim > 0.85f) {
                    return 0;
                }
                result = mFairy.findPic2(comm.setImg("mb4.png"));
                if (result.sim > 0.85f) {
                    Thread.sleep(1000);
                    err = 0;
                    comm.spot(455, 586, "喊话1", 1000);
                    comm.spot(455, 545, "喊话2", 1000);
                    comm.spot(455, 503, "喊话3", 1000);
                } else {
                    result = mFairy.findPic2(421, 567, 511, 599, comm.setImg("mb5.png"));
                    if (result.sim < 0.85f) {
                        result = mFairy.findPic2(comm.setImg("mb6.png"));
                        comm.Click(0.85f, result, comm.getImg(), "喊话", 1000);
                    }
                    err++;
                    LtLog.e(comm.getText("err:" + err));
                    if (err > 100) {
                        bj = 0;
                        continue;
                    }
                }
                result = mFairy.findPic2(413, 285, 891, 363, comm.setImg("zdsq.png"));
                comm.RndClick(0.85f, 785, 426, result, "组队申请-同意", 1000);

                result = mFairy.findPic2(comm.setImg("exit.png"));
                if (result.sim > 0.85f) {
                    return 0;
                }
            }
        }
    }//深渊狂热者组队
    /*
        钓鱼
     */
    public void goFishing() throws Exception {
        int bj = 0, count = 0;
        while (true) {
            if (bj == 0) {
                goFishingMap();
                count = 0;
                bj = 1;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("dy3.png"));
                if (result.sim > 0.85f) {
                    for (int d = 0; d < 19; d++) {
                        comm.spot(766, 374, "+", 200);
                    }
                    comm.spot(637, 524, "购买", 2000);
                } else {
                    result = comm.arrayCompare(2f, 405, 233, 903, 623, new String[]{"dy.png", "dy1.png"});
                    if (result.sim > 0.85f) {
                        comm.arrayClick(0.85f, result, "钓鱼", 2000);
                    }
                }
                result = mFairy.findPic2(comm.setImg("shoppingMall4.png"));
                comm.Click(0.85f, result, comm.getImg(), "点击使用", 2000);

                gamePublicFunction.reward();
                count++;
                if (count > 30) {
                    break;
                }
            }
        }

    }//钓鱼

    public void goFishingMap() throws Exception {
        int dy;
        String str = AtFairyConfig.getOption("dy");
        if (str.equals("")) {
            dy = 1;
        } else {
            dy = Integer.parseInt(str);
        }
        gamePublicFunction.init("home.png");
        while (true) {
            result = mFairy.findPic2(comm.setImg("map2.png"));
            if (result.sim > 0.85f) {
                result = mFairy.findPic2(comm.setImg("map.png"));
                comm.RndClick(0.85f, 1195, 649, result, "世界", 1000);

                result = mFairy.findPic2(comm.setImg("map1.png"));
                if (result.sim > 0.85f) {
                    switch (dy) {
                        case 1:
                        case 2:
                        case 3:
                            comm.spot(862, 385, "神木", 1000);
                            break;
                        case 4:
                        case 5:
                        case 6:
                            comm.spot(1026, 458, "零川", 1000);
                            break;
                        case 7:
                        case 8:
                        case 9:
                            comm.spot(619, 340, "苇原", 1000);
                            break;
                        case 10:
                        case 11:
                        case 12:
                            comm.spot(509, 208, "出云", 1000);
                            break;
                        case 13:
                        case 14:
                        case 15:
                            comm.spot(351, 358, "登能", 1000);
                            break;
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            comm.spot(248, 86, "鬼野", 1000);
                            break;
                    }
                    break;
                }
            } else {
                gamePublicFunction.init("home.png");
                comm.spot(1241, 35, "地图", 3000);
            }
        }

        while (true) {
            result = mFairy.findPic2(comm.setImg("map2.png"));
            if (result.sim > 0.85f) {
                result = mFairy.findPic2(comm.setImg("map1.png"));
                comm.Click(0.85f, result, comm.getImg(), "当前", 2000);

                result = mFairy.findPic2(comm.setImg("map.png"));
                if (result.sim > 0.85f) {
                    switch (dy) {
                        case 1:
                            comm.spot(507, 384, "小黄鱼群", 1000);
                            break;
                        case 2:
                            comm.spot(703, 242, "秋刀鱼群", 1000);
                            break;
                        case 3:
                            comm.spot(575, 343, "鲤鱼群", 1000);
                            break;
                        case 4:
                            comm.spot(979, 388, "鲈鱼群", 1000);
                            break;
                        case 5:
                            comm.spot(704, 668, "鲶鱼群", 1000);
                            break;
                        case 6:
                            comm.spot(1089, 588, "螃蟹群", 1000);
                            break;
                        case 7:
                            comm.spot(429, 132, "沙丁鱼群", 1000);
                            break;
                        case 8:
                            comm.spot(342, 266, "青花鱼群", 1000);
                            break;
                        case 9:
                            comm.spot(567, 330, "带鱼群", 1000);
                            break;
                        case 10:
                            comm.spot(322, 458, "竹荚鱼群", 1000);
                            break;
                        case 11:
                            comm.spot(602, 267, "大马哈鱼群", 1000);
                            break;
                        case 12:
                            comm.spot(586, 309, "河虾群", 1000);
                            break;
                        case 13:
                            comm.spot(661, 457, "金枪鱼群", 1000);
                            break;
                        case 14:
                            comm.spot(646, 645, "鳗鱼群", 1000);
                            break;
                        case 15:
                            comm.spot(631, 324, "鳜鱼群", 1000);
                            break;
                        case 16:
                            comm.spot(477, 410, "冰窟1", 1000);
                            break;
                        case 17:
                            comm.spot(544, 486, "冰窟2", 1000);
                            break;
                        case 18:
                            comm.spot(395, 417, "冰窟3", 1000);
                            break;
                        case 19:
                            comm.spot(373, 449, "冰窟4", 1000);
                            break;
                    }
                    Thread.sleep(5000);
                    comm.spot(58, 670, "返回", 1000);
                    return;
                }
            } else {
                gamePublicFunction.init("home.png");
                comm.spot(1241, 35, "地图", 3000);
            }


        }
    }//钓鱼地图

    public List<String> test(int num) throws Exception {
        String newNum = "" + num;
        String z1;
        String x1;
        List<String> aaa = new ArrayList();
        List<String> list = new ArrayList();
        char[] n = newNum.toCharArray();
        for (char a : n) {
            String s = a + "";
            list.add(s);
        }
        int w = newNum.length() / 2;
        //获取范围最小值
        String str1 = "";
        for (int j = 0; j < w - 1; j++) {
            str1 = "1" + "0";
        }
        //获取范围最大值
        String str2 = "";
        for (int j = 0; j < w - 1; j++) {
            str2 = "9" + "9";
        }
        int in1 = Integer.parseInt(str1);
        int in2 = Integer.parseInt(str2);

        for (int z = in1; z < (in2 - in1); z++) {
            for (int x = in1; x < (in2 - in1); x++) {
                if (z * x == num) {
                    LtLog.e("两个数乘法成立>>>");
                    List<String> newList = new ArrayList(list);
                    List<String> list1 = new ArrayList();
                    z1 = z + "";
                    x1 = x + "";
                    LtLog.e("-----------------z1   :" + z1);
                    LtLog.e("-----------------x1   :" + x1);
                    LtLog.e("-----------------num  :" + num);
                    char[] n1 = z1.toCharArray();
                    for (char a : n1) {
                        String s = a + "";
                        list1.add(s);
                    }
                    char[] n2 = x1.toCharArray();
                    for (char a : n2) {
                        String s = a + "";
                        list1.add(s);
                    }
                    int v = 0;
                    for (int p = 0; p < newList.size(); ) {
                        for (int p1 = 0; p1 < list1.size(); ) {
                            if (newList.get(p).equals(list1.get(p1))) {
                                LtLog.e("*****************list>>   :" + newList.get(p) + "*****************list1>>   :" + list1.get(p1));
                                newList.remove(p);
                                list1.remove(p1);
                                p1 = 0;
                                p = 0;
                                v = 1;
                            } else {
                                p1++;
                            }
                        }
                        if (v == 1) {
                            p = 0;
                            v = 0;
                        } else {
                            p++;
                        }
                    }
                    if (newList.size() == 0) {
                        aaa.add(num + "=" + z1 + "*" + x1);
                    }
                }
            }
        }
        return aaa;
    }//test

}









