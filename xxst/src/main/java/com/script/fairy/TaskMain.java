package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
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
     FindResult result;
    LimitlessTask limitlessTask;
    TimingActivity timingActivity;
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("小小神途");
         mFairy.setGameVersion(10);
         mFairy.initmMap(30);
         mFairy.initMatTime();
         init();
         util= new Util(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         mFairy.initMatTime();

    }
     public void main() throws Exception {
          singleTask.novice2();
         switch (task_id) {
             case 1585:
                 singleTask.novice2();
                 break;
             case 1561:
                 if (AtFairyConfig.getOption("lj").equals("1")){
                     singleTask.welfare();
                 }
                 singleTask.daily();
                 if (AtFairyConfig.getOption("jhty").equals("1")){
                     singleTask.jhty();
                 }
                 break;
             case 1567:
                 teamTask.teamCopy();
                 if (AtFairyConfig.getOption("2885").equals("1")){
                       teamTask.tdfb();
                 }
                 break;
             case 1565:
                 limitlessTask.field();
                 break;
             case 1573:
                 teamTask.test();
                 break;
             case 1583:
                 if (AtFairyConfig.getOption("qy").equals("1")){
                     singleTask.novice1();
                 }
                 singleTask.xkzj();
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
    }

    private int  task_id;
    public void  init() throws Exception {
        task_id=0;
        try {
            JSONObject optionJson = new JSONObject(Utils.stringFile("/sdcard/yunpai_files/uicache/task.uicfg"));
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }

}
