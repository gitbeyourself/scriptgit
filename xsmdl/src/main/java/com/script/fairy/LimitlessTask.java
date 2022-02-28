package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask  extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    OtherGame otherGame;
    SingleTask singleTask;
    TeamTask teamTask;
    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        singleTask=new SingleTask(mFairy);
        teamTask=new TeamTask(mFairy);
    }

    SingleTask singleTask1 = new SingleTask(mFairy);
    /**
     * 挂机任务
     * 野外挂机
     * @throws Exception
     */
    public void outdoorsOnHook() throws Exception {
        new LimitlessTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String endless_abyss="Hangs1.png";
                int mission = gameUtil.mission(endless_abyss, 0);
                if(mission==1){
                    setTaskName(2);
                }else {
                    setTaskEnd();
                    return;
                }
                LtLog.e("野外挂机");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("Hang.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result,"前往挂机", 2000);
                }
            }
        }.taskContent(mFairy,"野外挂机");
    }



}
