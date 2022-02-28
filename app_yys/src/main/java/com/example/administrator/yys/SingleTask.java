package com.example.administrator.yys;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/13.
 */

public class SingleTask {

    yys mFairy;
    FindResult result;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;
    ControlSplit back;
    public Map<String, Long> timeKeepMap = new HashMap();
    public SingleTask(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        back = new ControlSplit();
    }


    /*
        单人任务
    */
    public void zuduiYB() throws Exception {
        long t = System.currentTimeMillis();
        while (true) {
            if(System.currentTimeMillis()-t>3600000){
                TaskThread.task=72001;
                return;
            }

            result = mFairy.findPic2(comm.setImg("jujue.png"));
            comm.Click(0.85f, result, comm.getImg(), "封妖拒绝", 1000);

            result = mFairy.findPic2(comm.setImg("tl.png"));
            if (result.sim > 0.8f) {
                LtLog.e("体力不足,End!");
                return;
            }

            result = mFairy.findPic2(comm.setImg("auto.png"));
            comm.Click(0.85f, result, comm.getImg(), "自动战斗", 1000);

            result = mFairy.findPic2(comm.setImg("tz1.png"));
            if (result.sim > 0.985f) {
                Thread.sleep(2000);
                result = mFairy.findPic2(comm.setImg("tz1.png"));
                comm.Click(0.985f, result, comm.getImg(), "开始", 1000);
            }

            result = mFairy.findPic2(994, 466, 1274, 650, comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 2500);

            result = mFairy.findPic2(comm.setImg("qd.png"));
            if(result.sim>0.85f) {
                comm.spot(556,356,"默认邀请玩家",1000);
                comm.Click(0.85f, result, comm.getImg(), "继续邀请玩家", 1000);
            }

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if(result.sim>0.85f) {
                int numX  = (int) Math.random()*200;
                int numY  = (int) Math.random()*200;
                comm.RndClick(0.85f,result.x+numX,result.y-numY,result, "继续", 1000);
            }

            result = mFairy.findPic2(9,175,496,352, comm.setImg("js.png"));
            if(result.sim>0.8f) {
                Thread.sleep(1500);

                result = mFairy.findPic2(149,140,340,367, comm.setImg("jie1.png"));
                if(result.sim>0.85f){
                    comm.Click(0.8f, result, comm.getImg(), "接受1", 1000);
                }else {
                    result = mFairy.findPic2(8,187,584,384, comm.setImg("jia12.png"));
                    if(result.sim>0.8f) {
                        result = mFairy.findPic2(13, 168, 263, 356, comm.setImg("js.png"));
                        comm.Click(0.8f, result, comm.getImg(), "接受", 1000);
                    }
                }
            }

            result = mFairy.findPic2(852,418,1059,568,comm.setImg("yl3.png"));
            comm.Click(0.8f, result, comm.getImg(), "挑战", 2500);

            result = mFairy.findPic2(1082,544,1221,685,comm.setImg("tz2.png"));
            comm.Click(0.8f, result, comm.getImg(), "挑战", 2500);

            result = mFairy.findPic2(comm.setImg("yl4.png"));
            comm.RndClick(0.8f,668,390, result, "继续", 1000);

        }
    }//组队樱饼操作

    public void tsYB() throws Exception {
        int count = 0;
        int num =0;
        while (true) {
            Thread.sleep(1000);

            result = mFairy.findPic2(comm.setImg("tl.png"));
            if (result.sim > 0.8f) {
                LtLog.e("体力不足,End!");
                return;
            }

            result = mFairy.findPic2(comm.setImg("ts10.png"));
            if (result.sim > 0.85f) {
                num++;

                if(num>5){
                    comm.spot(41,47,"返回",3000);
                    num=0;
                }
            }else{
                num=0;
            }

            result = mFairy.findPic2(515,66,832,281,comm.setImg("ts11.png"));
            comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

            result = mFairy.findPic2(comm.setImg("jujue.png"));
            comm.Click(0.85f, result, comm.getImg(), "封妖拒绝", 1000);

            result = mFairy.findPic2(836, 466, 1052, 604, comm.setImg("tansuo.png"));
            if(result.sim>0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "探索", 2000);
            }else{
                result = mFairy.findPic2(comm.setImg("ts9.png"));
                if(result.sim>0.85f){
                    result = mFairy.findPic2(131,59,1056,621,comm.setImg("ts8.png"));
                    comm.Click(0.85f, result, comm.getImg(), "小人。", 1000);
                }
            }

            result = mFairy.findPic2(994, 466, 1274, 650, comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 2500);

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if(result.sim>0.85f) {
                int numX  = (int) Math.random()*200;
                int numY  = (int) Math.random()*200;
                comm.RndClick(0.85f,result.x+numX,result.y-numY,result, "继续", 1000);
            }

            result = mFairy.findPic2(100,100,1025,712, comm.setImg("ts6.png"));
            comm.Click(0.8f, result, comm.getImg(), "宝箱", 3000);

            result = mFairy.findPic2(comm.setImg("ts3.png"));
            if (result.sim > 0.85f) {
                result = mFairy.findPic2(33, 104, 1269, 611, comm.setImg("ts4.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.RndClick(0.85f, result.x+10,result.y+15,result,"战斗", 3000);
                    continue;
                }

                result = mFairy.findPic2(33, 104, 1269, 611, comm.setImg("ts5.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.RndClick(0.85f, result.x+10,result.y+15,result,"BOSS", 3000);
                    continue;
                }

                count++;

                if (count % 2 == 0) {
                    if (count < 13) {
                        comm.RanSwipe(300, 178, 800, 230, 3, 1000, 1000);
                    } else {
                        comm.RanSwipe(300, 178, 800, 230, 1, 1000, 1000);
                    }
                }

                if (count > 26) {
                    count = 0;
                }
            }

        }
    }//探索樱饼操作

    public void tp()throws Exception{
        int num=0;
        while (true) {
            result = mFairy.findPic2(comm.setImg("jujue.png"));
            comm.Click(0.85f, result, comm.getImg(), "封妖拒绝", 1000);

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png", "h3.png"});
            comm.arrayClick(0.85f, result, "继续", 1000);

            result = mFairy.findPic2(45, 611, 1026, 715, comm.setImg("jj.png"));
            comm.Click(0.85f, result, comm.getImg(), "结界突破", 1000);

           // result = mFairy.findPic2(comm.setImg("This week.png"));
            result = comm.arrayCompare(0.75f, new String[]{"This week.png", "This week2.png"});
            if (result.sim > 0.75f) {
                LtLog.e("------识别到再结界突破界面里");
                result = mFairy.findPic2(989,3,1129,61,comm.setImg("jjEnd2.png"));
                if (result.sim > 0.98f) {
                    LtLog.e(comm.getText("卷轴不足,End!"));
                    return;
                }

                if (num == 10) {
                    result = mFairy.findPic2(142,528,294,658,comm.setImg("jjEnd.png"));
                    if (result.sim > 0.95f) {

                    } else {
                        result = mFairy.findPic2(comm.setImg("sx.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "刷新", 3000);
                            comm.spot(757, 433, "确定", 2000);
                        }
                    }
                    num = 0;
                }

                result = mFairy.findPic2(248, 273, 1231, 691, comm.setImg("jingong.png"));
                LtLog.e("--------------"+result.sim);
                if (result.sim > 0.8f) {
                    comm.Click(0.8f, result, comm.getImg(), "进攻", 300);
                    for (int i = 0; i < 8; i++) {
                        result = mFairy.findPic2(comm.setImg("jjEnd1.png"));
                        if (result.sim > 0.8f) {
                            LtLog.e(comm.getText("卷轴不足,End!"));
                            return;
                        }
                    }
                    Thread.sleep(3000);
                    continue;
                }
                switch (num) {
                    case 1:
                    case 2:
                    case 3:
                        comm.spot(300 + ((num - 1) * 350), 158, "第" + num + "个", 1500);
                        break;
                    case 4:
                    case 5:
                    case 6:
                        comm.spot(300 + ((num - 4) * 350), 285, "第" + num + "个", 1500);
                        break;
                    case 7:
                    case 8:
                    case 9:
                        comm.spot(300 + ((num - 7) * 350), 425, "第" + num + "个", 1500);
                        break;
                }
                num++;
            }

            result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

            result = mFairy.findPic2(comm.setImg("auto.png"));
            comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

        }
    }//突破

    public class ControlSplit {
        public int choice;
        public int h;
        public int m;
        public int s;
        public long timeMillis;
        public int count;
        public ControlSplit() {

        }
    }

    public ControlSplit strSplit(String string) throws Exception {
        ControlSplit controlSplit = new ControlSplit();
        String[] arrstr = string.split("\\|\\|");
        String[] arrstr1;
        if(arrstr.length < 2) {
            arrstr1 = arrstr[0].split(":");
            if(arrstr1.length < 2) {
                controlSplit.count = Integer.parseInt(arrstr1[0]);
                return controlSplit;
            } else {
                controlSplit.h = Integer.parseInt(arrstr1[0]);
                controlSplit.m = Integer.parseInt(arrstr1[1]);
                controlSplit.s = Integer.parseInt(arrstr1[2]);
                controlSplit.timeMillis = (long)(controlSplit.h * 3600000 + controlSplit.m * '\uea60' + controlSplit.s * 1000);
                return controlSplit;
            }
        } else {
            controlSplit.choice = Integer.parseInt(arrstr[0]);
            arrstr1 = arrstr[1].split(":");
            if(arrstr1.length < 2) {
                controlSplit.count = Integer.parseInt(arrstr1[0]);
            } else {
                controlSplit.h = Integer.parseInt(arrstr1[0]);
                controlSplit.m = Integer.parseInt(arrstr1[1]);
                controlSplit.s = Integer.parseInt(arrstr1[2]);
                controlSplit.timeMillis = (long)(controlSplit.h * 3600000 + controlSplit.m * '\uea60' + controlSplit.s * 1000);
            }

            return controlSplit;
        }
    }
    public boolean timekeep(int order, long t, String string) throws Exception {
        if(this.timeKeepMap.containsKey(string)) {
            if(System.currentTimeMillis() - ((Long)this.timeKeepMap.get(string)).longValue() >= t) {
                this.timeKeepMap.put(string, Long.valueOf(System.currentTimeMillis()));
                return true;
            } else {
                return false;
            }
        } else {
            this.timeKeepMap.put(string, Long.valueOf(System.currentTimeMillis()));
            return order == 1;
        }
    }


    public void zuduiYB2() throws Exception {
        long t = System.currentTimeMillis();
        if (!AtFairyConfig.getOption("optime1").equals("")) {
            back = strSplit(AtFairyConfig.getOption("optime1"));
            LtLog.e("---------------------。"+AtFairyConfig.getOption("optime1"));

        }
        // LtLog.e("******************。"+AtFairyConfig.getOption("optime1"));
        while (true) {
            LtLog.e("已进入。。。");
            Thread.sleep(1000);
            LtLog.e("*-----*设置得时间"+back.timeMillis+"*----------*已经过得时间"+((System.currentTimeMillis()-t)/1000));
            if (back != null && back.choice == 1 && timekeep(0,back.timeMillis,"挑战时间")){
                LtLog.e("时间到了");
                gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                return;
            }

            result = mFairy.findPic2(comm.setImg("jujue.png"));
            comm.Click(0.85f, result, comm.getImg(), "封妖拒绝", 1000);

            result = mFairy.findPic2(comm.setImg("tl.png"));
            if (result.sim > 0.8f) {
                LtLog.e("体力不足,End!");
                gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                return;
            }

            result = mFairy.findPic2(comm.setImg("auto.png"));
            comm.Click(0.85f, result, comm.getImg(), "自动战斗", 1000);

            result = mFairy.findPic2(comm.setImg("tz1.png"));
            if (result.sim > 0.985f) {
                Thread.sleep(2000);
                result = mFairy.findPic2(comm.setImg("tz1.png"));
                comm.Click(0.985f, result, comm.getImg(), "开始", 1000);
            }

            result = mFairy.findPic2(994, 466, 1274, 650, comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 2500);

            result = mFairy.findPic2(comm.setImg("qd.png"));
            if(result.sim>0.85f) {
                comm.spot(556,356,"默认邀请玩家",1000);
                comm.Click(0.85f, result, comm.getImg(), "继续邀请玩家", 1000);
            }

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if(result.sim>0.85f) {
                int numX  = (int) Math.random()*200;
                int numY  = (int) Math.random()*200;
                comm.RndClick(0.85f,result.x+numX,result.y-numY,result, "继续", 1000);
            }

            result = mFairy.findPic2(9,175,496,352, comm.setImg("js.png"));
            if(result.sim>0.8f) {
                Thread.sleep(1500);

                result = mFairy.findPic2(149,140,340,367, comm.setImg("jie1.png"));
                if(result.sim>0.85f){
                    comm.Click(0.8f, result, comm.getImg(), "接受1", 1000);
                }else {
                    result = mFairy.findPic2(8,187,584,384, comm.setImg("jia12.png"));
                    if(result.sim>0.8f) {
                        result = mFairy.findPic2(13, 168, 263, 356, comm.setImg("js.png"));
                        comm.Click(0.8f, result, comm.getImg(), "接受", 1000);
                    }
                }
            }

            result = mFairy.findPic2(852,418,1059,568,comm.setImg("yl3.png"));
            comm.Click(0.8f, result, comm.getImg(), "挑战", 2500);

            result = mFairy.findPic2(1082,544,1221,685,comm.setImg("tz2.png"));
            comm.Click(0.8f, result, comm.getImg(), "挑战", 2500);

            result = mFairy.findPic2(comm.setImg("yl4.png"));
            comm.RndClick(0.8f,668,390, result, "继续", 1000);

        }
    }//组队樱饼操作带计时的

    public void tsYB2() throws Exception {
        long t = System.currentTimeMillis();
        if (!AtFairyConfig.getOption("optime2").equals("")) {
            back = strSplit(AtFairyConfig.getOption("optime2"));
            LtLog.e("---------------------。"+AtFairyConfig.getOption("optime2"));
        }
        int count = 0;
        int num =0;
        while (true) {
            Thread.sleep(1000);
            LtLog.e("*-----*设置得时间"+back.timeMillis+"*----------*已经过得时间"+((System.currentTimeMillis()-t)/1000));
            if (back != null && back.choice == 1 && timekeep(0,back.timeMillis,"挑战时间2")){
                LtLog.e("时间到了");
                gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                return;
            }
            result = mFairy.findPic2(comm.setImg("tl.png"));
            if (result.sim > 0.8f) {
                LtLog.e("体力不足,End!");
                gamePublicFunction.init(61, 625, 897, 706, "word create team.png");
                return;
            }

            result = mFairy.findPic2(comm.setImg("ts10.png"));
            if (result.sim > 0.85f) {
                num++;

                if(num>5){
                    comm.spot(41,47,"返回",3000);
                    num=0;
                }
            }else{
                num=0;
            }

            result = mFairy.findPic2(515,66,832,281,comm.setImg("ts11.png"));
            comm.Click(0.85f, result, comm.getImg(), "探索", 1000);

            result = mFairy.findPic2(comm.setImg("jujue.png"));
            comm.Click(0.85f, result, comm.getImg(), "封妖拒绝", 1000);

            result = mFairy.findPic2(836, 466, 1052, 604, comm.setImg("tansuo.png"));
            if(result.sim>0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "探索", 2000);
            }else{
                result = mFairy.findPic2(comm.setImg("ts9.png"));
                if(result.sim>0.85f){
                    result = mFairy.findPic2(131,59,1056,621,comm.setImg("ts8.png"));
                    comm.Click(0.85f, result, comm.getImg(), "小人。", 1000);
                }
            }

            result = mFairy.findPic2(994, 466, 1274, 650, comm.setImg("jia.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 2500);

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if(result.sim>0.85f) {
                int numX  = (int) Math.random()*200;
                int numY  = (int) Math.random()*200;
                comm.RndClick(0.85f,result.x+numX,result.y-numY,result, "继续", 1000);
            }

            result = mFairy.findPic2(100,100,1025,712, comm.setImg("ts6.png"));
            comm.Click(0.8f, result, comm.getImg(), "宝箱", 3000);

            result = mFairy.findPic2(comm.setImg("ts33.png"));
            if (result.sim > 0.8f) {
                result = mFairy.findPic2(33, 104, 1269, 611, comm.setImg("ts4.png"));
                if (result.sim > 0.8f) {
                    count = 0;
                    comm.RndClick(0.85f, result.x+10,result.y+15,result,"战斗", 3000);
                    continue;
                }

                result = mFairy.findPic2(33, 104, 1269, 611, comm.setImg("ts5.png"));
                if (result.sim > 0.85f) {
                    count = 0;
                    comm.RndClick(0.85f, result.x+10,result.y+15,result,"BOSS", 3000);
                    continue;
                }

                count++;

                if (count % 2 == 0) {
                    if (count < 13) {
                        comm.RanSwipe(300, 178, 800, 230, 3, 1000, 1000);
                    } else {
                        comm.RanSwipe(300, 178, 800, 230, 1, 1000, 1000);
                    }
                }

                if (count > 26) {
                    count = 0;
                }
            }

        }
    }//探索樱饼操作带计时的

    /**
     * 开启加成 （仅限我自己用）
     * @throws Exception
     */
    public void jiacheng() throws Exception{
        result = mFairy.findPic2(306,11,779,109,comm.setImg("jiacheng.png"));
        comm.Click(0.85f, result, comm.getImg(), "加成", 2000);

        result = mFairy.findPic2(comm.setImg("open.png"));
        comm.Click(0.8f, result, comm.getImg(), "开启", 1000);
        comm.Click(0.8f, result, comm.getImg(), "开启", 1000);


    }

    /**
     * 关闭加成 （仅限我自己用）
     * @throws Exception
     */
    public void closejiacheng() throws Exception{
       // result = mFairy.findPic2(306,11,779,109,comm.setImg("jiacheng.png"));
        while (true) {
            result = comm.arrayCompare(0.85f, new String[]{"jiacheng.png", "jiacheng2.png"});
            comm.Click(0.85f, result, comm.getImg(), "加成", 2000);

            result = mFairy.findPic2(761, 122, 901, 464, comm.setImg("guanle.png"));
            comm.Click(0.8f, result, comm.getImg(), "关闭", 1000);
            //comm.Click(0.8f, result, comm.getImg(), "关闭", 1000);
            result = mFairy.findPic2(comm.setImg("open.png"));
            if (result.sim > 0.8f){
                return;
            }
        }

    }

    /**
     * 活动自动挑战 （仅限我自己用）
     * @throws Exception
     */
    public void huodong() throws Exception{
        int num = 0;


        if(!AtFairyConfig.getOption("opcount1").equals("")){
            if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                num=strSplit(AtFairyConfig.getOption("opcount1")).count;
            }else {
                LtLog.e("没有设定垂钓次数结束默认100次");
                num = 100;
            }
        }

        while (true) {
            Thread.sleep(3000);
//            result = mFairy.findPic2(comm.setImg("huanjing.png"));
//            comm.Click(0.85f, result, comm.getImg(), "幻境间隙", 2000);
//
//            result = mFairy.findPic2(comm.setImg("putong.png"));
//            comm.Click(0.8f, result, comm.getImg(), "普通难度", 3000);

            result = mFairy.findPic2(comm.setImg("zhouniantz.png"));
            if(AtFairyConfig.getOption("wxd").equals("1")){

            }else if (result.sim > 0.8f){
                comm.Click(0.8f, result, comm.getImg(), "挑战", 3000);
                num--;
            }

            result = mFairy.findPic2(comm.setImg("zhouniantz2.png"));
            comm.Click(0.8f, result, comm.getImg(), "挑战2", 3000);

            result = mFairy.findPic2(comm.setImg("huodongtz2.png"));
            comm.Click(0.8f, result, comm.getImg(), "挑战2", 3000);

            result = mFairy.findPic2(comm.setImg("zhunbei.png"));
            comm.Click(0.8f, result, comm.getImg(), "准备", 3000);

            result = mFairy.findPic2(comm.setImg("chengji.png"));
            comm.Click(0.8f, result, comm.getImg(), "成绩", 3000);

            result = comm.arrayCompare(0.85f, new String[]{"h1.png", "h2.png"});
            if (result.sim > 0.85f) {
                //num--;
                int numX = (int) Math.random() * 200;
                int numY = (int) Math.random() * 200;
                comm.RndClick(0.85f, result.x + numX, result.y - numY, result, "继续", 3000);


            }
            LtLog.e("***快完了快完了还剩"+num+"次");
//            result = mFairy.findPic2(comm.setImg("zero.png"));
//            if (result.sim > 0.9f) {
//                return;
//            }
            if(!AtFairyConfig.getOption("wxd").equals("1")){
                if (num <=0){
                    return;
                }
            }

        }

    }

}









