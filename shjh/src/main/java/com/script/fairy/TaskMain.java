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
         mFairy.setGameName("山海镜花");
         mFairy.setGameVersion(117);
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
         switch (task_id) {
             case 2169:
                 singleTask.guide();
                 break;
             case 2163:
                 if (AtFairyConfig.getOption("gyhj").equals("1")){
                     singleTask.guYaoFantasy();
                 }
                 if (AtFairyConfig.getOption("zhzy").equals("1")){
                     singleTask.abyssDisaster();
                 }
                 if (AtFairyConfig.getOption("klzx").equals("1")){
                     singleTask.kunLunRuins();
                 }
                 break;
             case 2165:
                 if (AtFairyConfig.getOption("xs").equals("1")){
                     singleTask.offerReward();
                 }
                 if (AtFairyConfig.getOption("wp" ).equals("1")){
                     singleTask.delegate();
                 }
                 if (AtFairyConfig.getOption("qyt").equals("1")){
                     singleTask.Pagoda();
                 }
                 if (AtFairyConfig.getOption("zshw").equals("1")){
                     singleTask.practiceMartialArts();
                 }
                 if (AtFairyConfig.getOption("lj").equals("1")){
                     singleTask.receivePrize();
                 }
                 break;
             case 2173:
                 singleTask.experience();
                 break;
             case 2177:
                 singleTask.principalLine();
                 break;
             case 2185:
                 singleTask.delegates();
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
