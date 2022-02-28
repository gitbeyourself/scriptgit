package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/11/5 0005.
 */

public class OtherGame  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;

    GameUtil gameUtil;
    public OtherGame(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gameUtil = new GameUtil(mFairy);
    }
    public void inOperation() throws Exception {
        result = mFairy.findPic(895,410,1188,567,"dialogue.png");
        if (result.sim > 0.8f) {
            mFairy.onTap(0.8f, result, 681,685,695,695,"对话中", Sleep);
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }



}
