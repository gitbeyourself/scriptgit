package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask {
    AtFairyImpl mFairy;
    FindResult result;
    TimingActivity timingActivity;
    Util util;

    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
        timingActivity = new TimingActivity(mFairy);
    }


    public void fieldHangUp() throws Exception {
        int bj=0;
        int  map=0;
        int gmx,gmy;
        double x=0,y=0;
        String[] arr = AtFairyConfig.getOption("xystr").split(",");
        gmx = Integer.parseInt(arr[0]);
        gmy = Integer.parseInt(arr[1]);
        map=Integer.parseInt(AtFairyConfig.getOption("map"));
        while (mFairy.condit()){
            LtLog.e(mFairy.getLineInfo("野外挂机中bj="+bj));
            Thread.sleep(2000);
            if (util.reset(bj,3)==0){
                bj=0;
            }
            if (bj==0){
                      util.close();
                      bj=1;
            }
            if (bj==1){
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1181,57,1194,68,"日常打开地图", 1000);

                result = mFairy.findPic("world_map.png");
                mFairy.onTap(0.8f, result, "世界地图", 1000);

                result = mFairy.findPic("current_map.png");
                LtLog.e(mFairy.getLineInfo(0.8f,result,"当前地图"));
                if (result.sim>0.8f){
                    if (map==1){
                        mFairy.onTap(0.8f, result, 1015,197,1032,226,"青丘", 1000);
                    }
                    if (map==2){
                        mFairy.onTap(0.8f, result, 715,84,732,116,"翼界", 1000);
                    }
                    if (map==3){
                        mFairy.onTap(0.8f, result, 205,426,236,463,"长海仙境", 1000);
                    }
                    if (map==4){
                        mFairy.onTap(0.8f, result, 204,69,229,98,"极寒地狱", 1000);
                    }
                    if (map==5){
                        mFairy.onTap(0.8f, result, 778,500,802,532,"昆仑墟", 1000);
                    }
                    if (map==6){
                        mFairy.onTap(0.8f, result, 517,488,533,516,"若水河", 1000);
                    }
                    Thread.sleep(1500);
                    result = mFairy.findPic("confirm_transmission.png");
                    mFairy.onTap(0.8f, result, "确认传送", 1000);
                    if (result.sim<0.8f){
                        mFairy.onTap(1230,38,1245,49,"已在当前地图", 1000);
                    }
                    bj=2;
                }

            }

            if (bj==2){
                result = mFairy.findPic("daily.png");
                mFairy.onTap(0.8f, result, 1181,57,1194,68,"日常打开地图", 1000);

                result = mFairy.findPic("world_map.png");
                if (result.sim>0.8f){
                    Thread.sleep(2000);
                    LtLog.e(mFairy.getLineInfo("世界地图，开始跑坐标"));
                    if (map==1){
                        // 青丘   20-35
                        x=gmx *1.67+gmy *0.0015+363.7792;
                        y=gmx *0.0047+gmy *-1.8298+664.8368;
                    }
                    if (map==2){
                        // 翼界   35-50
                        x=gmx *1.5032+gmy *0.0034+388.4078;
                        y=gmx *-0.0007+gmy *-1.7302+650.741;
                    }
                    if (map==3){

                        // 长海仙境   50-65
                        x=gmx *1.0286+gmy *-0.0015+346.6444;
                        y=gmx *-0.0003+gmy *-1.0237+624.4774;
                    }
                    if (map==4){
                        // 极寒地狱  65-80
                        x=gmx *0.9023+gmy *0.0012+388.4975;
                        y=gmx *-0.0019+gmy *-0.8993+617.0021;
                    }
                    if (map==5){
                        // 昆仑墟  80-90
                        x=gmx *1.5073+gmy *0.0006+148.6109;
                        y=gmx *-0.0004+gmy *-1.1582+675.3023;
                    }
                    if (map==6){
                        // 若水河  90-100
                        x=gmx *1.708+gmy *-0.0023+358.8517;
                        y=gmx *0.0002+gmy *-1.2792+597.4407;
                    }
                    LtLog.e(mFairy.getLineInfo("x="+(int)x +",y="+(int)y));
                    mFairy.onTap(0.8f, result, (int)x,(int)y,(int)x+1,(int)y+1,"去坐标点", 2000);
                    mFairy.onTap(0.8f, result, 1162,66,1180,84,"关闭地图", 1000);
                    bj=3;
                }

            }
            if (bj==3){
                long dazeTime = mFairy.mMatTime(1035,552,23,21, 0.9f);
                if (dazeTime >=20) {
                    mFairy.initMatTime();
                    LtLog.e(mFairy.getLineInfo("发呆了"));
                    bj=0;
                }
                result = mFairy.findPic("manual.png");
                mFairy.onTap(0.8f, result, "手动开启自动", 1000);
            }
        }
    }








}
