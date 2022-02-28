package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/11/5 0005.
 */

public class OtherGame {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    public OtherGame(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }


}
