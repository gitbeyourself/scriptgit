package com.script.fairy;

import android.os.Build;

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
         mFairy.setGameName("狐妖小红娘");
         mFairy.setGameVersion(154);
         init();
         util= new Util(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         mFairy.initMatTime();
    }

    public void main() throws Exception {
         switch (task_id) {
             //一键28级
             case 1841:
                 singleTask.novice();
                 break;
             //单人日常
             case 1843:
                 singleTask.init_image();
                 singleTask.daily();
                 break;
             //多人副本
             case 1851:
                 singleTask.init_image();
                 teamTask.teamTask();
                 break;
             //限时任务
             case 1849:
                 singleTask.init_image();
                 limitlessTask.limit();
                 break;
            //测试
             case 100:
                 singleTask.test();
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
    }

    private int  task_id;
    public void  init() throws Exception {
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
    }

}
