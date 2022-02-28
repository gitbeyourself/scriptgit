package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    Util util;
    public TeamTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        util = new Util(mFairy);
        mFairy1 = atFairy;
    }
    long daze=0;

    @Override
    public void inOperation() throws Exception {
        daze=util.dazeTime();
        result=mFairy.findMultiColor(7,339,35,376,0.95f,"167,175,176",
                "0|-13|219,219,219&5|-7|212,220,220&9|-3|216,220,220&10|0|216,216,216&13|0|211,219,219&9|3|211,220,221&7|5|212,220,220&5|7|208,217,217&3|9|213,215,216");
        mFairy.onTap(0.9f,result,"打开任务栏",1000);

        result=mFairy.findPic("pic change task.png");
        mFairy.onTap(0.8f,result,"切换任务分页",1000);

        result=mFairy.findPic("word btn use.png");
        mFairy.onTap(0.8f,result,"使用",1000);

        result=mFairy.findPic("word btn drink.png");
        mFairy.onTap(0.8f,result,"饮用",1000);

        result=mFairy.findPic("word hint btn affirm use.png");
        mFairy.onTap(0.8f,result,"确定使用",1000);

        result=mFairy.findPic(300,145,396,203,"pic hint.png");
        if(result.sim>0.8f){
            result=mFairy.findPic("word hint affirm.png");
            mFairy.onTap(0.8f,result,"确定",1000);
            if(result.sim>0.8f)return;

            result=mFairy.findPic(new String[]{"word hint disabled.png","word hint planes.png","word hint dont find way.png"});
            mFairy.onTap(0.8f,result,852,505,860,513,"任务失效/离开位面/无法寻路",1000);
            if(result.sim>0.8f)return;

            mFairy.onTap(414,505,421,513,"关闭/取消",1000);
        }

        result=mFairy.findPic("word serious.png");
        mFairy.onTap(0.8f,result,1013,603,1020,610,"就近复活",1000);
    }
}
