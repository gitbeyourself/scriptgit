package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    Util util;
    List<String> list = new ArrayList<>();
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        mFairy1 = ypFairy;
    }

    abstract class teamTaskContent extends TaskContent {
        String strTeam ="";

        public teamTaskContent(AtFairyImpl mFairy) throws Exception {
            super(mFairy);
        }
        @Override
        void create() throws Exception {
            TASKNAME = "组队日常中";
            if (AtFairyConfig.getOption("zudui").equals("1")) {
                strTeam="队长";
            }
            if (AtFairyConfig.getOption("zudui").equals("2")) {
                strTeam="队员";
            }
            //夜袭敌营
            if (AtFairyConfig.getOption("yxdy").equals("1")) {
                list.add("yxdy.png");
            }
            //智闯绝情谷
            if (AtFairyConfig.getOption("zcjqg").equals("1")) {
                list.add("zcjqg.png");
            }
            //五绝令
            if (AtFairyConfig.getOption("wjl").equals("1")) {
                list.add("wjl.png");
            }
            //夜袭敌营精英
            if (AtFairyConfig.getOption("yxdyjy").equals("1")) {
                list.add("yxdyjy.png");
            }
            if (list.size() == 0) {
                setTaskEnd();
                return;
            }
        }

        @Override
        void init() throws Exception {
            if (list.size() == 0) {
                setTaskEnd();
                return;
            }
            util.signOutXX();
            setTaskName(1);
        }

        @Override
        void inOperation() throws Exception {
        }

        @Override
        void content_01() throws Exception {
            int ret = util.findTask(list.get(0), "看","日常", "全部");
            if (ret == 1) {
                mFairy.initMatTime();
                setTaskName(2);
                return;
            } else if (ret == 0) {
                LtLog.e(mFairy.getLineInfo("移除一个任务"));
                mFairy.initMatTime();
                list.remove(0);
                if (list.size() == 0) {
                    LtLog.e(mFairy.getLineInfo("没有任务了结束"));
                    setTaskEnd();
                    return;
                }
            }
        }
        @Override
        void content_02() throws Exception {
            setTaskName(3);
        }
    }

    public void teamCopy() throws Exception {
        new teamTaskContent(mFairy) {
            int  pnum_js=0;
            long dazeTime = 0;
            long  hhtime=0;
            @Override
            void create() throws Exception {
                super.create();
            }
            void inOperation() throws Exception {
                LtLog.e(mFairy.getLineInfo("list===" + list.toString()));
            }
            void content_03() throws Exception {

                if (list.get(0).equals("yxdy.png")) {
                    util.target(strTeam,"日常","Team duplicate.png","strSub1_yxdy.png");
                }
                if (list.get(0).equals("zcjqg.png")) {
                    util.target(strTeam,"日常","Team duplicate.png","strSub1_zcjqg.png");
                }
                if (list.get(0).equals("wjl.png")) {
                    util.target(strTeam,"日常","Team duplicate.png","strSub1_wjl.png");
                }
                if (list.get(0).equals("yxdyjy.png")) {
                    util.target(strTeam,"日常","Team duplicate.png","strSub1_yxdyjy.png");
                }
                setTaskName(4);
            }
            void content_04() throws Exception {
                if (strTeam.equals("队长")){
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
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("确定3个人了"));
                                pnum_js++;
                                Thread.sleep(2000);
                                if (pnum_js>30){
                                    util.findTask(list.get(0), "前往","日常", "全部");
                                    pnum_js=0;
                                }
                            }
                        }
                        result = mFairy.findPic(928,157,1009,244,"xiake.png");
                        if (result.sim < 0.8f) {
                            LtLog.e(mFairy.getLineInfo("好像5个人了"));
                            result = mFairy.findPic("num5.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("确定5个人了"));
                                util.findTask(list.get(0), "前往","日常", "全部");
                            }
                        }
                    }

                    result = mFairy.findPic(915, 159, 1159, 535, "copy.png");
                    mFairy.onTap(0.8f, result, "右侧副本", 1000);


                    result = mFairy.findPic("Entry copy.png");
                    mFairy.onTap(0.8f, result, "进入副本副本", 2000);
                    if (result.sim>0.8f){
                        result = mFairy.findPic("Entry copy.png");
                        mFairy.onTap(0.8f, result, "进入副本副本", 2000);
                        if (result.sim>0.8f){
                            util.outTeam();
                            setTaskName(0);
                            return;
                        }
                    }
                    result = mFairy.findPic("No copy reward.png");
                    mFairy.onTap(0.8f, result, 520,423,568,451,"没有副本奖励", 1000);
                    if (result.sim>0.8f){
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }
                    result = mFairy.findPic("In a copy.png");
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("副本内"));
                        setTaskName(5);
                        result = mFairy.findPic("teambar.png");
                        mFairy.onTap(0.9f, result, 1064,114,1096,128,"切换到副本栏", 1000);
                    }
                }else {
                    result = mFairy.findPic("Continue to be single.png");
                    mFairy.onTap(0.8f, result, "继续单人", 2000);

                    result = mFairy.findPic("team_inface.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("队伍界面匹配中"));
                    }else {
                        setTaskName(5);
                    }
                }
            }
            void content_05() throws Exception {
                overtime(50,0);
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
                if (strTeam.equals("队长")){
                    result = mFairy.findPic("In a copy.png");
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("副本内"));
                        result = mFairy.findPic("teambar.png");
                        mFairy.onTap(0.9f, result, 1064,114,1096,128,"切换到副本栏", 1000);
                    }
                    result = mFairy.findPic(1031, 139, 1245, 516, new  String[]{"Taskbar_yxdy.png","Taskbar_zcjqg.png","Taskbar_fyqsz.png","Taskbar_jy.png","Taskbar_cyyw.png"});
                    if (dazeTime > 7) {
                        if (result.sim > 0.7f) {
                            mFairy.onTap(0.7f, result, "右侧副本任务", 1000);
                            mFairy.initMatTime();
                            dazeTime=0;
                        } else {
                            setTaskName(0);
                        }
                    }
                    result = mFairy.findPic(383,222,920,535,"Continue to copy.png");
                    mFairy.onTap(0.8f, result,708,429,760,450,"继续前往副本", 1000);
                    if (result.sim>0.8f){
                        mFairy.initMatTime();
                        dazeTime=0;
                    }
                }else {
                    if (dazeTime>300){
                        setTaskName(0);
                    }
                }

            }
        };
    }


    //团队副本
    public void tdfb() throws Exception {
        new teamTaskContent(mFairy) {
            int  pnum_js=0;
            long dazeTime = 0;
            long  hhtime=0,lxtime=0;
            int hdcount=0;
            String strSub2="tdfb_pt.png";
            @Override
            void create() throws Exception {
                TASKNAME = "团队副本中";
                if (AtFairyConfig.getOption("td_nd").equals("1")){
                    strSub2="tdfb_pt.png";
                }
                if (AtFairyConfig.getOption("td_nd").equals("2")){
                    strSub2="tdfb_jy.png";
                }
                if (AtFairyConfig.getOption("td_nd").equals("3")){
                    strSub2="tdfb_ds.png";
                }
            }
            void init() throws Exception {
                util.signOutXX();
                util.outTeam();
                setTaskName(1);
            }
            void content_01() throws Exception {
                int ret = util.findTask("tdfb.png","看" ,"日常", "全部");
                if (ret == 1) {
                    setTaskName(2);
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("团队副本结束"));
                    setTaskEnd();
                    return;
                }
            }
            void content_02() throws Exception {
                util.target("队员","团队","mzxb.png",strSub2);
                setTaskName(3);
            }
            void content_03() throws Exception {
                result = mFairy.findPic("taskbar.png");
                mFairy.onTap(0.9f, result, 1164, 114, 1201, 128, "切换到队伍栏", 1000);

                result = mFairy.findPic(new String[]{"teambar.png","teambar1.png"});
                mFairy.onTap(0.8f, result, "打开队伍框", 1000);

                result = mFairy.findPic("Start matching.png");
                mFairy.onTap(0.8f, result, "开始匹配", 1000);

                result = mFairy.findPic("team_sure.png");
                mFairy.onTap(0.8f, result, "团队副本进入同意", 1000);
                if (result.sim>0.8f){
                    setTaskName(4);
                    return;
                }
            }
            void content_04() throws Exception {
                util.close();
                overtime(50,0);
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
                result = mFairy.findPic(215,87,1025,567,"tdbx.png");
                mFairy.onTap(0.95f, result, "团队宝箱", 1000);

                result = mFairy.findPic(254,42,1124,669,"tdbx1.png");
                mFairy.onTap(0.8f, result, "团队宝箱1", 1000);

                result = mFairy.findPic("Withdrawal from the team.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("退出团队中"));
                    setTaskName(0);
                }
                if (dazeTime>300){
                    setTaskName(0);
                }
            }
            void content_05() throws Exception {
            }
            void content_06() throws Exception {
            }
            void content_07() throws Exception {
            }
            void content_08() throws Exception {
            }
        };
    }





    //喊话
    public void test() throws Exception {
        new teamTaskContent(mFairy) {
            int  pnum_js=0;
            long dazeTime = 0;
            long  hhtime=0,lxtime=0;
            int hdcount=0;
            @Override
            void create() throws Exception {
                TASKNAME = "喊话中";
            }
            void init() throws Exception {
               util.signOutXX();
                setTaskName(1);
            }
            void content_01() throws Exception {
                util.target("队长","日常","mdkp.png","");
                setTaskName(2);
            }
            void content_02() throws Exception {
                setTaskName(3);
            }
            void content_03() throws Exception {
                setTaskName(4);
            }
            void content_04() throws Exception {
                   if (mFairy.dateHour()<8){
                       setTaskName(5);
                       return;
                   }

                    result = mFairy.findPic("team_inface.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("队伍界面准备喊话"));
                        Thread.sleep(10000);
                        if ((System.currentTimeMillis()-hhtime)>1800000){
                            LtLog.e(mFairy.getLineInfo("--------30分钟招募一下"));
                            mFairy.onTap(0.8f, result, 1005,591,1072,608,"喊话", 2000);
                            mFairy.onTap(0.8f, result, 453,309,475,329,"输入框", 1000);
                            mFairy.inputText("云端挂机全天在线+869-574-053");
                            mFairy.onTap(0.8f, result, 1196,224,1231,244,"确定", 1000);
                            mFairy.onTap(0.8f, result, 612,496,675,519,"发送", 1000);
                            Thread.sleep(35000);
                            mFairy.onTap(0.8f, result, 1005,591,1072,608,"喊话", 2000);
                            mFairy.onTap(0.8f, result, 453,309,475,329,"输入框", 1000);
                            mFairy.inputText("云端挂机全天在线+869-574-053");
                            mFairy.onTap(0.8f, result, 1196,224,1231,244,"确定", 1000);
                            mFairy.onTap(0.8f, result, 612,496,675,519,"发送", 1000);
                            Thread.sleep(35000);
                            mFairy.onTap(0.8f, result, 1005,591,1072,608,"喊话", 2000);
                            mFairy.onTap(0.8f, result, 453,309,475,329,"输入框", 1000);
                            mFairy.inputText("云端挂机全天在线+869-574-053");
                            mFairy.onTap(0.8f, result, 1196,224,1231,244,"确定", 1000);
                            mFairy.onTap(0.8f, result, 612,496,675,519,"发送", 1000);
                            hhtime=System.currentTimeMillis();
                        }
                    }
            }
            void content_05() throws Exception {
                int ret = util.findTask("xx.png", "前往","日常", "全部");
                if (ret == 1) {
                    mFairy.initMatTime();
                    setTaskName(6);
                    return;
                }
            }
            void content_06() throws Exception {
                overtime(10,0);
                result = mFairy.findPic("xx_inface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "修行场景"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(170,397,1119,536,"xxmap1.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "找到地图" ));
                    if (result.sim > 0.9f) {
                        setTaskName(7);
                        return;
                    }
                    for (int i = 0; i < 2; i++) {
                        mFairy.touchDown(2,293,311);
                        mFairy.touchMove(2,987,309,2000);
                        mFairy.touchUp(2);
                    }
                    setTaskName(7);
                }
            }
            void content_07() throws Exception {
                overtime(20,0);
                result = mFairy.findPic("xx_inface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "修行场景"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(170,397,1119,536,"xxmap1.png");
                    LtLog.e(mFairy.getLineInfo(0.9f, result, "找到地图"));
                    if (result.sim > 0.9f) {
                        mFairy.onTap(0.9f, result,result.x-42,result.y-208,result.x+3,result.y-166,"选择地图", 1000);
                        mFairy.onTap(0.9f, result,968,539,1022,565,"开始修行", 1000);
                        result = mFairy.findPic(310,216,988,281,"Inability to participate.png");
                        if (result.sim > 0.75f) {
                            LtLog.e(mFairy.getLineInfo("无法参与退队"));
                            util.outTeam();
                            setTaskName(0);
                        }
                        setTaskName(8);
                    }else {
                        hdcount++;
                        if (hdcount == 2 || hdcount == 4 || hdcount == 6 || hdcount == 8) {
                            mFairy.touchDown(2,1011,319);
                            mFairy.touchMove(2,273,326,2000);
                            mFairy.touchUp(2);
                            LtLog.e(mFairy.getLineInfo("没有找到滑动一下"));
                            Thread.sleep(1000);
                        }
                        if (hdcount >= 10) {
                            util.close();
                        }
                    }
                }

            }
            void content_08() throws Exception {
                if (mFairy.dateHour()>=8){
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic(383,222,920,535,"High Scene.png");
                mFairy.onTap(0.8f, result,714,424,755,448,"场景高确定", 1000);

                result = mFairy.findPic(310,216,988,281,"Inability to participate.png");
                if (result.sim > 0.75f) {
                    LtLog.e(mFairy.getLineInfo("无法参与退队"));
                    util.outTeam();
                    setTaskName(0);
                }
                overtime(50,0);
                result = mFairy.findPic(203,3,783,289,"activity.png");
                if (result.sim > 0.8f) {
                    dazeTime = mFairy.mMatTime(117, 48, 41, 14, 0.9f);
                    LtLog.e(mFairy.getLineInfo("发呆时间===" + dazeTime));
                    if (dazeTime>20){
                        setTaskName(0);
                    }
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



                result = mFairy.findPic(383,222,920,535,"Multiple times.png");
                if (result.sim>0.8f){
                    if (AtFairyConfig.getOption("sb").equals("1")){
                        mFairy.onTap(0.8f, result,711,427,766,447,"多倍开", 1000);
                    }else {
                        mFairy.onTap(0.8f, result,517,425,567,446,"多倍取消", 1000);
                    }
                }

                if ((System.currentTimeMillis()-lxtime)>300000){
                    util.switchbar("队伍");
                    lxtime=System.currentTimeMillis();
                }
            }
        };
    }

}
