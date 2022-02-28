
package com.example.administrator.xjqxz4;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/3/9.
 */

public class CheckTask implements Runnable {
    //监控线程
    xjqxz4 mFairy;
    FindResult result;
    private long time = 0;
    private boolean mIsStoped = true;
    CommonFunction commonFunction;
    int js_1=0 ;
    public CheckTask(xjqxz4 ypFairy) {
        mFairy = ypFairy;   commonFunction = new CommonFunction(mFairy);
    }
    @Override
    public void run()  {
        time=System.currentTimeMillis();
        while (true) {
                while (this.mIsStoped == true) {
                }
                try {
                    checkTask();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    LtLog.e(commonFunction.getLineInfo("------------+++-----------CheckTask异常死掉了"));
                }
        }

    }
    public void restart() {
        this.mIsStoped = false;
        LtLog.e(commonFunction.getLineInfo("------------+++-----------CheckTask.开启==") + this.mIsStoped);
    }

    public void stop() {
            this.mIsStoped = true;
        LtLog.e(commonFunction.getLineInfo( "-----------+++-----------CheckTask.停止===")  + this.mIsStoped);
    }

     private void checkTask()throws InterruptedException {
        Thread.sleep(3000);
         if ((System.currentTimeMillis()-time)>30000){
             LtLog.e(commonFunction.getLineInfo( "--------------------------CheckTask.checkTask-->") );
             LtLog.e( commonFunction.getLineInfo("-------------------------------掉线----------------------------------"+js_1));
             time=System.currentTimeMillis();
         }

     }

}
