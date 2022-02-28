package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;

    TimingActivity timingActivity;
    public SingleTask(AtFairyImpl ATFairy) throws Exception {
        Sleep = 100;
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);

        timingActivity=new TimingActivity(mFairy);
    }

    @Override
    public void inOperation() throws Exception {
//        result = mFairy.findPic(new String[]{"skip.png", "jump.png"});
//        mFairy.onTap(0.8f, result, "跳过", 2000);
        result = mFairy.findPic("buling.png");
        mFairy.onTap(0.8f, result, 195,706,210,719,"不话费100补领", 2000);
    }
    /**
     * 新手指引（主线任务）
     *
     * @throws Exception
     */
    public void plotTask() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                setTaskName(1);
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("immediately.png");
                mFairy.onTap(0.8f, result, "即刻启程", Sleep);

                result = mFairy.findPic("activation.png");
                mFairy.onTap(0.8f, result, "激活宠物", Sleep);

                result = mFairy.findPic(18,823,715,1270,"hand.png");//510,801 454,743
                mFairy.onTap(0.8f, result, result.x-56,result.y-58,result.x-55,result.y-57,"任务指导手下", 2000);

                result = mFairy.findPic(21,427,699,863,"hand.png");//510,801 454,743
                mFairy.onTap(0.8f, result, result.x-56,result.y-58,result.x-55,result.y-57,"任务指导手中", 2000);

                result = mFairy.findPic(0,48,719,463,"hand.png");//510,801 454,743
                mFairy.onTap(0.8f, result, result.x-56,result.y-58,result.x-55,result.y-57,"任务指导手上", 2000);

                result = mFairy.findPic(582,1053,719,1197,"hand2.png");//510,801 454,743
                mFairy.onTap(0.8f, result, result.x-56,result.y-58,result.x-55,result.y-57,"返回", 2000);

                result = mFairy.findPic(494,1068,693,1143,"new yes.png");
                mFairy.onTap(0.8f, result, "确定", Sleep);

                result = mFairy.findPic(65,807,413,919,"wancheng.png");
                mFairy.onTap(0.8f, result, "完成", 3000);

                result = mFairy.findPic("new lq.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);

                result = mFairy.findPic("chenchuan.png");
                mFairy.onTap(0.8f, result, 638,878,654,890,"去沉船地图", Sleep);

                result = mFairy.findPic("wreck.png");
                if(result.sim > 0.8f){
                    LtLog.e("引导结束");
                   setTaskEnd();return;
                }

            }
            public void content_2() throws Exception {
                result = mFairy.findPic("Receive awards Online.png");
                mFairy.onTap(0.8f, result, "在线领奖", Sleep);

                result = mFairy.findPic("online lj.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("online gift.png");
                    mFairy.onTap(0.8f, result, "在线领奖", Sleep);
                }
            }

        }.taskContent(mFairy, "新手指引");
    }

    /**
     * 钟馗捉鬼
     *
     * @throws Exception
     */
    public void catchGhost() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Catch the ghost.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1000);

                result = mFairy.findPic("go catch.png");
                mFairy.onTap(0.8f, result, "前往抓鬼svip", 2000);

                result = mFairy.findPic("go catch3.png");
                mFairy.onTap(0.8f, result, "前往抓鬼vip", 2000);

                result = mFairy.findPic("Tianyan.png");
                mFairy.onTap(0.8f, result, "天眼通符", 2000);

                result = mFairy.findPic("Challenge gui.png");
                mFairy.onTap(0.8f, result, "挑战svip", 2000);
                result = mFairy.findPic("viptz.png");
                mFairy.onTap(0.8f, result, "挑战vip", 2000);

                result = mFairy.findPic("receive gui.png");
                mFairy.onTap(0.8f, result, "领取抓鬼奖励", 2000);

                result = mFairy.findPic("viplingqu.png");
                mFairy.onTap(0.8f, result, "领取抓鬼奖励vip", 2000);

                result = mFairy.findPic("go catch2.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }

                result1 = mFairy.findPic("vipyilingqu.png");
                result = mFairy.findPic("go catch4.png");
                if(result.sim > 0.8f && result1.sim > 0.8f){
                    setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "钟馗捉鬼");
    }

    /**
     * 剧情挑战
     *
     * @throws Exception
     */
    public void plot() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("plot.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("没打过结束");
                    setTaskEnd();return;
                }

                result = mFairy.findPic(476,181,693,575,new String[]{"vipsd.png","Mopping juqing.png"});
                mFairy.onTap(0.8f, result, "一键扫荡", 2000);


                result = mFairy.findPic(480,134,684,939,"jqtz2.png");
                mFairy.onTap(0.8f, result, "挑战svip", Sleep);

                result = mFairy.findPic(480,134,684,939,"jqtzvip.png");
                mFairy.onTap(0.8f, result, "挑战vip", Sleep);

                result = mFairy.findPic(new String[]{"beat2.png","beat.png"});
                result1 = mFairy.findPic("tz.png");
                if (result.sim > 0.8f && result1.sim > 0.8f){
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"vipjibai.png","beat.png","jibai.png"});
                result1 = mFairy.findPic("viptz2.png");
                if (result.sim > 0.8f && result1.sim > 0.8f){
                    setTaskEnd();return;
                }
                result = mFairy.findPic(new String[]{"jibai2.png","jibai.png"});
                result1 = mFairy.findPic("juqing2.png");
                if (result.sim > 0.8f && result1.sim > 0.8f){
                    setTaskEnd();return;
                }

//                result = mFairy.findPic("juqingpage.png");
//                if (result.sim > 0.8f && result1.sim > 0.8f){
//                    setTaskName(0);return;
//                }

//                result = mFairy.findPic("go catch2.png");
//                if(result.sim > 0.8f){
//                    setTaskName(0);return;
//                }
            }

        }.taskContent(mFairy, "剧情挑战");
    }


    /**
     * 种族任务
     *
     * @throws Exception
     */
    public void race() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("race.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("gogo.png");
                mFairy.onTap(0.8f, result, "前往", 2000);

                result = mFairy.findPic("collection.png");
                mFairy.onTap(0.8f, result, "采集", 3000);

                result = mFairy.findPic(new String[]{"rescue.png","rescue2.png"});
                mFairy.onTap(0.8f, result, "救援", 3000);

                result = mFairy.findPic("lesson.png");
                mFairy.onTap(0.8f, result, "教训一下", 3000);

                result = mFairy.findPic("search.png");
                mFairy.onTap(0.8f, result, "搜索", 3000);

                result = mFairy.findPic("me go.png");
                if(result.sim > 0.8f){
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                result = mFairy.findPic("compass.png");
                mFairy.onTap(0.8f, result, "种族命盘", 3000);

                result = mFairy.findPic("zhongzulq.png");
                mFairy.onTap(0.8f, result, "领取", 1500);

                result = mFairy.findPic("vipzzlq.png");
                mFairy.onTap(0.8f, result, "领取", 1500);

                result = mFairy.findPic(new String[]{"zzlp.png","vipoverzz.png"});
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }

            }

        }.taskContent(mFairy, "种族任务");
    }

    /**
     * 副本任务
     *
     * @throws Exception
     */
    public void copyTask() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Copy.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(new String[]{"Free Admission.png","Free Admission2.png","fubencd.png"});
                mFairy.onTap(0.8f, result, "免费扫荡", 2000);

                result = mFairy.findPic("jqtz.png");
                mFairy.onTap(0.8f, result, "挑战", 3000);

                result = mFairy.findPic(243,792,468,896,"jzhs lq.png");
                mFairy.onTap(0.8f, result, "领取", 3000);

                result = mFairy.findPic(new String[]{"mianfei.png","vipmf.png","fbover.png"});
                result1 = mFairy.findPic(new String[]{"saodang.png","saodang2.png"});
                if(result.sim > 0.8f || result1.sim > 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("fbtz.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "副本任务");
    }

    /**
     * 擂台
     *
     * @throws Exception
     */
    public void arena() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("arena.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(526,794,623,915,new String[]{"recommend.png","recommend2.png"});
                mFairy.onTap(0.8f, result, result.x-80,result.y-100,result.x-79,result.y-99,"推荐", 4000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic("huafei.png");
                mFairy.onTap(0.8f, result, 195,705,205,715,"取消", 2000);

                result = mFairy.findPic(361,540,554,689,"zero1.png");
                result = mFairy.findPic(476,903,707,1028,"zero.png");
                result = mFairy.findPic(476,903,707,1028,"zero2.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "擂台");
    }

    /**
     * 二十八星宿
     *
     * @throws Exception
     */
    public void constellation() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Constellation.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                   setTaskEnd();return;
                }

                result = mFairy.findPic(15,963,693,1048,new String[]{"xxtz.png","vip28tz.png"});
                mFairy.onTap(0.8f, result, "挑战", 2000);
            }
        }.taskContent(mFairy, "二十八星宿");
    }

    /**
     * 白虎堂
     *
     * @throws Exception
     */
    public void whiteTiger() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("white tiger.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("num.png");
                mFairy.onTap(0.8f, result, 580,1095,590,1102,"跑商", 2000);
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }

                result = mFairy.findPic("cishu.png");
                mFairy.onTap(0.8f, result, 580,1095,590,1102,"跑商", 2000);
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }

                result = mFairy.findPic("Running a business.png");
                mFairy.onTap(0.8f, result, "跑商", 2000);

                result = mFairy.findPic("Runvip.png");
                mFairy.onTap(0.8f, result, "跑商vip", 2000);

                if (AtFairyConfig.getOption("zzps").equals("1")){
                    result = mFairy.findPic(491,475,628,544,"Paper.png");
                    mFairy.onTap(0.8f, result, "纸质跑商", 2000);
                }
                if (AtFairyConfig.getOption("tbps").equals("1")){
                    result = mFairy.findPic(483,683,640,758,"Copper plate.png");
                    mFairy.onTap(0.8f, result, "铜板跑商", 2000);
                }
                if (AtFairyConfig.getOption("djps").equals("1")){

                    result = mFairy.findPic("gold-plated.png");
                    mFairy.onTap(0.8f, result, "镀金跑商", 2000);
                }
                if (!AtFairyConfig.getOption("zzps").equals("1")&&!AtFairyConfig.getOption("tbps").equals("1")&&!AtFairyConfig.getOption("djps").equals("1")){
                    result = mFairy.findPic(481,889,633,965,"Copper plate.png");
                    mFairy.onTap(0.8f, result, "铜板跑商", 2000);
                }





                result = mFairy.findPic(new String[]{"jin.png","jin2.png"});
                mFairy.onTap(0.8f, result, "金库", 2000);



            }
        }.taskContent(mFairy, "白虎堂");
    }

    /**
     * 玄武堂
     *
     * @throws Exception
     */
    public void xuanwu() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission2("Xuanwu.png","xuanwu2.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
//                mFairy.sleep(1500);
                result = mFairy.findPic("xwok.png");
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 401,857,411,866,"领取1", 2000);
                    mFairy.onTap(0.8f, result, 623,858,631,865,"领取2", 2000);
                    setTaskName(0);return;
                }

                result = mFairy.findPic("xwbegin.png");
                mFairy.onTap(0.8f, result, "开始", 2000);

                result = mFairy.findPic("xwjiao.png");
                mFairy.onTap(0.8f, result, "开始", 2000);

                result = mFairy.findPic("begin xwt.png");
                mFairy.onTap(0.8f, result, "开始任务", 2000);

                result = mFairy.findPic("vipgo.png");
                mFairy.onTap(0.8f, result, "开始任务", 2000);

                result = mFairy.findPic(new String[]{"Monsters.png","Monsters2.png"});
                mFairy.onTap(0.8f, result, "妖怪看打", 2000);

                result = mFairy.findPic(new String[]{"Beat up.png","vipzou.png"});
                mFairy.onTap(0.8f, result, "揍到跪地求饶", 2000);

                result = mFairy.findPic("xwcai.png");
                mFairy.onTap(0.8f, result, "这就去采", 2000);

                result = mFairy.findPic("xwbang.png");
                mFairy.onTap(0.8f, result, "我来帮你", 2000);

                result = mFairy.findPic("bao.png");
                mFairy.onTap(0.8f, result, "包在我身上", 2000);

                result = mFairy.findPic(136,581,619,1010,"zhengque.png");
                mFairy.onTap(0.8f, result, "正确答案", 2000);

                result = mFairy.findPic(136,581,619,1010,"vipxu.png");
                mFairy.onTap(0.8f, result, "正确答案", 2000);

                result = mFairy.findPic(68,600,180,685,"A.png");
                mFairy.onTap(0.8f, result, "A", 2000);

                result = mFairy.findPic("xw yes.png");
                mFairy.onTap(0.8f, result, "确定", 2000);

                result = mFairy.findPic("fang.png");
                mFairy.onTap(0.8f, result, "厢房", 2000);

                result = mFairy.findPic(new String[]{"completexw.png","completexw2.png"});
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 577,1093,599,1102,"知道了", 2000);
                    setTaskName(0);return;
                }

            }
        }.taskContent(mFairy, "玄武堂");
    }

    /**
     * 青龙堂
     *
     * @throws Exception
     */
    public void qinglong() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission2("qinglong.png","qinglong2.png",0);
                if (ret ==1) {
                   /* mFairy.sleep(2000);
                    mFairy.condit();
                    result = mFairy.findPic(new String[]{"qlmain.png","qlmain2.png","vipqingl.png","vipqingl2.png","qlmain3.png"});
                    if(result.sim > 0.8f) {*/
                        setTaskName(2);
                        return;
                   // }
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
//                mFairy.sleep(1500);
                result = mFairy.findPic("hand in.png");
                mFairy.onTap(0.8f, result, "上交", 2000);

                result = mFairy.findPic("begin xwt.png");
                mFairy.onTap(0.8f, result, "开始任务", 2000);

                result = mFairy.findPic("Monsters.png");
                mFairy.onTap(0.8f, result, "妖怪看打", 2000);

                result = mFairy.findPic(new String[]{"qllingqu.png","qllingquvip.png"});
                mFairy.onTap(0.8f, result, "领取奖励", 2000);

                result = mFairy.findPic("bao.png");
                mFairy.onTap(0.8f, result, "包在我身上", 2000);


                result2 = mFairy.findPic(44,205,675,766,"hand in.png");
                result1 = mFairy.findPic(44,205,675,766,"Gang help.png");
                mFairy.onTap(0.8f, result1, "帮派求助", 2000);

                result = mFairy.findPic(44,205,675,766,"For help.png");
                if(result1.sim < 0.8f && result.sim > 0.8f && result2.sim < 0.8f){
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Submitted.png");
                if(result.sim > 0.8f ){
                    setTaskName(0);return;
                }

                result = mFairy.findPic(new String[]{"jin.png","svipshou.png"});
                if(result.sim > 0.8f ){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "青龙堂");
    }

    /**
     * 帮派除盗
     *
     * @throws Exception
     */
    public void depredation() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Depredation.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic(203,35,510,257,"chudao2.png");
                result1 = mFairy.findPic("su.png");
                if (result.sim < 0.8f && result1.sim < 0.8f){
                   gameUtil.close2();
                   setTaskName(1);return;
                }
                result = mFairy.findPic("chudao.png");
                mFairy.onTap(0.8f, result, "除盗", 2000);

                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去 直接结束");
                   setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"bang.png","bangvip.png"});
                if (result.sim >= 0.8f) {
                    result = mFairy.findPic(40, 215, 689, 965, "red.png");
                    mFairy.onTap(0.8f, result, result.x - 50, result.y - 80, result.x - 49, result.y - 79, "怪", 2000);
                }
                result = mFairy.findPic(364,837,557,908,"Quick join.png");
                mFairy.onTap(0.8f, result, "快速加入", 2000);

                result = mFairy.findPic("Quick join2.png");
                mFairy.onTap(0.8f, result, "快速加入", 2000);

                result = mFairy.findPic(464,806,683,992,"han.png");
                mFairy.onTap(0.8f, result, "一键喊话", 15000);

                result = mFairy.findPic(238,802,474,1003,"begin cd.png");
                mFairy.onTap(0.8f, result, "开始战斗", 2000);

                result = mFairy.findPic("beat.png");
                if(result.sim > 0.8f){
                    LtLog.e("打完了结束");
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "帮派除盗");
    }

    /**
     * 帮派守护兽
     *
     * @throws Exception
     */
    public void guardianBeast() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Guardian beast.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去 直接结束");
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"train one.png","vipxulian.png"});
                mFairy.onTap(0.8f, result, "训练一次", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic(69,521,358,679,new String[]{"no number.png","no number2.png","vipnum.png"});
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 191,714,204,722,"没有次数了", 2000);
                  //  LtLog.e("打不过去 直接结束");
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "帮派守护兽");
    }

    /**
     * 决战华山
     *
     * @throws Exception
     */
    public void huashanMountain() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Huashan Mountain.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去");
//                    result = mFairy.findPic("close hs.png");
//                    mFairy.onTap(0.8f, result, "关闭", 2000);
                    result = mFairy.findPic(33,957,242,1056,"Mopping juqing.png");
                    mFairy.onTap(0.8f, result, "一键扫荡", 2000);
                    mFairy.onTap(0.8f, result, "一键扫荡", 2000);
                    mFairy.onTap(0.8f, result, 646,886,659,896,"领取宝箱", 2000);
                    mFairy.onTap(0.8f, result, 345,802,364,817,"领取", 2000);
                    mFairy.sleep(2000);
                    setTaskName(0);return;
                }

                result = mFairy.findPic(371,939,695,1069,"jqtz.png");
                mFairy.onTap(0.8f, result, "挑战", 2000);

//                result = mFairy.findPic("no number.png");
//                if(result.sim > 0.8f){
//                    mFairy.onTap(0.8f, result, 191,714,204,722,"没有次数了", 2000);
//                    //  LtLog.e("打不过去 直接结束");
//                    setTaskName(0);return;
//                }
            }
        }.taskContent(mFairy, "决战华山");
    }

    /**
     * 雁塔地宫
     *
     * @throws Exception
     */
    public void undergroundPalace() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("underground palace.png",0);
                if (ret ==1) {
                    result = mFairy.findPic(new String[]{"yt.png","yt2.png"});
                    if (result.sim > 0.8f){
                        setTaskName(2);return;
                    }
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去");
                    setTaskName(0);return;
                }
                result = mFairy.findPic(321,103,708,213,"red2.png");
                mFairy.onTap(0.8f, result, "宝箱", 2000);


                result = mFairy.findPic(76,955,285,1047,"Mopping juqing.png");
                mFairy.onTap(0.8f, result, "一键扫荡", 2000);

                result = mFairy.findPic("yt Break.png");
                mFairy.onTap(0.8f, result, "闯关", 2000);

                result = mFairy.findPic(15,963,693,1048,new String[]{"xxtz.png","vip28tz.png"});
                mFairy.onTap(0.8f, result, "挑战", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);


//                result = mFairy.findPic("no number.png");
//                if(result.sim > 0.8f){
//                    mFairy.onTap(0.8f, result, 191,714,204,722,"没有次数了", 2000);
//                    //  LtLog.e("打不过去 直接结束");
//                    setTaskName(0);return;
//                }
            }
        }.taskContent(mFairy, "雁塔地宫");
    }

    /**
     * 挖宝
     *
     * @throws Exception
     */
    public void treasureDigging() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Treasure digging.png",0);
                if (ret ==1) {
                    result = mFairy.findPic(new String[]{"wb.png","wb2.png"});
                    if (result.sim > 0.8f) {
                        setTaskName(2);
                        return;
                    }else {

                    }
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("Arrest.png");
                mFairy.onTap(0.8f, result, "缉拿", 2000);

                result = mFairy.findPic(487,1064,699,1142,"listen.png");
                mFairy.onTap(0.8f, result, "听听", 2000);

                result = mFairy.findPic(490,1052,699,1162,"determine.png");
                mFairy.onTap(0.8f, result, "确定", 2000);

                result = mFairy.findPic(new String[]{"auto jn.png","vipauto.png"});
               // mFairy.onTap(0.8f, result, "自动缉拿", 2000);
                result1 = mFairy.findPic(new String[]{"jina.png","jina2.png"});
                if(result1.sim > 0.8f && result.sim < 0.8f) {
                    mFairy.onTap(0.8f, result1, 54,1084,64,1091,"自动缉拿", 2000);
                }
                //result=mFairy.findMultiColor(0.9f,"8,134,52","-1|-6|8,134,52&0|-11|12,135,56&3|-14|12,135,56&8|-7|8,134,52&6|0|9,134,54");
                result   = mFairy.findPic("zero3.png");
                LtLog.e("********"+result.sim);
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception {
                if (overtime(100,0))return;
                result = mFairy.findPic("Treasure.png");
                mFairy.onTap(0.8f, result, "挖宝", 500);

                result = mFairy.findPic("nocbt.png");
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic(new String[]{"wabao.png","wabao2.png"});
                result1 = mFairy.findPic(new String[]{"auto wb.png","auto wb2.png"});
                if (result.sim > 0.8f && result1.sim < 0.7f){
                    err=0;
                    mFairy.onTap(0.8f, result, 345,704,360,713,"自动挖宝", 2000);
                }
//                result=mFairy.findMultiColor(553,819,615,875,0.9f,"12,135,56","-4|-8|8,134,52&0|-16|12,135,56&5|-8|8,134,52");
                result = mFairy.findPic("zero5.png");
                LtLog.e("********"+result.sim);
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "挖宝");
    }

    /**
     * 找回
     *
     * @throws Exception
     */
    public void getBack() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close2();
                setTaskName(4);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic(new String[]{"guaji.png","Hang up.png"});
                mFairy.onTap(0.8f, result, "挂机页面", 2000);

                result = mFairy.findPic(3,303,107,730,"daily.png");
                mFairy.onTap(0.8f, result, "日常", 2000);


                result1 = mFairy.findPic("activity2.png");
                result = mFairy.findPic(new String[]{"zhaohui.png","zhaohui2.png"});
                mFairy.onTap(0.8f, result, "一键找回", 2000);
                if(result.sim < 0.8f && result1.sim > 0.8f){
                    LtLog.e("没有一键找回结束");
                    setTaskEnd();return;
                }
                result = mFairy.findPic(new String[]{"top zhaohui.png","top zhaohui2.png"});
                if(result.sim > 0.8f){
                    setTaskName(2);return;
                }

            }
            public void content_2() throws Exception {
                if (overtime(15,0))return;
                mFairy.sleep(1500);
                result = mFairy.findPic(39,347,691,960,new String[]{"Free retrieval.png","Free retrieval2.png"});
                mFairy.onTap(0.8f, result, "免费找回", 2000);

                result1 = mFairy.findPic(new String[]{"no.png","temporary.png","temporary2.png"});
                if(result1.sim > 0.8f ){
                   LtLog.e("没有可以一键找回的结束任务");
                   setTaskEnd();return;
                }

                if (err == 14){
                    LtLog.e("没有可以一键找回的结束任务");
                    setTaskEnd();return;
                }
//                result = mFairy.findPic(39,347,691,960,"zhfub.png");//129,564  600,652
//                mFairy.onTap(0.8f, result, result.x+471,result.y+88,result.x+472,result.y+89,"副本任务找回", 2000);
//
//                result = mFairy.findPic(39,347,691,960,"zhjuq.png");//129,564  600,652
//                mFairy.onTap(0.8f, result, result.x+471,result.y+88,result.x+472,result.y+89,"剧情任务找回", 2000);


//                result = mFairy.findPic("auto jn.png");
//                // mFairy.onTap(0.8f, result, "自动缉拿", 2000);
//                result1 = mFairy.findPic("jina.png");
//                if(result1.sim > 0.8f && result.sim < 0.8f) {
//                    mFairy.onTap(0.8f, result1, 54,1084,64,1091,"自动缉拿", 2000);
//                }
//                result=mFairy.findMultiColor(222,822,284,874,0.9f,"8,134,52","-1|-6|8,134,52&0|-11|12,135,56&3|-14|12,135,56&8|-7|8,134,52&6|0|9,134,54");
//                LtLog.e("********"+result.sim);
//                if (result.sim > 0.8f){
//                    setTaskName(3);return;
//                }
            }

           /* public void content_3() throws Exception {
                if (overtime(3,5))return;

                result = mFairy.findPic(159,896,597,1007,"Challenge order2.png");
                mFairy.onTap(0.7f, result, "挑战令2", 2000);
                
                result = mFairy.findPic(new String[]{"guaji.png","Hang up.png"});
                mFairy.onTap(0.8f, result, "挂机页面", 2000);

                result = mFairy.findPic(3,303,107,730,"daily.png");
                mFairy.onTap(0.8f, result, "日常", 2000);

                result = mFairy.findPic("Challenge order.png");
                mFairy.onTap(0.8f, result, "挑战令", 2000);

                result = mFairy.findPic(159,896,597,1007,"Challenge order2.png");
                mFairy.onTap(0.7f, result, "挑战令2", 2000);

                result = mFairy.findPic(159,896,597,1007,"tzl.png");
                mFairy.onTap(0.8f, result, "挑战令vip", 2000);



            }*/
            public void content_4() throws Exception{
                if (overtime(6,5))return;
                result = mFairy.findPic("Receive awards Online.png");
                mFairy.onTap(0.8f, result, "在线领奖", 2000);

                result = mFairy.findPic("online lj.png");
                mFairy.onTap(0.8f, result, "在线领奖", 2000);

                result = mFairy.findPic("viponline.png");
                mFairy.onTap(0.8f, result, "在线领奖", 2000);

            }

            public void content_5() throws Exception{
                if (overtime(5,1))return;
                result = mFairy.findPic(new String[]{"guaji.png","Hang up.png"});
                mFairy.onTap(0.8f, result, "挂机页面", 2000);

                result = mFairy.findPic(3,303,107,730,"daily.png");
                mFairy.onTap(0.8f, result, "日常", 2000);

                /*result = mFairy.findPic("active.png");
                mFairy.onTap(0.8f, result, "活跃", 2000);*/

                result = mFairy.findPic("finis.png");
                mFairy.onTap(0.8f, result,260,936,268,944, "领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, 351,937,361,946,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, 442,941,451,949,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result,537,935,548,943, "领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, 630,937,642,944,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, "领取活跃值奖励", 1500);

                result = mFairy.findPic("dui.png");
                if (result.sim > 0.8f){
                    setTaskName(1);return;
                }
               /* mFairy.onTap(0.8f, result,result.x+144,result.y-44,result.x+145,result.y-43, "领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result,result.x+144,result.y-44,result.x+145,result.y-43, "领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, result.x+223,result.y-44,result.x+224,result.y-43,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, result.x+223,result.y-44,result.x+224,result.y-43,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, result.x+302,result.y-44,result.x+303,result.y-43,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, result.x+302,result.y-44,result.x+303,result.y-43,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result,result.x+380,result.y-44,result.x+381,result.y-43, "领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result,result.x+380,result.y-44,result.x+381,result.y-43, "领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, result.x+460,result.y-44,result.x+461,result.y-43,"领取活跃值奖励", 1500);
                mFairy.onTap(0.8f, result, result.x+460,result.y-44,result.x+461,result.y-43,"领取活跃值奖励", 1500);*/
            }
        }.taskContent(mFairy, "找回");
    }

    /**
     * 领奖
     *
     * @throws Exception
     */
    public void receive() throws Exception {
        new SingleTask(mFairy) {
            boolean hgfz =false;
            boolean xgkp =false;
            boolean xcyb =false;
            boolean kj =false;
            //boolean fyw =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("hgfz").equals("1")){
                  hgfz =true;
                }
                if (AtFairyConfig.getOption("xgkp").equals("1")){
                    xgkp =true;
                }
                if (AtFairyConfig.getOption("xcyb").equals("1")){
                    xcyb =true;
                }
                if (AtFairyConfig.getOption("kj").equals("1")){
                    kj =true;
                }
                int min  = mFairy.dateMinute();
                int hour = mFairy.dateHour();
                if (hgfz) {
                    if (hour >= 11 && hour < 13) {
                        hgfz=false;
                        timingActivity.palaceThief();
                    }
                }
                if (xcyb){
                    if (hour >= 19 && hour <20){
                        xcyb=false;
                        timingActivity.schoolField();
                    }
                }
                if (xgkp) {
                    if ((hour == 11 && min >= 55) || (hour == 19 && min >= 55)) {
                        xgkp=false;
                        timingActivity.turtleRun();
                    }
                }
                if (kj) {
                    if (hour >= 13 && hour < 21) {
                        kj=false;
                        timingActivity.examination();
                    }
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(8);return;
               // setTaskName(9);return;

            }
            public void content_1() throws Exception {
                if (overtime(3,2))return;
                result = mFairy.findPic("Main city.png");
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(new String[]{"email.png","email2.png","email3.png","email new.png"});
                mFairy.onTap(0.8f, result, "邮件", 2000);

                result = mFairy.findPic(new String[]{"email lq.png","email lq2.png"});
                mFairy.onTap(0.8f, result, "一键领取", 2000);

                result = mFairy.findPic("email del.png");
                mFairy.onTap(0.8f, result, "一键删除", 2000);
               // mFairy.onTap(0.8f, result, 641,1025,664,1047,"退出", 2000);
                if(result.sim > 0.8f){

                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(6,3))return;
                mFairy.sleep(1500);
                result = mFairy.findPic(new String[]{"Main city.png","Main city2.png"});
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic("Shopping Mall.png");
                mFairy.onTap(0.8f, result, "商城", 4000);

               // result1 = mFairy.findPic("three jie.png");
                result = mFairy.findPic(485,230,714,1093,new String[]{"receive.png","vipsanjie.png"});
                mFairy.onTap(0.8f, result, "领取", 2000);
                if (result.sim < 0.8f || err >=3 ){
                    result1 = mFairy.findPic(6,1118,715,1274,new String[]{"vipgift.png","rem.png","rem2.png"});
                    mFairy.onTap(0.8f, result1, "热门礼包", 2000);

                }
                result = mFairy.findPic(new String[]{"Admission.png","Admission2.png"});
                mFairy.onTap(0.8f, result, "免费", 2000);

                result = mFairy.findPic("jiangli.png");
                mFairy.onTap(0.7f, result, "获得奖励", 2000);

                result = mFairy.findPic(new String[]{"week mf.png","week mf2.png"});
                mFairy.onTap(0.8f, result, "每周免费", 2000);
                mFairy.onTap(0.8f, result, 121,558,131,565,"免费", 2000);

              /*  result = mFairy.findPic("over.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 660,1181,690,1216,"关闭", 2000);

                }*/

                if (err == 5){
                    gameUtil.close2();
                }

            }
            public void content_3() throws Exception {
                if (overtime(15,4))return;
                result1 =mFairy.findPic(476,955,715,1280,"close1.png");
                mFairy.onTap(0.8f,result1,"关闭",2000);

                result = mFairy.findPic(4,156,715,370,new String[]{"welfare.png","welfare2.png"});
                mFairy.onTap(0.8f, result, "福利大厅", 2000);

                result = mFairy.findPic(179,869,606,969,"experience.png");
                mFairy.onTap(0.8f, result, "领取经验", 2000);


             /*   result = mFairy.findPic("check mark.png");
                LtLog.e("***************"+result.sim);*/

                if (err > 5&& err <10){
                    result = mFairy.findPic(34,121,667,239,"Challenge order.png");
                    mFairy.onTap(0.8f, result, "挑战令", 2000);

                    result = mFairy.findPic(163,603,590,786,"Challenge order2.png");
                    mFairy.onTap(0.8f, result, "领取", 2000);

                    result = mFairy.findPic(163,603,590,786,"Challenge order3.png");
                    mFairy.onTap(0.8f, result, "没到时间", 2000);
                    mFairy.onTap(0.8f, result, 626,600,630,608,"没到时间", 2000);
                   /* if (result.sim > 0.8f){
                        err = 25;
                    }*/
                }
                if (err >= 10){
                    result = mFairy.findPic(35,115,574,247,new String[]{"accumulation.png","accumulation2.png","accumulation3.png"});
                    mFairy.onTap(0.7f, result, "千万富翁", 2000);
                }

                result1 = mFairy.findPic(new String[]{"leiji.png","leiji2.png"});
                result = mFairy.findPic(450,432,693,1044,new String[]{"jzhs lq.png","vipfuli.png"});
                mFairy.onTap(0.8f, result, "领取", 2000);
                if (result.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f, result1, 678,87,691,108,"关闭", 2000);
                    setTaskName(4);return;
                }
            }
            public void content_4() throws Exception {
                result1 = mFairy.findPic(240,75,348,133,"V.png");
                result = mFairy.findPic(4,156,715,370,"mone.png");
                mFairy.onTap(0.8f, result, "半月盛典", 2000);
                if (result.sim < 0.8f && result1.sim > 0.8f){
                   setTaskName(5);return;
                }
                result = mFairy.findPic(428,414,694,575,"jzhs lq.png");
                mFairy.onTap(0.8f, result, "领取", 2000);

                result = mFairy.findPic("banyue.png");
                mFairy.onTap(0.8f, result, "领取vip", 2000);

                result = mFairy.findPic(new String[]{"go1.png","go12.png"});
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 233,1066,260,1095,"取经之路", 2000);
                }

                result = mFairy.findPic(31,116,684,1001,new String[]{"red.png","red5.png"});
                mFairy.onTap(0.8f, result, result.x-40,result.y+40,result.x-39,result.y+41,"点宝箱", 2000);

                result = mFairy.findPic(167,563,544,792,new String[]{"banyue.png","jzhs lq.png"});
                mFairy.onTap(0.8f, result, "领取宝箱里面的", 2000);

                result = mFairy.findPic(172,1023,368,1129,"red.png");
                result1 = mFairy.findPic(172,1023,368,1129,new String[]{"zhilu.png","zhilu2.png"});
                if (result1.sim > 0.8f && result.sim < 0.8f){
                    mFairy.onTap(0.8f, result1, 685,108,698,124,"关闭取经之路", 2000);
                    setTaskName(5);return;
                }
            }
            public void content_5() throws Exception {
                result = mFairy.findPic("guaji2.png");
                mFairy.onTap(0.8f, result, "挂机页面", 2000);

                result = mFairy.findPic(new String[]{"thread.png","thread2.png","thread3.png"});
                mFairy.onTap(0.8f, result, "主线奖励", 2000);

                result = mFairy.findPic("zhuxianlingqu.png");
                mFairy.onTap(0.8f, result, "领取", 1000);

                result = mFairy.findPic(new String[]{"hang in the air.png","hang in the air2.png"});
                result1 = mFairy.findPic(397,143,671,352,"go therd.png");
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    result = mFairy.findPic(584,41,720,162,"cha.png");
                    mFairy.onTap(0.8f, result, "关闭", 2000);
                    if (result.sim > 0.8f) {
                        setTaskName(6);
                        return;
                    }
                }
            }
            public void content_6() throws Exception {
                result = mFairy.findPic("guaji2.png");
                mFairy.onTap(0.8f, result, "挂机页面", 2000);

                result = mFairy.findPic(1,277,116,663,"achievement.png");
                mFairy.onTap(0.8f, result, "成就", 2000);

                result = mFairy.findPic(43,222,673,772,"red.png");
                mFairy.onTap(0.8f, result, "成就", 2000);
//                result1 = mFairy.findPic("chengjiu.png");
//                if (result1.sim > 0.8f && result.sim < 0.8f){
//                    mFairy.onTap(0.8f, result1, 682,82,697,93,"关闭", 2000);
//                    setTaskName(7);return;
//                }
                result1 = mFairy.findPic(new String[]{"achievement2.png","achievement2vip.png"});
                result2 = mFairy.findPic(28,874,679,992,"Peach2.png");
                mFairy.onTap(0.8f, result2, "桃子", 2000);
                if (result.sim < 0.8f && result1.sim > 0.8f && result2.sim < 0.8f){
                    mFairy.onTap(0.8f, result1, 682,82,697,93,"关闭", 2000);
                    timekeepInit("任务循环");
                    setTaskName(7);return;
                }
                result = mFairy.findPic(32,799,716,985,"cjqu.png");
                mFairy.onTap(0.8f, result, "桃子领取", 2000);

                result = mFairy.findPic(484,300,674,449,"achievement lq.png");
                mFairy.onTap(0.8f, result, "领取", 2000);

                result = mFairy.findPic("viptaozi.png");
                mFairy.onTap(0.8f, result, "领取vip", 2000);

                result1 = mFairy.findPic(484,300,674,449,new String[]{"achievement qw.png","chengjiuqian.png"});
                if (result1.sim >= 0.8f){
                    mFairy.onTap(0.8f, result1, 661,101,673,117,"关闭", 2000);
                    //setTaskName(7);return;
                }

                result = mFairy.findPic("jiacai.png");
                result1 = mFairy.findPic(484,300,674,449,new String[]{"viptaozi.png","achievement lq.png"});
                if (result.sim >= 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(0.8f, result, 661,101,673,117,"关闭", 2000);
                    //setTaskName(7);return;
                }

            }
            public void content_7() throws Exception {
                int min  = mFairy.dateMinute();
                int hour = mFairy.dateHour();
               // boolean gj = ;//1200000
                if(timekeep(1,300000,"挂机")) {
                    result = mFairy.findPic(new String[]{"guaji.png", "Hang up.png"});
                    mFairy.onTap(0.8f, result, "挂机页面", 2000);
                    timekeepInit("挂机");
                }
              //  boolean zd =;//1200000
                if( timekeep(1,3000000,"自动挑战")){
                    result = mFairy.findPic("auto2.png");
                    mFairy.onTap(0.8f, result, "自动挑战", 2000);
                    timekeepInit("自动挑战");
                }
                LtLog.e("**************************************");
//                if (hour >= 13 && hour < 21){
//                    timingActivity.examination();
//                }
                if (timekeep(1,1200000,"任务循环")) {
                    LtLog.e("时间到 开始从开任务");
                    result = mFairy.findPic("open.png");
                    mFairy.onTap(0.8f, result, "关自动挑战", 2000);
                    if (AtFairyConfig.getOption("xhlt").equals("1")){
                        leitai();
                    }
                    if (AtFairyConfig.getOption("xhyb").equals("1")){
                        Escort();
                    }
                    if (AtFairyConfig.getOption("xhfy").equals("1")){
                        sealDemon();
                    }
                    if (AtFairyConfig.getOption("fyw").equals("1")){
                        sealDemonboss();
                    }
                    guard();

                    setTaskName(0);return;
                }
                if (hgfz) {
                    if (hour >= 11 && hour < 13) {
                        hgfz=false;
                        timingActivity.palaceThief();
                    }
                }
                if (xcyb){
                    if (hour >= 19 && hour <20){
                        xcyb=false;
                        timingActivity.schoolField();
                    }
                }
                if (xgkp) {
                    if ((hour == 11 && min >= 55) || (hour == 19 && min >= 55)) {
                        xgkp=false;
                        timingActivity.turtleRun();
                    }
                }
                if (kj) {
                    if (hour >= 13 && hour < 21) {
                        kj=false;
                        timingActivity.examination();
                    }
                }

                result = mFairy.findPic(62,799,531,948,new String[]{"complete.png","complete2.png","complete3.png"});
                mFairy.onTap(0.7f, result, "完成", 2000);

                result = mFairy.findPic(4,813,482,1017,"hand.png");//510,801 454,743
                mFairy.onTap(0.8f, result, result.x-56,result.y-58,result.x-55,result.y-57,"任务指导手下", 2000);

                result = mFairy.findPic("gjred.png");
                mFairy.onTap(0.8f, result, result.x-33,result.y+40,result.x-32,result.y+41,"地图", 2000);

                result = mFairy.findPic("go new map.png");
                mFairy.onTap(0.8f, result, "前往新地图", 2000);

                result = mFairy.findPic("xia.png");
                mFairy.onTap(0.8f, result, "下一章", 2000);

                result = mFairy.findPic(new String[]{"box map.png","box mapvip.png"});
                mFairy.onTap(0.8f, result, "地图宝箱", 2000);

                result = mFairy.findPic(new String[]{"skpvip.png","map lq.png"});
                mFairy.onTap(0.8f, result, "地图宝箱领取", 2000);
                mFairy.onTap(0.8f, result, 682,284,692,297,"地图宝箱领取wan叉", 2000);

                result = mFairy.findPic(34,402,665,842,"hand.png");//510,801 454,743
                mFairy.onTap(0.8f, result, result.x-56,result.y-58,result.x-55,result.y-57,"新地图", 2000);

                result = mFairy.findPic(219,704,496,909,"close hs.png");
                mFairy.onTap(0.8f, result, "关闭", 2000);

            }
            public void content_8() throws Exception {
                getBack();
                setTaskName(9);return;
            }
            public void content_9() throws Exception{
                if(overtime(15,1)){ gameUtil.close2();return;}
                result = mFairy.findPic("Main city.png");
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(new String[]{"gang.png"});
                mFairy.onTap(0.8f, result, "帮派", 2000);

                result = mFairy.findPic(new String[]{"gangjn.png"});
                mFairy.onTap(0.8f, result, "帮派技能", 2000);

                result = mFairy.findPic(new String[]{"shengji.png","svipsgengji.png","bangpaishengji.png"});
                mFairy.onTap(0.8f, result, "升级", 2000);

                result=mFairy.findMultiColor(355,961,377,989,0.9f,"155,147,196","1|-4|214,40,71&4|-11|212,44,75&6|-16|211,47,79&7|-18|205,57,91");
                LtLog.e("77777"+result.sim);
               if (result.sim >= 0.8f){
                    gameUtil.close2();
                    setTaskName(1);return;
                }
                result=mFairy.findMultiColor(331,955,395,992,0.9f,"173,114,158","2|-6|212,45,78&5|-13|204,60,94&6|-17|215,40,72&8|-20|179,103,145");
                LtLog.e("88888"+result.sim);
                if (result.sim >= 0.8f){
                    gameUtil.close2();
                    setTaskName(1);return;
                }
            }
        }.taskContent(mFairy, "领奖");
    }

    /**
     * 循环擂台
     *
     * @throws Exception
     */
    public void leitai() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic(new String[]{"Main city.png"});//,"Main city2.png";
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(new String[]{"leitai.png","leitai4.png"});
                mFairy.onTap(0.8f, result, "擂台", 2000);

                result = mFairy.findPic(new String[]{"leitai2.png","leitai3.png"});
                if(result.sim > 0.8f){
                    setTaskName(2);return;
                }
                result = mFairy.findPic(new String[]{"zijin.png","jingjiguan.png","jianhui.png"});
                if (result.sim > 0.8f){
                    mFairy.ranSwipe(77,1087,406,1095,1000,1000);
                }


            }
            public void content_2() throws Exception {


                result = mFairy.findPic(531,795,637,878,"recommend.png");
                mFairy.onTap(0.8f, result, result.x-80,result.y-100,result.x-79,result.y-99,"推荐", 2000);

                result = mFairy.findPic("huafei.png");
                mFairy.onTap(0.8f, result, 195,705,205,715,"取消", 2000);

                result = mFairy.findPic("zero.png");
                if(result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result = mFairy.findPic(new String[]{"leitai2.png","leitai3.png"});
                if(result.sim < 0.8f){
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "循环擂台");
    }

    /**
     * 押镖
     *
     * @throws Exception
     */
    public void Escort() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Escort.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(10,3))return;
                result = mFairy.findPic(new String[]{"Dart Silver.png","xuanze.png"});
                mFairy.onTap(0.8f, result, "选择镖银", 2000);

                result = mFairy.findPic(452,328,686,1039,new String[]{"biaolq.png","viplin.png","svipbiaolq.png","sviplingqu.png"});
                mFairy.onTap(0.8f, result, "领取", 2000);

                result = mFairy.findPic(29,493,696,761,new String[]{"svipbiaodan.png","vipbiaodan.png"});
                mFairy.onTap(0.8f, result, 202,713,220,725,"在想想", 2000);

                result = mFairy.findPic(458,206,674,950,new String[]{"jiebiao.png","vipbiao.png"});
                mFairy.onTap(0.8f, result, "接镖", 2000);

                result = mFairy.findPic(48,512,656,984,new String[]{"paiqian.png","paiqian2.png","vipyijian.png"});
                mFairy.onTap(0.8f, result, "派遣", 2000);
//                mFairy.onTap(0.8f, result, 506,875,516,882,"开始", 2000);
//                mFairy.onTap(0.8f, result, 660,359,672,374,"开始", 2000);
                result = mFairy.findPic(48,512,656,984,new String[]{"jiebiao2.png","vipqueren.png"});
                mFairy.onTap(0.8f, result, "确认接镖", 2000);

//                result = mFairy.findPic("transport.png");
//                if (result.sim > 0.8f ){
//                    gameUtil.close();
//                    setTaskEnd();return;
//                }

            }
            public void content_3() throws Exception {
                if (overtime(10,3))return;
                result = mFairy.findPic(39,211,219,270,new String[]{"biaoshi.png","biaoshi2.png"});
                mFairy.onTap(0.8f, result, "镖师", 2000);
                result = mFairy.findPic(397,342,687,1055,new String[]{"biaolingqu.png","biaolingqu2.png"});
                mFairy.onTap(0.8f, result, "领取", 2000);
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8}, 0, 342,945, 350,505, 2500, 2000);
                if (err == 9){
                    gameUtil.close2();
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "循环押镖");
    }

    /**
     * 循环封妖
     *
     * @throws Exception
     */
    public void sealDemon() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic(new String[]{"Main city.png","Main city2.png"});
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(205,893,694,1131,new String[]{"sealDemon.png","sealDemonvip.png","vipfengyao.png"});
                mFairy.onTap(0.8f, result, "封妖主城", 2000);

                result = mFairy.findPic(23,1055,686,1138,"svipfy.png");
                mFairy.onTap(0.8f, result, "封妖按钮", 2000);

                result = mFairy.findPic(new String[]{"sealDemon2.png","sealDemon2vip.png"});
                mFairy.onTap(0.8f, result, "封妖界面", 2000);
                if(result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(497,186,683,937,"Seal.png");
                mFairy.onTap(0.8f, result, "前往封印", 2000);

                result = mFairy.findPic(new String[]{"Refresh.png","Refresh2.png"});
                mFairy.onTap(0.8f, result, "复活一个", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic(99,528,404,655,new String[]{"buy.png","viphuafei.png","vipover.png"});
                mFairy.onTap(0.8f, result, 191,709,216,721,"取消", 2000);
                if (result.sim > 0.8f){
                   // gameUtil.close();
                   // setTaskName(3);return;
                    setTaskEnd();return;
                }
                result = mFairy.findPic(205,893,694,1131,new String[]{"sealDemon.png","sealDemonvip.png","vipfengyao.png"});
                if (result.sim > 0.8f){
                     setTaskName(1);return;
                }
            }
            public void content_3() throws Exception {
                result = mFairy.findPic(23,1055,686,1138,new String[]{"Demon King.png","Demon King2.png"});
                mFairy.onTap(0.8f, result, "封印妖王", 2000);

                result = mFairy.findPic("gofy.png");
                mFairy.onTap(0.8f, result, "前往封印", 2000);

                result = mFairy.findPic("feng.png");
                mFairy.onTap(0.8f, result, "封印", 2000);

                result = mFairy.findPic(new String[]{"yaowang.png","Not refreshed.png","Not refreshed2.png","fengyin.png","fengyin2.png"});
                if (result.sim > 0.8f){
                    gameUtil.close();
                   // timekeepInit("任务循环");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("rob.png");
                mFairy.onTap(0.8f, result, 640,1013,654,1024,"抢夺归属叉", 2000);
            }
        }.taskContent(mFairy, "循环封妖");
    }

    /**
     *  封印妖王
     *
     * @throws Exception
     */
    public void sealDemonboss() throws Exception {
        new SingleTask(mFairy) {
            int num = 0;
            int jc = 0;
            List<FindResult> findResults;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic("Main city.png");
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(205,893,694,1131,new String[]{"sealDemon.png","sealDemonvip.png","vipfengyao.png"});
                mFairy.onTap(0.8f, result, "封妖主城", 2000);

                result = mFairy.findPic(23,1055,686,1138,new String[]{"Demon King.png","Demon King2.png"});
                mFairy.onTap(0.8f, result, "封妖按钮", 2000);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }

            }
            public void content_2() throws Exception{
                if (overtime(10,3))return;
                result = mFairy.findPic(new String[]{"50ji.png","50ji2.png"});
                if (result.sim < 0.8f){
                    LtLog.e("初始化滑动");
                    mFairy.ranSwipe(310,588,606,599,500,500);
                }else {
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception {
                result = mFairy.findPic("speed.png");
                if (result.sim > 0.8f){
                    jc = 0;
                    LtLog.e("正在战斗中。。。");
                    return;
                }
               // mFairy.taskSlid(err,new int[]{0,5,10,15,20},4,606,599,310,588,2000,1500);
              //  if (overtime(25,0))return;
                if (jc ==0) {
                    mFairy.sleep(1000);
                    mFairy.condit();
                    findResults = mFairy.findPic(49, 201, 679, 818, 0.9f, "dengji.png");
                    LtLog.e("初始数量" + findResults.size());
                    jc = findResults.size();
                    num = findResults.size();
                }
                if (findResults.size() == 0){

                }else {
                    result1 = mFairy.findPic(findResults.get(0).x - 104, findResults.get(0).y - 122, findResults.get(0).x + 21, findResults.get(0).y + 28, new String[]{"escape.png", "Seal2.png", "weijiesuo.png"});
                    if (result1.sim > 0.7f) {
                        LtLog.e("这只妖怪已经被打了");
                        findResults.remove(0);
                    } else {
                        mFairy.onTap(0.8f, findResults.get(0),
                                findResults.get(0).x - 7, findResults.get(0).y - 40, findResults.get(0).x - 6, findResults.get(0).y - 39,
                                "选择妖怪", 2000);
                        result = mFairy.findPic("gofy.png");
                        mFairy.onTap(0.8f, result, "前往封印", 2000);

                        result = mFairy.findPic("feng.png");
                        mFairy.onTap(0.8f, result, "封印", 2000);

                        result = mFairy.findPic("rob.png");
                        mFairy.onTap(0.8f, result, 640, 1013, 654, 1024, "抢夺归属叉", 2000);

                        result = mFairy.findPic("yaowang.png");
                        if (result.sim > 0.8f) {
                            num--;
                            findResults.remove(0);
                            mFairy.onTap(0.8f, result, 665, 376, 674, 382, "叉", 2000);
                            mFairy.onTap(0.8f, result, 662, 145, 675, 154, "叉", 2000);
                        }
                        result = mFairy.findPic(new String[]{"Not refreshed.png", "Not refreshed2.png"});
                        if (result.sim > 0.8f) {
//                        gameUtil.close2();
//                        setTaskEnd();return;
                            findResults.remove(0);
                        }
                        if (mFairy.findPic(new String[]{"fengyin.png", "fengyin2.png"}).sim > 0.8f) {
                            gameUtil.close2();
                            setTaskEnd();
                            return;
                        }

                    }
                }

                jc = findResults.size();
                if (jc == 0){
                    LtLog.e("滑动一次找怪");
                    mFairy.ranSwipe(606,599,506,588,2000,1500);
                    mFairy.sleep(2000);
                }

                result = mFairy.findPic("300ji.png");
                if (result.sim > 0.8f){
                    LtLog.e("找到300级");
                    gameUtil.close2();
                    setTaskEnd();return;
                }
                if (num <= 0){
                    LtLog.e("全都是要花道具的boss  结束");
                    gameUtil.close2();
                    setTaskEnd();return;
                }
                //result = mFairy.findPic("speed.png");
            }
        }.taskContent(mFairy, "循环封妖王");
    }

    /**
     * 帮派守护兽（循环）
     *
     * @throws Exception
     */
    public void guard() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic(new String[]{"Main city.png","Main city2.png"});
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(new String[]{"tongmeng.png","gang.png"});
                mFairy.onTap(0.8f, result, "帮派", 2000);

                result = mFairy.findPic("bangpai2.png");
                mFairy.onTap(0.8f, result, "帮派2", 2000);

                result = mFairy.findPic("gang2.png");
                mFairy.onTap(0.8f, result, "帮派地图", 2000);

                result = mFairy.findPic(new String[]{"Animal room.png"});
                mFairy.onTap(0.8f, result, "兽室", 2000);
                if(result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去 直接结束");
                    gameUtil.close();
                    setTaskEnd();return;
                }

                result = mFairy.findPic(new String[]{"train one.png","vipxulian.png"});
                mFairy.onTap(0.8f, result, "训练一次", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic(69,521,358,679,new String[]{"no number.png","no number2.png","vipnum.png"});
                if(result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, 191,714,204,722,"没有次数了", 2000);
                    //  LtLog.e("打不过去 直接结束");
                    gameUtil.close();
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "循环守护兽");
    }


    /**
     * 任务链
     *
     * @throws Exception
     */
    public void taskChain() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission("Task chain.png",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去");
                    setTaskEnd();return;
                }
                result = mFairy.findPic(168,78,675,196,"red3.png");
                mFairy.onTap(0.8f, result, result.x-30,result.y+15,result.x-29,result.y+16,"任务链宝箱", 2000);
                mFairy.onTap(0.8f, result, 353,804,375,819,"领取", 2000);

                result = mFairy.findPic(new String[]{"draw.png","viprwl.png"});
                mFairy.onTap(0.8f, result, "领取任务链", 2000);

                result = mFairy.findPic("I go now.png");
                mFairy.onTap(0.8f, result, "我这就去", 2000);

                result = mFairy.findPic(491,1060,702,1146,"Challenge line.png");
                mFairy.onTap(0.8f, result, "挑战", 2000);

                result = mFairy.findPic("Fighting Legends.png");
                mFairy.onTap(0.8f, result, "打传说", 2000);

                result = mFairy.findPic(492,1064,696,1145,"jzhs lq.png");
                mFairy.onTap(0.8f, result, "领取", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic(437,64,713,124,new String[]{"task line.png","task line2.png"});
                result1 = mFairy.findPic(new String[]{"task huan.png","task huan2.png"});
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    setTaskName(0);return;
                }

            }
        }.taskContent(mFairy, "任务链");
    }

    /**
     * 神器任务
     *
     * @throws Exception
     */
    public void shq() throws Exception {
        new SingleTask(mFairy) {
            boolean ad = true;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                int ret = gameUtil.mission2("Artifact.png","",0);
                if (ret ==1) {
                    setTaskName(2);return;
                }else {
                    LtLog.e("任务已完成或者没有该任务结束");
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(15,0))return;
                if (ad) {
                    result = mFairy.findPic("shenqi.png");
                    mFairy.onTap(0.8f, result, 100, 1000, 111, 1010, "第一个", Sleep);
                    mFairy.onTap(0.8f, result, 128, 908, 135, 913, "第一个开始", Sleep);
                }else {
                    result = mFairy.findPic("shenqi.png");
                    mFairy.onTap(0.8f, result, 239,1007,253,1014, "第二个", Sleep);
                    mFairy.onTap(0.8f, result, 128, 908, 135, 913, "第二个开始", Sleep);
                }


                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);
                if(result.sim > 0.8f){
                    ad =false;
                }
                result = mFairy.findPic("tongguan.png");
                if (result.sim > 0.8f){
                    ad =false;
                }
                result1 = mFairy.findPic("su.png");
                if (result1.sim > 0.8f){
                    err=0;
                }

            }
        }.taskContent(mFairy, "神器任务");
    }

    /**
     * 竞技商店购买
     *
     * @throws Exception
     */
    public void jjgm() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                if (overtime(15,99))return;
                result = mFairy.findPic("Main city.png");
                mFairy.onTap(0.8f, result, "主城页面", 2000);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("shanghui.png");
                mFairy.onTap(0.8f, result, "商会", 2000);

                result = mFairy.findPic("jjshop.png");
                mFairy.onTap(0.8f, result, "竞技商店", 2000);

                result = mFairy.findPic("taishang.png");
                mFairy.onTap(0.8f, result, "擂台商店", 2000);

                result = mFairy.findPic("buy2.png");
                mFairy.onTap(0.8f, result, "一键购买", 2000);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("yes1.png");
                mFairy.onTap(0.8f, result, "一键购买确定", 2000);
                if (result.sim > 0.8f){
                    err=0;
                }

            }

        }.taskContent(mFairy, "竞技商店购买");
    }

    /**
     * 妖界入侵
     *
     * @throws Exception
     */
    public void demonWorld() throws Exception {
        new SingleTask(mFairy) {
            int num = 0;
            boolean sd = true;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic("juqing.png");
                if (result.sim >0.8f){

                }else {
                    result = mFairy.findPic(new String[]{"Main city.png"});
                    mFairy.onTap(0.8f, result, "主城页面", 2000);
                }
                result = mFairy.findPic(205,893,694,1131,new String[]{"sealDemon.png","sealDemonvip.png","vipfengyao.png"});
                mFairy.onTap(0.8f, result, "封妖", 2000);

                result = mFairy.findPic(23,1055,686,1138,new String[]{"Demon world.png","Demon worldvip.png"});
                mFairy.onTap(0.8f, result, "妖界入侵", 2000);
                if (result.sim < 0.8f){
                    LtLog.e(mFairy.getLineInfo("滑动一次"));
                    mFairy.ranSwipe(555,1093,234,1090,1000,1000);
                }

                result = mFairy.findPic(new String[]{"Demon world2.png","Demon world2vip.png"});
                if(result.sim > 0.8f){
                    setTaskName(3);return;
                }
            }
            public void content_2() throws Exception {
              /*  mFairy.sleep(1500);
                result = mFairy.findPic("fail.png");
                if(result.sim > 0.8f){
                    LtLog.e("打不过去");
                   setTaskName(3);
                }

//                result = mFairy.findPic(new String[]{"fuben.png","fuben2.png"});
//                mFairy.onTap(0.8f, result, "副本", 2000);
                result1 = mFairy.findPic("su.png");
                result = mFairy.findPic(600,94,707,1036,"red yao.png");
                mFairy.onTap(0.8f, result, result.x-130,result.y+70,result.x-129,result.y+71,"副本", 2000);
                if (result.sim < 0.8f && result1.sim < 0.7f){
                    num++;
                    mFairy.ranSwipe(304,616,330,262,2000,2000);
                }
                if (num >=3){
                    setTaskEnd();return;
                }
                LtLog.e("*********"+num);
                result = mFairy.findPic(177,817,609,1065,new String[]{"engage.png","engage2.png"});
                mFairy.onTap(0.8f, result, "前往迎敌", 2000);

                result = mFairy.findPic("yaojietiaoz.png");
                mFairy.onTap(0.8f, result, "挑战", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic(new String[]{"ling.png"});
                mFairy.onTap(0.8f, result, 194,711,206,719,"取消", 2000);
                if (result.sim > 0.8f){
                     //gameUtil.close();
                   //setTaskEnd();return;
                }
                result = mFairy.findPic(177,817,609,1065,new String[]{"zero4.png"});
                mFairy.onTap(0.8f, result, 669,165,677,172,"关闭", 2000);*/
            }
            public void content_3() throws Exception {

                result = mFairy.findPic(87,192,693,295,new String[]{"Mop up.png"});
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f, result, result.x-2,result.y+40,result.x-1,result.y+41,"点击可以扫荡的副本", 2000);
                }else {
                    mFairy.ranSwipe(233,249,373,251,1000,1500);
                }

                result = mFairy.findPic(new String[]{"Mop up2.png","Mop up3.png"});
                mFairy.onTap(0.8f, result, "扫荡", 1000);

                result = mFairy.findPic("lq.png");
                mFairy.onTap(0.8f, result, "领取", 2000);

                result = mFairy.findPic("tipk.png");
                mFairy.onTap(0.8f, result, "跳过", 2000);

                result = mFairy.findPic("neverling.png");
                mFairy.onTap(0.8f,result,194,708,206,723,"没有令牌了",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result = mFairy.findPic("ling2.png");
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
//                result = mFairy.findPic(new String[]{"ling.png"});
//                mFairy.onTap(0.8f, result, 194,711,206,719,"取消", 2000);
//                if (result.sim > 0.8f){
//                    //gameUtil.close();
//                    //setTaskEnd();return;
//                }
             /*   result = mFairy.findPic(177,817,609,1065,new String[]{"zero4.png"});
                mFairy.onTap(0.8f, result, 669,165,677,172,"关闭", 2000);
                if (result.sim >0.8f){
                    setTaskName(2);return;
                }
                result = mFairy.findPic("greysd.png");
                mFairy.onTap(0.8f, result, 669,165,677,172,"关闭", 2000);
                if (result.sim >0.8f){
                    setTaskName(2);return;
                }*/
            }

        }.taskContent(mFairy, "妖界入侵");
    }

    /**
     * 小试牛刀
     *
     * @throws Exception
     */
    public void knife() throws Exception {
        new SingleTask(mFairy) {
            int num = 5;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);return;

            }
            public void content_1() throws Exception {
                result = mFairy.findPic(new String[]{"Main city.png","Main city2.png"});
                mFairy.onTap(0.8f, result, "主城页面", 2000);

                result = mFairy.findPic(7,158,672,393,new String[]{"knife.png","niudao.png"});
                mFairy.onTap(0.8f, result, "小试牛刀", 2000);

                result = mFairy.findPic(new String[]{"knife2.png"});
                if(result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1500);
                result = mFairy.findPic(7,158,672,393,new String[]{"knife.png","niudao.png"});
                mFairy.onTap(0.9f, result, "小试牛刀", 2000);

                result = mFairy.findPic(631,56,716,129,"gc.png");
                mFairy.onTap(0.8f, result, "关叉", 100);

                result = mFairy.findPic(453,910,685,1042,new String[]{"vip mianfei.png","knifetz.png","vip niudao.png"});
                mFairy.onTap(0.8f, result, "挑战", 2000);

                result = mFairy.findPic("yaojietiaoz.png");
                mFairy.onTap(0.8f, result, "挑战", 2000);

                result = mFairy.findPic("knifesl.png");
                mFairy.onTap(0.8f, result, 319,842,333,850,"胜利", 2000);
               if (result.sim > 0.8f){
                   num--;
               }
                result = mFairy.findPic("knifesl2.png");
                mFairy.onTap(0.8f, result, 316,988,334,1003,"胜利", 2000);
                if (result.sim > 0.8f){
                    num--;
                }
                if (num <=0){
                    gameUtil.close();
                    setTaskEnd();return;
                }
                result = mFairy.findPic("neverling.png");
                mFairy.onTap(0.8f,result,194,708,206,723,"没有令牌了",Sleep);
                if (result.sim > 0.8f){

                    setTaskEnd();return;
                }

                result = mFairy.findPic("niudaoover.png");
                if (result.sim > 0.8f){
                    LtLog.e("展示中 不在挑战时间结束任务");
                    gameUtil.close();
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "小试牛刀");
    }

    public void taskSlidme(int initSlidCount, int x, int y, int x1, int y1, int moveSleep, long stopSleep) throws Exception {
        int i;
        for(i = 0; i < initSlidCount; ++i) {
            LtLog.e(mFairy.getLineInfo("taskSlid初始化滑动>>>"));
            mFairy.ranSwipe( x, y,x1, y1, moveSleep, stopSleep);
        }
    }
}