package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;

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
    int count_1=0;
    String task_id= AtFairyConfig.getOption("task_id");
    //全局处理
    public void erro() throws Exception {

        result = mFairy.findPic("shengdian.png");
        mFairy.onTap(0.75f,result,"err省电",Sleep);

        result = mFairy.findPic("skip.png");
        mFairy.onTap(0.75f,result,"err跳过剧情",Sleep);

        result = mFairy.findPic("equipment.png");
        mFairy.onTap(0.8f,result,"err装备",Sleep);

        result = mFairy.findPic("newban.png");
        mFairy.onTap(0.8f,result,564,444,590,462,"err新版不考虑",Sleep);

        result = mFairy.findPic(new String[]{"Use.png","Use2.png"});
        mFairy.onTap(0.8f,result,"err使用",Sleep);

        result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
        mFairy.onTap(0.8f,result,"err确定",Sleep);

        result = mFairy.findPic("ignore.png");
        mFairy.onTap(0.8f,result,"err忽略",1000);

        result = mFairy.findPic(new String[]{"Camp revival.png","fight again.png"});
        mFairy.onTap(0.8f,result,"err奋起再战",Sleep);

        result = mFairy.findPic("refuse.png");
        mFairy.onTap(0.8f,result,"err乞讨拒绝",Sleep);

        result = mFairy.findPic("lingqu.png");
        mFairy.onTap(0.8f,result,"err宗师之路领取",Sleep);

        result = mFairy.findPic(new String[]{"Sign in list.png","Sign in list2.png"});
        mFairy.onTap(0.8f,result,"err签到列表",Sleep);

        result = mFairy.findPic(63,188,1100,528,"Sign in.png");
        mFairy.onTap(0.7f,result,"err签到",Sleep);

        mFairy.onTap(0.8f,result,1116,34,1144,62,"err关闭" ,Sleep);

        result = mFairy.findPic(63,188,1100,528,"ylq.png");
        mFairy.onTap(0.8f,result,1116,34,1144,62,"err关闭" ,Sleep);

        result = mFairy.findPic(245,563,898,668,"Sign in2.png");
        mFairy.onTap(0.7f,result,"err签到",Sleep);
        mFairy.onTap(0.8f,result,1116,34,1144,62,"err关闭" ,Sleep);

        result = mFairy.findPic(237,588,883,672,"Farewell.png");
        mFairy.onTap(0.8f,result,1116,34,1144,62,"err关闭" ,Sleep);

        result = mFairy.findPic("trigger.png");
        mFairy.onTap(0.8f,result,907,171,935,194,"err关闭不期而遇触发的礼包",Sleep);

        result = mFairy.findPic(753,536,907,628,"red bag.png");
        mFairy.onTap(0.8f,result,"err红包",Sleep);

        result = mFairy.findPic(new String[]{"Thanks.png","xiaona.png"});
        mFairy.onTap(0.8f,result,"err笑纳了",Sleep);

        result = mFairy.findPic("sure.png");
        mFairy.onTap(0.8f,result,"err接受帮会邀请",Sleep);

        result = mFairy.findPic("Gift package.png");
        mFairy.onTap(0.8f,result,1121,35,1144,56,"err关闭专属礼包",Sleep);

        result = mFairy.findPic("ltcha.png");
        mFairy.onTap(0.8f,result,"err关闭聊天",Sleep);

        result = mFairy.findPic("jujue.png");
        mFairy.onTap(0.8f,result,"err拒绝邀请",Sleep);

        result = mFairy.findPic("yaoji.png");
        mFairy.onTap(0.8f,result,1172,60,1191,86,"err取消药剂",Sleep);

        result = mFairy.findPic("qrshiyong.png");
        mFairy.onTap(0.8f,result,"err确认使用",Sleep);

        result = mFairy.findPic("ignore2.png");
        mFairy.onTap(0.8f,result,"err忽略",Sleep);

        result = mFairy.findPic("rbbag.png");
        mFairy.onTap(0.8f,result,806,152,827,171,"err关闭入帮红包",Sleep);

        result = mFairy.findPic(new String[]{"start-up.png","start-up2.png"});
        mFairy.onTap(0.8f,result,"err启动游戏",Sleep);

        result = mFairy.findPic("Client update.png");
        mFairy.onTap(0.8f,result,619,489,650,503,"err客户端更新",Sleep);


        result = mFairy.findPic("accept.png");
        mFairy.onTap(0.8f,result,"err接受",Sleep);

        result = mFairy.findPic("Notice.png");
        mFairy.onTap(0.8f,result,622,553,652,564,"err公告",Sleep);

        result = mFairy.findPic("gonggao.png");
        mFairy.onTap(0.8f,result,"err公告",Sleep);

        result = mFairy.findPic("land.png");
        mFairy.onTap(0.8f,result,"err账号登陆",Sleep);

        result = mFairy.findPic("land.png");
        mFairy.onTap(0.8f,result,"err账号登陆",Sleep);

        result = mFairy.findPic("begin game.png");
        mFairy.onTap(0.8f,result,"err开始游戏",Sleep);

        result = mFairy.findPic("begin game2.png");
        mFairy.onTap(0.8f,result,"err开始游戏2",Sleep);


    }



}
