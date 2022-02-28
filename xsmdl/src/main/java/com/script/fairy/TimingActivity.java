package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class TimingActivity extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;
    boolean scn=true;
    int n_err =0;
    public TimingActivity(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
    }
    SingleTask singleTask = new SingleTask(mFairy);
    /**
     * 限时
     * 炼金初试(单人)
     * @throws Exception
     */
    public void smelting() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {

                String Alchemy="Alchemy.png";
                int mission = gameUtil.mission(Alchemy, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("炼金初试(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("A.png");

                mFairy.onTap(0.8f, result, "选择", 1000);
                result = mFairy.findPic("ten.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"炼金初试");
    }

    /**
     * 限时
     * 守护要塞
     * @throws Exception
     */
    public void fortress() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String werewolf="guard.png";
                int mission = gameUtil.mission(werewolf, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("守护要塞(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("rukou.png");
                mFairy.onTap(0.8f, result, "入口复活", 4000);
                result2 = mFairy.findPic( "zidongs6.png");
                if(result2.sim<0.8f){
                    result = mFairy.findPic("xun.png");
                    mFairy.onTap(0.8f, result, "寻找盗贼", 4000);
                }
                result = mFairy.findPic("xun.png");
                if(result.sim<0.8f){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Zeros5.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"守护要塞");
    }
    /**
     * 限时
     * 狼人入侵
     * @throws Exception
     */
    public void intrusion() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String werewolf="werewolf.png";
                int mission = gameUtil.mission(werewolf, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("狼人入侵(单人)");
            }

            @Override
            public void content_2() throws Exception {


//                result = mFairy.findPic("gos1.png");
//                mFairy.onTap(0.8f, result, "前往", 1000);
                result1 = mFairy.findPic(309,154,939,484,"xin.png");
                if(result1.sim>0.8f){
                    result = mFairy.findPic(result1.x + 420, result1.y -17, result1.x +549, result1.y +41, "gos1.png");//384,284  804,267,933,325
                    LtLog.e("*//*******//*" + (result1.x + 420) + "," + (result1.y - 17) + "," + (result1.x + 549) + "," + (result1.y +41));
                    long time = mFairy.mMatTime(1154,48,88,60, 0.95f);
                    LtLog.e("***************" + time);
                    if (time > 3) {
                        n_err=0;
                        mFairy.onTap(0.8f, result, "前往", 3000);
                    }else {
                        n_err++;
                        if(n_err>10){
                            n_err=0;
                            mFairy.onTap(0.8f, result, "前往", 3000);
                        }
                    }
                }
                result = mFairy.findPic("congratulations.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"狼人入侵");
    }
    /**
     * 限时
     * 怪物攻城
     * @throws Exception
     */
    public void monster() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String monster="monster.png";
                int mission = gameUtil.mission(monster, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("怪物攻城(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("prevent.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f, result, "阻止", 1000);
                    result = mFairy.findPic("attacks1.png");
                    mFairy.onTap(0.8f, result, "自动攻击", 1000);
                }
            }
        }.taskContent(mFairy,"怪物攻城");
    }
    /**
     * 限时
     * 猩红之猎 做不了
     * @throws Exception
     */
    public void hunting() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String monster="Scarlet.png";
                int mission = gameUtil.mission(monster, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("猩红之猎(单人)");
            }

            @Override
            public void content_2() throws Exception {

            }
        }.taskContent(mFairy,"猩红之猎");
    }
    /**
     * 限时
     * 世界首领
     * @throws Exception
     */
    public void chief() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String world="world.png";   //tiaos6.png;  leave.png 离开并且结束
                int mission = gameUtil.mission(world, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("世界首领(单人)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("tiaos6.png");
                mFairy.onTap(0.8f, result, "挑战", 1000);
                result = mFairy.findPic("leave.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"世界首领");
    }
    /**
     * 限时
     * 篝火晚宴  做不了
     * @throws Exception
     */
    public void Dinner() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                gameUtil.init();
                LtLog.e("篝火晚宴(单人)");
            }
        }.taskContent(mFairy,"篝火晚宴");
    }
    /**
     * 限时
     * 正式工会战(第三轮)
     * @throws Exception
     */
    public void warThree() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String werewolf="warThree.png";
                int mission = gameUtil.mission(werewolf, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"正式工会战(第三轮)");
    }
    /**
     * 限时
     * 正式工会战(第四轮)
     * @throws Exception
     */
    public void warFour() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String werewolf="warFour.png";
                int mission = gameUtil.mission(werewolf, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("正式工会战(第四轮)(单人)");
            }
        }.taskContent(mFairy,"正式工会战(第四轮)");
    }
    /**
     * 限时
     * 永夜战场
     * @throws Exception
     */
    public void Eternal() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                String monster="night.png";
                int mission = gameUtil.mission(monster, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("永夜战场(限时)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("know.png");
                mFairy.onTap(0.8f, result, "知道了", 2000);
            }
        }.taskContent(mFairy,"永夜战场");
    }
    /**
     * 限时
     * 冰风谷战场
     * @throws Exception
     */
    public void Valley() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               String Ice="Ice.png"; //know.png 知道了  caiji.png  自动攻击  sign.png 报名
                int mission = gameUtil.mission(Ice, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("冰风谷战场(限时)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("know.png");
                mFairy.onTap(0.8f, result, "知道了", 2000);
                result = mFairy.findPic("caiji.png");
                mFairy.onTap(0.8f, result, "自动攻击", 2000);
                result = mFairy.findPic("Sign.png");
                mFairy.onTap(0.8f, result, "报名", 2000);
            }
        }.taskContent(mFairy,"冰风谷战场");
    }
//    /**
//     * 限时
//     * 地宫寻宝
//     * @throws Exception
//     */
//    public void Treasure() throws Exception {
//        new TimingActivity(mFairy){
//            @Override
//            public void content_0() throws Exception {
//                setTaskName(1);
//            }
//
//            @Override
//            public void content_1() throws Exception {
//               gameUtil.init();
//                LtLog.e("地宫寻宝(限时)");
//            }
//        }.taskContent(mFairy,"地宫寻宝");
//    }
    /**
     * 限时
     * 炼金复试
     * @throws Exception
     */
    public void Retest() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("炼金复试(限时)");
            }
        }.taskContent(mFairy,"炼金复试");
    }
    /**
     * 限时
     * 炼金终试
     * @throws Exception
     */
    public void Final() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("炼金终试(限时)");
            }
        }.taskContent(mFairy,"炼金终试");
    }
    /**
     * 限时
     * 神庙迷宫
     * @throws Exception
     */
    public void maze() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("神庙迷宫(限时)");
            }
        }.taskContent(mFairy,"神庙迷宫");
    }
    /**
     * 限时
     * 神赐盛宴
     * @throws Exception
     */
    public void feast() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               String gift="giftS.png";
                int mission = gameUtil.mission(gift, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("神赐盛宴(限时)");
            }
        }.taskContent(mFairy,"神赐盛宴");
    }
    /**
     * 限时
     * 公会竞速
     * @throws Exception
     */
    public void speed() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("公会竞速(限时)");
            }
        }.taskContent(mFairy,"公会竞速");
    }
    /**
     * 限时
     * 正式工会战(第一轮)
     * @throws Exception
     */
    public void warFirst() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("正式工会战(第一轮)(限时)");
            }
        }.taskContent(mFairy,"正式工会战(第一轮)");
    }
    /**
     * 限时
     * 正式工会战(第二轮)
     * @throws Exception
     */
    public void warTwo() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("正式工会战(第二轮)(限时)");
            }
        }.taskContent(mFairy,"正式工会战(第二轮)");
    }
    /**
     * 限时
     * 3对3实力为王
     * @throws Exception
     */
    public void king() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               String three="three.png";  //"knows3.png;"  Watch.png 观战 agree,png 同意
//                threes1.png  结束
                int mission = gameUtil.mission(three, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
                LtLog.e("3对3实力为王(限时)");
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("knows1.png");
                mFairy.onTap(0.8f, result, "知道了", 2000);
                result = mFairy.findPic("Watch.png");
                mFairy.onTap(0.8f, result, "观战", 2000);
                result = mFairy.findPic("agree.png");
                mFairy.onTap(0.8f, result, "同意", 2000);
                result = mFairy.findPic("threes1.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"3对3实力为王");
    }
    /**
     * 限时
     * 暴风幻境(公会)
     * @throws Exception
     */
    public void Dreamland() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("暴风幻境(公会)(限时)");
            }
        }.taskContent(mFairy,"暴风幻境(公会)");
    }
    /**
     * 限时
     * 跨服领地战
     * @throws Exception
     */
    public void territory() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("跨服领地战(限时)");
            }
        }.taskContent(mFairy,"跨服领地战");
    }
    /**
     * 限时
     * 盗宝哥布林(不限)
     * @throws Exception
     */
    public void Stealing() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                setTaskName(2);
                String fort="Stealing.png";
                int mission = gameUtil.mission(fort, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("gos2.png");
                mFairy.onTap(0.8f, result, "单人前往", 1000);
                result = mFairy.findPic("organize.png");
                mFairy.onTap(0.8f, result, "快捷组队", 1000);
                result = mFairy.findPic("starts1.png");
                mFairy.onTap(0.8f, result, "开始匹配", 1000);
            }
        }.taskContent(mFairy,"盗宝哥布林");
    }
    /**
     * 限时
     * 寒冰女王宝藏争夺战
     * @throws Exception
     */
    public void queen() throws Exception {
        new TimingActivity(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
               gameUtil.init();
                LtLog.e("寒冰女王宝藏争夺战(限时)");
            }
        }.taskContent(mFairy,"寒冰女王宝藏争夺战");
    }
    /**
     * 日常
     * 地宫寻宝
     * @throws Exception
     */
    public void underground() throws Exception {
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }
            @Override
            public void content_1() throws Exception {
                String fort="underground.png";
                int mission = gameUtil.mission(fort, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }
            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("get.png");
                mFairy.onTap(0.8f, result, "进入地宫寻宝", 1000);
                result = mFairy.findPic("wait.png");
                mFairy.onTap(0.8f, result, "等下", 1000);
                result = mFairy.findPic("Treasure.png");
                mFairy.onTap(0.8f, result,168,191,228,207, "寻宝", 1000);
                result = mFairy.findPic("skills1.png");
                mFairy.onTap(0.8f, result, "技能1", 1000);
                result = mFairy.findPic("skills2.png");
                mFairy.onTap(0.8f, result, "技能2", 1000);
                result = mFairy.findPic("collection.png");
                mFairy.onTap(0.8f, result, "采集", 1000);
                result = mFairy.findPic("resurrections1.png");
                mFairy.onTap(0.8f, result, "入口复活", 1000);
                result = mFairy.findPic("successs1.png");
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }

            }
        }.taskContent(mFairy,"地宫寻宝");
    }
    /**
     * 日常
     * 荣光之地
     * @throws Exception
     */
    public void Glory() throws Exception {
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
            }
            @Override
            public void content_1() throws Exception {
                String Glory="Glorys1.png";
                int mission = gameUtil.mission(Glory, 1);
                if(mission==1){
                    setTaskName(2);
                }else{
                    setTaskEnd();
                    return;
                }
            }
            @Override
            public void content_2() throws Exception {
                result = mFairy.findPic("get.png");
                mFairy.onTap(0.8f, result, "进入地宫寻宝", 1000);
                result = mFairy.findPic("wait.png");
                mFairy.onTap(0.8f, result, "等下", 1000);
                if(result.sim>0.8f){
                    setTaskEnd();
                    return;
                }

            }
        }.taskContent(mFairy,"荣光之地");
    }
}
