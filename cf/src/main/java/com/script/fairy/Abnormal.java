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
         Thread.sleep(1000);
      /*  result = mFairy.findPic(24,549,714,1155,"checkvx3.png");
        mFairy.onTap(0.8f, result, "err登录", 1000);*/
        result=mFairy.findPic("tap.png");
        mFairy.onTap(0.8f,result,"err点击屏幕继续",1000);

        result = mFairy.findPic("dkqb.png");
        mFairy.onTap(0.8f, result, "err打开全部", 1000);

        result = mFairy.findPic("jlsure2.png");
        mFairy.onTap(0.8f, result, "err奖励确定2", 1000);

        result = mFairy.findPic("jxpp.png");
        mFairy.onTap(0.8f, result, "err网络差继续匹配", 1000);

        result = mFairy.findPic("smxx_sure.png");
        mFairy.onTap(0.8f, result, "err实名确定", 1000);

        result = mFairy.findPic("wlzt_sure.png");
        mFairy.onTap(0.8f, result, "err网络状态确定", 1000);

        result = mFairy.findPic("agree.png");
        mFairy.onTap(0.8f, result, "err同意", 1000);

        result = mFairy.findPic("qqsign_in.png");
        mFairy.onTap(0.8f, result, "errqq登录", 1000);

        result = mFairy.findPic("temporarily.png");
        mFairy.onTap(0.8f, result, "err暂不加速", 1000);

        result = mFairy.findPic("download.png");
        mFairy.onTap(0.9f, result, "err确认下载", 1000);

        result = mFairy.findPic("cxlj.png");
        mFairy.onTap(0.8f, result, "err重新连接", 1000);


        result = mFairy.findPic("network_anomaly.png");
        mFairy.onTap(0.8f, result, 626,509,666,533,"err网络异常", 1000);

        result = mFairy.findPic(156,613,1139,689,"7day_receive.png");
        mFairy.onTap(0.8f, result, "err天领取", 1000);

        result = mFairy.findPic("jlsure1.png");
        mFairy.onTap(0.9f, result, "err奖励确定", 1000);

        result = mFairy.findPic("ppbdsure.png");
        mFairy.onTap(0.9f, result, "err匹配不到确定", 1000);

        result = mFairy.findPic("fh_sure.png");
        mFairy.onTap(0.9f, result, "err返回确定", 1000);


        result = mFairy.findPic(545,624,744,690, "sygj1.png");
        mFairy.onTap(0.9f, result, "err手游管家", 1000);


        result = mFairy.findPic(new  String[]{"in_combat.png","in_combat1.png"});
        result=mFairy.findPic(999,49,1027,76,"fork.png");
        if (result.sim<0.8f){
            result = mFairy.findPic(401,8,1265,451,new String[]{"fork.png","hdfork.png","hdfork1.png","hdfork2.png"});
            mFairy.onTap(0.8f, result, "err叉", 1000);
        }
          /*   */
    }


}
