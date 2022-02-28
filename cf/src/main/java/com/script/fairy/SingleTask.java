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
    //无限的 无限挑战
    public void Infinite(String parent_task ,String parent_task1,String sub_task , int difficulty) throws Exception {
        while (mFairy.condit()) {
            result = mFairy.findPic(new String[]{"leisure_time.png","xiuxian.png"});
            mFairy.onTap(0.8f, result, "休闲挑战", 1000);

            result = mFairy.findPic("challenge.png");
            mFairy.onTap(0.8f, result,result.x+10,result.y-106,result.x+28,result.y-87, "挑战", 1000);

            result = mFairy.findPic(6,58,209,715,"hurdle.png");
            mFairy.onTap(0.9f, result, "收栏", 1000);

            result1 = mFairy.findPic(6,58,209,715,new String[]{parent_task,parent_task1});
          //  LtLog.e(mFairy.getLineInfo(0.1f,result1,"父任务"));
            mFairy.onTap(0.8f, result1, "父任务", 2000);
            if (result1.sim>0.8f){
                if (!sub_task.equals("")){
                    result = mFairy.findPic(6,58,209,715,sub_task);
                    LtLog.e(mFairy.getLineInfo(0.1f,result,"子任务"));
                    mFairy.onTap(0.8f, result, "子任务", 1000);
                }
                if (difficulty==1){
                    mFairy.onTap(0.8f, result1, 282,83,310,96,"难度普通", 2000);
                }
                if (difficulty==2){
                    mFairy.onTap(0.8f, result1, 431,87,453,98,"难度困难", 2000);
                }
                if (difficulty==3){
                    mFairy.onTap(0.8f, result1,561,83,590,100,"难度炼狱", 2000);
                }
                mFairy.onTap(0.8f, result1,1109,655,1149,676,"多人", 2000);
            }

            if (AtFairyConfig.getOption("gm").equals("1")){
                result = mFairy.findPic("buy_all.png");
                mFairy.onTap(0.8f, result, "全部购买", 1000);

                result = mFairy.findPic("buy_all1.png");
                mFairy.onTap(0.8f, result, "全部购买", 1000);

            }else {
                result = mFairy.findPic(104,344,1218,452,"free_purchase.png");
                mFairy.onTap(0.8f, result, "免费翻牌", 1000);
                mFairy.onTap(0.8f,result,504,558,510,564,"直接退出",1000);

                result = mFairy.findPic("winning_award.png");
                mFairy.onTap(0.8f, result, "优胜奖励", 1000);
            }



            result = mFairy.findPic("manual.png");
            mFairy.onTap(0.7f, result, "手动切换到自动", 1000);

            result=mFairy.findPic("ready.png");
            mFairy.onTap(0.8f,result,result.x+222,result.y+7,result.x+235,result.y+17,"准备",1000);

            result = mFairy.findPic("return_hall.png");
            mFairy.onTap(0.8f, result, "返回大厅", 1000);

            result = mFairy.findPic("return_hall1.png");
            mFairy.onTap(0.8f, result, "返回大厅", 1000);


            result = mFairy.findPic("sign_out.png");
            mFairy.onTap(0.8f, result, "退出", 1000);

            result = mFairy.findPic("rematch.png");
            mFairy.onTap(0.8f, result, 607,509,667,528,"重新匹配", 1000);

            result = mFairy.findPic("pathfinding.png");
            mFairy.onTap(0.8f, result, "自动寻路", 5000);


            result = mFairy.findPic(new  String[]{"in_combat.png","in_combat1.png","life.png","feir.png"});
            LtLog.e(mFairy.getLineInfo(0.8f,result,"战斗中"));
            if (result.sim>0.8f){
                int dir = new Random().nextInt(3 - 1) + 1;
                LtLog.e(mFairy.getLineInfo("--------------------随机方向 dir = " + dir));
                int sle = new Random().nextInt(9 - 4) + 4;
                LtLog.e(mFairy.getLineInfo("--------------------随机延时 sle = " + sle));
                if (dir == 1) {
                    LtLog.e(mFairy.getLineInfo("--------------------当前随机为 1 ，向右滑动......"));
                    // mFairy.RanSwipe(273, 511, 335, 549, 1, sle * 1000);
                    mFairy.touchDown(3, 214, 520);
                    mFairy.touchMove(3, 269, 520, 4000);
                    mFairy.touchUp(3);
                    Thread.sleep(2000);
                } else {
                    LtLog.e(mFairy.getLineInfo("--------------------当前随机为 2 ，向左滑动......"));
                    //  mFairy.RanSwipe(218, 504, 274, 550, 3, sle * 1000);
                    mFairy.touchDown(3, 269, 520);
                    mFairy.touchMove(3, 214, 520, 4000);
                    mFairy.touchUp(3);
                    Thread.sleep(2000);
                }
            }


        }
    }

    //无限的 挑战世界boss
    public void Infinite1(String parent_task ,String parent_task1,String sub_task , int difficulty) throws Exception {
        while (mFairy.condit()) {
            LtLog.e("进入副本...............");
            result = mFairy.findPic(new String[]{"leisure_time.png","xiuxian.png"});
            mFairy.onTap(0.8f, result, "休闲挑战", 1000);

            result = mFairy.findPic("challenge.png");
            mFairy.onTap(0.8f, result,result.x+10,result.y-106,result.x+28,result.y-87, "挑战", 1000);


            result = mFairy.findPic(6,58,209,715,"hurdle.png");
            mFairy.onTap(0.9f, result, "收栏", 1000);

            result1 = mFairy.findPic(6,58,209,715,new String[]{parent_task,parent_task1});
            //  LtLog.e(mFairy.getLineInfo(0.1f,result1,"父任务"));
            mFairy.onTap(0.8f, result1, "父任务", 2000);
            if (result1.sim>0.8f){
                if (!sub_task.equals("")){
                    result = mFairy.findPic(6,58,209,715,sub_task);
                    LtLog.e(mFairy.getLineInfo(0.1f,result,"子任务"));
                    mFairy.onTap(0.8f, result, "子任务", 1000);
                }
                if (difficulty==1){
                    mFairy.onTap(0.8f, result1, 282,83,310,96,"难度普通", 2000);
                }
                if (difficulty==2){
                    mFairy.onTap(0.8f, result1, 431,87,453,98,"难度困难", 2000);
                }
                if (difficulty==3){
                    mFairy.onTap(0.8f, result1,561,83,590,100,"难度炼狱", 2000);
                }

                result = mFairy.findPic("frequency.png");
                LtLog.e(mFairy.getLineInfo(0.1f,result,"没有次数了"));
                if (result.sim>0.8f){
                    return;
                }

                mFairy.onTap(0.8f, result1,1109,655,1149,676,"多人", 2000);
            }

            result = mFairy.findPic("quxiao.png");
            LtLog.e(mFairy.getLineInfo(0.8f,result,"匹配中................"));


            if (AtFairyConfig.getOption("gm").equals("1")){
                result = mFairy.findPic("buy_all.png");
                mFairy.onTap(0.8f, result, "全部购买", 1000);

                result = mFairy.findPic("buy_all1.png");
                mFairy.onTap(0.8f, result, "全部购买", 1000);

            }else {
                result = mFairy.findPic(104,344,1218,452,"free_purchase.png");
                mFairy.onTap(0.8f, result, "免费翻牌", 1000);
                mFairy.onTap(0.8f,result,504,558,510,564,"直接退出",1000);

                result = mFairy.findPic("winning_award.png");
                mFairy.onTap(0.8f, result, "优胜奖励", 1000);
            }

            result = mFairy.findPic("jlsure.png");
            mFairy.onTap(0.8f, result, "奖励确定", 1000);

            result=mFairy.findPic("ready.png");
            mFairy.onTap(0.8f,result,result.x+222,result.y+7,result.x+235,result.y+17,"准备",1000);

            result = mFairy.findPic("manual.png");
            mFairy.onTap(0.8f, result, "手动切换到自动", 1000);

            result = mFairy.findPic("return_hall.png");
            mFairy.onTap(0.8f, result, "返回大厅", 1000);

            result = mFairy.findPic("return_hall1.png");
            mFairy.onTap(0.8f, result, "返回大厅", 1000);


            result = mFairy.findPic("sign_out.png");
            mFairy.onTap(0.8f, result, "退出", 1000);

            result = mFairy.findPic("rematch.png");
            mFairy.onTap(0.8f, result, 607,509,667,528,"重新匹配", 1000);

            result = mFairy.findPic("pathfinding.png");
            mFairy.onTap(0.8f, result, "自动寻路", 5000);


            result = mFairy.findPic(new  String[]{"in_combat.png","in_combat1.png","life.png","feir.png"});
            LtLog.e(mFairy.getLineInfo(0.8f,result,"战斗中"));
            if (result.sim>0.8f){
                int dir = new Random().nextInt(3 - 1) + 1;
                LtLog.e(mFairy.getLineInfo("--------------------随机方向 dir = " + dir));
                int sle = new Random().nextInt(9 - 4) + 4;
                LtLog.e(mFairy.getLineInfo("--------------------随机延时 sle = " + sle));
                if (dir == 1) {
                    LtLog.e(mFairy.getLineInfo("--------------------当前随机为 1 ，向右滑动......"));
                    // mFairy.RanSwipe(273, 511, 335, 549, 1, sle * 1000);
                    mFairy.touchDown(3, 214, 520);
                    mFairy.touchMove(3, 269, 520, 4000);
                    mFairy.touchUp(3);
                    Thread.sleep(2000);
                } else {
                    LtLog.e(mFairy.getLineInfo("--------------------当前随机为 2 ，向左滑动......"));
                    //  mFairy.RanSwipe(218, 504, 274, 550, 3, sle * 1000);
                    mFairy.touchDown(3, 269, 520);
                    mFairy.touchMove(3, 214, 520, 4000);
                    mFairy.touchUp(3);
                    Thread.sleep(2000);
                }
            }
        }
    }
}
