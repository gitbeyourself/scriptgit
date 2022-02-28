package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2019/4/11.
 */

/*public abstract class TaskContent {
    private int taskContentNum = 0;
    private boolean taskContentEnd = false;
    static String   TASKNAME="NULL";
    public Map<String, Integer> picCountMap = new HashMap();
    String logname;
    int err=0;

    public void setTaskName(int taskContentNum){
        err=0;
        this.taskContentNum=taskContentNum;
    }

    public void setTaskEnd(){
        err=0;
        taskContentEnd = true;
    }

    void taskContent(AtFairyImpl mFairy) throws Exception{
        create();
        while (mFairy.condit()) {
            if (taskContentEnd) {
                LtLog.e("【当前任务结束,End!】");
                break;
            }
            inOperation();
            if (taskContentNum == 0) {
                content_0();
                err=0;
            }

            if (taskContentNum == 1) {
                content_1();
            }
            if (taskContentNum == 2) {
                content_2();
            }
            if (taskContentNum == 3) {
                content_3();
            }
            if (taskContentNum == 4) {
                content_4();
            }
            if (taskContentNum == 5) {
                content_5();
            }
            if (taskContentNum == 6) {
                content_6();
            }
            if (taskContentNum == 7) {
                content_7();
            }
            if (taskContentNum == 8) {
                content_8();
            }
            if (taskContentNum == 9) {
                content_9();
            }
            if (taskContentNum == 10) {
                content_10();
            }

        }
    }

    void taskContent(AtFairyImpl mFairy,String info) throws Exception{
        this.logname = info;
        LtLog.e(info + ":【content__" + this.taskContentNum + "__err:" + this.err + "】");
        this.create();
        while (mFairy.condit()) {
                LtLog.e(info + ":【content__" + this.taskContentNum + "__err:" + this.err + "】");
                if (taskContentEnd) {
                LtLog.e("【当前任务结束,End!】");
                break;
            }
            inOperation();
            if (taskContentNum == 0) {
                content_0();
                err=0;
            }

            if (taskContentNum == 1) {
                content_1();
            }
            if (taskContentNum == 2) {
                content_2();
            }
            if (taskContentNum == 3) {
                content_3();
            }
            if (taskContentNum == 4) {
                content_4();
            }
            if (taskContentNum == 5) {
                content_5();
            }
            if (taskContentNum == 6) {
                content_6();
            }
            if (taskContentNum == 7) {
                content_7();
            }
            if (taskContentNum == 8) {
                content_8();
            }
            if (taskContentNum == 9) {
                content_9();
            }
            if (taskContentNum == 10) {
                content_10();
            }

        }
    }

    public class ControlSplit {
        public int choice;
        public int h;
        public int m;
        public int s;
        public long timeMillis;
        public int count;

        public ControlSplit() {
        }
    }

    public ControlSplit strSplit(String string) throws Exception {
        if(string==null||string.equals(""))return null;
        ControlSplit controlSplit = new ControlSplit();
        String[] arrstr = string.split("\\|\\|");
        String[] arrstr1;
        if(arrstr.length < 2) {
            arrstr1 = arrstr[0].split(":");
            if(arrstr1.length < 2) {
                controlSplit.count = Integer.parseInt(arrstr1[0]);
                return controlSplit;
            } else {
                controlSplit.h = Integer.parseInt(arrstr1[0]);
                controlSplit.m = Integer.parseInt(arrstr1[1]);
                controlSplit.s = Integer.parseInt(arrstr1[2]);
                controlSplit.timeMillis = (long)(controlSplit.h * 3600000 + controlSplit.m * '\uea60' + controlSplit.s * 1000);
                return controlSplit;
            }
        } else {
            controlSplit.choice = Integer.parseInt(arrstr[0]);
            arrstr1 = arrstr[1].split(":");
            if(arrstr1.length < 2) {
                controlSplit.count = Integer.parseInt(arrstr1[0]);
            } else {
                controlSplit.h = Integer.parseInt(arrstr1[0]);
                controlSplit.m = Integer.parseInt(arrstr1[1]);
                controlSplit.s = Integer.parseInt(arrstr1[2]);
                controlSplit.timeMillis = (long)(controlSplit.h * 3600000 + controlSplit.m * '\uea60' + controlSplit.s * 1000);
            }

            return controlSplit;
        }
    }

    *//**
     * 只执行一次
     *//*
    void create()throws Exception{}

    public int picCount(float sim, FindResult result, String string) throws Exception {
        if(this.picCountMap.containsKey(string)) {
            if(result.sim > sim) {
                int num = ((Integer)this.picCountMap.get(string)).intValue();
                ++num;
                this.picCountMap.put(string, Integer.valueOf(num));
            } else {
                this.picCountMap.put(string, Integer.valueOf(0));
            }
        } else {
            this.picCountMap.put(string, Integer.valueOf(0));
        }

        return ((Integer)this.picCountMap.get(string)).intValue();
    }

    *//**
     * 每次while都会执行
     *//*
    void inOperation()throws Exception{
        LtLog.e("【content__"+taskContentNum+"__err:"+err+"】");
    }

    *//**
     * 超时处理
     *//*
    boolean overtime(int num,int taskContentNum){
        err++;
        if(err>=num){
            if(taskContentNum==99){
                LtLog.e("【异常超时结束当前任务.....】");
                taskContentEnd=true;
            }else {
                LtLog.e("【异常超时切换到"+taskContentNum+".....】");
                this.taskContentNum = taskContentNum;
            }
            err=0;
            return true;
        }
        return false;
    }
    void content_0() throws Exception{}
    void content_1() throws Exception{}

    void content_2() throws Exception{}

    void content_3() throws Exception {}

    void content_4() throws Exception {}

    void content_5() throws Exception {}
    void content_6() throws Exception {}
    void content_7() throws Exception {}
    void content_8() throws Exception {}
    void content_9() throws Exception {}
    void content_10() throws Exception {}
}*/
