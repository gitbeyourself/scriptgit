package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    public Abnormal(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
    }
    int count_1=0;
    String task_id= AtFairyConfig.getOption("task_id");
    //全局处理
    public void erro() throws Exception {

        result =mFairy.findPic(465,921,715,1040,new String[]{"automatic.png","automatic2.png","auto2.png"});
        mFairy.onTap(0.8f,result,"err打开自动",Sleep);

        result =mFairy.findPic(447,926,708,1028,"auto.png");
        mFairy.onTap(0.8f,result,"err打开自动",Sleep);

        if (count_1==0) {
            result = mFairy.findPic("fourbei.png");
            mFairy.onTap(0.8f, result, "err四倍速度", 500);
            result1 = mFairy.findPic("beginfour.png");
            if (result.sim < 0.8f && result1.sim < 0.8f) {
                result = mFairy.findPic(447,926,708,1028,"beisu.png");
                mFairy.onTap(0.8f, result, "err双倍速度", 500);
            }
        }
        result =mFairy.findPic("su.png");
        if (result.sim > 0.8f){
            count_1 =1;
        }else {
            count_1 =0;
        }
        result =mFairy.findPic("Upper limit of props.png");
        mFairy.onTap(0.8f,result,343,838,361,849,"err道具上限",Sleep);

        result =mFairy.findPic(29,179,703,374,"yxfc.png");
        mFairy.onTap(0.8f,result,639,255,660,279,"关闭",Sleep);

        result =mFairy.findPic(29,179,703,374,"mjxc.png");
        mFairy.onTap(0.8f,result,639,255,660,279,"关闭",Sleep);

        result =mFairy.findPic(271,256,472,400,"jl.png");
        mFairy.onTap(0.8f,result,332,858,354,876,"err奖励确认",Sleep);

        result =mFairy.findPic("Upper limit of props2.png");
        mFairy.onTap(0.8f,result,344,833,359,847,"err道具上限",Sleep);

        result =mFairy.findPic(113,198,598,438,"hdjl.png");
        mFairy.onTap(0.8f,result,629,179,641,201,"奖励确认",Sleep);

        result =mFairy.findPic(49,337,663,570,"ksgj.png");
        mFairy.onTap(0.8f,result,246,836,269,849,"快速挂机关闭",Sleep);

        result = mFairy.findPic(new String[]{"start-up.png","start-up2.png"});
        mFairy.onTap(0.8f,result,"err启动游戏",Sleep);

        result =mFairy.findPic(48,598,706,1074,"jllq.png");
        mFairy.onTap(0.8f,result,"奖励领取",Sleep);

        result =mFairy.findPic("network environment.png");
        mFairy.onTap(0.8f,result,222,837,236,850,"err连接失败检查网络环境重试",Sleep);

        result =mFairy.findPic("continue2.png");
        mFairy.onTap(0.8f,result,"err继续",Sleep);

        result =mFairy.findPic("jj.png");
        mFairy.onTap(0.8f,result,"err奖励",Sleep);

        result =mFairy.findPic("blinda.png");
        mFairy.onTap(0.8f,result,362,1157,373,1164,"err关闭贝琳达",Sleep);

        result =mFairy.findPic("xukong.png");
        mFairy.onTap(0.8f,result,605,167,623,182,"err关闭虚空",Sleep);

        result =mFairy.findPic("jbs.png");
        mFairy.onTap(0.8f,result,349,955,366,972,"锦标赛领取",Sleep);

        result =mFairy.findPic(new String[]{"super value.png","super value1.png"});
        mFairy.onTap(0.8f,result,299,1174,308,1186,"err关闭超值",2000);

        result =mFairy.findPic("Failure in validation.png");
        mFairy.onTap(0.8f,result,479,844,489,853,"err效验失败",Sleep);

        result =mFairy.findPic(new String[]{"shiyong.png","fell.png"});
        mFairy.onTap(0.8f,result,640,278,654,294,"err免费使用三天",Sleep);

        result =mFairy.findPic("new hero2.png");
        mFairy.onTap(0.8f,result,28,1208,36,1219,"err新英雄",Sleep);
        result =mFairy.findPic("jiyu.png");
        mFairy.onTap(0.8f,result,607,334,620,351,"err际遇梦境",Sleep);

        result =mFairy.findPic("yinyou.png");
        mFairy.onTap(0.8f,result,367,1191,374,1197,"err吟游诗人弹窗",Sleep);

        result =mFairy.findPic("qingkong.png");
        mFairy.onTap(0.8f,result,463,839,475,850,"err清空确定",Sleep);
    }



}
