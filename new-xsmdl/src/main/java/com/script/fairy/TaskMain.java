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
    public  TaskMain (AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        mFairy.setGameName("新神魔大陆");
        mFairy.setGameVersion(135);
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
            case 2436:
                /**
                 * 新手任务
                 */
                singleTask.plotTask();
                break;
            case 2438:
                /**
                 * 日常(单人任务)
                 */
//                 singleTask.plotTask();
//                 singleTask.arena();
//                 singleTask.chief1();
//                 otherGame.Clear2();
//                 teamTask.Storm();
//                 limitlessTask.outdoorsOnHook();
//                 timingActivity.intrusion();
//                 singleTask.chief();
//                 singleTask.Raysingh();
                //跳转竞技场(单人)
                if(AtFairyConfig.getOption("ab").equals("1")){
                    singleTask.arena();
                }
                //跳转工会捐献(单人)
                if(AtFairyConfig.getOption("cd").equals("1")){
                    singleTask.contributions();
                }

                //跳转雷辛格秘闻(单人)
                if(AtFairyConfig.getOption("ef").equals("1")){
                    singleTask.Raysingh();
                }
                //跳转无尽深渊(单人)
                if(AtFairyConfig.getOption("gh").equals("1")){
                    singleTask.endless();
                }
                //跳转英林殿(单人)
                if(AtFairyConfig.getOption("ij").equals("1")){
                    singleTask.YinglinHall();
                }
                //跳转大秘境(单人)
                if(AtFairyConfig.getOption("kl").equals("1")){
                    singleTask.Secret();
                }
                //跳转女神宝藏(单人)
                if(AtFairyConfig.getOption("mn").equals("1")){
                    singleTask.treasure();
                }
                //跳转时光回廊(单人)
                if(AtFairyConfig.getOption("op").equals("1")){
                    singleTask.time();
                }

                //跳转野外首领(单人默认)
                if(AtFairyConfig.getOption("chief").equals("1")){
                    singleTask.chief();
                }
                //跳转野外首领(单人默认)
                if(AtFairyConfig.getOption("chief1").equals("1")){
                    singleTask.chief1();
                }
                //不执行
                if(AtFairyConfig.getOption("chief2").equals("1")){
                    singleTask.chief2();
                }
                //跳转野外首领(单人沉睡深林)
                if(AtFairyConfig.getOption("chief3").equals("1")){
                    singleTask.chief3();
                }
                //跳转野外首领(单人起源之地)
                if(AtFairyConfig.getOption("chief4").equals("1")){
                    singleTask.chief4();
                }
                //跳转野外首领(单人凯旋平原)
                if(AtFairyConfig.getOption("chief5").equals("1")){
                    singleTask.chief5();
                }
                //跳转野外首领(单人自由群岛)
                if(AtFairyConfig.getOption("chief6").equals("1")){
                    singleTask.chief6();
                }
                //跳转野外首领(单人深渊之底)
                if(AtFairyConfig.getOption("chief7").equals("1")){
                    singleTask.chief7();
                }
                //跳转野外首领(单人辉黯双城)
                if(AtFairyConfig.getOption("chief8").equals("1")){
                    singleTask.chief8();
                }
                //跳转野外首领(单人秩序高地)
                if(AtFairyConfig.getOption("chief9").equals("1")){
                    singleTask.chief9();
                }
                //跳转野外首领(单人冰风谷)
                if(AtFairyConfig.getOption("chief10").equals("1")){
                    singleTask.chief10();
                }
                //跳转要塞任务
                if(AtFairyConfig.getOption("ft").equals("1")){
                    singleTask.fort();
                }
                break;
            case 2450:
                /**
                 * 日常(组队任务)
                 */
                //跳转暴风裂隙(组队)
                if(AtFairyConfig.getOption("qr").equals("1")){
                    teamTask.Storm();
                }
                //跳转狮心荣耀(组队)
                if(AtFairyConfig.getOption("sts").equals("1")){
                    teamTask.Lion();
                }
                //跳转狮心荣耀(单人)
                if(AtFairyConfig.getOption("st").equals("1")){
                    teamTask.Lion2();
                }
                //跳转一见衷心(组队)
                if(AtFairyConfig.getOption("uv").equals("1")){

                }
                //跳转狼人入侵(组队)
                if(AtFairyConfig.getOption("ba2").equals("1")){
                    teamTask.intrusion2();
                }
                break;
            /**
             * 日常(挂机任务、限时任务)
             */
            case 2440:
//                 //跳转炼金初试(限时)
//                 if(AtFairyConfig.getOption("rg").equals("1")){
//                     timingActivity.Glory();
//                 }
                //跳转炼金初试(限时)
                if(AtFairyConfig.getOption("wx").equals("1")){
                    timingActivity.smelting();
                }
                //跳转守护要塞(限时)
                if(AtFairyConfig.getOption("yz").equals("1")){
                    timingActivity.fortress();
                }
                //跳转狼人入侵(限时)
                if(AtFairyConfig.getOption("ba").equals("1")){
                    timingActivity.intrusion();
                }
                //跳转猩红之猎(限时)
                if(AtFairyConfig.getOption("dc").equals("1")){
                    timingActivity.smelting();
                }
                //跳转世界首领(限时)
                if(AtFairyConfig.getOption("fe").equals("1")){
                    timingActivity.chief();
                }
                //跳转篝火晚宴(限时)
                if(AtFairyConfig.getOption("hg").equals("1")){
                    timingActivity.Dinner();
                }
                //跳转怪物攻城(公会)(限时)
                if(AtFairyConfig.getOption("ji").equals("1")){
                    timingActivity.monster();
                }
                //跳转正式工会战(第三轮)(限时)
                if(AtFairyConfig.getOption("lk").equals("1")){
                    timingActivity.warThree();
                }
                //跳转正式工会战(第四轮)(限时)
                if(AtFairyConfig.getOption("nm").equals("1")){
                    timingActivity.warFour();
                }
                //跳转永夜战场(限时)
                if(AtFairyConfig.getOption("po").equals("1")){
                    timingActivity.Eternal();
                }
                //跳转冰风谷战场(限时)
                if(AtFairyConfig.getOption("rq").equals("1")){
                    timingActivity.Valley();
                }
                //跳转地宫寻宝(限时)
                if(AtFairyConfig.getOption("ts").equals("1")){
                    timingActivity.underground();
                }
                //跳转炼金复试(单人)(限时)
                if(AtFairyConfig.getOption("vu").equals("1")){
                    timingActivity.Retest();
                }
                //跳转炼金终试(单人)(限时)
                if(AtFairyConfig.getOption("xw").equals("1")){
                    timingActivity.Final();
                }
                //跳转神庙迷宫(本服)(限时)
                if(AtFairyConfig.getOption("zy").equals("1")){
                    timingActivity.maze();
                }
                //跳转神赐盛宴(公会)(限时)
                if(AtFairyConfig.getOption("ae").equals("1")){
                    timingActivity.feast();
                }
                //跳转公会竞速(公会)(限时)
                if(AtFairyConfig.getOption("af").equals("1")){
                    timingActivity.speed();
                }
                //跳转正式工会战(第一轮)(限时)
                if(AtFairyConfig.getOption("ag").equals("1")){
                    timingActivity.warFirst();
                }
                //跳转正式工会战(第二轮)(限时)
                if(AtFairyConfig.getOption("ah").equals("1")){
                    timingActivity.warTwo();
                }
                //跳转3对3实力为王(限时)
                if(AtFairyConfig.getOption("ai").equals("1")){
                    timingActivity.king();  //知道了不确定
                }
                //跳转暴风幻境(公会)(限时)
                if(AtFairyConfig.getOption("aj").equals("1")){
                    timingActivity.Dreamland();
                }
                //跳转跨服领地战(限时)
                if(AtFairyConfig.getOption("ak").equals("1")){
                    timingActivity.territory();
                }
                //跳转盗宝哥布林(不限)(限时)
                if(AtFairyConfig.getOption("al").equals("1")){
                    timingActivity.Stealing();
                }
                //寒冰女王宝藏争夺战(限时)
                if(AtFairyConfig.getOption("am").equals("1")){
                    timingActivity.queen();
                }
                //跳转野外挂机
                if(AtFairyConfig.getOption("an").equals("1")){
                    limitlessTask.outdoorsOnHook();
                }
                break;
            case 2472:
                /**
                 * 其他任务
                 */
                //清包红
                if(AtFairyConfig.getOption("qb1").equals("1")){
                    otherGame.Clear();
                }
                //清包橙
                if(AtFairyConfig.getOption("Clear2").equals("1")){
                    otherGame.Clear2();
                }
                //转职
                if(AtFairyConfig.getOption("zz1").equals("1")){
                    otherGame.Transfer();
                }
                //签到领奖
                if(AtFairyConfig.getOption("reward").equals("1")){
                    otherGame.reward();
                }
                //神魔战令
                if(AtFairyConfig.getOption("Ghost").equals("1")){
                    otherGame.Ghost();
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
