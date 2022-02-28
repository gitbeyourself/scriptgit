package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    FindResult result4;
    FindResult result5;
    GameUtil gameUtil;
    int count = 0;
    int num = 0;
    public static long midTime;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        Sleep = 100;
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }

    public void content_0() throws Exception {

    }

    /**
     * 新手指引（主线任务）
     *
     * @throws Exception
     */
    int n_err =0;
    public void plotTask() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                setTaskName(1);
            }
            /**
             * 主线任务
             * @throws Exception
             */
            @Override
            public void content_1() throws Exception {

                result = mFairy.findPic("skip22.png");
                mFairy.onTap(0.8f, result, "剧情跳过", 2000);
                result = mFairy.findPic("tiao.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic("set2.png");
                if(result.sim<0.8f){
                    result = mFairy.findPic(new String[]{"close66.png", "closes6.png", "closes7.png", "closes8.png", "YinglinHall_close.png", "Secret_close.png"});
                    mFairy.onTap(0.8f, result, "誓约关闭", 2000);
                }
                result = mFairy.findPic("oks1.png");
                mFairy.onTap(0.8f, result, "游戏视角确定", 2000);
                result = mFairy.findPic("pledge.png");
                mFairy.onTap(0.8f, result,1149,48,1179,71, "誓约关闭", 2000);
                result = mFairy.findPic(new String[]{"zhus1.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "迷失之所", Sleep);
//                    mFairy.onTap(0.8f, result, 1162, 9, 1201, 30, "跳过", Sleep);
                }
                result = mFairy.findPic("qi.png");
                if (result.sim > 0.95f) {
                    mFairy.onTap(0.8f, result, 80, 15, 121, 44, "关闭起源之地", 5000);
                }
                result = mFairy.findPic("shenmi.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 192, 130, 225, 159, "神秘树林", Sleep);
//                    mFairy.onTap(0.8f, result, 1117,3,1254,23, "跳过", Sleep);
                }
                result = mFairy.findPic("ai.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1164, 8, 1203, 33, "爱德华跳过", Sleep);

                }

                result = mFairy.findPic("ba.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1161, 16, 1190, 36, "巴伦德跳过", Sleep);
                }
                result = mFairy.findPic("skips1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "绿人跳过", Sleep);
                }

                result = mFairy.findPic(24,105,265,214,new String[]{"jibai2.png"});
                result = mFairy.findPic("lend.png");


                mFairy.onTap(0.8f, result, 986,122,1010,141, "关闭", Sleep);
                result = mFairy.findPic(5,138,216,178,"copy4.png");
                if(result.sim>0.8f){
                    result = mFairy.findPic(859,103,1088,345,"copy3.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "副本跳过", Sleep);
                    }
                }
                result = mFairy.findPic("closes90.png");
                mFairy.onTap(0.8f, result, "关闭", 2000);
                result = mFairy.findPic("gongs1.png");
                if (result.sim > 0.95f) {
                    mFairy.onTap(0.8f, result, 1129, 545, 1156, 581, "攻击", Sleep);
                }
                result = mFairy.findPic("shous2.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("tiaoss2.png");
                    mFairy.onTap(0.8f, result, "跳过", Sleep);
                    result = mFairy.findPic("gongji.png");
                    mFairy.onTap(0.8f, result, "攻击", Sleep);
                }
                result = mFairy.findPic("Questioning.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1138,6,1242,35, "执问者马洛尔跳过", Sleep);
                }
                result = mFairy.findPic(37,206,153,266,"ma.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("jineng.png");
                    mFairy.onTap(0.8f, result,  "马洛尔技能攻击1", Sleep);
                    result = mFairy.findPic(1089,509,1192,616,"gongji.png");
                    mFairy.onTap(0.8f, result,  "马洛尔技能攻击2", Sleep);
                }
                 long time = mFairy.mMatTime(1167,49,72,55,0.95f);
                 LtLog.e("***********************"+time);
                if(time>3){
                    n_err=0;
                    result = mFairy.findPic(new String[]{"zhus3.png", "ris.png"});
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "主线任务", 5000);
                    }
                }else{
                    n_err ++;
                    if(n_err>10){
                        result = mFairy.findPic(new String[]{"zhus3.png", "ris.png"});
                        if (result.sim > 0.8f) {
                            n_err=0;
                            mFairy.onTap(0.8f, result, "主线任务", 5000);
                        }
                    }
                }
                result = mFairy.findPic("continues1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "继续", Sleep);
                }
                result = mFairy.findPic("automatics1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "自动攻击", Sleep);
                }
                result = mFairy.findPic("gui.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1161, 12, 1212, 32, "归叶村长跳过", Sleep);
                }
                result = mFairy.findPic("tiaos5.png");
                mFairy.onTap(0.8f, result, "跳过", Sleep);
                result = mFairy.findPic("Howard.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1159, 9, 1197, 27, "霍华德跳过", Sleep);
                }
                result = mFairy.findPic("Lancia.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1159, 9, 1197, 27, "兰希娅跳过", Sleep);
                }
                result = mFairy.findPic("Jacob.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1159, 9, 1197, 27, "雅各布跳过", Sleep);
                }
                result = mFairy.findPic("open.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result,1205,502,1235,547, "装备", Sleep);
                }
                result = mFairy.findPic("qiangs1.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("closes1.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "装备关闭", Sleep);
                    }
                } else {
                    result = mFairy.findPic("strengthen.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "一键强化", 4000);
                    }
                    result = mFairy.findPic("stone.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 534, 440, 562, 464, "取消", Sleep);
                    } else {
                        result = mFairy.findPic("oks2.png");
                        mFairy.onTap(0.8f, result, "确定", Sleep);
                    }
                }
                result = mFairy.findPic(new String[]{"dianjis1.png", "ri.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "主英雷辛格", Sleep);
                }
                result = mFairy.findPic("airen.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 949, 538, 985, 572, "矮人族低估", Sleep);
                }
                result = mFairy.findPic("airen2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 956, 537, 980, 565, "矮人族复兴", Sleep);
                }
                result = mFairy.findPic("zhu1.png");//,"understand.png","fu.png"
                if (result.sim > 0.8f) {
//                    result = mFairy.findPic("Horseshoe.png");//,"understand.png","fu.png"
                    mFairy.onTap(0.8f, result, 161, 549, 189, 584, "马蹄按钮", Sleep);
                }
                result = mFairy.findPic("Allen.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "艾伦跳过", Sleep);
                }
                result = mFairy.findPic("yas1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 717, 611, 739, 626, "自动攻击", 5000);
//                    mFairy.onTap(0.8f, result,711,610,744,624,"", 5000);
                }
                result = mFairy.findPic("aier.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1142, 6, 1195, 28, "埃尔林妮", Sleep);
                }
                result = mFairy.findPic("money.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 762, 187, 776, 200, "充钱关闭", Sleep);
                }
                result = mFairy.findPic("Shelia.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1172, 13, 1209, 27, "希莉娅跳过", Sleep);
                }
                result = mFairy.findPic(11,207,145,270,"qis1.png");
                if(result.sim>0.8f){
                    result = mFairy.findPic(859,103,1088,345,"copy3.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "副本跳过", Sleep);
                    }
                }

                result = mFairy.findPic(407,198,897,337,"gonghui1.png");
                mFairy.onTap(0.8f, result, 478,402,491,410,"拒绝", Sleep);
                result = mFairy.findPic("wing.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "翅膀", Sleep);
                }
                result = mFairy.findPic(371,118,738,239,"chibang.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result,495,537,527,578, "翅膀", Sleep);
                }
                result = mFairy.findPic("shis3.png");
                if(result.sim>0.8f){
                    result = mFairy.findPic("tiaoguo.png");
                    mFairy.onTap(0.8f, result,"跳过", 2000);
                    result = mFairy.findPic("jiesuo.png");
                    mFairy.onTap(0.8f, result,"解锁挑战", 2000);
                }
                result = mFairy.findPic("19.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 586, 391, 623, 422, "19级解锁", 2000);
                    mFairy.onTap(0.8f, result, 1107, 107, 1134, 127, "关闭", 2000);
                }
                result = mFairy.findPic("28.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "28解锁", 2000);
                    mFairy.onTap(0.8f, result, 1107, 107, 1134, 127, "关闭", 2000);
                }
                result = mFairy.findPic("37.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "37级解锁", 2000);
                    mFairy.onTap(0.8f, result, 1107, 107, 1134, 127, "关闭", 2000);
                }
                result = mFairy.findPic("39.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "39级解锁", 2000);
                    mFairy.onTap(0.8f, result, 1107, 107, 1134, 127, "关闭", 2000);
                }
                result = mFairy.findPic("47.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "47级解锁", 2000);
                }
                result = mFairy.findPic("jihuo.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "激活翅膀", Sleep);
                }
                result = mFairy.findPic("gongxi.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 197, 542, 239, 559, "确认", Sleep);
                }

                result = mFairy.findPic("buy.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 74, 12, 120, 42, "限购返回", Sleep);
                }
                result = mFairy.findPic("awaken.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1015, 606, 1043, 628, "起飞", Sleep);
                    mFairy.onTap(0.8f, result, 1135, 483, 1169, 514, "上", Sleep);
//                    mFairy.onTap(0.8f, result, 1015,606,1043,628,"下", Sleep);
                }
                result = mFairy.findPic("closes2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1108, 111, 1131, 128, "关闭", Sleep);
                }
                result = mFairy.findPic("Maun.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "摩恩跳过", Sleep);
                }
                result = mFairy.findPic("uses1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 838, 391, 888, 407, "装备使用", Sleep);
                }
                result = mFairy.findPic("shi.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1119, 132, 1143, 165, "时装选中", Sleep);
                }
                result = mFairy.findPic("wear.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1114, 146, 1145, 161, "穿上", Sleep);
                }
                result = mFairy.findPic("closes3.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 83, 20, 116, 43, "装备关闭", Sleep);
                }
                result = mFairy.findPic("Terrier.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 83, 20, 116, 43, "特莉休跳过", Sleep);
                }
                result = mFairy.findPic(new String[]{"photograph.png"}); //"photograph1.png"
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 629, 211, 659, 240, "拍照", Sleep);
                }
                result = mFairy.findPic("here.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1203, 563, 1249, 594, "这里拍照", Sleep);
                }
                result = mFairy.findPic("backs1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 535, 642, 611, 665, "屏幕返回", Sleep);
                }
                result = mFairy.findPic("tui.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 70, 47, 111, 64, "退出拍摄模式", Sleep);
                    result = mFairy.findPic("backs2.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "退出", Sleep);
                    }
                }

                result = mFairy.findPic("magic.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 932, 30, 956, 53, "相册", Sleep);
                }
                result = mFairy.findPic("reward.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 380, 227, 410, 249, "相册奖励", Sleep);
                }
                result = mFairy.findPic(new String[]{"album.png","albums1.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1164,36,1202,68,"相册关闭", Sleep);
                }
                result = mFairy.findPic("qiri.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 996, 86, 1029, 132, "福利领取", Sleep);
                    mFairy.onTap(0.8f, result, 34, 221, 118, 254, "七日登录", Sleep);
                }
                result = mFairy.findPic(18,65,157,132,"everydays1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 76,14,114,41, "返回", Sleep);
                }
                result = mFairy.findPic(28,94,84,152,"skips3.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 76,14,114,41, "返回", Sleep);
                }
                result = mFairy.findPic("activitys3.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 975,207,1005,243, "活动跳过", Sleep);
                    mFairy.onTap(0.8f, result, 1171,39,1198,74, "活动关闭", Sleep);
                }
                result = mFairy.findPic(42,120,287,335,"yins1.png");
                if (result.sim > 0.8f) {
//                    result = mFairy.findPic(result1.x -154, result1.y - 1, result1.x -72, result1.y +27, "completes1.png");//229,271  75,270,157,298
                    mFairy.onTap(0.8f, result, "引", 1000);
                }
                result = mFairy.findPic("qianghua.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 934, 595, 1010, 620, "立即领取", Sleep);
                }
                result = mFairy.findPic("collected.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 84, 21, 116, 37, "关闭福利", Sleep);
                }
                mFairy.onTap(0.8f, result, 712, 528, 746, 553, "空白区域关闭", Sleep);
                result = mFairy.findPic("qiday.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 417, 147, 435, 172, "领取", Sleep);
                    mFairy.onTap(0.8f, result, 848, 173, 868, 206, "跳过", Sleep);
                    mFairy.onTap(0.8f, result, 74, 13, 116, 41, "关闭", Sleep);
                }
                result = mFairy.findPic("leixinge.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 89, 7, 117, 40, "关闭", Sleep);
                }

                result = mFairy.findPic(new String[]{"yinglins3.png","yinlin.png"});//new String[]{"yinglin2.png","yinglin.png"}
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "英灵殿", 2000);
                }
                result = mFairy.findPic("activity.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1006, 21, 1022, 42, "活动1", Sleep);
                }
                result = mFairy.findPic("tiaozhan.png");//"Challenges1.png"
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "挑战1", Sleep);
                }
                result = mFairy.findPic("Valhalla.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 511, 164, 561, 191, "参与", Sleep);
                }
                result = mFairy.findPic("Valhalla1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "挑战2", Sleep);
                }
                result = mFairy.findPic("01s1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1168, 81, 1198, 104, "关闭", 2000);
                }
                result = mFairy.findPic("Transfer.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 224, 200, 254, 225, "转职", Sleep);

                }
                result = mFairy.findPic("tiyan.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 224, 200, 254, 225, "转职", Sleep);
                    result = mFairy.findPic("Shelia.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 1172, 13, 1209, 27, "希莉娅跳过", Sleep);
                    }
                }

                result = mFairy.findPic("introduce.png");//,"skip00.png"
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 103, 331, 152, 345, "职业介绍", Sleep);
                    mFairy.onTap(0.8f, result, 682, 125, 727, 142, "介绍", Sleep);
                }
                result = mFairy.findPic("guanbis1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "职业介绍关闭", Sleep);
                }
                result = mFairy.findPic(563,71,727,117,"zhis1.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,972,55,1001,80, "职业介绍关闭", Sleep);
                }
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "职业介绍关闭", Sleep);
                }
                result = mFairy.findPic("transformation.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "转换", Sleep);
                }
//                result = mFairy.findPic(new String[]{"automatics2.png", "60s.png"});
//                if (result.sim > 0.8f) {
////                    mFairy.onTap(0.8f, result, 717, 612, 740, 624, "自动攻击", 20000);
//                }
                result = mFairy.findPic("tiyans.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 980, 212, 1007, 250, "跳过", 20000);
                }
                result = mFairy.findPic("right.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1216, 108, 1246, 145, "职业", Sleep);
                }
                result = mFairy.findPic("zhuanzhis1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "转职", Sleep);
                }
                result = mFairy.findPic("detailed.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 319, 550, 351, 569, "职业", Sleep);
                    mFairy.onTap(0.8f, result, 1052, 627, 1107, 645, "转职", Sleep);
                }
                result = mFairy.findPic("sanctuary.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 629, 526, 665, 557, "激活契约", Sleep);
                    result = mFairy.findPic("jixus1.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 723, 648, 746, 659, "点击屏幕子继续", Sleep);
                    }
                }

                result = mFairy.findPic("Zulu.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "祖鲁跳过", Sleep);
                }
                result = mFairy.findPic("Murphy.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "墨菲跳过", Sleep);
                }
                result = mFairy.findPic(356,483,799,597,"skills3.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result,1205,326,1251,374, "技能", Sleep);
                }
                result = mFairy.findPic("skillunlocker.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 816, 272, 850, 303, "技能解锁", Sleep);
                    result = mFairy.findPic("Challenge.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 912, 638, 951, 662, "前往挑战", Sleep);
                        result = mFairy.findPic("Challenge1.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, 861, 645, 907, 665, "开始挑战", Sleep);
                        }
                    }
                }
                result = mFairy.findPic("closes5.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 89, 16, 117, 35, "关闭", Sleep);
                }

                result = mFairy.findPic("gemstone.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1053, 328, 1083, 360, "装备", Sleep);
                }

                result = mFairy.findPic("set.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1129, 240, 1159, 272, "镶嵌", Sleep);
                }
                result = mFairy.findPic("baoshi.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1216,509,1248,545, "宝石", Sleep);
                    mFairy.onTap(0.8f, result, 1172, 40, 1197, 66, "关闭", Sleep);
                }
                result = mFairy.findPic("sets1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 953,179,1020,209, "宝石", Sleep);
                    result = mFairy.findPic("closess3.png");
                    mFairy.onTap(0.8f, result, "关闭", Sleep);
                }
//                result = mFairy.findPic("baoshi.png");
//                if (result.sim > 0.8f) {
//                    mFairy.onTap(0.8f, result, 971, 176, 1003, 211, "宝石", Sleep);
//                    mFairy.onTap(0.8f, result, 1172, 40, 1197, 66, "关闭", Sleep);
//                }
                result = mFairy.findPic(new String[]{"chiefs1.png", "chief.png"});
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 941, 22, 964, 45, "个人首领", Sleep);
                }
                result = mFairy.findPic("Unlockchallenge.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 895, 485, 964, 508, "解锁挑战", Sleep);
                }

                result = mFairy.findPic(611,243,933,513,"zhuo.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "捕捉宠物确定", Sleep);
                }
                result = mFairy.findPic(1032,229,1267,673,"equipments3.png");
                mFairy.onTap(0.8f, result, "装备", Sleep);
                result = mFairy.findPic("grepok.png");
                mFairy.onTap(0.8f, result, "宠物确定", Sleep);
                result = mFairy.findPic(384,513,851,596,"familiar.png");
                if (result.sim > 0.8f) {
//                    mFairy.onTap(0.8f, result, 1203,511,1247,546, "魔宠", Sleep);
                    result = mFairy.findPic(1032,229,1267,673,"familiars2.png");
                    mFairy.onTap(0.8f, result, "魔宠", Sleep);
                }
//                result = mFairy.findPic("familiars2.png");
//                if (result.sim > 0.8f) {
//                    mFairy.onTap(0.8f, result, "魔宠", Sleep);
//                }
                result = mFairy.findPic("canzhan.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 902, 603, 1009, 629, "参战", Sleep);
                }
                result = mFairy.findPic("set1.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 79, 38, 115, 65, "关闭", Sleep);
                }
                result = mFairy.findPic("Tira.png");
                mFairy.onTap(0.8f, result, 1133, 9, 1229, 33, "提拉跳过", Sleep);

                result = mFairy.findPic("Guild.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("Guilds1.png");
                    mFairy.onTap(0.8f, result, "公会", Sleep);

                }
                result = mFairy.findPic("zhuans1.png");
                if(result.sim>0.8f){
                    result = mFairy.findPic("leaves5.png");
                    mFairy.onTap(0.8f, result, "离开", Sleep);
                    result = mFairy.findPic("shis2.png");
                    mFairy.onTap(0.8f, result,792,391,862,414, "确定", Sleep);
                }

                result = mFairy.findPic("zuo.png");
                mFairy.onTap(0.8f, result, "关闭", Sleep);
                result = mFairy.findPic("apply.png");
                mFairy.onTap(0.8f, result, "一键申请", Sleep);
                result = mFairy.findPic(488,162,830,437,"fails1.png");
                LtLog.e("************"+result.sim);
                if(result.sim>0.3f){
                    result = mFairy.findPic("offs5.png");
                    mFairy.onTap(0.8f, result,  "公会关闭", Sleep);
                }
                result = mFairy.findPic("gonghui.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1172, 38, 1193, 62, "公会关闭", Sleep);
                }
                result = mFairy.findPic("Raysingh.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 201, 137, 233, 158, "雷辛格秘闻", Sleep);
                }
                result = mFairy.findPic("sui.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 685, 462, 703, 483, "随即点击", Sleep);
                    mFairy.onTap(0.8f, result, 822, 149, 846, 173, "关闭", Sleep);
                }
                result = mFairy.findPic("seal.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic(1032,229,1267,673,"Wars1.png");
                    mFairy.onTap(0.8f, result, "战印", Sleep
                    );
                }
                result = mFairy.findPic("Breach.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 991, 598, 1033, 626, "突破", Sleep);
                    mFairy.onTap(0.8f, result, 609, 496, 680, 522, "前往配置", Sleep);
                }
                result = mFairy.findPic("qianwang.png");
                mFairy.onTap(0.8f, result, 918, 640, 936, 653, "前往挑战", Sleep);
                mFairy.onTap(0.8f, result, 829, 639, 871, 661, "开始挑战", Sleep);
                result = mFairy.findPic("zb.png");
                mFairy.onTap(0.8f, result, 942, 643, 973, 664, "装备", Sleep);
                mFairy.onTap(0.8f, result, 84, 13, 109, 38, "返回", Sleep);
                result = mFairy.findPic("equipments2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 932, 17, 957, 41, "首领", Sleep);
                    mFairy.onTap(0.8f, result, 881, 485, 961, 512, "解锁挑战", Sleep);
                }
                result = mFairy.findPic("Naga.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "进入纳伽领地", Sleep);
                }

                result = mFairy.findPic("civilization.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1171, 12, 1232, 33, "文明铁炮手跳过", Sleep);
                }
                result = mFairy.findPic("Daikelulu.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1172, 11, 1227, 31, "戴可露露跳过", Sleep);
                }
                result = mFairy.findPic("sea.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1114, 624, 1145, 654, "挑战s", 3000);
                }
                result = mFairy.findPic("Successs.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 475, 523, 529, 538, "离开副本", Sleep);
                }
                result = mFairy.findPic("guanbis2.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1141, 51, 1177, 82, "关闭", Sleep);
                }
                result = mFairy.findPic("tiaozhans1.png");
                mFairy.onTap(0.8f, result, "挑战", 2000);
                result = mFairy.findPic("Experience.png");//new String[]{"yinglin2.png","yinglin.png"}
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 130, 130, 171, 153, "英灵殿刺客之王", 2000);
                }

                result = mFairy.findPic("tixing.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 534, 391, 574, 412, "取消", 2000);
                }
                result = mFairy.findPic(56,391,322,695,"storm.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }

            /**
             * 副本
             * @throws Exception
             */
            @Override
            public void content_3() throws Exception {

//                overtime(6,2);
//
//                mFairy.taskSlid(err,new int[] {2,4,6},0,529,488,503,202,2000,1500);
            }
        }.taskContent(mFairy, "新手指引");
    }

    /**
     * 日常
     * 工会捐献(单人)
     *
     * @throws Exception
     */
    public void contributions() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String donate = "donate.png";
                int mission = gameUtil.mission(donate, 0);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }

            }

            @Override
            public void content_2() throws Exception {
                result1 = mFairy.findPic("shouji.png");
                if(result1.sim>0.8f){
                    result = mFairy.findPic(new String[]{"zhuang2.png", "pretend.png"});
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "购买装填", 2000);
                    }
                    result = mFairy.findPic("wan.png");
                    if (result.sim > 0.95f) {
                        LtLog.e("kkk" + result.sim);
                        mFairy.onTap(0.95f, result, "完成搜集", 2000);
                        result = mFairy.findPic("full.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.95f, result, 810, 401, 836, 415, "确定", 3000);
                        }
                        result1 = mFairy.findPic("wan.png");
                        if (result1.sim < 0.95f) {
                            setTaskEnd();
                            return;
                        }
                     }
                }else{
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "工会捐献");
    }

    /**
     * 日常
     * 竞技场(单人)
     *
     * @throws Exception
     */
    public void arena() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String sports = "sports4.png";
                int mission = gameUtil.mission(sports, 0);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
            }

            /**
             * 单人竞技场
             * @throws Exception
             */
            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("history.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 624, 489, 657, 512, "历史最高离开", 3000);
                }
                result = mFairy.findPic("sports3.png");
                mFairy.onTap(0.8f, result, "竞技场", 3000);
                result2 = mFairy.findPic("arena.png");
                result1 = mFairy.findPic("appoint.png");
                if (result2.sim > 0.8f && result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result1, "竞技场", 3000);
                    result = mFairy.findPic("determine.png");
                    mFairy.onTap(0.8f, result, "确定", 1000);
                    result = mFairy.findPic("likai.png");
                    mFairy.onTap(0.8f, result, 617, 492, 645, 510, "离开", 2000);
                    result = mFairy.findPic("consume.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 478, 394, 502, 412, "离开", 2000);
                        mFairy.onTap(0.8f, result, 1171, 44, 1194, 63, "竞技场关闭", 2000);
                        setTaskName(0);
                        return;
                    }
                }
                if (result2.sim > 0.8f) {
                    mFairy.onTap(0.8f, result2, 219, 335, 231, 355, "竞技场", 3000);
                    result = mFairy.findPic("determine.png");
                    mFairy.onTap(0.8f, result, "确定", 1000);
                    result = mFairy.findPic("likai.png");
                    mFairy.onTap(0.8f, result, 617, 492, 645, 510, "离开", 2000);
                    result = mFairy.findPic("consume.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 478, 394, 502, 412, "离开", 2000);
//                        mFairy.onTap(0.8f, result,1171,44,1194,63, "竞技场关闭", 2000);
                    }
                }
                result = mFairy.findPic("Zero1.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "竞技场");
    }

    /**
     * 日常
     * 雷辛格秘闻(单人)
     *
     * @throws Exception
     */
    public void Raysingh() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                init();
                Thread.sleep(1000);
                result = mFairy.findPic(40, 108, 334, 368, "ri.png");
                if (result.sim > 0.8f) {
                    err=0;
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("*****************"+time);
                    if(time>=2){
                        mFairy.onTap(0.8f, result, "雷辛格秘闻", 2000);
                    }
                }
                    result = mFairy.findPic("lists2.png");
                    mFairy.onTap(0.8f, result, "任务列表", 1000);

                mFairy.taskSlid(err, new int[]{2,4, 6, 8,10}, 3, 127,350, 127,131 , 2000, 1500);
                result = mFairy.findPic("jixu.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "继续", 2000);
                }
                result = mFairy.findPic(502,248,797,365,"ends2.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                if (overtime(12, 2)) return;//计次并跳转
            }

            @Override
            public void content_2() throws Exception {
                String lei = "lei.png";
                int mission = gameUtil.mission(lei, 0);
                if (mission == 0) {
                    setTaskEnd();
                    return;
                }else{
                    setTaskName(1);
                }


                result = mFairy.findPic("ends1.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "雷辛格秘闻");
    }

    /**
     * 日常
     * 无尽深渊(单人)
     *
     * @throws Exception
     */
    public void endless() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String endless_abyss = "endless_abyss.png";
                int mission = gameUtil.mission(endless_abyss, 2);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                LtLog.e("无尽深渊(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("oks3.png");
                mFairy.onTap(0.8f, result, "确定", 2000);
                result = mFairy.findPic("endless1.png");//273,166     483,159,593,193
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1039, 622, 1099, 655, "挑战", 1000);
                }
                result = mFairy.findPic("fail.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 457, 446, 541, 467, "离开副本", 2000);
                }
                result = mFairy.findPic("dengji.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 473,517,526,537, "离开副本", 2000);
                }
                result = mFairy.findPic("change.png");
                LtLog.e("sssssssssss" + result.sim);
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1160, 38, 1181, 62, "关闭", 2000);
                    result = mFairy.findPic("Mops1.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "扫荡", 2000);
                        result = mFairy.findPic("determine2.png");
                        mFairy.onTap(0.8f, result, "扫荡确定", 2000);
                        result = mFairy.findPic("Zeros8.png");
                        LtLog.e("fffffffffffff" + result.sim);
                        if (result.sim > 0.8f) {
                            setTaskEnd();
                            return;
                        }
                    }
                }
                result2 = mFairy.findPic(545,198,659,398,"bu.png");
                result = mFairy.findPic("Zeros8.png");
                result1 = mFairy.findPic(505,168,566,406,"tiaos7.png");
                if (result.sim > 0.8f || result1.sim>0.8f ||result2.sim>0.75f) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "无尽深渊");
    }

    /**
     * 日常
     * 英林殿(单人)
     *
     * @throws Exception
     */
    public void YinglinHall() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String Valhallas = "Valhallas1.png";
                int mission = gameUtil.mission(Valhallas, 2);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("zeros9.png");
                if (result.sim > 0.8f) {
                   setTaskEnd();
                   return;
                }
                if (result.sim < 0.8f) {
                    result = mFairy.findPic("duel.png");
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }
            }
        }.taskContent(mFairy, "英林殿");
    }

    /**
     * 日常
     * 大秘境(单人)
     *
     * @throws Exception
     */
    public void Secret() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String Secret = "Secret.png";
                int mission = gameUtil.mission(Secret, 2);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                LtLog.e("大秘境(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("Zeros4.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                } else {
                    result = mFairy.findPic("start.png");
                    mFairy.onTap(0.8f, result, "开始游戏", 3000);
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap(164,561,170,569,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "大秘境");
    }

    /**
     * 日常
     * 女神宝藏(单人)
     *
     * @throws Exception
     */
    public void treasure() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String house = "house.png";
                int mission = gameUtil.mission(house, 3);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                LtLog.e("女神宝藏(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("right3.png");
                mFairy.onTap(0.8f, result, "点击事件", 2000);
                result = mFairy.findPic("maps3.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "宝图任务", 2000);
                }
                result = mFairy.findPic(42,637,294,706, "bai.png");
                LtLog.e("*****************"+result.sim);
                if(result.sim>0.8f){
                    err=0;
                }
                result = mFairy.findPic("Submit.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "提交", 2000);
                }
                result = mFairy.findPic("tasks1.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("zhua.png");
                mFairy.onTap(0.8f, result, "搜寻宝图", 2000);

                    result = mFairy.findPic(38,118,289,366,"Treasures1.png");
                    if(result.sim>0.8f){
                        err=0;
                        mFairy.onTap(0.8f, result, "宝图", 6000);
                    }else {
//                    err=0;
                        mFairy.taskSlid(err, new int[]{2,4,6, 8, 10}, 3, 127,320, 127,131 , 2000, 1500);
                    }
                if (overtime(12, 1)) return;//计次并跳转
            }
        }.taskContent(mFairy, "女神宝藏");
    }

    /**
     * 日常
     * 星运(单人)
     *
     * @throws Exception
     */
    public void Nebula() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String Astrology = "Astrology.png";
                int mission = gameUtil.mission(Astrology, 3);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
//                result = mFairy.findPic("Pisces.png");
//                mFairy.onTap(0.8f, result, "双鱼", 2000);
            }
        }.taskContent(mFairy, "星运");
    }

    /**
     * 日常
     * 个人首领(单人)
     *
     * @throws Exception
     */

    int chief = 0;

    public void chief() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                LtLog.e("返回值"+mission);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {

                result1 = mFairy.findPic("Zeros2.png");
                result2 = mFairy.findPic("Insufficients2.png");
                result3 = mFairy.findPic("moneys2.png");
                if (result2.sim > 0.8f||result1.sim>0.8f||result3.sim>0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(new String[]{"Challenges4.png", "solution.png"});
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, "解锁挑战", 4000);
                    result = mFairy.findPic(519,241,592,303,"twos3.png");
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic(652,421,829,502,"querens1.png");
                        mFairy.onTap(0.8f, result, "确认", 2000);
                    }
                }

                result = mFairy.findPic("blame.png");
                if(result.sim<0.8f){
                    result = mFairy.findPic("leaves2.png");
                    if (result.sim < 0.8f) {
                        chief++;
                        if (chief > 10) {
                            setTaskName(0);
                            return;
                        }
                    } else {
                        chief = 0;
                    }
                }

                result = mFairy.findPic("rukou.png");
                mFairy.onTap(0.8f, result, "入口复活", 2000);

                if(gameUtil.dazeTime()>20){
                    mFairy.onTap(106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "首领");
    }
    /**
     * 日常
     * 野外首领默认
     *
     * @throws Exception
     */
    public void chief1() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                LtLog.e("_______________________+"+result1.sim);
                if (result1.sim > 0.72f) {
                    err=0;
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248  242,118,334,355
                            LtLog.e("-----------------"+result.sim);
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "默认");
    }
    /**
     * 日常
     * 不执行
     *
     * @throws Exception
     */
    public void chief2() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                setTaskEnd();
                return;
            }
        }.taskContent(mFairy, "不执行");
    }
    /**
     * 日常
     * 野外首领(单人) 沉睡深林
     *
     * @throws Exception
     */
    public void chief3() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "sleep.png");
                result2 = mFairy.findPic(65, 474, 715, 524, "sleep1.png");
                LtLog.e("********************"+result.sim+"**********"+result2.sim);
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "沉睡深林", 2000);
                    setTaskName(3);
                    err =0;
                }
                if (result2.sim>0.8f) {
                    mFairy.onTap(0.8f, result2, "沉睡深林", 2000);
                    setTaskName(3);
                    err =0;
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(8, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f){//||result2.sim>0.8f
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    err=0;
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248  242,118,334,355
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 起源之地
     *
     * @throws Exception
     */
    public void chief4() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }
            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "origin.png");
                result1 = mFairy.findPic(65, 474, 715, 524, "origin1.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "起源之地", 2000);
                    setTaskName(3);
                }
                if (result1.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result1, "起源之地", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(8, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    err=0;
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 凯旋平原
     *
     * @throws Exception
     */
    public void chief5() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "Triumph.png");
                result1 = mFairy.findPic(65, 474, 715, 524, "Triumph1.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "凯旋平原", 2000);
                    setTaskName(3);
                }
                if (result1.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result1, "凯旋平原", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(8, 0);
                return;

            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                LtLog.e("-----------"+result1.sim);
                if (result1.sim > 0.72f) {
                    err=0;
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(252,154,328,326, "Refresh.png");//118,366   260,221,325,248
                            LtLog.e("++++++++++++++++++++++++++"+result.sim);
                            mFairy.onTap(0.7f, result, "刷新", Sleep);
//                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 自由群岛
     *
     * @throws Exception
     */
    public void chief6() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "free.png");
                result2 = mFairy.findPic(65, 474, 715, 524, "free2.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "自由群岛", 2000);
                    setTaskName(3);
                }
                if (result2.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result2, "自由群岛", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(8, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    err=0;
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 深渊之底
     *
     * @throws Exception
     */
    public void chief7() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f ||result2.sim>0.8f){//
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "abyss1.png");
                result2 = mFairy.findPic(65, 474, 715, 524, "abyss2.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "深渊之底", 2000);
                    setTaskName(3);
                }
                if (result2.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result2, "深渊之底", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3,  468, 508, 186, 509,2000, 1500);
                overtime(8, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap(106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 辉黯双城
     *
     * @throws Exception
     */
    public void chief8() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "Dim.png");
                result2 = mFairy.findPic(65, 474, 715, 524, "Dim1.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "辉黯双城", 2000);
                    setTaskName(3);
                }
                if (result2.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result2, "辉黯双城", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(8, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 秩序高地
     *
     * @throws Exception
     */
    public void chief9() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "order.png");
                result2 = mFairy.findPic(65, 474, 715, 524, "order1.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "秩序高地", 2000);
                    setTaskName(3);
                }
                if (result2.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result2, "秩序高地", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(8, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                 result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 2000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 野外首领(单人) 冰风谷
     *
     * @throws Exception
     */
    public void chief10() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                chief = 0;
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String chief = "chiefs2.png";
                int mission = gameUtil.mission(chief, 2);
                if (mission == 1) {
                    result = mFairy.findPic("fields1.png");
                    mFairy.onTap(0.8f, result, 1217, 203, 1253, 246, "野外", 2000);
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("lock.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(54,653,247,694, "Percent.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("过图中"));
                    err = 0;
                }
                result = mFairy.findPic(65, 474, 715, 524, "ices2.png");
                result2 = mFairy.findPic(65, 474, 715, 524, "ices1.png");
                if (result.sim > 0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result, "冰风谷", 2000);
                    setTaskName(3);
                }
                if (result2.sim>0.8f) {
                    err =0;
                    mFairy.onTap(0.8f, result2, "冰风谷", 2000);
                    setTaskName(3);
                }
                mFairy.taskSlid(err, new int[]{2, 4, 6}, 3, 468, 508,186, 509,  2000, 1500);
                overtime(10, 0);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic("Zeros6.png");
                result2 = mFairy.findPic("Zeros7.png");
                if(result1.sim>0.8f||result2.sim>0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Challenges5.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    chief++;
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }
                if(chief>=4){
                    LtLog.e("复活"+chief+"次,任务结束");
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("shous1.png");
                mFairy.onTap(0.8f, result, "首领列表", Sleep);
                result1 = mFairy.findPic(46, 119, 335, 408, "lists1.png");
                if (result1.sim > 0.72f) {
                    result = mFairy.findPic("blame.png");
                    LtLog.e("*************"+result.sim);
                    long time = mFairy.mMatTime(1160,40,93,70,0.95f);
                    LtLog.e("********************"+time);
                    if(time>3){
                        if(result.sim<0.8f){
                            result = mFairy.findPic(242,118,334,355, "Refresh.png");//118,366   260,221,325,248
                            mFairy.onTap(0.7f, result, "刷新", 20000);
                            LtLog.e("*//*******//*" + (result1.x + 142) + "," + (result1.y - 155) + "," + (result1.x + 207) + "," + (result1.y - 118));
                        }
                    }
                }
                result1 = mFairy.findPic(429,163,882,377, "unable.png");
                if (result1.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                if(gameUtil.dazeTime()>20){
                    mFairy.onTap( 106,541,201,602,"图像识别点击", 1000);
                    gameUtil.fadTime=0L;
                }
            }
        }.taskContent(mFairy, "野外首领");
    }

    /**
     * 日常
     * 要塞任务  count 3次进行关闭 可能会多出其他工会任务
     *
     * @throws Exception
     */
    public void fort() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String fort = "fortress.png";
                int mission = gameUtil.mission(fort, 0);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic( "fortress2.png");
                if(result.sim>0.8f){
                    result1 = mFairy.findPic(473,49,1181,622, "familiars1.png");// 寄样魔宠
                    result2 = mFairy.findPic(473,49,1181,622, "Monsters2.png");//讨伐魔物
                    result3 = mFairy.findPic(473,49,1181,622, "steals1.png"); //窃取资源
                    result5 = mFairy.findPic(473,49,1181,622,"familiars3.png");//魔宠挂机
                    if (result2.sim > 0.8f) {
                        count++;
                        result = mFairy.findPic(result2.x - 12, result2.y + 220, result2.x + 88, result2.y + 252, "pick.png");//549,84  537,304,637,336
                        mFairy.onTap(0.8f, result, "接取1", 1000);
                        LtLog.e("/*******/" + (result2.x - 12) + "," + (result2.y + 220) + "," + (result2.x + 88) + "," + (result2.y + 252) + "----------------------" + count);
                    }
                    if (result1.sim>0.8f) {
                        count++;
                        result = mFairy.findPic(result1.x -12, result1.y + 220, result1.x + 88, result1.y + 252, "pick.png");//549,84  537,304,637,336
                        mFairy.onTap(0.8f, result, "接取3", 1000);
                        LtLog.e("/*******/" + (result1.x -12) + "," + (result1.y + 220) + "," + (result1.x + 88) + "," + (result1.y + 252) + "----------------------" + count);
                    }
                    if (result3.sim>0.8f) {
                        count++;
                        result = mFairy.findPic(result3.x -12, result3.y + 220, result3.x + 88, result3.y + 252, "pick.png");//549,84  537,304,637,336
                        mFairy.onTap(0.8f, result, "接取4", 1000);
                        LtLog.e("/*******/" + (result3.x -12) + "," + (result3.y + 220) + "," + (result3.x + 88) + "," + (result3.y + 252) + "----------------------" + count);
                    }
                    if (result5.sim>0.8f) {
                        count++;
                        result = mFairy.findPic(result5.x -12, result5.y + 220, result5.x + 88, result5.y + 252, "pick.png");//549,84  537,304,637,336
                        mFairy.onTap(0.8f, result, "接取6", 1000);
                        LtLog.e("/*******/" + (result5.x -12) + "," + (result5.y + 220) + "," + (result5.x + 88) + "," + (result5.y + 252) + "----------------------" + count);
                    }
                    result = mFairy.findPic(473,49,1181,622, "stealls2.png");// 毁坏建筑
                    if (result.sim>0.8f) {
                        count++;
                        result = mFairy.findPic(result.x -12, result.y + 220, result.x + 88, result.y + 252, "pick.png");//549,84  537,304,637,336
                        mFairy.onTap(0.8f, result, "接取5", 1000);
                        LtLog.e("/*******/" + (result.x -12) + "," + (result.y + 220) + "," + (result.x + 88) + "," + (result.y + 252) + "----------------------" + count);
                    }
                }else{
                    setTaskEnd();
                    return;
                }

                overtime(6,4);

            }
            @Override
            public void content_4() throws Exception {
                result = mFairy.findPic("offs1.png");
                mFairy.onTap(0.8f, result, "关闭", 1000);
                setTaskName(3);
                return;
            }

            @Override
            public void content_3() throws Exception {
                result = mFairy.findPic(42,637,294,706, "bai.png");
                LtLog.e("*****************"+result.sim);
                if(result.sim>0.8f){
                    err=0;
                }
                result = mFairy.findPic(519,489,768,593, "zidongs4.png");
                LtLog.e("*****************"+result.sim);
                if(result.sim>0.8f){
                    err=0;
                }
                //讨伐魔物
                result = mFairy.findPic(37, 117, 283, 363, "Monsters3.png");
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, "讨伐魔物", 10000);
                    result = mFairy.findPic( "zidongs3.png");
                    mFairy.onTap(0.8f, result, "自动战斗", 5000);
                }
                result = mFairy.findPic( 431,63,903,410,"successs2.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result,734,610,755,620, "点击取消自动战斗", 10000);
                    result = mFairy.findPic(519,489,768,593, "zidongs4.png");
                    if(result.sim<0.8f){
                        result = mFairy.findPic("list.png");
                        mFairy.onTap(0.8f, result, "任务列表", 1000);

                    }
                }

                //窃取资源
                result = mFairy.findPic(37, 117, 283, 363, "steal.png");
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, "窃取资源", 10000);
                    result = mFairy.findPic( "stones1.png");
                    mFairy.onTap(0.8f, result, "资源", 5000);
                }

                //毁坏建筑
                result = mFairy.findPic(37, 117, 283, 363, "steals3.png");
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, "毁坏建筑", 5000);
                    result = mFairy.findPic("destroy.png");
                    mFairy.onTap(0.8f, result, "开始毁坏", 1000);

                }
                result = mFairy.findPic("list.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "任务列表", 1000);
                }


                result = mFairy.findPic("visit.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "访问要塞", 1000);
                    result = mFairy.findPic("cannels2.png");
                    LtLog.e("dssssssss" + result.sim);
                    if (result.sim > 0.8f) {
                        result = mFairy.findPic("map.png");
                        if (result.sim > 0.8f) {
                            mFairy.onTap(0.8f, result, 1188, 40, 1214, 71, "点击地图", 1000);
                        }
                    }
                    result = mFairy.findPic("Architectures1.png");
                    mFairy.onTap(0.8f, result, 422, 295, 440, 314, "建筑", 20000);
                }
                //寄养魔宠
                result = mFairy.findPic(37, 117, 283, 363,"foster.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "寄养魔宠", 1000);
                    result = mFairy.findPic("adds1.png");
                    mFairy.onTap(0.8f, result, "添加", 1000);
                    result = mFairy.findPic("querens2.png");
                    mFairy.onTap(0.8f, result, "确定", 1000);
                }
                result = mFairy.findPic("forwards1.png");
                if(result.sim>0.8f){
                    err=0;
                    result = mFairy.findPic("offs4.png");
                    mFairy.onTap(0.8f, result, "关闭", 1000);
                }
                result = mFairy.findPic("collar.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "领取经验", 1000);
                    result = mFairy.findPic("querens5.png");
                    mFairy.onTap(0.8f, result, "确认", 1000);
                }
                //魔宠挂机
                result = mFairy.findPic(37, 117, 283, 363,"Hangs3.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "寄养魔宠", 1000);
                }else{
                    mFairy.taskSlid(err, new int[]{6, 8, 10}, 3, 151, 340, 209, 152, 2000, 1500);
                }
                result = mFairy.findPic("mo.png");
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, 1125, 254, 1163, 279, "挂机", 1000);
                    result = mFairy.findPic("add.png");
                    mFairy.onTap(0.8f, result, "选择魔宠", 1000);
                    result = mFairy.findPic("querens4.png");
                    if(result.sim>0.95f){
                        mFairy.onTap(0.8f, result, "确定", 1000);
                    }else{
                        result = mFairy.findPic("offs6.png");
                        mFairy.onTap(0.8f, result,"活动关闭右", 1000);
                        setTaskEnd();
                    }
                }
                result = mFairy.findPic("Hangs2.png");
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, "派遣挂机", 1000);
                }
                if (result.sim <0.8f) {
                    err=0;
                    result = mFairy.findPic("offs4.png");
                    mFairy.onTap(0.8f, result, "关闭", 1000);
                }
                mFairy.taskSlid(err, new int[]{4, 6, 8}, 3, 151, 340, 209, 152, 2000, 1500);
                overtime(10,0);
            }
        }.taskContent(mFairy, "要塞任务");
    }
    /**
     * 日常
     * 时光回廊
     *
     * @throws Exception
     */
    public void time() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {
              setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String time = "time.png";
                int mission = gameUtil.mission(time, 0);
                if (mission == 1) {
                    setTaskName(2);
                } else {
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("battles1.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }
                result = mFairy.findPic( "leaves2.png");
                result2 = mFairy.findPic( "zidongs6.png");
                LtLog.e("***********************自动战斗"+result2.sim+"---------离开"+result.sim);

                if (result2.sim<0.8f&&result.sim<0.8f) {
                    err=0;
                    long time = mFairy.mMatTime(1154,48,88,60, 0.95f);
                    LtLog.e("***************" + time);
                    if (time > 3) {
                        setTaskName(0);
                    }

                }
                result = mFairy.findPic(519,489,768,593, "zidongs6.png");
                LtLog.e("*****************"+result.sim);
                if(result.sim<0.8f){
                    mFairy.onTap(0.8f, result, 730,608,753,624,"自动战斗", 2000);
                }
                result = mFairy.findPic("resurrections2.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 2000);
                }

                result = mFairy.findPic("leaves4.png");
                mFairy.onTap(0.8f, result, "离开", 2000);

                result = mFairy.findPic("fail2.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "时光回廊");
    }
    /**
     * 雷辛格秘闻初始化
     *
     * @throws Exception
     */

        public void init() throws Exception {
            result = mFairy.findPic("zidong.png");
            if(result.sim>0.8f){
                mFairy.onTap(0.8f, result,737,614,749,621, "自动攻击关闭", 2000);
            }
            result = mFairy.findPic(new String[]{"close66.png","closes6.png","closes7.png","closes8.png","YinglinHall_close.png","Secret_close.png","offs3.png","yous2.png","right_close.png"});
            mFairy.onTap(0.8f, result,"活动关闭右", 1000);
            result = mFairy.findPic("into.png");
            if(result.sim>0.8f){

            }else{
                result = mFairy.findPic(new String[]{"lefts1.png"});
                mFairy.onTap(0.8f, result,"活动关闭左", 1000);
            }

            result = mFairy.findPic("change.png");
            mFairy.onTap(0.8f, result,1160,38,1181,62,"关闭", 2000);
            result = mFairy.findPic("ok000.png");
            if(result.sim>0.8f){
                mFairy.onTap(0.8f, result, 633,444,678,466,"确定", 1000);
            }
        }
    /**
     * 60秒倒计时
     */
    public void time2() throws Exception{
        midTime=60;
        while (midTime > 0) {
            midTime--;
            long ss = midTime % 30;
            LtLog.e("还剩" + ss + "秒");
            if(ss==0){
                try {
                        mFairy.onTap(106,541,201,602,"图像识别点击", 3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }
