package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;


/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    int task_id;
    Util util;
    public Abnormal(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        util=new Util(mFairy);
        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {
        result=mFairy.findPic(232,517,284,558,"pic dialogue.png");
        mFairy.onTap(0.8f,result,"对话",1000);
        if(result.sim>0.8f)util.initDaze("对话");

        result=mFairy.findPic(1147,14,1257,83,"pic continue.png");
        mFairy.onTap(0.8f,result,"跳过",1000);
        if(result.sim>0.8f)util.initDaze("跳过");

        result=mFairy.findPic(314,266,376,392,"pic dialogue1.png");
        mFairy.onTap(0.8f,result,"对话回复",1000);

        result=mFairy.findPic("word hint limit shop.png");
        mFairy.onTap(0.8f,result,489,489,496,498,"限时商店-取消前往",1000);

        result=mFairy.findPic("word btn go activity.png");
        mFairy.onTap(0.8f,result,"前往活动",1000);

        result=mFairy.findPic("word hint error.png");
        mFairy.onTap(0.8f,result,635,488,643,497,"错误提示，返回标题",1000);

        //掉线重连
        result=mFairy.findPic("word main menu.png");
        mFairy.onTap(0.8f,result,643,662,648,667,"掉线-开始",1000);

        result=mFairy.findPic("word select role.png");
        mFairy.onTap(0.8f,result,246,377,267,400,"选择角色",1000);
        mFairy.onTap(0.8f,result,1093,639,1124,667,"竞赛开始",1000);

        result=mFairy.findPic("word i know.png");
        mFairy.onTap(0.8f,result,"我知道了(实名制提示)",1000);

        result=mFairy.findPic("word hint download new.png");
        mFairy.onTap(0.8f,result,780,489,792,499,"下载新增数据",1000);

        result=mFairy.findPic("word btn login.png");
        mFairy.onTap(0.8f,result,"掉线-登录",1000);

        result=mFairy.findPic("word btn agree.png");
        mFairy.onTap(0.8f,result,"掉线-同意",1000);

        result=mFairy.findPic("word deal.png");
        mFairy.onTap(0.8f,result,183,720,194,731,"error_关闭交易",1000);
        if(result.sim<0.8f){
            result=mFairy.findPic("pic recharge close.png");
            mFairy.onTap(0.8f,result,"error_充值关闭",2000);
        }
	}
}
