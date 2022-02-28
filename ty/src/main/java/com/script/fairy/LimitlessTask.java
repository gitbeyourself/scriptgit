package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask  extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    OtherGame otherGame;
    SingleTask singleTask;
    TeamTask teamTask;
    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        singleTask=new SingleTask(mFairy);
        teamTask=new TeamTask(mFairy);
    }


    /**
     * 野外挂机
     *
     * @throws Exception
     */
    public void ywgj() throws Exception {
        new LimitlessTask(mFairy) {
            String coords [];
            boolean dg = false;
            @Override
            public void create() throws Exception {
                int hours = mFairy.dateHour();
                int min = mFairy.dateMinute();
                if(!AtFairyConfig.getOption("coord").equals("")){
                    String coord=AtFairyConfig.getOption("coord");
                     coords =coord.split(",");
                }

                if(AtFairyConfig.getOption("work").equals("1")){
                   dg = true;
                }

                if(AtFairyConfig.getOption("ycpd").equals("1")){
                    if (hours ==19 && min >=30 && min < 42 ){
                        ycpd();
                    }
              }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                LtLog.e("--------------x"+coords[0]+"--------y"+coords[1]);
                if (AtFairyConfig.getOption("ywgj").equals("1")){
                    int ret = gameUtil.goCity("萤川郡",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
                if (AtFairyConfig.getOption("ywgj").equals("2")){
                    int ret = gameUtil.goCity("灵虚",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
                if (AtFairyConfig.getOption("ywgj").equals("3")){
                    int ret = gameUtil.goCity("伞村",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
                if (AtFairyConfig.getOption("ywgj").equals("4")){
                    int ret = gameUtil.goCity("云波之境",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
                if (AtFairyConfig.getOption("ywgj").equals("5")){
                    int ret = gameUtil.goCity("汐愿之海",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }if (AtFairyConfig.getOption("ywgj").equals("6")){
                    int ret = gameUtil.goCity("亡命岛",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
                if (AtFairyConfig.getOption("ywgj").equals("7")){
                    int ret = gameUtil.goCity("苏澜郡",coords[0],coords[1]);
                    if (ret == 1) {
                        gameUtil.close();
                        setTaskName(3);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }

            }
            public void content_3() throws Exception {
                int hours = mFairy.dateHour();
                int min = mFairy.dateMinute();
                if(AtFairyConfig.getOption("ycpd").equals("1")){
                    if (hours ==19 && min >=30 && min < 42 ){
                        ycpd();
                    }
                }
                long  datetinme = mFairy.mMatTime(1171,109,27,10,0.9f);
                if (datetinme >=60){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("resurrection.png");
                mFairy.onTap(0.8f, result, "复活", Sleep);
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }

                if (datetinme > 5) {
                    result = mFairy.findPic("land.png");
                    mFairy.onTap(0.8f, result, "降落", Sleep);


                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.7f, result, "开启自动", Sleep);
                }
                LtLog.e("发呆---------"+datetinme+"秒");

                if (timekeep(1,1800000,"打工")&& dg){
                    dg();
                    timekeepInit("打工");

                }
            }
        }.taskContent(mFairy, "野外挂机");
    }


    /**
     * 打工
     *
     * @throws Exception
     */
    public void dg() throws Exception {
        new LimitlessTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                //if (overtime(10,0))return;
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);

                result = mFairy.findPic(999,190,1229,559,"Sociology.png");
                mFairy.onTap(0.8f,result,"社会",2000);

                result = mFairy.findPic("Working.png");
                mFairy.onTap(0.8f,result , "打工",2000);

                result = mFairy.findPic("red2.png");
                mFairy.onTap(0.8f,result , 50,652,60,667,"领取奖励",2000);

                result = mFairy.findPic("Receive reward.png");
                mFairy.onTap(0.8f,result , "领取奖励确认",Sleep);

                result = mFairy.findPic("begin work.png");
                mFairy.onTap(0.8f,result , "开始打工",2000);

                result = mFairy.findPic("begin work2.png");
                mFairy.onTap(0.8f,result , 743,492,759,500,"开始打工确认",Sleep);
                if (result.sim > 0.8f){
                    gameUtil.close();
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"Unlocking2.png","Working2.png","never num.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                    LtLog.e("打工中或者次数已用完或者没解锁");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "打工");
    }

    /**
     * 泳池派对
     *
     * @throws Exception
     */
    public void ycpd() throws Exception {
        new LimitlessTask(mFairy) {
            @Override
            public void inOperation() throws Exception {
                int hours = mFairy.dateHour();
                int min = mFairy.dateMinute();

                if ((hours ==19 && min >42 )|| hours>19 || hours < 19){
                    setTaskEnd();return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {

                int re = gameUtil.mission("pool.png", 3);
                if (re == 1) {
                    setTaskName(2);
                    return;
                } else {
                    setTaskEnd();
                    return;
                }
            }

           public void content_2() throws Exception {
                long datetime = mFairy.mMatTime(1131,29,15,9,0.9);
                result = mFairy.findPic("Pool Party.png");
                if (result.sim > 0.8f){
                   setTaskName(3);
                   return;
                }
                if (datetime > 35 && result.sim < 0.8f){
                    setTaskName(0);return;
                }


           }

           public void content_3() throws Exception{
               result1 = mFairy.findPic("A.png");
               if (result1.sim > 0.8f){
                   result = mFairy.findPic("zero.png");
                   if (result.sim < 0.8f){
                       mFairy.onTap(0.8f,result,"答题A",Sleep);
                   }
                   result = mFairy.findPic(1151,319,1203,348,"zero.png");
                   if (result.sim < 0.8f){
                       mFairy.onTap(0.8f,result,"答题B",Sleep);
                   }
                   result = mFairy.findPic(1149,418,1200,440,"zero.png");
                   if (result.sim < 0.8f){
                       mFairy.onTap(0.8f,result,"答题C",Sleep);
                   }
                   result = mFairy.findPic(1147,514,1202,538,"zero.png");
                   if (result.sim < 0.8f){
                       mFairy.onTap(0.8f,result,"答题D",Sleep);
                   }

               }

               result = mFairy.findPic("dice.png");
               mFairy.onTap(0.8f,result,"骰子",Sleep);

               result = mFairy.findPic("click begin.png");
               mFairy.onTap(0.8f,result,"点击开始",Sleep);

               result = mFairy.findPic("whole.png");
               mFairy.onTap(0.8f,result,1051,55,1064,69,"全部投完了",Sleep);


           }
        }.taskContent(mFairy, "泳池派对");
    }

}
