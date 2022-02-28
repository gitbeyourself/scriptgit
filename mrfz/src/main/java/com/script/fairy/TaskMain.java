package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
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
    SingleTask1 singleTask1;
    FindResult result;
    LimitlessTask limitlessTask;
    TimingActivity timingActivity;
     public  TaskMain (AtFairyImpl ATFairy) throws Exception {
         mFairy = ATFairy;
         mFairy.setGameName("明日方舟");
         mFairy.setGameVersion(64);
         init();
         util= new Util(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         singleTask1=new SingleTask1(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         mFairy.initMatTime();
    }

     public void main() throws Exception {
         switch (task_id) {
             case 1617:
                 singleTask.novice();//新手指引
                 break;
             case 1619:
                 singleTask1.mainFight();//主线作战任务
                 break;
             case 1623:
                 singleTask1.visitJiJian();//基建收菜
                 break;
             case 1625:
                 singleTask1.wuZiFight();//物资筹备作战任务
                 break;
             case 1627:
                 singleTask1.xinPianFight();//芯片搜索作战任务
                 break;
             case 1629:
                 singleTask1.jiaoMieFight();//剿灭作战任务
                 break;

             case 2137:
                 singleTask.dark();//生于黑夜
                 break;

             case 1635:
                 singleTask.sign();//日常签到
                 break;
             case 1637:
                 singleTask.haoyouJiJian();//访问好友基建
                 break;
             case 2193:
                 singleTask1.customLevel();//自选关卡代理
                 break;
             case 100:
                 singleTask.test();//测试
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
