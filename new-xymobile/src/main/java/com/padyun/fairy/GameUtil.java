package com.padyun.fairy;

import android.graphics.Bitmap;
import android.util.Base64;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;
import com.script.framework.TaskContent;
import com.script.framework.AtFairyImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        Sleep=1500;
        SleepWhile=1000;
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("smOverGraph.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("In transmission.png");
        if (result.sim > 0.7f) {
            LtLog.e(mFairy.getLineInfo("传送中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("road.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "complete.png");
        mFairy.onTap(0.8f, result, "完成", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "accept.png");
        mFairy.onTap(0.8f, result, "接受", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }

    int tastState = 0;
    public int mission(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;

            public void content_0() throws Exception {
                if (findtask >= 3) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, "日常", Sleep);

                result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(2000);
                    result = mFairy.findPic("jlred.png");
                    mFairy.onTap(0.8f, result, 378,100,409,111,"领取活跃奖励栏", Sleep);
                    if (result.sim>0.8f){
                        mFairy.onTap(881,288,895,304,"领取活跃奖励1", Sleep);
                        for (int i=0;i<5;i++){
                            result =mFairy.findPic(340,223,927,624,"smSure.png");
                            mFairy.onTap(0.8f,result,"奖励确认",Sleep);
                            result = mFairy.findPic(799,184,1179,659,"jlred1.png");
                            mFairy.onTap(0.8f, result, result.x-30,result.y+20,result.x-29,result.y+21,"领取活跃奖励2", Sleep);
                            if (result.sim>0.8f){
                                i=0;
                            }
                        }
                    }
                    mFairy.condit();
                    result = mFairy.findPic(220, 152, 844, 591, str);
                    if (result.sim > 0.8f) {
                    } else {
                        if (option == 1) {
                            mFairy.onTap(528, 99, 563, 113, "日常活动", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(691, 100, 722, 114, "限时活动", Sleep);
                        }
                        if (option == 3) {
                            mFairy.onTap(1005, 96, 1044, 117, "周历", Sleep);
                            findtask++;
                            setTaskName(3);
                            return;
                        }
                        if (option == 4) {
                            mFairy.onTap(375, 101, 410, 117, "活跃奖励", Sleep);
                        }
                    }
                    findtask++;
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(12, 0)) return;
                result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常界面"));
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(220, 152, 844, 591, str);
                    LtLog.e("找到了任务=" + str + "," + result1.sim);
                    if (result1.sim > 0.8f) {
                        result = mFairy.findPic(result1.x + 100, result1.y + 36, result1.x + 200, result1.y + 80, new String[]{"smGoTo.png","smGoTo1.png"});
                        if (str.equals("chirdsl.png")){
                            mFairy.onTap(0.8f, result, "日常前往", 5000);
                        }else {
                            mFairy.onTap(0.8f, result, "日常前往", Sleep);
                        }
                        if (result.sim >= 0.8f) {
                            if (!str.equals("Farm.png") && !str.equals("Praying.png")){
                                result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                                mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "前往关闭", Sleep);
                            }
                            GameUtil.this.tastState = 1;
                            setTaskEnd();
                            return;
                        }
                        result = mFairy.findPic(result1.x + 100, result1.y + 36, result1.x + 200, result1.y + 80, new  String[]{"rcComplete.png","rcComplete1.png"});
                        mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "日常完成", Sleep);
                        if (result.sim >= 0.8f) {
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;
                        }
                    }
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6, 8 , 10}, 0, 531, 586, 532, 185, 1000, 1500,2);
                }
            }
            public void content_3() throws Exception {
                result =mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                LtLog.e(mFairy.getLineInfo(0.8f, result, "日常界面"));
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(227,573,1195,650, new String[]{"smGoTo.png","smGoTo1.png"});
                    mFairy.onTap(0.8f, result, "周历前往", Sleep);
                    if (result.sim >= 0.8f) {
                        result = mFairy.findPic(new String[]{"Activeinterface.png","Activeinterface1.png","Activeinterface2.png"});
                        mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "前往关闭", Sleep);
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }else {
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }//开始任务

    public int tymission(final String str) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic(699, 11, 1180, 264, "outer space1.png");
                mFairy.onTap(0.8f, result, "天外山海图标", Sleep);

                result = mFairy.findPic("twsh_inface.png");
                mFairy.onTap(0.8f, result, 1133,343,1152,360, "天外山海界面切换到天外活动", 3000);
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(70,208,278,648, str);
                    LtLog.e("找到了任务=" + str + "," + result1.sim);
                    if (result1.sim > 0.8f) {
                        result = mFairy.findPic(result1.x + 776, result1.y + -20, result1.x + 928, result1.y + 52, "twqw.png");
                        mFairy.onTap(0.8f, result, "天外前往", Sleep);
                        if (result.sim >= 0.8f) {
                            GameUtil.this.tastState = 1;
                            setTaskEnd();
                            return;
                        }
                    }else {
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "天外找任务中");
        return tastState;
    }

    public void close(final int close) throws Exception {
        new GameUtil(mFairy) {
            int j = 1;
            public void content_0() throws Exception {
                if (Thread.currentThread().isInterrupted()){
                    throw new InterruptedException();
                }
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    if (close == 1) {
                        result = mFairy.findPic(1099, 277, 1173, 348,"Hangup1.png");
                        mFairy.onTap(0.8f, result, "关闭挂机", Sleep);

                        result = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                        if (result.sim > 0.8f) {
                            j = 2;
                        } else {
                            j = 20;
                        }
                    }

                    result = mFairy.findPic("leave.png");
                    mFairy.onTap(0.8f, result, "离开", 1000);

                    result =mFairy.findPic(611,234,1271,572,"pipeizhong.png");
                    mFairy.onTap(0.8f, result, "匹配中", Sleep);

                    result =mFairy.findPic("matching.png");
                    mFairy.onTap(0.8f, result, "匹配中", Sleep);

                    result =mFairy.findPic("jybattle.png");
                    mFairy.onTap(0.8f,result,489,430,520,443,"离开队列",Sleep);

                    result=mFairy.findPic("fork2.png");
                    mFairy.onTap(0.8f,result,"fork2关叉",2000);

                    result = mFairy.findPic(919,73,1073,202, new String[]{"fork.png","fork1.png"});//"ymzjcha.png",
                    mFairy.onTap(0.8f, result, "关叉1", 2000);

                    result = mFairy.findPic(442, 1, 1277, 513, new String[]{"cha4.png","cha3.png","cha2.png","cha.png","quxiao.png","fork.png","fork1.png","cha5"});//"ymzjcha.png",
                    mFairy.onTap(0.8f, result, "关叉", 2000);
                    if (result.sim > 0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                    result =mFairy.findPic("xiulian.png");
                    if (result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("挂机修炼了移动一下"));
                        mFairy.ranSwipe(173,569,216,570,100, (long) 100,2);
                    }
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

    public void setUp() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic(826,649,894,716,"visualAngle.png");
                mFairy.onTap(0.8f, result, "锁定视角", Sleep);

                result = mFairy.findPic(1,631,91,712,"Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic(93, 537, 1269, 713, "Set up.png");
                mFairy.onTap(0.8f, result, "设置", Sleep);
                result1 = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                if (result1.sim > 0.8f && result.sim < 0.8f){
                    mFairy.onTap(27,663,37,670,"下面扩展栏",2000);
                }


                result = mFairy.findPic(new String[]{"Set up inface.png","set up2.png"});
                mFairy.onTap(0.8f, result, 1136,146,1158,162, "设置界面", Sleep);
                if (result.sim>=0.8f){
                 /*   result = mFairy.findPic("jineng.png");
                    mFairy.onTap(0.8f, result, "技能", Sleep);*/
                    result = mFairy.findPic("zhengdian.png");
                    mFairy.onTap(0.8f, result, "挣点", Sleep);
                    setTaskName(2);return;
                }

            }

            public void content_2() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic(new String[]{"Set up inface.png","set up2.png"});
                mFairy.onTap(0.8f, result, 1149, 245, 1161, 255, "设置界面", Sleep);

                result1 = mFairy.findPic(688,261,801,342,"wkqzp.png");
                if (result1.sim > 0.75f) {
                    mFairy.onTap(738,304,748,317,"开启战袍模式",2000);

                   /* result1 = mFairy.findPic("kqzp.png");
                    mFairy.onTap(0.8f, result1,  "开启战袍", Sleep);*/

                    result1 = mFairy.findPic(377,272,905,480,"zpms.png");
                    if (result1.sim > 0.75f) {
                        mFairy.onTap(0.75f, result1, 775,435,783,441, "开启战袍确认", Sleep);
                    }
                }

                result = mFairy.findPic("xingneng.png");
                mFairy.onTap(0.8f, result, 776, 152, 796, 165, "性能优先", Sleep);

                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "设置中");
    }//设置

    public void huimeng() throws Exception {
        new GameUtil(mFairy) {
            int num =4;
            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                result = mFairy.findPic("visualAngle.png");
                mFairy.onTap(0.8f, result, "锁定视角", Sleep);

                result = mFairy.findPic(1,631,91,712,"Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic(1087,431,1272,608, "tuteng.png");
                mFairy.onTap(0.8f, result, "点图腾回盟", Sleep);
                result1 = mFairy.findPic(1099, 277, 1173, 348, "NoBattle.png");
                if (result1.sim > 0.8f && result.sim < 0.8f){
                    mFairy.onTap(27,663,37,670,"下面扩展栏",2000);
                }
                if (result.sim > 0.8f){
                    num--;
                }

                result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f, result, "确定", Sleep);

                result = mFairy.findPic("tuteng2.png");
                mFairy.onTap(0.8f, result, 990,125,1001,132,"关闭", Sleep);

                result = mFairy.findPic("xmld.png");
                if (result.sim > 0.8f || num <=0) {
                    LtLog.e("再血盟里了");
                    setTaskEnd();
                    return;
                }
                result2 = mFairy.findPic(1087,431,1272,608, "tuteng.png");
                result = mFairy.findPic( "city.png");
                result1 = mFairy.findPic(93, 537, 1269, 713, "Set up.png");
                if (result.sim > 0.8f && result1.sim > 0.8f && result2.sim < 0.8f){
                    LtLog.e("没用加入血盟回轩辕城");
                    goCity("轩辕");
                    setTaskEnd();
                    return;
                }

            }

        }.taskContent(mFairy, "回盟");
    }//回盟

    int cityCount;
    public int goCity(final String str) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(1);
                if (str.equals("天外噬灵渊") || str.equals("天外霜火岭") || str.equals("天外焚天台")) {
                    setTaskName(4);
                    return;
                }
                if (str.equals("氏族地宫")) {
                    setTaskName(7);return;
                }
                setTaskName(5);
                return;
            }

            public void content_1() throws Exception {
                if (overtime(4, 2)) return;
               /* result = mFairy.findPic("backbf.png");
                mFairy.onTap(0.8f, result, "回到本服", Sleep);

                result = mFairy.findPic("hbfsure.png");
                mFairy.onTap(0.8f, result, "回到本服确定", Sleep);

                result = mFairy.findPic(new String[]{"weimianzhong.png","weimianzhong1.png"});
                if (result.sim>0.8f) {
                    close(1);
                    LtLog.e(mFairy.getLineInfo("位面中"));
                    setTaskName(5);return;
                }else {
                    Thread.sleep(4000);
                }*/

                result = mFairy.findPic("Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic(new String[]{"qhTotems.png", "tuteng.png","backcity.png"});
                mFairy.onTap(0.8f, result, "图腾", Sleep);

                result = mFairy.findPic("Deliverysure.png");
                mFairy.onTap(0.8f, result, "传送确定", 10000);
                if (result.sim > 0.8f) {
                    setTaskName(6);return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic( "tut.png");
                mFairy.onTap(0.8f, result, 990,121,1001,130, "关闭图腾", Sleep);

                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1181, 71, 1203, 90, "打开地图", Sleep);

                result1 = mFairy.findPic("twsh_inface.png");
                result = mFairy.findPic("hcWorld.png");
                mFairy.onTap(0.8f, result, "切换到世界", Sleep);
                if (result.sim > 0.8f || result1.sim > 0.8f) {
                    switch (str) {
                        case "轩辕":
                            //mFairy.onTap(533, 292, 548, 318, str, Sleep);
                            break;
                        case "青木":
                            mFairy.onTap( 1039, 342, 1057, 360, str, Sleep);
                            break;
                        case "苍穹海":
                            mFairy.onTap(779, 585, 795, 599, str, Sleep);
                            break;
                        case "昆仑墟":
                            mFairy.onTap(376, 272, 398, 287, str, Sleep);
                            break;
                        case "孽龙囚":
                            mFairy.onTap( 501, 132, 519, 145, str, Sleep);
                            break;
                        case "葬魂谷":
                            mFairy.onTap( 1024, 204, 1038, 219, str, Sleep);
                            break;
                        case "霜火岭":
                            mFairy.onTap(1076, 497, 1091, 511, str, Sleep);
                            break;
                        case "噬灵渊":
                            mFairy.onTap( 1183, 254, 1198, 268, str, Sleep);
                            break;
                        case "天外噬灵渊":
                            mFairy.onTap(902, 370, 903, 371, str, Sleep);
                            break;
                        case "天外霜火岭":
                            mFairy.onTap( 722, 433, 723, 434, str, Sleep);
                            break;
                        case "焚天台":
                            mFairy.onTap(341, 107, 360, 124, str, Sleep);
                            break;
                        case "天外焚天台":
                            mFairy.onTap( 948, 459, 949, 460, str, Sleep);
                            break;
                        case "山海界":
                            mFairy.onTap( 999,581,1020,597, str, Sleep);
                            break;
                    }
                    if (str.equals("轩辕")){

                    }else {
                        mFairy.onTap(759, 431, 795, 448, "确定传送", Sleep);
                    }
                    result = mFairy.findPic(new  String[]{"szdgzhong.png","weimianzhong.png","weimianzhong1.png"});
                    if (result.sim>0.8f) {
                        close(1);
                        LtLog.e(mFairy.getLineInfo("位面中"));
                        setTaskName(5);return;
                    }
                    setTaskName(3);
                    return;
                }
            }

            public void content_3() throws Exception {
                result1 = mFairy.findPic("twsh_inface.png");
                result = mFairy.findPic("quyu.png");
                if (result.sim > 0.8f || result1.sim>0.8f) {
                    close(1);
                    LtLog.e(mFairy.getLineInfo("已经在目标地图了或没有目标地图"));
                    GameUtil.this.cityCount = 0;
                    setTaskEnd();
                    return;
                }
                long dazeTime = mFairy.mMatTime(1212,129,67,16, 0.9f);
                if (dazeTime > 3) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    GameUtil.this.cityCount = 1;
                    setTaskEnd();
                    return;
                }
                Thread.sleep(3000);
            }

            public void content_4() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic("twsh_inface.png");
                mFairy.onTap(0.8f, result, 1143, 138, 1161, 152, "天外山海界面切换到天外地图", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic(699, 11, 1180, 264, "outer space1.png");
                mFairy.onTap(0.8f, result, "天外山海图标", Sleep);
            }
            //处于位面
            public void content_5() throws Exception {
                if (overtime(15, 0)) return;
                if(AtFairyConfig.getOption("zhsz").equals("1")){
                    result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                    mFairy.onTap(0.8f, result, 1181, 71, 1203, 90, "打开地图", Sleep);
                    result = mFairy.findPic(85, 85, 157, 379, "fentian.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("quyu.png");
                        mFairy.onTap(0.8f, result, "区域", Sleep);

                        result = mFairy.findPic("chuansong.png");
                        mFairy.onTap(0.8f, result, "传送", Sleep);

                        result = mFairy.findPic(747, 135, 1153, 591, "lingdi.png");
                        mFairy.onTap(0.8f, result, "领地", Sleep);

                        result1 = mFairy.findPic("hcWorld.png");
                        if (result1.sim > 0.8f) {
                            result = mFairy.findPic("errszftt.png");
                            if (result.sim > 0.95f) {
                                mFairy.onTap(0.8f, result, 250, 145, 251, 146, "氏族焚天台二层去一层", Sleep);
                            } else {
                                mFairy.onTap(0.8f, result1, 766, 153, 771, 167, "氏族下一层", Sleep);
                            }
                            close(1);
                            setTaskName(1);
                            return;
                        }
                    } else {
                        mFairy.onTap(1240, 44, 1252, 55, "关叉", 2000);

                        result = mFairy.findPic("Lower expansion.png");
                        mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                        result = mFairy.findPic(new String[]{"qhTotems.png", "tuteng.png","backcity.png"});
                        mFairy.onTap(0.8f, result, "图腾", Sleep);

                        result = mFairy.findPic("Deliverysure.png");
                        mFairy.onTap(0.8f, result, "传送确定", 10000);
                        if (result.sim > 0.8f) {
                            setTaskName(6);
                            return;
                        }
                    }
                }else {
                    result = mFairy.findPic("Lower expansion.png");
                    mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                    result = mFairy.findPic(new String[]{"qhTotems.png", "tuteng.png","backcity.png"});
                    mFairy.onTap(0.8f, result, "图腾", Sleep);

                    result = mFairy.findPic("Deliverysure.png");
                    mFairy.onTap(0.8f, result, "传送确定", 10000);
                    if (result.sim > 0.8f) {
                        setTaskName(6);return;
                    }

                }
            }

            public void content_6() throws Exception {
                long dazeTime = mFairy.mMatTime(1212,129,67,16, 0.9f);
                result = mFairy.findPic( "tut.png");
                if (result.sim > 0.8f||dazeTime > 30) {
                    mFairy.onTap(0.8f, result, 990,121,1001,130, "关闭图腾", Sleep);
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("回到血盟"));
                    setTaskName(2);
                    return;
                }

                result2=mFairy.findPic("bianjing3.png");
                if (result2.sim > 0.8f && dazeTime > 10){
                    result  = mFairy.findPic(52,18,1225,670,"delivery2.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+153,result.x+3,result.y+154,"点击传送使者",Sleep);
                    if (result.sim < 0.8f){
                        mFairy.onTap(1199,89,1206,99,"地图",Sleep);
                        mFairy.onTap(579,505,582,510,"地图",Sleep);
                        mFairy.onTap(1243,46,1250,54,"地图",2000);
                    }
                    result  = mFairy.findPic(52,18,1225,670,"delivery2.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+153,result.x+3,result.y+154,"点击传送使者",Sleep);
                    result = mFairy.findPic("deliveryyes.png");
                    mFairy.onTap(0.8f,result,"传送",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(5);return;
                    }
                }

            }

            public void content_7() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(new String[]{"twsh_inface.png","shenmo.png"});
                mFairy.onTap(0.8f, result, 1159,231,1168,240, "天外山海界面切换到氏族", Sleep);
                mFairy.onTap(0.8f, result, 292,95,325,113, "天外山海界面切换到我的氏族", Sleep);
                mFairy.onTap(0.8f, result, 988,639,1014,651, "回到氏族领地",Sleep);
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(new String[]{"weimianzhong.png","weimianzhong1.png"});
                    if (result.sim>0.8f) {
                        close(1);
                        LtLog.e(mFairy.getLineInfo("位面中"));
                        setTaskName(5);return;
                    }
                    Thread.sleep(10000);
                    setTaskName(8);
                    return;
                }
                result = mFairy.findPic(699, 11, 1180, 264, new String[]{"twsh_inface2.png","outer space1.png"});
                mFairy.onTap(0.8f, result, "天外山海图标", Sleep);
            }

            public void content_8() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1181, 71, 1203, 90, "打开地图", Sleep);

                result = mFairy.findPic("quyu.png");
                mFairy.onTap(0.8f, result, "区域", Sleep);

                result = mFairy.findPic("chuansong.png");
                mFairy.onTap(0.8f, result, "传送", Sleep);


                result = mFairy.findPic(747,135,1153,591,"digong.png");
                mFairy.onTap(0.8f, result, "前往氏族地宫", Sleep);
                if (result.sim>0.8f){
                    close(1);
                    setTaskName(9);return;
                }
            }

            public void content_9() throws Exception {
                long dazeTime = mFairy.mMatTime(1144, 30, 55, 19, 0.9f);
                if (dazeTime > 3) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达氏族地宫地点开始传送"));
                    setTaskName(10);
                    return;
                }
            }

            public void content_10() throws Exception {
                if (overtime(30, 0)) return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 851, 594, 866, 604, "下车", Sleep);
                mFairy.onTap(0.8f, result,  559,346,583,403, "点击传送npc", 2000);
                if (result.sim>0.8f){
                    result = mFairy.findPic(710,123,1068,510, "digongsw.png");
                    mFairy.onTap(0.8f, result,  "地宫守卫", 3000);

                    result =mFairy.findPic(18,116,532,607,"jinrushizu.png");
                    mFairy.onTap(0.8f,result,"进入氏族地宫",5000);
                    if (result.sim>0.8f){
                        result =mFairy.findPic(18,116,532,607,"jinrushizu.png");
                        mFairy.onTap(0.8f,result,"进入氏族地宫",5000);
                        setTaskEnd();return;
                    }else {
                        mFairy.onTap(633,328,653,361, "点击传送npc2", 2000);
                        result = mFairy.findPic(710,123,1068,510, "digongsw.png");
                        mFairy.onTap(0.8f, result,  "地宫守卫", 3000);

                        result =mFairy.findPic(18,116,532,607,"jinrushizu.png");
                        mFairy.onTap(0.8f,result,"进入氏族地宫",5000);
                        if (result.sim>0.8f) {
                            result =mFairy.findPic(18,116,532,607,"jinrushizu.png");
                            mFairy.onTap(0.8f,result,"进入氏族地宫",5000);
                            setTaskEnd();
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy, "传送城市中");
        return cityCount;
    }//传送城市

    //天外山海回城
    public void twsh_back()throws Exception {
        new GameUtil(mFairy){
            public void content_0() throws Exception {
                close(1);
                setTaskName(1);
                return;
            }

            //处于位面
            public void content_1() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(699, 11, 1180, 264, "outer space1.png");
                mFairy.onTap(0.8f, result, "天外山海图标", Sleep);

                result= mFairy.findPic("twsh_inface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("twsh activity.png");
                    mFairy.onTap(0.8f,result,"切换天外山海-活动",1000);

                    result=mFairy.findPic("twsh wanfa.png");
                    mFairy.onTap(0.8f,result,"切换天外山海-玩法介绍",1000);

                    result=mFairy.findPic("twsh go.png");
                    mFairy.onTap(0.8f,result,"天外氏族心魔-前往",1000);
                    mFairy.onTap(0.8f,result,1144,45,1171,73,"天外山海关闭",1000);
                    if(result.sim>0.8f){
                        setTaskName(2);
                        return;
                    }
                }
            }

            public void content_2() throws Exception{
                long dazeTime = mFairy.mMatTime(1144, 30, 55, 19, 0.9f);
                if (dazeTime > 20) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("回到自己领地"));
                    setTaskName(3);
                    return;
                }
            }

            @Override
            public void content_3() throws Exception {
                if (overtime(30, 0)) return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 851, 594, 866, 604, "下车", Sleep);
                mFairy.onTap(0.8f, result,  620,363,648,398, "点击传送npc", 2000);

                result=mFairy.findPic("back xuan.png");
                mFairy.onTap(0.8f,result,"回轩辕城",1000);
                mFairy.onTap(0.8f,result,763,430,798,450,"确定",8000);
                if(result.sim>0.8f)setTaskEnd();
            }
        }.taskContent(mFairy,"天外山海-回城");
    }

    public void coordinate(final String str, final int gmx, final int gmy) throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                result = mFairy.findPic("hcWorld.png");
                if (result.sim > 0.8f) {
                }else {
                    close(1);
                }
                setTaskName(1);
                return;
            }

            double x;
            double y;

            public void content_1() throws Exception {
                if (overtime(15, 0)) return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1181, 71, 1203, 90, "打开地图", Sleep);


                result = mFairy.findPic("hcWorld.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("地图界面=" + str));
                    Thread.sleep(2000);
                    switch (str) {
                        case "轩辕":
                            x = gmx *0.0014+gmy *-1.0669+688.7355;
                            y = gmx *1.065+gmy *-0.0029+82.7958;
                            x++;y++;
                            break;
                        case "11": // 苍穹海一层
                            x = gmx * 1.5934 + gmy * -0.0003 + 153.2737;
                            y = gmx * -0.0032 + gmy * 1.592 + 82.5643;
                            break;
                        case "12": //苍穹海二层
                            x = gmx * 1.5904 + gmy * -0.0001 + 153.8818;
                            y = gmx * 0.0016 + gmy * 1.5964 + 81.3154;
                            break;
                        case "13":   // 苍穹海三层
                            x = gmx * 0.0052 + gmy * -1.5949 + 702.2972;
                            y = gmx * 1.5951 + gmy * 0.0071 + 74.2386;
                            break;
                        case "14":  // 苍穹海四层
                            x = gmx * -1.5912 + gmy * -0.0007 + 709.4776;
                            y = gmx * 0.0072 + gmy * -1.5857 + 622.4391;
                            break;
                        case "15":   // 苍穹海五层
                            x = gmx * 0.0038 + gmy * 1.5944 + 158.4757;
                            y = gmx * -1.5964 + gmy * 0.0008 + 632.1015;
                            break;
                        case "16":  //苍穹海六层
                            x = gmx * 1.6193 + gmy * -0.0048 + 138.5786;
                            y = gmx * -0.0006 + gmy * 1.6138 + 82.7988;
                            break;
                        case "21":     //昆仑墟一层
                            x = gmx * 2.6547 + gmy * 0.004 + 171.0579;
                            y = gmx * 0.0079 + gmy * 2.6665 + 86.6366;
                            break;
                        case "22":     //昆仑墟二层
                            x = gmx * 0.001 + gmy * -2.6549 + 695.6343;
                            y = gmx * 2.6683 + gmy * -0.0019 + 93.8995;
                            break;
                        case "23":      //昆仑墟三层
                            x = gmx * -2.6632 + gmy * -0.0064 + 692.8985;
                            y = gmx * 0.0082 + gmy * -2.658 + 617.975;
                            break;
                        case "24":         //昆仑墟四层
                            x = gmx * 0.0002 + gmy * 2.6617 + 165.1822;
                            y = gmx * -2.657 + gmy * -0.0074 + 614.282;
                            break;
                        case "25":         // 昆仑墟五层
                            x = gmx * 2.718 + gmy * 0.0123 + 168.3061;
                            y = gmx * 0.0034 + gmy * 2.7155 + 79.0227;
                            break;
                        case "31":        //   孽龙囚一层
                            x = gmx * 2.667 + gmy * -0.0059 + 162.8442;
                            y = gmx * 0.007 + gmy * 2.6588 + 79.1648;
                            break;
                        case "32":       // 孽龙囚二层
                            x = gmx * 0.0044 + gmy * -2.6556 + 705.2523;
                            y = gmx * 2.6605 + gmy * -0.0091 + 85.8399;
                            break;
                        case "33":        //孽龙囚三层
                            x = gmx * -2.6742 + gmy * 0.0073 + 700.1739;
                            y = gmx * 0.0096 + gmy * -2.6657 + 627.5776;
                            break;
                        case "34":        //孽龙囚四层
                            x = gmx * -0.005 + gmy * 2.652 + 158.8456;
                            y = gmx * -2.6477 + gmy * 0.0189 + 618.8376;
                            break;
                        case "35":         //孽龙囚五层
                            x = gmx * 2.5664 + gmy * -0.003 + 174.8193;
                            y = gmx * -0.0025 + gmy * 2.5807 + 95.5823;
                            break;
                        case "41":         // 葬魂谷一层
                            x = gmx * 2.6423 + gmy * 0.0021 + 160.4783;
                            y = gmx * 0.0007 + gmy * 2.6464 + 89.0966;
                            break;
                        case "42":         // 葬魂谷二层
                            x = gmx * 0.0002 + gmy * -2.6502 + 694.9322;
                            y = gmx * 2.6484 + gmy * -0.0096 + 84.4862;
                            break;
                        case "43":           // 葬魂谷三层
                            x = gmx * -2.6469 + gmy * -0.0039 + 701.1267;
                            y = gmx * -0.0006 + gmy * -2.65 + 617.4616;
                            break;
                        case "44":           // 葬魂谷四层
                            x = gmx * -0.0014 + gmy * 2.6503 + 166.3397;
                            y = gmx * -2.6523 + gmy * 0.0008 + 624.0532;
                            break;
                        case "45":         // 葬魂谷五层
                            x = gmx * 2.6766 + gmy * -0.0056 + 170.5767;
                            y = gmx * -0.0003 + gmy * 2.6793 + 80.1594;
                            break;
                        case "51":           // 霜火岭一层
                            x = gmx * 1.5339 + gmy * -0.0007 + 158.3344;
                            y = gmx * -0.0018 + gmy * 1.5406 + 92.0027;
                            break;
                        case "52":           // 霜火岭二层
                            x = gmx * -0.0023 + gmy * -1.5362 + 693.0572;
                            y = gmx * 1.5345 + gmy * -0.0007 + 81.5459;
                            break;
                        case "53":           //霜火岭三层
                            x = gmx * -1.5346 + gmy * -0.0037 + 704.1056;
                            y = gmx * -0.0011 + gmy * -1.5331 + 614.866;
                            break;
                        case "54":              //霜火岭四层
                            x = gmx * -0.0008 + gmy * 1.5377 + 170.3071;
                            y = gmx * -1.5391 + gmy * -0.001 + 627.8695;
                            break;
                        case "55":               //  霜火岭五层
                            x = gmx * 2.75 + gmy * -0.0 + 157.75;
                            y = gmx * 0.0062 + gmy * 2.7422 + 78.7247;
                        case "56":               //  霜火岭六层
                            x = gmx * 2.75 + gmy * -0.0 + 157.75;
                            y = gmx * 0.0062 + gmy * 2.7422 + 78.7247;
                            break;
                        case "81":           // t霜火岭一层
                            x = gmx * 1.5339 + gmy * -0.0007 + 158.3344;
                            y = gmx * -0.0018 + gmy * 1.5406 + 92.0027;
                            break;
                        case "82":           // t霜火岭二层
                            x = gmx * -0.0023 + gmy * -1.5362 + 693.0572;
                            y = gmx * 1.5345 + gmy * -0.0007 + 81.5459;
                            break;
                        case "83":           //t霜火岭三层
                            x = gmx * -1.5346 + gmy * -0.0037 + 704.1056;
                            y = gmx * -0.0011 + gmy * -1.5331 + 614.866;
                            break;
                        case "84":              //t霜火岭四层
                            x = gmx * -0.0008 + gmy * 1.5377 + 170.3071;
                            y = gmx * -1.5391 + gmy * -0.001 + 627.8695;
                            break;
                        case "85":               //  t霜火岭五层
                            x = gmx * 2.75 + gmy * -0.0 + 157.75;
                            y = gmx * 0.0062 + gmy * 2.7422 + 78.7247;
                            break;
                        case "61":              //噬灵渊一层
                            x = gmx * 2.3668 + gmy * -0.003 + 173.6987;
                            y = gmx * 0.0096 + gmy * 2.3445 + 87.5362;
                            break;
                        case "62":             //噬灵渊二层
                            x = gmx * -0.0044 + gmy * -2.365 + 699.2008;
                            y = gmx * 2.364 + gmy * -0.0005 + 96.7057;
                            break;
                        case "63":             //噬灵渊三层
                            x = gmx * -2.3614 + gmy * -0.0102 + 689.0948;
                            y = gmx * -0.0109 + gmy * -2.3531 + 621.0272;
                            break;
                        case "64":              //噬灵渊四层
                            x = gmx * 0.0003 + gmy * 2.3596 + 163.6336;
                            y = gmx * -2.3506 + gmy * -0.0093 + 609.7954;
                            break;
                        case "65":              //噬灵渊五层
                            x = gmx * 2.2561 + gmy * 0.0029 + 150.8067;
                            y = gmx * -0.0104 + gmy * 2.2572 + 75.5995;
                            break;
                        case "71":              //天外噬灵渊一层
                            x = gmx * 2.3668 + gmy * -0.003 + 173.6987;
                            y = gmx * 0.0096 + gmy * 2.3445 + 87.5362;
                            break;
                        case "72":             //天外噬灵渊二层
                            x = gmx * -0.0044 + gmy * -2.365 + 699.2008;
                            y = gmx * 2.364 + gmy * -0.0005 + 96.7057;
                            break;
                        case "73":             //天外噬灵渊三层
                            x = gmx * -2.3614 + gmy * -0.0102 + 689.0948;
                            y = gmx * -0.0109 + gmy * -2.3531 + 621.0272;
                            break;
                        case "74":              //天外噬灵渊四层
                            x = gmx * 0.0003 + gmy * 2.3596 + 163.6336;
                            y = gmx * -2.3506 + gmy * -0.0093 + 609.7954;
                            break;
                        case "75":              //天外噬灵渊五层
                            x = gmx * 2.3668 + gmy * -0.003 + 173.6987;
                            y = gmx * 0.0096 + gmy * 2.3445 + 87.5362;
                            break;
                        case "91":              //焚天台一层
                            x = gmx * 1.5212 + gmy * -0.006 + 174.9125;
                            y = gmx * 0.0027 + gmy * 1.5122 + 83.1501;
                            break;
                        case "92":             //焚天台二层
                            x = gmx * -0.0029 + gmy * -1.5218 + 703.4934;
                            y = gmx * 1.5162 + gmy * -0.0011 + 97.8166;
                            break;
                        case "93":           //焚天台三层
                            x = gmx * -1.5165 + gmy * 0.0034 + 687.1302;
                            y = gmx * -0.003 + gmy * -1.5118 + 624.5683;
                            break;
                        case "94":            //焚天台四层
                            x = gmx * 0.0051 + gmy * 1.5123 + 159.8901;
                            y = gmx * -1.5193 + gmy * 0.0003 + 611.0996;
                            break;
                        case "95":             //焚天台五层
                            x = gmx * 1.6216 + gmy * -0.0381 + 186.8292;
                            y = gmx * -0.2162 + gmy * 1.2899 + 148.5258;
                            break;
                        case "101":              //天外焚天台一层
                            x = gmx * 1.5212 + gmy * -0.006 + 174.9125;
                            y = gmx * 0.0027 + gmy * 1.5122 + 83.1501;
                            break;
                        case "102":               //天外焚天台二层
                            x = gmx * -0.0029 + gmy * -1.5218 + 703.4934;
                            y = gmx * 1.5162 + gmy * -0.0011 + 97.8166;
                            break;
                        case "103":                 //天外焚天台三层
                            x = gmx * -1.5165 + gmy * 0.0034 + 687.1302;
                            y = gmx * -0.003 + gmy * -1.5118 + 624.5683;
                            break;
                        case "104":                  //天外焚天台四层
                            x = gmx * 0.0051 + gmy * 1.5123 + 159.8901;
                            y = gmx * -1.5193 + gmy * 0.0003 + 611.0996;
                            break;
                        case "105":                  //天外焚天台五层
                            x = gmx * 1.6216 + gmy * -0.0381 + 186.8292;
                            y = gmx * -0.2162 + gmy * 1.2899 + 148.5258;
                            break;
                        case "106":                 //天外焚天台六层
                            x = gmx * -1.5165 + gmy * 0.0034 + 687.1302;
                            y = gmx * -0.003 + gmy * -1.5118 + 624.5683;
                            break;
                        case "107":                     //天外焚天台七层
                            x = gmx * 1.6578 + gmy * 0.0144 + 170.4418;
                            y = gmx * 0.012 + gmy * 1.6627 + 32.759;
                            break;
                        case "111":                     //氏族焚天台1层
                            x = gmx * 1.5212 + gmy * -0.006 + 174.9125;
                            y = gmx * 0.0027 + gmy * 1.5122 + 83.1501;
                            break;
                        case "112":                     //氏族焚天台2层
                            x = gmx * -0.0029 + gmy * -1.5218 + 703.4934;
                            y = gmx * 1.5162 + gmy * -0.0011 + 97.8166;
                            break;
                        case "121":                     //山海界
                            x=gmx *1.0985+gmy *0.0011+89.3976;
                            y=gmx *0.0003+gmy *1.0989+98.6534;
                            break;

                    }
                    if (str.equals("111")){
                        if (LimitlessTask.szmap==1){
                           // t霜火岭一层
                            x = gmx * 1.5339 + gmy * -0.0007 + 158.3344;
                            y = gmx * -0.0018 + gmy * 1.5406 + 92.0027;
                        }
                        if (LimitlessTask.szmap==2){
                            //天外噬灵渊一层
                            x = gmx * 2.3668 + gmy * -0.003 + 173.6987;
                            y = gmx * 0.0096 + gmy * 2.3445 + 87.5362;
                        }
                        if (LimitlessTask.szmap==3){
                            //天外焚天台一层
                            x = gmx * 1.5212 + gmy * -0.006 + 174.9125;
                            y = gmx * 0.0027 + gmy * 1.5122 + 83.1501;
                        }
                    }
                    if (str.equals("112")){
                        if (LimitlessTask.szmap==1){
                            // t霜火岭二层
                            x = gmx * -1.5346 + gmy * -0.0037 + 704.1056;
                            y = gmx * -0.0011 + gmy * -1.5331 + 614.866;
                        }
                        if (LimitlessTask.szmap==2){
                            //天外噬灵渊二层
                            x = gmx * -2.3614 + gmy * -0.0102 + 689.0948;
                            y = gmx * -0.0109 + gmy * -2.3531 + 621.0272;
                        }
                        if (LimitlessTask.szmap==3){
                            //天外焚天台二层
                            x = gmx * -1.5165 + gmy * 0.0034 + 687.1302;
                            y = gmx * -0.003 + gmy * -1.5118 + 624.5683;
                        }
                    }
                    mFairy.tap((int) x, (int) y);
                    LtLog.e(mFairy.getLineInfo("坐标x=" + (int) x + ",y=" + (int) y));
                    close(1);
                    setTaskName(2);
                    return;
                }
            }

            public void content_2() throws Exception {
                //坐标三秒没变,则到达坐标点
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                if (dazeTime > 3) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "定位坐标中");
    }//定位坐标

    public  void  baoshi()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(6,99)){
                    result = mFairy.findPic("zhuangbei.png");
                    mFairy.onTap(0.8f, result, 23,662,38,672,"装备", Sleep);
                    close(0);return;
                }
                result = mFairy.findPic("Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic("zhuangbei.png");
                mFairy.onTap(0.8f, result, "装备", Sleep);

                result = mFairy.findPic("baoshi.png");
                mFairy.onTap(0.8f, result, "宝石", Sleep);

                result = mFairy.findPic("xuanzebaoshi.png");
                mFairy.onTap(0.8f, result, "自动选择", Sleep);
                mFairy.onTap(0.8f, result, 981,636,1020,652,"升级", Sleep);
            }
        }.taskContent(mFairy,"升级宝石任务中");
    }//升级宝石

    //防止扩展背包
    public  void  goods()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);return;
            }
            int wpCount=0;
            public void content_1() throws Exception {
                if (overtime(9,99)){close(0);return;}
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1071,110,1087,121,"打开背包", 3000);

                result = mFairy.findPic(600,146,1137,529,"buluobi.png");
                LtLog.e("*********"+result.sim);

                result = mFairy.findPic("baginface.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result, 632,96,663,111,"背包界面内", Sleep);
                    result = mFairy.findPic(600,146,1137,529,new  String[]{"shanhai2.png","yinpiao.png","jinpiao.png","jinpiao2.png","buluobi.png","buluo bi2.png"});
                    mFairy.onTap(0.8f, result, "物品", 2000);
                    if (result.sim>0.8f){
                        err--;
                        wpCount++;
                        if (wpCount>20){
                            setTaskEnd();return;
                        }
                    }else {
                        mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4,5,6,7}, 0, 1106,309, 629,301, 1000, 1500,2);
                    }

                    result=mFairy.findPic(646,328,765,366,"word hint lanwei.png");
                    mFairy.onTap(0.8f,result,508,435,516,443,"取消解锁栏位",1000);

                    result = mFairy.findPic(23, 31, 1248, 690, "xmqjUse.png");
                    mFairy.onTap(0.8f, result, "使用", Sleep);

                    result = mFairy.findPic(23, 31, 1248, 690, "duihuan.png");
                    mFairy.onTap(0.8f, result, "兑换", Sleep);

                    result = mFairy.findPic(281,198,1036,684,"qluse.png");
                    result1=mFairy.findPic(646,328,765,366,"word hint lanwei.png");
                    if (result.sim>0.8f && result1.sim <0.8f){
                        mFairy.onTap(0.8f, result, "批量确定", Sleep);
                        result = mFairy.findPic(538,96,752,195,"cishuxianzhi.png");
                        mFairy.onTap(0.8f, result, 915,153,934,167,"次数限制",Sleep);
                        if (result.sim>0.8f){
                            mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                        }else {
                            Thread.sleep(4000);
                        }
                    }else {
                        mFairy.onTap(0.8f, result, 504,427,518,435,"取消222", Sleep);
                    }

                    result = mFairy.findPic("shanhaishop.png");
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("山海商店中"));
                        mFairy.onTap(0.8f, result, 173,153,188,164,"坡介石", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 630,161,661,176,"精髓", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 268,261,287,270,"神器", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 584,245,614,259,"精魂", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 154,368,169,380,"远古升级石", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 510,369,523,380,"氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 151,469,167,484,"高级氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 505,474,519,488,"玲珑玉下品", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 159,584,173,595,"温魂碎片", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("dhjsure.png");
                        mFairy.onTap(0.8f, result, 639,434,669,446,"确定", 5000);
                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("quehuo.png");
                        mFairy.onTap(0.8f, result, 633,429,671,445,"确定", 5000);
                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                    }
                    for (int i=0;i<2;i++){
                        mFairy.condit();
                        result = mFairy.findPic(281,198,1036,684,"plquxiao.png");
                        if (result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("使用中"));
                            i=0;
                        }
                    }
                }
            }
        }.taskContent(mFairy,"物品的使用中");
    } //物品的使用

    //使用物品
    public  void  goods2()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);return;
            }
            int wpCount=0;
            public void content_1() throws Exception {
                if (overtime(10,99)){close(0);return;}
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1071,110,1087,121,"打开背包", 3000);
                result = mFairy.findPic("baginface.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result, 632,96,663,111,"背包界面内", Sleep);//472,380  637，380

                    result = mFairy.findPic(600,146,1137,529,"box3.png");
                    mFairy.onTap(0.8f, result, "箱子", 2000);

                    result = mFairy.findPic(37,54,785,587,"box4.png");
                    mFairy.onTap(0.8f, result, result.x+255,result.y+36,result.x+257,result.y+39,"开起箱子", 1000);//676,385,684,392    421 349

                    result = mFairy.findPic(600,146,1137,529,new  String[]{"yinpiao.png","jinpiao.png","jinpiao2.png","buluo bi2.png"});
                    mFairy.onTap(0.8f, result, "物品", 2000);
                    mFairy.onTap(0.8f, result, result.x-165,result.y-2,result.x-164,result.y-1,"使用", 1000);
                    if (result.sim>0.8f){
                        err--;
                        wpCount++;
                        if (AtFairyConfig.getOption("twshj").equals("1")){
                            if (wpCount>10){
                               setTaskName(2);return;
                            }
                        }else {
                            if (wpCount>10){
                                setTaskEnd();return;
                            }
                        }
                    }else {
                        mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4,5,6,7}, 0, 1106,309, 629,301, 1000, 1500,2);
                    }

                    result=mFairy.findPic(646,328,765,366,"word hint lanwei.png");
                    mFairy.onTap(0.8f,result,508,435,516,443,"取消解锁栏位",1000);

                    result = mFairy.findPic(23, 31, 1248, 690, "xmqjUse.png");
                    mFairy.onTap(0.8f, result, "使用", Sleep);

                    result = mFairy.findPic(23, 31, 1248, 690, "duihuan.png");
                    mFairy.onTap(0.8f, result, "兑换", Sleep);

                    result = mFairy.findPic(281,198,1036,684,"qluse.png");
                    result1=mFairy.findPic(646,328,765,366,"word hint lanwei.png");
                    if (result.sim>0.8f && result1.sim <0.8f){
                        mFairy.onTap(0.8f, result, "批量确定", Sleep);
                        result = mFairy.findPic(538,96,752,195,"cishuxianzhi.png");
                        mFairy.onTap(0.8f, result, 915,153,934,167,"次数限制",Sleep);
                        if (result.sim>0.8f){
                            mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                        }else {
                            Thread.sleep(4000);
                        }
                    }else {
                        mFairy.onTap(0.8f, result, 504,427,518,435,"取消222", Sleep);
                    }

                   /* result = mFairy.findPic("shanhaishop.png");
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("山海商店中"));
                        mFairy.onTap(0.8f, result, 173,153,188,164,"坡介石", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 630,161,661,176,"精髓", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 268,261,287,270,"神器", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 584,245,614,259,"精魂", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 154,368,169,380,"远古升级石", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 510,369,523,380,"氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 151,469,167,484,"高级氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 505,474,519,488,"玲珑玉下品", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 159,584,173,595,"温魂碎片", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("dhjsure.png");
                        mFairy.onTap(0.8f, result, 639,434,669,446,"确定", 5000);
                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("quehuo.png");
                        mFairy.onTap(0.8f, result, 633,429,671,445,"确定", 5000);
                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                    }*/
                    for (int i=0;i<2;i++){
                        mFairy.condit();
                        result = mFairy.findPic(281,198,1036,684,"plquxiao.png");
                        if (result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("使用中"));
                            i=0;
                        }
                    }
                }

                if (AtFairyConfig.getOption("twshj").equals("1")){
                    if (err == 8){
                        close(0);
                        setTaskName(2);return;
                    }
                }
            }
            public void content_2() throws Exception {
                if (overtime(8,99)){close(0);return;}

                result = mFairy.findPic("juanbuzu.png");
                mFairy.onTap(0.8f, result, 644,432,656,440,"卷不足确定结束", 3000);
                if (result.sim > 0.8f){
                    err=99;
                }
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1071,110,1087,121,"打开背包", 3000);
                result = mFairy.findPic("baginface.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result, 632,96,663,111,"背包界面内", Sleep);
                    List<FindResult>  resultList = mFairy.findPic(600,146,1137,529,0.8f,"shanhai2.png");
                    LtLog.e("多少个天山卷"+resultList.size());
                    if (resultList.size() <= 0){
                        mFairy.taskSlid(err, new int[]{0,1,2,3,4,5,6,7,8}, 0, 1106,309, 629,301, 1000, 1500,3);
                    }else if (resultList.size() == 1){
                        mFairy.onTap(0.8f,resultList.get(0),"山海卷",3000);
                        mFairy.condit();
                        result = mFairy.findPic(9,62,1271,627,"shizhuang.png");
                        if (result.sim >= 0.8f){
                            mFairy.onTap(0.8f,resultList.get(0),"时装卷取消",2000);
                            LtLog.e("找到时装卷了  滑动");
                            mFairy.ranSwipe(1106,309, 629,301, 1000, 1500);
                        }
                    }else if (resultList.size() >=2){
                        mFairy.onTap(0.8f,resultList.get(0),"山海卷",3000);
                        mFairy.condit();
                        result = mFairy.findPic(9,62,1271,627,"shizhuang.png");
                        if (result.sim >= 0.8f){
                            mFairy.onTap(0.8f,resultList.get(0),"时装卷取消",2000);
                        }
                        mFairy.onTap(0.8f,resultList.get(1),"山海卷2",2000);
                    }
                   /* result = mFairy.findPic(600,146,1137,529,"shanhai2.png");
                    mFairy.onTap(0.8f, result, "物品", 2000);
                    if (result.sim>0.8f){
                        err--;
                        wpCount++;
                        if (wpCount > 20 ){
                            setTaskEnd();return;
                        }
                    }else {
                        mFairy.taskSlid(err, new int[]{0, 1, 2, 3, 4,5,6,7}, 0, 1106,309, 629,301, 1000, 1500,2);
                    }*/

                    result=mFairy.findPic(646,328,765,366,"word hint lanwei.png");
                    mFairy.onTap(0.8f,result,508,435,516,443,"取消解锁栏位",1000);

                    result = mFairy.findPic(23, 31, 1248, 690, "duihuan.png");
                    mFairy.onTap(0.8f, result, "兑换", Sleep);
                    if (result.sim > 0.8f){
                        err = 0;
                    }
                }
                    result = mFairy.findPic(466,111,621,214,"shanhaishop.png");
                    if (result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("山海商店中"));
                        if (AtFairyConfig.getOption("pjsrc").equals("1")){//171,162   332,107,470,215
                            result1 = mFairy.findPic(107,106,832,661,"shanhaishop.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "坡介石", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }

                        }
                        if (AtFairyConfig.getOption("jsrc").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"jingcui.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "精髓", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }

                        }
                        if (AtFairyConfig.getOption("sqrc").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"shenqiyg.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "神器", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("jhec").equals("1")){
                            result1 = mFairy.findPic(110,104,831,432,"jinghun.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "精魂", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("ygsjsrc").equals("1")){
                            result1 = mFairy.findPic(106,424,823,644,"jinghun.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "远古升级石", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("szbztrc").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"baozanghls.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "氏族藏宝图", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("gjszbztrc").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"baozang2hls.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "高级氏族藏宝图", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("llyxprc").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"linglong.png");
                            if (result1.sim > 0.7f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "玲珑玉下品", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("whsprc").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"wenhun.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "温魂碎片", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("hyjqd").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"hunyuan.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "混元聚气丹", Sleep);
                                    mFairy.onTap(0.8f, result1, 1091,463,1108,476,"最大", Sleep);
                                    mFairy.onTap(0.8f, result1, 968,597,989,611,"购买", Sleep);
                                    mFairy.onTap(0.8f, result1, 772,433,806,448,"确定", 5000);
                                }
                            }
                        }
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(500,567,501,200,300,Sleep);
                        LtLog.e("滑动=====");
                        mFairy.ranSwipe(500,567,501,200,300,Sleep);
                        if (AtFairyConfig.getOption("tgssd").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"tgssd.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "太古神石（低级）", 1000);
                                    mFairy.onTap(0.8f, result1, 1092,469,1116,479,"最大", 1000);
                                    mFairy.onTap(0.8f, result1, 992,596,1022,616,"购买", 1000);
                                    mFairy.onTap(0.8f, result1, 757,429,801,454,"确定", 5000);
                                }
                            }
                        }
                        if (AtFairyConfig.getOption("tgjcd").equals("1")){
                            result1 = mFairy.findPic(107,106,832,661,"tgjcd.png");
                            if (result1.sim > 0.8f){
                                result = mFairy.findPic(result1.x+161,result1.y-55,result1.x+299,result1.y+53,"shouwan.png");
                                if (result.sim > 0.8f){

                                }else {
                                    mFairy.onTap(0.8f, result1, "太古精粹（低级）", 1000);
                                    mFairy.onTap(0.8f, result1, 1085,460,1123,484,"最大", 1000);
                                    mFairy.onTap(0.8f, result1, 992,596,1022,616,"购买", 1000);
                                    mFairy.onTap(0.8f, result1, 757,429,801,454,"确定", 5000);
                                }
                            }
                        }
                       /* mFairy.onTap(0.8f, result, 510,369,523,380,"氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);*/

                        /*mFairy.onTap(0.8f, result, 151,469,167,484,"高级氏族藏宝图", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 505,474,519,488,"玲珑玉下品", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 159,584,173,595,"温魂碎片", Sleep);
                        mFairy.onTap(0.8f, result, 1091,463,1108,476,"最大", Sleep);
                        mFairy.onTap(0.8f, result, 968,597,989,611,"购买", Sleep);
                        mFairy.onTap(0.8f, result, 772,433,806,448,"确定", 5000);

                        mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);*/

                        result = mFairy.findPic("dhjsure.png");
                        mFairy.onTap(0.8f, result, 639,434,669,446,"确定", 5000);
                       // mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);

                        result = mFairy.findPic("quehuo.png");
                        mFairy.onTap(0.8f, result, 633,429,671,445,"确定", 5000);
                        //mFairy.onTap(0.8f, result, 1143,53,1162,64,"关闭", Sleep);
                        mFairy.ranSwipe(1106,309, 629,301, 1000, (long) 1500,2);
                    }
            }
        }.taskContent(mFairy,"物品的使用中2222");
    }


    public  void  clearBag()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                if (overtime(15,99)){close(0);return;}
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1071,110,1087,121,"打开背包", 3000);

                result = mFairy.findPic("baginface.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f, result, 977,628,1017,643,"分解", Sleep);
                    mFairy.onTap(0.8f, result, 825,630,892,650,"自动选择", Sleep);
                    mFairy.onTap(0.8f, result, 736,506,789,525,"确认选择", Sleep);
                    result1 = mFairy.findPic("zise.png");
                    if (result1.sim>0.8f) {
                        mFairy.onTap(0.8f, result1, 744, 423, 818, 458, "紫色确认分解", Sleep);
                    }
                    result2 = mFairy.findPic(586,256,724,384,"chengse.png");
                    if (result2.sim>0.8f) {
                        mFairy.onTap(0.8f, result2, 489,425,546,456, "有橙色取消分解", Sleep);
                    }
                    mFairy.onTap(0.8f, result, 305,619,341,636,"确认分解", Sleep);
                    result = mFairy.findPic("baginface.png");
                    for (int i=0;i<3;i++){
                        mFairy.condit();
                        result = mFairy.findPic(258,241,1010,612,"bagquxiao.png");
                        mFairy.onTap(0.8f, result, "清背包err取消", Sleep);
                    }
                    close(0);
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"分解清包中");
    }//分解清包

    public  void  cifu()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                 close(0);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1074,34,1085,49, "日常", Sleep);


                result = mFairy.findPic(876, 5, 1120, 146, "welfare.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(new String[]{"WelfareInterface.png","WelfareInterface1.png","WelfareInterface2.png","WelfareInterface3.png" });
                if (result.sim>0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(3,99)){close(0);return;}

                result = mFairy.findPic(13,16,505,710,"cifu.png");
                mFairy.onTap(0.8f, result, "赐福", Sleep);

                result = mFairy.findPic(6,4,1274,707,new  String[]{"jpReceive.png","jpReceive1.png" });
                mFairy.onTap(0.8f, result, "领取", Sleep);
            }
        }.taskContent(mFairy,"赐福中");
    }//赐福

    public  void  tanxian()throws Exception{
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;

                result = mFairy.findPic("Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result=mFairy.findPic("pic lock.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("灵宠没有解锁，任务结束"));
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("Spoil.png");
                mFairy.onTap(0.8f, result, "灵宠", Sleep);

                result = mFairy.findPic("SpiritInterface.png");
                int picCount=picCount(0.8f,result,"pet tanxian");
                if(picCount>=4){
                    LtLog.e(mFairy.getLineInfo("灵宠探险没有解锁，任务结束"));
                    mFairy.onTap(1146,51,1168,69,"关闭",1000);
                    setTaskEnd();
                    return;
                }
                mFairy.onTap(0.8f, result, 1142,564,1159,579,"灵宠界面切探险", Sleep);

                result=mFairy.findPic("pic pet tanxian interface.png");
                if (result.sim>0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(6,3))return;

                result = mFairy.findPic(67,81,335,670, "txwc.png");
                mFairy.onTap(0.8f, result, "已完成", Sleep);

                result = mFairy.findPic("dkbx.png");
                mFairy.onTap(0.8f, result, "打开宝箱", Sleep);
                if (result.sim>0.8f){
                    err=0;
                }

                result =mFairy.findPic(371,245,916,632,"tssure.png");
                mFairy.onTap(0.8f,result,"探索奖励确认",Sleep);
            }
            int rwCount=0,xzCount=0,num =0;
            public void content_3() throws Exception {
                result = mFairy.findPic("SpiritInterface.png");
                mFairy.onTap(0.8f, result, 1142,564,1159,579,"灵宠界面切探险", Sleep);
                if (result.sim>0.8f){
                    result1 = mFairy.findPic("notanxian.png");
                    if (result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("没有探险任务了结束"));
                        setTaskEnd();return;
                    }
                    if (rwCount==0){
                        mFairy.onTap(0.8f, result, 180,127,212,146,"第1个探险", Sleep);
                    }
                    if (rwCount==1){
                        mFairy.onTap(0.8f, result, 182,236,204,250,"第2个探险", Sleep);
                    }
                    if (rwCount==2){
                        mFairy.onTap(0.8f, result, 185,334,209,353,"第3个探险", Sleep);
                    }
                    if (rwCount==3){
                        mFairy.onTap(0.8f, result, 176,430,204,443,"第4个探险", Sleep);
                    }
                    if (rwCount==4){
                        mFairy.onTap(0.8f, result, 167,530,194,548,"第5个探险", Sleep);
                    }
                    if (rwCount==5){
                        setTaskEnd();return;
                    }
                    setTaskName(4);return;
                }else {
                    setTaskName(0);return;
                }
            }
            public void content_4() throws Exception {
                if (overtime(10,3))return;
                result = mFairy.findPic("lijits.png");
                if (result.sim>0.8f){
                    List<FindResult> listResult = mFairy.findPic(661,117,709,282, 0.8f, "tsNO.png");
                    if (listResult.size() != 0) {
                        if (xzCount==0){
                            mFairy.onTap(0.8f, result, 454,550,474,566,"第1个选择框", Sleep);
                        }
                        if (xzCount==1){
                            mFairy.onTap(0.8f, result, 632,550,649,567,"第2个选择框", Sleep);
                        }
                        if (xzCount==2){
                            mFairy.onTap(0.8f, result, 807,552,827,572,"第3个选择框", Sleep);
                        }
                        if (xzCount==3){
                            mFairy.onTap(0.8f, result, 979,548,998,566,"第4个选择框", Sleep);
                        }
                        mFairy.onTap(0.8f, result, 436,384,459,403,"选一个灵兽", Sleep);
                        xzCount++;
                        if (xzCount>=4){
                            mFairy.onTap(0.8f, result, "立即探索", Sleep);
                            rwCount++;
                            xzCount=0;
                            setTaskName(3);return;
                        }
                        result = mFairy.findPic(474,213,870,463,"tansuostop.png");
                        if (result.sim>0.8f){
                            mFairy.onTap(0.8f, result, 711,632,735,650,"立即探索", Sleep);
                            setTaskEnd();return;
                        }
                    }else{
                        mFairy.onTap(0.8f, result, "立即探索", Sleep);
                        rwCount++;
                        if (rwCount>=5){
                            LtLog.e(mFairy.getLineInfo("5个图都探险完了结束"));
                            setTaskEnd();return;
                        }
                        setTaskName(3);return;
                    }
                }
                result = mFairy.findPic(762,585,1090,702,new String[]{"Immediate.png","kewan.png"});
                if (result.sim>=0.8f){
                    rwCount++;
                    setTaskName(3);return;
                }
                if (err==9){
                    num++;
                }
                if (num >= 10){
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"探险中");
    }//灵宠探险

    public  void  pullHeel()throws Exception{
        new GameUtil(mFairy){
            @Override
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(15,2))return;
                result = mFairy.findPic("LeftCaptain.png");
                mFairy.onTap( 0.9f, result, "左侧队伍", Sleep);

                result = mFairy.findPic("CreateTeam.png");
                mFairy.onTap( 0.8f, result, 766, 282,767, 283,"创建队伍", Sleep);
                if (result.sim > 0.8f) {
                   setTaskName(2);return;
                }
                result = mFairy.findPic("HeelStation.png");
                mFairy.onTap( 0.8f, result, "发起跟站", Sleep);

                result = mFairy.findPic(new String[]{"gzSure.png","by following.png"});
                mFairy.onTap( 0.8f, result, "跟站确定", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(10,99)){close(0);return;}
                result =mFairy.findPic("task1.png");
                mFairy.onTap(0.9f,result,"任务栏暗点切换到任务栏",Sleep);

                result =mFairy.findPic("team.png");
                mFairy.onTap(0.95f,result,15,234,29,262,"在队伍栏切换到任务栏",Sleep);

                result=mFairy.findPic("my team.png");
                mFairy.onTap(0.8f,result,766, 282,767, 283,"关闭队伍界面",1000);

                result =mFairy.findPic("task.png");
                if (result.sim<0.9f){
                    mFairy.onTap( 0.8f, result, 766, 282,767, 283,"收一下任务框", Sleep);
                }else {
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"拉跟站中");
    }//拉跟站

    public void jdplx() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);
                return;
            }
            public void content_1() throws Exception {
                result = mFairy.findPic(1,631,91,712,"Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic(370,534,625,634, "juedoupai.png");
                mFairy.onTap(0.8f, result, "打开决斗牌", Sleep);

                result = mFairy.findPic("jingji.png");
                mFairy.onTap(0.8f, result, "竞技", Sleep);

                result = mFairy.findPic("off-line.png");
                mFairy.onTap(0.8f, result, "匹配", Sleep);

                result = mFairy.findPic("tiaoz.png");
                mFairy.onTap(0.8f, result, "挑战", Sleep);

                result = mFairy.findPic("tiaoz2.png");
                mFairy.onTap(0.8f, result, "挑战2", Sleep);

                result = mFairy.findPic("no.png");
                if (result.sim > 0.8f){
                    LtLog.e("挑战冷却结束");
                    setTaskEnd();return;
                }

              /*  result1 = mFairy.findPic("mianfei.png");
                if (result1.sim > 0.8f) {
                    result = mFairy.findPic(424, 86, 1057, 554, "box.png");
                    mFairy.onTap(0.8f, result, "挖矿2", Sleep);
                }*/
                result1 = mFairy.findPic("null.png");
                if (result1.sim > 0.8f){
                    LtLog.e("没有牌结束");
                    setTaskEnd();return;
                }

                result = mFairy.findPic( "jixu.png");
                mFairy.onTap(0.8f, result, "继续", Sleep);

                result = mFairy.findPic(437,529,556,628,"suo.png");
                if (result.sim > 0.8f){
                    LtLog.e("还没开启");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "决斗牌");
    } //决斗牌离线

    public  void  fuli()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close(1);
                setTaskName(1);return;
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;
                result = mFairy.findPic(876, 5, 1120, 146, "daily.png");
                mFairy.onTap(0.8f, result, 1074,34,1085,49, "日常", Sleep);

                result = mFairy.findPic(876, 5, 1120, 146, "welfare.png");
                mFairy.onTap(0.8f, result, "福利", Sleep);

                result = mFairy.findPic(new String[]{"WelfareInterface.png","WelfareInterface1.png","WelfareInterface2.png","WelfareInterface3.png" });
                if (result.sim>0.7f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(4,3))return;
                result = mFairy.findPic(66,56,425,422, new  String[]{"qdlj.png","qdlj1.png"});
                mFairy.onTap(0.8f, result, "签到领奖", Sleep);

                result = mFairy.findPic( 6,4,1274,707,new  String[]{"qiandao.png","qiandao1.png"});
                mFairy.onTap(0.8f, result, "签到", Sleep);

                result = mFairy.findPic("buqian.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                if (overtime(6,4))return;
                result = mFairy.findPic(66,56,425,422, new  String[]{"zyzh.png","zyzh1.png"});
                mFairy.onTap(0.8f, result, "资源追回", Sleep);

                result = mFairy.findPic(891,177,1029,229,"FullRecovery.png");
                mFairy.onTap(0.8f, result, "普通全追回", Sleep);

                result = mFairy.findPic("FullRecovery1.png");
                mFairy.onTap(0.8f, result, "普通全追回", 30000);

                result =mFairy.findPic(340,223,927,624,"smSure.png");
                mFairy.onTap(0.8f,result,"奖励确认",Sleep);
                if (result.sim>0.8f){
                    err=0;
                }


            }
            public void content_4() throws Exception {
                if (overtime(3,5))return;

                result = mFairy.findPic(66,56,425,422,  new  String[]{"zhaocai.png","zhaocai1.png"});
                mFairy.onTap(0.8f, result, "招财", Sleep);

                result = mFairy.findPic(947,296,1196,472,new  String[]{"Freefeed.png","Freefeed1.png"});
                mFairy.onTap(0.8f, result,   result.x+30, result.y - 30, result.x+31, result.y - 29,"免费招财", Sleep);

            }
            public void content_5() throws Exception {
                if (overtime(4,6)){
                    gameUtil.close(1);
                    return;
                }

                result = mFairy.findPic(66,56,425,422,"cifu.png");
                mFairy.onTap(0.8f, result, "赐福", Sleep);

                result = mFairy.findPic(458,262,1092,644,new  String[]{"jpReceive.png","jpReceive1.png" });
                mFairy.onTap(0.8f, result, "领取", Sleep);
            }
            public void content_6() throws Exception {
                if (overtime(6,99))return;

                result = mFairy.findPic("Lower expansion.png");
                mFairy.onTap(0.8f, result, "打开下扩展栏", Sleep);

                result = mFairy.findPic("Spoil.png");
                mFairy.onTap(0.8f, result, "灵宠", Sleep);

                result = mFairy.findPic("SpiritInterface.png");
                mFairy.onTap(0.8f, result, 1139,350,1159,368,"灵宠界面", Sleep);

                result = mFairy.findPic(155, 552, 1085, 681,"FreeCharge.png");
                mFairy.onTap(0.8f, result,  result.x, result.y - 30, result.x+1, result.y - 29,"灵宠免费", 7000);

                result = mFairy.findPic("initFork8.png");
                mFairy.onTap(0.8f, result, "叉", Sleep);
            }
        }.taskContent(mFairy,"福利任务中");
    }//福利

    public  void  moshi()throws Exception{
        if (AtFairyConfig.getOption("hpms").equals("1")) {
            result = mFairy.findPic("moshi.png");
            result1 = mFairy.findPic("peace.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, "切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 517, 148, 529, 155, "和平模式", Sleep);
            }
        }
        if (AtFairyConfig.getOption("hpms").equals("2")) {
            result = mFairy.findPic("moshi.png");
            result1 = mFairy.findPic("sane.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, "切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 518,203,531,212, "善恶模式", Sleep);
            }
        }

        if (AtFairyConfig.getOption("hpms").equals("3")) {
            result = mFairy.findPic("moshi.png");
            result1 = mFairy.findPic("xuemeng.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, "切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 512,309,531,326, "血盟模式", Sleep);
            }
        }

        if (AtFairyConfig.getOption("hpms").equals("4")) {
            result = mFairy.findPic("moshi.png");
            result1 = mFairy.findPic("buluo.png");
            if (result.sim > 0.8f && result1.sim < 0.8f) {
                mFairy.onTap(0.8f, result, "切换下模式", Sleep);
                mFairy.onTap(0.8f, result, 515,362,531,381, "部落模式", Sleep);
            }
        }
    }//切换模式


    public void srAIAnswer() throws Exception {
        List<String> answerStrABCD = new ArrayList();

        String mStr = getPictureText(220,133,848,88);//题目范围x,y,w,h
        LtLog.e(this.mFairy.getLineInfo("题目是=" + mStr));
        if (mStr == null || mStr.equals("")) {
            this.mFairy.onTap(597,266,606,274, "没有识别到题目,默认选A", 1000);
            //mFairy.onTap(895, 579, 935, 588, "", 3000);
        } else {
            answerStrABCD.add(getPictureText(581,250,279,72));//A范围x,y,w,h
            answerStrABCD.add(getPictureText(882,250,275,70));//B范围x,y,w,h

            String c = getPictureText(580,342,280,72);
            if (!c.equals("")) {
                answerStrABCD.add(c);//C范围x,y,w,h
            }
            String d = getPictureText(883,344,276,63);
            if (!d.equals("")) {
                answerStrABCD.add(d);//C范围x,y,w,h
            }

            String[] answer = this.findAnswer(mStr, AtFairyConfig.getGameID());
            if (answer != null) {
                LtLog.e(mFairy.getLineInfo("开始匹配答案："));
                for (int j = 0; j < answerStrABCD.size(); ++j) {
                    LtLog.e(j + " : " + answerStrABCD.get(j));

                    for (int i = 0; i < answer.length; ++i) {
                        if (answerStrABCD.get(j).equals(answer[i])) {
                            switch (j) {
                                case 0:
                                    mFairy.onTap(600,271,620,289, "匹配到正确答案A", 1000);
                                    break;
                                case 1:
                                    mFairy.onTap(1107,282,1117,288, "匹配到正确答案B", 1000);
                                    break;
                                case 2:
                                    mFairy.onTap(613,365,637,386, "匹配到正确答案C", 1000);
                                    break;
                                case 3:
                                    mFairy.onTap(915,365,939,383, "匹配到正确答案D", 1000);
                                    break;
                            }
                            mFairy.onTap(604,278,611,287, "", 3000);
                            return;
                        }
                    }
                }
            }

            LtLog.e(this.mFairy.getLineInfo("没有匹配到,开始上传"));
            LtLog.i(this.mFairy.getLineInfo("----------------------------upDown>"));
            String answerStr = "";
            this.mFairy.onTap(604,278,611,287, "A", 1000);
            for (int i = 0; i < 10; ++i) {
                result = this.mFairy.findPic(762,244,862,328, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(0);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---A---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(1064,247,1160,331, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(1);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---B---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(758,333,866,421, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(2);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---C---" + answerStr));
                    break;
                }

                result = this.mFairy.findPic(1059,336,1163,414, "str1.png");
                if (result.sim > 0.88f) {
                    answerStr = answerStrABCD.get(3);
                    LtLog.e(this.mFairy.getLineInfo("正确答案---D---" + answerStr));
                    break;
                }
                Thread.sleep(200);
            }

            if (answerStr != "") {
                this.UpAnswerAndTitle(mStr, answerStr, AtFairyConfig.getGameID());
            }
        }
    }


    public String bitmapToBase64(Bitmap bitmap, int quality) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public String trWebOCR(String url, Bitmap bitmap) {
        String result = null;
        String imgBase64 = bitmapToBase64(bitmap, 50);
        try {
            FormBody.Builder builder = new FormBody.Builder();

            builder.add("img", imgBase64);
            RequestBody formBody = builder.build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                result = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPictureText(int x, int y, int width, int height) {
        //331, 165, 811, 109
        Mat mat = mFairy.getScreenMat(x, y, width, height, 1, 0, 0, 1);
        Bitmap bmpCanny = Bitmap.createBitmap(mat.cols(), mat.rows(), Bitmap.Config.ARGB_8888);
        org.opencv.android.Utils.matToBitmap(mat, bmpCanny);

        String str = trWebOCR("http://192.168.1.254:8089/api/tr-run/", bmpCanny);
        if (str == null || str.equals("")) {
            return "";
        }

        LtLog.e("trWebOCR :" + str);

        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) new JSONObject(new JSONObject(str).get("data").toString()).get("raw_out");
            String mStr = new JSONArray(jsonArray.get(0).toString()).get(1).toString();
            return mStr;
        } catch (JSONException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return "";
    }

    private String[] findAnswer(String title, String game_id) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String resultStr = null;
        Request request = (new Request.Builder()).url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/FindTheAnswer?title=" + title + "&game_id=" + game_id).get().build();
        Response response = client.newCall(request).execute();
        resultStr = response.body().string();
        resultStr = (new JSONTokener(resultStr)).nextValue().toString();
        JSONObject jsonObject = new JSONObject(resultStr);
        if (jsonObject.getString("data").equals("false")) {
            LtLog.i(this.mFairy.getLineInfo("-----------+++---------not title"));
            return null;
        } else {
            String arr = jsonObject.getString("data").replaceAll("\\[", "");
            arr = arr.replaceAll("\\]", "");
            arr = arr.replaceAll("\"", "");
            String[] array = arr.split(",");
            LtLog.i(this.mFairy.getLineInfo("-----------+++---------array=" + array));
            return array;
        }
    }

    private void UpAnswerAndTitle(String title, String answer, String game_id) throws InterruptedException {
        String resultStr = null;
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "title=" + title + "&game_id=" + game_id + "&answer=" + answer);
        Request request = (new Request.Builder()).url("http://API.padyun.com/Yunpai/V1/IntelligentAnswer/AddTitle").post(body).build();

        try {
            Response response = client.newCall(request).execute();
            resultStr = response.body().string();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        Thread.sleep(100L);
    }

    /*public static void main(String[] args) {
        int b = decrf(4);
        System.out.println(b);
    }

    public static int decrf(int n){
        if (n<=1){
            return n;
        }
        else {
            return decrf(n-1)+decrf(n-2);
        }
    }*/
}
