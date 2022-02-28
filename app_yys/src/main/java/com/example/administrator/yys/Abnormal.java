package com.example.administrator.yys;


import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/3/13.
 */

public class Abnormal {
    //异常处理
    //监控线程
    yys mFairy;
    FindResult result;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;
    String task_id;
    int id;

    public Abnormal(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
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
        }

    }

    public void pub() throws Exception {

        result = mFairy.findPic2(comm.setImg("ts7.png"));
        comm.RndClick(0.85f, 326, 44, result, "获得奖励", 1000);

        result = mFairy.findPic2(326,182,896,396,comm.setImg("err1.png"));
        comm.RndClick(0.85f, 523,424, result, "关闭位置定位", 1000);

        result = mFairy.findPic2(comm.setImg("jq.png"));
        comm.Click(0.9f, result, comm.getImg(), "拒绝", 1000);

        result = mFairy.findPic2(comm.setImg("bz.png"));
        comm.RndClick(0.85f, 326, 44, result, "发现宝藏", 1000);

        result = mFairy.findPic2(comm.setImg("shibai.png"));
        comm.RndClick(0.85f, 1210, 618, result, "战斗失败", 1000);

        result = mFairy.findPic2(comm.setImg("xz.png"));
        comm.RndClick(0.85f, 470, 457, result, "取消下载插画", 1000);

        result = mFairy.findPic2(comm.setImg("login3.png"));
        comm.RndClick(0.85f,640,615, result,"login3_进入游戏", 1000);

        result = mFairy.findPic2(618,534,822,692,comm.setImg("login1.png"));
        comm.Click(0.85f, result, comm.getImg(), "login1_进入游戏", 1000);

        result = mFairy.findPic2(comm.setImg("erryp.png"));
        if(result.sim >0.8f) {
            comm.Click(0.8f, result, comm.getImg(), "err云派启动", 16000);
            comm.spot(652,310,"跳过动画",1000);
            comm.spot(652,310,"跳过动画",1000);
        }
    }
}
