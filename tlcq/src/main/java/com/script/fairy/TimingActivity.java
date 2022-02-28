package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    static int xshd_1 = 0, xshd_2 = 0, xshd_3 = 0, xshd_4 = 0, xshd_5 = 0, xshd_6 = 0;
    static int xshd_7 = 0, xshd_8 = 0, xshd_9 = 0, xshd_10 = 0, xshd_11 = 0, xshd_12 = 0;
    boolean scn=true;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }

}
