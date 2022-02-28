package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    public GameUtil(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }

    /**
     * 关叉
     * @param
     * @throws Exception
     */
    public void close() throws Exception {
        new GameUtil(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result =mFairy.findPic(new String[]{"myhome.png","ksgjcha.png","gjcha.png","quxiao.png","pqcha.png","jbcha.png","mrcha.png","hycha.png","yjcha.png","jjcha.png","jjccha.png","dhmcha.png","rwcha.png","gkcha.png","cha.png"});
                    mFairy.onTap(0.75f,result,"关闭",Sleep);
                    result1 =mFairy.findPic(2,989,140,1269,"gjcha.png");
                    mFairy.onTap(0.8f,result1,"关闭",Sleep);
                    result2 =mFairy.findPic( 106,739,375,998,"quxiao.png");
                    mFairy.onTap(0.8f,result2,"关闭",Sleep);
                    result3 =mFairy.findPic( 518,3,717,404,new String[]{"kxcha.png","kxcha1.png"});
                    mFairy.onTap(0.8f,result3,"关闭",Sleep);


                    if (result.sim > 0.75f || result1.sim > 0.8f|| result2.sim >0.8f || result3.sim > 0.8f) {
                        j = 5;
                    } else {
                        j = 2;
                    }
                    result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","paper.png","chengj.png"});
                    mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                    result =mFairy.findPic("chongz.png");
                    mFairy.onTap(0.8f,result,318,1063,369,1087,"战斗失败重试",Sleep);
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

}
