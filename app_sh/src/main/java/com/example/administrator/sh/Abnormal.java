package com.example.administrator.sh;


import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;

/**
 * Created by Administrator on 2018/3/13.
 */

public class Abnormal {
    //异常处理
    //监控线程
    sh mFairy;
    FindResult result;
    private CommonFunction comm;
    private GamePublicFunction gamePublicFunction;
    private String task_id;
    int id;
    public static int LOGIN = 0;

    public Abnormal(sh ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        LOGIN = 0;
    }

    public void error() throws Exception {
        long time_1;
        time_1 = System.currentTimeMillis();

        task_id = AtFairyConfig.getOption("task_id");
        if (task_id.equals("")) {
            id = 0;
        } else {
            id = Integer.parseInt(task_id);
        }


        while (true) {
            Thread.sleep(100);
            if ((System.currentTimeMillis() - time_1) > 300000) {
                LtLog.e(comm.getLineInfo("———————————————————————————————————————————————————————异常线程运行中"));
                time_1 = System.currentTimeMillis();
            }
            pub();
            battleMethod();

        }

    }

    public void battleMethod() throws Exception {
        MatTime matTime1 = new MatTime(mFairy);
        MatTime matTime2 = new MatTime(mFairy);
        MatTime matTime3 = new MatTime(mFairy);
        MatTime matTime4 = new MatTime(mFairy);
        MatTime matTime5 = new MatTime(mFairy);
        int num = 0;
        while (true) {
            result = mFairy.findPic2(comm.setImg("adventure.png"));
            if (result.sim > 0.85f) {
                result = comm.arrayCompare(2f, new String[]{"xue1.png", "xue2.png"});
                if (result.sim < 0.85) {
                    result = mFairy.findPic2(comm.setImg("xue.png"));
                    comm.RndClick(0.85f, 913, 474, result, "err血量不足使用药品", 20);
                }
                result = mFairy.findPic2(comm.setImg("n.png"));
                comm.Click(0.85f, result, comm.getImg(), "err怒气", 200);


                result = comm.arrayCompare(2f, new String[]{"zu.png", "zu1.png"});
                if (result.sim > 0.85f) {
                    for (int i = 0; i < 1; i++) {

                        result = mFairy.findPic2(comm.setImg("zu.png"));
                        if (result.sim > 0.85f) {
                            if (num > 2) {
                                for (int j = 0; j < 2; j++) {
                                    long a5 = matTime5.mMatTime(1198, 289, 40, 41, 0.9);
                                    LtLog.i("555555          " + a5);
                                    if (a5 > 0) {
                                        comm.spot(1224, 354, "Skill Five", 1000);
                                    }
                                }
                            }
                            num++;
                        } else {
                            long a5 = matTime5.mMatTime(1198, 289, 40, 41, 0.9);
                            LtLog.i("555555          " + a5);
                            if (a5 > 0) {
                                comm.spot(1224, 354, "Skill Five", 1000);
                            }
                        }




                        long a1 = matTime1.mMatTime(1044, 636, 38, 38, 0.9);
                        LtLog.i("111111          " + a1);
                        if (a1 > 0) {
                            comm.spot(1067, 685, "Skill One", 1000);
                            break;
                        }
                        long a2 = matTime2.mMatTime(1027, 533, 31, 28, 0.9);
                        LtLog.i("222222          " + a2);
                        if (a2 > 0) {
                            comm.spot(1043, 520, "Skill Two", 1000);
                            break;
                        }
                        long a3 = matTime3.mMatTime(1086, 432, 35, 37, 0.9);
                        LtLog.i("333333          " + a3);
                        if (a3 > 0) {
                            comm.spot(1101, 431, "Skill Three", 1000);
                            break;
                        }
                        long a4 = matTime4.mMatTime(1198, 424, 39, 31, 0.9);
                        LtLog.i("444444          " + a4);
                        if (a4 > 0) {
                            comm.spot(1216, 436, "Skill Four", 1000);
                            break;
                        }
                    }
                }

            }else{
                break;
            }
        }

    }//battle处理

    public void pub() throws Exception {

        result = mFairy.findPic2(comm.setImg("login.png"));
        if (result.sim > 0.85f) {
            Thread.sleep(60000);
            result = mFairy.findPic2(comm.setImg("login.png"));
            comm.Click(0.85f, result, comm.getImg(), "err登录", 1000);
        }

        result = mFairy.findPic2(comm.setImg("qqlogin.png"));
        if (result.sim > 0.85f) {
            Thread.sleep(60000);
            result = mFairy.findPic2(comm.setImg("qqlogin.png"));
            comm.Click(0.85f, result, comm.getImg(), "errQQ登录", 1000);
        }

        result = mFairy.findPic2(26,539,705,1268,comm.setImg("denglu.png"));
        if (result.sim > 0.85f) {
            Thread.sleep(60000);
            result = mFairy.findPic2(26,539,705,1268,comm.setImg("denglu.png"));
            comm.Click(0.85f, result, comm.getImg(), "errQQ登录", 1000);
        }

        result = mFairy.findPic2(comm.setImg("agreement.png"));
        if (result.sim > 0.85f) {
            result = mFairy.findPic2(comm.setImg("agreement.png"));
          //  comm.Click(0.85f, result, comm.getImg(), "err用户协议确定", 1000);
            comm.RndClick(0.85f, 783,441, result, "err用户协议", 1000);
        }


        result = mFairy.findPic2(711, 462, 1037, 628, comm.setImg("shoppingMall4.png"));
        comm.Click(0.85f, result, comm.getImg(), "点击使用", 1000);

        gamePublicFunction.reward();

        result = mFairy.findPic2(comm.setImg("err1.png"));
        comm.RndClick(0.85f, 55, 673, result, "err装备强化界面", 1000);

        result = mFairy.findPic2(comm.setImg("jia1.png"));
        comm.RndClick(0.85f, 55, 673, result, "err装备强化界面", 1000);

        result = mFairy.findPic2(comm.setImg("j.png"));
        comm.RndClick(0.85f, 1182, 602, result, "err神秘卷轴", 1000);

        result = mFairy.findPic2(comm.setImg("xl.png"));
        comm.RndClick(0.85f, 1049, 268, result, "err邪灵弹框", 1000);

        result = mFairy.findPic2(comm.setImg("ok.png"));
        comm.Click(0.85f, result, comm.getImg(), "err确定", 1000);

        result = mFairy.findPic2(comm.setImg("wz.png"));
        comm.Click(0.85f, result, comm.getImg(), "err我自己来", 1000);

        result = mFairy.findPic2(comm.setImg("hd.png"));
        comm.RndClick(0.85f, 1162, 587, result, "err获得ss", 1000);

        result = mFairy.findPic2(comm.setImg("zoomLeft.png"));
        comm.Click(0.95f, result, comm.getImg(), "err左侧缩放栏", 1000);

        result = mFairy.findPic2(comm.setImg("zoomLeft1.png"));
        comm.Click(0.95f, result, comm.getImg(), "err左侧缩放栏", 1000);

        result = mFairy.findPic2(comm.setImg("skip.png"));
        comm.Click(0.85f, result, comm.getImg(), "err跳过", 1000);

        result = mFairy.findPic2(comm.setImg("continue.png"));
        comm.Click(0.85f, result, comm.getImg(), "err继续", 1000);

        result = mFairy.findPic2(comm.setImg("hz.png"));
        comm.RndClick(0.85f, 789, 423, result, "err降低画质", 1000);

        result = mFairy.findPic2(comm.setImg("jx.png"));
        comm.Click(0.95f, result, comm.getImg(), "err继续", 1000);

        result = mFairy.findPic2(comm.setImg("sanb.png"));
        if (result.sim > 0.85f) {
            comm.spot(525, 465, "不再提醒", 500);
            comm.Click(0.85f, result, comm.getImg(), "领取", 1000);
        }
        result = mFairy.findPic2(comm.setImg("gg.png"));
        comm.RndClick(0.85f, 1146, 106, result, "err公告", 1000);

        result = mFairy.findPic2(comm.setImg("zdyq.png"));
        if (result.sim > 0.85f) {
            comm.spot(515, 388, "5分钟不在提醒>>>", 1000);
            comm.spot(510, 443, "返回", 1000);
        }
        result = mFairy.findPic2(comm.setImg("jz.png"));
        if (result.sim > 0.85f) {
            comm.spot(508, 380, "5分钟不在提醒>>>", 1000);
            comm.spot(492, 426, "取消", 1000);
        }

        if (LOGIN == 0) {
            result = mFairy.findPic2(comm.setImg("login2.png"));
            comm.Click(0.85f, result, comm.getImg(), "进入游戏", 1000);

            result = mFairy.findPic2(comm.setImg("create.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "创建角色", 8000);
                result = mFairy.findPic2(comm.setImg("create1.png"));
                if (result.sim > 0.85f) {
                    comm.spot(792, 654, "随机名字", 1000);
                    comm.spot(1137, 653, "进入游戏", 3000);
                }

            }
        }

        /**result = mFairy.findPic2(comm.setImg("resurrection.png"));
        if (result.sim > 0.85f) {
            GamePublicFunction.KZ = 1;
        }*/
    }
}
