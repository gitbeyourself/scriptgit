package com.example.administrator.xjqxz4;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.script.opencvapi.AtFairy2.FAIRY_TYPE_TASK;
import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TaskThread {
    xjqxz4 mFairy;
    FindResult result;
    JSONObject optionJson;
    CommonFunction commonFunction;
    GamePublicFunction gamePublicFunction;
    SingleTask singleTask;
    TimingActivity timingActivity;
    TeamTask teamTask;
    LimitlessTask limitlessTask;
    Other other;
    static List<String> list = new ArrayList<>();
    static int xshd_1 = 0, xshd_2 = 0, xshd_3 = 0, xshd_4 = 0, xshd_5 = 0, xshd_6 = 0, xshd_7 = 0, xshd_8 = 0, xshd_9 = 0,xshd_10=0;
    static int scbj=0;
    static int task = 0;
    String task_id;
    public TaskThread(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        commonFunction = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
        singleTask=new SingleTask(mFairy);
        teamTask=new TeamTask(mFairy);
        limitlessTask=new LimitlessTask(mFairy);
        timingActivity=new TimingActivity(mFairy);
        other=new Other(mFairy);
        xshd_1 = 0; xshd_2 = 0;xshd_3 = 0; xshd_4 = 0; xshd_5 = 0; xshd_6 = 0; xshd_7 = 0;xshd_8 = 0; xshd_9 = 0;xshd_10=0;
        scbj=0;
        task = 0;
        list.clear();
    }
    public void taskTread() throws Exception {
        int task_id1 =0;

        if(!AtFairyConfig.getOption("task_id").equals("")){
            task_id1 = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }

/*        task_id = AtFairyConfig.getOption("task_id");
        if (task_id.equals("")) {
            task_id1 = 0;
        } else {
            task_id1 = Integer.parseInt(task_id);
        }*/


        try {
            optionJson = new JSONObject(Utils.stringFile("/sdcard/yunpai_files/uicache/task.uicfg"));
            LtLog.e(commonFunction.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LtLog.e(commonFunction.getLineInfo("task_id1==" + task_id1));
        /*  if (task_id1 !=1090   && task_id1 !=1126){
            gamePublicFunction.setUp();
        }*/
        switch (task_id1) {
            case 1290:
                if (xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了新手引导"));
                    singleTask.Novice();
                }
                break;
            case 1292:
                if (xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了仙缘任务"));
                    gamePublicFunction.WithdrawTeam();
                    singleTask.Novice1();
                }
                break;
            case  1298:
                if (AtFairyConfig.getOption("qdlj").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了签到追回"));
                    singleTask.signIn();
                }
                gamePublicFunction.WithdrawTeam();
                if (AtFairyConfig.getOption("ljmj").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了六界美酒"));
                    singleTask.Master();
                }
                if (AtFairyConfig.getOption("mrdt").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了每日答题"));
                    singleTask.answerDay();
                }
                if (AtFairyConfig.getOption("bzts").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了宝藏探索"));
                    singleTask.treasureMap();
                }
                if (AtFairyConfig.getOption("xyp").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了降妖谱"));
                    singleTask.xyp();
                }
                if (AtFairyConfig.getOption("klzd").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了昆仑之巅"));
                    singleTask.klzd();
                }
                if (AtFairyConfig.getOption("yxlt").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了英雄擂台"));
                    singleTask.arena();
                }
                if (AtFairyConfig.getOption("wbt").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了挖宝图"));
                    singleTask.treasureMap1();
                }
                break;
            case  1302:
                if (AtFairyConfig.getOption("dd").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了带队挂机"));
                    teamTask.dayToDay();
                }
                if (AtFairyConfig.getOption("gd").equals("1") && xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了跟队挂机"));
                    teamTask.followTeam();
                }
                break;
            case  1300:
                if (xjqxz4.taskStartUp == true && task == 0) {
                    LtLog.e(commonFunction.getLineInfo("勾选了野外挂机"));
                    limitlessTask.fieldHangMachine();
                }
                break;
            default:
                task = 1;
                break;
        }
        if (task_id == "0" || xjqxz4.taskStartUp == false) {
            task = 0;
        } else if (xjqxz4.taskStartUp == true && task == 0) {
            task = 99;
        }
        //上报 类型 1 check（FAIRY_TYPE_CHECK） 2 （FAIRY_TYPE_TASK）task 任务完成 上报 99 （TASK_STATE_FINISH）
        switch (task) {
            case 99:
                LtLog.e(commonFunction.getLineInfo("-------------------------xjqxz4 任务完成 .....") + task);
                mFairy.finish(FAIRY_TYPE_TASK, task_id, TASK_STATE_FINISH);
                xjqxz4.taskStartUp = false;
                break;
        }
        LtLog.e(commonFunction.getLineInfo("任务线程结束"));
    }
}
