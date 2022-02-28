package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    AtFairyImpl mFairy1;
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

    }
    int count_1=0;
    //全局处理
    public void erro() throws Exception {
        result = mFairy.findPic("dutiao.png");
        if (picCount(0.8f,result,"卡读条")>300){
            LtLog.e(mFairy.getLineInfo("卡死重启"));
            mFairy.killUserGame();
        }
        result = mFairy.findPic(545,624,744,690, "sygj1.png");
        mFairy.onTap(0.8f, result, "err手游管家", Sleep);

        result = mFairy.findPic("jryx.png");
        mFairy.onTap(0.8f, result, "err进入游戏", Sleep);

        result = mFairy.findPic("jryx1.png");
        mFairy.onTap(0.8f, result, "err进入游戏1", Sleep);
        if (result.sim>0.8f){
            result = mFairy.findPic("jryx1.png");
            mFairy.onTap(0.8f, result, 106,634,145,650,"err无法进入游戏返回一下", Sleep);
        }

        result = mFairy.findPic("sure.png");
        mFairy.onTap(0.8f, result, "err公告确定", Sleep);

        result = mFairy.findPic("ljsure.png");
        mFairy.onTap(0.8f, result, "err确定重连", Sleep);

        result = mFairy.findPic("sure1.png");
        mFairy.onTap(0.8f, result, "err确定更新", Sleep);
        Thread.sleep(2000);
    }



}
