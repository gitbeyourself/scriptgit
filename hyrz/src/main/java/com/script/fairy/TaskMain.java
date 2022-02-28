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
     GameUtil gameUtil;
     TeamTask teamTask;
     SingleTask singleTask;
     FindResult result;
     LimitlessTask limitlessTask;
     TimingActivity timingActivity;
     public  TaskMain (AtFairyImpl ypFairy) throws Exception {
         mFairy = ypFairy;
         mFairy.setGameName("火影忍者");
         mFairy.setGameVersion(72);
         init();
         gameUtil = new GameUtil(mFairy);
         teamTask=new TeamTask(mFairy);
         singleTask=new SingleTask(mFairy);
         limitlessTask=new LimitlessTask(mFairy);
         timingActivity=new TimingActivity(mFairy);
         mFairy.initMatTime();
    }
     public void main() throws Exception {
         switch (task_id) {
             case 1615:
                 if (AtFairyConfig.getOption("fb").equals("1")){
                     singleTask.novice();
                 }
                 if (AtFairyConfig.getOption("fb1").equals("1")){
                    singleTask.elite1();
                 }
                 break;
             case 1621:
                 singleTask.setUp();
              while (true){
                  //赠送
                  if (AtFairyConfig.getOption("zs").equals("1")) {
                       singleTask.zengSong();
                  }
                  if (AtFairyConfig.getOption("yj").equals("1")) {
                       singleTask.youjian();
                  }
                  //招募
                  if (AtFairyConfig.getOption("zm").equals("1")) {
                      singleTask.zhaoMu();
                  }
                  //点赞
                  if (AtFairyConfig.getOption("dz").equals("1")) {
                       singleTask.dianZan();
                  }
                  //招财
                  if (AtFairyConfig.getOption("zc").equals("1")) {
                   singleTask.zhaoCai();
                  }
                  //祈福
                  if (AtFairyConfig.getOption("qf").equals("1")) {
                      singleTask.qifu();
                  }
                  //丰饶一键完成
                  if (AtFairyConfig.getOption("fryj").equals("1")) {
                     singleTask.fengrao();
                  }
                  //历练
                  if (AtFairyConfig.getOption("ll").equals("1")) {
                    singleTask.lilian();
                  }
                  //闯荡
                  if (AtFairyConfig.getOption("cd").equals("1")) {
                     singleTask.chuangdang();
                  }
                  //赏金
                  if (AtFairyConfig.getOption("sj").equals("1")) {
                    singleTask.shangjin();
                  }
                  //突袭
                  if (AtFairyConfig.getOption("tx").equals("1") || AtFairyConfig.getOption("txsb").equals("1")) {
                    singleTask.tuxi();
                  }
                  //修行
                  if (AtFairyConfig.getOption("xx").equals("1")) {
                   singleTask.xiuxing();
                  }
                  //生存
                  if (AtFairyConfig.getOption("sc").equals("1")) {
                    singleTask.shengcun();
                  }
                  //会所
                  if (AtFairyConfig.getOption("hs").equals("1")) {
                    singleTask.club();
                  }
                  //积分赛
                  if (AtFairyConfig.getOption("jf").equals("1")) {
                     singleTask.jifensai();
                  }
                  //周胜
                  if (AtFairyConfig.getOption("zsrw").equals("1")) {
                     singleTask.zhousheng();
                  }
                  //斗气
                  if (AtFairyConfig.getOption("dq").equals("1")) {
                     singleTask.douqi();
                  }
                  //秘境
                  if (!AtFairyConfig.getOption("mj").equals("")) {
                     singleTask.mijing();
                  }
                  //羁绊
                  if (AtFairyConfig.getOption("jb").equals("1")) {
                    singleTask.jiban();
                  }
                  //装备升级
                  if (AtFairyConfig.getOption("sd").equals("1")) {
                     singleTask.equip();
                  }
                  //奖励
                  if (AtFairyConfig.getOption("jl").equals("1")) {
                    singleTask.jiangli();
                  }
                  //活动
                  if (AtFairyConfig.getOption("yile").equals("1") || AtFairyConfig.getOption("hd1").equals("1") || AtFairyConfig.getOption("hd2").equals("1") || AtFairyConfig.getOption("hd3").equals("1") || AtFairyConfig.getOption("hd4").equals("1") || AtFairyConfig.getOption("hd5").equals("1")) {
                       singleTask.huodong();
                  }
                  LtLog.e(mFairy.getLineInfo("单人任务执行完成"));
                  //挂机
                  if(AtFairyConfig.getOption("6370").equals("1")){
                      limitlessTask.hangUp();
                      if(AtFairyConfig.getOption("5cq").equals("1")){
                        continue;
                      }
                  }
                  break;
              }
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
