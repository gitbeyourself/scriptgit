package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }
}
