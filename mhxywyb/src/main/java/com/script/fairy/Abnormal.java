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
        result = mFairy.findPic("huafei.png");
        mFairy.onTap(0.8f, result, 195,705,205,715,"取消", 2000);

        result = mFairy.findPic("vipage.png");
        mFairy.onTap(0.8f,result,672,83,688,96,"关闭VIP页面",Sleep);

        result = mFairy.findPic("te.png");
        mFairy.onTap(0.8f,result,577,164,588,170,"关闭VIP页面",Sleep);

        result = mFairy.findPic("go decompose.png");
        mFairy.onTap(0.8f,result,494,704,525,722,"背包满了前去分解",Sleep);

        result = mFairy.findPic(new String[]{"go decompose vip.png","go decompose vip2.png"});
        mFairy.onTap(0.8f,result,494,704,525,722,"背包满了前去分解vip",Sleep);

        result = mFairy.findPic(new String[]{"svipfenjie.png","decompose.png","fenjie.png","vipfenjie2.png"});
        mFairy.onTap(0.8f,result,"去分解",Sleep);

        result = mFairy.findPic(419,910,609,969,"decompose.png");
        mFairy.onTap(0.8f,result,"分解50件",Sleep);

        result = mFairy.findPic(new  String[]{"null.png","vipfenjie.png"});
        mFairy.onTap(0.8f,result,661,156,676,173,"分解完了关掉当前页面",Sleep);
        mFairy.onTap(0.8f,result,675,82,688,97,"分解完了关掉当前页面",Sleep);

        result = mFairy.findPic("off-line.png");
        mFairy.onTap(0.8f,result,347,837,371,852,"离线收益",Sleep);

        result = mFairy.findPic("Disconnection.png");
        mFairy.onTap(0.8f,result,359,717,369,724,"断线重连失败确定",Sleep);

        result = mFairy.findPic("Time limit.png");
        mFairy.onTap(0.8f,result,677,403,688,417,"限时秒杀关闭",Sleep);

        result = mFairy.findPic("hdgb.png");
        mFairy.onTap(0.8f,result,"端午活动关闭",Sleep);

        result = mFairy.findPic(new String[]{"ganwu.png","vipganwu.png"});
        mFairy.onTap(0.8f,result,617,293,628,301,"感悟手礼叉",Sleep);

        result = mFairy.findPic(new String[]{"start-up.png","start-up2.png"});
        mFairy.onTap(0.8f,result,"err启动游戏",Sleep);

        result = mFairy.findPic(new String[]{"sure.png"});
        mFairy.onTap(0.8f,result,"err同意并继续",Sleep);

        result = mFairy.findPic("arrow.png");
        mFairy.onTap(0.8f,result,"err箭头",Sleep);

        result = mFairy.findPic("binding.png");
        mFairy.onTap(0.8f,result,202,722,217,733,"err下次再说",Sleep);

        result = mFairy.findPic(new String[]{"login.png","login2.png"});
        mFairy.onTap(0.8f,result,"err登陆",Sleep);

        result = mFairy.findPic(new String[]{"xianqipu.png","vipsqp.png"});
        mFairy.onTap(0.8f,result,622,289,634,305,"err关闭guanggao",Sleep);

        result = mFairy.findPic("seckill.png");
        mFairy.onTap(0.8f,result,676,448,689,458,"err限时秒杀",Sleep);

        result = mFairy.findPic("everyday.png");
        mFairy.onTap(0.8f,result,662,526,676,539,"err每日礼包弹窗 关闭",Sleep);

        result = mFairy.findPic("yfdt.png");
        mFairy.onTap(0.8f,result,674,89,696,108,"err迎福大厅弹窗 关闭",Sleep);

        result1 = mFairy.findPic("bzxs.png");
        if (result1.sim> 0.8f) {
            mFairy.onTap(0.8f, result1, 644,1198,704,1244, "关闭广告", Sleep);
        }

        result = mFairy.findPic("jijiangvip.png");
        mFairy.onTap(0.8f,result,667,326,678,337,"err即将开启 关闭",Sleep);

        result = mFairy.findPic("hui.png");
        mFairy.onTap(0.8f,result,579,221,588,231,"err150级特惠 关闭",Sleep);

        result = mFairy.findPic("shoumai.png");
        mFairy.onTap(0.8f,result,597,353,605,363,"err程咬金限时售卖 关闭",Sleep);

        result = mFairy.findPic(new String[]{"cha2.png","huodcha.png","cha3.png"});
        mFairy.onTap(0.8f,result,"err关闭",Sleep);
    }



}
