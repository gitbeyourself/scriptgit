package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    SingleTask singleTask;
    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        singleTask=new SingleTask(mFairy);
    }
    //挂机
    public void hangUp() throws Exception {
        new LimitlessTask(mFairy) {
            int count = 0;
            int hs = 1;
            int rzcount = 0;
            int zbcount = 1;
            int sjcount = 0;
            int mjcount = 0;

            @Override
            public void create() throws Exception {
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            int xshd_1 = 0;
            int xshd_2 = 0;
            int xshd_3 = 0;

            public void content_1() throws Exception {
                Thread.sleep(10000);
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();

                //一乐拉面
                if ((h == 12 || h == 17 || h == 21) && xshd_1 == 0 && AtFairyConfig.getOption("yile").equals("1")) {
                    singleTask.yile();
                    xshd_1 = 1;
                    setTaskName(0);
                    return;
                }
                if (h != 12 && h != 17 && h != 21) {
                    xshd_1 = 0;
                }

                //任务集会所
                //3600 000 =60*60*1000
                if (timekeep(0,3600000,"挂机会所")&& AtFairyConfig.getOption("hs").equals("1")) {
                    singleTask.club();
                    setTaskName(0);
                    return;
                }

                //精英
                //7200 000=2*60*60*1000
                if (timekeep(0,7200000,"挂机精英")) {
                   singleTask.elite();
                    setTaskName(0);
                    return;
                }

                //升级
                //7200 000=2*60*60*1000
                if (timekeep(0,7200000,"挂机升级") && AtFairyConfig.getOption("sd").equals("1")) {
                    singleTask.equip();
                    setTaskName(0);
                    return;
                }

                //招募
                //3600 000=60*60*1000
                if (timekeep(0,3600000,"招募") && AtFairyConfig.getOption("zm").equals("1")) {
                   singleTask.zhaoMu();
                    setTaskName(0);
                    return;
                }

                //
                if (AtFairyConfig.getOption("5cq").equals("1") && h == 5) {
                    LtLog.e("5点重启");
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"挂机中");
    }
}
