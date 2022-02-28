package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
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
     public  TaskMain (AtFairyImpl ATFairy) throws Exception {
         mFairy = ATFairy;
         mFairy.setGameName("梦幻西游网页版");
         mFairy.setGameVersion(256);
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
       // singleTask.demonWorld();
        // singleTask.sealDemonboss();
        // ScProxy.profiler().startWithUserTag("");
         //singleTask.receive();

         if(!AtFairyConfig.getOption("task_id").equals("")){
             task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
         }

         switch (task_id) {
             case 2196:
                 singleTask.plotTask();
                 break;
             case 2198:
                 //钟馗捉鬼
                 if (AtFairyConfig.getOption("zkzg").equals("1")){
                     singleTask.catchGhost();
                 }
                 //剧情挑战
                 if (AtFairyConfig.getOption("jqtz").equals("1")){
                     singleTask.plot();
                 }
                 //种族任务
                 if (AtFairyConfig.getOption("zzrw").equals("1")){
                     singleTask.race();
                 }
                 //副本任务
                 if (AtFairyConfig.getOption("fbrw").equals("1")){
                     singleTask.copyTask();
                 }
                 //擂台
                 if (AtFairyConfig.getOption("lt").equals("1")){
                     singleTask.arena();
                 }
                 //二十八星宿
                 if (AtFairyConfig.getOption("esbxx").equals("1")){
                     singleTask.constellation();
                 }
                 //白虎堂
                 if (AtFairyConfig.getOption("bht").equals("1")){
                     singleTask.whiteTiger();
                 }
                 //玄武堂
                 if (AtFairyConfig.getOption("xwt").equals("1")){
                     singleTask.xuanwu();
                 }
                 //青龙堂
                 if (AtFairyConfig.getOption("qlt").equals("1")){
                     singleTask.qinglong();
                 }
                 //帮派除盗
                 if (AtFairyConfig.getOption("bpcd").equals("1")){
                     singleTask.depredation();
                 }
                 //雁塔地宫
                 if (AtFairyConfig.getOption("ytdg").equals("1")){
                     singleTask.undergroundPalace();
                 }
                 //决战华山
                 if (AtFairyConfig.getOption("jzhs").equals("1")){
                     singleTask.huashanMountain();
                 }
                 //帮派守护兽
                 if (AtFairyConfig.getOption("bpshs").equals("1")){
                     singleTask.guardianBeast();
                 }
                 //挖宝
                 if (AtFairyConfig.getOption("wb").equals("1")){
                     singleTask.treasureDigging();
                 }
                 //妖界入侵
                 if (AtFairyConfig.getOption("yjrq").equals("1")){
                     singleTask.demonWorld();
                 }
                 //小试牛刀
                 if (AtFairyConfig.getOption("xsnd").equals("1")){
                     singleTask.knife();
                 }
                 //任务链
                 if (AtFairyConfig.getOption("rwl").equals("1")){
                     singleTask.taskChain();
                 }
                 //神器任务
                 if (AtFairyConfig.getOption("sqrw").equals("1")){
                     singleTask.shq();
                 }
                 //擂台商店
                 if (AtFairyConfig.getOption("ltsd").equals("1")){
                     singleTask.jjgm();
                 }
                 break;

             case 2224:
                 singleTask.receive();
                 break;
             case 2464:
                 singleTask.leitai();
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
