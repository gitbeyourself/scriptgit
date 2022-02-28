package com.example.administrator.sh;

import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity {//限时任务

    sh mFairy;
    FindResult result;
    private CommonFunction comm;
    private GamePublicFunction gamePublicFunction;
    int hour;
    int minute;
    int week;

    public TimingActivity(sh ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
    }
    /*
        限时任务
     */

}
