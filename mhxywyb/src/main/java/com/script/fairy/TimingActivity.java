package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity  {
    AtFairyImpl mFairy;

    GameUtil gameUtil;
    boolean scn=true;
    public TimingActivity(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);

    }

    /**
     * 限时*皇宫飞贼
     *
     * @throws Exception
     */
    public void palaceThief() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                timekeepInit("任务");
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Flying thief.png",1);
                if (ret==1){
                    setTaskName(2);
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                if (overtime(100,0))return;
                boolean xh = timekeep(0,1200000,"任务");//1800000
                if (xh){
                    setTaskName(0);return;
                }
                result = mFairy.findPic(new String[]{"Quick join.png","Quick join2.png"});
                mFairy.onTap(0.8f, result, "快速加入",3000);

                result = mFairy.findPic("receive fly.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);


//                result = mFairy.findPic("auto.png");
//               if (result.sim > 0.8f){
//                   setTaskName(0);return;
//               }
            }


        }.taskContent(mFairy, "限时****皇宫飞贼");
    }

    /**
     * 限时*校场演兵
     *
     * @throws Exception
     */
    public void schoolField() throws Exception {
        new SingleTask(mFairy) {
            @Override
            public void create() throws Exception {
                int hour = mFairy.dateHour();
                if ( hour > 20 || hour<19){
                    setTaskEnd();return;
                }
            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("schoolField.png",1);
                if (ret==1){
                    setTaskName(2);
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic(new String[]{"Quick join.png","Quick join2.png"});
                mFairy.onTap(0.8f, result, "快速加入",3000);

                result = mFairy.findPic("receive fly.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);


                result = mFairy.findPic("auto.png");
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }


        }.taskContent(mFairy, "限时**校场演兵");
    }

    /**
     * 限时*小龟快跑
     *
     * @throws Exception
     */
    public void turtleRun() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Turtle.png",1);
                if (ret==1){
                    setTaskName(2);
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic(new String[]{"support.png","shengyuan.png"});
                mFairy.onTap(0.8f, result, "声援",2000);


                result = mFairy.findPic(new String[]{"support2.png","support2vip.png"});
                mFairy.onTap(0.8f, result, "声援",2000);
                mFairy.onTap(0.8f, result, 478,504,494,510,"声援",2000);
                mFairy.onTap(0.8f, result, 485,751,494,756,"声援",2000);
                mFairy.onTap(0.8f, result, 643,942,661,948,"声援",2000);
                mFairy.onTap(0.8f, result, 582,454,593,464,"声援",2000);

                result = mFairy.findPic("auto.png");
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "限时**小龟快跑");
    }

    /**
     * 限时*强盗入侵
     *
     * @throws Exception
     */
    public void banditInvasion() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("robber.png",1);
                if (ret==1){
                    setTaskName(2);
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic(new String[]{"Quick join2.png","Quick join.png"});
                mFairy.onTap(0.8f, result, "快速加入",3000);

                result = mFairy.findPic("receive fly.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);

            }

            public void content_3() throws Exception {

//                result = mFairy.findPic(new String[]{"attack.png", "attack2.png"});
//                mFairy.onTap(0.8f, result, "攻击", Sleep);


            }

        }.taskContent(mFairy, "限时****强盗入侵");
    }

    /**
     * 限时*科举
     *
     * @throws Exception
     */
    public void examination() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission2("examination.png","examination.png",1);
                if (ret==1){
                    setTaskName(2);
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic("answer.png");
                mFairy.onTap(0.8f, result, "开始答题",3000);

                result = mFairy.findPic("writing brush.png");
                mFairy.onTap(0.8f, result,120,769,131,777, "第一个", 3000);
                mFairy.onTap(0.8f, result,456,772,461,780, "第二个", 3000);
                mFairy.onTap(0.8f, result,133,881,148,891, "第三个", 3000);
                mFairy.onTap(0.8f, result,449,879,467,894, "第四个", 3000);

                result = mFairy.findPic("congratulations.png");
                if (result.sim > 0.8f){
                    LtLog.e("恭喜通过 结束任务");
                    setTaskName(0);return;
                }

            }

            public void content_3() throws Exception {

//                result = mFairy.findPic(new String[]{"attack.png", "attack2.png"});
//                mFairy.onTap(0.8f, result, "攻击", Sleep);


            }

        }.taskContent(mFairy, "限时**科举");
    }

    /**
     * 限时*英雄大会
     *
     * @throws Exception
     */
    public void hero() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("hero.png",1);
                if (ret==1){
                    setTaskName(2);
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic("pipei.png");
                mFairy.onTap(0.8f, result, "匹配对手",3000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic("twenty.png");
                if (result.sim > 0.8f){
                    LtLog.e("恭喜通过 结束任务");
                    setTaskName(0);return;
                }

            }


        }.taskContent(mFairy, "限时**英雄打会");
    }


}
