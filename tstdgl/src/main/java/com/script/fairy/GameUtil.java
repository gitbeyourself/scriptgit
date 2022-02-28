package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public GameUtil(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        Sleep=1500;
        SleepWhile=1000;
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic(895, 410, 1188, 567, "dialogue.png");
        if (result.sim > 0.8f) {
            mFairy.onTap(0.8f, result, 681, 685, 695, 695, "对话中", Sleep);
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }

    int tastState = 0;
    public int mission(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;

            public void content_0() throws Exception {
                if (findtask >= 3) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(1124,557,1276,719,"daily.png");
                result1 = mFairy.findPic(1124,557,1276,719,"tj.png");
                if(result.sim> 0.8f && result1.sim < 0.8f) {
                    mFairy.onTap(0.8f, result, "日常", Sleep);
                }

                result = mFairy.findPic(1124,557,1276,719,"daily.png");

                result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(2000);
                    result = mFairy.findPic("jlred.png");
                    mFairy.onTap(0.8f, result, 378,100,409,111,"领取活跃奖励栏", Sleep);
                    if (result.sim>0.8f){
                        mFairy.onTap(881,288,895,304,"领取活跃奖励1", Sleep);
                        for (int i=0;i<5;i++){
                            result =mFairy.findPic(340,223,927,624,"smSure.png");
                            mFairy.onTap(0.8f,result,"奖励确认",Sleep);
                            result = mFairy.findPic(799,184,1179,659,"jlred1.png");
                            mFairy.onTap(0.8f, result, result.x-30,result.y+20,result.x-29,result.y+21,"领取活跃奖励2", Sleep);
                            if (result.sim>0.8f){
                                i=0;
                            }
                        }
                    }
                    mFairy.condit();
                    result = mFairy.findPic(209,132,862,592, str);
                    if (result.sim > 0.8f) {
                    } else {
                        if (option == 1) {
                            mFairy.onTap(528, 99, 563, 113, "日常活动", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(691, 100, 722, 114, "限时活动", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(1005, 96, 1044, 117, "周历", Sleep);
                            findtask++;
                            setTaskName(3);
                            return;
                        }
                        if (option == 4) {
                            mFairy.onTap(375, 101, 410, 117, "活跃奖励", Sleep);
                        }
                    }
                    findtask++;
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(12, 0)) return;
                result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常界面"));
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(208,139,858,591, str);
                    LtLog.e("找到了任务=" + str + "," + result1.sim);
                    if (result1.sim > 0.8f) {
                        mFairy.onTap(0.8f, result1, "任务点击", Sleep);
                        result = mFairy.findPic(853,553,1205,663, "smGoTo3.png");
                       /* result = mFairy.findPic(result1.x + 100, result1.y + 36, result1.x + 200, result1.y + 80, new String[]{"smGoTo.png","smGoTo1.png"});*/
                        if (str.equals("chirdsl.png")){
                            mFairy.onTap(0.8f, result, "日常前往", 5000);
                        }else {
                            mFairy.onTap(0.8f, result, "日常前往", Sleep);
                        }
                        if (result.sim >= 0.8f) {
                            if (!str.equals("Farm.png") && !str.equals("Praying.png")){
                                result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                                mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "前往关闭", Sleep);
                            }
                            GameUtil.this.tastState = 1;
                            setTaskEnd();
                            return;
                        }
                        result = mFairy.findPic(result1.x + 100, result1.y + 36, result1.x + 200, result1.y + 80, new  String[]{"rcComplete.png","rcComplete1.png"});
                        mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "日常完成", Sleep);
                        if (result.sim >= 0.8f) {
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6, 8 , 10}, 0, 531, 586, 532, 185, 1000, 1500,2);
                }
            }
            public void content_3() throws Exception {
                result =mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常界面"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(227,573,1195,650, new String[]{"smGoTo.png","smGoTo1.png"});
                    mFairy.onTap(0.8f, result, "周历前往", Sleep);
                    if (result.sim >= 0.8f) {
                        result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                        mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "前往关闭", Sleep);
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }else {
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }//开始任务

    public int missionfb(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            int i=0;
            public void content_0() throws Exception {
                for(int n=0;n<=2;n++) {
                    long dazeTime = mFairy.mMatTime(1200, 45, 74, 10, 0.9f);
                    LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                    mFairy.sleep(2000);
                    if (n==2 && dazeTime<1){
                        i=1;
                    }else {
                        i=0;
                    }
                }
                result = mFairy.findPic(1185,386,1280,645, "Victory or defeat.png");
                if (result.sim > 0.8f) {
                    LtLog.e("战斗中");
                    mFairy.initMatTime();
                }else{
                    close(1);
                    if (i==1){
                        mFairy.initMatTime();
                        mFairy.onTap(165,135,172,154, "关闭自动遇敌", 500);
                    }
                    setTaskName(1);
                    return;
                }



                if (findtask >= 3) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }




            }

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(723,389,1277,720,"daily.png");
                result1 = mFairy.findPic(723,389,1277,720,"fb.png");
                if(result.sim> 0.8f && result1.sim < 0.8f) {
                    mFairy.onTap(0.8f, result, "日常", Sleep);
                }

                result = mFairy.findPic(731,405,1198,720,"fb.png");
                mFairy.onTap(0.8f, result, "副本", Sleep);

                result = mFairy.findPic(119,80,260,185,"fb1.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "副本界面"));
                if (result.sim > 0.8f) {


                    mFairy.condit();
                    result = mFairy.findPic(209,132,862,592, str);
                    if (result.sim > 0.8f) {
                    } else {
                        if (option == 1) {
                            result = mFairy.findPic(150,128,317,630,"Many people.png");
                            mFairy.onTap(0.8f,result,"多人", Sleep);
                        }
                        if (option == 2) {
                            result = mFairy.findPic(150,128,317,630,"Single.png");
                            mFairy.onTap(0.8f,result,"单人", Sleep);
                        }
                    }
                    findtask++;
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(12, 0)) return;
                result = mFairy.findPic(119,80,260,185,"fb1.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "副本界面"));
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(156,146,309,626, str);
                    LtLog.e("找到了任务=" + str + "," + result1.sim);
                    if (result1.sim > 0.8f) {
                        mFairy.onTap(0.8f, result1, "任务点击", Sleep);
                        result = mFairy.findPic(571,509,829,633, "smGoTo3.png");

                        mFairy.onTap(0.8f, result, "开始副本", Sleep);


                        result = mFairy.findPic(495,287,576,334,"rcComplete1.png");
                        LtLog.e("副本完成");
                        if (result.sim >= 0.8f) {
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6, 8 , 10},  201, 485, 201, 251, 1000, 1500,2);
                }
            }
        }.taskContent(mFairy, "找副本任务中");
        return tastState;
    }//开始副本任务

    public void close(final int close) throws Exception {
        new GameUtil(mFairy) {
            int j = 1;
            public void content_0() throws Exception {
                for (int i = 0; i < j; i++) {
                    result = mFairy.findPic(712,384,1273,715,"sheding.png");
                    mFairy.onTap(0.8f, result, 1232,674,1242,688,"收回扩展列表", Sleep);


                    result = mFairy.findPic(404,1,1279,300, new String[]{"fork1.png"});
                    mFairy.onTap(0.8f, result, "关叉", 500);
                    if (result.sim > 0.8f) {
                        j = 5;
                    } else {
                        j = 2;
                    }

                }
                setTaskEnd();
                return;
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }//关叉

    public  void  goods(final int x)throws Exception{
        new GameUtil(mFairy){

            @Override
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);return;
            }
            int wpCount=0;
            public void content_1() throws Exception {

                if (overtime(9,99)){close(0);setTaskName(0);return;}
                result = mFairy.findPic(1042,501,1275,718,"knapsack.png");
                mFairy.onTap(0.8f, result, "打开背包", 1000);

                result = mFairy.findPic(600,146,1137,529,"buluobi.png");
                LtLog.e("*********"+result.sim);

                result = mFairy.findPic(352,235,1071,642, "use.png");
                mFairy.onTap(0.8f, result, "使用", Sleep);

                result = mFairy.findPic(103,56,330,200,"baginface.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result, 226,361,236,370,"背包界面内", Sleep);
                    result = mFairy.findPic(748,234,1088,579,new  String[]{"Capacity expansionfen.png","Capacity expansionlv.png","qzCapacity expansionlvfen.png","qzCapacity expansionlvzi.png","libaolv.png","libaofen.png","libaolan.png","fd1.png","fd2.png","fd3.png","fd4.png","fd5.png","wp1.png",});
                    mFairy.onTap(0.8f, result, "物品", Sleep);
                    if(x==1) {
                        result = mFairy.findPic(748, 234, 1088, 579, new String[]{"wp2.png", "wp3.png", "wp4.png", "wp5.png", "wp6.png", "wp7.png"});
                        mFairy.onTap(0.8f, result, "物品", Sleep);
                        result = mFairy.findPic(453,6,830,306, "wf.png");
                        mFairy.onTap(0.8f, result, 624,454,636,469,"切换武将", Sleep);
                    }
                    if (result.sim > 0.8f){
                        err--;
                        wpCount++;
                        if (wpCount>20){
                            setTaskEnd();return;
                        }
                    }else {
                        mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4,5,6,7}, 0, 1106,309, 629,301, 1000, 1500,2);
                    }

                    result = mFairy.findPic(352,235,1071,642, "use.png");
                    mFairy.onTap(0.8f, result, "使用", Sleep);

                    result1=mFairy.findPic(461,216,828,363,"Batch determination.png");
                    if (result1.sim>0.8f){
                        mFairy.onTap(0.8f, result1,761,338,773,347, "批量确定", Sleep);
                        mFairy.onTap(0.8f, result1,632,402,639,412, "批量确定", Sleep);
                        /*result = mFairy.findPic(538,96,752,195,"cishuxianzhi.png");
                        mFairy.onTap(0.8f, result, 915,153,934,167,"次数限制",Sleep);
                        if (result.sim>0.8f){
                            mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                        }else {
                            Thread.sleep(4000);
                        }*/
                    }else {
                        /*mFairy.onTap(0.8f, result, 504,427,518,435,"取消222", Sleep);*/
                    }

                    /*result = mFairy.findPic("shanhaishop.png");
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("山海商店中"));
                        mFairy.onTap(0.8f, result, 173,153,188,164,"坡介石", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 630,161,661,176,"精髓", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 268,261,287,270,"神器", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 584,245,614,259,"精魂", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 154,368,169,380,"远古升级石", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 510,369,523,380,"氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 151,469,167,484,"高级氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 505,474,519,488,"玲珑玉下品", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 159,584,173,595,"温魂碎片", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("dhjsure.png");
                        mFairy.onTap(0.8f, result, 639,434,669,446,"确定", 5000);
                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("quehuo.png");
                        mFairy.onTap(0.8f, result, 633,429,671,445,"确定", 5000);
                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                    }
                    for (int i=0;i<2;i++){
                        mFairy.condit();
                        result = mFairy.findPic(281,198,1036,684,"plquxiao.png");
                        if (result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("使用中"));
                            i=0;
                        }
                    }*/
                }
            }
        }.taskContent(mFairy,"物品的使用中");
    } //物品的使用

    public  void  fuli()throws Exception{
        new SingleTask(mFairy){
            int i=0;
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;

                result = mFairy.findPic(824,1,1060,80, "welfare.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(151,96,328,620,"tjjy.png");
                mFairy.onTap(0.8f, result, 231,206,243,213,"脱机经验", Sleep);
                if (result.sim>0.7f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(4,3))return;
                result = mFairy.findPic(412,492,567,608,"fllq1.png");

                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 480,511,493,527,"领取经验", Sleep);
                    setTaskName(3);return;
                } else {
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                result = mFairy.findPic(151,96,328,620,"mrqd.png");
                mFairy.onTap(0.8f, result, 219,284,231,292,"每日签到", Sleep);

                    setTaskName(4);return;
            }
            public void content_4() throws Exception {
                if (overtime(10,4)){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(158,151,309,618, "zxjl.png");
                mFairy.onTap(0.8f, result, "在线奖励", Sleep);

                result = mFairy.findPic(922,323,1094,594, "lq.png");

                if(result.sim > 0.8f ){
                    mFairy.onTap(0.8f, result, "领取", Sleep);
                }else{
                    i++;
                }
                if(i>=3 ){
                    setTaskName(5);return;
                }

            }
            public void content_5() throws Exception {
                if (overtime(10,5)){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(158,151,309,618, "drjl.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "在线奖励", Sleep);
                }else
                {
                    mFairy.taskSlid(err, new int[]{0, 2, 4,}, 0, 201, 485, 201, 251, 1000, 1500,2);
                }
                mFairy.onTap(0.8f, result, "在线奖励", Sleep);

                result = mFairy.findPic(922,323,1094,594, "lq.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);
                if(result.sim<0.8f){
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6, 8 }, 0, 531, 586, 532, 385, 1000, 1500,2);
                }

            }

        }.taskContent(mFairy,"福利任务中");
    }//福利

    public  void  cs()throws Exception{
        new SingleTask(mFairy){
            int i=0;
            @Override
            public void content_0() throws Exception {
                long dazeTime = mFairy.mMatTime(1200, 45, 74, 10, 0.9f);

                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                mFairy.sleep(5000);

                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
            }


        }.taskContent(mFairy,"测试");
    }//福利

}
