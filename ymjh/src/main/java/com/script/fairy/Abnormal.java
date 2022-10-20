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

    int task_id;
    Util util=new Util(mFairy);
    static boolean test=false;
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {
        result=mFairy.findPic(529,502,714,564,"word sheng.png");
        mFairy.onTap(0.8f,result,"退出省电模式",1000);

        result=mFairy.findPic("zb.png");
        mFairy.onTap(0.8f,result,"装备",1000);

        result=mFairy.findPic(500,508,766,617,"rtjh.png");
        mFairy.onTap(0.8f,result,"装备",1000);

        result=mFairy.findPic(968,574,1272,704,"jryx.png");
        mFairy.onTap(0.8f,result,"进入游戏",1000);


        result=mFairy.findPic(478,577,810,695,"djgb.png");
        mFairy.onTap(0.8f,result,"点击关闭",1000);

        result=mFairy.findPic("use yes.png");
        mFairy.onTap(0.8f,result,"确认使用",1000);

        if(test){
            result=mFairy.findPic("stop.png");
            mFairy.onTap(0.8f,result,"停止应用",1000);
        }

        result=mFairy.findPic("pic jie.png");
        mFairy.onTap(0.8f,result,1207,16,1220,30,"关闭-抽奖",1000);

        result=mFairy.findPic("word plot.png");
        mFairy.onTap(0.8f,result,"跳过剧情",2000);
        if(result.sim>0.8f)util.initDaze();

        result=mFairy.findPic("pic dialogue ear.png");
        mFairy.onTap(0.8f,result,"跳过对话",500);
        if(result.sim>0.8f)util.initDaze();

        //跳过对话
        result=mFairy.findPic("pic dialogue1.png");
        if(result.sim>0.8f){
            result1=mFairy.findPic(new String[]{"pic dialogue select.png","pic dialogue select1.png","pic guide jsb.png"});
            if(result1.sim<0.8f){
                mFairy.onTap(0.8f,result,"跳过对话",500);
            }
        }

        result=mFairy.findPic("word tap close.png");
        mFairy.onTap(0.8f,result,"点击界面关闭",1000);
	}
}
