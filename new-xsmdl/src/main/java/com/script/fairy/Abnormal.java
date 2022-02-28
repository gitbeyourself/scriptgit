package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * 处理异常弹框 红包
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    public static long midTime;
    public Abnormal(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
    }
    int count_1=0;
    String task_id= AtFairyConfig.getOption("task_id");
    //全局处理
    public void erro() throws Exception {

        result = mFairy.findPic(428,98,816,239,"remind.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,525,391,582,419, "取消", 2000);
        }
        result = mFairy.findPic("qiyuan.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("closess4.png");
            mFairy.onTap(0.8f, result,"关闭", 1000);
        }
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,525,391,582,419, "取消", 2000);
        }
        result = mFairy.findPic(341,171,954,431,"timing.png");
        mFairy.onTap(0.8f, result,459,392,522,419, "取消", 1000);
        result = mFairy.findPic("tiaozhans2.png");
//        if(result.sim>0.8f){
//
//        }else{
//            result = mFairy.findPic("quxiao.png");
//            mFairy.onTap(0.8f, result,"取消", 1000);
//        }
        result = mFairy.findPic("recovery.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result, "装备回收", 1000);
            result = mFairy.findPic("reds4.png");
            if (result.sim>0.8f){
                mFairy.onTap(0.8f, result,502,446,508,455, "红色装备选择", 2000);
            }
            result = mFairy.findPic("recoverys1.png");
            mFairy.onTap(0.8f, result, "回收", 1000);
        }
        result = mFairy.findPic(17,362,111,476,"flush.png");
        mFairy.onTap(0.8f, result,418,340,439,359, "首冲关闭", 1000);
        result = mFairy.findPic("drugs.png");
        mFairy.onTap(0.8f, result,585,453,641,478, "确定", 1000);
        result = mFairy.findPic("sui2.png");
        mFairy.onTap(0.8f, result, "抽奖关闭0", 1000);
        result = mFairy.findPic("luck.png");
        mFairy.onTap(0.8f, result, "抽奖关闭1", 1000);
//        result = mFairy.findPic("jujue.png");
//        mFairy.onTap(0.8f, result, "拒绝", 1000);
        result = mFairy.findPic("yous1.png");
        mFairy.onTap(0.8f, result, "关闭宝箱", 1000);
        result = mFairy.findPic("querens6.png");
        mFairy.onTap(0.8f, result, "确认", 1000);
        result = mFairy.findPic("wans1.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("signs1.png");
            mFairy.onTap(0.8f, result, "登录", 1000);
        }
        result = mFairy.findPic("arbitrarily.png");
        mFairy.onTap(0.8f, result, "任意位置", 1000);
        result = mFairy.findPic("into.png");
        mFairy.onTap(0.8f, result, "进入游戏", 1000);
        result = mFairy.findPic("Notices1.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("offs7.png");
            mFairy.onTap(0.8f, result, "关闭", 1000);
        }
        result = mFairy.findPic("Guilds2.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("offs8.png");
            mFairy.onTap(0.8f, result, "关闭", 1000);
        }
        result = mFairy.findPic(663,282,1096,481,"uses2.png");
        mFairy.onTap(0.8f, result, "使用", 1000);
        result = mFairy.findPic("stars1.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("offss2.png");
            mFairy.onTap(0.8f, result, "关闭", 1000);
            result = mFairy.findPic("tiaoss1.png");
            mFairy.onTap(0.8f, result, "跳过", 1000);
        }
        result = mFairy.findPic("download.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("canel.png");
            mFairy.onTap(0.8f, result, "关闭", 1000);
        }
        result = mFairy.findPic("deng.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,395,457,421,478, "关闭", 1000);
        }
        result = mFairy.findPic(228,365,1163,507,"huo.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,1107,392,1140,425, "关闭", 1000);
        }
        result = mFairy.findPic(474,223,949,281,"xiazai.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("canels1.png");
            mFairy.onTap(0.8f, result, "取消", 1000);
        }
        result = mFairy.findPic(474,223,949,281,"xiazai.png");
        if(result.sim>0.8f){
            result = mFairy.findPic("canels1.png");
            mFairy.onTap(0.8f, result, "取消", 1000);
        }
        result = mFairy.findPic(475,262,776,319,"ends2.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,548,364,593,383, "取消", 1000);
        }

        result = mFairy.findPic("yong.png");
        mFairy.onTap(0.8f, result, 636,444,652,456,"确定", 1000);

        result = mFairy.findPic("canell.png");
        mFairy.onTap(0.8f, result, "取消", 1000);

        result = mFairy.findPic(414,109,893,296,"cishu.png");
        LtLog.e("**************挑战为0"+result.sim);
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,739,615,748,621, "取消自动战斗", 3000);
            mFairy.touchDown( 170,576);
            mFairy.touchMove( 208,522, 6000);
            mFairy.touchUp();
        }
    }
}
