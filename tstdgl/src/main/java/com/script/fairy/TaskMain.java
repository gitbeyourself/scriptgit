package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


/**
 * Created by Administrator on 2019/1/24 0024.
 */

public class TaskMain {
     AtFairyImpl mFairy;
     GameUtil gameUtil;
     TeamTask teamTask;
     SingleTask singleTask;
     FindResult result;
     LimitlessTask limitlessTask;
     TimingActivity timingActivity;
     OtherGame otherGame;
     static List<String> list = new ArrayList<>();
     public  TaskMain (AtFairyImpl atFairy) throws Exception {
         mFairy = atFairy;
         mFairy.setGameName("吞食天地归来测试版");
         mFairy.setGameVersion(19);

         init();

         gameUtil = new GameUtil(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         otherGame=new OtherGame(mFairy);
         mFairy.initMatTime();
         list.clear();
    }

     public void main() throws Exception {

         if(!AtFairyConfig.getOption("task_id").equals("")){
             task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
         }

         if (task_id!=1939&&task_id!=100&&task_id!=2161&&!AtFairyConfig.getOption("test").equals("1")){
             gameUtil.close(1);
         }
         switch (task_id) {
             //单人日常
             case 2687:
                 LtLog.e("1937中");
                 if (AtFairyConfig.getOption("fuli").equals("1")){
                     gameUtil.fuli();//福利
                 }
                 if (AtFairyConfig.getOption("sywp").equals("1")){
                     if (AtFairyConfig.getOption("wjjyd").equals("1")) {
                         gameUtil.goods(1);//使用物品
                     }else
                     {
                         gameUtil.goods(0);//使用物品
                     }
                 }

                 break;
             //副本
             case 2691:
                 if (AtFairyConfig.getOption("tzbd").equals("1")){
                     gameUtil.missionfb("tzbd.png",2);
                     /*gameUtil.cs();*/
                 }
                 break;
             //定点挂机
             case 2693:
                 limitlessTask.fieldHangMachine();
                 break;
             case 2689:
                 singleTask.novice();
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
    }

    private int  task_id;
    public void  init() throws Exception {
        task_id=0;
        try {
            JSONObject   optionJson = new JSONObject(AtFairyConfig.getUserTaskConfig());
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }

}
