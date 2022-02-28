package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
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
    FindResult result3;
    public GameUtil(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }

    int tastState = 0;
    /**
     * 关闭影响接取任务的窗口（初始化）
     * @throws Exception
     */
    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                mFairy.sleep(5000);
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result =mFairy.findPic(568,4,715,345,new String[]{"close.png","close.png","redcha.png","mapcha.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);

                    result1 =mFairy.findPic(476,955,715,1280,new String[]{"close1.png","close2.png","close4.png"});
                    mFairy.onTap(0.8f,result1,"关闭",2000);

                    result2 =mFairy.findPic("cha2.png");
                    mFairy.onTap(0.8f,result1,"关闭",2000);

//                    result2 =mFairy.findPic(564,5,717,162,"close.png");
//                    mFairy.onTap(0.8f,result2,"还原",2000);
//                    result3 =mFairy.findPic(564,5,717,162,"close.png");
//                    mFairy.onTap(0.8f,result3,"关闭",2000);
                    if (result.sim > 0.8f || result1.sim > 0.8f || result2.sim > 0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                    result =mFairy.findPic(8,1025,720,1163,new String[]{"wait.png","dengdeng.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);

                }
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                result = mFairy.findPic(new String[]{"guaji.png","Hang up.png"});
                mFairy.onTap(0.8f, result, "挂机页面", 2000);

                result = mFairy.findPic(1,243,131,699,new String[]{"bag.png","bag2.png"});
                mFairy.onTap(0.8f, result, "背包", 2000);

//                result = mFairy.findPic("decompose.png");
//                mFairy.onTap(0.8f,result,"去分解",Sleep);
//
//                result = mFairy.findPic("fenjie.png");
//                mFairy.onTap(0.8f,result,"去分解",Sleep);
//
//                result = mFairy.findPic(419,910,609,969,"decompose.png");
//                mFairy.onTap(0.8f,result,"分解50件",Sleep);
//
//                result = mFairy.findPic(new  String[]{"null.png","vipfenjie.png"});
//                mFairy.onTap(0.8f,result,661,156,676,173,"分解完了关掉当前页面",Sleep);
//                mFairy.onTap(0.8f,result,675,82,688,97,"分解完了关掉当前页面",Sleep);

                setTaskEnd();return;
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

    public void close2() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                mFairy.sleep(5000);
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result =mFairy.findPic(568,4,715,345,new String[]{"close.png","close.png","redcha.png","mapcha.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);

                    result1 =mFairy.findPic(476,955,715,1280,new String[]{"close1.png","close2.png","close4.png"});
                    mFairy.onTap(0.8f,result1,"关闭",2000);

                    if (result.sim > 0.8f || result1.sim > 0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                    result =mFairy.findPic(8,1025,720,1163,new String[]{"wait.png","dengdeng.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);
                }
                setTaskEnd();
            }

        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }
    /**
     * 日常入口
     * @param str
     * @throws Exception
     */
    public int mission(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public  void content_0() throws Exception {
                close2();
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                result = mFairy.findPic(new String[]{"guaji.png","Hang up.png"});
                mFairy.onTap(0.8f, result, "挂机页面", 2000);
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }

                setTaskName(1);

            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                mFairy.sleep(1000);

                result = mFairy.findPic(3,303,107,730,"daily.png");
                mFairy.onTap(0.8f, result, "日常", 2000);

                result = mFairy.findPic(151,40,588,153,new String[]{"activity.png","wanfa.png","wanfa2.png"});
                result1 = mFairy.findPic(151,40,588,153,"activityvip.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));



                if (result.sim > 0.8f || result1.sim >0.8f) {

                    result = mFairy.findPic("ww.png");
                    mFairy.onTap(0.8f, result, "在线奖励", 100);

                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(21,183,698,860,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(106,144,136,160, "日常活动", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(268,143,297,161, "限时", Sleep);
                        }
                        if (option == 2) {

                          //  mFairy.onTap(503,148,534,168, "休闲闲趣", Sleep);
                        }
                    }
                    findtask++;
                    if (findtask > 2){
                        setTaskName(0);
                    }
                    setTaskName(2);
                }
            }
            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public   void content_2() throws Exception {
                result1 = mFairy.findPic(21,183,698,860,str);
                LtLog.e("寻找任务相似度"+result1.sim);
                if (result1.sim > 0.8f) {
                    LtLog.e("找到任务");
                    LtLog.e("***"+(result1.x + 450)+","+(result1.y -50)+","+(result1.x +600)+","+(result1.y +96));
                    result = mFairy.findPic(result1.x + 450, result1.y -50, result1.x +600, result1.y +96, new String[]{"Go now2.png","Go now.png"});//128,281   627,287
                    mFairy.onTap(0.8f, result, "日常前往", 1000); // - 499   -6
                    if (result.sim >= 0.8f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(result1.x + 405, result1.y -50, result1.x + 600, result1.y +96, "Finished.png");
                    result1 = mFairy.findPic(result1.x + 405, result1.y -50, result1.x + 600, result1.y +96,new String[]{"Finished2.png","Finished3.png"});
                    if (result.sim >= 0.8f || result1.sim > 0.8f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8}, 0, 323,776, 323,315, 2500, 2000);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }

    /**
     * 日常入口2
     * @param str
     * @throws Exception
     */
    public int mission2(final String str, final String str2,final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public  void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                close2();
                result = mFairy.findPic(new String[]{"guaji.png","Hang up.png"});
                mFairy.onTap(0.8f, result, "挂机页面", 2000);
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }

                setTaskName(1);

            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                mFairy.sleep(1000);

                result = mFairy.findPic(3,303,107,730,"daily.png");
                mFairy.onTap(0.8f, result, "日常", 2000);

                result = mFairy.findPic(151,40,588,153,new String[]{"activity.png","wanfa.png","wanfa2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                result1 = mFairy.findPic(151,40,588,153,"activityvip.png");
                if (result.sim > 0.8f || result1.sim >0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(21,183,698,860,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(106,144,136,160, "日常活动", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(268,143,297,161, "限时", Sleep);
                        }
                        if (option == 2) {

                            //  mFairy.onTap(503,148,534,168, "休闲闲趣", Sleep);
                        }
                    }
                    findtask++;
                    if (findtask > 2){
                        setTaskName(0);
                    }
                    setTaskName(2);
                }
            }
            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public   void content_2() throws Exception {
//                result = mFairy.findPic(78,1161,702,1194,new String[]{"red.png","red2.png","red3.png"});
//                mFairy.onTap(0.8f,result,"领取活跃值奖励",2000);
                result1 = mFairy.findPic(21,183,698,860,new String[]{str,str2});
                LtLog.e("寻找任务相似度"+result1.sim);
                if (result1.sim > 0.8f) {
                    LtLog.e("找到任务");
                    LtLog.e("***"+(result1.x + 300)+","+(result1.y -50)+","+(result1.x +500)+","+(result1.y +120));//240,403   627,460
                    result = mFairy.findPic(result1.x + 300, result1.y -50, result1.x +500, result1.y +120, new String[]{"Go now.png","Go now2.png"});//128,281   627,287
                    mFairy.onTap(0.8f, result, "日常前往", 1000); // - 499   -6   +387 +57
                    if (result.sim >= 0.8f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(result1.x + 405, result1.y -50, result1.x + 600, result1.y +96, "Finished.png");
                    result1 = mFairy.findPic(result1.x + 405, result1.y -50, result1.x + 600, result1.y +96,new String[]{"Finished2.png","Finished3.png"});
                    if (result.sim >= 0.8f || result1.sim >= 0.8f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8}, 0, 323,776, 323,315, 2500, 2000);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }
}
