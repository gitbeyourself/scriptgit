package com.script.fairy;


//import com.script.content.ScProxy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask  extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    FindResult result4;
    GameUtil gameUtil;

    YxdUtil yxdUtil_1;
    YxdUtil yxdUtil_2;
    YxdUtil yxdUtil_3;
    TimingActivity timingActivity;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        Sleep = 100;
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);
        yxdUtil_1 = new YxdUtil(mFairy);
        yxdUtil_2 = new YxdUtil(mFairy);
        yxdUtil_3 = new YxdUtil(mFairy);
        timingActivity=new TimingActivity(mFairy);
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("smOverGraph.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中。。。。。"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("Finding the way auto.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中。。。。。"));
            //mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("battle auto.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("自动战斗中。。。。。"));
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }

    }

    /**
     * 新手指引（主线任务）
     *
     * @throws Exception
     */
    public void plotTask() throws Exception {
        //ScProxy.config().setMatchingTimeIntervalLimitLevel(0);
//        strSplit(AtFairyConfig.getOption("optime1"));
//        timekeep(0,back.timeMillis,"挑战时间")
        new SingleTask(mFairy) {
            @Override
            public void inOperation() throws Exception {
                result = mFairy.findPic("skip.png");
                mFairy.onTap(0.8f,result,"跳过",2000);

                result = mFairy.findPic("skip3.png");
                mFairy.onTap(0.8f,result,"跳过",2000);

                result = mFairy.findPic("skip4.png");
                mFairy.onTap(0.8f,result,"跳过",2000);

                result = mFairy.findPic("skip2.png");
                mFairy.onTap(0.8f,result,"跳过确认",2000);

                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("ascend the stairs.png");
                mFairy.onTap(0.8f,result,"立即升阶",Sleep);

                result = mFairy.findPic("consume.png");
                mFairy.onTap(0.8f,result,796,465,808,473,"升阶消耗",Sleep);

                result = mFairy.findPic("shengjie.png");
                mFairy.onTap(0.8f,result,"升阶完成",Sleep);

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(4);return;
            }
            public void content_4() throws Exception  {
                result = mFairy.findPic("bu.png");
                mFairy.onTap(0.8f,result,"起号下一步",2000);

                result = mFairy.findPic(530,423,771,551,"Power saving.png");
                if (result.sim > 0.8f){
                    LtLog.e("防卡死滑动一下");
                    mFairy.touchDown(207,559);
                    mFairy.touchMove(130,618,1000);
                    mFairy.touchUp();
                }

                result = mFairy.findPic("jingame.png");
                mFairy.onTap(0.8f,result,"捏脸进入游戏",2000);
                mFairy.onTap(0.8f,result,738,463,750,470,"捏脸进入游戏确定",2000);

                result = mFairy.findPic("Novice hand.png");
                mFairy.onTap(0.8f,result,"指引摇晃控制杆",Sleep);

                result = mFairy.findPic(1084,142,1276,248,"skip.png");
                mFairy.onTap(0.8f,result,"跳过",Sleep);

                result = mFairy.findPic("new hand.png");
                mFairy.onTap(0.8f,result,743,463,754,470,"跳过新手关卡确认",Sleep);

                result = mFairy.findPic("letter.png");
                mFairy.onTap(0.8f,result,"点击书信",Sleep);

                result = mFairy.findPic("random.png");
                mFairy.onTap(0.8f,result,"随机名字",Sleep);
                mFairy.onTap(0.8f,result,614,619,627,628,"确认名字",Sleep);

                result3 = mFairy.findPic("Finding the way auto.png");
                if(result3.sim < 0.8f) {
                    result = mFairy.findPic(38,93,253,333,new String[]{"plot.png","plot2.png"});
                    mFairy.onTap(0.8f, result, "剧情", 3000);
                }
                result = mFairy.findPic("prologue.png");
                mFairy.onTap(0.8f,result,985,662,1000,670,"序章完成",2000);


                result = mFairy.findPic("jianghu.png");
                mFairy.onTap(0.8f,result,118,31,126,36,"点击流派",Sleep);

                result = mFairy.findPic("schools.png");
                mFairy.onTap(0.8f,result,"确认流派",Sleep);

                result = mFairy.findPic("firstliu.png");
                mFairy.onTap(0.8f,result,799,556,811,562,"确定选择流派",Sleep);

                result = mFairy.findPic("zidong.png");
                mFairy.onTap(0.8f,result,1242,682,1253,687,"开启挂机",Sleep);

                result = mFairy.findPic(new String[]{"overcome.png","yedao.png","jijie.png","yougu.png","qian.png"});
                if (result.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                    mFairy .onTap(0.8f,result,"开启自动",Sleep);
                }

                result = mFairy.findPic("Joinmeng.png");
                if (result.sim > 0.8f){
                    LtLog.e("加盟滑动");
                    mFairy.touchDown(207,559);
                    mFairy.touchMove(130,618,1000);
                    mFairy.touchUp();
                }

                result = mFairy.findPic("function.png");
                mFairy.onTap(0.8f,result,1232,184,1247,196,"打开功能面板",Sleep);

                result = mFairy.findPic("new go.png");
                mFairy.onTap(0.8f,result,"前往",2000);
                if (result.sim > 0.8f){
                    result1 = mFairy.findPic(38,93,253,333,new String[]{"plot.png","plot2.png"});
                    if (result1.sim > 0.8f) {
                        setTaskName(6);
                        return;
                    }
                }

                result = mFairy.findPic("title.png");
                mFairy.onTap(0.8f,result,1124,285,1136,294,"头衔",Sleep);

                result = mFairy.findPic("Promotion.png");
                mFairy.onTap(0.8f,result,"晋升",3000);
                mFairy.onTap(0.8f,result,45,34,54,42,"关闭",2000);
//                result = mFairy.findPic("famous.png");
//                mFairy.onTap(0.8f,result,"文明",2000);


                result = mFairy.findPic("new hand bang.png");
                mFairy.onTap(0.8f,result,1129,383,1142,391,"帮会页面",2000);

                result = mFairy.findPic("apply.png");
                mFairy.onTap(0.8f,result,"全部申请",3000);
                mFairy.onTap(0.8f,result,49,27,58,37,"申请完关闭",2000);

                result = mFairy.findPic("Stealing.png");
                mFairy.onTap(0.8f,result,"盗图",2000);

                result = mFairy.findPic("new back.png");
                mFairy.onTap(0.8f,result,"返回同伴界面",2000);

                result = mFairy.findPic("Check.png");
                mFairy.onTap(0.8f,result,367,172,373,179,"勾选出战",2000);
                mFairy.onTap(0.8f,result,42,24,52,36,"勾选出战后退出",2000);
                result1 = mFairy.findPic("tongban.png");
                if(result.sim < 0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f,result1,42,24,52,36,"退出同伴页面",2000);
                }

                result2 = mFairy.findPic("fishing2.png");
                if (result2.sim >0.8f){

                 setTaskName(1);return;
                }

                result = mFairy.findPic("left.png");
                mFairy.onTap(0.8f,result,"左使喝多了",2000);

                result = mFairy.findPic("Meridians.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
               // setTaskName(2);return;
                result = mFairy.findPic("zhaomu.png");
                mFairy.onTap(0.8f,result,1236,187,1243,196,"招募打开菜单栏",2000);
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }
                result = mFairy.findPic(new String[]{"topyun2.png","bang.png"});//"topyun.png",
                if (result.sim > 0.8f){
                    result = mFairy.findPic("topyun.png");
                    mFairy.onTap(0.8f,result,"风云榜",2000);
                    setTaskName(5);return;
                }
                result = mFairy.findPic("toptz.png");
                if (result.sim > 0.8f){
                    setTaskName(5);return;
                }
                result = mFairy.findPic("songyao.png");
                mFairy.onTap(0.8f,result,"小的去送药",2000);

                result = mFairy.findPic("Kong Ming.png");
                if (result.sim > 0.8f){
                    setTaskName(7);return;
                }
                result = mFairy.findPic(new String[]{"yaopo.png","fpp.png"});
                mFairy.onTap(0.8f,result,"拯救卡在人物对话得页面",2000);

                result = mFairy.findPic("xia.png");
                mFairy.onTap(0.8f,result,43,30,49,36,"行侠关闭",2000);

//                if(result.sim > 0.8f){
//                    setTaskName(6);return;
//                }
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("fishing accept.png");
                mFairy.onTap(0.8f,result,"接受",2000);

                result = mFairy.findPic(41,111,241,331,"gofishing.png");
                mFairy.onTap(0.8f,result,"去钓鱼地点",5000);

                result = mFairy.findPic(1038,481,1239,687,"gofishing2.png");
                mFairy.onTap(0.8f,result,"开始钓鱼",3300);

                result = mFairy.findPic(1015,472,1229,661,"bobo.png");
                mFairy.onTap(0.8f,result,"钓鱼",Sleep);

                result = mFairy.findPic("Shop.png");
                mFairy.onTap(0.8f,result,46,25,55,34,"逛摊",3000);

                result1 = mFairy.findPic("finish fish.png");
                result = mFairy.findPic("hand in fish.png");
                mFairy.onTap(0.8f,result,"上交",Sleep);
                if(result.sim > 0.8f || result1.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_2() throws Exception{
                result = mFairy.findPic("Meridians.png");
                mFairy.onTap(0.8f,result,1212,296,1227,305,"打开经脉页面",2000);


                result = mFairy.findPic("jia.png");
                mFairy.onTap(0.8f,result,"经脉",2000);

                result = mFairy.findPic("lunjian.png");
                mFairy.onTap(0.8f,result,"论剑",2000);

                result = mFairy.findPic("sword Challenge.png");
                mFairy .onTap(0.8f,result,"论剑挑战",Sleep);

                result1 = mFairy.findPic("open auto.png");
                result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    result = mFairy.findPic("Duel Arena.png");
                    result2 = mFairy.findPic("Exit key.png");
                    if (result.sim > 0.8f && result2.sim >0.8f){
                        mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
                    }

                }
                result = mFairy.findPic("continue.png");
                mFairy .onTap(0.8f,result,"继续",2000);
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("sign out.png");
                mFairy .onTap(0.8f,result,"菜鸡没打过退出",3000);

                result1 = mFairy.findPic("open.png");
                mFairy .onTap(0.8f,result1,"开启",2000);

                result = mFairy.findPic("yes.png");
                mFairy .onTap(0.8f,result,"确定",2000);

                result = mFairy.findPic("jixu.png");
                mFairy .onTap(0.8f,result,78,29,87,37,"退出",2000);
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }


            }
            public void content_3() throws Exception{
                result1 = mFairy.findPic(1017,320,1268,584,"friend.png");
                mFairy .onTap(0.8f,result1,"同伴",2000);
                result2 = mFairy.findPic("bag.png");
                if (result1.sim < 0.8f && result2.sim > 0.8f) {
                    result = mFairy.findPic(new String[]{"menu.png", "map yw.png"});
                    mFairy.onTap(0.8f, result,  "菜单栏", 2000);
                }
                result = mFairy.findPic( "zhaomu2.png");
                mFairy.onTap(0.8f, result,  "招募栏", 2000);

                result = mFairy.findPic( "yinliang.png");
                mFairy.onTap(0.8f, result,  "银两购买", 2000);

                result = mFairy.findPic( "huode.png");
                mFairy.onTap(0.8f, result,  "恭喜获得", 2000);
                mFairy.onTap(0.8f, result,  46,24,61,37,"退出", 2000);
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic( "one.png");
                if (result.sim > 0.8f){
                    LtLog.e("购买了一次了");
                    setTaskName(0);return;
                }
            }
            public void content_5() throws Exception{
                result = mFairy.findPic("yijian.png");
                mFairy .onTap(0.8f,result,"一键领取领取",2000);

                result = mFairy.findPic("lingqu.png");
                mFairy .onTap(0.8f,result,"领取",2000);

                result = mFairy.findPic("Gifts.png");
                mFairy .onTap(0.8f,result,621,509,637,515,"馈赠",2000);

                result = mFairy.findPic("toptz.png");
                mFairy .onTap(0.8f,result,"boss挑战",2000);

                result1 = mFairy.findPic("fytop2.png");
                result = mFairy.findPic(216,374,995,511,"Challenge topyun.png");
                mFairy .onTap(0.8f,result,"挑战小兵",2000);
                if (result.sim < 0.8f && result1.sim > 0.8f){
                    result = mFairy.findPic("fytop.png");
                    mFairy .onTap(0.8f,result,"挑战boss",2000);
                }

                result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);

                result = mFairy.findPic("back2.png");
                mFairy .onTap(0.8f,result,"打完了退出",2000);

                result = mFairy.findPic("di.png");
                mFairy .onTap(0.8f,result,735,462,748,477,"战力较低继续挑战",2000);

                result = mFairy.findPic("bai.png");
                mFairy .onTap(0.8f,result,"已击败",2000);

                result = mFairy.findPic("victory.png");
                mFairy .onTap(0.8f,result,"胜利",2000);

                result = mFairy.findPic("again.png");
                mFairy .onTap(0.8f,result,1056,659,1063,668,"退出",2000);
                if (result.sim > 0.8f){
                    LtLog.e("挑战失败");
                    setTaskEnd();return;
                }

                result = mFairy.findPic("topyun.png");
                if (result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_6() throws Exception{
                result = mFairy.findPic("Challenge2.png");
                mFairy .onTap(0.8f,result,"挑战",2000);

                result = mFairy.findPic("begin.png");
                mFairy .onTap(0.8f,result,"开始",2000);

                result1 = mFairy.findPic("open auto.png");
                result = mFairy.findPic(new String[]{"auto.png","auto2.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    result2 = mFairy.findPic("ben.png");
                    // result2 = mFairy.findPic("begin.png");
                    if ( result2.sim >0.8f){
                        mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
                    }


                }

                result = mFairy.findPic("pingmu.png");
                mFairy .onTap(0.8f,result,"点击屏幕退出",2000);
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }

                result = mFairy.findPic("Power saving.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
                result = mFairy.findPic("Challenge3.png");
                if(result.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_7() throws Exception{
                result = mFairy.findPic("light1.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(302,311);
                    mFairy.touchMove(895,509,1000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("light2.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(473,214);
                    mFairy.touchMove(874,259,1000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("light3.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(461,529);
                    mFairy.touchMove(963,391,1000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("light4.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(535,363);
                    mFairy.touchMove(855,392,1000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("light5.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(194,203);
                    mFairy.touchMove(1008,189,1000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("light6.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(278,575);
                    mFairy.touchMove(1009,308,1000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("xuyuan.png");
                mFairy.onTap(0.8f,result,"输入内容",Sleep);
                if (result.sim > 0.8f) {
                    mFairy.inputText("我");
                    mFairy.onTap(614,55,626,65,"空白点击",2000);
                    mFairy.onTap(380,494,387,503,"许愿",2000);
                }
                result = mFairy.findPic(38,93,253,333,new String[]{"plot.png","plot2.png"});
                if (result.sim > 0.8f) {
                   setTaskName(0);return;
                }
            }
        }.taskContent(mFairy, "新手指引");
    }

    /**
     * 钓鱼
     */
    public void fishing() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("fishing.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("XiangYang.png");
                mFairy.onTap(0.8f,result,642,467,657,473,"关闭提示",Sleep);

                result = mFairy.findPic("Activeinterface.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("XiangYang2.png");
                    mFairy.onTap(0.8f,result,"前往襄阳",Sleep);

                }else {
                    result = mFairy.findPic(1018,147,1271,246,"activity.png");
                    LtLog.e("=========================活动按钮相似度=="+result.sim);
                    mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);
                }
                if (err == 5){
                    gameUtil.close();
                }
                if (overtime(6,3))return;
            }
            public void content_3() throws Exception {
                result = mFairy.findPic("dialogue.png");
                mFairy.onTap(0.8f,result,"钓鱼",2000);
                result3 = mFairy.findPic("Finding the way auto.png");
                result1 = mFairy.findPic("XiangYang4.png");
                if (result3.sim < 0.8f && result.sim < 0.8f && result1.sim < 0.8f) {
                    result3 = mFairy.findPic("XiangYang3.png");
                    mFairy.onTap(0.8f, result3, 1191,55,1201,67,"首次打开襄阳地图", 3000);
 //                   result1 = mFairy.findPic("XiangYang4.png");
//                    if (result1.sim > 0.8f){
//                        setTaskName(5);return;
//                    }
                    result1 = mFairy.findPic("XiangYang4.png");
                    if (result1.sim > 0.8f){
                        mFairy.touchDown(623,669);
                        mFairy.touchMove(613,155,1000);
                        mFairy.touchUp();

                    } else {

                    }
                    mFairy.sleep(2000);
                }
                result1 = mFairy.findPic("XiangYang4.png");
                result2 = mFairy.findPic("fishing2.png");
                if (result2.sim > 0.8f){
                    setTaskName(4);return;
                }else if (result.sim > 0.8f && result2.sim < 0.8f && result1.sim < 0.8f){
                   // mFairy.onTap(194,556,204,564,"没有叉子关闭",2000);
                    gameUtil.close();
                    result4 = mFairy.findPic("XiangYang3.png");
                    mFairy.onTap(0.8f, result4, 1191,55,1201,67,"再次打开襄阳地图", 3000);
//                    if (result1.sim > 0.8f){
//                        setTaskName(5);return;
//                    }
                    mFairy.touchDown(623,669);
                    mFairy.touchMove(613,155,1000);
                    mFairy.touchUp();
                    mFairy.sleep(2000);
                }
                result = mFairy.findPic(308,7,984,702,"xiao.png");
                LtLog.e("**********"+result.x+","+result.y);//339,155    340,175,348,183
                mFairy.onTap(0.8f,result,result.x+1,result.y+20,result.x+9,result.y+28,"去钓鱼翁那",2000);
                //mFairy.onTap(0.8f,result,37,29,44,41,"关闭襄阳地图",2000);
            }
            public void content_4() throws Exception {
                result = mFairy.findPic("dialogue.png");
                mFairy.onTap(0.8f,result,"钓鱼",2000);

                result = mFairy.findPic("fishing accept.png");
                mFairy.onTap(0.8f,result,"接受",2000);

                result = mFairy.findPic(43,181,134,326,"jieri.png");
                if (result.sim > 0.8f){
                    LtLog.e(mFairy.getLineInfo("滑动一次，"));
                    mFairy.sleep(2000);
                    mFairy.ranSwipe(135,255,135,170,1000,3000l,1);
                }

                result = mFairy.findPic(41,111,241,331,"gofishing.png");
                mFairy.onTap(0.8f,result,"去钓鱼地点",5000);

                result = mFairy.findPic(1038,481,1239,687,"gofishing2.png");
                mFairy.onTap(0.8f,result,"开始钓鱼",3300);

                result = mFairy.findPic(1015,472,1229,661,"bobo.png");
                mFairy.onTap(0.8f,result,"钓鱼",Sleep);

                result = mFairy.findPic("Shop.png");
                mFairy.onTap(0.8f,result,46,25,55,34,"逛摊",3000);

                result1 = mFairy.findPic("finish fish.png");
                result = mFairy.findPic("hand in fish.png");
                mFairy.onTap(0.8f,result,"上交",Sleep);
                if(result.sim > 0.8f || result1.sim > 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_5() throws Exception{
                result1 = mFairy.findPic("XiangYang4.png");
                if (result1.sim > 0.8f){
                    result = mFairy.findPic("fisherman.png");
                    mFairy.onTap(0.8f,result,"前去渔翁处",2000);
                    if (result.sim > 0.8f){
                        setTaskName(2);return;
                    }
                }else {
                    setTaskName(2);return;
                }

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6, 8}, 0, 1133,661, 1133,99, 1000, 1500);
                if (overtime(10, 2)) return;//计次并跳转
            }
        }.taskContent(mFairy, "钓鱼");
    }

    /**
     * 论剑
     */
    public void sword() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            public void content_1() throws Exception {
                int ret =  gameUtil.mission("sword.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        mFairy.sleep(3000);
                        LtLog.e("接取任务成功");
                        mFairy.sleep(2000);
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("sword Challenge.png");
                mFairy .onTap(0.8f,result,"论剑挑战",Sleep);

                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result1 = mFairy.findPic("open auto.png");
                result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    result = mFairy.findPic("Duel Arena.png");
                    result2 = mFairy.findPic("Exit key.png");
                    if (result.sim > 0.8f && result2.sim >0.8f){
                        mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
                    }

                }
                result = mFairy.findPic("continue.png");
                mFairy .onTap(0.8f,result,"继续",2000);

                result = mFairy.findPic("sign out.png");
                mFairy .onTap(0.8f,result,"菜鸡没打过退出",3000);

                result1 = mFairy.findPic("open.png");
                mFairy .onTap(0.8f,result1,"开启",2000);

                result = mFairy.findPic("yes.png");
                mFairy .onTap(0.8f,result,"确定",2000);


                result3 = mFairy.findPic("Finding the way auto.png");
                result1 = mFairy.findPic("task.png");
                if(result3.sim < 0.8f && result1.sim > 0.8f){
                    setTaskName(0);return;
                }

                result = mFairy.findPic("swad finish.png");
                if (result.sim > 0.8f) {
                    mFairy.sleep(5000);
                    result1 = mFairy.findPic("open.png");
                    mFairy .onTap(0.8f,result1,"开启",3000);

                    result2 = mFairy.findPic("yes.png");
                    mFairy .onTap(0.8f,result2,"确定",2000);
                    if (result1.sim < 0.8f && result2.sim < 0.8f) {
                        LtLog.e("次数打完了 还想去看看 任务完成没 ");
                        setTaskName(0);
                        return;
                    }
                }
            }

        }.taskContent(mFairy, "论剑");
    }

    /**
     * 科举
     */
    public void examination() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("examination.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic("participate.png");
                mFairy .onTap(0.8f,result,"科举参加",Sleep);

                result = mFairy.findPic(1040,175,1171,225,"first.png");
                mFairy .onTap(0.8f,result,715,395,724,403,"第一个",Sleep);

                result = mFairy.findPic(new String[]{"Make a list.png","fabang.png"});
                if (result.sim > 0.8f){
                    LtLog.e("科举呆瓜答题终于完事了");
                    setTaskName(0);return;
                }

            }

        }.taskContent(mFairy, "科举");
    }

    /**
     * 商会任务
     */
    public void chamberCommerce() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("Chamber of Commerce.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("canjia2.png");
                mFairy .onTap(0.8f,result,"参加",2000);

                //mFairy.sleep(2000);
                result = mFairy.findPic(1097,91,1229,488,"hand in.png");
                mFairy .onTap(0.8f,result,"上交",2000);

//                if (result.sim < 0.8f){
//                    LtLog.e("没有上交的物品了走去干做任务的");
//                    setTaskName(3);return;
//                }
                if (err == 1){
                    mFairy.sleep(5000);
                }
                if (overtime(10,3))return;
            }
            public void content_3() throws Exception {
                long dazeTime = mFairy.mMatTime(1170,124,88,21, 0.9f);

                result = mFairy.findPic(1097,91,1229,488,"hand in.png");
                mFairy .onTap(0.8f,result,"上交",2000);

                result = mFairy.findPic(1081,76,1237,711,"Finding the way.png");
                mFairy .onTap(0.8f,result,"寻路",Sleep);

                result = mFairy.findPic("mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定寻路",2000);



                result = mFairy.findPic("Receive the prize.png");
                mFairy .onTap(0.8f,result,"领取奖励",2000);

                result = mFairy.findPic("Payment.png");
                mFairy .onTap(0.8f,result,726,461,736,473, "没有缴纳完就领取确定",2000);

                result4 = mFairy.findPic(43,181,134,326,"jieri.png");
                if (result4.sim > 0.8f){
                    LtLog.e(mFairy.getLineInfo("err滑动一次，"));
                    mFairy.sleep(2000);
                    mFairy.ranSwipe(135,255,135,170,1000,3000l,1);
                }

                result = mFairy.findPic("shanhfinish.png");
                mFairy .onTap(0.8f,result,622,517,638,525,"完成商会任务",2000);
                if (result.sim > 0.8f){
                    LtLog.e("完成了也得去看一眼");
                    setTaskName(0);return;
                }
                result = mFairy.findPic("task.png");
                result1 = mFairy.findPic(38,112,284,333,"shtask.png");
                if (result.sim > 0.8f && result1.sim < 0.8f && result4.sim < 0.8f){
                    LtLog.e("完成了也得去看一眼2");
                    setTaskName(0);return;
                }
                if (result.sim > 0.8f && result1.sim < 0.8f && dazeTime >=30){
                    LtLog.e("发呆了");
                    setTaskName(0);return;
                }

                result3 = mFairy.findPic("Finding the way auto.png");
                result2 = mFairy.findPic("battle auto.png");
                if (result3.sim < 0.8f && result2.sim < 0.8f && result1.sim>0.8f&& result4.sim < 0.8f){
                    //LtLog.e("怎么不动了 去看看是不是做完了");
                    mFairy.sleep(3000);
                    result = mFairy.findPic(38,112,284,333,"shtask.png");
                    mFairy .onTap(0.8f,result,"点一下商会",3000);
                    //setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "商会任务");
    }

    /**
     * 师门
     */
    public void school() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("School.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        mFairy.sleep(5000);
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1170,124,88,21, 0.9f);
                LtLog.e("发呆时间"+dazeTime);
                result = mFairy.findPic("canjia.png");
                mFairy .onTap(0.8f,result,"参加师门任务",2000);

                result = mFairy.findPic("go to.png");
                mFairy .onTap(0.8f,result,"前往",2000);

                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result4 = mFairy.findPic(43,181,134,326,"jieri.png");
                if (result4.sim > 0.8f){
                    LtLog.e(mFairy.getLineInfo("滑动一次，"));
                    mFairy.sleep(2000);
                    mFairy.ranSwipe(135,255,135,170,1000,3000l,1);
                }

                result1 = mFairy.findPic("task.png");
                result = mFairy.findPic(38,112,284,333,"teach.png");
                if (result.sim < 0.8f && result1.sim > 0.8f&& result4.sim < 0.8f){
                    LtLog.e("任务栏没有师门任务了 去看看是不是做完了");
                    setTaskName(0);return;
                }

                result3 = mFairy.findPic("Finding the way auto.png");
                result2 = mFairy.findPic("battle auto.png");
                if ( result2.sim < 0.8f && result3.sim < 0.8f){
                    mFairy.sleep(3000);
                    result = mFairy.findPic(27,113,140,334,"teach.png");
                    mFairy .onTap(0.8f,result,"点一下师门",Sleep);
                    //setTaskName(0);return;
                }
                result = mFairy.findPic(38,112,284,333,"teach.png");
                if (result.sim < 0.8f && result3.sim < 0.8f && result2.sim < 0.8f && result4.sim > 0.8f&& dazeTime >= 30){
                    //LtLog.e("怎么不动了 去看看是不是做完了");
                    setTaskName(0);return;
                }
                result = mFairy.findPic("Power saving.png");
                if(result.sim > 0.8f){
                    result = mFairy.findPic(27,113,140,334,"teach.png");
                    mFairy .onTap(0.8f,result,"点一下师门",Sleep);
                    if (result.sim < 0.8f){
                        setTaskName(0);return;
                    }

                }
                result = mFairy.findPic("tiaoz.png");
                mFairy .onTap(0.8f,result,737,465,755,476,"确定",1000);

                result = mFairy.findPic("over.png");
                mFairy .onTap(0.8f,result,"完成",1000);

            }
        }.taskContent(mFairy, "师门");
    }

    /**
     * 行侠
     */
    public void chivalry() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int ret =  gameUtil.mission("Chivalry.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                long dazeTime = mFairy.mMatTime(1170,124,88,21, 0.9f);
                LtLog.e("发呆时间"+dazeTime);
                result = mFairy.findPic("joinhuodong.png");
                mFairy.onTap(0.8f,result,739,468,750,472,"确认参加",Sleep);

                result3 = mFairy.findPic("Finding the way auto.png");
                if (result3.sim > 0.8f && dazeTime < 30){
                    LtLog.e("寻路中");
                    return;
                }else if (result3.sim > 0.8f && dazeTime >= 30){
                    LtLog.e("卡房顶了使用轻功");
                    mFairy.onTap(1160,592,1170,599,"轻功",Sleep);
                }else if (result3.sim < 0.8f && dazeTime >=10){
                    if (AtFairyConfig.getOption("qldj").equals("1")){
                        int ret =  gameUtil.xingxia("ji.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成或者做完了");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("hmth").equals("1")){
                        int ret =  gameUtil.xingxia("hua.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("ywyy").equals("1")){
                        int ret =  gameUtil.xingxia("yun.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("lftx").equals("1")){
                        int ret =  gameUtil.xingxia("xue.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("mxbw" ).equals("1")){
                        int ret =  gameUtil.xingxia("wu.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("ctl").equals("1")){
                        int ret =  gameUtil.xingxia("lao.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("sgdj").equals("1")){
                        int ret =  gameUtil.xingxia("jie.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("bdjz").equals("1")){
                        int ret =  gameUtil.xingxia("zhan.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }


                    if (AtFairyConfig.getOption("bzzj").equals("1")){
                        int ret =  gameUtil.xingxia("ji2.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }

                    if (AtFairyConfig.getOption("jpyx").equals("1")){
                        int ret =  gameUtil.xingxia("xian.png");
                        switch (ret){
                            case 0:
                                LtLog.e("任务已完成");
                                setTaskEnd();return;
                            case 1:
                                LtLog.e("接取任务成功");
                                setTaskName(3);return;
                        }
                    }
                }


            }
            public void content_3() throws Exception {
//                result = mFairy.findPic("Challenge2.png");
//                mFairy .onTap(0.8f,result,"挑战",2000);

                result = mFairy.findPic("begin.png");
                mFairy .onTap(0.8f,result,"开始",2000);

           /*     result1 = mFairy.findPic("open auto.png");
                result = mFairy.findPic(new String[]{"auto.png","auto2.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    result2 = mFairy.findPic("ben.png");
                    // result2 = mFairy.findPic("begin.png");
                    if ( result2.sim >0.8f){
                        mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
                    }

                }*/
                result1 = mFairy.findPic("fuben.png");
                result = mFairy.findPic("battle auto.png");
                result2 = mFairy.findPic("Power saving.png");
                if (result1.sim > 0.65f&& result.sim < 0.8f){
                    mFairy.onTap(1236,674,1246,680,"开启自动2",Sleep);
                }else if (result.sim > 0.8f && result2.sim > 0.8f){
                    mFairy .onTap(0.8f,result2,"退出省电模式",2000);
                }

                result = mFairy.findPic(new String[]{"pingmu.png","mu.png"});
                mFairy .onTap(0.8f,result,"点击屏幕退出",2000);
                if (result.sim > 0.8f){
                    mFairy.sleep(5000);
                    LtLog.e("--------------11111");
                    setTaskName(0);return;
                }
                result = mFairy.findPic("Challenge3.png");
                if(result.sim > 0.8f){
                    LtLog.e("--------------22222");
                    setTaskName(0);return;
                }
                result1 = mFairy.findPic("fuben.png");
                result = mFairy.findPic("Power saving.png");
                if(result.sim > 0.8f && result1.sim < 0.7f){
                    LtLog.e("--------------33333");
                    setTaskName(0);return;
                }

            }
        }.taskContent(mFairy, "行侠");
    }

    /**
     * 行侠
     */
    public void chivalry2() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result1 = mFairy.findPic("fuben.png");
                if (result1.sim >0.75f){
                    LtLog.e("副本中。。。。"+result1.sim);
                    setTaskName(3);
                }


                int ret =  gameUtil.mission("Chivalry.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(3);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_3() throws Exception {
                result = mFairy.findPic("Challenge2.png");
                mFairy .onTap(0.8f,result,"挑战",2000);

                result = mFairy.findPic("begin.png");
                mFairy .onTap(0.8f,result,"开始",2000);

                result1 = mFairy.findPic("open auto.png");
                result = mFairy.findPic(new String[]{"auto.png","auto2.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    result2 = mFairy.findPic("ben.png");
                    // result2 = mFairy.findPic("begin.png");
                    if ( result2.sim >0.8f){
                        mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
                    }

                }
                result1 = mFairy.findPic("fuben.png");
                result = mFairy.findPic("battle auto.png");
                result2 = mFairy.findPic("Power saving.png");
                if (result1.sim > 0.65f&& result.sim < 0.8f){
                    mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
                }else if (result.sim > 0.8f && result2.sim > 0.8f){
                    mFairy .onTap(0.8f,result2,"退出省电模式",2000);
                }

                result = mFairy.findPic(new String[]{"pingmu.png","mu.png"});
                mFairy .onTap(0.8f,result,"点击屏幕退出",2000);
                if (result.sim > 0.8f){
                    mFairy.sleep(5000);
                    LtLog.e("--------------11111");
                    setTaskName(0);return;
                }
                result = mFairy.findPic("Challenge3.png");
                if(result.sim > 0.8f){
                    LtLog.e("--------------22222");
                    setTaskName(0);return;
                }
                result1 = mFairy.findPic("fuben.png");
                result = mFairy.findPic("Power saving.png");
                if(result.sim > 0.8f && result1.sim < 0.7f){
                    LtLog.e("--------------33333");
                    setTaskName(0);return;
                }
            }

        }.taskContent(mFairy, "行侠");
    }

    /**
     *  神捕
     */
    public void shenbu() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic(36,113,233,398,"Arrest.png");
                if (result.sim >0.8f){
                    setTaskName(2);
                    return;
                }
                int ret =  gameUtil.mission("shenbu.png",0);
                switch (ret){
                    case 0:
                        LtLog.e("任务已完成");
                        setTaskEnd();return;
                    case 1:
                        LtLog.e("接取任务成功");
                        setTaskName(2);return;
                    case 2:
                        LtLog.e("任务还没解锁");
                        setTaskEnd();return;

                }
            }
            public void content_2() throws Exception {
                long time = mFairy.mMatTime(1164,124,96,21,0.9f);
                result = mFairy.findPic("shenbuhd.png");
                if (result.sim > 0.8f){

//                    result = mFairy.findPic("hand in2.png");
//                    mFairy.onTap(0.8f,result,"上交",2000);

                    result = mFairy.findPic("beginsb.png");
                    mFairy.onTap(0.8f,result,"开始",2000);

                }

                result = mFairy.findPic("Unveiling.png");
                mFairy.onTap(0.8f,result,"揭榜",2000);

                result3 = mFairy.findPic("Finding the way auto.png");
                result = mFairy.findPic(36,113,233,398,"Arrest.png");
                if (result.sim>0.8f && result3.sim < 0.8f && time >=15){
                    result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                    mFairy .onTap(0.8f,result,"开启自动",Sleep);

                }else if (result.sim< 0.8f && result3.sim < 0.8f && time >=30){
                    setTaskName(0);
                    return;
                }else if(result.sim>0.8f && result3.sim<0.8f && time >= 10){
                    mFairy.onTap(0.8f,result,"缉拿",2000);
                }

                result = mFairy.findPic("direct.png");
                mFairy.onTap(0.8f,result,"直接动手",Sleep);

                result = mFairy.findPic(new String[]{"skip.png","skip3.png","skip4.png"});
                mFairy.onTap(0.8f,result,"跳过",Sleep);

                result = mFairy.findPic("agin.png");
                mFairy.onTap(0.8f,result,"继续",2000);



            }
        }.taskContent(mFairy, "神捕");
    }

    /**
     * 风云榜
     */
    public void topList() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {

                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result3 = mFairy.findPic("Finding the way auto.png");
                if (result3.sim < 0.8f){
                    result = mFairy.findPic("topyun.png");
                    mFairy .onTap(0.8f,result,"风云榜",2000);
                }

                result = mFairy.findPic("yijian.png");
                mFairy .onTap(0.8f,result,"一键领取领取",2000);

                result = mFairy.findPic(new String[]{"lingqu.png","lingqu2.png"});
                mFairy .onTap(0.8f,result,"领取",2000);

                result = mFairy.findPic("Gifts.png");
                mFairy .onTap(0.8f,result,621,509,637,515,"馈赠",2000);


                result = mFairy.findPic("toptz.png");
                mFairy .onTap(0.8f,result,"boss挑战",2000);

                result1 = mFairy.findPic(new String[]{"fytop2.png","fytop3.png"});
                result = mFairy.findPic(46,334,1013,583,new String[]{"Challenge topyun.png","tz2.png"});
                mFairy .onTap(0.8f,result,"挑战小兵",2000);
                if (result.sim < 0.8f && result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"fytop.png","fytz.png"});
                    mFairy .onTap(0.8f,result,"挑战boss",2000);
                }
                result1 = mFairy.findPic("open auto.png");
                result = mFairy.findPic(new String[]{"auto.png","auto2.png","auto3.png"});
                mFairy .onTap(0.8f,result,"开启自动",Sleep);
//                if (result.sim < 0.8f && result1.sim < 0.8f){
//                    result = mFairy.findPic("Duel Arena.png");
//                    result2 = mFairy.findPic("Exit key.png");
//                    if (result.sim > 0.8f && result2.sim >0.8f){
//                        mFairy.onTap(1236,674,1246,680,"开启自动",Sleep);
//                    }
//
//                }
                result = mFairy.findPic("back2.png");
                mFairy .onTap(0.8f,result,"打完了退出",2000);

                result = mFairy.findPic("di.png");
                mFairy .onTap(0.8f,result,735,462,748,477,"战力较低继续挑战",2000);

                result = mFairy.findPic(new String[]{"bai.png","jibai.png"});
                mFairy .onTap(0.8f,result,"已击败",2000);

                result = mFairy.findPic("huode2.png");
                mFairy .onTap(0.8f,result,"退出",2000);

                result = mFairy.findPic("victory.png");
                mFairy .onTap(0.8f,result,"胜利",2000);

                result = mFairy.findPic("again.png");
                mFairy .onTap(0.8f,result,1056,659,1063,668,"退出",2000);
                if (result.sim > 0.8f){
                    LtLog.e("挑战失败");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "风云榜");
    }

    /**
     * 竞技人机练习
     */
    public void sports() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(3);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("ding.png");
                if (result.sim > 0.8f){
                    LtLog.e("1500分刷满了");
                    gameUtil.close();
                    setTaskEnd();return;
                }else {
                    result = mFairy.findPic("practice.png");
                    mFairy.onTap(0.8f,result,"人机练习",Sleep);
                }

                result = mFairy.findPic("Activeinterface.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("sport.png");
                    mFairy.onTap(0.8f,result,"竞技栏",Sleep);

                }else {
                    result = mFairy.findPic(1018,147,1271,246,"activity.png");
                    LtLog.e("=========================活动按钮相似度=="+result.sim);
                    mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);
                }

                result = mFairy.findPic("nozhu.png");
                mFairy.onTap(0.8f,result,966,34,976,42,"不在主城回汴京",2000);

                result = mFairy.findPic("Confer a title.png");
                mFairy.onTap(0.8f,result,531,464,544,474,"取消去授衔",2000);

                result = mFairy.findPic("tournament.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                mFairy.sleep(1000);

                result = mFairy.findPic("tournament.png");
                if (result.sim > 0.8f ) {
                    mFairy.onTap(1205, 368, 1218, 377, "绝技", Sleep);
                    mFairy.onTap(1207, 453, 1221, 463, "技能4", Sleep);
                    mFairy.onTap(1114, 467, 1131, 479, "技能三", Sleep);
                    mFairy.onTap(1035, 547, 1045, 560, "技能二", Sleep);
                    mFairy.onTap(1035, 650, 1047, 664, "技能一", Sleep);
                }
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            mFairy.sleep(2000);
//                            result = mFairy.findPic("tournament.png");
//                            if (result.sim > 0.8f ) {
//                                mFairy.onTap(1205, 368, 1218, 377, "绝技", Sleep);
//                                mFairy.onTap(1207, 453, 1221, 463, "技能4", Sleep);
//                                mFairy.onTap(1114, 467, 1131, 479, "技能三", Sleep);
//                                mFairy.onTap(1035, 547, 1045, 560, "技能二", Sleep);
//                                mFairy.onTap(1035, 650, 1047, 664, "技能一", Sleep);
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            result = mFairy.findPic("tournament.png");
//                            if (result.sim > 0.8f ) {
//                                mFairy.onTap(1144, 578, 1167, 591, "普工", 500);
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }).start();

                result = mFairy.findPic("continue.png");
                mFairy .onTap(0.8f,result,"继续",3000);
                mFairy .onTap(0.8f,result,912,489,921,502,"继续",2000);

                result = mFairy.findPic("plk.png");
                mFairy .onTap(0.8f,result,419,392,441,422,"继续2",2000);

                result1 = mFairy.findPic("practice.png");
                result = mFairy.findPic("practice back.png");
                mFairy.onTap(0.8f,result,"返回",Sleep);
                if(result.sim > 0.8f || result1.sim > 0.8f){
                    setTaskName(1);return;
                }
            }
            public void content_3() throws Exception{
                if (overtime(5,1))return;
                result = mFairy.findPic("Activeinterface.png");
                if (result.sim > 0.8f){
                    result = mFairy.findPic("XiangYang2.png");
                    mFairy.onTap(0.8f,result,"前往襄阳",Sleep);
                    mFairy.onTap(0.8f,result,31,25,45,34,"关闭",Sleep);
                }else {
                    result = mFairy.findPic(1018,147,1271,246,"activity.png");
                    LtLog.e("=========================活动按钮相似度=="+result.sim);
                    mFairy.onTap(0.8f, result, "活动入口",Sleep+2000);
                }


            }
        }.taskContent(mFairy, "竞技人机");
    }

    /**
     * 派遣
     */
    public void dispatch() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result = mFairy.findPic("menu.png");
                mFairy .onTap(0.8f,result,"菜单",2000);

                result1 = mFairy.findPic("friend.png");
                mFairy .onTap(0.8f,result1,"同伴",2000);
                result2 = mFairy.findPic("bag.png");
                if (result.sim < 0.8f && result1.sim<0.8f && result2.sim>0.8f){
                    result = mFairy.findPic("map yw.png");
                    mFairy .onTap(0.8f,result,"菜单",2000);

                }

                result = mFairy.findPic("dispatch.png");
                mFairy .onTap(0.8f,result,"派遣栏",2000);

                result = mFairy.findPic(149,564,1251,706,"harvest2.png");
                mFairy .onTap(0.8f,result,"收获",2000);
                mFairy .onTap(0.8f,result,620,499,633,510,"收获确定",2000);


                result = mFairy.findPic(149,564,1251,706,"dispatch2.png");
                mFairy .onTap(0.8f,result,"派遣",2000);

                result = mFairy.findPic("paiqian.png");
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("two").equals("1")) {
                        mFairy.onTap(545, 614, 558, 624, "2小时", 2000);
                    }else if (AtFairyConfig.getOption("four").equals("1")) {
                        mFairy.onTap(645, 615, 654, 621, "4小时", 2000);
                    }else if (AtFairyConfig.getOption("eight").equals("1")) {
                        mFairy.onTap(745, 617, 752, 623, "8小时", 2000);
                    }else {
                        LtLog.e("默认2小时");
                        mFairy.onTap(545, 614, 558, 624, "2小时", 2000);
                    }
                }
                result = mFairy.findPic("battle automatically.png");
                mFairy .onTap(0.8f,result,"自动上阵",2000);
                mFairy .onTap(0.8f,result,970,628,982,637,"自动上阵",2000);

                result = mFairy.findPic(149,564,1251,706,"harvest2.png");
                result1 = mFairy.findPic("cepq.png");
                result2 = mFairy.findPic(149,564,1251,706,"dispatch2.png");
                if (result.sim < 0.8f && result1.sim > 0.8f && result2.sim < 0.8f){
                    LtLog.e("派遣完成");
                    gameUtil.close();
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "派遣");
    }

    /**
     * 领奖
     */
    public void receive () throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(15,4))return;
                result = mFairy.findPic(new String[]{"open lan.png","open lan2.png"});
                mFairy .onTap(0.8f,result,"展开栏",2000);
                result1 = mFairy.findPic("activity.png");
                result2 = mFairy.findPic("bag.png");
                result3 = mFairy.findPic("topyun.png");
                result4 = mFairy.findPic(571,12,1156,122,"shengwang.png");
                if (result.sim < 0.8f&& result1.sim> 0.8f && result2.sim > 0.8f && result3.sim > 0.8f && result4.sim < 0.8f){
                    mFairy.onTap(1123,45,1128,50,"展开栏2",3000);
                }

                result = mFairy.findPic(571,12,1156,122,"email.png");
                mFairy .onTap(0.8f,result,"邮件",2000);

                result = mFairy.findPic(1020,624,1218,700,"One click claim.png");
                mFairy .onTap(0.8f,result,"一键领取",2000);

                result = mFairy.findPic("delread.png");
                mFairy .onTap(0.8f,result,"删除已读",2000);
                mFairy .onTap(0.8f,result,739,458,756,479,"确认删除已读",2000);
                mFairy .onTap(0.8f,result,484,405,491,412,"退出邮件",2000);

//                result = mFairy.findPic("email2.png");
//                if (result.sim > 0.8f && err == 2){
//                    mFairy.onTap(478,285,485,291,"退出邮件",Sleep);
//                }

            }
            public void content_2() throws Exception{
               // if (overtime(3,2))return;
                result = mFairy.findPic(new String[]{"open lan.png","open lan2.png"});
                mFairy .onTap(0.8f,result,"展开栏",2000);
                result1 = mFairy.findPic("activity.png");
                result2 = mFairy.findPic("bag.png");
                result3 = mFairy.findPic("topyun.png");
                result4 = mFairy.findPic(571,12,1156,122,"shengwang.png");
                if (result.sim < 0.8f&& result1.sim> 0.8f && result2.sim > 0.8f && result3.sim > 0.8f){
                    mFairy.onTap(1123,45,1128,50,"展开栏2",2500);
                }


                result = mFairy.findPic(571,12,1156,122,"welfare.png");
                mFairy .onTap(0.8f,result,"外面福利",2000);

                result = mFairy.findPic("welfare2.png");
                mFairy .onTap(0.8f,result,"里面福利",2000);

                result = mFairy.findPic(117,83,321,698,"on line.png");
                mFairy .onTap(0.8f,result,"在线领奖",2000);

                result = mFairy.findPic(339,511,1218,645,"online lq.png");
                mFairy .onTap(0.8f,result,"领奖",2000);
                result1 = mFairy.findPic("on line.png");
                if (result.sim < 0.8f && result1.sim > 0.8f){
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception{
                result = mFairy.findPic(117,83,321,698,"Retrieve.png");
                mFairy .onTap(0.8f,result,"奖励找回",2000);

//                result = mFairy.findPic("welfare.png");
//                mFairy .onTap(0.8f,result,"外面福利",2000);

                result = mFairy.findPic("back for free.png");
                mFairy .onTap(0.8f,result,"免费找回",2000);

                result = mFairy.findPic("back jl.png");
                mFairy .onTap(0.8f,result,"找回",2000);

                result = mFairy.findPic("back3.png");
                mFairy .onTap(0.8f,result,"确定找回",2000);

                result = mFairy.findPic("jiang.png");
                if(result.sim > 0.8f){
                    LtLog.e("领奖领完了");
                    gameUtil.close();
                    setTaskEnd();return;
                }
            }
            public void content_4() throws Exception {
                if (overtime(15,1))return;
                result = mFairy.findPic(new String[]{"open lan.png","open lan2.png"});
                mFairy .onTap(0.8f,result,"展开栏",2000);
                result1 = mFairy.findPic("activity.png");
                result2 = mFairy.findPic("bag.png");
                result3 = mFairy.findPic("topyun.png");
                result4 = mFairy.findPic(571,12,1156,122,"shengwang.png");
                if (result.sim < 0.8f&& result1.sim> 0.8f && result2.sim > 0.8f && result3.sim > 0.8f && result4.sim < 0.8f){
                    mFairy.onTap(1123,45,1128,50,"展开栏2",3000);
                }

                result = mFairy.findPic(571,12,1156,122,"prestige.png");
                mFairy .onTap(0.8f,result,"声望",2000);


                result = mFairy.findPic("prestige2.png");
                if (result.sim > 0.8f){
                    setTaskName(5);return;
                }

            }
            public void content_5() throws Exception {
                if (overtime(6,6))return;
                result = mFairy.findPic("tzsw.png");
                mFairy .onTap(0.8f,result,"挑战奖励界面",2000);

                result = mFairy.findPic(155,510,1189,678,"prestigelq.png");
                mFairy .onTap(0.8f,result,"领取",2000);

                result = mFairy.findPic("prestige2.png");
                if (result.sim < 0.8f){
                    setTaskName(4);return;
                }

            }
            public void content_6() throws Exception {
                if (overtime(10,7))return;
                result = mFairy.findPic("grow up.png");
                mFairy .onTap(0.8f,result,"成长奖励界面",2000);

                result = mFairy.findPic(1000,128,1220,682,"prestigelq.png");
                mFairy .onTap(0.8f,result,"领取",2000);
                if (result.sim < 0.8f){
                    setTaskName(7);
                }
                result = mFairy.findPic("prestige2.png");
                if (result.sim < 0.8f){
                    setTaskName(4);return;
                }
                mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 0, 775,623, 775,195, 1000, 1500);
            }
            public void content_7() throws Exception {
                if (overtime(10,8))return;
                result = mFairy.findPic(72,56,1229,135,"red.png");
                mFairy .onTap(0.8f,result,result.x-50,result.y+20,result.x-49,result.y+21,"选阶",2000);
                if (result.sim > 0.8f){
                    setTaskName(6);return;
                }
                result = mFairy.findPic("prestige2.png");
                if (result.sim < 0.8f){
                    setTaskName(4);return;
                }
                mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 0, 1137,99, 371,99, 1000, 1500);
            }
            public void content_8() throws Exception {
                if (overtime(10,9))return;
                result = mFairy.findPic("everyday.png");
                mFairy .onTap(0.8f,result,"每日奖励界面",2000);

                result = mFairy.findPic(1016,57,1226,646,"prestigelq.png");
                mFairy .onTap(0.8f,result,"领取",2000);

                result = mFairy.findPic("prestige2.png");
                if (result.sim < 0.8f){
                    setTaskName(4);return;
                }
            }
            public void content_9() throws Exception {
                if (overtime(12,99))return;
                result = mFairy.findPic("reward.png");
                mFairy .onTap(0.8f,result,"奖励界面",2000);

                result = mFairy.findPic(173,182,945,344,"red2.png");
                mFairy .onTap(0.8f,result,result.x+40,result.y+40,result.x+41,result.y+41,"奖励",2000);

                result = mFairy.findPic("prestige2.png");
                if (result.sim < 0.8f){
                    setTaskName(4);return;
                }
                if (err == 11){
                    gameUtil.close();
                   setTaskEnd();return;
                }
                mFairy.taskSlid(err, new int[]{0, 3, 6, 9}, 3, 845,292, 316,310, 1000, 1500);
            }
            public void content_10() throws Exception {
                result = mFairy.findPic("menu.png");
                mFairy .onTap(0.8f,result,"菜单",2000);
                result1 = mFairy.findPic("gang.png");
                mFairy .onTap(0.8f,result1,"帮会",2000);
                result2 = mFairy.findPic("bag.png");
                if (result.sim < 0.8f && result1.sim<0.8f && result2.sim>0.8f){
                    result = mFairy.findPic("map yw.png");
                    mFairy .onTap(0.8f,result,"菜单",2000);

                }

                result = mFairy.findPic("bhlq.png");
                mFairy .onTap(0.8f,result,"领取一次",2000);

                result = mFairy.findPic(724,496,1275,670,new String[]{"juanxian.png","yinzi.png"});
                if (result.sim > 0.8f){
                    LtLog.e("完事了");
                    gameUtil.close();
                   setTaskName(2);return;
                }else {
                    result = mFairy.findPic(724,496,1275,670,"donate.png");
                    mFairy .onTap(0.8f,result,"捐献一次",2000);
                }

                result = mFairy.findPic("banglist.png");
                if (result.sim > 0.8f){
                    LtLog.e("没有帮会");
                    gameUtil.close();
                    setTaskName(2);return;
                }
            }
        }.taskContent(mFairy, "领奖");
    }

    /**
     * 野外挂机
     */
    public void field () throws Exception {
        new SingleTask(mFairy) {
            boolean tlho = false;
            boolean zs = false;
            boolean wc = false;
            boolean wp = false;
            boolean erg = false;
            boolean mhys = false;
            boolean gcdb = false;
            boolean wzxy =false;
            boolean bhwq =false;
            boolean shenb = false;
            ControlSplit qb =null;
            public void create() throws Exception{
                //清包
                if (!AtFairyConfig.getOption("optime1").equals("")) {
                    qb = strSplit(AtFairyConfig.getOption("optime1"));
                }
                if (AtFairyConfig.getOption("tlho").equals("1")){
                    tlho=true;
                }
                if (AtFairyConfig.getOption("zs").equals("1")){
                    zs=true;
                }
                if (AtFairyConfig.getOption("wc").equals("1")){
                    wc=true;
                }
                if (AtFairyConfig.getOption("erg").equals("1")){
                    erg=true;
                }
                if (AtFairyConfig.getOption("mhys").equals("1")){
                    mhys=true;
                }
                if (AtFairyConfig.getOption("bhwq").equals("1")){
                    bhwq=true;
                }
                if (AtFairyConfig.getOption("shenb").equals("1")){
                    shenb=true;
                }
                if (AtFairyConfig.getOption("gcdb").equals("1")&& AtFairyConfig.getOption("7262").equals("1")){
                    gcdb=true;
                }
                if (AtFairyConfig.getOption("wzxy").equals("1")&& AtFairyConfig.getOption("7262").equals("1")){
                    wzxy=true;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                int hour = mFairy.dateHour();
                int min = mFairy.dateMinute();
                int sum = hour*60+min;
                if (tlho) {
                    if ((hour >= 12 && hour < 13) || (hour >= 16 && hour < 17) || (sum >= 1290 && sum < 1350)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入天雷荒火");
                        int ret = gameUtil.missionTimelimitn("Sky thunder.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                tlho = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //天雷荒火
                                timingActivity.skyThunder();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                tlho = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }

                if (zs) {
                    if ((hour >= 13 && sum < 870) || (hour >= 18 && sum < 1170) || (hour >= 22 && hour < 23)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入种树");
                        int ret = gameUtil.missionTimelimitn("tree.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                zs = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //种树
                                timingActivity.plantingTrees();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                zs = false;
                                gameUtil.close();
                                break;

                        }



                    }
                }

                if (wc) {
                    if (hour >= 18 && hour < 19) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入晚间盛宴");
                        int ret = gameUtil.missionTimelimitn("dinner.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                wc = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //晚间盛宴
                                timingActivity.dinner();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                wc = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }

                if (erg) {
                    if (hour == 20 && min < 30) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入恶人谷");
                        int ret = gameUtil.missionTimelimitn("Valley.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                erg = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //恶人谷
                                timingActivity.alley();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                erg = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }
                if (mhys) {
                    if (sum >= 1290 && sum < 1350) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入梦华夜市");
                        int ret = gameUtil.missionTimelimitn("night.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                mhys = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //梦华夜市
                                timingActivity.nightMarket();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                mhys = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }
                if (gcdb) {
                    if ((sum >= 615 && sum < 620) || (sum >= 675 && sum < 680) || (sum >= 735 && sum < 740) || (sum >= 795 && sum < 800) || (sum >= 855 && sum < 860) || (sum >= 915 && sum < 920) || (sum >= 975 && sum < 980) || (sum >= 1035 && sum < 1040) || (sum >= 1095 && sum < 1100) || (sum >= 1155 && sum < 1160) || (sum >= 1215 && sum < 1220) || (sum >= 1275 && sum < 1280) || (sum >= 1335 && sum < 1340)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===古城夺宝");
                        result = mFairy.findPic("battle auto.png");
                        mFairy.onTap(0.8f, result, 1242,680,1249,685,"关闭自动战斗", Sleep);
                        if (result.sim < 0.8f) {
                            if (AtFairyConfig.getOption("gbcs").equals("1")) {
                                result = mFairy.findPic("Activeinterface.png");
                                if (result.sim > 0.8f) {
                                    result = mFairy.findPic("battlefield.png");
                                    mFairy.onTap(0.8f, result, "战场", Sleep);
                                    result = mFairy.findPic("ancientCity.png");
                                    mFairy.onTap(0.8f, result, "古城夺宝", 2000);

                                } else {
                                    result = mFairy.findPic(1018, 147, 1271, 246, "activity.png");
                                    LtLog.e("=========================活动按钮相似度==" + result.sim);
                                    mFairy.onTap(0.8f, result, "活动入口", Sleep + 2000);
                                }


                                result1 = mFairy.findPic("oldcity2.png");
                                if (result1.sim > 0.8f) {
                                    result = mFairy.findPic("gecishu.png");
                                    if (result.sim > 0.8f && result1.sim > 0.8f) {
                                        gameUtil.close();
                                        LtLog.e("高额次数已经打完了结束");
                                        gcdb = false;
                                    } else {
                                        timingActivity.ancientCity();
                                    }
                                }

                            } else {
                                timingActivity.ancientCity();
                            }
                        }
                    }
                }
                    if (wzxy) {
                        if ((sum>=645 && sum < 650) ||  (sum >= 705 && sum < 710)|| (sum >= 765 && sum < 770 )||(sum >= 825 && sum < 830 )||(sum >= 885 && sum <890)||(sum >= 945 && sum < 950)||(sum >= 1005 && sum < 1010)||( sum >=1065 && sum < 1070 )||( sum >= 1125 && sum< 1130)||( sum >= 1185 && sum < 1190)||( sum >= 1245 && sum < 1250)||( sum >=1305 && sum < 1310)||( sum >= 1365 && sum <1370) ) {
                            LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===雾原血战");
                            result = mFairy.findPic("battle auto.png");
                            mFairy.onTap(0.8f, result, 1242,680,1249,685,"关闭自动战斗", Sleep);
                            if (result1.sim < 0.8f) {
                                if (AtFairyConfig.getOption("gbcs").equals("1")) {
                                    result = mFairy.findPic("Activeinterface.png");
                                    if (result.sim > 0.8f) {
                                        result = mFairy.findPic("battlefield.png");
                                        mFairy.onTap(0.8f, result, "战场", Sleep);
                                        result = mFairy.findPic("Bloody.png");
                                        mFairy.onTap(0.8f, result, "雾原血战", Sleep);

                                    } else {
                                        result = mFairy.findPic(1018, 147, 1271, 246, "activity.png");
                                        LtLog.e("=========================活动按钮相似度==" + result.sim);
                                        mFairy.onTap(0.8f, result, "活动入口", Sleep + 2000);
                                    }


                                    result1 = mFairy.findPic("wuyuan.png");
                                    if (result1.sim > 0.8f) {
                                        result = mFairy.findPic("gecishu.png");
                                        if (result.sim > 0.8f) {
                                            gameUtil.close();
                                            LtLog.e("高额次数已经打完了结束");
                                            wzxy = false;
                                        } else {
                                            timingActivity.wuyuan();
                                        }
                                    }

                                } else {
                                    timingActivity.wuyuan();
                                }
                            }
                         }
                     }

                if (bhwq){
                    if (sum >= 1205 && sum < 1230) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入帮会温泉");

                        timingActivity.hotSpring();
                    }

                }
               /* if (shenb) {
                    if ((sum >= 780 && sum < 870) || (sum >= 1080 && sum < 1170) || (hour >= 22 && hour < 23)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入神捕");
                        int ret = gameUtil.missionTimelimitn("shenbu.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                zs = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //神捕
                                timingActivity.shenbu();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                zs = false;
                                gameUtil.close();
                                break;

                        }
                    }
                }*/
                if (err == 4){
                    LtLog.e("关叉");
                    gameUtil.close();
                }
                if (overtime(5,2))return;
            }
            public void content_2() throws Exception{
               // long datime = mFairy.mMatTime(1165,123,96,22,0.9f);
                result = mFairy.findPic(5,1,284,106,"Activeinterface.png");
                mFairy.onTap(0.8f,result,39,23,48,32,"关闭活动界面",2000);

                result = mFairy.findPic("battle auto.png");
                mFairy.onTap(0.8f,result,1243,676,1251,686,"关闭自动战斗",2000);

                result3 = mFairy.findPic("Finding the way auto.png");
                if (result3.sim <0.8f) {

                    result = mFairy.findPic(new String[]{"menu.png", "map yw.png"});
                    mFairy.onTap(0.8f, result, 1213, 81, 1223, 88, "地图", 2000);
                }
                result = mFairy.findPic("Dao Xiang map.png");
                if(result.sim > 0.8f){
                    result = mFairy.findPic(299,6,997,713,"bandit.png");
                    mFairy.onTap(0.8f, result, "土匪", 2000);
                    result = mFairy.findPic("Dao Xiang map.png");
                    mFairy.onTap(0.8f, result, 36,31,45,38,"还在原来位置", 2000);
                }else {
                    result = mFairy.findPic("word map.png");
                    mFairy.onTap(0.8f, result, "世界地图", 2000);
                }

                result = mFairy.findPic(new String[]{"Dao Xiang.png","Dao Xiang2.png"});
                mFairy .onTap(0.8f,result,"稻香村",1000);

                result = mFairy.findPic(396,174,911,449,"mapcs.png");
                mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

                result = mFairy.findPic("Dao Xiang Cun.png");
                result3 = mFairy.findPic("Finding the way auto.png");
                if(result.sim >0.8f && result3.sim < 0.8f ){
                    LtLog.e("到达挂机位置");
                    timekeepInit("挂机位置");
                    timekeepInit("野外挂机清理背包");
                    mFairy.initMatTime();
                    setTaskName(3);return;
                }
            }
            public void content_3() throws Exception{
                long datime = mFairy.mMatTime(1165,123,96,22,0.9f);

                if (datime > 30){
                    LtLog.e("发呆中。。。。从新定位");
                    result = mFairy.findPic("battle auto.png");
                    mFairy.onTap(0.8f,result,1243,676,1251,686,"关闭自动战斗",2000);
                    setTaskName(2);return;
                }
                int hour = mFairy.dateHour();
                int min = mFairy.dateMinute();
                int sum = hour*60+min;
                LtLog.e("当前时间"+hour+"时"+min+"分====="+sum+"总分钟");
                if (tlho) {
                    if ((hour >= 12 && hour < 13) || (hour >= 16 && hour < 17) || (sum >= 1290 && sum < 1350)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入天雷荒火");
                        int ret = gameUtil.missionTimelimitn("Sky thunder.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                tlho = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //天雷荒火
                                timingActivity.skyThunder();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                tlho = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }

                if (zs) {
                    if ((hour >= 13 && sum < 870) || (hour >= 18 && sum < 1170) || (hour >= 22 && hour < 23)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入种树");
                        int ret = gameUtil.missionTimelimitn("tree.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                zs = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //种树
                                timingActivity.plantingTrees();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                zs = false;
                                gameUtil.close();
                                break;

                        }



                    }
                }

                if (wc) {
                    if (hour >= 18 && hour < 19) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入晚间盛宴");
                        int ret = gameUtil.missionTimelimitn("dinner.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                wc = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //晚间盛宴
                                timingActivity.dinner();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                wc = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }
                if (erg) {
                    if (hour == 20 && min < 30) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入恶人谷");
                        int ret = gameUtil.missionTimelimitn("Valley.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                erg = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //恶人谷
                                timingActivity.alley();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                erg = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }
                if (mhys) {
                    if (sum >= 1290 && sum < 1350) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入梦华夜市");
                        int ret = gameUtil.missionTimelimitn("night.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                mhys = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //梦华夜市
                                timingActivity.nightMarket();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                mhys = false;
                                gameUtil.close();
                                break;
                        }
                    }
                }
                if (gcdb) {
                    if ((sum >= 615 && sum < 620) || (sum >= 675 && sum < 680) || (sum >= 735 && sum < 740) || (sum >= 795 && sum < 800) || (sum >= 855 && sum < 860) || (sum >= 915 && sum < 920) || (sum >= 975 && sum < 980) || (sum >= 1035 && sum < 1040) || (sum >= 1095 && sum < 1100) || (sum >= 1155 && sum < 1160) || (sum >= 1215 && sum < 1220) || (sum >= 1275 && sum < 1280) || (sum >= 1335 && sum < 1340)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===古城夺宝");
                        result = mFairy.findPic("battle auto.png");
                        mFairy.onTap(0.8f, result, 1242,680,1249,685,"关闭自动战斗", Sleep);
                        if (result.sim < 0.8f) {
                            if (AtFairyConfig.getOption("gbcs").equals("1")) {
                                result = mFairy.findPic("Activeinterface.png");
                                if (result.sim > 0.8f) {
                                    result = mFairy.findPic("battlefield.png");
                                    mFairy.onTap(0.8f, result, "战场", Sleep);

                                    result = mFairy.findPic("ancientCity.png");
                                    mFairy.onTap(0.8f, result, "古城夺宝", 2000);

                                } else {
                                    result = mFairy.findPic(1018, 147, 1271, 246, "activity.png");
                                    LtLog.e("=========================活动按钮相似度==" + result.sim);
                                    mFairy.onTap(0.8f, result, "活动入口", Sleep + 2000);
                                }

                                result1 = mFairy.findPic("oldcity2.png");
                                if (result1.sim > 0.8f) {
                                    result = mFairy.findPic("gecishu.png");
                                    if (result.sim > 0.8f && result1.sim > 0.8f) {
                                        gameUtil.close();
                                        LtLog.e("高额次数已经打完了结束");
                                        gcdb = false;
                                    } else {
                                        timingActivity.ancientCity();
                                    }
                                }
                            } else {
                                timingActivity.ancientCity();
                            }
                        }
                    }
                }
                if (wzxy) {
                    if ((sum>=645 && sum < 650) ||  (sum >= 705 && sum < 710)|| (sum >= 765 && sum < 770 )||(sum >= 825 && sum < 830 )||(sum >= 885 && sum <890)||(sum >= 945 && sum < 950)||(sum >= 1005 && sum < 1010)||( sum >=1065 && sum < 1070 )||( sum >= 1125 && sum< 1130)||( sum >= 1185 && sum < 1190)||( sum >= 1245 && sum < 1250)||( sum >=1305 && sum < 1310)||( sum >= 1365 && sum <1370) ) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===雾原血战");
                        result = mFairy.findPic("battle auto.png");
                        mFairy.onTap(0.8f, result, 1242,680,1249,685,"关闭自动战斗", Sleep);
                        if (result.sim < 0.8f) {
                            if (AtFairyConfig.getOption("gbcs").equals("1")) {
                                result = mFairy.findPic("Activeinterface.png");
                                if (result.sim > 0.8f) {
                                    result = mFairy.findPic("battlefield.png");
                                    mFairy.onTap(0.8f, result, "战场", Sleep);

                                    result = mFairy.findPic("Bloody.png");
                                    mFairy.onTap(0.8f, result, "雾原血战", Sleep);
                                } else {
                                    result = mFairy.findPic(1018, 147, 1271, 246, "activity.png");
                                    LtLog.e("=========================活动按钮相似度==" + result.sim);
                                    mFairy.onTap(0.8f, result, "活动入口", Sleep + 2000);
                                }


                                result1 = mFairy.findPic("wuyuan.png");
                                if (result1.sim > 0.8f) {
                                    result = mFairy.findPic("gecishu.png");
                                    if (result.sim > 0.8f) {
                                        gameUtil.close();
                                        LtLog.e("高额次数已经打完了结束");
                                        wzxy = false;
                                    } else {
                                        timingActivity.wuyuan();
                                    }
                                }

                            } else {
                                timingActivity.wuyuan();
                            }
                        }

                    }
                }
                if (bhwq){
                    if (sum >= 1205 && sum < 1230) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入帮会温泉");
                        timingActivity.hotSpring();
                    }

                }
               /* if (shenb) {
                    if ((sum >= 780 && sum < 870) || (sum >= 1080 && sum < 1170) || (hour >= 22 && hour < 23)) {
                        LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入神捕");
                        int ret = gameUtil.missionTimelimitn("shenbu.png", 0);
                        switch (ret) {
                            case 0:
                                LtLog.e("任务已完成");
                                zs = false;
                                gameUtil.close();
                                break;
                            case 1:
                                LtLog.e("任务可以参加");
                                //神捕
                                timingActivity.shenbu();
                                break;
                            case 2:
                                LtLog.e("任务还没解锁");
                                zs = false;
                                gameUtil.close();
                                break;

                        }
                    }
                }*/
                if (qb != null && qb.choice == 1 && timekeep(5, qb.timeMillis, "野外挂机清理背包")) {
                    gameUtil.clearBag();
                    timekeepInit("野外挂机清理背包");
                }
                if (AtFairyConfig.getOption("6926").equals("1")){

                    if (AtFairyConfig.getOption("two").equals("1")) {
                         wp = timekeep(1,7200000,"委派");//7200    14400   28800
                        LtLog.e("委派2小时");
                    }else if (AtFairyConfig.getOption("four").equals("1")) {
                         wp = timekeep(1,14400000,"委派");//7200    14400   28800
                        LtLog.e("委派4小时");
                    }else if (AtFairyConfig.getOption("eight").equals("1")) {
                         wp = timekeep(1,28800000,"委派");//7200    14400   28800
                         LtLog.e("委派8小时");
                    }
                    if (wp){
                        LtLog.e("委派时间");
//                        if (tlho) {
//                            if ((hour >= 12 && hour < 13) || (hour >= 16 && hour < 17) || (sum >= 1290 && sum < 1350)) {
//                                LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入天雷荒火");
//                                int ret = gameUtil.missionTimelimitn("Sky thunder.png", 0);
//                                switch (ret) {
//                                    case 0:
//                                        LtLog.e("任务已完成");
//                                        tlho = false;
//                                        gameUtil.close();
//                                        break;
//                                    case 1:
//                                        LtLog.e("任务可以参加");
//                                        //天雷荒火
//                                        timingActivity.skyThunder();
//                                        break;
//                                    case 2:
//                                        LtLog.e("任务还没解锁");
//                                        tlho = false;
//                                        gameUtil.close();
//                                        break;
//                                }
//                            }
//                        }
//
//                        if (zs) {
//                            if ((hour >= 13 && sum < 870) || (hour >= 18 && sum < 1170) || (hour >= 22 && hour < 23)) {
//                                LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入种树");
//                                int ret = gameUtil.missionTimelimitn("tree.png", 0);
//                                switch (ret) {
//                                    case 0:
//                                        LtLog.e("任务已完成");
//                                        zs = false;
//                                        gameUtil.close();
//                                        break;
//                                    case 1:
//                                        LtLog.e("任务可以参加");
//                                        //种树
//                                        timingActivity.plantingTrees();
//                                        break;
//                                    case 2:
//                                        LtLog.e("任务还没解锁");
//                                        zs = false;
//                                        gameUtil.close();
//                                        break;
//
//                                }
//
//
//
//                            }
//                        }
//
//                        if (wc) {
//                            if (hour >= 18 && hour < 19) {
//                                LtLog.e("当前时间" + hour + "时" + min + "分=====" + sum + "总分钟===进入晚间盛宴");
//                                int ret = gameUtil.missionTimelimitn("dinner.png", 0);
//                                switch (ret) {
//                                    case 0:
//                                        LtLog.e("任务已完成");
//                                        wc = false;
//                                        gameUtil.close();
//                                        break;
//                                    case 1:
//                                        LtLog.e("任务可以参加");
//                                        //晚间盛宴
//                                        timingActivity.dinner();
//                                        break;
//                                    case 2:
//                                        LtLog.e("任务还没解锁");
//                                        wc = false;
//                                        gameUtil.close();
//                                        break;
//                                }
//                            }
//                        }
                        dispatch();//派遣
                        timekeepInit("委派");
                    }

                }


                boolean gj = timekeep(1,300000,"挂机位置");
                if(gj){
                    LtLog.e("5分钟重置下位置");
                    setTaskName(2);return;
                }
                result1 = mFairy.findPic("Finding the way auto.png");
                result = mFairy.findPic("Dao Xiang Cun.png");
                if(result.sim > 0.8f && result1.sim < 0.8f) {
                    result = mFairy.findPic(new String[]{"auto.png", "auto2.png", "auto3.png"});
                    mFairy.onTap(0.8f, result, "开启自动", Sleep);
                }

                result = mFairy.findPic(530,423,771,551,"Power saving.png");
                mFairy.onTap(0.8f, result, "点击省电模式", Sleep);

                long dazeTime = mFairy.mMatTime(1170,124,88,21, 0.9f);
                LtLog.e("发呆时间"+dazeTime);
                result3 = mFairy.findPic("Finding the way auto.png");
                result2 = mFairy.findPic("battle auto.png");
                if (dazeTime >= 30 && result3.sim < 0.8f & result2.sim < 0.8f){
                    LtLog.e("发呆了重置下位置");
                    setTaskName(2);return;

                }
            }
        }.taskContent(mFairy, "野外挂机");
    }

}