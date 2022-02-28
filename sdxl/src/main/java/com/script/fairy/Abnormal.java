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
        result = mFairy.findPic(383,222,920,535,"errsure.png");
        if (result.sim>0.8f){
            js_1++;
            if (js_1>20){
                mFairy.onTap(0.8f, result, "err长时间存在确定", 1000);
            }
        }else {
            js_1=0;
        }
        result = mFairy.findPic(911,47,1159,533,"errmatter.png");
        if (result.sim>0.8f){
            js_2++;
            if (js_2>30){
                mFairy.onTap(0.8f, result, 595,266,617,286,"err长时间存在右侧任务栏", 1000);
            }
        }else {
            js_2=0;
        }
        result = mFairy.findPic(502,563,834,646,"Pet eggs.png");
        if (result.sim>0.8f){
            mFairy.onTap(0.8f, result, "宠物蛋", 1000);
            mFairy.onTap(0.8f, result, "宠物蛋", 1000);
            mFairy.onTap(0.8f, result, "宠物蛋", 1000);
            mFairy.onTap(0.8f, result, "宠物蛋", 1000);
        }
        result = mFairy.findPic("Continue to be single.png");
        mFairy.onTap(0.8f, result, "err继续单人", 2000);

        result = mFairy.findPic("yaojiang.png");
        mFairy.onTap(0.8f, result, "err摇奖", 2000);
        mFairy.onTap(0.8f, result, "err摇奖", 2000);

        result = mFairy.findPic("Choose pets.png");
        mFairy.onTap(0.8f, result, 250, 361, 288, 394, "选择宠物", 100);
        mFairy.onTap(0.8f, result, 982,598,1030,620, "带她回家", 1000);

        result = mFairy.findPic("Take her home.png");
        mFairy.onTap(0.8f, result, "带她回家", 1000);

        result = mFairy.findPic("Put aside the dialogue.png");
        mFairy.onTap(0.8f, result, "收起对话", 1000);

        result = mFairy.findPic("Invite consent.png");
        mFairy.onTap(0.8f, result, "邀请队伍同意", 1000);

//        result=mFairy.findPic("pic dialogue.png");
//        mFairy.onTap(0.8f,result,"error_跳过对话",1000);

        result = mFairy.findPic(972,646,1038,701,"dialogue.png");
        mFairy.onTap(0.9f, result, 1217,22,1238,33,"err对话", 1000);

        result = mFairy.findPic(new String[]{"use.png","use2.png"});
        mFairy.onTap(0.8f, result, "err使用", 1000);

        result = mFairy.findPic("Batch use.png");
        mFairy.onTap(0.8f, result, "err批量使用", 1000);

        result = mFairy.findPic("Arbitrary Click.png");
        mFairy.onTap(0.8f, result, "err任意点击", 1000);

        result = mFairy.findPic("World Answers.png");
        mFairy.onTap(0.8f, result, 462,372,476,385,"err世界答题", 1000);

        result = mFairy.findPic("Quick Purchase.png");
        mFairy.onTap(0.8f, result, "err快捷购买", 1000);




        result = mFairy.findPic("I can bear it..png");
        mFairy.onTap(0.8f, result,"err我可以忍", 1000);


        result = mFairy.findPic(379,54,885,186,"Optional gift bag.png");
        mFairy.onTap(0.8f, result,932,68,945,83,"err自选礼包", 100);
        mFairy.onTap(0.8f, result,942,368,957,386,"err自选礼包关闭", 1000);

        result = mFairy.findPic(383,222,920,535,"crammed.png");
        mFairy.onTap(0.8f, result,697,428,736,444,"err人满确定进入副本", 1000);

        result = mFairy.findPic(383,222,920,535,"Only one person can enter.png");
        mFairy.onTap(0.8f, result,718,426,758,446,"err只能单人进入确定", 1000);


        result = mFairy.findPic(383,222,920,535,"Unoperated.png");
        mFairy.onTap(0.8f, result,712,426,758,450,"err未操作确定", 1000);

        result = mFairy.findPic(756,165,888,235,"Fabulous.png");
        if (result.sim>0.8f){
            mFairy.onTap(0.8f, result, "err点赞", 1000);
            result = mFairy.findPic(758,291,890,358,"Fabulous.png");
            mFairy.onTap(0.8f, result, "err点赞", 1000);
            result = mFairy.findPic(753,412,890,486,"Fabulous.png");
            mFairy.onTap(0.8f, result, "err点赞", 1000);
            result = mFairy.findPic(755,534,894,604,"Fabulous.png");
            mFairy.onTap(0.8f, result, "err点赞", 1000);
            mFairy.onTap(0.8f, result, 1055,99,1069,113,"err关闭点赞界面", 1000);
        }

        result = mFairy.findPic(383,222,920,535,"Durable equipment.png");
        mFairy.onTap(0.8f, result,710,424,775,449,"err装备耐久确定", 1000);
        mFairy.onTap(0.8f, result,725,467,780,482,"err装备耐久确定", 1000);

        result = mFairy.findPic("reserve.png");
        mFairy.onTap(0.8f, result,1025,573,1076,597,"err储备不够购买", 1000);
        mFairy.onTap(0.8f, result,1239,16,1257,30,"err储备不够购买关闭界面", 1000);

        result = mFairy.findPic(383,222,920,535,"Clear copy progress.png");
        mFairy.onTap(0.8f, result,715,425,761,447,"err清除副本进度", 1000);

        result = mFairy.findPic(545,624,744,690, "sygj1.png");
        mFairy.onTap(0.9f, result, "err手游管家", 1000);

        result = mFairy.findPic("The Game Begins.png");
        mFairy.onTap(0.8f, result,"err开始游戏", 1000);

        result = mFairy.findPic("Game announcement.png");
        mFairy.onTap(0.8f, result,1077,78,1095,99,"err游戏公告", 1000);


    }


}
