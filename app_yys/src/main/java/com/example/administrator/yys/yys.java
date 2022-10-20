package com.example.administrator.yys;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;

import com.script.opencvapi.AtFairy2;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.AtFairyService;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.utils.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Administrator on 2018/3/13.
 */

public class yys extends AtFairy2 {
    private static String imagePath = null;
    private TaskThread taskThread;
    private Abnormal abnormal;
    public Context context;
    public Context mContext;
    private boolean taskState = false;
    Object lockTask = new Object();
    CommonFunction commonFunction = new CommonFunction(this);
    protected static boolean taskStartUp = false;//用来控制任务执行中为true
    public yys(Context context, Intent intentResult) {
        super(context, intentResult);
        this.context = context;
        this.mContext=context;
        if (AtFairyService.isApkInDebug(getContext())){
            keepalive(false);
        }
    }
    public void onStart() {
        String task_id;
        //启动任务
        //主线程 onStart 可能多次调用
        LtLog.e(commonFunction.getLineInfo("-------------------------- 阴阳师-onstart....."));
        this.taskStartUp = false;
        if (taskState == false) {
            //如果任务线程没有在运行,启动任务线程,并设置taskState为真
            this.taskState = true;
            task_id= AtFairyConfig.getOption("task_id");
            if (!(task_id.equals(""))){
                taskStartUp=true;
            }
            MainThread();
        }
        LtLog.e("都结束了+++++++++++++++++++++++++");

    }
    public byte[] getTemplateData(String name) {
        Object in = null;

        try {
            if(imagePath == null) {
                AssetManager assetManager = this.mContext.getAssets();
                in = assetManager.open(name);
            } else {
                String file = imagePath + "/" + name;
                in = new FileInputStream(file);
            }

            int len = ((InputStream)in).available();
            byte[] b = new byte[len];
            ((InputStream)in).read(b);
            byte[] var5 = b;
            return var5;
        } catch (FileNotFoundException var17) {
            var17.printStackTrace();
        } catch (IOException var18) {
            var18.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    ((InputStream)in).close();
                } catch (IOException var16) {
                    var16.printStackTrace();
                }
            }

        }

        return null;
    }
  /*  public FindResult findPic2(String name)  {
        FindResult result = super.findPic2(name);
        if(result == null){
            FindResult result1 = new FindResult();
            result1.sim=0.1f;
           *//* result1.x=1;
            result1.y=1;
            result1.height=1;
            result1.width=1;
            result1.timestamp=1;*//*
            return  result1;
        }
        return result ;
    }*/
   /* public FindResult findPic2(int leftX, int leftY, int rightX, int rightY, String name)  {
        FindResult result =super.findPic2(leftX, leftY, rightX, rightY, name);
        if(result == null){
            FindResult result1 = new FindResult();
            result1.sim=0.1f;
            return  result1;
        }
        return result ;
    }*/
/*    public FindResult findPicRange(String name, int wide) {

        FindResult result =super.findPicRange(name, wide);
        if(result == null){
            FindResult result1 = new FindResult();
            result1.sim=0.1f;
            result1.x=1;
            result1.y=1;
            result1.height=1;
            result1.width=1;
            result1.timestamp=1;
            return  result1;
        }
        return result ;
    }*/

    public void onRestart(){
        LtLog.e(commonFunction.getLineInfo("------------+++--------------阴阳师 onRestart....."));
        killUserGame();
    }

    public void onStop() {
        //停止任务
        LtLog.e(commonFunction.getLineInfo("------------+++--------------阴阳师 onStop....."));
       synchronized (lockTask) {
           LtLog.e(commonFunction.getLineInfo("进入到了阴阳师 onStop....."));
            this.taskStartUp = false;
            lockTask.notify();
      }

    }

    public void onResume() {
        //继续运行任务
        LtLog.e(commonFunction.getLineInfo("----------onResume------"));
           synchronized (lockTask) {
               LtLog.e(commonFunction.getLineInfo("----------进入到了onResume------"));
               this.taskStartUp=true;
               lockTask.notify();
        }
  }

    public void onPause() {

    }

    public void onChangeConfig() {

    }

    public boolean onMonitorState(int i) {
        return false;
    }

    public void onCheckStop() {

    }

    public void onCheckStart() {

    }

    public void MainThread() {
        long time_1;
        String nowTime2="没有开启任务";
        SimpleDateFormat format1=new SimpleDateFormat("HH:mm:ss");
        String nowTime1=format1.format(new Date());
        time_1=System.currentTimeMillis();
        Date date = new Date();
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        while (true) {
            taskThread  = new TaskThread(this);    //任务线程
            abnormal = new Abnormal(this);  //异常线程

            Thread threadTaskThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LtLog.e(commonFunction.getLineInfo("———————————————————————————————————————————————————————启动任务线程"));
                        try {
                            taskThread.taskTread();
                        }catch (Exception e) {
                            LtLog.i(e.toString());
                            StringWriter sw = new StringWriter();
                            e.printStackTrace(new PrintWriter(sw, true));
                            String str = sw.toString();
                            LtLog.e(str);
                        }
                    LtLog.e(commonFunction.getLineInfo("———————————————————————————————————————————————————————任务线程结束"));
                }
            });

            Thread threadAbnormal = new Thread(new Runnable() {
                @Override
                public void run() {
                    LtLog.e(commonFunction.getLineInfo("———————————————————————————————————————————————————————启动异常线程"));
                    try {
                       abnormal.error();
                    }catch (Exception e) {
                        LtLog.i(e.toString());
                        StringWriter sw = new StringWriter();
                        e.printStackTrace(new PrintWriter(sw, true));
                        String str = sw.toString();
                        LtLog.e(str);
                    }
                    LtLog.e(commonFunction.getLineInfo("———————————————————————————————————————————————————————异常线程结束"));
                }
            });

            while (true) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if ((System.currentTimeMillis()-time_1)>30000){
                    LtLog.e(commonFunction.getLineInfo("【阴阳师版本号 - 122 -  用户进入设备时间:"+df1.format(date)+":"+nowTime1+", 用户开启任务的时间:"+nowTime2+"】"));
                    LtLog.e(commonFunction.getLineInfo("【当前时间:"+df1.format(new Date())+":"+ format1.format(new Date())+", threadTaskThread:"+threadTaskThread.getState()+",taskStartUp=="+taskStartUp+"】"));
                    time_1=System.currentTimeMillis();
                }
                if (threadTaskThread.getState().equals(Thread.State.TERMINATED)  &&   !(threadAbnormal.getState().equals(Thread.State.TERMINATED)) ){
                    threadAbnormal.interrupt();
                }
                if (threadTaskThread.getState().equals(Thread.State.TERMINATED) &&   threadAbnormal.getState().equals(Thread.State.TERMINATED)  ){
                    break;
                }
                if (taskStartUp==true && threadTaskThread.getState().equals(Thread.State.NEW)){
                    LtLog.e(commonFunction.getLineInfo("———————————————————————————————————————————————————————启动任务线程"));
                    threadTaskThread.start(); //任务线程
                    threadAbnormal.start();
                    LtLog.e(commonFunction.getLineInfo("----------继续运行任务结束------"));
                    nowTime2=format1.format(new Date());
                }

                if (AtFairyConfig.getOption("task_id").equals("")){
                    taskStartUp=false;
                }

                if (taskStartUp == false && !(threadTaskThread.getState()==Thread.State.TERMINATED) && !(threadTaskThread.getState().equals(Thread.State.NEW))) {
                    threadTaskThread.interrupt();
                    threadAbnormal.interrupt();
                    while (!(threadTaskThread.getState().equals(Thread.State.TERMINATED))){
                        LtLog.e(commonFunction.getLineInfo("任务线程还没死等着---,threadTaskThread=="+threadTaskThread.getState()));
                        threadTaskThread.interrupt();
                        Utils.sleep(1000);
                    }
                    while (!(threadAbnormal.getState().equals(Thread.State.TERMINATED))){
                        LtLog.e(commonFunction.getLineInfo("异常线程还没死等着---,threadAbnormal==" +threadAbnormal.getState()));
                        threadAbnormal.interrupt();
                        Utils.sleep(1000);
                    }
                    LtLog.e(commonFunction.getLineInfo("线程全死了---,threadTaskThread=="+threadTaskThread.getState()+",threadAbnormal==" +threadAbnormal.getState()));
                    break;
                }
            }
        }
    }

}

