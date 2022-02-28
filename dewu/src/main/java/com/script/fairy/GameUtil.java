package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    private static AtFairyImpl mFairy;

    FindResult result;
    FindResult result1;

    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        Sleep = 1500;
        SleepWhile = 300;
    }

    public void inOperation() throws Exception {

    }


    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 1;
            public void content_0() throws Exception {



                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result = mFairy.findPic(579,50,715,151, "cancel.png");
                    mFairy.onTap(0.8f, result, "取消", Sleep);

                    result = mFairy.findPic(79,77,182,181, "cha3.png");
                    mFairy.onTap(0.8f, result, "关叉2", Sleep);

                    result = mFairy.findPic(561,263,709,394, new String[]{"cha2.png","cha4.png"});
                    mFairy.onTap(0.8f, result, "关叉2", Sleep);


                    result1 = mFairy.findPic(604, 709, 713, 914, "cha1.png");
                    mFairy.onTap(0.85f, result, "关叉", Sleep);

                    result = mFairy.findPic(19, 52, 101, 132, "fanhui.png");
                    mFairy.onTap(0.85f, result, "返回", Sleep);

                    if ( result.sim > 0.85f || result1.sim > 0.85f) {
                        j = 10;
                    } else {
                        j = 2;
                    }
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

}
