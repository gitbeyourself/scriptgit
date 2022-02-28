package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;


    YxdUtil yxdUtil_1;
    YxdUtil yxdUtil_2;
    YxdUtil yxdUtil_3;
    int num = 0;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        Sleep = 1000;
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);
        yxdUtil_1 = new YxdUtil(mFairy);
        yxdUtil_2 = new YxdUtil(mFairy);
        yxdUtil_3 = new YxdUtil(mFairy);
    }

    @Override
    public void inOperation() throws Exception {
        result = mFairy.findPic(new String[]{"arbitrarily.png","RYi.png","Yi.png","screen.png","JX.png","mu.png"});
        mFairy.onTap(0.8f,result,"任意位置继续",Sleep);

        result = mFairy.findPic("every JL.png");
        mFairy.onTap(0.8f,result,"每日奖励",4000);

        result = mFairy.findPic("every day cha.png");
        mFairy.onTap(0.8f,result,"每日奖励叉",3000);

    }

    /**
     * 姑瑶幻境
     */
    public void guYaoFantasy() throws Exception {
        new SingleTask(mFairy) {
//            @Override
//            public void inOperation() throws Exception {
//                result = mFairy.findPic("dengji.png");
//                mFairy.onTap(0.8f,result,"等级",2000);
//
//                result = mFairy.findPic("every JL.png");
//                mFairy.onTap(0.8f,result,"每日奖励",4000);
//
//                result = mFairy.findPic("every day cha.png");
//                mFairy.onTap(0.8f,result,"每日奖励叉",3000);
//
//            }
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        num=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认刷1次");
                        num = 1;
                    }
                }else {
                    LtLog.e("没有设定次数默认刷1次");
                    num = 1;
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                gameUtil.currency("experience.png");
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                if (num <= 0){
                    result1 = mFairy.findPic("team.png");
                    if (result1.sim > 0.8f){
                        LtLog.e("========次数"+num);
                        result = mFairy.findPic("Unmanage.png");
                        mFairy.onTap(0.8f, result, "取消托管结束任务", 2000);
                        gameUtil.close();
                        setTaskEnd();return;
                    }

                }

               // result = mFairy.findPic("Unmanage.png");
                result = mFairy.findPic("victory.png");
                mFairy.onTap(0.8f,result,"胜利",2000);
                if (result.sim > 0.8f && num > 0){
                    mFairy.sleep(2000);
                    num--;

                    LtLog.e("============================"+num);
                }

                result = mFairy.findPic("Trusteeship.png");
                mFairy.onTap(0.8f, result, "开始", 2000);

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "姑瑶幻境");
    }

    /**
     * 灾祸之渊
     * @throws Exception
     */
    public void abyssDisaster() throws Exception {
        new SingleTask(mFairy) {
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        num=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认刷完1次");
                        num = 1;
                    }
                }else {
                    LtLog.e("没有设定次数默认刷完1次");
                    num = 1;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                gameUtil.currency("Chong Ling.png");
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                if (num <= 0){
                    result1 = mFairy.findPic("team.png");
                    if (result1.sim > 0.8f){
                        LtLog.e("========次数"+num);
                        result = mFairy.findPic("Unmanage.png");
                        mFairy.onTap(0.8f, result, "取消托管结束任务", 2000);
                        gameUtil.close();
                        setTaskEnd();return;
                    }

                }

             //   result = mFairy.findPic("Unmanage.png");
                result = mFairy.findPic("victory.png");
                mFairy.onTap(0.8f,result,"胜利",2000);
                if (result.sim > 0.8f ){
                   // mFairy.sleep(15000);
                    num--;
                }


                result = mFairy.findPic("Trusteeship.png");
                mFairy.onTap(0.8f, result, "开始", Sleep);

                result = mFairy.findPic("physical strength.png");
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "灾祸之渊");
    }

    /**
     * 昆仑之虚
     * @throws Exception
     */
    public void kunLunRuins() throws Exception {
        new SingleTask(mFairy) {
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        num=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认刷1次");
                        num = 1;
                    }
                }else {
                    LtLog.e("没有设定次数默认刷完1次");
                    num = 1;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                gameUtil.currency("Spirit organ.png");
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                if (num <= 0){
                    result1 = mFairy.findPic("team.png");
                    if (result1.sim > 0.8f){
                        LtLog.e("========次数"+num);
                        result = mFairy.findPic("Unmanage.png");
                        mFairy.onTap(0.8f, result, "取消托管结束任务", 2000);
                        gameUtil.close();
                        setTaskEnd();return;
                    }

                }

              //  result = mFairy.findPic("Unmanage.png");
                result = mFairy.findPic("victory.png");
                mFairy.onTap(0.8f,result,"胜利",2000);
                if (result.sim > 0.8f ){
                    //mFairy.sleep(15000);
                    num--;
                }

                result = mFairy.findPic("Trusteeship.png");
                mFairy.onTap(0.8f, result, "开始", Sleep);

                result = mFairy.findPic("physical strength.png");
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "昆仑之虚");
    }

    /**
     * 悬赏
     * @throws Exception
     */
    public void offerReward() throws Exception {
        new SingleTask(mFairy) {
            boolean us = false;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                long dazeTime=mFairy.mMatTime(966,146,63,11,0.9f);
                if (dazeTime >= 60){
                    mFairy.initMatTime();
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("delegate.png");
                mFairy.onTap(0.8f,result,"委派",Sleep);

                result1 = mFairy.findPic("weipaixs.png");
                result = mFairy.findPic("reward.png");
                mFairy.onTap(0.8f,result,"悬赏",Sleep);
                if (result1.sim > 0.8f && result.sim < 0.8f){
                    LtLog.e("悬赏还没开结束任务");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("receive.png");
                mFairy.onTap(0.8f,result,"领取奖励",Sleep);

                result = mFairy.findPic(new String[]{"invitation.png","invitation2.png"});
                if (result.sim > 0.8f){
                    setTaskName(4);return;
                }

                result = mFairy.findPic(441,412,493,547,"arrow.png");
                mFairy.onTap(0.8f,result,"打开悬赏图",Sleep);

                result = mFairy.findPic("go now.png");
                mFairy.onTap(0.8f,result,"前往悬赏图",Sleep);

                result = mFairy.findPic("begin Experience.png");
                mFairy.onTap(0.8f,result,"进图",2000);



                result = mFairy.findPic("Lineup lock up.png");
                if(result.sim  >  0.8f ){
                    LtLog.e("进入副本");
                    setTaskName(2);return;
                }

                result = mFairy.findPic("complete.png");
               if (result.sim > 0.8f){
                   LtLog.e("完成悬赏");
                   setTaskEnd();return;
               }

                result = mFairy.findPic("Mysterious mission.png");
                if (result.sim > 0.8f){
                    LtLog.e("神秘任务");
                    mFairy.onTap(0.8f,result,640,514,664,527,"神秘任务关闭",Sleep);
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }

            }
            public void content_2() throws Exception {
                long dazeTime=mFairy.mMatTime(924,63,35,12,0.9f);
                LtLog.e("时间============"+dazeTime);
                if (dazeTime >= 150){
                    mFairy.initMatTime();
                    LtLog.e("去滑动");
                    setTaskName(3);return;
                }
                result = mFairy.findPic(0,65,1279,500,new String[]{"Shang little.png","Shang.png","Shang big.png","shang top.png","shang solittle.png","shang solittle2.png"});
                mFairy.onTap(0.7f,result,"悬赏怪",2000);
                if (result.sim < 0.7f){
                    result = mFairy.findPic(0,65,1279,500,new String[]{"Zhan.png","Zhan2.png","Zhan3.png","so little.png"});
                    mFairy.onTap(0.8f,result,"普通怪",2000);
                }
                result = mFairy.findPic(0,204,59,557,"monster.png");//18,406   65,399
                mFairy.onTap(0.7f,result,result.x+47,result.y-7,result.x+48,result.y-6,"怪左",2000);

                result = mFairy.findPic(1203,181,1280,697,"monster2.png");//1273,451   1224,442
                mFairy.onTap(0.7f,result,result.x-49,result.y-9,result.x-48,result.y-8,"怪右",2000);

                result = mFairy.findPic(8,678,1280,720,"down.png");//436,714  433,664
                mFairy.onTap(0.7f,result,result.x-3,result.y-50,result.x-2,result.y-49,"怪下",2000);


                result = mFairy.findPic("make war.png");
                mFairy.onTap(0.8f,result,"开战",2000);

                result = mFairy.findPic(new String[]{"begin Experience.png","Lian.png"});
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("Chapter rewards.png");
                mFairy.onTap(0.8f,result,"章节奖励",2000);
                mFairy.onTap(0.8f,result,613,595,637,608,"章节奖励",Sleep);

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Bai.png");
                mFairy.onTap(0.8f,result,"失败",2000);
                if (result.sim > 0.8f){
                    LtLog.e("失败了");
                    gameUtil.close();
                    setTaskEnd();return;
                }

            }
            public void content_3() throws Exception {
                if (overtime(2,1))return;

                if (us){
                    mFairy.touchDown(518,349);
                    mFairy.touchMove(917,344,1500);
                    mFairy.touchUp();
                    us=false;
                    LtLog.e("左滑动");
                }

                if (!us){
                    mFairy.touchDown(917,344);
                    mFairy.touchMove(518,349,1500);
                    mFairy.touchUp();
                    us =true;
                    LtLog.e("右滑动");
                }

            }
            public void content_4() throws Exception {
                long dazeTime=mFairy.mMatTime(966,146,63,11,0.9f);
                if (dazeTime >= 60){
                    mFairy.initMatTime();
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("delegate.png");
                mFairy.onTap(0.8f,result,"委派",Sleep);

                result = mFairy.findPic("reward.png");
                mFairy.onTap(0.8f,result,"悬赏",Sleep);

                result = mFairy.findPic("receive.png");
                mFairy.onTap(0.8f,result,"领取奖励",Sleep);


                result = mFairy.findPic("arrow2.png");
                mFairy.onTap(0.8f,result,"打开悬赏图",Sleep);

                result = mFairy.findPic("go now.png");
                mFairy.onTap(0.8f,result,"前往悬赏图",Sleep);

                result = mFairy.findPic("begin Experience.png");
                mFairy.onTap(0.8f,result,"进图",Sleep);


                result = mFairy.findPic("Lineup lock up.png");
                if(result.sim  >  0.8f ){
                    LtLog.e("进入副本");
                    setTaskName(2);return;
                }

                result = mFairy.findPic(505,163,825,519,"complete.png");
                if (result.sim > 0.8f){
                    LtLog.e("完成悬赏");
                    setTaskEnd();return;
                }

                result = mFairy.findPic(436,169,835,482,"Mysterious mission.png");
                if (result.sim > 0.8f){
                    LtLog.e("神秘任务");
                    mFairy.onTap(0.8f,result,640,514,664,527,"神秘任务关闭",Sleep);
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Mysterious mission2.png");
                if (result.sim > 0.8f){
                    LtLog.e("神秘任务");
                    mFairy.onTap(0.8f,result,640,514,664,527,"神秘任务关闭",Sleep);
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "悬赏");
    }

    /**
     * 奖励的领取  日常、成就、每日免费领取、领取赠送好友 、邮件
     */
    public void receivePrize() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(3);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f,result,"日常",Sleep);

//                result = mFairy.findPic("receive day.png");
//                mFairy.onTap(0.8f,result,"领取",Sleep);

                result = mFairy.findPic("box.png");
                mFairy.onTap(0.8f,result,"一键领取累积奖励",Sleep);

                result = mFairy.findPic("Gan Fu.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("achievement.png");
                    mFairy.onTap(0.8f,result,"成就",3000);
                }

                result = mFairy.findPic("receive Cj.png");
                mFairy.onTap(0.8f,result,"领取成就奖励",Sleep);
                result1 = mFairy.findPic("Cheng Jiu.png");
                if(result.sim < 0.8f && result1 .sim > 0.8f){
                    mFairy.onTap(0.8f,result1,1096,73,1101,85,"关闭成就",2000);

                    setTaskName(4);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(4,1))return;

                result = mFairy.findPic("email.png");
                mFairy.onTap(0.8f,result,"邮件",3000);

                result = mFairy.findPic("Collect all.png");
                mFairy.onTap(0.8f,result,"全部领取",Sleep);

                result = mFairy.findPic("Jian.png");
                mFairy.onTap(0.8f,result,760,513,783,524,"全部领取",Sleep);

                if (err == 3){
                    gameUtil.close();
                }
            }
            public void content_3() throws Exception {
                if (overtime(30,2))return;
                result = mFairy.findPic("friend.png");
                mFairy.onTap(0.8f,result,"好友",3000);

                result = mFairy.findPic("friend top.png");
                if(result.sim < 0.8f){
                    err =0;
                }

                result = mFairy.findPic("Fetter.png");
                mFairy.onTap(0.8f,result,1222,192,1240,209,"羁绊等级提升",Sleep);

                result = mFairy.findPic(415,258,503,450,"Receive as a gift.png");
                mFairy.onTap(0.8f,result,"赠送领取",Sleep);

                result = mFairy.findPic(415,258,503,450,"Receive as a gift2.png");
                mFairy.onTap(0.8f,result,"赠送",Sleep);
                if (err == 29){
                    gameUtil.close();
                }

            }
            public void content_4() throws Exception {
                result = mFairy.findPic("shop.png");
                mFairy.onTap(0.8f,result,"商城",Sleep);

                result = mFairy.findPic("Ti.png");
                mFairy.onTap(0.8f,result,190,654,195,660,"不在提示",Sleep);
                mFairy.onTap(0.8f,result,1184,73,1196,82,"不在提示关闭",Sleep);

                result = mFairy.findPic("Grocery box.png");
                mFairy.onTap(0.8f,result,"杂货箱",Sleep);

                result = mFairy.findPic("goods shelves.png");
                mFairy.onTap(0.8f,result,"货架",3000);

                result = mFairy.findPic("Shou L.png");
                mFairy.onTap(0.8f,result,"领取",3000);

                result = mFairy.findPic("Goods and gifts.png");
                result1 = mFairy.findPic("Free Admission.png");
                mFairy.onTap(0.8f,result1,518,161,539,174,"免费领取",5000);
                if(result.sim > 0.8f && result1.sim < 0.8f){
                    LtLog.e("领完了");
                    setTaskEnd();return;
                }


            }
        }.taskContent(mFairy, "领奖");
    }

    /**
     *  委派
     */
    public void delegate() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(10,2))return;
                result = mFairy.findPic("delegate.png");
                mFairy.onTap(0.8f,result,"委派",2000);

                result1 = mFairy.findPic("delegate2.png");
                if(result1.sim > 0.8f){
                    result = mFairy.findPic(168,172,1084,656,"red.png");
                    mFairy.onTap(0.8f,result,"领取奖励",2000);
                }

                result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f,result,"确定领取",2000);

                result = mFairy.findPic(168,172,1084,656,"new RW.png");
                mFairy.onTap(0.8f,result,"新任务",2000);

                result=mFairy.findMultiColor(135,139,1096,669,0.9f,"183,165,116","-10|-20|207,183,131&-6|-54|233,217,171&20|-77|253,237,187&53|-77|253,237,187&83|-47|227,209,175&83|-16|203,169,120&74|0|185,159,112");
                mFairy.onTap(0.8f,result,result.x+33,result.y-32,result.x+34,result.y-31,"任务",2000);//431,355    502,417    673,389   706,357

                result = mFairy.findPic("Wei P.png");
                mFairy.onTap(0.8f,result,"委派境灵",3000);

                result = mFairy.findPic(772,576,994,629,"Wei P.png");
                mFairy.onTap(0.8f,result,"一键委派",3000);

                result = mFairy.findPic("begin Wp.png");
                mFairy.onTap(0.8f,result,"开始委派",3000);

                result = mFairy.findPic("accelerate.png");
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,1159,68,1169,80,"关闭",3000);
                }

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                setTaskEnd();return;

            }

        }.taskContent(mFairy, "委派");
    }

    /**
     * 七曜塔
     */
    public void Pagoda() throws Exception {

        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic(192,105,1195,344,new String[]{"The Crusade.png","zz.png"});
                mFairy.onTap(0.8f,result,"征战",Sleep);

                result = mFairy.findPic("lvdengji.png");
                if (result.sim > 0.8f){
                    LtLog.e("等级不够");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("seven Ta.png");
                mFairy.onTap(0.8f,result,"选择任务",Sleep);

                result = mFairy.findPic("Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result = mFairy.findPic("make war.png");
                mFairy.onTap(0.8f,result,"开战",Sleep);

                result = mFairy.findPic("victory.png");
                mFairy.onTap(0.8f,result,"胜利",Sleep);

                result = mFairy.findPic(new String[]{"Bai.png","suo.png"});
                if (result.sim > 0.8f){
                    LtLog.e("失败了或者打到上限了去扫荡");
                    setTaskName(2);return;
                }

            }
            public void content_2() throws Exception {
                result = mFairy.findPic("Mopping up.png");
                mFairy.onTap(0.8f,result,"快速扫荡",Sleep);

                result = mFairy.findPic("Mopping up2.png");
                mFairy.onTap(0.8f,result,"扫荡",Sleep);

                result = mFairy.findPic("arbitrarily.png");
                mFairy.onTap(0.8f,result,"任意位置继续",Sleep);

                result = mFairy.findPic(new String[]{"no Sao D.png","no Sao D2.png"});
                if(result.sim > 0.8f){
                    LtLog.e("扫荡道具没有了" );
                    mFairy.onTap(0.8f,result,966,162,981,179,"扫荡道具了",2000);

                    setTaskEnd();return;

                }


            }

        }.taskContent(mFairy, "七曜塔");
    }

    /**
     * 主线
     */
    public void principalLine() throws Exception {

        new SingleTask(mFairy) {
            int cish = 0;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (cish >= 3){
                    LtLog.e("打不过去结束");
                    gameUtil.close();
                    setTaskEnd();return;
                }

                result = mFairy.findPic(17,166,754,430,new String[]{"ZX.png","ZX2.png","XL1.png"});
                mFairy.onTap(0.8f,result,"主线",Sleep);

                result = mFairy.findPic(new String[]{"line.png","line2.png","XL2.png"});
                mFairy.onTap(0.8f,result,"主线",Sleep);

                result = mFairy.findPic("Click to skip.png");
                mFairy.onTap(0.8f,result,"点击跳过",3000);

                result = mFairy.findPic("skip2.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);
//
//                result = mFairy.findPic("skip3.png");
//                mFairy.onTap(0.8f,result,"开战",Sleep);

                result = mFairy.findPic("continue.png");
                mFairy.onTap(0.8f,result,"继续",Sleep);

                result = mFairy.findPic("make war.png");
                mFairy.onTap(0.8f,result,"开战",2000);

                result = mFairy.findPic("Chapter rewards.png");
                mFairy.onTap(0.8f,result,"章节奖励",2000);
                mFairy.onTap(0.8f,result,613,595,637,608,"章节奖励",Sleep);

                result = mFairy.findPic(222,168,438,470,new String[]{"Unlock.png","Linging.png"});
                if (result.sim > 0.8f){
                    LtLog.e("完成主线升级解锁");
                   setTaskEnd();return;
                }
                result = mFairy.findPic("zxshibai.png");
                mFairy.onTap(0.8f,result,"失败",2000);
                if(result.sim > 0.8f){
                    cish++;
                }


            }


        }.taskContent(mFairy, "主线");
    }

    /**
     * 引导
     */
    public void guide() throws Exception {

        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                result = mFairy.findPic("Manual.png");
                mFairy.onTap(0.8f,result,"自动",2000);

                result = mFairy.findPic("2X speed.png");
                mFairy.onTap(0.8f,result,"倍速",2000);

                result = mFairy.findPic("Pu.png");
                mFairy.onTap(0.8f,result,1000,650,1021,671,"普工",3000);
                mFairy.onTap(0.8f,result,750,163,763,173,"普工",3000);
                mFairy.onTap(0.8f,result,750,163,763,173,"普工",3000);

                result = mFairy.findPic(779,460,1064,636,"skill.png");
                mFairy.onTap(0.8f,result,1115,647,1132,665,"技能",3000);
                mFairy.onTap(0.8f,result,756,165,765,174,"技能",3000);
                mFairy.onTap(0.8f,result,756,165,765,174,"技能",3000);

                result = mFairy.findPic(17,166,754,430,new String[]{"ZX.png","ZX2.png"});
                mFairy.onTap(0.8f,result,"主线",Sleep);

                result = mFairy.findPic(new String[]{"line.png","line2.png"});
                mFairy.onTap(0.8f,result,"主线",Sleep);

                result = mFairy.findPic("Click to skip.png");
                mFairy.onTap(0.8f,result,"点击跳过",3000);

                result = mFairy.findPic("GLV.png");
                mFairy.onTap(0.8f,result,137,621,156,637,"攻略",Sleep);

                result = mFairy.findPic("XQ.png");
                mFairy.onTap(0.8f,result,580,565,600,580,"详情",Sleep);

                result = mFairy.findPic("ZH.png");
                mFairy.onTap(0.8f,result,910,572,937,584,"组合详情",Sleep);

                result = mFairy.findPic(983,16,1243,156,"close1.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("skip2.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);

                result = mFairy.findPic("TG.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);

//                result = mFairy.findPic("skip3.png");
//                mFairy.onTap(0.8f,result,"开战",Sleep);

                result = mFairy.findPic("QL.png");
               if (result.sim > 0.8f){
                   mFairy.touchDown(410,604);
                   mFairy.touchMove(601,413,1500);
                   mFairy.touchUp();
               }

                result = mFairy.findPic("SX.png");
                mFairy.onTap(0.8f,result,"收下",3000);
                mFairy.onTap(0.8f,result,39,27,51,42,"返回",3000);

                result = mFairy.findPic("JL.png");
                mFairy.onTap(0.8f,result,"境灵",2000);

                result = mFairy.findPic("YC.png");
                mFairy.onTap(0.8f,result,"育成",2000);

                result = mFairy.findPic("SJ.png");
                mFairy.onTap(0.8f,result,"升级",2000);
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,40,38,52,47,"返回",2000);
                    mFairy.onTap(0.8f,result,40,38,52,47,"返回",2000);
                }

                result = mFairy.findPic("YL.png");
                mFairy.onTap(0.8f,result,1104,649,1119,657,"元灵",2000);
                mFairy.onTap(0.8f,result,762,213,773,223,"元灵",2000);

                result = mFairy.findPic("GRS.png");
                mFairy.onTap(0.8f,result,1213,223,1218,235,"古荣神",2000);
                mFairy.onTap(0.8f,result,758,212,770,224,"古荣神",2000);

                result = mFairy.findPic("FH.png");
                mFairy.onTap(0.8f,result,45,30,61,49,"返回",2000);

                result = mFairy.findPic("ZHH.png");
                mFairy.onTap(0.8f,result,"召唤",3000);

                result = mFairy.findPic("GJJL.png");
                mFairy.onTap(0.8f,result,"高阶境灵",3000);


                result = mFairy.findPic("QLYC.png");
                mFairy.onTap(0.8f,result,"启灵一次",2000);

                result = mFairy.findPic("continue.png");
                mFairy.onTap(0.8f,result,"继续",2000);

                result = mFairy.findPic("BZ.png");
                mFairy.onTap(0.8f,result,"布阵",2000);

                result = mFairy.findPic("DK.png");
                mFairy.onTap(0.8f,result,"打开",4000);
                mFairy.onTap(0.8f,result,1187,48,1200,61,"关闭",2000);

                result = mFairy.findPic("TH.png");
                mFairy.onTap(0.7f,result,"替换",2000);

                result = mFairy.findPic("CS.png");
                mFairy.onTap(0.8f,result,"长蛇",2000);

                result = mFairy.findPic("make war.png");
                mFairy.onTap(0.8f,result,"开战",2000);

                result = mFairy.findPic("LQ.png");
                mFairy.onTap(0.8f,result,1115,647,1132,659,"灵气",2000);
                mFairy.onTap(0.8f,result,311,341,319,351,"灵气",2000);

                result = mFairy.findPic("Chapter rewards.png");
                mFairy.onTap(0.8f,result,"章节奖励",2000);
                mFairy.onTap(0.8f,result,613,595,637,608,"章节奖励",Sleep);

                result = mFairy.findPic(222,168,438,470,new String[]{"Unlock.png","Linging.png"});
                if (result.sim > 0.8f){
                    LtLog.e("完成主线升级解锁");
                    setTaskEnd();return;
                }

            }


        }.taskContent(mFairy, "初始引导");
    }
    /**
     * 历练
     */
    public void experience() throws Exception {

        new SingleTask(mFairy) {
            boolean us = false;
            public void content_0() throws Exception {
                long dazeTime=mFairy.mMatTime(924,63,35,12,0.9f);
                LtLog.e("时间============"+dazeTime);
                if (dazeTime >= 150){
                    mFairy.initMatTime();
                    LtLog.e("去滑动");
                    setTaskName(2);return;
                }
                result = mFairy.findPic("begin Experience.png");
                mFairy.onTap(0.8f,result,"进图",2000);

//                result = mFairy.findPic(new String[]{"Lian.png","Lian2.png"});
//                if (result.sim > 0.7f){
//                    result = mFairy.findPic("begin Experience.png");
//                    mFairy.onTap(0.8f,result,"进图",2000);
//                }
                result = mFairy.findPic("Lineup lock up.png");
                 if(result.sim > 0.8f) {
                     result = mFairy.findPic(0, 65, 1279, 500, new String[]{"Shang little.png", "Shang.png", "Shang big.png"});
                     mFairy.onTap(0.7f, result, "悬赏怪", 2000);
                     if (result.sim < 0.7f) {
                         result = mFairy.findPic(0, 65, 1279, 500, new String[]{"Zhan.png", "Zhan2.png", "Zhan3.png"});
                         mFairy.onTap(0.8f, result, "普通怪", 2000);
                     }
                     result = mFairy.findPic(0, 204, 59, 557, "monster.png");//18,406   65,399
                     mFairy.onTap(0.7f, result, result.x + 47, result.y - 7, result.x + 48, result.y - 6, "怪左", 2000);

                     result = mFairy.findPic(1210, 283, 1279, 573, "monster2.png");//1273,451   1224,442
                     mFairy.onTap(0.7f, result, result.x - 49, result.y - 9, result.x - 48, result.y - 8, "怪右", 2000);
                 }
                result = mFairy.findPic("make war.png");
                mFairy.onTap(0.8f,result,"开战",2000);

                result = mFairy.findPic("Chapter rewards.png");
                mFairy.onTap(0.8f,result,"章节奖励",2000);
                mFairy.onTap(0.8f,result,613,595,637,608,"章节奖励",Sleep);

                result = mFairy.findPic("shoutong.png");
                mFairy.onTap(0.8f,result,"首通",2000);

                result = mFairy.findPic("victory.png");
                mFairy.onTap(0.8f,result,"胜利",2000);

                result = mFairy.findPic("Bai.png");
                mFairy.onTap(0.8f,result,"失败",2000);
                if (result.sim > 0.8f){
                    LtLog.e("失败了");
                    gameUtil.close();
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskEnd();return;
                }

            }
            public void content_2() throws Exception {
                if (overtime(2,0))return;

                if (us){
                    mFairy.touchDown(518,349);
                    mFairy.touchMove(917,344,1500);
                    mFairy.touchUp();
                    us=false;
                    LtLog.e("左滑动");
                }

                if (!us){
                    mFairy.touchDown(917,344);
                    mFairy.touchMove(518,349,1500);
                    mFairy.touchUp();
                    us =true;
                    LtLog.e("右滑动");
                }

            }

        }.taskContent(mFairy, "历练");
    }

    /**
     * 演武
     */
    public void practiceMartialArts() throws Exception {

        new SingleTask(mFairy) {
            int num = 0 ;
            int ssw = 0 ;
            public void inOperation() throws Exception {
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(3,2))return;
                result = mFairy.findPic(192,105,1195,344,new String[]{"Practice martial arts.png","dou.png"});
                mFairy.onTap(0.8f,result,"演武",2000);

                result = mFairy.findPic("ZSPractice martial arts.png");//219,348   160,360
                mFairy.onTap(0.8f,result,"钟山演武",2000);

                result = mFairy.findPic("Always win.png");
                mFairy.onTap(0.8f,result,"常胜",2000);
                if (result.sim > 0.8f ){
                    num=0;
                }
                result = mFairy.findPic("Hundred battles.png");
                mFairy.onTap(0.8f,result,"百战",2000);
                if (result.sim > 0.8f ){
                    num=0;
                }
                result = mFairy.findPic("Primordial mind.png");
                mFairy.onTap(0.8f,result,"初心",2000);
                if (result.sim > 0.8f ){
                    num=0;
                }
                List<FindResult> list = mFairy.findPic(308,244,1155,509,0.8f,"negative.png");
                List<FindResult> list2 = mFairy.findPic(308,244,1155,509,0.8f,"victory2.png");
                ssw = list.size()+list2.size();
                if (ssw >=3){
                    result = mFairy.findPic("Reset.png");
                    mFairy.onTap(0.8f,result,"重置",2000);
                }
                result = mFairy.findPic(556,266,759,452,"Reset2.png");
                mFairy.onTap(0.8f,result,770,510,788,523,"确定重置",2000);
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(192,105,1195,344,"Practice martial arts.png");
                mFairy.onTap(0.8f,result,"演武",2000);

                result = mFairy.findPic("ZSPractice martial arts.png");//219,348   160,360
                mFairy.onTap(0.8f,result,"钟山演武",2000);

                result = mFairy.findPic("Always win.png");
                mFairy.onTap(0.8f,result,"常胜",2000);
                if (result.sim > 0.8f ){
                    num=0;
                }
                result = mFairy.findPic("Hundred battles.png");
                mFairy.onTap(0.8f,result,"百战",2000);
                if (result.sim > 0.8f ){
                    num=0;
                }
                result = mFairy.findPic("Primordial mind.png");
                mFairy.onTap(0.8f,result,"初心",2000);
                if (result.sim > 0.8f ){
                    num=0;
                }
               List<FindResult> list = mFairy.findPic(457,287,997,503,0.9f,"resist the enemy.png");//652,226,741,313
                for (int i = 0 ; i < list.size() ; i++){
                    LtLog.e("=="+list.get(i).x+","+list.get(i).y);
                    result = mFairy.findPic(list.get(i).x+183,list.get(i).y-92,list.get(i).x+272,list.get(i).y-5,"negative.png");
                    result2 = mFairy.findPic(list.get(i).x+183,list.get(i).y-92,list.get(i).x+272,list.get(i).y-5,"victory2.png");
                    if (result.sim >= 0.7f){
                        LtLog.e("****"+list.get(i).x+","+list.get(i).y);
                    }else if (result2.sim >= 0.8f){
                        LtLog.e("//////"+list.get(i).x+","+list.get(i).y);
                    } else {
                        mFairy.onTap(0.8f,list.get(i),"选人",2000);
                        return;
                    }
                }

                result = mFairy.findPic("TZ.png");
                mFairy.onTap(0.8f,result,"挑战",2000);

                result = mFairy.findPic("make war.png");
                mFairy.onTap(0.8f,result,"开战",2000);

                result = mFairy.findPic("victory.png");
                mFairy.onTap(0.8f,result,"胜利",2000);

                result = mFairy.findPic("yes Wu.png");
                mFairy.onTap(0.8f,result,"确定",2000);

                result = mFairy.findPic(new String[]{"box Wu.png","box Wu2.png","box Wu3.png"});
                mFairy.onTap(0.8f,result,"宝箱",2000);

                result = mFairy.findPic("browse.png");
                mFairy.onTap(0.8f,result,"关闭浏览",2000);

                result = mFairy.findPic("Bai.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,"失败",2000);
                    num ++;

                }
                LtLog.e("失败次数===="+num);
                if (num >= 3){
                    LtLog.e("失败了3次以上 结束");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Chu.png");
                if (num >= 2 && result.sim > 0.8f){
                    LtLog.e("初心失败了2次以上 结束");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("No tickets.png");
                if (result.sim > 0.8f){
                    LtLog.e("没票了");
                   setTaskEnd();return;
                }
                result = mFairy.findPic(new String[]{"Yi.png","screen.png"});
                mFairy.onTap(0.8f,result,"任意位置继续",Sleep);
            }

        }.taskContent(mFairy, "演武");
    }

    /**
     *  定时委派 、领活跃 、领成就
     */
    public void delegates() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(10,3))return;
                result = mFairy.findPic("delegate.png");
                mFairy.onTap(0.8f,result,"委派",2000);

                result1 = mFairy.findPic("delegate2.png");
                if(result1.sim > 0.8f){
                    result = mFairy.findPic(168,172,1084,656,"red.png");
                    mFairy.onTap(0.8f,result,"领取奖励",2000);
                }

                result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f,result,"确定领取",2000);

                result = mFairy.findPic(168,172,1084,656,"new RW.png");
                mFairy.onTap(0.8f,result,"新任务",2000);

                result=mFairy.findMultiColor(135,139,1096,669,0.9f,"183,165,116","-10|-20|207,183,131&-6|-54|233,217,171&20|-77|253,237,187&53|-77|253,237,187&83|-47|227,209,175&83|-16|203,169,120&74|0|185,159,112");
                mFairy.onTap(0.8f,result,result.x+33,result.y-32,result.x+34,result.y-31,"任务",2000);//431,355    502,417    673,389   706,357

                result = mFairy.findPic("Wei P.png");
                mFairy.onTap(0.8f,result,"委派境灵",3000);

                result = mFairy.findPic(772,576,994,629,"Wei P.png");
                mFairy.onTap(0.8f,result,"一键委派",3000);

                result = mFairy.findPic("begin Wp.png");
                mFairy.onTap(0.8f,result,"开始委派",3000);

                result = mFairy.findPic("accelerate.png");
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,1159,68,1169,80,"关闭",3000);
                }

                result = mFairy.findPic(new String[]{"Lack of energy.png","physical strength.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("没有体力了");
                    setTaskName(3);return;
                }
                if (err == 9){
                    gameUtil.close();
                    //timekeepInit("定时委派3小时");
                }
            }
            public void content_2() throws Exception {
                LtLog.e("***************定时委派挂机中*****************");
                boolean xs = timekeep(3,3600000,"定时委派3小时");
                mFairy.sleep(1000);
                if (xs){
                    setTaskName(0);return;
                }else {
                    result = mFairy.findPic("dating.png");
                    if (result.sim < 0.8f){
                        gameUtil.close();
                    }
                }
            }
            public void content_3() throws Exception {
                result = mFairy.findPic(3,335,518,610,"tili.png");
                mFairy.onTap(0.8f,result,"体力",Sleep);

                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f,result,"日常",Sleep);

                result = mFairy.findPic("box.png");
                mFairy.onTap(0.8f,result,"一键领取累积奖励",Sleep);

                result = mFairy.findPic("Gan Fu.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("achievement.png");
                    mFairy.onTap(0.8f,result,"成就",3000);
                }

                result = mFairy.findPic("receive Cj.png");
                mFairy.onTap(0.8f,result,"领取成就奖励",Sleep);
                result1 = mFairy.findPic("Cheng Jiu.png");
                if(result.sim < 0.8f && result1 .sim > 0.8f){
                    mFairy.onTap(0.8f,result1,1096,73,1101,85,"关闭成就",2000);
                    timekeepInit("定时委派3小时");
                    setTaskName(2);return;
                }
            }


        }.taskContent(mFairy, "定时委派");
    }

}