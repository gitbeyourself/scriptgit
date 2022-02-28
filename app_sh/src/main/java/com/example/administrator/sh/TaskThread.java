package com.example.administrator.sh;

import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;


import static com.script.opencvapi.AtFairy2.FAIRY_TYPE_TASK;
import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TaskThread {//任务线程

    sh mFairy;
    JSONObject optionJson;
    private CommonFunction comm;
    private GamePublicFunction gamePublicFunction;
    private SingleTask singleTask;
    private TeamTask teamTask;
    private LimitlessTask limitlessTask;
    private TimingActivity timingActivity;
    private Other other;
    static int task = 0;
    private String task_id;

    public TaskThread(sh ypFairy) {
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
        /*
            test
         */
        /*List<String> aaa=singleTask.test(1000);
        for(int i=0;i<aaa.size();i++){
            LtLog.e(""+aaa.get(i));
        }*/
        /*int i=0;
        while (true) {
            gamePublicFunction.battle();
            if(i>0){
                break;
            }
        }*/
        switch (task_id1) {
            case 1336:
                if (sh.taskStartUp == true && task == 0) {
                    LtLog.e(comm.getText("***********************一键满级***********************"));
                    gamePublicFunction.setUp();
                    task =singleTask.thread();
                }
            case 1340:
                if (sh.taskStartUp == true && task == 0) {
                    LtLog.e(comm.getText("***********************签到***********************"));
                    singleTask.signIn();
                }
                break;
            case 1344:
                if (sh.taskStartUp == true && task == 0) {
                    LtLog.e(comm.getText("***********************副本***********************"));
                    gamePublicFunction.setUp();
                    task = singleTask.GameCopy();
                }
                break;
            case 1350:
                if (sh.taskStartUp == true && task == 0) {
                    LtLog.e(comm.getText("***********************花牌***********************"));
                    singleTask.flowerCards();
                }
                break;
            case 1352:
                if (sh.taskStartUp == true && task == 0) {
                    LtLog.e(comm.getText("***********************魔界深渊***********************"));
                    gamePublicFunction.setUp();
                    task = singleTask.GameAbyss();
                }
                break;
            default:
                task = 1;
                break;
        }
        if (task_id == "0" || sh.taskStartUp == false) {
            task = 0;
        } else if (sh.taskStartUp == true && task == 0) {
            task = 99;
        }
        //上报 类型 1 check（FAIRY_TYPE_CHECK） 2 （FAIRY_TYPE_TASK）task 任务完成 上报 99 （TASK_STATE_FINISH）
        switch (task) {
            case 99:
                LtLog.e(comm.getLineInfo("--------------------------侍魂·胧月传说 任务完成 .....") + task);
                mFairy.finish(FAIRY_TYPE_TASK, task_id, TASK_STATE_FINISH);
                sh.taskStartUp = false;
                break;
            case 6001:
                LtLog.e(comm.getLineInfo("--------------------------侍魂·胧月传说 角色战斗失败 .....") + task);
                mFairy.finish(FAIRY_TYPE_TASK, task_id, 6001);
                sh.taskStartUp = false;
                break;
            case 6002:
                LtLog.e(comm.getLineInfo("--------------------------侍魂·胧月传说 魔界深渊秘钥不足 .....") + task);
                mFairy.finish(FAIRY_TYPE_TASK, task_id, 6002);
                sh.taskStartUp = false;
                break;
        }
        LtLog.e(comm.getLineInfo("任务线程结束"));


    }


}
