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
   Integer task_id= Integer.parseInt(AtFairyConfig.getOption("task_id"));
    //全局处理
    public void erro() throws Exception {
        if (task_id==2169){

        }else {
            result = mFairy.findPic("Manual.png");
            mFairy.onTap(0.8f,result,"err自动",2000);

            result = mFairy.findPic("2X speed.png");
            mFairy.onTap(0.8f,result,"err2倍速",2000);
        }

        result = mFairy.findPic("Synergetic station.png");
        mFairy.onTap(0.8f,result,516,586,543,603,"err拒绝协站",Sleep);

        result = mFairy.findPic("testing.png");
        mFairy.onTap(0.8f,result,486,511,503,518,"err检测",Sleep);

        result = mFairy.findPic("Grade.png");
        mFairy.onTap(0.8f,result,"err等级提升",Sleep);

        result = mFairy.findPic("TG.png");
        mFairy.onTap(0.8f,result,"err跳过",Sleep);


        result = mFairy.findPic(new String[]{"start-up.png","start-up2.png"});
        mFairy.onTap(0.8f,result,"err启动游戏",Sleep);

        result = mFairy.findPic("train2.png");
        mFairy.onTap(0.8f,result,"err列车2号线svip",Sleep);

        result = mFairy.findPic("twoline.png");
        mFairy.onTap(0.8f,result,"err列车2号线vip",Sleep);

        result = mFairy.findPic("Privacy clause.png");
        mFairy.onTap(0.8f,result,784,620,794,628,"err自动登陆的隐私条款",Sleep);

        result = mFairy.findPic("lizard.png");
        mFairy.onTap(0.8f,result,624,506,643,520,"err无法连接检查网络",Sleep);

        result = mFairy.findPic(425,7,877,181,"Notice.png");
        mFairy.onTap(0.8f,result,626,618,647,633,"err关闭公告svip",Sleep);

        result = mFairy.findPic(425,7,877,181,"Notice2.png");
        mFairy.onTap(0.8f,result,623,582,652,604,"err关闭公告vip",Sleep);

        result = mFairy.findPic("network.png");
        mFairy.onTap(0.8f,result,617,467,652,482,"err登陆",Sleep);

        result = mFairy.findPic("Go Go.png");
        mFairy.onTap(0.8f,result,"err出发",Sleep);

        result = mFairy.findPic("begin game.png");
        mFairy.onTap(0.8f,result,"err进入游戏",Sleep);

        result = mFairy.findPic("Start taking risks.png");
        mFairy.onTap(0.8f,result,"err开始冒险",Sleep);

        result = mFairy.findPic("qdday.png");
        mFairy.onTap(0.8f,result,922,90,932,107,"err签到完关闭",Sleep);

        result = mFairy.findPic("no ts.png");
        mFairy.onTap(0.8f,result,1033,71,1043,84,"err关闭",Sleep);

        result = mFairy.findPic("sure.png");
        mFairy.onTap(0.8f,result,"err隐私条款同意vip",Sleep);
    }



}
