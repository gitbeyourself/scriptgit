package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    List<String> list = new ArrayList<>();
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);

    }
    public void welfare() throws Exception {
        util.close();
        int js_1=0;
         for (int i=0;i<20;i++){
             mFairy.condit();
             LtLog.e(mFairy.getLineInfo("福利中="));
             result = mFairy.findPic("daily.png");
             mFairy.onTap(0.8f, result, 872,25,889,44,"日常打开福利", 1000);

             result = mFairy.findPic("welfare.png");
             LtLog.e(mFairy.getLineInfo(0.8f,result,"福利界面"));
             if (result.sim>0.8f){
                 result = mFairy.findPic(301,134,350,681,"red.png");
                 mFairy.onTap(0.8f, result,"红点", 1000);
                 if (result.sim<0.8f){
                     js_1++;
                     if (js_1>5){
                         break;
                     }
                 }else {
                     js_1=0;
                 }

                 result = mFairy.findPic(360,100,1171,710,"welfare_payment.png");
                 mFairy.onTap(0.8f, result,"领取", 1000);

                 result = mFairy.findPic(360,100,1171,710,"welfare_payment1.png");
                 mFairy.onTap(0.8f, result,"领取", 1000);

                 result = mFairy.findPic(360,100,1171,710,"sign_in.png");
                 mFairy.onTap(0.8f, result,"签到", 1000);


                 result = mFairy.findPic(360,100,1171,710,"general_return.png");
                 mFairy.onTap(0.8f, result,"找回", 1000);


             }
         }
         util.close();
    }


}
