package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    int picCount=0;
    public Util(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    public void close(String info) throws Exception{
        LtLog.e(mFairy.getLineInfo(info));
        close();
    }

    public void close() throws Exception {
        new Util(mFairy) {
            int j = 2;
            public void content_0() throws Exception {
                for (int i = 0; i < j; i++) {
                    mFairy.condit();
                    result=mFairy.findPic(0,0,93,71,"return.png");
                    if(result.sim>0.8f){
                        j=10;
                        result1=mFairy.findPic(new String[]{"direction.png","direction1.png"});
                        if(result1.sim<0.8f){
                            mFairy.onTap(0.8f,result,"util_return",750);
                        }else{
                            LtLog.e(mFairy.getLineInfo(0.8f,result,"gameUtil_close，战斗结束后关闭"));
                        }
                    }

                    result=mFairy.findPic(753,0,1280,317,new String[]{"pic close1.png","pic close3.png"});
                    mFairy.onTap(0.8f,result,"叉",1000);
                    if (result.sim > 0.8f) {
                        j = 20;
                    } else {
                        j = 2;
                    }
                    result=mFairy.findPic( 535,600,620,700,"tap.png");
                    mFairy.onTap(0.8f,result,"util_点击跳过",200);

                    result=mFairy.findPic("word cancel1.png");
                    mFairy.onTap(0.8f,result,"点击取消",200);

                    result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                    mFairy.onTap(0.9f,result,702,406,715,419,"发呆跳过",1000);
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "------------------------------------------------------------------------关叉中");
    }

    /**
     * 对mFairy.change(x1,y1,x2,y2);的封装,范围内哪里变化点击哪里
     * @param x1 范围x1
     * @param y1 范围y1
     * @param x2 范围x2
     * @param y2 范围y2
     * @param info 输出到日志里,点击事件的信息
     * @return change 变化的坐标(String类型)
     * @throws Exception
     */
    public String change(int x1,int y1,int x2,int y2,String info) throws Exception{
        String change=mFairy.change(x1,y1,x2,y2);
        if(!change.equals("0,0")){
            int coordX=Integer.parseInt(change.split(",")[0]);
            int coordY=Integer.parseInt(change.split(",")[1]);
            mFairy.onTap(coordX,coordY,coordX+1,coordY+1,info,200);
        }
        return  change;
    }

    int tastState = 0;
    public int mission(final String str, final int option) throws Exception {
        new Util(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
          public void content_0() throws Exception {
                result = mFairy.findPic("tianshuInface.png");
                LtLog.e(mFairy.getLineInfo(0.8f, result, "红线天书界面"));
                if (result.sim > 0.8f) {
                    if (findtask >= 2) {
                        LtLog.e("没有这个任务");
                        Util.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                    setTaskName(1);
                    return;
                }
                close();
                setTaskName(1);
            }
            /**
             * 打开日常并且寻找任务
             */
            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("tianshu.png");
                mFairy.onTap(0.8f, result, "天书", Sleep);

                result = mFairy.findPic("tianshuInface.png");
                LtLog.e(mFairy.getLineInfo(0.85f, result, "红线天书界面"));
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    int colorNum=mFairy.getColorNum(132,621,220,720,"253,240,115",0.9f);
                    if(colorNum>200){
                        mFairy.onTap(168,665,177,678,"领取活跃奖励1",500);
                        mFairy.onTap(168,665,177,678,"领取活跃奖励2",500);
                        return;
                    }

                    result = mFairy.findPic(155,156,646,603, str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 1) {
                            mFairy.onTap(1209,135,1225,150, "日常", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(1212,236,1227,252, "冒险", Sleep);
                        }
                    }
                    findtask++;
                    setTaskName(2);
                }
            }

            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public void content_2() throws Exception {
                if (overtime(8, 0)) return;//计次并跳转
                result1 = mFairy.findPic(155,156,646,603, str);
                LtLog.e(mFairy.getLineInfo(0.1f,result1,str));
                if (result1.sim > 0.85f) {
                    LtLog.e("找到任务");
                    result = mFairy.findPic(result1.x + 53, result1.y - 43, result1.x + 116, result1.y +6, "wancheng.png");
                    if (result.sim > 0.75f) {
                        LtLog.e("完成");
                        Util.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }else {
                        mFairy.onTap(0.8f,result1,str,Sleep);
                        mFairy.onTap(0.8f,result1,903,618,934,635,"参加",Sleep);
                        Util.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 2, 332,582, 339,238, 500, 1500);
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }

    public FindResult findPic(int x1,int y1,int x2,int y2,String [] picNameArr)throws Exception{
        for (String picName: picNameArr) {
            result=mFairy.findPic(x1, y1, x2, y2, picName);
            if(result.sim>0.8f){
                return result;
            }
        }
        return result;
    }
}
