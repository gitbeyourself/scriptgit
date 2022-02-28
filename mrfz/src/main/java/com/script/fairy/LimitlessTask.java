package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {
    AtFairyImpl mFairy;
    FindResult result;
    TimingActivity timingActivity;
    Util util;

    public LimitlessTask(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        util = new Util(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }

}
