package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;
    boolean bhjy=true,ytjjz = true ;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }
    /**
     * 挂机开封
     * @throws Exception
     */
    public void kaifeng() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
               gameUtil.backcity();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int h = mFairy.dateHour();
                int min = mFairy.dateMinute();
                int wek = mFairy.week();
                LtLog.e("开封挂机中。。。");
                LtLog.e("北京时间："+h+":"+min+";"+"星期:"+wek);
                if(AtFairyConfig.getOption("bhjy").equals("1") &&h == 19 && min >=30 && bhjy){
                    LtLog.e("进入帮会聚饮");
                    drinking();
                    bhjy =false;
                }

                if(AtFairyConfig.getOption("ytjjz").equals("1") &&h == 20 && min < 30 && ytjjz && wek ==1){
                    LtLog.e("进入影堂精英战");
                    eliteWar();
                    ytjjz =false;
                }

                mFairy.sleep(5000);
            }
            public void content_2() throws Exception {

            }

        }.taskContent(mFairy, "挂机开封");
    }

    /**
     * 帮会聚饮
     * @throws Exception
     */
    public void drinking() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {
                int h = mFairy.dateHour();
                if (h>=20){
                    LtLog.e("任务时间到结束");
                    setTaskEnd();
                    return;
                }

            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("Drinking.png",1);
                if (ret ==1 ){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();
                    return;
                }

            }
            public void content_2() throws Exception {
                result = mFairy.findPic("gang juyin.png");
                mFairy.onTap(0.8f,result,"帮会聚饮",Sleep);

                result = mFairy.findPic("gang canyu.png");
                mFairy.onTap(0.8f,result,"前往参与",Sleep);

                result = mFairy.findPic(55,112,230,347,"juyin.png");
                mFairy.onTap(0.8f,result,"聚饮",3000);

                result = mFairy.findPic("shouji.png");
                mFairy.onTap(0.7f,result,"品尝",Sleep);

                result = mFairy.findPic(43,106,303,341,"juyin reward.png");
                if (result.sim > 0.8f){
                    LtLog.e("完成了");
                   setTaskEnd();
                   return;
                }



            }

        }.taskContent(mFairy, "帮会聚饮");
    }

    /**
     * 影堂精英战
     * @throws Exception
     */
    public void eliteWar() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {
                int h = mFairy.dateHour();
                int min = mFairy.dateMinute();
                if (h!=20 && min>30){
                    LtLog.e("不在任务时间结束");
                    setTaskEnd();
                    return;
                }
                if (h == 20 && min > 30){
                    LtLog.e("任务时间已过结束");
                    setTaskEnd();
                    return;
                }

            }
            public void content_0() throws Exception {
                gameUtil.backcity();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("Elite.png",1);
                if (ret ==1 ){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();
                    return;
                }

            }
            public void content_2() throws Exception {
                long datatime = mFairy.mMatTime(1197,104,19,7,0.9f);
                result = mFairy.findPic("end.png");
                if (result.sim > 0.8f){
                    LtLog.e("打完了");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("traitor.png");
                mFairy.onTap(0.8f,result,"点击叛徒",Sleep);

                result = mFairy.findPic(961,306,1074,668,"recommend.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,result.x+80,result.y+1,result.x+82,result.y+3,"推荐前往",Sleep);
                }else {
                    result = mFairy.findPic(1036,301,1195,675,"elite go.png");
                    mFairy.onTap(0.8f,result,"前往",3000);
                }

                if (datatime >= 30 ){
                    mFairy.onTap(696,571,706,580,"开自动",3000);
                }

                if (datatime >= 60){
                    setTaskName(1);return;
                }

            }

        }.taskContent(mFairy, "影堂精英战");
    }

}
