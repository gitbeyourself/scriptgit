package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2019/4/11.
 */

public abstract class TaskContent {
    private int taskContentNum = 0;
    private boolean taskContentEnd = false;
    private AtFairyImpl mFairy;
    FindResult result;
    private String name;
    public static Boolean actBools = false;
    public static int err = 0;
    public boolean battle = true;
    public static Map<String,Integer> fm = new HashMap<>();
    public static Map<String,Long> tm = new HashMap<>();
    Slide activitySlide = new Slide(825,129,863,502);
    Slide taskSlide = new Slide(1103, 97, 1120, 150);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTaskName(int taskContentNum) {
        err = 0;
        this.taskContentNum = taskContentNum;
        LtLog.e("                                                                                        【 跳转 TaskName: "+taskContentNum+"】");

    }

    public void setTaskEnd() {
        err = 0;
        fm.clear();
        taskContentEnd = true;
    }

    public TaskContent(AtFairyImpl mFairy, String name) throws Exception {
        this.mFairy = mFairy;
        this.name = name;
        actBools =false;
        /*** 进入任务循环
         */
        initTaskContent(name);
    }

    public void initTaskContent(String name) throws Exception {
        create();
        err = 0;
        while (mFairy.condit()) {
            if (taskContentEnd) {
                LtLog.e("                                                                                        【 " + getName() + " 任务结束,End!】");
                LtLog.e("                                                                                        【 切换任务中.....】");
                LtLog.e("                                                                                        【 切换任务中.....】");
                LtLog.e("                                                                                        【 切换任务中.....】");
                break;
            }

            if (taskContentNum == 0) {
                LtLog.e("                                                                                        【 " + getName() + " init】");
                init();
                err = 0;
            }

            if (taskContentNum == 1) {
                if (err != 0 || timeMap("errCount",30000)) {
                    LtLog.e("                                                                                        【 " + getName() + " content_01  err:" + err + "】");
                }
                content_01();
            }

            if (taskContentNum == 2) {
                if (err != 0 || timeMap("errCount",30000)) {
                    LtLog.e("                                                                                        【 " + getName() + " content_02  err:" + err + "】");
                }
                content_02();
            }

            if (taskContentNum == 3) {
                if (err != 0 || timeMap("errCount",30000)) {
                    LtLog.e("                                                                                        【 " + getName() + " content_03  err:" + err + "】");
                }
                content_03();
            }
            if (taskContentNum == 4) {
                if (err != 0 || timeMap("errCount",30000)) {
                    LtLog.e("                                                                                        【 " + getName() + " content_04  err:" + err + "】");
                }
                content_04();
            }
            if (taskContentNum == 5) {
                if (err != 0 || timeMap("errCount",30000)) {
                    LtLog.e("                                                                                        【 " + getName() + " content_05  err:" + err + "】");
                }
                content_05();
            }

            inOperation();
        }
    }

    void create() throws Exception {
        fm = new HashMap<String,Integer>();
        tm = new HashMap<String,Long>();
    }

    void init() throws Exception {
        battle = true;
    }

    void content_01() throws Exception {
    }

    void content_02() throws Exception {
    }

    void inOperation() throws Exception {
    }

    void content_03() throws Exception {
    }

    void content_04() throws Exception {
    }

    void content_05() throws Exception {
    }

    /**
     * 超时处理
     **/
    boolean timeCount(int num, int taskContentNum) {
        err++;
        if (err >= num) {
            if (taskContentNum == 99) {
                taskContentEnd = true;
            } else {
                this.taskContentNum = taskContentNum;
            }
            err = 0;
            return true;
        }
        return false;
    }

    /**
     * 快速找图
     **/
    boolean mapCount(float sim, int x, int y, int x1, int y1, String name) throws Exception {
        for (int i = 0; i < 3; i++) {
            FindResult result = mFairy.findPic(x, y, x1, y1, name);
            if (result.sim >= sim) {
                return true;
            }
        }
        return false;
    }

    boolean mapCount(float sim, String name) throws Exception {
        for (int i = 0; i < 10; i++) {
            FindResult result = mFairy.findPic(name);
            if (result.sim >= sim) {
                return true;
            }
        }
        return false;
    }

    /**
     * other
     * @throws Exception
     */
    public void battle() throws Exception {

        for (int i = 0; i <= 5; i++) {
            Thread.sleep(100);
            long l = mFairy.getColorNum(852, 470, 922, 532, "174,241,240", 0.92f);
            if (l > 3) {
                if (battle) {
                    battle = false;
                    result = mFairy.findPic("bat.png");
                    mFairy.onTap(0.85f, result, "自动战斗", 500);

                    for (int j = 0; j < 10; j++) {

                        result = mFairy.findPic(371, 78, 552, 320, "fuzhu.png");
                        if (result.sim > 0.75f) {
                            return;
                        }
                    }
                    result = mFairy.findPic("bat.png");
                    mFairy.onTap(0.85f, result, "自动战斗", 2000);
                }

            } else {
                if (i == 5) {
                    result = mFairy.findPic("bat.png");
                    mFairy.onTap(0.85f, result, "自动战斗", 3000);
                    battle = false;
                }
            }

        }
    }//战斗判断

    public boolean gm()throws Exception{
        result= mFairy.findPic(654,520,794,606,"gm3.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result, "购买", 500);
            mFairy.onTap(712,433,744,448,"",1000);
            return false;
        }else {
            result = mFairy.findPic(577, 298, 1272, 712, new String[]{"gm1.png", "gm2.png"});
            if (result.sim > 0.8f) {
                mFairy.onTap(0.8f, result, "购买", 500);

                if (mapCount(0.8f, 635, 144, 692, 296, "man.png")) {
                    /**
                     * 上报
                     */
                    LtLog.e(mFairy.getLineInfo("背包已满"));
                    mFairy.finish(AtFairyConfig.getTaskID(), 28101);
                    setTaskEnd();
                    return true;
                }
                return true;
            }
        }
        return false;
    }//购买

    private int skip = 0;
    public void skip()throws Exception{
        result = mFairy.findPic(new String[]{"skip.png", "chat3.png"});
        if (result.sim > 0.8f) {
            err = 0;
            skip++;
            if (skip>=5) {
                mFairy.onTap(996, 311, 1059, 325, "skip >>> err", 500);
            } else {
                mFairy.onTap(0.8f, result, "skip", 200);
            }
        }else{
            skip=0;
        }
    }//skip

    /**
     * 次数判断
     **/
    void frequencyInit(String key){
        if(fm.containsKey(key)){
            fm.put(key,0);
        }
    }

    boolean frequencyMap(String key,int frequen){
        if(fm.containsKey(key)){
            fm.put(key, fm.get(key)+1);
            if(fm.get(key)>=frequen){
                fm.put(key,0);
                return true;
            }
        }else{
            fm.put(key,1);
        }
        return false;
    }

    static boolean timeMap(String key,long sheep){
        long s = System.currentTimeMillis();
        if(tm.containsKey(key)){
            if(s - tm.get(key)>=sheep){
                tm.put(key,s);
                return true;
            }
        }else{
            tm.put(key,s);
            return true;
        }
        return false;
    }

    public int oneSecond = 0;
    boolean oneSecond() throws Exception {
        if (oneSecond == 0) {
            oneSecond = 1;
            return true;
        }
        return false;
    }//只执行一次

    public int judgeOneSecond = 0;
    boolean judgeOneSecond() throws Exception {
        if (judgeOneSecond == 0) {
            return true;
        }
        return false;
    }//可定义执行一次

    public int modularLookup = 0;
    public FindResult modularLookup(int x,int y,int x1,int y1,String img)throws Exception{
        int calculationHigh = (y1-y)*modularLookup;
        return mFairy.findPic(x, y+calculationHigh, x1, y1+calculationHigh,img);
    }//模块查找


/**
 * 内部类
 */

    /**
     * 滑动
     **/
    class Slide {
        private int[] slideRangeIndex = new int[4];
        private int moveTime = 200;
        private long endTime = 200;
        private int moveInitTime = 200;
        private long endInitTime = 20;

        public Slide(int x, int y, int x1, int y1) {
            slideRangeIndex[0] = x;
            slideRangeIndex[1] = y;
            slideRangeIndex[2] = x1;
            slideRangeIndex[3] = y1;
            LtLog.e("new Slide >>>>>");
        }

        public void slideRange(int[] count, int type, int init) throws Exception {
            if (count.length > 0) {
                if (err == count[0]) {
                    LtLog.e(mFairy.getLineInfo("slideRange init滑动>>>"));
                    LtLog.e(mFairy.getLineInfo(slideRangeIndex[0] + "," + slideRangeIndex[1] + "," +
                            slideRangeIndex[2] + "," + slideRangeIndex[3] + ""));
                    for (int i = 0; i < 4; i++) {
                        mFairy.ranSwipe(slideRangeIndex[0], slideRangeIndex[1], slideRangeIndex[2], slideRangeIndex[3], init, moveInitTime, endInitTime);
                    }
                    Thread.sleep(endTime);
                }

                for (int i = 1; i < count.length; i++) {
                    if (err == count[i]) {
                        LtLog.e(mFairy.getLineInfo("slideRange type滑动>>>"));
                        switch (type){
                            case 0:
                                mFairy.touchDown(type,slideRangeIndex[0],slideRangeIndex[1]);
                                mFairy.touchMove(type,slideRangeIndex[0],slideRangeIndex[3],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                            case 1:
                                mFairy.touchDown(type,slideRangeIndex[0],slideRangeIndex[1]);
                                mFairy.touchMove(type,slideRangeIndex[2],slideRangeIndex[1],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                            case 2:
                                mFairy.touchDown(type,slideRangeIndex[0],slideRangeIndex[3]);
                                mFairy.touchMove(type,slideRangeIndex[0],slideRangeIndex[1],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                            case 3:
                                mFairy.touchDown(type,slideRangeIndex[2],slideRangeIndex[1]);
                                mFairy.touchMove(type,slideRangeIndex[0],slideRangeIndex[1],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                        }
                    }
                }
            }
        }

        public void slideRange(int[] count, int type) throws Exception {
            if (count.length > 0) {
                for (int i = 0; i < count.length; i++) {
                    if (err == count[i]) {
                        LtLog.e(mFairy.getLineInfo("slideRange type滑动>>>"));
                        switch (type){
                            case 0:
                                mFairy.touchDown(type,slideRangeIndex[0],slideRangeIndex[1]);
                                mFairy.touchMove(type,slideRangeIndex[0],slideRangeIndex[3],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                            case 1:
                                mFairy.touchDown(type,slideRangeIndex[0],slideRangeIndex[1]);
                                mFairy.touchMove(type,slideRangeIndex[2],slideRangeIndex[1],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                            case 2:
                                mFairy.touchDown(type,slideRangeIndex[0],slideRangeIndex[3]);
                                mFairy.touchMove(type,slideRangeIndex[0],slideRangeIndex[1],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                            case 3:
                                mFairy.touchDown(type,slideRangeIndex[2],slideRangeIndex[1]);
                                mFairy.touchMove(type,slideRangeIndex[0],slideRangeIndex[1],moveTime);
                                Thread.sleep(endTime);
                                mFairy.touchUp(type);
                                break;
                        }
                    }
                }
            }
        }

        /****/
        public void slideRange(int num, int[] count, int type, int init) throws Exception {
            if (count.length > 0) {
                if (num == count[0]) {
                    LtLog.e(mFairy.getLineInfo("slideRange init滑动>>>"));
                    LtLog.e(mFairy.getLineInfo(slideRangeIndex[0] + "," + slideRangeIndex[1] + "," +
                            slideRangeIndex[2] + "," + slideRangeIndex[3] + ""));
                    for (int i = 0; i < 3; i++) {
                        mFairy.ranSwipe(slideRangeIndex[0], slideRangeIndex[1], slideRangeIndex[2], slideRangeIndex[3], init, moveInitTime, endInitTime);
                    }
                    Thread.sleep(endTime);
                }

                for (int i = 1; i < count.length; i++) {
                    if (num == count[i]) {
                        LtLog.e(mFairy.getLineInfo("slideRange type滑动>>>"));
                        LtLog.e(mFairy.getLineInfo(slideRangeIndex[0] + "," + slideRangeIndex[1] + "," +
                                slideRangeIndex[2] + "," + slideRangeIndex[3] + ""));
                        mFairy.ranSwipe(slideRangeIndex[0], slideRangeIndex[1], slideRangeIndex[2], slideRangeIndex[3], type, moveTime, endTime);

                    }
                }
            }
        }

        public void slideRange(int num, int[] count, int type) throws Exception {
            LtLog.e(mFairy.getLineInfo("slideRange >>>"));
            if (count.length > 0) {
                for (int i = 0; i < count.length; i++) {
                    if (num == count[i]) {
                        LtLog.e(mFairy.getLineInfo("slideRange type滑动>>>"));
                        LtLog.e(mFairy.getLineInfo(slideRangeIndex[0] + "," + slideRangeIndex[1] + "," +
                                slideRangeIndex[2] + "," + slideRangeIndex[3] + ""));
                        mFairy.ranSwipe(slideRangeIndex[0], slideRangeIndex[1], slideRangeIndex[2], slideRangeIndex[3], type, moveTime, endTime);
                    }
                }
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

        public ControlSplit(String string) throws Exception {
            String[] arrstr = string.split("\\|\\|");
            String[] arrstr1;
            if(arrstr.length < 2) {
                arrstr1 = arrstr[0].split(":");
                if(arrstr1.length < 2) {
                    count = Integer.parseInt(arrstr1[0]);
                } else {
                    h = Integer.parseInt(arrstr1[0]);
                    m = Integer.parseInt(arrstr1[1]);
                    s = Integer.parseInt(arrstr1[2]);
                    timeMillis = (long)(h * 3600000 + m * '\uea60' + s * 1000);
                }
            } else {
                choice = Integer.parseInt(arrstr[0]);
                arrstr1 = arrstr[1].split(":");
                if(arrstr1.length < 2) {
                    count = Integer.parseInt(arrstr1[0]);
                } else {
                    h = Integer.parseInt(arrstr1[0]);
                    m = Integer.parseInt(arrstr1[1]);
                    s = Integer.parseInt(arrstr1[2]);
                    timeMillis = (long)(h * 3600000 + m * '\uea60' + s * 1000);
                }
            }
        }
    }



}
