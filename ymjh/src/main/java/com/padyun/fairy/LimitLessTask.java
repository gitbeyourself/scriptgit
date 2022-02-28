package com.padyun.fairy;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;

import org.opencv.photo.MergeDebevec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitLessTask extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    int picCount=0;
    TimingActivity timingActivity;
    public LimitLessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity=new TimingActivity(mFairy);
    }
    @Override
    public void inOperation() throws Exception {
    }
}

