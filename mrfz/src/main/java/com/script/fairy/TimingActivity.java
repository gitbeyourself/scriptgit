package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    static  int xshd_1 = 0, xshd_2 = 0, xshd_3 = 0 , xshd_4 = 0, xshd_5 = 0, xshd_6 = 0;
    static  int xshd_7= 0, xshd_8 = 0, xshd_9= 0 , xshd_10 = 0, xshd_11 = 0, xshd_12 = 0;
    public TimingActivity(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        util = new Util(mFairy);
    }


    public int  timingActivity() throws Exception {
        int h=mFairy.dateHour();
        int m=mFairy.dateMinute();
        int w=mFairy.week();
        return 0;
    }

}
