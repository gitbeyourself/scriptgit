package com.example.administrator.xjqxz4;


import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class Other {
    xjqxz4 mFairy;
    FindResult result;
    CommonFunction commonFunction;
    GamePublicFunction gamePublicFunction;
    public Other(xjqxz4 atFairy) {
        mFairy = atFairy;
        commonFunction = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
    }


}
