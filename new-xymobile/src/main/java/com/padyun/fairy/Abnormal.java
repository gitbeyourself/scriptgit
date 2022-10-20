package com.padyun.fairy;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;


import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;
import com.script.opencvapi.AtFairyConfig;
import com.script.framework.TaskContent;
import com.script.framework.AtFairyImpl;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.sql.SQLOutput;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;


    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    int count_1 = 0;
    long i = 0;
    String task_id = AtFairyConfig.getOption("task_id");

    //全局处理
    public void erro() throws Exception {
//            mFairy.sleep(1000);


        result = mFairy.findPic("gg.png");
        mFairy.onTap(0.8f, result, 1209, 323, 1218, 331, "err关闭误点相片分享", Sleep);

        result = mFairy.findPic("High fold.png");
        mFairy.onTap(0.8f, result, 636, 433, 648, 442, "err确认高倍", Sleep);

        result = mFairy.findPic("teacher.png");
        mFairy.onTap(0.8f, result, 506, 443, 516, 452, "err关闭拜师弹窗", Sleep);

        result = mFairy.findPic("kapai.png");
        mFairy.onTap(0.8f, result, 1204, 438, 1212, 444, "err关闭获得卡牌得广告弹窗", Sleep);

        result = mFairy.findPic("grass.png");
        mFairy.onTap(0.8f, result, 1010, 149, 1023, 162, "err关闭广告弹窗", Sleep);

        result = mFairy.findPic("jinjie.png");
        mFairy.onTap(0.8f, result, 1106, 514, 1118, 524, "err颜色进阶知道了", Sleep);

        result = mFairy.findPic(393, 291, 824, 407, "xiufu.png");
        mFairy.onTap(0.8f, result, 639, 437, 649, 447, "err修复完成确定", Sleep);

        result = mFairy.findPic(new String[]{"friend2.png", "huigui.png"});
        mFairy.onTap(0.8f, result, 1068, 71, 1082, 83, "err号回好友叉", Sleep);

        result = mFairy.findPic("shenmo2.png");
        mFairy.onTap(0.8f, result, 559, 666, 567, 672, "err不再提示", Sleep);
        mFairy.onTap(0.8f, result, 1084, 78, 1093, 87, "err叉", Sleep);

        result = mFairy.findPic("me.png");
        mFairy.onTap(0.9f, result, 1109, 45, 1116, 58, "关闭", Sleep);

        result = mFairy.findPic(1162, 593, 1208, 718, "dialogue.png");
        mFairy.onTap(0.8f, result, "err对话", Sleep);

        result = mFairy.findPic(741, 9, 1269, 344, "nodiren.png");
        mFairy.onTap(0.8f, result, 1065, 179, 1074, 190, "err没有敌人遮挡", Sleep);

        result = mFairy.findPic("erpaizhao.png");
        mFairy.onTap(0.8f, result, 42, 652, 72, 671, "er拍照模式", Sleep);

        result = mFairy.findPic(904, 211, 1066, 257, "jujue.png");
        mFairy.onTap(0.8f, result, "err拒绝语音", Sleep);

        result = mFairy.findPic("errBackpack.png");
        mFairy.onTap(0.8f, result, 514, 438, 515, 439, "err背包满", Sleep);

        result = mFairy.findPic(858, 480, 1035, 539, "use.png");
        mFairy.onTap(0.8f, result, "err自动使用", Sleep);

        result = mFairy.findPic(340, 223, 927, 624, "smSure.png");
        mFairy.onTap(0.8f, result, "err奖励确认", Sleep);

        result = mFairy.findPic(363,259,920,487, "cxlj.png");
        mFairy.onTap(0.8f, result, 770,436,780,443,"重新连接确定", Sleep);

        result = mFairy.findPic("unclaimed.png");
        mFairy.onTap(0.8f, result, 490, 516, 499, 525, "err奖励未领取，退出", Sleep);

        result = mFairy.findPic("bagman.png");
        mFairy.onTap(0.8f, result, 630, 435, 671, 451, "err背包满1", Sleep);

        result = mFairy.findPic("death.png");
        if (picCount(0.8f, result, "err复活") > 5) {
            mFairy.onTap(0.8f, result, "err复活", Sleep);
        }
        result = mFairy.findPic(303, 254, 1014, 567, "errquxiao.png");
        if (picCount(0.8f, result, "err取消") > 25) {
            mFairy.onTap(0.8f, result, "err取消", Sleep);
        }

          /*  result = mFairy.findPic("xmqjinface.png");
            if (result.sim > 0.8f) {
                List<FindResult> listResult = mFairy.findPic(795, 133, 1002, 593, 0.8f, "xmqjUse111.png");
                if (listResult.size() != 0) {
                    mFairy.onTap(0.8f, listResult.get(0), listResult.get(0).x, listResult.get(0).y, listResult.get(0).x + 1, listResult.get(0).y + 1, "err清剿使用", Sleep);
                    mFairy.onTap(0.8f, result, 1031, 122, 1049, 139, "err关闭清剿界面", Sleep);
                }
            }*/

        result = mFairy.findPic("xmqjinface.png");
        if (result.sim > 0.8f) {
            result = mFairy.findPic(754, 211, 994, 336, "xmqjUse111.png");
            if (result.sim > 0.8f) {
                mFairy.onTap(0.8f, result, "err 清剿使用", Sleep);
                mFairy.onTap(0.8f, result, 1031, 122, 1049, 139, "err关闭清剿界面", Sleep);
            }
        }

        result = mFairy.findPic("qxComplete.png");
        mFairy.onTap(0.8f, result, "err七星完成任务", Sleep);

        //七星秘宝 弹窗 四星以上 不包含
        result1 = mFairy.findPic("qxAccept.png");
        if (result1.sim > 0.8f) {
            result2 = mFairy.findPic("gblianbao.png");
            if (result2.sim > 0.8f) {
                LtLog.e(mFairy.getLineInfo(0.8f, result2, "gaobei++++++++++++++++"));
                if (!AtFairyConfig.getOption("lbsx").equals("1") && !AtFairyConfig.getOption("lbsx").equals("")) {
                    if (AtFairyConfig.getOption("lbsx").equals("2")) {
                        // result = mFairy.findPic(815, 446, 876, 519, "lianbaoStar.png");
                        i = mFairy.getColorNum(840, 479, 852, 491, "14,10,11", 0.92f);
                        //long i =  mFairy.getColorNum(1080,478,1092,492,"14,10,11",0.92f);
                        LtLog.e("*********4星" + i);
                        //LtLog.e(mFairy.getLineInfo(0.8f, result, "没有到4星"));
                    } else if (AtFairyConfig.getOption("lbsx").equals("3")) {
                        i = mFairy.getColorNum(918, 479, 935, 493, "14,10,11", 0.92f);
                        //long i =  mFairy.getColorNum(1080,478,1092,492,"14,10,11",0.92f);
                        LtLog.e("*********5星" + i);
                    } else if (AtFairyConfig.getOption("lbsx").equals("4")) {
                        i = mFairy.getColorNum(999, 480, 1013, 492, "14,10,11", 0.92f);
                        //long i =  mFairy.getColorNum(1080,478,1092,492,"14,10,11",0.92f);
                        LtLog.e("*********6星" + i);
                    } else if (AtFairyConfig.getOption("lbsx").equals("5")) {
                        // i =  mFairy.getColorNum(840,479,852,491,"14,10,11",0.92f);
                        i = mFairy.getColorNum(1080, 478, 1092, 492, "14,10,11", 0.92f);
                        LtLog.e("*********7星" + i);
                    }
                    if (i >= 90) {
                        mFairy.onTap(583, 627, 623, 647, "err刷新", Sleep);
                    } else {
                        mFairy.onTap(0.8f, result1, "err七星接受任务", Sleep);
                    }
                } else {
                    mFairy.onTap(0.8f, result1, "err七星接受任务1", Sleep);
                }
            } else {
                mFairy.onTap(0.8f, result1, "err七星接受任务2", Sleep);
            }
        }

        result = mFairy.findPic(859, 327, 1183, 560, "baohun.png");
        if (result.sim > 0.8f) {
            //两层爆魂
            if (AtFairyConfig.getOption("ecbh").equals("1")) {
                int colorNum = mFairy.getColorNum(961, 393, 1075, 504, 0.99f, 0, "140,140,190");
                if (colorNum == 0)
                    mFairy.onTap(0.8f, result, 1015, 415, 1016, 416, "err爆魂2", Sleep);
            }
            //一层爆魂
            else if (AtFairyConfig.getOption("ycbh").equals("1")) {
                mFairy.onTap(0.8f, result, 1015, 415, 1016, 416, "err爆魂1", Sleep);
            }
        }

        result = mFairy.findPic("HarvestSure.png");
        mFairy.onTap(0.8f, result, "err收获确定奖励", Sleep);

        result = mFairy.findPic("errLowGrade.png");
        mFairy.onTap(0.8f, result, 650, 441, 651, 442, "err等级太低", Sleep);

        result = mFairy.findPic("errLowGrade.png");
        if (picCount(0.8f, result, "err队伍界面") > 20) {
            mFairy.onTap(0.8f, result, 766, 282, 767, 283, "err队伍界面", Sleep);
        }

        result = mFairy.findPic(474, 105, 804, 326, "gbbagua.png");
        mFairy.onTap(0.8f, result, "关闭八卦抽奖", Sleep);

        result = mFairy.findPic("dxts.png");
        if (result.sim > 0.8f) {
            result = mFairy.findPic("dxgb.png");
            mFairy.onTap(0.8f, result, 597, 421, 702, 462, "掉线提示", Sleep);
            return;
        }

        result = mFairy.findPic("startgames.png");
        mFairy.onTap(0.8f, result, "err启动游戏", 10000);

        result = mFairy.findPic("Notice.png");
        mFairy.onTap(0.8f, result, 637, 534, 638, 535, "err更新公告", Sleep);

        result = mFairy.findPic("checkvx.png");
        if (result.sim > 0.8f) {

            switch (AtFairyConfig.getOption("qdl")) {
                case "1":
                    mFairy.onTap(0.8f, result, 883, 641, 884, 642, "errvx登录界面_QQ登录", Sleep);
                    break;
                case "2":
                    mFairy.onTap(0.8f, result, "errvx登录界面_微信登录", Sleep);
                    break;
            }
        }

        result = mFairy.findPic("weixin.png");
        if (result.sim > 0.8f) {
            switch (AtFairyConfig.getOption("qdl")) {
                case "1":
                    mFairy.onTap(1098,625,1141,640, "安卓QQ", Sleep);
                    break;
                case "2":
                    mFairy.onTap(441,608,498,627, "安卓微信", Sleep);
                    break;
                case "3":
                    mFairy.onTap(771,615,816,630, "IOS QQ", Sleep);
                    break;
                case "4":
                    mFairy.onTap(154,616,215,630, "IOS微信", Sleep);
                    break;
            }
        }


        result = mFairy.findPic(new String[]{"login.png", "login2.png", "login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", Sleep);

        result = mFairy.findPic(444, 846, 598, 991, "sure.png");
        mFairy.onTap(0.8f, result, "err新版qq隐私政策同意", Sleep);

        result = mFairy.findPic("authorization.png");
        mFairy.onTap(0.8f, result, "err新版qq授权", Sleep);

        result = mFairy.findPic(new String[]{"login.png", "login2.png", "login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", Sleep);

        result = mFairy.findPic(219, 850, 512, 1114, "checkvx3.png");
        mFairy.onTap(0.8f, result, "errqq登录角色", Sleep);

        result = mFairy.findPic(219, 850, 512, 1114, "checkvx4_1.png");
        mFairy.onTap(0.8f, result, "errqq登录角色", Sleep);

        result = mFairy.findPic(160, 656, 525, 1233, "qqlogn.png");
        mFairy.onTap(0.8f, result, "errqq登录角色1", Sleep);

        result = mFairy.findPic("oversq.png");
        mFairy.onTap(0.8f, result, "errqq完成授權", Sleep);

        result = mFairy.findPic(9, 403, 345, 894, "cq.png");
        mFairy.onTap(0.8f, result, 311, 1098, 338, 1120, "errqq登录", Sleep);

        result = mFairy.findPic(new String[]{"checkvx5.png", "checkvx5_1.png", "shouquan.png"});
        mFairy.onTap(0.8f, result, "err完成qq授权", Sleep);

//        result = mFairy.findPic(293, 440, 1027, 688, "Getintogame1.png");
//        mFairy.onTap(0.8f, result, "err开始游戏", 10000);

        result = mFairy.findPic("Getintogame1.png");
        mFairy.onTap(0.8f, result, "err开始游戏", 10000);

        result = mFairy.findPic("sieve.png");
        if (result.sim > 0.8f) {
            mFairy.onTap(0.8f, result, 27, 23, 73, 42, "返回", 5000);
            mFairy.onTap(0.8f, result, 27, 23, 73, 42, "返回", 5000);
        }
        result = mFairy.findPic("Roleentry.png");
        mFairy.onTap(0.8f, result, "err角色开始游戏", 10000);

        result = mFairy.findPic("errAuthorization.png");
        if (picCount(0.8f, result, "err授权问题") > 2) {
            mFairy.onTap(0.8f, result, 903, 263, 904, 264, "err授权问题", Sleep);
        }

        result = mFairy.findPic("errLoginNO.png");
        mFairy.onTap(0.8f, result, 647, 441, 648, 442, "err登录失败", Sleep);

        result = mFairy.findPic("errHejiu.png");
        mFairy.onTap(0.8f, result, 519, 441, 520, 442, "err喝酒取消", Sleep);

        result = mFairy.findPic("errKnow.png");
        mFairy.onTap(0.8f, result, 516, 404, 517, 405, "err我知道了", Sleep);
        mFairy.onTap(0.8f, result, 506, 487, 507, 488, "err我知道了", Sleep);

        result = mFairy.findPic("errkiss.png");
        mFairy.onTap(0.8f, result, 280, 513, 281, 514, "err亲了一下", Sleep);

        result = mFairy.findPic("errKnow1.png");
        mFairy.onTap(0.8f, result, "err我知道了1", Sleep);

        result = mFairy.findPic("errzhanpao.png");
        mFairy.onTap(0.8f, result, 1262, 12, 1272, 20, "err战袍关闭", Sleep);

        result = mFairy.findPic("jiuyoufinish.png");
        if (picCount(0.8f, result, "err无法匹配了") > 5) {
            mFairy.onTap(0.8f, result, 619, 432, 655, 442, "err九幽无法匹配了", Sleep);
        }

        result = mFairy.findPic("word btn continue receive.png");
        mFairy.onTap(0.8f, result, "error血盟清剿继续接取", Sleep);

        result = mFairy.findPic("tanran.png");
        mFairy.onTap(0.8f, result, 443, 433, 454, 441, "err被人击败了坦然面对", Sleep);

        result = mFairy.findPic(523, 374, 750, 558, "tanran2.png");
        mFairy.onTap(0.8f, result, "err被人击败了坦然面对", Sleep);

        result = mFairy.findPic("paizhao.png");
        mFairy.onTap(0.8f, result, 48, 663, 57, 670, "err退出拍照", Sleep);

        result = mFairy.findPic("flower.png");
        mFairy.onTap(0.8f, result, 840, 562, 853, 570, "err不喜欢他", Sleep);
        mFairy.onTap(0.8f, result, 437, 389, 448, 397, "err不再提醒", Sleep);
        mFairy.onTap(0.8f, result, 773, 439, 785, 450, "err确定", Sleep);

          /*  result=mFairy.findPic("ymzjwiidow.png");
            mFairy.onTap(0.8f,result,1231,53,1243,66,"err先关闭遗民战境弹窗",Sleep);*/

        result = mFairy.findPic(100, 148, 1074, 229, "hai.png");
        mFairy.onTap(0.8f, result, 1151, 56, 1163, 65, "err先关闭天海山外弹窗", Sleep);

        result = mFairy.findPic("email.png");
        mFairy.onTap(0.8f, result, "err左侧弹窗邮件", 2000);
        mFairy.onTap(0.8f, result, 1153, 49, 1162, 70, "err左侧弹窗邮件关闭", Sleep);

          /*  result=mFairy.findPic(884,238,1060,398,new String[]{"redbag.png","home.png","gift box.png","box2.png","tanhan.png","rumeng.png","hui.png","twoxin.png","heart.png","err1.png","friend.png","city2.png","arena.png","fruist.png","over.png"});
            mFairy.onTap(0.8f,result,"err弹窗",Sleep);*/

        result = mFairy.findPic(396, 292, 897, 396, "Grade.png");
        mFairy.onTap(0.8f, result, 628, 434, 639, 441, "err等级落后弹窗", 1000);

        result = mFairy.findPic("Later.png");
        mFairy.onTap(0.8f, result, "err稍后前往", Sleep);

        result = mFairy.findPic("Validity period.png");
        mFairy.onTap(0.8f, result, 501, 397, 511, 408, "err时装过去弹窗取消", Sleep);

        result = mFairy.findPic(765, 450, 983, 587, "Congratulations.png");
        mFairy.onTap(0.8f, result, "err发表助词", Sleep);

        result = mFairy.findPic("tournament.png");
        mFairy.onTap(0.8f, result, 500, 434, 512, 442, "err比武招亲", Sleep);

        result = mFairy.findPic(382, 282, 898, 415, new String[]{"Time limit.png", "mature.png"});
        mFairy.onTap(0.9f, result, 500, 434, 512, 442, "err取消", Sleep);

        result = mFairy.findPic("higt.png");
        mFairy.onTap(0.8f, result, 639, 431, 647, 441, "err最高等级确定", Sleep);

        result = mFairy.findPic("emperor.png");
        mFairy.onTap(0.8f, result, 622, 434, 635, 443, "err大皇帝排行榜知道了", Sleep);

        result = mFairy.findPic("firend refuse.png");
        mFairy.onTap(0.8f, result, "err好友拒绝", Sleep);

        result = mFairy.findPic("see.png");
        mFairy.onTap(0.8f, result, "err一会看", Sleep);

        result = mFairy.findPic(357, 264, 913, 417, "sign up.png");
        mFairy.onTap(0.8f, result, 510, 428, 521, 435, "err取消报名", Sleep);

        result = mFairy.findPic(403, 311, 892, 399, "jihuo.png");
        mFairy.onTap(0.9f, result, 645, 443, 669, 447, "err激活", Sleep);

        result = mFairy.findPic("huodong.png");
        mFairy.onTap(0.8f, result, 510, 437, 517, 442, "err取消报名", Sleep);

        result = mFairy.findPic(391, 309, 884, 388, "can.png");
        mFairy.onTap(0.85f, result, 502, 433, 511, 444, "err稍后参见", Sleep);

        result = mFairy.findPic("shuaguai.png");
        mFairy.onTap(0.8f, result, 624, 429, 635, 437, "err刷怪时间过长休息确定", Sleep);

        result = mFairy.findPic(440, 300, 897, 398, "shangline.png");
        mFairy.onTap(0.8f, result, 636, 435, 643, 442, "err上线了", Sleep);

        result = mFairy.findPic("jiuyoutanchuang.png");
        mFairy.onTap(0.8f, result, 628, 467, 636, 473, "err九幽弹窗", Sleep);

        result = mFairy.findPic("mqgb.png");
        mFairy.onTap(0.8f, result, 1034, 80, 1057, 105, "err九幽弹窗", Sleep);

        result = mFairy.findPic("shifei.png");
        mFairy.onTap(0.9f, result, 510, 434, 520, 443, "err施肥取消", Sleep);

        result = mFairy.findPic("cifu2.png");
        mFairy.onTap(0.8f, result, 641, 432, 648, 442, "err赐福确定", Sleep);

        result = mFairy.findPic("lingqu.png");
        mFairy.onTap(0.8f, result, 1007, 435, 1011, 441, "err红包取消", Sleep);

        result = mFairy.findPic("woxin.png");
        mFairy.onTap(0.8f, result, 1106, 45, 1115, 52, "err卧薪尝胆取消", Sleep);

           /* result=mFairy.findPic("baishi.png");
            mFairy.onTap(0.8f,result,513,444,526,454,"err拜师取消",Sleep);*/

        result = mFairy.findPic("koudai.png");
        if (result.sim >= 0.75f) {
            mFairy.ranSwipe(482, 365, 923, 364, 1000, 1000);
        }

    }
}
