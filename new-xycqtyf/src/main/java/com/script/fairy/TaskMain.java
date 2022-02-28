package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
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
         mFairy.setGameName("新轩辕传奇体验服任务");
         mFairy.setGameVersion(823);

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

         if (task_id!=1939&&task_id!=100&&task_id!=2161&&!AtFairyConfig.getOption("test").equals("1")){
             gameUtil.setUp();
         }
         switch (task_id) {
             //单人日常
             case 2669:
                 LtLog.e("1937中");
                 if(!AtFairyConfig.getOption("test").equals("1")){
                     gameUtil.goCity("轩辕");//不在测试 回城
                 }
                 if (AtFairyConfig.getOption("qdzh").equals("1")){
                     gameUtil.fuli();//签到追回
                 }
                 if (AtFairyConfig.getOption("wk").equals("1")){
                     singleTask.wk();//挖矿
                 }
                 if (AtFairyConfig.getOption("qb").equals("1")){
                     gameUtil.clearBag();//清理背包
                 }
                 if (AtFairyConfig.getOption("sjbs").equals("1")){
                     gameUtil.baoshi();//宝石
                 }
                 if (AtFairyConfig.getOption("sywp").equals("1")){
                     gameUtil.goods();//使用物品
                 }
                 if (AtFairyConfig.getOption("7878").equals("1")){
                     gameUtil.goods2();//使用物品
                 }
                 if (AtFairyConfig.getOption("szbt").equals("1")){
                     gameUtil.szcbt();//氏族宝藏
                 }
                 if (AtFairyConfig.getOption("lctx").equals("1")){
                     gameUtil.tanxian();//灵宠探险
                 }
                 if (AtFairyConfig.getOption("yinsm").equals("1")){
                     singleTask.teacher();//师门
                     gameUtil.goCity("轩辕");
                 }
                 if (AtFairyConfig.getOption("kj").equals("1")){
                     singleTask.keju2();//科举
                 }
                 if (AtFairyConfig.getOption("yinttt").equals("1")){
                     singleTask.tongtianta();//通天塔
                 }
                 if (AtFairyConfig.getOption("zvsl").equals("1")){
                     singleTask.chired();//子女试炼
                 }
                 if (AtFairyConfig.getOption("5193").equals("1")){//5193
                     singleTask.tianming();//天命
                 }
                 if (AtFairyConfig.getOption("yinjgly").equals("1")){
                     singleTask.jgly();//建功立业
                 }
                 if (AtFairyConfig.getOption("yinbz").equals("1")){
                     singleTask.cbt();//藏宝图
                 }
                 /*if (AtFairyConfig.getOption("szbt").equals("1")){
                     singleTask.cbt();//氏族宝藏图
                 }*/
                 if (AtFairyConfig.getOption("dxcb").equals("1")){
                     gameUtil.goCity("轩辕");
                     gameUtil.coordinate("轩辕",147,257);
                     singleTask.visit();//雕像参拜
                     singleTask.visit();//雕像参拜
                 }
                 if (AtFairyConfig.getOption("5189").equals("1")){
                     singleTask.xmqf();//血盟祈福
                 }
                 if (AtFairyConfig.getOption("xmrw").equals("1")){
                     singleTask.xmrw();//血盟任务
                 }
                 if (AtFairyConfig.getOption("zhzs").equals("1")){
                     singleTask.zhzs();//部落战火正盛
                 }
                 if (AtFairyConfig.getOption("szmt").equals("1")){
                     singleTask.szmt();//氏族密探
                 }
                 if (AtFairyConfig.getOption("mqtc").equals("1")){
                     singleTask.mqtc();//魔气探查
                 }
                 if (AtFairyConfig.getOption("jlzm").equals("1")){
                     singleTask.jlzm();//九黎之谜
                 }
                 if (AtFairyConfig.getOption("8169").equals("1")){
                     singleTask.mrjc();//每日建材
                 }
                 if (AtFairyConfig.getOption("5191").equals("1")){
                     singleTask.szzyzd();//氏族资源
                 }
                 break;
             //副本
             case 2659:
                 gameUtil.goCity("轩辕");
                 if (AtFairyConfig.getOption("sdl").equals("1")){
                     if (AtFairyConfig.getOption("mrfb").equals("1")){
                         teamTask.aDragon1("mrfb.png");
                     }
                     if (AtFairyConfig.getOption("qsz").equals("1")){
                         teamTask.aDragon1("qishazhen.png");
                     }
                     if (AtFairyConfig.getOption("nsj").equals("1")){
                         teamTask.aDragon1("nishijing.png");
                     }
                     if (AtFairyConfig.getOption("xzl").equals("1")){
                         teamTask.aDragon1("xiezunling.png");
                     }
                     if (AtFairyConfig.getOption("pyg").equals("1")){
                         teamTask.aDragon1("poyougu.png");
                     }
                     if (AtFairyConfig.getOption("zrd").equals("1")){
                         teamTask.aDragon1("zhurongdian.png");
                     }

                 }else {
                     if (AtFairyConfig.getOption("mrfb").equals("1")){
                         teamTask.aDragon("mrfb.png");
                     }
                     if (AtFairyConfig.getOption("qsz").equals("1")){
                         teamTask.aDragon("qishazhen.png");
                     }
                     if (AtFairyConfig.getOption("nsj").equals("1")){
                         teamTask.aDragon("nishijing.png");
                     }
                     if (AtFairyConfig.getOption("xzl").equals("1")){
                         teamTask.aDragon("xiezunling.png");
                     }
                     if (AtFairyConfig.getOption("pyg").equals("1")){
                         teamTask.aDragon("poyougu.png");
                     }
                     if (AtFairyConfig.getOption("zrd").equals("1")){
                         teamTask.aDragon("zhurongdian.png");
                     }
                 }
                 break;
             //定点挂机
             case 2675:
                 timingActivity.timingActivity();

                 if (AtFairyConfig.getOption("qdzh").equals("1")){
                     gameUtil.fuli();//签到追回
                 }

                 limitlessTask.fieldHangMachine();
                 break;
             case 2671:
                 singleTask.novice();
                 break;
             case 2677:
                 if (mFairy.dateHour()>=10){
                     if (AtFairyConfig.getOption("gddxz").equals("1")){
                         otherGame.dxz1();
                     }else {
                         gameUtil.goCity("轩辕");
                         otherGame.dxz();
                     }
                 }
                 break;
             case 1234:
                 singleTask.wk();
                 break;
             case 2470:
                 timingActivity.demo();
                 break;
            /* //单人日常
             case 2380:
                 if(!AtFairyConfig.getOption("test").equals("1")){
                     gameUtil.goCity("轩辕");//不在测试 回城
                 }
                 if (AtFairyConfig.getOption("qdzh").equals("1")){
                     gameUtil.fuli();//签到追回
                 }
                 if (AtFairyConfig.getOption("qb").equals("1")){
                     gameUtil.clearBag();//清理背包
                 }
                 if (AtFairyConfig.getOption("sjbs").equals("1")){
                     gameUtil.baoshi();//宝石
                 }
                 if (AtFairyConfig.getOption("sywp").equals("1")){
                     gameUtil.goods();//使用物品
                 }
                 if (AtFairyConfig.getOption("lctx").equals("1")){
                     gameUtil.tanxian();//灵宠探险
                 }
                 if (AtFairyConfig.getOption("yinsm").equals("1")){
                     singleTask.teacher();//师门
                     gameUtil.goCity("轩辕");
                 }
                 if (AtFairyConfig.getOption("kj").equals("1")){
                     singleTask.keju();//科举
                 }
                 if (AtFairyConfig.getOption("yinttt").equals("1")){
                     singleTask.tongtianta();//通天塔
                 }
                 if (AtFairyConfig.getOption("7206").equals("1")){
                     singleTask.tianming();//天命
                 }
                 if (AtFairyConfig.getOption("yinjgly").equals("1")){
                     singleTask.jgly();//建功立业
                 }
                 if (AtFairyConfig.getOption("yinbz").equals("1")){
                     singleTask.cbt();//藏宝图
                 }
                 if (AtFairyConfig.getOption("dxcb").equals("1")){
                     gameUtil.goCity("轩辕");
                     gameUtil.coordinate("轩辕",147,257);
                     singleTask.visit();//雕像参拜
                     singleTask.visit();//雕像参拜
                 }
                 if (AtFairyConfig.getOption("7202").equals("1")){
                     singleTask.xmqf();//血盟祈福
                 }
                 if (AtFairyConfig.getOption("xmrw").equals("1")){
                     singleTask.xmrw();//血盟任务
                 }
                 if (AtFairyConfig.getOption("szmt").equals("1")){
                     singleTask.szmt();//氏族密探
                 }
                 if (AtFairyConfig.getOption("7204").equals("1")){
                     singleTask.szzyzd();//氏族资源
                 }
                 break;
             //副本
             case 2384:
                 gameUtil.goCity("轩辕");
                 if (AtFairyConfig.getOption("sdl").equals("1")){
                     if (AtFairyConfig.getOption("mrfb").equals("1")){
                         LtLog.e("每日副本");
                         teamTask.aDragon1("mrfb.png");
                     }
                     if (AtFairyConfig.getOption("qsz").equals("1")){
                         LtLog.e("七杀阵");
                         teamTask.aDragon1("qishazhen.png");
                     }
                     if (AtFairyConfig.getOption("nsj").equals("1")){
                         LtLog.e("逆试镜");
                         teamTask.aDragon1("nishijing.png");
                     }
                     if (AtFairyConfig.getOption("xzl").equals("1")){
                         LtLog.e("邪尊零");
                         teamTask.aDragon1("xiezunling.png");
                     }
                     if (AtFairyConfig.getOption("pyg").equals("1")){
                         LtLog.e("破幽谷");
                         teamTask.aDragon1("poyougu.png");
                     }
                     if (AtFairyConfig.getOption("zrd").equals("1")){
                         LtLog.e("祝融殿");
                         teamTask.aDragon1("zhurongdian.png");
                     }

                 }else {
                     if (AtFairyConfig.getOption("mrfb").equals("1")){
                         teamTask.aDragon("mrfb.png");
                     }
                     if (AtFairyConfig.getOption("qsz").equals("1")){
                         teamTask.aDragon("qishazhen.png");
                     }
                     if (AtFairyConfig.getOption("nsj").equals("1")){
                         teamTask.aDragon("nishijing.png");
                     }
                     if (AtFairyConfig.getOption("xzl").equals("1")){
                         teamTask.aDragon("xiezunling.png");
                     }
                     if (AtFairyConfig.getOption("pyg").equals("1")){
                         teamTask.aDragon("poyougu.png");
                     }
                     if (AtFairyConfig.getOption("zrd").equals("1")){
                         teamTask.aDragon("zhurongdian.png");
                     }
                 }
                 break;
             //定点挂机
             case 2386:
                 if (AtFairyConfig.getOption("qdzh").equals("1")){
                     gameUtil.fuli();//签到追回
                 }
                 limitlessTask.fieldHangMachine();
                 break;
             case 2382:
                 singleTask.novice();
                 break;
             case 2388:
                 if (mFairy.dateHour()>=10){
                     if (AtFairyConfig.getOption("gddxz").equals("1")){
                         otherGame.dxz1();
                     }else {
                         gameUtil.goCity("轩辕");
                         otherGame.dxz();
                     }
                 }
                 break;*/
             case 2665:
                 gameUtil.goCity("轩辕");
                 singleTask.cw();
                 break;
             case 2681:
                 timingActivity.hejiu();
                 break;
         }
         mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
         Thread.sleep(2000);
         LtLog.e("sase后");
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
