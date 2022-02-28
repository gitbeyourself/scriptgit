package com.example.administrator.yys;

import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class GamePublicFunction {//公共方法
    yys mFairy;
    FindResult result;
    FindResult result1;
    CommonFunction comm;
    /*
            公共方法
         */
    public GamePublicFunction(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
    }

    public void close()throws Exception{
            result = comm.arrayCompare(2f, 3, 2, 204, 224, new String[]{
                    "close.png", "close1.png", "close2.png","close5.png"});
            comm.arrayClick(0.85f, result, "返回", 1000);

            result= mFairy.findPic2(832, 2, 1276, 416,comm.setImg("close3.png"));
            comm.Click(0.85f,result,comm.getImg(),"关闭",1000);

            result= mFairy.findPic2(832, 2, 1276, 416,comm.setImg("close4.png"));
            comm.Click(0.85f,result,comm.getImg(),"关闭",1000);
    }//关闭

    public void init(int x,int y,int x1,int y1,String img)throws Exception{
        while (true) {
            close();
            result = mFairy.findPic2(984,208,1138,332,comm.setImg("ty.png"));
            comm.Click(0.85f, result, comm.getImg(), "庭院", 2000);

            result = mFairy.findPic2(comm.setImg("b1.png"));
            comm.Click(0.85f, result,comm.getImg(),  "确认", 1000);

            result = mFairy.findPic2(comm.setImg("yj.png"));
            comm.RndClick(0.85f, 326, 44, result, "印记获取", 1000);

            result = mFairy.findPic2(comm.setImg("djEnd.png"));
            comm.Click(0.85f, result, comm.getImg(), "取消斗技", 1000);

            result = mFairy.findPic2(comm.setImg("qx.png"));
            comm.Click(0.85f, result, comm.getImg(), "取消", 2000);

            result = mFairy.findPic2(comm.setImg("zoomBar.png"));
            comm.Click(0.85f, result, comm.getImg(), "缩放栏", 2000);

            result = mFairy.findPic2(comm.setImg("tl.png"));
            comm.RndClick(0.85f,934,195,result,"关闭体力",1000);

            result = mFairy.findPic2(comm.setImg("hd.png"));
            comm.RndClick(0.85f,326,44,result,"获得奖励",1000);

            result = mFairy.findPic2(comm.setImg("qian2.png"));
            comm.RndClick(0.85f,326,44,result,"获得奖励",1000);

            result = mFairy.findPic2(comm.setImg("word every day.png"));
            comm.RndClick(0.85f,633,214,result,"每日一签",1000);

            result = comm.arrayCompare(0.85f,new String[]{
                    "qian1.png","y1.png","z1.png","yx1.png","yx2.png"});
            comm.arrayClick(0.9f,result,"确定",2000);

            result = mFairy.findPic2(comm.setImg("pic fight over.png"));
            comm.Click(0.85f, result, comm.getImg(), "战斗结束，点击屏幕继续", 2000);

            result = mFairy.findPic2(comm.setImg("lk.png"));
            if(result.sim>0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "离开队伍", 3000);
                comm.spot(763,428,"确定",1000);
            }
            result = mFairy.findPic2(x,y,x1,y1,comm.setImg(img));
            if (result.sim > 0.85f) {
                LtLog.e(comm.getText("init结束>>>"));
                break;
            }

        }

    }//初始化

    public void teamMethod()throws Exception{
        result = mFairy.findPic2(994,466,1274,650,comm.setImg("jia.png"));
        comm.Click(0.8f, result, comm.getImg(), "准备", 1000);

        result = mFairy.findPic2(comm.setImg("auto.png"));
        comm.Click(0.9f, result, comm.getImg(), "自动战斗", 1000);

        result = mFairy.findPic2(comm.setImg("qd.png"));
        comm.Click(0.9f, result, comm.getImg(), "继续邀请玩家", 3000);

        result = comm.arrayCompare(2f,514,254,1268,711, new String[]{"jx2.png", "jx3.png"});
        comm.arrayClick(0.85f, result, "创建", 2000);
    }//public

    public void layerTools(int num)throws Exception{
        switch (num) {
            case 1:
                comm.spot(486, 260, "一层", 2000);
                break;
            case 2:
                comm.spot(486, 324, "二层", 2000);
                break;
            case 3:
                comm.spot(486, 391, "三层", 2000);
                break;
            case 4:
                comm.spot(486, 463, "四层", 2000);
                break;
            case 5:
                comm.spot(486, 530, "五层", 2000);
                break;
            case 6:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 280, "六层", 2000);
                break;
            case 7:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 349, "七层", 2000);
                break;
            case 8:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 416, "八层", 2000);
                break;
            case 9:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 484, "九层", 2000);
                break;
            case 10:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 552, "十层", 2000);
                break;

        }
    }//层数

    public void newLayerTools(int type,int num)throws Exception{
        while (true) {
            result = mFairy.findPic2(214, 97, 320, 644, comm.setImg("zd" + type + ".png"));
            comm.Click(0.85f, result, comm.getImg(), "选择副本", 2500);

            result = comm.arrayCompare(2f, new String[]{"jx1.png"});
            if (result.sim > 0.85f) {
                break;
            }
        }
        switch (num) {
            case 1:
                comm.spot(486, 260, num+"层", 2000);
                break;
            case 2:
                comm.spot(486, 324, num+"层", 2000);
                break;
            case 3:
                comm.spot(486, 391, num+"层", 2000);
                break;
            case 4:
                comm.spot(486, 463, num+"层", 2000);
                break;
            case 5:
                comm.spot(486, 530, num+"层", 2000);
                break;
            case 6:
                comm.spot(514, 576, num+"层", 2000);
                break;
            case 7:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                result=mFairy.findPic2(413,131,562,614,comm.setImg("jia"+num+".png"));
                comm.Click(0.85f,result,comm.getImg(),num+"层",2000);
                break;
            case 8:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                result=mFairy.findPic2(413,131,562,614,comm.setImg("jia"+num+".png"));
                comm.Click(0.85f,result,comm.getImg(),num+"层",2000);
                break;
            case 9:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                result=mFairy.findPic2(413,131,562,614,comm.setImg("jia"+num+".png"));
                comm.Click(0.85f,result,comm.getImg(),num+"层",2000);
                break;
            case 10:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                result=mFairy.findPic2(413,131,562,614,comm.setImg("jia"+num+".png"));
                comm.Click(0.85f,result,comm.getImg(),num+"层",2000);
                break;
            case 11:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                result=mFairy.findPic2(413,131,562,614,comm.setImg("jia"+num+".png"));
                comm.Click(0.85f,result,comm.getImg(),"悲鸣",2000);
                break;

        }
    }//层数

    public void layerTools2(int num)throws Exception{
        switch (num) {
            case 1:
                comm.spot(486, 260, "一层", 2000);
                break;
            case 2:
                comm.spot(486, 324, "二层", 2000);
                break;
            case 3:
                comm.spot(486, 391, "三层", 2000);
                break;
            case 4:
                comm.spot(486, 463, "四层", 2000);
                break;
            case 5:
                comm.spot(486, 530, "五层", 2000);
                break;
            case 6:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 349, "七层", 2000);
                break;
            case 7:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 416, "八层", 2000);
                break;
            case 8:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 484, "九层", 2000);
                break;
            case 9:
                comm.RanSwipe(463, 216, 505, 555, 2, 1000,3000);
                comm.spot(486, 552, "十层", 2000);
                break;
        }
    }//层数

    public void jc(String img,int i)throws Exception{
        while (true) {
            result = mFairy.findPic2(comm.setImg("jc.png"));
            comm.Click(0.85f,result,comm.getImg(),"加成",2000);

            result1 = mFairy.findPic2(739, 115, 867, 508, comm.setImg(img));
            if (result1.sim > 0.85f) {
                switch (i) {
                    case 1:
                        result = mFairy.findPic2(result1.x + 112, result1.y - 25,
                                result1.x + 172, result1.y + 30, comm.setImg("kai.png"));
                        comm.Click(0.85f, result, comm.getImg(), "开启", 2000);
                        comm.spot(436,50,"关闭加成界面",1000);
                        return;
                    case 2:
                        result = mFairy.findPic2(result1.x + 112, result1.y - 25,
                                result1.x + 172, result1.y + 30, comm.setImg("ting.png"));
                        comm.Click(0.85f, result, comm.getImg(), "关闭", 2000);
                        comm.spot(436,50,"关闭加成界面",1000);
                        return;
                }
            }


        }
    }//加成
}
