package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;

    YxdUtil yxdUtil_1;
    YxdUtil yxdUtil_2;
    YxdUtil yxdUtil_3;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        Sleep = 100;
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);
        yxdUtil_1 = new YxdUtil(mFairy);
        yxdUtil_2 = new YxdUtil(mFairy);
        yxdUtil_3 = new YxdUtil(mFairy);

    }

    @Override
    public void inOperation() throws Exception {
        result = mFairy.findPic("skip.png");
        mFairy.onTap(0.8f, result, "跳过", 2000);

        result = mFairy.findPic("Loading.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }

    }
    /**
     * 新手指引（主线任务）
     *
     * @throws Exception
     */
    public void plotTask() throws Exception {
        new SingleTask(mFairy) {
            boolean sd = true;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public void content_1() throws Exception {
                result = mFairy.findPic( "jixu2.png");
                if (result.sim > 0.8f && sd) {
                    setTaskName(2);
                    return;
                }else {
                    result = mFairy.findPic(48, 129, 136, 224, "online.png");
                    mFairy.onTap(0.8f, result, "主线", 3000);
                }
                /*result = mFairy.findPic(48, 129, 136, 224, "online.png");
                mFairy.onTap(0.8f, result, "主线", 3000);*/

                result = mFairy.findPic(new String[]{"Make a fire.png","xuanqu.png","give2.png","Shouting2.png","Sacrifice wine.png","rise.png","shouji.png","collection.png","Search.png","light.png","roster.png","write letters.png","eat.png","View.png","visit.png","bowl.png","observation.png"});
                mFairy.onTap(0.8f, result, "动作", 5000);

                result = mFairy.findPic("new people.png");
                mFairy.onTap(0.8f, result, "新手", 2000);
                mFairy.onTap(0.8f, result, 628,579,639,588,"确定", Sleep);

                result = mFairy.findPic("left.png");
                if (result.sim > 0.8f){
                    mFairy.ranSwipe(180,515,286,518,1000,1000);
                }

                result = mFairy.findPic(46,132,150,255,new String[]{"repel.png","eliminate.png","black.png","bai.png","lesson.png"});
                if (result.sim > 0.7f){
                    for (int i =0 ; i <20 ; i++) {
                        mFairy.onTap(1108, 583, 1125, 591, "黑衣人", 200);
                    }
                }

                result = mFairy.findPic("zhonghuaji.png");
                mFairy.onTap(0.8f, result, 1212,314,1225,322,"重华技", Sleep);

                result = mFairy.findPic(new String[]{"hand.png","lashou.png"});
                mFairy.onTap(0.7f, result, "拉手", Sleep);

//                result = mFairy.findPic(812,189,812,189,new String[]{"Good feeling.png","dialogue.png"});
//                mFairy.onTap(0.8f, result, 989,250,998,256,"对话选择默认第一个", Sleep);

                result = mFairy.findPic("review.png");
                mFairy.onTap(0.8f, result, 995,233,1003,238,"对话选择默认第一个", 2000);

              /*  result = mFairy.findPic("camp.png");
                mFairy.onTap(0.8f, result, 1035,172,1044,179,"对话选择默认第一个", Sleep);*/

                result = mFairy.findPic("review.png");
                mFairy.onTap(0.8f, result, 1035,172,1044,179,"对话选择默认第一个", 2000);

                result = mFairy.findPic("QingYongFang.png");
                mFairy.onTap(0.8f, result, "去清永芳", Sleep);

                result = mFairy.findPic("xin.png");
                mFairy.onTap(0.8f, result, 1007,518,1018,528,"信 ", Sleep);

                result = mFairy.findPic("chapter.png");
                mFairy.onTap(0.8f, result, 1231,18,1238,27,"章节 ", Sleep);

                result = mFairy.findPic("wan.png");
                mFairy.onTap(0.8f, result, "万 ", 2000);
                mFairy.onTap(0.8f, result, 1196,60,1206,70,"叉 ", Sleep);

                result = mFairy.findPic("jie.png");
                mFairy.onTap(0.8f, result, 268,392,280,406,"解控止 ", Sleep);

                result = mFairy.findPic("shop.png");
                mFairy.onTap(0.8f, result, 1242,17,1251,27,"商城关闭 ", Sleep);

                result = mFairy.findPic("drug.png");
                mFairy.onTap(0.8f, result, 1212,205,1220,214,"菜单 ", 2000);

                result = mFairy.findPic("role.png");
                mFairy.onTap(0.8f, result, 921,98,933,105,"角色 ", 2000);

                result = mFairy.findPic("wuxue2.png");
                mFairy.onTap(0.8f, result, 1185,25,1200,36,"武学界面再次打开 ", 2000);

                result = mFairy.findPic("Qi and blood.png");
                mFairy.onTap(0.8f, result, 780,262,787,270,"气血1", 2000);
                mFairy.onTap(0.8f, result, 784,542,795,552,"气血2", 2000);
                mFairy.onTap(0.8f, result, 439,49,448,57,"气血3", 2000);
                mFairy.onTap(0.8f, result, 1242,166,1251,174,"气血4", 2000);
                mFairy.onTap(0.8f, result, 1238,164,1252,178,"气血5", 2000);
                mFairy.onTap(0.8f, result, 1244,20,1252,28,"气血6", 2000);

                result = mFairy.findPic( "set.png");
               if (result.sim > 0.8f){
                   gameUtil.close();
               }

                result = mFairy.findPic( "eagle.png");
                mFairy.onTap(0.8f, result, "老鹰", 2000);

                result = mFairy.findPic( "direct.png");
                mFairy.onTap(0.8f, result, "直接完成", 2000);

                result = mFairy.findPic( "jump.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic( "wunian.png");
                mFairy.onTap(0.8f, result, "无念", Sleep);

                result = mFairy.findPic( "yinshen.png");
                mFairy.onTap(0.8f, result, "隐身", 3000);

                result = mFairy.findPic("Notice.png");
                if (result.sim > 0.8f){
                    LtLog.e("剧情下回预告结束了");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("renyi.png");
                mFairy.onTap(0.8f, result, "任意地方关闭 ", 1000);

               /* result = mFairy.findPic("jia2.png");
                mFairy.onTap(0.8f, result, "甲 ", 1000);
*/
                result = mFairy.findPic("note.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(result.x,result.y);
                    mFairy.sleep(2000);
                    mFairy.touchUp();

                    setTaskName(3);return;
                }

                /*result = mFairy.findPic("expression.png");
                mFairy.onTap(0.8f, result, 347,683,361,695,"表情", 1000);

                result = mFairy.findPic("function.png");
                mFairy.onTap(0.8f, result, "功能", 1000);*/

                result = mFairy.findPic(new String[]{"video.png","three seven.png"});
                mFairy.onTap(0.8f, result, 1187,25,1196,41,"身份玩法37级开启", 1000);

                result = mFairy.findPic(297,311,980,499,new String[]{"Iron plate.png","Iron plate2.png"});
                mFairy.onTap(0.75f, result, "骨牌 ", 2000);

                result = mFairy.findPic("leave3.png");
                mFairy.onTap(0.8f, result, "确认离开 ", 1000);

                result = mFairy.findPic("signature over.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f, result, 1154,235,1164,245,"旁边", 1000);
                   gameUtil.close();
                }
            }

            public void content_2() throws Exception {
                if (overtime(6,1)){gameUtil.close();return;}
                result = mFairy.findPic(47,157,149,317,"guide.png");
                mFairy.onTap(0.8f, result, "引导", 2000);

                result = mFairy.findPic(40,219,226,343,new String[]{"black.png","bai.png","lesson.png"});
                if (result.sim > 0.7f){
                    err=0;
                    for (int i =0 ; i <10 ; i++) {
                        mFairy.onTap(1108, 583, 1125, 591, "黑衣人", 200);
                    }
                }

                result = mFairy.findPic("review.png");
                mFairy.onTap(0.8f, result, 995,233,1003,238,"对话选择默认第一个", 2000);

                result = mFairy.findPic(new String[]{"give2.png","Shouting2.png","Sacrifice wine.png","rise.png","shouji.png","collection.png","Search.png","light.png","roster.png","write letters.png","eat.png","View.png","visit.png","bowl.png","observation.png"});
                mFairy.onTap(0.8f, result, "动作", 5000);

                result = mFairy.findPic(new String[]{"zhaomu.png","partner.png","chong.png","upgrade.png","Seiko.png"});
                mFairy.onTap(0.8f, result, 1212,205,1220,214,"菜单", 2000);

                result = mFairy.findPic(621,456,752,535,"zhaomu.png");
                mFairy.onTap(0.8f, result, 1208,601,1219,611,"招募", 2000);
                mFairy.onTap(0.8f, result, 499,543,514,552,"招募", 2000);
                mFairy.onTap(0.8f, result, 1242,21,1252,29,"招募叉", 2000);

                result = mFairy.findPic(344,270,500,356,"partner.png");
                mFairy.onTap(0.8f, result, 925,202,936,213,"伙伴", 2000);

                result = mFairy.findPic("hu.png");
                mFairy.onTap(0.8f, result, 223,293,230,302,"合成胡小宝", 2000);
                mFairy.onTap(0.8f, result, 835,603,851,620,"升一级", 2000);
                mFairy.onTap(0.8f, result, 1243,17,1250,26,"叉", 2000);

                result = mFairy.findPic("Must do.png");
                mFairy.onTap(0.8f, result, 1071,200,1080,209,"必做", 2000);

                result = mFairy.findPic("auspiciousness.png");
                mFairy.onTap(0.8f, result, 132,524,142,533,"祈福", 2000);

                result = mFairy.findPic("auspiciousness2.png");
                mFairy.onTap(0.8f, result, 646,604,657,610,"祈福2", 2000);

                result = mFairy.findPic("signature2.png");
                mFairy.onTap(0.8f,result,"求签2",3000);

                result = mFairy.findPic("signature over.png");
                if (result.sim >0.8f){
                   setTaskName(0);return;
                }

                result = mFairy.findPic(481,182,671,267,new  String[]{"upgrade.png","wuxue.png"});
                mFairy.onTap(0.8f, result, 1022,97,1032,113,"武学", 2000);

                result = mFairy.findPic("strengthen.png");
                mFairy.onTap(0.8f, result, 1118,103,1134,115,"强化", 2000);

                result = mFairy.findPic("Meridians.png");
                mFairy.onTap(0.8f, result, 1203,210,1212,220,"经脉", 2000);

                result = mFairy.findPic("chong2.png");
                mFairy.onTap(0.8f, result, "冲穴", 2000);
                mFairy.onTap(0.8f, result, 1242,16,1253,28,"冲穴cha", 2000);

                result = mFairy.findPic("jian.png");
                mFairy.onTap(0.8f, result, "一键升级", 2000);
                mFairy.onTap(0.8f, result, 1242,16,1253,28,"一键升级cha", 2000);

                result = mFairy.findPic("five.png");
                mFairy.onTap(0.8f, result, "升5级", 2000);
                mFairy.onTap(0.8f, result, 1242,16,1253,28,"升5级cha", 2000);

                result = mFairy.findPic("Block.png");
                mFairy.onTap(0.8f, result, 1026,314,1034,320,"格挡", 2000);

                result = mFairy.findPic("qinglong.png");
                mFairy.onTap(0.8f, result, "青龙会", 2000);
                mFairy.onTap(0.8f, result, 649,530,660,538,"签署", 2000);

                result = mFairy.findPic("qinglong2.png");
                mFairy.onTap(0.8f, result, 1237,24,1251,36,"叉", 2000);

                result = mFairy.findPic("fast.png");
                mFairy.onTap(0.8f, result, "快速加入", 2000);

                result = mFairy.findPic("gang.png");
                mFairy.onTap(0.8f, result, 1243,17,1253,24,"加入帮了 叉", 2000);

                result = mFairy.findPic("sure.png");
                mFairy.onTap(0.8f, result, "同意", 2000);
                mFairy.onTap(0.8f, result, 1034,138,1043,147,"叉", 2000);

                result = mFairy.findPic("zhongji.png");
                mFairy.onTap(0.8f,result,"中级签到",2000);
                mFairy.onTap(0.8f,result,1225,16,1236,26,"中级签到完了cha",Sleep);

                result = mFairy.findPic("Good feeling2.png");
                mFairy.onTap(0.8f, result, 1212,205,1220,214,"好感 菜单", 2000);
                mFairy.onTap(0.8f, result, 918,304,929,312,"好感", 2000);
                mFairy.onTap(0.8f, result, 121,307,134,319,"胡小宝", 2000);

                result = mFairy.findPic("photograph.png");
                mFairy.onTap(0.8f, result, "拍照", 2000);
                mFairy.onTap(0.8f, result, 1170,349,1179,361,"叉", 3000);
                mFairy.onTap(0.8f, result, 1208,33,1218,40,"叉", 2000);

                result = mFairy.findPic("jia2.png");
                mFairy.onTap(0.8f, result, "甲 ", 1000);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("note.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(result.x,result.y);
                    mFairy.sleep(2000);
                    mFairy.touchUp();

                    setTaskName(3);return;
                }

                result = mFairy.findPic("huxiaobao.png");
                mFairy.onTap(0.8f, result, 1230,17,1235,26,"叉", 2000);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic(new String[]{"Iron plate.png","Iron plate2.png"});
                if (result.sim > 0.75f){
                    mFairy.ranSwipe(400,382,737,414,1000,1000);
                }

                result = mFairy.findPic(297,311,980,499,new String[]{"Iron plate.png","Iron plate2.png"});
                mFairy.onTap(0.75f, result, "骨牌 ", 2000);

                result = mFairy.findPic("leave3.png");
                mFairy.onTap(0.8f, result, "确认离开 ", 1000);
            }
            public void content_3() throws Exception{
                result = mFairy.findPic(194,234,1056,563,"note.png");
                mFairy.onTap(0.8f,result,"音符",Sleep);

                result = mFairy.findPic(48, 129, 136, 224, "online.png");
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "新手指引");
    }

    /**
     * 世界任务
     * @throws Exception
     */
    public void wordTask() throws Exception {
        new SingleTask(mFairy) {
            int peg =0;
            boolean bz =false;
            int num = 0;
            boolean wz = true;
            int fz = 0;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6, 2)) return;

                result = mFairy.findPic("Withdraw.png");
                mFairy.onTap(0.7f,result,"退队",3000);
                mFairy.onTap(0.7f,result,704,507,724,515,"确认退队",Sleep);

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.7f,result,"显示任务",Sleep);

                result1 = mFairy.findPic("social contact.png");
                result = mFairy.findPic("duties.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic(43,72,275,285,"JangHu.png");
                    mFairy.onTap(0.7f,result,"江湖栏",Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }

                result = mFairy.findPic("task.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic(125,139,313,648,"shijie.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);

                    result = mFairy.findPic("qianwang.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1134,86,1153,102,"世界任务",Sleep);
                    }
                }


                result=mFairy.findPic(new String[]{"JangHu2.png","JangHuvx.png"});
                if(result.sim>=0.8f){
                    result=mFairy.findPic("appointment.png");
                    result1=mFairy.findPic("over.png");
                    if (result.sim>0.7f && result1.sim < 0.8f){
                        mFairy.onTap(0.7f,result,"帮派委任",Sleep);
                        setTaskName(3);
                        return;
                    }
                    result=mFairy.findPic(47,122,159,315,new String[]{"menpai3.png","menpai4.png"});
                    mFairy.onTap(0.7f,result,"门派任务",Sleep);
                    if (result.sim>0.7f){
                        setTaskName(4);
                        return;
                    }

                    result=mFairy.findPic(new String[]{"word left.png","word3.png"});
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);
                    if (result.sim>0.7f){
                        setTaskName(5);
                        return;
                    }
                    mFairy.taskSlid(err, new int[]{ 1, 3, 5}, 0, 136,198,136,314, 1000, 1500,1);
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("map.png");
                mFairy.onTap(0.8f,result,"地图",Sleep);

                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                mFairy.onTap(0.8f, result, 1164,50,1173,61,"世界任务先打开地图",2000);

                result = mFairy.findPic("word lan.png");
                mFairy.onTap(0.8f,result,"左侧地图收纳栏",Sleep);

                if (bz==false) {
                    result = mFairy.findPic(346, 8, 431, 455, "shouna.png");
                    mFairy.onTap(0.7f, result, "收纳", Sleep);
                    if (result.sim > 0.8f) {
                        return;
                    }
                }
                switch (peg){
                    case 0:
                        bz = true;
                        result2 = mFairy.findPic("bang2.png");
                        mFairy.onTap(0.8f,result2,"帮派任务",Sleep);

                        result1 = mFairy.findPic(162,10,324,446,"bang.png");
                        if (result1.sim > 0.8f){//223,55  325,75,435,158
                            result = mFairy.findPic(result1.x+151,result1.y+43,result1.x+234,result1.y+109,"finish.png");
                           if (result.sim >= 0.8f){
                               peg=1;
                               bz = false;
                           }else {
                               mFairy.onTap(0.8f,result1,231,105,237,113,"帮派委托",2000);
                           }
                        }else if (result2.sim < 0.8f && result1.sim <0.8f){
                            peg=1;
                            bz = false;
                        }
                        result = mFairy.findPic("suo2.png");
                        if (result.sim >0.8f){
                            LtLog.e("没有帮会结束");
                            peg=1;
                            bz = false;
                        }
                        result = mFairy.findPic("go now.png");
                        mFairy.onTap(0.8f,result,"前往",2000);
                        if (result.sim > 0.8f){
                            mFairy.initMatTime();
                            setTaskName(3);return;
                        }
                        break;
                    case 1:
                        bz = true;
                        result2 = mFairy.findPic(140,10,344,306,"menpai.png");
                        mFairy.onTap(0.8f,result2,"门派任务",Sleep);

                        result1 = mFairy.findPic(162,10,324,446,"menpai2.png");
                        if (result1.sim > 0.8f){// 203,31   354,74,437,140
                            result = mFairy.findPic(result1.x+151,result1.y+43,result1.x+234,result1.y+109,"finish.png");
                            result2 = mFairy.findPic(result1.x+151,result1.y+113,result1.x+234,result1.y+179,"finish.png");
                            if (result.sim > 0.8f && result2.sim >0.8f){
                                peg=2;
                                bz = false;
                            }else if (result.sim < 0.8f){
                                mFairy.onTap(0.8f,result1,result1.x,result1.y+60,result1.x+10,result1.y+80,"门派任务",2000);
                            }else if (result2.sim < 0.8f){
                                mFairy.onTap(0.8f,result1,result1.x,result1.y+120,result1.x+10,result1.y+140,"门派任务",2000);
                            }
                        }else if (result2.sim < 0.8f && result1.sim <0.8f){
                            peg=2;
                            bz = false;
                        }

                        result = mFairy.findPic("go now.png");
                        mFairy.onTap(0.8f,result,"前往",Sleep);
                        if (result.sim > 0.8f){
                            mFairy.initMatTime();
                            setTaskName(4);return;
                        }
                        break;
                    case 2:
                        result2 = mFairy.findPic(140,10,344,306,"putong.png");
                        mFairy.onTap(0.8f,result2,"普通任务",Sleep);
                        if (result2.sim > 0.8f){
                            bz = true;
                        }
                        result1 = mFairy.findPic(162,10,324,446,"putong2.png");
                        if (result1.sim > 0.8f){//246,413  327,430,426,490
                            num =0;
                            for (int i = 0 ; i < 5 ; i++){
                                result = mFairy.findPic(result1.x+70,result1.y+((i+1)*70),result1.x+186,result1.y+((i+1)*70),"finish.png");
                                if (result.sim > 0.8f){
                                    num++;
                                    continue;
                                }else {
                                    num++;
                                    mFairy.onTap(0.8f,result1,result1.x,result1.y+((i+1)*60),result1.x+10,result1.y+((i+1)*60),"普通任务",2000);
                                    break;
                                }
                            }
                           /* result = mFairy.findPic(result1.x+70,result1.y+20,result1.x+186,result1.y+87,"finish.png");
                            result2 = mFairy.findPic(result1.x+70,result1.y+85,result1.x+186,result1.y+162,"finish.png");
                            if (result.sim > 0.8f && result2.sim >0.8f){
                                peg=2;
                                bz = false;
                            }else if (result.sim < 0.8f){
                                mFairy.onTap(0.8f,result,320,166,331,175,"门派任务",Sleep);
                            }else if (result2.sim < 0.8f){
                                mFairy.onTap(0.8f,result2,286,235,300,246,"门派任务",Sleep);
                            }*/
                        }

                        result = mFairy.findPic("go now.png");
                        mFairy.onTap(0.8f,result,"前往",Sleep);
                        if (result.sim > 0.8f){
                            mFairy.initMatTime();
                            setTaskName(5);return;
                        }

                        if (num >= 5){
                            LtLog.e("任务结束");
                            setTaskEnd();return;
                        }
                        break;
                }
            }
            public void content_3() throws Exception{
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=30){
                    result=mFairy.findPic(new String[]{"appointment.png","weiren.png"});
                    mFairy.onTap(0.7f,result,"帮派委任",Sleep);
                    result2 = mFairy.findPic(new String[]{"Plane.png","Plane2.png"});
                    if(result.sim<0.8f && result2.sim <0.8f){
                        setTaskName(0);return;
                    }
                }

                result1 = mFairy.findPic("social contact.png");
                result = mFairy.findPic("duties.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("JangHu.png");
                    mFairy.onTap(0.7f,result,"江湖栏",Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }

                result = mFairy.findPic("task.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic(125,139,313,648,"word.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);

                    result = mFairy.findPic("qianwang.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1134,86,1153,102,"世界任务",Sleep);
                    }
                }

                result = mFairy.findPic("JangHu.png");
                mFairy.onTap(0.7f,result,"江湖栏",Sleep);

                result=mFairy.findPic("weipaigo.png");
                mFairy.onTap(0.8f,result,"击退守卫",10000);
                mFairy.onTap(0.8f,result,689,572,703,581,"自动",3000);

                result=mFairy.findPic(new String[]{"over.png","over3.png"});
                if (result.sim > 0.8f){
                  /*  result2 = mFairy.findPic(new String[]{"Plane.png","Plane2.png"});
                    mFairy.onTap(0.7f,result2,"退出位面",2000);

                    result2 = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.7f,result2,728,503,740,518,"退出位面",2000);*/
                    mFairy.onTap(368,24,378,30,"退出位面",2000);
                    mFairy.onTap(728,503,740,518,"退出位面",2000);
                    bz=false;
                    LtLog.e("任务完成");
                    setTaskName(0);
                    return;
                }


            }
            public void content_4() throws Exception{
                result=mFairy.findPic("over.png");
                if (result.sim > 0.8f){
                    result2 = mFairy.findPic(new String[]{"Plane.png","Plane2.png"});
                    mFairy.onTap(0.7f,result2,"退出位面",2000);

                    result2 = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.7f,result2,728,503,740,518,"退出位面",2000);;
                }

                result = mFairy.findPic("JangHu.png");
                mFairy.onTap(0.7f,result,"江湖栏",Sleep);

                result1 = mFairy.findPic("sit in meditation.png");
                mFairy.onTap(0.7f,result1,"打坐",5000);
                result = mFairy.findPic("Meditation.png");
                if (result.sim >0.7f || result1.sim >0.8f){

                }else {
                    result = mFairy.findPic(47,122,159,315,"menpai3.png");
                    mFairy.onTap(0.8f,result,"左侧门派",3000);
                }
                result = mFairy.findPic("begin dazuo.png");
                mFairy.onTap(0.8f,result,"开始打坐答题",5000);

                result = mFairy.findPic("submit.png");
                mFairy.onTap(0.8f,result,"提交物品",2000);

                result = mFairy.findPic("buy.png");
                mFairy.onTap(0.8f,result,726,511,731,517,"确定快捷购买",5000);

                result = mFairy.findPic("buy2.png");
                mFairy.onTap(0.8f,result,"购买",2000);

                result = mFairy.findPic("buy qr.png");
                mFairy.onTap(0.8f,result,723,503,733,510,"购买确认",2000);

                result = mFairy.findPic("submit2.png");
                mFairy.onTap(0.8f,result,"确定提交",2000);

                result = mFairy.findPic("dati.png");
                mFairy.onTap(0.8f,result,960,108,972,122,"答题选第一个",5000);

                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=30){
                    result=mFairy.findPic(57,170,118,252,new String[]{"bai.png","bai2.png"});
                    mFairy.onTap(0.7f,result,692,574,706,582,"开自动",Sleep);
                }

                result = mFairy.findPic(new String[]{"yanwu.png","yanwu2.png"});
                result1 = mFairy.findPic("Plane.png");
                if (result.sim > 0.8f && result1.sim > 0.8f && wz){
                    mFairy.onTap(0.7f,result,692,574,706,582,"开自动",Sleep);
                    wz =false;
                }else {
                    wz=true;
                }
                result1=mFairy.findPic(new String[]{"menpai3.png","menpai4.png"});
                result=mFairy.findPic(new String[]{"JangHu2.png","JangHuvx.png"});
                if (result.sim > 0.8f && result1.sim <0.7f && datatime >=15){
                    setTaskName(0);return;
                }


            }
            public void content_5() throws Exception{
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                result = mFairy.findPic(49,102,221,330,"shenfen2.png");
                mFairy.onTap(0.8f,result,"左侧任务栏身份",3000);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("explore.png");
                    mFairy.onTap(0.7f,result,"探索",10000);

                    result = mFairy.findPic("shouji.png");
                    mFairy.onTap(0.7f,result,"收集",2000);

                    result = mFairy.findPic("appraisal.png");
                    mFairy.onTap(0.7f,result,1243,17,1254,30,"鉴定关闭",Sleep);

                    if (datatime >= 10 ){
                        mFairy.onTap(758,573,770,579,"切目标",Sleep);
                    }
                    result = mFairy.findPic("Tui.png");
                    LtLog.e("----"+result.sim);
                    mFairy.onTap(0.8f, result, 692, 571, 699, 581, "开启自动", 12000);
                    mFairy.onTap(0.8f, result, 692, 571, 699, 581, "关闭自动", 1000);
                }else {
                    int sum = dateSS();
                    LtLog.e("****" + sum);
                    if (sum % 5 == 0) {
                        result = mFairy.findPic(new String[]{"word left.png", "word3.png"});
                        mFairy.onTap(0.7f, result, "世界任务", 3000);
                        if (result.sim < 0.8f) {
                            mFairy.ranSwipe(136, 198, 136, 314, 1000, 1500);
                        }
                    }
                    result = mFairy.findPic(43, 72, 275, 285, "JangHu.png");
                    mFairy.onTap(0.7f, result, "江湖栏", Sleep);

                    if (datatime >= 15) {
                        result = mFairy.findPic(new String[]{"word left.png", "word3.png"});
                        mFairy.onTap(0.7f, result, "世界任务15", 3000);
                        if (result.sim < 0.8f) {
                            mFairy.ranSwipe(146, 199, 144, 289, 1000, 1000);
                        }

                        result = mFairy.findPic(52, 129, 212, 270, new String[]{"tfl.png", "repel.png", "bai.png", "zangwu.png"});
                        mFairy.onTap(0.7f, result, 692, 574, 706, 582, "开自动", 3000);
                        mFairy.initMatTime();
                        //ao =true;
                    }
                    result = mFairy.findPic(new String[]{"collect.png", "clean.png", "destruction.png", "Recapture.png", "get.png"});
                    mFairy.onTap(0.7f, result, "收集清理", 2000);

                    result = mFairy.findPic("shouji.png");
                    mFairy.onTap(0.7f, result, "收集", 5000);
                    result1 = mFairy.findPic(61,171,195,277,"jiaoguan.png");
                    if (result.sim > 0.8f&&result1.sim < 0.8f) {
                        switch (fz) {
                            case 0:
                                mFairy.onTap(1176, 7, 1179, 12, "切线", 2000);
                                mFairy.onTap(1155, 88, 1159, 92, "切线1", 2000);
                                fz = 1;
                                break;
                            case 1:
                                mFairy.onTap(1176, 7, 1179, 12, "切线", 2000);
                                mFairy.onTap(1154, 132, 1158, 138, "切线2", 2000);
                                fz = 2;
                                break;
                            case 2:
                                mFairy.onTap(1176, 7, 1179, 12, "切线", 2000);
                                mFairy.onTap(1157, 171, 1163, 174, "切线3", 2000);
                                fz = 3;
                                break;
                            case 3:
                                mFairy.onTap(1176, 7, 1179, 12, "切线", 2000);
                                mFairy.onTap(1152, 212, 1159, 219, "切线4", 2000);
                                fz = 4;
                                break;
                            case 4:
                                mFairy.onTap(1176, 7, 1179, 12, "切线", 2000);
                                mFairy.onTap(1152, 212, 1159, 219, "切线5", 2000);
                                fz = 0;
                                break;

                        }
                    }
                    result = mFairy.findPic("Personal switching.png");
                    mFairy.onTap(0.7f, result, "个人切换", 2000);

                    result = mFairy.findPic(869, 125, 1193, 394, "give.png");
                    mFairy.onTap(0.7f, result, "给你", 2000);

                    result = mFairy.findPic("Water the flowers.png");
                    mFairy.onTap(0.7f, result, "浇花", 2000);
             /*   if (result.sim > 0.8f){
                    ao =false;
                }*/
                    result2 = mFairy.findPic("target.png");
                    result = mFairy.findPic(new String[]{"word left.png", "word3.png"});
                    result1 = mFairy.findPic(51, 129, 123, 260, new String[]{"repel.png", "bai.png", "zangwu.png"});
                    if (result.sim > 0.8f && result1.sim < 0.8f && result2.sim > 0.8f) {
                        // ao=false;
                        mFairy.onTap(0.7f, result, 692, 574, 706, 582, "关自动", Sleep);
                    }

                    result1 = mFairy.findPic(new String[]{"word left.png", "word3.png"});
                    result = mFairy.findPic(new String[]{"JangHu2.png", "JangHuvx.png"});
                    if (result.sim > 0.8f && result1.sim < 0.7f && datatime >= 10) {
                        setTaskName(0);
                        return;
                    }

                    result = mFairy.findPic("qingli.png");
                    mFairy.onTap(0.7f, result, "积雪已经清理", Sleep);
                }
            }

        }.taskContent(mFairy, "世界任务");
    }
    public int dateSS() {
        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
        String nowTime1 = format1.format(new Date());
        int SS = Integer.parseInt(nowTime1.split(":")[2]);
        return SS;
    }

    /**
     * 帮派任务
     * @throws Exception
     */
    public void gangtask() throws Exception {
        new SingleTask(mFairy) {
            boolean bz =false;
            public void inOperation() throws Exception {
                int h = mFairy.dateHour();
                if (!(h>=12)){
                    LtLog.e(mFairy.getLineInfo("帮派任务"));
                    setTaskEnd();return;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6, 2)) return;
                result = mFairy.findPic("Withdraw.png");
                mFairy.onTap(0.7f,result,"退队",3000);
                mFairy.onTap(0.7f,result,704,507,724,515,"确认退队",Sleep);

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.7f,result,"显示任务",Sleep);

                result1 = mFairy.findPic("social contact.png");
                result = mFairy.findPic("duties.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("JangHu.png");
                    mFairy.onTap(0.7f,result,"江湖栏",Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }

                result = mFairy.findPic("task.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic(125,139,313,648,"word.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);

                    result = mFairy.findPic("qianwang.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1134,86,1153,102,"世界任务",Sleep);
                    }
                }
                result=mFairy.findPic(new String[]{"JangHu2.png","JangHuvx.png"});
                if(result.sim>=0.8f){
                    result=mFairy.findPic("appointment.png");
                    result1=mFairy.findPic("over.png");
                    if (result.sim>0.7f && result1.sim < 0.8f){
                        mFairy.onTap(0.7f,result,"帮派委任",Sleep);
                        setTaskName(3);
                        return;
                    }
                    mFairy.taskSlid(err, new int[]{ 1, 3, 5}, 0, 136,198,136,314, 1000, 1500,1);
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("map.png");
                mFairy.onTap(0.8f,result,"地图",Sleep);

                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                mFairy.onTap(0.8f, result, 1164,50,1173,61,"世界任务先打开地图",2000);

                result = mFairy.findPic("word lan.png");
                mFairy.onTap(0.8f,result,"左侧地图收纳栏",Sleep);

                if (bz==false) {
                    result = mFairy.findPic(346, 8, 431, 455, "shouna.png");
                    mFairy.onTap(0.7f, result, "收纳", Sleep);
                    if (result.sim > 0.8f) {
                        return;
                    }
                }

                    result2 = mFairy.findPic("bang2.png");
                    mFairy.onTap(0.8f,result2,"帮派任务",Sleep);
                    if(result2.sim > 0.8f){
                        bz = true;
                    }
                    result1 = mFairy.findPic(162,10,324,446,"bang.png");
                    if (result1.sim > 0.8f){//223,55  325,75,435,158
                        result = mFairy.findPic(result1.x+151,result1.y+43,result1.x+234,result1.y+109,"finish.png");
                        if (result.sim >= 0.8f){
                            LtLog.e("已完成");
                            setTaskEnd();return;
                        }else {
                            mFairy.onTap(0.8f,result1,231,105,237,113,"帮派委托",2000);
                        }
                    }
                    result = mFairy.findPic("suo2.png");
                    if (result.sim >0.8f){
                        LtLog.e("没有帮会结束");
                        setTaskEnd();return;
                    }
                    result = mFairy.findPic("go now.png");
                    mFairy.onTap(0.8f,result,"前往",2000);
                    if (result.sim > 0.8f){
                        mFairy.initMatTime();
                        setTaskName(3);return;
                    }
                result = mFairy.findPic("word.png");
                result2 = mFairy.findPic("bang2.png");
                result1 = mFairy.findPic(162,10,324,446,"bang.png");
                if (result1.sim <0.8f && result2.sim <0.8f && result.sim > 0.8f){
                    setTaskEnd();return;
                }



            }
            public void content_3() throws Exception{
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=30){
                    result=mFairy.findPic(new String[]{"appointment.png","weiren.png"});
                    mFairy.onTap(0.7f,result,"帮派委任",Sleep);
                    result2 = mFairy.findPic(new String[]{"Plane.png","Plane2.png"});
                    if(result.sim<0.8f && result2.sim <0.8f){
                        setTaskName(0);return;
                    }
                }

                result1 = mFairy.findPic("social contact.png");
                result = mFairy.findPic("duties.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("JangHu.png");
                    mFairy.onTap(0.7f,result,"江湖栏",Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }

                result = mFairy.findPic("task.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic(125,139,313,648,"word.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);

                    result = mFairy.findPic("qianwang.png");
                    mFairy.onTap(0.7f,result,"世界任务",Sleep);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1134,86,1153,102,"世界任务",Sleep);
                    }
                }

                result = mFairy.findPic("JangHu.png");
                mFairy.onTap(0.7f,result,"江湖栏",Sleep);

                result=mFairy.findPic("weipaigo.png");
                mFairy.onTap(0.8f,result,"击退守卫",10000);
                mFairy.onTap(0.8f,result,689,572,703,581,"自动",3000);

                result=mFairy.findPic(new String[]{"over.png","over3.png"});
                if (result.sim > 0.8f){
                    /*result2 = mFairy.findPic(new String[]{"Plane.png","Plane2.png"});
                    mFairy.onTap(0.7f,result2,"退出位面",2000);

                    result2 = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.7f,result2,728,503,740,518,"退出位面",2000);*/
                    mFairy.onTap(368,24,378,30,"退出位面",2000);
                    mFairy.onTap(728,503,740,518,"退出位面",2000);
                    bz=false;
                    LtLog.e("任务完成");
                    setTaskName(0);
                    return;
                }
            }


        }.taskContent(mFairy, "帮派任务");
    }

    /**
     * 帮派签到
     * @throws Exception
     */
    public void gangSignIn() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
               int ret =  gameUtil.mission("gangsgin.png",0);
               if (ret ==1 ){
                   setTaskName(2);
                   return;
               }else {
                   setTaskEnd();
                   return;
               }


            }
            public void content_2() throws Exception {
               /* result = mFairy.findPic("chuji.png");
                mFairy.onTap(0.8f,result,"初级签到",Sleep);*/

                result = mFairy.findPic("zhongji.png");
                mFairy.onTap(0.8f,result,"中级签到",Sleep);

                /*result = mFairy.findPic("gaoji.png");
                mFairy.onTap(0.8f,result,"高级签到",Sleep);*/

                result = mFairy.findPic("sgin over.png");
                if (result.sim >0.8f){
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Activeinterface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "每日必做界面"));
                if (result.sim > 0.8f) {
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic("join bp.png");
                if (result.sim >0.8f){
                    LtLog.e("没有帮派结束");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "帮派签到");
    }

    /**
     * 时雨祈福
     * @throws Exception
     */
    public void auspiciousness() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("rain.png",0);
                if (ret ==1 ){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();
                    return;
                }


            }
            public void content_2() throws Exception {
                result = mFairy.findPic("signature.png");
                mFairy.onTap(0.8f,result,"求签",2000);

                result = mFairy.findPic("signature2.png");
                mFairy.onTap(0.8f,result,"求签2",3000);

                result = mFairy.findPic("signature over.png");
                if (result.sim >0.8f){
                   setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "时雨祈福");
    }

    /**
     * 天波挑战
     * @throws Exception
     */
    public void TBChallenge() throws Exception {
        new SingleTask(mFairy) {
            boolean tt = true;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("TB.png",0);
                if (ret ==1 ){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();
                    return;
                }


            }
            public void content_2() throws Exception {
                result = mFairy.findPic("challenge.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);
                if (result.sim > 0.8f){
                    tt = true;
                }
                result = mFairy.findPic("next.png");
                mFairy.onTap(0.8f,result,"挑战下一层",Sleep);
                if (result.sim > 0.8f){
                    tt = true;
                }
                result = mFairy.findPic(46,108,226,325,"TBFleft.png");
                mFairy.onTap(0.8f,result,"左侧天波府",Sleep);

                result = mFairy.findPic("surplus time.png");
                if (result.sim > 0.8f && tt){
                    tt=false;
                    mFairy.onTap(0.8f,result,693,574,700,587,"自动战斗",Sleep);
                }
                result = mFairy.findPic("fail.png");
                if (result.sim >0.8f){
                   setTaskName(3);return;
                }

                result = mFairy.findPic("sign out2.png");
                mFairy.onTap(0.8f,result,726,502,737,510,"退出退伍开始挑战",Sleep);
            }
            public void content_3() throws Exception {
                result = mFairy.findPic("sign out.png");
                mFairy.onTap(0.8f,result,"退出试炼",Sleep);

                result = mFairy.findPic("Mop up.png");
                mFairy.onTap(0.8f,result,"扫荡",Sleep);

                result = mFairy.findPic("TBlingqu.png");
                if (result.sim >0.8f){
                    setTaskName(0);return;
                }

            }

        }.taskContent(mFairy, "天波挑战");
    }

    /**
     * 必做竞技
     * @throws Exception
     */
    public void sportsmust() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("sport.png",0);
                if (ret ==1 ){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();
                    return;
                }

               /* result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",2000);

                result = mFairy.findPic(873,56,1273,706,"sports.png");
                mFairy.onTap(0.8f,result,"竞技",2000);

                if(AtFairyConfig.getOption("jj").equals("1")){
                    result = mFairy.findPic("sword.png");
                    mFairy.onTap(0.8f,result,"论剑1v1",2000);

                }


                if(AtFairyConfig.getOption("jj").equals("2")){
                    result = mFairy.findPic("battlefield.png");
                    mFairy.onTap(0.8f,result,"5v5",2000);
                }

                result = mFairy.findPic("LunJian.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
                result = mFairy.findPic("Song.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
                result = mFairy.findPic("Han.png");
                if (result.sim > 0.8f){
                    setTaskName(4);return;
                }
                result = mFairy.findPic("ZS.png");
                mFairy.onTap(0.8f,result,1243,14,1252,29,"关闭宗师",2000);*/

            }
            public void content_2() throws Exception {
                result = mFairy.findPic("sword.png");
                mFairy.onTap(0.8f,result,"1v1",Sleep);

               /* result = mFairy.findPic("battlefield.png");
                mFairy.onTap(0.8f,result,"5v5",Sleep);*/

                result = mFairy.findPic("ljlingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result = mFairy.findPic("matching.png");
                mFairy.onTap(0.8f,result,"开始匹配",Sleep);

                result = mFairy.findPic("zhan.png");
                if (result.sim > 0.8f){
                    for (int i = 0 ; i < 10 ; i++){
                        mFairy.onTap(1123,582,1128,593,"攻击",200);
                    }
                }

                result = mFairy.findPic("share.png");
                mFairy.onTap(0.8f,result,1244,24,1249,34,"叉",Sleep);


             /*   if(AtFairyConfig.getOption("slt").equals("1")){
                    result = mFairy.findPic("win.png");
                    if (result.sim > 0.8f){
                        setTaskEnd();return;
                    }
                }*/

                result = mFairy.findPic("leave.png");
                mFairy.onTap(0.8f,result,"离开",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }

            }

        }.taskContent(mFairy, "每日必做竞技");
    }

    /**
     * 竞技
     * @throws Exception
     */
    public void sports() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
               /* int ret =  gameUtil.mission("sport.png",0);
                if (ret ==1 ){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();
                    return;
                }*/
                int week = mFairy.week();
                LtLog.e("今天是周："+week);
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",2000);

                result = mFairy.findPic(873,56,1273,706,"sports.png");
                mFairy.onTap(0.8f,result,"竞技",2000);

                if(AtFairyConfig.getOption("lunjian").equals("1")){
                    result = mFairy.findPic("sword.png");
                    mFairy.onTap(0.8f,result,"论剑1v1",2000);

                }


                if(AtFairyConfig.getOption("gpzc").equals("1")){
                    result = mFairy.findPic("battlefield.png");
                    mFairy.onTap(0.8f,result,"5v5",2000);

                    if(AtFairyConfig.getOption("slwz").equals("1") && week==7){
                        mFairy.onTap(289,364,296,372,"松林问战",2000);
                    }

                    if(AtFairyConfig.getOption("hhld").equals("1") && week == 7){
                        mFairy.onTap(865,365,873,371,"瀚海乱斗",2000);
                    }
                }

                result = mFairy.findPic("LunJian.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
                result = mFairy.findPic("Song.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
                result = mFairy.findPic("Han.png");
                if (result.sim > 0.8f){
                    setTaskName(4);return;
                }
                result = mFairy.findPic("ZS.png");
                mFairy.onTap(0.8f,result,1243,14,1252,29,"关闭宗师",2000);
            }
            public void content_2() throws Exception {
//                result = mFairy.findPic("sword.png");
//                mFairy.onTap(0.8f,result,"1v1",Sleep);

               /* result = mFairy.findPic("battlefield.png");
                mFairy.onTap(0.8f,result,"5v5",Sleep);*/

                result = mFairy.findPic("ljlingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result = mFairy.findPic("matching.png");
                mFairy.onTap(0.8f,result,"开始匹配",Sleep);

                result = mFairy.findPic("zhan.png");
                if (result.sim > 0.8f){
                    for (int i = 0 ; i < 10 ; i++){
                        mFairy.onTap(1123,582,1128,593,"攻击",200);
                    }
                }

                result = mFairy.findPic("share.png");
                mFairy.onTap(0.8f,result,1244,24,1249,34,"叉",Sleep);


                if(AtFairyConfig.getOption("slt").equals("1")){
                    result = mFairy.findPic("win.png");
                    if (result.sim > 0.8f){
                        setTaskEnd();return;
                    }
                }

//                result = mFairy.findPic("leave.png");
//                mFairy.onTap(0.8f,result,"离开",Sleep);

            }
            public void content_3() throws Exception {
                long  datetime = mFairy.mMatTime(1189,104,16,6,0.9f);
                result = mFairy.findPic("Single person.png");
                mFairy.onTap(0.8f,result,"单人匹配",Sleep);

                result = mFairy.findPic("punishment.png");
                if (result.sim > 0.8f){
                    LtLog.e("挂机惩罚中。。。。");
                    mFairy.sleep(270000);
                }

                if (datetime >5){
                    result = mFairy.findPic(600,69,636,103,"begin.png");
                    mFairy.onTap(0.8f,result,694, 572, 703, 579, "自动", Sleep);
                    mFairy.onTap(0.8f,result,1171,61,1181,68,"打开地图",2000);
                    mFairy.onTap(0.8f,result,582,332,594,343,"去地图中央",5000);
                    mFairy.onTap(0.8f,result,1247,15,1260,36,"cha",2000);
                    mFairy.onTap(694, 572, 703, 579, "自动", Sleep);
                }

                result2=mFairy.findPic(600,69,636,103,"SongLin.png");
                LtLog.e("***"+result2.sim);
                if (result2.sim >= 0.8f) {
                    if (datetime >= 5) {
                        for (int i = 0; i < 10; i++) {
                            mFairy.onTap(1109, 579, 1125, 586, "攻击", Sleep);
                        }
                        result = mFairy.findPic(new String[]{"mi.png", "target.png"});
                        if (result.sim < 0.8f) {
                            mFairy.ranSwipe(163, 585, 163, 447, 3000, 1000);

                        }
                        mFairy.onTap(694, 572, 703, 579, "自动", Sleep);
                    }
                }
                if(AtFairyConfig.getOption("slt").equals("1")){
                    result = mFairy.findPic("win2.png");
                    if (result.sim > 0.8f){
                        setTaskEnd();return;
                    }
                }

                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }


            }
            public void content_4() throws Exception {
                long  datetime = mFairy.mMatTime(1197,110,16,6,0.9f);
                result = mFairy.findPic("Single person.png");
                mFairy.onTap(0.8f,result,"单人匹配",Sleep);
                LtLog.e( "*****"+datetime);
//                if (datetime >= 10){
//                    mFairy.ranSwipe(163,585,138,447,3000,1000);
//                    mFairy.onTap(694,572,703,579,"自动",Sleep);
//                }

                result = mFairy.findPic("punishment.png");
                if (result.sim > 0.8f){
                    LtLog.e("挂机惩罚中。。。。");
                    mFairy.sleep(30000);
                }

                result2=mFairy.findPic("zhan2.png");
                if (result2.sim > 0.8f) {
                    if (datetime >= 5) {
                        for (int i = 0; i < 5; i++) {
                            mFairy.onTap(1109, 579, 1125, 586, "攻击", Sleep);
                        }
                        result = mFairy.findPic(new String[]{"mi.png", "target.png"});
                        if (result.sim < 0.8f) {
                            mFairy.ranSwipe(163, 585, 163, 447, 3000, 1000);

                        }
                        mFairy.onTap(694, 572, 703, 579, "自动", Sleep);
                    }
                }
                if(AtFairyConfig.getOption("slt").equals("1")){
                    result = mFairy.findPic("win2.png");
                    if (result.sim > 0.8f){
                        setTaskEnd();return;
                    }
                }

                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }

            }
        }.taskContent(mFairy, "竞技");
    }

    /**
     * 身份
     * @throws Exception
     */
    public void identity() throws Exception {
        new SingleTask(mFairy) {
            int num =0;
            boolean sd = true;
            List<String> list = new ArrayList();
            int wbcs = 0,xscs = 0,dtcs = 0,x=0,y=0;
            @Override
            public void create() throws Exception {
                if(AtFairyConfig.getOption("7880").equals("1")){
                    list.add("yx");
                    if (!AtFairyConfig.getOption("wbcs").equals("")) {
                        wbcs = strSplit(AtFairyConfig.getOption("wbcs")).count;
                    }
                }

                if(AtFairyConfig.getOption("7884").equals("1")){
                    list.add("xy");
                    if (!AtFairyConfig.getOption("xscs").equals("")) {
                        xscs = strSplit(AtFairyConfig.getOption("xscs")).count;
                    }
                    LtLog.e("/////"+xscs);
                }

                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        list.add("ys");
                        dtcs = strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                LtLog.e("集合"+list.toString());
                if (list.size() != 0){

                }else {
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Withdraw.png");
                mFairy.onTap(0.7f,result,"退队",3000);
                mFairy.onTap(0.7f,result,704,507,724,515,"确认退队",Sleep);

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.7f,result,"显示任务",Sleep);

                result1 = mFairy.findPic("social contact.png");
                result = mFairy.findPic("duties.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("JangHu.png");
                    mFairy.onTap(0.7f,result,"江湖栏",Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.7f,result,1140,90,1152,100,"关闭",Sleep);

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,"身份",Sleep);

                result = mFairy.findPic("identity2.png");
                mFairy.onTap(0.8f,result,"身份百业",Sleep);

                if(list.get(0).equals("yx")){
                    result = mFairy.findPic("Ranger.png");
                    mFairy.onTap(0.8f,result,"游侠",2000);

                    if (result.sim > 0.8f) {
                        result = mFairy.findPic(1046, 566, 1213, 658, "qianwang2.png");
                        if (result.sim > 0.8f) {
                            LtLog.e("没有活力了");
                            setTaskEnd();
                            return;
                        }
                    }

                    result = mFairy.findPic(49,102,221,330,"xun.png");
                    if(result.sim > 0.8f){
                        setTaskName(2);return;
                    }

                    result = mFairy.findPic("Wb.png");
                    if(result.sim > 0.8f){
                        if(AtFairyConfig.getOption("tsd").equals("1")){
                            mFairy.onTap(532,551,541,561,"天水蝶",2000);
                            mFairy.onTap(1083,622,1096,629,"参加挖宝",2000);
                        }
                        if(AtFairyConfig.getOption("nhd").equals("1")){
                            mFairy.onTap(309,554,318,564,"南华蝶",2000);
                            mFairy.onTap(1083,622,1096,629,"参加挖宝",2000);
                        }
                        setTaskName(2);return;
                    }
                }
                if(list.get(0).equals("xy")){
                    result = mFairy.findPic("Eye suspension.png");
                    mFairy.onTap(0.8f,result,"悬眼",2000);

                    if (result.sim > 0.8f) {
                        result = mFairy.findPic(1046, 566, 1213, 658, "qianwang2.png");
                        if (result.sim > 0.8f) {
                            LtLog.e("没有活力了");
                            setTaskEnd();
                            return;
                        }
                    }

                    result = mFairy.findPic(49,102,221,330,"xuanshang2.png");
                    if(result.sim > 0.8f){
                        setTaskName(4);return;
                    }

                    result = mFairy.findPic("Insufficient props.png");
                    if (result.sim > 0.8f){
                        mFairy.onTap(0.8f,result,543,475,558,486,"暂不前往",Sleep);
                        LtLog.e("道具不足");
                        if (list.size() != 0){
                            list.remove(0);
                        }else {
                            setTaskEnd();return;
                        }

                        gameUtil.close();
                    }

                    result = mFairy.findPic("Unveiling.png");
                    if(result.sim > 0.8f){
                        if(AtFairyConfig.getOption("ys").equals("1")){
                            mFairy.onTap(26,134,36,143,"义赏",2000);

                        }
                        if(AtFairyConfig.getOption("xs").equals("1")){
                            mFairy.onTap(35,316,43,329,"悬赏",2000);
                        }
                        setTaskName(4);return;
                    }
                }
                if(list.get(0).equals("ys")){
                    result = mFairy.findPic("Elegant scholar.png");
                    mFairy.onTap(0.8f,result,"雅士",2000);
                    result = mFairy.findPic(new String[]{"qianwang.png","qianwang2.png"});
                    if(result.sim > 0.8f){
                        setTaskEnd();return;
                    }
                }

                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.7f, result, "菜单", Sleep);

                result = mFairy.findPic(1035,421,1203,662,"Tshui.png");
                mFairy.onTap(0.8f,result,"参与",Sleep);

                result = mFairy.findPic("answer.png");
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,741,482,756,497,"确认",Sleep);
                    setTaskName(3);return;
                }
                result = mFairy.findPic("huoli.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,514,480,528,490,"暂不前往",Sleep);
                    LtLog.e("活力不足结束");
                    setTaskEnd();return;
                }


            }
            public void content_2() throws Exception {
                LtLog.e("挖宝次数"+wbcs);
                result = mFairy.findPic(49,102,221,330,"shenfen2.png");
                if (wbcs <= 0 && result.sim < 0.8f){
                    if (list.size() != 0){
                        list.remove(0);
                        setTaskName(0);return;
                    }else {
                        setTaskEnd();return;
                    }

                }
                long  datetime = mFairy.mMatTime(1189,104,16,6,0.9f);
                result = mFairy.findPic("JangHu.png");
                mFairy.onTap(0.7f,result,"江湖栏",Sleep);

                result = mFairy.findPic(49,102,221,330,"shenfen2.png");
                mFairy.onTap(0.8f,result,"左侧任务栏身份",3000);

                result = mFairy.findPic("explore.png");
                mFairy.onTap(0.7f,result,"探索",10000);

                result = mFairy.findPic("shouji.png");
                mFairy.onTap(0.7f,result,"收集",2000);

                result = mFairy.findPic("appraisal.png");
                mFairy.onTap(0.7f,result,1243,17,1254,30,"鉴定关闭",Sleep);

                result1 = mFairy.findPic(49,102,221,330,"shenfen2.png");
                result = mFairy.findPic("jixu.png");
                if (result.sim > 0.8f){
                   -- wbcs;
                }
                if (result.sim > 0.8f && wbcs>0){
                    mFairy.onTap(0.7f,result,"继续挖宝",7000);
                }
                if (result.sim < 0.8f && result1.sim < 0.8f && datetime >= 15){
                    setTaskName(0);return;
                }

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"身份关闭",Sleep);

                if (datetime >= 10 ){
                    mFairy.onTap(758,573,770,579,"切目标",Sleep);
                }
                result = mFairy.findPic("Tui.png");
                LtLog.e("----"+result.sim);
                mFairy.onTap(0.8f, result, 692, 571, 699, 581, "开启自动", 12000);
                mFairy.onTap(0.8f, result, 692, 571, 699, 581, "关闭自动", 1000);

                result = mFairy.findPic("Insufficient props.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,543,475,558,486,"暂不前往",Sleep);
                    LtLog.e("道具不足");
                    if (list.size() != 0){
                        list.remove(0);

                    }else {
                        setTaskEnd();return;
                    }
                    gameUtil.close();
                }

            }
            public void content_3() throws Exception {
                if (overtime(10,1))return;
                LtLog.e("答题次数"+dtcs);
                if (dtcs <= 0){
                    if (list.size() != 0){
                        list.remove(0);
                        setTaskName(0);return;
                    }else {
                        setTaskEnd();return;
                    }
                }
                result = mFairy.findPic("answer.png");
                mFairy.onTap(0.8f,result,741,482,756,497,"确认",Sleep);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("JIA.png");
                mFairy.onTap(0.8f,result,"甲",Sleep);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("continue.png");
                if (result.sim > 0.8f){
                    --dtcs;
                    err=0;
                }
                if (result.sim > 0.8f && dtcs>0){
                    mFairy.onTap(0.8f,result,"继续答题",Sleep);
                }
                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"身份关闭",Sleep);
                if (result.sim > 0.8f){
                    err=0;
                }

            }
            public void content_4() throws Exception {
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                if (datatime >= 35 && result.sim > 0.8f){
                    result = mFairy.findPic("xiama.png");
                    mFairy.onTap(0.8f,result,"下马",Sleep);
                }
                LtLog.e("悬赏次数"+xscs);
                if (xscs <= 0){
                    if (list.size() != 0){
                        list.remove(0);
                        setTaskName(0);return;
                    }else {
                        setTaskEnd();return;
                    }
                }
                result = mFairy.findPic(65,477,1274,585,"qianwangxs.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);
                if (result.sim > 0.8f){

                }else {
                    result = mFairy.findPic(80, 163, 1274, 518, new String[]{"bang3.png","shang.png"});
                    mFairy.onTap(0.8f, result, "悬赏", Sleep);

                    result = mFairy.findPic(new String[]{"vitality.png","xuanshang.png","not huoli.png"});
                   if (result.sim > 0.8f){
                       LtLog.e("悬赏令不足 活力不足" );
                       if (list.size() != 0){
                           list.remove(0);
                           setTaskName(0);return;
                       }else {
                           setTaskEnd();return;
                       }
                   }
                }
                result = mFairy.findPic("quer.png");
                mFairy.onTap(0.8f,result,"确认",Sleep);

                result = mFairy.findPic( 49,102,221,330,"leftshang.png");
                mFairy.onTap(0.8f, result, "左侧悬赏", 5000);

                result = mFairy.findPic( "wunian.png");
                mFairy.onTap(0.8f, result, "无念", Sleep);

                result = mFairy.findPic( "yinshen.png");
                mFairy.onTap(0.8f, result, "隐身", Sleep);
                if (result.sim > 0.8f){
                    sd=true;
                }
                result = mFairy.findPic( "eagle.png");
                mFairy.onTap(0.8f, result, "老鹰", Sleep);
                if (result.sim > 0.8f){
                    num=0;
                    setTaskName(5);return;
                }

                LtLog.e("/*/"+sd);
                result = mFairy.findPic(451,1,574,32,"wunian2.png");
                result2=mFairy.findPic("target.png");
               if (sd && result.sim > 0.8f) {
                    sd=false;
                   mFairy.onTap(0.7f, result, 698, 576, 706, 584, "开自动", Sleep);
               }else if (result.sim < 0.8f && result2.sim >0.8f){
                   mFairy.onTap(698, 576, 706, 584, "关自动", Sleep);
               }


                result = mFairy.findPic( "agin.png");
                if (result.sim > 0.8f){
                    LtLog.e("发现继续");
                    --xscs;
                }
                if (result.sim > 0.8f && xscs>0){

                    mFairy.onTap(0.8f, result, "继续", Sleep);
                }

            }
            public void content_5() throws Exception {
                mFairy.sleep(1500);
                mFairy.condit();
                result = mFairy.findPic(658,8,923,75,"someone.png");
                result1 = mFairy.findPic(1,64,1263,686,"target2.png");
                LtLog.e("----------"+result1.sim);
                if (result.sim > 0.7f && result1.sim < 0.7f){
                    LtLog.e("滑动");
                  //  mFairy.ranSwipe(639,357,810,356,3000,3000);
/*                    switch (num){
                        case 6:
                            LtLog.e("222");
                            mFairy.ranSwipe(641,363,809,430,3000,3000);
                            num++;
                            break;
                        case 12:
                            LtLog.e("333");
                            mFairy.ranSwipe(641,363,813,255,4000,3000);
                            num=0;
                            break;
                        default:

                            num++;
                            break;
                    }*/
                    mFairy.ranSwipe(639,357,810,356,2000,2000);
                    mFairy.condit();
                }else if (result1.sim >= 0.8f){
                    mFairy.condit();
                    LtLog.e("找到了");
                    LtLog.e("x,"+result1.x+"y,"+result1.y);
                    x = result1.x - 639;
                    y = result1.y - 361;
                    //mFairy.ranSwipe(639,357,result1.x,result1.y,2000,1500);
                    //mFairy.touchDown(639,361);
                    if (x >5){
                        mFairy.touchDown(639,361);
                        mFairy.touchMove(674,361,500);
                        mFairy.sleep(1000);
                        mFairy.touchUp();
                    }
                    if (x < -5 ){
                        mFairy.touchDown(639,361);
                        mFairy.touchMove(604,361,500);
                        mFairy.sleep(1000);
                        mFairy.touchUp();
                    }
                    if (y>10){
                        mFairy.touchDown(639,361);
                        mFairy.touchMove(639,380,300);
                        mFairy.sleep(1000);
                        mFairy.touchUp();
                    }
                    if ( y < -10){
                        mFairy.touchDown(639,361);
                        mFairy.touchMove(639,340,300);
                        mFairy.sleep(1000);
                        mFairy.touchUp();
                    }
                   // mFairy.touchMove(result1.x,result1.y,2000);
                   /* result1 = mFairy.findPic(1,64,1263,686,"target2.png");
                    mFairy.touchMove(result1.x,result1.y,500);*/
                   // mFairy.touchUp();
                }

                result = mFairy.findPic( "locking.png");
                mFairy.onTap(0.8f, result, 1039,487,1052,496,"锁定", Sleep);
                if (result.sim > 0.8f){
                    setTaskName(4);return;
                }

                result = mFairy.findPic( "eagle.png");
                mFairy.onTap(0.8f, result, "老鹰", Sleep);
                result1 = mFairy.findPic(1007,140,1263,304,"activity.png");
                if (result.sim <0.8f && result1.sim > 0.8f){
                    setTaskName(4);return;
                }
            }
        }.taskContent(mFairy, "身份");
    }

    /**
     * 福利
     * @throws Exception
     */
    public void welfare() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(10,2))return;
                result = mFairy.findPic("welfare.png");
                mFairy.onTap(0.7f,result,"福利",3000);

                result = mFairy.findPic(112,46,293,465,new String[]{"line.png","line1.png","line2.png"});
                mFairy.onTap(0.7f,result,"福利",1000);

               /* result = mFairy.findPic(112,46,293,465,"online.png");
                if (result.sim > 0.8f){

                }else {
                    mFairy.onTap(195,119,205,125,"在线奖励",1000);
                }*/

                result = mFairy.findPic(1029,562,1198,644,"online receive.png");
                mFairy.onTap(0.7f,result,"领取",Sleep);
                if (result.sim > 0.7f){
                    err=0;
                }
                result = mFairy.findPic(new String[]{"receive over.png","suo.png"});
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }

            }
            public void content_2() throws Exception {
                if (overtime(5,3))return;
                result = mFairy.findPic("welfare2.png");
                if (result.sim > 0.8f){


                }else {
                    result = mFairy.findPic("welfare.png");
                    mFairy.onTap(0.7f,result,"福利",3000);

                }

                result = mFairy.findPic(112,46,293,465,"register.png");
                mFairy.onTap(0.8f,result,"每日签到",3000);

                List<FindResult> findResults = mFairy.findPic(424,52,1216,554,0.8f,"register2.png");
                LtLog.e("/*/"+findResults.size());
                if (findResults.size() == 0){

                }else {
                    if (findResults.size() == 8 || findResults.size() == 16 || findResults.size() == 24) {//1130,169    496,273,514,290
                        LtLog.e("11");
                        LtLog.e((findResults.get(findResults.size()-1).x - 634)+","+(findResults.get(findResults.size()-1).y+ 104)+","+(findResults.get(findResults.size()-1).x- 616)+","+(findResults.get(findResults.size()-1).y + 121));
                        mFairy.onTap( findResults.get(findResults.size() - 1).x - 634, findResults.get(findResults.size() - 1).y + 104, findResults.get(findResults.size() - 1).x - 616, findResults.get(findResults.size() - 1).y + 121, "点击签到", 1000);
                    } else {//586,274   680,276,692,287
                        //LtLog.e("----"+findResults.get(7).x+","+findResults.get(7).y);
                        // LtLog.e("/*/"+findResults.get(findResults.size()-1).x+","+findResults.get(findResults.size()-1).y);
                        // LtLog.e((findResults.get(findResults.size()-1).x+94)+","+(findResults.get(findResults.size()-1).y+2)+","+(findResults.get(findResults.size()-1).x+106)+","+(findResults.get(findResults.size()-1).y+13));
                        mFairy.onTap(findResults.get(findResults.size() - 1).x + 94, findResults.get(findResults.size() - 1).y + 2, findResults.get(findResults.size() - 1).x + 106, findResults.get(findResults.size() - 1).y + 13, "点击签到", 1000);
                    }
                }
                result=mFairy.findPic(449,78,1197,536,"Supplementary signature.png");
                mFairy.onTap(0.8f,result,"点击补签",1000);

                result=mFairy.findPic("qian2.png");
                mFairy.onTap(0.8f,result,724,496,737,517,"确定补签",1000);

                result = mFairy.findPic("qian.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.7f,result,721,575,726,584,"2天",1000);
                    mFairy.onTap(0.7f,result,829,571,835,580,"7天",1000);
                    mFairy.onTap(0.7f,result,938,575,946,584,"14天",1000);
                    mFairy.onTap(0.7f,result,1048,573,1053,578,"21天",1000);
                    mFairy.onTap(0.7f,result,1158,573,1165,580,"28天",1000);
                    mFairy.onTap(0.7f,result,1214,579,1218,583,"结束",1000);
                }



            }
            public void content_3() throws Exception {
                if (overtime(3,4))return;
                result = mFairy.findPic("Grade.png");
                mFairy.onTap(0.8f,result,"等级奖励",Sleep);

                result = mFairy.findPic("review2.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

            }
            public void content_4() throws Exception {
                result = mFairy.findPic("preferential.png");
                mFairy.onTap(0.8f,result,"特惠",Sleep);

                result = mFairy.findPic(119,52,288,556,"zhaocai.png");
                mFairy.onTap(0.8f,result,"招财进宝",Sleep);

                result = mFairy.findPic("fail3.png");
                mFairy.onTap(0.8f,result,"本次免费",Sleep);

                result = mFairy.findPic( "Roll up.png");
                if (result.sim > 0.8f){
                    setTaskName(5);return;
                }
            }
            public void content_5() throws Exception {
                if (overtime(3,7))return;
                result = mFairy.findPic( 119,52,288,556,"gift.png");
                mFairy.onTap(0.8f, result, "每日礼包", Sleep);
                mFairy.onTap(0.8f, result, 800,602,811,612,"领取", Sleep);

                result = mFairy.findPic( "gift lq.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);
            }
            public void content_6() throws Exception {
                result = mFairy.findPic("welfare3.png");
                mFairy.onTap(0.8f,result,1213,56,1223,73,"叉",2000);

                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                mFairy.onTap(0.8f, result, "活动入口",2000);

                result = mFairy.findPic("active.png");
                mFairy.onTap(0.8f, result, "每周活跃",2000);

                result = mFairy.findPic("huoyue.png");
                mFairy.onTap(0.8f, result, "活跃领取",2000);

                result = mFairy.findPic(988,80,1067,242,"register2.png");
                LtLog.e("/*/"+result.sim);
                if (result.sim >= 0.8f){
                    setTaskEnd();return;
                }
                result = mFairy.findPic("huoyueqianwang.png");
                if (result.sim >= 0.8f){
                    setTaskEnd();return;
                }
            }
            public void content_7() throws Exception{
                if (overtime(3,6)){gameUtil.close();return;}
                result = mFairy.findPic("welfare3.png");
                mFairy.onTap(0.8f,result,1213,56,1223,73,"叉",2000);

                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",2000);

                result = mFairy.findPic(873,56,1273,706,"sports.png");
                mFairy.onTap(0.8f,result,"竞技",2000);

                result = mFairy.findPic(228,93,692,177,"box.png");
                mFairy.onTap(0.8f,result,"首胜宝箱",2000);

            }
        }.taskContent(mFairy, "福利");
    }

    /**
     * 奖励找回
     * @throws Exception
     */
    public void recovery() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic(1007,140,1263,304,"activity.png");
                mFairy.onTap(0.8f, result, "活动入口",2000);

                result = mFairy.findPic("Reward recovery.png");
                mFairy.onTap(0.8f, result, "奖励找回",2000);

                result = mFairy.findPic("General recovery.png");
                mFairy.onTap(0.8f, result, "全部普通找回",2000);

                result = mFairy.findPic("General recovery2.png");
                mFairy.onTap(0.8f, result, 741,488,750,499,"确认全部普通找回",2000);


                result = mFairy.findPic("zan.png");
                if (result.sim >0.8f){
                    LtLog.e("没有可找回的奖励");

                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "奖励找回");
    }

    /**
     * 清理背包
     * @throws Exception
     */
    public void cleanbackpack() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(5,99)){gameUtil.close();return;}
                result = mFairy.findPic("backpack.png");
                mFairy.onTap(0.8f, result, "背包",2000);

                result = mFairy.findPic("decompose.png");
                mFairy.onTap(0.8f, result, "批量分解",2000);

                result = mFairy.findPic("choice.png");
                mFairy.onTap(0.8f, result, "快速选择",2000);


                result1 = mFairy.findPic("jie2.png");
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(1000,182,1056,230,"check mark.png");
                    if (result.sim > 0.8f) {

                    } else {
                        mFairy.onTap(1026,202,1032,213, "绝品", 2000);
                    }
                    result = mFairy.findPic(862,182,918,233,"check mark.png");
                    if (result.sim > 0.8f) {

                    } else {
                        mFairy.onTap(889,206,895,211, "极品", 2000);
                    }
                    result = mFairy.findPic(724,182,778,232,"check mark.png");
                    if (result.sim > 0.8f) {

                    } else {
                        mFairy.onTap(750,205,757,211, "精品", 2000);
                    }
                    result = mFairy.findPic(591,185,640,231,"check mark.png");
                    if (result.sim > 0.8f) {

                    } else {
                        mFairy.onTap(613,204,621,207, "凡品", 2000);
                    }

                    mFairy.onTap(767,572,780,582,"选择",Sleep);
                }

                result = mFairy.findPic("decompose2.png");
                mFairy.onTap(0.8f, result, "批量分解",2000);

                result = mFairy.findPic("Props decomposition.png");
                mFairy.onTap(0.8f, result, 723,505,732,519,"确认分解",2000);


            }
        }.taskContent(mFairy, "分解");
    }

    /**
     * 每日抽卡
     * @throws Exception
     */
    public void drawCard() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.7f, result, "菜单", Sleep);

                result = mFairy.findPic("partner2.png");
                mFairy.onTap(0.8f, result, "伙伴",2000);

                result = mFairy.findPic("recruit.png");
                mFairy.onTap(0.8f, result, "招募1",2000);

                result1 = mFairy.findPic("Limited immunity.png");
                if (result1.sim > 0.8f) {
                    LtLog.e("抽完了");
                    setTaskEnd();return;
                }

                result1 = mFairy.findPic("Free Admission.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result1, "招募", 2000);
                }

                result1 = mFairy.findPic("Free Admission2.png");
                result = mFairy.findPic("switch.png");
                if (result1.sim > 0.8f) {
                    mFairy.ranSwipe(483,435,729,434,500,500);
                }
                if (result1.sim < 0.8f && result.sim > 0.8f){
                    LtLog.e("抽完了");
                    mFairy.onTap(1244,24,1252,30,"返回",Sleep);
                    setTaskEnd();return;
                }


                result = mFairy.findPic("continue2.png");
                mFairy.onTap(0.8f, result, "点击空白继续",2000);


            }
        }.taskContent(mFairy, "抽卡");
    }

    /**
     * 邮件
     * @throws Exception
     */
    public void email() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(5,99)){gameUtil.close();return;}
                result = mFairy.findPic(new String[]{"email.png","email2.png"});
                mFairy.onTap(0.7f, result, "邮箱", Sleep);

                result = mFairy.findPic("alllq.png");
                mFairy.onTap(0.8f, result, "全部领取",5000);

                result = mFairy.findPic("delete.png");
                mFairy.onTap(0.8f, result, "一键删除",2000);
                mFairy.onTap(0.8f, result, 718,476,732,490,"确认删除",2000);

            }
        }.taskContent(mFairy, "邮件");
    }


    /**
     * 钓鱼
     * @throws Exception
     */
    public void finish() throws Exception {
        new SingleTask(mFairy) {
            int dyy = 0;
            @Override
            public void create() throws Exception {
                if(strSplit(AtFairyConfig.getOption("opcount3")).choice==1){
                    dyy = strSplit(AtFairyConfig.getOption("opcount3")).count;
                }
                else {
                    setTaskEnd();return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                LtLog.e("钓鱼次数"+dyy);
                result = mFairy.findPic("finish2.png");
                mFairy.onTap(0.8f, result, "钓鱼",2000);

                result = mFairy.findPic("fishing2.png");
                mFairy.onTap(0.8f, result, "钓鱼",2000);

                result = mFairy.findPic("fishing3.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(1127,598);
                    mFairy.sleep(1350);
                    mFairy.touchUp();
                }

                result = mFairy.findPic("fish.png");
                if (result.sim > 0.8f){
                    dyy--;
                }

                result = mFairy.findPic("fishing close.png");
                mFairy.onTap(0.8f, result, "关闭",2000);
               /* if (result.sim >0.8f){
                    dyy--;
                }*/
                if (dyy <= 0){
                    setTaskEnd();return;
                }
                result = mFairy.findPic("huoli2.png");
                if (result.sim > 0.8f){
                    LtLog.e("活力不足");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "钓鱼");
    }


    }