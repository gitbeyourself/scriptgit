package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    SingleTask singleTask;

    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        singleTask = new SingleTask(mFairy);
    }

    public int timingActivity() throws Exception {
        int h = mFairy.dateHour();
        int m = mFairy.dateMinute();
        int w = mFairy.week();

        if (AtFairyConfig.getOption("dalaolao").equals("1") && ((h == 13 && m > 49) || (h == 14 && m < 21) || (h == 20 && m > 49) || (h == 21 && m < 21)) ){
            dalaolao();
            return 1;
        }
        if (AtFairyConfig.getOption("sder").equals("1")&& ((h == 13 && m >= 0 && m <= 30) || (h == 22 && m >= 0 && m <= 30)) ){
            sder();
            return 1;
        }

        return 0;
    }
    public void inOperation() throws Exception {
        result = mFairy.findPic("guotu.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            err = 0;
        }
        for (int i = 0; i < 1; i++) {
            result = mFairy.findPic("Dialogbox.png");
            mFairy.onTap(0.8f, result, result.x, result.y + 50, result.x + 1, result.y + 51, "对话框", Sleep);
            if (result.sim > 0.8f) {
                err = 0;
                i = 0;
            }
        }
        result = mFairy.findPic("death.png");
        if (result.sim > 0.8f) {
            err = 0;
        }
    }
    //打姥姥
    public void dalaolao() throws Exception {
        new TimingActivity(mFairy) {
            @Override
            public void inOperation() throws Exception {
                super.inOperation();
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                if ((h == 13 && m > 49) || (h == 14 && m < 21) || (h == 20 && m > 49) || (h == 21 && m < 21)) {
                } else {
                    LtLog.e(mFairy.getLineInfo("打姥姥结束"));
                    setTaskEnd();return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.backCity(14,1);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);


                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                mFairy.onTap(0.8f, result, 365, 376,366, 377,"地图界面", 15000);
                if (result.sim > 0.8f) {
                     gameUtil.close(0);
                    result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                    mFairy.onTap(0.8f, result, "挂机中取消", Sleep);
                     setTaskName(2);return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic(884, 53, 1172, 232, new String[]{"HangUp.png", "HangUp1.png"});
                mFairy.onTap(0.8f, result, "打开挂机按钮", 3000);

                result = mFairy.findPic(908, 91, 1196, 389, new String[]{"Shmachine.png", "Shmachine1.png"});
                mFairy.onTap(0.8f, result,  "场景挂机", Sleep);
            }

        }.taskContent(mFairy, "打姥姥中");
    }


    //四大恶人
    public void sder() throws Exception {
        new TimingActivity(mFairy) {

            public void  inOperation() throws Exception {
                super.inOperation();
                int  h = mFairy.dateHour();
                int  m = mFairy.dateMinute();
                if ((h == 13 && m >= 0 && m <= 30) || (h == 22 && m >= 0 && m <= 30)) {
                } else {
                    result = mFairy.findPic("sdermatching.png");
                    mFairy.onTap(0.8f, result, "匹配中", Sleep);
                    gameUtil.close(0);
                    for (int i = 0; i < 30; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                        mFairy.onTap(0.8f, result,  145, 251, 146, 252, "活动", Sleep);

                        result = mFairy.findPic("sdercaptain.png");
                        mFairy.onTap(0.8f, result, 118, 323,119, 324,"我是队长", Sleep);

                        result = mFairy.findPic("sderLeaveteam.png");
                        mFairy.onTap(0.8f, result,  538, 452, 539, 453,"离开队伍确定", Sleep);
                        if (result.sim > 0.8f) {
                           setTaskEnd();return;
                        }
                        result = mFairy.findPic("sderdissolution.png");
                        mFairy.onTap(0.8f, result, "解散队伍", Sleep);

                        result = mFairy.findPic("sderlidui.png");
                        mFairy.onTap(0.8f, result, "队员离队", Sleep);
                        if (result.sim > 0.8f) {
                            setTaskEnd();return;
                        }
                        result = mFairy.findPic("sderInteam.png");
                        mFairy.onTap(0.8f, result, 118, 323,119, 324,"队伍中", Sleep);

                    }
                    setTaskEnd();return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.backCity(1,1);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 967, 129, 968, 130, "活动", Sleep);

                result = mFairy.findPic(75, 22, 454, 257, "rcinterface.png");
                mFairy.onTap(0.8f, result, 257, 270,258, 271,"活动界面", Sleep);

                result = mFairy.findPic(400, 133, 1147, 663, "sder.png");
                mFairy.onTap(0.8f, result, "四大恶人副本", Sleep);
                if (result.sim > 0.8f) {
                   setTaskName(2);return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(150, 0)) return;
                result = mFairy.findPic("sderteam.png");
                mFairy.onTap(0.8f, result, "一键组队", Sleep);

                result = mFairy.findPic("sdermatching.png");
                if (result.sim > 0.8f) {
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                if (overtime(150, 0)) return;
                result = mFairy.findPic("sderteam.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("组到队伍了"));
                   gameUtil.close(0);
                    setTaskName(4);return;
                }
            }
            public void content_4() throws Exception {
                if (overtime(30, 0)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("sderInteam.png");
                    if (result.sim > 0.8f) {
                        err=0;
                    }
                }

                result = mFairy.findPic("sdercaptain.png");
                mFairy.onTap(0.8f, result, 118, 323,119, 324,"我是队长", Sleep);

                result = mFairy.findPic("sderLeaveteam.png");
                mFairy.onTap(0.8f, result, 538, 452, 539, 453, "离开队伍确定", Sleep);

                result = mFairy.findPic("sderdissolution.png");
                mFairy.onTap(0.8f, result, "解散队伍", Sleep);
                if (result.sim > 0.8f) {
                   setTaskName(0);return;
                }
                result = mFairy.findPic("fbcomplete.png");
                mFairy.onTap(0.8f, result, "副本完成", Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(993, 166, 1278, 330, "Replica.png");
                    if(result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, "离开副本", 1500);
                        mFairy.onTap(514,439,561,460,"",3500);
                    }
                }
                result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                mFairy.onTap(0.8f, result, "副本奖励", Sleep);
            }
        }.taskContent(mFairy, "四大恶人中");
    }

}
