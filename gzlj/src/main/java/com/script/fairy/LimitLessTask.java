package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;
/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitLessTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    int picCount=0;
    TimingActivity timingActivity;
    public LimitLessTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        util = new Util(mFairy);
        timingActivity=new TimingActivity(mFairy);
    }
    @Override
    public void inOperation() throws Exception {
    }
}

