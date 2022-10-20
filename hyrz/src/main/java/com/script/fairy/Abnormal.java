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
    int count_1=0;
    //全局处理
    public void erro() throws Exception {

        result = mFairy.findPic( 676,11,1271,312,new String[]{"fork1.png","fork.png"});
        if (result.sim>0.8f){
            count_1++;
            if(count_1>50){
                count_1=0;
                mFairy.onTap(0.8f,result, "err叉", 100);
            }
        }else {
            count_1=0;
        }

        result = mFairy.findPic( "fsyc.png");
        mFairy.onTap(0.8f,result, "err发生异常确定", 100);

        result = mFairy.findPic( 1126,647,1186,703,"dialogue.png");
        mFairy.onTap(0.8f,result, "err对话", 100);

        int colorNum=mFairy.getColorNum("1020,17,1053,34","2,2,2",0.9f,0);
        if (colorNum>100){
            mFairy.onTap(1138,55,1156,68,"err对话1", 100);
        }
        result = mFairy.findPic( "ltk.png");
        mFairy.onTap(0.8f,result, "err聊天框", 100);

        result = mFairy.findPic( 518,511,928,711,"Arbitrarily.png");
        mFairy.onTap(0.8f,result, "err点任意位置", 100);

        result = mFairy.findPic( "dialogue1.png");
        mFairy.onTap(0.8f,result,1138,55,1156,68,"err对话1", 100);

        result = mFairy.findPic( 7,10,1268,710,"guide.png");
        mFairy.onTap(0.8f, result,result.x-20,result.y-35,result.x-19,result.y-34, "err指引导", 100);

        result = mFairy.findPic( "upgrade.png");
        mFairy.onTap(0.8f,result, "err升级", 100);

        result = mFairy.findPic( "new function.png");
        mFairy.onTap(0.8f,result, "err新功能", 100);

        result = mFairy.findPic( 287,26,1081,575,"victory.png");
        mFairy.onTap(0.8f,result, "err胜利", 100);

        result = mFairy.findPic( "Notice.png");
          mFairy.onTap(0.8f,result, "err公告", 100);

        result = mFairy.findPic( "hdfork.png");
        mFairy.onTap(0.8f,result, "err各种活动页面叉", 100);

        result = mFairy.findPic( "qqlogin.png");
        mFairy.onTap(0.8f,result, "errqq登录", 100);

        result = mFairy.findPic( 48,775,680,1166,"qqlogin1.png");
        mFairy.onTap(0.8f,result, "errqq登录1", 100);

        result = mFairy.findPic( "restart.png");
        mFairy.onTap(0.8f,result, "err版本不对重启", 100);

        result = mFairy.findPic("xssz.png");
        mFairy.onTap(0.8f, result, 612, 444, 664, 466, "err设置音效确定", 100);

        result = mFairy.findPic( 337,498,533,603,"tctz.png");
        mFairy.onTap(0.8f,result, 840,537,890,558,"err退出挑战", 100);

        result = mFairy.findPic( "liaotian.png");
        mFairy.onTap(0.8f,result, "err收起聊天框", 100);

        result = mFairy.findPic( "yunpai.png");
        mFairy.onTap(0.8f,result, "err云派桌面启动", 100);

        result = mFairy.findPic( "dljl.png");
        mFairy.onTap(0.8f,result, "err登录奖励", 100);

        result = mFairy.findPic( "Start the game.png");
        mFairy.onTap(0.8f,result, "err开始游戏", 100);

        result = mFairy.findPic(564,143,710,252,"tishi.png");
        if (result.sim > 0.8f) {
            result = mFairy.findPic( 390,336,896,542,"queding.png");
            mFairy.onTap(0.8f,result, "err确定", 100);
        }

        result = mFairy.findPic( "fail1.png");
        mFairy.onTap(0.8f,result, "err失败了", 100);

        result = mFairy.findPic( new String[]{"xshd.png","othererr.png"});
        mFairy.onTap(0.8f,result, 1163,653,1186,664,"err限时活动1", 100);

        result = mFairy.findPic( "othererr1.png");
        mFairy.onTap(0.8f,result, "err领取补给", 100);

        result = mFairy.findPic( "jixu.png");
        mFairy.onTap(0.8f,result, "err继续重连", 100);

        result = mFairy.findPic("qbxz.png");
        mFairy.onTap(0.8f, result, "err全部下载", 100);

        result = mFairy.findPic("errsure.png");
        mFairy.onTap(0.8f, result, "err确定退队", 100);

        result=mFairy.findPic("already leave.png");
        mFairy.onTap(0.8f,result,623,442,653,464,"error_对手离开了",1000);
    }
}
