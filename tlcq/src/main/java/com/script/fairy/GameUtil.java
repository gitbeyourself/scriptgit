package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }
    void  close() throws Exception {
        for (int i=0;i<2;i++){
            mFairy.condit();
            result = mFairy.findPic(10,9,1270,486,"fork.png");
            mFairy.onTap(0.8f, result, "叉", Sleep);
        }
    }

}
