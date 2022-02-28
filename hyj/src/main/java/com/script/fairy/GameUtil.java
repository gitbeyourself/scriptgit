package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.List;


/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    /**
     * 关叉
     * @param
     * @throws Exception
     */
    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result =mFairy.findPic(new String[]{"zzcha.png","scdbcha.png","yw.png","ylcha.png","tianzicha.png","dhcha.png","ggcha.png","ltcha.png","bbcha.png","rightcha.png","sevencha2.png","sevencha.png","cha.png","cha2.png","cha3.png","cha4.png","cha5.png","cha6.png","cha7.png","cha8.png","cha9.png","hdcha.png","jbcha.png","xsbcha.png","jycha.png","hdincha.png","flowercha.png","syjwccha.png","llkcha.png","zfcha.png","kjcha.png"});
                    LtLog.e("关闭方法关闭相似度===="+result.sim);
                    mFairy.onTap(0.75f,result,"关闭",3500);
                    result1 =mFairy.findPic(1056,12,1276,145,"givecha.png");
                    mFairy.onTap(0.75f,result1,"关闭",3500);
                    result2 =mFairy.findPic(1044,1,1280,184,"newcha.png");
                    mFairy.onTap(0.75f,result2,"关闭",3500);
                    if (result.sim > 0.75f|| result1.sim > 0.8f || result2.sim > 0.8f) {
                        j = 5;
                    } else {
                        j = 2;
                    }
                }
               setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

    /**
     * 找任务 并前往 单人日常
     * @param str
     * @param option
     * @return
     * @throws Exception
     */
    int tastState ;
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
                result = mFairy.findPic("Activeinterface.png");
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
                result = mFairy.findPic(955,10,1094,71,"activity.png");
                LtLog.e("=========================活动按钮相似度=="+result.sim);
                mFairy.onTap(0.8f, result, "活动",Sleep+2000);

                result = mFairy.findPic("Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(408,117,1255,439,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(79,167,104,210, "日常", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(77,263,100,297, "竞技", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(78,345,99,389, "挑战", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(78,432,103,484, "休闲", Sleep);
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
                result = mFairy.findPic(669,546,1267,643,"red.png");
                mFairy.onTap(0.8f,result,"领取活跃值奖励",2000);
                result1 = mFairy.findPic(408,117,1255,439,str);
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(result1.x-34, result1.y+183, result1.x+59, result1.y+235,"Go now.png");
                    //mFairy.onTap(0.8f, result, "点击前往", 2000);
                    LtLog.e("找到任务");
                    //result = mFairy.findPic( "GoGo.png");
                    mFairy.onTap(0.8f, result, "日常前往",2000);
                    mFairy.condit();
                    if (result.sim >= 0.8f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }//1175,299  1141,482,1234,534
                    result = mFairy.findPic(result1.x-3, result1.y+111, result1.x+73, result1.y+165, "Finished.png");
                    LtLog.e("完成图标相似度==="+result.sim);
                    if (result.sim >= 0.7f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 3, 1189,377, 704,394, 2000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }

    /**
     * 找任务  组队副本
     */
    public int seek(final String str, final int option) throws Exception {
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
                result = mFairy.findPic("Activeinterface.png");
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
                result = mFairy.findPic(955,10,1094,71,"activity.png");
                LtLog.e("=========================活动按钮相似度=="+result.sim);
                mFairy.onTap(0.8f, result, "活动",Sleep+2000);

                result = mFairy.findPic("Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(408,117,1255,439,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(79,167,104,210, "日常", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(77,263,100,297, "竞技", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(78,345,99,389, "挑战", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(78,432,103,484, "休闲", Sleep);
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
                result = mFairy.findPic(669,546,1267,643,"red.png");
                mFairy.onTap(0.8f,result,"领取活跃值奖励",2000);
                result1 = mFairy.findPic(408,117,1255,439,str);
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(result1.x-34, result1.y+183, result1.x+59, result1.y+235,"Go now.png");
                    LtLog.e("找到任务");
                   // mFairy.onTap(0.8f, result, "日常前往",2000);
                    if (result.sim >= 0.8f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(result1.x-3, result1.y+111, result1.x+73, result1.y+165, "Finished.png");
                    LtLog.e("完成图标相似度==="+result.sim);
                    if (result.sim >= 0.7f) {
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 ,8}, 3, 1189,377, 704,394, 2000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }
    /**
     * 领队 创建队伍
     */
    public void createTeam(final String str,final int option) throws Exception {
        new GameUtil(mFairy) {
            public  void content_0() throws Exception {
                result = mFairy.findPic("team3.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "队伍界面"));
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
                close();
                setTaskName(1);
            }
            /**
             * 创建队伍
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                mFairy.onTap(155,114,195,133,"组队蓝",2000);
                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                result = mFairy.findPic(3,85,251,156,"team.png");
                LtLog.e("=====================================组队栏相似度"+result.sim);
                mFairy.onTap(0.70f,result,"打开组队栏",2000);

//                result = mFairy.findPic("team2.png");
//                mFairy.onTap(0.8f, result, "打开组队平台",2000);
                result = mFairy.findPic("Establish.png");
               mFairy.onTap(0.8f,result,"创建队伍",2000);
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic("Team platform.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,1036,613,1083,639,"创建队伍",2000);
                    mFairy.condit();
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic("team3.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "队伍界面"));
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }
            /***
             * 切换队伍副本目标
             * @throws Exception
             */
            public void content_2() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("team3.png");
//                result1 = mFairy.findPic(148,89,505,166,str);
                if (result.sim > 0.8f) {
                    LtLog.e("切换队伍目标");
                    mFairy.onTap(0.8f, result,150,115,162,130, "切换队伍目标", 2000);
                    if (option == 0){
                        mFairy.onTap(198,237,227,260, "日常", 2000);
                    }
                    if (option == 1) {
                        mFairy.onTap(211,300,243,319, "竞技", 2000);
                    }
                    if (option == 2) {
                        mFairy.onTap(214,361,259,378, "挑战", 2000);
                    }
                    if (option == 3) {
                        mFairy.onTap(208,420,245,444, "周末活动", 2000);
                    }
                    setTaskName(3);
                }

            }
            public void content_3() throws Exception {
                if (overtime(8, 0)) return;//计次并跳转
                result = mFairy.findPic(304,165,630,597,str);
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"选择队伍目标",2000);
                    mFairy.onTap(0.8f,result,519,621,568,648,"确定队伍目标",2000);
                    number();
                    if (tastState ==1){
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0,  446,558, 456,265,2000, 1500);
            }
        }.taskContent(mFairy, "创建组队==领队");
    }

    public void number() throws Exception{
        new GameUtil(mFairy) {
            public  void content_0() throws Exception {
                result = mFairy.findPic("team3.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "队伍界面"));
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
                close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                result = mFairy.findPic(3,85,251,156,new String[]{"team.png","team4.png"});
                LtLog.e("=====================================组队栏相似度"+result.sim);
                mFairy.onTap(0.75f,result,"切换组队栏",2000);

                result = mFairy.findPic("Establish.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "创建队伍"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic("team2.png");
                mFairy.onTap(0.8f, result, "打开组队平台",2000);
                setTaskName(2);
            }
            public  void content_2() throws Exception {
                //long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                boolean dazeTime = timekeep(1,40000,"喊话");
                result = mFairy.findPic("team3.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.8f,result,"自动匹配",Sleep);
                    result = mFairy.findPic(755,504,1139,591,new String[]{"position.png","position2.png"});
                    if (result.sim > 0.8f){
                        mFairy.onTap(684,616,725,634,"人数大于等于4人前往副本",3000);
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }
                    if (dazeTime){
                        result = mFairy.findPic("Shouting.png");
                        mFairy.onTap(0.8f,result,"喊话",2000);
                        mFairy.onTap(0.8f,result,759,557,827,585,"招募频道发布",2000);
                        timekeepInit("喊话");
                    }

                }
            }

        }.taskContent(mFairy,"判断人数 并喊话");
    }

    /**
     *  跟队 找队伍
     */
    public void seekTeam(final String str,final int option) throws Exception {
        new GameUtil(mFairy) {
            public  void content_0() throws Exception {
                result = mFairy.findPic("team3.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "队伍界面"));
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Team platform.png");
                if (result.sim >0.8f){
                    setTaskName(3);return;
                }
                close();
                setTaskName(1);
            }
            /**
             * 寻找队伍
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                mFairy.onTap(155,114,195,133,"组队栏",2000);
                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                result = mFairy.findPic(3,85,251,156,"team.png");
                LtLog.e("=====================================组队栏相似度"+result.sim);
                mFairy.onTap(0.70f,result,"打开组队栏",2000);

                result = mFairy.findPic("Team platform.png");
                if (result.sim > 0.8f){
                   // mFairy.onTap(0.8f,result,1036,613,1083,639,"创建队伍",2000);
                    mFairy.condit();
                    setTaskName(2);
                    return;
                }
            }
            /***
             * 切换队伍副本目标
             * @throws Exception
             */
            public void content_2() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("Team platform.png");
//                result1 = mFairy.findPic(148,89,505,166,str);
                if (result.sim > 0.8f) {
                    LtLog.e("切换队伍目标");
                    mFairy.onTap(0.8f, result,214,110,264,127, "切换队伍目标", 2000);
                    if (option == 0){
                        mFairy.onTap(198,237,227,260, "日常", 2000);
                    }
                    if (option == 1) {
                        mFairy.onTap(211,300,243,319, "竞技", 2000);
                    }
                    if (option == 2) {
                        mFairy.onTap(214,361,259,378, "挑战", 2000);
                    }
                    if (option == 3) {
                        mFairy.onTap(208,420,245,444, "周末活动", 2000);
                    }
                    setTaskName(3);
                }

            }
            public void content_3() throws Exception {
                if (overtime(8, 0)) return;//计次并跳转
                result = mFairy.findPic(304,165,630,597,str);
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"选择队伍目标",2000);
                    mFairy.onTap(0.8f,result,519,621,568,648,"确定队伍目标",2000);
                    //number();

                    result = mFairy.findPic(959,89,1145,158,"auto.png");
                    mFairy.onTap(0.8f,result,"自动匹配",Sleep);

                    List<FindResult> findResults =  mFairy.findPic(965,159,1129,572,0.8f,"Apply.png");
                    for (int i =0 ; i<findResults.size();i++){
                        mFairy.onTap(0.8f,findResults.get(i),"申请入队",Sleep);
                    }
                    result = mFairy.findPic("team3.png");
                    LtLog.e(mFairy.getLineInfo(0.8f, result, "队伍界面"));
                    if (result.sim > 0.8f) {
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 2,  446,558, 456,265,2000, 1500);
            }
        }.taskContent(mFairy, "寻找组队==跟队");
    }

    /**
     * 传送城市
     */
    int cityCount;
    public int goCity(final String str) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close();
                setTaskName(2);
                return;
            }

            public void content_2() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic(904,2,1066,89,"activity.png");
                mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);

                result1 = mFairy.findPic("Current map.png");
                result = mFairy.findPic("word map.png");
                mFairy.onTap(0.8f, result, "切换到世界", Sleep);
                if (result1.sim > 0.8f) {
                    switch (str) {
                        case "韦剑山庄":
                            mFairy.onTap(0.8f, result1, 597,591,610,620, str, Sleep);
                            break;
                        case "长安":
                            mFairy.onTap(0.8f, result1, 899,311,911,330, str, Sleep);
                            break;
                        case "墨圣山庄":
                            mFairy.onTap(0.8f, result1, 202,427,222,451, str, Sleep);
                            break;
                        case "雪域幻境":
                            mFairy.onTap(0.8f, result1, 721,231,738,249, str, Sleep);
                            break;
                        case "文墨轩":
                            mFairy.onTap(0.8f, result1, 535,344,554,368, str, Sleep);
                            break;
                        case "御龙峰":
                            mFairy.onTap(0.8f, result1, 412,166,434,184, str, Sleep);
                            break;

                    }
                    setTaskName(3);
                    return;
                }
            }
            public void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(604,52,63,12, 0.9f);
                if (dazeTime > 3) {
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    GameUtil.this.cityCount = 1;
                    setTaskEnd();
                    return;
                }
                Thread.sleep(5000);
            }
        }.taskContent(mFairy, "传送城市中");
        return cityCount;
    }

    /**
     * 生活技能制作炼药
     */

    public void makingMedicine(final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                result = mFairy.findPic(new String[]{"makegongyi.png","cooking.png","makequipment.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "制作界面"));
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
                result = mFairy.findPic("Entrance.png");
                mFairy.onTap(0.8f, result, "入口",2000);
                result = mFairy.findPic("makeinto.png");
                mFairy.onTap(0.8f, result, "入口2",2000);
                result = mFairy.findPic(new String[]{"makegongyi.png","cooking.png","makequipment.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "制作界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    if (option == 0){
                        mFairy.onTap(1187,112,1204,155, "制作", Sleep);
                    }
                    if (option == 1) {
                        mFairy.onTap(1187,207,1205,256, "烹饪", Sleep);
                    }
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "打开工艺");
    }

    /**
     * 制作
     */
    public int woodWork(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public void content_0() throws Exception {
                result = mFairy.findPic("makegongyi.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "工艺界面"));
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
                result = mFairy.findPic("makegongyi.png");
               // mFairy.onTap(1187,112,1204,155, "制作", Sleep);
                LtLog.e(mFairy.getLineInfo(0.8f, result, "制作"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(408,117,1255,439,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(53,563,78,589, "材料", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(63,501,85,529, "工具", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(63,436,79,470, "时装", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(60,368,84,401, "鞍具", Sleep);
                        }
                        if (option == 4) {
                            mFairy.onTap(59,310,79,344, "器物", Sleep);
                        }
                        if (option == 5) {
                            mFairy.onTap(62,242,84,279, "载具", Sleep);
                        }
                        if (option == 6) {
                            mFairy.onTap(62,181,78,215, "伞具", Sleep);
                        }
                        if (option == 7) {
                            mFairy.onTap(64,117,81,153, "礼物", Sleep);
                        }
                    }
                    findtask++;
                    if (findtask > 2){
                        setTaskName(0);
                    }
                    setTaskName(2);
                }else {
                    makingMedicine(0);
                }
            }
            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public   void content_2() throws Exception {
                result1 = mFairy.findPic(82,75,343,644,str);
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f,result1,"点击需要制作的道具",2000);
                    LtLog.e("找到道具");
                    GameUtil.this.tastState = 1;
                    setTaskEnd();
                    return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8,10,12,14,16}, 4, 206,563, 185,227, 2000, 1500);
                if (overtime(16, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找道具");
        return tastState;
    }


    /**
     * 寻找npc
     */
    public int findnpc(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public void content_0() throws Exception {
                result = mFairy.findPic(new String[]{"Current map.png","word map.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "地图界面"));
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
                result = mFairy.findPic("activity.png");
                mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                result = mFairy.findPic("visit.png");
                mFairy.onTap(0.8f, result, "拜访", 2000);
                result = mFairy.findPic("Automatic visit.png");
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(935,138,1186,665,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 1){
                            mFairy.onTap(1106,95,1120,115, "无忧卷", Sleep);
                        }
                        if (option == 0) {
                            mFairy.onTap(983,105,1000,112, "情缘卷", Sleep);
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
                result1 = mFairy.findPic(935,138,1186,665,str);
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f,result1,"点击要拜访的npc",2000);
                    if(result1.sim>0.8f){
                        setTaskName(3);return;
                    }
                }

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 1065,596, 1059,219, 2000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
            public  void content_3() throws Exception {
                long dazeTime=mFairy.mMatTime(1205,54,26,12,0.9f);

                result = mFairy.findPic(934,223,1250,604,"visit2.png");
                mFairy.onTap(0.75f, result, "拜访", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(4,2,178,55,"Acquaintance.png");
                if(result.sim>0.8f){
                    LtLog.e("npc界面");
                    GameUtil.this.tastState = 1;
                    setTaskEnd();
                    return;
                }
                if (dazeTime >= 30 && result.sim < 0.8f){

                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "找npc");
        return tastState;
    }
}
