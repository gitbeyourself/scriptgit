package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

    }
    int i=0;
    String task_id= AtFairyConfig.getOption("task_id");
    //全局处理
    public void erro() throws Exception {

        i =  mFairy.getColorNum(672,550,730,603,"255,255,255",0.92f);
        LtLog.e("颜色"+i);

        result = mFairy.findPic("Microphone.png");
        mFairy.onTap(0.8f,result,540,509,550,515,"麦克风不开",Sleep);

        result = mFairy.findPic(556,193,1052,273,new String[]{"update.png","gao2.png"});
        mFairy.onTap(0.8f,result,1229,186,1237,196,"关闭公告",2000);

        result = mFairy.findPic("Brave.png");
        mFairy.onTap(0.8f,result,1194,32,1204,40,"勇闯天波府关闭",Sleep);

        result = mFairy.findPic("red bage.png");
        mFairy.onTap(0.8f,result,"红包",Sleep);

        result = mFairy.findPic("red bag2.png");
        mFairy.onTap(0.8f,result,1037,213,1043,224,"红包2",Sleep);

        result = mFairy.findPic("abnormal.png");
        mFairy.onTap(0.8f,result,"来信了",Sleep);

        result = mFairy.findPic("blank.png");
        mFairy.onTap(0.8f,result,"点击空白区域关闭",2000);

        result = mFairy.findPic("resurrection.png");
        mFairy.onTap(0.8f,result,"复活",Sleep);

        result = mFairy.findPic("click.png");
        mFairy.onTap(0.8f,result,"穿戴使用",Sleep);

        result = mFairy.findPic("youxian.png");
        mFairy.onTap(0.8f,result,"优先下载",Sleep);

        result = mFairy.findPic("movements.png");
        mFairy.onTap(0.8f,result,948,291,954,300,"习得招式",Sleep);

        result = mFairy.findPic("QQ.png");
        mFairy.onTap(0.8f,result,"qq登陆",Sleep);

        result = mFairy.findPic(84,612,650,1222,"shouquan.png");
        mFairy.onTap(0.8f,result,"qq授权",Sleep);

        result = mFairy.findPic("Wandering.png");
        mFairy.onTap(0.8f,result,"闯荡江湖",2000);

        result = mFairy.findPic("joingame.png");
        mFairy.onTap(0.8f,result,"进入游戏",2000);

        result = mFairy.findPic("Popup.png");
        mFairy.onTap(0.8f,result,"err广告弹窗叉",2000);

        result = mFairy.findPic("update2.png");
        mFairy.onTap(0.8f,result,"err跟新",2000);

        result = mFairy.findPic("sure2.png");
        mFairy.onTap(0.8f,result,"err同意",2000);

        result = mFairy.findPic("new sure.png");
        mFairy.onTap(0.8f, result, "err新版qq隐私政策同意", Sleep);

        result = mFairy.findPic("new authorization.png");
        mFairy.onTap(0.8f, result, "err新版qq授权", Sleep);

        result = mFairy.findPic(new String[]{"new login.png","new login2.png","new login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", Sleep);

    }



}
