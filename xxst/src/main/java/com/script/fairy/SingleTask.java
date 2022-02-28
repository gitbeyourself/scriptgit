package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    List<String> list = new ArrayList<>();

    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);

    }

    public void novice() throws Exception {
        while (mFairy.condit()) {
            LtLog.e(mFairy.getLineInfo("新手引导中"));

            result = mFairy.findPic(1031, 141, 1115, 419, "main.png");
            mFairy.onTap(0.7f, result, "主线", 5000);
            if (result.sim < 0.7f) {
                for (int i = 0; i < 3; i++) {
                    mFairy.onTap(1219, 183, 1232, 196, "跳引导", 100);
                }
                Thread.sleep(3000);
            }
            result = mFairy.findPic("End of Main Line.png");
            LtLog.e(mFairy.getLineInfo(0.8f, result, "主线结束"));
            if (result.sim > 0.8f) {
                break;
            }

            result = mFairy.findPic(501,486,776,685, "or.png");
            if (result.sim > 0.8f) {
                Random random = new Random();
                int num = random.nextInt(2) + 1;
                if (num==1){
                    mFairy.onTap(0.8f, result, 399,589,454,615,"选择1", 1000);
                }else if (num==2){
                    mFairy.onTap(0.8f, result, 798,580,870,618,"选择2", 1000);
                }
            }

            result = mFairy.findPic(915, 159, 1159, 535, "bjzd.png");
            mFairy.onTap(0.8f, result, 984,411,1029,431,"便捷组队点上面", 1000);

            result = mFairy.findPic(918,119,1143,660,"Grade Gift Pack Collection.png");
            mFairy.onTap(0.8f, result, "等级礼包领取", 1000);
            mFairy.onTap(0.8f, result, 1191,69,1203,80,"等级礼包领取关闭", 1000);

            result = mFairy.findPic("skip.png");
            mFairy.onTap(0.8f, result, 1217, 22, 1238, 33, "跳过动画", 1000);

            result = mFairy.findPic("Right side task.png");
            mFairy.onTap(0.8f, result, "右侧任务", 1000);

            result = mFairy.findPic("Right side task1.png");
            mFairy.onTap(0.8f, result, "右侧任务", 1000);

            result = mFairy.findPic("Got it.png");
            mFairy.onTap(0.8f, result, "知道了", 1000);

            result = mFairy.findPic(201, 70, 1242, 586, "tap.png");
            mFairy.onTap(0.8f, result, "点击", 1000);


      /*      result = mFairy.findPic("Choose pets.png");
            mFairy.onTap(0.8f, result, 250, 361, 288, 394, "选择宠物", 1000);*/

          /*  result = mFairy.findPic("Take her home.png");
            mFairy.onTap(0.8f, result, "带她回家", 1000);*/

            result = mFairy.findPic(547, 488, 798, 589, "instructions.png");
            mFairy.onTap(0.8f, result, 1200, 472, 1209, 481, "指令", 1000);
            mFairy.onTap(0.8f, result, 535, 242, 551, 255, "指令", 1000);
            mFairy.onTap(0.8f, result, 1134, 559, 1159, 578, "指令", 1000);
            mFairy.onTap(0.8f, result, 535, 242, 551, 255, "指令", 1000);

            result = mFairy.findPic("I can bear it..png");
            mFairy.onTap(0.8f, result, "我可以忍", 1000);

            result = mFairy.findPic("Feeding grass.png");
            mFairy.onTap(0.8f, result, "喂草", 1000);

            result = mFairy.findPic(14,489,1261,708,"Look for1.png");
            if (result.sim > 0.8f) {
                result = mFairy.findPic(237, 550, 1170, 673, "Look for.png");
                mFairy.onTap(0.8f, result, "寻访", 5000);
                mFairy.onTap(0.8f, result, 287, 654, 313, 665, "寻访返回", 1000);
            }


            result = mFairy.findPic("Search and Return.png");
            mFairy.onTap(0.8f, result, "寻访返回", 1000);

            result = mFairy.findPic("Picture scroll.png");
            if (result.sim > 0.8f) {
                mFairy.touchDown(2, 239, 482);
                mFairy.touchMove(2, 395, 299, 1000);
                mFairy.touchMove(2, 514, 550, 1000);
                mFairy.touchMove(2, 712, 369, 1000);
                mFairy.touchMove(2, 871, 514, 1000);
                mFairy.touchMove(2, 1057, 322, 1000);
                mFairy.touchUp(2);
            }

            result = mFairy.findPic("love flower.png");
            if (result.sim > 0.8f) {
                mFairy.touchDown(2, 275, 158);
                mFairy.touchMove(2, 665, 145, 1000);
                mFairy.touchUp(2);

                mFairy.touchDown(2, 172, 416);
                mFairy.touchMove(2, 484, 497, 1000);
                mFairy.touchUp(2);

                mFairy.touchDown(2, 1113, 489);
                mFairy.touchMove(2, 795, 491, 1000);
                mFairy.touchUp(2);
            }

            result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork.png","fork2.png"});
            mFairy.onTap(0.9f, result, "叉", 1000);

            result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork1.png","fork3.png"});
            mFairy.onTap(0.9f, result, "叉", 1000);

        }

    }

    public void novice1() throws Exception {
        while (mFairy.condit()) {
            LtLog.e(mFairy.getLineInfo("新手引导中"));

            result = mFairy.findPic(891,93,1269,547,"qiyu.png" );
            mFairy.onTap(0.7f, result, "奇遇", 2000);



            result = mFairy.findPic(501,486,776,685, "or.png");
            if (result.sim > 0.8f) {
                Random random = new Random();
                int num = random.nextInt(2) + 1;
                if (num==1){
                    mFairy.onTap(0.8f, result, 399,589,454,615,"选择1", 1000);
                }else if (num==2){
                    mFairy.onTap(0.8f, result, 798,580,870,618,"选择2", 1000);
                }
            }

            result = mFairy.findPic("chengying_other.png");
            if (result.sim > 0.8f) {
                mFairy.touchDown(2, 517,384);
                mFairy.touchMove(2, 753,369, 1000);
                mFairy.touchMove(2, 517,384, 1000);
                mFairy.touchMove(2, 753,369, 1000);
                mFairy.touchMove(2, 517,384, 1000);
                mFairy.touchMove(2, 753,369, 1000);
                mFairy.touchUp(2);
            }
            result = mFairy.findPic("other_sure.png");
            mFairy.onTap(0.8f, result, "上交任务物品确定", 1000);

            result = mFairy.findPic(915, 159, 1159, 535, "bjzd.png");
            mFairy.onTap(0.8f, result, 984,411,1029,431,"便捷组队点上面", 1000);

            result = mFairy.findPic(918,119,1143,660,"Grade Gift Pack Collection.png");
            mFairy.onTap(0.8f, result, "等级礼包领取", 1000);
            mFairy.onTap(0.8f, result, 1191,69,1203,80,"等级礼包领取关闭", 1000);

            result = mFairy.findPic("skip.png");
            mFairy.onTap(0.8f, result, 1217, 22, 1238, 33, "跳过动画", 1000);

            result = mFairy.findPic("Right side task.png");
            mFairy.onTap(0.8f, result, "右侧任务", 1000);

            result = mFairy.findPic("Right side task1.png");
            mFairy.onTap(0.8f, result, "右侧任务", 1000);

            result = mFairy.findPic("Got it.png");
            mFairy.onTap(0.8f, result, "知道了", 1000);

            result = mFairy.findPic(201, 70, 1242, 586, "tap.png");
            mFairy.onTap(0.8f, result, "点击", 1000);


            result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork.png","fork2.png"});
            mFairy.onTap(0.9f, result, "叉", 1000);

            result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork1.png","fork3.png"});
            mFairy.onTap(0.9f, result, "叉", 1000);

        }

    }
    public void novice2() throws Exception {
        long qbtime=0,pktime=0,grboss=0,ywboss=0,sjtime=0;
        while (mFairy.condit()) {
            LtLog.e(mFairy.getLineInfo("新手引导中"));

            result = mFairy.findPic("Start the journey.png" );
            mFairy.onTap(0.8f, result, "开始征程", 1000);

            result = mFairy.findPic("task.png" );
            mFairy.onTap(0.8f, result, 351,1038,372,1050,"任务", 1000);

            result = mFairy.findPic("fail.png" );
            if (result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("失败"));
                Thread.sleep(5000);
                mFairy.onTap(0.8f, result, 255,1196,282,1218,"技能", 1000);
                mFairy.onTap(0.8f, result, 335,1015,380,1031,"全部升级", 1000);
                result = mFairy.findPic(241,761,712,1271,new String[]{"game_return.png","game_return1.png"} );
                mFairy.onTap(0.8f, result, "返回", 1000);
                mFairy.onTap(0.8f, result, 166,1202,188,1222,"角色", 1000);
                mFairy.onTap(0.8f, result, 333,749,384,771,"一键换装", 1000);
                result = mFairy.findPic(241,761,712,1271,new String[]{"game_return.png","game_return1.png"} );
                mFairy.onTap(0.8f, result, "返回", 1000);
                mFairy.onTap(0.8f, result, 455,1195,479,1214,"强化", 1000);
            }

            result = mFairy.findPic(0,0,720,1280,"Right Guidance.png" );
            mFairy.onTap(0.9f, result, result.x+105,result.y+3,result.x+106,result.y+4,"err右指引", 1000);

            result = mFairy.findPic(0,0,720,1280,"Left Guidance.png" );
            mFairy.onTap(0.9f, result, result.x-76,result.y+2,result.x-75,result.y+3,"err左指引", 1000);

            result = mFairy.findPic(0,0,720,1280,"Garish.png" );
            mFairy.onTap(0.9f, result, result.x+30,result.y,result.x+40,result.y+5,"err花里胡哨", 1000);

            result = mFairy.findPic("qbsj.png" );
            mFairy.onTap(0.8f, result, "e全部升级", 1000);




            result = mFairy.findPic("Go to smelting.png" );
            mFairy.onTap(0.8f, result, "前往熔炼", 2000);

            result = mFairy.findPic("melting.png" );
            if (result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("熔炼"));
                for (int i=0;i<10;i++){
                    mFairy.tap(result.x,result.y);
                }
                mFairy.condit();
            }
            result = mFairy.findPic("Strengthen.png" );
            if (result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("强化"));
                for (int i=0;i<30;i++){
                    mFairy.tap(result.x,result.y);
                }
                mFairy.condit();
            }
            result = mFairy.findPic("Practice.png" );
            if (result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("修炼"));
                for (int i=0;i<30;i++){
                    mFairy.tap(result.x,result.y);
                }
                mFairy.condit();
            }
            result = mFairy.findPic("Chong pulse.png" );
            if (result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("冲脉"));
                for (int i=0;i<10;i++){
                    mFairy.tap(result.x,result.y);
                }
                mFairy.condit();
            }
            result = mFairy.findPic("tisheng.png" );
            if (result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("提升"));
                for (int i=0;i<10;i++){
                    mFairy.tap(result.x,result.y);
                }
                mFairy.condit();
            }

            result = mFairy.findPic(new String[]{"mifa.png","mifa1.png"} );
            if (result.sim>0.8f){
                mFairy.onTap(0.8f, result, 471,975,489,991,"秘法", 1000);
                mFairy.onTap(0.8f, result, 340,897,382,922,"激活", 1000);
                mFairy.onTap(0.8f, result, 224,1038,256,1055,"秘法", 1000);
                mFairy.onTap(0.8f, result, 340,897,382,922,"激活", 1000);
                mFairy.onTap(0.8f, result, 480,1040,511,1053,"秘法", 1000);
                mFairy.onTap(0.8f, result, 340,897,382,922,"激活", 1000);
            }
            result = mFairy.findPic(19,15,704,1073,new String[]{"fb_tiaozhan.png","fb_shaodang.png","zhaohui.png"} );
            mFairy.onTap(0.8f, result, "副本挑战扫荡", 1000);

            result = mFairy.findPic(new String[]{"zhaohui1.png","Challenge1.png"} );
            mFairy.onTap(0.8f, result, "1副本挑战扫荡", 1000);

            result = mFairy.findPic(new String[]{"ttt_tiaozhan.png"} );
            mFairy.onTap(0.8f, result, "通天塔挑战", 1000);


            result = mFairy.findPic("zhaohui_lq_mf.png" );
            mFairy.onTap(0.8f, result, "找回领取免费", 1000);

            result = mFairy.findPic("sure1.png" );
            mFairy.onTap(0.8f, result, "确定领取", 1000);


            result = mFairy.findPic("casting.png" );
            mFairy.onTap(0.8f, result, "铸造", 1000);

            result = mFairy.findPic("activation.png" );
            mFairy.onTap(0.8f, result, "激活", 1000);



            result = mFairy.findPic("yy_shengjie.png" );
            mFairy.onTap(0.8f, result, "一键升阶", 5000);

            result = mFairy.findPic("pkChallenge.png" );
            mFairy.onTap(0.8f, result, "pk挑战", 1000);

            result = mFairy.findPic("Challenge.png" );
            mFairy.onTap(0.8f, result, "个人boss挑战", 1000);

            result = mFairy.findPic(433,69,698,1074,"yw_tiaozhan.png" );
            mFairy.onTap(0.8f, result, "野外挑战", 1000);


            result = mFairy.findPic(241,761,712,1271,new String[]{"game_return.png","game_return1.png"} );
            mFairy.onTap(0.8f, result, "返回", 1000);

            result = mFairy.findPic("zidong.png" );
            mFairy.onTap(0.8f, result, "自动战斗", 1000);


            if (System.currentTimeMillis()-qbtime>360000){
                LtLog.e(mFairy.getLineInfo("清包"));
                result = mFairy.findPic("juese.png" );
                mFairy.onTap(0.8f, result, 552,1199,574,1215,"包裹", 2000);
                mFairy.onTap(0.8f, result, 545,1004,601,1027,"熔炼", 1000);
                qbtime=System.currentTimeMillis();
            }
            if (System.currentTimeMillis()-sjtime>300000){
                LtLog.e(mFairy.getLineInfo("升级东西"));
                result = mFairy.findPic("juese.png" );
                    mFairy.onTap(0.8f, result, 255,1196,282,1218,"技能", 1000);
                    mFairy.onTap(0.8f, result, 335,1015,380,1031,"全部升级", 1000);
                    result = mFairy.findPic(241,761,712,1271,new String[]{"game_return.png","game_return1.png"} );
                    mFairy.onTap(0.8f, result, "返回", 1000);
                    mFairy.onTap(0.8f, result, 166,1202,188,1222,"角色", 1000);
                    mFairy.onTap(0.8f, result, 333,749,384,771,"一键换装", 1000);
                    result = mFairy.findPic(241,761,712,1271,new String[]{"game_return.png","game_return1.png"} );
                    mFairy.onTap(0.8f, result, "返回", 1000);
                    mFairy.onTap(0.8f, result, 455,1195,479,1214,"强化", 1000);
                 sjtime=System.currentTimeMillis();
            }
            if (System.currentTimeMillis()-grboss>240000){
                LtLog.e(mFairy.getLineInfo("个人boss"));
                result = mFairy.findPic("task.png" );
                mFairy.onTap(0.8f, result, 646,851,680,865,"boss个人", 2000);
                mFairy.onTap(0.8f, result, 63,1100,91,1118,"个人", 1000);
                grboss=System.currentTimeMillis();
            }

            if (System.currentTimeMillis()-ywboss>180000){
                LtLog.e(mFairy.getLineInfo("野外boss"));
                result = mFairy.findPic("task.png" );
                mFairy.onTap(0.8f, result, 646,851,680,865,"boss野外", 2000);
                mFairy.onTap(0.8f, result, 208,1103,242,1120,"野外", 1000);
                ywboss=System.currentTimeMillis();
            }

            if (System.currentTimeMillis()-pktime>120000){
                LtLog.e(mFairy.getLineInfo("pk中"));
                result = mFairy.findPic("task.png" );
                mFairy.onTap(0.8f, result, 657,712,691,729,"pk", 2000);
                pktime=System.currentTimeMillis();
            }
        }

    }

    abstract class singleTaskContent extends TaskContent {
        public singleTaskContent(AtFairyImpl mFairy) throws Exception {
            super(mFairy);
        }

        @Override
        void create() throws Exception {
            TASKNAME = "单人日常";
            //烽火令
            if (AtFairyConfig.getOption("fhl").equals("1")) {
                list.add("fhl.png");
            }
            //翰林求学
            if (AtFairyConfig.getOption("hlqx").equals("1")) {
                list.add("hlqx.png");
            }
            //盖世英雄
            if (AtFairyConfig.getOption("sm").equals("1")) {
                list.add("gsyx.png");
            }
            //天下奇闻
            if (AtFairyConfig.getOption("txqw").equals("1")) {
                list.add("txqw.png");
            }
            //帮派任务
            if (AtFairyConfig.getOption("bprw").equals("1")) {
                list.add("bprw.png");
            }
            //恩仇录
            if (AtFairyConfig.getOption("ecl").equals("1")) {
                list.add("ecl.png");
            }
            //丝绸之路
            if (AtFairyConfig.getOption("sczl").equals("1")) {
                list.add("sczl.png");
            }
            //竞技场
            if (AtFairyConfig.getOption("jjc").equals("1")) {
                list.add("jjc.png");
            }
            //踏雪无痕
            if (AtFairyConfig.getOption("txwh").equals("1")) {
                list.add("txwh.png");
            }
            //名人逸事
            if (AtFairyConfig.getOption("mrys").equals("1")) {
                list.add("mrys.png");
            }
            //萌雕快跑
            if (AtFairyConfig.getOption("mdkp").equals("1")) {
                list.add("mdkp.png");
            }
            if (list.size() == 0) {
                setTaskEnd();
                return;
            }
        }

        @Override
        void init() throws Exception {
            if (list.size() == 0) {
                setTaskEnd();
                return;
            }
            util.signOutXX();
            util.outTeam();
            util.switchbar("任务");
            setTaskName(1);
        }

        @Override
        void inOperation() throws Exception {
            LtLog.e(mFairy.getLineInfo("list===" + list.toString()));
        }

        @Override
        void content_01() throws Exception {
            int ret = util.findTask(list.get(0),"前往" ,"日常", "全部");
            if (ret == 1) {
                mFairy.initMatTime();
                setTaskName(2);
            } else if (ret == 0) {
                LtLog.e(mFairy.getLineInfo("移除一个任务"));
                mFairy.initMatTime();
                list.remove(0);
                if (list.size() == 0) {
                    LtLog.e(mFairy.getLineInfo("没有任务了结束"));
                    setTaskEnd();
                    return;
                }
            }
        }

        @Override
        void content_02() throws Exception {
            setTaskName(3);
        }
    }
    //单人任务
    public void daily() throws Exception {

        new singleTaskContent(mFairy) {
            long dazeTime = 0;

            @Override
            void create() throws Exception {
                super.create();
            }

            void content_03() throws Exception {
                overtime(50, 0);
                result = mFairy.findPic(203,3,783,289, "activity.png");
                if (result.sim > 0.8f) {
                    dazeTime = mFairy.mMatTime(117, 48, 41, 14, 0.9f);
                    LtLog.e(mFairy.getLineInfo("发呆时间===" + dazeTime));
                    err = 0;
                } else {
                    mFairy.initMatTime();
                    dazeTime=0;
                }
                result = mFairy.findPic("In battle.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    err = 0;
                }
                if (list.get(0).equals("fhl.png")) {
                    result = mFairy.findPic("Receiving Tasks.png");
                    mFairy.onTap(0.8f, result,"领取任务", 1000);
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("烽火令结束"));
                        util.close();
                        list.remove(0);
                        setTaskName(0);
                    }
                }
                if (list.get(0).equals("hlqx.png")) {
                    result = mFairy.findPic("hlqx_inface.png");
                    mFairy.onTap(0.8f, result, 648, 327, 670, 340, "翰林求学界面", 1000);

                    result = mFairy.findPic("hlqx_end.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("翰林求学结束"));
                        util.close();
                        list.remove(0);
                        setTaskName(0);
                    }
                }

                if (list.get(0).equals("gsyx.png")) {
                    result = mFairy.findPic(915, 159, 1159, 535, "Right_gsyx.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);

                    result = mFairy.findPic("turntable.png");
                    mFairy.onTap(0.8f, result, "转盘开", 5000);
                    mFairy.onTap(0.8f, result, "转盘停", 2000);

                    result = mFairy.findPic(891,93,1269,547, "Taskbar Division Gate.png");
                    if (dazeTime > 7) {
                        if (result.sim > 0.7f) {
                            mFairy.onTap(0.7f, result, "右侧师门", 1000);
                            mFairy.initMatTime();
                            dazeTime=0;
                        } else {
                            setTaskName(0);
                        }
                    }
                }

                if (list.get(0).equals("txqw.png")) {
                    result = mFairy.findPic(915, 159, 1159, 535, "Right_txqw.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);

                    result = mFairy.findPic("txqw_Receive.png");
                    mFairy.onTap(0.8f, result, "天下奇闻领取", 2000);
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("txqw_Receive.png");
                        mFairy.onTap(0.8f, result, 393,263,406,286,"天下奇闻换个任务", 1000);
                        mFairy.onTap(0.8f, result, "天下奇闻领取", 2000);
                    }

                    result = mFairy.findPic(1031, 139, 1245, 516, "Taskbar txqw.png");
                    if (dazeTime > 7) {
                        if (result.sim > 0.7f) {
                            mFairy.onTap(0.7f, result, "天下奇闻", 1000);
                            mFairy.initMatTime();
                            dazeTime=0;
                        } else {
                            setTaskName(0);
                        }
                    }
                }

                if (list.get(0).equals("bprw.png")) {
                    result = mFairy.findPic("Applying for gangs.png");
                    mFairy.onTap(0.8f, result, "申请帮派", 1000);

                    result = mFairy.findPic(915, 159, 1159, 535, "Right_bprw.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);


                    result = mFairy.findPic(1031, 139, 1245, 516, "Taskbar bprw.png");
                    if (dazeTime > 7) {
                        if (result.sim > 0.7f) {
                            mFairy.onTap(0.7f, result, "帮派任务", 1000);
                            mFairy.initMatTime();
                            dazeTime=0;
                        } else {
                            setTaskName(0);
                        }
                    }
                }

                if (list.get(0).equals("ecl.png")) {

                    result = mFairy.findPic(370, 158, 626, 320, "ecl_stop.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("恩仇录结束"));
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }

                    result = mFairy.findPic(414, 265, 760, 390, "stopecl.png");
                    mFairy.onTap(0.8f, result, 521, 426, 566, 444, "恩仇录结束", 1000);
                    if (result.sim > 0.8f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }
                    result = mFairy.findPic(915, 159, 1159, 535, "Right_ecl.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);

                    result = mFairy.findPic("ecl_Get into.png");
                    mFairy.onTap(0.8f, result, "进入", 1000);

                    result = mFairy.findPic("gain.png");
                    mFairy.onTap(0.8f, result, 452,317,479,341,"增益", 1000);
                    mFairy.onTap(0.8f, result, 749,462,801,486,"增益确定", 1000);


                    result = mFairy.findPic("ecl_automatic.png");
                    mFairy.onTap(0.8f, result, "开启自动", 1000);

                    result = mFairy.findPic(1003, 143, 1276, 242, "Taskbar ecl.png");
                    if (dazeTime > 7) {
                        if (result.sim > 0.7f) {
                            mFairy.onTap(0.7f, result, "恩仇录", 1000);
                            mFairy.initMatTime();
                            dazeTime=0;
                        } else {
                            setTaskName(0);
                        }
                    }
                }

                if (list.get(0).equals("sczl.png")) {
                    result = mFairy.findPic("sczl_buy.png");
                    mFairy.onTap(0.8f, result, "购买", 1000);
                    if (result.sim > 0.8f) {
                        err=0;
                    }
                    result = mFairy.findPic("Arrangement purchase.png");
                    mFairy.onTap(0.8f, result, "摆摊购买", 1000);

                    result = mFairy.findPic("sczl_Submission.png");
                    mFairy.onTap(0.8f, result, "提交", 1000);

                    result = mFairy.findPic("sczl_Submission1.png");
                    mFairy.onTap(0.8f, result, "提交", 1000);
                    if (result.sim>0.8f){
                        result = mFairy.findPic("sczl_Submission1.png");
                        mFairy.onTap(0.8f, result, 1036,201,1053,217,"提交差个东西", 1000);
                        mFairy.onTap(0.8f, result, "提交", 1000);
                    }

                    result = mFairy.findPic("sczl_stop.png");
                    mFairy.onTap(0.8f, result, 362, 563, 390, 581, "丝绸之路结束", 1000);
                    if (result.sim > 0.8f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }
                    if (dazeTime > 30) {
                        setTaskName(0);
                        return;
                    }
                }
                if (list.get(0).equals("jjc.png")) {
                    if (dazeTime > 30) {
                        setTaskName(0);
                        return;
                    }
                    result = mFairy.findPic(191,117,1211,574,"jjc_Challenge.png");
                    mFairy.onTap(0.8f, result, 1015,599,1054,617,"刷新", 1000);
                    mFairy.onTap(0.8f, result, "挑战", 1000);

                    result = mFairy.findPic(915, 159, 1159, 535, "Right_jjc.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);

                    result = mFairy.findPic("jjc_fail.png");
                    mFairy.onTap(0.8f, result, "失败", 1000);

                    result = mFairy.findPic( "jjc_stop.png");
                    mFairy.onTap(0.9f, result, 651,485,665,504,"竞技场结束宝箱", 1000);
                    mFairy.onTap(0.9f, result, 780,483,798,499,"竞技场结束宝箱", 1000);
                    if (result.sim > 0.9f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }
                }
                if (list.get(0).equals("txwh.png")) {
                    if (dazeTime > 30) {
                        setTaskName(0);
                        return;
                    }
                    result = mFairy.findPic(915, 159, 1159, 535, "Right_txwh.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);


                    result = mFairy.findPic("txwh_stop1.png");
                    mFairy.onTap(0.8f, result, 525,425,559,446,"踏雪无痕做过了结束", 1000);
                    if (result.sim > 0.8f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }
                    result = mFairy.findPic(new String[]{"txwh_stop.png","jmdb_stop.png"});
                    mFairy.onTap(0.8f, result, "踏雪无痕结束", 1000);
                    if (result.sim > 0.8f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }

                    result = mFairy.findPic("txwh_inface.png");
                    if (result.sim > 0.8f) {
                        mFairy.initMatTime();
                        LtLog.e(mFairy.getLineInfo("踏雪无痕内"));
                        mFairy.touchDown(2,192,530);
                        mFairy.touchMove(2,117,605,2000);
                        Thread.sleep(2000);
                        mFairy.touchUp(2);
                        Thread.sleep(3000);
                        mFairy.touchDown(2,192,530);
                        mFairy.touchMove(2,259,447,2000);
                        Thread.sleep(2000);
                        mFairy.touchUp(2);
                        Thread.sleep(3000);
                    }


                }

                if (list.get(0).equals("mrys.png")) {
                    result = mFairy.findPic(915, 159, 1159, 535, "Right_mrys.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);
                    if (result.sim > 0.8f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }
                    if (dazeTime > 30) {
                        setTaskName(0);
                        return;
                    }
                }
                if (list.get(0).equals("mdkp.png")) {
                    result = mFairy.findPic("mdpp.png");
                    mFairy.onTap(0.8f, result, "开始匹配", 1000);

                    result = mFairy.findPic("mdtg.png");
                    mFairy.onTap(0.8f, result, "托管", 1000);

                    result = mFairy.findPic(915, 159, 1159, 535, "Right_mdkp.png");
                    mFairy.onTap(0.8f, result, "右侧任务", 1000);

                    result = mFairy.findPic(new String[]{"txwh_stop.png","jmdb_stop.png"});
                    mFairy.onTap(0.8f, result, 620,501,657,523,"萌雕结束", 1000);
                    if (result.sim > 0.8f) {
                        util.close();
                        setTaskName(0);
                        list.remove(0);
                        return;
                    }

                }

            }
        };
    }//
    //福利
    public void welfare() throws Exception {

        new singleTaskContent(mFairy) {
            long dazeTime = 0;
            int count=1,count1=0,count2=0;
            @Override
            void create() throws Exception {
                TASKNAME = "福利领取";
            }
            @Override
            void inOperation() throws Exception {
            }

            @Override
            void init() throws Exception {
                result = mFairy.findPic(new String[]{"welfare_inface.png","welfare_inface1.png"});
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("福利界面"));
                    setTaskName(1);
                }else {
                    util.close();
                    result = mFairy.findPic(203, 3, 783, 289, "welfare.png");
                    mFairy.onTap(0.8f, result, "主界面福利", 3000);
                }
            }
            @Override
            void content_01() throws Exception {
                overtime(200,0);
                result = mFairy.findPic(new String[]{"welfare_inface.png","welfare_inface1.png"});
                if (result.sim>0.8f){
                    if (count==1){
                        mFairy.onTap(0.8f, result, 213,160,260,183,"福利界面1", 1000);
                    }
                    if (count==2){
                        mFairy.onTap(0.8f, result, 213,234,254,253,"福利界面2", 1000);
                    }
                    if (count==3){
                        mFairy.onTap(0.8f, result,216,301,261,322, "福利界面3", 1000);
                    }
                    if (count==4){
                        mFairy.onTap(0.8f, result, 217,368,267,392,"福利界面4", 1000);
                    }
                    if (count==5){
                        mFairy.onTap(0.8f, result, 232,441,276,462,"福利界面5", 1000);
                    }
                    if (count==6){
                        mFairy.onTap(0.8f, result, 217,506,275,526,"福利界面6", 1000);
                    }
                    if (count==7){
                        setTaskName(0);
                        util.close();
                        count2++;
                        if (count2>2){
                            setTaskName(2);
                            return;
                        }else {
                            count=0;
                            setTaskName(0);
                        }
                    }
                    count1++;
                    if (count1>2){
                        count++;
                        count1=0;
                    }
                    err=0;
                }

                result = mFairy.findPic("Welfare Collection1.png");
                mFairy.onTap(0.8f, result, "登录豪礼领取", 1000);

                result = mFairy.findPic("Welfare Collection2.png");
                mFairy.onTap(0.8f, result, 1078,174,1101,192,"每日礼包领取", 1000);

                result = mFairy.findPic("Welfare Collection3.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("大侠之路"));
                    for (int i=0;i<5;i++){
                        mFairy.condit();
                        result = mFairy.findPic(382,117,1129,151,"dxred.png");
                        mFairy.onTap(0.8f, result, "大侠红点", 1000);
                        if (result.sim>0.8f){
                            i=1;
                        }
                        result = mFairy.findPic(947,198,1136,560,"dxlq.png");
                        mFairy.onTap(0.8f, result, "大侠领取", 1000);
                        if (result.sim>0.8f){
                            i=1;
                        }
                    }
                }
                result = mFairy.findPic(410,589,1089,654,"Welfare Collection4.png");
                mFairy.onTap(0.8f, result, "江湖茶楼", 1000);

                result = mFairy.findPic(410,589,1089,654,"Welfare Collection5.png");
                mFairy.onTap(0.8f, result, "签到日历", 1000);
                mFairy.onTap(0.8f, result, 625,580,661,607,"签到日历", 1000);

                result = mFairy.findPic("Welfare Collection6.png");
                mFairy.onTap(0.8f, result, 723,319,751,343,"周一豪礼", 1000);


                result = mFairy.findPic("Welfare Collection7.png");
                mFairy.onTap(0.8f, result, "聚宝树", 1000);
                if (result.sim>0.8f){
                    count1=0;
                }
                result = mFairy.findPic(929,295,1056,683,"Welfare Collection8.png");
                mFairy.onTap(0.8f, result, 950,344,1075,677,"经验追回", 1000);
                if (result.sim>0.8f){
                    count1=0;
                }
                result = mFairy.findPic("Welfare Collection9.png");
                mFairy.onTap(0.8f, result, "推送奖励", 1000);


                result = mFairy.findPic(918,119,1143,660,"Grade Gift Pack Collection.png");
                mFairy.onTap(0.8f, result, "等级礼包领取", 1000);
            }

            @Override
            void content_02() throws Exception {
                util.close();
                setTaskName(3);
                err=0;
            }
            void content_03() throws Exception {
                overtime(15,4);
                result = mFairy.findPic(203, 3, 783, 289, "activity.png");
                mFairy.onTap(0.8f, result, 33,212,55,229,"右侧福利", 1000);

                result = mFairy.findPic("Welfare Collection10.png");
                mFairy.onTap(0.8f, result, "右侧福利领取", 1000);
            }
            void content_04() throws Exception {
                util.close();
                setTaskName(5);
                err=0;
            }
            void content_05() throws Exception {
                overtime(15,6);
                result = mFairy.findPic(203, 3, 783, 289, "activity.png");
                mFairy.onTap(0.8f, result, 57,312,70,326,"右侧福利1", 1000);

                result = mFairy.findPic("Welfare Collection11.png");
                mFairy.onTap(0.8f, result, "右侧福利领取", 1000);
                mFairy.onTap(0.8f, result, "右侧福利领取", 1000);
            }
            void content_06() throws Exception {
                util.close();
                setTaskName(7);
                err=0;
            }
            void content_07() throws Exception {
                overtime(15,99);
                result = mFairy.findPic(575,570,1275,710,"Gangs.png");
                mFairy.onTap(0.8f, result, "帮派", 1000);
                if (result.sim>0.8f){
                }else{
                    result = mFairy.findPic(203, 3, 783, 289, "activity.png");
                    mFairy.onTap(0.8f, result, 1221,652,1242,670,"切换右下角", 3000);
                }
                result = mFairy.findPic("Gangs_inface.png");
                mFairy.onTap(0.8f, result, 1243,261,1258,306,"内政", 1000);
                mFairy.onTap(0.8f, result, 1015,592,1067,611,"内政奖励", 1000);
                mFairy.onTap(0.8f, result, 1238,383,1261,425,"建设", 1000);
                mFairy.onTap(0.8f, result, 1005,596,1051,615,"帮派捐献", 1000);
                mFairy.onTap(0.8f, result, 605,576,677,595,"全部捐献", 1000);
                if (result.sim>0.8f){
                    util.close();
                    setTaskEnd();
                }

            }
        };
    }//

    //江湖同游
    public void jhty() throws Exception {

        new singleTaskContent(mFairy) {
            long dazeTime = 0;
            long  hhtime=0;
            @Override
            void create() throws Exception {

            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "江湖同游中";
            }

            @Override
            void init() throws Exception {
                util.signOutXX();
                util.outTeam();
                setTaskName(1);
            }
            @Override
            void content_01() throws Exception {
                int ret = util.findTask("jhty.png", "看","日常", "全部");
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else if (ret == 0) {
                        LtLog.e(mFairy.getLineInfo("没有任务了结束"));
                        setTaskEnd();
                        return;
                }
            }

            @Override
            void content_02() throws Exception {
                util.target("队长","日常","target_jhty.png","");
                setTaskName(3);
            }
            void content_03() throws Exception {
                overtime(500, 2);
                result = mFairy.findPic("team_inface.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("队伍界面判断人数"));
                    if ((System.currentTimeMillis()-hhtime)>180000){
                        LtLog.e(mFairy.getLineInfo("--------3分钟招募一下"));
                        mFairy.onTap(0.8f, result, 1005,591,1072,608,"喊话", 2000);
                        mFairy.onTap(0.8f, result, 612,496,675,519,"发送", 1000);
                        hhtime=System.currentTimeMillis();
                    }
                }
                result = mFairy.findPic("Start matching.png");
                mFairy.onTap(0.8f, result, "开始匹配", 1000);
                if (result.sim>0.8f){
                    result = mFairy.findPic("Start matching.png");
                    mFairy.onTap(0.8f, result, "开始匹配", 1000);
                    if (result.sim>0.8f){
                        util.close();
                    }
                }
                result = mFairy.findPic(915, 159, 1159, 535, "r_jhty.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);
                if (result.sim>0.8f){
                    setTaskName(4);
                    return;
                }
                result = mFairy.findPic(203,3,783,289, "activity.png");
                if (result.sim > 0.8f) {
                    int ret = util.findTask("jhty.png", "前往","日常", "全部");
                    if (ret == 1) {
                        setTaskName(4);
                        return;
                    } else if (ret == 0) {
                        LtLog.e(mFairy.getLineInfo("没有任务了结束"));
                        setTaskEnd();
                        return;
                    }
                }
            }
            void content_04() throws Exception {
                overtime(50, 0);
                result = mFairy.findPic(203,3,783,289, "activity.png");
                if (result.sim > 0.8f) {
                    dazeTime = mFairy.mMatTime(117, 48, 41, 14, 0.9f);
                    LtLog.e(mFairy.getLineInfo("发呆时间===" + dazeTime));
                    err = 0;
                } else {
                    mFairy.initMatTime();
                    dazeTime=0;
                }
                result = mFairy.findPic("In battle.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗中"));
                    err = 0;
                }
                result = mFairy.findPic(915, 159, 1159, 535, "r_jhty.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic("teambar.png");
                mFairy.onTap(0.9f, result, 1064, 114, 1096, 128, "切换到任务栏", 1000);

                result = mFairy.findPic(1003, 143, 1276, 242, "Taskbar jhty.png");
                if (dazeTime > 10) {
                    if (result.sim > 0.7f) {
                        mFairy.onTap(0.7f, result, "江湖同游", 1000);
                        mFairy.initMatTime();
                        dazeTime=0;
                    } else {
                        setTaskName(0);
                    }
                }
            }
        };
    }//

    //侠客传记中
    public void xkzj() throws Exception {

        new singleTaskContent(mFairy) {
            String string="";
            @Override
            void create() throws Exception {

            }
            @Override
            void inOperation() throws Exception {
                TASKNAME = "侠客传记中";
            }

            @Override
            void init() throws Exception {
                util.signOutXX();
                util.outTeam();
                setTaskName(1);
            }
            @Override
            void content_01() throws Exception {
                int ret = util.findTask("xkzj.png", "前往","休闲", "全部");
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else if (ret == 0) {
                    LtLog.e(mFairy.getLineInfo("没有任务了结束"));
                    setTaskEnd();
                    return;
                }
            }

            @Override
            void content_02() throws Exception {
                result = mFairy.findPic("xkzj_inface.png");
                mFairy.onTap(0.8f, result, 380,474,409,499,"侠客传记页面初始化", 1000);
                mFairy.onTap(0.8f, result, 380,474,409,499,"侠客传记页面初始化", 2000);
                mFairy.onTap(0.8f, result, 380,474,409,499,"侠客传记页面初始化", 2000);
                mFairy.onTap(0.8f, result, 380,474,409,499,"侠客传记页面初始化", 2000);
                mFairy.onTap(0.8f, result, 380,474,409,499,"侠客传记页面初始化", 2000);
                if (AtFairyConfig.getOption("xkzj").equals("1")){
                    setTaskName(3);
                    string="chengying.png";
                    return;
                }
                if (AtFairyConfig.getOption("xkzj").equals("2")){
                    mFairy.onTap(0.8f, result, 866,481,905,505,"侠客传记页面第二个", 1000);
                    setTaskName(3);
                    string="zhenbing.png";
                    return;
                }
                if (AtFairyConfig.getOption("xkzj").equals("3")){
                    mFairy.onTap(0.8f, result, 866,481,905,505,"侠客传记页面第三个", 1000);
                    mFairy.onTap(0.8f, result, 866,481,905,505,"侠客传记页面第三个", 1000);
                    setTaskName(3);
                    string="hongqigong.png";
                    return;
                }
                if (AtFairyConfig.getOption("xkzj").equals("4")){
                    mFairy.onTap(0.8f, result, 866,481,905,505,"侠客传记页面第4个", 1000);
                    mFairy.onTap(0.8f, result, 866,481,905,505,"侠客传记页面第4个", 1000);
                    mFairy.onTap(0.8f, result, 866,481,905,505,"侠客传记页面第4个", 1000);
                    string="yinggu.png";
                    setTaskName(3);
                    return;
                }
            }
            void content_03() throws Exception {
                result = mFairy.findPic(891,93,1269,547,string );
                mFairy.onTap(0.7f, result, "任务传", 2000);

                result = mFairy.findPic("xkzj_jinru.png");
                mFairy.onTap(0.8f, result, "进入", 1000);

                result = mFairy.findPic("kqzj.png");
                mFairy.onTap(0.8f, result, "开启传记", 1000);

                result = mFairy.findPic("wjs.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("未解锁"));
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic(501,486,776,685, "or.png");
                if (result.sim > 0.8f) {
                    Random random = new Random();
                    int num = random.nextInt(2) + 1;
                    if (num==1){
                        mFairy.onTap(0.8f, result, 399,589,454,615,"选择1", 1000);
                    }else if (num==2){
                        mFairy.onTap(0.8f, result, 798,580,870,618,"选择2", 1000);
                    }
                }

                result = mFairy.findPic("chengying_other.png");
                if (result.sim > 0.8f) {
                    mFairy.touchDown(2, 517,384);
                    mFairy.touchMove(2, 753,369, 1000);
                    mFairy.touchMove(2, 517,384, 1000);
                    mFairy.touchMove(2, 753,369, 1000);
                    mFairy.touchMove(2, 517,384, 1000);
                    mFairy.touchMove(2, 753,369, 1000);
                    mFairy.touchUp(2);
                }
                result = mFairy.findPic("other_sure.png");
                mFairy.onTap(0.8f, result, "上交任务物品确定", 1000);

                result = mFairy.findPic(915, 159, 1159, 535, "bjzd.png");
                mFairy.onTap(0.8f, result, 984,411,1029,431,"便捷组队点上面", 1000);

                result = mFairy.findPic(918,119,1143,660,"Grade Gift Pack Collection.png");
                mFairy.onTap(0.8f, result, "等级礼包领取", 1000);
                mFairy.onTap(0.8f, result, 1191,69,1203,80,"等级礼包领取关闭", 1000);

                result = mFairy.findPic("skip.png");
                mFairy.onTap(0.8f, result, 1217, 22, 1238, 33, "跳过动画", 1000);

                result = mFairy.findPic("Right side task.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic("Right side task1.png");
                mFairy.onTap(0.8f, result, "右侧任务", 1000);

                result = mFairy.findPic("Got it.png");
                mFairy.onTap(0.8f, result, "知道了", 1000);

                result = mFairy.findPic(201, 70, 1242, 586, "tap.png");
                mFairy.onTap(0.8f, result, "点击", 1000);


                result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork.png","fork2.png"});
                mFairy.onTap(0.9f, result, "叉", 1000);

                result = mFairy.findPic(657, 5, 1278, 323, new String[]{"fork1.png","fork3.png"});
                mFairy.onTap(0.9f, result, "叉", 1000);

            }
            void content_04() throws Exception {

            }
        };
    }//


}
