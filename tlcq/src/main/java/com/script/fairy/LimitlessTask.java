package com.script.fairy;

import com.script.framework.AtFairyImpl;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask extends TaskContent {
    AtFairyImpl mFairy;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    OtherGame otherGame;
    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame=new OtherGame(mFairy);
    }





}
