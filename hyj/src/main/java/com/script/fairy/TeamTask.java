package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class TeamTask extends TaskContent {
    AtFairyImpl mFairy;
    AtFairyImpl mFairy1;
    FindResult result;
    GameUtil gameUtil;

    OtherGame otherGame;

    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        yxdUtil = new YxdUtil(mFairy);
        otherGame = new OtherGame(mFairy);
    }


    /**
     * 游园惊梦
     */
    public void gardenDream()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Garden dream.png",0);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Garden dream2.png",0);
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                boolean ti =  timekeep(2,24000000,"副本计时");
                if (ti){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    timekeepInit("副本计时");
                    setTaskEnd();return;
                }

                result = mFairy.findPic(970,249,1229,582,"youyuan.png");
                mFairy.onTap(0.8f,result,"开启游园惊梦",Sleep);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }
                result = mFairy.findPic("li.png");
                mFairy.onTap(0.8f,result,"意外礼物",Sleep);

                if (dazeTime > 30 && result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }

                if(dazeTime >= 10) {
                    result = mFairy.findPic("team3.png");
                    mFairy.onTap(0.8f, result, 1176, 59, 1200, 90, "关闭队伍界面", 2000);
                }
                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",2000);

                result = mFairy.findPic("mlbx.png");
                mFairy.onTap(0.8f,result,1111,50,1133,77,"关闭",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
                result = mFairy.findPic("mlbx2.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Garden dream2.png",0);
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",2000);

                result = mFairy.findPic("mlbx.png");
                mFairy.onTap(0.8f,result,1111,50,1133,77,"关闭",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
                result = mFairy.findPic("mlbx2.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
            }
        }.taskContent(mFairy,"游园惊梦");
    }

    /**
     * 往事如烟
     */
    public void pastEvents()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Past events.png",0);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }

                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Past events2.png",0);
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                boolean ti =  timekeep(2,1800000,"副本计时");
                if (ti){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    timekeepInit("副本计时");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("dengji.png");
                if(result.sim > 0.8f){
                    LtLog.e("队伍有等级不符的人退出队伍");
                    mFairy.onTap(1176,61,1200,82, "关闭往事如烟", 2000);
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic(970,249,1229,582,"Past.png");

                mFairy.onTap(0.8f,result,"开启往事如烟",2000);

                result = mFairy.findPic("copy.png");
                mFairy.onTap(0.8f,result,"进入副本",Sleep);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }
                result = mFairy.findPic("li.png");
                mFairy.onTap(0.8f,result,"意外礼物",Sleep);

                if (dazeTime > 30 && result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
                if(dazeTime >= 10) {
                    result = mFairy.findPic("team3.png");
                    mFairy.onTap(0.8f, result, 1176, 59, 1200, 90, "关闭队伍界面", 3000);
                }
                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",2000);

                result = mFairy.findPic("mlbx.png");
                mFairy.onTap(0.8f,result,1111,50,1133,77,"关闭",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
                result = mFairy.findPic("mlbx2.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Past events2.png",0);
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskName(0);return;
                }

                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",2000);

                result = mFairy.findPic("mlbx.png");
                mFairy.onTap(0.8f,result,1111,50,1133,77,"关闭",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
                result = mFairy.findPic("mlbx2.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
            }
        }.taskContent(mFairy,"往事如烟");
    }

    /**
     *  守卫皇城
     */
    public void imperialCity()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Imperial City.png",0);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Imperial City3.png",0);
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Imperial City2.png");
                mFairy.onTap(0.8f,result,"开启守卫皇城",2000);


                result = mFairy.findPic("Explain2.png");
                mFairy.onTap(0.8f,result,1144,84,1153,95,"玩法说明关闭",Sleep);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }
//                result = mFairy.findPic("li.png");
//                mFairy.onTap(0.8f,result,"意外礼物",Sleep);

                if (dazeTime > 30 && result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
                if(dazeTime >= 10) {
                    result = mFairy.findPic("team3.png");
                    mFairy.onTap(0.8f, result, 1176, 59, 1200, 90, "关闭队伍界面", 2000);
                }
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Imperial City3.png",0);
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskName(0);return;
                }

                result = mFairy.findPic("Explain2.png");
                mFairy.onTap(0.8f,result,1144,84,1153,95,"玩法说明关闭",Sleep);
            }
        }.taskContent(mFairy,"守卫皇城");
    }

    /**
     * 四方辑盗
     */
    int line = 0 ;
    public void captureThieves()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("jidao.png",0);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }

            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("jidaoteam.png",0);
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (dazeTime >= 5 && result1.sim < 0.8f) {
                    result = mFairy.findPic("jian.png");
                    if (result.sim > 0.7f) {

                    } else {
                        int ret = gameUtil.mission("jidao.png", 0);
                        if (ret == 1) {
                            LtLog.e("任务还没做");
                        } else {
                            LtLog.e("任务做完了");
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }else {
                    if (line == 0) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 721, 394, 740, 404, "点击地图1", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 2) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 623, 523, 633, 538, "点击地图9", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 15000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 3) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 611, 467, 618, 477, "点击地图3", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 4) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 625, 462, 636, 472, "点击地图4", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 5) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 633, 518, 639, 527, "点击地图5", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 6) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 629, 497, 639, 509, "点击地图6", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 7) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 580, 479, 595, 489, "点击地图7", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 8) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 624, 487, 635, 495, "点击地图8", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (line == 1) {
                        result = mFairy.findPic("activity.png");
                        mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                        mFairy.onTap(0.8f, result, 630,355,638,364, "点击地图2", 2000);
                        mFairy.onTap(0.8f, result, 1225, 48, 1252, 72, "关闭", 10000);
                        mFairy.onTap(683,377,694,391, "默认盗宝贼在眼前", 2000);
                        mFairy.onTap(604, 374, 618, 390, "默认盗宝贼在眼前", 2000);
                    } else if (dazeTime >= 60) {
                        mFairy.initMatTime();

                    }
                    setTaskName(6);return;
                }
//                result = mFairy.findPic(0,0,1280,720,new String[]{"Pirate.png","daobao.png"});
//                mFairy.onTap(0.7f,result,result.x-10,result.y+136,result.x-9,result.y+137,"盗宝贼",Sleep);

            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("jidaogd.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.7f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",2000);

                result = mFairy.findPic("mlbx.png");
                mFairy.onTap(0.8f,result,1111,50,1133,77,"关闭",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                }
                result = mFairy.findPic("mlbx2.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                }
            }
            public void content_6()throws Exception {
                if (overtime(10, 3)) return;
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    err = 0;
                    mFairy.onTap(1155,579,1176,597, "点一下攻击", 2000);
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }
                result = mFairy.findPic(418,194,762,485,"dbzblack.png");
                mFairy.onTap(0.8f,result,"盗宝贼",2000);

                result = mFairy.findPic("Piratepeople.png");
                mFairy.onTap(0.8f,result,"盗宝贼2",2000);
                if (result.sim < 0.8f && line < 10 && err ==1){
                    LtLog.e("line=========================加一了");
                    line++;
                }
                if (line >=10){
                    line =0;
                }
                result = mFairy.findPic("go for it.png");
                mFairy.onTap(0.8f,result,"盘他",Sleep);

                result = mFairy.findPic("Piratenopeople.png");
                if (result.sim > 0.75f){
                    setTaskName(2);
                    return;
                }

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",2000);

                result = mFairy.findPic("mlbx.png");
                mFairy.onTap(0.8f,result,1111,50,1133,77,"关闭",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }
                result = mFairy.findPic("mlbx2.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                }

            }
        }.taskContent(mFairy,"四方辑盗");
    }

    /**
     *  赏金护卫
     */
    int go = 0;
     public void moneyReward()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Money reward.png",0);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Money reward2.png",0);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
               // boolean js =  timekeep(2,30000,"计时 ");
                result = mFairy.findPic("Money reward3.png");
                mFairy.onTap(0.8f,result,"开始赏金护卫",2000);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime >= 25){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
                    result = mFairy.findPic(539,365,786,565,"Rich man.png");
                    mFairy.onTap(0.75f,result,"财主位置",2000);
                    mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
                    mFairy.initMatTime();
                }

//
//                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
//                if (result1.sim > 0.8f){
//                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
//                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
//
//                    boolean first =  timekeep(2,10000,"第一个点");
//                    boolean first2 =  timekeep(3,40000,"第二个点");
//                    boolean first3 =  timekeep(4,70000,"第三个点");
//                    boolean first4 =  timekeep(5,100000,"第四个点");
//                    boolean first5 =  timekeep(6,120000,"第五个点");
//                    if (first && go == 0){
//                        result = mFairy.findPic("activity.png");
//                        mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
//                        mFairy.onTap(0.8f,result,733,391,742,402,"第一个位置",2000);
//                        mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
//                        go = 1 ;
//                    }else if (first2 && go ==1){
//                        result = mFairy.findPic("activity.png");
//                        mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
//                        mFairy.onTap(0.8f,result,686,420,696,430,"第二个位置",2000);
//                        mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
//                       go = 2 ;
//                    }else if (first3 && go == 3){
//                        result = mFairy.findPic("activity.png");
//                        mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
//                        mFairy.onTap(0.8f,result,635,460,646,468,"第三个位置",2000);
//                        mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
//                       go = 4 ;
//                    }else if (first4 && go == 4){
//                        result = mFairy.findPic("activity.png");
//                        mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
//                        mFairy.onTap(0.8f,result,671,495,682,506,"第四个位置",2000);
//                        mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
//                        go =5 ;
//                    }else if (first5 && go == 5){
//                        result = mFairy.findPic("activity.png");
//                        mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
//                        mFairy.onTap(0.8f,result,733,547,742,553,"第五个位置",2000);
//                        mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
//                        go  = 6 ;
//                    }
//                }else {
//                    timekeepInit("第一个点");
//                    timekeepInit("第二个点");
//                    timekeepInit("第三个点");
//                    timekeepInit("第四个点");
//                    timekeepInit("第五个点");
//                    go = 0;
//                }

                if (dazeTime > 20 && result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
                if(dazeTime >= 10) {
                    result = mFairy.findPic("team3.png");
                    mFairy.onTap(0.8f, result, 1176, 59, 1200, 90, "关闭队伍界面", 2000);
                }
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Money reward2.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"赏金护卫");
    }

    /**
     * 刑司密卷
     */

    public void  secretVolume()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Secret volume.png",2);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Secret volume2.png",2);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Arrest.png");
                mFairy.onTap(0.8f,result,"前往缉拿",2000);

                boolean time1 =  timekeep(2,780000,"刑司密卷");

                result = mFairy.findPic("Open challenge.png");
                mFairy.onTap(0.8f,result,"开启挑战",2000);

                result = mFairy.findPic(332,130,994,246,"qianzhi.png");
                if (result.sim > 0.7f){
                    LtLog.e("有人没做前置退出队伍");
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    setTaskName(0);return;
                }


                result = mFairy.findPic("mjrs.png");
               if (result.sim > 0.7f){
                   LtLog.e("人数不够");
                   setTaskName(0);return;
               }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }
                if (time1){
                    LtLog.e("副本时间超时结束任务");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",2000);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Secret volume2.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"刑司密卷");
    }

    /**
     *以武会友
     */
    public void  withHuiyou()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    setTaskName(3);return;
                }
                //寻找任务并且前往
                int ret =gameUtil.seek("WithHuiyou.png",2);
                if (ret==1){
                      LtLog.e("任务还没做");

                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("WithHuiyoupt.png",2);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("WithHuiyoubagin.png");
                mFairy.onTap(0.8f,result,"进行试炼",2000);


                result = mFairy.findPic("Challenge hy.png");
                mFairy.onTap(0.8f,result,"开始挑战",2000);

                result = mFairy.findPic(471,19,763,240,"hyxuanguan.png");
                mFairy.onTap(0.7f,result,"选关",2000);

                result = mFairy.findPic("First pass.png");
                mFairy.onTap(0.7f,result,"第一关",2000);

                mFairy.onTap(1155,579,1176,597, "点一下攻击", 2000);

                result = mFairy.findPic("fail.png");
                if (result.sim > 0.8f){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("fight again.png");
                    mFairy.onTap(0.8f,result,"奋起再战",Sleep);
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic("mpsl num.png");
                if (result.sim > 0.7f){
                    LtLog.e("人数不够");

                    setTaskName(0);return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",2000);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("WithHuiyoupt.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"以武会友");
    }
    /**
     * 御前校武  ong
     */
    public void   imperialSchool()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Imperial school.png",2);
                if (ret==1){
                    LtLog.e("任务还没做");
                    setTaskName(2);return;
//                    if (AtFairyConfig.getOption("ld").equals("1")){
//                        setTaskName(2);return;
//                    }
//                    if (AtFairyConfig.getOption("gd").equals("1")){
//                        setTaskName(4);return;
//                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Imperial school team.png",2);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Imperial school begain.png");
                mFairy.onTap(0.8f,result,"前往御前校武",2000);

                result = mFairy.findPic("Imperial school challenge.png");
                mFairy.onTap(0.8f,result,"开始挑战",2000);

                result = mFairy.findPic("First pass.png");
                mFairy.onTap(0.7f,result,"第一关",2000);

                result = mFairy.findPic("tiaozhanta.png");
                mFairy.onTap(0.7f,result,"挑战他",2000);

                result = mFairy.findPic("fail.png");
                if (result.sim > 0.8f){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskEnd();return;
                }

                result = mFairy.findPic("mpsl num.png");
                if (result.sim > 0.7f){
                    LtLog.e("人数不够");

                    setTaskName(0);return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Imperial school team.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"御前校武");
    }

    /**
     * 大雁塔  ong
     */
    public void  bigWild()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("WithHuiyou.png",2);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Big Wild team.png",2);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Big Wild begain.png");
                mFairy.onTap(0.8f,result,"前去大雁塔",2000);

                result = mFairy.findPic("Big Wild challenge.png");
                mFairy.onTap(0.8f,result,"开始挑战",2000);

                result = mFairy.findPic(471,19,763,240,"hyxuanguan.png");
                mFairy.onTap(0.7f,result,"选关",2000);

                result = mFairy.findPic("First pass.png");
                mFairy.onTap(0.7f,result,"第一关",2000);

                result = mFairy.findPic("fail.png");
                if (result.sim > 0.8f){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskEnd();return;
                }

                result = mFairy.findPic("mpsl num.png");
                if (result.sim > 0.7f){
                    LtLog.e("人数不够");

                    setTaskName(0);return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Big Wild team.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"大雁塔");
    }
    /**
     * 隐龙迷踪 Hidden Dragon
     */
    public void  hiddenDragon()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Hidden Dragon.png",2);
                if (ret==1){
                    LtLog.e("任务还没做");
                    setTaskName(2);return;
//                    if (AtFairyConfig.getOption("ld").equals("1")){
//                        setTaskName(2);return;
//                    }
//                    if (AtFairyConfig.getOption("gd").equals("1")){
//                        setTaskName(4);return;
//                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Hidden Dragon team.png",2);
                mFairy.initMatTime();
                setTaskName(6);
            }
            public void content_6()throws Exception{
                if (AtFairyConfig.getOption("yldj").equals("1")){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f, result, 34,86,47,123, "世界地图", 2000);
                    mFairy.onTap(0.8f, result, 592,587,611,613, "剑韦山庄", 2000);
                }
                if (AtFairyConfig.getOption("yldj").equals("2")){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f, result, 34,86,47,123, "世界地图", 2000);
                    mFairy.onTap(0.8f, result, 722,216,732,245, "雪域幻境", 2000);
                }
                if (AtFairyConfig.getOption("yldj").equals("3")){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f, result, 34,86,47,123, "世界地图", 2000);
                    mFairy.onTap(0.8f, result, 201,412,220,429, "圣墨山庄", 2000);
                }
                if (AtFairyConfig.getOption("yldj").equals("4")){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f, result, 34,86,47,123, "世界地图", 2000);
                    mFairy.onTap(0.8f, result, 592,587,611,613, "长安", 2000);
                }
                if (AtFairyConfig.getOption("yldj").equals("5")){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f, result, 34,86,47,123, "世界地图", 2000);
                    mFairy.onTap(0.8f, result, 592,587,611,613, "文墨轩", 2000);
                }
                if (AtFairyConfig.getOption("yldj").equals("6")){
                    result = mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f, result, 34,86,47,123, "世界地图", 2000);
                    mFairy.onTap(0.8f, result, 592,587,611,613, "御龙峰", 2000);
                }
                setTaskName(3);return;
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Big Wild begain.png");
                mFairy.onTap(0.8f,result,"前去大雁塔",2000);

                result = mFairy.findPic("Big Wild challenge.png");
                mFairy.onTap(0.8f,result,"开始挑战",2000);

                result = mFairy.findPic(471,19,763,240,"hyxuanguan.png");
                mFairy.onTap(0.7f,result,"选关",2000);

                result = mFairy.findPic("First pass.png");
                mFairy.onTap(0.7f,result,"第一关",2000);

                result = mFairy.findPic("fail.png");
                if (result.sim > 0.8f){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                }

                result = mFairy.findPic("mpsl num.png");
                if (result.sim > 0.7f){
                    LtLog.e("人数不够");

                    setTaskName(0);return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }

                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Hidden Dragon team.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"隐龙迷踪");
    }
    /**
     * 门派试炼 Chieftain challenge
     */
    public void  factionTrial()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.seek("Faction trial.png",2);
                if (ret==1){
                    LtLog.e("任务还没做");
                    if (AtFairyConfig.getOption("ld").equals("1")){
                        setTaskName(2);return;
                    }
                    if (AtFairyConfig.getOption("gd").equals("1")){
                        setTaskName(4);return;
                    }
                }else {
                    LtLog.e("任务做完了");
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                gameUtil.close();
                gameUtil.createTeam("Faction trial team.png",2);
                mFairy.initMatTime();
                setTaskName(3);
            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("bagin sl.png");
                mFairy.onTap(0.8f,result,"进行试炼",2000);

                boolean time1 =  timekeep(2,780000,"门派试炼");

                result = mFairy.findPic("fail.png");
                if (result.sim > 0.8f){
                    LtLog.e("打不过结束任务");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    setTaskEnd();return;
                }

                result = mFairy.findPic("mpsl num.png");
                if (result.sim > 0.7f){
                    LtLog.e("人数不够");
                    setTaskName(0);return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);

                }
                if (dazeTime > 30 && result1.sim < 0.8f) {
                    setTaskName(1);
                    return;
                }
                if (time1){
                    LtLog.e("副本时间超时结束任务");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",2000);
            }
            public void content_4()throws Exception{
                gameUtil.close();
                gameUtil.seekTeam("Faction trial team.png",0);
                mFairy.initMatTime();
                setTaskName(5);
            }
            public void content_5()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                }

                if (dazeTime >= 300 && result1.sim<0.8f){
                    gameUtil.close();
                    mFairy.onTap(155,114,195,133,"组队蓝",2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f,result,"任务收纳栏",Sleep+1000);
                    result = mFairy.findPic(3,85,251,156,"team.png");
                    LtLog.e("=====================================组队栏相似度"+result.sim);
                    mFairy.onTap(0.70f,result,"打开组队栏",2000);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",Sleep);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"确定",Sleep);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("team3.png");
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);
            }
        }.taskContent(mFairy,"门派试炼");
    }
}


