package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    GameUtil gameUtil;

    public SingleTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gameUtil = new GameUtil(mFairy);

    }

    public void novice() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void content_0() throws Exception {



                result = mFairy.findPic(1163,385,1279,648,"knapsack.png");
                if(result.sim > 0.8f) {
                    result = mFairy.findPic(9,98,271,268,"battle.png");
                    mFairy.onTap(0.8f, result, "自动战斗", 1000);
                }

                result = mFairy.findPic(1153,416,1280,714,"Victory or defeat.png");
                if(result.sim > 0.8f) {
                    mFairy.initMatTime();
                    LtLog.e("战斗中");
                }


                long dazeTime = mFairy.mMatTime(1207,44, 71, 15, 0.9f);
                LtLog.e("发呆时间"+dazeTime);
                if (dazeTime > 60) {
                    gameUtil.close(1);
                    mFairy.initMatTime();
                }



                result = mFairy.findPic(917,612,1247,716, "kqjn.png");
                mFairy.onTap(0.8f, result, 1151,678,1158,687,"展开任务栏", Sleep);

                result = mFairy.findPic(420,94,949,422, "xzjn.png");
                mFairy.onTap(0.8f, result, 695,249,703,261,"选择技能", 2000);
                mFairy.onTap(0.8f, result, 622,564,646,577,"选择技能", 2000);
                mFairy.onTap(0.8f, result, 1066,550,1080,564,"选择技能", 2000);
                mFairy.onTap(0.8f, result, 1040,437,1048,448,"选择技能", 2000);
                mFairy.onTap(0.8f, result, 717,170,724,185,"选择技能", 2000);
                mFairy.onTap(0.8f, result, 1086,93,1092,103,"选择技能", 2000);

                result = mFairy.findPic(117,119,548,483, "djjm.png");
                mFairy.onTap(0.8f, result, 220,283,234,293,"等级界面", 2000);
                mFairy.onTap(0.8f, result, 500,310,515,334,"提速", 2000);
                mFairy.onTap(0.8f, result, 224,360,241,378,"培养", 2000);
                mFairy.onTap(0.8f, result, 500,310,515,334,"提升", 2000);
                mFairy.onTap(0.8f, result, 224,521,248,540,"收集", 2000);
                mFairy.onTap(0.8f, result, 425,272,436,294,"选坐骑外观", 2000);
                mFairy.onTap(0.8f, result,1086,91,1092,101, "关闭", Sleep);

                result = mFairy.findPic(139,141,544,415, "zdsd.png");
                mFairy.onTap(0.8f, result, 223,282,254,298,"战斗设定", 2000);
                mFairy.onTap(0.8f, result, 578,343,596,359,"界面", 2000);
                mFairy.onTap(0.8f, result, 224,360,241,378,"培养", 2000);
                mFairy.onTap(0.8f, result, 500,310,515,334,"提升", 2000);
                mFairy.onTap(0.8f, result, 224,521,248,540,"收集", 2000);
                mFairy.onTap(0.8f, result, 425,272,436,294,"选坐骑外观", 2000);
                mFairy.onTap(0.8f, result,1086,91,1092,101, "关闭", Sleep);

                result = mFairy.findPic(12,63,329,217, "qczq.png");
                mFairy.onTap(0.8f, result, 63,134,72,144,"选择骑乘", 2000);


                result = mFairy.findPic(1029, 62, 1278, 328, "rwl.png");
                mFairy.onTap(0.9f, result, "展开任务栏", Sleep);

                result1 = mFairy.findPic(1003,54,1280,223, "rwl3.png");
                result = mFairy.findPic(1003,54,1280,223, "rwl2.png");
                if (result1.sim > 0.8f && result.sim < 0.8f){
                    mFairy.onTap(1103,85,1118,91,"队伍切换到任务", Sleep);
                }

                result = mFairy.findPic(1054,69,1277,379, "main.png");
                result1 = mFairy.findPic(1053,110,1278,196,"guide.png");
                if(result.sim > 0.7f) {
                    mFairy.onTap(0.7f, result, "右侧主线", Sleep);
                }else if(result1.sim >0.7f){
                    mFairy.onTap(0.7f, result1, "右侧引导", Sleep);
                }
                result = mFairy.findPic(1054,69,1277,379, new String[]{"main.png","guide.png"});
                if (picCountS(0.7f, result, "右侧主线") > 30) {
                    LtLog.e(mFairy.getLineInfo("主线结束"));
                    setTaskEnd();
                    return;
                }


                result = mFairy.findPic(252,510,1170,684,"3gwt.png");//桃园三结义
                if (result.sim > 0.8f) {
                    mFairy.onTap(494,628,506,643, "试试看", Sleep);
                    mFairy.onTap(487,624,520,643, "曹操", Sleep);
                    mFairy.onTap(487,624,520,643, "空白", Sleep);
                    mFairy.onTap(481,630,507,641, "青囊书", Sleep);
                    mFairy.onTap(481,630,507,641, "空白", Sleep);
                    mFairy.onTap(895,570,934,590, "汉献帝", Sleep);
                }

                /*result = mFairy.findPic(722,505,1277,716,"hand.png");//技能指引
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 1147,668,1156,683,"开启技能", Sleep);
                    mFairy.onTap(654,263,661,274, "选择技能", Sleep);
                    mFairy.onTap(1062,548,1080,563, "选择技能", Sleep);
                    mFairy.onTap(1062,548,1080,563, "详情", Sleep);
                    mFairy.onTap(1037,433,1052,447, "确定", Sleep);
                    mFairy.onTap(710,174,722,189, "设定", Sleep);
                    mFairy.onTap(1086,91,1092,101, "关闭", Sleep);
                }*/
                result = mFairy.findPic(680,452,1279,717,"Mount.png");//坐骑
                if (result.sim > 0.8f) {
                    mFairy.onTap(1066,595,1077,610, "坐骑", 1500);
                    mFairy.onTap(511,354,526,371, "详细", 1500);
                    mFairy.onTap(225,282,243,292, "等级", 1500);
                    mFairy.onTap(511,354,526,371, "详细", 1500);
                    mFairy.onTap(233,364,243,373, "培养", 1500);
                    mFairy.onTap(511,354,526,371, "详细", 1500);
                    mFairy.onTap(232,522,257,538, "收集", 1500);
                    mFairy.onTap(426,281,438,293, "选择", 1500);
                    mFairy.onTap(1085,121,1094,129, "关闭", 1500);
                    mFairy.onTap(60,132,69,141, "骑马", 1500);
                }

                result = mFairy.findPic(680,452,1279,717,"function.png");//功能指引
                if (result.sim > 0.8f) {
                    mFairy.onTap( 1227,672,1247,686,"功能", 500);
                    result = mFairy.findPic(680,452,1279,717,"Mount.png");//坐骑
                    if (result.sim > 0.8f) {
                        mFairy.onTap(1066,595,1077,610, "坐骑", 1500);
                        mFairy.onTap(511,354,526,371, "详细", 1500);
                        mFairy.onTap(225,282,243,292, "等级", 1500);
                        mFairy.onTap(511,354,526,371, "详细", 1500);
                        mFairy.onTap(233,364,243,373, "培养", 1500);
                        mFairy.onTap(511,354,526,371, "详细", 1500);
                        mFairy.onTap(232,522,257,538, "收集", 1500);
                        mFairy.onTap(426,281,438,293, "选择", 1500);
                        mFairy.onTap(1085,121,1094,129, "关闭", 1500);
                        mFairy.onTap(60,132,69,141, "骑马", 1500);
                    }
                    result = mFairy.findPic(680,452,1279,717,"office.png");//机关
                    if (result.sim > 0.8f) {
                        mFairy.onTap(1158,525,1165,535, "机关", 1500);
                        mFairy.onTap(435,326,445,371, "详细", 1500);
                        mFairy.onTap(227,287,238,300, "战斗", 1500);
                        mFairy.onTap(435,326,445,371, "详细", 1500);
                        mFairy.onTap(1085,121,1094,129, "关闭", 1500);
                        mFairy.onTap(119,126,130,142, "练功助手", 1500);
                    }
                    result = mFairy.findPic(680,452,1279,717,"paiqian.png");//派遣
                    if (result.sim > 0.8f) {
                        mFairy.onTap(1149,587,1159,597, "派遣", 1000);
                        mFairy.onTap(443,292,455,306, "详细", 1000);
                        mFairy.onTap(932,383,937,398, "选择武将", 1000);
                        mFairy.onTap(696,291,703,307, "详细", 1000);
                        mFairy.onTap(844,287,847,292, "详细", 1000);
                        mFairy.onTap(803,509,806,511, "确定", 1000);
                        mFairy.onTap(929,576,931,579, "出发", 1000);
                        mFairy.onTap(954,524,960,530, "详细", 1000);
                        mFairy.onTap(929,576,931,579, "快速完成", 1000);
                        mFairy.onTap(1091,122,1093,131, "关闭", 1000);
                    }
                    result = mFairy.findPic(680,452,1279,717,"cs.png");//传送
                    if (result.sim > 0.8f) {
                        mFairy.onTap(998,524,1011,537, "传送", 1000);
                        mFairy.onTap(383,288,400,304, "详细", 1000);
                        mFairy.onTap(220,282,242,295, "记录点", 1000);
                        mFairy.onTap(761,198,772,215, "详细", 1000);
                        mFairy.onTap(216,357,231,369, "练功区", 1000);
                        mFairy.onTap(761,198,772,215, "详细", 1000);
                        mFairy.onTap(1091,122,1093,131, "关闭", 1000);
                    }
                    mFairy.onTap(920,589,936,608, "成就", 1000);
                    mFairy.onTap(785,221,798,235, "详细", 1000);
                    mFairy.onTap(226,495,247,502, "任务", 1000);
                    mFairy.onTap(996,213,1014,225, "领取", 1000);
                    mFairy.onTap(1085,121,1094,129, "关闭", 1000);
                }

                result = mFairy.findPic(249,473,1178,686,"jiebang.png");//揭榜
                if (result.sim > 0.8f) {
                    mFairy.onTap( 489,630,512,638,"揭榜", Sleep);
                    mFairy.onTap(58,223,67,239, "自动", Sleep);
                }

                result = mFairy.findPic(252,510,1170,684,"qba.png");//地痞
                if (result.sim > 0.8f) {
                    mFairy.onTap( 481,629,509,643,"扁他", Sleep);
                    mFairy.onTap(58,223,67,239, "自动", Sleep);
                }

                result = mFairy.findPic(252,510,1170,684,"solve.png");//
                mFairy.onTap( 0.8f, result,484,626,514,642,"好！", Sleep);

                result = mFairy.findPic(252,510,1170,684,"wx.png");//
                mFairy.onTap( 0.8f, result,484,626,514,642,"好！", Sleep);

                result = mFairy.findPic(252,510,1170,684,"jiuren.png");//
                mFairy.onTap( 0.8f, result,484,626,514,642,"好！", Sleep);

                result = mFairy.findPic(252,510,1170,684,"zudui.png");//
                mFairy.onTap( 0.8f, result,351,639,360,647,"否！", Sleep);

                result = mFairy.findPic(252,510,1170,684,"Lost.png");//马夫
                mFairy.onTap( 0.8f, result,483,629,495,641,"找", Sleep);

                result = mFairy.findPic(252,510,1170,684,"Lost.png");//迁马
                mFairy.onTap( 0.8f, result,483,629,495,641,"迁马", Sleep);

                result = mFairy.findPic(268,523,1159,682,"qianhui.png");//迁马
                mFairy.onTap( 0.8f, result,"迁马", Sleep);

                result = mFairy.findPic(252,510,1170,684,"yt.png");
                mFairy.onTap( 0.8f, result,484,626,514,642,"好！", Sleep);

                result = mFairy.findPic(252,510,1170,684,"shn.png");
                mFairy.onTap( 0.8f, result,484,626,514,642,"好！", Sleep);

                result = mFairy.findPic(986,546,1178,673,"next step.png");
                mFairy.onTap( 0.8f, result, "下一步", Sleep);

                result = mFairy.findPic(252,510,1170,684,"xuanxiang.png");//
                mFairy.onTap( 0.8f, result,484,626,514,642,"左侧选项！", Sleep);

                result = mFairy.findPic(1057,113,1278,195,"jucai.png");
                result1 = mFairy.findPic(565,90,933,381,"zhangg.png");
                if (result.sim > 0.8f && result1.sim > 0.8f){

                    mFairy.onTap( 0.8f, result1,  result1.y+60,result1.x+10,result1.y+65,result1.x,"选择掌柜", 1000);
                    mFairy.onTap(0.8f, result1,1149,554,1161,570, "对话", Sleep);

                    result1 = mFairy.findPic(251,452,1201,689,"zhang2.png");
                    if (result1.sim > 0.8f) {
                        mFairy.onTap(0.8f, result1,507,636,523,644, "武将", Sleep);
                        mFairy.onTap(0.8f, result1,975,346,990,353, "存入", Sleep);
                        mFairy.onTap(0.8f, result1,1086,91,1092,101, "关闭", Sleep);
                    }

                }

            }
        }.taskContent(mFairy, "一键15");
    }//一键15


    public void inOperation() throws Exception {

        result = mFairy.findPic(895,410,1188,567,"dialogue.png");
        if (result.sim > 0.8f) {
            mFairy.onTap(0.8f, result, 681,685,695,695,"对话中", Sleep);
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }

        result = mFairy.findPic(261,517,1169,685,"guoqiao.png");
        if (result.sim > 0.8f) {
            mFairy.onTap(0.8f, result, 487,631,504,639,"过桥", Sleep);
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }

    }

}
