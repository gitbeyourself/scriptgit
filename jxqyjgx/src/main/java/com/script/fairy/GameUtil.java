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
    FindResult result3;
    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    int tastState ;
    /**
     * 关闭影响接取任务的窗口（初始化）
     * @throws Exception
     */
    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                result3 = mFairy.findPic("open auto.png");
                mFairy.onTap(0.8f,result3,"停止自动挂机",Sleep);
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result =mFairy.findPic(975,2,1276,201,new String[]{"close reght top.png","advertisement.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);

                    result1 =mFairy.findPic(5,5,252,138,new String[]{"close finsh.png","close left top.png","close left top2.png","close left top3.png","close left top4.png"});
                    mFairy.onTap(0.8f,result1,"关闭",2000);
                    if (result1.sim > 0.8f || result.sim >= 0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                   // result2 = mFairy.findPic(1018,147,1271,246,"activity.png");

                    result2 = mFairy.findPic("bag.png");
                    if (result1.sim < 0.8f && result.sim < 0.8f && result2.sim > 0.8f){
                        mFairy.onTap(194,556,204,564,"没有叉子关闭",2000);
                    }
                }
                setTaskEnd();return;
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

    /**
     * 活动入口
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
            public void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
                close();
                setTaskName(1);

            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(1018,147,1271,246,"activity.png");
                LtLog.e("=========================活动按钮相似度=="+result.sim);
                mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);

                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(83,64,1275,585,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(39,169,50,189, "日常", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(37,279,47,291, "战场", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(40,380,50,397, "竞技", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(38,490,50,505, "领地", Sleep);
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
                result1 = mFairy.findPic(83,64,1275,585,str);
                mFairy.onTap(0.8f, result1,result1.x-92,result1.y-80,result1.x-78,result1.y-60, "找到任务并点击",2000);//297,550   205,429,219,438
                LtLog.e("任务图标相似度"+result1.sim);
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(new String[]{"few more.png","Go now.png"});
                    mFairy.onTap(0.8f, result, "可以参加点击",2000);
                    if (result.sim >= 0.8f) {
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                    LtLog.e("***"+result1.x+","+result1.y);
                    LtLog.e("***"+(result1.x-193)+","+(result1.y-126)+","+(result1.x+100)+","+(result1.y+40));//284,201  91,75,384,241
                    result = mFairy.findPic(result1.x-193, result1.y-126, result1.x+100, result1.y+40, "Finished2.png");
                    result2 = mFairy.findPic(result1.x-193, result1.y-126, result1.x+100, result1.y+40, "Finished.png");
                    LtLog.e("完成图标相似度==="+result.sim);
                    if (result.sim >= 0.8f) {
                        GameUtil.this.tastState = 2;
                        setTaskEnd();
                        return;
                    }
                    if (result2.sim >= 0.8f){
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 4, 8}, 0, 521,533, 521,147, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }

    /**
     * 限时活动入口
     * @param str
     * @throws Exception
     */
    public int missionTimelimit(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
                close();
                setTaskName(1);

            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(1018,147,1271,246,"activity.png");
                LtLog.e("=========================活动按钮相似度=="+result.sim);
                mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);
                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(83,64,1275,585,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(39,169,50,189, "日常", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(37,279,47,291, "战场", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(40,380,50,397, "竞技", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(38,490,50,505, "领地", Sleep);
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

                result1 = mFairy.findPic(973,60,1273,591,str);
                mFairy.onTap(0.8f, result1, "找到任务并点击",2000);
                LtLog.e("任务图标相似度"+result1.sim);
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(new String[]{"few more.png","Go now.png"});
                    mFairy.onTap(0.8f, result, "可以参加点击",2000);
                    if (result.sim >= 0.8f) {
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                    LtLog.e("***"+result1.x+","+result1.y);//1200,191    982,118,1263,226
                    LtLog.e("***"+(result1.x-218)+","+(result1.y-73)+","+(result1.x+63)+","+(result1.y+35));//284,201  91,75,384,241
                    result = mFairy.findPic(result1.x-218, result1.y-73, result1.x+63, result1.y+35, "Finished2.png");
                    result2 = mFairy.findPic(result1.x-218, result1.y-73, result1.x+63, result1.y+35, "time finish.png");
                    result3 = mFairy.findPic("gangmeike.png");
                    LtLog.e("完成图标相似度==="+result.sim);
                    if (result.sim >= 0.8f || result3.sim > 0.8f) {
                        GameUtil.this.tastState = 2;
                        setTaskEnd();
                        return;
                    }
                    if (result2.sim >= 0.8f){
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 0, 1135,533, 1141,186, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中限时");
        return tastState;
    }

    /**
     * 限时活动入口(野外挂机)
     * @param str
     * @throws Exception
     */
    public int missionTimelimitn(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
                close();
                setTaskName(1);

            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(1018,147,1271,246,"activity.png");
                LtLog.e("=========================活动按钮相似度=="+result.sim);
                mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);

                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(83,64,1275,585,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(39,169,50,189, "日常", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(37,279,47,291, "战场", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(40,380,50,397, "竞技", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(38,490,50,505, "领地", Sleep);
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
                result1 = mFairy.findPic(973,60,1273,591,str);
                mFairy.onTap(0.8f, result1, "找到任务并点击",2000);
                LtLog.e("任务图标相似度"+result1.sim);
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(new String[]{"few more.png","Go now.png"});
                   // mFairy.onTap(0.8f, result, "可以参加点击",2000);
                    if (result.sim >= 0.8f) {
                        LtLog.e("可以参加");
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                    LtLog.e("***"+result1.x+","+result1.y);//1200,191    982,118,1263,226
                    LtLog.e("***"+(result1.x-218)+","+(result1.y-73)+","+(result1.x+63)+","+(result1.y+35));//284,201  91,75,384,241
                    result = mFairy.findPic(result1.x-218, result1.y-73, result1.x+63, result1.y+35, "Finished2.png");
                    result2 = mFairy.findPic(result1.x-218, result1.y-73, result1.x+63, result1.y+35, "time finish.png");
                    LtLog.e("完成图标相似度==="+result.sim);
                    if (result.sim >= 0.8f) {
                        LtLog.e("不可以参加");
                        GameUtil.this.tastState = 2;
                        setTaskEnd();
                        return;
                    }
                    if (result2.sim >= 0.8f){
                        LtLog.e("做完了");
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 3, 1135,533, 1141,186, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中限时野外");
        return tastState;
    }


    /**
     * 找行侠副本
     * @param str
     * @throws Exception
     */
    public int xingxia(final String str) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                result = mFairy.findPic(8,4,261,67,"xia.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "行侠页面"));
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
                result = mFairy.findPic("dialogue.png");
                LtLog.e("=========================活动按钮相似度=="+result.sim);
                mFairy.onTap(0.8f, result, "行侠副本npc",Sleep+2000);
                result1 = mFairy.findPic(8,4,261,67,"xia.png");
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    LtLog.e("点击了错误得npc");
                    int ret =  mission("Chivalry.png",0);
                    switch (ret){
                        case 0:
                            LtLog.e("任务已完成");
                            GameUtil.this.tastState = 0;
                            setTaskEnd();return;
                        case 1:
                            LtLog.e("接取任务成功");
                            setTaskName(2);return;
                        case 2:
                            LtLog.e("任务还没解锁");
                            GameUtil.this.tastState = 0;
                            setTaskEnd();return;
                    }
                }else if (result1.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public   void content_2() throws Exception {
                //long dazeTime = mFairy.mMatTime(1170,124,88,21, 0.9f);
                result1 = mFairy.findPic(25,84,1267,305,str);//81,216    81,569,303,677
                //mFairy.onTap(0.8f, result1,result1.x-92,result1.y-100,result1.x-78,result1.y-90, "找到任务并点击",2000);//297,550   205,429,219,438

                if (result1.sim >= 0.8f) {
                    err =1;
                    LtLog.e("找到行侠副本");
                    result = mFairy.findPic(result1.x-1, result1.y+353, result1.x+222, result1.y+461,"Challenge2.png");
                    mFairy.onTap(0.8f, result, "可以参加点击",2000);
                    LtLog.e("--------------------"+result.sim);
                    if (result.sim >= 0.8f) {
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;

                    }

                    LtLog.e("***"+result1.x+","+result1.y);
                    LtLog.e("***"+(result1.x-1)+","+(result1.y+353)+","+(result1.x+222)+","+(result1.y+461));//284,201  91,75,384,241
                    result = mFairy.findPic(result1.x-1, result1.y+353, result1.x+222, result1.y+461,"Challengeover.png");
                    LtLog.e("完成图标相似度==="+result.sim);
                    if (result.sim >= 0.8f) {
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }

                }
                mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 3, 1144,326, 216,326, 1000, 4000);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "寻找行侠副本");
        return tastState;
    }

    /**
     * 清包
     */
    public void clearBag() throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            public void content_0() throws Exception {
                close();
                setTaskName(2);return;
            }
            public   void content_2() throws Exception {
                if (overtime(9, 99)){ timekeepInit("野外挂机清理背包");close(); return;}//计次并跳转

                result = mFairy.findPic("bag.png");
                mFairy.onTap(0.8f,result,"打开背包",3000);

                result= mFairy.findPic("prop.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, 1244, 253, 1250, 266, "背包界面内", Sleep);
                    result = mFairy.findPic(744, 59, 1215, 625, new String[]{"guozi.png","perplo box.png","box1.png", "Cultivation pill.png", "box2.png", "box3.png", "ling.png", "Vitality.png", "box4.png", "box5.png", "box6.png","box7.png","Vitality2.png"});
                    mFairy.onTap(0.9f, result, "物品", 2000);
                    if (result.sim > 0.9f) {
                        err--;
                        findtask++;
                        LtLog.e("*-****-"+findtask);
                        if (findtask>20){
                            timekeepInit("野外挂机清理背包");
                            setTaskEnd();return;
                        }
                    } else {
                        mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 0, 964, 562, 964, 225, 1000, 1500, 2);
                    }
                    result = mFairy.findPic(210, 92, 1059, 637, new String[]{"use.png","use2.png","use seed.png"});
                    mFairy.onTap(0.8f, result, "使用", Sleep);
                    // mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 3, 1144,326, 216,326, 1000, 4000);
                }
            }
        }.taskContent(mFairy, "清包");
    }

}
