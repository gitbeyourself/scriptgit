package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public Util(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    public void close() throws Exception {
        mFairy.condit();


        result = mFairy.findPic(426,10,1272,464,"fork.png");
        mFairy.onTap(0.8f, result, "叉", 1000);
        result = mFairy.findPic(426,10,1272,464,"fork.png");
        mFairy.onTap(0.8f, result, "叉", 1000);
    }
    public void backCity() throws Exception {
        for (int i=0;i<5;i++){
            mFairy.condit();
            result = mFairy.findPic("activity.png");
            mFairy.onTap(0.8f, result, 1186,79,1204,91,"活动点地图", 1000);

            result = mFairy.findPic("map_inface.png");
            mFairy.onTap(0.8f, result, 1140,265,1151,284,"地图界面", 2000);
            mFairy.onTap(0.8f, result, 736,356,765,377,"轩辕", 1000);
            mFairy.onTap(0.8f, result, 737,472,767,483,"确定传送", 5000);
            if (result.sim>0.8f){
                break;
            }
        }
       close();
    }


    int bj_1=0;
    int  cs_1=0;
    //重置
    public int  reset(int bj,int wrong) throws Exception {
            if (bj_1 == bj && bj !=wrong) {
                cs_1++;
            } else if (bj_1 != bj) {
                cs_1 = 0;
                bj_1 = bj;
                LtLog.e(mFairy.getLineInfo("标记发生变化"));
            }
            if (cs_1 > 50) {
                LtLog.e(mFairy.getLineInfo("标记长时间未发生变化"));
                return  0;
            }
            return  1;
    }
}
