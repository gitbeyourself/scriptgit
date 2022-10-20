package com.script.fairy;

import android.os.Build;

import com.script.content.ScProxy;
import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;

/**
 * Created by Administrator on 2019/1/24 0024.
 */

public class TaskMain {
     AtFairyImpl mFairy;
     Util util;
     TeamTask teamTask;
     SingleTask singleTask;
    TimingActivity timingActivity;
    LimitLessTask limitlessTask;
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("一梦江湖");
         mFairy.setGameVersion(200);
         init();
         util= new Util(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitLessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         mFairy.initMatTime();
    }

     public void main() throws Exception {
         if (!AtFairyConfig.getOption("task_id").equals("")) {
             task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
         }

         if (task_id != 2111 && task_id != 2105) {
             //util.init_picture();
         }

         switch (task_id) {
             //一键十级
             case 2111:
                 singleTask.novice();
                 break;

             //江湖主目标
             case 2105:
                 singleTask.guide_goal();
                 break;

             //单人日常
             case 1945:
                 singleTask.daily();
                 break;

             //采集
             case 2043:
                 singleTask.pick_test();
                 break;

             //悬赏
             case 2049:
                 singleTask.reward();
                 break;

             //副本任务
             case 2131:
                 teamTask.team();
                 break;

             //测试
             case 100:
                 util.task("hangdang wanfa","jianghu xingshang");
                 singleTask.test();
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
    }

    private int  task_id;
    public void init() throws Exception {
        task_id = 0;
        try {
            JSONObject optionJson = new JSONObject(AtFairyConfig.getUserTaskConfig());
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }
}
