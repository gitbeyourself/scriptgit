package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask  extends TaskContent{
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    GameUtil gameUtil;
    OtherGame otherGame;
    public TeamTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = atFairy;
        otherGame=new OtherGame(mFairy);
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
