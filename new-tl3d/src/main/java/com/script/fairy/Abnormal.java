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

    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    int count_1 = 0;
    String task_id = AtFairyConfig.getOption("task_id");

    //全局处理
    public void erro() throws Exception {

        mFairy.findPicWithExpansion(20, "death.png");

        if (AtFairyConfig.getOption("dyms").equals("1")) {
            result = mFairy.findPic(371, 273, 910, 423, new String[]{"teamsure.png", "teamsure1.png"});
            mFairy.onTap(0.8f, result, 537, 451, 538, 452, "error组队确定", Sleep);
        }

        result = mFairy.findPic(new String[]{"ai1.png","ai2.png"});
        if (picCount(0.85f, result, "err切换到任务栏") > 3) {
            mFairy.onTap(0.85f, result, 32, 237, 53, 250, "err切换到任务栏", Sleep);
        }

        result = mFairy.findPic("erryp.png");
        mFairy.onTap(0.85f, result, "err云派启动", 1000);

        result = mFairy.findPic(371, 273, 910, 423, "horn.png");
        mFairy.onTap(0.8f, result, "error喇叭", Sleep);

        result = mFairy.findPic(344,215,928,507, "cs.png");
        mFairy.onTap(0.8f, result,533,446,553,458, "确定", Sleep);


        result = mFairy.findPic(459, 24, 815, 125, "Notice.png");
        mFairy.onTap(0.8f, result, 1106, 68, 1107, 69, "error公告", Sleep);

        result = mFairy.findPic("shiming.png");
        mFairy.onTap(0.8f, result, 939, 93, 940, 94, "error实名", Sleep);


        result = mFairy.findPic(377, 60, 1139, 650, "xmscancel.png");
        mFairy.onTap(0.8f, result, "error小秘书取消", Sleep);


        result = mFairy.findPic(new String[]{"Opentaskbar.png", "Opentaskbar1.png"});
        mFairy.onTap(0.85f, result, "error左侧任务栏", Sleep);

        result = mFairy.findPic(388,294,899,400, "jrts.png");
        mFairy.onTap(0.8f, result,508,435,570,461, "进入提示", Sleep);

        result = mFairy.findPic("redbao.png");
        mFairy.onTap(0.8f, result, "error红包", Sleep);

        result = mFairy.findPic("errConnect.png");
        mFairy.onTap(0.8f, result, 643, 450, 644, 451, "error连接丢失", Sleep);

        result = mFairy.findPic(475,557,816,668,"errLogininterface.png");
        if (result.sim > 0.8f) {
            qudao();
            result = mFairy.findPic("errLogininterface.png");
            mFairy.onTap(0.8f, result, "error登录游戏界面", 5000);
        }

        result = mFairy.findPic(789, 462, 1276, 715, new String[]{"Entergame.png", "Entergame1.png"});
        if (picCount(0.8f, result, "err角色登录界面") > 30) {
            mFairy.onTap(0.8f, result, "err角色登录界面", Sleep);
        }
        result = mFairy.findPic(334, 156, 575, 370, "cbgtransport.png");
        mFairy.onTap(0.8f, result, "error藏宝阁输了", Sleep);

        if (!(task_id.equals("193")) && !(task_id.equals("1068"))) {
            result = mFairy.findPic(new String[]{"cbgleave.png", "jia5.png"});
            mFairy.onTap(0.8f, result, "error藏宝阁离开", Sleep);
        }
        result = mFairy.findPic("qhValuables.png");
        mFairy.onTap(0.8f, result, 536, 451, 537, 452, "error强化贵重物品确定", Sleep);

        result = mFairy.findPic(327,124,961,505,"OverGraph.png");
        mFairy.onTap(0.8f, result, 536, 451, 537, 452, "error过图提醒", Sleep);

        /**/

        result = mFairy.findPic(185, 496, 471, 667, "jia1.png");
        mFairy.onTap(0.8f, result, "完成任务", Sleep);

        result = mFairy.findPic(185, 496, 471, 667, "jia4.png");
        mFairy.onTap(0.8f, result, "接取任务", Sleep);

        mFairy.findPicWithExpansion(20,"equipment.png");

        result = mFairy.findPic(374 ,284,414,324,"xsbecome.png");
        mFairy.onTap(0.8f, result, 534, 465, 535, 466, "error结义弹框", Sleep);

        result = mFairy.findPic(382,286,424,326,"Helpprompting.png");
        mFairy.onTap(0.8f, result, 742, 454, 743, 455, "error未加入帮会", Sleep);

        result = mFairy.findPic(341, 215, 760, 416, "Giveuptaskprompt.png");
        mFairy.onTap(0.8f, result, 539, 454, 540, 455, "error放弃任务", Sleep);

        result = mFairy.findPic("qinhuang3.png");
        mFairy.onTap(0.8f, result, 539, 451, 540, 452, "error秦皇3确定", Sleep);

        result = mFairy.findPic(427,261,904,408,"yqjr.png");
        mFairy.onTap(0.8f, result, 727,442,739,453, "拒绝加入队伍", Sleep);

        result = mFairy.findPic(455,294,863,379,"jwhy.png");
        mFairy.onTap(0.8f, result, 713,436,736,456, "取消关注", Sleep);

        result = mFairy.findPic("errzhanlidi.png");
        mFairy.onTap(0.8f, result, 1146, 47, 1147, 48, "error战力低", Sleep);


        result = mFairy.findPic(291, 233, 1038, 564, "noknowcancel.png");
        if (picCount(0.8f, result, "error不造是什么确定") > 5) {
            mFairy.onTap(0.8f, result, "error不造是什么确定", Sleep);
        }

        result1 = mFairy.findPic(291, 233, 1038, 564, "noknowcancel.png");
        if (result1.sim > 0.8f) {

            result = mFairy.findPic(353, 242, 662, 406, "jia7.png");
            if (result.sim > 0.8f) {
                mFairy.onTap(0.8f, result, 502, 445, 539, 454, "退出副本", 3000);
                return;
            }

            result = mFairy.findPic(397, 226, 870, 447, "jia9.png");
            if (result.sim > 0.8f) {
                mFairy.onTap(0.8f, result, 502, 445, 539, 454, "退出副本", 3000);
                return;
            }

            result = mFairy.findPic(383, 245, 914, 449, "jia11.png");
            if (result.sim > 0.8f) {
                mFairy.onTap(409, 401, 427, 415, "", 500);
                mFairy.onTap(519, 440, 564, 458, "确定进入场景", 3000);
                return;
            }
        }

        if (picCount(0.8f, result1, "error不造是什么取消") > 5) {
            mFairy.onTap(0.8f, result1, "error不造是什么取消", Sleep);
        }

        if (timekeep(0, 300000, "err取消一下挂机")) {
            result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
            mFairy.onTap(0.8f, result, "err挂机中取消", Sleep);
        }
        qudao();
    }

    public void qudao() throws Exception {


        result = mFairy.findPic(153, 743, 516, 1176, "login1.png");
        mFairy.onTap(0.8f, result, "qq授权登录", Sleep);

        result = mFairy.findPic("qd1.png");
        mFairy.onTap(0.8f, result, "渠道-手游猪-登录", 2000);

        result = mFairy.findPic("qd2.png");
        mFairy.onTap(0.8f, result, "渠道-汉风-登录", 2000);

        result = mFairy.findPic("qd6.png");
        mFairy.onTap(0.8f, result, 410, 532, 504, 545, "渠道-汉风-选择小号", 2000);

        result = mFairy.findPic("qd3.png");
        mFairy.onTap(0.8f, result, 883, 92, 904, 112, "渠道-oppo-关闭实名注册", 2000);

        result = mFairy.findPic("qd4.png");
        mFairy.onTap(0.8f, result, 909, 83, 918, 100, "渠道-oppo-关闭公告", 2000);

        result = mFairy.findPic("qd5.png");
        mFairy.onTap(0.8f, result, 859, 393, 881, 413, "渠道-oppo-关闭信息界面", 2000);

        result = mFairy.findPic("qd7.png");
        mFairy.onTap(0.8f, result, "渠道-天宇-登录", 2000);

        result = mFairy.findPic(429, 372, 860, 581, new String[]{"qd8.png", "qd13.png"});
        mFairy.onTap(0.8f, result, "渠道-说玩-登录", 2000);

        result = mFairy.findPic("qd9.png");
        mFairy.onTap(0.8f, result, "渠道-说玩-跳过", 2000);

        result = mFairy.findPic("qd10.png");
        mFairy.onTap(0.8f, result, 519, 194, 568, 220, "渠道-九游-选择账号", 2000);

        result = mFairy.findPic("qd11.png");
        mFairy.onTap(0.8f, result, "渠道-九游-暂不认证", 2000);

        result = mFairy.findPic("qd12.png");
        mFairy.onTap(0.8f, result, "渠道-九游-知道了", 2000);

        result = mFairy.findPic(768, 16, 1109, 189, "qd99.png");
        mFairy.onTap(0.95f, result, "渠道-oppo-关闭广告", 2000);

    }//渠道

}
