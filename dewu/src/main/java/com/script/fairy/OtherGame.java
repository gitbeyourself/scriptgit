package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.Random;

/**
 * Created by Administrator on 2019/11/5 0005.
 */

public class OtherGame  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    GameUtil gameUtil;
    public OtherGame(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
    }
    public void inOperation() throws Exception {

    }


}
