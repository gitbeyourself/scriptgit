package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

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
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("cf");
         mFairy.setGameVersion(76);
         mFairy.initmMap(30);
         mFairy.initMatTime();
         init();
         util= new Util(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         mFairy.initMatTime();

    }
     public void main() throws Exception {
         switch (task_id) {
             //无限挑战
             case 1422:
                 if (AtFairyConfig.getOption("pt_s").equals("1")){
                     singleTask.Infinite("sjboss.png","sjboss1.png","stl.png",1);
                 }
                 if (AtFairyConfig.getOption("pt_b").equals("1")){
                     singleTask.Infinite("sjboss.png","sjboss1.png","bhjx.png",1);
                 }
                 if (AtFairyConfig.getOption("pt_z").equals("1")){
                     singleTask.Infinite("sjboss.png","sjboss1.png","zzjs.png",1);
                 }
                 if (AtFairyConfig.getOption("th_pt").equals("1")){
                     singleTask.Infinite("jskc.png","jskc1.png","ltqb.png",1);
                 }
                 if (AtFairyConfig.getOption("th_kn").equals("1")){
                     singleTask.Infinite("jskc.png","jskc1.png","ltqb.png",2);
                 }
                 if (AtFairyConfig.getOption("th_ly").equals("1")){
                     singleTask.Infinite("jskc.png","jskc1.png","ltqb.png",3);
                 }
                 if (AtFairyConfig.getOption("to_pt").equals("1")){
                     singleTask.Infinite("jskc.png","jskc1.png","llgm.png",1);
                 }
                 if (AtFairyConfig.getOption("to_kn").equals("1")){
                     singleTask.Infinite("jskc.png","jskc1.png","llgm.png",2);
                 }
                 if (AtFairyConfig.getOption("to_ly").equals("1")){
                     singleTask.Infinite("jskc.png","jskc1.png","llgm.png",3);
                 }

                 if (AtFairyConfig.getOption("pt_cfj").equals("1")){
                     singleTask.Infinite("cfjrc.png","cfjrc1.png","",1);
                 }
                 if (AtFairyConfig.getOption("kn_cfj").equals("1")){
                     singleTask.Infinite("cfjrc.png","cfjrc1.png","",2);
                 }
                 if (AtFairyConfig.getOption("ly_cfj").equals("1")){
                     singleTask.Infinite("cfjrc.png","cfjrc1.png","",3);
                 }

                 if (AtFairyConfig.getOption("pt_j").equals("1")){
                     singleTask.Infinite("jrc.png","jrc1.png","",1);
                 }
                 if (AtFairyConfig.getOption("kn_j").equals("1")){
                     singleTask.Infinite("jrc.png","jrc1.png","",2);
                 }
                 if (AtFairyConfig.getOption("ly_j").equals("1")){
                     singleTask.Infinite("jrc.png","jrc1.png","",3);
                 }


                 if (AtFairyConfig.getOption("shpt").equals("1")){
                     singleTask.Infinite("hxfy.png","hxfy1.png","shzx.png",1);
                 }
                 if (AtFairyConfig.getOption("shkn").equals("1")){
                     singleTask.Infinite("hxfy.png","hxfy1.png","shzx.png",2);
                 }
                 if (AtFairyConfig.getOption("shly").equals("1")){
                     singleTask.Infinite("hxfy.png","hxfy1.png","shzx.png",3);
                 }
                 break;
             //挑战世界boss
             case 1416:
                 if (AtFairyConfig.getOption("kn_s").equals("1")){
                     singleTask.Infinite1("sjboss.png","sjboss1.png","stl.png",2);
                 }
                 if (AtFairyConfig.getOption("ly_s").equals("1")){
                     singleTask.Infinite1("sjboss.png","sjboss1.png","stl.png",3);
                 }
                 if (AtFairyConfig.getOption("kn_b").equals("1")){
                     singleTask.Infinite1("sjboss.png","sjboss1.png","bhjx.png",2);
                 }
                 if (AtFairyConfig.getOption("ly_b").equals("1")){
                     singleTask.Infinite1("sjboss.png","sjboss1.png","bhjx.png",3);
                 }

                 if (AtFairyConfig.getOption("kn_z").equals("1")){
                     singleTask.Infinite1("sjboss.png","sjboss1.png","zzjs.png",2);
                 }
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
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
