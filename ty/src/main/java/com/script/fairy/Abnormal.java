package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    GameUtil gameUtil;
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

        gameUtil = new GameUtil(mFairy);
    }
    //全局处理
    public void erro() throws Exception {

        result = mFairy.findPic(new String[]{"jump.png","jump2.png"});
        mFairy.onTap(0.8f,result,"跳过",2500);

        result = mFairy.findPic("Power saving.png");
        mFairy.onTap(0.8f,result,"err解除省电模式",200);

        result = mFairy.findPic(new String[]{"appraisal.png","make.png"});
        mFairy.onTap(0.8f,result,"err使用",1000);

        result = mFairy.findPic("equipment.png");
        mFairy.onTap(0.8f,result,"err装备",1000);

        result = mFairy.findPic("notice.png");
        mFairy.onTap(0.8f,result,1171,50,1184,61,"err关闭公告",1000);

        result = mFairy.findPic("join game.png");
        mFairy.onTap(0.8f,result,"err进入游戏1",1000);

        result = mFairy.findPic("cruel.png");
        mFairy.onTap(0.8f,result,"err残忍跳过",1000);

        result = mFairy.findPic("game.png");
        mFairy.onTap(0.8f,result,"err进入游戏",1000);

        result = mFairy.findPic("open game.png");
        mFairy.onTap(0.8f,result,"err开启云垂",1000);

        result = mFairy.findPic("no.png");
        mFairy.onTap(0.8f,result,"err不赶时间",1000);

        result = mFairy.findPic("resurrection.png");
        mFairy.onTap(0.8f,result,"err就近复活",1000);

        result = mFairy.findPic("iknow.png");
        mFairy.onTap(0.8f,result,"err知道了",1000);

        result = mFairy.findPic("Rebate.png");
        mFairy.onTap(0.8f,result,1218,90,1229,101,"err300%返利叉",1000);

        result = mFairy.findPic("New announcement.png");
        mFairy.onTap(0.8f,result,539,522,553,529,"err新公告稍后",1000);

        result = mFairy.findPic("yunchuixueyuan.png");
        mFairy.onTap(0.8f,result,32,26,39,32,"err退出云垂学院",1000);

        result = mFairy.findPic("num.png");
        mFairy.onTap(0.8f,result,723,424,735,432,"err确定",1000);

        result = mFairy.findPic(454,422,644,690,"cancel.png");
        mFairy.onTap(0.8f,result,"err取消",Sleep);

       // gameUtil.yanzheng();

    }



}
