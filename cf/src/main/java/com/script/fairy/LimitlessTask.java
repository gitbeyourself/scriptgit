package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {
    AtFairyImpl mFairy;
    FindResult result;
    TimingActivity timingActivity;
    Util util;

    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }


    public void fieldHangUp() throws Exception {
        int bj=0;
        String string="";
        if (AtFairyConfig.getOption("map").equals("1")){
            string="map1.png";
        }
        if (AtFairyConfig.getOption("map").equals("2")){
            string="map2.png";
        }
        if (AtFairyConfig.getOption("map").equals("3")){
            string="map3.png";
        }
        if (AtFairyConfig.getOption("map").equals("4")){
            string="map4.png";
        }
        while (mFairy.condit()){
            LtLog.e(mFairy.getLineInfo("野外挂机中bj="+bj));
            Thread.sleep(2000);
            if (util.reset(bj,3)==0){
                bj=0;
            }
            if (bj==0){
                      util.close();
                      util.backCity();
                      bj=1;
            }
            if (bj==1){

                result = mFairy.findPic("organize_team.png");
                mFairy.onTap(0.9f, result,"组队", 1000);

                result = mFairy.findPic("organize_team1.png");
                mFairy.onTap(0.9f, result,"组队1", 1000);


                result = mFairy.findPic(128,56,366,599,"hanging_brush_monster.png");
                mFairy.onTap(0.8f, result, "挂机刷怪", 1000);


                result = mFairy.findPic(string);
                mFairy.onTap(0.9f, result,"地图", 1000);

                result = mFairy.findPic("switching_target.png");
                mFairy.onTap(0.8f, result,"切换目标", 1000);

                result = mFairy.findPic("create_team.png");
                mFairy.onTap(0.8f, result,"创建队伍", 1000);

                result = mFairy.findPic("go_to.png");
                mFairy.onTap(0.8f, result,"前往", 1000);
                if (result.sim>0.8f){
                    util.close();
                    bj=2;
                }

            }

            if (bj==2){
                long dazeTime = mFairy.mMatTime(1206,152,51,18, 0.9f);
                if (dazeTime >=10) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("到达目的地了"));
                    bj=3;
                }
            }
            if (bj==3){
                long dazeTime = mFairy.mMatTime(1007,650,31,30, 0.9f);
                if (dazeTime >=20) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("发呆了"));
                    bj=0;
                }
                result = mFairy.findPic("automatic_opening.png");
                mFairy.onTap(0.8f, result,"开启自动", 1000);

            }

        }
    }

}
