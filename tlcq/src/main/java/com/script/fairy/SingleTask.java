package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    GameUtil gameUtil;


    YxdUtil yxdUtil_1;
    YxdUtil yxdUtil_2;
    YxdUtil yxdUtil_3;
    ControlSplit controlSplit;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);
        yxdUtil_1 = new YxdUtil(mFairy);
        yxdUtil_2 = new YxdUtil(mFairy);
        yxdUtil_3 = new YxdUtil(mFairy);
    }
    void setTaskName(int taskContentNum)throws Exception{
        super.setTaskName(taskContentNum);
        mFairy.condit();
    }
    //师门
    public void guaji() throws Exception {
        new SingleTask(mFairy) {
            int map1=0;
            String string="";
            int gmx,gmy;
            double x = 0, y = 0;
            void create()throws Exception{
                if (!AtFairyConfig.getOption("opcount1").equals("")){
                    controlSplit=strSplit(AtFairyConfig.getOption("opcount1"));
                }else {
                    setTaskEnd();
                    return;
                }
                map1=Integer.parseInt(AtFairyConfig.getOption("map1"));
                String[] arr = AtFairyConfig.getOption("xystr").split(",");
                gmx = Integer.parseInt(arr[0]);
                gmy = Integer.parseInt(arr[1]);
                if (map1==1){
                    x=gmx *4.1183+gmy *-0.0202+144.3366;
                    y=gmx *0.0044+gmy *2.2055+142.8439;
                    string="map1.png";
                }
                if (map1==2){
                    x=gmx *7.6739+gmy *-0.0584+145.928;
                    y=gmx *0.087+gmy *4.1531+142.615;
                    string="map2.png";
                }
                if (map1==3){
                    x=gmx *6.7436+gmy *0.0256+144.8205;
                    y=gmx *-0.0564+gmy *3.4479+151.0872;
                    string="map3.png";
                }
                if (map1==4){
                    x=gmx *9.8051+gmy *0.3287+137.3819;
                    y=gmx *0.0531+gmy *5.1831+146.3504;
                    string="map4.png";
                }
            }
            void content_0() throws Exception {
                 gameUtil.close();
                 setTaskName(1);
            }

            void content_1() throws Exception {
                if (overtime(10,0))return;
                result = mFairy.findPic(string);
                if (result.sim>0.8f) {
                    LtLog.e(mFairy.getLineInfo("在选中的地图了,去等级地点"));
                    setTaskName(2);
                    return;
                }

                result = mFairy.findPic(new  String[]{"anquan.png","weixian.png"});
                if (result.sim>0.8f){
                    Thread.sleep(3000);
                    mFairy.onTap(0.8f, result, "在安全区打开地图", Sleep);
                }
                result = mFairy.findPic("chuansonginface.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("传送界面"));
                    if (map1==1){
                        mFairy.onTap(0.8f, result, 792,296,804,317,"第1大陆", Sleep);
                    }
                    if (map1==2){
                        mFairy.onTap(0.8f, result, 1002,173,1015,196,"第2大陆", Sleep);
                    }
                    if (map1==3){
                        mFairy.onTap(0.8f, result, 280,201,294,235,"第3大陆", Sleep);
                    }
                    if (map1==4){
                        mFairy.onTap(0.8f, result, 472,388,483,439,"第4大陆", Sleep);
                    }
                    Thread.sleep(3000);
                    gameUtil.close();
                }

                result = mFairy.findPic("dituinface.png");
                mFairy.onTap(0.8f, result, 69,211,100,226,"传送", Sleep);
            }
            void content_2() throws Exception {
                if (overtime(10,0))return;
                result = mFairy.findPic(new  String[]{"anquan.png","weixian.png"});
                if (result.sim>0.8f){
                    Thread.sleep(3000);
                    mFairy.onTap(0.8f, result, "在安全区打开地图", Sleep);
                }
                result = mFairy.findPic("dituinface.png");
                if (result.sim>0.8f){
                    mFairy.tap((int)x,(int)y);
                    gameUtil.close();
                    setTaskName(3);
                    return;
                }
            }
            void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(1188,62,62,25, 0.9f);
                if (dazeTime > 3) {
                    LtLog.e(mFairy.getLineInfo("到达目的地"));
                    for (int i=0;i<10;i++){
                        mFairy.condit();
                        result = mFairy.findPic("xzrk.png");
                        if (result.sim<0.8f){
                            mFairy.onTap(594,317,677,425,"点开等级选项", 2000);
                        }else{
                            break;
                        }
                    }
                    if (result.sim<0.8f){
                        setTaskName(0);
                        return;
                    }
                    result1 = mFairy.findPic("guanjue.png");
                    if (result1.sim<0.8f){
                        if (controlSplit.count==1 ){
                            mFairy.onTap(0.8f, result, 94,446,126,459,"1层", 3000);
                            mFairy.onTap(0.8f, result, 188,482,217,494,"1层", 3000);
                        }
                        if (controlSplit.count==2){
                            mFairy.onTap(0.8f, result, 293,447,321,457,"2层", 3000);
                        }
                        if (controlSplit.count==3){
                            mFairy.onTap(0.8f, result, 106,516,133,531,"3层", 3000);
                        }
                        if (controlSplit.count==4){
                            mFairy.onTap(0.8f, result, 312,520,343,533,"4层", 3000);
                        }
                    }else {
                        if (map1==1){
                            if (controlSplit.count==1){
                                mFairy.onTap(0.8f, result, 106,407,131,422,"1层", Sleep);
                            }
                            if (controlSplit.count==2){
                                mFairy.onTap(0.8f, result, 304,408,331,425,"2层", Sleep);
                            }
                            if (controlSplit.count==3){
                                mFairy.onTap(0.8f, result, 100,484,131,499,"3层", Sleep);
                            }
                            if (controlSplit.count==4){
                                mFairy.onTap(0.8f, result, 306,483,333,495,"4层", Sleep);
                            }
                            if (controlSplit.count==5){
                                mFairy.onTap(0.8f, result, 112,556,150,567,"5层", Sleep);
                            }
                            if (controlSplit.count==6){
                                mFairy.onTap(0.8f, result, 308,554,334,568,"6层", Sleep);
                            }
                        }
                        if (map1==2){
                            if (controlSplit.count==1){
                                mFairy.onTap(0.8f, result, 106,444,125,458,"1层", Sleep);
                            }
                            if (controlSplit.count==2){
                                mFairy.onTap(0.8f, result, 312,446,329,459,"2层", Sleep);
                            }
                            if (controlSplit.count==3){
                                mFairy.onTap(0.8f, result, 104,520,124,528,"3层", Sleep);
                            }
                            if (controlSplit.count==4){
                                mFairy.onTap(0.8f, result, 303,514,320,528,"4层", Sleep);
                            }
                        }
                        if (map1==3){
                            if (controlSplit.count==1){
                                mFairy.onTap(0.8f, result, 106,444,125,458,"1层", Sleep);
                            }
                            if (controlSplit.count==2){
                                mFairy.onTap(0.8f, result, 312,446,329,459,"2层", Sleep);
                            }
                            if (controlSplit.count==3){
                                mFairy.onTap(0.8f, result, 104,520,124,528,"3层", Sleep);
                            }
                        }
                        if (map1==4){
                            if (controlSplit.count==1){
                                mFairy.onTap(0.8f, result, 106,481,151,501,"1层", Sleep);
                            }
                            if (controlSplit.count==2){
                                mFairy.onTap(0.8f, result, 309,487,333,498,"2层", Sleep);
                            }
                        }
                    }
                    Thread.sleep(2000);
                    setTaskName(4);
                }
              Thread.sleep(1000);
            }
            void content_4() throws Exception {
                result = mFairy.findPic("weixian.png");
                if (result.sim>0.8f){
                    result = mFairy.findPic("zhandou.png");
                    if (result.sim<0.8f){
                        mFairy.onTap(1225,382,1238,391,"开启自动", Sleep);
                    }
                }
                result = mFairy.findPic("anquan.png");
                if (result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("在安全区"));
                    setTaskName(0);
                }
                Thread.sleep(3000);
            }
        }.taskContent(mFairy,"挂机任务中");
    }


}
