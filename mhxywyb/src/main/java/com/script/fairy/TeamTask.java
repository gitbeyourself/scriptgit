package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    GameUtil gameUtil;
    List<String> list = new ArrayList<>();
    OtherGame otherGame;
    public TeamTask(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ATFairy;
        otherGame=new OtherGame(mFairy);
    }



}
