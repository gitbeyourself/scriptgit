package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.LtLog;

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;

    GameUtil gameUtil;

    public TimingActivity(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);
    }

    public int timingActivity() throws Exception {
        int h = mFairy.dateHour();
        int m = mFairy.dateMinute();
        int w = mFairy.week();
        int s=(h*60+m)*60;
        int sm = s*1000;
        int back=0;
        for (int i=0 ;i<=1;i++) {
            LtLog.e("查看限时任务！！！！！");


        }
        return back;

    }

    public void inOperation() throws Exception {

    }


}
