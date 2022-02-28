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
    int err=0;

    public void setTaskName(int taskContentNum){
        err=0;
        this.taskContentNum=taskContentNum;
    }

    public void setTaskEnd(){
        err=0;
        taskContentEnd = true;
    }

    public TaskContent(AtFairyImpl mFairy) throws Exception {
        create();
        while (mFairy.condit()) {
            LtLog.e("【 "+TASKNAME+"__content__"+taskContentNum+"__err:"+err+"】");
            if (taskContentEnd) {
                LtLog.e("【 "+TASKNAME+" 任务结束,End!】");
                break;
            }
            inOperation();
            if (taskContentNum == 0) {
                init();
                err=0;
            }

            if (taskContentNum == 1) {
                content_01();
            }
            if (taskContentNum == 2) {
                content_02();
            }
            if (taskContentNum == 3) {
                content_03();
            }
            if (taskContentNum == 4) {
                content_04();
            }
            if (taskContentNum == 5) {
                content_05();
            }
            if (taskContentNum == 6) {
                content_06();
            }
            if (taskContentNum == 7) {
                content_07();
            }
            if (taskContentNum == 8) {
                content_08();
            }
            if (taskContentNum == 9) {
                content_09();
            }
            if (taskContentNum == 10) {
                content_10();
            }

        }
    }

    abstract void create()throws Exception;

    abstract void init() throws Exception;


    void inOperation()throws Exception{}

    void overtime(int num,int taskContentNum){
        err++;
        if(err>=num){
            if(taskContentNum==99){
                taskContentEnd=true;
            }else {
                this.taskContentNum = taskContentNum;
            }
            err=0;
        }
    }
    abstract void content_01() throws Exception;

    abstract void content_02() throws Exception;

    void content_03() throws Exception {}

    void content_04() throws Exception {}

    void content_05() throws Exception {}
    void content_06() throws Exception {}
    void content_07() throws Exception {}
    void content_08() throws Exception {}
    void content_09() throws Exception {}
    void content_10() throws Exception {}
}
