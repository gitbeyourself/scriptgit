package com.example.administrator.yys;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TeamTask {//组队任务  带队 跟队
    yys mFairy;
    FindResult result;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;

    public TeamTask(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
    }
    /*
        组队任务,跟队
     */
    public void awaken(int type, int layer) throws Exception {
        int bj = 0;
        int count = 0;
        int newNum = 0;
        int num;
        int bool = 0;
        String cs = AtFairyConfig.getOption("cs");
        if (cs.equals("")) {
            num = 8;
        } else {
            num = Integer.parseInt(cs);
        }

        while (true) {
            LtLog.e(comm.getText("觉醒副本,bj:" + bj));
            if (bj == 0) {
                gamePublicFunction.init(61, 625, 897, 706, "task.png");
                if (AtFairyConfig.getOption("jxsb").equals("1")) {
                    gamePublicFunction.jc("sb.png", 1);
                }
                bj = 1;
                count = 0;
                bool = 1;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    if (AtFairyConfig.getOption("jxsb").equals("1")) {
                        gamePublicFunction.init(61, 625, 897, 706, "task.png");
                        gamePublicFunction.jc("sb.png", 2);
                    }
                    break;
                }

                result = mFairy.findPic2(208, 646, 884, 701, comm.setImg("task.png"));
                comm.Click(0.85f, result, comm.getImg(), "组队", 2000);

                result = mFairy.findPic2(comm.setImg("zd.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    awakenTool(type, layer);
                }

                gamePublicFunction.teamMethod();

                result = mFairy.findPic2(comm.setImg("jx4.png"));
                if (result.sim > 0.85f) {
                    if (num <= newNum) {
                        LtLog.e(comm.getText("达到次数要求,End"));
                        if (AtFairyConfig.getOption("jxsb").equals("1")) {
                            gamePublicFunction.init(61, 625, 897, 706, "task.png");
                            gamePublicFunction.jc("sb.png", 2);
                        }
                        break;
                    }
                    count = 0;
                    result = mFairy.findPic2(comm.setImg("go.png"));
                    if (result.sim > 0.95f) {
                        Thread.sleep(3000);
                        if (bool == 1) {
                            newNum++;
                        }
                        bool = 0;
                        comm.Click(0.95f, result, comm.getImg(), "开始", 3000);
                    }
                }
                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    bool = 1;
                    count = 0;
                }


                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }

        }


    }//觉醒副本

    public void awakenTool(int type, int layer) throws Exception {

        while (true) {
            result = mFairy.findPic2(214, 97, 320, 644, comm.setImg("zd" + type + ".png"));
            comm.Click(0.85f, result, comm.getImg(), "选择副本", 2500);

            result = comm.arrayCompare(2f, new String[]{"jx1.png"});
            if (result.sim > 0.85f) {
                break;
            }
        }
        gamePublicFunction.layerTools(layer);
    }//觉醒工具

    public void mitama(int layer) throws Exception {
        int bj = 0;
        int count = 0;
        while (true) {
            if (bj == 0) {
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                bj = 1;
                count = 0;
            }
            if (bj == 1) {
                result = mFairy.findPic2(2, 72, 1277, 284, comm.setImg("ts.png"));
                comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

                result = mFairy.findPic2(45, 611, 1026, 715, comm.setImg("yh1.png"));
                comm.Click(0.85f, result, comm.getImg(), "御魂", 1000);

                result = mFairy.findPic2(comm.setImg("yh2.png"));
                comm.RndClick(0.85f, 923, 368, result, "业原火", 2000);


                result = mFairy.findPic2(comm.setImg("yyh1.png"));
                if (result.sim > 0.85f) {
                    switch (layer) {
                        case 1:
                            comm.spot(421, 178, "贪之阵", 1000);
                            break;
                        case 2:
                            comm.spot(421, 277, "嗔之阵", 1000);
                            break;
                        case 3:
                            comm.spot(421, 373, "痴之阵", 1000);
                            break;
                    }

                    comm.spot(952, 501, "挑战", 500);
                    for (int i = 0; i < 5; i++) {
                        result = mFairy.findPic2(comm.setImg("yyhEnd.png"));
                        if (result.sim > 0.85f) {
                            LtLog.e(comm.getText("卷轴不足,End!"));
                            return;
                        }
                    }
                }

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                }
                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }
        }
    }//业原火

    public void mitamaShe(int type, int layer) throws Exception {
        int bj = 0;
        int count = 0;
        int newNum = 0;
        int num;
        int bool = 0;
        String cs = AtFairyConfig.getOption("cs");
        if (cs.equals("")) {
            num = 8;
        } else {
            num = Integer.parseInt(cs);
        }
        while (true) {
            LtLog.e(comm.getText("八岐大蛇,bj:" + bj));
            if (bj == 0) {
                gamePublicFunction.init(61, 625, 897, 706, "task.png");
                if (AtFairyConfig.getOption("dssb").equals("1")) {
                    gamePublicFunction.init(61, 625, 897, 706, "task.png");
                    gamePublicFunction.jc("sb1.png", 1);
                }
                bj = 1;
                count = 0;
                bool = 1;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    if (AtFairyConfig.getOption("dssb").equals("1")) {
                        gamePublicFunction.init(61, 625, 897, 706, "task.png");
                        gamePublicFunction.jc("sb1.png", 2);
                    }
                    break;
                }

                result = mFairy.findPic2(208, 646, 884, 701, comm.setImg("task.png"));
                comm.Click(0.85f, result, comm.getImg(), "组队", 2000);

                result = mFairy.findPic2(comm.setImg("zd.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    gamePublicFunction.newLayerTools(type, layer);

                }

                gamePublicFunction.teamMethod();

                result = mFairy.findPic2(comm.setImg("jx4.png"));
                if (result.sim > 0.85f) {
                    if (num <= newNum) {
                        LtLog.e(comm.getText("达到次数要求,End"));
                        if (AtFairyConfig.getOption("dssb").equals("1")) {
                            gamePublicFunction.init(61, 625, 897, 706, "task.png");
                            gamePublicFunction.jc("sb1.png", 2);
                        }
                        break;
                    }
                    count = 0;
                    result = mFairy.findPic2(comm.setImg("go.png"));
                    if (result.sim > 0.95f) {
                        Thread.sleep(3000);
                        if (bool == 1) {
                            newNum++;
                        }
                        bool = 0;
                        comm.Click(0.95f, result, comm.getImg(), "开始", 3000);
                    }
                }
                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    bool = 1;
                    count = 0;
                }

                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }

        }


    }//八岐大蛇

    public void DRmitamaShe(int layer) throws Exception {
        int bj = 0;
        int count = 0;
        int num;
        int newNum = 0;
        String cs = AtFairyConfig.getOption("cs");
        if (cs.equals("")) {
            num = 8;
        } else {
            num = Integer.parseInt(cs);
        }
        while (true) {
            if (bj == 0) {
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                if (AtFairyConfig.getOption("dssb").equals("1")) {
                    gamePublicFunction.init(61, 625, 897, 706, "task.png");
                    gamePublicFunction.jc("sb1.png", 1);
                }
                bj = 1;
                count = 0;
                newNum = 0;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    if (AtFairyConfig.getOption("dssb").equals("1")) {
                        gamePublicFunction.init(61, 625, 897, 706, "task.png");
                        gamePublicFunction.jc("sb1.png", 2);
                    }
                    break;
                }

                result = mFairy.findPic2(2, 72, 1277, 284, comm.setImg("ts.png"));
                comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

                result = mFairy.findPic2(45, 611, 1026, 715, comm.setImg("yh1.png"));
                comm.Click(0.85f, result, comm.getImg(), "御魂", 1000);

                result = mFairy.findPic2(comm.setImg("yh2.png"));
                comm.RndClick(0.85f, 391, 368, result, "八岐大蛇", 2000);

                result = mFairy.findPic2(comm.setImg("drs.png"));
                if (result.sim > 0.85f) {
                    if(newNum==0) {
                        for (int i = 0; i < 2; i++) {
                            comm.RanSwipe(411, 198, 447, 319, 0, 500,100);
                        }

                        Thread.sleep(2000);
                        switch (layer) {
                            case 1:
                                comm.spot(405, 174, layer + "层", 1000);
                                break;
                            case 2:
                                comm.spot(405, 246, layer + "层", 1000);
                                break;
                            case 3:
                                comm.spot(405, 320, layer + "层", 1000);
                                break;
                            case 4:
                                comm.spot(405, 399, layer + "层", 1000);
                                break;
                            case 5:
                                comm.RanSwipe(404,152,438,349, 2, 1000,2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs1.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 6:
                                comm.RanSwipe(404,152,438,349, 2, 1000,2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs2.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 7:
                                comm.RanSwipe(404,152,438,349, 2, 1000,2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs3.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 8:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(404, 152, 438, 349, 2, 500, 200);
                                }
                                Thread.sleep(2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs4.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 9:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(404, 152, 438, 349, 2, 500, 200);
                                }
                                Thread.sleep(2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs5.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 10:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(404, 152, 438, 349, 2, 500, 200);
                                }
                                Thread.sleep(2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs6.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 11:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(404, 152, 438, 349, 2, 500, 200);
                                }
                                Thread.sleep(2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs7.png"));
                                comm.Click(0.85f, result, comm.getImg(), "悲鸣", 1000);
                                break;
                        }
                    }
                    if (num <= newNum) {
                        LtLog.e(comm.getText("达到次数要求,End"));
                        if (AtFairyConfig.getOption("dssb").equals("1")) {
                            gamePublicFunction.init(61, 625, 897, 706, "task.png");
                            gamePublicFunction.jc("sb1.png", 2);
                        }
                        return;
                    }
                    newNum++;
                    comm.spot(952, 501, "挑战", 500);
                }

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                }
                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }
        }

    }//单人八岐大蛇

    public void theRoyalSpirit() throws Exception {
        int bj = 0;
        int count = 0;
        int num;
        String yl = AtFairyConfig.getOption("yl");
        if (yl.equals("")) {
            num = 8;
        } else {
            num = Integer.parseInt(yl);
        }
        int layer;
        String ylcs = AtFairyConfig.getOption("ylcs");
        if (ylcs.equals("")) {
            layer = 1;
        } else {
            layer = Integer.parseInt(ylcs);
        }
        while (true) {
            if (bj == 0) {
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                bj = 1;
                count = 0;
            }
            if (bj == 1) {
                result = mFairy.findPic2(2, 72, 1277, 284, comm.setImg("ts.png"));
                comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

                result = mFairy.findPic2(45, 611, 1026, 715, comm.setImg("yl1.png"));
                comm.Click(0.85f, result, comm.getImg(), "御魂", 1000);

                result = mFairy.findPic2(comm.setImg("yl2.png"));
                if (result.sim > 0.85f) {
                    switch (num) {
                        case 1:
                            comm.spot(231, 384, "神龙", 500);
                            break;
                        case 2:
                            comm.spot(515, 385, "白藏主", 500);
                            break;
                        case 3:
                            comm.spot(787, 373, "黑豹", 500);
                            break;
                        case 4:
                            comm.spot(1049, 380, "孔雀", 500);
                            break;
                    }
                    for (int i = 0; i < 5; i++) {
                        result = mFairy.findPic2(comm.setImg("ylEnd.png"));
                        if (result.sim > 0.85f) {
                            LtLog.e(comm.getText("没有到时间,End!"));
                            return;
                        }
                    }
                }
                result = mFairy.findPic2(comm.setImg("yh4.png"));
                if (result.sim > 0.85f) {
                    switch (layer) {
                        case 1:
                            comm.spot(403, 166, "一层", 2000);
                            break;
                        case 2:
                            comm.spot(403, 242, "二层", 2000);
                            break;
                        case 3:
                            comm.spot(403, 318, "三层", 2000);
                            break;
                    }

                    comm.spot(948, 499, "挑战", 500);
                    for (int i = 0; i < 5; i++) {
                        result = mFairy.findPic2(comm.setImg("ylEnd1.png"));
                        if (result.sim > 0.85f) {
                            LtLog.e(comm.getText("卷轴不足,End!"));
                            return;
                        }
                    }
                }

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                }
                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }
        }


    }//御灵

    public void sealSeal(int type) throws Exception {
        int num;
        String cs = AtFairyConfig.getOption("cs");
        if (cs.equals("")) {
            num = 8;
        } else {
            num = Integer.parseInt(cs);
        }
        int bool = 0;
        int newNum = 0;
        int bj = 0;
        int count = 0;
        while (true) {
            LtLog.e(comm.getText("妖气封印,bj:" + bj));
            LtLog.e(comm.getText("妖气封印,count:" + count));
            if (bj == 0) {
                gamePublicFunction.init(61, 625, 897, 706, "task.png");
                bj = 1;
                count = 0;
                bool = 0;
            }

            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    return;
                }

                result = mFairy.findPic2(208, 646, 884, 701, comm.setImg("task.png"));
                comm.Click(0.85f, result, comm.getImg(), "组队", 2000);

                result = mFairy.findPic2(comm.setImg("zd.png"));
                if (result.sim > 0.85f) {
                    if (num <= newNum) {
                        LtLog.e(comm.getText("达到次数要求,End"));
                        break;
                    }
                /*
                    先判断再滑动
                 */
                    result = mFairy.findPic2(comm.setImg("ing.png"));
                    if (result.sim >0.85f) {
                        count=0;
                    }else{
                        for (int j = 0; j < 2; j++) {
                            comm.RanSwipe(222, 188, 277, 527, 2, 1000,1000);
                        }
                        Thread.sleep(2000);
                        //选择副本
                        comm.spot(251, 166, "妖气封印", 3000);

                        for(int i=0;i<3;i++){
                            comm.RanSwipe(463, 216, 505, 555, 0, 1000,200);
                        }
                        Thread.sleep(2000);

                        result = comm.arrayCompare(2f, new String[]{"jx1.png"});
                        if (result.sim > 0.85f) {
                            gamePublicFunction.layerTools2(type);
                        }
                    }

                    result = mFairy.findPic2(comm.setImg("pp.png"));
                    if (result.sim > 0.85f) {
                        count = 0;
                        if (bool == 1) {
                            newNum++;
                        }
                        bool = 0;
                        comm.Click(0.85f, result, comm.getImg(), "自动匹配", 2000);
                    }
                }

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(comm.setImg("go.png"));
                comm.Click(0.95f, result, comm.getImg(), "开始", 3000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    bool = 1;
                    count = 0;
                }
                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    bj = 0;
                }
            }
        }


    }//妖气封印

    public void newAwaken(int jx,int layer)throws Exception{
        int bj = 0;
        int count = 0;
        int num;
        int newNum = 0;
        String cs = AtFairyConfig.getOption("cs");
        if (cs.equals("")) {
            num = 8;
        } else {
            num = Integer.parseInt(cs);
        }
        while (true) {
            if (bj == 0) {
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                if (AtFairyConfig.getOption("jxsb").equals("1")) {
                    gamePublicFunction.jc("sb.png", 1);
                }
                bj = 1;
                count = 0;
                newNum = 0;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    if (AtFairyConfig.getOption("jxsb").equals("1")) {
                        gamePublicFunction.init(61, 625, 897, 706, "task.png");
                        gamePublicFunction.jc("sb.png", 2);
                    }
                    break;
                }

                result = mFairy.findPic2(2, 72, 1277, 284, comm.setImg("ts.png"));
                comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

                result = mFairy.findPic2(45, 611, 1026, 715, comm.setImg("newjx1.png"));
                comm.Click(0.85f, result, comm.getImg(), "觉醒", 1000);

                result = mFairy.findPic2(comm.setImg("newjx2.png"));
                if(result.sim>0.85f){
                    switch (jx){
                        case 1:
                            comm.spot(254,363,"火麒麟",3000);
                            break;
                        case 2:
                            comm.spot(523,363,"风麒麟",3000);
                            break;
                        case 3:
                            comm.spot(791,363,"水麒麟",3000);
                            break;
                        case 4:
                            comm.spot(1066,363,"雷麒麟",3000);
                            break;
                    }
                }


                result = mFairy.findPic2(comm.setImg("newjx3.png"));
                if (result.sim > 0.85f) {
                    if(newNum==0) {
                        for (int i = 0; i < 2; i++) {
                            comm.RanSwipe(411, 198, 447, 319, 0, 1000,500);
                        }

                        Thread.sleep(2000);
                        switch (layer) {
                            case 1:
                                comm.spot(405, 174, layer + "层", 1000);
                                break;
                            case 2:
                                comm.spot(405, 246, layer + "层", 1000);
                                break;
                            case 3:
                                comm.spot(405, 320, layer + "层", 1000);
                                break;
                            case 4:
                                comm.spot(405, 399, layer + "层", 1000);
                                break;
                            case 5:
                                comm.RanSwipe(411, 198, 447, 319, 2, 1000,2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs1.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 6:
                                comm.RanSwipe(411, 198, 447, 319, 2, 1000,2000);
                                result = mFairy.findPic2(352, 111, 419, 413, comm.setImg("drs2.png"));
                                comm.Click(0.85f, result, comm.getImg(), layer + "层", 1000);
                                break;
                            case 7:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(411, 198, 447, 319, 2, 1000,500);
                                }
                                Thread.sleep(2000);
                                comm.spot(405, 174, layer + "层", 1000);
                                break;
                            case 8:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(411, 198, 447, 319, 2, 1000,500);
                                }
                                Thread.sleep(2000);
                                comm.spot(405, 246, layer + "层", 1000);
                                break;
                            case 9:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(411, 198, 447, 319, 2, 1000,500);
                                }
                                Thread.sleep(2000);
                                comm.spot(405, 320, layer + "层", 1000);
                                break;
                            case 10:
                                for (int i = 0; i < 2; i++) {
                                    comm.RanSwipe(411, 198, 447, 319, 2, 1000,500);
                                }
                                Thread.sleep(2000);
                                comm.spot(405, 399, layer + "层", 1000);
                                break;
                        }
                    }
                    if (num <= newNum) {
                        LtLog.e(comm.getText("达到次数要求,End"));
                        if (AtFairyConfig.getOption("jxsb").equals("1")) {
                            gamePublicFunction.init(61, 625, 897, 706, "task.png");
                            gamePublicFunction.jc("sb.png", 2);
                        }
                        return;
                    }
                    newNum++;
                    comm.spot(952, 501, "挑战", 500);
                }

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                }
                count++;
                Thread.sleep(2000);
                if (count > 20) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }
        }
    }//新觉醒副本

    public void explore(int zhang)throws Exception{
        int bj = 0;
        int count = 0,count1=0;
        int init=0;
        int err=0;
        while (true) {
            if (bj == 0) {
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                bj = 1;
                count = 0;
                count1=0;
                init=0;
                err=0;
            }
            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    return;
                }

                result = mFairy.findPic2(2, 72, 1277, 284, comm.setImg("ts.png"));
                comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

                result = mFairy.findPic2(comm.setImg("ts2.png"));
                if (result.sim > 0.85f) {
                    if(AtFairyConfig.getOption("tstype").equals("2")){
                        comm.spot(472,228,"选择困难类型",2000);
                    }else{
                        comm.spot(335,228,"选择普通类型",2000);
                    }
                    comm.spot(944,540,"探索",5000);
                }


                result = mFairy.findPic2(comm.setImg("ts1.png"));
                if (result.sim > 0.85f) {
                    if(init==0) {
                        for (int i = 0; i < 7; i++) {
                            comm.RanSwipe(1141, 251, 1189, 624, 0, 500, 200);
                        }
                        Thread.sleep(5000);
                        init=1;
                    }
                    if(exploreTools(zhang)){
                        count1++;
                        if(count1>3) {
                            bj = 0;
                            continue;
                        }
                    }
                }


                result = mFairy.findPic2(comm.setImg("ts3.png"));
                if (result.sim > 0.85f) {
                    result = mFairy.findPic2(33,104,1269,611,comm.setImg("ts5.png"));
                    comm.Click(0.85f, result, comm.getImg(), "boss", 5000);

                    result = mFairy.findPic2(33,104,1269,611,comm.setImg("ts4.png"));
                    if(result.sim>0.85f) {
                        count=0;
                        comm.Click(0.85f, result, comm.getImg(), "战斗", 5000);
                    }else{
                        count++;
                        err++;
                    }

                    if(count<13) {
                        if (count % 2 == 0) {
                            comm.RanSwipe(300, 178, 800, 230, 3, 1000, 3000);
                        }
                    }
                    if(count>13){
                        if (count % 2 == 0) {
                            comm.RanSwipe(300, 178, 800, 230, 1, 1000, 3000);
                        }
                    }
                    if(count >25){
                        count=0;
                    }

                    if(err>100){
                        LtLog.e(comm.getText("找不到战斗图标,End!"));
                        bj=0;
                        continue;
                    }
                }

                result = mFairy.findPic2(305,241,1025,712, comm.setImg("ts6.png"));
                comm.Click(0.8f, result, comm.getImg(), "宝箱", 3000);

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0; count1 = 0;
                }

            }
        }
    }//探索

    public boolean exploreTools(int num)throws Exception{
        int count=0;
        while (true){
            result = mFairy.findPic2(1092,164,1212,590,comm.setImg("tt"+num+".png"));
            if (result.sim > 0.85f) {
                mFairy.tap(result.x,result.y+12);
                Thread.sleep(3000);
                return false;
            }
            count++;
            if(count%3==0){
                comm.RanSwipe(1141,251,1189,624,2,500,3000);
            }
            if(count>22){
                LtLog.e(comm.getText("没有发现玩家选择的章节"));
                return true;
            }
        }

    }//探索选择章节

    public void followTeam()throws Exception{
        while (true){
            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if(result.sim>0.85f) {
                int numX  = (int) Math.random()*200;
                int numY  = (int) Math.random()*200;
                comm.RndClick(0.85f,result.x+numX,result.y-numY,result, "继续", 1000);

            }

            result = mFairy.findPic2(13,168,263,356,comm.setImg("js.png"));
            comm.Click(0.8f,result,comm.getImg(),"接受",1000);

            result = mFairy.findPic2(13, 168, 263, 356, comm.setImg("js.png"));
            if(result.sim>0.8f) {
                Thread.sleep(1500);
                result = mFairy.findPic2(13, 168, 263, 356, comm.setImg("js.png"));
                comm.Click(0.8f, result, comm.getImg(), "接受", 1000);
            }

            result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 1000);

            result = mFairy.findPic2(comm.setImg("qx.png"));
            comm.Click(0.85f, result, comm.getImg(), "取消", 1000);

            result = mFairy.findPic2(comm.setImg("tl.png"));
            if(result.sim>0.85f) {
                return;
            }
            result = comm.arrayCompare(0.85f,new String[]{
                    /*"qian1.png","y1.png",*/"z1.png",/*"yx1.png",*/"yx2.png"});
            comm.arrayClick(0.85f,result,"确定",1000);
        }
    }//跟队

    public void daidui()throws Exception{
        while (true){
            result = mFairy.findPic2(comm.setImg("tl.png"));
            if(result.sim>0.8f){
                LtLog.e("体力不足,End!");
                return;
            }

            result = mFairy.findPic2(comm.setImg("go.png"));
            if(result.sim>0.95f){
                Thread.sleep(3000);
                result = mFairy.findPic2(comm.setImg("go.png"));
                comm.Click(0.95f, result, comm.getImg(), "开始", 1000);
            }

            result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 1000);

            result = mFairy.findPic2(comm.setImg("qd.png"));
            comm.Click(0.9f, result, comm.getImg(), "继续邀请玩家", 1000);

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if(result.sim>0.85f) {
                int numX  = (int) Math.random()*200;
                int numY  = (int) Math.random()*200;
                comm.RndClick(0.85f,result.x+numX,result.y-numY,result, "继续", 1000);

            }

        }
    }//
}

