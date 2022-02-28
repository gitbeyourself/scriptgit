package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    boolean scn=true;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }

    /**
     * 试剑擂台
     */
    public void swordArena() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("hls2.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("matching.png");
                mFairy .onTap(0.8f,result,"匹配",2000);

                result = mFairy.findPic("continue.png");
                mFairy .onTap(0.8f,result,"继续",2000);

                result = mFairy.findPic("back.png");
                mFairy .onTap(0.8f,result,"返回",2000);

                result = mFairy.findPic(340,188,935,317,"achievement.png");
                mFairy .onTap(0.8f,result,638,508,648,516,"成绩 ",2000);
                if (result.sim > 0.8f){
                    LtLog.e("次数打完了 还想去看看 任务完成没 ");
                    setTaskName(0);return;
                }

                result = mFairy.findPic("leitaiover.png");
               // mFairy .onTap(0.8f,result,638,508,648,516,"成绩 ",2000);
                if (result.sim > 0.8f){
                    LtLog.e("次数打完了 还想去看看 任务完成没 ");
                    setTaskName(0);return;
                }
                result = mFairy.findPic("back.png");
                mFairy .onTap(0.8f,result,"返回",2000);
            }

        }.taskContent(mFairy, "试剑擂台");
    }

    /**
     * 古城夺宝
     */
    public void ancientCity() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {
//                result = mFairy.findPic(477,9,801,265,"zengyi.png");
//                mFairy.onTap(0.8f,result,984,92,992,99,"关闭增益",Sleep);

                result = mFairy.findPic(595,355,909,558,"buy.png");
                mFairy.onTap(0.8f,result,result.x-40,result.y+80,result.x-39,result.y+81,"购买",Sleep);

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("Activeinterface.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,1147,30,1161,37,"不在主城回襄阳",2000);
                    result = mFairy.findPic("battlefield.png");
                    mFairy.onTap(0.8f,result,"战场",Sleep);

                    result = mFairy.findPic("ancientCity.png");
                    mFairy.onTap(0.8f,result,"古城夺宝",Sleep);

                }else {
                    result = mFairy.findPic(1018,147,1271,246,"activity.png");
                    LtLog.e("=========================活动按钮相似度=="+result.sim);
                    mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);
                }




                result = mFairy.findPic("Cross Service.png");
                mFairy.onTap(0.8f,result,"跨服匹配",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                long datetime = mFairy.mMatTime(1176,231,92,20,0.9f);

                result = mFairy.findPic("Cross Service.png");
                mFairy.onTap(0.8f,result,"跨服匹配",Sleep);

                result = mFairy.findPic("correct.png");
                if (result.sim > 0.8f){
                    LtLog.e("时间过了");
                    gameUtil.close();
                    setTaskEnd();return;
                }
                result = mFairy.findPic("cheng.png");
                if (result.sim > 0.8f){
                    LtLog.e("不在主城");
                    mFairy.onTap(0.8f,result,1146,130,1160,151,"叉",Sleep);
                    mFairy.onTap(0.8f,result,1142,38,1154,43,"襄阳",Sleep);
                    mFairy.onTap(0.8f,result,1142,38,1154,43,"襄阳",Sleep);
                }

                result = mFairy.findPic(new String[]{"Hang up.png","hang up2.png"});
                if (result.sim > 0.8f){
                    LtLog.e("匹配中..........");
                    return;
                }
                result = mFairy.findPic("bi.png");
                if (datetime >= 6 && result.sim > 0.8f) {
                    result = mFairy.findPic("city.png");
                    mFairy.onTap(0.8f, result, 1133, 116, 1161, 152, "打开地图", 2000);
                }else if (datetime >= 30){
                    result = mFairy.findPic(477,9,801,265,"zengyi.png");
                    mFairy.onTap(0.8f,result,984,92,992,99,"关闭增益",Sleep);
                }
                result = mFairy.findPic("map.png");
                mFairy.onTap(0.8f,result,638,408,644,421,"去战场中间",8000);
                mFairy.onTap(0.8f,result,1079,21,1091,33,"关闭地图",1000);
                if (result.sim > 0.8f){
                   // mFairy.sleep(2000);
                    setTaskName(3);return;
                }
                result1 = mFairy.findPic("XiangYang3.png");
                //mFairy.onTap(0.8f,result,"复活",Sleep);
                if ( result1.sim > 0.8f){
                    setTaskName(1);return;
                }
            }
            public void content_3() throws Exception{
                mFairy.sleep(2000);
                result = mFairy.findPic("oldcity.png");
                if (result.sim > 0.8f ) {
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                }

                result = mFairy.findPic("continue.png");
                mFairy .onTap(0.8f,result,"继续",2000);

                result = mFairy.findPic("next step.png");
                mFairy.onTap(0.8f,result,"下一步",3000);

                result1 = mFairy.findPic(461,221,807,350,"resurrection.png");
                //mFairy.onTap(0.8f,result,"复活",Sleep);
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    setTaskName(2);return;
                }
                result1 = mFairy.findPic("XiangYang3.png");
                //mFairy.onTap(0.8f,result,"复活",Sleep);
                if ( result1.sim > 0.8f){
                    setTaskName(1);return;
                }
            }
        }.taskContent(mFairy, "古城夺宝");
    }

    /**
     * 雾原血战
     */
    public void wuyuan() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {

                result = mFairy.findPic("continue.png");
                mFairy .onTap(0.8f,result,"继续",2000);
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("Activeinterface.png");
                mFairy.onTap(0.8f,result,1147,30,1161,37,"不在主城回襄阳",2000);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("battlefield.png");
                    mFairy.onTap(0.8f,result,"战场",Sleep);

                    result = mFairy.findPic("Bloody.png");
                    mFairy.onTap(0.8f,result,"雾原血战",Sleep);


                }else {
                    result = mFairy.findPic(1018,147,1271,246,"activity.png");
                    LtLog.e("=========================活动按钮相似度=="+result.sim);
                    mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);
                }




                result = mFairy.findPic("Cross Service.png");
                mFairy.onTap(0.8f,result,"跨服匹配",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                long datetime = mFairy.mMatTime(1176,231,92,20,0.9f);
                result = mFairy.findPic("Cross Service.png");
                mFairy.onTap(0.8f,result,"跨服匹配",Sleep);

                result = mFairy.findPic("correct.png");
                if (result.sim > 0.8f){
                    LtLog.e("时间过了");
                    gameUtil.close();
                    setTaskEnd();return;
                }
                result = mFairy.findPic("cheng.png");
                if (result.sim > 0.8f){
                    LtLog.e("不在主城");
                    mFairy.onTap(0.8f,result,1146,130,1160,151,"叉",Sleep);
                    mFairy.onTap(0.8f,result,1142,38,1154,43,"襄阳",Sleep);
                    mFairy.onTap(0.8f,result,1142,38,1154,43,"襄阳",Sleep);
                }

                result = mFairy.findPic(new String[]{"Hang up.png","hang up2.png"});
                if (result.sim > 0.8f){
                    LtLog.e("匹配中..........");
                    return;
                }


                if (datetime >= 6) {
                    result = mFairy.findPic("Bloody2.png");
                    mFairy.onTap(0.8f, result, 1133, 116, 1161, 152, "打开地图", 3000);
                }else if (datetime >= 30){
                    result = mFairy.findPic(477,9,801,265,"zengyi.png");
                    mFairy.onTap(0.8f,result,984,92,992,99,"关闭增益",Sleep);
                }
                result = mFairy.findPic("map2.png");
                mFairy.onTap(0.8f,result,615,435,626,444,"去战场中间",13000);
                mFairy.onTap(0.8f,result,1158,583,1166,591,"关闭地图",1000);
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
                result1 = mFairy.findPic("XiangYang3.png");
                //mFairy.onTap(0.8f,result,"复活",Sleep);
                if ( result1.sim > 0.8f){
                    setTaskName(1);return;
                }
            }
            public void content_3() throws Exception{
                mFairy.sleep(2000);
                result = mFairy.findPic("Bloody2.png");
                if (result.sim > 0.8f ) {
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                    mFairy.onTap(1162,588,1174,597, "攻击", Sleep);
                }

                result = mFairy.findPic("back4.png");
                mFairy.onTap(0.8f,result,"返回",3000);

                result1 = mFairy.findPic(461,221,807,350,"resurrection.png");
                //mFairy.onTap(0.8f,result,"复活",Sleep);
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    setTaskName(2);return;
                }
                result1 = mFairy.findPic("XiangYang3.png");
                //mFairy.onTap(0.8f,result,"复活",Sleep);
                if ( result1.sim > 0.8f){
                    setTaskName(1);return;
                }
            }
        }.taskContent(mFairy, "雾原血战");
    }

    /**
     * 天雷荒火
     */
    public void skyThunder() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("Sky thunder.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        //mFairy.sleep(3000);
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("join.png");
                mFairy.onTap(0.8f,result,"进入",5000);

                mFairy.sleep(3000);

                result = mFairy.findPic("lei.png");
                if (result.sim > 0.8f){
                    LtLog.e("随意走动");
                    mFairy.touchDown(197,559);
                    mFairy.touchMove(343,570,3300);
                    mFairy.touchMove(62,446,5000);
                    mFairy.touchMove(190,672,4500);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("death.png");
                mFairy.onTap(0.8f,result,636,469,655,478,"确定",Sleep);

                result = mFairy.findPic("backlei.png");
                mFairy.onTap(0.8f,result,"活动结束退出",Sleep);

                result1 = mFairy.findPic("lei.png");
                result3 = mFairy.findPic("Finding the way auto.png");
                result = mFairy.findPic("XiangYang3.png");
                if(result.sim > 0.8f && result3.sim < 0.8f && result1.sim < 0.8f){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "天雷荒火");
    }

    /**
     * 种树
     */
    public void plantingTrees() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("tree.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("Planting trees.png");
                if(result.sim > 0.8f){
                    result = mFairy.findPic("buytrees.png");
                    mFairy.onTap(0.8f,result,"购买种子",2000);
                    //mFairy.onTap(0.8f,result,"购买种子",2000);
                }

                result = mFairy.findPic("Planting trees2.png");
                mFairy.onTap(0.8f,result,"去种树",2000);
                if ( result.sim > 0.8f){
                    mFairy.sleep(5000);
                    setTaskName(3);return;
                }
                result = mFairy.findPic(36,121,238,317,"tree2.png");
                if (result.sim > 0.8f){

                    setTaskName(3);return;

                }

                result = mFairy.findPic("Power saving.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_3() throws Exception{
                long datetime = mFairy.mMatTime(1176,231,92,20,0.9f);

                if (datetime >= 60){
                    setTaskName(0);return;
                }
//                result = mFairy.findPic("bigmap.png");
//                if (result.sim > 0.8f){
//                    err=0;
//                }

//                result3 = mFairy.findPic("Finding the way auto.png");
//                if (result3.sim < 0.8f && datetime >=30){
//                    result = mFairy.findPic("bag.png");
//                    mFairy.onTap(0.8f,result,"打开背包",2000);
//
//                    result = mFairy.findPic(742,51,1226,629,new String[]{"seed.png","seed2.png"});
//                    mFairy.onTap(0.8f,result,"点击种子",2000);
//
//                    result = mFairy.findPic(516,396,762,539,"use seed.png");
//                    mFairy.onTap(0.8f,result,"使用种子",2000);
//                    if(result.sim > 0.8f){
//                        mFairy.sleep(3000);
//                        setTaskName(4);return;
//                    }
//                }else {
//                    err =0;
//                }
                result = mFairy.findPic(36,121,238,317,"tree2.png");
                if (result.sim > 0.8f && datetime > 10){
                    mFairy.onTap(0.8f,result,"接了任务",2000);
                    result = mFairy.findPic(396,174,911,449,"mapcs.png");
                    mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                    //err=0;
                }
                result = mFairy.findPic(36,121,238,317,"shouhu.png");
                if (result.sim > 0.8f){
                    setTaskName(4);
                    return;
                }
              //  mFairy.taskSlid(err, new int[]{0, 5, 9, 13}, 0, 986,567, 988,111, 1000, 1500);
              //  if (overtime(15, 0)) return;//计次并跳转
            }
            public void content_4() throws Exception{
                long datetime = mFairy.mMatTime(1176,231,92,20,0.9f);
                if(datetime >= 30) {
                    mFairy.initMatTime();
                    result = mFairy.findPic(36, 121, 238, 317, "shouhu.png");
                    mFairy.onTap(0.8f, result, "去树边", 2000);
                }
                result = mFairy.findPic("Disinfestation.png");
                mFairy.onTap(0.8f,result,"除虫",2000);

                result = mFairy.findPic("watering.png");
                mFairy.onTap(0.8f,result,"浇水",2000);

                result = mFairy.findPic("harvest.png");
                mFairy.onTap(0.8f,result,"收获",2000);

                result1 = mFairy.findPic(36,121,238,317,"tree2.png");
                result = mFairy.findPic(44,126,275,340,"sapling.png");
                if(result.sim< 0.7f && result1.sim < 0.8f){
                    LtLog.e("左边任务栏没有树苗了去查看任务");
                    setTaskName(0);return;
                }else if (result1.sim > 0.8f && result.sim <0.8f){
                    setTaskName(3);
                    return;
                }
            }
        }.taskContent(mFairy, "种树");
    }


    /**
     *  晚餐
     */
    public void dinner() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("dinner.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("buydinner.png");
                mFairy.onTap(0.8f,result,"购买优质晚餐",2000);
                mFairy.onTap(0.8f,result,743,464,754,472,"确定购买",2000);
                mFairy.onTap(0.8f,result,42,26,51,32,"购买完关闭当前页面",2000);
                if(result.sim > 0.8f){
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception{
                result3 = mFairy.findPic("Finding the way auto.png");
                if (result3.sim < 0.8f){
                    result = mFairy.findPic("bag.png");
                    mFairy.onTap(0.8f,result,"打开背包",2000);

                    result = mFairy.findPic(742,51,1226,629,"Meal ticket.png");
                    mFairy.onTap(0.8f,result,"点击饭票",2000);

                    result = mFairy.findPic(576,457,728,528,"use seed.png");
                    mFairy.onTap(0.8f,result,"使用饭票",2000);
                    mFairy.onTap(0.8f,result,30,27,38,36,"关闭",2000);
                    if(result.sim > 0.8f){
                        setTaskName(4);return;
                    }
                }else {
                    err =0;
                }

                mFairy.taskSlid(err, new int[]{0,  5, 9}, 0, 986,567, 988,111, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
            public void content_4() throws Exception{
                result1 = mFairy.findPic("bag.png");
                result = mFairy.findPic("supper.png");
                if(result.sim< 0.7f && result1.sim > 0.8f){
                    LtLog.e("吃完了");
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "晚餐");
    }

    /**
     *  恶人谷
     */
    public void alley() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("Valley.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("Valley2.png");
                mFairy.onTap(0.8f,result,"挑战恶人谷",2000);

                result = mFairy.findPic("Valley3.png");
                if (result.sim > 0.8f){
                    result1 = mFairy.findPic("open auto.png");
                    result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                    mFairy .onTap(0.8f,result,"开启自动",Sleep);
                    if (result.sim < 0.8f && result1.sim < 0.8f){
                        result = mFairy.findPic("Valley3.png");
                        result2 = mFairy.findPic("Exit key.png");
                        if (result.sim > 0.8f && result2.sim >0.8f){
                            mFairy.onTap(1236,674,1246,680,"开启自动2",Sleep);
                        }

                    }
                }
                result = mFairy.findPic("erentz.png");
                mFairy.onTap(0.8f,result,"再次挑战",2000);

                result = mFairy.findPic("qwanover.png");
                if (result.sim > 0.8f){
                    LtLog.e("没有挑战次数了");
                    setTaskName(0);return;
                }

                result = mFairy.findPic("banghui.png");
                if (result.sim > 0.8f){
                    LtLog.e("没有加入帮会");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("XiangYang3.png");
                result3 = mFairy.findPic("Finding the way auto.png");
                result1 = mFairy.findPic("Valley2.png");
                if (result.sim > 0.8f&& result3.sim < 0.8f&& result1.sim < 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("Power saving.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "恶人谷");
    }


    /**
     *  帮会首领
     */
    public void crusade() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("gangboss.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁或者还没开");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("gangboss.png");
                if (result.sim > 0.8f){

                }

                result = mFairy.findPic("call.png");
                mFairy .onTap(0.8f,result,"召唤",5000);

                mFairy.taskSlid(err, new int[]{0,  5, 9}, 0, 986,567, 988,111, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
            public void content_4() throws Exception{
                result = mFairy.findPic("Disinfestation.png");
                mFairy.onTap(0.8f,result,"除虫",2000);

                result = mFairy.findPic("watering.png");
                mFairy.onTap(0.8f,result,"浇水",2000);

                result = mFairy.findPic("harvest.png");
                mFairy.onTap(0.8f,result,"收获",2000);

                result = mFairy.findPic(44,126,275,340,"sapling.png");
                if(result.sim< 0.7f){
                    LtLog.e("左边任务栏没有树苗了去查看任务");
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "首领讨伐");
    }

    /**
     *  梦华夜市
     */
    public void nightMarket() throws Exception {
        new SingleTask(mFairy) {
            int num = 3;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("night.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("Cornbuy.png");
                mFairy.onTap(0.8f,result,"购买玉米",2000);

                result = mFairy.findPic("obtain.png");
                mFairy.onTap(0.8f,result,277,684,288,692,"已购买玉米",2000);
                if(result.sim > 0.8f){
                    num --;
                    setTaskName(3);return;
                }
                result = mFairy.findPic("XiangYang3.png");
                result3 = mFairy.findPic("Finding the way auto.png");
                result1 = mFairy.findPic("meng.png");
                if (result.sim > 0.8f && result3.sim < 0.8f && result1.sim < 0.8f){
                    setTaskName(0);return;
                }
                if (num <= 0){
                    LtLog.e("次数用完了");
                    setTaskName(0);return;
                }
            }
            public void content_3() throws Exception{
                result3 = mFairy.findPic("Finding the way auto.png");
                if (result3.sim < 0.8f){
                    result = mFairy.findPic("bag.png");
                    mFairy.onTap(0.8f,result,"打开背包",2000);

                    result = mFairy.findPic(742,51,1226,629,"com.png");
                    mFairy.onTap(0.8f,result,"点击玉米",2000);

                    result = mFairy.findPic(576,457,728,528,"use seed.png");
                    mFairy.onTap(0.8f,result,"使用玉米",2000);
                    if(result.sim > 0.8f){
                        setTaskName(4);return;
                    }
                }else {
                    err =0;
                }

                mFairy.taskSlid(err, new int[]{0,  5, 9}, 0, 986,567, 988,111, 1000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
            public void content_4() throws Exception{
                mFairy.sleep(3000);
                result = mFairy.findPic("eat.png");
                if(result.sim< 0.7f){
                    LtLog.e("吃完了 再去 买一个");
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "梦华夜市");
    }

    /**
     *  帮会温泉
     */
    public void hotSpring() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.missionTimelimit("hot spring.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                int hour = mFairy.dateHour();
                int min = mFairy.dateMinute();
                int sum = hour*60+min;
                if (sum >1230){
                    LtLog.e("泡温泉时间结束");
                    setTaskEnd();return;
                }
                long time = mFairy.mMatTime(1164,124,96,21,0.9f);
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("join hot spring.png");
                mFairy.onTap(0.8f,result,"进入温泉",2000);

                result = mFairy.findPic("leave wenquan.png");
                mFairy.onTap(0.8f,result,745,461,753,468,"沐浴完毕 离开温泉",2000);

                result = mFairy.findPic("flower.png");
                if (result.sim < 0.8f && time >= 30){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "帮会温泉");
    }


}
