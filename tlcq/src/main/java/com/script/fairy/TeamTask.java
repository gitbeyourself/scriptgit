package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    GameUtil gameUtil;
    List<String> list = new ArrayList<>();
    YxdUtil yxdUtil ;
    YxdUtil zm ;
    YxdUtil clearbag;
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        yxdUtil=new YxdUtil(mFairy);
        zm=new YxdUtil(mFairy);
        clearbag=new YxdUtil(mFairy);
    }


}
