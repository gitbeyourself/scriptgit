package com.example.administrator.yys;


import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class Other {//其他任务
    yys mFairy;
    FindResult result;
    CommonFunction comm;
    GamePublicFunction gamePublicFunction;

    public Other(yys ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction=new GamePublicFunction(mFairy);
    }
    /*
        其他方法
     */
    public void o()throws Exception{
        while (true) {
            result = mFairy.findPic2(comm.setImg("o1.png"));
            comm.Click(0.85f,result,comm.getImg(),"主页",1000);

            result = mFairy.findPic2(comm.setImg("o2.png"));
            comm.Click(0.85f,result,comm.getImg(),"挑战",1000);

            gamePublicFunction.teamMethod();

            result = mFairy.findPic2(comm.setImg("go.png"));
            comm.Click(0.95f, result, comm.getImg(), "开始", 3000);
        }
    }
}