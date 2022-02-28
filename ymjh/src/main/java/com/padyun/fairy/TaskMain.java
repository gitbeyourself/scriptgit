package com.padyun.fairy;

import android.os.Build;


import com.script.content.ScProxy;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.utils.Utils;
import com.script.framework.AtFairyImpl;

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
    TimingActivity  timingActivity;
    LimitLessTask limitlessTask;
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("一梦江湖");
         mFairy.setGameVersion(156);
         init();
         util= new Util(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitLessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         mFairy.initMatTime();
    }

     public void main() throws Exception {
         ScProxy.config().Level().capturing(2);

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
                 util.init_picture();
                 singleTask.daily();
                 break;

             //采集
             case 2043:
                 util.init_picture();
                 singleTask.pick_test();
                 break;

             //悬赏
             case 2049:
                 util.init_picture();
                 singleTask.reward();
                 break;

             //副本任务
             case 2131:
                 util.init_picture();
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
    public void  init() throws Exception {
        String str=Utils.stringFile("/data/as/task_config/task.uicfg");
        String str1=Utils.stringFile("/sdcard/yunpai_files/uicache/task.uicfg");
        JSONObject optionJson;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                optionJson = new JSONObject(Utils.stringFile("/data/as/task_config/task.uicfg"));
            }else{
                optionJson = new JSONObject(Utils.stringFile("/sdcard/yunpai_files/uicache/task.uicfg"));
            }
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
        if (AtFairyConfig.getOption("test").equals("1")) {
            Abnormal.test=true;
        }
    }
}
