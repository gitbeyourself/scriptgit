package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;


public class TeamTask  extends TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    GameUtil gameUtil;
    GameUtil yxdUtil ;
    OtherGame otherGame;
    public TeamTask(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ATFairy;
        yxdUtil=new GameUtil(mFairy);
        otherGame=new OtherGame(mFairy);
    }


    public void inOperation() throws Exception {

    }

}
