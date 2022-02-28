package com.padyun.fairy;


import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;

import com.script.framework.TaskContent;
import com.script.framework.AtFairyImpl;



import org.opencv.core.RotatedRect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UTFDataFormatException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;


import static org.opencv.imgcodecs.Imgcodecs.imread;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    GameUtil gameUtil;




    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);

    }

    public void novice() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                result = mFairy.findPic("tuzhi.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("主线结束"));
                    setTaskEnd();
                    return;
                }


                result = mFairy.findPic("zhu.png");
                mFairy.onTap(0.8f, result, "后续有其他支线接取主线", 2000);

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                if (dazeTime > 3) {
                    mFairy.initMatTime();
                    result = mFairy.findPic("task team.png");
                    mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);
                    LtLog.e("11111111" + result.sim);
                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.9f, result, 84, 195, 108, 209, "任务栏切换到普通", Sleep);
                    LtLog.e("22222222" + result.sim);
                    result = mFairy.findPic(44, 178, 254, 318, "main.png");
                    mFairy.onTap(0.7f, result, "左侧主线", Sleep);
                    if (picCountS(0.7f, result, "左侧主线") > 30) {
                        LtLog.e(mFairy.getLineInfo("主线结束"));
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f, result, "手", 4000);

                result = mFairy.findPic("Automatically put on.png");
                mFairy.onTap(0.8f, result, "自动穿上", Sleep);

                result = mFairy.findPic("Replica.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("In combat.png");
                    if (result.sim < 0.8f) {
                        mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", Sleep);
                    }
                }
                result = mFairy.findPic("anchor.png");
                mFairy.onTap(0.8f, result, 16, 154, 30, 163, "主播", Sleep);


                result = mFairy.findPic("iknow.png");
                mFairy.onTap(0.8f, result, "知道了", 2000);

                result = mFairy.findPic("Departure.png");
                mFairy.onTap(0.8f, result, "坐骑出站", Sleep);
                mFairy.onTap(0.8f, result, 1153, 55, 1167, 66, "关闭", Sleep);
                mFairy.onTap(0.8f, result, 851, 592, 868, 604, "骑乘", Sleep);


                result = mFairy.findPic(new String[]{"other.png", "other7.png", "other8.png"});
                mFairy.onTap(0.8f, result, 1225, 194, 1239, 206, "需要离开副本", Sleep);
                mFairy.onTap(0.8f, result, 753, 427, 802, 446, "离开确定", Sleep);


                result = mFairy.findPic(new String[]{"Enter the battlefield.png", "other1.png", "know.png", "other2.png", "other3.png", "other4.png", "other6.png"});
                mFairy.onTap(0.8f, result, "other", Sleep);

                result = mFairy.findPic("other4.png");
                mFairy.onTap(0.8f, result, 576, 621, 600, 637, "搜索", Sleep);

                result = mFairy.findPic("other5.png");
                mFairy.onTap(0.8f, result, "进入捕获", Sleep);
                mFairy.onTap(0.8f, result, 749, 435, 786, 452, "进入捕获确定", Sleep);

                result = mFairy.findPic("arms.png");
                mFairy.onTap(0.8f, result, 251, 126, 266, 141, "选择武器", Sleep);
                mFairy.onTap(0.8f, result, 967, 608, 977, 618, "强化", Sleep);
                mFairy.onTap(0.8f, result, 1151, 52, 1168, 67, "关闭强化", Sleep);

                result = mFairy.findPic(442, 3, 1269, 513, "fork.png");
                LtLog.e("********" + picCount(0.8f, result, "叉"));
                if (picCount(0.8f, result, "叉") > 5) {
                    mFairy.onTap(0.8f, result, "关叉", Sleep);
                }
            }
        }.taskContent(mFairy, "新手引导");
    }

    public static int getAppCpuUsedPercent() {
        String[] cpuInfos = null;
        int AppCpuUsedPercent = -1;
        try {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                int uid = android.os.Process.myUid();
                int pid = android.os.Process.myPid();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        Runtime.getRuntime().exec("top -b -u " + uid + " -n 1 ").getInputStream()), 500);
                String load = reader.readLine();
                while (load != null) {
                    if (load.contains(String.valueOf(pid))) {
                        break;
                    }
                    load = reader.readLine();
                    //   LtLog.e("load111====="+load);
                }
                //    LtLog.e("load2222====="+load);
                reader.close();
                cpuInfos = load.split("\\s+");
              /*  for (int i=0;i<cpuInfos.length;i++){
                    LtLog.e("cpuInfos====="+cpuInfos[i]);
                }*/
                AppCpuUsedPercent = Double.valueOf(cpuInfos[9]).intValue();
                // LtLog.e("AppCpuUsedPercent====="+AppCpuUsedPercent);
                AppCpuUsedPercent = ((AppCpuUsedPercent * 100) / 600);
            } else {
                int pid = android.os.Process.myPid();
                int uid = android.os.Process.myUid();
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        Runtime.getRuntime().exec("top -n 1").getInputStream()), 500);
                String load = reader.readLine();
                while (load != null) {
                    if (load.contains(String.valueOf(pid))) {
                        break;
                    }
                    load = reader.readLine();
                }
                reader.close();
                cpuInfos = load.split("%");
                AppCpuUsedPercent = Integer.parseInt(cpuInfos[0].substring(cpuInfos[0].length() - 3).trim());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return AppCpuUsedPercent;
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("smOverGraph.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("In transmission.png");
        if (result.sim > 0.7f) {
            LtLog.e(mFairy.getLineInfo("传送中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("road.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "complete.png");
        mFairy.onTap(0.8f, result, "完成", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "accept.png");
        mFairy.onTap(0.8f, result, "接受", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }

    public void teacher() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("smExperience.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 7) {
                    mFairy.initMatTime();
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("put.png");
                mFairy.onTap(0.8f, result, "普通", Sleep);
                result = mFairy.findPic(46, 177, 274, 469, "leftshimen.png");
                mFairy.onTap(0.8f, result, "左侧师门", Sleep);

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f, result, "手", 5000);

                result = mFairy.findPic("Hangup1.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    mFairy.initMatTime();
                    err = 0;
                }
             /*   result =mFairy.findPic(340,223,927,624,"smSure.png");
                mFairy.onTap(0.8f,result,"师门确认",Sleep);*/
            }
        }.taskContent(mFairy, "师门任务中");
    }//师门

    public void tianming() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("tmChallenge.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
             /*  long dazeTime=mFairy.mMatTime(1215,128,61,16,0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间="+dazeTime));
                if (dazeTime>10){
                    result =mFairy.findPic("Replica.png");
                    mFairy.onTap(148,215,164,224,"副本中点左侧任务",3000);

                    result =mFairy.findPic(1099,277,1173,348,"NoBattle.png");
                    mFairy.onTap(0.8f,result,"开启自动战斗",Sleep);
                }*/
                result = mFairy.findPic("Replica.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("Hangup1.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("xuetiao.png");
                        if (picCountS(0.8f, result, "血条") > 5) {
                            mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", 3000);
                        }
                    } else {
                        mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", 3000);
                        while (mFairy.condit()) {
                            super.inOperation();
                            long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                            LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                            if (dazeTime > 3) {
                                mFairy.initMatTime();
                                result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                                mFairy.onTap(0.8f, result, "开启自动战斗", Sleep);
                                break;
                            }
                        }
                    }
                }

                result = mFairy.findPic("tminface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("天命界面"));

                    if (AtFairyConfig.getOption("tmtz").equals("1")) {
                        mFairy.onTap(0.8f, result, 214, 320, 240, 332, "万劫窟", Sleep);
                    }
                    if (AtFairyConfig.getOption("tmtz").equals("2")) {
                        mFairy.onTap(0.8f, result, 464, 329, 492, 346, "封魔阵", Sleep);
                    }
                    if (AtFairyConfig.getOption("tmtz").equals("3")) {
                        mFairy.onTap(0.8f, result, 714, 325, 748, 355, "厉山丘", Sleep);
                    }
                    if (AtFairyConfig.getOption("tmtz").equals("4")) {
                        mFairy.onTap(0.8f, result, 1033, 328, 1070, 353, "共工雏", Sleep);
                    }
                }
                result = mFairy.findPic("tmEnterCopy.png");
                mFairy.onTap(0.8f, result, "进入副本", Sleep);


                result = mFairy.findPic(665, 596, 837, 656, "tmleave.png");
                mFairy.onTap(0.8f, result, "天命离开", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(340, 223, 927, 624, "smSure.png");
                mFairy.onTap(0.8f, result, "天命确认", Sleep);
            }
        }.taskContent(mFairy, "天命挑战任务中");
    } //天命

    public void tongtianta() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("ttPagoda.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic("ttSweep.png");
                mFairy.onTap(0.8f, result, "一键扫荡", Sleep);
                mFairy.onTap(0.8f, result, 753, 431, 790, 446, "一键扫荡确定", 10000);
                setTaskName(3);
                return;
            }

            public void content_3() throws Exception {
                result = mFairy.findPic("zddzgc.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("已达到最高层"));
                    setTaskEnd();
                }
                result1 = mFairy.findPic(206, 117, 583, 660, "sdstop0.png");
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic("ttReset.png");
                    if (result.sim < 0.8f) {
                        mFairy.onTap(0.8f, result1, 1013, 617, 1066, 639, "扫荡完毕开始挑战", Sleep);
                    } else {
                        LtLog.e(mFairy.getLineInfo("重置本层通天塔结束"));
                        setTaskEnd();
                    }
                }


                result = mFairy.findPic("Replica.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                    mFairy.onTap(0.8f, result, "开启自动战斗", Sleep);
                }
                result = mFairy.findPic(876, 601, 1040, 652, "Continue.png");
                mFairy.onTap(0.8f, result, "继续挑战", Sleep);

                result = mFairy.findPic(644, 618, 818, 681, "Continue1.png");
                mFairy.onTap(0.8f, result, "继续挑战", Sleep);

                result = mFairy.findPic("ttSure.png");
                mFairy.onTap(0.8f, result, "只剩一次机会确定", Sleep);

                result = mFairy.findPic(856, 596, 1094, 653, "ttChallengeAgain.png");
                mFairy.onTap(0.8f, result, "再次挑战", Sleep);

                result = mFairy.findPic(856, 596, 1094, 653, "ttChallengeAgain2.png");
                mFairy.onTap(0.9f, result, 716, 619, 748, 633, "没有再次挑战了离开", Sleep);
                if (result.sim > 0.9f) {
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy, "通天塔任务中");
    }//通天塔

    public void keju() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("kjExamination.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic("kjStartAnswer.png");
                mFairy.onTap(0.8f, result, "开始答题", Sleep);

                result = mFairy.findPic(new String[]{"kjAnswerAA.png", "kjAnswerAA1.png"});
                mFairy.onTap(0.8f, result, 632, 279, 664, 290, "选A", 3000);

                result = mFairy.findPic("kjSignOut.png");
                mFairy.onTap(0.8f, result, "答题退出", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                }

                overtime(10, 0);
            }
        }.taskContent(mFairy, "科举乡试任务中");
    }//科举乡试

    public void visit() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("Visit.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            int count = 0;

            /*
             * 1、71,264   2、78,267  3、90,269 4、97,269 5、104,269 6、112,269
             * 7、112,245  8、105,245  9、98,245 10、90,246 11、78,248 12、70,250
             * */
            public void content_2() throws Exception {
                if (count == 0) {
                    gameUtil.coordinate("轩辕", 71, 264);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(419, 177, 431, 189, "选雕像", 2000);
                }
                if (count == 1) {
                    gameUtil.coordinate("轩辕", 78, 267);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(445, 167, 460, 179, "选雕像1", 2000);
                }
                if (count == 2) {
                    gameUtil.coordinate("轩辕", 90, 269);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(520, 177, 531, 186, "选雕像2", 2000);
                }
                if (count == 3) {
                    gameUtil.coordinate("轩辕", 97, 269);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(532, 175, 549, 192, "选雕像3", 2000);
                }
                if (count == 4) {
                    gameUtil.coordinate("轩辕", 104, 269);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(500, 174, 518, 188, "选雕像4", 2000);
                }
                if (count == 5) {
                    gameUtil.coordinate("轩辕", 112, 269);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(538, 163, 555, 176, "选雕像5", 2000);
                }
                if (count == 6) {
                    gameUtil.coordinate("轩辕", 112, 245);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(731, 209, 741, 218, "选雕像6", 2000);
                }
                if (count == 7) {
                    gameUtil.coordinate("轩辕", 105, 245);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(742, 184, 751, 193, "选雕像7", 2000);
                }
                if (count == 8) {
                    gameUtil.coordinate("轩辕", 98, 245);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(723, 170, 734, 181, "选雕像8", 1000);
                }
                if (count == 9) {
                    gameUtil.coordinate("轩辕", 90, 246);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(784, 221, 792, 232, "选雕像9", 1000);
                }
                if (count == 10) {
                    gameUtil.coordinate("轩辕", 78, 248);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(799, 205, 810, 217, "选雕像10", 1000);
                }
                if (count == 11) {
                    gameUtil.coordinate("轩辕", 70, 250);
                    result = mFairy.findPic("visualAngle.png");
                    mFairy.onTap(0.8f, result, "锁定视角", Sleep);
                    mFairy.onTap(791, 243, 805, 254, "选雕像11", 1000);
                }
                if (count == 12) {
                    LtLog.e(mFairy.getLineInfo("参拜完毕"));
                    setTaskEnd();
                    return;
                }
                count++;
                setTaskName(3);
                return;
            }

            int stopCount = 0;

            public void content_3() throws Exception {
                if (overtime(6, 2)) return;
                result = mFairy.findPic(38, 361, 361, 593, "leftVisit.png");
                mFairy.onTap(0.8f, result, "左侧参拜一下", Sleep);
                if (result.sim > 0.8f) {
                    stopCount++;
                    if (stopCount >= 3) {
                        LtLog.e(mFairy.getLineInfo("参拜完毕"));
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "雕像参拜任务中");
    }//雕像参拜

    public void jgly() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);

                result = mFairy.findPic("put.png");
                mFairy.onTap(0.8f, result, "普通", Sleep);

                result = mFairy.findPic(18, 116, 532, 607, "Leftjg.png");
                mFairy.onTap(0.8f, result, "左侧建功", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 76, 429, 76, 245, 500, 1500, 2);
                if (overtime(8, 2)) return;
            }

            public void content_2() throws Exception {
                int ret = gameUtil.mission("jgbuy.png", 1);
                if (ret == 1) {
                    setTaskName(3);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 30) {
                    mFairy.initMatTime();
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic(575, 98, 711, 233, "bagM.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("背包满了结束"));
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(18, 116, 532, 607, "jgly.png");
                mFairy.onTap(0.8f, result, "左侧建功立业", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                }
                Thread.sleep(2000);
            }
        }.taskContent(mFairy, "建工立业任务中");
    }//建工立业

    public void xmqf() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("Praying.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic("xmqfLower.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("祈福界面"));
                  /*  String string =AtFairyConfig.getOption("qifu");
                    String string1 =AtFairyConfig.getOption("tm");
                    LtLog.e(mFairy.getLineInfo("string="+string));
                    LtLog.e(mFairy.getLineInfo("string1="+string1));
                    LtLog.e(mFairy.getLineInfo("string="+string.equals("1")));
                    LtLog.e(mFairy.getLineInfo("string1="+string1.equals("2")));*/
                    if (AtFairyConfig.getOption("qifu").equals("1")) {
                        mFairy.onTap(0.8f, result, 540, 512, 570, 523, "低级祈福", Sleep);
                    }
                    if (AtFairyConfig.getOption("qifu").equals("2")) {
                        mFairy.onTap(0.8f, result, 711, 510, 740, 524, "中级祈福", Sleep);
                    }
                    if (AtFairyConfig.getOption("qifu").equals("3")) {
                        mFairy.onTap(0.8f, result, 889, 510, 924, 527, "高级祈福", Sleep);
                    }
                }
                result = mFairy.findPic("xmqfCompleted.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("祈福完成"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "血盟祈福任务中");
    } //血盟祈福

    public void cbt() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("btMap.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                overtime(10, 0);
               /* result = mFairy.findPic(23, 31, 1248, 690, "xmqjUse.png");
                mFairy.onTap(0.8f, result, "使用", Sleep);*/

                result = mFairy.findPic(23, 31, 1248, 690, "noMap.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("没有藏宝图了"));
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(665, 599, 839, 654, "cbtfblk.png");
                mFairy.onTap(0.8f, result, "藏宝图副本离开", Sleep);

                result = mFairy.findPic(846, 450, 1060, 548, "btNowUse.png");
                mFairy.onTap(0.8f, result, "立即使用", Sleep);
                if (result.sim < 0.8f) {
                    result = mFairy.findPic(601, 145, 1133, 530, new String[]{"luo.png", "cbt.png", "cbt1.png"});// 1065 257   895,351
                    mFairy.onTap(0.8f, result, "藏宝图", Sleep);
                    //mFairy.onTap(0.8f, result, result.x-170,result.y+94,result.x-169,result.y+95,"藏宝图", Sleep);
                    if (result.sim > 0.8f) {
                        err = 0;
                    }
                } else {
                    err = 0;
                }
                result = mFairy.findPic(43, 116, 830, 625, new String[]{"seniorcb.png", "seniorcb2.png"});//537,259   900,351
                mFairy.onTap(0.8f, result, result.x + 363, result.y + 92, result.x + 364, result.y + 93, "使用", Sleep);


                result = mFairy.findPic("Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    result = mFairy.findPic("Hangup1.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("xuetiao.png");
                        if (picCountS(0.8f, result, "血条") > 5) {
                            mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", 3000);
                        }
                    } else {
                        mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", 3000);
                        while (mFairy.condit()) {
                            super.inOperation();
                            long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                            LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                            if (dazeTime > 3) {
                                mFairy.initMatTime();
                                result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                                mFairy.onTap(0.8f, result, "开启自动战斗", Sleep);
                                break;
                            }
                        }
                    }
                }
            }
        }.taskContent(mFairy, "藏宝图任务中");
    }//藏宝图

    public void szcbt() throws  Exception{
        new GameUtil(mFairy){
            int err1 = 0;
            @Override
            public void content_0() throws Exception {

                setTaskName(1);
                return;
            }
            public void content_1() throws Exception{
                close(0);

                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1071, 110, 1087, 121, "打开背包", 3000);
                result = mFairy.findPic("baginface.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 632, 96, 663, 111, "背包界面内", Sleep);
                    result = mFairy.findPic(600, 146, 1137, 529, "szbz.png");
                    if (result.sim >= 0.8f) {
                        mFairy.onTap(0.8f, result, "点击氏族宝藏图", 2000);
                        result = mFairy.findPic(434, 115, 1275, 703, "sy.png");
                        mFairy.onTap(0.8f, result, "使用氏族宝藏图", 2000);
                        err1 = 0;
                        setTaskName(2);
                        return;
                    } else {
                        LtLog.e("没找到滑动第" + err + "次");
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(1030, 336, 703, 336, 300, Sleep);
                        err1++;
                    }
                    if (err1 <= 8) {
                        close(0);
                        setTaskEnd();
                        return;
                    }
                }
            }
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                result = mFairy.findPic(362, 163, 1084, 612, "qr.png");
                mFairy.onTap(0.8f, result, "确认", Sleep);

                result = mFairy.findPic(362, 163, 1084, 612, "ljsy.png");
                mFairy.onTap(0.8f, result, "立即使用", Sleep);

                result = mFairy.findPic(478, 120, 806, 203, "bbm.png");
                if (result.sim > 0.7f) {
                    LtLog.e("背包满清包");
                    clearBag();
                }
                result = mFairy.findPic("Replica.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    result = mFairy.findPic("Hangup1.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("xuetiao.png");
                        if (picCountS(0.8f, result, "血条") > 5) {
                            mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", 3000);
                        }
                    } else {
                        mFairy.onTap(148, 215, 164, 224, "副本中点左侧任务", 3000);
                        while (mFairy.condit()) {
                            super.inOperation();
                            if (dazeTime > 3) {
                                mFairy.initMatTime();
                                result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                                mFairy.onTap(0.8f, result, "开启自动战斗", Sleep);
                                break;
                            }
                        }
                    }
                }
                if (dazeTime > 60) {
                    setTaskName(1);
                    return;
                }
            }
        }.taskContent(mFairy,"氏族藏宝图");
    }//氏族藏宝图

    public void xmrw() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);

                result = mFairy.findPic(18, 116, 532, 607, "leftxmrw.png");
                mFairy.onTap(0.95f, result, "左侧血盟任务", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 119, 423, 116, 245, 500, 1500, 2);
                if (overtime(8, 2)) return;
            }

            public void content_2() throws Exception {
                int ret = gameUtil.mission("xmrw.png", 1);
                if (ret == 1) {
                    setTaskName(3);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 10) {
                    mFairy.initMatTime();
                    gameUtil.close(1);
                    setTaskName(4);
                    return;
                }
              /*  result = mFairy.findPic(18, 116, 532, 607, "leftxmrw.png");
                if (result.sim > 0.8f){

                }else {
                    setTaskName(1);return;
                }*/
                result = mFairy.findPic("Nosdl.png");
                mFairy.onTap(0.8f, result, 491, 424, 545, 451, "没有扫荡令了", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("xmrwwc.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                    err = 0;
                }
                result = mFairy.findPic(new String[]{"xmrwjs.png", "jieshou.png"});
                mFairy.onTap(0.8f, result, "接受", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                    err = 0;
                }
                result = mFairy.findPic(561, 563, 1158, 670, "qwhq.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("前往获取没有材料了跳过"));
                    result = mFairy.findPic(561, 563, 1158, 670, "tiaoguo.png");
                    mFairy.onTap(0.8f, result, "跳过本环", Sleep);
                    mFairy.onTap(0.8f, result, 362, 364, 376, 376, "跳过本环", Sleep);
                    mFairy.onTap(0.8f, result, 758, 455, 792, 476, "跳过本环", Sleep);
                }

                result = mFairy.findPic("tjcl.png");
                mFairy.onTap(0.8f, result, 668, 612, 687, 628, "提交材料", Sleep);
                mFairy.onTap(0.8f, result, 168, 108, 191, 125, "提交材料", Sleep);
                mFairy.onTap(0.8f, result, "提交材料", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                    err = 0;
                }

                result = mFairy.findPic("Lazy.png");
                mFairy.onTap(0.8f, result, 636, 430, 648, 439, "想偷懒", Sleep);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("新号做联盟任务不能跳过导致卡任务给停止"));
                    setTaskEnd();
                    return;
                }
            }

            public void content_4() throws Exception {
                if (overtime(20, 0)) return;
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.9f, result, 15, 234, 29, 262, "在任务栏打开任务框", Sleep);

                result = mFairy.findPic("yijie.png");
                mFairy.onTap(0.9f, result, "打开已接任务", Sleep);

                result = mFairy.findPic(483, 558, 1095, 677, "tiaoguo.png");
                mFairy.onTap(0.8f, result, "跳过本环", Sleep);
                mFairy.onTap(0.8f, result, 362, 364, 376, 376, "跳过本环", Sleep);
                mFairy.onTap(0.8f, result, 758, 455, 792, 476, "跳过本环", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }


            }

        }.taskContent(mFairy, "血盟任务中");
    } //血盟任务

    public void szmt() throws Exception {
        new SingleTask(mFairy) {
            int mtCount = 0;

            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                result = mFairy.findPic("task common.png");
                mFairy.onTap(0.95f, result, "任务栏初始化", Sleep);

                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"outer space1.png", "twsh_inface2.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有天外山海图标"));
                        mFairy.initMatTime();
                        setTaskName(1);
                        return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("bag2.png");
                mFairy.onTap(0.9f, result, 1189, 44, 1203, 51, "背包关闭", Sleep);
                /*result=mFairy.findPic("me.png");
                mFairy.onTap(0.9f,result,1109,45,1116,58,"关闭",Sleep);*/

                LtLog.e("-----------==" + mtCount);
                result = mFairy.findPic("task team.png");
                mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);

                /*result=mFairy.findPic("shizu.png");
                mFairy.onTap(0.95f, result, 178,195,201,211,"氏族栏暗点切换到氏族栏", Sleep);
                if (result.sim > 0.95){
                    mFairy.initMatTime();
                }*/


                result = mFairy.findPic("jqmt.png");
                mFairy.onTap(0.8f, result, "接取密探任务", Sleep);

                result = mFairy.findPic("mtjf.png");
                mFairy.onTap(0.8f, result, "交付密探任务", Sleep);
              /*  if (result.sim > 0.8f){
                    mFairy.initMatTime();
                }*/

                result = mFairy.findPic(6, 245, 1194, 484, "death.png");
                mFairy.onTap(0.8f, result, "复活", Sleep);

                result = mFairy.findPic("sqqb.png");
                mFairy.onTap(0.8f, result, "索取情报", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                }
                result = mFairy.findPic("skip.png");
                mFairy.onTap(0.8f, result, "err跳过", Sleep);

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                if (dazeTime > 5 && dazeTime < 50) {

                    result = mFairy.findPic("shizu.png");
                    mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                    result2 = mFairy.findPic(231, 366, 284, 482, new String[]{"wc.png", "jf.png"});
                    LtLog.e("左侧密探任务二阶段相似度 判定是否点击 大于0.8不进入" + result2.sim);
                    if (result2.sim < 0.8f) {
                        result2 = mFairy.findPic(52, 223, 201, 496, new String[]{"yxmt.png", "yxmt1.png", "yxmt3.png", "yxmt4.png", "yxmt5.png", "yxmt6.png", "yxmt7.png", "yxmt8.png", "yxmt9.png"});
                        LtLog.e("左侧密探任务相似度 大约0.8点击" + result2.sim);
                        mFairy.onTap(0.65f, result2, "左侧隐形密探", 3000);
                    }
                    result3 = mFairy.findPic(50,226,134,427, new String[]{"4.png", "rwqd.png"});
                    /*result3 = mFairy.findPic(52, 339, 220, 391, new String[]{"qb.png", "qb2.png"});*/
                    if (result3.sim > 0.8f) {
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(200, 300, 200, 400, 300, Sleep);
                    }else {
                        result = mFairy.findPic(44, 214, 199, 315, new String[]{"yxmt.png", "yxmt1.png", "yxmt4.png", "yxmt3.png", "yxmt6.png", "yxmt5.png", "yxmt7.png", "yxmt8.png", "yxmt9.png"});
                        LtLog.e("左侧密探任务滑动前相似度" + result.sim);
                        result1 = mFairy.findPic("shizu.png");
                        if (result.sim < 0.65f && result1.sim > 0.8f) {
                            LtLog.e("滑动=====");
                            mFairy.ranSwipe(200, 460, 200, 200, 300, Sleep);
                        }
                        LtLog.e("滑动识别---" + result.sim);
                    }
               /* result=mFairy.findPic(new String[]{"shizu.png","shizu2.png"});
                mFairy.onTap(0.8f, result, "氏族栏", Sleep);*/
                    result = mFairy.findPic(39, 215, 233, 345, new String[]{"yxmt.png", "yxmt1.png"});//47, 221, 274, 399
                    LtLog.e("前往识别---" + result.sim);
                    // mFairy.onTap(0.7f, result, "左侧隐形密探", Sleep);
                    if (result.sim > 0.7f) {
                        result1 = mFairy.findPic(52, 213, 261, 435, new String[]{"mi.png", "mi2.png", "mi3.png", "mi4.png"});
                        if (result1.sim > 0.7f) {
                            //84,277   246,366,286,391  242,389,289,418                               243,439,290,468
                            result2 = mFairy.findPic(result.x + 160, result.y + 89, result.x + 205, result.y + 114, "wc.png");
                            if (result2.sim > 0.8f && mtCount == 0) {
                                mtCount++;
                            }
                            result2 = mFairy.findPic(result.x + 160, result.y + 112, result.x + 205, result.y + 141, "wc.png");
                            if (result2.sim > 0.8f && mtCount == 1) {
                                mtCount++;
                            }
                            result2 = mFairy.findPic(result.x + 160, result.y + 138, result.x + 205, result.y + 168, "wc.png");
                            if (result2.sim > 0.8f && mtCount == 2) {
                                mtCount++;
                            }
                            result2 = mFairy.findPic(result.x + 160, result.y + 162, result.x + 205, result.y + 191, "wc.png");
                            if (result2.sim > 0.8f && mtCount == 3) {
                                mtCount++;
                            }

                            if (mtCount >= 4) {
                                mtCount = 0;
                            }

                            if (mtCount == 0) {
                                mFairy.onTap(0.7f, result, result.x + 170, result.y + 102, result.x + 171, result.y + 103, "第1个前往", Sleep);
                            }
                            if (mtCount == 1) {
                                mFairy.onTap(0.7f, result, result.x + 170, result.y + 125, result.x + 171, result.y + 128, "第2个前往", Sleep);
                            }
                            if (mtCount == 2) {
                                mFairy.onTap(0.7f, result, result.x + 170, result.y + 151, result.x + 171, result.y + 152, "第3个前往", Sleep);
                            }
                            if (mtCount == 3) {
                                mFairy.onTap(0.7f, result, result.x + 170, result.y + 173, result.x + 171, result.y + 174, "第4个前往", Sleep);
                            }

                            result3 = mFairy.findPic(530, 101, 772, 223, "szjk.png");
                            if (result3.sim < 0.8f) {
                                mFairy.onTap(0.8f, result3, 1024, 133, 1033, 144, "关闭", 1000);
                                LtLog.e("滑动=====");
                                mFairy.ranSwipe(200, 300, 200, 380, 300, Sleep);
                                LtLog.e("滑动=====");
                                mFairy.ranSwipe(200, 300, 200, 380, 300, Sleep);
                                LtLog.e("滑动=====");
                                mFairy.ranSwipe(200, 300, 200, 380, 300, Sleep);
                            }
                        }
                    }
                }
                if (dazeTime > 50) {
                    mtCount++;
                    if (mtCount >= 4) {
                        mtCount = 0;
                    }
                }

                if (dazeTime > 60) {
                    mFairy.initMatTime();
                    gameUtil.close(0);
                    result = mFairy.findPic(43, 201, 212, 496, new String[]{"yxmt.png", "yxmt1.png", "yxmt4.png", "yxmt3.png", "yxmt6.png", "yxmt5.png", "yxmt7.png", "yxmt8.png", "yxmt9.png"});
                    LtLog.e("结束识别---" + result.sim);
                    result1 = mFairy.findPic("shizu.png");
                    result2 = mFairy.findPic("bianjing3.png");
                    result3 = mFairy.findPic(38, 201, 247, 292, new String[]{"jiancai.png", "jiancai3.png", "jiancai4.png"});
                    LtLog.e("/*result=/" + result.sim + ",result1" + result1 + "result3" + result3);
                    if (result.sim < 0.7f && result1.sim > 0.8f && result3.sim < 0.7f) {
                        LtLog.e(mFairy.getLineInfo("左侧没有密探结束"));
                        // setTaskEnd();
                        setTaskName(3);
                        return;
                    } else if (result2.sim > 0.8f) {
                        setTaskName(2);
                        return;
                        //setTaskName(0);return;
                    }
                } else {

                }
            }

            public void content_2() throws Exception {
                if (overtime(4, 0)) return;
                result = mFairy.findPic(52, 18, 1225, 670, "delivery2.png");
                mFairy.onTap(0.8f, result, result.x + 2, result.y + 153, result.x + 3, result.y + 154, "点击传送使者", Sleep);
                if (result.sim < 0.8f) {
                    if (result.sim < 0.8f) {
                        mFairy.onTap(1199, 89, 1206, 99, "地图", Sleep);
                        mFairy.onTap(579, 505, 582, 510, "地图", Sleep);
                        mFairy.onTap(1243, 46, 1250, 54, "地图", Sleep);
                    }
                }

                result = mFairy.findPic("deliveryyes.png");
                mFairy.onTap(0.8f, result, "传送", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                }
            }

            public void content_3() throws Exception {
                int ret = gameUtil.mission("yxmt2.png", 1);
                if (ret == 1) {
                    setTaskName(0);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "氏族密探任务中");
    } //氏族密探

    public void mqtc() throws Exception {
        new SingleTask(mFairy) {
            int mtCount = 0;

            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                result = mFairy.findPic("task common.png");
                mFairy.onTap(0.95f, result, "任务栏初始化", Sleep);

                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"outer space1.png", "twsh_inface2.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有天外山海图标"));
                        mFairy.initMatTime();
                        setTaskName(1);
                        return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("bag2.png");
                mFairy.onTap(0.9f, result, 1189, 44, 1203, 51, "背包关闭", Sleep);
                result = mFairy.findPic("me.png");
                mFairy.onTap(0.9f, result, 1109, 45, 1116, 58, "关闭", Sleep);

                LtLog.e("-----------==" + mtCount);

                result = mFairy.findPic("task team.png");
                mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);

                if (result.sim > 0.95) {
                    mFairy.initMatTime();
                }

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                if (dazeTime > 5) {

                    result = mFairy.findPic("shizu.png");
                    mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                    result = mFairy.findPic("jqmq.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "接取魔气探查任务", Sleep);

                    }
                    result1 = mFairy.findPic(52, 213, 261, 435, new String[]{"moqi.png", "moqi2.png", "mq.png", "jhqw.png", "jhhc.png", "yz.png", "mqdctj2.png"});
                    if (result1.sim > 0.8f) {
                        mFairy.initMatTime();
                        setTaskName(2);
                        return;
                    }


                    result = mFairy.findPic(50, 226, 203, 325, new String[]{"mqtc.png", "mqtc1.png"});
                    result1 = mFairy.findPic(44, 227, 261, 494, new String[]{"mqdctj2.png", "mqdctj3.png"});
                    if (result.sim > 0.75f && result1.sim < 0.8f) {
                        mFairy.onTap(0.75f, result, "左侧魔气探查", 3000);
                        mFairy.initMatTime();
                    }
                }
                if (dazeTime > 40 && dazeTime < 50) {
                    result = mFairy.findPic(1059, 17, 1218, 114, "gc.png");
                    mFairy.onTap(0.95f, result, "不知道什么遮挡", Sleep);

                }
                if (dazeTime > 50) {
                    setTaskName(2);
                }

            }

            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                /*result = mFairy.findPic("mtjf.png");
                mFairy.onTap(0.8f, result, "交付密探任务", Sleep);
                if (result.sim > 0.8f){
                    mFairy.initMatTime();
                }*/

                result = mFairy.findPic(6, 245, 1194, 484, "death.png");
                mFairy.onTap(0.8f, result, "复活", Sleep);

                result = mFairy.findPic("skip.png");
                mFairy.onTap(0.8f, result, "err跳过", Sleep);

                result = mFairy.findPic(44, 227, 261, 494, "mqdctj2.png");
                mFairy.onTap(0.7f, result, "任务栏魔气调查提交", 5000);

                result = mFairy.findPic(42, 359, 506, 498, "mqdctj.png");
                mFairy.onTap(0.7f, result, "魔气调查提交", 5000);

                result = mFairy.findPic(557, 531, 726, 591, "shangjiao01.png");
                mFairy.onTap(0.7f, result, 630, 555, 657, 566, "上缴晶核", 5000);

                if (dazeTime > 5 && dazeTime < 10) {
                    result2 = mFairy.findPic(810, 260, 913, 377, "cz.png");
                    mFairy.onTap(0.7f, result2, 867, 306, 878, 323, "操作", 5000);
                }

                if (dazeTime > 10) {

                    result = mFairy.findPic("shizu.png");
                    mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                    result = mFairy.findPic(50, 226, 203, 325, new String[]{"mqtc.png", "mqtc1.png"});
                    if (result.sim > 0.7f) {

                        result1 = mFairy.findPic(52, 213, 261, 435, new String[]{"moqi.png", "moqi2.png", "mq.png", "jhqw.png", "jhhc.png", "yz.png"});
                        if (result1.sim > 0.7f) {

                            result2 = mFairy.findPic(1125, 0, 1278, 145, new String[]{"dt.png", "ld.png"});
                            mFairy.onTap(0.7f, result2, 1188, 76, 1214, 101, "打开地图", 3000);


                            result2 = mFairy.findPic(271, 117, 613, 569, "dtmq.png");
                            if (result2.sim > 0.7f) {
                                mFairy.onTap(0.7f, result2, "寻找魔气", 3000);
                                mFairy.initMatTime();
                            }

                            result2 = mFairy.findPic(1234, 34, 1262, 64, "gc.png");
                            mFairy.onTap(0.7f, result2, "关闭地图", 3000);

                        }
                    }
                }
                if (dazeTime > 60) {
                    mFairy.initMatTime();
                    gameUtil.close(0);

                    result = mFairy.findPic("rwl.png");
                    mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);

                    result = mFairy.findPic("shizu.png");
                    mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                    result = mFairy.findPic(50, 226, 203, 325, new String[]{"mqtc.png", "mqtc1.png"});
                    LtLog.e("结束识别---" + result.sim);
                    if (result.sim < 0.7f) {
                        LtLog.e(mFairy.getLineInfo("左侧没有魔气结束"));
                        setTaskEnd();
                        return;
                    } else {
                        setTaskName(2);
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "魔气探查任务中");
    } //魔气探查

    public void jlzm() throws Exception {
        new SingleTask(mFairy) {
            int mtCount = 0;
            int sum = 0;

            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                result = mFairy.findPic("task common.png");
                mFairy.onTap(0.95f, result, "任务栏初始化", Sleep);

                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"outer space1.png", "twsh_inface2.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有天外山海图标"));
                        mFairy.initMatTime();
                        setTaskName(1);
                        return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_1() throws Exception {

                result = mFairy.findPic(6, 245, 1194, 484, "death.png");
                mFairy.onTap(0.8f, result, "复活", Sleep);

                result = mFairy.findPic("bag2.png");
                mFairy.onTap(0.9f, result, 1189, 44, 1203, 51, "背包关闭", Sleep);


                result = mFairy.findPic("me.png");
                mFairy.onTap(0.9f, result, 1109, 45, 1116, 58, "关闭", Sleep);

                LtLog.e("-----------==" + mtCount);

                result = mFairy.findPic("task team.png");
                mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);

                if (result.sim > 0.95) {
                    mFairy.initMatTime();
                }

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                if (dazeTime > 5) {

                    result = mFairy.findPic("shizu.png");
                    mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                    result = mFairy.findPic(51, 227, 295, 333, new String[]{"jlzm1.png"});
                    result1 = mFairy.findPic(47, 312, 285, 504, new String[]{"jlzmqw1.png"});
                    if (result.sim > 0.75f && result1.sim < 0.75f) {
                        mFairy.onTap(0.75f, result, "左侧九黎之谜", Sleep);
                    }

                    result = mFairy.findPic(51, 227, 295, 333, new String[]{"jlzm1.png"});
                    result1 = mFairy.findPic(47, 312, 285, 504, new String[]{"zctj.png"});
                    if (result.sim > 0.75f && result1.sim < 0.75f) {
                        mFairy.onTap(0.75f, result, "左侧九黎之谜", Sleep);

                        result = mFairy.findPic("jlzmtj.png");
                        mFairy.onTap(0.7f, result, 228, 409, 304, 433, "九黎之谜任务完成", 5000);

                        result = mFairy.findPic("wcrw.png");
                        if (result.sim > 0.75f) {
                            mFairy.onTap(0.7f, result, 244, 554, 286, 571, "九黎之谜任务完成", 5000);
                            setTaskEnd();
                            return;
                        }
                    }

                    result = mFairy.findPic(51, 227, 295, 333, new String[]{"jlzm1.png"});
                    if (result.sim > 0.75f) {
                        result = mFairy.findPic(47, 312, 285, 504, new String[]{"jlzmqw1.png"});
                        mFairy.onTap(0.9f, result, "前往接取任务", 1000);
                        mFairy.initMatTime();
                        result = mFairy.findPic(331, 78, 553, 210, new String[]{"yddjlc.png"});
                        if (result.sim > 0.75f) {
                            LtLog.e("已到达九黎城");
                            setTaskName(2);
                            return;
                        }

                    } else {
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(200, 460, 200, 300, 300, Sleep);
                        sum++;
                    }

                    result = mFairy.findPic("jlzmjq.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "接取九黎之谜任务", Sleep);

                        result = mFairy.findPic("jsrw.png");
                        mFairy.onTap(0.8f, result, "接受任务", Sleep);

                    }

                    result = mFairy.findPic("qwjlc.png");
                    if (result.sim > 0.75f) {
                        mFairy.onTap(0.9f, result, "前往九黎城", Sleep);
                        setTaskName(2);
                        return;
                    }
                    if (sum >= 5) {
                        sum = 0;
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(123, 247, 123, 490, 300, Sleep);
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(123, 247, 123, 490, 300, Sleep);
                    }

                }

                if (dazeTime > 60){
                    setTaskName(4);
                }
            }

            public void content_2() throws Exception {

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));

                /*result = mFairy.findPic("mtjf.png");
                mFairy.onTap(0.8f, result, "交付密探任务", Sleep);
                if (result.sim > 0.8f){
                    mFairy.initMatTime();
                }*/

                result = mFairy.findPic(6, 245, 1194, 484, "death.png");
                mFairy.onTap(0.8f, result, "复活", Sleep);

                result = mFairy.findPic("skip.png");
                mFairy.onTap(0.8f, result, "err跳过", Sleep);

                result2 = mFairy.findPic(810, 260, 913, 377, "cz.png");
                mFairy.onTap(0.7f, result2, 867, 306, 878, 323, "操作", 5000);

                result = mFairy.findPic("jlwc1.png");
                mFairy.onTap(0.8f, result, "九黎之谜提交前往", 5000);

                /**
                 *
                 */
                //result = mFairy.findPic(61, 378, 491, 582, "zctj.png");
                result = mFairy.findPic(50, 197, 293, 464, "zctj.png");
                if (result.sim > 0.7f) {
                    mFairy.onTap(0.7f, result, "九黎之谜提交前往", 8000);
                    setTaskName(3);
                    return;
                }
                result = mFairy.findPic("zdzd2.png");
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                }
                if (dazeTime > 4 && dazeTime < 10) {
                    result2 = mFairy.findPic("wkzd.png");
                    mFairy.onTap(0.7f, result2, 1129, 308, 1141, 315, "自动战斗", 5000);
                }
                if (dazeTime > 15) {

                    result2 = mFairy.findPic(1125, 0, 1278, 145, new String[]{"dt.png", "jlc2.png"});
                    mFairy.onTap(0.7f, result2, 1188, 76, 1214, 101, "打开地图", 3000);

                    mFairy.onTap(0.7f, result2, 396, 338, 400, 343, "九黎城中心", 3000);

                    result2 = mFairy.findPic(1234, 34, 1262, 64, "gc.png");

                    mFairy.onTap(0.7f, result2, "关闭地图", 15000);

                    mFairy.onTap(0.7f, result2, 1129, 308, 1141, 315, "自动战斗", 5000);
                    mFairy.initMatTime();

                }
                if (dazeTime > 60) {
                    setTaskName(1);
                    return;
                }
            }

            public void content_3() throws Exception {

                result = mFairy.findPic(50, 197, 293, 464, "zctj.png");
                mFairy.onTap(0.7f, result, "九黎之谜提交前往", 5000);

                result = mFairy.findPic("jlzmtj.png");
                mFairy.onTap(0.7f, result, 228, 409, 304, 433, "九黎之谜任务完成", 5000);

                result = mFairy.findPic("wcrw.png");
                mFairy.onTap(0.7f, result, 244, 554, 286, 571, "九黎之谜任务完成", 5000);

                Thread.sleep(2000);

                overtime(10, 99);
            }
            public void content_4() throws Exception {
                gameUtil.close(1);
                result = mFairy.findPic("task common.png");
                mFairy.onTap(0.95f, result, "任务栏初始化", Sleep);

                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"outer space1.png", "twsh_inface2.png"});

                    mFairy.onTap(0.8f, result, "有天外山海图标", Sleep);
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有天外山海图标"));

                        result1 = mFairy.findPic("shijian.png");
                        mFairy.onTap(0.8f, result1, "事件", 5000);

                        result = mFairy.findPic(417,74,605,147,"yiwancheng.png");
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("没有九黎任务"));
                            setTaskEnd();
                            return;
                        }else{
                            mFairy.onTap(0.8f, result1,490,95,502,106, "九黎", Sleep);

                            result1 = mFairy.findPic(505,544,1027,645,"qwjlzm.png");
                            mFairy.onTap(0.8f, result1, "前往九黎之谜", Sleep);

                            result = mFairy.findPic(362,109,919,242,"cncj.png");
                            if (result.sim > 0.8f) {
                                LtLog.e(mFairy.getLineInfo("没有九黎任务"));
                                setTaskEnd();
                                return;
                            }
                        }
                        setTaskName(1);
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "九黎之谜任务中");
    } //九黎之谜

    public void szzyzd() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {
                super.inOperation();

                result = mFairy.findPic("jfzyzd.png");
                mFairy.onTap(0.8f, result, "交付资源争夺任务", Sleep);
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("szzy").equals("1")) {
                        stopCount++;
                        if (stopCount >= 3) {
                            LtLog.e(mFairy.getLineInfo("完成3次结束"));
                            setTaskEnd();
                            return;
                        }
                    }
                }


                result = mFairy.findPic(7, 202, 1266, 491, new String[]{"death.png", "death2.png"});
                mFairy.onTap(0.85f, result, "复活", Sleep);
                if (result.sim > 0.8f) {
                    zyCount++;
                    if (zyCount > 4) {
                        zyCount = 0;
                    }

                    setTaskName(3);
                }
            }

            public void content_0() throws Exception {
                gameUtil.close(1);
                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"outer space1.png", "twsh_inface2.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有天外山海图标"));
                        setTaskName(1);
                        return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            int zyCount = 0, stopCount = 0;

            public void content_1() throws Exception {
                result = mFairy.findPic("bag2.png");
                mFairy.onTap(0.9f, result, 1192, 39, 1203, 53, "关闭背包", Sleep);

                result = mFairy.findPic("task team.png");
                mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);

                result = mFairy.findPic("task common.png");
                mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                result1 = mFairy.findPic(new String[]{"shizu.png", "shizu2.png"});
                mFairy.onTap(0.8f, result1, "氏族栏", Sleep);

                result = mFairy.findPic("anquan.png");
                result2 = mFairy.findPic("bianjing3.png");
                if (result2.sim > 0.8f && result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
                result = mFairy.findPic(47, 399, 274, 500, new String[]{"zyzd.png", "zyzd1.png"});
                if (result.sim > 0.7f) {
                    LtLog.e(mFairy.getLineInfo("资源争夺往上滑"));
                    mFairy.ranSwipe(200, 467, 200, 271, 500, 1000l, 1);
                    //return;
                }
                result = mFairy.findPic(47, 221, 274, 399, new String[]{"zyzd.png", "zyzd1.png"});
                if (picCountS(0.7f, result, "没有资源争夺") > 30) {
                    LtLog.e(mFairy.getLineInfo("没有资源争夺结束"));
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.7f, result, result.x + 172, result.y + 125, result.x + 173, result.y + 126, "左侧资源争夺", 5000);


                result = mFairy.findPic(377, 205, 444, 460, "zyzdqw.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("金库界面"));
                    LtLog.e(mFairy.getLineInfo("金库界面zyCount=" + zyCount));
                    if (zyCount == 0) {
                        result = mFairy.findPic(379, 214, 450, 259, "qwsz.png");
                        result2 = mFairy.findPic(266,215,326,260, "zd.png");
                        LtLog.e(mFairy.getLineInfo("if zyCount=0 result。sim=" + result.sim));
                        if (result.sim > 0.8f && result2.sim < 0.8f) {
                            mFairy.onTap(401, 229, 420, 239, "前往第一个", Sleep);
                            mFairy.onTap(1019, 130, 1036, 146, "关闭", Sleep);
                            setTaskName(2);
                            return;
                        } else {
                            zyCount++;
                        }
                    }
                    if (zyCount == 1) {
                        result = mFairy.findPic(382, 269, 440, 302, "qwsz.png");
                        result2 = mFairy.findPic(264,263,325,309, "zd.png");
                        if (result.sim > 0.8f  && result2.sim < 0.8f) {
                            mFairy.onTap(404, 278, 422, 290, "前往第2个", Sleep);
                            mFairy.onTap(1019, 130, 1036, 146, "关闭", Sleep);
                            setTaskName(2);
                            return;
                        } else {
                            zyCount++;
                        }
                    }
                    if (zyCount == 2) {
                        result = mFairy.findPic(385, 319, 438, 350, "qwsz.png");
                        result2 = mFairy.findPic(262,310,325,357, "zd.png");
                        if (result.sim > 0.8f && result2.sim < 0.8f) {
                            mFairy.onTap(405, 331, 420, 342, "前往第3个", Sleep);
                            mFairy.onTap(1019, 130, 1036, 146, "关闭", Sleep);
                            setTaskName(2);
                            return;
                        } else {
                            zyCount++;
                        }
                    }
                    if (zyCount == 3) {
                        result = mFairy.findPic(384, 366, 438, 401, "qwsz.png");
                        result2 = mFairy.findPic(262,360,325,405, "zd.png");
                        if (result.sim > 0.8f && result2.sim < 0.8f) {
                            mFairy.onTap(404, 377, 422, 389, "前往第4个", Sleep);
                            mFairy.onTap(1019, 130, 1036, 146, "关闭", Sleep);
                            setTaskName(2);
                            return;
                        } else {
                            zyCount++;
                        }
                    }
                    if (zyCount == 4) {
                        result = mFairy.findPic(386, 416, 442, 447, "qwsz.png");
                        result2 = mFairy.findPic(262,408,326,455, "zd.png");
                        if (result.sim > 0.8f && result2.sim < 0.8f) {
                            mFairy.onTap(401, 427, 423, 437, "前往第5个", Sleep);
                            mFairy.onTap(1019, 130, 1036, 146, "关闭", Sleep);
                            setTaskName(2);
                            return;
                        } else {
                            zyCount = 0;
                        }
                    }
                }
            }

            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 5) {
                    mFairy.initMatTime();
                    mFairy.ranSwipe(174, 572, 235, 545, 900, (long) 1000, 2);
                    setTaskName(4);
                    return;
                }
            }

            public void content_3() throws Exception {
                if (overtime(3, 1)) return;
                result2 = mFairy.findPic("bianjing3.png");
                if (result2.sim > 0.8f) {
                    result = mFairy.findPic(52, 18, 1225, 670, "delivery2.png");
                    mFairy.onTap(0.8f, result, result.x + 2, result.y + 153, result.x + 3, result.y + 154, "点击传送使者", Sleep);
                    if (result.sim < 0.8f) {
                        mFairy.ranSwipe(167, 571, 176, 684, 1500, 1000);
                    }

                    result = mFairy.findPic("deliveryyes.png");
                    mFairy.onTap(0.8f, result, "传送", Sleep);
                    if (result.sim > 0.8f) {
                        mFairy.initMatTime();
                    }
                }
            }

            public void content_4() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                result = mFairy.findPic("zys.png");
                mFairy.onTap(0.8f, result, "采集资源", Sleep);
                if (result.sim > 0.8f) {
                    result2 = mFairy.findPic(372,113,571,208, "zyjs.png");
                    result1 = mFairy.findPic(480, 72, 804, 201, "zjsz.png");
                    if (result1.sim > 0.8f || result2.sim > 0.8f) {
                        zyCount++;
                        if (zyCount > 4) {
                            zyCount = 0;
                        }
                        LtLog.e(mFairy.getLineInfo("无法采集"));
                        setTaskName(1);
                    } else {
                        Thread.sleep(8000);
                    }
                    mFairy.initMatTime();
                    if (AtFairyConfig.getOption("tie").equals("1") || (!AtFairyConfig.getOption("tie").equals("1") && !AtFairyConfig.getOption("tong").equals("1") && !AtFairyConfig.getOption("yin").equals("1") && !AtFairyConfig.getOption("jin").equals("1"))) {
                        setTaskName(1);
                        return;
                    }
                    if (AtFairyConfig.getOption("tong").equals("1")) {
                        result = mFairy.findPic(new String[]{"tong.png", "yin.png", "jin.png"});
                        if (result.sim > 0.8f) {
                            setTaskName(1);
                            return;
                        }
                    }
                    if (AtFairyConfig.getOption("yin").equals("1")) {
                        result = mFairy.findPic(new String[]{"yin.png", "jin.png"});
                        if (result.sim > 0.8f) {
                            setTaskName(1);
                            return;
                        }
                    }
                    if (AtFairyConfig.getOption("jin").equals("1")) {
                        result = mFairy.findPic("jin.png");
                        if (result.sim > 0.8f) {
                            setTaskName(1);
                            return;
                        }
                    }
                } else if (dazeTime > 60) {
                    setTaskName(1);
                    return;
                }


            }
        }.taskContent(mFairy, "氏族资源争夺中");
    } //氏族资源争夺

    public void mrjc() throws Exception {
        new SingleTask(mFairy) {
            int mtCount = 0;
            int stopCount = 0;

            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                result = mFairy.findPic("daily.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(699, 11, 1180, 264, new String[]{"outer space1.png", "twsh_inface2.png"});
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有天外山海图标"));
                        mFairy.initMatTime();
                        result = mFairy.findPic("put.png");
                        mFairy.onTap(0.8f, result, "普通", Sleep);
                        setTaskName(1);
                        return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("没有天外山海图标"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("bag2.png");
                mFairy.onTap(0.9f, result, 1189, 44, 1203, 51, "背包关闭", Sleep);

                LtLog.e("-----------==" + mtCount);
                result = mFairy.findPic("task team.png");
                mFairy.onTap(0.9f, result, 13, 233, 27, 257, "任务栏暗点切换到任务栏", Sleep);

                result = mFairy.findPic("task common.png");
                mFairy.onTap(0.95f, result, 178, 195, 201, 211, "氏族栏暗点切换到氏族栏", Sleep);

                result = mFairy.findPic(new String[]{"shizu.png", "shizu2.png"});
                mFairy.onTap(0.8f, result, "氏族栏", Sleep);

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 10) {
                    if (mtCount == 2) {

                        result = mFairy.findPic("moshi.png");
                        result1 = mFairy.findPic("peace.png");
                        if (result.sim > 0.8f && result1.sim < 0.8f) {
                            mFairy.onTap(0.8f, result, "切换下模式", Sleep);
                            mFairy.onTap(0.8f, result, 517, 148, 529, 155, "和平模式", Sleep);
                        }
                        result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                        mFairy.onTap(0.8f, result, 1121, 311, 1125, 316, "开启自动战斗", Sleep);
                    }
                }/*else {
                    result = mFairy.findPic("jiancai.png");
                    result1=mFairy.findPic("shizu.png");
                    if (result.sim < 0.7f && result1.sim >0.8f){
                        mFairy.ranSwipe(90,434,129,268,1000,1000);
                    }
                }*/

                result = mFairy.findPic(38, 201, 247, 292, new String[]{"jiancai.png", "jiancai3.png", "jiancai4.png"});
                LtLog.e("/*******asdf*********/" + result.sim);
                if (mtCount == 2) {

                } else {
                    mFairy.onTap(0.7f, result, "左侧建材密探", Sleep);
                }
                if (result.sim > 0.7f) {
                    // mFairy.initMatTime();
                    if (mtCount == 0) {
                        result = mFairy.findPic(230, 298, 280, 331, new String[]{"go.png", "go2.png"});
                        mFairy.onTap(0.7f, result, "第1个前往", Sleep);
                        result = mFairy.findPic(243, 297, 284, 328, "ok.png");
                        if (result.sim > 0.7f) {
                            mtCount++;
                        }
                    }
                    if (mtCount == 1) {
                        result = mFairy.findPic(225, 322, 281, 355, new String[]{"go.png", "go2.png"});
                        mFairy.onTap(0.7f, result, "第2个前往", Sleep);
                        result = mFairy.findPic(240, 321, 281, 349, "ok.png");
                        if (result.sim > 0.7f) {
                            mtCount++;
                        }
                    }
                    if (mtCount == 2) {
                        result2 = mFairy.findPic(1099, 277, 1173, 348, "Hangup1.png");
                        if (result2.sim > 0.8f) {

                        } else {
                            result = mFairy.findPic(230, 343, 282, 378, new String[]{"go.png", "go2.png"});
                            mFairy.onTap(0.7f, result, "第3个前往", Sleep);
                        }
                        result = mFairy.findPic(244, 342, 279, 373, "ok.png");
                        if (result.sim > 0.7f) {
                            mtCount = 0;
                        }
                    }

                }

                result = mFairy.findPic("zys.png");
                //mFairy.onTap(0.8f, result, "采集资源", Sleep);
                if (result.sim > 0.8f && dazeTime > 2) {
                    //mFairy.initMatTime();
                    setTaskName(3);
                    return;
                }
                result = mFairy.findPic("jiancai2.png");
                mFairy.onTap(0.8f, result, "接取任务", Sleep);

                result = mFairy.findPic("shangjiao2.png");
                mFairy.onTap(0.8f, result, "交付任务", Sleep);

                result = mFairy.findPic("shangjiao3.png");
                mFairy.onTap(0.8f, result, "上缴", Sleep);
                if (result.sim > 0.8f) {
                    mtCount = 0;
                    if (AtFairyConfig.getOption("two").equals("1")) {
                        stopCount++;
                        if (stopCount >= 2) {
                            LtLog.e(mFairy.getLineInfo("完成2次结束"));
                            setTaskEnd();
                            return;
                        }
                    }
                    if (AtFairyConfig.getOption("ten").equals("1")) {
                        stopCount++;
                        if (stopCount >= 10) {
                            LtLog.e(mFairy.getLineInfo("完成10次结束"));
                            setTaskEnd();
                            return;
                        }
                    }
                }
                result = mFairy.findPic(new String[]{"shangjiao.png", "jiao.png"});
                mFairy.onTap(0.68f, result, "上缴建材", Sleep);
                if (result.sim > 0.8f) {
                    mtCount = 10;
                }

                result = mFairy.findPic(6, 245, 1194, 484, "death.png");
                mFairy.onTap(0.8f, result, "复活", Sleep);


                if (dazeTime > 35) {
                    if (mtCount == 10) {
                        mtCount = 0;
                    }
                    mFairy.initMatTime();
                    result = mFairy.findPic(38, 201, 247, 292, new String[]{"jiancai.png", "jiancai3.png", "jiancai4.png"});
                    result1 = mFairy.findPic("shizu.png");
                    result2 = mFairy.findPic("bianjing3.png");
                    LtLog.e("/****************/" + result.sim);
                    if (result.sim < 0.7f && result1.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("左侧没有建材结束"));
                        setTaskEnd();
                        return;
                    } else if (result2.sim > 0.8f) {
                        setTaskName(2);
                        return;
                        //setTaskName(0);return;
                    }
                }

            }

            public void content_2() throws Exception {
                if (overtime(4, 0)) return;
                result = mFairy.findPic(52, 18, 1225, 670, "delivery2.png");
                mFairy.onTap(0.8f, result, result.x + 2, result.y + 153, result.x + 3, result.y + 154, "点击传送使者", Sleep);
                if (result.sim < 0.8f) {
                    if (result.sim < 0.8f) {
                        mFairy.onTap(1199, 89, 1206, 99, "地图", Sleep);
                        mFairy.onTap(579, 505, 582, 510, "地图", Sleep);
                        mFairy.onTap(1243, 46, 1250, 54, "地图", Sleep);
                    }
                }

                result = mFairy.findPic("deliveryyes.png");
                mFairy.onTap(0.8f, result, "传送", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                }
            }

            public void content_3() throws Exception {
                result = mFairy.findPic("zys.png");
                mFairy.onTap(0.8f, result, "采集资源", 5000);
                if (result.sim < 0.8f) {
                    setTaskName(1);
                    if (mtCount < 2) {
                        mtCount++;
                    }
                    mFairy.initMatTime();
                    return;
                }

            }
        }.taskContent(mFairy, "每日建材");
    } //每日建材

    public void wk() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(60, 0)) return;
                result = mFairy.findPic(1, 631, 91, 712, "Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic("shenqi.png");
                mFairy.onTap(0.8f, result, "打开神器", Sleep);

                result = mFairy.findPic("wakuang.png");
                mFairy.onTap(0.8f, result, "挖矿", Sleep);

                result1 = mFairy.findPic(854, 72, 1081, 105, "mianfei.png");
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(424, 86, 1057, 554, "box.png");
                    mFairy.onTap(0.8f, result, "挖矿2", 2000);
                }

                result1 = mFairy.findPic(854, 72, 1081, 105, "jinbi.png");
                if (result1.sim > 0.8f) {
                    LtLog.e("要花钱了结束");
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("shenqi2.png");
                if (result.sim > 0.8f) {
                    LtLog.e("还没开启神器");
                    setTaskEnd();
                    return;
                }

            }
        }.taskContent(mFairy, "挖矿");
    } //神器挖矿

    //战火正盛
    public void zhzs() throws Exception {
        new SingleTask(mFairy) {
            int num = 0;
            int jc = 0;

            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);

                result = mFairy.findPic("put.png");
                mFairy.onTap(0.8f, result, "普通", Sleep);

                result = mFairy.findPic(44, 155, 263, 497, "zhanhuo.png");
                mFairy.onTap(0.8f, result, "左侧战火正盛", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                } else if (num >= 0 && num <= 2) {
                    LtLog.e("777777");
                    num++;
                    mFairy.ranSwipe(122, 205, 122, 401, 500, 1500);
                } else {
                    LtLog.e("----");
                    num++;
                    mFairy.ranSwipe(122, 401, 122, 204, 500, 1500);
                }

                result = mFairy.findPic("smOverGraph.png");
                if (result.sim > 0.8f) {
                    num = 0;
                }
                if (num > 7) {
                    setTaskEnd();
                    return;
                }

            }

            public void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 10) {
                    mFairy.initMatTime();
                    setTaskName(1);
                    num = 0;
                    return;
                }

                result = mFairy.findPic(141, 516, 446, 620, "xmrwjs.png");
                mFairy.onTap(0.8f, result, "接受", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.initMatTime();
                    err = 0;
                }

                result1 = mFairy.findPic(164, 508, 404, 622, "xmrwwc.png");
                mFairy.onTap(0.8f, result1, "完成", Sleep);
                jc = picCount(0.8f, result1, "完成");
                if (jc >= 10) {
                    mFairy.initMatTime();
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "战火正盛");
    }

    public void cw() throws Exception {
        new SingleTask(mFairy) {
            int num = 0;
            int num2 = 0;

            @Override
            public void create() throws Exception {
                if (!AtFairyConfig.getOption("opcount1").equals("")) {
                    if (strSplit(AtFairyConfig.getOption("opcount1")).choice == 1) {
                        num = strSplit(AtFairyConfig.getOption("opcount1")).count;
                    } else {
                        LtLog.e("没有设定次数结束");
                        setTaskEnd();
                        return;
                    }
                }

            }

            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(2);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic(1, 631, 91, 712, "Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic("pic lock.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("灵宠没有解锁，任务结束"));
                    setTaskEnd();
                    return;
                }
                if (num2 <= 0) {
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("Spoil.png");
                mFairy.onTap(0.8f, result, "灵宠", Sleep);

                result = mFairy.findPic("Spoilshop.png");
                mFairy.onTap(0.8f, result, "灵宠商店", Sleep);

                result = mFairy.findPic("Wolf baby.png");
                mFairy.onTap(0.8f, result, "狼宝宝", 1000);

                result = mFairy.findPic("buy.png");
                mFairy.onTap(0.8f, result, "购买", 1000);
                mFairy.onTap(0.8f, result, 769, 432, 779, 438, "购买确定", 1000);
                if (result.sim > 0.8f) {
                    num2--;
                }

                result = mFairy.findPic("full2.png");
                if (result.sim > 0.8f) {
                    LtLog.e("买满了");
                    setTaskName(0);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(5, 1
                )) {
                    num2 = num;
                    gameUtil.close(0);
                    return;
                }

                LtLog.e("****" + num);
                if (num <= 0) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(new String[]{"daily.png", "beibao.png"});
                mFairy.onTap(0.8f, result, 1071, 110, 1087, 121, "打开背包", 3000);

                result = mFairy.findPic("baginface.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("zuozuo.png");
                    mFairy.onTap(0.8f, result, "宠物", Sleep);

                    result = mFairy.findPic("Pets.png");
                    mFairy.onTap(0.8f, result, "宠物", Sleep);

                    result = mFairy.findPic(583, 126, 923, 538, "Wolf baby.png");
                    mFairy.onTap(0.8f, result, "狼宝宝", 1000);
                    if (result.sim < 0.8f) {
                        mFairy.onTap(1098, 628, 1105, 640, "整理", 1000);
                    }
                    if (result.sim > 0.8f) {
                        err = 0;
                    }
                    result = mFairy.findPic(453, 111, 1261, 661, "Release.png");
                    mFairy.onTap(0.8f, result, "放生", 1000);
                    mFairy.onTap(0.8f, result, 743, 513, 755, 523, "放生确认", 1000);
                    if (result.sim > 0.8f) {
                        num--;
                        err = 0;
                    }

                }
            }
        }.taskContent(mFairy, "宠物材料");
    } //宠物材料

    void test() throws Exception {
        while (mFairy.condit()) {
            mFairy.sleep(1000);
            LtLog.e(mFairy.getLineInfo("\nwhile。。。。"));

            result = mFairy.findPic("task common.png");
            LtLog.e(mFairy.getLineInfo("普通 hls=" + result.toString()));


            LtLog.e(mFairy.getLineInfo("队伍 hls=" + result.toString()));
//            result=mFairy.findPic("pic pet tanxian interface.png");
//            LtLog.e(mFairy.getLineInfo("灵宠探险界面 result="+result.toString()));
        }
    }

    void lineTest() throws Exception {
        while (mFairy.condit()) {
            mFairy.sleep(1000);
            LtLog.e(mFairy.getLineInfo("\n\ntest while..........."));
//            result = mFairy.findPic(281,198,1036,684,"qluse.png");
//            LtLog.e(mFairy.getLineInfo("result="+result.toString()));

        }
    }


    public void keju2() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("kjExamination.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic("kjStartAnswer.png");
                mFairy.onTap(0.8f, result, "开始答题", Sleep);

               /* result = mFairy.findPic(new String[]{"kjAnswerAA.png", "kjAnswerAA1.png"});
                mFairy.onTap(0.8f, result, 632, 279, 664, 290, "选A", 3000);*/
                gameUtil.srAIAnswer();

                result = mFairy.findPic("kjSignOut.png");
                mFairy.onTap(0.8f, result, "答题退出", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy, "科举乡试任务中");
    }//科举乡试

    public void ymzj() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("ymzj.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic("tz.png");
                mFairy.onTap(0.8f, result, "挑战", Sleep);

                result = mFairy.findPic("begintz.png");
                mFairy.onTap(0.8f, result, "开始挑战", Sleep);

                result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                mFairy.onTap(0.8f, result, "开启自动战斗", Sleep);

                result = mFairy.findPic(874, 593, 1035, 641, "tzfive.png");
                mFairy.onTap(0.8f, result, "挑战多层", Sleep);

                result = mFairy.findPic("yesjl.png");
                mFairy.onTap(0.8f, result, "确认奖励", Sleep);

                result = mFairy.findPic("again.png");
                mFairy.onTap(0.8f, result, "再次挑战", Sleep);

                result = mFairy.findPic("onlyone.png");
                mFairy.onTap(0.8f, result, 771, 425, 778, 441, "确定最后一次", Sleep);

                result = mFairy.findPic(new String[]{"over2.png", "over3.png"});
                if (result.sim > 0.8f) {
                    LtLog.e("每次数了结束");
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy, "遗民战境");
    }//遗民战境

    public void buhuo() throws Exception {
        new TimingActivity(mFairy) {
            public void inOperation() throws Exception {
                result = mFairy.findPic("word hint enter capture.png");
                mFairy.onTap(0.8f, result, 502, 438, 510, 447, "消耗次数，进入捕获界面，确定", 1000);
                super.inOperation();
            }

            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                overtime(30, 0);

                result = mFairy.findPic("Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic("pic horse.png");
                mFairy.onTap(0.8f, result, "进入坐骑", Sleep);

                //
                result = mFairy.findPic("word horse interface.png");
                if (result.sim > 0.8f) {
                    err = 0;
                    LtLog.e(mFairy.getLineInfo("坐骑界面"));

                    result = mFairy.findPic("pic horse buhuo.png");
                    mFairy.onTap(0.8f, result, "切换捕获分页", Sleep);

                    result = mFairy.findPic("word first free.png");
                    mFairy.onTap(0.8f, result, 589, 626, 594, 634, "探索，首次免费", 2000);

                    result = mFairy.findPic("word btn enter capture.png");
                    mFairy.onTap(0.8f, result, "进入捕获", 1000);

                    result = mFairy.findPic("word horse 100 jinpiao.png");
                    mFairy.onTap(0.8f, result, 1154, 58, 1163, 65, "捕获完成，关闭", 1000);
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("任务完成"));
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic("pic copy leave.png");
                mFairy.onTap(0.8f, result, "离开副本", 1000);
            }

        }.taskContent(mFairy, "捕获坐骑");
    }//捕获坐骑

    public void chired() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("chirdsl.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                result = mFairy.findPic(739, 597, 886, 663, "ttSweep.png");
                mFairy.onTap(0.8f, result, "一键扫荡", Sleep);
                mFairy.onTap(0.8f, result, 753, 431, 790, 446, "一键扫荡确定", 10000);
                setTaskName(3);
                return;
            }

            public void content_3() throws Exception {
                result = mFairy.findPic("zddzgc.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("已达到最高层"));
                    setTaskEnd();
                }

                result = mFairy.findPic("begintz2.png");
                mFairy.onTap(0.8f, result, "开始挑战", Sleep);

                result = mFairy.findPic("need2.png");
                if (result.sim > 0.8f) {
                    LtLog.e("没有子女");
                    setTaskEnd();
                }

                result = mFairy.findPic("Replica.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                    mFairy.onTap(0.8f, result, "开启自动战斗", Sleep);
                }
                result = mFairy.findPic(876, 601, 1040, 652, "Continue.png");
                mFairy.onTap(0.8f, result, "继续挑战", Sleep);

              /*  result = mFairy.findPic( "quer.png");
                mFairy.onTap(0.8f, result, "确认", Sleep);*/

                result = mFairy.findPic(613, 189, 839, 236, "buff.png");
                mFairy.onTap(0.8f, result, 448, 461, 453, 465, "buff", Sleep);
                mFairy.onTap(0.8f, result, 625, 530, 638, 541, "buff确认", Sleep);

             /*   result = mFairy.findPic("ttSure.png");
                mFairy.onTap(0.8f, result, "只剩一次机会确定", Sleep);*/

                result = mFairy.findPic("iknow2.png");
                mFairy.onTap(0.8f, result, "知道了", Sleep);
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(173, 583, 76, 455, 3000, 1200);
                }
                result = mFairy.findPic("leave.png");
                mFairy.onTap(0.8f, result, "离开", 1000);
                if (result.sim > 0.8f) {
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy, "子女试炼任务中");
    }//子女试炼

}
