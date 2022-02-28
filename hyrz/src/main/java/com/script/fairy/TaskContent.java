package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.LtLog;

/**
 * Created by user on 2019/4/11.
 */

public abstract class TaskContent {
    private int taskContentNum = 0;
    private boolean taskContentEnd = false;
    static String   TASKNAME="NULL";
    public String logname;
    int err=0;

    public void setTaskName(int taskContentNum){
        err=0;
        this.taskContentNum=taskContentNum;
    }

    public void setTaskEnd(){

        err=0;
        taskContentEnd = true;
    }
    void taskContent(AtFairyImpl mFairy,String string) throws Exception{
        this.logname = string;
        LtLog.e(string + ":【content__" + this.taskContentNum + "__err:" + this.err + "】");
        create();
        while (mFairy.condit()) {
            LtLog.e(string + ":【content__" + this.taskContentNum + "__err:" + this.err + "】");
            inOperation();
            if (taskContentEnd) {
                LtLog.e("【当前任务结束,End!】");
                break;
            }
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

    /**
     * 只执行一次
     */
     void create()throws Exception{}


    /**
     * 每次while都会执行
     */
    void inOperation()throws Exception{
        LtLog.e(logname + ":【content__" + this.taskContentNum + "__err:" + this.err + "】");
    }

    /**
     * 超时处理
     */
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
}
