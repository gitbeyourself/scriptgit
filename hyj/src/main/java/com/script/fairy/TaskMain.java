package com.script.fairy;

import com.script.content.ScProxy;
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
         mFairy.setGameName("花与剑");
         mFairy.setGameVersion(157);
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
         ScProxy.profiler().startWithUserTag("");
         switch (task_id) {
             case 1981:
                 singleTask.novice();
                 break;
             case 1989:
                 if (AtFairyConfig.getOption("xyxs").equals("1")){
                     singleTask.chivalrous();
                 }
                 if (AtFairyConfig.getOption("qrz").equals("1")){
                     singleTask.sevenLog();
                 }
                 if (AtFairyConfig.getOption("mjxw").equals("1")){
                     singleTask.feelGold();
                 }
                 if (AtFairyConfig.getOption("kjcs").equals("1")){
                     singleTask.imperialExamination();
                 }
                 if (AtFairyConfig.getOption("bqjs").equals("1")){
                     singleTask.gangbuild();
                 }
                 if (AtFairyConfig.getOption("lsqt").equals("1")){
                     singleTask.troubledTimes();
                 }
                 if (AtFairyConfig.getOption("plzz").equals("1")){
                     singleTask.battlePenglai();
                 }
                 if (AtFairyConfig.getOption("mpyw").equals("1")){
                     singleTask.factionMartial();
                 }
                 if (AtFairyConfig.getOption("jrys").equals("1")){
                     singleTask.fortune();
                 }
                 if (AtFairyConfig.getOption("llby").equals("1")){
                     singleTask.hospital();
                 }
                 if (AtFairyConfig.getOption("scdb").equals("1")){
                     timingActivity.battlefieldTroops();
                 }
                 break;
             case 1991:
                 if (AtFairyConfig.getOption("yyjm").equals("1")){
                     teamTask.gardenDream();
                 }
                 if (AtFairyConfig.getOption("wsry").equals("1")){
                    teamTask.pastEvents();
                 }
                 if (AtFairyConfig.getOption("swhc").equals("1")){
                     teamTask.imperialCity();
                 }
                 if (AtFairyConfig.getOption("sjhw").equals("1")){
                     teamTask.moneyReward();
                 }
                 if (AtFairyConfig.getOption("sfjd").equals("1")){
                     teamTask.captureThieves();
                 }
                 if (AtFairyConfig.getOption("xsmj").equals("1")){
                    teamTask.secretVolume();
                 }
                 if (AtFairyConfig.getOption("mpsl").equals("1")){
                     teamTask.factionTrial();
                 }
                 if (AtFairyConfig.getOption("ywhy").equals("1")){
                     teamTask.withHuiyou();
                 }
                 break;
             case 2047:
                 if (!AtFairyConfig.getOption("cj").equals("")){
                     singleTask.collection();
                 }
                 if (!AtFairyConfig.getOption("cd").equals("")){
                     singleTask.goFishing();
                 }
                 if (AtFairyConfig.getOption("5757").equals("1")){
                     singleTask.technology();
                 }
                 break;
             case 2119:
                 if (AtFairyConfig.getOption("lt").equals("1")){
                     singleTask.intimacy();
                 }
                 if (AtFairyConfig.getOption("sl").equals("1")){
                     singleTask.giveGift();
                 }
                 if (AtFairyConfig.getOption("qcnpc").equals("1")){
                     singleTask.duel();
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
