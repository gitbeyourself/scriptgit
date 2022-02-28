package com.example.administrator.sh;

import com.script.opencvapi.FindResult;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {//无限任务

    sh mFairy;
    FindResult result;
    private CommonFunction comm;
    private GamePublicFunction gamePublicFunction;
    private TimingActivity timingActivity;
    private int hour;

    public LimitlessTask(sh ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }
    /*
        无限任务
     */


}
