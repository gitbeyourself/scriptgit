package com.example.administrator.xjqxz4;


import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {

    xjqxz4 mFairy;
    FindResult result;
    CommonFunction commonFunction;
    GamePublicFunction gamePublicFunction;
    TimingActivity timingActivity;
    Other other;
    public LimitlessTask(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        commonFunction = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
        timingActivity= new TimingActivity(mFairy);
        other=new Other(mFairy);
    }
    //  野外挂机
    public void  fieldHangMachine() throws Exception {
        int bj = 0,bj_1;
        int  cs_1=0;
        int ret;
        int ditu;
        int gmx,gmy;
        int  numcolor,numcolor1;
        int js_1=0,js_2=0,js_3=0,js_4=0,js_5=0;
        long time=System.currentTimeMillis(),time_1=0,time_2=0;

        double x = 0, y = 0;
        String str="";
        String str1="";
        String[] arr = AtFairyConfig.getOption("xystr").split(",");
        gmx = Integer.parseInt(arr[0]);
        gmy = Integer.parseInt(arr[1]);
        ditu=Integer.parseInt(AtFairyConfig.getOption("ditu"));
      /*  gmx = 249;
        gmy = 44;
        ditu=1;*/
        if (ditu==1){
            str="30map.png";
            str1="30map1.png";
            x=gmx *0.8951+gmy *0.0015+386.4817;
            y=gmx *-0.0049+gmy *-0.8936+660.714;
        }
        if (ditu==2){
            str="40map.png";
            str1="40map1.png";
            x=gmx *1.3185+gmy *0.0027+362.1679;
            y=gmx *-0.0001+gmy *-1.3145+660.4326;
        }
        if (ditu==3){
            str="50map.png";
            str1="50map1.png";
            x=gmx *1.3088+gmy *-0.0064+346.0148;
            y=gmx *-0.0013+gmy *-1.3162+660.5124;
        }
        if (ditu==4){
            str="60map.png";
            str1="60map1.png";
            x=gmx *1.2325+gmy *-0.0103+345.4405;
            y=gmx *-0.0137+gmy *-1.2682+676.5782;
        }
        if (ditu==5){
            str="70map.png";
            str1="70map1.png";
            x=gmx *0.8572+gmy *0.0014+342.5935;
            y=gmx *-0.0041+gmy *-0.8559+660.6872;
        }
        if (ditu==6){
            str="80map.png";
            str1="80map1.png";
            x=gmx *0.9819+gmy *0.0039+406.2508;
            y=gmx *-0.0045+gmy *-0.9829+660.5252;
        }
        if (ditu==7){
            str="90map.png";
            str1="90map1.png";
            x=gmx *0.9607+gmy *0.0469+314.0479;
            y=gmx *0.0653+gmy *-0.9213+637.6451;
        }
        if (ditu==8){
            str="100map.png";
            str1="100map1.png";
            x=gmx *0.6119+gmy *-0.0034+347.3922;
            y=gmx *-0.004+gmy *-0.6173+663.0591;
        }
        if (ditu==9){
            str="110map.png";
            str1="110map1.png";
            x=gmx *1.1652+gmy *-0.0047+342.2721;
            y=gmx *0.0077+gmy *-1.1637+659.0094;
        }
        timingActivity.timeLimitActivity();
        bj_1 = bj;
        while (true) {
            if (bj_1 == bj && bj != 5) {
                cs_1++;
            } else if (bj_1 != bj) {
                cs_1 = 0;
                bj_1 = bj;
                LtLog.e(commonFunction.getLineInfo("标记发生变化"));
            }
            if (cs_1 > 100) {
                cs_1 = 0;
                bj = 0;
                LtLog.e(commonFunction.getLineInfo("标记长时间未发生变化"));
            }
            LtLog.e(commonFunction.getLineInfo("野外挂机中bj="+bj));
            Thread.sleep(2000);
            if (bj == 0) {
                gamePublicFunction.init();
                bj = 1;
            }
            if (bj==1){
                result = mFairy.findPic2(1161,1,1279,132,commonFunction.setImg(str1));
                LtLog.e(commonFunction.getLineInfo(result, 0.1f, "已经在地图"));
                if (result.sim>0.7f){
                    bj=3;
                }else {
                    bj=2;
                }
            }
            if (bj == 2) {


                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                commonFunction.RndCompare(0.8f, 1196,76,result, commonFunction.getImg());


                result = mFairy.findPic2(commonFunction.setImg("backyaochi.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "返回瑶池"));
                commonFunction.RndCompare(0.8f, 1039,110,result, commonFunction.getImg());


                result = mFairy.findPic2(6,4,1273,707,commonFunction.setImg(str));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "要去的地图"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());
                if (result.sim>0.8f){
                        Thread.sleep(8000);
                        bj=0;
                }
            }
            if (bj==3){
//                result = mFairy.findPic2(commonFunction.setImg("YK.png"));
//                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "御空"));
//                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                commonFunction.RndCompare(0.8f, 1196,76,result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("backyaochi.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "返回瑶池"));
                commonFunction.RndCompare(0.8f,(int)x,(int)y,result, commonFunction.getImg());
                if (result.sim>0.8f){
                    gamePublicFunction.init();
                    bj=4;
                }

            }
            if (bj==4){
                numcolor = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                LtLog.e(commonFunction.getLineInfo("numcolor=" + numcolor));
                Thread.sleep(1000);
                numcolor1 = commonFunction.getColorsNumber(1167, 18, 71, 12, "234,231,213", 0.9f);
                LtLog.e(commonFunction.getLineInfo("numcolor1=" + numcolor1));
                if (numcolor == numcolor1) {
                    js_1++;
                    if (js_1 > 3) {
                        LtLog.e(commonFunction.getLineInfo("已到达指定坐标点" ));
                        result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                        LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
                        commonFunction.RndCompare(0.8f, 867,677,result, commonFunction.getImg());
                          bj=5;
                    }
                } else {
                    js_1 = 0;
                }
            }
            if (bj==5){
                if (System.currentTimeMillis()-time>600000){
                    bj=0;
                    time=System.currentTimeMillis();
                }
                result = mFairy.findPic2(9,2,1258,186,commonFunction.setImg("activity.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "活动"));
             //   commonFunction.RndCompare(0.8f, 826,675,result, commonFunction.getImg());
                if (result.sim>0.8f){
                    js_2=0;
                }else {
                    js_2++;
                    if (js_2>15){
                        bj=0;
                    }
                }
                if ((System.currentTimeMillis()-time_1)>300000){
                    LtLog.e(commonFunction.getLineInfo("--------5分钟拉跟站一次"));
                    gamePublicFunction.pullAndStop();
                    gamePublicFunction.init();
                    time_1=System.currentTimeMillis();
                }
                if ((System.currentTimeMillis()-time_2)>3600000){
                    LtLog.e(commonFunction.getLineInfo("--------1小时领一次仙盟奖励"));
                    gamePublicFunction.xmlj();
                    gamePublicFunction.init();
                    time_2=System.currentTimeMillis();
                }
           /*     result = commonFunction.FindManyPic(442,5,1270,394, new String[]{"fork1.png"}, 0);
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "发现一个叉子"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());*/

                result = mFairy.findPic2(commonFunction.setImg("Openhang.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "开启挂机"));
                commonFunction.Compare(0.8f, result, commonFunction.getImg());

                result = mFairy.findPic2(commonFunction.setImg("In a daze.png"));
                LtLog.e(commonFunction.getLineInfo(result, 0.8f, "发呆重来"));
                if (result.sim>0.8f){
                    bj=0;
                }

                ret=timingActivity.timeLimitActivity();
                if (ret==1){
                    bj=0;
                }
            }
        }
    }


}
