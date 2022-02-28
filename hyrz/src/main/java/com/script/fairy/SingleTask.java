package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;

    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }
    int count = 0;
    @Override
    public void inOperation() throws Exception {
        result = mFairy.findPic(303, 290, 1271, 709, new String[]{"zmsure.png", "sure1.png", "sure2.png"});
        mFairy.onTap(0.8f, result, "确定", 100);

        result = mFairy.findPic("attack.png");
        result1 = mFairy.findPic(new String[]{"automatic.png", "automatic1.png"});
        if(result.sim>0.8f)LtLog.e(mFairy.getLineInfo( "普工"));
        if(result1.sim>0.8f)LtLog.e(mFairy.getLineInfo( "自动中"));
        if (result.sim > 0.8f && result1.sim > 0.8f) {
            mFairy.onTap(0.8f, result1, "开启自动", 1000);
        }
        //普攻攻击键
        if (result.sim > 0.8f) {
            err = 0;
            for (int i = 0; i < 2; i++) {
                mFairy.condit();
                result=mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,846,544,891,564,"选择出战忍者",1000);

                result = mFairy.findPic("Resurrection.png");
                mFairy.onTap(0.8f, result, 1185, 43, 1199, 54, "复活", 1000);

                result1 = mFairy.findPic(new String[]{"automatic.png", "automatic1.png"});
                if (result1.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("自动中"));
                    break;
                }
                result = mFairy.findPic("attack.png");
                if(result.sim>0.8f)LtLog.e(mFairy.getLineInfo( "普工" + count));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("lianxic.png");
                    mFairy.onTap(0.8f, result, 1236,27,1253,38, "练习场退出", 3000);
                    mFairy.onTap(0.8f, result, 475,445,515,465, "练习场退出", 3000);
                    i = 0;
                    count++;
                    if (count > 6) {
                      /*   mFairy.ranSwipe(218,552,140,540,2000,100);
                         mFairy.ranSwipe(218,552,284,545,50,100);*/
                        mFairy.touchDown(2, 218, 552);
                        mFairy.touchMove(2, 140, 540, 1500);
                        mFairy.touchMove(2, 276, 549, 50);
                        mFairy.touchUp(2);
                        LtLog.e(mFairy.getLineInfo("向左"));
                        count = 0;
                    }
                    mFairy.tap(1135, 585);
                    mFairy.tap(1135, 585);
                    mFairy.tap(1135, 585);
                    mFairy.tap(996, 634);
                    mFairy.tap(1021, 495);
                    mFairy.tap(1146, 434);
                    mFairy.tap(859, 636);
                    mFairy.tap(1155, 291);
                    mFairy.tap(1157, 185);

                } else {
                    break;
                }
            }
        }
        if (result1.sim > 0.8f) {
            err = 0;
        }

        result = mFairy.findPic("Load.png");
        if (result.sim > 0.9f) {
            LtLog.e(mFairy.getLineInfo(0.9f, result, "加载中"));
            err = 0;
        }

        result = mFairy.findPic("weijiesuo.png");
        if (result.sim > 0.9f) {
            LtLog.e(mFairy.getLineInfo("当前任务未解锁"));
            setTaskEnd();
        }
    }

    public void inOperation_test() throws Exception {
        result = mFairy.findPic(303, 290, 1271, 709, new String[]{"zmsure.png", "sure1.png", "sure2.png"});
        mFairy.onTap(0.8f, result, "确定", 100);

        result = mFairy.findPic("attack.png");
        result1 = mFairy.findPic(new String[]{"automatic.png", "automatic1.png"});
        if(result.sim>0.8f)LtLog.e(mFairy.getLineInfo( "普工"));
        if(result1.sim>0.8f)LtLog.e(mFairy.getLineInfo( "自动中"));
        if (result.sim > 0.8f && result1.sim > 0.8f) {
            mFairy.onTap(0.8f, result1, "开启自动", 1000);
        }
        //普攻攻击键
        if (result.sim > 0.8f) {
            err = 0;
            for (int i = 0; i < 2; i++) {
                mFairy.condit();
                result=mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,846,544,891,564,"选择出战忍者",1000);

                result = mFairy.findPic("Resurrection.png");
                mFairy.onTap(0.8f, result, 1185, 43, 1199, 54, "复活", 1000);

                result1 = mFairy.findPic(new String[]{"automatic.png", "automatic1.png"});
                if (result1.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("自动中"));
                    break;
                }

                result = mFairy.findPic("attack.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo( "普工" + count));

                    result = mFairy.findPic("lianxic.png");
                    mFairy.onTap(0.8f, result, 1236,27,1253,38, "练习场退出", 3000);
                    mFairy.onTap(0.8f, result, 475,445,515,465, "练习场退出", 3000);
                    i = 0;
                    count++;
                    if (count > 6) {
                        mFairy.touchDown(2, 218, 552);
                        mFairy.touchMove(2, 140, 540, 1500);
                        mFairy.touchMove(2, 276, 549, 50);
                        mFairy.touchUp(2);
                        LtLog.e(mFairy.getLineInfo("向左"));
                        count = 0;
                    }
                    mFairy.tap(1135, 585);
                    mFairy.tap(1135, 585);
                    mFairy.tap(1135, 585);
                    mFairy.tap(996, 634);
                    mFairy.tap(1021, 495);
                    mFairy.tap(1146, 434);
                    mFairy.tap(859, 636);
                    mFairy.tap(1155, 291);
                    mFairy.tap(1157, 185);

                } else {
                    break;
                }
            }
        }
        if (result1.sim > 0.8f) {
            err = 0;
        }

        result = mFairy.findPic("Load.png");
        if (result.sim > 0.9f) {
            LtLog.e(mFairy.getLineInfo(0.9f, result, "加载中"));
            err = 0;
        }

        result = mFairy.findPic("weijiesuo.png");
        if (result.sim > 0.9f) {
            LtLog.e(mFairy.getLineInfo("当前任务未解锁"));
            setTaskEnd();
        }
    }

    public void test() throws Exception {
        while (mFairy.condit()) {
            result = mFairy.findPic("test.png");
            mFairy.onTap(0.8f, result, "点击home", 100);
        }
    }

    //冒险
    public void novice() throws Exception {
        int count = 0, count_1 = 0, sbcount = 0;
        while (mFairy.condit()) {
            result = mFairy.findPic("other.png");
            LtLog.e(mFairy.getLineInfo(0.8f, result, "右移"));
            if (result.sim > 0.8f) {
                mFairy.ranSwipe(218, 552, 356, 560, 2000, 3000);
            }

            result = mFairy.findPic("attack.png");
            LtLog.e(mFairy.getLineInfo(0.8f, result, "普工"));
            result1 = mFairy.findPic(new String[]{"automatic.png", "automatic1.png"});
            LtLog.e(mFairy.getLineInfo(0.8f, result1, "自动中"));
            if (result.sim > 0.8f && result1.sim > 0.8f) {
                mFairy.onTap(0.8f, result1, "开启自动", 1000);
            }
            if (result.sim > 0.8f) {
                for (int i = 0; i < 2; i++) {
                    mFairy.condit();
                    result1 = mFairy.findPic(new String[]{"automatic.png", "automatic1.png"});
                    LtLog.e(mFairy.getLineInfo(0.8f, result1, "自动中"));
                    if (result1.sim > 0.8f) {
                        break;
                    }
                    result = mFairy.findPic("attack.png");
                    LtLog.e(mFairy.getLineInfo(0.8f, result, "普工" + count));
                    if (result.sim > 0.8f) {
                        i = 0;
                        count++;
                        if (count > 7) {
                              /*   mFairy.ranSwipe(218,552,140,540,2000,100);
                                 mFairy.ranSwipe(218,552,284,545,50,100);*/
                            mFairy.touchDown(2, 218, 552);
                            mFairy.touchMove(2, 140, 540, 1500);
                            mFairy.touchMove(2, 276, 549, 50);
                            mFairy.touchUp(2);
                            LtLog.e(mFairy.getLineInfo("向左"));
                            count = 0;
                        }
                        mFairy.tap(1135, 585);
                        mFairy.tap(1135, 585);
                        mFairy.tap(1135, 585);
                        mFairy.tap(996, 634);
                        mFairy.tap(1021, 495);
                        mFairy.tap(1146, 434);
                        mFairy.tap(859, 636);
                        mFairy.tap(1155, 291);
                        mFairy.tap(1157, 185);

                    } else {
                        break;
                    }
                }
            }


            result = mFairy.findPic("victory.png");
            mFairy.onTap(0.8f, result, "胜利", 3000);
            if (result.sim > 0.8f) {
                sbcount = 0;
            }
            result = mFairy.findPic("Resurrection.png");
            mFairy.onTap(0.8f, result, 1185, 43, 1199, 54, "复活", 3000);

            result = mFairy.findPic(556, 405, 1034, 629, "other1.png");
            mFairy.onTap(0.8f, result, "领取奖励", 3000);

            result = mFairy.findPic("Experience story.png");
            mFairy.onTap(0.8f, result, "体验剧情关卡", 3000);

            result = mFairy.findPic("adventure.png");
            mFairy.onTap(0.8f, result, "冒险", 3000);

            result = mFairy.findPic("Slide chapter.png");
            mFairy.onTap(0.8f, result, 958, 327, 971, 343, "选择章节", 100);
            mFairy.onTap(0.8f, result, 958, 327, 971, 343, "选择章节", 100);
            mFairy.onTap(0.8f, result, 958, 327, 971, 343, "选择章节", 100);
            mFairy.onTap(0.8f, result, 958, 327, 971, 343, "选择章节", 100);
            mFairy.onTap(0.8f, result, 958, 327, 971, 343, "选择章节", 100);
            mFairy.onTap(0.8f, result, 625, 303, 647, 324, "选择章节", 100);

            result = mFairy.findPic("Departure.png");
            mFairy.onTap(0.8f, result, "出站", 3000);

            result = mFairy.findPic("fail.png");
            mFairy.onTap(0.8f, result, "失败", 3000);
            if (result.sim > 0.8f) {
                sbcount++;
                if (sbcount > 2) {
                    break;
                }
            }
            result = mFairy.findPic("djbz.png");
            if (result.sim > 0.8f) {
                LtLog.e(mFairy.getLineInfo("等级不足结束"));
                break;
            }

            result = mFairy.findPic("clearance.png");
            mFairy.onTap(0.8f, result, 230, 299, 256, 330, "选关", 3000);


            result = mFairy.findPic(676, 11, 1271, 312, new String[]{"fork1.png", "fork.png"});
            if (result.sim > 0.8f) {
                count_1++;
                if (count_1 > 4) {
                    mFairy.onTap(0.8f, result, "叉", 3000);
                    count_1 = 0;
                }
            } else {
                count_1 = 0;
            }
        }
    }

    //精英1
    public void elite1() throws Exception {

        new SingleTask(mFairy) {
            int sbcount = 0;

           public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public void content_1() throws Exception {
                LtLog.e("精英副本中");

                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, "冒险", 3000);


                result = mFairy.findPic("Slide chapter.png");
                mFairy.onTap(0.8f, result, 217, 52, 241, 88, "选择精英副本", 100);

                result = mFairy.findPic("Departure.png");
                mFairy.onTap(0.8f, result, "出站", 3000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("Departure.png");
                    if (result.sim > 0.8f) {
                        LtLog.e("还有出站结束任务");
                        setTaskEnd();
                    }
                }

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f, result, "失败", 3000);
                if (result.sim > 0.8f) {
                    sbcount++;
                    if (sbcount > 2) {
                        setTaskEnd();
                    }
                }
            }
        }.taskContent(mFairy,"精英1");
    }

    //精英
    public void elite() throws Exception {
        new SingleTask(mFairy) {
            List<Integer> list = new ArrayList<>();
            int k = 0;

            public  void create() throws Exception {
                for (int i = 1; i < 46; i++) {
                    if (AtFairyConfig.getOption("gk" + i).equals("1")) {
                        list.add(i);
                    }
                }
                if (list.size() == 0) {
                    setTaskEnd();
                    return;
                }
                k = list.get(0);
            }

            public  void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public   void content_1() throws Exception {
                overtime(20, 0);
                LtLog.e("精英副本中");

                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, "冒险", 3000);


                result = mFairy.findPic("Slide chapter.png");
                mFairy.onTap(0.8f, result, 217, 52, 241, 88, "选择精英副本", 100);

                result = mFairy.findPic("Departure.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("jybjsd").equals("1")) {
                        mFairy.onTap(0.8f, result, 751, 648, 768, 661, "便捷扫荡", 2000);
                        mFairy.onTap(0.8f, result, 629, 575, 652, 591, "扫荡", 10000);
                        mFairy.onTap(214, 70, 230, 85, "取消弹框", 1000);
                        mFairy.onTap(214, 70, 230, 85, "取消弹框", 1000);
                        mFairy.onTap(214, 70, 230, 85, "取消弹框", 1000);
                        setTaskEnd();
                        return;
                    }
                    LtLog.e(mFairy.getLineInfo("精英副本界面开始初始化滑动"));
                    for (int i = 0; i < 50; i++) {
                        mFairy.onTap(347, 346, 348, 347, "上一关", 100);
                    }
                }
                result = mFairy.findPic("jy1.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("精英副本第一关到了"));

                    setTaskName(2);
                }
            }

            public  void content_2() throws Exception {
                overtime(20, 0);
                result = mFairy.findPic("Departure.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("开始选择用户选择关卡" + list.get(0) + "需要点几下关卡=" + (k - 1)));
                    for (int i = 1; i < k; i++) {
                        mFairy.onTap(0.8f, result, 932, 341, 951, 358, "正在前往用户选择关卡", 100);
                    }
                    mFairy.onTap(0.8f, result, 872, 644, 891, 656, "扫荡", 2000);
                    result = mFairy.findPic("jysdgx.png");
                    if (result.sim < 0.8f) {
                        mFairy.onTap(738, 473, 746, 483, "勾选扫荡3次", 1000);
                    }
                    mFairy.onTap(850, 462, 882, 479, "开始扫荡", 5000);
                    mFairy.onTap(214, 70, 230, 85, "取消弹框", 1000);
                    mFairy.onTap(214, 70, 230, 85, "取消弹框", 1000);
                    mFairy.onTap(214, 70, 230, 85, "取消弹框", 1000);
                    int n = list.get(0);
                    list.remove(0);
                    if (list.size() == 0) {
                        setTaskEnd();
                        return;
                    }
                    int m = list.get(0);
                    k = m - n + 1;
                }
            }
        }.taskContent(mFairy,"精英");
    }

    //奖励
    public  void  jiangli()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int rzcount = 0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 1215, 340, 1238, 359, "奖励2", 1000);

                result = mFairy.findPic("jl2.png");
                if (result1.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("奖励2界面"));
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(199, 391, 1268, 488, "jl2lq.png");
                        mFairy.onTap(0.8f, result, "每日任务奖励领取", 1000);

                        result = mFairy.findPic(303, 290, 1271, 709, new String[]{"zmsure.png", "sure1.png", "sure2.png"});
                        mFairy.onTap(0.8f, result, "确定", 3000);
                    }
                    mFairy.onTap(490, 543, 515, 567, "活跃宝箱", 1000);
                    mFairy.onTap(255, 546, 280, 560, "活跃宝箱", 1000);
                    mFairy.onTap(733, 547, 751, 565, "活跃宝箱", 1000);
                    mFairy.onTap(255, 546, 280, 560, "活跃宝箱", 1000);
                    mFairy.onTap(1036, 546, 1060, 562, "活跃宝箱", 1000);
                    mFairy.onTap(255, 546, 280, 560, "活跃宝箱", 1000);
                    mFairy.onTap(1202, 549, 1218, 570, "活跃宝箱", 1000);
                    mFairy.onTap(255, 546, 280, 560, "活跃宝箱", 1000);
                    mFairy.onTap(89, 257, 117, 281, "奖励中心", 1000);
                    for (int i = 0; i < 3; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(201, 490, 1272, 624, "jl22.png");
                        mFairy.onTap(0.8f, result, "签到", 1000);
                        if (result.sim > 0.8f) {
                            i = 0;
                        }
                    }
                   setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"奖励中");
    }

    //活动奖励
    public  void  huodong()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int rzcount = 0;
            public void content_1() throws Exception {
                if (overtime(100, 99))return;
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 1217, 43, 1232, 60, "活动", 1000);


                result = mFairy.findPic("Active interface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    if (AtFairyConfig.getOption("yile").equals("1")) {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(2000);
                            mFairy.condit();
                            result = mFairy.findPic(4, 154, 163, 635, "yile.png");
                            mFairy.onTap(0.8f, result, "一乐外卖", 1000);

                            result = mFairy.findPic(286, 127, 1233, 291, "yilelq.png");
                            mFairy.onTap(0.8f, result, result.x - 30, result.y + 220, result.x - 29, result.y + 221, "一乐外卖", 1000);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("一乐外卖结束"));
                                break;
                            }
                        }
                    }

                    if (AtFairyConfig.getOption("hd1").equals("1")) {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(2000);
                            mFairy.condit();
                            result = mFairy.findPic(4, 154, 163, 635, "hd1.png");
                            mFairy.onTap(0.8f, result, "天天的礼物", 1000);

                            result = mFairy.findPic("hd1stop.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("天天的礼物结束"));
                                break;
                            }
                            result = mFairy.findPic("hd1yl.png");
                            mFairy.onTap(0.8f, result, 435, 588, 453, 602, "天天的礼物摇铃", 1000);
                            mFairy.onTap(0.8f, result, "天天的礼物摇铃", 6000);
                            mFairy.onTap(0.8f, result, 610, 558, 649, 573, "天天的礼物摇铃确定", 1000);
                            mFairy.onTap(0.8f, result, 610, 558, 649, 573, "天天的礼物摇铃确定", 1000);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("天天的礼物结束"));
                                break;
                            }
                        }
                    }
                    if (AtFairyConfig.getOption("hd2").equals("1")) {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(2000);
                            mFairy.condit();
                            result = mFairy.findPic(4, 154, 163, 635, "hd2.png");
                            mFairy.onTap(0.8f, result, "假日集元气", 1000);

                            result = mFairy.findPic("hd1stop.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("天天的礼物结束"));
                                break;
                            }

                            result = mFairy.findPic("hd2inface.png");
                            mFairy.onTap(0.8f, result, 350, 574, 369, 589, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 208, 577, 223, 588, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 481, 578, 505, 591, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 208, 577, 223, 588, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 619, 581, 637, 593, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 208, 577, 223, 588, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 749, 577, 769, 591, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 208, 577, 223, 588, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 953, 569, 973, 586, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 208, 577, 223, 588, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 1157, 577, 1173, 591, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 694, 161, 721, 176, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 697, 288, 726, 306, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 693, 422, 718, 436, "宝箱", 1000);
                            mFairy.onTap(0.8f, result, 698, 547, 720, 566, "宝箱", 1000);
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("天天的礼物结束"));
                                break;
                            }
                        }
                    }
                    if (AtFairyConfig.getOption("hd3").equals("1")) {
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(2000);
                            mFairy.condit();
                            result = mFairy.findPic(4, 154, 163, 635, "qd.png");
                            mFairy.onTap(0.8f, result, "签到", 3000);

                            result = mFairy.findPic("qd1.png");
                            mFairy.onTap(0.8f, result, "签到", 1000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                    }
                    if (AtFairyConfig.getOption("hd4").equals("1") || AtFairyConfig.getOption("hd5").equals("1")) {
                        mFairy.ranSwipe(67, 544, 85, 200, 1000, 1000);
                        mFairy.ranSwipe(67, 544, 85, 200, 1000, 1000);
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(2000);
                            mFairy.condit();
                            result = mFairy.findPic(4, 154, 163, 635, "sgrs.png");
                            mFairy.onTap(0.8f, result, "时光忍术", 1000);

                            if (AtFairyConfig.getOption("hd4").equals("1")) {
                                result = mFairy.findPic(187, 456, 1254, 573, "mfzh.png");
                                mFairy.onTap(0.8f, result, "免费追回", 1000);
                                if (result.sim > 0.8f) {
                                    i = 0;
                                }
                            }
                            if (AtFairyConfig.getOption("hd5").equals("1")) {
                                result = mFairy.findPic(187, 456, 1254, 573, "zhj.png");
                                mFairy.onTap(0.8f, result, "花钱追回", 1000);
                                if (result.sim > 0.8f) {
                                    i = 0;
                                }
                            }
                        }
                    }
                   setTaskEnd();
                }
            }
        }.taskContent(mFairy,"活动奖励中");
    }

    //羁绊对战
    public  void  jiban()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int rzcount = 0;
            public void content_1() throws Exception {
                if (overtime(100, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"Duel.png","Duel1.png"});
                mFairy.onTap(0.8f, result, "决斗场", 3000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 3000);
                }

                result = mFairy.findPic("Ninja battle.png");
                mFairy.onTap(0.8f, result, 994, 625, 1049, 641, "更多玩法", 10000);

                result = mFairy.findPic("Fetters against.png");
                mFairy.onTap(0.8f, result, "羁绊对战", 3000);

                result = mFairy.findPic("jbzd.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("羁绊组队"));
                    mFairy.onTap(0.8f, result, 765, 641, 781, 661, "更换忍者", 5000);
                    result = mFairy.findPic("jpqueding.png");
                    mFairy.onTap(0.8f, result, "更换忍者确定", 5000);
                    mFairy.onTap(0.8f, result, 1169, 602, 1188, 622, "组队", 5000);
                }
                result = mFairy.findPic(new String[]{"jbzb.png", "jbcz.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 878, 642, 895, 655, "查看羁绊任务", 3000);
                    for (int i = 0; i < 3; i++) {
                        result1 = mFairy.findPic(435, 75, 846, 639, "jblj.png");
                        mFairy.onTap(0.8f, result1, "羁绊领奖", 1000);

                        result1 = mFairy.findPic("jpstop.png");
                        if (result1.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("羁绊对战完成"));
                            setTaskEnd();
                            return;
                        }

                    }
                }
                mFairy.onTap(0.8f, result, "羁绊准备出站", 1000);
                mFairy.onTap(0.8f, result, "羁绊准备出站", 1000);
            }
        }.taskContent(mFairy,"羁绊对战中");
    }

    //秘境
    public  void  mijing()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int mjcount = 0;
            public void content_1() throws Exception {
                if (overtime(60, 99))return;
                result = mFairy.findPic("attack.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "普工"));
                if (result.sim>0.8f){
                    result = mFairy.findPic("mjdjs.png");
                    LtLog.e(mFairy.getLineInfo(0.8f, result, "秘境胜利"));
                    if (result.sim > 0.8f) {
                        mjcount = 0;
                    } else {
                        mjcount++;
                        if (mjcount > 3) {
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result = mFairy.findPic(26, 17, 1243, 682, new  String[]{"tx.png","tx1.png"});
                mFairy.onTap(0.8f, result, result.x - 205, result.y + 136, result.x - 204, result.y + 137, "忍者挑战", 10000);

                result = mFairy.findPic(26, 17, 1243, 682, "findmj.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("走两步找秘境"));
                    mFairy.ranSwipe(216, 550, 308, 550, 1500, 1000);
                }
                result = mFairy.findPic(26, 17, 1243, 682, "mjtx.png");
                mFairy.onTap(0.8f, result, "秘境探险", 10000);


                if (AtFairyConfig.getOption("mj").equals("1")) {
                    result = mFairy.findPic("cjfj.png");
                    mFairy.onTap(0.8f, result, "创建房间", 1000);

                    result = mFairy.findPic("mjcz.png");
                    if (result.sim > 0.8f) {
                        result1 = mFairy.findPic("mjstop.png");
                        if (result1.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("秘境结束"));
                            setTaskEnd();
                            gameUtil.close();
                            return;
                        }
                    }
                    mFairy.onTap(0.8f, result, "秘境出站", 1000);
                }

                if (AtFairyConfig.getOption("mj").equals("2")) {
                    result = mFairy.findPic("cjfj.png");
                    mFairy.onTap(0.8f, result, 685, 515, 715, 533, "系统匹配", 1000);

                    result = mFairy.findPic("mjzb.png");
                    if (result.sim > 0.8f) {
                        result1 = mFairy.findPic("mjstop.png");
                        if (result1.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("秘境结束"));
                            setTaskEnd();
                            gameUtil.close();
                            return;
                        }
                    }
                    mFairy.onTap(0.8f, result, "准备", 1000);

                    result = mFairy.findPic("mjcz.png");
                    mFairy.onTap(0.8f, result, 1214, 28, 1229, 43, "秘境是队长出去", 1000);
                }


                result = mFairy.findPic("qbxz.png");
                mFairy.onTap(0.8f, result, "全部下载", 1000);
                if (result.sim > 0.8f) {
                    Thread.sleep(30000);
                    mFairy.onTap(0.8f, result, 1077, 109, 1099, 121, "全部下载关闭", 1000);
                }
                result = mFairy.findPic("qwxz.png");
                mFairy.onTap(0.8f, result, "前往下载", 1000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"秘境中");
    }

    //斗气奖励
    public  void  douqi()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int rzcount = 0;
            public void content_1() throws Exception {
                if (overtime(60, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"Duel.png","Duel1.png"});
                mFairy.onTap(0.8f, result, "决斗场", 10000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 1000);
                }

                result = mFairy.findPic("Ninja battle.png");
                mFairy.onTap(0.8f, result, "忍术对战", 10000);


                result = mFairy.findPic("zsOpening station.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("开站,看任务"));
                    mFairy.onTap(0.8f, result, 794, 649, 808, 659, "开站,看任务", 4000);
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(991, 179, 1118, 500, "zslq.png");
                        mFairy.onTap(0.8f, result, "周胜领取", 1000);
                    }
                    mFairy.onTap(419, 569, 435, 585, "领首胜", 100);
                    mFairy.onTap(666, 568, 685, 586, "领斗气", 100);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 100);

                    mFairy.onTap(779, 564, 799, 587, "领斗气", 100);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 100);
                    mFairy.onTap(884, 569, 906, 581, "领斗气", 100);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 1000);

                    rzcount = 0;
                    result = mFairy.findPic(390, 296, 584, 390, "cji.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "c级忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 1;
                    }
                    result = mFairy.findPic(390, 296, 584, 390, "bji.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "b级忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 2;
                    }

                    result = mFairy.findPic(390, 296, 584, 390, "girlrz.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "女忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 3;
                    }
                    result = mFairy.findPic(390, 296, 584, 390, "aji.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "a级忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 4;
                    }

                    result = mFairy.findPic(851, 527, 957, 628, "dqjl.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("斗气奖励打完了结束"));
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(1081, 111, 1099, 128, "关闭决斗任务界面", 1000);
                    mFairy.onTap(1035, 654, 1053, 670, "调整阵容", 10000);
                }
                result = mFairy.findPic("zstzzr.png");
                mFairy.onTap(0.8f, result, 177, 312, 200, 334, "下阵忍者", 1000);
                mFairy.onTap(0.8f, result, 409, 380, 436, 399, "下阵忍者", 1000);
                mFairy.onTap(0.8f, result, 638, 371, 659, 390, "下阵忍者", 1000);
                int count=0;
                if (result.sim > 0.8f) {
                    if (rzcount == 0) {
                        mFairy.onTap(0.7f, result, 839, 175, 853, 192, "随便选个忍者", 1000);
                        mFairy.onTap(0.7f, result, 953, 178, 970, 194, "随便选个忍者", 1000);
                        mFairy.onTap(0.7f, result, 1065, 180, 1080, 198, "随便选个忍者", 1000);
                    }
                    if (rzcount == 1) {
                        mFairy.onTap(1145, 106, 1177, 118, "c级忍者", 1000);
                        mFairy.onTap(1122, 326, 1150, 342, "c级忍者", 2000);
                        for (int i=0;i<10;i++){
                            mFairy.condit();
                            result = mFairy.findPic(796, 132, 904, 556, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(908, 133, 1012, 549, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1022, 129, 1127, 548, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1136, 136, 1240, 554, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(1149,540,1150,541,"下一页", 2000);
                            }
                        }


                    }
                    if (rzcount == 2) {
                        mFairy.onTap(1145, 106, 1177, 118, "b级忍者", 1000);
                        mFairy.onTap(1124, 276, 1151, 291, "b级忍者", 2000);
                        for (int i=0;i<10;i++) {
                            mFairy.condit();
                            result = mFairy.findPic(796, 132, 904, 556, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(908, 133, 1012, 549, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1022, 129, 1127, 548, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1136, 136, 1240, 554, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(1149,540,1150,541,"下一页", 2000);
                            }
                        }

                    }
                    if (rzcount == 3) {
                        mFairy.onTap(1145, 106, 1177, 118, "c级忍者", 1000);
                        mFairy.onTap(1122, 326, 1150, 342, "c级忍者", 1000);
                        for (int i=0;i<10;i++) {
                            mFairy.condit();
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr1.png");
                            mFairy.onTap(0.7f, result, "女忍1", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr2.png");
                            mFairy.onTap(0.7f, result, "女忍2", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr3.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr4.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr5.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr6.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(1149,540,1150,541,"下一页", 2000);
                            }

                        }

                    }
                    if (rzcount == 4) {
                        mFairy.onTap(1145, 106, 1177, 118, "a级忍者", 1000);
                        mFairy.onTap(1094, 222, 1126, 232, "a级忍者", 1000);
                        for (int i=0;i<10;i++) {
                            mFairy.condit();
                            result = mFairy.findPic(908, 133, 1012, 549, "ajirz.png");
                            mFairy.onTap(0.7f, result, "a级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1022, 129, 1127, 548, "ajirz.png");
                            mFairy.onTap(0.7f, result, "a级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1136, 136, 1240, 554, "ajirz.png");
                            mFairy.onTap(0.7f, result, "a级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(972,539,973,540,"下一页", 2000);
                            }
                        }
                    }
                    mFairy.onTap(0.7f, result, 985, 582, 1046, 607, "确定", 2000);
                    result = mFairy.findPic("zstzzr.png");
                    if (result.sim > 0.8f) {
                    } else {
                        mFairy.onTap(1157, 593, 1180, 625, "开站", 5000);
                    }
                }
            }
        }.taskContent(mFairy,"斗气奖励中");
    }

    //周胜
    public  void  zhousheng()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int rzcount = 0;
            public void content_1() throws Exception {
                if (overtime(60, 99))return;

                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"Duel.png","Duel1.png"});
                mFairy.onTap(0.8f, result, "决斗场", 10000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 1000);
                }

                result = mFairy.findPic("Ninja battle.png");
                mFairy.onTap(0.8f, result, "忍术对战", 10000);


                result = mFairy.findPic("zsOpening station.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("开站,看任务"));
                    mFairy.onTap(0.8f, result, 794, 649, 808, 659, "开站,看任务", 4000);
                    for (int i = 0; i < 4; i++) {
                        result = mFairy.findPic(991, 179, 1118, 500, "zslq.png");
                        mFairy.onTap(0.8f, result, "周胜领取", 1000);
                    }
                    mFairy.onTap(419, 569, 435, 585, "领首胜", 1000);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 1000);
                    mFairy.onTap(666, 568, 685, 586, "领斗气", 1000);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 1000);
                    mFairy.onTap(779, 564, 799, 587, "领斗气", 1000);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 1000);
                    mFairy.onTap(884, 569, 906, 581, "领斗气", 1000);
                    mFairy.onTap(218, 541, 238, 554, "领斗气", 1000);

                    rzcount = 0;
                /*    result = mFairy.findPic(390, 296, 584, 390, "cji.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "c级忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 1;
                    }
                    result = mFairy.findPic(390, 296, 584, 390, "bji.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "b级忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 2;
                    }

                    result = mFairy.findPic(390, 296, 584, 390, "girlrz.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "女忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 3;
                    }

                    result = mFairy.findPic(390, 296, 584, 390, "aji.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "a级忍者"));
                    if (result.sim > 0.9f) {
                        rzcount = 4;
                    }*/

                    mFairy.onTap(222, 346, 245, 363, "周任务", 2000);
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(980,175,1115,586, "zslq.png");
                        mFairy.onTap(0.8f, result, "周胜领取", 1000);
                    }
                    result = mFairy.findPic(980,493,1109,586, "zsstop.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("周胜打完了结束"));
                       setTaskEnd();
                        return;
                    }
                    mFairy.onTap(1081, 111, 1099, 128, "关闭决斗任务界面", 1000);
                    mFairy.onTap(1035, 654, 1053, 670, "调整阵容", 10000);
                }
                result = mFairy.findPic("zstzzr.png");
                mFairy.onTap(0.8f, result, 177, 312, 200, 334, "下阵忍者", 1000);
                mFairy.onTap(0.8f, result, 409, 380, 436, 399, "下阵忍者", 1000);
                mFairy.onTap(0.8f, result, 638, 371, 659, 390, "下阵忍者", 1000);
                int count=0;
                if (result.sim > 0.8f) {
                    if (rzcount == 0) {
                        mFairy.onTap(0.7f, result, 839, 175, 853, 192, "随便选个忍者", 1000);
                        mFairy.onTap(0.7f, result, 953, 178, 970, 194, "随便选个忍者", 1000);
                        mFairy.onTap(0.7f, result, 1065, 180, 1080, 198, "随便选个忍者", 1000);
                    }
                    if (rzcount == 1) {
                        mFairy.onTap(1145, 106, 1177, 118, "c级忍者", 1000);
                        mFairy.onTap(1122, 326, 1150, 342, "c级忍者", 2000);
                        for (int i=0;i<10;i++){
                            mFairy.condit();
                            result = mFairy.findPic(796, 132, 904, 556, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(908, 133, 1012, 549, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1022, 129, 1127, 548, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1136, 136, 1240, 554, "cjirenz.png");
                            mFairy.onTap(0.7f, result, "c级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(1149,540,1150,541,"下一页", 2000);
                            }
                        }


                    }
                    if (rzcount == 2) {
                        mFairy.onTap(1145, 106, 1177, 118, "b级忍者", 1000);
                        mFairy.onTap(1124, 276, 1151, 291, "b级忍者", 2000);
                        for (int i=0;i<10;i++) {
                            mFairy.condit();
                            result = mFairy.findPic(796, 132, 904, 556, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(908, 133, 1012, 549, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1022, 129, 1127, 548, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1136, 136, 1240, 554, "bjirenz.png");
                            mFairy.onTap(0.7f, result, "b级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(972,539,973,540,"下一页", 2000);
                            }
                        }

                    }
                    if (rzcount == 3) {
                        mFairy.onTap(1145, 106, 1177, 118, "c级忍者", 1000);
                        mFairy.onTap(1122, 326, 1150, 342, "c级忍者", 1000);
                        for (int i=0;i<10;i++) {
                            mFairy.condit();
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr1.png");
                            mFairy.onTap(0.7f, result, "女忍1", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr2.png");
                            mFairy.onTap(0.7f, result, "女忍2", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr3.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr4.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr5.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(794, 132, 1246, 558, "grilr6.png");
                            mFairy.onTap(0.7f, result, "女忍3", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(1149,540,1150,541,"下一页", 2000);
                            }

                        }

                    }
                    if (rzcount == 4) {
                        mFairy.onTap(1145, 106, 1177, 118, "a级忍者", 1000);
                        mFairy.onTap(1094, 222, 1126, 232, "a级忍者", 1000);
                        for (int i=0;i<10;i++) {
                            mFairy.condit();
                            result = mFairy.findPic(908, 133, 1012, 549, "ajirz.png");
                            mFairy.onTap(0.7f, result, "a级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1022, 129, 1127, 548, "ajirz.png");
                            mFairy.onTap(0.7f, result, "a级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            result = mFairy.findPic(1136, 136, 1240, 554, "ajirz.png");
                            mFairy.onTap(0.7f, result, "a级忍者", 1000);
                            if (result.sim>0.7f){
                                count++;
                            }
                            if (count>=3){
                                break;
                            }else {
                                mFairy.onTap(1149,540,1150,541,"下一页", 2000);
                            }
                        }
                    }
                    mFairy.onTap(0.8f, result, 985, 582, 1046, 607, "确定", 2000);
                    result = mFairy.findPic("zstzzr.png");
                    if (result.sim > 0.8f) {
                    } else {
                        mFairy.onTap(1157, 593, 1180, 625, "开站", 5000);
                    }
                }
            }
        }.taskContent(mFairy,"周胜中");
    }

    //积分赛
    public  void  jifensai()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int sjcount=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"integral.png","integral1.png"});
                mFairy.onTap(0.8f, result, "积分赛", 10000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 1000);
                }

                result = mFairy.findPic("Integral challenge.png");
                mFairy.onTap(0.8f, result, "积分挑战", 1000);

                result = mFairy.findPic(960, 534, 1107, 596, "jftz.png");
                mFairy.onTap(0.8f, result, "积分挑战1", 1000);


                result = mFairy.findPic("jfstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("积分赛结束"));
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"积分赛中");
    }

    //生存
    public  void  shengcun()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int sjcount=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"slzd.png","slzd1.png"});
                mFairy.onTap(0.8f, result, "试炼之地", 1000);

                result=mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,846,544,891,564,"选择出战忍者",1000);

                result = mFairy.findPic("slzd_inface.png");
                mFairy.onTap(0.8f, result, 870, 276, 899, 314, "生存", 1000);

                result = mFairy.findPic("sckz.png");
                mFairy.onTap(0.8f, result, "开站", 1000);

                result = mFairy.findPic("scmy.png");
                mFairy.onTap(0.8f, result, 881, 644, 903, 660, "没有可以出战的忍者", 1000);

                result = mFairy.findPic("zbjx.png");
                mFairy.onTap(0.8f, result, "准备就绪", 1000);

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f, result, "生存失败了", 5000);
                mFairy.onTap(0.8f, result, 880, 643, 909, 659, "重置", 1000);


                result = mFairy.findPic("scstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("生存结束"));
                   setTaskEnd();
                    return;
                }


                result = mFairy.findPic("sclj.png");
                mFairy.onTap(0.8f, result, "生存领奖", 1000);
                mFairy.onTap(0.8f, result, "生存领奖", 1000);


                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"生存中");
    }

    //修行
    public  void  xiuxing()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int sjcount=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"slzd.png","slzd1.png"});
                mFairy.onTap(0.8f, result, "试炼之地", 1000);

                result = mFairy.findPic("slzd_inface.png");
                mFairy.onTap(0.8f, result, "修行", 1000);

                result = mFairy.findPic("xxDeparture.png");
                mFairy.onTap(0.8f, result, "出站", 1000);

                result = mFairy.findPic(new String[]{"xxchuansong.png","xxchuansong1.png"});
                mFairy.onTap(0.8f, result, "传送", 6000);

                result=mFairy.findPic("award.png");
                mFairy.onTap(0.8f,result,607,271,654,311,"宝箱奖励",1000);

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f, result, "修行失败了", 5000);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("xxcs.png");
                    LtLog.e(mFairy.getLineInfo("修行没有重置次数了"));
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    } else {
                        mFairy.onTap(757, 647, 774, 665, "重置", 2000);
                    }
                }
                result = mFairy.findPic("xxsd.png");
                mFairy.onTap(0.8f, result, "扫荡", 1000);

                result = mFairy.findPic("xxlj.png");
                mFairy.onTap(0.8f, result, "修行领奖", 1000);
                mFairy.onTap(0.8f, result, "修行领奖", 1000);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("xxsdzhong.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("修行扫荡中"));
                    err = 0;
                }

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"修行中");
    }

    //小队突袭
    public  void  tuxi()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int sjcount=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new  String[]{"tx.png","tx1.png"});
                mFairy.onTap(0.8f, result, "小队突袭", 1000);

                result1 = mFairy.findPic("matching.png");
                if (result1.sim > 0.8f) {
                    if (AtFairyConfig.getOption("txsb").equals("1")) {
                        result = mFairy.findPic("txsbgx.png");
                        mFairy.onTap(0.8f, result, "突袭三倍勾选", 1000);
                    }
                    result = mFairy.findPic("txcs.png");
                    LtLog.e(mFairy.getLineInfo(0.8f, result, "突袭次数没了结束"));
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.onTap(0.8f, result1, "匹配", 1000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"小队突袭中");
    }

    //赏金
    public  void  shangjin()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int sjcount=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new  String[]{"fzzj.png","fzzj1.png"});
                mFairy.onTap(0.8f, result, "丰饶之间", 1000);

                result = mFairy.findPic("makeLive.png");
                mFairy.onTap(0.8f, result, 977, 272, 1008, 300, "赏金", 1000);
                if (result.sim > 0.8f) {
                    sjcount++;
                    if (sjcount > 3) {
                       setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic(913, 394, 1087, 536, "frcomplete.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "完成"));
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"赏金中");
    }

    //闯荡
    public  void  chuangdang()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int fr_count=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new  String[]{"fzzj.png","fzzj1.png"});
                mFairy.onTap(0.8f, result, "丰饶之间", 1000);

                result = mFairy.findPic("makeLive.png");
                mFairy.onTap(0.8f, result, 638, 272, 666, 298, "闯荡", 1000);
                if (result.sim > 0.8) {
                    fr_count++;
                    if (fr_count>=3){
                        setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic(220, 415, 384, 535, "frcomplete.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "完成"));
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(552, 405, 742, 533, "adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"闯荡中");
    }

    //历练
    public  void  lilian()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            int fr_count=0;
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new  String[]{"fzzj.png","fzzj1.png"});
                mFairy.onTap(0.8f, result, "丰饶之间", 1000);

                result = mFairy.findPic("makeLive.png");
                mFairy.onTap(0.8f, result, 281, 231, 323, 262, "历练", 1000);
                if (result.sim > 0.8) {
                    fr_count++;
                    if (fr_count>=3){
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic(220, 415, 384, 535, "frcomplete.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "完成"));
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"历练中");
    }

    //丰饶一键
    public  void  fengrao()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(8, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new  String[]{"fzzj.png","fzzj1.png"});
                mFairy.onTap(0.8f, result, "丰饶之间", 1000);

                result = mFairy.findPic("fryj.png");
                mFairy.onTap(0.8f, result, "丰饶一键", 2000);
                mFairy.onTap(0.8f, result, 641, 452, 675, 470, "丰饶一键确定", 3000);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(955, 351, 210, 325, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"丰饶一键中");
    }

    //祈福
    public  void  qifu()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"zuzhi.png","zuzhi1.png"});
                LtLog.e(mFairy.getLineInfo(0.5f,result,"组织"));
                mFairy.onTap(0.8f, result, "组织", 1000);


                result = mFairy.findPic("Organizational interface.png");
                mFairy.onTap(0.8f, result, "组织玩法", 1000);

                result = mFairy.findPic("Pray for blessing.png");
                mFairy.onTap(0.8f, result, "祈福前往", 1000);

                result = mFairy.findPic("Blessing times.png");
                mFairy.onTap(0.8f, result, 574, 574, 604, 593, "祈福", 3000);
                mFairy.onTap(0.8f, result, 1213, 26, 1231, 44, "祈福", 1000);

                result = mFairy.findPic("qf0.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1184, 192, 1195, 204, "祈福0", 1000);
                    mFairy.onTap(0.8f, result, 1184, 192, 1195, 204, "祈福0", 1000);
                    mFairy.onTap(0.8f, result, 1194, 294, 1208, 306, "祈福0", 1000);
                    mFairy.onTap(0.8f, result, 1194, 294, 1208, 306, "祈福0", 1000);
                    mFairy.onTap(0.8f, result, 1189, 405, 1207, 425, "祈福0", 1000);
                    mFairy.onTap(0.8f, result, 1189, 405, 1207, 425, "祈福0", 1000);
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 1000);
                }
            }
        }.taskContent(mFairy,"祈福中");
    }

    //招财
    public  void  zhaoCai()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 746, 38, 759, 52, "招财", 1000);

                result = mFairy.findPic("mfzc.png");
                mFairy.onTap(0.8f, result, "免费招财", 1000);

                result = mFairy.findPic("zcstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo(0.8f, result, "招财结束"));
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"招财中");
    }

    //点赞
    public  void  dianZan()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"phb.png","phb1.png"});
                mFairy.onTap(0.8f, result, "排行榜", 1000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 1000);
                }
                result = mFairy.findPic(1130, 127, 1264, 566, "taplike.png");
                mFairy.onTap(0.8f, result, "点赞", 1000);
                mFairy.onTap(0.8f, result, "点赞", 1000);
                mFairy.onTap(0.8f, result, "点赞", 1000);
                if (result.sim > 0.8f) {
                     setTaskEnd();return;
                }
                result = mFairy.findPic(1130, 127, 1264, 566, "Praised.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "已赞"));
                if (result.sim > 0.8f) {
                    setTaskEnd();return;
                }
                err += 3;
            }
        }.taskContent(mFairy,"点赞中");
    }

    //招募
    public  void  zhaoMu()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 1217, 146, 1230, 170, "招募", 1000);

                result = mFairy.findPic("Exemption.png");
                mFairy.onTap(0.8f, result, "免费", 1000);

                result = mFairy.findPic("Exemption1.png");
                mFairy.onTap(0.8f, result, "免费1", 1000);

                result = mFairy.findPic("zmstop.png");
                if (result.sim > 0.8f) {
                    err += 5;
                }
            }
        }.taskContent(mFairy,"招募中");
    }

    //赠送
    public  void  zengSong()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(20, 99))return;
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 50, 205, 64, 220, "好友", 1000);

                result = mFairy.findPic("Presentation interface.png");
                mFairy.onTap(0.8f, result, 231, 335, 249, 355, "qq好友", 1000);

                result = mFairy.findPic("onegive.png");
                mFairy.onTap(0.8f, result, "一键赠送", 1000);
                mFairy.onTap(0.8f, result, 574, 583, 609, 597, "一键领取", 1000);
                if (result.sim > 0.8f) {
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"赠送中");
    }

    //邮件
    public  void  youjian()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
               if (overtime(20, 99))return;
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 48, 274, 65, 284, "邮件", 1000);

                result = mFairy.findPic("yjtq.png");
                mFairy.onTap(0.8f, result, "一键提取", 1000);
                if (result.sim > 0.8f) {
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"邮件中");
    }

    //会所
    public void club() throws Exception {
        new SingleTask(mFairy) {
            int hs = 1;

          public   void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public void content_1() throws Exception {
                overtime(60, 99);
                LtLog.e("会所任务中");
                result = mFairy.findPic(26, 17, 1243, 682, new String[]{"club.png","club1.png"});
                mFairy.onTap(0.8f, result, "会所", 1000);

                result = mFairy.findPic("adventure.png");
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(352, 326, 950, 304, 1000, 1000);
                }
                for (int i = 0; i < 2; i++) {
                    result = mFairy.findPic("Club reception.png");
                    mFairy.onTap(0.8f, result, "会所领取", 1000);
                    mFairy.onTap(0.8f, result, "会所领取", 1000);
                    if (result.sim < 0.8f) {
                        break;
                    }
                }

                result = mFairy.findPic(1106, 255, 1234, 312, "Pick up.png");
                if (result.sim > 0.8f & hs < 3) {
                    mFairy.onTap(0.8f, result, "会所接取1", 1000);
                }

                result = mFairy.findPic(1114, 363, 1234, 423, "Pick up.png");
                if (result.sim > 0.8f && hs >= 3 && hs <= 6) {
                    mFairy.onTap(0.8f, result, "会所接取2", 1000);
                }

                result = mFairy.findPic(1101, 449, 1234, 540, "Pick up.png");
                if (result.sim > 0.8f && hs > 6) {
                    mFairy.onTap(0.8f, result, "会所接取3", 1000);
                }


                result = mFairy.findPic("hsSet out.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("hsjb.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("开始选择羁绊忍者"));
                        int x = 877;
                        int y = 153;
                        int x1 = 877;
                        int y1 = 153;
                        for (int j = 0; j < 100; j++) {
                            x1 = 877;
                            y1 = 153;
                            mFairy.tap(x, y);
                            Thread.sleep(1500);
                            x = x + 100;
                            if (x > 1200) {
                                y = y + 100;
                                x = 877;
                            }
                            if (y > 500) {
                                gameUtil.close();
                                break;
                            }
                            for (int i = 0; i < 100; i++) {
                                if (x1 == x && y1 == y) {
                                } else {
                                    mFairy.tap(x1, y1);
                                }
                                x1 = x1 + 100;
                                if (x1 > 1200) {
                                    y1 = y1 + 100;
                                    x1 = 877;
                                }
                                if (y1 > 500) {
                                    break;
                                }
                            }
                            mFairy.onTap(0.8f, result, 1163, 623, 1190, 646, "会所羁绊出发", 1000);
                            hs = hs + 2;
                        }
                        gameUtil.close();
                    }
                }
                result = mFairy.findPic("hsSet out.png");
                mFairy.onTap(0.8f, result, 913, 573, 933, 582, "推荐小队", 1000);
                mFairy.onTap(0.8f, result, "会所出发", 1000);


                result = mFairy.findPic("hsSet out.png");
                if (result.sim > 0.8f) {
                    int x = 877;
                    int y = 153;
                    for (int j = 0; j < 100; j++) {
                        mFairy.tap(x, y);
                        x = x + 100;
                        if (x > 1200) {
                            y = y + 100;
                            x = 877;
                        }
                        if (y > 500) {
                            break;
                        }
                    }
                    mFairy.onTap(0.8f, result, "会所出发", 1000);
                    if (result.sim > 0.8f) {
                        gameUtil.close();
                    }
                }
                hs++;
                if (hs > 9) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"会所");
    }

    //装备升级
    public void equip() throws Exception {
        new SingleTask(mFairy) {
            int zbcount = 1;

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public  void content_1() throws Exception {
                LtLog.e("装备升级任务中");
                overtime(100, 99);
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 266, 656, 298, 670, "装备", 1000);

                result = mFairy.findPic("equipment.png");
                mFairy.onTap(0.8f, result, "装备", 1000);


                result = mFairy.findPic("equipment-inface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("装备界面"));
                    if (zbcount == 1) {
                        mFairy.onTap(0.8f, result, 173, 236, 191, 249, "装备1111", 1500);
                    }
                    if (zbcount == 2) {
                        mFairy.onTap(0.8f, result, 347, 234, 370, 254, "装备2222", 1500);
                    }
                    if (zbcount == 3) {
                        mFairy.onTap(0.8f, result, 509, 240, 536, 256, "装备3333", 1500);
                    }
                    if (zbcount == 4) {
                        mFairy.onTap(0.8f, result, 173, 392, 193, 408, "装备4444", 1500);
                    }
                    if (zbcount == 5) {
                        mFairy.onTap(0.8f, result, 346, 398, 363, 418, "装备5555", 1500);
                    }
                    if (zbcount == 6) {
                        mFairy.onTap(0.8f, result, 504, 403, 525, 424, "装备6666", 1500);
                    }
                    if (zbcount == 7) {
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic("Advanced.png");
                    mFairy.onTap(0.8f, result, "进阶", 1000);
                    if (result.sim > 0.8f) {
                        zbcount++;
                        return;
                    } else {
                        mFairy.onTap(1150, 540, 1187, 558, "一键添加", 2000);
                    }
                    for (int i = 0; i < 3; i++) {
                        result = mFairy.findPic(684, 402, 1243, 484, new String[]{"Need to sweep.png", "Need to sweep1.png"});
                        mFairy.onTap(0.8f, result, "需要扫荡", 2000);
                        if (result.sim > 0.8f) {
                            break;
                        }
                    }
                    result = mFairy.findPic(new String[]{"Synthesis.png", "Synthesis success.png"});
                    mFairy.onTap(0.8f, result, "合成，装备", 1000);
                    mFairy.onTap(0.8f, result, 46, 478, 59, 489, "开始扫荡", 100);
                    mFairy.onTap(0.8f, result, 46, 478, 59, 489, "开始扫荡", 100);

                    result = mFairy.findPic("Access way.png");
                    mFairy.onTap(0.8f, result, result.x + 80, result.y + 90, result.x + 81, result.y + 91, "获取途径", 2000);

                    result = mFairy.findPic("Departure.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("材料副本没有打开进行下一个装备"));
                        zbcount++;
                        gameUtil.close();
                        return;
                    }

                    result = mFairy.findPic("sd5ci.png");
                    mFairy.onTap(0.8f, result, "扫荡5次", 1500);

                    result = mFairy.findPic("sd5ci1.png");
                    mFairy.onTap(0.8f, result, 848, 507, 868, 521, "开始扫荡", 3000);

                    result1 = mFairy.findPic("No physical.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("没有体力了"));
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f, result, 46, 478, 59, 489, "开始扫荡", 100);
                    mFairy.onTap(0.8f, result, 46, 478, 59, 489, "开始扫荡", 1000);
                    mFairy.onTap(0.8f, result, 46, 478, 59, 489, "开始扫荡", 1000);
                }
            }
        }.taskContent(mFairy,"装备升级");
    }

    //一乐
    public void yile() throws Exception {
        new SingleTask(mFairy) {
            int hs = 1;

            public  void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public   void content_1() throws Exception {
                overtime(20, 99);
                LtLog.e("一乐外卖中");
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 1217, 43, 1232, 60, "活动", 1000);

                result = mFairy.findPic("Active interface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("活动界面"));
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(2000);
                        mFairy.condit();
                        result = mFairy.findPic(4, 154, 163, 635, "yile.png");
                        mFairy.onTap(0.8f, result, "一乐外卖", 1000);

                        result = mFairy.findPic(286, 127, 1233, 291, "yilelq.png");
                        mFairy.onTap(0.8f, result, result.x - 30, result.y + 220, result.x - 29, result.y + 221, "一乐外卖", 1000);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("一乐外卖结束"));

                            setTaskEnd();
                        }
                    }
                }
            }
        }.taskContent(mFairy,"一乐");
    }

    //设置
    public void setUp() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public    void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            @Override
            public    void content_1() throws Exception {
                overtime(20, 99);
                result = mFairy.findPic("adventure.png");
                mFairy.onTap(0.8f, result, 49, 141, 66, 160, "设置", 1000);

                result = mFairy.findPic("Setup interface.png");
                mFairy.onTap(0.8f, result, 228, 329, 245, 346, "高级设置", 1000);
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(562, 203, 567, 585, 1000, 1000);
                    for (int i = 0; i < 6; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(312, 162, 1122, 630, "Set check.png");
                        mFairy.onTap(0.8f, result, "取消勾选", 100);
                    }
                    mFairy.ranSwipe(567, 585, 562, 203, 1000, 100);
                    for (int i = 0; i < 6; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(312, 162, 1122, 630, "Set check.png");
                        mFairy.onTap(0.8f, result, "取消勾选", 1000);
                    }
                    gameUtil.close();
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy,"设置");
    }

}
