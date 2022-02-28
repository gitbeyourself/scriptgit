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

    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    int count_1 = 0;
    String task_id = AtFairyConfig.getOption("task_id");

    //全局处理
    public void erro() throws Exception {
        result =mFairy.findPic(347,919,633,1078,"agree.png");
        mFairy.onTap(0.8f,result,"err同意协议",Sleep);
    }

}
