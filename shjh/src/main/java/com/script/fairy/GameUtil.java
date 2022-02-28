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
                mFairy.sleep(4000);
                for (int i = 0; i < j; i++) {
                    mFairy.sleep(2000);
                    mFairy.condit();
                    result =mFairy.findPic("not prompt.png");
                    mFairy.onTap(0.8f,result,553,656,563,665,"不在提示",1500);

                    result = mFairy.findPic(2,1,127,109,new String[]{"close.png","close left top.png"});
                    mFairy.onTap(0.8f,result,"关闭",3000);
                    result1 = mFairy.findPic(1027,3,1276,166,new String[]{"close1.png","close right top.png","close right top2.png","close right top3.png"});
                    mFairy.onTap(0.8f,result1,"关闭",2000);
                    result2 = mFairy.findPic(1078,99,1280,262,new String[]{"close right top2.png"});
                    mFairy.onTap(0.8f,result2,"关闭",2000);

                    result =mFairy.findPic(new String[]{"Exit level.png","Exit level2.png","XTS.png"});
                    mFairy.onTap(0.8f,result,772,511,790,527,"确定退出",10000);

                    result3 = mFairy.findPic(870,111,1148,282,new String[]{"close1.png","close right top.png","close right top2.png","close right top3.png"});
                    mFairy.onTap(0.8f,result3,"关闭",2000);
                    if (result.sim > 0.8f || result1.sim > 0.8f || result2.sim > 0.8f || result3.sim > 0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                    result = mFairy.findPic(new String[]{"arbitrarily.png","RYi.png","Yi.png","screen.png"});
                    mFairy.onTap(0.8f,result,"任意位置继续",Sleep);

                }
                result = mFairy.findPic("hall.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "最外界面"));
                if (result.sim >0.8f){
                    setTaskEnd();return;
                }

            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

    /**
     * 姑瑶幻境  昆仑之虚  灾难之渊 入口
     * @param str
     * @throws Exception
     */
    public void currency(final String str) throws Exception {
        new GameUtil(mFairy) {
            /**
             * content_0流程控制
             * @throws Exception
             */
            public   void content_0() throws Exception {
                result = mFairy.findPic("hall.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "最外界面"));
                if (result.sim >0.8f){
                    setTaskName(1);return;
                }
                close();
                setTaskName(1);
            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(6,0))return;
                result = mFairy.findPic("hall.png");
                result1 = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f, result1, "组队", Sleep);
                if(result.sim > 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(0.8f, result, 1206,637,1218,646,"任务收纳栏", Sleep);
                }
                result = mFairy.findPic("team list.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }

            }

            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
           public   void content_2() throws Exception {
               result = mFairy.findPic("hall.png");
               if (result.sim > 0.8f){
                   LtLog.e(mFairy.getLineInfo(0.8f, result, "最外界面"));
                   setTaskName(1);return;
               }
               result = mFairy.findPic(152,139,376,598,str);
               mFairy.onTap(0.8f, result, "选择副本", Sleep);
               if (result.sim > 0.80f){
                   setTaskName(3);
               }
            }
            public   void content_3() throws Exception {
                result = mFairy.findPic("Establish team.png");
                mFairy.onTap(0.8f, result, "创建队伍", Sleep);
                result = mFairy.findPic("Establish.png");
                mFairy.onTap(0.8f, result, "创建", Sleep);
                result = mFairy.findPic("begin fight.png");
                mFairy.onTap(0.8f, result, "开始战斗", Sleep);

                result1 = mFairy.findPic("team.png");
               // result = mFairy.findPic("position.png");
                if (result1.sim > 0.80f){
                    result = mFairy.findPic("Trusteeship.png");
                    mFairy.onTap(0.8f, result, "开始", 3000);
                   setTaskEnd();return;
                }

            }
        }.taskContent(mFairy, "找任务中");
    }

    /**
     * 历练
     */
    public Integer toughening(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public   void content_0() throws Exception {
                if (findtask >= 2) {
                    LtLog.e("没有这个副本或者是没有开放");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                result = mFairy.findPic("hall.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "最外界面"));
                if (result.sim >0.8f){
                    setTaskName(1);return;
                }
                close();
                setTaskName(1);
            }
            /**
             * 打开历练并且寻找图
             */
            public  void content_1() throws Exception {
                if (overtime(6,0))return;
                result = mFairy.findPic("hall.png");
                result1 = mFairy.findPic("Experience2.png");
                mFairy.onTap(0.8f, result1, "历练", Sleep);
                if(result.sim > 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(0.8f, result, 1206,637,1218,646,"任务收纳栏", Sleep);
                }
                result = mFairy.findPic("Lian.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "历练界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(225,54,1280,225,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(106,172,122,186, "小隐村", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(117,262,130,275, "青丘国", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(110,355,130,367, "君子国", Sleep);
                        }
                        if (option == 3) {
                          //  mFairy.onTap(78,432,103,484, "休闲", Sleep);
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
                result1 = mFairy.findPic(225,54,1280,225,str);
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result1, "点击前往", 2000);
                    result = mFairy.findPic("begin Experience.png");
                    mFairy.onTap(0.8f, result, "进图", 10000);
                }
                result = mFairy.findPic("Lineup lock up.png");
                if (result.sim > 0.8f) {
                    LtLog.e("进入副本");
                    GameUtil.this.tastState = 1;
                    setTaskEnd();
                    return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4,}, 2, 1131,370, 560,371, 2000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找图中");
        return tastState;
    }

}
