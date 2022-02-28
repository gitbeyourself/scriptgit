package com.example.administrator.yys;


import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity {//限时任务

    yys mFairy;
    FindResult result;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;
    int hour;
    int minute;
    int week;

    public TimingActivity(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
    }
}
