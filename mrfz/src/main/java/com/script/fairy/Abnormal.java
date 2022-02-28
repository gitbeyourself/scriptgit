package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    int task_id;
    public Abnormal(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {
        //对话情景跳过
        result=mFairy.findPic(42,36,206,213,"chat.png");
        mFairy.onTap(0.8F,result,"对话情景跳过",200l);
        //对话情景跳过
        result=mFairy.findPic(45,489,234,692,"chat.png");
        mFairy.onTap(0.8F,result,"对话情景跳过",200l);
        //对话情景1跳过
        result=mFairy.findPic(42,36,206,213,"chat1.png");
        mFairy.onTap(0.8F,result,"对话情景跳过",200l);

        result=mFairy.findPic(440,268,840,380,"lkjj.png");
        mFairy.onTap(0.8F,result,819,472,886,522,"基建返回提醒",200l);

        //剧情跳过按钮
        result=mFairy.findPic(970,11,1275,93,"continue.png");
        if(result.sim>0.8){
            mFairy.onTap(0.8f,result,"剧情跳过按钮",500);
            mFairy.onTap(813,476,872,534,"剧情确认跳过",1000);

            result=mFairy.findPic(801,479,892,535,"continue_yes.png");
            mFairy.onTap(0.8f,result,813,476,872,534,"剧情再次确认跳过",200l);
        }

        //匹配所有确认按钮
        result=mFairy.findPic("continue_yes.png");
        mFairy.onTap(0.8f,result,"点击确认",200l);

        if(task_id!=1635){
            //关闭活动
            result=mFairy.findPic(1016,5,1271,129,"close.png");
            mFairy.onTap(0.8F,result,"关闭活动",200l);
        }

        //获取东西确认
        result = mFairy.findPic("get_ok.png");
        mFairy.onTap(0.8F, result, "获取东西确认", 200l);

        //PRTS对话剧情
        result=mFairy.findPic(42,36,206,213,"PRTS_chat.png");
        mFairy.onTap(0.8F,result,"PRTS对话剧情",200l);

        result=mFairy.findPic(45,489,234,692,"PRTS_chat.png");
        mFairy.onTap(0.8F,result,"PRTS对话剧情",200l);

    }

}
