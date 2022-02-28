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
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {
        result=mFairy.findPic(1136,546,1178,587,new String[]{"pic continue1.png","pic continue2.png","pic continue3.png"});
        mFairy.onTap(0.8f,result,"跳过对话",1000);

        result=mFairy.findPic(1057,616,1095,657,new String[]{"pic continue1.png","pic continue2.png","pic continue3.png"});
        mFairy.onTap(0.8f,result,"跳过对话",1000);

        result=mFairy.findPic(1139,617,1183,657,new String[]{"pic continue1.png","pic continue2.png","pic continue3.png"});
        mFairy.onTap(0.8f,result,"跳过对话",1000);

        result=mFairy.findPic(1009,629,1050,669,new String[]{"pic continue1.png","pic continue2.png","pic continue3.png"});
        mFairy.onTap(0.8f,result,"跳过对话",1000);

        result=mFairy.findPic("word continue1.png");
        mFairy.onTap(0.8f,result,"跳过",1000);

        result=mFairy.findPic(532,655,570,713,"word tap.png");
        mFairy.onTap(0.8f,result,"点击其他区域返回",1000);

        result=mFairy.findPic("word btn jiaona.png");
        mFairy.onTap(0.8f,result,886,216,895,225,"关闭缴纳",1000);
	}
}
