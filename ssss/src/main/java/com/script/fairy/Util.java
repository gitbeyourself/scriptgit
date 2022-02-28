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
