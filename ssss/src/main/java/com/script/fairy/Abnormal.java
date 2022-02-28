package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }
    int js_1=0,js_2=0;
    //全局处理
    public void erro() throws Exception {
         Thread.sleep(2000);
        result = mFairy.findPic("red_envelopes.png");
        mFairy.onTap(0.8f, result, "err红包", 1000);

        result = mFairy.findPic("activity_opening.png");
        mFairy.onTap(0.8f, result, 482,457,541,481,"err活动开启取消", 1000);

        result = mFairy.findPic("resurrection.png");
        mFairy.onTap(0.8f, result, "err复活", 1000);

        result = mFairy.findPic("power_saving.png");
        mFairy.onTap(0.8f, result, "err省电模式", 1000);

    }


}
