package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
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
     FindResult result;
     LimitlessTask limitlessTask;
     TimingActivity timingActivity;
     OtherGame otherGame;
     static List<String> list = new ArrayList<>();
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("天涯明月刀");
         mFairy.setGameVersion(147);
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
       /* singleTask.wordTask();
        singleTask.gangSignIn();
        singleTask.auspiciousness();
        singleTask.TBChallenge();
        singleTask.sportsmust();
        */

        //singleTask.sports();
         //singleTask.identity();
       // teamTask.textStory();//话本
         //teamTask.captor();

       // singleTask.welfare();
        /*  singleTask.recovery();*/
      /* singleTask.cleanbackpack();
       singleTask.email();*/
       //singleTask.drawCard();
        // teamTask.escort();
         //gameUtil.backcity();
         switch (task_id) {
             case 2490:
                 //清理背包
                 if(AtFairyConfig.getOption("qlbb").equals("1")){
                     singleTask.cleanbackpack();
                 }
                 //领取邮件
                 if(AtFairyConfig.getOption("lqyj").equals("1")){
                     singleTask.email();
                 } //每日一抽
                 if(AtFairyConfig.getOption("mryc").equals("1")){
                     singleTask.drawCard();
                 }
                 //奖励找回
                 if(AtFairyConfig.getOption("jlzh").equals("1")){
                     singleTask.recovery();
                 }
                 //帮派任务
                 if(AtFairyConfig.getOption("bprw").equals("1")){
                     singleTask.gangtask();
                 }
                 //世界任务
                 if(AtFairyConfig.getOption("sjrw").equals("1")){
                     singleTask.wordTask();
                 }
                 //帮派签到
                 if(AtFairyConfig.getOption("bpqd").equals("1")){
                     singleTask.gangSignIn();
                 }
                 //时雨祈福
                 if(AtFairyConfig.getOption("syqf").equals("1")){
                     singleTask.auspiciousness();
                 }
                 //天波挑战
                 if(AtFairyConfig.getOption("tbtz").equals("1")){
                     singleTask.TBChallenge();
                 }
                 //每日竞技
                 if(AtFairyConfig.getOption("mrjj").equals("1")){
                     singleTask.sportsmust();
                 }
                 //签到福利
                 if(AtFairyConfig.getOption("qdfl").equals("1")){
                     singleTask.welfare();
                 }

                 if(AtFairyConfig.getOption("7834").equals("1")){
                     singleTask.sports();
                 }
                 break;
             case 2500:
                 singleTask.plotTask();
                 break;
             case 2502:
                 gameUtil.backcity();
                 if(AtFairyConfig.getOption("sjhb").equals("1")){
                     teamTask.textStorySJ();//随机话本
                 }
                 if(AtFairyConfig.getOption("7866").equals("1")){
                     teamTask.textStory();//普通话本
                 }
                 if(AtFairyConfig.getOption("8040").equals("1")){
                     teamTask.knhb();//困难话本
                 }
             case 2504:
                 if(AtFairyConfig.getOption("7880").equals("1")||AtFairyConfig.getOption("7884").equals("1")|| !AtFairyConfig.getOption("opcount1").equals("")){
                     singleTask.identity();//身份
                 }
                 if(!AtFairyConfig.getOption("opcount2").equals("")){
                     teamTask.captor();//捕快
                 }
                 if(AtFairyConfig.getOption("7892").equals("1")){
                     teamTask.escort();//押镖
                 }

                 if(!AtFairyConfig.getOption("opcount3").equals("")){
                   singleTask.finish();//钓鱼
                 }
                 break;
             case 2510:
                 timingActivity.kaifeng();
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
