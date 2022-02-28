package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.FindResult;


/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

    }
    int js_1=0,js_2=0;
    //全局处理
    public void erro() throws Exception {
        result = mFairy.findPic("Total.png" );
        mFairy.onTap(0.8f, result, 662,1207,684,1224,"err合击", 1000);


        result = mFairy.findPic(298,636,421,737,"hongbao.png" );
        mFairy.onTap(0.8f, result, "err红包", 1000);

        result = mFairy.findPic("qiang.png" );
        mFairy.onTap(0.8f, result, "err抢" , 1000);

        result = mFairy.findPic("duihuakuang.png" );
        mFairy.onTap(0.8f, result, "err对话框", 1000);

        result = mFairy.findPic("pkquxiao.png" );
        mFairy.onTap(0.8f, result, "errpk取消", 1000);
        mFairy.onTap(0.8f, result, 651,1206,678,1225,"errpk取消", 1000);


    }


}
