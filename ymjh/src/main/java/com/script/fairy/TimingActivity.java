package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    LimitLessTask timingActivity;
    Util util;

    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }

    //限时任务
    //世界首领 19:35-19:45 抢不到线
    public void timing_jh_sjsl()throws Exception{}

    //七星秘宝 三五日 19:00 没法寻路
    public void timing_jh_qxb()throws Exception{}

    //私塾乱斗 六 5:00
    public void timing_jh_ssld()throws Exception{}

    //武林闲趣 日 5:00
    public void timing_jh_wlxq()throws Exception{}

    //平月宴 三 21:00
    public void timing_bp_pyy()throws Exception{}

    //金陵破阵 二 日 19:45-20-25
    public void timing_bp_jlpz()throws Exception{}

    //金陵夺宝阵 四 19:45
    public void timing_bp_jlzdz()throws Exception{}
    @Override
    public void inOperation() throws Exception {
    }
}
