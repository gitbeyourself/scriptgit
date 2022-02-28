package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    int colorNum=0;
    int task_id;
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {
        result=mFairy.findPic(new String[]{"continue.png","know.png"});
        mFairy.onTap(0.8f,result,"error_点击跳过",500);

        result=mFairy.findPic(753,0,1280,317,"pic close2.png");
        mFairy.onTap(0.8f,result,"error_关闭活动窗口",500);

        //新手任务
        if(task_id==1841){
            result=mFairy.findPic( "tap1.png");
            mFairy.onTap(0.8f,result,"error_拼图点击跳过",500);

            result=mFairy.findPic("word new system.png");
            if(result.sim>0.8f){
                result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                mFairy.onTap(0.8f,result,"新系统_误点关闭窗口",500);
            }

            result=mFairy.findPic( 535,600,620,700,"tap.png");
            mFairy.onTap(0.8f,result,"error_点击跳过",200);

            result=mFairy.findPic(670,652,790,707,"tap.png");
            mFairy.onTap(0.8f,result,"error_胜利跳过",200);
        }

        result=mFairy.findPic("pic take back.png");
        mFairy.onTap(0.8f,result,"error_收回",200);

        result=mFairy.findPic(new String []{"chat1.png","chat2.png","chat3.png","chat4.png"});
        if(result.sim>0.8){
            result1=mFairy.findPic(1205,400,1219,495,"dialogue.png");
            if(result1.sim<0.8f){
                mFairy.onTap(0.85f,result,"error_跳过对话",200);
            }
        }

        result=mFairy.findPic("sheng.png");
        mFairy.onTap(0.8f,result,"error_黑屏点击",200);

        result=mFairy.findPic(576,366,651,429,"word today.png");
        if(result.sim>0.8f){
            result=mFairy.findPic(461,422,563,558,new String[]{"word cancel.png","word cancel1.png"});
            mFairy.onTap(0.8f,result,"error_今天不再提醒取消",200);
        }

        result=mFairy.findPic(new String[]{"pic red packet1.png","pic red packet2.png"});
        mFairy.onTap(0.8f,result,"红包",1000);

        //红包界面
        result=mFairy.findPic("pic red packet.png");
        if(result.sim>0.8){
            result1=mFairy.findPic("word start red packet.png");
            if(result1.sim>0.8f){
                mFairy.onTap(0.8f,result,"红包",1000);
            }else{
                mFairy.onTap(986,497,998,512,"关闭红包界面",1000);
            }
        }

        result=mFairy.findPic("word huazhi.png");
        mFairy.onTap(0.8f,result,296,364,314,379,"流畅画质",500);
    }
}
