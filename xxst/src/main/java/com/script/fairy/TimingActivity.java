package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    static  int xshd_1 = 0, xshd_2 = 0, xshd_3 = 0 , xshd_4 = 0, xshd_5 = 0, xshd_6 = 0;
    static  int xshd_7= 0, xshd_8 = 0, xshd_9= 0 , xshd_10 = 0, xshd_11 = 0, xshd_12 = 0;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }

    abstract class  timingActivityContent extends TaskContent {
        public timingActivityContent(AtFairyImpl mFairy) throws Exception {
            super(mFairy);
        }
        @Override
        void create() throws Exception {

        }

        @Override
        void init() throws Exception {
            util.signOutXX();
            setTaskName(1);
        }

        @Override
        void inOperation() throws Exception {
            //  LtLog.e(mFairy.getLineInfo("list===" + list.toString()));
        }

        @Override
        void content_01() throws Exception {
            setTaskName(2);
        }
        @Override
        void content_02() throws Exception {
            setTaskName(3);
        }
    }

    public int  timingActivity() throws Exception {
        int h=mFairy.dateHour();
        int m=mFairy.dateMinute();
        int w=mFairy.week();
        int count=0;
        if (h == 0 && m == 0) {
            xshd_1 = 0;
            xshd_2 = 0;
            xshd_3 = 0;
            xshd_4 = 0;
            xshd_5 = 0;
            xshd_6 = 0;
            xshd_7 = 0;
            xshd_8 = 0;
            xshd_9 = 0;
            xshd_10 = 0;
            xshd_11= 0;
            xshd_12= 0;
        }
        if ((w==1 || w==2 || w==4 || w==5 || w==7)&&h==19 && m>=30 && m<55 && AtFairyConfig.getOption("bprh").equals("1")&& xshd_1==0){
             bprh();
             xshd_1=1;
             count=1;
        }
        if ((w==1 || w==2 || w==4 || w==5 || w==7)&&h==19 && m>=30 && m<55 && AtFairyConfig.getOption("bpyh").equals("1")&& xshd_6==0){
            bpyh();
            xshd_6=1;
            count=1;
        }
        if ((h==13 || h==14 || h==15 || h==16 || h==17 || h==18 || h==22 || h==23) && m>=20 && m<28 && AtFairyConfig.getOption("jmdb").equals("1") ){
            jmdb();
            count=1;
        }
        if ((h==12 && m>=30 )  && AtFairyConfig.getOption("bpqd").equals("1") && xshd_7==0){
            bpqd();
            xshd_7=1;
            count=1;
        }
        if ((h==18 && m<30) && AtFairyConfig.getOption("bpqd").equals("1") && xshd_8==0){
            bpqd();
            xshd_8=1;
            count=1;
        }
        if (w==1 && h==20 && m<40  && AtFairyConfig.getOption("mpcg").equals("1")&& xshd_2==0){
            mpcg();
            xshd_2=1;
            count=1;
        }
        if ((w==1 || w==3 || w==5) && h==21  && AtFairyConfig.getOption("qwjc").equals("1")&& xshd_3==0){
            qwjc();
            xshd_3=1;
            count=1;
        }
        if (w==2 && h==20 && m<55 && AtFairyConfig.getOption("bpz").equals("1")&& xshd_4==0){
            bpz();
            xshd_4=1;
            count=1;
        }
        if (w==2 && h==21 && m<30 && AtFairyConfig.getOption("lzzbs").equals("1")&& xshd_5==0){
            lzzbs();
            xshd_5=1;
            count=1;
        }
        if (count==1){
            return 1;
        }
        return 0;
    }
    //帮派燃火
    public void bprh() throws Exception {
        new  timingActivityContent(mFairy) {
            long dazeTime = 0;
            long  lxtime=0;
            int hdcount=0;
            String strSub2="";
            String xxmap="";
            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "帮派燃火中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (h!=19 || m>55){
                    LtLog.e(mFairy.getLineInfo("帮派燃火结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("bprh.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("帮派燃火结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {
                result = mFairy.findPic( new String[]{"bprh_other.png","bprh_other1.png","bprh_other2.png","bprh_other3.png"});
                mFairy.onTap(0.8f, result, "帮派跳舞宝箱点火等", 1000);

            }
            void content_04() throws Exception {

            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }

    //周一门派闯关
    public void mpcg() throws Exception {
        new  timingActivityContent(mFairy) {
            long dazeTime = 0;
            int  pnum_js=0;
            long  hhtime=0;
            long  lxtime=0;
            int hdcount=0;
            String strSub2="";
            String xxmap="";
            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "门派闯关中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (h!=20 || m>40){
                    LtLog.e(mFairy.getLineInfo("门派闯关结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("mpcg.png","看" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("门派闯关结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {
                util.target("队长","限时","target_mpcg.png","");
                setTaskName(4);
            }
            void content_04() throws Exception {
                result = mFairy.findPic("team_inface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("队伍界面判断人数"));
                    if ((System.currentTimeMillis()-hhtime)>180000){
                        LtLog.e(mFairy.getLineInfo("--------3分钟招募一下"));
                        mFairy.onTap(0.8f, result, 1005,591,1072,608,"喊话", 2000);
                        mFairy.onTap(0.8f, result, 612,496,675,519,"发送", 1000);
                        hhtime=System.currentTimeMillis();
                    }
                    result = mFairy.findPic(549,158,638,233,"xiake.png");
                    if (result.sim < 0.8f) {
                        LtLog.e(mFairy.getLineInfo("好像3个人了"));
                        result = mFairy.findPic("num3.png");
                        if (result.sim > 0.9f) {
                            LtLog.e(mFairy.getLineInfo("确定3个人了"));
                            pnum_js++;
                            Thread.sleep(2000);
                            if (pnum_js>30){
                                util.close();

                                pnum_js=0;
                                setTaskName(5);
                                return;
                            }
                        }
                    }
                    result = mFairy.findPic(928,157,1009,244,"xiake.png");
                    if (result.sim < 0.8f) {
                        LtLog.e(mFairy.getLineInfo("好像5个人了"));
                        result = mFairy.findPic("num5.png");
                        if (result.sim > 0.9f) {
                            util.close();
                            LtLog.e(mFairy.getLineInfo("确定5个人了"));
                            setTaskName(5);
                            return;
                        }
                    }
                }
            }
            void content_05() throws Exception {
                overtime(50, 0);
                result = mFairy.findPic(203,3,783,289, "activity.png");
                if (result.sim > 0.8f) {
                    dazeTime = mFairy.mMatTime(117, 48, 41, 14, 0.9f);
                    LtLog.e(mFairy.getLineInfo("发呆时间===" + dazeTime));
                    err = 0;
                } else {
                    mFairy.initMatTime();
                    dazeTime=0;
                }
                result = mFairy.findPic("In battle.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    err = 0;
                }
                result = mFairy.findPic(915, 159, 1159, 535, "Right_mpcg.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic(1031, 139, 1245, 516, "Taskbar_mpcg.png");
                if (dazeTime > 10) {
                    if (result.sim > 0.7f) {
                        mFairy.onTap(0.7f, result, "右侧门派闯关", 1000);
                        mFairy.initMatTime();
                        dazeTime=0;
                    } else {
                        setTaskName(0);
                    }
                }
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }

    //趣味竞猜
    public void qwjc() throws Exception {
        new  timingActivityContent(mFairy) {
            long dazeTime = 0;
            long  lxtime=0;
            int hdcount=0;
            String strSub2="";
            String xxmap="";
            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "趣味竞猜中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (h!=21){
                    LtLog.e(mFairy.getLineInfo("趣味竞猜结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("qwjc.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("趣味竞猜结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {

                result = mFairy.findPic("guessing competition.png");
                mFairy.onTap(0.8f, result, "竞猜", 1000);

                result = mFairy.findPic(915, 159, 1159, 535, "Right_jc.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic("vote.png");
                if (result.sim>0.8f){
                    for (int i=0;i<10;i++){
                        mFairy.onTap(0.8f, result, "投票", 1000);
                    }
                    util.close();
                    Thread.sleep(40000);
                }
            }
            void content_04() throws Exception {

            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }

    //假面夺宝
    public void jmdb() throws Exception {
        new  timingActivityContent(mFairy) {
            int count=0,mapcount=0;
            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "假面夺宝中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (m>35){
                    LtLog.e(mFairy.getLineInfo("假面夺宝结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("jmdb.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("假面夺宝结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {
                result = mFairy.findPic(915, 159, 1159, 535, "Right_jmdb.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic(383,222,920,535,"bcjm.png");
                mFairy.onTap(0.8f, result,720,426,762,445,"本场假面确定", 1000);

                result = mFairy.findPic("jmdb_map.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("假面夺宝内"));
                }

                result = mFairy.findPic(93,60,1252,659, "soul calibur1.png");
                mFairy.onTap(0.8f, result, "剑魂", 1000);

                result = mFairy.findPic(new String[]{"txwh_stop.png","jmdb_stop.png"});
                mFairy.onTap(0.8f, result, 601,582,667,603,"假面夺宝结束", 1000);
                if (result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("In battle.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    count=0;
                }
                result = mFairy.findPic(99,58,1176,452, "soul calibur.png");
                mFairy.onTap(0.7f, result, result.x+19,result.y+58,result.x+20,result.y+59,"剑魂", 1000);
                if (result.sim<0.8f){
                    count++;
                    if (count>50){
                        mapcount++;
                        if (mapcount>=4){
                            mapcount=1;
                        }
                        count=0;
                        result = mFairy.findPic("jmdb_map.png");
                        if (result.sim>0.8f){
                            mFairy.onTap(0.8f, result, "打开假面夺宝地图", 1000);
                            if (mapcount==1){
                                mFairy.onTap(0.8f, result, 613,431,624,440,"去第一个点", 1000);
                            }
                            if (mapcount==2){
                                mFairy.onTap(0.8f, result, 544,312,555,320,"去第2个点", 1000);
                            }
                            if (mapcount==3){
                                mFairy.onTap(0.8f, result, 736,433,744,440,"去第3个点", 1000);
                            }
                            util.close();
                            Thread.sleep(5000);
                        }
                    }
                }
            }
            void content_04() throws Exception {

            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }

    //帮派战
    public void bpz() throws Exception {
        new  timingActivityContent(mFairy) {

            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "帮派战中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (h!=20){
                    LtLog.e(mFairy.getLineInfo("帮派战结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("bpz.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("帮派战结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {
                result = mFairy.findPic("bzjr.png");
                mFairy.onTap(0.8f, result, "帮战进入", 1000);

                result = mFairy.findPic(915, 159, 1159, 535, "r_bpz.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);
            }
            void content_04() throws Exception {

            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }


    //龙舟争霸赛中
    public void lzzbs() throws Exception {
        new  timingActivityContent(mFairy) {

            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "龙舟争霸赛中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (h!=21 || m>30){
                    LtLog.e(mFairy.getLineInfo("龙舟争霸赛结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("lzzbs.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("龙舟争霸赛结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {
                result = mFairy.findPic(915, 159, 1159, 535, "r_lzzbs.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic(915, 159, 1159, 535, "r_wydcy.png");
                mFairy.onTap(0.8f, result, "我要当船员", 1000);

            }
            void content_04() throws Exception {

            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }

    //帮派宴会中
    public void bpyh() throws Exception {
        new  timingActivityContent(mFairy) {
            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "帮派宴会中";
                int h=mFairy.dateHour();
                int m=mFairy.dateMinute();
                if (h!=19 || m>55){
                    LtLog.e(mFairy.getLineInfo("帮派宴会结束"));
                    setTaskEnd();
                    return;
                }
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                int ret = util.findTask("lzzbs.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(3);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("帮派宴会结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_03() throws Exception {
                result = mFairy.findPic("qwbr.png");
                mFairy.onTap(0.8f, result, "前往烹饪", 1000);

                result = mFairy.findPic("bpyh_inface.png");
                mFairy.onTap(0.8f, result, 447,410,469,427,"帮派宴会界面", 1000);
                mFairy.onTap(0.8f, result, 876,225,896,241,"帮派宴会选材料", 1000);
                mFairy.onTap(0.8f, result, 965,554,1001,570,"帮派宴会放入", 1000);
                mFairy.onTap(0.8f, result, 594,330,612,350,"帮派宴会界面", 1000);
                mFairy.onTap(0.8f, result, 876,225,896,241,"帮派宴会选材料", 1000);
                mFairy.onTap(0.8f, result, 965,554,1001,570,"帮派宴会放入", 1000);
                mFairy.onTap(0.8f, result, 731,272,756,292,"帮派宴会界面", 1000);
                mFairy.onTap(0.8f, result, 876,225,896,241,"帮派宴会选材料", 1000);
                mFairy.onTap(0.8f, result, 965,554,1001,570,"帮派宴会放入", 1000);
                mFairy.onTap(0.8f, result, 722,565,763,584,"帮派宴会温火", 1000);

                result = mFairy.findPic(196,85,900,518, "sclz.png");
                mFairy.onTap(0.8f, result, "食材篮子", 1000);


            }
            void content_04() throws Exception {

            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
        };
    }

    //帮派强盗
    public void bpqd() throws Exception {
        new  timingActivityContent(mFairy) {
            int count=0,mapcount=0;
            @Override
            void create() throws Exception {
            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "帮派强盗中";
            }
            @Override
            void content_01() throws Exception {
                util.outTeam();
                setTaskName(2);
            }
            @Override
            void content_02() throws Exception {
                setTaskName(3);
            }
            void content_03() throws Exception {
                util.target("队长","帮派","target_bpqd.png","");
                setTaskName(4);
            }
            void content_04() throws Exception {
                int ret = util.findTask("bpqd.png","前往" ,"限时", "全部");
                if (ret == 1) {
                    setTaskName(5);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("帮派强盗结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_05() throws Exception {
                overtime(100,6);
                result = mFairy.findPic(93,60,1252,659, "Robber1.png");
                mFairy.onTap(0.8f, result, "强盗", 1000);

                result = mFairy.findPic(new String[]{"txwh_stop.png","jmdb_stop.png"});
                mFairy.onTap(0.8f, result, 601,582,667,603,"假面夺宝结束", 1000);
                if (result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(93,60,1252,659, "Among the robbers.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("强盗中"));
                    err=0;
                }


                result = mFairy.findPic("In battle.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    count=0;
                }
                result = mFairy.findPic(99,58,1176,452, "Robber.png");
                mFairy.onTap(0.7f, result, result.x+7,result.y+77,result.x+8,result.y+78,"强盗", 1000);
                if (result.sim<0.8f){
                    count++;
                    if (count>50){
                        mapcount++;
                        if (mapcount>=4){
                            mapcount=1;
                        }
                        count=0;
                        result = mFairy.findPic("bp_map.png");
                        if (result.sim>0.8f){
                            mFairy.onTap(0.8f, result, "打开帮派地图", 1000);
                            if (mapcount==1){
                                mFairy.onTap(0.8f, result, 570,267,571,268,"去第一个点", 1000);
                            }
                            if (mapcount==2){
                                mFairy.onTap(0.8f, result, 566,367,567,368,"去第2个点", 1000);
                            }
                            if (mapcount==3){
                                mFairy.onTap(0.8f, result, 645,355,646,356,"去第3个点", 1000);
                            }
                            util.close();
                            Thread.sleep(5000);
                        }
                    }
                }
            }
            void content_06() throws Exception {
                setTaskEnd();
            }
            void content_07() throws Exception {
            }
        };
    }
}
