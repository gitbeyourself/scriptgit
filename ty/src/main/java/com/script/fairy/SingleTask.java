package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    GameUtil gameUtil;

    YxdUtil yxdUtil_1;
    YxdUtil yxdUtil_2;
    YxdUtil yxdUtil_3;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        Sleep = 100;
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);
        yxdUtil_1 = new YxdUtil(mFairy);
        yxdUtil_2 = new YxdUtil(mFairy);
        yxdUtil_3 = new YxdUtil(mFairy);
    }

    @Override
    public void inOperation() throws Exception {


    }
    /**
     * 新手指引（主线任务）
     *
     * @throws Exception
     */
    public void plotTask() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public void content_1() throws Exception {
                result = mFairy.findPic(867,526,1071,648,"next.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);

                result = mFairy.findPic(new String[]{"class.png","activity.png"});
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result = mFairy.findPic(58,120,144,234,new String[]{"line.png","yuan.png"});
                mFairy.onTap(0.8f,result,"主线",Sleep);

                result = mFairy.findPic("name.png");
                mFairy.onTap(0.8f,result,"确认姓名",Sleep);

                result = mFairy.findPic("over3.png");
                mFairy.onTap(0.8f,result,"完成",Sleep);

                result = mFairy.findPic("line yes.png");
                mFairy.onTap(0.8f,result,"确认",Sleep);

                result = mFairy.findPic(60,193,231,278,new String[]{"faer.png","collect.png","King crab.png","Rascal.png","Hualing.png"});//"copy.png"
                if (result.sim > 0.8f){
                    mFairy.onTap(1021,652,1028,659,"技能1",1500);
                    mFairy.onTap(1002,557,1010,565,"技能2",1500);
                    mFairy.onTap(1033,464,1041,473,"技能3",1500);
                    mFairy.onTap(1125,427,1135,438,"技能4",1500);
                    for (int i =0 ; i < 10; i++)
                    mFairy.onTap(1121,555,1135,564,"攻击",Sleep);
                }


                result = mFairy.findPic("win.png");
                mFairy.onTap(0.8f,result,"打赢所有冒险家",Sleep);

                result = mFairy.findPic("camera.png");
                mFairy.onTap(0.8f,result,"照相机",Sleep);

                result = mFairy.findPic("download.png");
                mFairy.onTap(0.8f,result,1115,87,1125,100,"叉",Sleep);

                result = mFairy.findPic("information.png");
                mFairy.onTap(0.8f,result,"确认信息",Sleep);

                result = mFairy.findPic("continue2.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result = mFairy.findPic("lovely.png");
                mFairy.onTap(0.8f,result,"可爱得骆驼",Sleep);

                result = mFairy.findPic("submit2.png");
                mFairy.onTap(0.8f,result,"提交",Sleep);

                result = mFairy.findPic("map.png");
                mFairy.onTap(0.8f,result,71,50,79,62,"关地图",Sleep);

                result = mFairy.findPic("Ring the bell.png");
                mFairy.onTap(0.8f,result,1117,549,1140,561,"敲钟",Sleep);

                result = mFairy.findPic(new String[]{"hua.png","Star River.png"});
                if (result.sim > 0.8f){
                    mFairy.ranSwipe(521,183,516,538,1000,1000);
                    mFairy.ranSwipe(516,181,716,367,1000,1000);
                    mFairy.ranSwipe(768,174,558,370,1000,1000);
                    mFairy.ranSwipe(763,179,751,553,1000,1000);
                    mFairy.onTap(1203,614,1215,628,"完成",3000);
                }

                result = mFairy.findPic("Resurrection in place.png");
                mFairy.onTap(0.8f,result,"原地复活",Sleep);
                mFairy.onTap(0.8f,result,720,489,736,507,"确定",Sleep);


                result = mFairy.findPic(854,456,1098,631,"lovely.png");
                mFairy.onTap(0.8f,result,"并不值得",Sleep);

                result = mFairy.findPic(1034,549,1226,631,"over3.png");
                mFairy.onTap(0.8f,result,"完成",Sleep);

                result = mFairy.findPic("Chance.png");
                mFairy.onTap(0.8f,result,620,470,645,492,"机缘",Sleep);

                result = mFairy.findPic("Free creation.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(1039,222,1048,237,"++",500);
                    mFairy.onTap(160,155,174,168,"1",1500);
                    mFairy.onTap(273,162,280,173,"2",1500);
                    mFairy.onTap(63,261,76,273,"3",1500);
                    mFairy.onTap(168,265,177,274,"4",1500);
                    mFairy.onTap(274,253,286,262,"5",1500);
                    mFairy.onTap(67,355,78,366,"6",1500);
                    mFairy.onTap(1109,625,1125,638,"7",3000);
                    //mFairy.onTap(1125,427,1135,438,"8",1500);
                }


                result = mFairy.findPic(66,129,150,319,"yin.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }



            }

            public void content_2() throws Exception {
                result1 = mFairy.findPic(58,120,144,234,"line.png");
                result = mFairy.findPic(66,129,150,319,"yin.png");
                mFairy.onTap(0.8f,result,"引导任务",2500);
                if (result.sim < 0.8f&& result1.sim > 0.8f){
                    setTaskName(1);return;
                }
                result = mFairy.findPic("open fly.png");
                mFairy.onTap(0.8f,result,1238,413,1246,426,"展开翅膀",Sleep);

                result = mFairy.findPic(867,526,1071,648,"next.png");
                mFairy.onTap(0.8f,result,"下一步",Sleep);


                result = mFairy.findPic("there.png");
                mFairy.onTap(0.8f,result,1121,516,1132,527,"起飞",Sleep);

                result = mFairy.findPic("receive3.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result = mFairy.findPic(854,456,1098,631,"lovely.png");
                mFairy.onTap(0.8f,result,"并不值得",Sleep);


               /* result = mFairy.findPic("Black Dragon.png");//"copy.png"
                if (result.sim > 0.8f){
                    mFairy.onTap(1021,652,1028,659,"技能1",1500);
                    mFairy.onTap(1002,557,1010,565,"技能2",1500);
                    mFairy.onTap(1033,464,1041,473,"技能3",1500);
                    mFairy.onTap(1125,427,1135,438,"技能4",1500);
                    for (int i =0 ; i < 10; i++)
                        mFairy.onTap(1121,555,1135,564,"攻击",Sleep);
                }*/


                result = mFairy.findPic("Withdraw .png");
                mFairy.onTap(0.8f,result,"退出战场",Sleep);

               /* /* result = mFairy.findPic("yin.png");
                mFairy.onTap(0.8f,result,"引导任务",Sleep);

                result = mFairy.findPic("yin.png");
                mFairy.onTap(0.8f,result,"引导任务",Sleep);

                result = mFairy.findPic("yin.png");
                mFairy.onTap(0.8f,result,"引导任务",Sleep);
                result = mFairy.findPic("yin.png");
                mFairy.onTap(0.8f,result,"引导任务",Sleep);
                result = mFairy.findPic("yin.png");
                mFairy.onTap(0.8f,result,"引导任务",Sleep);
*/










            }

        }.taskContent(mFairy, "新手指引");
    }


    /**
     * 神语之试
     *
     * @throws Exception
     */
    public void syzs() throws Exception {
        new SingleTask(mFairy) {

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public void content_1() throws Exception {
                int re = gameUtil.mission("ShenYu.png",0);

                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }

            }

            public void content_2() throws Exception {
                result = mFairy.findPic(560,148,858,324,"tuodao.png");
                if (result.sim > 0.7f){

                    mFairy.ranSwipe(473,494,687,184,1500,2000);

                    mFairy.ranSwipe(827,496,687,265,1500,1500);

                }
                result = mFairy.findPic("queren.png");
                mFairy.onTap(0.8f,result,"确认提交",Sleep);
                gameUtil.srAIAnswer();

                result = mFairy.findPic("over.png");
                mFairy.onTap(0.8f,result,632,492,640,505,"确定",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "神语之试");
    }

    /**
     * 万事屋
     *
     * @throws Exception
     */
    public void wsw() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result1 = mFairy.findPic("task2.png");
                mFairy.onTap(0.8f,result1,"任务栏",2000);
                result1 = mFairy.findPic("richang.png");
                mFairy.onTap(0.8f,result1,"日常",2000);

                result1 = mFairy.findPic(67,127,293,233,"WAnShiWu.png");
                mFairy.onTap(0.8f,result1,"左侧任务栏",2000);
                if (result1.sim<0.8f) {
                    int re = gameUtil.mission("WanShi.png", 0);
                    if (re == 1) {
                        setTaskName(2);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }else {
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                long  datetinme = mFairy.mMatTime(1176,137,24,9,0.9f);
                result = mFairy.findPic("jump.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);

                result1 = mFairy.findPic("richang.png");
                mFairy.onTap(0.8f,result1,"日常",2000);

                result = mFairy.findPic("complete.png");
                mFairy.onTap(0.8f,result,"提交任务",Sleep);

                result = mFairy.findPic("Firefly.png");
                mFairy.onTap(0.8f,result,1213,47,1226,57,"萤火",1000);

                result2 = mFairy.findPic(new String[]{"dialogue.png","task.png","dialogue2.png"});
                mFairy.onTap(0.8f,result2,"接任务",Sleep);

                result1 = mFairy.findPic(67,127,293,233,"WAnShiWu.png");
                mFairy.onTap(0.8f,result1,"左侧任务栏",2000);

                result = mFairy.findPic("tong.png");
                if(result.sim > 0.8f){
                   mFairy.ranSwipe(200,549,309,671,2500,1500);
                }

                if (result1.sim < 0.8f&&datetinme>30){
                    setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "万事屋");
    }


    /**
     * 商会任务
     *
     * @throws Exception
     */
    public void shrw() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("ShangHui4.png");
                if (result.sim > 0.8f){
                    setTaskName(2);
                    return;
                }else {
                    int re = gameUtil.mission("ShangHui.png", 0);
                    if (re == 1) {
                        setTaskName(2);
                        return;
                    } else {
                        setTaskEnd();
                        return;
                    }
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("jump.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);

                result = mFairy.findPic(67,127,293,233,"ShangHui4.png");
                mFairy.onTap(0.8f,result,"左侧任务栏",Sleep);
                if (result.sim < 0.8f) {
                    result = mFairy.findPic(new String[]{"ShangHui2.png", "ShangHui3.png"});
                    mFairy.onTap(0.8f, result, "接任务", Sleep);
                }
                result = mFairy.findPic(898,433,1120,498,"submit.png");
                mFairy.onTap(0.8f,result,"提交",Sleep);
                if (result.sim > 0.8f){
                    err =0;
                }
                result = mFairy.findPic("submit over.png");
                mFairy.onTap(0.8f,result,1015,595,1025,603,"完成",Sleep);

                result = mFairy.findPic("shyes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result = mFairy.findPic("yunbi.png");
                if (result.sim > 0.8f){
                    LtLog.e("云币不足 结束");
                    setTaskEnd();return;
                }

                if (overtime(10,0))return;
            }

        }.taskContent(mFairy, "商会任务");
    }

    /**
     * 工会建设
     *
     * @throws Exception
     */
    public void ghjs() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("GongHui.png",0);
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                long datetime = mFairy.mMatTime(1191,128,22,6,0.9f);
                result = mFairy.findPic("jump.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);

                result = mFairy.findPic(57,115,286,226,"rcxc.png");
                if (result.sim > 0.7f) {
                    //setTaskName(0);return;

                }else {
                    result = mFairy.findPic(57,115,286,226,new String[]{"day.png","day2.png"});
                    mFairy.onTap(0.8f, result, "左侧任务栏", 2000);
                }
              /*  result = mFairy.findPic("introduction.png");*/
                if (datetime >60 ){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("accept.png");
                mFairy.onTap(0.8f, result, "接任务", Sleep);

                result = mFairy.findPic("wancheng3.png");
                mFairy.onTap(0.8f, result, "完成", Sleep);

                result = mFairy.findPic(386,137,929,573,"hand.png");
                mFairy.onTap(0.8f, result, "薅羊毛挤牛奶", 6000);

                result = mFairy.findPic("hand2.png");
                mFairy.onTap(0.8f, result, "薅羊毛挤牛奶", 6000);

                result = mFairy.findPic("Received.png");
                mFairy.onTap(0.8f,result,57,23,65,29,"已接取",Sleep);

                result = mFairy.findPic("submit over.png");
                mFairy.onTap(0.8f,result,1015,595,1025,603,"完成",Sleep);

                result = mFairy.findPic("five star.png");
                mFairy.onTap(0.8f,result,"互动按钮",5000 );

                result = mFairy.findPic("conversation.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,44,22,54,30,"贩卖机无法自动购买结束",Sleep);
                    setTaskEnd();return;
                }
                result = mFairy.findPic("group photo.png");
                if (result.sim > 0.8f){
                    LtLog.e("合影");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("zhudi.png");
                mFairy.onTap(0.8f,result,79,54,87,62,"叉",1000 );

                result1 = mFairy .findPic("time.png");
                result = mFairy .findPic("eye.png");
                if (result.sim > 0.8f&&result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result,1214,46,1228,60,"无法自动做的任务结束",Sleep);
                    setTaskEnd();return;
                }

               // if (overtime(10,0))return;
            }

        }.taskContent(mFairy, "工会建设");
    }


    /**
     * 门派比武
     *
     * @throws Exception
     */
    public void mpbw() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("MenPai.png",2);
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {

                long datetime = mFairy.mMatTime(1191,128,22,6,0.9f);
                if (datetime>60){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("matching.png");
                mFairy.onTap(0.8f,result,"开始匹配",Sleep);

                result = mFairy .findPic("delivery.png");
                mFairy.onTap(0.8f,result,731,489,740,496,"确定传送",Sleep);

                result = mFairy.findPic("Challenge.png");
                mFairy.onTap(0.8f, result, "挑战", Sleep);

                result = mFairy.findPic("biwu.png");
               if(result.sim > 0.8f){
                   mFairy.onTap(1123,551,1130,557,"技能",Sleep);
                   mFairy.onTap(1021,646,1029,655,"技能",Sleep);
                   mFairy.onTap(996,556,1009,565,"技能",Sleep);
                   mFairy.onTap(1028,467,1043,480,"技能",Sleep);
                   mFairy.onTap(1121,429,1136,438,"技能",Sleep);
                   mFairy.onTap(1223,436,1233,448,"技能",Sleep);



               }

                result = mFairy.findPic("Challenge agin.png");
                mFairy.onTap(0.8f,result,"再次挑战",Sleep);

                result = mFairy.findPic("zengjia.png");
                mFairy.onTap(0.8f,result,526,498,539,506,"取消",Sleep);
                mFairy.onTap(0.8f,result,476,644,486,650,"确定",Sleep);
                if(result.sim> 0.8f){
                    setTaskEnd();return;
                }
                // if (overtime(10,0))return;
            }
        }.taskContent(mFairy, "门派比武");
    }

    /**
     * 青麟之野
     *
     * @throws Exception
     */
    public void qlzy() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int re = gameUtil.mission("QingLin.png",1);
                if (re == 1){
                    setTaskName(2);
                    return;
                }else {
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("receive2.png");
                mFairy.onTap(0.8f,result,"领取奖励",Sleep);

                result = mFairy.findPic("begintz.png");
                mFairy.onTap(0.8f, result, "开始挑战", Sleep);

                result = mFairy.findPic("begintz2.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result = mFairy.findPic("close2.png");
                mFairy.onTap(0.8f,result,"宠物开启自动释放技能",Sleep);

                result = mFairy.findPic("auto.png");
                mFairy.onTap(0.8f,result,"开启自动",Sleep);

                result = mFairy.findPic(624,364,920,642,"stjx.png");
                mFairy.onTap(0.8f,result,"继续",Sleep);

                result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f,result,"确认选择",Sleep);

                result = mFairy.findPic("Optional.png");
                mFairy.onTap(0.8f,result,491,342,505,352,"组选sr",Sleep);
                mFairy.onTap(0.8f,result,633,495,647,504,"组选sr",Sleep);

                result = mFairy.findPic("watches.png");
                if(result.sim < 0.8f){
                    mFairy.ranSwipe(200,555,202,354,4000,2000);
                }

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f,result,511,484,522,491,"离开",Sleep);
                if(result.sim > 0.8f){
                    setTaskEnd();return;
                }
                // if (overtime(10,0))return;
            }
        }.taskContent(mFairy, "青麟之野");
    }

    /**
     * 找回
     *
     * @throws Exception
     */
    public void back() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                //if (overtime(5,0))return;
                result = mFairy.findPic("welfare.png");
                mFairy.onTap(0.8f,result,"福利",Sleep);

                result = mFairy.findPic(22,76,178,441,"back gift.png");
                mFairy.onTap(0.8f,result,"奖励找回",Sleep);

                result = mFairy.findPic("Ordinary retrieval.png");
                mFairy.onTap(0.8f,result,"普通找回",Sleep);

                result = mFairy.findPic(867,149,1094,279,"spend.png");
                mFairy.onTap(0.8f,result,"花费",Sleep);

                result = mFairy.findPic("only back.png");
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

            }

        }.taskContent(mFairy, "找回");
    }

    /**
     * 清理背包
     *
     * @throws Exception
     */
    public void cleanbag() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(5,99))return;
                result = mFairy.findPic("bag.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("equipment2.png");
                mFairy.onTap(0.8f,result,"装备",1000);
                if (result.sim > 0.8f){
                    err=0;
                }
               /* result = mFairy.findPic("equipment3.png");
                if (result.sim > 0.8f){

                }*/


                result = mFairy.findPic("decompose.png");
                mFairy.onTap(0.8f,result,"分解",Sleep);
                if (result.sim > 0.8f){
                    err=0;
                }
                result = mFairy.findPic("yijian.png");
                mFairy.onTap(0.8f,result,"一键分解",Sleep);

              /*  result = mFairy.findPic("decompose.png");
                mFairy.onTap(0.8f,result,"分解",Sleep);*/

              /*  result = mFairy.findPic("click.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }*/
            }

        }.taskContent(mFairy, "清理背包");
    }

    /**
     * 召唤
     *
     * @throws Exception
     */
    public void call() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                //if (overtime(15,0))return;
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);

                result = mFairy.findPic("Yingling.png");
                mFairy.onTap(0.8f,result,"英灵",2000);

                result = mFairy.findPic("call.png");
                mFairy.onTap(0.8f,result,"召唤",Sleep);

                result = mFairy.findPic("Free.png");
                mFairy.onTap(0.8f,result,462,601,473,610,"免费",Sleep);
                result1 = mFairy.findPic(389,570,565,634,"Pray.png");
                if (result.sim < 0.8f && result1.sim > 0.8f){
                    setTaskEnd();return;
                }


                result = mFairy.findPic("sun.png");
                mFairy.onTap(0.8f,result,"召唤2",Sleep);

                result = mFairy.findPic("click.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "召唤");
    }

    /**
     *  采集
     *
     * @throws Exception
     */
    public void caiji() throws Exception {
        new SingleTask(mFairy) {
            ArrayList<String> list = new ArrayList<>();
            int num = 10;
            @Override
            public void create() throws Exception {
                if(AtFairyConfig.getOption("cz").equals("1")){
                    list.add("cz");
                }
                if(AtFairyConfig.getOption("fm").equals("1")){
                    list.add("fm");
                }
                if(AtFairyConfig.getOption("wk").equals("1")){
                    list.add("wk");
                }
                if(AtFairyConfig.getOption("dy").equals("1")){
                    list.add("dy");
                }


            }

            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (list.size() <=0){
                    setTaskEnd();return;
                }
                result = mFairy.findPic("menu.png");
                mFairy.onTap(0.8f,result,"菜单",Sleep);

                result = mFairy.findPic("Sociology.png");
                mFairy.onTap(0.8f, result, "社会", Sleep);

                result = mFairy.findPic("life.png");
                mFairy.onTap(0.8f,result,"生活",3000);

                result = mFairy.findPic("life2.png");
                if (result.sim > 0.8f) {
                    if (list.get(0).equals("cz")) {
                        result = mFairy.findPic("pick.png");
                        mFairy.onTap(0.8f, result, "采摘", Sleep);
                        if (AtFairyConfig.getOption("zl").equals("1")) {
                            mFairy.onTap(276, 223, 286, 236, "星茸花", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl").equals("2")) {
                            mFairy.onTap(373, 226, 383, 238, "金玲草", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl").equals("3")) {
                            mFairy.onTap(474, 226, 486, 235, "鬼语千芽花", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl").equals("4")) {
                            mFairy.onTap(565, 228, 576, 240, "荧息草", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl").equals("5")) {
                            mFairy.onTap(673, 225, 683, 231, "盘龙啸天草", Sleep);
                        }
                    }

                    if (list.get(0).equals("fm")) {
                        result = mFairy.findPic("lumbering.png");
                        mFairy.onTap(0.8f, result, "伐木", Sleep);
                        if (AtFairyConfig.getOption("zl2").equals("1")) {
                            mFairy.onTap(276, 223, 286, 236, "迷梦木", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl2").equals("2")) {
                            mFairy.onTap(373, 226, 383, 238, "椰子树", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl2").equals("3")) {
                            mFairy.onTap(474, 226, 486, 235, "桦树", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl2").equals("4")) {
                            mFairy.onTap(565, 228, 576, 240, "松树", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl2").equals("5")) {
                            mFairy.onTap(673, 225, 683, 231, "银杏", Sleep);
                        }

                    }

                    if (list.get(0).equals("wk")) {
                        result = mFairy.findPic("mining.png");
                        mFairy.onTap(0.8f, result, "挖矿", Sleep);
                        if (AtFairyConfig.getOption("zl3").equals("1")) {
                            mFairy.onTap(276, 223, 286, 236, "坚岩矿", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl3").equals("2")) {
                            mFairy.onTap(373, 226, 383, 238, "赤硫石", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl3").equals("3")) {
                            mFairy.onTap(474, 226, 486, 235, "秘银矿", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl3").equals("4")) {
                            mFairy.onTap(565, 228, 576, 240, "辉金石", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl3").equals("5")) {
                            mFairy.onTap(673, 225, 683, 231, "虹石矿", Sleep);
                        }
                    }

                    if (list.get(0).equals("dy")) {
                        result = mFairy.findPic("fishing.png");
                        mFairy.onTap(0.8f, result, "钓鱼", Sleep);
                        if (AtFairyConfig.getOption("zl4").equals("1")) {
                            mFairy.onTap(276, 223, 286, 236, "沙丁类", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("2")) {
                            mFairy.onTap(373, 226, 383, 238, "鲈类", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("3")) {
                            mFairy.onTap(474, 226, 486, 235, "旗鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("4")) {
                            mFairy.onTap(565, 228, 576, 240, "金枪鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("5")) {
                            mFairy.onTap(673, 225, 683, 231, "鲑类", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("6")) {
                            mFairy.onTap(276, 223, 286, 236, "鲤鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("7")) {
                            mFairy.onTap(373, 226, 383, 238, "鳗鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("8")) {
                            mFairy.onTap(474, 226, 486, 235, "鲇鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("9")) {
                            mFairy.onTap(565, 228, 576, 240, "石斑鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("10")) {
                            mFairy.onTap(673, 225, 683, 231, "鲷鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("11")) {
                            mFairy.onTap(276, 223, 286, 236, "河豚", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("12")) {
                            mFairy.onTap(373, 226, 383, 238, "鲟龙鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("13")) {
                            mFairy.onTap(474, 226, 486, 235, "背鼻鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("14")) {
                            mFairy.onTap(565, 228, 576, 240, "六间鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("15")) {
                            mFairy.onTap(673, 225, 683, 231, "蛇鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("16")) {
                            mFairy.onTap(276, 223, 286, 236, "板机鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("17")) {
                            mFairy.onTap(373, 226, 383, 238, "皇后鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("18")) {
                            mFairy.onTap(474, 226, 486, 235, "刺尾鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("19")) {
                            mFairy.onTap(565, 228, 576, 240, "赤笔鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("20")) {
                            mFairy.onTap(673, 225, 683, 231, "钻嘴鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("21")) {
                            mFairy.ranSwipe(615, 563, 610, 366, 500, 500);
                            mFairy.onTap(276, 223, 286, 236, "鲬鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("22")) {
                            mFairy.ranSwipe(615, 563, 610, 366, 500, 500);
                            mFairy.onTap(373, 226, 383, 238, "射水鱼", Sleep);
                        }
                        if (AtFairyConfig.getOption("zl4").equals("23")) {
                            mFairy.ranSwipe(615, 563, 610, 366, 500, 500);
                            mFairy.onTap(474, 226, 486, 235, "角鲽鱼", Sleep);
                        }

                    }
                }
                result = mFairy.findPic(new String[]{"Unlocking.png","zanwei.png"});
                if (result.sim > 0.8f && list.size() >0){
                    list.remove(0);
                    setTaskName(0);return;
                }
                result = mFairy.findPic("go.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);

                result = mFairy.findPic(6,57,765,652,new String[]{"grass.png","wood.png","mineral.png","fish.png"});
                mFairy.onTap(0.8f,result,"前往2",Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(3);
                    return;
                }
            }
            public void content_2() throws Exception {




            }
            public void content_3() throws Exception {
                result = mFairy.findPic(new String[]{"pick2.png","lumbering2.png","mining2.png","fishing2.png"});
                mFairy.onTap(0.8f,result,"采集",3000);
                if (result.sim > 0.8f){
                    num--;
                }

                if (num <=0 && list.size() >= 0){
                    num =10;
                    list.remove(0);
                }
                LtLog.e("--------------"+num);
                result = mFairy.findPic(155,12,1154,702,"Mischief.png");
                mFairy.onTap(0.6f, result, "捣蛋", Sleep);

              /*    result = mFairy.findPic("begintz2.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result = mFairy.findPic("close2.png");
                mFairy.onTap(0.8f,result,"宠物开启自动释放技能",Sleep);

                result = mFairy.findPic("auto.png");
                mFairy.onTap(0.8f,result,"开启自动",Sleep);

                result = mFairy.findPic("stjx.png");
                mFairy.onTap(0.8f,result,"继续",Sleep);

                result = mFairy.findPic("yes.png");
                mFairy.onTap(0.8f,result,"确认选择",Sleep);

                result = mFairy.findPic("surplus.png");
                if(result.sim < 0.8f){
                    mFairy.ranSwipe(200,555,202,354,4000,2000);
                }*/

                result = mFairy.findPic("fail.png");
                mFairy.onTap(0.8f,result,511,484,522,491,"离开",Sleep);
                if(result.sim > 0.8f){
                    setTaskEnd();return;
                }
                // if (overtime(10,0))return;
            }
        }.taskContent(mFairy, "采集");
    }


   }