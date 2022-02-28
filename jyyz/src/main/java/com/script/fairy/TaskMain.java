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
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("剑与远征");
         mFairy.setGameVersion(319);
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

         switch (task_id) {
             case 2083:
             if (AtFairyConfig.getOption("bttzlj").equals("1")){

                     singleTask.reward();

             }else {
                 if (AtFairyConfig.getOption("5871").equals("1")){
                     singleTask.novice();
                 }
                 if (AtFairyConfig.getOption("5881").equals("1")){
                     singleTask.campaign();
                 }
                 if (AtFairyConfig.getOption("ksgj").equals("1")){
                     singleTask.quickHang();
                 }
                 if (AtFairyConfig.getOption("5885").equals("1")){
                     singleTask.towerThrone();
                 }
                 if (AtFairyConfig.getOption("5887").equals("1")){
                     singleTask.raceTower();
                 }
                 if (AtFairyConfig.getOption("5907").equals("1")){
                     singleTask.rewardColumn();
                 }
                 if (AtFairyConfig.getOption("5891").equals("1")){
                     singleTask.sports();
                 }
                 if (AtFairyConfig.getOption("5893").equals("1")){
                     if (AtFairyConfig.getOption("jhkq").equals("1")) {
                         singleTask.swordSoul();
                     }
                     singleTask.hunting();
                     if (AtFairyConfig.getOption("nqmj").equals("1")){
                         singleTask.twistedDreams();
                     }

                 }
                 if (AtFairyConfig.getOption("5909").equals("1")){
                     singleTask.library();
                 }
                 if (AtFairyConfig.getOption("hcgjz").equals("1")){
                     singleTask.hcgjz();
                 }

                 if (AtFairyConfig.getOption("5903").equals("1")){
                     singleTask.reward();
                 }
             }
             break;
             case 2183:
                 if (AtFairyConfig.getOption("tu").equals("1")){
                     singleTask.campaigns();
                 }
                 if (AtFairyConfig.getOption("wzzt").equals("1")){
                     singleTask.towerThrones();
                 }
                 if (AtFairyConfig.getOption("gzzj").equals("1")){
                     singleTask.towerThronesgz();
                 }
                 if (AtFairyConfig.getOption("lczk").equals("1")){
                     singleTask.towerThroneslk();
                 }
                 if (AtFairyConfig.getOption("cczz").equals("1")){
                     singleTask.towerThroneszz();
                 }
                 if (AtFairyConfig.getOption("qhzm").equals("1")){
                     singleTask.towerThroneszm();
                 }

                 break;
             case 2187:
                 if (AtFairyConfig.getOption("rctu").equals("1")){//推图
                    // singleTask.campaignnew();
                   //  singleTask.quickHangnew();
                 }
                 if (AtFairyConfig.getOption("rcwzzt").equals("1")){//王座之塔
                   //  singleTask.towerThronenew();
                 }
                 if (AtFairyConfig.getOption("rcyjmg").equals("1")){//异界迷宫
                   //  singleTask.raceTowernew();
                 }
                 if (AtFairyConfig.getOption("rcxsl").equals("1")){//悬赏栏
                   //  singleTask.rewardColumnnew();
                 }

                 if (AtFairyConfig.getOption("rcjjc").equals("1")){//竞技场
                    // singleTask.sportsnew();
                 }

                 if (AtFairyConfig.getOption("rcghsl").equals("1")){//工会狩猎
                     if (AtFairyConfig.getOption("kqjh").equals("1")) {
                       //  singleTask.swordSoul();
                     }
                    // singleTask.huntingnew();
                     if (AtFairyConfig.getOption("nqmj").equals("1")){
                       //  singleTask.twistedDreamsnew();
                     }

                 }
                 if (AtFairyConfig.getOption("rctsg").equals("1")){//图书馆
                    // singleTask.librarynew();
                 }
                 if (AtFairyConfig.getOption("lj").equals("1")){//领奖
                    // singleTask.rewardnew();
                 }

                 if (AtFairyConfig.getOption("yjld").equals("1")){//异界旅店
                    // singleTask.hostel();
                 }
                 break;
             case 2191:
                 singleTask.campaignnew();
                 singleTask.quickHangnew();
                 singleTask.towerThronenew();
                 singleTask.rewardColumnnew();
                 singleTask.sportsnews();
                 singleTask.huntingnews();
                 singleTask.rewardnews();
                 break;
             case 2609:
                 singleTask.hcgjz();
                 break;

         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
    }

    private int  task_id;
    public void  init() throws Exception {
        task_id=0;
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
