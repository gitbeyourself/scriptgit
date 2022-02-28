package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;


import org.json.JSONException;
import org.json.JSONObject;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.File;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


public class TaskMain {
    AtFairyImpl mFairy;
    SingleTask singleTask;
    TeamTask teamTask;
    LimitlessTask limitlessTask;
    FindResult result;
    JSONObject optionJson = null;
    GamePublicFuntion gamePublicFuntion;
    public static boolean ST = true;
    public static int QH = 1;
    public static boolean QHBOOLS = false;
    private int taskId = 0;

    public TaskMain(AtFairyImpl atFairy) throws Exception {
        singleTask = new SingleTask(atFairy);
        teamTask = new TeamTask(atFairy);
        gamePublicFuntion = new GamePublicFuntion(atFairy);
        limitlessTask = new LimitlessTask(atFairy);
        mFairy = atFairy;
        mFairy.setGameName("龙族幻想");
        mFairy.setGameVersion(65);
        init();
        QH = 1;
        ST = true;
    }

    private int week;
    private int hour;
    private int minute;

    public void main() throws Exception {
        switch (taskId) {
            case 1861:
                Mat m = mFairy.captureMat();
                Imgcodecs.imwrite("/sdcard/yunpai_files/111.png", m);

                File f = new File("/sdcard/yunpai_files/111.png");
                if (!f.exists()) {
                    LtLog.e("没有发现图片");
                }
                break;
            case 1833:
                do {
                    QHBOOLS = false;

                    gamePublicFuntion.setUp();

                    if (AtFairyConfig.getOption("zanli").equals("1")) {
                        gamePublicFuntion.liRank(0);
                    } else {
                        gamePublicFuntion.liRank(1);
                    }
                    if (AtFairyConfig.getOption("4821").equals("1")) {
                        singleTask.qingbao();
                    }
                    if (AtFairyConfig.getOption("zhuangbei").equals("1")) {
                        singleTask.zhuangbei();
                    }
                    if (AtFairyConfig.getOption("wpzl").equals("1")) {
                        singleTask.wpzl();
                    }

                    if (AtFairyConfig.getOption("tlkh").equals("1")) {
                        singleTask.tlkh();
                    }
                    if (AtFairyConfig.getOption("bsylx").equals("1")) {
                        singleTask.bsylx();
                    }

                    if (AtFairyConfig.getOption("jyzh").equals("1")) {
                        singleTask.jyzh();
                    }
                    if (!AtFairyConfig.getOption("ddjy").equals("")) {
                        singleTask.ddjy();
                    }

                    /**
                     *  社团任务
                     */
                    if (AtFairyConfig.getOption("stfh").equals("1") && ST) {
                        singleTask.stfh();
                    }

                    if (AtFairyConfig.getOption("djxmzs").equals("1") && ST) {
                        week = mFairy.week();
                        if (week != 1 && week != 2) {
                            singleTask.djxmzs();
                        }
                    }
                    if (AtFairyConfig.getOption("stzl").equals("1") && ST) {
                        singleTask.stzl();
                    }
                    if (AtFairyConfig.getOption("stmnz").equals("1") && ST) {
                        week = mFairy.week();
                        if (week != 5) {
                            singleTask.stmnzlj();
                        }
                    }

                    if (AtFairyConfig.getOption("stgz").equals("1") && ST) {
                        singleTask.stgz();
                    }
                    if (AtFairyConfig.getOption("4825").equals("1") && ST) {
                        singleTask.stmj();
                    }
                    if (AtFairyConfig.getOption("zhsl").equals("1")) {
                        hour = mFairy.dateHour();
                        if (hour >= 12 && hour <= 23) {
                            singleTask.zhsl();
                        }
                    }

                    if (AtFairyConfig.getOption("jskb").equals("1")) {
                        singleTask.jskb();
                    }

                    if (AtFairyConfig.getOption("mfzm").equals("1")) {
                        singleTask.mfzm();
                    }

                    String oxjx = AtFairyConfig.getOption("oxjx");
                    if (!oxjx.equals("") && !oxjx.equals("0")) {
                        singleTask.oxjx();
                    }

                    if (AtFairyConfig.getOption("4889").equals("1")) {

                        if (AtFairyConfig.getOption("wyng").equals("1")) {
                            teamTask.wyngzz();
                        }
                        if (AtFairyConfig.getOption("mgsx").equals("1")) {
                            teamTask.mgsx();
                        }
                        if (AtFairyConfig.getOption("llxd").equals("1")) {
                            teamTask.llxd();
                        }
                        if (AtFairyConfig.getOption("qian").equals("1")) {
                            singleTask.qian();
                        }

                        for (int i = 0; i < 4; i++) {
                            if (AtFairyConfig.getOption("qh1").equals("1") && QH == 1) {
                                QHBOOLS = true;
                                break;
                            }
                            if (AtFairyConfig.getOption("qh2").equals("1") && QH == 2) {
                                QHBOOLS = true;
                                break;
                            }
                            if (AtFairyConfig.getOption("qh3").equals("1") && QH == 3) {
                                QHBOOLS = true;
                                break;
                            }
                            if (AtFairyConfig.getOption("qh4").equals("1") && QH == 4) {
                                QHBOOLS = true;
                                break;
                            }
                            QH++;
                        }
                    }

                    if (QHBOOLS) {
                        LtLog.e(mFairy.getLineInfo("开始执行切换角色"));
                        singleTask.qh();
                        QH++;
                    }
                } while (QHBOOLS);
                break;
            case 1835:
                singleTask.nn();//新手引导
                break;
            case 1859:
                singleTask.qian();//签到
                break;
            case 1845:
                limitlessTask.guaji();//挂机
                break;
            case 1865:
                teamTask.gen();//跟队
                break;
            case 1839:
                if (AtFairyConfig.getOption("wyng").equals("1")) {
                    teamTask.wyngzz();
                }

                if (AtFairyConfig.getOption("mgsx").equals("1")) {
                    teamTask.mgsx();
                }

                if (!AtFairyConfig.getOption("llxd").equals("")) {
                    teamTask.llxd();
                }
                break;
        }

        gamePublicFuntion.init(0,false);

        LtLog.e(mFairy.getLineInfo("勾选任务已经全部完成,End!" + AtFairyConfig.getTaskID()));
        mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
    }

    public void init() throws Exception {
        AtFairyConfig.initConfig();
        try {
            optionJson = new JSONObject(AtFairyConfig.getUserTaskConfig());
            LtLog.e("选项列表" + optionJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            taskId = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }
}
