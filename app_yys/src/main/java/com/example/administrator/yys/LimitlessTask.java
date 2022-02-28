package com.example.administrator.yys;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {//无限任务

    yys mFairy;
    FindResult result;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;
    TimingActivity timingActivity;
    private int hour;
    private int week;

    public LimitlessTask(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }
    /*
        庭院挂机
        无限任务
     */
    public void Daze() throws Exception {
        long time1 = System.currentTimeMillis() - 3600001;//6min
        long time2 = System.currentTimeMillis() - 36000001;//60min
        long time3 = System.currentTimeMillis() - 21600001;//36min
        long time4 = System.currentTimeMillis() - 21600001;//36min
        int GO1=0;
        int GO2=0;
        while (true) {
            result = comm.arrayCompare(0.9f, 7, 309, 1276, 566, new String[]{"fan.png", "gy.png", "qian.png", "y.png", "z.png"});
            comm.arrayClick(0.9f, result, "纸人", 2000);

            result = mFairy.findPic2(comm.setImg("hd.png"));
            comm.RndClick(0.85f, 326, 44, result, "获得奖励", 1000);

            result = mFairy.findPic2(comm.setImg("djEnd.png"));
            comm.Click(0.85f,result,comm.getImg(),"斗技取消",1000);

            result = mFairy.findPic2(comm.setImg("qian2.png"));
            comm.RndClick(0.85f, 326, 44, result, "获得奖励", 1000);

            for (int i = 0; i < 3; i++) {
                result = comm.arrayCompare(0.85f, new String[]{"qian1.png", "y1.png", "z1.png"});
                if(result.sim >0.85f) {
                    comm.arrayClick(0.85f, result, "确定", 2000);
                }else{
//                    gamePublicFunction.init(61, 625, 897, 706, "task.png");
                    gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                }
            }

            //斗技
            if (AtFairyConfig.getOption("dj").equals("1")) {
                hour = comm.DateHour();
                if (hour == 12 || hour == 20 || hour == 13 || hour == 21) {
                    dj();
                }
            }
            //石距
            if (AtFairyConfig.getOption("fda").equals("1")) {
                if (System.currentTimeMillis() - time1 > 3600000) {
                    LtLog.e(comm.getText("***********************石距***********************"));
                    FuBen(1);
                    time1 = System.currentTimeMillis();
                }
            }
            //年兽
            if (AtFairyConfig.getOption("fdb").equals("1")) {
                if (System.currentTimeMillis() - time2 > 36000000) {
                    LtLog.e(comm.getText("***********************年兽***********************"));
                    FuBen(2);
                    time2 = System.currentTimeMillis();
                }
            }
            //金币妖怪
            if (AtFairyConfig.getOption("fdc").equals("1")) {
                if (System.currentTimeMillis() - time3 > 21600000) {
                    LtLog.e(comm.getText("***********************金币妖怪***********************"));
                    FuBen(3);
                    time3 = System.currentTimeMillis();
                }
            }
            //经验妖怪
            if (AtFairyConfig.getOption("fdd").equals("1")) {
                if (System.currentTimeMillis() - time4 > 21600000) {
                    LtLog.e(comm.getText("***********************经验妖怪***********************"));
                    FuBen(4);
                    time4 = System.currentTimeMillis();
                }
            }

            if(GO1==0){
                if (AtFairyConfig.getOption("fm").equals("1")) {
                    hour=comm.DateHour();
                    if(hour>=17 && hour<=22){
                        fm();
                        GO1=1;
                    }

                }
            }

            if(GO2==0){
                if (AtFairyConfig.getOption("ql").equals("1")) {
                    hour=comm.DateHour();
                    week=comm.Week();
                    if(week==1 || week==2 || week==3 || week==4){
                        if(hour>=19 && hour<=21){
                            GO2=1;
                        }
                    }
                }
            }
        }
    }

    public void FuBen(int i) throws Exception {
        int bj = 0;
        int num = 0;
        int count = 0;
        while (true) {
            LtLog.e(comm.getText("副本,bj:" + bj));
            LtLog.e(comm.getText("副本,count:" + count));
            if (bj == 0) {
                gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                bj = 1;
                count = 0;
            }

            if (bj == 1) {
                result = mFairy.findPic2(comm.setImg("tl.png"));
                if (result.sim > 0.85f) {
                    LtLog.e(comm.getText("体力不足,End!"));
                    gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                    return;
                }
                result = mFairy.findPic2(208, 646, 884, 701, comm.setImg("word create team.png"));
                if (result.sim > 0.85f) {
                    if (num == 0) {
                        comm.Click(0.85f, result, comm.getImg(), "组队", 2000);
                    } else {
                        return;
                    }

                }

//                result = mFairy.findPic2(comm.setImg("zd.png"));
                result = mFairy.findPic2(comm.setImg("word zd.png"));
                if (result.sim > 0.85f) {
                /*
                    先判断再滑动
                 */
//                    result = mFairy.findPic2(comm.setImg("ing.png"));
                    result = mFairy.findPic2(comm.setImg("word match ing.png"));
                    if (result.sim > 0.85f) {
                        count = 0;
                        LtLog.e(comm.getLineInfo("匹配中"));
                    } else {
                        for (int j = 0; j < 2; j++) {
                            comm.RanSwipe(222, 188, 277, 527, 2, 1000,500);
                            if (j == 1) {
                                Thread.sleep(3000);
                            }
                        }

                        //选择副本
                        switch (i) {
                            case 1:
                                comm.spot(251, 460, "石距", 3000);
                                break;
                            case 2:
                                comm.spot(251, 387, "年兽", 3000);
                                break;
                            case 3:
                                comm.spot(251, 311, "金币妖怪", 3000);
                                break;
                            case 4:
                                comm.spot(251, 240, "经验妖怪", 3000);
                                break;
                        }
                    }

                    //自动匹配
//                    result = mFairy.findPic2(comm.setImg("pp.png"));
                    result = mFairy.findPic2(comm.setImg("word auto.png"));
                    if (result.sim > 0.85f) {
                        count = 0;
                        comm.Click(0.85f, result, comm.getImg(), "自动匹配", 500);
                        for (int o = 0; o < 5; o++) {
                            result = mFairy.findPic2(comm.setImg("fdEnd.png"));
                            if (result.sim > 0.85f) {
                                LtLog.e(comm.getText("副本再冷却中..."));
                                return;
                            }

                        }
                        num = 1;
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
                    count = 0;
                    LtLog.e(comm.getLineInfo("战斗中。。"));
                }
                result = mFairy.findPic2(comm.setImg("bq.png"));
                if(result.sim >0.85f){
                    count=0;
                    LtLog.e(comm.getLineInfo("bq.png"));
                }
                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    bj = 0;
                }
            }
        }
    }//庭院发呆

    public void dj() throws Exception {
        int bj = 0;
        int count = 0;
        while (true) {
            LtLog.e(comm.getText("斗技,bj:" + bj));
            hour = comm.DateHour();
            if (hour == 14 || hour == 22) {
                LtLog.e(comm.getText("结束时间到了,End!"));
                return;
            }
            if (bj == 0) {
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                bj = 1;
                count = 0;

            }
            if (bj == 1) {
                result = mFairy.findPic2(61, 207, 1269, 396, comm.setImg("tz.png"));
                comm.Click(0.85f, result, comm.getImg(), "町中", 1000);

                result = mFairy.findPic2(984, 208, 1138, 332, comm.setImg("ty.png"));
                comm.RndClick(0.85f, 779, 173, result, "斗技", 1000);

                result = mFairy.findPic2(comm.setImg("djEnd.png"));
                comm.Click(0.85f, result, comm.getImg(), "取消斗技", 1000);

                result = mFairy.findPic2(comm.setImg("t.png"));
                comm.Click(0.85f, result, comm.getImg(), "战", 1000);

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    LtLog.e(comm.getLineInfo("fb.png"));
                }
                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }

            }
        }
    }//斗技

    public void fm()throws Exception{
        int bj=0,count=0;
        while (true){
            if(bj==0){
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                for(int i=0; i<3;i++){
                    comm.RanSwipe(242,273,800,339,1,1000,500);
                }
                bj=1;
                count=0;
            }
            if(bj==1){
                result=mFairy.findPic2(10,351,920,516,comm.setImg("fm1.png"));
                comm.Click(0.85f,result,comm.getImg(),"火曜",1000);

                result=mFairy.findPic2(223,161,1097,615,comm.setImg("fm4.png"));
                if(result.sim >0.85f){
                    comm.Click(0.85f,result,comm.getImg(),"逢魔",1000);
                }else{
                    result=mFairy.findPic2(comm.setImg("fm3.png"));
                    comm.Click(0.85f,result,comm.getImg(),"日常",1000);
                }

                result=mFairy.findPic2(comm.setImg("fm2.png"));
                comm.Click(0.85f,result,comm.getImg(),"前往",1000);


                result=mFairy.findPic2(comm.setImg("fm9.png"));
                comm.Click(0.85f,result,comm.getImg(),"答题",1000);

                result=mFairy.findPic2(comm.setImg("fm10.png"));
                comm.RndClick(0.85f,636,299,result,"默认选择A",1000);

                result=mFairy.findPic2(comm.setImg("fm.png"));
                if(result.sim >0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "现世逢魔", 500);
                    for(int i=0;i<5;i++){
                        result=mFairy.findPic2(comm.setImg("dw.png"));
                        if(result.sim >0.85f){
                            LtLog.e(comm.getText("没有开启定位,End!"));
                            return;
                        }
                    }
                }
                result=mFairy.findPic2(comm.setImg("fm11.png"));
                if(result.sim >0.85f) {
                    comm.RndClick(0.85f, 1212, 234, result, "点击领奖励", 1000);
                    bj=2;
                }
            }
            if(bj==2){
                result = mFairy.findPic2(comm.setImg("hd.png"));
                comm.RndClick(0.85f, 326, 44, result, "获得奖励", 1000);

                result=mFairy.findPic2(comm.setImg("fm6.png"));
                if(result.sim >0.85f) {
                    count=0;
                    comm.Click(0.85f, result, comm.getImg(), "寻找首领", 3000);
                    comm.spot(637,292,"点击首领",2000);
                }

                result=mFairy.findPic2(comm.setImg("fm7.png"));
                if(result.sim >0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "集结挑战", 500);
                    for(int i=0;i<5;i++){
                        result=mFairy.findPic2(comm.setImg("e.png"));
                        if(result.sim >0.85f){
                            LtLog.e(comm.getText("今天已经打过了,End!"));
                            return;
                        }
                    }
                }
                result=mFairy.findPic2(comm.setImg("fm8.png"));
                if(result.sim >0.85f) {
                    count=0;
                    comm.Click(0.85f, result, comm.getImg(), "确定", 3000);
                    comm.spot(1139,72,"点击关闭",1000);
                }

                result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
                comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

                result = mFairy.findPic2(comm.setImg("auto.png"));
                comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

                result=mFairy.findPic2(comm.setImg("fm5.png"));
                if(result.sim>0.85f) {
                    count=0;
                }
                result = mFairy.findPic2(8, 558, 163, 710, comm.setImg("fb.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                }

                result=mFairy.findPic2(comm.setImg("fm12.png"));
                if(result.sim>0.85f) {
                    LtLog.e(comm.getText("逢魔已完成,End!"));
                    return;
                }

                count++;
                Thread.sleep(2000);
                if (count > 15) {
                    LtLog.e(comm.getText("异常..."));
                    bj = 0;
                }
            }
        }
    }//逢魔

    public void ql()throws Exception{
        int bj=0,count=0;
        while (true){
            if(bj==0){
                gamePublicFunction.init(2, 72, 1277, 284, "ts.png");
                for(int i=0; i<3;i++){
                    comm.RanSwipe(242,273,800,339,1,1000,500);
                }
                bj=1;
                count=0;
            }
            if(bj==1) {
                result = mFairy.findPic2(10, 351, 920, 516, comm.setImg("fm1.png"));
                comm.Click(0.85f, result, comm.getImg(), "火曜", 1000);

                result = mFairy.findPic2(223, 161, 1097, 615, comm.setImg("ql.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "麒麟", 1000);
                } else {
                    result = mFairy.findPic2(comm.setImg("fm3.png"));
                    comm.Click(0.85f, result, comm.getImg(), "日常", 1000);
                }
                result = mFairy.findPic2(comm.setImg("fm2.png"));
                comm.Click(0.85f, result, comm.getImg(), "前往", 1000);
            }
        }




    }//鬼王

}
