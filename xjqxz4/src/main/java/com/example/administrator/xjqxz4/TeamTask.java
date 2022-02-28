package com.example.administrator.xjqxz4;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TeamTask {
    xjqxz4 mFairy;
    FindResult result;
    FindResult result1;
    CommonFunction commonFunction;
    GamePublicFunction gamePublicFunction;
    public TeamTask(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        commonFunction = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
    }


    //带队任务
    public void  dayToDay() throws Exception{
        int bj = 0,bj_1;
        int  cs_1=0;
        int js_1=0,js_2=0,js_3=0,js_4=0;
        int numcolor;
        int ret,ret1=0;
        int xjsl=0;
        String string="", string1="";
        List<String> list = new ArrayList<>();
        if (!AtFairyConfig.getOption("xjsl").equals("")){
            //仙境试炼
            list.add("1");
            xjsl=Integer.parseInt(AtFairyConfig.getOption("xjsl"));
        }
        if (AtFairyConfig.getOption("xjhj").equals("1")){
            //心剑幻境
            list.add("2");
        }
        if (AtFairyConfig.getOption("hmmj").equals("1")){
            //幻冥梦境
            list.add("3");
        }
        LtLog.e(commonFunction.getLineInfo("list==="+list.toString()));
        bj_1 = bj;
        while (true) {
            LtLog.e(commonFunction.getLineInfo("带队任务中bj=" + bj+",发呆计次+"+js_2));
            Thread.sleep(2000);
            if (bj_1 == bj  && bj!=3 ) {
                cs_1++;
            } else if (bj_1 != bj) {
                cs_1 = 0;
                bj_1 = bj;
                LtLog.e(commonFunction.getLineInfo("标记发生变化"));
            }
            if (cs_1 > 100) {
                cs_1 = 0;
                bj = 0;
                LtLog.e(commonFunction.getLineInfo("标记长时间未发生变化"));
            }
            if (bj==0){
                if (list.size()==0){
                    LtLog.e(commonFunction.getLineInfo("没有任务了"));
                    break;
                }
                LtLog.e(commonFunction.getLineInfo("list==="+list.toString()));
                if (list.get(0).equals("1")){
                    string="xjsl.png";
                    string1="xjsl1.png";
                }else if (list.get(0).equals("2")){
                    string="xjhj.png";
                    string1="xjhj1.png";
                }else if (list.get(0).equals("3")){
                    string="hmmj.png";
                    string1="hmmj1.png";
                }
                js_1=0;
                js_2=0;
                js_3=0;
                bj=1;
            }
            if (bj==1){
                 ret=gamePublicFunction.mission(string,string1,2);
                if (ret == 0) {
                    list.remove(0);
                    bj=0;
                } else if (ret == 1) {
                    bj = 2;
                }
            }
            if (bj==2){
                result1 = commonFunction.FindManyPic(8,352,993,666, new String[]{"Team entry.png","Team entry1.png","Team entry2.png","Team entry3.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result1,0.8f,"组队进入,进入活动"));
                if (result1.sim>0.8f){
                    if (xjsl==2){
                        result = mFairy.findPic2(commonFunction.setImg("xjsljt.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙境试炼箭头"));
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }else if (xjsl==3){
                        result = mFairy.findPic2(commonFunction.setImg("xjsljt.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙境试炼箭头"));
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }
                    commonFunction.Compare(0.8f, result1, commonFunction.getImg());
                    js_3++;
                    if (js_3>5){
                        list.remove(0);
                        bj=0;
                    }
                }else {
                    js_3=0;
                }
    /*            result = commonFunction.FindManyPic(8,352,993,666, new String[]{"Team entry.png","Team entry1.png","Team entry2.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result,0.8f,"组队进入,进入活动"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_3++;
                    if (js_3>5){
                        list.remove(0);
                        bj=0;
                    }
                }else {
                    js_3=0;
                }*/


                result = mFairy.findPic2(357,227,921,473,commonFunction.setImg("Need team formation.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "需要组队"));
                commonFunction.RndCompare(0.8f, 527, 508, result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("Create team.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "创建队伍"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());



                result = mFairy.findPic2(commonFunction.setImg("Quit the team.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "回安全区"));
                commonFunction.RndCompare(0.8f, 1130, 244, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("3people.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "3个人了开始进入活动"));
                commonFunction.RndCompare(0.8f, 979, 617, result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, 1128, 182, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    Thread.sleep(2000);
                }

                result = mFairy.findPic2(364,248,1066,520,commonFunction.setImg("People dissatisfied.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "人不满直接开"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Team member's agreement.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "队员同意"));
                commonFunction.RndCompare(0.8f, 640, 504, result, commonFunction.getImg());

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "没有进入副本,拉下跟站="+js_1));
                if (result.sim>0.8f){
                    js_1++;
                    if (js_1>8){
                        result = commonFunction.FindManyPic(1121,152,1280,193, new String[]{"rightteam.png","rightteam2.png","rightteam1.png","rightteam3.png"}, 0);
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧队伍"));
                        commonFunction.RndCompare(0.8f, 1155,170, result, commonFunction.getImg());



                            result = mFairy.findPic2(commonFunction.setImg("Quit the team.png"));
                            LtLog.e(commonFunction.getLineInfo(result, 0.8f, "拉跟站"));
                            commonFunction.RndCompare(0.8f, 1128, 182, result, commonFunction.getImg());
                        js_1=0;
                    }
                }else {
                    js_1=0;
                }
                result = mFairy.findPic2(commonFunction.setImg("Quit the team.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "喊话招募"));
                commonFunction.RndCompare(0.8f, 583, 619, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Shouting.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "招募设置"));
                result1 = mFairy.findPic2(commonFunction.setImg("Shouting and selecting.png"));
                LtLog.e(commonFunction.getLineInfo(result1, 0.8f, "喊话勾选"));
                if (result.sim>0.8f && result1.sim<0.8f){
                    mFairy.tap(701,332);
                    mFairy.tap(494,396);
                    mFairy.tap(701,396);
                    mFairy.tap(645,500);
                }else if (result.sim>0.8f && result1.sim>0.8f){
                    mFairy.tap(497,334);
                    mFairy.tap(645,500);
                }
                result = commonFunction.FindManyPic(1036,84,1277,393, new String[]{"fb.png","fb1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
                if (result.sim>0.8f){
                    bj=3;
                }

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                if (result.sim>0.8f){
                       js_4++;
                       if (js_4>30){
                           result = commonFunction.FindManyPic(1121,152,1280,193, new String[]{"rightteam.png","rightteam2.png","rightteam1.png","rightteam3.png"}, 0);
                           LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧队伍"));
                           commonFunction.RndCompare(0.8f, 1155,170, result, commonFunction.getImg());

                           result = commonFunction.FindManyPic(1121,152,1280,193, new String[]{"rightteam.png","rightteam2.png","rightteam1.png","rightteam3.png"}, 0);
                           LtLog.e(commonFunction.getLineInfo(result, 0.8f, "右侧队伍"));
                           commonFunction.RndCompare(0.8f, 1155,170, result, commonFunction.getImg());
                           js_4=0;
                       }
                }else {
                    js_4=0;
                }
            }
           if (bj==3){
               result = commonFunction.FindManyPic(1036,84,1277,393, new String[]{"fb.png","fb1.png"}, 0);
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
               if (result.sim>0.8f){
                   js_2=0;
               }else {
                   js_2++;
                   if (js_2>30){
                       bj=0;
                   }
               }
               result = mFairy.findPic2(commonFunction.setImg("Team member's agreement.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "队员同意"));
               commonFunction.RndCompare(0.8f, 640, 504, result, commonFunction.getImg());
               if (result.sim>0.8f){
                   js_2=0;
               }

               result = mFairy.findPic2(364,248,1066,520,commonFunction.setImg("People dissatisfied.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "人不满直接开"));
               commonFunction.Compare(0.8f, result, commonFunction.getImg());
               if (result.sim>0.8f){
                   js_2=0;
               }

               result = mFairy.findPic2(357,226,924,474,commonFunction.setImg("team full.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "队伍满同意开车"));
               commonFunction.RndCompare(0.8f, 753, 504, result, commonFunction.getImg());
               if (result.sim>0.8f){
                   js_2=0;
               }


               result = mFairy.findPic2(358,228,918,468,commonFunction.setImg("Mission accomplished.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "当前任务完成"));
               commonFunction.RndCompare(0.8f, 762, 506, result, commonFunction.getImg());
               if (result.sim>0.8f){
                   list.remove(0);
                   bj=0;
               }
               result = mFairy.findPic2(commonFunction.setImg("xjhjcomplete.png"));
               LtLog.e(commonFunction.getLineInfo(result, 0.8f, "心剑幻境完成"));
               if (result.sim>0.8f){
                   list.remove(0);
                   bj=0;
               }
           }
        }
    }

    //跟队任务
    public void  followTeam() throws Exception{
        int bj = 0;
        int js_1=0,js_2=0,js_3=0,js_4=0;
        int numcolor;
        int ret,ret1=0;
        int xjsl=0;
        String string="", string1="";
        List<String> list = new ArrayList<>();
        if (!AtFairyConfig.getOption("xjsl").equals("")){
            //仙境试炼
            list.add("1");
            xjsl=Integer.parseInt(AtFairyConfig.getOption("xjsl"));
        }
        if (AtFairyConfig.getOption("xjhj").equals("1")){
            //心剑幻境
            list.add("2");
        }
        if (AtFairyConfig.getOption("hmmj").equals("1")){
            //幻冥梦境
            list.add("3");
        }
        if (AtFairyConfig.getOption("ydxs").equals("1")){
            //幽都悬赏
            list.add("4");
        }
        LtLog.e(commonFunction.getLineInfo("list==="+list.toString()));
        while (true) {
            LtLog.e(commonFunction.getLineInfo("跟队任务中bj=" + bj+",发呆计次+"+js_2));
            Thread.sleep(2000);
            if (bj==0){
                if (list.size()==0){
                    LtLog.e(commonFunction.getLineInfo("没有任务了"));
                    break;
                }
                LtLog.e(commonFunction.getLineInfo("list==="+list.toString()));
                if (list.get(0).equals("1")){
                    string="xjsl.png";
                    string1="xjsl1.png";
                }else if (list.get(0).equals("2")){
                    string="xjhj.png";
                    string1="xjhj1.png";
                }else if (list.get(0).equals("3")){
                    string="hmmj.png";
                    string1="hmmj1.png";
                }else if (list.get(0).equals("4")){
                    string="ydxs.png";
                    string1="ydxs1.png";
                }
                js_1=0;
                js_2=0;
                js_3=0;
                js_4=0;
                bj=1;
            }
            if (bj==1){
                ret=gamePublicFunction.mission(string,string1,2);
                if (ret == 0) {
                    list.remove(0);
                    bj=0;
                } else if (ret == 1) {
                    bj = 2;
                }
            }
            if (bj==2){
                result1 = commonFunction.FindManyPic(8,352,993,666, new String[]{"Team entry.png","Team entry1.png","Team entry2.png","Team entry3.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result1,0.8f,"组队进入,进入活动"));
                if (result1.sim>0.8f){
                    if (xjsl==2){
                        result = mFairy.findPic2(commonFunction.setImg("xjsljt.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙境试炼箭头"));
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }else if (xjsl==3){
                        result = mFairy.findPic2(commonFunction.setImg("xjsljt.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "仙境试炼箭头"));
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }
                    commonFunction.Compare(0.8f, result1, commonFunction.getImg());
                    js_3++;
                    if (js_3>5){
                        list.remove(0);
                        bj=0;
                    }
                }else {
                    js_3=0;
                }

                result = mFairy.findPic2(883,80,1054,648,commonFunction.setImg("Apply.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "申请"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Matching settings.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "匹配设置"));
                if (result.sim<0.8f){
                    result = mFairy.findPic2(commonFunction.setImg("Matching team.png"));
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "匹配队伍"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                }

                result = mFairy.findPic2(commonFunction.setImg("Matching settings.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "匹配设置"));
                if (result.sim>0.8f){
                    commonFunction.RndCompare(0.8f, 558, 614, result, "清空");
                    if (list.get(0).equals("1")){
                        commonFunction.RanSwipe(478,169,494,516,2,1000);
                        Thread.sleep(4000);
                        result = mFairy.findPic2(321,121,960,577,commonFunction.setImg("xjsl2.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.1f, "仙境试炼"));
                        if (xjsl==1){
                            commonFunction.RndCompare(0.8f, result.x-37, result.y+93, result, commonFunction.getImg());
                        }else if (xjsl==2){
                            commonFunction.RndCompare(0.8f, result.x-37, result.y+171, result, commonFunction.getImg());
                        }else if (xjsl==3){
                            commonFunction.RndCompare(0.8f, result.x-37, result.y+249, result, commonFunction.getImg());
                        }
                    }else if (list.get(0).equals("2")){
                        result = mFairy.findPic2(321,121,960,577,commonFunction.setImg("xjhj2.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "心剑幻境"));
                        commonFunction.RndCompare(0.8f, result.x-38, result.y+13, result, commonFunction.getImg());
                    }else if (list.get(0).equals("3")){
                        result = mFairy.findPic2(321,121,960,577,commonFunction.setImg("hmmj2.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幻冥梦境"));
                        commonFunction.RndCompare(0.8f, result.x-37, result.y+93, result, commonFunction.getImg());
                    }else if (list.get(0).equals("4")){
                        result = mFairy.findPic2(321,121,960,577,commonFunction.setImg("ydxs2.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "幽都悬赏"));
                        commonFunction.RndCompare(0.8f, result.x-38, result.y+13, result, commonFunction.getImg());
                    }
                    if (result.sim>0.8f){
                        commonFunction.RndCompare(0.8f, 837, 621, result, "开始匹配");
                    }else {
                       commonFunction.RanSwipe(478,169,494,546,2,2000);
                    }
                    js_4++;
                    if (js_4>5){
                        bj=0;
                    }
                }else {
                    js_4=0;
                }


                result = mFairy.findPic2(359,225,922,471,commonFunction.setImg("Follow up station.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "同意跟站"));
                commonFunction.RndCompare(0.8f, 758,502, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    bj=3;
                }

                result = mFairy.findPic2(commonFunction.setImg("Quit the team.png"));
                result1 = mFairy.findPic2(commonFunction.setImg("Captain.png"));
                if (result.sim>0.8f && result1.sim<0.8f){
                    LtLog.e(commonFunction.getLineInfo("是队员"));
                    bj=3;
                }

                result = mFairy.findPic2(357,227,921,473,commonFunction.setImg("Need team formation.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "需要组队"));
                commonFunction.RndCompare(0.8f, 527, 508, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("Captain.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "是队长需要退队"));
                commonFunction.RndCompare(0.8f, 437, 617, result, commonFunction.getImg());
                if (result.sim>0.8f){
                    bj=0;
                }


                result = mFairy.findPic2(commonFunction.setImg("Team member's agreement.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "队员同意"));
                commonFunction.RndCompare(0.8f, 640, 504, result, commonFunction.getImg());

                result = mFairy.findPic2(358,228,918,468,commonFunction.setImg("Mission accomplished.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "当前任务完成"));
                commonFunction.RndCompare(0.8f, 762, 506, result, commonFunction.getImg());

                result = commonFunction.FindManyPic(1036,84,1277,393, new String[]{"fb.png","fb1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
                if (result.sim>0.8f){
                    js_1=0;
                    bj=3;
                }else {
                    js_1++;
                    if (js_1>300){
                        list.remove(0);
                        bj=0;
                    }
                }

            }
            if (bj==3){
                result = mFairy.findPic2(358,228,918,468,commonFunction.setImg("Mission accomplished.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "当前任务完成"));
                commonFunction.RndCompare(0.8f, 762, 506, result, commonFunction.getImg());

                result = mFairy.findPic2(359,225,922,471,commonFunction.setImg("Follow up station.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "同意跟站"));
                commonFunction.RndCompare(0.8f, 758,502, result, commonFunction.getImg());

                result = commonFunction.FindManyPic(1036,84,1277,393, new String[]{"fb.png","fb1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "副本中"));
                if (result.sim>0.8f){
                    js_2=0;
                }else {
                    js_2++;
                    if (js_2>100){
                       gamePublicFunction.WithdrawTeam();
                        bj=0;
                    }
                }
            }
        }
    }
}
