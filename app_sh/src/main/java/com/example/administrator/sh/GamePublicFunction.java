package com.example.administrator.sh;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class GamePublicFunction {//公共方法
    sh mFairy;
    FindResult result;
    private CommonFunction comm;
    MatTime matTime;
    public static int X = 10;
    public static int Y = -50;
    public static int QH1 = 0, QH2 = 0, QH3 = 0, QH4 = 0, QH5 = 0, QH6 = 0,QH7=0;
    private long time;
    public int gox = 620;
    public int goy = 430;

    public GamePublicFunction(sh ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        matTime = new MatTime(mFairy);
        X = 10;
        Y = -10;
        QH1 = 0;
        QH2 = 0;
        QH3 = 0;
        QH4 = 0;
        QH5 = 0;
        QH6 = 0;
        QH7 = 0;
    }

    /*  公共方法
         */
    public void close() throws Exception {
        while (true) {
            result = comm.arrayCompare(2f, 742, 0, 1277, 529, new String[]{"close1.png", "close2.png", "close5.png"});
            if (result.sim > 0.85f) {
                comm.arrayClick(0.85f, result, "关闭", 1000);
            } else if (mFairy.findPic2(3, 618, 117, 717, comm.setImg("close3.png")).sim > 0.75f) {
                result = mFairy.findPic2(3, 618, 117, 717, comm.setImg("close3.png"));
                comm.Click(0.75f, result, comm.getImg(), "返回", 1000);
            } else {
                break;
            }
        }
    }//关闭

    public void chat() throws Exception {
        while (true) {
            result = mFairy.findPic2(comm.setImg("chat1.png"));
            comm.RndClick(0.85f, 1187, 628, result, "聊天", 1000);

            result = mFairy.findPic2(432, 632, 1256, 716, comm.setImg("chat.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "聊天", 1000);
            } else {
                break;
            }
        }
    }//聊天

    public int go(FindResult newResult) throws Exception {
        int count = 0;
        int x = (int) (Math.random() * 50) + 150;
        int y = (int) (Math.random() * 50) + 520;
        mFairy.touchDown(5, x, y);
        time = System.currentTimeMillis();
        while (true) {
            X = (newResult.x - gox) / 2;
            Y = (newResult.y - goy) / 2;
            mFairy.touchMove(5, x + X, y + Y, 200);

            /*if (KZ == 1) {
                mFairy.touchUp(5);
                return -1;
            }*/

            if (System.currentTimeMillis() - time > 5000) {
                break;
            }
            int i = (int) (Math.random() * 4);
            int num = (int) (Math.random() * 50);
            if (i == 2) {
                if (newResult.x < gox) {
                    comm.RanSwipe(791 + num, 244 + num, 900 + num, 271 + num, 3, 200 + num, 100 + num);
                }
                if (newResult.x > gox) {
                    comm.RanSwipe(791 + num, 244 + num, 900 + num, 271 + num, 1, 200 + num, 100 + num);
                }
            } else {
                comm.spot(950 + i, 662 + i, "跳", 500);
            }
            count++;
            if (count > 1) {
                comm.spot(1160 + num, 600 + num, "", 500);
                count = 0;
            }
            newResult = mFairy.findPic2(460, 255, 800, 625, comm.setImg("go.png"));
            LtLog.e(comm.getText("go  --------- " + result.sim));
            if (newResult.sim < 0.75f) {
                break;
            }
        }
        mFairy.touchUp(5);
        return 0;
    }//go

    public void go1(FindResult result) throws Exception {
        int count = 0;
        int num = (int) (Math.random() * 8);
        while (true) {
            X = (result.x - gox) / 2;
            Y = (result.y - goy) / 2;
            mFairy.touchDown(2, 199 + num, 570 - num);
            mFairy.touchMove(2, 199 + X, 570 + Y, 200);
            Thread.sleep(700);
            mFairy.touchUp(2);
            result = mFairy.findPic2(comm.setImg("resurrection.png"));
            if (result.sim > 0.85f) {
                break;
            }
            result = mFairy.findPic2(460, 255, 800, 625, comm.setImg("go.png"));
            if (result.sim < 0.8f) {
                break;
            }
            count++;
            int n = (int) (Math.random() * 30);
            if (count > 1) {
                comm.spot(1175 + n, 615 + n, "A", 300);
                count = 0;
            }
        }
    }//go1

    public void randomMovement(int count) throws Exception {

        if (count == 3) {
            LtLog.e(comm.getText("释放1技能,"));
            comm.spot(1067, 685, "Skill One", 1000);
        }
        if (count == 4) {
            LtLog.e(comm.getText("多次未识别到,记录滑,"));
            mFairy.touchDown(2, 198, 569);
            mFairy.touchMove(2, 198 + X, 569 + Y, 200);
            Thread.sleep(2200);
            mFairy.touchUp(2);
        }
        if (count == 5) {

            LtLog.e(comm.getText("多次未识别到,向右滑,"));
            mFairy.touchDown(2, 198, 569);
            mFairy.touchMove(2, 383, 568, 200);
            Thread.sleep(3000);
            mFairy.touchUp(2);

        }
        if (count == 6) {

            LtLog.e(comm.getText("多次未识别到,向上滑,"));
            mFairy.touchDown(2, 198, 569);
            mFairy.touchMove(2, 200, 398, 200);
            Thread.sleep(2200);
            mFairy.touchUp(2);
        }
        if (count == 7) {
            LtLog.e(comm.getText("多次未识别到,向左滑,"));
            mFairy.touchDown(2, 198, 569);
            mFairy.touchMove(2, 37, 522, 200);
            Thread.sleep(2200);
            mFairy.touchUp(2);
        }
        if (count == 8) {
            LtLog.e(comm.getText("多次未识别到,向下滑,"));
            mFairy.touchDown(2, 198, 569);
            mFairy.touchMove(2, 213, 678, 200);
            Thread.sleep(2200);
            mFairy.touchUp(2);
        }
    }//多次没有识别到,移动

    public void battle() throws Exception {
        int count = 0;
        int n = 0;
        while (true) {
            result = mFairy.findPic2(comm.setImg("fail1.png"));
            if (result.sim > 0.8f) {
                break;
            }

            result = mFairy.findPic2(460, 255, 800, 625, comm.setImg("go.png"));
            if (result.sim > 0.8f) {
                count = 0;
                go1(result);//识别go图标
            }
            result = comm.arrayCompare(2f, new String[]{"zu.png", "zu1.png"});
            if (result.sim < 0.85f) {
                count++;
                LtLog.e(comm.getText("count:" + count));
                if (count > 16) {
                    init("home.png");
                    LtLog.e("副本卡住>>>  End!");
                    break;
                }
                randomMovement(count);//移动
            }
            result = mFairy.findPic2(comm.setImg("exit.png"));
            if (result.sim > 0.85f) {
                int u = (int) (Math.random() * 5) + 5;
                int num = (int) (Math.random() * 30);
                for (int j = 0; j < u; j++) {
                    comm.spot(1175 + num, 615 + num, "", 300 + num);
                }
                n = 0;
            } else {
                n++;
                if (n > 1) {
                    return;
                }
            }
            result = mFairy.findPic2(comm.setImg("pickup.png"));
            if (result.sim > 0.7f) {
                comm.Click(0.7f, result, comm.getImg(), "拾取", 3000);
                break;
            }
            result = mFairy.findPic2(comm.setImg("guide4.png"));
            comm.RndClick(0.85f, 1230, 46, result, "关闭", 1000);
        }
    }//战斗

    public void fishing() throws Exception {
        for (int i = 0; i < 15; i++) {
            result = mFairy.findPic2(comm.setImg("dy.png"));
            comm.Click(0.85f, result, comm.getImg(), "钓鱼", 3000);

            result = mFairy.findPic2(534, 483, 749, 578, comm.setImg("dy2.png"));
            if (result.sim > 0.85f) {
                i = 0;
            }
            result = mFairy.findPic2(630, 198, 1062, 572, comm.setImg("dy1.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.93f, result, comm.getImg(), "上钩", 1000);
                for (int j = 0; j < 15; j++) {
                    result = mFairy.findPic2(57, 135, 110, 287, comm.setImg("thread.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "主线", 300);
                        break;
                    }
                }
            }
            result = mFairy.findPic2(comm.setImg("bait.png"));
            if (result.sim > 0.85f) {
                return;
            }

        }

    }//钓鱼

    public void init(String img) throws Exception {
        int num = 0;
        while (true) {
            close();
            chat();
            reward();
            result = mFairy.findPic2(comm.setImg("exit.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "退出", 2000);
                comm.spot(789, 427, "确定退出", 1000);
            }
            result = mFairy.findPic2(comm.setImg("package.png"));
            comm.Click(0.85f, result, comm.getImg(), "关闭包裹", 1000);

            result = mFairy.findPic2(comm.setImg("goodFriend.png"));
            comm.Click(0.85f, result, comm.getImg(), "err关闭好友", 1000);

            result = mFairy.findPic2(comm.setImg("guide1.png"));
            comm.RndClick(0.85f, 275, 346, result, "选择2.5D", 1000);

            result = mFairy.findPic2(300, 292, 696, 607, comm.setImg("qx1.png"));
            comm.Click(0.85f, result, comm.getImg(), "取消", 1000);

            result = mFairy.findPic2(256, 180, 644, 641, comm.setImg("qx.png"));
            comm.Click(0.85f, result, comm.getImg(), "包裹-取消", 1000);

            result = mFairy.findPic2(comm.setImg("awaken3.png"));
            comm.Click(0.85f, result, comm.getImg(), "领奖", 1000);

            result = mFairy.findPic2(comm.setImg("resurrection2.png"));
            if (result.sim > 0.95f) {
                for (int i = 0; i < 3; i++) {
                    result = mFairy.findPic2(comm.setImg("resurrection.png"));
                    comm.Click(0.85f, result, comm.getImg(), "回城复活", 2000);

                    result = mFairy.findPic2(comm.setImg("resurrection1.png"));
                    comm.RndClick(0.85f, 792, 424, result, "确定", 1000);
                }
                LtLog.e(comm.getText("玩家没有复活道具,结束当前角色"));
            } else {
                result = mFairy.findPic2(985, 461, 1208, 517, comm.setImg("fh.png"));
                comm.Click(0.85f, result, comm.getImg(), "原地复活", 1000);
            }


            result = mFairy.findPic2(comm.setImg("mb3.png"));
            if (result.sim > 0.85f) {
                comm.RndClick(0.85f, 491, 426, result, "立刻前往-取消", 1000);
            } else {
                result = mFairy.findPic2(comm.setImg(img));
                if (result.sim > 0.85f) {
                    break;
                } else {
                    num++;
                    if (num > 3) {
                        int s = (int) (Math.random() * 30);
                        comm.spot(1200 + (s * 2), 30, "init 点一下屏幕>>>", 1000);
                    }
                }
            }
        }
    }//初始化

    public void setUp() throws Exception {
        init("home.png");
        LtLog.e(comm.getText("开始设置游戏画面>>>"));
        result = mFairy.findPic2(comm.setImg("D.png"));
        if (result.sim > 0.85f) {
            comm.spot(303, 122, "2.5D", 1000);
        } else {
            comm.spot(354, 64, "设置画面", 1000);
            comm.spot(303, 122, "2.5D", 1000);
        }
        while (true) {
            result = mFairy.findPic2(comm.setImg("home.png"));
            comm.RndClick(0.85f, 56, 56, result, "点击头像", 1000);

            result = mFairy.findPic2(comm.setImg("setUp.png"));
            if(result.sim>0.85f){
                result = mFairy.findPic2(89,404,198,689,comm.setImg("setUp3.png"));
                comm.Click(0.85f, result, comm.getImg(), "音频设置", 1000);
            }


            result = mFairy.findPic2(comm.setImg("setUp1.png"));
            if (result.sim > 0.85f) {
                comm.spot(346, 208, "流畅画质", 2000);

                result = mFairy.findPic2(331, 305, 648, 336, comm.setImg("set.png"));
                if (result.sim > 0.85f) {
                    comm.RanSwipe(228, 322, result.x, result.y, 3, 1000, 2000);
                }
                result = mFairy.findPic2(331, 354, 646, 386, comm.setImg("set.png"));
                if (result.sim > 0.85f) {
                    comm.RanSwipe(228, 373, result.x, result.y, 3, 1000, 2000);
                }

                result = mFairy.findPic2(comm.setImg("set11.png"));
                if (result.sim > 0.85f) {
                    for (int j = 7; j <= 10; j++) {
                        result = mFairy.findPic2(comm.setImg("set" + j + ".png"));
                        comm.Click(0.85f, result, comm.getImg(), "set点击", 1000);
                    }
                    comm.spot(352, 471, "30帧", 1000);
                } else {
                    for (int j = 1; j <= 6; j++) {
                        result = mFairy.findPic2(comm.setImg("set" + j + ".png"));
                        comm.Click(0.85f, result, comm.getImg(), "set点击", 1000);
                    }
                }
                comm.spot(1112, 102, "分辨率", 2000);

                result = mFairy.findPic2(comm.setImg("setUp2.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "分辨设置-普通", 1000);
                    return;
                }
            }


        }
    }//设置

    public void decompose(int n) throws Exception {
        int num = 0;
        int title;
        for (int i = 1; i <= 5; i++) {
            if (AtFairyConfig.getOption("fen" + i).equals("1")) {
                num = 1;
            }
        }
        if (num == 1) {
            LtLog.e(comm.getText("开始清理包裹>>>"));

            int err = 0;
            title = 0;
            if (n == 1) {
                while (true) {
                    result = mFairy.findPic2(comm.setImg("package1.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "仓库", 2000);

                        result = mFairy.findPic2(comm.setImg("jj.png"));
                        if (result.sim > 0.85f) {
                            for (int i = 0; i < 2; ) {
                                comm.spot(524 + (i * 170), 63, "个人仓库", 500);
                                result = mFairy.findPic2(comm.setImg("package6.png"));
                                if (result.sim > 0.85f) {
                                    comm.Click(0.85f, result, comm.getImg(), "一键添加", 1000);
                                    i++;
                                } else {
                                    i = 0;
                                }
                                err++;
                                if (err > 30) {
                                    return;
                                }
                            }
                            comm.spot(809, 31, "关闭", 1000);
                            break;
                        }
                    } else {
                        pakageTools(1);
                        title++;
                        if (title > 5) {
                            LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                            return;
                        }
                    }
                }
            }


            title = 0;
            while (true) {
                result = mFairy.findPic2(comm.setImg("package1.png"));
                if (result.sim > 0.85f) {
                    comm.spot(900, 40, "装备", 2000);
                    comm.spot(1177, 617, "分解", 1000);
                } else {
                    pakageTools(1);
                    title++;
                    if (title > 5) {
                        LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                        return;
                    }
                }

                result = mFairy.findPic2(comm.setImg("package2.png"));
                if (result.sim > 0.85f) {
                    /*while (true) {
                        result = mFairy.findPic2(434, 111, 735, 142, comm.setImg("fen.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "√", 100);
                        } else {
                            break;
                        }
                    }*/

                    for (int i = 1; i <= 3; i++) {
                        if (AtFairyConfig.getOption("fen" + i).equals("1")) {
                            result = mFairy.findPic2(comm.setImg("fen" + i + ".png"));
                            comm.Click(0.85f, result, comm.getImg(), "勾选品质", 500);
                        } else {
                            result = mFairy.findPic2(comm.setImg("fe" + i + ".png"));
                            comm.Click(0.85f, result, comm.getImg(), "取消勾选勾选品质", 500);
                        }
                    }

                    result = mFairy.findPic2(comm.setImg("package3.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "分解", 2000);
                        comm.spot(785, 429, "确定", 2000);
                        reward();
                        break;
                    }
                }
            }

            title = 0;
            while (true) {
                result = mFairy.findPic2(comm.setImg("package1.png"));
                if (result.sim > 0.85f) {
                    comm.spot(1118, 37, "材料", 2000);
                    comm.spot(1173, 617, "分解-出售", 1000);
                } else {
                    pakageTools(1);
                    if (title > 5) {
                        LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                        return;
                    }
                }

                result = mFairy.findPic2(comm.setImg("package4.png"));
                if (result.sim > 0.85f) {
                    while (true) {
                        result = mFairy.findPic2(426, 61, 773, 143, comm.setImg("fen.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "√", 100);
                        } else {
                            break;
                        }
                    }
                    for (int i = 4; i <= 5; i++) {
                        if (AtFairyConfig.getOption("fen" + i).equals("1")) {
                            result = mFairy.findPic2(comm.setImg("fen" + i + ".png"));
                            comm.Click(0.85f, result, comm.getImg(), "出售物品", 500);
                        }
                    }

                    if (AtFairyConfig.getOption("suo").equals("1")) {
                        for (int i = 0; i < 4; i++) {
                            result = mFairy.findPic2(854, 165 + (90 * i), 1270, 255 + (90 * i), comm.setImg("qing.png"));
                            if (result.sim > 0.85f) {
                                break;
                            }
                            for (int j = 0; j < 5; j++) {
                                comm.spot(897 + (j * 82), 210 + (i * 90), "清理材料", 1000);
                                result = mFairy.findPic2(comm.setImg("ql.png"));
                                comm.Click(0.85f, result, comm.getImg(), "选择", 1000);
                            }
                        }
                    }


                    result = mFairy.findPic2(comm.setImg("package5.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "出售", 1000);
                        comm.spot(809, 31, "关闭", 1000);
                        break;
                    }

                }
            }//出售
        }
    }//清理背包

    public void fantuan() throws Exception {

        int title = 0;

        while (true) {
            result = mFairy.findPic2(comm.setImg("package1.png"));
            if (result.sim > 0.85f) {
                comm.spot(1225, 37, "消耗", 2000);
                for (int i = 0; i < 3; i++) {
                    result = mFairy.findPic2(847, 59, 1274, 616, comm.setImg("c.png"));
                    comm.Click(0.85f, result, comm.getImg(), "发现可以存入的物品", 1500);

                    result = mFairy.findPic2(comm.setImg("c1.png"));
                    comm.Click(0.85f, result, comm.getImg(), "装配", 1000);
                }
                break;
            } else {
                pakageTools(1);
                title++;
                if (title > 5) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }
            }
        }

    }//装备饭团

    public void autoUseProp() throws Exception {
        int title = 0;
        while (true) {
            result = mFairy.findPic2(comm.setImg("package1.png"));
            if (result.sim > 0.85f) {
                comm.spot(1225, 37, "消耗", 2000);
                for (int i = 0; i < 3; i++) {
                    result = mFairy.findPic2(847, 59, 1274, 616, comm.setImg("wu.png"));
                    comm.Click(0.85f, result, comm.getImg(), "发现武器盒子", 1500);

                    result = mFairy.findPic2(584, 140, 844, 573, comm.setImg("wu1.png"));
                    comm.Click(0.85f, result, comm.getImg(), "使用", 1000);
                }

                for (int i = 0; i < 3; i++) {
                    result = mFairy.findPic2(847, 59, 1274, 616, comm.setImg("dan1.png"));
                    comm.Click(0.85f, result, comm.getImg(), "发现黑蛋", 1500);

                    result = mFairy.findPic2(584, 140, 844, 573, comm.setImg("wu1.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "使用", 8000);
                        comm.spot(1185, 523, "", 1000);
                    }
                }
                break;
            } else {
                pakageTools(1);
                title++;
                if (title > 5) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }

            }
        }

    }//自动使用道具

    public void autoEquipment() throws Exception {
        LtLog.e(comm.getText("开始自动装备>>>"));
        int title = 0;
        int s = (int) (Math.random() * 50) + 150;
        while (true) {
            result = mFairy.findPic2(comm.setImg("zhuang1.png"));
            if (result.sim > 0.85f) {
                comm.spot(901, 669, "", 2000 + s);
                comm.spot(957, 74, "装备", 2000 + s);
                comm.spot(880, 125, "pve", 2000 + s);
                for (int i = 1; i <= 15; i++) {
                    if (autoEquipmentTools(i) == 1) {
                        return;
                    }
                    result = mFairy.findPic2(389, 18, 696, 503, comm.setImg("wu2.png"));
                    if (result.sim > 0.85f) {
                        result = mFairy.findPic2(result.x + 100, result.y - 30, result.x + 220, result.y + 58, comm.setImg("jian.png"));
                        if (result.sim < 0.92f) {
                            result = mFairy.findPic2(572, 269, 777, 709, comm.setImg("guide19.png"));
                            comm.Click(0.85f, result, comm.getImg(), "穿上", 2000);
                        }
                    } else {
                        result = mFairy.findPic2(431, 7, 657, 371, comm.setImg("qf.png"));
                        if (result.sim > 0.85f) {
                            result = mFairy.findPic2(result.x + 50, result.y - 22, result.x + 170, result.y + 35, comm.setImg("jian.png"));
                            if (result.sim < 0.92f) {
                                result = mFairy.findPic2(572, 269, 777, 709, comm.setImg("guide19.png"));
                                comm.Click(0.85f, result, comm.getImg(), "穿上", 2000);
                            }

                        }
                    }

                    result = mFairy.findPic2(661, 248, 919, 374, comm.setImg("bufu.png"));
                    if (result.sim > 0.85f) {
                        comm.RndClick(0.85f, 492, 428, result, "不符", 1000);
                    } else {
                        result = mFairy.findPic2(comm.setImg("zhuangOK.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "确定", 2000);
                            i--;
                        }
                    }

                }
                comm.spot(62, 670, "关闭装备界面", 1000);
                return;
            } else {
                pakageTools(2);
                title++;
                if (title > 5) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }
            }
        }

    }//自动装备

    public void autoSkill() throws Exception {
        while (true) {
            result = mFairy.findPic2(comm.setImg("jn1.png"));
            if (result.sim > 0.85f) {
                result = mFairy.findPic2(123, 535, 204, 625, comm.setImg("jn.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "推荐加点", 2000);
                    comm.spot(57, 673, "返回", 1000);
                    return;
                } else {
                    result = mFairy.findPic2(comm.setImg("jn3.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "重置", 2000);
                        comm.spot(787, 427, "确定", 2000);
                    }
                }
            } else {
                init("home.png");
                while (true) {
                    result = mFairy.findPic2(391, 509, 787, 625, comm.setImg("jn2.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "技能", 2000);
                        break;
                    } else {
                        result = mFairy.findPic2(comm.setImg("home.png"));
                        comm.Click(0.85f, result, comm.getImg(), "切换", 3000);
                    }
                }
            }
        }
    }//自动点技能

    public void email() throws Exception {
        while (true) {
            result = comm.arrayCompare(2f, 366, 544, 628, 646, new String[]{"email1.png", "email2.png"});
            if (result.sim > 0.85f) {
                comm.arrayClick(0.85f, result, "邮箱", 2000);
            } else {
                result = mFairy.findPic2(comm.setImg("home.png"));
                comm.Click(0.85f, result, comm.getImg(), "切换", 3000);
            }
            result = mFairy.findPic2(comm.setImg("email3.png"));
            if (result.sim > 0.85f) {
                comm.spot(35, 323, "邮箱", 1000);
            } else {
                init("home.png");
            }
            result = mFairy.findPic2(comm.setImg("email4.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "一键领取", 5000);
                reward();
                comm.spot(575, 365, "关闭邮件框", 1000);
                break;
            }
        }
    }//自动领邮箱

    public void newAutoSkill() throws Exception {
        int count = 0;
        int bj = 0;
        int num = 0;
        while (true) {
            if (bj == 0) {
                init("home.png");
                result = mFairy.findPic2(391, 509, 787, 625, comm.setImg("jn2.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "技能", 2000);
                } else {
                    result = mFairy.findPic2(comm.setImg("home.png"));
                    comm.Click(0.85f, result, comm.getImg(), "切换", 3000);
                }
                result = mFairy.findPic2(comm.setImg("jn1.png"));
                if (result.sim > 0.85f) {
                    bj = 1;
                    count = 0;
                }

            }

            if (bj == 1) {
                if (AtFairyConfig.getOption("jncz").equals("1")) {
                    for (int i = 0; i < 5; i++) {
                        result = mFairy.findPic2(comm.setImg("jn3.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "重置", 2000);
                            comm.spot(787, 427, "确定", 8000);
                            break;
                        }
                    }
                }
                for (int i = 0; i < 3; i++) {
                    comm.RanSwipe(228, 191, 261, 512, 0, 1000, 2000);
                }

                result = mFairy.findPic2(comm.setImg("jn1.png"));
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 10; ) {
                        if (i == 0) {
                            result = mFairy.findPic2(comm.setImg("njn1.png"));
                            if (result.sim > 0.8f) {
                                for (int d = 0; d < 4; d++) {
                                    comm.spot(result.x + 80, result.y, "one", 1000);
                                    result = mFairy.findPic2(comm.setImg("njn2.png"));
                                    if (result.sim > 0.85f) {
                                        while (true) {
                                            comm.arrayCompare(2f, 783, 562, 1272, 685, new String[]{
                                                    "njn3.png", "njn4.png"});
                                            comm.arrayClick(0.85f, result, "激活升级", 1000);

                                            comm.arrayCompare(2f, 782, 488, 1272, 714, new String[]{
                                                    "njn5.png"});
                                            if (result.sim > 0.85f) {
                                                i++;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                count++;
                                if (count == 2 || count == 4) {
                                    comm.RanSwipe(228, 191, 261, 512, 2, 1000, 2000);
                                }
                                if (count > 6) {
                                    bj = 0;
                                    break;
                                }
                            }
                        }


                    }


                }

            }
        }

    }//自动点技能

    public void autoMQ() throws Exception {
        LtLog.e(comm.getText("开始装备铭切>>>"));
        int count = 0;
        int num = 0;
        int title = 0;
        while (true) {
            result = mFairy.findPic2(comm.setImg("zhuang1.png"));
            if (result.sim > 0.85f) {
                comm.spot(997, 668, "铭切", 1000);
                while (true) {
                    int n = (int) (Math.random() * 30);
                    result = mFairy.findPic2(871, 45, 982, 636, comm.setImg("mq2.png"));
                    if (result.sim > 0.8f) {
                        mFairy.tap(result.x - 30 - n, result.y + 40 + n);
                        Thread.sleep(500);
                        LtLog.e(comm.getText("发现绿标"));
                    } else {
                        result = mFairy.findPic2(56, 90, 307, 628, comm.setImg("mq1.png"));
                        if (result.sim > 0.8f) {
                            mFairy.tap(result.x - 30 - n, result.y + 40 + n);
                            LtLog.e(comm.getText("发现红标"));
                            Thread.sleep(1000);
                        } else {
                            num++;
                            if (num > 5) {
                                break;
                            }
                        }
                    }
                    count++;
                    if (count > 50) {
                        break;
                    }
                }
                return;
            } else {
                pakageTools(2);
                title++;
                if (title > 5) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }
            }
        }
    }//自动装备铭切

    public int autoEquipmentTools(int i) throws Exception {
        if (i <= 5) {
            result = mFairy.findPic2(comm.setImg("zh1.png"));
            if (result.sim > 0.85f) {
                return 1;
            } else {
                comm.spot(871 + (91 * (i - 1)), 194, "第" + i + "个", 1500);
            }
        } else if (i > 5 && i <= 10) {
            result = mFairy.findPic2(comm.setImg("zh2.png"));
            if (result.sim > 0.85f) {
                return 1;
            } else {
                comm.spot(871 + (91 * (i - 6)), 287, "第" + i + "个", 1500);
            }
        } else {
            result = mFairy.findPic2(comm.setImg("zh3.png"));
            if (result.sim > 0.85f) {
                return 1;
            } else {
                comm.spot(871 + (91 * (i - 11)), 378, "第" + i + "个", 1500);
            }
        }
        return 0;
    }

    public void ranks(int type) throws Exception {
        init("home.png");
        int err = 0;
        while (true) {
            err++;
            if (err > 30) {
                init("home.png");
                err = 0;
            }
            result = comm.arrayCompare(2f, new String[]{"rank.png", "rank6.png"});
            comm.arrayClick(0.85f, result, "队伍", 1000);

            result = mFairy.findPic2(comm.setImg("mb3.png"));
            comm.RndClick(0.85f, 491, 426, result, "立刻前往-取消", 1000);
            switch (type) {
                case 1:
                    LtLog.e(comm.getText("带队>>>"));
                    result = mFairy.findPic2(comm.setImg("rank1.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "创建", 1000);
                        return;
                    }
                    result = comm.arrayCompare(2f, new String[]{"rank4.png", "rank5.png", "rr.png"});
                    if (result.sim > 0.85f) {
                        result = mFairy.findPic2(comm.setImg("mb.png"));
                        if (result.sim > 0.85f) {
                            for (int i = 0; i < 20; i++) {
                                result = comm.arrayCompare(2f, new String[]{"mb1.png", "mb2.png"});
                                if (result.sim > 0.85f) {
                                    comm.arrayClick(0.85f, result, "无目标", 1000);
                                    return;
                                } else {
                                    comm.RanSwipe(457, 200, 476, 483, 0, 1000, 2000);
                                }
                            }
                        } else {
                            result = mFairy.findPic2(comm.setImg("rank3.png"));
                            comm.RndClick(0.85f, 131, 638, result, "更改目标", 1000);
                        }
                    }
                    result = mFairy.findPic2(comm.setImg("rank2.png"));
                    if (result.sim > 0.85f) {
                        result = mFairy.findPic2(comm.setImg("rank3.png"));
                        comm.Click(0.85f, result, comm.getImg(), "退出队伍", 1000);
                    }

                    break;
                case 2:
                    LtLog.e(comm.getText("单人>>>"));
                    result = mFairy.findPic2(comm.setImg("rank1.png"));
                    if (result.sim > 0.85f) {
                        return;
                    }
                    result = mFairy.findPic2(comm.setImg("rank3.png"));
                    if (result.sim > 0.85f) {
                        comm.Click(0.85f, result, comm.getImg(), "退出队伍", 1000);
                        return;
                    }
                    break;
            }
        }
    }//队伍

    public void matchingTarget(String img1, String img2, String img3, String img4) throws Exception {
        int bj = 0;
        int err = 0;
        int count = 0;
        while (true) {
            if (bj == 0) {
                init("home.png");
                bj = 1;
                err = 0;
                count = 0;
            }
            if (bj == 1) {
                result = comm.arrayCompare(2f, new String[]{"rank.png", "rank6.png"});
                comm.arrayClick(0.85f, result, "队伍", 1000);

                result = mFairy.findPic2(comm.setImg("mb.png"));
                if (result.sim > 0.85f) {
                    while (true) {
                        result = mFairy.findPic2(295, 224, 406, 538, comm.setImg(img1));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "img1", 2000);
                            count = 0;
                        }
                        result = mFairy.findPic2(371, 221, 445, 523, comm.setImg(img2));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "img2", 1500);
                            comm.spot(637, 560, "确定", 1000);
                            break;
                        }

                        count++;
                        if (count > 5) {
                            comm.RanSwipe(432, 253, 477, 486, 2, 1000, 2000);
                            count = 0;
                        }
                    }
                    bj = 2;
                } else {
                    result = mFairy.findPic2(comm.setImg("rank3.png"));
                    comm.RndClick(0.85f, 131, 638, result, "更改目标", 1000);
                }

                result = mFairy.findPic2(comm.setImg("mb3.png"));
                if (result.sim > 0.85f) {
                    bj = 2;
                }
            }
            if (bj == 2) {
                result = comm.arrayCompare(2f, new String[]{"rank.png", "rank6.png"});
                comm.arrayClick(0.85f, result, "队伍", 1000);


                result = mFairy.findPic2(comm.setImg("rank5.png"));
                comm.Click(0.85f, result, comm.getImg(), "前往", 5000);


                result = mFairy.findPic2(comm.setImg("ym7.png"));
                if (result.sim > 0.85f) {
                    result = mFairy.findPic2(comm.setImg("ym10.png"));
                    if (result.sim < 0.85f) {
                        comm.spot(910, 635, "进入副本", 5000);
                    }
                }

                result = mFairy.findPic2(comm.setImg("mb3.png"));
                comm.RndClick(0.85f, 788, 430, result, "整装待发", 5000);

                result = mFairy.findPic2(comm.setImg("ym8.png"));
                comm.Click(0.85f, result, comm.getImg(), "", 1000);


                result = mFairy.findPic2(comm.setImg("xyf.png"));
                if (result.sim > 0.85f) {
                    comm.RndClick(0.85f, 643, 430, result, "信用分不足", 1000);
                    return;
                }
                result = mFairy.findPic2(comm.setImg("ym9.png"));
                if (result.sim > 0.85f) {
                    comm.RndClick(0.85f, 491, 418, result, "已达到60级无法获得奖励", 1000);
                    return;
                }

                /*result = mFairy.findPic2(comm.setImg("mb3.png"));
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 30; i++) {
                        result = mFairy.findPic2(comm.setImg("mb3.png"));
                        if (result.sim > 0.85f) {
                            comm.RndClick(0.85f, 788, 430, result, "整装待发", 1000);
                            i = 0;
                        }
                        result = mFairy.findPic2(comm.setImg("exit.png"));
                        if (result.sim > 0.85f) {
                            return;
                        } else {
                            bj = 0;
                        }
                        Thread.sleep(1000);
                    }
                }*/
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

                result = mFairy.findPic2(944, 279, 1204, 551, comm.setImg(img3));
                comm.Click(0.85f, result, comm.getImg(), "副本", 1000);

                result = mFairy.findPic2(944, 498, 1270, 685, comm.setImg(img4));
                comm.Click(0.85f, result, comm.getImg(), "go", 1000);

                result = mFairy.findPic2(comm.setImg("exit.png"));
                if (result.sim > 0.85f) {
                    return;
                }
            }
        }
    }//匹配目标

    public void task() throws Exception {
        result = mFairy.findPic2(comm.setImg("rank.png"));
        comm.RndClick(0.9f, 35, 225, result, "任务", 1000);

    }//任务

    public void switchRoles() throws Exception {
        init("home.png");
        Abnormal.LOGIN = 1;
        while (true) {
            result = mFairy.findPic2(comm.setImg("home.png"));
            comm.RndClick(0.85f, 56, 56, result, "点击头像", 1000);

            result = mFairy.findPic2(comm.setImg("setUp.png"));
            if(result.sim>0.8f) {
                result = mFairy.findPic2(91,332,204,680,comm.setImg("setUp4.png"));
                comm.Click(0.85f, result, comm.getImg(), "基本设置", 2000);
            }
            result = mFairy.findPic2(comm.setImg("qh.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "切换角色", 2000);
                comm.spot(789, 425, "确定", 1000);
            }
            result = mFairy.findPic2(comm.setImg("qhUI.png"));
            if (result.sim > 0.85f) {
                if (QH1 == 1) {
                    comm.spot(83, 153, "", 1000);
                    comm.spot(83, 153, "角色1", 1000);
                    QH1 = 2;
                } else if (QH2 == 1) {
                    comm.spot(83, 245, "", 1000);
                    comm.spot(83, 245, "角色2", 1000);
                    QH2 = 2;
                } else if (QH3 == 1) {
                    comm.spot(83, 331, "", 1000);
                    comm.spot(83, 331, "角色3", 1000);
                    QH3 = 2;
                } else if (QH4 == 1) {
                    comm.spot(83, 427, "", 1000);
                    comm.spot(83, 427, "角色4", 1000);
                    QH4 = 2;
                } else if (QH5 == 1) {
                    comm.spot(83, 513, "", 1000);
                    comm.spot(83, 513, "角色5", 1000);
                    QH5 = 2;
                } else if (QH6 == 1 && QH7!=1) {
                    comm.RanSwipe(145, 221, 191, 482, 2, 500, 2000);
                    comm.spot(83, 513, "", 1000);
                    comm.spot(83, 513, "角色6", 1000);
                    QH6 = 2;
                }else if (QH6 == 1 && QH7==1) {
                    comm.RanSwipe(145, 221, 191, 482, 2, 500, 2000);
                    comm.spot(83, 426, "", 1000);
                    comm.spot(83, 426, "角色6", 1000);
                    QH6 = 2;
                }else if(QH7==1){
                    comm.RanSwipe(145, 221, 191, 482, 2, 500, 2000);
                    comm.spot(83, 513, "", 1000);
                    comm.spot(83, 513, "角色7", 1000);
                    QH7 = 2;

                }
                result = mFairy.findPic2(comm.setImg("login1.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "进入游戏", 2000);
                    Abnormal.LOGIN = 0;
                    break;
                }
            }

            result = mFairy.findPic2(comm.setImg("create.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "创建角色", 8000);
                while (true) {
                    result = mFairy.findPic2(comm.setImg("create1.png"));
                    if (result.sim > 0.85f) {
                        comm.spot(792, 654, "随机名字", 1000);
                        comm.spot(1137, 653, "进入游戏", 3000);
                    } else {
                        Abnormal.LOGIN = 0;
                        return;
                    }
                }
            }

        }
    }//切换角色

    public int stopJudge() throws Exception {
        FindResult result = mFairy.findPic2(comm.setImg("packages.png"));
        if (result.sim > 0.85f) {
            int colorNum = comm.getColorsNumber(888, 57, 298, 13, "239,141,77", 1);
            for (int i = 0; i <= 20; i++) {
                Thread.sleep(1000);
                int NewColorNum = comm.getColorsNumber(888, 57, 298, 13, "239,141,77", 1);
                if (NewColorNum != colorNum) {
                    return 0;
                }
                if (i == 20) {
                    return 1;
                }
            }
        }
        return 0;
    }//暂停判断

    public void switchRolesYools() throws Exception {

        if (QH1 == 0) {
            if (AtFairyConfig.getOption("qh1").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色1"));
                QH1 = 1;
            }
        }
        if (QH2 == 0) {
            if (AtFairyConfig.getOption("qh2").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色2"));
                QH2 = 1;
            }
        }
        if (QH3 == 0) {
            if (AtFairyConfig.getOption("qh3").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色3"));
                QH3 = 1;
            }
        }
        if (QH4 == 0) {
            if (AtFairyConfig.getOption("qh4").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色4"));
                QH4 = 1;
            }
        }
        if (QH5 == 0) {
            if (AtFairyConfig.getOption("qh5").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色5"));
                QH5 = 1;
            }
        }
        if (QH6 == 0) {
            if (AtFairyConfig.getOption("qh6").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色6"));
                QH6 = 1;
            }
        }
        if (QH7 == 0) {
            if (AtFairyConfig.getOption("qh7").equals("1")) {
                LtLog.e(comm.getText("玩家设置了角色7"));
                QH7 = 1;
            }
        }


    }//

    public int adventure(String img, String str) throws Exception {
        int count = 0;
        while (true) {
            result = mFairy.findPic2(906, 177, 1275, 262, comm.setImg("zd.png"));
            comm.Click(0.85f, result, comm.getImg(), "战斗", 1000);

            result = mFairy.findPic2(47, 114, 211, 641, comm.setImg(img));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), str, 1000);
                return 0;
            } else {
                count++;
                if (count == 3) {
                    comm.RanSwipe(83, 193, 137, 568, 2, 1000, 2000);
                } else if (count > 5) {
                    LtLog.e(comm.getText("战斗副本没有找到!"));
                    return 1;
                }
            }

        }
    }//冒险

    public boolean reward() throws Exception {
        result = mFairy.findPic2(comm.setImg("reward.png"));
        if (result.sim > 0.85f) {
            comm.RndClick(0.85f, 1152, 602, result, "获得奖励", 2000);
            return false;
        }
        return true;
    }//获得奖励

    public void hhf() throws Exception {
        int title = 0;
        if(title==0){
            return;
        }
        init("home.png");
        Thread.sleep(2000);
        result = mFairy.findPic2(811, 9, 1177, 99, comm.setImg("shoppingMall.png"));
        if (result.sim > 0.85f) {
            while (true) {
                result = mFairy.findPic2(811, 9, 1177, 99, comm.setImg("shoppingMall.png"));
                comm.Click(0.85f, result, comm.getImg(), "商城", 1000);

                result = mFairy.findPic2(comm.setImg("sc.png"));
                comm.Click(0.85f, result, comm.getImg(), "sc", 1000);

                result = mFairy.findPic2(comm.setImg("shoppingMall1.png"));
                comm.Click(0.85f, result, comm.getImg(), "消耗", 2000);

                result = mFairy.findPic2(comm.setImg("shoppingMall5.png"));
                if (result.sim > 0.85f) {
                    break;
                }
                result = mFairy.findPic2(comm.setImg("shoppingMall2.png"));
                comm.Click(0.85f, result, comm.getImg(), "回魂幡", 1000);

                result = mFairy.findPic2(comm.setImg("shoppingMall3.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "领取", 2000);
                    comm.spot(1226, 43, "关闭商城界面", 3000);
                    for (int i = 0; i < 8; i++) {
                        result = mFairy.findPic2(711, 462, 1037, 628, comm.setImg("shoppingMall4.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "点击使用", 2000);
                        } else {
                            break;
                        }
                    }
                    reward();//获得奖励

                    break;
                }
                title++;
                if (title > 50) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }
            }
        }

    }//领取免费回魂幡

    public int fbChoice(int chapter) throws Exception {
        int num, num1 = 1;
        int fb;
        int number;
        String str = AtFairyConfig.getOption("mx");
        if ((!str.equals(""))) {

            fb = Integer.parseInt(str);

            number = fbChapter(fb) - chapter;
            /**
             *  选择章节
             */
            if (number > 0) {
                for (int i = 0; i < number; i++) {
                    comm.spot(1240, 359, "下一章", 2000);
                }
            } else if (number < 0) {
                for (int i = 0; i > number; i--) {
                    comm.spot(29, 359, "上一章", 1000);
                }
            }
            /**
             *  选择副本
             */
            if (fb <= 5) {
                num = fb;
                fbChoiceTools(num);
            } else if (fb > 5 && fb <= 25) {
                num = fb % 5;
                fbChoiceTools(num);
            } else {
                fbChoiceTools2(fb);
            }

            result = mFairy.findPic2("men.png");
            if (result.sim > 0.85f) {
                String str1 = AtFairyConfig.getOption("nd");
                if ((!str1.equals(""))) {
                    num1 = Integer.parseInt(str1);
                } else {
                    LtLog.e(comm.getText("玩家没有勾选难度"));
                }

                switch (num1) {
                    case 1:
                        comm.spot(250, 268, "剧情", 1000);
                        break;
                    case 2:
                        comm.spot(250, 328, "无双", 1000);
                        break;
                    case 3:
                        comm.spot(250, 394, "剧情", 1000);
                        break;
                    case 4:
                        comm.spot(250, 462, "死狂", 1000);
                        break;
                }

                return 0;
            } else {
                LtLog.e(comm.getText("玩家没有勾选章节"));
            }

        }
        return -1;

    }//副本选择

    public void fbChoiceTools(int num) throws Exception {
        switch (num) {
            case 1:
                comm.spot(200, 398, "第" + num + "关", 2000);
                break;
            case 2:
                comm.spot(404, 247, "第" + num + "关", 2000);
                break;
            case 3:
                comm.spot(542, 483, "第" + num + "关", 2000);
                break;
            case 4:
                comm.spot(814, 399, "第" + num + "关", 2000);
                break;
            case 0:
            case 5:
                comm.spot(1089, 261, "第5关", 2000);
                break;
        }
    }//副本选择

    public void fbChoiceTools2(int num) throws Exception {
        switch (num) {
            case 26:
            case 33:
                comm.spot(200, 398, "第1关", 2000);
                break;
            case 27:
            case 34:
                comm.spot(399, 247, "第2关", 2000);
                break;
            case 28:
            case 35:
                comm.spot(539, 483, "第3关", 2000);
                break;
            case 29:
            case 36:
                comm.spot(689, 283, "第4关", 2000);
                break;
            case 30:
            case 37:
                comm.spot(874, 394, "第5关", 2000);
                break;
            case 31:
            case 38:
                comm.spot(1083, 253, "第6关", 2000);
                break;
            case 32:
            case 39:
                comm.spot(1166, 468, "第7关", 2000);
                break;
        }
    }//副本选择

    public int fbChapter(int fb) throws Exception {
        switch (fb) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 1;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return 2;
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 3;
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return 4;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                return 5;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return 6;
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
                return 7;
        }
        return -1;
    }//章节

    public int huaPai(int num) throws Exception {

        switch (num) {
            case 1:
                comm.spot(396, 296, "花牌角色", 2000);
                break;
            case 2:
                comm.spot(563, 303, "花牌角色", 2000);
                break;
            case 3:
                comm.spot(725, 306, "花牌角色", 2000);
                break;
            case 4:
                comm.spot(894, 310, "花牌角色", 2000);
                break;
            case 5:
                comm.RanSwipe(501, 285, 867, 327, 3, 1000, 2500);
                comm.spot(396, 296, "花牌角色", 2000);
                break;
            case 6:
                comm.RanSwipe(501, 285, 867, 327, 3, 1000, 2500);
                comm.spot(563, 303, "花牌角色", 2000);
                break;
            case 7:
                comm.RanSwipe(501, 285, 867, 327, 3, 1000, 2500);
                comm.spot(725, 306, "花牌角色", 2000);
                break;
        }
        result = mFairy.findPic2(comm.setImg("sy4.png"));
        if (result.sim > 0.85f) {
            return 1;
        }
        return 0;
    }//花牌

    public void pakageTools(int num) throws Exception {

        init("home.png");

        switch (num) {
            case 1:
                result = mFairy.findPic2(comm.setImg("packages.png"));
                if (result.sim > 0.8f) {
                    comm.Click(0.8f, result, comm.getImg(), "包裹", 2000);
                } else {
                    result = mFairy.findPic2(comm.setImg("home.png"));
                    comm.Click(0.85f, result, comm.getImg(), "切换", 3000);
                }
                break;
            case 2:
                result = mFairy.findPic2(391, 509, 787, 625, comm.setImg("zhuang.png"));
                if (result.sim > 0.75f) {
                    comm.Click(0.75f, result, comm.getImg(), "装备", 2000);
                } else {
                    result = mFairy.findPic2(comm.setImg("home.png"));
                    comm.Click(0.85f, result, comm.getImg(), "切换", 3000);
                }
                break;
        }

    }//包裹工具

    public int chapterTools() throws InterruptedException {
        for (int i = 1; i <= 7; i++) {
            result = mFairy.findPic2("zhang" + i + ".png");
            if (result.sim > 0.85f) {
                return i;
            }
        }
        return -1;
    }//返回章节标识

    public int btTools() throws InterruptedException {

        result = mFairy.findPic2(966, 442, 1178, 633, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 9;
        }

        result = mFairy.findPic2(645, 483, 779, 630, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 8;
        }

        result = mFairy.findPic2(420, 492, 553, 640, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 7;
        }
        result = mFairy.findPic2(189, 497, 324, 643, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 6;
        }
        result = mFairy.findPic2(1052, 248, 1185, 357, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 5;
        }
        result = mFairy.findPic2(788, 245, 948, 364, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 4;
        }
        result = mFairy.findPic2(436, 251, 552, 351, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 3;
        }
        result = mFairy.findPic2(207, 259, 314, 352, comm.setImg("bt3.png"));
        if (result.sim > 0.85) {
            return 2;
        }
        return 1;
    }//八天奖励验证

}
