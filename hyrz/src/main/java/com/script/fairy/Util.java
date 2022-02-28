package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public Util(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }
    public  void close()throws Exception{
        for (int i=0;i<2;i++){
            mFairy.condit();
            result = mFairy.findPic( 564,36,997,339,new String[]{"fork1.png","fork.png"});
            mFairy.onTap(0.8f,result, "叉1", 1000);
            if (result.sim>0.8f){
                i=0;
            }
            result = mFairy.findPic( 676,11,1271,312,new String[]{"fork1.png","fork.png"});
            mFairy.onTap(0.8f,result, "叉", 1000);
            if (result.sim>0.8f){
                i=0;
            }
        }
    }

}
