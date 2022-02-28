package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;


    public Util(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }
    public  void close()throws Exception{
        for (int i=0;i<2;i++){
            mFairy.condit();
            result = mFairy.findPic( 676,11,1271,312,"fork.png");
            mFairy.onTap(0.9f,result, "叉", 1000);
            if (result.sim>0.9f){
                i=0;
            }
        }
    }

}
