package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
/**
 * Created by Administrator on 2019/11/5 0005.
 */

public class OtherGame  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    GameUtil gameUtil;
    SingleTask singleTask;
    int count;
    public OtherGame(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        gameUtil = new GameUtil(mFairy);
        singleTask=new SingleTask(mFairy);
    }
    /**
     *
     * 清包 红0-1星
     * @throws Exception
     */
    public void Clear() throws Exception {
        new OtherGame(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                init();
                result = mFairy.findPic("bags1.png");
                LtLog.e("**************"+result.sim);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("bags1.png");
                mFairy.onTap(0.8f, result, "背包", 1000);
                result = mFairy.findPic("recoverys3.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "回收", 2000);
                    result = mFairy.findPic(477,428,546,473,"reds2.png");
                    result2 = mFairy.findPic(482,387,563,432,"orange.png");
                    if(result.sim>0.8f){
                        if(result2.sim>0.8f) {
                            mFairy.onTap(0.8f, result2, 496, 396, 520, 417, "取消", 3000);
                        }
                        result = mFairy.findPic("recoverys1.png");
                        mFairy.onTap(0.8f, result, "回收", 3000);
                        count++;

                    }
                    if(result.sim<0.8f){
                        if(result2.sim>0.8f){
                            mFairy.onTap(0.8f, result2,496,396,520,417, "取消", 1000);
                        }
                        mFairy.onTap(495,438,521,465, "红色装备选择", 3000);
                        result = mFairy.findPic("recoverys1.png");
                        mFairy.onTap(0.8f, result, "回收", 3000);
                        count++;
                    }
                }
                LtLog.e("*****************"+count);
                if(count>=1){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "清包红");
    }
    /**
     *
     * 清包橙0-1星
     * @throws Exception
     */
    public void Clear2() throws Exception {
        new OtherGame(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                init();
                result = mFairy.findPic("bags1.png");
                LtLog.e("**************"+result.sim);
                if (result.sim > 0.8f) {
                    setTaskName(2);
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("bags1.png");
                mFairy.onTap(0.8f, result, "背包", 1000);
                result = mFairy.findPic("recoverys3.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "回收", 2000);
                    result2 = mFairy.findPic(477,428,546,473,"reds2.png");
                    result = mFairy.findPic(482,387,563,432,"orange.png");
                    LtLog.e("************"+result.sim);
                    if(result.sim>0.8f){
                        if(result2.sim>0.8f) {
                            mFairy.onTap(0.8f, result, 492,439,519,464, "取消", 3000);
                        }
                        result = mFairy.findPic("recoverys1.png");
                        mFairy.onTap(0.8f, result, "回收", 3000);
                        count++;
                    }
                    if(result.sim<0.8f){
                        if(result2.sim>0.8f){
                            mFairy.onTap(0.8f, result2,492,439,519,464, "取消", 3000);
                        }
                        mFairy.onTap(495,396,520,420, "橙色装备选择", 3000);
                        result = mFairy.findPic("recoverys1.png");
                        mFairy.onTap(0.8f, result, "回收", 3000);
                        count++;
                    }
                }
                LtLog.e("***********"+count);
                result = mFairy.findPic("reds4.png");
                if(count>=1||result.sim<0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "清包橙");
    }
    /**
     *
     * 转职
     * @throws Exception
     */
    public void Transfer() throws Exception {
        new OtherGame(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                init();
                result = mFairy.findPic("skills4.png");
                if(result.sim>0.8f){
                    setTaskName(2);
                }else{
                    result = mFairy.findPic("opens1.png");
                    mFairy.onTap(0.8f, result, "打开", 1000);
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("skills4.png");
                mFairy.onTap(0.8f, result, "技能", 1000);
                result = mFairy.findPic("occupations1.png");
                mFairy.onTap(0.8f, result, "职业", 1000);
                result = mFairy.findPic(741,386,1039,519,"Transfers2.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,304,544,356,587, "职业1", 2000);
                }
                result = mFairy.findPic("Transfers3.png");
                mFairy.onTap(0.8f, result, "转职", 1000);
                result = mFairy.findPic("Transfers4.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,792,388,854,414, "确认", 1000);
                    result = mFairy.findPic("closess2.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f, result, "关闭", 1000);
                        result = mFairy.findPic(741,386,1039,519,"Transfers2.png");
                        if(result.sim<0.8f){
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result = mFairy.findPic(236,425,454,498,"Transfers1.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,828,538,903,587, "职业2", 2000);
                }
                result = mFairy.findPic("Transfers3.png");
                mFairy.onTap(0.8f, result, "转职", 1000);
                result = mFairy.findPic("Transfers4.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,792,388,854,414, "确认", 1000);
                    result = mFairy.findPic("closess2.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f, result, "关闭", 1000);
                        result = mFairy.findPic(741,386,1039,519,"Transfers1.png");
                        if(result.sim<0.8f){
                            setTaskEnd();
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy,"转职");
    }

    /**
     *
     * 奖励领取
     * @throws Exception
     */
    public void reward() throws Exception {
        new OtherGame(mFairy) {
            @Override
            public void content_0() throws Exception {
                init();
                result = mFairy.findPic("activitys1.png");
                if(result.sim>0.8f){
                    setTaskName(1);
                    return;
                }
            }

            @Override
            public void content_1() throws Exception {
                result2 = mFairy.findPic(412,3,1115,158,"fuli.png");
                mFairy.onTap(0.7f, result2, "福利", 2000);
                result2 = mFairy.findPic(412,3,1115,158,"fulis1.png");
                mFairy.onTap(0.7f, result2, "福利", 2000);
                if(result2.sim>0.8f){
                    err=0;
                }
                result = mFairy.findPic("Signs2.png");
                if(result.sim>0.9f){
                    err=0;
                    mFairy.onTap(0.8f, result, "每日签到", 3000);
                }else{

                }
                result = mFairy.findPic(167,67,1200,686,"rewards1.png");//618,146  639,124,679,156
                LtLog.e("*************"+result.sim);
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, result.x+31, result.y+30 , result.x +71, result.y+100,"签到领取", 2000);
                    result = mFairy.findPic(1086,110,1206,539,"guang.png");
                    mFairy.onTap(0.8f, result, "领取", 2000);
                    LtLog.e("/*******/"+(result.x+31)+","+(result.y+30)+","+(result.x+71)+","+(result.y+100));
                }else{
                    mFairy.taskSlid(err, new int[]{2,4,6}, 0, 583,429,581,130,  2000, 1500);
                }
                if (overtime(10, 2)) return;//计次并跳转
            }

            @Override
            public void content_2() throws Exception {

                result = mFairy.findPic(29,72,158,596,"on-line.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "在线奖励", 2000);
                }else{

                }
                result1 = mFairy.findPic(new String[]{"lucks2.png","lucks1.png"});
                mFairy.onTap(0.8f, result1, "立即抽奖", 1000);
                result = mFairy.findPic(new String[]{"lings1.png","ends3.png"});
                if(result1.sim<0.8f){
                    setTaskName(3);
                }
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic(29,72,158,596,"seven.png");
                if(result1.sim>0.8f){
                    mFairy.onTap(0.8f, result1, "七日礼包", 2000);
                }else{

                }
                result = mFairy.findPic("receives5.png");
                mFairy.onTap(0.8f, result, "立即领取", 2000);
                if(result1.sim<0.8f){
                    setTaskName(4);
                }
                if(result.sim<0.8f){
                    setTaskName(4);
                }
            }

            @Override
            public void content_4() throws Exception {
                result = mFairy.findPic(29,72,158,596,"days2.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "每日礼包", 2000);
                }else{

                }

                result2 = mFairy.findPic("green.png");
                if(result2.sim>0.9f){
                    mFairy.onTap(0.8f, result2, "免费领取", 2000);
                }
                result = mFairy.findPic("renyi.png");
                mFairy.onTap(0.8f, result, "空白点击", 2000);
                result = mFairy.findPic("yi.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,799,213,841,241, "空白点击", 2000);
                }
                result = mFairy.findPic("mings1.png");
                result1 = mFairy.findPic("huodong.png");
                if(result.sim>0.9f||result1.sim<0.8f){
                    setTaskEnd();
                    return;
                }
//                        if(result2.sim<0.8f){
//
//                        }
            }
        }.taskContent(mFairy, "奖励领取");
    }
    /**
     *
     * 神魔战令
     * @throws Exception
     */
    public void Ghost() throws Exception {
        new OtherGame(mFairy) {
            @Override
            public void content_0() throws Exception {
                init();
                result = mFairy.findPic("activitys1.png");
                if(result.sim>0.8f){
                    setTaskName(1);
                    return;
                }
            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic("rights1.png");
                LtLog.e("----------------"+result.sim);
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "扩张", 2000);
                }else{
                    result3 = mFairy.findPic(412,3,1115,158,"Ghost.png");
                    if(result3.sim>0.8f){
                        err=0;
                        mFairy.onTap(0.8f, result3, "神魔战令", 2000);
                        result1 = mFairy.findPic(308,229,943,628,"receives2.png");
                        if(result1.sim>0.8f){
                            err=0;
                            mFairy.onTap(0.8f, result1, "可领取", 2000);

                        }

                    }
                    result = mFairy.findPic(36,31,211,89,"zhan.png");
                    if(result.sim>0.8f) {
                        err=0;
                        result1 = mFairy.findPic(308,229,943,628,"receives2.png");
                        if(result1.sim>0.8f){
                            result1 = mFairy.findPic(308,229,943,628,"receives2.png");
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f, result1, "可领取", 2000);
                            }
                        }else{
                            mFairy.taskSlid(err, new int[]{2, 4, 6}, 0, 357,406,650,406,  2000, 1500);
                        }
                    }
                    result = mFairy.findPic("whites1.png");
                    mFairy.onTap(0.8f, result, "关闭", 2000);
                    LtLog.e("+++++++++++"+count);
                    if(result1.sim<0.8f){
                        setTaskEnd();
                        return;
                    }
                }

                overtime(12, 2);
                return;
            }

            @Override
            public void content_2() throws Exception {
                setTaskEnd();
                return;
            }
        }.taskContent(mFairy, "神魔战令");
    }
    /**
     *
     * 限时领取
     * @throws Exception
     */
    public void celebration() throws Exception {
        new OtherGame(mFairy) {
            @Override
            public void content_0() throws Exception {
                init();
                result = mFairy.findPic("activitys1.png");
                if(result.sim>0.8f){
                    setTaskName(1);
                    return;
                }
            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic("rights1.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "扩张", 2000);
                }else{
                    result = mFairy.findPic(412,3,1115,158,"celebration.png");
                    if(result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, "庆典", 2000);
                        result = mFairy.findPic(1047,262,1253,449,"receives3.png");
                        mFairy.onTap(0.8f, result, "领取", 2000);
                        result = mFairy.findPic("whites2.png");
                        mFairy.onTap(0.8f, result, "关闭", 2000);
                        result1 = mFairy.findPic("lucks2.png");
                        mFairy.onTap(0.8f, result1, "抽奖", 2000);
                    }else{
                        setTaskName(2);
                    }
                }
//                result = mFairy.findPic("zeross1.png");
//                if (result1.sim<0.8f&&result.sim>0.8f){
//                     setTaskName(2);
//                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("offss1.png");
                mFairy.onTap(0.8f, result, "关闭", 2000);
                result = mFairy.findPic("rights1.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "扩张", 2000);
                }else{
                    result = mFairy.findPic(412,3,1115,158,"carnival.png");
                    if(result.sim>0.8f) {
                        mFairy.onTap(0.8f, result, "狂欢", 2000);
                        result1= mFairy.findPic(729,315,900,594,"receives4.png");
                        mFairy.onTap(0.8f, result1, "领取", 2000);
                    }else{
                        setTaskEnd();
                        return;
                    }
                }
                if (result1.sim<0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "限时领取");
    }
    public void init() throws Exception {
        result = mFairy.findPic("zidong.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,737,614,749,621, "自动攻击关闭", 2000);
        }
        result = mFairy.findPic(new String[]{"close66.png","closes6.png","closes7.png","closes8.png","YinglinHall_close.png","Secret_close.png","offs3.png","yous2.png"});
        mFairy.onTap(0.8f, result,"活动关闭右", 1000);
        result = mFairy.findPic("into.png");
        if(result.sim>0.8f){

        }else{
            result = mFairy.findPic(new String[]{"lefts1.png"});
            mFairy.onTap(0.8f, result,"活动关闭左", 1000);
        }

        result = mFairy.findPic("change.png");
        mFairy.onTap(0.8f, result,1160,38,1181,62,"关闭", 2000);
        result = mFairy.findPic("ok000.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result, 633,444,678,466,"确定", 1000);
        }
    }
}
