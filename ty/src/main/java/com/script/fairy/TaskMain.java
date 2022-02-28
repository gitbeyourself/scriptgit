package com.script.fairy;

//import com.script.opencvapi.FindResult;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.utils.Utils;

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

     LimitlessTask limitlessTask;
     TimingActivity timingActivity;
     OtherGame otherGame;
     static List<String> list = new ArrayList<>();
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("天谕");
         mFairy.setGameVersion(104);
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
        // singleTask.plotTask();
        /* singleTask.mpbw();
         singleTask.ghjs();
         singleTask.shrw();
         singleTask.wsw();
         singleTask.syzs();
         singleTask.qlzy();

         teamTask.fbtx();*/
         //singleTask.caiji();

        // teamTask.xl();
       /*  teamTask.fbxc();
         teamTask.fbtx();*/
         switch (task_id) {
             case 2602:
                 if(AtFairyConfig.getOption("syzs").equals("1")){
                     singleTask.syzs();
                 }
                 if(AtFairyConfig.getOption("wsw").equals("1")){
                     singleTask.wsw();
                 }
                 if(AtFairyConfig.getOption("shrw").equals("1")){
                     singleTask.shrw();
                 }
                 if(AtFairyConfig.getOption("ghjs").equals("1")){
                     singleTask.ghjs();
                 }

                 if(AtFairyConfig.getOption("mpbw").equals("1")){
                     singleTask.mpbw();
                 }
                 if(AtFairyConfig.getOption("qlzy").equals("1")){
                     singleTask.qlzy();
                 }

                 if(AtFairyConfig.getOption("zh").equals("1")){
                     singleTask.back();
                 }

                 if(AtFairyConfig.getOption("zhan").equals("1")){
                     singleTask.call();
                 }
                 if(AtFairyConfig.getOption("fjzb").equals("1")){
                     singleTask.cleanbag();
                 }

                 break;

             case 2604:
                 if(AtFairyConfig.getOption("gdxl").equals("1")&& AtFairyConfig.getOption("gd").equals("1")){
                     teamTask.xl();
                 }//跟队寻灵
                 if(AtFairyConfig.getOption("gdxc").equals("1")&& AtFairyConfig.getOption("gd").equals("1")){
                     teamTask.fbxc();
                 }//跟队洗尘
                 if(AtFairyConfig.getOption("ddxl").equals("1")&& AtFairyConfig.getOption("dd").equals("1")){
                     teamTask.xldd();
                 }//带队寻灵

                 if(AtFairyConfig.getOption("8147").equals("1")&& AtFairyConfig.getOption("dd").equals("1")){
                     teamTask.fbdd();
                 }//带队副本
                 if(AtFairyConfig.getOption("fbxcdd").equals("1") && AtFairyConfig.getOption("dd").equals("1")){
                     teamTask.fbxcdd();
                 }//带队洗尘
                 break;
             case 2606:
                 limitlessTask.ywgj();//挂机
                 break;

             case 2611:
                singleTask.plotTask();//新手
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

  /**
     * 初始化sdk
     */
        /*YpSdk.getInstance().init(this);*/
    /**
     * 注册任务变更监听
     */
       /* YpSdk.getInstance().setTaskChangeListener(new ITaskChangeListener(){

        @Override
        public void onChang() {
            Log.e("--aj","Task changed!");
            Log.e("--aj",YpSdk.getInstance().getCurrentTask());
        }
    });*/
    /**
     * 完成任务
     */
       /* YpSdk.getInstance().onTaskComplete("****");*/

}
