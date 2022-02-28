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
         mFairy.setGameName("剑侠情缘2剑歌行");
         mFairy.setGameVersion(130);
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
singleTask.chivalry2();
         //timingActivity.shenbu();//神捕
         //gameUtil.clearBag();//清包
           //singleTask.fishing();//钓鱼
         //singleTask.sword();//论剑
        // singleTask.examination();//科举
        // singleTask.chamberCommerce();//商会
           //singleTask.school();//师门
          // singleTask.challenge();//挑战
          //singleTask.chivalry();//行侠
           //singleTask.topList();//风云榜
           //timingActivity.swordArena();//试剑擂台
           //singleTask.sports();
           //timingActivity.plantingTrees();//种树

          // singleTask.dispatch();//派遣
           //timingActivity.skyThunder();//天雷荒火
          //timingActivity.dinner();//晚餐
         //singleTask.receive();//领奖

          //singleTask.plotTask();//新手
//         ScProxy.config().Debugger().setImwriteAssetsMat("assets_hls2.png");
//         ScProxy.config().Debugger().setImwriteAssetsMat("screencap_hls2.png");
//         for(;;){
//             FindResult result = mFairy.findPic(973,60,1273,591, "hls2.png");
//             Thread.sleep(1000);
//         }

         switch (task_id) {
             case 2326:
                 if (AtFairyConfig.getOption("qdlj").equals("1")){
                     singleTask.receive();//签到
                 }
                 if (AtFairyConfig.getOption("dy").equals("1")){
                     singleTask.fishing();//钓鱼
                 }
                 if (AtFairyConfig.getOption("lj").equals("1")){
                     singleTask.sword();//论剑
                 }
                 if (AtFairyConfig.getOption("kj").equals("1")){
                     singleTask.examination();//科举
                 }
                 if (AtFairyConfig.getOption("sh").equals("1")){
                     singleTask.chamberCommerce();//商会
                 }
                 if (AtFairyConfig.getOption("sm").equals("1")){
                     singleTask.school();//师门
                 }
                 if (AtFairyConfig.getOption("xx").equals("1")){
                     singleTask.chivalry2();//行侠
                 }
                 if (AtFairyConfig.getOption("6988").equals("1")){
                     singleTask.chivalry();//行侠
                 }
                 if (AtFairyConfig.getOption("sbb").equals("1")){
                     singleTask.shenbu();//神捕
                 }
                 if (AtFairyConfig.getOption("fyb").equals("1")){
                     singleTask.topList();//风云榜
                 }
                 if (AtFairyConfig.getOption("sjlt").equals("1")){
                     timingActivity.swordArena();//试剑擂台
                 }
                 if (AtFairyConfig.getOption("rjlx").equals("1")){
                     singleTask.sports();//无限人机
                 }
                 break;
             case 2328:
                 singleTask.sports();//无限人机
                 break;
             case 2330:
                 singleTask.field();//野外挂机
                 break;
             case 2332:
                 singleTask.plotTask();//新手
                 break;

             case 2358:
                 timingActivity.ancientCity();//古城夺宝
                 break;
             case 2359:
                 timingActivity.wuyuan();//雾原血战
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
