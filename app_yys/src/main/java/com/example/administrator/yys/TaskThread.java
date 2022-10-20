package com.example.administrator.yys;


import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.script.opencvapi.AtFairy2.FAIRY_TYPE_TASK;
import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TaskThread {//任务线程
    yys mFairy;
    JSONObject optionJson;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;
    SingleTask singleTask;
    TeamTask teamTask;
    LimitlessTask limitlessTask;
    TimingActivity timingActivity;
    Other other;
    static int task = 0;
    String task_id;

    public TaskThread(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        singleTask = new SingleTask(mFairy);
        teamTask = new TeamTask(mFairy);
        limitlessTask = new LimitlessTask(mFairy);
        other = new Other(mFairy);
        timingActivity = new TimingActivity(mFairy);
        task = 0;
    }


    public void taskTread() throws Exception {
        int task_id1;
        task_id = AtFairyConfig.getOption("task_id");
        if (task_id.equals("")) {
            task_id1 = 0;
        } else {
            task_id1 = Integer.parseInt(task_id);
        }
        try {
            optionJson = new JSONObject(Utils.stringFile("/sdcard/yunpai_files/uicache/task.uicfg"));
            LtLog.e("选项列表" + optionJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LtLog.e("task_id1==" + task_id1);

        /* test */
        switch (task_id1) {
            //探索挑战（同纸人操作）
            case 1599:

                singleTask.tsYB();
                break;
            //自动挑战（同纸人操作）
            case 1597:

                singleTask.zuduiYB();
                break;
            //结界突破
            case 1605:
            case 2791:
                singleTask.tp();
                break;
            //阴阳寮突破
            case 2787:
            case 2801:
                singleTask.yyltp();
                break;
            //庭院挂机
            case 1282:
            case 2789:
                if (yys.taskStartUp == true && task == 0) {
                    LtLog.e(comm.getText("***********************庭院挂机***********************"));
                    limitlessTask.Daze();
                }
                break;
            case 2358:
            case 2793:
                //自动挑战（同纸人操作）
                singleTask.zuduiYB2();
                break;
            case 2378:
            case 2795:
                //探索挑战（同纸人操作）
                singleTask.tsYB2();
                break;
            case 2456:
                singleTask.huodong();
                break;
            case 2458:
                singleTask.closejiacheng();
                break;
            default:
                task = 1;
                break;
        }
        if (task_id == "0" || yys.taskStartUp == false) {
            task = 0;
        } else if (yys.taskStartUp == true && task == 0) {
            task = 99;
        }
        //上报 类型 1 check（FAIRY_TYPE_CHECK） 2 （FAIRY_TYPE_TASK）task 任务完成 上报 99 （TASK_STATE_FINISH）
        switch (task) {
            case 99:
                LtLog.e(comm.getLineInfo("--------------------------阴阳师 任务完成 .....") + task);
                mFairy.finish(FAIRY_TYPE_TASK, task_id, TASK_STATE_FINISH);
                yys.taskStartUp = false;
                break;
            case 72001:
                LtLog.e(comm.getLineInfo("--------------------------阴阳师 时间过长 .....") + task);
                mFairy.finish(FAIRY_TYPE_TASK, task_id, task);
                yys.taskStartUp = false;
                break;
        }
        LtLog.e(comm.getLineInfo("任务线程结束"));
    }
}
