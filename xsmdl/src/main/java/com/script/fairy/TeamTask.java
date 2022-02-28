package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends TaskContent{
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    GameUtil gameUtil;
    List<String> list = new ArrayList<>();
    OtherGame otherGame;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    SingleTask singleTask;
    int chief;
    int n_err =0;
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        otherGame=new OtherGame(mFairy);
         singleTask = new SingleTask(mFairy);
    }

    /**
     * 组队 暴风裂隙(组队)
     * @throws Exception
     */
    public void Storm() throws Exception {
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String Storms="Storms1.png";
                int mission = gameUtil.mission(Storms, 0);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic(80,398,310,662,"Violent.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "暴风裂隙", 2000);
                    result = mFairy.findPic(new String[]{"starts3.png","matchings1.png"});
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f, result, "匹配队伍", 2000);
                    }
                }

                result = mFairy.findPic("Baotuwei.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,787,393,866,416, "匹配队伍", 2000);
                }

                result = mFairy.findPic("spot.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "点击跳过", 2000);
                }
                result = mFairy.findPic("end.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result,630,443,675,474, "确认", 2000);
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("mind.png");
                if(result.sim<0.8f){
                    result = mFairy.findPic( "leaves2.png");
                    result2 = mFairy.findPic( 508,493,788,596,"follows1.png");
                    result3 = mFairy.findPic( "zidongss2.png");
                    LtLog.e("***********************跟随战斗"+result2.sim+"---------离开"+result.sim+"------------自动战斗"+result3.sim);
                    if (result2.sim<0.8f&&result.sim<0.8f&&result3.sim<0.8f) {
                        long time = mFairy.mMatTime(1154,48,88,60, 0.95f);
                        LtLog.e("***************" + time);
                        if (time > 5) {
                            setTaskName(1);
                        }
                    }
                }
            }
        }.taskContent(mFairy,"暴风裂隙");
    }
    /**
     * 组队  狮心荣耀(单人)
     * @throws Exception
     */
    public void Lion2() throws Exception {
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String werewolf="Lion.png";
                int mission = gameUtil.mission(werewolf, 0);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("current.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result,1175,45,1193,62, "关闭", 2000);
                    return;
                }

                result = mFairy.findPic("heart.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "狮心荣耀", 2000);
                    result = mFairy.findPic("skips2.png");
                    mFairy.onTap(0.8f, result, "跳过", 2000);
                    result = mFairy.findPic("battle.png");
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                    result = mFairy.findPic("continues2.png");
                    mFairy.onTap(0.8f, result, "继续挑战", 2000);
                    result = mFairy.findPic(451,212,869,265,"wei.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f, result, 779,394,854,417,"继续挑战", 2000);
                    }
                }

            }
        }.taskContent(mFairy,"狮心荣耀");
    }
    /**
     * 组队  狮心荣耀(组队多人)
     * @throws Exception
     */
    public void Lion() throws Exception {
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                init();
                result = mFairy.findPic("zu.png");
                mFairy.onTap(0.8f, result, "组队", 1000);
                result = mFairy.findPic("establish.png");
                if(result.sim>0.8f){
                    result = mFairy.findPic("offs2.png");
                    mFairy.onTap(0.8f, result, "关闭", 2000);
                    result = mFairy.findPic("activitys1.png");
                    if(result.sim>0.8f){
                        setTaskName(1);
                        return;
                    }
                }
                result = mFairy.findPic("exits1.png");
                mFairy.onTap(0.8f, result, "退出队伍", 2000);
                result = mFairy.findPic("querens3.png");
                mFairy.onTap(0.8f, result, "确定", 2000);
            }

            @Override
            public void content_1() throws Exception {
                String werewolf="Lion.png";
                int mission = gameUtil.mission(werewolf, 0);
                if(mission==1){
                setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("current.png");
                if (result.sim > 0.8f) {

                    mFairy.onTap(0.8f, result, 1175, 45, 1193, 62, "关闭", 2000);
                    return;
                }

                result = mFairy.findPic("heart.png");
                if (result.sim > 0.8f) {
                    err=0;
                    mFairy.onTap(0.8f, result, "狮心荣耀", 2000);
                    result = mFairy.findPic("skips2.png");
                    mFairy.onTap(0.8f, result, "跳过", 2000);
                    result = mFairy.findPic("agrees1.png");
                    mFairy.onTap(0.8f, result, "同意", 2000);
                    result = mFairy.findPic("teams2.png");
                    mFairy.onTap(0.8f, result, "组队", 2000);
                    result = mFairy.findPic("create.png");
                    mFairy.onTap(0.8f, result, "创建队伍", 2000);
                    result = mFairy.findPic("talks1.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, "喊话", 15000);
                        result = mFairy.findPic("matching.png");
                        mFairy.onTap(0.8f, result, "开始匹配", 2000);
                    }
                }
//                result = mFairy.findPic("matching2.png");
                result1 = mFairy.findPic("matching3.png");
//                result2 = mFairy.findPic("matching4.png");
//                result3 = mFairy.findPic("matching5.png");
                if (result1.sim < 0.8f) {
                    err=0;
                    result = mFairy.findPic("zus1.png");
                    if (result.sim > 0.8f) {
                        mFairy.onTap(0.8f, result, 1168, 42, 1194, 64, "关闭", 2000);
                    }
                }
                result = mFairy.findPic("battle.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "挑战", 2000);
                }

                result = mFairy.findPic("threes4.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 597, 667, 696, 684, "空白关闭", 2000);
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic(1128, 4, 1250, 43, "skips4.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);
                result = mFairy.findPic("nums1.png");
                if (result.sim > 0.8f) {

                    mFairy.onTap(0.8f, result, 470, 395, 524, 423, "取消", 2000);
                }
                result = mFairy.findPic("fulls1.png");
                if (result.sim > 0.8f) {

                    mFairy.onTap(0.8f, result, 798, 392, 821, 422, "确认", 2000);
                }
                result = mFairy.findPic("zhaohuan.png");
                mFairy.onTap(0.8f, result, "召唤跟随", 2000);
                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    err=0;
                    LtLog.e("入口复活"+result.sim);
                    mFairy.onTap(0.8f, result, "入口复活", 2000);
                }


                result1 = mFairy.findPic("zus1.png");
                if(result1.sim<0.8f){
                    result = mFairy.findPic( "leaves2.png");
                    result2 = mFairy.findPic( "zidongs6.png");
                    LtLog.e("***********************自动战斗"+result2.sim+"---------离开"+result.sim);

                    if (result2.sim<0.8f&&result.sim<0.8f) {
                        long time = mFairy.mMatTime(1154,48,88,60, 0.95f);
                        LtLog.e("***************" + time);
                        if (time > 12) {

                            setTaskName(1);
                        }
                    }
                }
            }

        }.taskContent(mFairy,"狮心荣耀");
    }
    /**
     * 组队 一见衷心(组队)
     * @throws Exception
     */
    public void Heartfelt() throws Exception {
        new TeamTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                gameUtil.init();
                LtLog.e("一见衷心(组队)");
            }
        }.taskContent(mFairy,"一见衷心");
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
    /**
     * 限时 狼人入侵
     * 狼人入侵
     * @throws Exception
     */
    public void intrusion2() throws Exception {
        new TimingActivity(mFairy){
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
                result = mFairy.findPic("zu.png");
                mFairy.onTap(0.8f, result, "组队", 1000);
                result = mFairy.findPic("establish.png");
                    mFairy.onTap(0.8f, result, "创建队伍", 1000);
                    result = mFairy.findPic(544,54,773,102,"targets2.png");
                    if(result.sim>0.8f){
                        chief++;
                        if(chief<2){
                            LtLog.e("**********"+result.sim);
                            mFairy.onTap(0.8f, result, "目标", 1000);
                        }
                    }else {
                        chief=0;
                    }
                    LtLog.e("************"+chief);
                result = mFairy.findPic(349,194,517,545,"wolf.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "狼人入侵", 2000);
                    result = mFairy.findPic("oks7.png");
                    mFairy.onTap(0.8f, result, "确认", 3000);
                }else{
                    result = mFairy.findPic("days1.png");
                    mFairy.onTap(0.8f, result, "日常", 3000);
                }
                result = mFairy.findPic("talks1.png");
                mFairy.onTap(0.8f, result, "喊话", 28000);
                result = mFairy.findPic(325,271,510,392,"matching2.png");
                if(result.sim<0.8f){
                    result = mFairy.findPic("follow.png");
                        mFairy.onTap(0.8f, result, "跟随", 3000);
                        result = mFairy.findPic("offs2.png");
                        mFairy.onTap(0.8f, result, "关闭", 2000);
                        result = mFairy.findPic("activitys1.png");
                        if(result.sim>0.8f){
                            setTaskName(2);
                            return;
                        }
                    }

            }

            @Override
            public void content_2() throws Exception {
                String werewolf="werewolf.png";
                int mission = gameUtil.mission(werewolf, 1);
                if(mission==1){
                    setTaskName(3);
                }else{
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result1 = mFairy.findPic(309,154,939,484,"elite.png");
                if(result1.sim>0.8f){
                    err=0;
                    result = mFairy.findPic(result1.x + 420, result1.y -17, result1.x +549, result1.y +41, "gos3.png");//384,284  804,267,933,325
                    LtLog.e("*//*******//*" + (result1.x + 420) + "," + (result1.y - 17) + "," + (result1.x + 549) + "," + (result1.y +41));
                    long time = mFairy.mMatTime(1154,48,88,60, 0.95f);
                    LtLog.e("***************" + time);
                    if (time > 3) {
                        n_err=0;
                        mFairy.onTap(0.8f, result, "前往", 5000);
                    }else {
                        n_err++;
                        if(n_err>10){
                            n_err=0;
                            mFairy.onTap(0.8f, result, "前往", 5000);
                        }
                    }
                }
                result1 = mFairy.findPic("blame.png");
                LtLog.e("******************点击"+result1.sim);
                if(result1.sim>0.9f&&result.sim<0.8f){
                    mFairy.onTap(0.8f, result1,605,281,668,331, "点击", 5000);
                    result = mFairy.findPic(27,97,178,170,"jikui.png");//Insufficients3
                    result3 = mFairy.findPic("ones2.png");//Insufficients3
                    LtLog.e("***************"+result.sim+"-------------"+result3.sim);
                    if(result.sim>0.3f&&result3.sim>0.8f){
                        setTaskName(1);
                    }
                }

                result = mFairy.findPic("rukou.png");
                if(result.sim>0.8f){
                    err=0;
                    mFairy.onTap(0.8f, result, "入口复活", 4000);
                }


                result = mFairy.findPic("congratulations.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"狼人入侵");
    }
}
