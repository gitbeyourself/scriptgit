package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    GameUtil gameUtil;
    SingleTask singleTask;
    TaskContent.ControlSplit optime1 = null;

    public TimingActivity(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
        singleTask = new SingleTask(mFairy);
        jzqd.add(13);
        sjzy.add(14);
        jzqd.add(15);
        jzqd.add(16);
        jzqd.add(17);
        sjzy.add(18);
        jzqd.add(19);

        sjzy.add(13);
        sjzy.add(14);
        sjzy.add(15);
        sjzy.add(16);
        sjzy.add(17);
        sjzy.add(18);
        sjzy.add(23);

        if (!AtFairyConfig.getOption("optime1").equals("")) {
            optime1 = strSplit(AtFairyConfig.getOption("optime1"));
        }
    }

    List<Integer> jzqd = new ArrayList<>();
    List<Integer> sjzy = new ArrayList<>();
    int kjxs = 0, jzkd = 0, jzls = 0, jzls1 = 0, fqhs = 0, zhanchang = 0, jzsl = 0, jzjh = 0, ddmt = 0, ryjjc = 0, lldb = 0,
            jzms = 0, mphw = 0, ygbh = 0, tsly = 0, zbs = 0, yjdx = 0, szlc = 0, sjzy1 = 0, jzqd1 = 0;
    int ldz = 0, cfjj=0, pwzz=0, jbjl = 0;
    int sjsy = 0;

    public int timingActivity() throws Exception {
        int h = mFairy.dateHour();
        int m = mFairy.dateMinute();
        int w = mFairy.week();
        int s = (h * 60 + m) * 60;
        int back = 0;

        LtLog.e(mFairy.getLineInfo("检测限时任务"));

        for (int i = 0; i < 2; i++) {

            if (AtFairyConfig.getOption("cfjj").equals("1") && w == 6 &&(( h==19 && m>=57)||(h==20 && m<48)) && cfjj == 0) {
                // LtLog.e(mFairy.getLineInfo("用户勾选冲锋竞技"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                cfjj();
                cfjj = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("zhanchang").equals("1") && w != 7 && ((h==11 && m>=58) || h == 12) && m < 40 && zhanchang == 0) {
                // LtLog.e(mFairy.getLineInfo("用户勾选战场"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                zhanchang();
                zhanchang = 1;
                back = 1;
            }
            if (AtFairyConfig.getOption("zhanchang").equals("1") && w != 7 && ((h==21 && m>=58) || h == 22) && m < 40 && zhanchang == 0) {
                // LtLog.e(mFairy.getLineInfo("用户勾选战场"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                zhanchang();
                zhanchang = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("sjsy").equals("1") && h == 19 && m < 5 && sjsy == 0) {
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                sjsy();
                sjsy = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("jzsl").equals("1") && w != 7 && h == 19 && m >= 8 && m < 20 && jzsl == 0) {
                //   LtLog.e(mFairy.getLineInfo("用户勾选家族首领"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                jzsl();
                jzsl = 1;
                back = 1;
                if (AtFairyConfig.getOption("jzjh").equals("1") && h == 19 && (m >= 15 && m<= 30 ) && jzjh == 0) {
                    //    LtLog.e(mFairy.getLineInfo("用户勾选家族酒会"));
                    if (w == 6 || w == 7) {
                        jzwh();
                    } else {
                        jzjh();
                    }
                    jzjh = 1;
                    back = 1;
                }

            }

            if (AtFairyConfig.getOption("jzjh").equals("1") && h == 19 && (m >= 15 && m<= 30 ) && jzjh == 0) {
                //    LtLog.e(mFairy.getLineInfo("用户勾选家族酒会"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                if (w == 6 || w == 7) {
                    jzwh();
                } else {
                    jzjh();
                }
                jzjh = 1;
                back = 1;
            }

            if (!AtFairyConfig.getOption("jzls").equals("") && (w == 2 || w == 4) && h == 20  && jzls == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选家族联赛"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                jzls();
                jzls = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("kjxs").equals("1") && w != 6 && w != 7 && h >= 19 && h < 22 && kjxs == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选科举答题"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                kjxs();
                kjxs = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("jzkd").equals("1") && (w == 1 || w == 3 || w == 5) && ((h >= 12 && m >=30) || h >=13) && jzkd == 0) {
                //   LtLog.e(mFairy.getLineInfo("用户勾选家族矿洞"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                jzkd();
                jzkd = 1;
                back = 1;
            }



            if (!AtFairyConfig.getOption("jzls").equals("") && w == 2 && h == 21 && jzls1 == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选家族联赛"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                jzls1();
                jzls1 = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("fqhs").equals("1") && (w == 2 || w == 4 || w == 6) && ((h >= 12 && m >=30) || h >=13) && fqhs == 0) {
                //   LtLog.e(mFairy.getLineInfo("用户勾选法器护送"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                fqhs();
                fqhs = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("ddmt").equals("1") && w == 7 && (h>12 && h<24) && ddmt == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选颠倒魔塔"));
                gameUtil.lkfb();
                ddmt();
                ddmt = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("ryjjc").equals("1") && (w == 1 || w == 3 || w == 5) && h == 21 && m<=45 && ryjjc == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选荣耀竞技场"));
                gameUtil.lkfb();
                ryjjc();
                ryjjc = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("lldb").equals("1") && w == 4 && h == 21 && m < 30 && lldb == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选楼兰夺宝"));
                gameUtil.lkfb();
                lldb();
                lldb = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("5599").equals("1") && (w == 3 || w == 6) && h == 20 && jzms == 0) {
                //   LtLog.e(mFairy.getLineInfo("用户勾选家族魔神"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                jzms();
                jzms = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("mphw").equals("1") && w == 7 && h == 20 && mphw == 0) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选门派会武"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                mphw();
                mphw = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("swjz").equals("1") && w != 7 && h >= 13 && (h < 19 && m < 10) && jzqd.size() != 0 && jzqd1 == 0) {
                //LtLog.e(mFairy.getLineInfo("用户勾选守卫家族"));
                if (jzqd.contains(h)) {
                    if (m < 20) {
                        if (optime1 != null && optime1.choice == 1) {
                            gameUtil.zhjb();
                        }
                        gameUtil.lkfb();
                        jzqd();
                        jzqd1=1;
                        jzqd.remove(jzqd.indexOf(h));
                        back = 1;
                    }
                }
            }

            if (AtFairyConfig.getOption("sjzy").equals("1") && w != 7 && h >= 13 && sjzy.size() != 0 && sjzy1 == 0) {
                //LtLog.e(mFairy.getLineInfo("用户勾选赏金追妖"));
                if (sjzy.contains(h)) {
                    if (m < 10) {
                        if (optime1 != null && optime1.choice == 1) {
                            gameUtil.zhjb();
                        }
                        gameUtil.lkfb();
                        sjzy();
                        sjzy.remove(sjzy.indexOf(h));
                        back = 1;
                    }
                }
            }

            if (AtFairyConfig.getOption("ygbh").equals("1") && w == 5 && h == 20 && ygbh == 0) {
                //   LtLog.e(mFairy.getLineInfo("用户勾选月光宝盒"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                ygbh();
                ygbh = 1;
                back = 1;
            }


            if (AtFairyConfig.getOption("zbs").equals("1") && w == 6 && h < 20 && zbs == 1) {
                //  LtLog.e(mFairy.getLineInfo("用户勾选争霸赛"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                zbs();
                zbs = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("pwzz").equals("1") && w == 1 && h==20 && pwzz == 0) {
                //    LtLog.e(mFairy.getLineInfo("用户九天"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                pwzz();
                pwzz = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("pwzz").equals("1") && w == 1 && h==20 && pwzz == 0) {
                //    LtLog.e(mFairy.getLineInfo("用户破雾之战"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                pwzz();
                pwzz = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("5615").equals("1") && w == 5 && h == 21 && m >= 35 && m < 45 && tsly == 0) {
                //    LtLog.e(mFairy.getLineInfo("用户勾选天神领域"));
                gameUtil.lkfb();
                tsly();
                tsly = 1;
                back = 1;
            }


            if (AtFairyConfig.getOption("6476").equals("1") && w == 5 && h >= 20 && m >= 33 && yjdx == 0) {
                gameUtil.lkfb();
                yjdx_test();
                yjdx = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("szlc").equals("1") && (h>0 && h<22) && szlc == 0) {
                //    LtLog.e(mFairy.getLineInfo("用户勾选神之猎场"));
                gameUtil.lkfb();
                szlc();
                szlc = 1;
                back = 1;
            }

            if (AtFairyConfig.getOption("ldz").equals("1") && w == 6 && h == 21 && m < 43 && ldz == 0) {
                //    LtLog.e(mFairy.getLineInfo("用户勾选领地战"));
                gameUtil.lkfb();
                gameUtil.cancelFollowing();
                ldz();
                ldz = 1; 
                back = 1;
            }

            if (h == 23 && jbjl == 0) {
                gameUtil.lkfb();
                gameUtil.jpjl();
                singleTask.kgfl();
                jbjl = 1;
                back = 1;
            }
        }

        return back;
    }

    public void inOperation() throws Exception {
        if (!AtFairyConfig.getTaskID().equals("2033") && !AtFairyConfig.getTaskID().equals("2035")) {
            result = mFairy.findPic(1144, 1, 1240, 31, new String[]{"llhj.png", "huanjing.png"});
            if (result.sim > 0.8f) {
                for (int i = 0; i < 10; i++) {
                    result = mFairy.findPic(1144, 1, 1240, 31, new String[]{"llhj.png", "huanjing.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("洗刷刷中暂停别的任务"));
                        i = 0;
                    }
                    mFairy.condit();
                    Thread.sleep(2000);
                }
            }
        }
        result = mFairy.findPic(new String[]{"In picture.png", "In picture1.png"});
        LtLog.e(mFairy.getLineInfo("过图：" + result.sim));
        if (result.sim > 0.92f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(511, 6, 805, 437, "Pathfinding.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("dutiao.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("读条中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("Join the family.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("没有家族结束当前任务"));
            setTaskEnd();
            return;
        }
    }

    public boolean jzlsbool = false;

    public void jzls() throws Exception {
        new TimingActivity(mFairy) {

            public void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("jzlsstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    setTaskEnd();
                    return;
                }


                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if ( m >= 49) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                jzlsbool = false;
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 600, 410, 601, 411, "在家族去中心点打怪", 10000);
                    mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                    mFairy.onTap(0.8f, result, 686,456,700,465, "卓洛", 3000);

                }

                if (AtFairyConfig.getOption("jzls").equals("1")) {
                    result1 = mFairy.findPic(1008, 13, 1266, 601, "leftzhuzc.png");
                }else{
                    result1 = mFairy.findPic(1008, 13, 1266, 601, "leftfuzc.png");
                }

                if(result1.sim>0.8f){
                    mFairy.onTap(0.8f,result1,(AtFairyConfig.getOption("jzls").equals("1")?"主战场":"副战场"),10);
                    for (int i = 0; i < 50; i++) {
                        result1 = mFairy.findPic(494,372,778,561,new String[]{"wkq.png","yjs.png","lsts.png"});
                        if(result1.sim>0.75f){
                            LtLog.i(mFairy.getLineInfo("联赛未开启"));
                            setTaskEnd();
                            return;
                        }
                        LtLog.e("查看是否开启");
                    }
                    LtLog.e("进入联赛");
                    Thread.sleep(5000);
                    setTaskName(2);
                    return;
                }
            }


            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);

                result = mFairy.findPic(1037, 169, 1119, 242, "copy.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("联赛中"));
                    setTaskName(3);
                    return;
                }
            }

            boolean openmap = true;

            public void content_3() throws Exception {
                if (overtime(30, 0)) {
                    if (jzlsbool) {
                        setTaskEnd();
                    }
                    gameUtil.close(1);
                    return;
                }

                Thread.sleep(1000);

                result = mFairy.findPic(1037, 169, 1119, 242, "copy.png");
                mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("地图界面"));
                    if (AtFairyConfig.getOption("jzlscz").equals("1")) {
                        mFairy.onTap(0.8f, result, 408, 238, 417, 245, "去挖矿", 5000);
                    }

                    if (AtFairyConfig.getOption("jzlscz").equals("2")) {
                        result1 = mFairy.findPic(150,68,296,192, "zb.png");
                        mFairy.onTap(0.8f, result1, 668,132,677,144, "去上杀人", 5000);

                        result2 = mFairy.findPic(106,207,249,470, "zb.png");
                        mFairy.onTap(0.8f, result2, 668,344,679,357, "去中杀人", 5000);

                        result3 = mFairy.findPic(142,473,306,647, "zb.png");
                        mFairy.onTap(0.8f, result3, 668,580,677,591, "去下杀人", 5000);


                    }

                    mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                    setTaskName(4);
                    return;
                }

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                }

                result = mFairy.findPic(552,116,701,203,new String[]{"jzlsstop.png","dz.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    setTaskEnd();
                    return;
                }
            }

            public void content_4() throws Exception {

                if (overtime(15, 3)) {
                    jzlsbool = true;
                    gameUtil.close(1);
                    return;
                }

                result = mFairy.findPic(552,116,701,203,new String[]{"jzlsstop.png","dz.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    Thread.sleep(20000);
                    setTaskEnd();
                    return;
                }else {

                    result = mFairy.findPic(492, 12, 1272, 334, new String[]{"fork.png", "fork3.png"});
                    mFairy.onTap(0.9f, result, "关叉", Sleep);

                    result = mFairy.findPic(492, 12, 1272, 334, new String[]{"fork2.png"});
                    mFairy.onTap(0.9f, result, "关叉2", Sleep);

                    result = mFairy.findPic(492, 12, 1272, 334, new String[]{"fork1.png"});
                    mFairy.onTap(0.9f, result, "关叉1", Sleep);
                }
                result = mFairy.findPic(1037, 169, 1119, 242, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    if (AtFairyConfig.getOption("jzlscz").equals("2")) {
                        result = mFairy.findPic("hand.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                            mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                            mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                            mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                            mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                            mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                            mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                            mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                        }
                    }

                    if (AtFairyConfig.getOption("jzlscz").equals("1")) {
                        result = mFairy.findPic(238, 114, 1086, 466, "kuangshi.png");
                        mFairy.onTap(0.8f, result, result.x - 38, result.y + 119, result.x - 37, result.y + 120, "捡取矿石", 4000);
                        if (picCountS(0.8f, result, "家族联赛找不到矿石") > 5) {
                            result = mFairy.findPic("hand.png");
                            if (picCount(0.8f, result, "家族联赛找不到矿石滑动了5次") > 5) {
                                openmap = true;
                                setTaskName(3);
                                LtLog.e(mFairy.getLineInfo("家族联赛找不到矿石滑动了5次"));
                                return;
                            }
                            if (result.sim > 0.8f) {
                                int x = new Random().nextInt(143) + 106;
                                int y = new Random().nextInt(145) + 249;
                                mFairy.ranSwipe(175, 570, x, y, 100, (long) 1000, 2);
                            }
                        }
                    }
                }

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    setTaskName(3);
                    return;
                }
                result = mFairy.findPic("jzlsstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    Thread.sleep(20000);
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "家族联赛中20");

    } //家族联赛

    public void jzls1() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("jzlsstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    setTaskEnd();
                    return;
                }

                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h >= 22) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                jzlsbool = false;
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 600, 410, 601, 411, "在家族去中心点打怪", 10000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                mFairy.onTap(0.8f, result, 686,456,700,465, "卓洛", Sleep);

                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }


            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                if (AtFairyConfig.getOption("jzls").equals("1")) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "leftzhuzc.png");
                    LtLog.e("进入联赛主战场");
                }

                if (AtFairyConfig.getOption("jzls").equals("2")) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "leftfuzc.png");
                    LtLog.e("进入联赛副战场");
                }
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,  "进入", 10);
                    for (int i = 0; i < 50; i++) {
                        result = mFairy.findPic(494,372,778,561,new String[]{"wkq.png","yjs.png","lsts.png"});
                        if(result.sim>0.75f){
                            LtLog.i(mFairy.getLineInfo("联赛未开启"));
                            setTaskEnd();
                            return;
                        }
                        LtLog.e("查看是否开启");
                    }
                    LtLog.e("进入联赛");
                    Thread.sleep(5000);
                }

                result1 = mFairy.findPic(1037, 169, 1119, 242, "copy.png");
                if (result1.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("联赛中"));
                    setTaskName(3);
                    return;
                }
            }

            boolean openmap = true;

            public void content_3() throws Exception {
                if (overtime(30, 0)) {
                    if (jzlsbool) {
                        setTaskEnd();
                    }
                    gameUtil.close(1);
                    return;
                }
                Thread.sleep(1000);
                result = mFairy.findPic(1037, 169, 1119, 242, "copy.png");
                mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("地图界面"));
                    if (AtFairyConfig.getOption("jzlscz").equals("1")) {
                        mFairy.onTap(0.8f, result, 408, 238, 417, 245, "去挖矿", 5000);
                    }
                    if (AtFairyConfig.getOption("jzlscz").equals("2")) {
                        result1 = mFairy.findPic(150,68,296,192, "zb.png");
                        mFairy.onTap(0.8f, result1, 668,132,677,144, "去上杀人", 5000);

                        result2 = mFairy.findPic(106,207,249,470, "zb.png");
                        mFairy.onTap(0.8f, result2, 668,344,679,357, "去中杀人", 5000);

                        result3 = mFairy.findPic(142,473,306,647, "zb.png");
                        mFairy.onTap(0.8f, result3, 668,580,677,591, "去下杀人", 5000);
                    }

                    mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                    setTaskName(4);
                    return;
                }

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                }

                result = mFairy.findPic(552,116,701,203,new String[]{"jzlsstop.png","dz.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    setTaskEnd();
                    return;
                }
            }

            public void content_4() throws Exception {
                if (overtime(30, 3)) {
                    jzlsbool = true;
                    gameUtil.close(1);
                    return;
                }



                result = mFairy.findPic(552,116,701,203,new String[]{"jzlsstop.png","dz.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    Thread.sleep(20000);
                    setTaskEnd();
                    return;
                }else {

                    result = mFairy.findPic(492, 12, 1272, 334, new String[]{"fork.png", "fork3.png"});
                    mFairy.onTap(0.9f, result, "关叉", Sleep);

                    result = mFairy.findPic(492, 12, 1272, 334, new String[]{"fork2.png"});
                    mFairy.onTap(0.9f, result, "关叉2", Sleep);

                    result = mFairy.findPic(492, 12, 1272, 334, new String[]{"fork1.png"});
                    mFairy.onTap(0.9f, result, "关叉1", Sleep);

                    result = mFairy.findPic(640,5,988,79, new String[]{"kzl.png"});
                    mFairy.onTap(0.9f, result, "收回", Sleep);
                }

                result = mFairy.findPic(1037, 169, 1119, 242, new String[]{"copy.png","copy1.png"});
                if (result.sim > 0.8f) {
                    err = 0;
                    if (AtFairyConfig.getOption("jzlscz").equals("2")) {
                        result = mFairy.findPic("hand.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                            mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                            mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                            mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                            mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                            mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                            mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                            mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                        }
                    }

                    if (AtFairyConfig.getOption("jzlscz").equals("1")) {
                        result = mFairy.findPic(640,5,988,79, new String[]{"crysta.png"});
                        mFairy.onTap(0.9f, result, "水晶", 4000);

                        result = mFairy.findPic(249,112,1111,560, new String[]{"kuangshi.png","crysta1.png"});
                        mFairy.onTap(0.8f, result, result.x - 42, result.y + 119, result.x - 31, result.y + 127, "捡取矿石", 4000);
                        if (picCountS(0.8f, result, "家族联赛找不到矿石") > 5) {
                            result = mFairy.findPic("hand.png");
                            if (picCount(0.8f, result, "家族联赛找不到矿石滑动了5次") > 5) {
                                openmap = true;
                                setTaskName(3);
                                LtLog.e(mFairy.getLineInfo("家族联赛找不到矿石滑动了5次"));
                                return;
                            }
                            if (result.sim > 0.8f) {
                                int x = new Random().nextInt(143) + 106;
                                int y = new Random().nextInt(145) + 249;
                                mFairy.ranSwipe(175, 570, x, y, 100, (long) 1000, 2);
                            }
                        }
                    }
                }

                result = mFairy.findPic(475,249,806,387,"Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic("jzlsstop.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族联赛结束"));
                    Thread.sleep(20000);
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "家族联赛中");

    }//家族联赛

    public void kjxs() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("kjxs.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic("kjinface.png");
                mFairy.onTap(0.8f, result, 598, 393, 639, 411, "科举界面选A", Sleep);
                if (result.sim > 0.8f) {
                    err = 0;
                }

                result = mFairy.findPic("kjxsstop.png");
                mFairy.onTap(0.8f, result, 615, 590, 674, 611, "科举乡试结束", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "科举乡试中");
    } //科举乡试

    public void ddmt() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m >= 30) {
                    LtLog.e(mFairy.getLineInfo("颠倒魔塔结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("ddmttask.png", 2);
                if (ret == 1) {
                    gameUtil.retire();
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(8, 0)) return;
                if (gameUtil.duiyuan() == 1) {
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(7, 0)) {
                    return;
                }

                result = mFairy.findPic("dyqxpp.png");
                mFairy.onTap(0.8f, result, "先取消匹配从新定义活动", Sleep);


                result = mFairy.findPic(79, 107, 270, 599, "dshd.png");
                mFairy.onTap(0.95f, result, "找到定时活动", Sleep);


                result = mFairy.findPic(79, 107, 270, 599, "mbddmt.png");
                mFairy.onTap(0.8f, result, "找到颠倒魔塔", Sleep);
                mFairy.onTap(0.8f, result, 1047, 631, 1085, 643, "开启自动匹配", Sleep);
                if (result.sim < 0.8f) {
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 171, 541, 173, 160, 200, 1500, 2);
                } else {
                    setTaskName(4);
                    return;
                }
            }

            public void content_4() throws Exception {
                if (overtime(15, 0)) return;
                if (timekeep(0, 600000, "超过10分钟没组到人")) {
                    LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("dyqxpp.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "匹配中"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("shenqing.png");
                    mFairy.onTap(0.8f, result, 957, 103, 1151, 588, "申请进队", Sleep);
                    err = 0;
                }

                result = mFairy.findPic(855, 248, 1116, 410, "youceyaoqing.png");
                mFairy.onTap(0.8f, result, 1030, 370, 1058, 384, "右侧同意邀请", Sleep);

                result = mFairy.findPic("yryaoqing.png");
                mFairy.onTap(0.8f, result, "有人邀请点开", Sleep);

                result = mFairy.findPic(879, 101, 1092, 581, "jiaru.png");
                mFairy.onTap(0.8f, result, "邀请加入", 100);
                mFairy.onTap(0.8f, result, 438, 613, 477, 625, "邀请列表关闭", Sleep);

                result = mFairy.findPic("beitile.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("应该被踢了从来"));
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("qxgs.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进入队伍成功跟随队伍"));
                    gameUtil.close(0);
                    setTaskName(5);
                    return;
                }
                result = mFairy.findPic("gensuiduiwu.png");
                mFairy.onTap(0.8f, result, "进入队伍成功跟随队伍", Sleep);
                if (result.sim > 0.8f) {
                    gameUtil.close(0);
                    setTaskName(5);
                    return;
                }
            }

            int mapCount = 0;

            public void content_5() throws Exception {
                result = mFairy.findPic("duiwulan.png");
                mFairy.onTap(0.8f, result, "切换到队伍栏", Sleep);

                result = mFairy.findPic(0, 0, 30, 27, "hg.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("成了队长了从来"));
                    gameUtil.retire();
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic("chuanjianduiwu.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("应该被踢了从来"));
                    setTaskName(0);
                    return;
                }

                if (timekeep(0, 300000, "超过5分钟没有在副本")) {
                    LtLog.e(mFairy.getLineInfo("--------超过5分钟没有在副本"));
                    gameUtil.retire();
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("beitile.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("应该被踢了从来"));
                    gameUtil.lkfb();
                    setTaskName(0);
                    return;
                }
                gameUtil.fuhuo();
                result = mFairy.findPic(1037, 146, 1105, 212, new String[]{"copy.png", "ddmtnei.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    timekeepInit("超过5分钟没有在副本");

                    gameUtil.zidong();
                }
                result = mFairy.findPic("ddmtdingceng.png");
                mFairy.onTap(0.8f, result, "颠倒魔塔顶层了打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("地图界面"));
                    if (mapCount == 0) {
                        mFairy.onTap(0.8f, result, 633, 592, 646, 605, "顶层第一个位置", Sleep);
                    }
                    if (mapCount == 1) {
                        mFairy.onTap(0.8f, result, 313, 484, 329, 497, "顶层第2个位置", Sleep);
                    }
                    if (mapCount == 2) {
                        mFairy.onTap(0.8f, result, 381, 214, 398, 227, "顶层第3个位置", Sleep);
                    }
                    if (mapCount == 3) {
                        mFairy.onTap(0.8f, result, 632, 149, 650, 162, "顶层第4个位置", Sleep);
                    }
                    if (mapCount == 4) {
                        mFairy.onTap(0.8f, result, 890, 213, 909, 225, "顶层第5个位置", Sleep);
                    }
                    if (mapCount == 5) {
                        mFairy.onTap(0.8f, result, 969, 492, 990, 501, "顶层第6个位置", Sleep);
                    }
                    if (mapCount == 6) {
                        LtLog.e(mFairy.getLineInfo("没有领到宝箱颠倒魔塔结束"));
                        gameUtil.lkfb();
                        gameUtil.retire();
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", 5000);

                    result = mFairy.findPic(293, 16, 1170, 581, "ddmtbx.png");
                    mFairy.onTap(0.7f, result, result.x - 37, result.y + 42, result.x - 36, result.y + 43, "宝箱", Sleep);
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("领完宝箱颠倒魔塔结束"));
                        gameUtil.lkfb();
                        gameUtil.retire();
                        setTaskEnd();
                        return;
                    } else {
                        mapCount++;
                    }
                }
            }
        }.taskContent(mFairy, "颠倒魔塔中");
    }//颠倒魔塔

    public void fqhs_test() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void inOperation() throws Exception {
                super.inOperation();
                gameUtil.fuhuo();
                gameUtil.fqtask();
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("fqhs.png", 2);
                if (ret == 1) {
                    setTaskName(3);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int renwu = 0;

            public void content_2() throws Exception {
                result = mFairy.findPic(40, 124, 282, 411, "leftfqhs.png");
                mFairy.onTap(0.7f, result, "左侧法器护送", Sleep);
                if (result.sim > 0.7f) {
                    result = mFairy.findPic(40, 124, 282, 411, new String[]{"leftdiling.png", "lefttaoyuan.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("地灵童子的任务"));
                        renwu = 2;
                        setTaskName(3);
                        return;
                    }

                    result = mFairy.findPic(40, 124, 282, 411, new String[]{"lefttianling.png", "lefthuashan.png"});
                    LtLog.e(mFairy.getLineInfo("天灵童子的任务"));
                    if (result.sim > 0.8f) {
                        renwu = 1;
                        setTaskName(3);
                        return;
                    }
                }
                result = mFairy.findPic("task1.png");
                mFairy.onTap(0.9f, result, "任务栏暗点切换到任务栏", Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4}, 2, 85, 340, 85, 178, 1000, 1500, 2);

                if (overtime(8, 0)) return;
            }

            boolean index = true;

            public void content_3() throws Exception {
                if (overtime(10, 2)) return;
                result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightfqhs.png"});
                mFairy.onTap(0.8f, result, "右侧法器护送", Sleep);

                result = mFairy.findPic(40, 124, 282, 411, "leftfqhs.png");
                mFairy.onTap(0.7f, result, "左侧法器护送", Sleep);
                if (result.sim > 0.7f) {
                    result = mFairy.findPic(40, 124, 282, 411, "lefttianling.png");
                    if (result.sim > 0.7f) {
                        renwu = 1;
                        setTaskName(4);
                        return;
                    }
                    result = mFairy.findPic(40, 124, 282, 411, "leftdiling.png");
                    if (result.sim > 0.7f) {
                        renwu = 2;
                        setTaskName(4);
                        return;
                    }
                }
                Thread.sleep(1000);
            }

            int wcCount = 0;

            public void content_4() throws Exception {
                if (overtime(30, 0)) {
                    wcCount++;
                    return;
                }

              /* if (timekeep(0, 600000, "法器护送超时")) {
                    gameUtil.close(1);
                    result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                    mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                    result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                    mFairy.onTap(0.8f, result, 299, 589, 313, 597, "山妖", 7000);
                    index = true;
                }*/


                result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightfqhs.png"});
                mFairy.onTap(0.8f, result, "右侧法器护送", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("法器护送完成"));
                    wcCount++;
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                if (picCount(0.8f, result, "法器护送活动标记") > 2) {
                    mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);
                }

                //在地图界面
                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    if (wcCount > 0) {
                        wcCount = 0;
                        index = true;
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(159, 56, 1130, 675, new String[]{"Lbc.png", "Rbc.png"});
                            mFairy.onTap(0.8f, result, result.x, result.y, result.x + 50, result.y + 21, "去镖车", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "dbc.png");
                            mFairy.onTap(0.8f, result, result.x + 5, result.y, result.x + 6, result.y + 1, "去镖车", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "house.png");
                            mFairy.onTap(0.8f, result, result.x - 30, result.y + 10, result.x - 29, result.y + 11, "去镖车", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                        gameUtil.close(1);
                        result1 = mFairy.findPic("look.png");
                        mFairy.onTap(0.8f, result1, "查看货物", Sleep);

                        result = mFairy.findPic("shanyao.png");
                        mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);
                        gameUtil.zidong();
                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1000);
                            mFairy.condit();
                            result = mFairy.findPic("fqhsyaoguai.png");
                            if (result.sim > 0.9f) {
                                LtLog.e(mFairy.getLineInfo("打妖怪中"));
                                i = 0;
                            }
                        }
                        result = mFairy.findPic("closehand.png");
                        mFairy.onTap(0.8f, result, "关闭自动", Sleep);
                    }

                    if (renwu == 1) {
                        result = mFairy.findPic(319, 128, 395, 179, "fqhsddmdd.png");
                        mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                        mFairy.onTap(0.8f, result, 652, 349, 664, 359, "点击天灵npc", Sleep);
                        if (result.sim > 0.8f) {
                            return;
                        }
                    }

                    if (renwu == 2) {
                        result = mFairy.findPic(645, 197, 717, 254, "fqhsddmdd.png");
                        mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                        mFairy.onTap(0.8f, result, 652, 349, 664, 359, "点击地宝npc", Sleep);
                        if (result.sim > 0.8f) {
                            return;
                        }
                    }

                    result = mFairy.findPic("shanyao.png");
                    mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);

                    result1 = mFairy.findPic("look.png");
                    mFairy.onTap(0.8f, result1, "查看货物", Sleep);
                    if (result.sim > 0.8f || result1.sim > 0.8f) {
                        index = true;
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(159, 56, 1130, 675, new String[]{"Lbc.png", "Rbc.png"});
                            mFairy.onTap(0.8f, result, result.x + 8, result.y + 20, result.x + 9, result.y + 21, "去镖车", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "dbc.png");
                            mFairy.onTap(0.8f, result, result.x + 5, result.y, result.x + 6, result.y + 1, "去镖车", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "house.png");
                            mFairy.onTap(0.8f, result, result.x - 30, result.y + 10, result.x - 29, result.y + 11, "去镖车", Sleep);
                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                    /*    result = mFairy.findPic(159, 56, 1130, 675, new String[]{"Lbc.png", "Rbc.png", "dbc.png", "house.png"});
                        mFairy.onTap(0.8f, result, "去镖车", Sleep);
                        mFairy.onTap(0.8f, result, "去镖车", Sleep);
                        mFairy.onTap(0.8f, result, "去镖车", Sleep);
                        mFairy.onTap(0.8f, result, "去镖车", 5000);*/
                        gameUtil.close(1);
                        result1 = mFairy.findPic("look.png");
                        mFairy.onTap(0.8f, result1, "查看货物", Sleep);
                        result = mFairy.findPic("shanyao.png");
                        mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);
                        gameUtil.zidong();
                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1000);
                            mFairy.condit();
                            result = mFairy.findPic("fqhsyaoguai.png");
                            if (result.sim > 0.9f) {
                                LtLog.e(mFairy.getLineInfo("打妖怪中"));
                                i = 0;
                            }
                        }
                        result = mFairy.findPic("closehand.png");
                        mFairy.onTap(0.8f, result, "关闭自动", Sleep);
                    }
                    err = 0;

                    //第一次传送
                    result = mFairy.findPic("fqhsinjiazu.png");
                    mFairy.onTap(0.8f, result, 342, 626, 343, 627, "在家族去龙城", Sleep);

                    //第二次传送
                    result = mFairy.findPic("fqhsinlongcheng.png");
                    if (result.sim > 0.8f) {
                        if (renwu == 1) {
                            mFairy.onTap(0.8f, result, 1090, 614, 1091, 615, "在龙城去华山", Sleep);
                        }
                        if (renwu == 2) {
                            mFairy.onTap(0.8f, result, 1100, 134, 1101, 135, "在龙城去桃源", Sleep);
                        }
                    }

                    if (index) {
                        //第三次传送
                        result = mFairy.findPic("fqhsinhuashan.png");
                        mFairy.onTap(0.8f, result, 45, 230, 59, 240, "在华山打开查询", Sleep);
                        mFairy.onTap(0.8f, result, 123, 342, 153, 353, "在华山点天灵童子", Sleep);
                        if (result.sim > 0.8f) {
                            index = false;
                        }
                        result = mFairy.findPic("fqhsintaoyuan.png");
                        mFairy.onTap(0.8f, result, 45, 230, 59, 240, "在桃源村打开查询", Sleep);
                        mFairy.onTap(0.8f, result, 138, 457, 159, 466, "在桃源村点地灵童子", Sleep);
                        if (result.sim > 0.8f) {
                            index = false;
                        }
                    }
                }

            }
        }.taskContent(mFairy, "法器护送中");
    }//法器护送-(旧版)

    private int fqhs_err = 0;
    public int fq = 0;

    public void fqhs() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void inOperation() throws Exception {
                super.inOperation();
                gameUtil.fuhuo();
                gameUtil.fqtask();
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("fqhs.png", 2);
                if (ret == 1) {
                    setTaskName(3);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int renwu = 0;

            public void content_2() throws Exception {
                result = mFairy.findPic(40, 124, 282, 411, "leftfqhs.png");
                mFairy.onTap(0.7f, result, "左侧法器护送", Sleep);
                if (result.sim > 0.7f) {
                    if (renwu == 0) {
                        LtLog.e(mFairy.getLineInfo("未知前往目的地，转5查找"));
                        setTaskName(5);
                        return;
                    } else {
                        setTaskName(4);
                        return;
                    }
                }
                result = mFairy.findPic("task1.png");
                mFairy.onTap(0.9f, result, "任务栏暗点切换到任务栏", Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4}, 4, 85, 340, 85, 178, 1000, 1500, 2);

                if (overtime(8, 99)) return;
            }

            boolean index = true;

            public void content_3() throws Exception {
                if (overtime(10, 2)) return;
                result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightfqhs.png"});
                mFairy.onTap(0.8f, result, "右侧法器护送", Sleep);

                result = mFairy.findPic(40, 124, 282, 411, "leftfqhs.png");
                mFairy.onTap(0.7f, result, "左侧法器护送", 1000);
                if (result.sim > 0.7f) {
                    if (renwu == 0) {
                        LtLog.e(mFairy.getLineInfo("未知前往目的地，转2查找"));
                        setTaskName(2);
                        return;
                    } else {
                        setTaskName(4);
                        return;
                    }
                }
                Thread.sleep(1000);
            }

            int wcCount = 0;

            public void content_4() throws Exception {
                if (overtime(30, 0)) {
                    wcCount++;
                    return;
                }

                result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightfqhs.png"});
                mFairy.onTap(0.8f, result, "右侧法器护送", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("法器护送完成"));
                    wcCount++;
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                if (picCount(0.8f, result, "法器护送活动标记") > 2) {
                    mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);
                }

                //在地图界面
                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {

                    if (wcCount > 0) {
                        wcCount = 0;
                        index = true;
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(159, 56, 1130, 675, new String[]{"Lbc.png", "Rbc.png"});
                            mFairy.onTap(0.8f, result, result.x, result.y, result.x + 50, result.y + 21, "去镖车", 3000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "dbc.png");
                            mFairy.onTap(0.8f, result, result.x + 5, result.y, result.x + 6, result.y + 1, "去镖车", 3000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "house.png");
                            mFairy.onTap(0.8f, result, result.x - 30, result.y + 10, result.x - 29, result.y + 11, "去镖车", 3000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                        }

                        gameUtil.close(1);


                        while (mFairy.condit()) {
                            Thread.sleep(2000);

                            LtLog.e(mFairy.getLineInfo("等待到达镖车中 "));

                            long dazeTime = mFairy.mMatTime(1181, 38, 37, 15, 0.9f);
                            if (dazeTime > 6) {
                                break;
                            }

                            result1 = mFairy.findPic("look.png");
                            if (result1.sim > 0.8f) {
                                mFairy.onTap(0.8f, result1, "查看货物", Sleep);
                                break;
                            }

                            result = mFairy.findPic("shanyao.png");
                            if (result.sim > 0.8f) {
                                mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);
                                break;
                            }
                        }

                        result1 = mFairy.findPic("look.png");
                        mFairy.onTap(0.8f, result1, "查看货物", Sleep);

                        result = mFairy.findPic("shanyao.png");
                        mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);

                        gameUtil.zidong();

                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1000);
                            mFairy.condit();
                            result = mFairy.findPic("fqhsyaoguai.png");
                            if (result.sim > 0.9f) {
                                LtLog.e(mFairy.getLineInfo("打妖怪中"));
                                i = 0;
                            }
                        }

                        result = mFairy.findPic("closehand.png");
                        mFairy.onTap(0.8f, result, "关闭自动", Sleep);
                    }

                    if (renwu == 1) {
                        result = mFairy.findPic(319, 128, 395, 179, "fqhsddmdd.png");
                        mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                        mFairy.onTap(0.8f, result, 657,374,663,383, "点击天灵npc", Sleep);
                        if (result.sim > 0.8f) {
                            return;
                        }
                    }

                    if (renwu == 2) {
                        result = mFairy.findPic(645, 197, 717, 254, "fqhsddmdd.png");
                        mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                        mFairy.onTap(0.8f, result, 652, 349, 664, 359, "点击地宝npc", Sleep);
                        if (result.sim > 0.8f) {
                            fq++;
                            if (fq > 5) {
                                mFairy.onTap(620, 229, 639, 258, "点击", 1000);
                                fq = 0;
                            }
                            return;
                        }
                    }

                    result = mFairy.findPic("shanyao.png");
                    mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);

                    result1 = mFairy.findPic("look.png");
                    mFairy.onTap(0.8f, result1, "查看货物", Sleep);

                    if (result.sim > 0.8f || result1.sim > 0.8f) {
                        index = true;
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(159, 56, 1130, 675, new String[]{"Lbc.png", "Rbc.png"});
                            mFairy.onTap(0.8f, result, result.x + 8, result.y + 20, result.x + 9, result.y + 21, "去镖车", 5000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "dbc.png");
                            mFairy.onTap(0.8f, result, result.x + 5, result.y, result.x + 6, result.y + 1, "去镖车", 5000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                            result = mFairy.findPic(159, 56, 1130, 675, "house.png");
                            mFairy.onTap(0.8f, result, result.x - 30, result.y + 10, result.x - 29, result.y + 11, "去镖车", 5000);
                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                    /*    result = mFairy.findPic(159, 56, 1130, 675, new String[]{"Lbc.png", "Rbc.png", "dbc.png", "house.png"});
                        mFairy.onTap(0.8f, result, "去镖车", Sleep);
                        mFairy.onTap(0.8f, result, "去镖车", Sleep);
                        mFairy.onTap(0.8f, result, "去镖车", Sleep);
                        mFairy.onTap(0.8f, result, "去镖车", 5000);*/
                        gameUtil.close(1);
                        result1 = mFairy.findPic("look.png");
                        mFairy.onTap(0.8f, result1, "查看货物", Sleep);
                        result = mFairy.findPic("shanyao.png");
                        mFairy.onTap(0.8f, result, 972, 373, 999, 384, "山妖", Sleep);

                        long timex = System.currentTimeMillis();

                        for (int i = 0; i < 10; i++) {
                            Thread.sleep(1000);
                            mFairy.condit();

                            if (System.currentTimeMillis() - timex > 30000) {
                                timex = System.currentTimeMillis();
                                mFairy.touchDown(173, 572);
                                mFairy.touchMove(284, 572, 500, 1000);
                                mFairy.touchUp();
                            }

                            gameUtil.zidong();

                            result = mFairy.findPic("fqhsyaoguai.png");
                            if (result.sim > 0.9f) {
                                LtLog.e(mFairy.getLineInfo("打妖怪中"));
                                i = 0;
                            }
                        }
                        result = mFairy.findPic("closehand.png");
                        mFairy.onTap(0.8f, result, "关闭自动", Sleep);
                    }

                    err = 0;

                    fqhs_err++;
                    if (fqhs_err > 20) {
                        fqhs_err = 0;
                        index = true;
                    }

                    //第一次传送
                    result = mFairy.findPic(new String[]{"fqhsinjiazu.png", "jiazu1.png"});
                    mFairy.onTap(0.8f, result, 342, 626, 343, 632, "在家族去龙城", Sleep);

                    //第二次传送
                    result = mFairy.findPic("fqhsinlongcheng.png");
                    if (result.sim > 0.8f) {
                        if (renwu == 1) {
                            mFairy.onTap(0.8f, result, 1090, 614, 1091, 615, "在龙城去华山", Sleep);
                        }
                        if (renwu == 2) {
                            mFairy.onTap(0.8f, result, 1100, 134, 1101, 135, "在龙城去桃源", Sleep);
                        }
                    }


                    if (index) {
                        //第三次传送
                        result = mFairy.findPic("fqhsinhuashan.png");
                        if (result.sim > 0.8f) {
                            index = false;
                            mFairy.onTap(0.8f, result, 45, 230, 59, 240, "在华山打开查询", Sleep);
                            mFairy.onTap(0.8f, result, 123, 342, 153, 353, "在华山点天灵童子", Sleep);
                        }

                        result = mFairy.findPic("fqhsintaoyuan.png");
                        if (result.sim > 0.8f) {

                            mFairy.onTap(0.8f, result, 45, 230, 59, 240, "在桃源村打开查询", Sleep);
                            mFairy.onTap(0.8f, result, 138, 457, 159, 466, "在桃源村点地灵童子", Sleep);

                            index = false;
                        }
                    }
                }
            }

            @Override
            public void content_5() throws Exception {
                result = mFairy.findPic(new String[]{"task1.png", "task.png"});
                mFairy.onTap(0.8f, result, "进入任务栏", 1000);

                result = mFairy.findPic("task interface.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(94, 196, 253, 664, "task fqhs.png");
                    mFairy.onTap(0.8f, result, "切换法器护送", 1000);

                    result = mFairy.findPic("task huashan.png");
                    mFairy.onTap(0.8f, result, 1170, 85, 1183, 100, "目标-华山-天灵童子，关闭", 1000);
                    if (result.sim > 0.8f) {
                        renwu = 1;
                        setTaskName(3);
                        return;
                    }

                    result = mFairy.findPic("task taoyuancun.png");
                    mFairy.onTap(0.8f, result, 1170, 85, 1183, 100, "目标-桃源村-地宝童子，关闭", 1000);
                    if (result.sim > 0.8f) {
                        renwu = 2;
                        setTaskName(3);
                        return;
                    }
                }
                overtime(8, 0);
            }
        }.taskContent(mFairy, "法器护送中");
    }//法器护送

    public void lldb() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h >= 21 && m > 30) {
                    LtLog.e(mFairy.getLineInfo("楼兰夺宝结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("lldb.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    ret = gameUtil.mission("lldb1.png", 2);
                    if (ret == 1) {
                        setTaskName(2);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
            }

            boolean yidong = true;

            public void content_2() throws Exception {
                if (overtime(15, 0)) {
                    gameUtil.close(0);
                    return;
                }
                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                }
                result = mFairy.findPic(924, 79, 1216, 379, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("楼兰夺宝副本内"));

                    result = mFairy.findPic("hand.png");
                    mFairy.onTap(0.8f, result, "开启自动", Sleep);

                    /*result = mFairy.findPic(269, 78, 1001, 579, "lldbwaguan.png");
                    mFairy.onTap(0.7f, result, result.x - 23, result.y + 66, result.x - 22, result.y + 67, "瓦罐", 5000);*/

                    /*result = mFairy.findPic("hand.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 500);
                        mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 500);
                        mFairy.onTap(0.8f, result, 1021, 527, 1042, 543, "技能3", 500);
                        mFairy.onTap(0.8f, result, 1016, 636, 1032, 651, "技能4", 500);
                        mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                        mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    }*/

                    result = mFairy.findPic("lldbstop.png");
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("楼兰夺宝结束"));
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "楼兰夺宝中");
    }//楼兰夺宝

    public void ygbh() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h >= 21) {
                    LtLog.e(mFairy.getLineInfo("月光宝盒结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 564, 457, 581, 466, "在家族去中心点打怪", 5000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    gameUtil.zidong();
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (timekeep(0, 600000, "月光宝盒超过10分钟没有在副本")) {
                    LtLog.e(mFairy.getLineInfo("--------超过10分钟没有在副本"));
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("ygbh.png");
                mFairy.onTap(0.8f, result, "月光宝盒", Sleep);

                result = mFairy.findPic("ygbhinface.png");
                mFairy.onTap(0.8f, result, 606, 280, 643, 295, "月光宝盒界面去积累山", Sleep);

                result = mFairy.findPic(924, 79, 1216, 379, "copy.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("月光宝盒副本内"));
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(15, 0)) return;
                LtLog.e(mFairy.getLineInfo("在第一层等待进入第二层"));
                result = mFairy.findPic(924, 79, 1216, 379, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    result = mFairy.findPic("ygbh1ceng.png");
                    mFairy.onTap(0.7f, result, 1189, 91, 1209, 105, "打开地图", 3000);

                    result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                    mFairy.onTap(0.8f, result, 244, 112, 254, 120, "月光宝盒去第二层", 4000);
                    if (result.sim > 0.8f) {
                        gameUtil.close(1);
                        Thread.sleep(90000);
                        setTaskName(4);
                    }
                }
            }

            public void content_4() throws Exception {
                if (overtime(15, 0)) return;
                LtLog.e(mFairy.getLineInfo("在第二层等待进入第三层"));
                result = mFairy.findPic(924, 79, 1216, 379, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    result = mFairy.findPic("ygbh1ceng.png");
                    mFairy.onTap(0.7f, result, 1189, 91, 1209, 105, "打开地图", 3000);

                    result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                    mFairy.onTap(0.8f, result, 647, 116, 654, 124, "月光宝盒去第三层", 4000);
                    if (result.sim > 0.8f) {
                        gameUtil.close(1);
                        Thread.sleep(90000);
                        setTaskName(5);
                    }
                }
            }

            public void content_5() throws Exception {
                if (overtime(15, 99)) {
                    LtLog.e(mFairy.getLineInfo("月光宝盒结束"));
                    return;
                }
                LtLog.e(mFairy.getLineInfo("在第三层"));
                result = mFairy.findPic(924, 79, 1216, 379, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                }
            }
        }.taskContent(mFairy, "月光宝盒中");
    }//月光宝盒

    public void zhanchang() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m > 40) {
                    LtLog.e(mFairy.getLineInfo("冲锋战场结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                timekeepInit("超过10分钟没有进入战场");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("zhanchang.png", 2);//cfzc1
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int bmcount = 0;

            public void content_2() throws Exception {
                if (overtime(8, 0)) return;
                Thread.sleep(2000);
                if (timekeep(0, 720000, "超过10分钟没有进入战场")) {
                    LtLog.e(mFairy.getLineInfo("--------超过10分钟没有进入战场"));
                    setTaskName(0);
                    return;
                }
                timekeepInit("超过10分钟没有进入战场");
                result = mFairy.findPic(807, 218, 950, 438, "zcquxiao.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "战场已报名等待开站"));
                if (result.sim < 0.8f) {
                    result = mFairy.findPic(803, 233, 956, 294, "zcbaoming.png");
                    mFairy.onTap(0.8f, result, "战场报名", Sleep);

                    result = mFairy.findPic(814, 289, 963, 353, "zcbaoming.png");
                    mFairy.onTap(0.8f, result, "战场报名", Sleep);


                    result = mFairy.findPic(813, 353, 968, 416, "zcbaoming.png");
                    mFairy.onTap(0.8f, result, "战场报名", Sleep);
                } else {
                    mFairy.onTap(0.8f, result, 1232, 203, 1246, 220, "报名成功", Sleep);
                    err = 0;
                    bmcount = 1;
                }
                if (bmcount == 1) {
                    err = 0;
                    gameUtil.zidong();
                }

                result = mFairy.findPic("zhanchangqueren.png");
                mFairy.onTap(0.8f, result, 751, 444, 783, 457, "战场确认参加", Sleep);


                result = mFairy.findPic(924, 43, 1143, 254, "copy.png");
                if (result.sim > 0.8f) {
                    timekeepInit("超过10分钟没有进入战场");
                    LtLog.e(mFairy.getLineInfo("战场副本内"));
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(8, 0)) return;

                result = mFairy.findPic(924, 43, 1143, 254, "copy.png");
                mFairy.onTap(0.8f, result, 1188, 94, 1208, 112, "战场打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    timekeepInit("超过10分钟没有进入战场");

                    result = mFairy.findPic(94, 53, 1192, 676, new String[]{"chongfengwupin.png", "chongfengwupin1.png"});
                    mFairy.onTap(0.9f, result, "战场冲锋球", Sleep);
                    if (result.sim < 0.9f) {
                        mFairy.onTap(578, 359, 579, 360, "可能在修罗战场去地图中心", Sleep);
                    }
                    mFairy.onTap(1228, 40, 1248, 55, "关闭地图", Sleep);
                    setTaskName(4);
                    return;
                }

                result = mFairy.findPic("fuhuotime.png");
                if (result.sim > 0.75f) {
                    LtLog.e(mFairy.getLineInfo("战场复活"));
                    Thread.sleep(8000);
                }

                result = mFairy.findPic("sile.png");
                if (result.sim > 0.82f) {
                    LtLog.e(mFairy.getLineInfo("战场复活"));
                    Thread.sleep(12000);
                }

                result = mFairy.findPic("zc1.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("zhanchangls").equals("1")) {
                        mFairy.onTap(799, 610, 830, 628, "双倍领取", Sleep);
                    } else {
                        mFairy.onTap(1219, 459, 1232, 470, "普通领取", Sleep);
                    }
                    setTaskEnd();
                    return;
                }
            }

            public void content_4() throws Exception {
                long dazeTime = mFairy.mMatTime(1181, 38, 37, 15, 0.9f);
                if (dazeTime > 2) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达目的地释放技能"));
                    setTaskName(5);
                    return;
                }
            }

            public void content_5() throws Exception {
                if (overtime(10, 3)) return;
                result = mFairy.findPic(924, 43, 1143, 254, "copy.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                    mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                    mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                    mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                    mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }

                result = mFairy.findPic("fuhuotime.png");
                if (result.sim > 0.75f) {
                    LtLog.e(mFairy.getLineInfo("战场复活"));
                    Thread.sleep(8000);
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic("sile.png");
                if (result.sim > 0.82f) {
                    LtLog.e(mFairy.getLineInfo("战场复活"));
                    Thread.sleep(12000);
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic("zhanchangsb.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("zhanchangls").equals("1")) {
                        mFairy.onTap(799, 610, 830, 628, "双倍领取", Sleep);
                    } else {
                        mFairy.onTap(1219, 459, 1232, 470, "普通领取", Sleep);
                    }
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "战场中");
    }//冲锋战场

    public void jzkd() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("jzkd.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            boolean openmap = true;

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);

                result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightjzkd.png", "jzkd1.png"});
                mFairy.onTap(0.8f, result, "右侧矿洞", Sleep);


                result = mFairy.findPic(1030, 77, 1127, 168, "copy.png");
                mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "矿洞中打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 642, 318, 643, 319, "去矿洞中间", Sleep);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", 5000);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("矿洞中"));
                    setTaskName(3);
                    return;
                }
            }

            int hjkcount = 0;

            public void content_3() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightjzkd.png", "jzkd1.png"});
                mFairy.onTap(0.8f, result, "右侧矿洞", Sleep);

                result = mFairy.findPic(1030, 77, 1127, 168, "copy.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("开始挖矿中"));
                    result = mFairy.findPic(272,84,1016,667, new String[]{"jk.png"});
                    mFairy.onTap(0.8f, result,result.x-38,result.y+133,result.x-16,result.y+145,"水晶矿", 5000);
                    if (result.sim > 0.8f) {
                        hjkcount++;
                        if (hjkcount > 20) {

                            gameUtil.close(3);

                            for (int i = 0; i < 3; i++) {
                                result = mFairy.findPic(862, 308, 1104, 641, "use1.png");
                                if (result.sim > 0.8f) {
                                    i = 0;
                                    mFairy.onTap(0.8f, result, "使用", 1000);
                                }
                            }

                            hjkcount = 0;
                            setTaskName(2);
                            return;
                        }
                        err = 0;
                    }
                }
                result = mFairy.findPic(794,56,1128,177,new String[]{"jzkdstop.png","jzkdstop1.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("家族矿洞结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "家族矿洞中");

    }//家族矿洞

    public void jzqd() throws Exception {
        new TimingActivity(mFairy) {

            public void inOperation() throws Exception {
                super.inOperation();
                if (mFairy.dateMinute() >= 30) {
                    LtLog.e(mFairy.getLineInfo("没有家族强盗了结束"));
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;

                int ret = gameUtil.mission("jzsw.png", 2);
                if (ret == 1) {
                    if (gameUtil.duizhang() == 1) {
                        setTaskName(3);
                        return;
                    }
                } else {
                    setTaskEnd();
                    return;
                }


            }

            boolean openlan = true;

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    return;
                }
                result = mFairy.findPic("yijianhanhua.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("mbswjz.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("目标正确"));
                        result = mFairy.findPic("dzqxpp.png");
                        mFairy.onTap(0.8f, result, "先取消一下自动匹配", Sleep);
                        result = mFairy.findPic("dzzdpp.png");
                        mFairy.onTap(0.8f, result, "开启自动匹配", Sleep);
                        setTaskName(3);
                        return;
                    } else {
                        result = mFairy.findPic(79, 107, 270, 599, "dshd.png");
                        mFairy.onTap(0.95f, result, "找到定时活动", Sleep);

                        result = mFairy.findPic(79, 107, 270, 599, "jzdd.png");
                        mFairy.onTap(0.8f, result, "找到家族大盗", Sleep);
                        mFairy.onTap(0.8f, result, 162, 615, 191, 628, "设为目标", Sleep);
                        if (result.sim < 0.8f) {
                            mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 171, 541, 173, 160, 200, 1500, 2);
                        }
                    }
                }
            }

            public void content_3() throws Exception {
                if (overtime(8, 0)) {
                    return;
                }
                result = mFairy.findPic("yijianhanhua.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    int mannum = 0;
                    result = mFairy.findPic(461, 485, 645, 520, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }

                    result = mFairy.findPic(648, 484, 828, 518, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }

                    result = mFairy.findPic(832, 486, 1010, 521, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }
                    result = mFairy.findPic(1012, 485, 1190, 520, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }
                    if (mannum > 1) {
                        gameUtil.callToFollow();
                        gameUtil.kicking();
                        LtLog.e(mFairy.getLineInfo("人满了出发"));
                        setTaskName(4);
                        return;
                    } else {
                        setTaskName(2);
                    }
                    gameUtil.shenqing();
                    if (timekeep(1, 120000, "2分钟招募一下")) {
                        LtLog.e(mFairy.getLineInfo("--------2分钟招募一下"));
                        gameUtil.yjhh();
                    }
                    if (timekeep(0, 600000, "家族强盗超过10分钟没组到人")) {
                        LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                        setTaskName(0);
                        return;
                    }
                }
            }

            public void content_4() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    Thread.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(200, 58, 1089, 676, "qdnpc.png");
                    mFairy.onTap(0.7f, result, result.x + 3, result.y + 27, result.x + 4, result.y + 28, "点击强盗", Sleep);
                    mFairy.onTap(0.7f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                    if (result.sim < 0.7f) {
                        LtLog.e(mFairy.getLineInfo("没有强盗了"));
                        setTaskEnd();
                        return;
                    }
                    setTaskName(5);
                    return;
                }
            }

            int juliCount = 0;

            public void content_5() throws Exception {
                long dazeTime = mFairy.mMatTime(1181, 38, 37, 15, 0.9f);
                if (dazeTime > 3) {
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    mFairy.initMatTime();

                    result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                    mFairy.onTap(0.8f, result, 591, 371, 611, 390, "点击强盗", 2000);

                    result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightjzqd.png"});
                    if (result.sim > 0.8f) {
                        Thread.sleep(7000);
                        mFairy.condit();
                        result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightjzqd.png"});
                        mFairy.onTap(0.8f, result, "右侧少废话看招", 500);
                    }

                    result = mFairy.findPic(449, 436, 814, 578, "julitaiyuan.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("距离太远"));
                        setTaskName(2);
                        return;
                    }
                    result = mFairy.findPic(449, 436, 814, 578, "rsbuzu.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("--------人数不足"));
                        setTaskName(2);
                        return;
                    }
                    setTaskName(6);
                    return;
                }
            }

            public void content_6() throws Exception {
                if (overtime(8, 4)) {
                    gameUtil.callToFollow();
                    return;
                }
                gameUtil.fuhuo();
                result = mFairy.findPic(1030, 77, 1127, 168, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    gameUtil.zidong();
                }
                result = mFairy.findPic(759, 418, 915, 527, "noqdjl.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("没有奖励"));
                    jzqd1 = 1;
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "家族强盗中");
    }//家族强盗

    public void sjzy() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic("sjzy1.png");
                if (result.sim < 0.8f) {
                    if (mFairy.dateMinute() >= 10) {
                        LtLog.e(mFairy.getLineInfo("没有赏金追妖了结束"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("出云");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                if (gameUtil.duizhang() == 1) {
                    setTaskName(3);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(7, 0)) {
                    return;
                }
                result = mFairy.findPic("yijianhanhua.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("mbsjzy.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("目标正确"));
                        result = mFairy.findPic("dzqxpp.png");
                        mFairy.onTap(0.8f, result, "先取消一下自动匹配", Sleep);
                        result = mFairy.findPic("dzzdpp.png");
                        mFairy.onTap(0.8f, result, "开启自动匹配", Sleep);
                        setTaskName(3);
                        return;
                    } else {
                        result = mFairy.findPic(79, 107, 270, 599, "dshd.png");
                        mFairy.onTap(0.95f, result, "找到定时活动", Sleep);

                        result = mFairy.findPic(79, 107, 270, 599, "sjzy.png");
                        mFairy.onTap(0.8f, result, "找到赏金追妖", Sleep);
                        mFairy.onTap(0.8f, result, 162, 615, 191, 628, "设为目标", Sleep);
                        if (result.sim < 0.8f) {
                            mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 171, 541, 173, 160, 200, 1500, 2);
                        }
                    }
                }
            }

            public void content_3() throws Exception {
                if (overtime(8, 0)) {
                    return;
                }
                result = mFairy.findPic("yijianhanhua.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    int mannum = 0;
                    result = mFairy.findPic(461, 485, 645, 520, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }

                    result = mFairy.findPic(648, 484, 828, 518, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }

                    result = mFairy.findPic(832, 486, 1010, 521, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }
                    result = mFairy.findPic(1012, 485, 1190, 520, "ppnum.png");
                    if (result.sim > 0.8f) {
                        mannum++;
                        LtLog.e(mFairy.getLineInfo(mannum + "个人了"));
                    }
                    if (mannum > 1) {
                        gameUtil.callToFollow();
                        LtLog.e(mFairy.getLineInfo("人满了出发"));
                        setTaskName(4);
                        return;
                    } else {
                        setTaskName(2);
                    }
                    gameUtil.shenqing();
                    if (timekeep(1, 120000, "2分钟招募一下")) {
                        LtLog.e(mFairy.getLineInfo("--------2分钟招募一下"));
                        gameUtil.yjhh();
                    }
                    if (timekeep(0, 600000, "赏金追妖超过10分钟没组到人")) {
                        LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                        setTaskName(0);
                        return;
                    }
                }
            }

            public void content_4() throws Exception {

                result = mFairy.findPic("sjzy1.png");
                mFairy.onTap(0.8f, result, "赏金追妖刷新出来了", Sleep);

                if (result.sim < 0.8f) {
                    if (mFairy.dateMinute() >= 10) {
                        LtLog.e(mFairy.getLineInfo("没有赏金追妖了结束"));
                        setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic("sjzyqw.png");
                mFairy.onTap(0.8f, result, "赏金追妖前往", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(5);
                    return;
                }
            }

            public void content_5() throws Exception {
                long dazeTime = mFairy.mMatTime(1181, 38, 37, 15, 0.9f);
                if (dazeTime > 3) {
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    mFairy.initMatTime();
                    result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightsjzy.png"});
                    if (result.sim > 0.8f) {
                        Thread.sleep(7000);
                        mFairy.condit();
                        result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"rightsjzy.png"});
                        mFairy.onTap(0.8f, result, "右侧妖怪哪里跑", 500);
                    }
                    result = mFairy.findPic(759, 418, 915, 527, "nojl.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("没有奖励"));
                        sjzy1 = 1;
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(449, 436, 814, 578, "julitaiyuan.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("距离太远"));
                        setTaskName(2);
                        return;
                    }

                    result = mFairy.findPic(449, 436, 814, 578, "rsbuzu.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("--------人数不足"));
                        setTaskName(2);
                        return;
                    }
                    setTaskName(6);
                    return;
                }
            }

            public void content_6() throws Exception {
                if (overtime(8, 4)) {
                    gameUtil.callToFollow();
                    return;
                }
                result = mFairy.findPic("shjzyboss.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("打boss中"));
                }
            }
        }.taskContent(mFairy, "赏金追妖中");
    }//赏金追妖

    public void yjdx() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h == 23 && m > 40) {
                    LtLog.e(mFairy.getLineInfo("一骑当先结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("yjdx.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int ppcount = 0;

            public void content_2() throws Exception {
                if (overtime(60, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(1008, 13, 1266, 601, "rightyjdx.png");
                mFairy.onTap(0.8f, result, "右侧一骑当先", Sleep);

                result = mFairy.findPic("yjdxpipei.png");
                if (result.sim > 0.8f) {
                    ppcount++;
                    if (ppcount >= 3) {
                        LtLog.e(mFairy.getLineInfo("一骑当先两次了结束"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f, result, "一骑当先匹配", 20000);
                }
                result = mFairy.findPic("yjdxzhandouzhong.png");
                mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "战斗中打开地图", Sleep);


                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 429, 315, 438, 321, "随便去个地方挂机", Sleep);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }
                result = mFairy.findPic("yjdxlikai.png");
                mFairy.onTap(0.8f, result, "一骑当先离开", 10000);
            }

            public void content_3() throws Exception {
                if (overtime(10, 2)) return;
             /*   result = mFairy.findPic("yjdxzhandouzhong.png");
                if (result.sim > 0.8f) {
                    err = 0;
                }*/
                result = mFairy.findPic(207, 77, 1138, 580, "yjdxbaohe.png");
                mFairy.onTap(0.8f, result, result.x - 34, result.y + 77, result.x - 33, result.y + 78, "一骑当先宝盒", 5000);

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }

                result = mFairy.findPic("hand.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 100);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 100);
                    mFairy.onTap(0.8f, result, 1021, 527, 1042, 543, "技能3", 100);
                    mFairy.onTap(0.8f, result, 1016, 636, 1032, 651, "技能4", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }

                result = mFairy.findPic("yjdxlikai.png");
                mFairy.onTap(0.8f, result, "一骑当先离开", 10000);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }
        }.taskContent(mFairy, "一骑当先中");

    }//一骑当先

    public void yjdx_test() throws Exception {
        new TimingActivity(mFairy) {
            Integer fightType = 1;//打怪方式:1、地图打怪。2、原地打怪
            Integer fightCount = 2;//参与次数

            @Override
            public void create() throws Exception {
                if (!AtFairyConfig.getOption("yjdxType").equals("")) {
                    fightType = Integer.parseInt(AtFairyConfig.getOption("yjdxType"));
                }

                if (!AtFairyConfig.getOption("yjdxCount").equals("")) {
                    fightCount = Integer.parseInt(AtFairyConfig.getOption("yjdxCount"));
                    if (fightCount == 0) fightCount = 2;
                    fightCount++;
                }
            }

            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h == 23 && m > 40) {
                    LtLog.e(mFairy.getLineInfo("一骑当先结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("yjdx.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int ppcount = 0;

            public void content_2() throws Exception {
                if (overtime(60, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(1008, 13, 1266, 601, "rightyjdx.png");
                mFairy.onTap(0.8f, result, "右侧一骑当先", Sleep);

                result = mFairy.findPic("yjdxpipei.png");
                if (result.sim > 0.8f) {
                    // ppcount 1 2 3
                    // fightCount 3 3
                    ppcount++;
                    if (ppcount >= fightCount) {
                        LtLog.e(mFairy.getLineInfo("一骑当先" + (ppcount - 1) + "次了结束"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f, result, "一骑当先匹配", 20000);
                }

                result = mFairy.findPic("yjdxzhandouzhong.png");
                if (result.sim > 0.8f) {
                    if (fightType == 1) {
                        mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "战斗中打开地图", Sleep);
                    }

                    if (fightType == 2) {
                        setTaskName(3);
                        LtLog.e(mFairy.getLineInfo("直接原地挂机"));
                        return;
                    }
                }

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 429, 315, 438, 321, "随便去个地方挂机", Sleep);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }

                result = mFairy.findPic("yjdxlikai.png");
                mFairy.onTap(0.8f, result, "一骑当先离开", 10000);
            }

            public void content_3() throws Exception {
                if (overtime(10, 2)) return;
             /*   result = mFairy.findPic("yjdxzhandouzhong.png");
                if (result.sim > 0.8f) {
                    err = 0;
                }*/
                result = mFairy.findPic(207, 77, 1138, 580, "yjdxbaohe.png");
                mFairy.onTap(0.8f, result, result.x - 34, result.y + 77, result.x - 33, result.y + 78, "一骑当先宝盒", 5000);

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }

                result = mFairy.findPic("hand.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 100);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 100);
                    mFairy.onTap(0.8f, result, 1021, 527, 1042, 543, "技能3", 100);
                    mFairy.onTap(0.8f, result, 1016, 636, 1032, 651, "技能4", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }

                result = mFairy.findPic("yjdxlikai.png");
                mFairy.onTap(0.8f, result, "一骑当先离开", 10000);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }
        }.taskContent(mFairy, "一骑当先中");

    }//一骑当先 改进版

    public boolean ryjjc_bool = false;

    public void ryjjc() throws Exception {
        new TimingActivity(mFairy) {

            public void create() throws Exception {
                super.create();
                ryjjc_bool = false;
            }

            public void inOperation() throws Exception {
                result = mFairy.findPic(546, 129, 591, 232, "dhl.png");
                mFairy.onTap(0.8f, result, "收起对话栏", Sleep);
                super.inOperation();
            }

            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("ryjjc.png", 2);
                if (ret == 1) {
                    gameUtil.retire();
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {

                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(951,71,1122,201,"ryjjcnei.png");
                mFairy.onTap(0.9f, result, "打开竞技", Sleep);

                result = mFairy.findPic(991,483,1195,671,"ryppz.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                    err = 0;
                }
                result = mFairy.findPic(991,483,1195,671,"jjcdrpp.png");
                if (result.sim > 0.8f) {
                    int m = mFairy.dateMinute();
                    if (m>=46){
                        LtLog.e(mFairy.getLineInfo("荣耀竞技场结束"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }


                    Thread.sleep(5000);
                    mFairy.onTap(462, 611, 478, 622, "活跃1", 200);
                    mFairy.onTap(462, 611, 478, 622, "活跃1", 200);
                    mFairy.onTap(619, 609, 638, 621, "活跃2", 200);
                    mFairy.onTap(619, 609, 638, 621, "活跃2", 200);
                    mFairy.onTap(707, 607, 732, 626, "活跃3", 200);
                    mFairy.onTap(707, 607, 732, 626, "活跃3", 200);
                    mFairy.onTap(807, 608, 821, 627, "活跃4", 200);
                    mFairy.onTap(807, 608, 821, 627, "活跃4", 200);
                    mFairy.onTap(1031, 383, 1039, 391, "战力", 200);
                    mFairy.onTap(1031, 383, 1039, 391, "战力", Sleep);


                    if (AtFairyConfig.getOption("ryjjc").equals("2") && ryjjc_bool) {
                        LtLog.e(mFairy.getLineInfo("用户勾选只打一次,荣耀竞技场结束!"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }

                    m = mFairy.dateMinute();
                    if (m>=45) {
                        LtLog.e(mFairy.getLineInfo("荣耀竞技场结束"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }

                    mFairy.onTap(0.8f, result, "单人匹配", Sleep);

                    result = mFairy.findPic("jjcdrpp.png");
                    mFairy.onTap(0.8f, result, "单人匹配", Sleep);


                }

                result = mFairy.findPic(553,47,740,157,"jjczhandou.png");
                mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "战斗中打开地图", 7000);

                result = mFairy.findPic(516,625,762,716,"ryjjcfanhui.png");
                mFairy.onTap(0.8f, result, "荣耀竞技场返回", Sleep);
                if (result.sim > 0.8f) {
                    ryjjc_bool = true;
                    int m = mFairy.dateMinute();
                    if (m>=46) {
                        LtLog.e(mFairy.getLineInfo("荣耀竞技场结束"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }
                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 719,407,729,417, "去地图中间挂机", 3000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(553,47,740,157,"jjczhandou.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                    mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                    mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                    mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                    mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }
                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic(516,625,762,716,"ryjjcfanhui.png");
                mFairy.onTap(0.8f, result, "荣耀竞技场返回", Sleep);
                if (result.sim > 0.8f) {
                    ryjjc_bool = true;
                    setTaskName(2);
                    return;
                }
            }

        }.taskContent(mFairy, "荣耀竞技场中");

    }//荣耀竞技场

    public void cfjj() throws Exception {
        new TimingActivity(mFairy) {

            public void create() throws Exception {
                super.create();
                ryjjc_bool = false;
            }

            public void inOperation() throws Exception {
                result = mFairy.findPic(546, 129, 591, 232, "dhl.png");
                mFairy.onTap(0.8f, result, "收起对话栏", Sleep);

                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
            }

            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("cfjj.png", 2);
                if (ret == 1) {
                    gameUtil.retire();
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(60, 0)) return;
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                int s = (h * 60 + m) * 60;
                if (!((h==19 && m>=55) || (h==20 && m<52))){
                    LtLog.e("任务时间已过 结束任务！");
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(1121,4,1276,26,"cfjjxxq.png");
                if (result.sim > 0.8f){
                    LtLog.e("休息区！");
                    Thread.sleep(1000);
                }


                result = mFairy.findPic(916,42,1115,200,"jjc2.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, "打开竞技", 50);
                    for (int i = 0; i < 20; i++) {
                        result = mFairy.findPic(436,432,814,569, new String[]{"swjr.png"});
                        if (result.sim > 0.75f) {
                            LtLog.i(mFairy.getLineInfo("尚未加入战队"));
                            setTaskEnd();
                            return;
                        }
                        LtLog.e("查看是否开启");
                    }
                }

                result2 = mFairy.findPic(939,537,1264,704,"bm.png");
                if (result2.sim > 0.8f){

                    for (int i = 0; i < 8; i++) {//开箱
                        result = mFairy.findPic(328,549,951,694, new String[]{"bx.png"});
                        mFairy.onTap(0.8f, result,result.x,result.y+20,result.x+24,result.y+31, "宝箱点击", Sleep);
                        LtLog.e("查看是否有宝箱");
                    }
                    mFairy.ranSwipe(850,615, 650,615, 100, (long) 1000, 2);
                    for (int i = 0; i < 3; i++) {//开箱
                        result = mFairy.findPic(328,549,951,694, new String[]{"bx.png"});
                        mFairy.onTap(0.8f, result, result.x,result.y+20,result.x+24,result.y+31,"宝箱点击", Sleep);
                        LtLog.e("查看是否有宝箱");
                    }

                    for (int i = 0; i < 3; i++) {//4战奖励
                    result = mFairy.findPic(328,549,951,694, new String[]{"sizhan.png"});
                        if (result.sim >0.8f) {
                            result1 = mFairy.findPic(result.x-4,result.y-56,result.x+20,result.y-23, new String[]{"ykq.png"});
                            if (result1.sim >0.8f) {
                                LtLog.i(mFairy.getLineInfo("4战完成  结束任务"));
                                setTaskEnd();
                                return;
                            }
                        }
                    }

                    mFairy.onTap(0.8f, result2, "报名", Sleep);
                }


                result = mFairy.findPic(810,187,962,454,"quxiao1.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("匹配中"));
                    mFairy.onTap(1017,145,1023,157,"关闭", Sleep);
                    result = mFairy.findPic(1130,30,1237,156,"cha.png");
                    mFairy.onTap(0.8f, result, "关叉", 50000);
                    err = 0;

                }




                result = mFairy.findPic(932,41,1151,249,"zhankuang.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "战斗中打开地图", 1000);
                    setTaskName(3);
                    return;
                }


            }

            public void content_3() throws Exception {

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }
                result = mFairy.findPic(932,41,1151,249,"zhankuang.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1196, 98, 1211, 111, "战斗中打开地图", 1000);
                }

                /*result = mFairy.findPic(0,69,90,312,new String[]{"shijie.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 598,334,604,347, "去地图中间挂机", 3000);
                mFairy.onTap(0.8f, result, 1232,40,1237,54, "关闭地图界面", Sleep);*/

                result = mFairy.findPic(271,66,1025,625,"lingpai.png");
                mFairy.onTap(0.8f, result,  "令牌", 1000);
                if (result.sim > 0.8f) {
                    setTaskName(4);
                    return;
                }
            }

            public void content_4() throws Exception {
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                int w = mFairy.week();
                int s = (h * 60 + m) * 60;
                if (overtime(30, 2)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(415,40,895,141, "jifen.png");
                if (result.sim > 0.8f)      {
                    err = 0;
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                    mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                    mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                    mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                    mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic(149,31,1153,682, new String[]{"quanbzj.png","lkzz.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(609,611,641,626, "离开战场", 3000);
                    setTaskName(2);
                    return;
                }


            }

        }.taskContent(mFairy, "冲锋竞技场中");

    }//冲锋竞技场

    public void pwzz() throws Exception {
        new TimingActivity(mFairy) {

            public void inOperation() throws Exception {
                result = mFairy.findPic(546, 129, 591, 232, "dhl.png");
                mFairy.onTap(0.8f, result, "收起对话栏", Sleep);

                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                if (h!=20){
                    setTaskEnd();
                    return;
                }

            }

            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {

                if (overtime(15, 0)) return;

                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 684,453,689,457, "在家族去中心点打怪", 5000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);

                result = mFairy.findPic(565,245,770,334, "pw.png");
                result1 = mFairy.findPic(670,175,1115,563, "pw1.png");
                result2 = mFairy.findPic(191,79,688,479, "pw3.png");
                if (result.sim>0.8f) {
                    mFairy.onTap(0.8f, result, result.x + 13, result.y + 83, result.x + 4, result.y + 88, "NPC点击", Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(0.8f, result1, result1.x-161, result1.y+57, result1.x-156, result1.y+72, "NPC点击1", Sleep);
                }else if (result2.sim > 0.8f){
                    mFairy.onTap(0.8f, result2, result2.x + 346, result2.y + 124, result2.x + 352, result2.y + 138, "NPC点击2", Sleep);
                }



                result = mFairy.findPic(992,95,1275,574,"pwzzjr.png");
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }

            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(992,95,1275,574,"pwzzjr.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "破雾之战进入", 10);
                    for (int i = 0; i < 20; i++) {
                        result = mFairy.findPic(526,451,763,550, new String[]{"fbwkq.png"});
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("破雾之战未开启 结束任务"));
                            setTaskEnd();
                            return;
                        }
                    }
                    setTaskName(3);
                    return;
                }
            }
            int x=0;
            public void content_3() throws Exception {

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f, result, "开启自动", Sleep);

                result = mFairy.findPic(899,2,1272,270,new String[]{"pwzzdt.png","pwzzdt.png"});
                if (result.sim < 0.7f) {
                    LtLog.e(mFairy.getLineInfo("不在破雾之战地图 "+x+++" 次"));

                    if (x>=10) {
                        setTaskName(1);
                        return;
                    }
                }
            }

        }.taskContent(mFairy, "破雾之战");

    }//破雾之战

    public void szlc() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m >= 30) {
                    LtLog.e(mFairy.getLineInfo("神之猎场结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("szlc.png", 2);
                if (ret == 1) {
                    gameUtil.retire();
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(8, 0)) return;
                if (gameUtil.duiyuan() == 1) {
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(7, 0)) {
                    return;
                }

                result = mFairy.findPic("dyqxpp.png");
                mFairy.onTap(0.8f, result, "先取消匹配重新定义活动", Sleep);

                result = mFairy.findPic(79, 107, 270, 599, "dshd.png");
                mFairy.onTap(0.95f, result, "找到定时活动", Sleep);

                result = mFairy.findPic(79, 107, 270, 599, "mbszlc.png");
                mFairy.onTap(0.8f, result, "找到神之猎场", Sleep);
                mFairy.onTap(0.8f, result, 1047, 631, 1085, 643, "开启自动匹配", Sleep);
                if (result.sim < 0.8f) {
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5}, 0, 171, 541, 173, 160, 200, 1500, 2);
                } else {
                    setTaskName(4);
                    return;
                }
            }

            public void content_4() throws Exception {
                if (overtime(15, 0)) return;
                if (timekeep(0, 600000, "超过10分钟没组到人")) {
                    LtLog.e(mFairy.getLineInfo("--------超过10分钟没组到人"));
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("dyqxpp.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "匹配中"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("shenqing.png");
                    mFairy.onTap(0.8f, result, 957, 103, 1151, 588, "申请进队", Sleep);
                    err = 0;
                }

                result = mFairy.findPic(855, 248, 1116, 410, "youceyaoqing.png");
                mFairy.onTap(0.8f, result, 1030, 370, 1058, 384, "右侧同意邀请", Sleep);

                result = mFairy.findPic("yryaoqing.png");
                mFairy.onTap(0.8f, result, "有人邀请点开", Sleep);

                result = mFairy.findPic(879, 101, 1092, 581, "jiaru.png");
                mFairy.onTap(0.8f, result, "邀请加入", 100);
                mFairy.onTap(0.8f, result, 438, 613, 477, 625, "邀请列表关闭", Sleep);

                result = mFairy.findPic("beitile.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("应该被踢了从来"));
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic("qxgs.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("进入队伍成功跟随队伍"));
                    gameUtil.close(0);
                    setTaskName(5);
                    return;
                }

                result = mFairy.findPic("gensuiduiwu.png");
                mFairy.onTap(0.8f, result, "进入队伍成功跟随队伍", Sleep);
                if (result.sim > 0.8f) {
                    gameUtil.close(0);
                    setTaskName(5);
                    return;
                }
            }

            public void content_5() throws Exception {

                result = mFairy.findPic("duiwulan.png");
                mFairy.onTap(0.8f, result, "切换到队伍栏", Sleep);

                result = mFairy.findPic(0, 0, 30, 27, "hg.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("成了队长了从来"));
                    gameUtil.retire();
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic("chuanjianduiwu.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("应该被踢了从来"));
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(1012, 134, 1121, 229, "copy.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    timekeepInit("超过5分钟没有在副本");
                    LtLog.e(mFairy.getLineInfo("神之猎场内"));
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                    mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                    mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                    mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                    mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }

                if (timekeep(0, 300000, "超过5分钟没有在副本")) {
                    LtLog.e(mFairy.getLineInfo("--------超过5分钟没有在副本"));
                    gameUtil.retire();
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic("beitile.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("应该被踢了从来"));
                    gameUtil.lkfb();
                    setTaskName(0);
                    return;
                }

                gameUtil.fuhuo();

                result = mFairy.findPic("szlcstop.png");
                mFairy.onTap(0.8f, result, "神之猎场结束关闭", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }
            }
        }.taskContent(mFairy, "神之猎场中");
    }//神之猎场

    public void jzsl() throws Exception {
        new TimingActivity(mFairy) {
            int first;

            public void create() throws Exception {
                super.create();
                first = 0;
            }

            public void inOperation() throws Exception {
                super.inOperation();
                int w = mFairy.week();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;

                if (AtFairyConfig.getOption("jzjh").equals("1") && h == 19 && (m >= 15 && m<= 30 ) && jzjh == 0) {
                    //    LtLog.e(mFairy.getLineInfo("用户勾选家族酒会"));
                    if (w == 6 || w == 7) {
                        jzwh();
                    } else {
                        jzjh();
                    }
                    jzjh = 1;
                }

                if ( h!=19 || m >= 16) {
                    LtLog.e(mFairy.getLineInfo("家族首领结束"));
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 564, 457, 581, 466, "在家族去中心点打怪", 5000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    if (first == 0) {
                        gameUtil.callToFollow();
                        gameUtil.cancelFollowing();
                        first = 1;
                    }
                    gameUtil.zidong();
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (AtFairyConfig.getOption("fuhuo").equals("1")) {
                    result = mFairy.findPic(491, 133, 784, 539, "fuhuo2.png");
                    mFairy.onTap(0.8f, result, "原地复活", Sleep);
                } else {
                    result = mFairy.findPic(491, 133, 784, 539, "fuhuo1.png");
                    mFairy.onTap(0.8f, result, "默认复活", Sleep);
                }
                if (result.sim > 0.8f) {
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy, "家族首领中");
    }//家族首领

    public void sjsy() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                overtime(10, 99);

                result = mFairy.findPic("hui1.png");
                if (result.sim > 0.8f) {
                    err = 0;

                    result = mFairy.findPic(800, 550, 1150, 707, "jiazu2.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "家族", 2000);

                    } else {
                        mFairy.onTap(1226, 207, 1251, 223, "", 1500);
                    }
                }

                result = mFairy.findPic(537, 41, 645, 90, "jiazu3.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(1209, 440, 1219, 480, "活动", 1000);

                    result = mFairy.findPic(203, 128, 345, 645, "sjsy.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(result.x + 805, result.y + 18, result.x + 807, result.y + 20, "助力", 1000);
                        mFairy.onTap(1165, 83, 1181, 94, "", 500);
                        setTaskEnd();
                        return;
                    }
                    return;
                }
            }
        }.taskContent(mFairy, "水晶深渊");
    }//水晶深渊

    public void mphw() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h >= 21) {
                    LtLog.e(mFairy.getLineInfo("门派会武结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("mphw.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic(1034, 121, 1106, 190, "copy.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("副本中"));
                    err = 0;
                }
                result = mFairy.findPic("hwzhankuang.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    mFairy.onTap(0.8f, result, 1217, 459, 1234, 470, "技能1", 200);
                    mFairy.onTap(0.8f, result, 1106, 457, 1122, 467, "技能2", 200);
                    mFairy.onTap(0.8f, result, 1042,483,1057,497, "技能3", 200);
                    mFairy.onTap(0.8f, result, 1008,568,1024,585, "技能4", 200);
                    mFairy.onTap(0.8f, result, 1049,655,1064,671, "技能5", 200);
                    mFairy.onTap(0.8f, result, 959,656,972,663, "技能6", 200);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                    mFairy.onTap(0.8f, result, 1166, 591, 1185, 605, "普工", 100);
                }

                result = mFairy.findPic(519, 40, 735, 121, "mpzk.png");
                mFairy.onTap(0.8f, result, 1113, 268, 1114, 269, "门派战况点击关闭", Sleep);

                result = mFairy.findPic("Resurrection.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("复活倒计时中"));
                    Thread.sleep(8000);
                    return;
                }
                result = mFairy.findPic(953, 152, 1037, 196, "dzinfo.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(980, 74, 1064, 120, "bisaizhong.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("门派会武任务结束"));
                        gameUtil.lkfb();
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "门派会武中");
    }//门派会武

    public void jzms() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h >= 21) {
                    LtLog.e(mFairy.getLineInfo("家族魔神结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("jzmstask.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int msfb = Integer.parseInt(AtFairyConfig.getOption("msfb"));
            boolean openmap = true;
            int msmap = 1;

            public void content_2() throws Exception {
                if (overtime(20, 0)) {
                    msfb++;
                    if (msfb > 5) {
                        msfb = 1;
                    }
                    return;
                }
                if (msfb == 1) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "ms1.png");
                    mFairy.onTap(0.8f, result, "副本1", 3000);
                }
                if (msfb == 2) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "ms2.png");
                    mFairy.onTap(0.8f, result, "副本2", 3000);
                }
                if (msfb == 3) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "ms3.png");
                    mFairy.onTap(0.8f, result, "副本3", 3000);
                }
                if (msfb == 4) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "ms4.png");
                    mFairy.onTap(0.8f, result, "副本4", 3000);
                }
                if (msfb == 5) {
                    result = mFairy.findPic(1008, 13, 1266, 601, "ms5.png");
                    mFairy.onTap(0.8f, result, "副本5", 3000);
                }
                result = mFairy.findPic(1018,123,1266,524, "msjoin.png");
                mFairy.onTap(0.8f, result, "进入", Sleep);


                result1 = mFairy.findPic(1027, 116, 1097, 194, "copy.png");
                if (result1.sim > 0.8f && mFairy.dateMinute() >= 5) {
                    result = mFairy.findPic("closehand.png");
                    mFairy.onTap(0.8f, result, "关闭自动", Sleep);
                }
                mFairy.onTap(0.8f, result1, 1196, 98, 1211, 111, "魔神中打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    if (msmap == 1) {
                        mFairy.onTap(0.8f, result, 628, 520, 629, 521, "去魔神第一个点", Sleep);
                    }
                    if (msmap == 2) {
                        mFairy.onTap(0.8f, result, 962, 448, 963, 449, "去魔神第2个点", Sleep);
                    }
                    if (msmap == 3) {
                        mFairy.onTap(0.8f, result, 832, 153, 833, 154, "去魔神第3个点", Sleep);
                    }
                    if (msmap == 4) {
                        mFairy.onTap(0.8f, result, 511, 375, 512, 376, "去魔神第4个点", Sleep);
                    }
                    if (msmap == 5) {
                        mFairy.onTap(0.8f, result, 378, 142, 379, 143, "去魔神第5个点", Sleep);
                        msmap = 3;
                    }
                    msmap++;
                }
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", 10000);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(30, 2)) return;
                Thread.sleep(1000);
                result1 = mFairy.findPic(1027, 116, 1097, 194, "copy.png");
                if (result1.sim > 0.8f) {
                    err = 0;
                }
                gameUtil.fuhuo();
                gameUtil.zidong();
                long dazeTime = mFairy.mMatTime(118, 59, 67, 21, 0.9f);
                if (dazeTime > 12) {
                    mFairy.initMatTime();
                    setTaskName(2);
                    return;
                }
            }
        }.taskContent(mFairy, "家族魔神中");
    }//家族魔神

    public void tsly() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (h == 22 && m > 45) {
                    LtLog.e(mFairy.getLineInfo("天神领域结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("tsly.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(30, 0)) return;
                Thread.sleep(1000);
                result = mFairy.findPic("tslyjm.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("天神领域界面"));
                    if (AtFairyConfig.getOption("tsly").equals("1")) {
                        mFairy.onTap(0.8f, result, 211, 167, 212, 168, "若空的残识", Sleep);
                    }
                    if (AtFairyConfig.getOption("tsly").equals("2")) {
                        mFairy.onTap(0.8f, result, 235, 258, 236, 259, "水疯魔", Sleep);
                    }
                    if (AtFairyConfig.getOption("tsly").equals("3")) {
                        mFairy.onTap(0.8f, result, 237, 361, 238, 362, "不动圣明王", Sleep);
                    }
                    if (AtFairyConfig.getOption("tsly").equals("4")) {
                        mFairy.onTap(0.8f, result, 229, 458, 230, 459, "沐风", Sleep);
                    }
                    if (AtFairyConfig.getOption("tsly").equals("5")) {
                        mFairy.onTap(0.8f, result, 234, 549, 235, 550, "天火魔龙", Sleep);
                    }
                    if (AtFairyConfig.getOption("tsly").equals("6")) {
                        mFairy.onTap(0.8f, result, 232, 638, 233, 639, "亡国守将", Sleep);
                    }
                    mFairy.onTap(0.8f, result, 1036, 631, 1037, 632, "传送", 10000);
                    result = mFairy.findPic(1053, 278, 1147, 456, "tslyjm.png");
                    mFairy.onTap(0.8f, result, 1192, 92, 1193, 93, "家族不能参赛退出", Sleep);
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                    setTaskName(3);
                    return;
                }
            }

            boolean openmap = true;

            public void content_3() throws Exception {

                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                if (result.sim > 0.8f && openmap) {
                    mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);
                    openmap = false;
                }

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 449, 199, 450, 200, "随便去个地方挂机", Sleep);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);

                gameUtil.fuhuo();
                gameUtil.zidong();
                long dazeTime = mFairy.mMatTime(118, 59, 67, 21, 0.9f);
                if (dazeTime > 20) {
                    mFairy.initMatTime();
                    openmap = true;
                }
            }
        }.taskContent(mFairy, "天神领域中");
    }//天神领域

    public void zbs() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("zbs.png", 2);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(15, 99)) return;
                result = mFairy.findPic(1008, 244, 1273, 536, "youceduizhenbiao.png");
                mFairy.onTap(0.8f, result, "右侧对阵表", Sleep);

                result = mFairy.findPic(492, 55, 801, 119, "duizhanbiaojiemian.png");
                mFairy.onTap(0.8f, result, 273, 270, 274, 271, "对阵表界面", Sleep);


                result = mFairy.findPic(579, 478, 827, 597, "zw.png");
                mFairy.onTap(0.8f, result, "助威", Sleep);

                result = mFairy.findPic(579, 478, 827, 597, "xh.png");
                mFairy.onTap(0.8f, result, "献花", Sleep);


                result = mFairy.findPic(828, 106, 932, 655, "xhh.png");
                mFairy.onTap(0.8f, result, "献花花", Sleep);
                mFairy.onTap(0.8f, result, 993, 98, 994, 99, "关闭献花花界面", 60000);

            }
        }.taskContent(mFairy, "争霸赛助威献花中");
    }//争霸赛助威献花

    public void jzwh() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m > 30) {
                    LtLog.e(mFairy.getLineInfo("家族舞会结束"));
                    setTaskEnd();
                    return;
                }


                result = mFairy.findPic(1022, 372, 1119, 431, "szclose.png");
                mFairy.onTap(0.8f, result, "关闭摇色子", Sleep);
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result1 = mFairy.findPic("tiaowu.png");
                mFairy.onTap(0.8f, result1, "跳舞", 5000);

                result = mFairy.findPic("xm.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "下马", 3000);

                    result1 = mFairy.findPic("tiaowu.png");
                    mFairy.onTap(0.8f, result1, "跳舞", 5000);
                }

                mFairy.onTap(0.8f, result1, "跳舞离开", Sleep);
                if (result1.sim > 0.8f) {
                    if (AtFairyConfig.getOption("jhsyyh").equals("1")) {
                        syyh();
                    }
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (AtFairyConfig.getOption("dati").equals("1")) {
                    result = mFairy.findPic(1020, 332, 1134, 440, "dati.png");
                    mFairy.onTap(0.8f, result, "点击答题", Sleep);

                    result = mFairy.findPic("Use of articles.png");
                    mFairy.onTap(0.8f, result, "使用烟花", Sleep);

                    result = mFairy.findPic("baginface.png");
                    mFairy.onTap(0.8f, result, 1161, 88, 1180, 100, "关闭包裹", Sleep);

                    result = mFairy.findPic(638, 134, 710, 196, "ti.png");
                    mFairy.onTap(0.8f, result, 513, 359, 514, 360, "在答题页面", 10000);

                    result = mFairy.findPic(1022, 372, 1119, 431, "ysz.png");
                    mFairy.onTap(0.8f, result, 1071, 388, 1072, 389, "摇色子", 10000);
                }
            }
        }.taskContent(mFairy, "家族舞会中");
    }//家族舞会

    public void qh_jzwh() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m > 46) {
                    LtLog.e(mFairy.getLineInfo("家族舞会结束"));
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(1022, 372, 1119, 431, "szclose.png");
                mFairy.onTap(0.8f, result, "关闭摇色子", Sleep);
            }

            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic("tiaowu.png");
                mFairy.onTap(0.8f, result, "跳舞", 5000);
                mFairy.onTap(0.8f, result, "跳舞离开", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }


        }.taskContent(mFairy, "家族舞会中");
    }//家族舞会

    public void jzjh() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m > 30) {
                    LtLog.e(mFairy.getLineInfo("家族酒会结束"));
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("gbdm.png");
                mFairy.onTap(0.8f, result, "关闭弹幕", Sleep);

                result = mFairy.findPic(120, 335, 1165, 683, "szclose.png");
                mFairy.onTap(0.8f, result, "关闭摇色子", Sleep);
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 569,458,578,463, "在家族去中心点喝酒", 5000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(846,112,1176,251, "jzjh.png");
                mFairy.onTap(0.8f, result, 414, 138, 452, 156, "家族酒会", Sleep);

                result = mFairy.findPic(1004,358,1270,541, "hejiu.png");//1021, 434, 1270, 531
                mFairy.onTap(0.8f, result, "点击喝酒", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 414, 138, 452, 156, "家族酒会", Sleep);
                    result = mFairy.findPic(1004,358,1270,541, "hejiu.png");//1021, 434, 1270, 531
                    mFairy.onTap(0.8f, result, "点击喝酒", Sleep);

                    mFairy.onTap(0.8f, result, 414, 138, 452, 156, "家族酒会", Sleep);
                    result = mFairy.findPic(1004,358,1270,541, "hejiu.png");//1021, 434, 1270, 531
                    mFairy.onTap(0.8f, result, "点击喝酒", Sleep);

                    if (AtFairyConfig.getOption("jhsyyh").equals("1")) {
                        syyh();
                    }
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (AtFairyConfig.getOption("bhdt").equals("1")) {
                    result = mFairy.findPic(1020, 332, 1134, 440, "dati.png");
                    mFairy.onTap(0.8f, result, "点击答题", Sleep);

                    result = mFairy.findPic("Use of articles.png");
                    mFairy.onTap(0.8f, result, "使用烟花", Sleep);

                    result = mFairy.findPic("baginface.png");
                    mFairy.onTap(0.8f, result, 1161, 88, 1180, 100, "关闭包裹", Sleep);

                    result = mFairy.findPic(638, 134, 710, 196, "ti.png");
                    mFairy.onTap(0.8f, result, 513, 359, 514, 360, "在答题页面", 10000);

                    result = mFairy.findPic(1022, 372, 1119, 431, "ysz.png");
                    mFairy.onTap(0.8f, result, 1071, 388, 1072, 389, "摇色子", 10000);
                }
            }
        }.taskContent(mFairy, "家族酒会中");
    }//家族酒会

    public void qh_jzjh() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m > 46) {
                    LtLog.e(mFairy.getLineInfo("家族酒会结束"));
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("gbdm.png");
                mFairy.onTap(0.8f, result, "关闭弹幕", Sleep);

                result = mFairy.findPic(120, 335, 1165, 683, "szclose.png");
                mFairy.onTap(0.8f, result, "关闭摇色子", Sleep);
            }

            @Override
            public void content_0() throws Exception {
                gameUtil.goCity("家族");
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic(676, 7, 1152, 170, "daily.png");
                mFairy.onTap(0.8f, result, 1189, 91, 1209, 105, "找到活动打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                mFairy.onTap(0.8f, result, 564, 457, 581, 466, "在家族去中心点喝酒", 5000);
                mFairy.onTap(0.8f, result, 1231, 39, 1246, 54, "关闭地图界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(15, 0)) return;

                result = mFairy.findPic(846,112,1176,251, "jzjh.png");
                mFairy.onTap(0.8f, result, 414, 138, 452, 156, "家族酒会", Sleep);

                result = mFairy.findPic(1021, 434, 1270, 531, "hejiu.png");
                mFairy.onTap(0.8f, result, "点击喝酒", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "家族酒会中");
    }//家族酒会


    public void syyh() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 99)) return;
                result = mFairy.findPic("bag.png");
                mFairy.onTap(0.8f, result, "包裹", Sleep);

                result = mFairy.findPic("baginface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("包裹界面中"));
                    result = mFairy.findPic(761, 177, 1147, 570, new String[]{"yanhua.png", "yanhua1.png", "yanhua2.png"});
                    mFairy.onTap(0.9f, result, "烟花", Sleep);

                    result = mFairy.findPic(224, 189, 736, 652, "sywp.png");
                    mFairy.onTap(0.8f, result, "物品使用", 10000);
                    if (result.sim > 0.8f) {
                        if (gameUtil.man() == 1) {
                            setTaskEnd();
                            return;
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4, 5, 6}, 0, 918, 538, 917, 225, 500, 1500, 2);
                }
            }
        }.taskContent(mFairy, "使用烟花中");
    }//使用烟花

    public void ldz() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                super.inOperation();
                int m = mFairy.dateMinute();
                int h = mFairy.dateHour();
                int s = (h * 60 + m) * 60;
                if (m >= 43) {
                    LtLog.e(mFairy.getLineInfo("领地战结束"));
                    gameUtil.lkfb();
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("ldz.png", 2);
                if (ret == 1) {
                    gameUtil.retire();
                    setTaskName(2);
                    return;
                } else {
                    result1 = mFairy.findPic(1129,4,1263,25,new String[]{"fz.png","zhu.png"});
                    if (result1.sim > 0.8f) {
                        GameUtil.lkfb();
                    }
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {//rightldz 圣域 jrfzzd 进入放逐
                if (overtime(10, 1)) return;
                Thread.sleep(1000);

                result = mFairy.findPic(292,81,1109,570,new String[]{"bhldz.png","bhldz1.png"});
                mFairy.onTap(0.8f, result,result.x+28,result.y+124, result.x+37,result.x+131,"白虎领地战", Sleep);

                result2 = mFairy.findPic(1008, 13, 1266, 601,"sxzb.png");
                if (result2.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("四雄争霸领地战结束"));
                    gameUtil.lkfb();
                    setTaskEnd();
                    return;
                }else{
                    result = mFairy.findPic(1008, 13, 1266, 601, new String[]{"jinru.png","jinru1.png"});
                    mFairy.onTap(0.8f, result, "对话框进入领地战", Sleep);
                    if (result.sim > 0.8f) {
                        for (int i=0;i<=20;i++){
                            result1 = mFairy.findPic(293,405,1029,586, "my.png");
                            if (result1.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("领地战无法参加"));
                                LtLog.e(mFairy.getLineInfo("领地战结束"));
                                gameUtil.lkfb();
                                setTaskEnd();
                                return;
                            }
                        }
                    }
                }
                result = mFairy.findPic(486,93,997,399,"fzldnpc.png");
                mFairy.onTap(0.8f, result,result.x+9,result.y+130, result.x+28,result.x+177,"放逐领地npc", Sleep);

                result1 = mFairy.findPic(1129,4,1263,25,new String[]{"fz.png","zhu.png"});
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result1, 1191,93,1210,116,"打开地图", Sleep);
                    mFairy.onTap(0.8f, result1, 653,378,659,383,"npc", Sleep);
                    mFairy.onTap(0.8f, result1, 1230,48,1243,60,"关闭地图", Sleep);
                    mFairy.onTap(0.8f, result1, 651,292,701,362,"npc点击", Sleep);
                }

                result = mFairy.findPic(907, 206, 1113, 312, new String[]{"copy.png","copy1.png"});
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("领地战副本内"));
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(8, 1)) return;
                result = mFairy.findPic(907, 206, 1113, 312, new String[]{"copy.png","copy1.png"});
                mFairy.onTap(0.8f, result, 1188, 94, 1208, 112, "领地战打开地图", Sleep);

                result = mFairy.findPic(new String[]{"mapinface.png", "mapinface1.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(644, 364, 655, 372, "去地图中心", Sleep);
                    mFairy.onTap(0.8f, result, 1228, 40, 1248, 55, "关闭地图", Sleep);
                    setTaskName(4);
                    return;
                }
                result = mFairy.findPic("fuhuotime.png");
                if (result.sim > 0.8f){
                    LtLog.e(mFairy.getLineInfo("领地战复活"));
                    Thread.sleep(8000);
                }
            }

            public void content_4() throws Exception {
                long dazeTime = mFairy.mMatTime(1181, 38, 37, 15, 0.9f);
                if (dazeTime > 2) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达目的地释放技能"));
                    setTaskName(5);
                    return;
                }
            }

            public void content_5() throws Exception {
                if (overtime(10, 3)) return;
                Thread.sleep(2000);
                gameUtil.zidong();
                result = mFairy.findPic("fuhuotime.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("领地战复活"));
                    Thread.sleep(8000);
                    setTaskName(3);
                    return;
                }
                Thread.sleep(2000);
            }
        }.taskContent(mFairy, "领地战中");
    }//领地战
}
