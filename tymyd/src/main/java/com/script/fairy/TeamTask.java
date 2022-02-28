package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    FindResult result4;
    FindResult result5;
    GameUtil gameUtil;
    YxdUtil yxdUtil ;
    OtherGame otherGame;
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        yxdUtil=new YxdUtil(mFairy);
        otherGame=new OtherGame(mFairy);
    }


    /**
     * 普通话本
     * @throws Exception
     */
    public void textStory() throws Exception {
        new SingleTask(mFairy) {
            List<String> list = new ArrayList();
            @Override
            public void inOperation() throws Exception {
                result = mFairy.findPic(new String[]{"skip.png","skip2.png"});
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic("Loading.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }

                result = mFairy.findPic("exit team.png");
                mFairy.onTap(0.8f,result,723,505,733,513,"退出队伍",Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.8f,result,1139,89,1150,100,"任务关闭",Sleep);

                result = mFairy.findPic("shouji.png");
                mFairy.onTap(0.8f,result,"开箱子",5000);

                result = mFairy.findPic(644,76,1143,215,"Turn over the brand.png");
                mFairy.onTap(0.8f,result,"天涯明月刀",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

                result = mFairy.findPic("drop-down.png");
                mFairy.onTap(0.8f,result,"对话复原",Sleep);

                result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);
            }
            @Override
            public void create() throws Exception {
                if(AtFairyConfig.getOption("lss").equals("1")){
                    list.add("lss");
                }
                if(AtFairyConfig.getOption("cwkz").equals("1")){
                   list.add("cwkz");
                }
                if(AtFairyConfig.getOption("zyj").equals("1")){
                  list.add("zyj");
                }
                if(AtFairyConfig.getOption("xyqd").equals("1")){
                    list.add("xyqd");
                }
                if(AtFairyConfig.getOption("ythg").equals("1")){
                    list.add("ythg");
                }
            }
            public void content_0() throws Exception {
               // gameUtil.backcity();
                gameUtil.close();
                if(AtFairyConfig.getOption("kfpp").equals("1")) {
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                }
                if(AtFairyConfig.getOption("gdddd").equals("1")){
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(3);
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                }
                setTaskName(1);
            }
            public void content_1() throws Exception {
                LtLog.e("副本"+list.toString());
                if (list.size() == 0){
                    setTaskEnd();return;
                }

                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);

                result = mFairy.findPic(873,56,1273,706,"huaben.png");
                mFairy.onTap(0.8f,result,"话本",Sleep);

                result = mFairy.findPic("Ordinary.png");
                mFairy.onTap(0.8f,result,"普通话本",Sleep);

                if(list.get(0).equals("lss")){
                    result = mFairy.findPic("LongShouShan.png");
                    mFairy.onTap(0.8f,result,"龙首山",2000);

                }
                if(list.get(0).equals("cwkz")){
                    result = mFairy.findPic("CangWu.png");
                    mFairy.onTap(0.8f,result,"苍梧客栈",2000);


                }
                if(list.get(0).equals("zyj")){
                    result = mFairy.findPic("ZuiYue.png");
                    mFairy.onTap(0.8f,result,"醉月居",2000);

                }
                if(list.get(0).equals("xyqd")){
                    result = mFairy.findPic("XingYue.png");
                    mFairy.onTap(0.8f,result,"星月群岛",2000);

                }

                if(list.get(0).equals("ythg")){
                    result = mFairy.findPic("yetan.png");
                    mFairy.onTap(0.8f,result,"夜探皇宫",2000);

                }

                if(AtFairyConfig.getOption("gdddd").equals("1")){
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(3);
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result = mFairy.findPic("sure3.png");
                    mFairy.onTap(0.8f,result,"同意",2000);
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                    result = mFairy.findPic(1121, 499, 1250, 620, "Not automatically.png");
                    if (result.sim > 0.8f) {
                        if (timekeep(3, 300000, "等待超时")) {
                            setTaskEnd();return;
                        }
                    }

                }
                if(AtFairyConfig.getOption("kfpp").equals("1")) {
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result1 = mFairy.findPic(1123, 240, 1194, 315, "Not unlocked.png");
                   // result2 = mFairy.findPic(1123, 240, 1194, 315, "zero.png");
                    result2 = mFairy.findPic(623,544,686,624,"zero1.png");
                    result3 = mFairy.findPic( 713,545,782,622,"zero2.png");
                    result4 = mFairy.findPic( 802,547,876,622,"zero3.png");
                    LtLog.e("第一个"+result2.sim+"第二个"+result3.sim+"第三个"+result4.sim);
                    if (result1.sim > 0.8f || (result2.sim > 0.8f && result3.sim > 0.8f && result4.sim > 0.8f)) {
                        LtLog.e("此副本没解锁或者没有奖励次数了");
                        list.remove(0);
                        return;
                    }
                }else {
                    result = mFairy.findPic(1121, 499, 1250, 620, "Not automatically.png");
                    result1 = mFairy.findPic(1123, 240, 1194, 315, "Not unlocked.png");
                    result2 = mFairy.findPic(623,544,686,624,"zero1.png");
                    result3 = mFairy.findPic( 713,545,782,622,"zero2.png");
                    result4 = mFairy.findPic( 802,547,876,622,"zero3.png");
                    LtLog.e("第一个"+result2.sim+"第二个"+result3.sim+"第三个"+result4.sim);
                    if (result.sim > 0.8f || result1.sim > 0.8f || (result2.sim > 0.8f && result3.sim > 0.8f && result4.sim > 0.8f)) {
                        LtLog.e("此副本没开启自动或者没解锁或者没有奖励次数了");
                        list.remove(0);
                        return;
                    }
                }
                if(AtFairyConfig.getOption("kfpp").equals("1")) {
                    result = mFairy.findPic("Single person2.png");
                    mFairy.onTap(0.8f, result, 717,501,730,513,"跨服匹配", Sleep);
                }

                if (list.get(0).equals("lss")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("LongShouShan2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }
                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("LongShouShan2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }

                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);
                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("LongShouShan2.png");
                        if (result.sim > 0.8f) {
                           setTaskName(2);
                        }*/
                    }

                }
                if (list.get(0).equals("cwkz")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("CangWu2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("CangWu2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);
                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                       /* result = mFairy.findPic("CangWu2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }

                }
                if (list.get(0).equals("zyj")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("ZuiYue2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("ZuiYue2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);
                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                       /* result = mFairy.findPic("ZuiYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }

                }
                if (list.get(0).equals("xyqd")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);

                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }


                }

                if (list.get(0).equals("ythg")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("yetan2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("yetan2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);

                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }


                }
                result = mFairy.findPic("again.png");
                mFairy.onTap(0.8f,result,719,501,729,511,"从新",Sleep);

                result = mFairy.findPic("wait for.png");
                mFairy.onTap(0.8f,result,"继续等待",Sleep);

                result = mFairy.findPic("begn pipei.png");
                mFairy.onTap(0.8f,result,"开始匹配",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

                if (timekeep(3,600000,"重新匹配")){

                    result = mFairy.findPic("Matching2.png");
                    mFairy.onTap(0.8f,result,"匹配中",2000);

                    result = mFairy.findPic("Exit p.png");
                    mFairy.onTap(0.8f,result,"退出匹配",2000);

                    timekeepInit("重新匹配");
                }

                result = mFairy.findPic("Exit p.png");
                mFairy.onTap(0.8f,result,"退出匹配",2000);

            }
            public void content_2() throws Exception {
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                timekeepInit("等待超时");
                LtLog.e("**********"+datatime);
                if (datatime >=35){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    mFairy.onTap(35,158,40,166,"打开任务",Sleep);
                    //ao =true;
                }

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic("sure3.png");
                mFairy.onTap(0.8f,result,"同意",2000);

                result = mFairy.findPic("follow sure.png");
                mFairy.onTap(0.8f,result,"跟随确认",2000);

                result = mFairy.findPic("follow.png");
                mFairy.onTap(0.8f,result,181,375,187,380,"跟随队长",Sleep);

                result = mFairy.findPic("follow2.png");
                if(result.sim >= 0.75f){

                }else {
                    result = mFairy.findPic(49,102,221,330,"Script.png");
                    mFairy.onTap(0.8f, result, "话本", 5000);
                }

                result = mFairy.findPic("clearance.png");
                mFairy.onTap(0.8f, result, "通关", 2000);

                result = mFairy.findPic("Accept Resurrection.png");
                mFairy.onTap(0.8f,result,723,501,732,511,"接受复活",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

               /* result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);*/

                result1 = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result1.sim < 0.8f){
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.85f,result,"自动",8000);
                }
                if (result1.sim < 0.8f && datatime >=10 ){
                    setTaskName(0);
                    return;
                }
                result2 = mFairy.findPic("renwu.png");
                if (result2.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,29,154,37,160,"任务栏",Sleep);
                }
               /* result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);*/



            }
            public void content_3() throws Exception {
                int ss = dateSS();
                if (ss == 50){
                    result = mFairy.findPic("call together3.png");
                    mFairy.onTap(0.7f, result, "拉跟随", 2000);
                    mFairy.onTap(0.7f, result, 736,502,749,507,"拉跟随确认", 2000);
                }
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=35){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    mFairy.onTap(35,158,40,166,"打开任务",Sleep);
                    //ao =true;
                }

             /*   result = mFairy.findPic("duties.png");
                if (result.sim > 0.75f){

                }else {
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }*/

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic(49,102,221,330,"Script.png");
                mFairy.onTap(0.8f, result, "话本", 5000);

                result = mFairy.findPic("clearance.png");
                mFairy.onTap(0.8f, result, "通关", 2000);

                result = mFairy.findPic("Accept Resurrection.png");
                mFairy.onTap(0.8f,result,723,501,732,511,"接受复活",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("Villa master.png");
                if (result.sim > 0.8f && datatime >= 30){
                    result = mFairy.findPic("map.png");
                    mFairy.onTap(0.8f,result,"切换地图",2000);
                    mFairy.onTap(0.8f,result,1174,68,1181,76,"地图",2000);
                    mFairy.onTap(0.8f,result,416,297,420,302,"过去",2000);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1174,68,1181,76,"地图",2000);
                        mFairy.onTap(416,297,420,302,"过去",2000);
                    }

                }

                result1 = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result1.sim < 0.8f){
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.85f,result,"自动",8000);
                }
                if (result1.sim < 0.8f && datatime >=10 ){
                    setTaskName(0);
                    return;
                }
                result2 = mFairy.findPic("renwu.png");
                if (result2.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,29,154,37,160,"任务栏",Sleep);
                }


               /* result = mFairy.findPic("drop-down.png");
                mFairy.onTap(0.8f,result,"对话复原",Sleep);*/

            }


        }.taskContent(mFairy, "普通话本");
    }


    /**
     * 困难话本
     * @throws Exception
     */
    public void knhb() throws Exception {
        new SingleTask(mFairy) {
            List<String> list = new ArrayList();
            @Override
            public void inOperation() throws Exception {
                result = mFairy.findPic(new String[]{"skip.png","skip2.png"});
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic("Loading.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    mFairy.initMatTime();
                    err = 0;
                    picCountMapS.clear();
                    picCountMap.clear();
                }

                result = mFairy.findPic("exit team.png");
                mFairy.onTap(0.8f,result,723,505,733,513,"退出队伍",Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.8f,result,1139,89,1150,100,"任务关闭",Sleep);

                result = mFairy.findPic("shouji.png");
                mFairy.onTap(0.8f,result,"开箱子",5000);

                result = mFairy.findPic(644,76,1143,215,"Turn over the brand.png");
                mFairy.onTap(0.8f,result,"天涯明月刀",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

                result = mFairy.findPic("drop-down.png");
                mFairy.onTap(0.8f,result,"对话复原",Sleep);

                result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);
            }
            @Override
            public void create() throws Exception {
                if(AtFairyConfig.getOption("ptwxk").equals("1")){
                    list.add("ptwxk");
                }
                if(AtFairyConfig.getOption("knwxk").equals("1")){
                    list.add("knwxk");
                }
                if(AtFairyConfig.getOption("ptctg").equals("1")){
                    list.add("ptctg");
                }
                if(AtFairyConfig.getOption("knctg").equals("1")){
                    list.add("knctg");
                }
                if(AtFairyConfig.getOption("pthbh").equals("1")){
                    list.add("pthbh");
                }
                if(AtFairyConfig.getOption("knhbh").equals("1")){
                    list.add("knhbh");
                }
            }
            public void content_0() throws Exception {
                // gameUtil.backcity();
                gameUtil.close();
                if(AtFairyConfig.getOption("kfpp").equals("1")) {
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                }
                if(AtFairyConfig.getOption("gdddd").equals("1")){
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(3);
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                }
                setTaskName(1);
            }
            public void content_1() throws Exception {
                LtLog.e("副本"+list.toString());
                if (list.size() == 0){
                    setTaskEnd();return;
                }

                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);

                result = mFairy.findPic(873,56,1273,706,"huaben.png");
                mFairy.onTap(0.8f,result,"话本",Sleep);

                result = mFairy.findPic(971,389,1169,484,"Ordinary.png");
                mFairy.onTap(0.8f,result,"困难话本",Sleep);

                if(list.get(0).equals("ptwxk")){
                    result = mFairy.findPic("putong3.png");
                    mFairy.onTap(0.8f,result,"普通",2000);

                    result = mFairy.findPic("ptwxk.png");
                    mFairy.onTap(0.8f,result,"普通万雪窟",2000);

                }
                if(list.get(0).equals("knwxk")){
                    result = mFairy.findPic("kunnan.png");
                    mFairy.onTap(0.8f,result,"困难",2000);

                    result = mFairy.findPic("knwxk.png");
                    mFairy.onTap(0.8f,result,"困难万雪窟",2000);


                }
                if(list.get(0).equals("ptctg")){
                    result = mFairy.findPic("putong3.png");
                    mFairy.onTap(0.8f,result,"普通",2000);
                    result = mFairy.findPic("ptctg.png");
                    mFairy.onTap(0.8f,result,"普通朝天宫",2000);

                }
                if(list.get(0).equals("knctg")){
                    result = mFairy.findPic("kunnan.png");
                    mFairy.onTap(0.8f,result,"困难",2000);
                    result = mFairy.findPic("knctg.png");
                    mFairy.onTap(0.8f,result,"困难朝天宫",2000);

                }

                if(list.get(0).equals("pthbh")){
                    result = mFairy.findPic("putong3.png");
                    mFairy.onTap(0.8f,result,"普通",2000);
                    result = mFairy.findPic("pthbh.png");
                    mFairy.onTap(0.8f,result,"普通会八荒",2000);

                }
                if(list.get(0).equals("knhbh")){
                    result = mFairy.findPic("kunnan.png");
                    mFairy.onTap(0.8f,result,"困难",2000);
                    result = mFairy.findPic("knhbh.png");
                    mFairy.onTap(0.8f,result,"困难会八荒",2000);

                }

                if(AtFairyConfig.getOption("gdddd").equals("1")){
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(3);
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result = mFairy.findPic("sure3.png");
                    mFairy.onTap(0.8f,result,"同意",2000);
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                    result = mFairy.findPic(1121, 499, 1250, 620, "Not automatically.png");
                    if (result.sim > 0.8f) {
                        if (timekeep(3, 300000, "等待超时")) {
                            setTaskEnd();return;
                        }
                    }

                }
                if(AtFairyConfig.getOption("kfpp").equals("1")) {
                    result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 694, 571, 703, 579, "开启自动", Sleep);
                        setTaskName(2);
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result1 = mFairy.findPic(1139,198,1229,261, "Not unlocked.png");
                    result2 = mFairy.findPic("jibai.png");
                    if (result1.sim > 0.8f || result2.sim > 0.8f ) {
                        LtLog.e("此副本没解锁或者没有奖励次数了");
                        list.remove(0);
                        return;
                    }
                }else {
                    result = mFairy.findPic(1188,529,1257,604, "Not automatically.png");
                    result1 = mFairy.findPic(1139,198,1229,261, "Not unlocked.png");
                    result2 = mFairy.findPic("jibai.png");
                    if (result.sim > 0.8f || result1.sim > 0.8f || result2.sim > 0.8f ) {
                        LtLog.e("此副本没开启自动或者没解锁或者没有奖励次数了");
                        list.remove(0);
                        return;
                    }
                }
                if(AtFairyConfig.getOption("kfpp").equals("1")) {
                    result = mFairy.findPic("Single person2.png");
                    mFairy.onTap(0.8f, result, 717,501,730,513,"跨服匹配", Sleep);
                }

                if (list.get(0).equals("ptwxk")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("ptwxk2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit2.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }
                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("ptwxk2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }

                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);
                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("LongShouShan2.png");
                        if (result.sim > 0.8f) {
                           setTaskName(2);
                        }*/
                    }

                }
                if (list.get(0).equals("knwxk")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("knwxk2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit2.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("knwxk2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb2.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);
                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                       /* result = mFairy.findPic("CangWu2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }

                }
                if (list.get(0).equals("ptctg")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("ptctg2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit2.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("ptctg2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb2.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);
                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                       /* result = mFairy.findPic("ZuiYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }

                }
                if (list.get(0).equals("knctg")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("knctg2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit2.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("knctg2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb2.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);

                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }


                }

                if (list.get(0).equals("pthbh")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("pthbh2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit2.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("pthbh2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb2.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);

                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }

                }

                if (list.get(0).equals("knhbh")) {
                    if(AtFairyConfig.getOption("kfpp").equals("1")) {
                        result = mFairy.findPic("knhbh2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("Cross suit2.png");
                            mFairy.onTap(0.8f, result, "跨服匹配", Sleep);

                            result = mFairy.findPic("man.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(2);return;
                            }
                        }
                    }

                    if(AtFairyConfig.getOption("gdddd").equals("1")) {
                        result = mFairy.findPic("knhbh2.png");
                        if (result.sim > 0.8f) {
                            result = mFairy.findPic("join hb2.png");
                            mFairy.onTap(0.8f,result,"进入话本",2000);

                            result = mFairy.findPic("benzhong.png");
                            if (result.sim > 0.8f){
                                gameUtil.close();
                                setTaskName(3);return;
                            }
                            result = mFairy.findPic("Confirm to join.png");
                            mFairy.onTap(0.8f,result,"确定加入",2000);

                            result = mFairy.findPic("sure3.png");
                            mFairy.onTap(0.8f,result,"同意",2000);

                        }
                    }
                    if(AtFairyConfig.getOption("gddgd").equals("1")) {
                      /*  result = mFairy.findPic("XingYue2.png");
                        if (result.sim > 0.8f) {
                            setTaskName(2);
                        }*/
                    }


                }
                result = mFairy.findPic("again.png");
                mFairy.onTap(0.8f,result,719,501,729,511,"从新",Sleep);

                result = mFairy.findPic("wait for.png");
                mFairy.onTap(0.8f,result,"继续等待",Sleep);

                result = mFairy.findPic("begn pipei.png");
                mFairy.onTap(0.8f,result,"开始匹配",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

                if (timekeep(3,600000,"重新匹配")){

                    result = mFairy.findPic("Matching2.png");
                    mFairy.onTap(0.8f,result,"匹配中",2000);

                    result = mFairy.findPic("Exit p.png");
                    mFairy.onTap(0.8f,result,"退出匹配",2000);

                    timekeepInit("重新匹配");
                }

                result = mFairy.findPic("Exit p.png");
                mFairy.onTap(0.8f,result,"退出匹配",2000);

            }
            public void content_2() throws Exception {
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                timekeepInit("等待超时");
                LtLog.e("**********"+datatime);
                if (datatime >=35){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    mFairy.onTap(35,158,40,166,"打开任务",Sleep);
                    //ao =true;
                }
                result = mFairy.findPic(332, 4, 434, 86, "Plane.png");
                if (result.sim > 0.8f) {
                  mFairy.initMatTime();
                }
                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic("sure3.png");
                mFairy.onTap(0.8f,result,"同意",2000);
                if (result.sim > 0.8f){
                    mFairy.initMatTime();
                }
                result = mFairy.findPic("follow sure.png");
                mFairy.onTap(0.8f,result,"跟随确认",2000);

                result = mFairy.findPic("follow.png");
                mFairy.onTap(0.8f,result,181,375,187,380,"跟随队长",Sleep);

                result = mFairy.findPic("follow2.png");
                if(result.sim >= 0.75f){

                }else {
                    result = mFairy.findPic(49,102,221,330,"Script.png");
                    mFairy.onTap(0.8f, result, "话本", 5000);
                }

                result = mFairy.findPic("clearance.png");
                mFairy.onTap(0.8f, result, "通关", 2000);

                result = mFairy.findPic("Accept Resurrection.png");
                mFairy.onTap(0.8f,result,723,501,732,511,"接受复活",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);
                if (result.sim > 0.8f){
                    mFairy.initMatTime();
                }
                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);
                if (result.sim > 0.8f){
                    mFairy.initMatTime();
                }
               /* result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);*/

                result1 = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result1.sim < 0.8f){
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.85f,result,"自动",8000);
                }
                if (result1.sim < 0.8f && datatime >=10 ){
                    setTaskName(0);
                    return;
                }
                result2 = mFairy.findPic("renwu.png");
                if (result2.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,29,154,37,160,"任务栏",Sleep);
                }
               /* result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);*/



            }
            public void content_3() throws Exception {
                int ss = dateSS();
                if (ss == 50){
                    result = mFairy.findPic("call together3.png");
                    mFairy.onTap(0.7f, result, "拉跟随", 2000);
                    mFairy.onTap(0.7f, result, 736,502,749,507,"拉跟随确认", 2000);
                }
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=35){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    mFairy.onTap(35,158,40,166,"打开任务",Sleep);
                    //ao =true;
                }

             /*   result = mFairy.findPic("duties.png");
                if (result.sim > 0.75f){

                }else {
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }*/

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic(49,102,221,330,"Script.png");
                mFairy.onTap(0.8f, result, "话本", 5000);

                result = mFairy.findPic("clearance.png");
                mFairy.onTap(0.8f, result, "通关", 2000);

                result = mFairy.findPic("Accept Resurrection.png");
                mFairy.onTap(0.8f,result,723,501,732,511,"接受复活",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("Villa master.png");
                if (result.sim > 0.8f && datatime >= 30){
                    result = mFairy.findPic("map.png");
                    mFairy.onTap(0.8f,result,"切换地图",2000);
                    mFairy.onTap(0.8f,result,1174,68,1181,76,"地图",2000);
                    mFairy.onTap(0.8f,result,416,297,420,302,"过去",2000);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1174,68,1181,76,"地图",2000);
                        mFairy.onTap(416,297,420,302,"过去",2000);
                    }

                }

                result1 = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result1.sim < 0.8f){
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.85f,result,"自动",8000);
                }
                if (result1.sim < 0.8f && datatime >=10 ){
                    setTaskName(0);
                    return;
                }
                result2 = mFairy.findPic("renwu.png");
                if (result2.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,29,154,37,160,"任务栏",Sleep);
                }


               /* result = mFairy.findPic("drop-down.png");
                mFairy.onTap(0.8f,result,"对话复原",Sleep);*/

            }


        }.taskContent(mFairy, "困难话本");
    }
    /**
     * 随机话本
     * @throws Exception
     */
    public void textStorySJ() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                //gameUtil.backcity();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);

                result = mFairy.findPic(873,56,1273,706,"huaben.png");
                mFairy.onTap(0.8f,result,"话本",Sleep);

                result = mFairy.findPic("random.png");
                mFairy.onTap(0.8f,result,result.x-120,result.y+120,result.x-110,result.y+130,"随机话本",2000);


                result1 = mFairy.findPic("open.png");
               // result2 = mFairy.findPic(1132, 257, 1180, 289, "zero.png");
                result2 = mFairy.findPic( 619,539,678,584,"zero1.png");
                result3 = mFairy.findPic( 719,542,774,581,"zero2.png");
                result4 = mFairy.findPic( 816,543,865,581,"zero3.png");
                LtLog.e("第一个"+result2.sim+"第二个"+result3.sim+"第三个"+result4.sim);
                if (result1.sim > 0.8f ||(result2.sim > 0.8f && result3.sim > 0.8f && result4.sim > 0.8f)) {
                    LtLog.e("此副本没开启自动或者没解锁或者没有奖励次数了 结束任务");
                    setTaskEnd();
                    return;
                }

                if(AtFairyConfig.getOption("kfpp").equals("1")){
                    result = mFairy.findPic("Cross suit.png");
                    mFairy.onTap(0.8f,result,"跨服匹配",Sleep);

                    result = mFairy.findPic("wait for.png");
                    mFairy.onTap(0.8f,result,"继续等待",Sleep);

                    result = mFairy.findPic("begn pipei.png");
                    mFairy.onTap(0.8f,result,"开始匹配",Sleep);

                    result = mFairy.findPic("man.png");
                    if (result.sim > 0.8f){
                        gameUtil.close();
                        setTaskName(2);return;
                    }
                    result = mFairy.findPic(332,4,434,86,"Plane.png");
                    if (result.sim > 0.8f){
                        mFairy.onTap(0.8f,result,694,571,703,579,"开启自动",Sleep);
                        setTaskName(2);return;
                    }
                }

                if(AtFairyConfig.getOption("gdddd").equals("1")){
                    result = mFairy.findPic("join hb.png");
                    mFairy.onTap(0.8f,result,"进入话本",Sleep);

                    result = mFairy.findPic("Confirm to join.png");
                    mFairy.onTap(0.8f,result,"确定加入",Sleep);

                    result = mFairy.findPic("benzhong.png");
                    if (result.sim > 0.8f){
                        gameUtil.close();
                        setTaskName(3);return;
                    }
                    result = mFairy.findPic("sure3.png");
                    mFairy.onTap(0.8f,result,"同意",Sleep);

                    result = mFairy.findPic(332,4,434,86,"Plane.png");
                    if (result.sim > 0.8f){
                        mFairy.onTap(0.8f,result,694,571,703,579,"开启自动",Sleep);
                        setTaskName(3);return;
                    }
                }
                if(AtFairyConfig.getOption("gddgd").equals("1")){
                    result = mFairy.findPic("sure3.png");
                    mFairy.onTap(0.8f,result,"同意",Sleep);

                    result = mFairy.findPic(332,4,434,86,"Plane.png");
                    if (result.sim > 0.8f){
                        mFairy.onTap(0.8f,result,694,571,703,579,"开启自动",Sleep);
                        setTaskName(2);return;
                    }
                    result = mFairy.findPic(1121, 499, 1250, 620, "Not automatically.png");
                    if (result.sim > 0.8f) {
                        if (timekeep(3, 300000, "等待超时")) {
                            setTaskEnd();return;
                        }
                    }
                }

                result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);


            }
            public void content_2() throws Exception {
                result = mFairy.findPic("sure3.png");
                mFairy.onTap(0.8f,result,"同意",Sleep);

                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=35){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    //ao =true;
                }

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.8f,result,1139,89,1150,100,"任务关闭",Sleep);

                result = mFairy.findPic("follow.png");
                mFairy.onTap(0.8f,result,181,375,187,380,"跟随队长",Sleep);

                result = mFairy.findPic("follow2.png");
                if(result.sim > 0.8f){

                }else {
                    result = mFairy.findPic(49,102,221,330,"Script.png");
                    mFairy.onTap(0.8f, result, "话本", 5000);
                }

                result = mFairy.findPic("Accept Resurrection.png");
                mFairy.onTap(0.8f,result,723,501,732,511,"接受复活",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic(644,76,1143,215,"Turn over the brand.png");
                mFairy.onTap(0.8f,result,"天涯明月刀",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

               /* result = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result.sim < 0.8f && datatime >30){
                   setTaskName(0);
                    return;
                }*/
                result1 = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result1.sim < 0.8f){
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.85f,result,"自动",8000);
                }
                if (result1.sim < 0.8f && datatime >=10 ){
                    setTaskName(0);
                    return;
                }
                result2 = mFairy.findPic("renwu.png");
                if (result2.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,29,154,37,160,"任务栏",Sleep);
                }
                result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);

            }
            public void content_3() throws Exception {
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("**********"+datatime);
                if (datatime >=35){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    //ao =true;
                }
              /*  result = mFairy.findPic("duties.png");
                if (result.sim > 0.75f){

                }else {
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }*/

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.8f,result,1139,89,1150,100,"任务关闭",Sleep);

                result = mFairy.findPic(49,102,221,330,"Script.png");
                mFairy.onTap(0.8f, result, "话本", 5000);

                result = mFairy.findPic("Accept Resurrection.png");
                mFairy.onTap(0.8f,result,723,501,732,511,"接受复活",Sleep);

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic(644,76,1143,215,"Turn over the brand.png");
                mFairy.onTap(0.8f,result,"天涯明月刀",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

               /* result = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result.sim < 0.8f && datatime >30){
                    setTaskName(0);
                    return;
                }*/
                result = mFairy.findPic("Resurrect nearby.png");
                mFairy.onTap(0.8f,result,"就近复活",Sleep);

                result1 = mFairy.findPic(332,4,434,86,"Plane.png");
                if (result1.sim < 0.8f){
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.85f,result,"自动",8000);
                }
                if (result1.sim < 0.8f && datatime >=10 ){
                    setTaskName(0);
                    return;
                }
                result2 = mFairy.findPic("renwu.png");
                if (result2.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,29,154,37,160,"任务栏",Sleep);
                }
            }

        }.taskContent(mFairy, "随机话本");
    }
    /**
     * 捕快
     * @throws Exception
     */
    public void captor() throws Exception {
        new SingleTask(mFairy) {
            boolean ao = true;
            int jncs = 0;
            @Override
            public void create() throws Exception {
                if(strSplit(AtFairyConfig.getOption("opcount2")).choice==1){
                    jncs = strSplit(AtFairyConfig.getOption("opcount2")).count;
                }
                else {
                    setTaskEnd();return;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                gameUtil.createTeam("jina.png",0);
                result = mFairy.findPic("join.png");
                mFairy.onTap(0.8f,result,"进入玩法",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }

            }
            public void content_2() throws Exception {
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                LtLog.e("缉拿次数"+jncs);
                if (jncs <= 0){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,1249,15,1258,27,"菜单关闭",Sleep);

                result = mFairy.findPic(new String[]{"Adjudicate.png","identity3.png"});
                mFairy.onTap(0.8f,result,1246,17,1251,23,"身份关闭",Sleep);

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.8f,result,1139,89,1150,100,"任务关闭",Sleep);

                result2 = mFairy.findPic(new String[]{"Plane.png","Plane2.png"});
                if (result2.sim >= 0.8f && ao){
                    mFairy.initMatTime();
                    mFairy.onTap(692,574,706,582,"开自动",Sleep);
                    ao =false;
                }

                result = mFairy.findPic(49,102,221,330,"left jina.png");
                mFairy.onTap(0.8f,result,"左侧缉拿",4000);
                if (result.sim > 0.8f && ao == false){

                    mFairy.onTap(692,574,706,582,"关自动",Sleep);
                    ao =true;
                }
                if (datatime >=30 && result.sim < 0.8f && result2.sim <0.8f ){
                    setTaskName(3);return;

                }

                result = mFairy.findPic("follow2.png");
                if(result.sim > 0.8f){

                }else {
                    result = mFairy.findPic(49,102,221,330,"Script.png");
                    mFairy.onTap(0.8f, result, "话本", 5000);
                }

                result = mFairy.findPic(407,590,1177,707,"next step.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic("close.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("ya.png");
                mFairy.onTap(0.8f,result,"涯",Sleep);

                result = mFairy.findPic("weimian.png");
                mFairy.onTap(0.8f,result,624,504,638,517,"进入队友位面",Sleep);

                result = mFairy.findPic("record.png");
                mFairy.onTap(0.8f,result,1121,88,1132,102,"记录关闭",Sleep);

                result = mFairy.findPic("Next round.png");
                if (result.sim > 0.8f ){
                    --jncs;
                }
                if (result.sim > 0.8f && jncs > 0){
                    mFairy.onTap(0.8f,result,721,504,736,515,"下一轮",Sleep);
                }

            }
            public void content_3() throws Exception {
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.7f, result, "菜单", Sleep);

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,"身份",Sleep);

                result = mFairy.findPic("identity2.png");
                mFairy.onTap(0.8f,result,"身份百业",Sleep);

                result = mFairy.findPic("Captor.png");
                mFairy.onTap(0.8f,result,"捕快",2000);

                result = mFairy.findPic(1042,441,1203,523,new String[]{"Tshui.png","qianwang2.png"});
                mFairy.onTap(0.8f,result,"参与",Sleep);

                result = mFairy.findPic(new  String[]{"lingqu jina.png","lingqu jina3.png"});
                mFairy.onTap(0.8f,result,"领取缉拿",Sleep);

                result = mFairy.findPic(239,316,1095,512,"distance.png");
                if (result.sim > 0.8f){
                    LtLog.e("有人距离不够发起召集");
                    mFairy.onTap(344,596,355,607,"组队平台",2000);
                    mFairy.onTap(938,87,960,99,"发起跟随",2000);
                    mFairy.onTap(728,504,738,516,"确定发起",2000);
                    mFairy.onTap(1242,21,1252,32,"叉",2000);
                }

                result1 = mFairy.findPic("lingqu jina2.png");
                mFairy.onTap(0.8f,result1,"领取缉拿2",Sleep);
                if (result.sim > 0.8f ){
                    setTaskName(2);return;
                }
                result = mFairy.findPic("left jina.png");
                if (result.sim > 0.8f ){
                    setTaskName(2);return;
                }
                result = mFairy.findPic(new String[]{"vitality2.png","not huoli.png"});
                if (result.sim > 0.8f){
                    LtLog.e("没有活力了");
                    setTaskEnd();return;
                }


                result = mFairy.findPic("vacancy.png");
                if (result.sim > 0.8f){
                    LtLog.e("人不够了");
                   setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "捕快");
    }

    /**
     * 押镖
     * @throws Exception
     */
    public void escort() throws Exception {
        new SingleTask(mFairy) {
            boolean gg = false;
            int ybcs = 0;
            @Override
            public void create() throws Exception {

                if (!AtFairyConfig.getOption("ybcs").equals("")) {
                    ybcs = strSplit(AtFairyConfig.getOption("ybcs")).count;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if(AtFairyConfig.getOption("dr").equals("1")){
                    result = mFairy.findPic("left team.png");
                    mFairy.onTap(0.8f, result, "左侧组队栏",2000);

                    result = mFairy.findPic("left team2.png");
                    mFairy.onTap(0.8f, result, "左侧组队栏",2000);

                    result = mFairy.findPic("Withdraw.png");
                    mFairy.onTap(0.7f,result,"退队",3000);
                    mFairy.onTap(0.7f,result,704,507,724,515,"确认退队",Sleep);

                    result = mFairy.findPic(560,610,1121,711,"tuichu.png");
                    mFairy.onTap(0.7f,result,"退队",3000);
                    mFairy.onTap(0.7f,result,717,499,729,511,"确认退队",Sleep);

                    setTaskName(2);return;
                }
                if(AtFairyConfig.getOption("zd").equals("1")){
                    if(AtFairyConfig.getOption("aqb").equals("1")){
                        gameUtil.createTeam("anquan.png",0);
                    }
                    if(AtFairyConfig.getOption("wwb").equals("1")){
                        gameUtil.createTeam("weiwu.png",0);

                    }
                    mFairy.sleep(2000);
                }

                result = mFairy.findPic("join.png");
                mFairy.onTap(0.8f,result,"进入玩法",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }

            }
            public void content_2() throws Exception {
                LtLog.e("押镖次数"+ybcs);
                if (ybcs <= 0){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.7f,result,"显示任务",Sleep);

                result1 = mFairy.findPic("social contact.png");
                result = mFairy.findPic("duties.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("JangHu.png");
                    mFairy.onTap(0.7f,result,"江湖栏",Sleep);
                }else if (result1.sim > 0.8f){
                    mFairy.onTap(31,157,36,165,"任务栏",Sleep);
                }

                result = mFairy.findPic("task.png");
                mFairy.onTap(0.7f,result,1140,90,1152,100,"关闭",Sleep);


                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.7f, result, "菜单", Sleep);

                result = mFairy.findPic(873,56,1273,706,"identity.png");
                mFairy.onTap(0.8f,result,"身份",Sleep);

                result = mFairy.findPic("identity2.png");
                mFairy.onTap(0.8f,result,"身份百业",Sleep);

                result = mFairy.findPic("biao.png");
                mFairy.onTap(0.8f,result,"镖师",2000);

                if (result.sim > 0.8f) {
                    result = mFairy.findPic(1046, 566, 1213, 658, "qianwang2.png");
                    if (result.sim > 0.8f) {
                        LtLog.e("没有活力了");
                        setTaskEnd();
                        return;
                    }
                }
                if (AtFairyConfig.getOption("wwb").equals("1")) {
                    result = mFairy.findPic(1042,431,1211,525, "qianwang2.png");
                    if (result.sim > 0.8f) {
                        LtLog.e("没有道具了");
                        setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic(1035,421,1203,662,"Tshui.png");
                mFairy.onTap(0.8f,result,"参与",Sleep);

                result = mFairy.findPic("yabiao.png");
                mFairy.onTap(0.8f,result,"押镖",Sleep);

                result = mFairy.findPic("biaolei.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("aqb").equals("1")) {
                        mFairy.onTap(0.8f,result,365, 287, 378, 297, "安全镖", 2000);
                    }
                    if (AtFairyConfig.getOption("wwb").equals("1")) {
                        mFairy.onTap(0.8f,result,880, 281, 893, 290, "威武镖", 2000);
                    }

                    mFairy.onTap(0.8f,result,829,587,841,599, "开始押镖", 2000);
                }
                if(AtFairyConfig.getOption("zd").equals("1")){
                    result = mFairy.findPic(239,316,1095,512,"distance.png");
                    if (result.sim > 0.8f){
                        LtLog.e("有人距离不够发起召集");
                        mFairy.onTap(344,596,355,607,"组队平台",2000);
                        mFairy.onTap(938,87,960,99,"发起跟随",2000);
                        mFairy.onTap(728,504,738,516,"确定发起",2000);
                        mFairy.onTap(1242,21,1252,32,"叉",2000);
                    }
                }
                result = mFairy.findPic(616,577,895,662,"beginbiao.png");
                mFairy.onTap(0.8f,result,"领取开始",2000);
                if (result.sim > 0.8f){
                    ybcs--;
                    gg=false;
                    gameUtil.close();
                    setTaskName(3);return;
                }
                result = mFairy.findPic(new String[]{"vitality2.png","not huoli.png"});
                if (result.sim > 0.8f){
                    LtLog.e("没有活力了");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Insufficient props.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,543,475,558,486,"暂不前往",Sleep);
                    LtLog.e("道具不足");
                    setTaskEnd();return;
                }
            }
            public void content_3() throws Exception {
                long  datetime = mFairy.mMatTime(1189,104,16,6,0.9f);
                result = mFairy.findPic("Rush transportation.png");
                mFairy.onTap(0.7f, result, "抢运", Sleep);

                result1 = mFairy.findPic(433,2,561,29,new String[]{"Captor2.png","Captor3.png"});
                if (result1.sim > 0.8f){
                    mFairy.onTap(0.8f, result1, 692, 571, 699, 581, "开启自动", 12000);
                    mFairy.onTap(0.8f, result1, 692, 571, 699, 581, "关闭自动", 1000);
                }

                result = mFairy.findPic("zhongshang.png");
                if (result.sim >0.8f){
                    gg=true;
                }
                if (gg){
                    result = mFairy.findPic("rush to repair.png");
                    mFairy.onTap(0.8f,result,"抢修",Sleep);
                }

                result = mFairy.findPic("closebiao.png");
                mFairy.onTap(0.8f,result,"关闭守镖成功",Sleep);

                result = mFairy.findPic(49,102,221,330,"shenfen2.png");
                mFairy.onTap(0.8f,result,"左侧押镖",Sleep);

                if (result1.sim < 0.8f && result.sim <0.8f && datetime >= 15){
                    setTaskName(0);return;
                }

                result = mFairy.findPic(new String[]{"vitality2.png","not huoli.png"});
                if (result.sim > 0.8f){
                    LtLog.e("没有活力了");
                    setTaskEnd();return;
                }

            }

        }.taskContent(mFairy, "押镖");
    }
}
