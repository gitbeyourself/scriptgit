package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;
/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public Util(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    abstract class utilContent extends TaskContent {

        public utilContent(AtFairyImpl mFairy) throws Exception {
            super(mFairy);
        }

        @Override
        void create() throws Exception {

        }

        @Override
        void inOperation() throws Exception {

        }

        @Override
        void init() throws Exception {
            setTaskName(1);
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

    String strTeam = "";
    String strParent = "";
    String strSub = "";
    String strSub1 = "";

    //寻找目标任务
    public void target(String strTeam1, final String strParent1, String strSub_1, String strSub_2) throws Exception {
        strTeam = strTeam1;
        strParent = strParent1;
        strSub = strSub_1;
        strSub1 = strSub_2;
        new utilContent(mFairy) {
            int hd = 0;
            int hd_1 = 0;

            @Override
            void create() throws Exception {
                super.create();
            }

            @Override
            void inOperation() throws Exception {
                LtLog.e(mFairy.getLineInfo("选择目标:" + strTeam + "," + strParent + "," + strSub + "," + strSub1));
            }

            void content_03() throws Exception {
                switchbar("队伍");
                setTaskName(4);
            }

            void content_04() throws Exception {
                overtime(10, 0);
                if (strTeam.equals("队员")) {
                    result = mFairy.findPic("Convenient team formation.png");
                    mFairy.onTap(0.8f, result, "便捷组队", 2000);
                    if (result.sim > 0.8f) {
                        setTaskName(5);
                        return;
                    }

                    result = mFairy.findPic("teambar.png");
                    mFairy.onTap(0.8f, result, "打开队伍界面", 1000);

                    result = mFairy.findPic("Withdrawal from the ranks.png");
                    mFairy.onTap(0.8f, result, "退出队伍", 1000);

                    result = mFairy.findPic(383,222,920,535,"Withdrawal from the ranksSure.png");
                    mFairy.onTap(0.8f, result,716,423,760,446,"退出队伍确定", 1000);

                    result = mFairy.findPic("Creating a team.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("Unmatching.png");
                        mFairy.onTap(0.8f, result, "取消匹配", 1000);

                        result = mFairy.findPic("Start matching.png");
                        mFairy.onTap(0.8f, result, 935, 134, 949, 148, "开始匹配选择目标", 1000);
                        setTaskName(5);
                        return;
                    }
                }

                if (strTeam.equals("队长")) {

                    result = mFairy.findPic("Convenient team formation.png");
                    mFairy.onTap(0.8f, result, 1130, 297, 1171, 316, "创建队伍", 1000);

                    result = mFairy.findPic("teambar.png");
                    mFairy.onTap(0.8f, result, "打开队伍界面", 1000);

                    result = mFairy.findPic("Creating a team.png");
                    mFairy.onTap(0.8f, result, "创建队伍", 1000);

                    result = mFairy.findPic("Withdrawal from the ranks.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("Unmatching.png");
                        mFairy.onTap(0.8f, result, "取消匹配", 1000);

                        result = mFairy.findPic("Start matching.png");
                        mFairy.onTap(0.8f, result, 935, 134, 949, 148, "开始匹配选择目标", 1000);
                        setTaskName(5);
                        return;
                    }
                }

            }

            void content_05() throws Exception {
                overtime(10, 0);
                result = mFairy.findPic("Convenient Team Interface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("选择任务界面"));
                    if (strParent.equals("日常")) {
                        mFairy.onTap(0.8f, result, 279, 155, 327, 175, "日常", 2000);
                    }
                    if (strParent.equals("限时")) {
                        mFairy.onTap(0.8f, result, 276,237,313,252, "限时", 2000);
                    }
                    if (strParent.equals("团队")) {
                        mFairy.onTap(0.8f, result, 271,382,321,400, "团队", 2000);
                    }
                    if (strParent.equals("帮派")) {
                        mFairy.onTap(0.8f, result, 287,459,320,474, "帮派", 2000);
                    }
                    setTaskName(6);
                    return;
                }
            }

            void content_06() throws Exception {
                overtime(10, 0);
                result = mFairy.findPic(145, 94, 754, 630, strSub);
                mFairy.onTap(0.8f, result, result.x + 153, result.y + 19, result.x + 169, result.y + 34, "打开任务扩展栏" + strSub, 1000);
              if (result.sim > 0.8f) {
                 /*     if (strTeam.equals("队员")) {
                        result = mFairy.findPic("Improper Captain.png");
                        mFairy.onTap(0.9f, result, "不当队长", 1000);
                        mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                        setTaskEnd();
                        return;
                    } else if (strTeam.equals("队长")) {
                        result = mFairy.findPic("Improper Captain.png");
                        if (result.sim < 0.9f) {
                            mFairy.onTap(489, 578, 507, 592, "不当队长勾选取消", 1000);
                        }
                        mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                        setTaskEnd();
                        return;
                    }*/
                    if (strSub1.equals("")) {
                        if (strTeam.equals("队员")) {
                            result = mFairy.findPic("Improper Captain.png");
                            mFairy.onTap(0.9f, result, "不当队长", 1000);
                            mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                            setTaskEnd();
                            return;
                        } else if (strTeam.equals("队长")) {
                            result = mFairy.findPic("Improper Captain.png");
                            if (result.sim < 0.9f) {
                                mFairy.onTap(489, 578, 507, 592, "不当队长勾选取消", 1000);
                            }
                            mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                            setTaskEnd();
                            return;
                        }
                    } else {
                        //mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                        setTaskName(7);
                        return;
                    }
                } else {
                    if (hd == 0) {
                        for (int i = 0; i < 3; i++) {
                            mFairy.touchDown(2, 307, 178);
                            mFairy.touchMove(2, 292, 560, 1500);
                            mFairy.touchUp(2);
                        }
                        hd = 1;
                    } else {
                        mFairy.touchDown(2, 292, 560);
                        mFairy.touchMove(2, 307, 178, 1500);
                        mFairy.touchUp(2);
                        Thread.sleep(2000);
                    }
                }

            }

            void content_07() throws Exception {
                overtime(10, 0);
                result = mFairy.findPic(145, 94, 754, 630, strSub1);
                mFairy.onTap(0.9f, result, "选择任务" + strSub1, 1000);
                if (result.sim > 0.9f) {
                    if (strTeam.equals("队员")) {
                        result = mFairy.findPic("Improper Captain.png");
                        mFairy.onTap(0.9f, result, "不当队长", 1000);
                        mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                        setTaskEnd();
                        return;
                    } else if (strTeam.equals("队长")) {
                        result = mFairy.findPic("Improper Captain.png");
                        if (result.sim < 0.9f) {
                            mFairy.onTap(489, 578, 507, 592, "不当队长勾选取消", 1000);
                        }
                        mFairy.onTap(1021, 579, 1081, 597, "开始匹配", 1000);
                        setTaskEnd();
                        return;
                    }

                } else {
                    if (hd_1 == 0) {
                        for (int i = 0; i < 3; i++) {
                            mFairy.touchDown(2, 565, 159);
                            mFairy.touchMove(2, 563, 396, 1500);
                            mFairy.touchUp(2);
                        }
                        hd_1 = 1;
                    } else {
                        mFairy.touchDown(2, 563, 396);
                        mFairy.touchMove(2, 565, 159, 1500);
                        mFairy.touchUp(2);
                        Thread.sleep(2000);
                    }
                }

            }
        };
    }

    //关闭页面
    public void close() throws Exception {
        mFairy.condit();
        for (int i = 0; i < 2; i++) {
            result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork.png","fork2.png"});
            mFairy.onTap(0.9f, result, "叉", 1000);

            result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork1.png","fork3.png"});
            mFairy.onTap(0.9f, result, "叉", 1000);

            result = mFairy.findPic("In battle.png");
            if (result.sim > 0.8f) {
                LtLog.e(mFairy.getLineInfo("战斗中"));
                 signOutXX();
            }

        }
        LtLog.e("关叉中。。。。。");
    }

    //退出修行
    public void signOutXX() throws Exception {
        for (int i = 0; i < 3; i++) {
            mFairy.condit();
            LtLog.e(mFairy.getLineInfo("退出修行中"));
            result = mFairy.findPic("In a copy.png");
            mFairy.onTap(0.8f, result, "退出修行", 1000);
            if (result.sim > 0.8f) {
                i=0;
            }
            result = mFairy.findPic(383, 222, 920, 535, "Sign outxx.png");
            mFairy.onTap(0.8f, result, 712, 425, 765, 447, "退出修行确定", 1000);
            if (result.sim > 0.8f) {
                i=0;
            }

            result = mFairy.findPic("In battle.png");
            if (result.sim > 0.8f) {
                LtLog.e(mFairy.getLineInfo("战斗中"));
                i=0;
            }
            result = mFairy.findPic(657, 5, 1278, 323, "fork.png");
            mFairy.onTap(0.3f, result, "叉", 1000);
            if (result.sim > 0.3f) {
                i=0;
            }
            result = mFairy.findPic(657, 5, 1278, 323, "fork1.png");
            mFairy.onTap(0.8f, result, "叉", 1000);
            if (result.sim > 0.8f) {
                i=0;
            }
        }
        close();
    }

    //找任务
    public int findTask(String strpic, String see, String strParent, String strChild) throws Exception {
        int bj = 0;
        int hdcount = 0,hdcount_1=0;
        while (mFairy.condit()) {
            LtLog.e(mFairy.getLineInfo( "找任务中bj="+bj));
            result = mFairy.findPic(915, 159, 1159, 535, "copy.png");
            mFairy.onTap(0.8f, result, "右侧副本", 1000);
            if (result.sim > 0.8f) {
                break;
            }
            if (bj == 0) {
                result = mFairy.findPic("activity1.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动界面场景"));
                if (result.sim > 0.8f) {
                    if (strParent.equals("日常")) {
                        mFairy.onTap(0.8f, result, 194, 196, 225, 214, "日常", 1000);
                    }
                    if (strParent.equals("限时")) {
                        mFairy.onTap(0.8f, result, 196, 271, 230, 289, "限时", 1000);
                    }
                    if (strParent.equals("休闲")) {
                        mFairy.onTap(0.8f, result, 191, 346, 232, 367, "休闲", 1000);
                    }
                    if (strChild.equals("全部")) {
                        mFairy.onTap(0.8f, result, 399, 145, 414, 156, "全部", 1000);
                    }
                    if (strChild.equals("经验")) {
                        mFairy.onTap(0.8f, result, 538, 144, 550, 157, "经验", 1000);
                    }
                    if (strChild.equals("道具")) {
                        mFairy.onTap(0.8f, result, 672, 143, 686, 157, "道具", 1000);
                    }
                    if (strChild.equals("休闲")) {
                        mFairy.onTap(0.8f, result, 804, 146, 824, 159, "休闲", 1000);
                    }
                   for (int i = 0; i < 3; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(462,551,1164,632,"active_reward.png");
                        mFairy.onTap(0.7f, result, "活跃有奖励", 1000);
                        if (result.sim>0.7f){
                            i=1;
                        }
                    }
                    result = mFairy.findPic(331, 177, 1189, 544, strpic);
                    LtLog.e(mFairy.getLineInfo(0.8f, result, "找到任务" + strpic));
                    LtLog.e("*-*-****======"+result.sim);
                    if (result.sim > 0.8f) {
                        bj = 1;
                        continue;
                    }
                    for (int i = 0; i < 3; i++) {
                        mFairy.touchDown(2, 754, 198);
                        mFairy.touchMove(2, 762, 529, 1500);
                        mFairy.touchUp(2);
                    }
                    bj = 1;
                } else {
                    close();
                    result = mFairy.findPic(203, 3, 783, 289, "activity.png");
                    mFairy.onTap(0.8f, result, "主界面活动", 3000);
                }
            }
            if (bj == 1) {
                result = mFairy.findPic(203, 3, 783, 289, "activity.png");
                mFairy.onTap(0.8f, result, "主界面活动", 3000);

                result = mFairy.findPic("activity1.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "活动界面场景"));
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(331, 177, 1189, 544, strpic);
                    LtLog.e(mFairy.getLineInfo(0.8f, result1, "找到任务" + strpic));
                    if (result1.sim > 0.8f) {
                        if (strpic.equals("gsyx.png")) {
                            result = mFairy.findPic(result1.x + 252, result1.y, result1.x + 377, result1.y + 57, "go.png");
                            LtLog.e(mFairy.getLineInfo(0.1f, result, "前往"));
                            mFairy.onTap(0.8f, result, "前往1", 3000);
                            if (result.sim > 0.8f) {
                                result = mFairy.findPic(result1.x + 191, result1.y, result1.x + 313, result1.y + 57, "go.png");
                                mFairy.onTap(0.8f, result, "前往2", 3000);
                                if (result.sim > 0.8f) {
                                    continue;
                                }
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                        result = mFairy.findPic(result1.x + 191, result1.y, result1.x + 313, result1.y + 57, "go.png");
                        LtLog.e(mFairy.getLineInfo(0.1f, result, "前往"));
                        if (result.sim > 0.8f) {
                            if (see.equals("看")) {

                            } else if (see.equals("前往")) {
                                mFairy.onTap(0.8f, result, "前往", 3000);
                                result = mFairy.findPic(result1.x + 191, result1.y, result1.x + 313, result1.y + 57, "go.png");
                                mFairy.onTap(0.8f, result, "前往", 3000);
                                if (result.sim > 0.8f) {
                                    continue;
                                }
                            }
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        hdcount++;
                        if (hdcount == 2 || hdcount == 4 || hdcount == 6 || hdcount == 8) {
                            mFairy.touchDown(2, 762, 529);
                            mFairy.touchMove(2, 754, 198, 2000);
                            mFairy.touchUp(2);
                            LtLog.e(mFairy.getLineInfo("没有找到滑动一下"));
                            Thread.sleep(1000);
                        }
                        if (hdcount >= 10) {
                            if (hdcount_1>=2){
                                return 0;
                            }
                            close();
                            hdcount_1++;
                            bj=0;
                            continue;
                        }
                    }
                } else {
                    close();
                }
            }
        }
        return 0;
    }


    //切换队伍任务栏
    public void switchbar(String string) throws Exception {
        close();
        for (int i = 0; i < 10; i++) {
            mFairy.condit();
            if (string.equals("任务")) {
                result = mFairy.findPic("taskbar.png");
                LtLog.e(mFairy.getLineInfo(0.95f, result, "在任务栏"));
                if (result.sim > 0.95f) {
                    LtLog.e(mFairy.getLineInfo("在任务栏"));
                    break;
                }

                result = mFairy.findPic(new String[]{"teambar.png","teambar1.png"});
                mFairy.onTap(0.9f, result, 1064, 114, 1096, 128, "切换到任务栏", 1000);



            }

            if (string.equals("队伍")) {
                result = mFairy.findPic("taskbar.png");
                mFairy.onTap(0.95f, result, 1164, 114, 1201, 128, "切换到队伍栏", 1000);

                result = mFairy.findPic(new String[]{"teambar.png","teambar1.png"});
                if (result.sim > 0.9f) {
                    LtLog.e(mFairy.getLineInfo("在队伍栏"));
                    for (int i1 = 0; i1 < 3; i1++) {
                        result = mFairy.findPic(1188, 147, 1269, 515, "Off-line.png");
                        mFairy.onTap(0.8f, result, "离线", 2000);
                        if (result.sim > 0.8f) {
                            i1 = 1;
                        }

                        result = mFairy.findPic(829, 117, 1042, 644, "Please leave the team.png");
                        mFairy.onTap(0.8f, result, "请离队伍", 1000);
                        if (result.sim > 0.8f) {
                            i1 = 1;
                        }

                        result = mFairy.findPic(383, 222, 920, 535, "Make sure you leave.png");
                        mFairy.onTap(0.8f, result, 710, 426, 765, 449, "确定请离", 1000);
                        if (result.sim > 0.8f) {
                            i1 = 1;
                        }
                    }
                    break;
                }
            }
        }
       close();
    }

    //退队
    public void outTeam() throws Exception {
        switchbar("队伍");
        for (int i = 0; i < 5; i++) {
            mFairy.condit();
            LtLog.e(mFairy.getLineInfo("退队"));
            result = mFairy.findPic("Convenient team formation.png");
            if (result.sim > 0.8f) {
                LtLog.e(mFairy.getLineInfo("便捷组队"));
                break;
            }
            result = mFairy.findPic("Creating a team.png");
            if (result.sim > 0.8f) {
                LtLog.e(mFairy.getLineInfo("创建队伍"));
                break;
            }

            result = mFairy.findPic(new String[]{"teambar.png","teambar1.png"});
            mFairy.onTap(0.8f, result, "打开队伍界面", 1000);

            result = mFairy.findPic("Withdrawal from the ranks.png");
            mFairy.onTap(0.8f, result, "退出队伍", 1000);

            result = mFairy.findPic("Withdrawal from the team.png");
            mFairy.onTap(0.8f, result, "退出团队", 1000);

            result = mFairy.findPic(383,222,920,535,new String[]{"Withdrawal from the ranksSure.png","Withdrawal from the ranksSure1.png"});
            mFairy.onTap(0.8f, result,716,423,760,446,"退出队伍确定", 1000);

        }
        close();
    }

    //设置
    public void setUp() throws Exception {
        new utilContent(mFairy) {
            public void init() throws Exception {
                close();
                setTaskName(1);
                return;
            }
            public void content_01() throws Exception {
                overtime(10, 0);
                result = mFairy.findPic("set up.png");
                mFairy.onTap(0.8f, result, "点击下拉框",1000);

                result = mFairy.findPic(969,479,1273,713,"set2.png");
                mFairy.onTap(0.8f, result, "设置", 1000);

                result = mFairy.findPic(38,46,126,263,"shezhi.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f, result,  441,376,446,382,"省电模式", 3000);
                    LtLog.e("设置结束------");
                    mFairy.onTap(0.8f, result,  1239,21,1254,36,"关闭", 3000);
                    setTaskEnd();return;
                }
            }
        };
    }
}
