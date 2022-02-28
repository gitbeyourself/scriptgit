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
            int i =0;
            public void content_0() throws Exception {
                i =  mFairy.getColorNum(672,550,730,603,"255,255,255",0.92f);
                LtLog.e("自动颜色"+i);
                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                if(i>200 && result.sim > 0.8f){
                    mFairy.onTap(692,574,706,582,"关自动",Sleep);
                }

                result2=mFairy.findPic("target.png");
                mFairy.onTap(0.7f,result2,692,574,706,582,"关自动",Sleep);

                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result =mFairy.findPic(977,3,1274,181,new String[]{"cha4.png","close right top 1.png","close right top 2.png","close right top 3.png","close right top 4.png","close top right.png"});
                    mFairy.onTap(0.8f,result,"关闭",2000);
                    result1=mFairy.findPic(new String[]{"cha.png","Cancel fishing.png","cha2.png"});
                    mFairy.onTap(0.7f,result1,"关自动",Sleep);
                    result2=mFairy.findPic(790,252,983,471,"cha3.png");
                    mFairy.onTap(0.7f,result2,"关闭继续挖宝",Sleep);
                    if (result.sim > 0.8f ||result1.sim > 0.8f||result2.sim >0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                }
                setTaskEnd();
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
                result = mFairy.findPic("Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "每日必做界面"));
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
                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);

                result = mFairy.findPic("Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动大厅界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(20,89,1109,214,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(1171,131,1186,145, "必做任务", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(1186,217,1202,232, "限时活动", Sleep);
                            setTaskName(3);
                            return;
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
                result = mFairy.findPic(41,469,1080,588,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);
                if (result.sim > 0.8f){
                    return;
                }

                result1 = mFairy.findPic(20,89,1109,214,str);
                if (result1.sim > 0.8f) {
                    LtLog.e("找到任务");//804，131    779,447,910,508   781,491,914,561
                    //LtLog.e("x,"+(result1.x-25)+"y,"+(result1.y-316)+"x,"+(result1.x+106)+"y,"+(result1.y+377));
                    result = mFairy.findPic(result1.x-25, result1.y+316, result1.x+106, result1.y+377, "Finished.png");
                    if (result.sim >= 0.8f){
                        LtLog.e("任务做完了");
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(result1.x-23, result1.y+360, result1.x+110, result1.y+430, "Unlock.png");
                    if (result.sim >0.8f) {
                        LtLog.e("没解锁");
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                    LtLog.e("x,"+result1.x+"y,"+result1.y);
                   // LtLog.e("x,"+(result1.x-118)+"y,"+(result1.y-275)+"x,"+(result1.x+26)+"y,"+(result1.y+376));
                    result = mFairy.findPic(result1.x-23, result1.y+360, result1.x+110, result1.y+430, "go now2.png");
                    mFairy.onTap(0.8f, result, "可以参加点击", 2000);
                    if (result.sim >0.8f) {
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                }
                mFairy.taskSlid(err, new int[]{0, 4, 8}, 0, 995,330, 265,350, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }

            public   void content_3() throws Exception {
                result = mFairy.findPic(41,469,1080,588,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);
                if (result.sim > 0.8f){
                    return;
                }

                result1 = mFairy.findPic(50,87,1073,684,str);
                if (result1.sim > 0.8f) {
                    LtLog.e("找到任务");//629,98  925,127,1067,224
                    result = mFairy.findPic(result1.x+296, result1.y+29, result1.x+438, result1.y+126, new String[]{"not begin.png","not tomday.png","Finished.png"});
                    if (result.sim >= 0.8f){
                        LtLog.e("完成了或者没有开始或者不是今天");
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                    //result = mFairy.findPic(result1.x-41, result1.y+321, result1.x+98, result1.y+377, "Finished.png");
                   // LtLog.e("x,"+result1.x+"y,"+result1.y);
                    // LtLog.e("x,"+(result1.x-118)+"y,"+(result1.y-275)+"x,"+(result1.x+26)+"y,"+(result1.y+376));
                    result = mFairy.findPic(result1.x+296, result1.y+29, result1.x+438, result1.y+126, "join1.png");
                    mFairy.onTap(0.8f, result, "可以参加点击", 2000);
                    if (result.sim >0.8f) {
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }

                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6, 8}, 0, 766,561, 758,140, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }

        }.taskContent(mFairy, "找任务中");
        return tastState;
    }

    /**
     * 组队
     * @param str
     * @throws Exception
     */
    public void createTeam(final String str,final int option) throws Exception {
        new GameUtil(mFairy) {
            public  void content_0() throws Exception {
                close();
                setTaskName(1);
            }
            /**
             * 创建队伍
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("left team.png");
                mFairy.onTap(0.8f, result, "左侧组队栏",2000);

                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);

                result = mFairy.findPic("left team2.png");
                mFairy.onTap(0.8f, result, "左侧组队栏",2000);

                result = mFairy.findPic(new String[]{"establish team.png","establish team2.png"});
                mFairy.onTap(0.8f, result, "创建队伍",Sleep);

                result = mFairy.findPic("Target setting.png");
                mFairy.onTap(0.8f, result, "目标设置",Sleep);

                result = mFairy.findPic("Team goal.png");
                if (result.sim> 0.8f){
                    setTaskName(2);
                }
            }
            /***
             * 切换队伍副本目标
             * @throws Exception
             */
            public void content_2() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("Team goal.png");
                if (result.sim > 0.8f) {
                    LtLog.e("切换队伍目标");
                   // mFairy.onTap(0.8f, result,150,115,162,130, "切换队伍目标", 2000);
                    if (option == 0){
                        mFairy.onTap(147,227,159,235, "身份", 2000);
                    }
                    if (option == 1) {
                        mFairy.onTap(165,306,176,312, "话本", 2000);
                    }
                   /* if (option == 2) {
                        mFairy.onTap(214,361,259,378, "挑战", 2000);
                    }
                    if (option == 3) {
                        mFairy.onTap(208,420,245,444, "周末活动", 2000);
                    }*/
                    setTaskName(3);
                }

            }
            public void content_3() throws Exception {
                if (overtime(8, 0)) return;//计次并跳转
                result = mFairy.findPic(300,114,1213,582,str);
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"选择队伍目标",2000);
                    mFairy.onTap(0.8f,result,1102,617,1112,629,"确定队伍目标",2000);
                    //判断人数
                    setTaskName(4);
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0,  630,506, 625,223,2000, 1500);
            }
            public void content_4() throws Exception {
                result = mFairy.findPic("left team.png");
                mFairy.onTap(0.8f, result, "左侧组队栏",2000);

                boolean dazeTime = timekeep(1,60000,"喊话");
                if (dazeTime) {
                    result = mFairy.findPic("Shouting.png");
                    mFairy.onTap(0.8f, result, "喊话", 2000);

                    result = mFairy.findPic("release.png");
                    mFairy.onTap(0.8f, result, "发布", Sleep);
                    timekeepInit("喊话");
                }

                result = mFairy.findPic("auto2.png");
                result1 = mFairy.findPic(new String[]{"zu team.png","zu team2.png"});
                if (result.sim < 0.8f && result1.sim >0.8f){
                    mFairy.onTap(224,658,234,668,"自动接受申请",Sleep);
                }
                result = mFairy.findPic("people four.png");
                if (result.sim < 0.8f && result1.sim > 0.8f){
                    result = mFairy.findPic("call together.png");
                    mFairy.onTap(0.8f, result, "召集", 2000);

                    result = mFairy.findPic("call together2.png");
                    mFairy.onTap(0.8f, result, 725,501,733,510,"确定召集", Sleep);
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                }

            }
        }.taskContent(mFairy, "创建组队==领队");
    }


    /**
     * 回 开封
     * @throws Exception
     */
    public void backcity() throws Exception {
        new GameUtil(mFairy) {
            public  void content_0() throws Exception {
                close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (overtime(8, 99)){ close(); return;}
                result = mFairy.findPic("map.png");
                mFairy.onTap(0.8f,result,"地图",Sleep);

                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                mFairy.onTap(0.8f, result, 1164,50,1173,61,"世界任务先打开地图",2000);

                result = mFairy.findPic("kaifeng.png");
                if (result.sim > 0.8f){
                    err=99;
                }else {
                    result = mFairy.findPic("word.png");
                    mFairy.onTap(0.8f,result,"世界地图",2000);

                    result = mFairy.findPic("kaifeng2.png");
                    mFairy.onTap(0.8f,result,"开封",2000);

                }
                result = mFairy.findPic("kezhan.png");
                mFairy.onTap(0.8f,result,"客栈",2000);

                result = mFairy.findPic("Transmission confirmation.png");
                mFairy.onTap(0.8f,result,721,501,733,508,"传送确认",5000);

            }
        }.taskContent(mFairy, "回开封");
    }


}
