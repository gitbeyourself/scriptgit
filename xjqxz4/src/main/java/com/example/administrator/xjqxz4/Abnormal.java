

package com.example.administrator.xjqxz4;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/3/13.
 */

public class Abnormal {
    //异常处理
    //监控线程
     xjqxz4 mFairy;
     FindResult result;
     CommonFunction commonFunction;
    public Abnormal(xjqxz4 atFairy) {
        mFairy = atFairy;
        commonFunction = new CommonFunction(mFairy);
    }

    public void error() throws Exception{
        long time_1;
        String task_id;
        int js_1=0,js_2=0,js_3=0,js_4=0;
        int jjsq=0;
        time_1=System.currentTimeMillis();
        task_id= AtFairyConfig.getOption("task_id");
        if (AtFairyConfig.getOption("jjsq").equals(1)){
            jjsq=1;
        }
        while (true) {
            if ((System.currentTimeMillis() - time_1) > 15000) {
                LtLog.e(commonFunction.getLineInfo("---------异常线程运行中"));
                time_1 = System.currentTimeMillis();
            }

            if (!task_id.equals("1290")  && !task_id.equals("1302") ){
                result = mFairy.findPic2(commonFunction.setImg("xmAgree.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err同意"));
                commonFunction.RndCompare(0.8f, 526,501,result, commonFunction.getImg());
            }
            result = mFairy.findPic2(360,215,920,478, commonFunction.setImg("authorization.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err授权过期"));
                commonFunction.RndCompare(0.8f, 754,503,result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, 644,503,result, commonFunction.getImg());
            }
            result = mFairy.findPic2(21,641,704,1119,commonFunction.setImg("Sign in.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err登录"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("new sure.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err新版qq隐私政策同意"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("new authorization.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err新版qq授权"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("new login.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err新版qq登陆"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("new login2.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err新版qq登陆"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("new login3.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err新版qq登陆"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("ycrw.png"));
            if (result.sim>0.8f){
                js_1++;
                if (js_1>4){
                    LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err右侧任务"));
                    commonFunction.Compare(0.8f, result, commonFunction.getImg());
                }
            }else {
                js_1=0;
            }
            if (!task_id.equals("1300") && !task_id.equals("1302")){
                result = mFairy.findPic2(commonFunction.setImg("Taskbar_not_open.png"));
                if (result.sim>0.8f){
                    js_2++;
                    if (js_2>10){
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err任务栏未打开"));
                        commonFunction.Compare(0.8f, result, commonFunction.getImg());
                    }

                }else {
                    js_2=0;
                }
            }

            result = mFairy.findPic2(commonFunction.setImg("open_up.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err打开上面的列表"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(200,106,265,348,commonFunction.setImg("Notice.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err公告确定"));
                commonFunction.RndCompare(0.8f, 643,555,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(582,249,878,418,commonFunction.setImg("xzsf.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err寻找师傅"));
                commonFunction.RndCompare(0.8f, 522,507,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("Sign in1.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err登录1"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("Sign in2.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err登录2"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("yinsi.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err我已详细阅读并同意服务协议"));
               // commonFunction.Compare(0.8f, result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, 770,504,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(385,281,731,420,commonFunction.setImg("bgmb.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err变更目标"));
                commonFunction.RndCompare(0.8f, 755,507,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(71,153,445,569,commonFunction.setImg("fbtj.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err发布通缉"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(358,231,915,465,commonFunction.setImg("qrtj.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err确认通缉"));
                commonFunction.RndCompare(0.8f, 746,506,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("xgnc.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err小鬼难缠"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("dwxz.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err队伍须知"));
                commonFunction.RndCompare(0.8f, 1124,40,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("power saving.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err省电"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("Withdrawfromteam.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err退出并进入"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(605,424,927,555,commonFunction.setImg("zdwfcj.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err组队无法参加退出队伍"));
                commonFunction.RndCompare(0.8f, 751,505,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("Give up the subject.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err放弃本题"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("Give up the subject1.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err放弃本题1"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("Collar red.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err领红包"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, 1247,32,result, commonFunction.getImg());
            }
            result = mFairy.findPic2(545,624,744,690, "sygj1.png");
            if (result.sim > 0.8f) {
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err手游管家"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("dialogue.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err对话"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPicRange(commonFunction.setImg("Leave a copy.png"),100);
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err离开副本"));
                commonFunction.RndCompare(0.8f, 758,505,result, commonFunction.getImg());
            }
            result =  commonFunction.FindManyPic(1092,3,1279,89, new String[]{"skip.png","skip1.png"},0);
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err跳过"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }


            result = mFairy.findPic2(362,229,916,471,commonFunction.setImg("Safe zone.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err前往安全区"));
                commonFunction.RndCompare(0.8f, 750,505,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(357,231,922,474,commonFunction.setImg("Health system.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err健康系统"));
                commonFunction.RndCompare(0.8f, 644,502,result, commonFunction.getImg());
                commonFunction.RndCompare(0.8f, 751,503,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("qcxdl.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "err重新登录"));
                commonFunction.RndCompare(0.8f, 640,501,result, commonFunction.getImg());

            }

            result = mFairy.findPic2(commonFunction.setImg("qqdl.png"));
            if (result.sim>0.8f){
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "errqq登录"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(24,549,714,1155,commonFunction.setImg("checkvx3.png"));
            if (result.sim>0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "errorqq登录角色"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(24,549,714,1155,commonFunction.setImg("checkvx4.png"));
            if (result.sim>=0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "errorqq登录角色"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(24,549,714,1155,commonFunction.setImg("login.png"));
            LtLog.e("相似度+++++++++++"+result.sim);
            if (result.sim>=0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "errorqq登录角色"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(24,549,714,1155,commonFunction.setImg("login2.png"));
            LtLog.e("相似度+++++++++++"+result.sim);
            if (result.sim>=0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "errorqq登录角色"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

            result = mFairy.findPic2(486,284,795,393,commonFunction.setImg("lkmlj.png"));
            if (result.sim>0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "error离开迷离景"));
                commonFunction.RndCompare(0.8f, 748,502,result, commonFunction.getImg());
            }
            result = mFairy.findPic2(commonFunction.setImg("dhk.png"));
            if (result.sim>0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "error对话框"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }
            result = mFairy.findPic2(717,263,993,352,commonFunction.setImg("accident.png"));
            if (result.sim>0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "error意外弹框"));
                commonFunction.RndCompare(0.8f, 652,382,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(121,84,190,326,commonFunction.setImg("yyxx.png"));
            if (result.sim>0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "error语音选秀"));
                commonFunction.RndCompare(0.8f, 1052,67,result, commonFunction.getImg());
            }

            result = mFairy.findPic2(commonFunction.setImg("OpenRightlist.png"));
            if (result.sim>0.8f){
                LtLog.e( commonFunction.getLineInfo(result, 0.8f, "error打开右侧列表"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
            }

        }
    }
}
