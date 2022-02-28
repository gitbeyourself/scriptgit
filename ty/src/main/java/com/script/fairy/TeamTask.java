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
    FindResult result1;
    GameUtil gameUtil;
    YxdUtil yxdUtil ;
    OtherGame otherGame;
    public TeamTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        mFairy1 = ypFairy;
        yxdUtil=new YxdUtil(mFairy);
        otherGame=new OtherGame(mFairy);
    }

    /**
     * 寻灵跟队
     *
     * @throws Exception
     */
    public void xl() throws Exception {
        new TeamTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.8f,result,"队伍栏",Sleep);

                result = mFairy.findPic(64,194,301,387,"set out.png");
                mFairy.onTap(0.8f,result,"退出",Sleep);
                mFairy.onTap(0.8f,result,729,493,740,504,"确定退出",Sleep);
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("XunLing.png",0);
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,624,497,642,506,"跳转组队",Sleep);

                result = mFairy.findPic("autopp.png");
                mFairy.onTap(0.8f, result, "自动匹配", Sleep);

              /*  result = mFairy.findPic(955,203,1151,562,"apply.png");
                mFairy.onTap(0.8f,result,"申请",Sleep);*/

                 result = mFairy.findPic("Continue to match.png");
                 mFairy.onTap(0.8f,result,"继续匹配",Sleep);

                result = mFairy.findPic("sign out.png");
                mFairy.onTap(0.8f,result,1124,77,1129,86,"关叉",3000);

                 result = mFairy.findPic("introduction.png");
                if (datetinme > 60 && result.sim < 0.8f){
                    gameUtil.close();
                    result = mFairy.findPic("team.png");
                    mFairy.onTap(0.8f,result,"队伍栏",Sleep);

                    result = mFairy.findPic(64,194,301,387,"set out.png");
                    mFairy.onTap(0.8f,result,"退出",Sleep);
                    mFairy.onTap(0.8f,result,729,493,740,504,"确定退出",Sleep);

                    setTaskEnd();return;


                }

                /* result = mFairy.findPic("stjx.png");
                mFairy.onTap(0.8f,result,"继续",Sleep);

                result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f,result,"确认选择",Sleep);

                result = mFairy.findPic("surplus.png");
                if(result.sim < 0.8f){
                    mFairy.ranSwipe(200,555,202,354,4000,2000);
                }

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f,result,511,484,522,491,"离开",Sleep);
                if(result.sim > 0.8f){
                    setTaskEnd();return;
                }*/
                // if (overtime(10,0))return;
            }
        }.taskContent(mFairy, "寻灵跟队");
    }

    /**
     * 寻灵带队
     *
     * @throws Exception
     */
    public void xldd() throws Exception {
        new TeamTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("XunLing.png",0);
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,624,497,642,506,"跳转组队",Sleep);

                result = mFairy.findPic("invitation.png");
                mFairy.onTap(0.8f,result,1119,73,1130,84,"邀请关闭",Sleep);

                result = mFairy.findPic("build team.png");
                mFairy.onTap(0.8f, result, "创建队伍", Sleep);

                result = mFairy.findPic("myteam.png");
                if(result.sim > 0.8f){

                }

                if (timekeep(1,30000,"喊话")) {
                    result = mFairy.findPic("Shouting.png");
                    mFairy.onTap(0.8f, result, "喊话", 2000);
                    mFairy.onTap(0.8f, result, 533,533,541,541,"队伍喊话", Sleep);
                    timekeepInit("喊话");
                }
                result = mFairy.findPic("zidong.png");
                mFairy.onTap(0.8f,result,"自动匹配",Sleep);


                result = mFairy.findPic("activity.png");
                if (result.sim > 0.8f){
                    LtLog.e("还在活动界面");
                    setTaskName(1);return;
                }
                result = mFairy.findPic("gotask2.png");
                mFairy.onTap(0.8f,result,"人满了前往目标",Sleep);

                result = mFairy.findPic("gotask.png");
                mFairy.onTap(0.8f,result,"前往目标",Sleep);

                result = mFairy.findPic("openxun.png");
                mFairy.onTap(0.8f,result,"开启寻灵任务",Sleep);
                if(result.sim > 0.8f){
                    setTaskName(3);return;
                 }
                result = mFairy.findPic("fu.png");
                if(result.sim > 0.8f){
                    setTaskName(3);return;
                }
            }

            public void content_3() throws Exception {
                result = mFairy.findPic(new String[]{"introduction.png","introduction2.png"});
                if (result.sim > 0.75f) {
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.8f, result, "开启自动", Sleep);
                }

                result = mFairy.findPic("gotask.png");
                mFairy.onTap(0.8f,result,"前往目标",Sleep);

                result = mFairy.findPic("openxun.png");
                mFairy.onTap(0.8f,result,"开启寻灵任务",Sleep);

                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);

                if (datetinme >= 30) {
                    result = mFairy.findPic(61,114,303,393,"xunling2.png");
                    mFairy.onTap(0.8f, result, "前往目标2", 5000);

                }
                result = mFairy.findPic("no num.png");
                if (result.sim > 0.8f){
                    setTaskName(1);return;
                }

                result = mFairy.findPic("gotask2.png");
                mFairy.onTap(0.8f,result,"人满了前往目标",Sleep);

                result = mFairy.findPic("duiwu.png");
                mFairy.onTap(0.8f,result,"申请列表",Sleep);

                result = mFairy.findPic("sure.png");
                mFairy.onTap(0.8f,result,"同意",Sleep);
                mFairy.onTap(0.8f,result,1116,71,1134,86,"同意",Sleep);

               /* result = mFairy.findPic("introduction.png");
                if (result.sim < 0.8f && datetinme >=50){
                    setTaskEnd();return;
                }*/
               result  =mFairy.findPic(new String[]{"xunl.png","xunl2.png"});
                result1 = mFairy.findPic(61,114,303,393,"xunling2.png");
               if (result.sim > 0.8f && datetinme > 60 && result1.sim <0.8f){
                   mFairy.onTap(0.8f,result,625,492,633,504,"寻灵已完成",Sleep);

                   setTaskName(4);return;

               }

            }
            public void content_4() throws Exception {
                result = mFairy.findPic("team2.png");
                mFairy.onTap(0.8f,result,"队伍",Sleep);

                result = mFairy.findPic(65,186,273,401,"set out.png");
                mFairy.onTap(0.8f,result,"退出队伍",Sleep);

                result = mFairy.findPic("tuichu2.png");
                mFairy.onTap(0.8f,result,"退出队伍",Sleep);

                result = mFairy.findPic(new String[]{"tuichu.png","tuichu3.png"});
                mFairy.onTap(0.7f,result,720,490,735,502,"确定退出队伍",Sleep);

                result =mFairy.findPic(new String[]{"build team.png","establishteam.png"});
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "寻灵带队");
    }

    /**
     * 副本探险带队
     *
     * @throws Exception
     */
    public void fbdd() throws Exception {
        new TeamTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("XiChen.png",1);//"XiChen.png"
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                //long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("activity.png");
                if (result.sim > 0.8f && datetinme >30){
                    LtLog.e("重置");
                    // gameUtil.close();
                    setTaskName(0);return;
                }
                result = mFairy.findPic(212,286,672,504,new String[]{"3v3.png","3v32.png"});
                if (result.sim > 0.8f){
                    LtLog.e("没有次数了");
                    gameUtil.close();
                    setTaskName(4);return;
                }
                result = mFairy.findPic(53,78,717,678,new String[]{"ordinary.png","ordinary2.png"});
                mFairy.onTap(0.8f,result,"普通",Sleep);

                result = mFairy.findPic("fbyes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                if(AtFairyConfig.getOption("lx").equals("1")){
                    result = mFairy.findPic("LingXu.png");
                    mFairy.onTap(0.8f,result,"灵虚",Sleep);
                    mFairy.onTap(0.8f,result,812,626,827,634,"组队",Sleep);
                }
                if(AtFairyConfig.getOption("sc").equals("1")){
                    result = mFairy.findPic("shensi.png");
                    mFairy.onTap(0.8f,result,"神祀",Sleep);
                    mFairy.onTap(0.8f,result,812,626,827,634,"组队",Sleep);
                }
                if(AtFairyConfig.getOption("cc").equals("1")){
                    result = mFairy.findPic("changcheng.png");
                    mFairy.onTap(0.8f,result,"长城",Sleep);
                    mFairy.onTap(0.8f,result,812,626,827,634,"组队",Sleep);
                }

                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,624,497,642,506,"跳转组队",Sleep);

                result = mFairy.findPic("build team.png");
                mFairy.onTap(0.8f, result, "创建队伍", Sleep);


                if (timekeep(1,30000,"喊话")) {
                    result = mFairy.findPic("Shouting.png");
                    mFairy.onTap(0.8f, result, "喊话", 2000);
                    mFairy.onTap(0.8f, result, 533,533,541,541,"队伍喊话", Sleep);
                    timekeepInit("喊话");
                }
                result = mFairy.findPic("zidong.png");
                mFairy.onTap(0.8f,result,"自动匹配",Sleep);

                result = mFairy.findPic("gotask2.png");
                mFairy.onTap(0.8f,result,"人满了前往目标",Sleep);

                result = mFairy.findPic("gotask.png");
                mFairy.onTap(0.8f,result,"前往目标",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
                result = mFairy.findPic("close fb.png");//continue
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic(new String[]{"introduction.png","introduction2.png"});
                if (result.sim > 0.8f) {
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception {
                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("zhuzhan.png");
                mFairy.onTap(0.8f,result,519,491,535,502,"不开助战",Sleep);

                result = mFairy.findPic(new String[]{"introduction.png","introduction2.png"});
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.8f, result, "开启自动", Sleep);
                }else if (result.sim < 0.8f&& datetinme > 30){
                    setTaskName(0);return;
                }

                result = mFairy.findPic(53,78,717,678,new String[]{"ordinary.png","ordinary2.png"});
                mFairy.onTap(0.8f,result,"普通",Sleep);

                result = mFairy.findPic("fbyes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                if(AtFairyConfig.getOption("lx").equals("1")){
                    result = mFairy.findPic("LingXu.png");
                    mFairy.onTap(0.8f,result,"灵虚",Sleep);
                    mFairy.onTap(0.8f,result,1052,629,1061,640,"组队",Sleep);
                }
                if(AtFairyConfig.getOption("sc").equals("1")){
                    result = mFairy.findPic("shensi.png");
                    mFairy.onTap(0.8f,result,"神祀",Sleep);
                    mFairy.onTap(0.8f,result,1052,629,1061,640,"组队",Sleep);
                }
                if(AtFairyConfig.getOption("cc").equals("1")){
                    result = mFairy.findPic("changcheng.png");
                    mFairy.onTap(0.8f,result,"长城",Sleep);
                    mFairy.onTap(0.8f,result,1052,629,1061,640,"组队",Sleep);
                }

                result = mFairy.findPic("gotask2.png");
                mFairy.onTap(0.8f,result,"人满了前往目标",Sleep);

                result = mFairy.findPic("gofuben.png");
                mFairy.onTap(0.8f,result,"前往副本",Sleep);

                result = mFairy.findPic("wancheng2.png");
                mFairy.onTap(0.8f,result,"完成",Sleep);

               /* result = mFairy.findPic("again.png");
                mFairy.onTap(0.8f,result,"再次挑战",Sleep);
                if (result.sim > 0.8f){
                    num++;
                }*/
                result = mFairy.findPic("duiwu.png");
                mFairy.onTap(0.8f,result,"申请列表",Sleep);

                result = mFairy.findPic("guanbi.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
               /* if (num >=3){
                    result = mFairy.findPic("guanbi.png");
                    mFairy.onTap(0.8f,result,"关闭",Sleep);
                    num=0;
                    num2++;
                }
                if (num2>=3){
                    setTaskName(4);return;
                }*/
                result = mFairy.findPic("sure.png");
                mFairy.onTap(0.8f,result,"同意",Sleep);
                mFairy.onTap(0.8f,result,1116,71,1134,86,"同意",Sleep);

               /* result  =mFairy.findPic(new String[]{"xunl.png","xunl2.png"});
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,625,492,633,504,"寻灵已完成",Sleep);

                    setTaskName(4);return;

                }*/

            }
            public void content_4() throws Exception {
                result = mFairy.findPic("team2.png");
                mFairy.onTap(0.8f,result,"队伍",Sleep);

                result = mFairy.findPic(65,186,273,401,"set out.png");
                mFairy.onTap(0.8f,result,"退出队伍",Sleep);

                result = mFairy.findPic("tuichu2.png");
                mFairy.onTap(0.8f,result,"退出队伍",Sleep);

                result = mFairy.findPic(new String[]{"tuichu.png","tuichu3.png"});
                mFairy.onTap(0.7f,result,720,490,735,502,"确定退出队伍",Sleep);


                result =mFairy.findPic(new String[]{"build team.png","establishteam.png"});
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "副本探险带队");
    }

    /**
     * 副本洗尘带队
     *
     * @throws Exception
     */
    public void fbxcdd() throws Exception {
        new TeamTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("XiChen.png",1);//"XiChen.png"
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("activity.png");
                if (result.sim > 0.8f && datetinme >30){
                    LtLog.e("重置");
                   // gameUtil.close();
                    setTaskName(0);return;
                }
                result = mFairy.findPic(53,78,717,678,new String[]{"ordinary.png","ordinary2.png"});
                mFairy.onTap(0.8f,result,"普通",Sleep);

                result = mFairy.findPic("fbyes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);


                result = mFairy.findPic("LingXu.png");
                mFairy.onTap(0.8f,result,"灵虚",Sleep);
                mFairy.onTap(0.8f,result,812,626,827,634,"组队",Sleep);
               /* if(AtFairyConfig.getOption("sc").equals("1")){
                    result = mFairy.findPic("shensi.png");
                    mFairy.onTap(0.8f,result,"神祀",Sleep);
                    mFairy.onTap(0.8f,result,812,626,827,634,"组队",Sleep);
                }
                if(AtFairyConfig.getOption("cc").equals("1")){
                    result = mFairy.findPic("changcheng.png");
                    mFairy.onTap(0.8f,result,"长城",Sleep);
                    mFairy.onTap(0.8f,result,812,626,827,634,"组队",Sleep);
                }*/

                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,624,497,642,506,"跳转组队",Sleep);

                result = mFairy.findPic("build team.png");
                mFairy.onTap(0.8f, result, "创建队伍", Sleep);


                if (timekeep(1,30000,"喊话")) {
                    result = mFairy.findPic("Shouting.png");
                    mFairy.onTap(0.8f, result, "喊话", 2000);
                    mFairy.onTap(0.8f, result, 533,533,541,541,"队伍喊话", Sleep);
                    timekeepInit("喊话");
                }
                result = mFairy.findPic("zidong.png");
                mFairy.onTap(0.8f,result,"自动匹配",Sleep);

                result = mFairy.findPic("gotask2.png");
                mFairy.onTap(0.8f,result,"人满了前往目标",Sleep);

                result = mFairy.findPic("gotask.png");
                mFairy.onTap(0.8f,result,"前往目标",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
                result = mFairy.findPic("close fb.png");//continue
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic(new String[]{"introduction.png","introduction2.png"});
                if (result.sim > 0.8f) {
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception {
                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("zhuzhan.png");
                mFairy.onTap(0.8f,result,727,490,739,498,"助战",Sleep);

                result = mFairy.findPic(new String[]{"introduction.png","introduction2.png"});
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.8f, result, "开启自动", Sleep);
                }else if (result.sim < 0.8f&& datetinme > 30){
                    setTaskName(0);return;
                }

                result = mFairy.findPic(61,117,313,380,"rcxc.png");
                mFairy.onTap(0.8f,result,"洗尘",Sleep);


                result = mFairy.findPic(53,78,717,678,new String[]{"ordinary.png","ordinary2.png"});
                mFairy.onTap(0.8f,result,"普通",Sleep);

                result = mFairy.findPic("fbyes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result = mFairy.findPic("LingXu.png");
                mFairy.onTap(0.8f,result,"灵虚",Sleep);
                mFairy.onTap(0.8f,result,1052,629,1061,640,"组队",Sleep);

                result = mFairy.findPic("gotask2.png");
                mFairy.onTap(0.8f,result,"人满了前往目标",Sleep);

                result = mFairy.findPic("gofuben.png");
                mFairy.onTap(0.8f,result,"前往副本",Sleep);

                result = mFairy.findPic("wancheng2.png");
                mFairy.onTap(0.8f,result,"完成",Sleep);

                result = mFairy.findPic("duiwu.png");
                mFairy.onTap(0.8f,result,"申请列表",Sleep);

                result = mFairy.findPic("guanbi.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);
                if (result.sim > 0.8f){
                    gameUtil.close();
                   setTaskName(4);return;
                }
                result = mFairy.findPic("sure.png");
                mFairy.onTap(0.8f,result,"同意",Sleep);
                mFairy.onTap(0.8f,result,1116,71,1134,86,"同意",Sleep);
            }
            public void content_4() throws Exception {
                result = mFairy.findPic("team2.png");
                mFairy.onTap(0.8f,result,"队伍",Sleep);

                result = mFairy.findPic(65,186,273,401,"set out.png");
                mFairy.onTap(0.8f,result,"退出队伍",Sleep);

                result = mFairy.findPic("tuichu2.png");
                mFairy.onTap(0.8f,result,"退出队伍",Sleep);

                result = mFairy.findPic(new String[]{"tuichu.png","tuichu3.png"});
                mFairy.onTap(0.7f,result,720,490,735,502,"确定退出队伍",Sleep);


                result =mFairy.findPic(new String[]{"build team.png","establishteam.png"});
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "副本洗尘带队");
    }
    /**
     * 副本洗尘
     *
     * @throws Exception
     */
    public void fbxc() throws Exception {
        new TeamTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("XiChen.png",0);
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,624,497,642,506,"跳转组队",Sleep);

                result = mFairy.findPic("task3.png");
                mFairy.onTap(0.8f, result, "任务栏", Sleep);

                result = mFairy.findPic(61,117,313,380,"rcxc.png");
                mFairy.onTap(0.8f,result,"洗尘",Sleep);

                result = mFairy.findPic("autopp.png");
                mFairy.onTap(0.8f, result, "自动匹配", Sleep);

                result = mFairy.findPic(new String[]{"introduction.png","introduction2.png"});
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("auto.png");
                    mFairy.onTap(0.8f, result, "开启自动", Sleep);
                }/*else if (result.sim < 0.8f&& datetinme > 30){
                    setTaskName(0);return;
                }*/

                result = mFairy.findPic("wancheng2.png");
                mFairy.onTap(0.8f,result,"完成",Sleep);
                if (result.sim > 0.8f){
                    result = mFairy.findPic("team.png");
                    mFairy.onTap(0.8f,result,"队伍栏",Sleep);

                    result = mFairy.findPic(64,194,301,387,"set out.png");
                    mFairy.onTap(0.8f,result,"退出",Sleep);
                    mFairy.onTap(0.8f,result,729,493,740,504,"确定退出",Sleep);

                    result =mFairy.findPic("establishteam.png");
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                }
                result = mFairy.findPic(53,78,717,678,new String[]{"ordinary.png","ordinary2.png"});
                mFairy.onTap(0.8f,result,"普通",Sleep);

                result = mFairy.findPic("fbyes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result = mFairy.findPic("LingXu.png");
                mFairy.onTap(0.8f,result,"灵虚",Sleep);
                mFairy.onTap(0.8f,result,1052,629,1061,640,"组队",Sleep);


                result = mFairy.findPic("Continue to match.png");
                mFairy.onTap(0.8f,result,"继续匹配",Sleep);

                result = mFairy.findPic("sign out.png");
                mFairy.onTap(0.8f,result,1124,77,1129,86,"关叉",Sleep);

               /* result1 = mFairy.findPic(61,117,313,380,"rcxc.png");
                 mFairy.onTap(0.7f,result1,"完成洗尘",Sleep);
                 result = mFairy.findPic("introduction.png");
                if (datetinme > 60 && result.sim < 0.8f && result1.sim < 0.7f){
                    result = mFairy.findPic("team.png");
                    mFairy.onTap(0.8f,result,"队伍栏",Sleep);

                    result = mFairy.findPic(64,194,301,387,"set out.png");
                    mFairy.onTap(0.8f,result,"退出",Sleep);
                    mFairy.onTap(0.8f,result,729,493,740,504,"确定退出",Sleep);

                    setTaskName(0);return;
                }*/

                result = mFairy.findPic("close fb.png");//continue
                mFairy.onTap(0.8f,result,"关闭",Sleep);


                result = mFairy.findPic("zhuzhan.png");
                mFairy.onTap(0.8f,result,727,490,739,498,"助战",Sleep);
               /* result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f,result,"确认选择",Sleep);

                result = mFairy.findPic("surplus.png");
                if(result.sim < 0.8f){
                    mFairy.ranSwipe(200,555,202,354,4000,2000);
                }

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f,result,511,484,522,491,"离开",Sleep);
                if(result.sim > 0.8f){
                    setTaskEnd();return;
                }*/
                // if (overtime(10,0))return;
            }
        }.taskContent(mFairy, "副本洗尘");
    }

}
