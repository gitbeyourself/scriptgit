package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    GameUtil gameUtil;


    public SingleTask(AtFairyImpl ATFairy) throws Exception {
        Sleep = 2000;
        mFairy = ATFairy;
        gameUtil = new GameUtil(mFairy);

    }
    /**
     * 第一阶段新手主线任务
     *
     * @throws Exception
     */
    int count =0;
    int count2 =0;
    int count3 =0;
    int dt = 0;
    public void novice() throws Exception{
        new SingleTask(mFairy) {
            boolean diyi =false;
            boolean secend =false;
           List<String> str = new ArrayList<>();
            public void create() throws Exception{
                if(!AtFairyConfig.getOption("zddhm").equals("")) {
                    String coord = AtFairyConfig.getOption("zddhm");
                    String coords [] = coord.split("/");
                    for (int i =0; i < coords.length; i++){
                        str.add(coords[i]);
                    }
                    //setTaskName(4);return;
                }
                if (AtFairyConfig.getOption("dwdyz").equals("1")){
                    diyi =true;
                }
                if (AtFairyConfig.getOption("dwdyz").equals("2")){
                    secend =true;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
//                if (count2 == 0){
//                    setTaskName(4);return;
//                }
                setTaskName(1);
            }
            public void content_1() throws Exception {

                setTaskName(2);return;

            }
            public void content_2() throws Exception {
                result =mFairy.findPic("Head portrait.png");
                mFairy.onTap(0.8f,result,90,802,107,826,"第一次上阵英雄",Sleep);

                result =mFairy.findPic("Energy tank.png");
                mFairy.onTap(0.8f,result,422,1107,445,1129,"第一次释放技能",Sleep);

                result =mFairy.findPic("new hero.png");
                mFairy.onTap(0.8f,result,20,1208,42,1238,"新英雄",Sleep);

                result =mFairy.findPic("Challenge boss.png");
                mFairy.onTap(0.8f,result,"挑战boss",Sleep);

                result =mFairy.findPic(165,895,584,1085,"Challenge boss2.png");
                mFairy.onTap(0.8f,result,"挑战boss2",Sleep);

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic("Hurry up.png");
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("hotgirl.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(84,236);
                    mFairy.touchMove(94,442,1000);
                    mFairy.touchUp();
                }

                result =mFairy.findPic("newfirend.png");
                mFairy.onTap(0.8f,result,499,1211,509,1228,"新伙伴",Sleep);

                result =mFairy.findPic("fail.png");
                mFairy.onTap(0.8f,result,"失败",Sleep);
                if(result.sim > 0.8f){
                    count++;
                    setTaskName(3);return;
                }
                if (count >= 5){
                    count=0;
                   setTaskName(4);return;
                }
                result =mFairy.findPic("Next chapter.png");
                mFairy.onTap(0.8f,result,"下一章",Sleep);

                result =mFairy.findPic("Go to.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);
                if (result.sim > 0.8f){
                    result =mFairy.findPic("territory.png");
                    mFairy.onTap(0.8f,result,"领地",2000);
                    mFairy.onTap(0.8f,result,202,888,212,903,"月光酒馆",2000);
                    mFairy.onTap(0.8f,result,221,964,242,983,"单抽",2000);
                    mFairy.onTap(0.8f,result,342,562,372,592,"单抽",15000);
                    mFairy.onTap(0.8f,result,342,562,372,592,"单抽",2000);
                    result =mFairy.findPic("new hero.png");
                    if (result.sim >0.8f){
                        gameUtil.close();
                    }
                    setTaskName(5);return;
                }

                result =mFairy.findPic("zhucheng.png");
                mFairy.onTap(0.8f,result,68,1213,91,1234,"主城",Sleep);

                result =mFairy.findPic("Rank promotion.png");
                mFairy.onTap(0.8f,result,"等级提升",Sleep);

                result =mFairy.findPic("littlefive.png");
                mFairy.onTap(0.8f,result,230,841,252,850,"少于5名取消",Sleep);
                mFairy.onTap(0.8f,result,51,726,59,743,"全部下阵",Sleep);
                mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);

                result =mFairy.findPic(0,0,720,1080,"hand.png");//331 558   376,611
                mFairy.onTap(0.7f,result,result.x+45,result.y+53,result.x+46,result.y+54,"引导手",Sleep);
                result =mFairy.findPic("hand2.png");//331 558   376,611
                mFairy.onTap(0.7f,result,"引导手2",Sleep);
            }
            public void content_3() throws Exception {
                long dazeTime=mFairy.mMatTime(572,104,34,18,0.9f);
                result =mFairy.findPic("hero.png");
                mFairy.onTap(0.8f,result,"英雄栏",2000);
                mFairy.onTap(0.8f,result,103,983,127,1006,"全部英雄",Sleep);

                result =mFairy.findPic(14,108,718,389,"exclamation mark.png");
                mFairy.onTap(0.8f,result,"可以穿戴装备的英雄",Sleep);

                result =mFairy.findPic("hero2.png");
                mFairy.onTap(0.8f,result,"英雄栏2",Sleep);

                result =mFairy.findPic("ydchuandai.png");
                mFairy.onTap(0.8f,result,result.x-53,result.y+30,result.x-52,result.y+31,"一键穿装",Sleep);

                result =mFairy.findPic("upgrade.png");
                mFairy.onTap(0.8f, result, "升级", Sleep);

                result =mFairy.findPic("confirm.png");
                mFairy.onTap(0.8f,result,"确认",Sleep);

                result =mFairy.findPic("herojy.png");
                if (result.sim > 0.8f || dazeTime >= 60){
                    mFairy.initMatTime();
                    setTaskName(0);return;
                }

                result =mFairy.findPic(25,98,720,328,"hotgirl2.png");
                mFairy.onTap(0.8f, result, "升级火女", Sleep);


            }
            public void content_4() throws Exception{
                if (overtime(8,0))return;
                result =mFairy.findPic("hero.png");
                mFairy.onTap(0.8f,result,53,42,76,60,"头像",Sleep);

                result =mFairy.findPic(new String[]{"Set up.png","Set up2.png"});
                mFairy.onTap(0.8f,result,"设置",Sleep);

                for ( String into: str) {
                result =mFairy.findPic(70,491,666,685,"Exchange code.png");
                mFairy.onTap(0.8f,result,"兑换码",Sleep);

                result =mFairy.findPic("Exchange code2.png");
                   if (result.sim > 0.8f){
                       mFairy.onTap(0.8f,result,186,626,204,642,"输入",Sleep);
                       mFairy.inputText(into);
                       mFairy.onTap(0.8f,result,449,850,487,867,"确定",Sleep);
                       mFairy.onTap(0.8f,result,449,850,487,867,"确定",3000);
                   }

                }

                    if (err == 5){
                        setTaskEnd();return;
                    }
            }
            public void content_5() throws Exception{
                if (overtime(8,4))return;
                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("World map.png");
                mFairy.onTap(0.8f,result,"世界地图",Sleep);
                if (diyi){
                    result =mFairy.findPic(0,0,720,128,"first zhang.png");
                    if (result.sim >0.8f){
                        diyi =false;
                        setTaskName(4);return;
                    }else {
                        setTaskName(0);return;
                    }

                   // setTaskName(4);return;
                }
                if (secend){
                    result =mFairy.findPic(0,0,720,128,"secend zhang.png");
                    if (result.sim >0.8f){
                        secend =false;
                        setTaskName(4);return;
                    }else {
                        setTaskName(0);return;
                    }
                    //setTaskName(4);return;

                }
                result =mFairy.findPic(0,0,720,1080,"hand.png");//331 558   376,611
                mFairy.onTap(0.7f,result,result.x+45,result.y+53,result.x+46,result.y+54,"引导手",Sleep);
                result =mFairy.findPic("hand2.png");//331 558   376,611
                mFairy.onTap(0.7f,result,"引导手2",Sleep);
            }
        }.taskContent(mFairy, "初始引导");
    }


    /**
     * 战役
     */
    public void campaign() throws Exception {
        new SingleTask(mFairy) {
            int zycs = 0;
            public void create() throws Exception{
                if(!AtFairyConfig.getOption("sbcs").equals("")){
                    zycs=Integer.parseInt(AtFairyConfig.getOption("sbcs"));
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic("Challenge boss.png");
                mFairy.onTap(0.8f,result,"挑战boss",Sleep);

                result =mFairy.findPic(165,895,584,1085,"Challenge boss2.png");
                mFairy.onTap(0.8f,result,"挑战boss2",Sleep);

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Next chapter.png");//336,557   374,605
                mFairy.onTap(0.8f,result,result.x+38,result.y+50,result.x+39,result.y+51,"下一章",Sleep);

                result =mFairy.findPic(0,0,720,1080,"hand.png");
                mFairy.onTap(0.8f,result,"选择下一地图",Sleep);

                result =mFairy.findPic("Go to.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);

                result =mFairy.findPic("classq.png");
                mFairy.onTap(0.8f,result,"等级提升",Sleep);

                result =mFairy.findPic("onlytz.png");
                mFairy.onTap(0.8f,result,252,730,262,739,"不在提示",Sleep);
                mFairy.onTap(0.8f,result,351,793,363,804,"确定",Sleep);

                result =mFairy.findPic("zhucheng.png");
                mFairy.onTap(0.8f,result,68,1213,91,1234,"主城",Sleep);

                if (AtFairyConfig.getOption("bd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    zycs --;
                    LtLog.e("失败次数剩余:"+zycs);
                    if (zycs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,366,1114,386,1127,"胜利继续",Sleep);
                


            }
        }.taskContent(mFairy, "战役");
    }


    /**
     * 快速挂机
     */
    int gjcs = 0;
    int ksgjnum = 0;
    public void quickHang() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if(!AtFairyConfig.getOption("gjcs").equals("")){
                    gjcs=Integer.parseInt(AtFairyConfig.getOption("gjcs"));
                }
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                if (overtime(30,0))return;
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);


                result =mFairy.findPic( 0,1160,718,1277,"fanhui.png");
                mFairy.onTap(0.8f,result,"返回",Sleep);

                result =mFairy.findPic(new String[]{"Hang up lq.png","Hang up lq2.png"});
                mFairy.onTap(0.8f,result,"宝箱领取",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic(218,1123,511,1271,"zhanyi.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result1 = mFairy.findPic("Quick hang up.png");
                mFairy.onTap(0.8f, result1, "快速挂机", Sleep);
                if (gjcs==0 || gjcs==1) {
                    result = mFairy.findPic(310,776,659,910,"Free collection.png");
                    mFairy.onTap(0.8f, result, "领取", 3000);
                    if (result.sim>0.8f){
                        ksgjnum =1000;
                    }
                    result = mFairy.findPic(310,776,659,910,"make.png");
                    mFairy.onTap(0.8f, result, 224,833,251,853,"关闭", 3000);
                    if (result.sim>0.8f){
                        ksgjnum =1000;
                    }
                }else {
                    result = mFairy.findPic(310,776,659,910,new String[]{"Free collection.png","make.png"});
                    mFairy.onTap(0.8f, result, "领取", 3000);
                    if(result.sim>0.8f) {
                        ksgjnum++;
                    }
                }

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);


                result = mFairy.findPic(310,776,659,910,"make.png");
                mFairy.onTap(0.8f, result, 224,833,251,853,"关闭", 3000);

                if (gjcs == ksgjnum){
                    LtLog.e("快速挂机完成结束");
                    setTaskEnd();return;
                }
                if ( ksgjnum == 1000){
                    LtLog.e("快速挂机1次结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("In cooling.png");
                if (result.sim > 0.8f){
                    LtLog.e("快速挂机没次数了结束");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "快速挂机");
    }

    /**
     * 王座之塔
     */
    public void towerThrone() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean wzzt = false;
            boolean gzzj =false;
            boolean lczk = false;
            boolean cczz =false;
            boolean qhzm =false;
            boolean yszq = false;
            boolean jyzy = false;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            boolean bd7 =false;
            public void create() throws Exception {

                if (AtFairyConfig.getOption("wzzt").equals("1")){
                   wzzt=true;
                }
                if (AtFairyConfig.getOption("gzzj").equals("1")){
                    gzzj=true;
                }
                if (AtFairyConfig.getOption("lczk").equals("1")){
                   lczk =true;
                }
                if (AtFairyConfig.getOption("cczz").equals("1")){
                    cczz=true;
                }
                if (AtFairyConfig.getOption("qhzm").equals("1")){
                    qhzm =true;
                }
                if (AtFairyConfig.getOption("yszq").equals("1")){
                    yszq =true;
                }
                if (AtFairyConfig.getOption("jyzy").equals("1")){
                    jyzy =true;
                }
                if (AtFairyConfig.getOption("wzbd").equals("1")){
                   bd1=true;
                }
                if (AtFairyConfig.getOption("wzbd").equals("2")){
                  bd2=true;
                }
                if (AtFairyConfig.getOption("wzbd").equals("3")){
                bd3=true;

                }
                if (AtFairyConfig.getOption("wzbd").equals("4")){
                 bd4=true;
                }
                if (AtFairyConfig.getOption("wzbd").equals("5")){
                  bd5=true;
                }
                if (AtFairyConfig.getOption("wzbd").equals("6")){
                   bd6=true;
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if(!AtFairyConfig.getOption("wzcs").equals("")){
                    wzcs=Integer.parseInt(AtFairyConfig.getOption("wzcs"));
                }
                if (wzzt){
                    setTaskName(2);return;
                }else if (gzzj){
                    setTaskName(3);return;
                }else if (lczk){
                    setTaskName(4);return;
                }else if (cczz){
                    setTaskName(5);return;
                }else if (qhzm){
                    setTaskName(6);return;
                }else if (yszq){
                    setTaskName(7);return;
                }else if (jyzy){
                    setTaskName(8);return;
                }else{
                    setTaskEnd();return;
                }
/*               if (overtime(8,0))return;
                if (err == 6){
                    setTaskEnd();return;
                }*/
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("wangzuo.png");
                mFairy.onTap(0.8f,result,"王座之塔",Sleep);

                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",2000);

//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (AtFairyConfig.getOption("wzbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
//                result =mFairy.findPic("fight.png");
//                mFairy.onTap(0.8f,result,"战斗",3000);
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",1000);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        wzzt =false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);
//                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
//                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("combatjy.png");
                mFairy.onTap(0.8f,result,468,829,491,844,"战斗失败重试",Sleep);

                result =mFairy.findPic("chongz.png");
                mFairy.onTap(0.8f,result,318,1063,369,1087,"战斗失败重试",Sleep);

            }
            public void content_3() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic("Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic(81,618,299,728,"Beam.png");
                mFairy.onTap(0.8f,result,"光柱之阶",500);
                result =mFairy.findPic(86,611,319,755,"nointogz.png");
/*                if (result.sim >0.8f){
                    LtLog.e("没开启光柱之阶结束1");
                    gzzj=false;
                    setTaskName(0);return;
                }*/
                result =mFairy.findPic(72,610,296,692,"week1.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启光柱之阶结束2");
                    gzzj=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    gzzj=false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs -- ;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        gzzj=false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);



            }
            public void content_4() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic("Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Cracked tooth.png");
                mFairy.onTap(0.8f,result,"裂齿之窟",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启裂齿之窟结束");
                    lczk=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("week2.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启裂齿之窟结束");
                    lczk=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    lczk=false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        lczk=false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);



            }
            public void content_5() throws Exception {

                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic("Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }


                result =mFairy.findPic("Verdant.png");
                mFairy.onTap(0.8f,result,"苍翠之主",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启苍翠之主结束");
                    cczz=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("week3.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启苍翠之主结束");
                    cczz=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    cczz=false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs -- ;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        cczz=false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);


            }
            public void content_6() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic("Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Thousand bones.png");
                mFairy.onTap(0.8f,result,"千骸之墓",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启千骸之墓结束");
                    qhzm=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("week4.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启千骸之墓结束");
                    qhzm=false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    qhzm=false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        qhzm=false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);


            }
            public void content_7() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"跃升之穹",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"跃升之穹还没解锁",Sleep);
                if (result.sim > 0.8f){
                    LtLog.e("没开启跃升之穹结束");
                    yszq=false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic("yuesheng.png");
                mFairy.onTap(0.8f,result,"跃升之穹",Sleep);

                result =mFairy.findPic(152,575,563,703,"bnjr.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启跃升之穹结束");
                    yszq=false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic("week5.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启跃升之穹结束");
                    yszq=false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",2000);

                result =mFairy.findPic(120,548,602,722,"csxz.png");
                if (result.sim > 0.8f){
                    LtLog.e("次数限制跃升之穹结束");
                    yszq=false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (AtFairyConfig.getOption("wzbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
//                result =mFairy.findPic("fight.png");
//                mFairy.onTap(0.8f,result,"战斗",3000);
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",1000);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        yszq =false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);
//                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
//                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("combatjy.png");
                mFairy.onTap(0.8f,result,468,829,491,844,"战斗失败重试",Sleep);

                result =mFairy.findPic("chongz.png");
                mFairy.onTap(0.8f,result,318,1063,369,1087,"战斗失败重试",Sleep);

            }
            public void content_8() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(229,574,445,673,new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"极渊之域",Sleep);

                /*result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"跃升之穹还没解锁",Sleep);
                if (result.sim > 0.8f){
                    LtLog.e("没开启跃升之穹结束");
                    yszq=false;
                    setTaskName(0);return;
                }*/

                result =mFairy.findPic(325,1037,504,1101,"jiyuanzy.png");
                mFairy.onTap(0.8f,result,"极渊之域",Sleep);

                result =mFairy.findPic(152,575,563,703,"bnjr.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启极渊之域 结束");
                    jyzy=false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic(313,978,541,1083,"week6.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启极渊之域 结束");
                    jyzy=false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",2000);

                result =mFairy.findPic(120,548,602,722,"csxz.png");
                if (result.sim > 0.8f){
                    LtLog.e("次数限制极渊之域结束");
                    jyzy=false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("fist.png");
//                if (result.sim >0.8f){
//                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
//                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
//                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
//                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
//                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
//                }

                if (AtFairyConfig.getOption("wzbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
//                result =mFairy.findPic("fight.png");
//                mFairy.onTap(0.8f,result,"战斗",3000);
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",1000);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        jyzy =false;
                        setTaskName(0);return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);
//                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
//                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("combatjy.png");
                mFairy.onTap(0.8f,result,468,829,491,844,"战斗失败重试",Sleep);

                result =mFairy.findPic("chongz.png");
                mFairy.onTap(0.8f,result,318,1063,369,1087,"战斗失败重试",Sleep);

            }
        }.taskContent(mFairy, "王座之塔");
    }

    /**
     * 异界迷宫
     */

    public void raceTower() throws Exception {
        new SingleTask(mFairy) {
            int yjcs =0;
            public void create() throws Exception{
                if(!AtFairyConfig.getOption("yjcs").equals("")){
                    yjcs=Integer.parseInt(AtFairyConfig.getOption("yjcs"));
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {

                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(52,560,412,830,"Alien maze.png");
                mFairy.onTap(0.8f,result,"异界迷宫",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(69,66,642,1034,"coordinate2.png");
                mFairy.onTap(0.8f,result,result.x-92,result.y-23,result.x-91,result.y-22,"左边",2000);//186,745 90,722

                result =mFairy.findPic("yjgg.png");
                mFairy.onTap(0.8f,result,643,261,656,279,"关闭说明",Sleep);

                result =mFairy.findPic(69,66,642,1034,"coordinate2.png");
                mFairy.onTap(0.9f,result,result.x+92,result.y+23,result.x+93,result.y+24,"右边",2000);//186,745 241,705

                result =mFairy.findPic(69,66,642,1034,"Carriage.png");
                mFairy.onTap(0.8f,result,147,608,170,622,"选择第一个英雄",Sleep);
                mFairy.onTap(0.8f,result,345,826,383,845,"确定选择",Sleep);

                result =mFairy.findPic("Hot spring.png");
                mFairy.onTap(0.8f,result,461,817,488,847,"温泉",Sleep);

                result =mFairy.findPic("Hot spring2.png");
                mFairy.onTap(0.8f,result,466,807,489,822,"使用温泉",Sleep);

                result =mFairy.findPic("mysterious.png");
                mFairy.onTap(0.8f,result,462,820,488,842,"随机复活队友",Sleep);

                result =mFairy.findPic("mysterious2.png");
                mFairy.onTap(0.8f,result,457,807,490,823,"随机复活队友",Sleep);

                result =mFairy.findPic("Travelling merchant.png");
                mFairy.onTap(0.8f,result,339,813,365,834,"前往旅行商人",Sleep);

                result =mFairy.findPic("Travelling merchant.png");
                mFairy.onTap(0.8f,result,339,813,365,834,"放弃旅行商人",Sleep);

                result =mFairy.findPic(3,3,720,754,"next.png");
                mFairy.onTap(0.8f,result,"进入下一关",Sleep);

                result =mFairy.findPic("Get into.png");
                mFairy.onTap(0.8f,result,"进入下一关",Sleep);

                result =mFairy.findPic(new String[]{"Go toyjmg.png"});
                mFairy.onTap(0.8f,result,"挑战",Sleep);
                result2 =mFairy.findPic("fight2.png");
                result1 =mFairy.findPic("Devil.png");
                if (result.sim<0.8f && result1.sim >0.8f && result2.sim < 0.8f){
                    mFairy.onTap(0.8f,result1,646,276,668,292,"关闭",Sleep);
                }

                result =mFairy.findPic(196,22,499,245,new String[]{"Ultimate.png","Ultimate2.png","Ultimate3.png"});
                mFairy.onTap(0.7f,result,"终极宝箱",Sleep);


                result =mFairy.findPic("Combat.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                if (AtFairyConfig.getOption("yjbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("yjbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("yjbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("yjbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("yjbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("yjbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
                result =mFairy.findPic("fight2.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(19,44,669,1094,"yjbox.png");
                mFairy.onTap(0.8f,result,"遗物宝箱",Sleep);

                result =mFairy.findPic("Relic.png");
                mFairy.onTap(0.8f,result,104,566,120,584,"第一个遗物",Sleep);
                mFairy.onTap(0.8f,result,111,885,137,897,"确定第一个遗物",Sleep);

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                mFairy.onTap(0.8f,result,"失败",Sleep);
                if(result.sim > 0.8f){
                    yjcs --;
                    if (yjcs <= 0){
                        setTaskEnd();return;
                    }
                }


                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("yjmg.png");
                result1 =mFairy.findPic(69,66,642,1034,"coordinate.png");
                LtLog.e("1111111111111111111111111"+result.sim+"2222222222222222222222222222222222222222"+result1.sim);
                if (result.sim >=0.8f&& result1.sim < 0.8f){
                    LtLog.e("-----------------------------进来了");
                    setTaskName(0);return;
                }
                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic("nohero.png");
                if(result.sim > 0.8f){
                    LtLog.e("没有英雄可以上阵结束任务");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("littlefive.png");
                mFairy.onTap(0.8f,result,462,834,476,857,"少于5名开始",Sleep);

                result1 =mFairy.findPic("threeceng.png");
                result2 =mFairy.findPic("first end.png");
                if (result2.sim > 0.8f && result1.sim >0.85f){
                    LtLog.e("刷完了");
                    setTaskEnd();return;
                }


            }

        }.taskContent(mFairy, "异界迷宫");
    }
    /**
     * 悬赏栏
     */
    public void rewardColumn() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(231,772,556,1072,new String[]{"Reward column.png","Reward column3.png"});
                mFairy.onTap(0.8f,result,"悬赏栏",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(new String[]{"One key collection2.png","One key collection.png"});
                mFairy.onTap(0.8f,result,"一键领取派遣",Sleep);

                result =mFairy.findPic(504,276,698,392,"pqlingqu.png");
                mFairy.onTap(0.8f,result,"派遣领取",Sleep);

                result2 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result =mFairy.findPic("Battle array2.png");
               // result =mFairy.findPic(102,980,389,1185,new String[]{"teampq.png","Battle array2.png"});
                mFairy.onTap(0.8f,result,"一键派遣",Sleep);
                result1 =mFairy.findPic("Reward column2.png");
                result3 =mFairy.findPic("Battle array3.png");
                if(result.sim<0.8f && result1.sim >0.8f&& result2.sim>0.8f && result3.sim < 0.8f){
                    LtLog.e("没有一键上阵任务");
                   setTaskName(3);return;
                }

                result =mFairy.findPic("pqyes.png");
                mFairy.onTap(0.8f,result,"确定一键派遣",Sleep);

                result =mFairy.findPic("Reward column2.png");
                result1 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result2 =mFairy.findPic("pqlingqu.png");
                if (result.sim > 0.8f && result1.sim < 0.8f && result2.sim < 0.8f){
                    LtLog.e("派遣完成结束");
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception {
                result =mFairy.findPic("Team reward2.png");
                mFairy.onTap(0.8f,result,"团队悬赏",Sleep);

                result =mFairy.findPic("Team reward.png");
                mFairy.onTap(0.8f,result,"团队悬赏",Sleep);

                result =mFairy.findPic(372,954,676,1149,new String[]{"One key collection2.png","One key collection.png"});
                mFairy.onTap(0.8f,result,"一键领取团队派遣",Sleep);

                result =mFairy.findPic(511,271,703,411,"pqlingqu.png");
                mFairy.onTap(0.8f,result,"派遣领取",Sleep);

                result =mFairy.findPic(102,980,389,1185,new String[]{"teampq.png","Battle array2.png"});
                mFairy.onTap(0.8f,result,"一键团队派遣",Sleep);

                result =mFairy.findPic("pqyes.png");
                mFairy.onTap(0.8f,result,"确定一键派遣",Sleep);

                result1 =mFairy.findPic(new String[]{"no.png"});
                if(result1.sim >= 0.8f){
                    LtLog.e("英雄不够派遣");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Reward column2.png");
                result1 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result2 =mFairy.findPic("pqlingqu.png");
                if (result.sim > 0.8f && result1.sim < 0.8f && result2.sim < 0.8f){
                    LtLog.e("派遣完成结束");
                    setTaskEnd();return;
                }
                result2 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result =mFairy.findPic("Battle array2.png");
                // result =mFairy.findPic(102,980,389,1185,new String[]{"teampq.png","Battle array2.png"});
                mFairy.onTap(0.8f,result,"一键派遣",Sleep);
                result1 =mFairy.findPic("Reward column2.png");
                result3 =mFairy.findPic("Battle array3.png");
                if(result.sim<0.8f && result1.sim >0.8f&& result2.sim>0.8f && result3.sim < 0.8f){
                    LtLog.e("没有一键上阵任务");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "悬赏栏");
    }

    /**
     * 竞技场
     */
    public void sports() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(377,561,644,836,new String[]{"Arena.png","Arena4.png","Arena5.png","jjc.png","Arena6.png"});
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(30,64,470,1141,"Arena3.png");
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic("Challengejingji.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result =mFairy.findPic("Challenge jj.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }

                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }


                if (AtFairyConfig.getOption("jjbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("jjbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("jjbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("jjbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("jjbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("jjbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","jixu.png"});
                mFairy.onTap(0.75f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
            }
            public void content_3() throws Exception {
                if (overtime(6,2))return;
                mFairy.taskSlid(err, new int[]{0, 1, 2}, 0, 355,802, 360,579, 1000, 1000);

                result =mFairy.findPic("Zero.png");
                result1 =mFairy.findPic(435,406,631,866,"Free Admission.png");
                LtLog.e("============================="+result.sim);
                if (result.sim >= 0.9f && result1.sim < 0.8f){
                    setTaskEnd();return;
                }

                if (AtFairyConfig.getOption("mf").equals("1")){
                    result =mFairy.findPic("Free Admission.png");
                    mFairy.onTap(0.8f,result,"挑战免费最后一个",Sleep);
                    if (result.sim >= 0.8f ){
                        setTaskName(2);return;
                    }
                    LtLog.e("=============================1"+result.sim);
                    result =mFairy.findPic(new String[]{"Free Admission3.png","mianfei.png"});
                    mFairy.onTap(0.8f,result,"挑战免费倒数第二个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                    LtLog.e("=============================2"+result.sim);
                    result =mFairy.findPic(447,655,621,758,"mianfei3.png");
                    mFairy.onTap(0.8f,result,"挑战免费倒数第三个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                    LtLog.e("=============================3"+result.sim);

                    result =mFairy.findPic(455,529,624,627,"mianfei3.png");
                    mFairy.onTap(0.8f,result,"挑战免费倒数第4个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }

                    result =mFairy.findPic(456,416,622,509,"mianfei3.png");
                    mFairy.onTap(0.8f,result,"挑战免费倒数第5个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                }
                if (AtFairyConfig.getOption("jz").equals("1")){
                    result =mFairy.findPic(new String[]{"Free Admission.png","juanzi.png"});
                    mFairy.onTap(0.8f,result,"挑战花费卷子最后一个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                    result =mFairy.findPic(new String[]{"Free Admission2.png","juanzi2.png","mianfei.png"});
                    mFairy.onTap(0.8f,result,"挑战花费卷子倒数第二个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                    result =mFairy.findPic(451,645,633,767,new String[]{"Free Admission2.png","juanzi2.png","mianfei.png"});
                    mFairy.onTap(0.75f,result,"挑战花费卷子倒数第三个",Sleep);
                    if (result.sim >= 0.75f){
                        setTaskName(2);return;
                    }
                    LtLog.e("==========================="+result.sim);

                    result =mFairy.findPic(450,532,622,631,new String[]{"Free Admission2.png","juanzi2.png","mianfei.png"});
                    mFairy.onTap(0.75f,result,"挑战花费卷子倒数第4个",Sleep);
                    if (result.sim >= 0.75f){
                        setTaskName(2);return;
                    }

                    result =mFairy.findPic(456,416,622,509,new String[]{"Free Admission2.png","juanzi2.png","mianfei.png"});
                    mFairy.onTap(0.75f,result,"挑战花费卷子倒数第5个",Sleep);
                    if (result.sim >= 0.75f){
                        setTaskName(2);return;
                    }
                }


                result =mFairy.findPic(452,409,629,959,"juanzi.png");
                if (AtFairyConfig.getOption("mf").equals("1")&& result.sim > 0.8f ){
                    setTaskEnd();return;
                }

            }
        }.taskContent(mFairy, "竞技场");
    }

    /**
     * 竞技币
     */
    public void higherOrder() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                if (overtime(3,0))return;
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(356,509,676,862,new String[]{"Arena.png","Arena4.png","Arena5.png","jjc.png","Arena6.png"});
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(160,11,557,1118,"Higher order.png");
                mFairy.onTap(0.8f,result,"高阶竞技场",Sleep);

                result =mFairy.findPic(new String[]{"Competitive currency.png","Competitive currency2.png","Competitive currency3.png"});
                mFairy.onTap(0.8f,result,"领取竞技币",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                if (err ==2){
                    setTaskEnd();return;

                }

            }

        }.taskContent(mFairy, "高阶竞技场");
    }


    /**
     * 奖励
     */
    int js = 0;
    int xb =0;
    int fb =0;
    public void reward() throws Exception {
        new SingleTask(mFairy) {
            boolean gjbx =false;
            boolean rwjl =false;
            boolean yjjl =false;
            boolean hyjl =false;
            boolean mrlq =false;
            boolean kxfb =false;
            boolean tj =false;
            boolean rlb =false;
            boolean jjb =false;
            boolean cjiu =false;
            boolean xsllj =false;
            boolean hjxsl =false;
            boolean yzxsl =false;
            boolean xs =false;
            boolean lmxsl=false;
            boolean yjlvd=false;
            boolean hcgjzlj=false;
            boolean mghz=false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("gjbx").equals("1")){
                   gjbx = true;
                }
                if (AtFairyConfig.getOption("yjjl").equals("1")){
                    yjjl = true;
                }
                if (AtFairyConfig.getOption("hyjl").equals("1")){
                    hyjl =true;
                }
                if (AtFairyConfig.getOption("rwjl").equals("1")){
                    rwjl =true;
                }
                if (AtFairyConfig.getOption("mrlq").equals("1")){
                    mrlq =true;
                }
                if (AtFairyConfig.getOption("kxfb").equals("1")){
                    kxfb =true;
                }
                if (AtFairyConfig.getOption("tj").equals("1")){
                    tj =true;
                }

                if (AtFairyConfig.getOption("rlb").equals("1")) {
                    rlb =true;
                   // dailyGiftPackage();
                }

                if (AtFairyConfig.getOption("cjiu").equals("1")) {
                    cjiu =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("lqjjb").equals("1")) {
                    jjb =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("xsllj").equals("1")) {
                    xsllj =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("hjxsl").equals("1")) {
                    hjxsl =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("yzxsl").equals("1")) {
                    yzxsl =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("lmxsl").equals("1")) {
                    lmxsl =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("xsmf").equals("1")) {
                    xs =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("yjld").equals("1")){//异界旅店
                     // hostel();
                    yjlvd=true;
                }
                if (AtFairyConfig.getOption("hcgjzlj").equals("1")){
                   hcgjzlj=true;
                }
                if (AtFairyConfig.getOption("mghz").equals("1")){
                    mghz=true;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,3))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Drop-down box2.png");
                mFairy.onTap(0.8f,result,"右下拉框",Sleep);

                if (gjbx){
                    setTaskName(2);return;
                }
                if (hyjl){
                    LtLog.e("进入好友奖励");
                    result =mFairy.findPic(new String[]{"Good friend.png","Good friend2.png"} );
                    mFairy.onTap(0.8f,result,"好友奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(8);return;
                    }

                }
                if (yjjl){
                    LtLog.e("进入邮件奖励");
                    result =mFairy.findPic(new String[]{"email.png","email3.png"});
                    mFairy.onTap(0.8f,result,"邮件奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(7);return;
                    }
                }
                if (rwjl){
                    LtLog.e("进入任务奖励");
                    result =mFairy.findPic(new String[]{"task.png","task2.png"});
                    mFairy.onTap(0.8f,result,"任务奖励",Sleep);
                    if(result.sim > 0.8f){
                        js=0;
                        setTaskName(6);return;
                    }
                }
                if (mrlq){

                    result =mFairy.findPic("Drop-down box.png");
                    mFairy.onTap(0.8f,result,"左下拉框",Sleep);

                    result =mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f,result,"活动",Sleep);

                    if (xb == 0) {
                        xb ++;
                        result = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                        mFairy.onTap(0.8f, result, "光辉", Sleep);
                    }
                    if (xb <6 && xb != 0){
                        xb ++;
                        result =mFairy.findPic(358,387,720,1091,"Recruit.png");
                        mFairy.onTap(0.8f,result,"新兵",Sleep);
                        if(result.sim > 0.8f){ //96,337 79,373
                            result =mFairy.findPic(67,324,720,389,"tanhao.png");
                            mFairy.onTap(0.8f,result,result.x-17,result.y+36,result.x-16,result.y+37,"可以领取的栏",Sleep);
                        }
                    }
                    if (xb >= 6){
                        xb =0;
                    }
                    setTaskName(4);return;
                }
                if (kxfb){
                    gameUtil.close();
                    setTaskName(9);return;
                }
                if (tj){
                    result =mFairy.findPic("hero.png");
                    mFairy.onTap(0.8f,result,"英雄",Sleep);

                    result1 =mFairy.findPic("tjhero.png");
                    result =mFairy.findPic("handbook3.png");
                    mFairy.onTap(0.8f,result,"图鉴",Sleep);
                   // result =mFairy.findPic("handbook3.png");
                    if(result.sim > 0.8f){
                        fb++;
                        setTaskName(5);return;
                    }
                    if (result1.sim>0.8f && result.sim<0.8f){
                        LtLog.e("没有可领取的图鉴");
                        tj=false;
                    }
                }
                if (jjb){
                    jjb=false;
                    higherOrder();
                }
                if (cjiu){
                    cjiu=false;
                    achievement();
                }
                if (hjxsl){
                    hjxsl=false;
                    brisk();
                }
                if (yzxsl){
                    yzxsl=false;
                    brisk();
                }
                if (lmxsl){
                    lmxsl=false;
                    brisk();
                }
                if (xs){
                    xs=false;
                    xs();
                }
                if (rlb){
                    rlb=false;
                    dailyGiftPackage();
                }
                if (xsllj){
                    xsllj=false;
                    rewardColumn();
                }
                if (yjlvd){
                    yjlvd=false;
                    hostel();
                }
                if (hcgjzlj){
                    hcgjzlj=false;
                    hcjl();
                }
                if (mghz){
                    mghz=false;
                    mghz();
                }
                if (err >= 4){
                    timekeepInit("任务循环");
                }

            }
            public void content_2() throws Exception {
                if (overtime(2,0))return;
                result =mFairy.findPic(new String[]{"Battle.png","Battle2.png"});
                mFairy.onTap(0.8f,result,"战役",3000);
                mFairy.onTap(0.8f,result,336,978,368,1007,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Treasure chest.png","Treasure chest2.png","boxgj1.png"});
                mFairy.onTap(0.8f,result,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Hang up lq.png","Hang up lq2.png"});
                mFairy.onTap(0.8f,result,"宝箱领取",Sleep);
                if (err == 1){
                    gjbx =false;
                }


            }
            public void content_3() throws Exception {
               boolean xh = timekeep(3,1800000,"任务循环");
                result =mFairy.findPic(233,1121,499,1272,"Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);
                if (xh) {
                     LtLog.e("时间到 开始从开任务");
                    if (AtFairyConfig.getOption("gjbx").equals("1")) {
                        gjbx = true;
                    }
                    if (AtFairyConfig.getOption("hyjl").equals("1")) {
                        hyjl = true;
                    }
                    if (AtFairyConfig.getOption("kxfb").equals("1")) {
                        kxfb = true;
                    }
                    if (AtFairyConfig.getOption("tj").equals("1")) {
                        tj = true;
                    }
                    if (AtFairyConfig.getOption("rwjl").equals("1")){
                        js =0;
                        rwjl =true;
                    }
                    if (AtFairyConfig.getOption("xsllj").equals("1")) {
                        rewardColumn();
                    }
                    if (AtFairyConfig.getOption("jhkq").equals("1")) {
                        swordSoul();
                    }
                    if (AtFairyConfig.getOption("lqjjb").equals("1")) {
                        higherOrder();
                    }

                    if (AtFairyConfig.getOption("cjiu").equals("1")) {
                        achievement();
                    }
                    if (AtFairyConfig.getOption("hjxsl").equals("1")) {
                        brisk();
                    }
                    if (AtFairyConfig.getOption("yzxsl").equals("1")) {
                        brisk();
                    }
                    if (AtFairyConfig.getOption("yjld").equals("1")) {
                       yjlvd=true;
                    }
                    if (AtFairyConfig.getOption("hcgjzlj").equals("1")) {
                        hcgjzlj=true;
                    }
                    if (AtFairyConfig.getOption("mghz").equals("1")) {
                        mghz=true;
                    }
                    setTaskName(0);return;
                }else {
                    if (result.sim<0.8f){
                        gameUtil.close();
                    }
                }

//                result =mFairy.findPic("territory.png");
//                mFairy.onTap(0.8f,result,"领地",Sleep);
//
//                result =mFairy.findPic("shops.png");
//                mFairy.onTap(0.8f,result,"商铺",Sleep);
//
//                result =mFairy.findPic("buyfc.png");
//                mFairy.onTap(0.8f,result,"购买",Sleep);
//
//                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
//                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//
//                result =mFairy.findPic("Sold out.png");
//                if (result.sim > 0.8f){
//                    fc =false;
//                    setTaskName(0);return;
//                }
//
//                result =mFairy.findPic(new String[]{"dust.png","dust2.png"});
//                mFairy.onTap(0.8f,result,"粉尘",Sleep);

            }
            public void content_4() throws Exception {
                result =mFairy.findPic(468,331,702,1158,"Receive dl.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(468,331,702,1158,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("Marvellous.png");
                result1 = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                result2 =mFairy.findPic(358,387,720,1091,"Recruit.png");
                if (result.sim>0.8f && result1.sim<0.8f&& result2.sim<0.8f){
                    xb=6;
                }
                if (xb >=6){
                    mrlq =false;
                }

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 343,772, 338,434, 2000, 1500);
                if (overtime(8,0))return;

            }
            public void content_5() throws Exception {

                if (fb>=1){
                    tj=false;
                }
                result =mFairy.findPic(52,145,669,983,"tjtanhao.png");
                mFairy.onTap(0.8f,result,"没有领取钻石的图鉴",Sleep);

                result =mFairy.findPic("Story.png");
                mFairy.onTap(0.8f,result,"故事",Sleep);

                result =mFairy.findPic("open.png");
                mFairy.onTap(0.8f,result,"打开",Sleep);

                result =mFairy.findPic("Diamonds.png");
                mFairy.onTap(0.8f,result,"领取钻石",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8, 10 ,12}, 0, 348,982, 350,184, 2000, 1500);
                if (overtime(12,0))return;
            }
            public void content_6() throws Exception {
                result =mFairy.findPic("task lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(1,202,720,383,"task box.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("zxlingqu.png");
                mFairy.onTap(0.8f,result,"主线领取",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(new String[]{"go.png","Completed.png"});
                if (result.sim > 0.8f && js == 2){
                    js =1;
                    mFairy.onTap(0.8f,result,596,1075,633,1101,"主线",Sleep);
                }
                if (result.sim > 0.8f && js == 0){
                    js =2;
                    mFairy.onTap(0.8f,result,413,1072,446,1106,"周长",Sleep);
                }
                result =mFairy.findPic("Hang in the air.png");
                if (result.sim > 0.8f){
                    rwjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("renwu.png");
                if (result.sim < 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_7() throws Exception {

//                result =mFairy.findPic("email2.png");
//                if (result.sim <0.8f){
//                    LtLog.e("没进邮箱");
//                    setTaskName(0);return;
//                }
                result =mFairy.findPic("yjlqemail.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("yjlqemail2.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic(154,575,568,708,"wpsx.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,20,1101,44,1121,"上限退出",500);
                    yjjl =false;
                    setTaskName(0);return;

                }
//                result =mFairy.findPic("yjdelemail.png");
//                mFairy.onTap(0.8f,result,"一键删除邮件",Sleep);

                result =mFairy.findPic(36,83,671,721,"Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//
//                result =mFairy.findPic(new String[]{"yes.png","yes2.png"});
//                mFairy.onTap(0.8f,result,"确认删除",Sleep);

                result =mFairy.findPic(554,177,712,965,"exclamation mark.png");
                mFairy.onTap(0.8f,result,"公告",Sleep);

                result =mFairy.findPic("email yes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result =mFairy.findPic("noemail.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("xianzhi.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic("notice.png");
                mFairy.onTap(0.8f,result,655,227,668,239,"通知关闭",Sleep);

            }
            public void content_8() throws Exception {
                if (overtime(3,0))return;
                result =mFairy.findPic(new String[]{"One collection.png","One collection2.png"});
                mFairy.onTap(0.8f,result,"一键领取和赠送",Sleep);

                if (err == 2){
                    hyjl =false;
                }
            }
            public void content_9() throws Exception {
                if (overtime(30,0))return;
                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(411,642,707,1122,"Tabula Rasa.png");
                mFairy.onTap(0.8f,result,"凯旋丰碑",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    kxfb =false;
                    setTaskName(0);return;
                }

                result1 =mFairy.findPic("Triumph.png");
                if (result1.sim > 0.8f){
                    result =mFairy.findPic(221,91,713,948,"kxfbtanhao.png");
                    mFairy.onTap(0.8f,result,"可领取的榜",Sleep);
                    if (result.sim <0.8f){
                        LtLog.e("没有可领取的榜");
                        kxfb =false;
                        setTaskName(0);return;
                    }
                }

                result =mFairy.findPic(2,1136,713,1274,"reward.png");
                mFairy.onTap(0.8f,result,"奖励",3000);
                if(result.sim > 0.8f){
                    setTaskName(10);return;
                }
                result =mFairy.findPic("renwu.png");
                mFairy.onTap(0.8f,result,26,1096,40,1106,"关闭",Sleep);

                result =mFairy.findPic(29,179,703,374,"yxfc.png");
                mFairy.onTap(0.8f,result,639,255,660,279,"关闭",Sleep);

            }
            public void content_10() throws Exception{
                result =mFairy.findPic(343,359,645,1076,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 333,911, 344,322, 2000, 1500);
                if (overtime(8,0))return;
            }
        }.taskContent(mFairy, "奖励日常");
    }

    public void reward1() throws Exception {
        new SingleTask(mFairy) {
            boolean gjbx =false;
            boolean rwjl =false;
            boolean yjjl =false;
            boolean hyjl =false;
            boolean mrlq =false;
            boolean kxfb =false;
            boolean tj =false;
            boolean rlb =false;
            boolean jjb =false;
            boolean cjiu =false;
            boolean xsllj =false;
            boolean hjxsl =false;
            boolean yzxsl =false;
            boolean xs =false;
            boolean lmxsl=false;
            boolean yjlvd=false;
            boolean hcgjzlj=false;
            boolean mghz=false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("gjbx").equals("1")){
                    gjbx = true;
                }
                if (AtFairyConfig.getOption("yjjl").equals("1")){
                    yjjl = true;
                }
                if (AtFairyConfig.getOption("hyjl").equals("1")){
                    hyjl =true;
                }
                if (AtFairyConfig.getOption("rwjl").equals("1")){
                    rwjl =true;
                }
                if (AtFairyConfig.getOption("mrlq").equals("1")){
                    mrlq =true;
                }
                if (AtFairyConfig.getOption("kxfb").equals("1")){
                    kxfb =true;
                }
                if (AtFairyConfig.getOption("tj").equals("1")){
                    tj =true;
                }

                if (AtFairyConfig.getOption("rlb").equals("1")) {
                    rlb =true;
                    // dailyGiftPackage();
                }

                if (AtFairyConfig.getOption("cjiu").equals("1")) {
                    cjiu =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("lqjjb").equals("1")) {
                    jjb =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("xsllj").equals("1")) {
                    xsllj =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("hjxsl").equals("1")) {
                    hjxsl =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("yzxsl").equals("1")) {
                    yzxsl =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("lmxsl").equals("1")) {
                    lmxsl =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("xsmf").equals("1")) {
                    xs =true;
                    //  dailyGiftPackage();
                }
                if (AtFairyConfig.getOption("yjld").equals("1")){//异界旅店
                    // hostel();
                    yjlvd=true;
                }
                if (AtFairyConfig.getOption("hcgjzlj").equals("1")){
                    hcgjzlj=true;
                }
                if (AtFairyConfig.getOption("mghz").equals("1")){
                    mghz=true;
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,0))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Drop-down box2.png");
                mFairy.onTap(0.8f,result,"右下拉框",Sleep);

                if (gjbx){
                    setTaskName(2);return;
                }else if (hyjl){
                    LtLog.e("进入好友奖励");
                    result =mFairy.findPic(new String[]{"Good friend.png","Good friend2.png"} );
                    mFairy.onTap(0.8f,result,"好友奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(8);return;
                    }

                }else  if (yjjl){
                    LtLog.e("进入邮件奖励");
                    result =mFairy.findPic(new String[]{"email.png","email3.png"});
                    mFairy.onTap(0.8f,result,"邮件奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(7);return;
                    }
                }else if (rwjl){
                    LtLog.e("进入任务奖励");
                    result =mFairy.findPic(new String[]{"task.png","task2.png"});
                    mFairy.onTap(0.8f,result,"任务奖励",Sleep);
                    if(result.sim > 0.8f){
                        js=0;
                        setTaskName(6);return;
                    }
                }else if (mrlq){

                    result =mFairy.findPic("Drop-down box.png");
                    mFairy.onTap(0.8f,result,"左下拉框",Sleep);

                    result =mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f,result,"活动",Sleep);

                    if (xb == 0) {
                        xb ++;
                        result = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                        mFairy.onTap(0.8f, result, "光辉", Sleep);
                    }
                    if (xb <6 && xb != 0){
                        xb ++;
                        result =mFairy.findPic(358,387,720,1091,"Recruit.png");
                        mFairy.onTap(0.8f,result,"新兵",Sleep);
                        if(result.sim > 0.8f){ //96,337 79,373
                            result =mFairy.findPic(67,324,720,389,"tanhao.png");
                            mFairy.onTap(0.8f,result,result.x-17,result.y+36,result.x-16,result.y+37,"可以领取的栏",Sleep);
                        }
                    }
                    if (xb >= 6){
                        xb =0;
                    }
                    setTaskName(4);return;
                }else if (kxfb){
                    gameUtil.close();
                    setTaskName(9);return;
                }else  if (tj){
                    result =mFairy.findPic("hero.png");
                    mFairy.onTap(0.8f,result,"英雄",Sleep);

                    result1 =mFairy.findPic("tjhero.png");
                    result =mFairy.findPic("handbook3.png");
                    mFairy.onTap(0.8f,result,"图鉴",Sleep);
                    // result =mFairy.findPic("handbook3.png");
                    if(result.sim > 0.8f){
                        fb++;
                        setTaskName(5);return;
                    }
                    if (result1.sim>0.8f && result.sim<0.8f){
                        LtLog.e("没有可领取的图鉴");
                        tj=false;
                    }
                }else if (jjb){
                    jjb=false;
                    higherOrder();
                }else if (cjiu){
                    cjiu=false;
                    achievement();
                }else if (hjxsl){
                    hjxsl=false;
                    brisk();
                }else if (yzxsl){
                    yzxsl=false;
                    brisk();
                }else if (lmxsl){
                    lmxsl=false;
                    brisk();
                }else if (xs){
                    xs=false;
                    xs();
                }else if (rlb){
                    rlb=false;
                    dailyGiftPackage();
                }else if (xsllj){
                    xsllj=false;
                    rewardColumn();
                }else if (yjlvd){
                    yjlvd=false;
                    hostel();
                }else if (hcgjzlj){
                    hcgjzlj=false;
                    hcjl();
                }else if (mghz){
                    mghz=false;
                    mghz();
                }else  if (err >= 4){
                    LtLog.e("结束任务");
                    setTaskEnd();return;
                }

            }
            public void content_2() throws Exception {
                if (overtime(2,0))return;
                result =mFairy.findPic(new String[]{"Battle.png","Battle2.png"});
                mFairy.onTap(0.8f,result,"战役",3000);
                mFairy.onTap(0.8f,result,336,978,368,1007,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Treasure chest.png","Treasure chest2.png","boxgj1.png"});
                mFairy.onTap(0.8f,result,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Hang up lq.png","Hang up lq2.png"});
                mFairy.onTap(0.8f,result,"宝箱领取",Sleep);
                if (err == 1){
                    gjbx =false;
                }


            }
            public void content_4() throws Exception {
                result =mFairy.findPic(468,331,702,1158,"Receive dl.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(468,331,702,1158,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("Marvellous.png");
                result1 = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                result2 =mFairy.findPic(358,387,720,1091,"Recruit.png");
                if (result.sim>0.8f && result1.sim<0.8f&& result2.sim<0.8f){
                    xb=6;
                }
                if (xb >=6){
                    mrlq =false;
                }

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 343,772, 338,434, 2000, 1500);
                if (overtime(8,0))return;

            }
            public void content_5() throws Exception {

                if (fb>=1){
                    tj=false;
                }
                result =mFairy.findPic(52,145,669,983,"tjtanhao.png");
                mFairy.onTap(0.8f,result,"没有领取钻石的图鉴",Sleep);

                result =mFairy.findPic("Story.png");
                mFairy.onTap(0.8f,result,"故事",Sleep);

                result =mFairy.findPic("open.png");
                mFairy.onTap(0.8f,result,"打开",Sleep);

                result =mFairy.findPic("Diamonds.png");
                mFairy.onTap(0.8f,result,"领取钻石",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8, 10 ,12}, 0, 348,982, 350,184, 2000, 1500);
                if (overtime(12,0))return;
            }
            public void content_6() throws Exception {
                result =mFairy.findPic("task lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(1,202,720,383,"task box.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("zxlingqu.png");
                mFairy.onTap(0.8f,result,"主线领取",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(new String[]{"go.png","Completed.png"});
                if (result.sim > 0.8f && js == 2){
                    js =1;
                    mFairy.onTap(0.8f,result,596,1075,633,1101,"主线",Sleep);
                }
                if (result.sim > 0.8f && js == 0){
                    js =2;
                    mFairy.onTap(0.8f,result,413,1072,446,1106,"周长",Sleep);
                }
                result =mFairy.findPic("Hang in the air.png");
                if (result.sim > 0.8f){
                    rwjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("renwu.png");
                if (result.sim < 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_7() throws Exception {

//                result =mFairy.findPic("email2.png");
//                if (result.sim <0.8f){
//                    LtLog.e("没进邮箱");
//                    setTaskName(0);return;
//                }
                result =mFairy.findPic("yjlqemail.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("yjlqemail2.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic(154,575,568,708,"wpsx.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,20,1101,44,1121,"上限退出",500);
                    yjjl =false;
                    setTaskName(0);return;

                }
//                result =mFairy.findPic("yjdelemail.png");
//                mFairy.onTap(0.8f,result,"一键删除邮件",Sleep);

                result =mFairy.findPic(36,83,671,721,"Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//
//                result =mFairy.findPic(new String[]{"yes.png","yes2.png"});
//                mFairy.onTap(0.8f,result,"确认删除",Sleep);

                result =mFairy.findPic(554,177,712,965,"exclamation mark.png");
                mFairy.onTap(0.8f,result,"公告",Sleep);

                result =mFairy.findPic("email yes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result =mFairy.findPic("noemail.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("xianzhi.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic("notice.png");
                mFairy.onTap(0.8f,result,655,227,668,239,"通知关闭",Sleep);

            }
            public void content_8() throws Exception {
                if (overtime(3,0))return;
                result =mFairy.findPic(new String[]{"One collection.png","One collection2.png"});
                mFairy.onTap(0.8f,result,"一键领取和赠送",Sleep);

                if (err == 2){
                    hyjl =false;
                }
            }
            public void content_9() throws Exception {
                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(411,642,707,1122,"Tabula Rasa.png");
                mFairy.onTap(0.8f,result,"凯旋丰碑",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    kxfb =false;
                    setTaskName(0);return;
                }

                result1 =mFairy.findPic("Triumph.png");
                if (result1.sim > 0.8f){
                    result =mFairy.findPic(221,91,713,948,"kxfbtanhao.png");
                    mFairy.onTap(0.8f,result,"可领取的榜",Sleep);
                    if (result.sim <0.8f){
                        LtLog.e("没有可领取的榜");
                        kxfb =false;
                        setTaskName(0);return;
                    }
                }

                result =mFairy.findPic(2,1136,713,1274,"reward.png");
                mFairy.onTap(0.8f,result,"奖励",3000);
                if(result.sim > 0.8f){
                    setTaskName(10);return;
                }
                result =mFairy.findPic("renwu.png");
                mFairy.onTap(0.8f,result,26,1096,40,1106,"关闭",Sleep);
            }
            public void content_10() throws Exception{
                result =mFairy.findPic(343,359,645,1076,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 333,911, 344,322, 2000, 1500);
                if (overtime(8,0))return;
            }
        }.taskContent(mFairy, "奖励日常不循环");
    }


    /**
     * 幻池攻坚战领奖
     */
    public void hcjl() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                if (overtime(4,99))return;
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("gjzjl.png");
                mFairy.onTap(0.8f,result,"幻池攻坚战奖励",Sleep);

                result =mFairy.findPic("never.png");
                if (result.sim > 0.8f){

                    mFairy.onTap(0.8f,result,366,867,377,872,"领完了",Sleep);

                    setTaskEnd();return;
                }

                result =mFairy.findPic("gjzjlyes.png");
                mFairy.onTap(0.8f,result,"幻池攻坚战奖励确认",Sleep);


            }

        }.taskContent(mFairy, "幻池攻坚战领奖");
    }

    /**
     * 工会狩猎
     */
    public void hunting() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {

                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic(83,573,297,731,"hunting.png");
                mFairy.onTap(0.8f,result,189,596,203,603,"工会狩猎",Sleep);

                if (AtFairyConfig.getOption("gbl").equals("1")){
                    result =mFairy.findPic("Sword soul.png");
                    if (result.sim > 0.8f){
                        result =mFairy.findPic("Left.png");
                        mFairy.onTap(0.8f,result,"左箭头",Sleep);
                    }
                    result =mFairy.findPic("Brother brin.png");
                    mFairy.onTap(0.8f,result,331,1213,363,1240,"挑战哥布林",Sleep);
                    result = mFairy.findPic("jhfer.png");
                    mFairy.onTap(0.8f, result,  "挑战哥布林", Sleep);

                }

                if (AtFairyConfig.getOption("ygjh").equals("1")){
                    result =mFairy.findPic("Brother brin.png");
                    if (result.sim > 0.8f){
                        result =mFairy.findPic("right.png");
                        mFairy.onTap(0.8f,result,"右箭头",Sleep);
                    }
                    result =mFairy.findPic("Not opened.png");
                    result1 =mFairy.findPic("openjh.png");
                    if (result.sim < 0.8f && result1.sim <0.8f) {
                        result = mFairy.findPic("Sword soul.png");
                        mFairy.onTap(0.8f, result, 331, 1213, 363, 1240, "挑战远古剑魂", Sleep);
                        result = mFairy.findPic("jhfer.png");
                        mFairy.onTap(0.8f, result,  "挑战远古剑魂", Sleep);
                    }

                }
                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                if (AtFairyConfig.getOption("slbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","renyi3.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result1 = mFairy.findPic("Sword soul.png");
                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","openjh.png"});
                if (result.sim > 0.8f && result1.sim>0.8f){
                    LtLog.e("远古剑魂未开启或者没次数了结束任务");
                    setTaskEnd();return;
                }
                if (!AtFairyConfig.getOption("ygjh").equals("1") && AtFairyConfig.getOption("gbl").equals("1")){
                    result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png"});
                    if (result.sim > 0.8f ){
                        LtLog.e("打完哥布林结束任务");
                        setTaskEnd();return;
                    }
                }
                if (!AtFairyConfig.getOption("ygjh").equals("1") && !AtFairyConfig.getOption("gbl").equals("1")){
                    LtLog.e("没有选择哥布林个远古剑魂");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "工会狩猎");
    }

    /**
     *  开启剑魂
     */
    public void swordSoul() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("hunting.png");
                mFairy.onTap(0.8f,result,189,596,203,603,"工会狩猎",Sleep);


                result =mFairy.findPic("Brother brin.png");
                if (result.sim > 0.8f){
                    result =mFairy.findPic("right.png");
                    mFairy.onTap(0.8f,result,"右箭头",Sleep);
                }
                result =mFairy.findPic("openjh.png");
                mFairy.onTap(0.8f, result, "开启剑魂", Sleep);

                result =mFairy.findPic("confirmjh.png");
                mFairy.onTap(0.8f, result, "确认开启剑魂", 500);

                result1 =mFairy.findPic("Insufficient.png");
                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","fight.png","jhtz.png","jhfer.png"});
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    LtLog.e("远古剑魂不符合开启条件或者已开启结束任务");
                    setTaskEnd();return;
                }

                result1 =mFairy.findPic("jianhun.png");
                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","fight.png","jhtz.png","jhfer.png"});
                if (result.sim > 0.8f || result1.sim > 0.8f){
                    LtLog.e("当剑魂遇见了游戏bug");
                    mFairy.onTap(0.8f, result1, 24,1212,40,1227,"返回", 500);
                }
            }

        }.taskContent(mFairy, "开启剑魂");
    }

    /**
     *  扭曲梦境
     */
    public void twistedDreams() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(435,503,631,690,new String[]{"dreams1.png","dreams3.png"});
                mFairy.onTap(0.8f,result,512,581,523,593,"梦魇",Sleep);

                result =mFairy.findPic(156,179,590,868,"nqmj1.png");
                mFairy.onTap(0.8f,result,"扭曲梦境",Sleep);


                result =mFairy.findPic(180,447,563,634,"Unlock3.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("timeover.png");
                mFairy.onTap(0.8f,result,331,787,373,811,"boss时间到",Sleep);
                if (result.sim > 0.8f){
                    LtLog.e("等待boss刷新 结束任务");
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Challengemj.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                if (AtFairyConfig.getOption("slbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("slbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic("frequency.png");
                mFairy.onTap(0.8f,result,244,724,263,742,"不再提示",Sleep);
                mFairy.onTap(0.8f,result,347,786,361,804,"确定",Sleep);

                result =mFairy.findPic("nqmj.png");
                mFairy.onTap(0.8f,result,244,724,263,742,"不再提示",Sleep);
                mFairy.onTap(0.8f,result,347,786,361,804,"确定",Sleep);

                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","Continue.png"});
                if (result.sim > 0.8f){
                    LtLog.e("扭曲梦境没次数了结束任务");
                    setTaskEnd();return;
                }

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","weizhi.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);
            }

        }.taskContent(mFairy, "扭曲梦境");
    }

    /**
     * 图书馆
     */

    public void library() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {

                setTaskName(2);return;
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(349,327,627,822,new String[]{"Library.png","Library2.png"});
                mFairy.onTap(0.8f,result,"图书馆",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic(213,71,502,1125,"Fetters2.png");
                mFairy.onTap(0.8f,result,"羁绊",Sleep);

                result =mFairy.findPic("Fetters.png");
                if (result.sim > 0.8f){
                    result =mFairy.findPic(551,99,707,1181,"kxfbtanhao.png");
                    mFairy.onTap(0.8f,result,"添加图书馆",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(3);return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 334,1102, 351,211, 2000, 1500);
                if (overtime(8,0))return;
                if (err == 7){
                    setTaskEnd();return;
                }
            }
            public void content_3() throws Exception {
                result1 =mFairy.findPic("Fetters.png");
                result =mFairy.findPic(102,1129,623,1245,"kxfbtanhao.png");
                mFairy.onTap(0.8f,result,result.x-17,result.y+36,result.x-16,result.y+37,"添加羁绊",Sleep);
                result2 =mFairy.findPic("activation.png");
                if (result2.sim > 0.8f){
                    mFairy.onTap(0.8f,result2,"永久激活",Sleep);
                }else {
                    mFairy.onTap(0.8f,result,161,447,177,475,"添加羁绊",Sleep);
                    mFairy.onTap(0.8f,result,481,1051,498,1079,"确定添加羁绊",Sleep);
                }
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(23,1212,44,1226,"返回",Sleep);
                }


                if (overtime(4,2))return;
            }
        }.taskContent(mFairy, "图书馆");
    }

    /**
     *  周礼包月礼包日礼包
     */
    public void dailyGiftPackage() throws Exception {
        new SingleTask(mFairy) {
            public void create() throws Exception {

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Trading port.png");
                mFairy.onTap(0.8f,result,"贸易港",3000);

                result =mFairy.findPic(172,1165,395,1280,"Merchant ship.png");
                mFairy.onTap(0.8f,result,"普通商船",3000);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
//                if (AtFairyConfig.getOption("rlb").equals("1")){
//                    result =mFairy.findPic(new String[]{"daypackage.png","daypackage2.png"});
//                    mFairy.onTap(0.8f,result,"日礼包",3000);
//                    mFairy.onTap(0.8f,result,139,419,155,436,"领取日礼包",Sleep);
//                }
//                if (AtFairyConfig.getOption("zlb").equals("1")) {
//                    result =mFairy.findPic("weekpackage.png");
//                    mFairy.onTap(0.8f,result,"周礼包",3000);
//                    mFairy.onTap(0.8f,result,122,416,150,434,"领取周礼包",Sleep);
//                }
//                if (AtFairyConfig.getOption("ylb").equals("1")) {
//                    result =mFairy.findPic("monpackage.png");
//                    mFairy.onTap(0.8f,result,"月礼包",3000);
//                    mFairy.onTap(0.8f,result,110,445,132,461,"领取月礼包",Sleep);
//                }
//
//                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
//                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//                if (err >1){
//                    setTaskEnd();return;
//
//                }

            }
            public void content_2() throws Exception {
                if (overtime(4,0))return;

                result =mFairy.findPic(172,1165,395,1280,"Merchant ship.png");
                mFairy.onTap(0.8f,result,"普通商船",2000);

                if (AtFairyConfig.getOption("rlb").equals("1")){
                    result =mFairy.findPic(1,985,717,1166,new String[]{"daypackage.png","daypackage2.png"});
                    mFairy.onTap(0.8f,result,"日礼包",3000);
                    mFairy.onTap(0.8f,result,139,419,155,436,"领取日礼包",Sleep);
                    mFairy.onTap(0.8f,result,104,790,113,796,"领取",Sleep);
                }
                if (AtFairyConfig.getOption("zlb").equals("1")) {
                    result =mFairy.findPic(1,985,717,1166,"weekpackage.png");
                    mFairy.onTap(0.8f,result,"周礼包",1000);
                    mFairy.onTap(0.8f,result,"周礼包",1000);
                    mFairy.onTap(0.8f,result,122,416,150,434,"领取周礼包",Sleep);
                    mFairy.onTap(0.8f,result,104,790,113,796,"领取",Sleep);
                }
                if (AtFairyConfig.getOption("ylb").equals("1")) {
                    result =mFairy.findPic(1,985,717,1166,"monpackage.png");
                    mFairy.onTap(0.8f,result,"月礼包",1000);
                    mFairy.onTap(0.8f,result,110,445,132,461,"领取月礼包",Sleep);

                }

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                if (err >1){
                    setTaskEnd();return;

                }
            }

        }.taskContent(mFairy, "礼包");
    }

    /**
     *  成就
     */

    public void achievement() throws Exception {
        new SingleTask(mFairy) {
            public void create() throws Exception {

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,0))return;
                result =mFairy.findPic("hero.png");
                mFairy.onTap(0.8f,result,53,42,76,60,"头像",Sleep);

                result =mFairy.findPic("achievement.png");
                mFairy.onTap(0.8f,result,"成就",Sleep);

                result2 =mFairy.findPic(495,233,673,955,"achievementmake.png");
                mFairy.onTap(0.8f,result2,"领取成就奖励",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","paper.png","chengj.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("chengjiubox.png");
                mFairy.onTap(0.8f,result,"成就宝箱",Sleep);

                if (result2.sim > 0.8f) {
                    mFairy.taskSlid(err, new int[]{0, 2, 4,}, 0, 343, 955, 347, 349, 2000, 1500);
                }
                if (err >=5){
                     setTaskName(2);return;
                    //setTaskEnd();return;

                }


            }
            public void content_2() throws Exception {
                if (overtime(6,0))return;
                result =mFairy.findPic(79,1011,652,1089,"adventure.png");
                mFairy.onTap(0.8f,result,"冒险成就",Sleep);

                result2 =mFairy.findPic(495,233,673,955,"achievementmake.png");
                mFairy.onTap(0.8f,result2,"领取成就奖励",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","paper.png","chengj.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("chengjiubox.png");
                mFairy.onTap(0.8f,result,"成就宝箱",Sleep);

                if (err >=5){
                    setTaskEnd();return;

                }
            }

        }.taskContent(mFairy, "成就");
    }

    /**
     * 皇家悬赏令/勇者悬赏令
     */
    public void brisk() throws Exception {
        new SingleTask(mFairy) {
            boolean yz =false;
            boolean hj =false;
            boolean lm = false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("hjxsl").equals("1")){
                  hj=true;
                }
                if (AtFairyConfig.getOption("yzxsl").equals("1")) {
                   yz=true;
                }
                if (AtFairyConfig.getOption("lmxsl").equals("1")) {
                    lm =true;
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,0))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Trading port.png");
                mFairy.onTap(0.7f,result,"贸易港",3000);

                result =mFairy.findPic(144,782,588,1068,"queren.png");
                mFairy.onTap(0.8f,result,"确定",2000);

                result =mFairy.findPic(397,930,608,1000,"zhuti.png");
                mFairy.onTap(0.8f,result,361,853,375,865,"确定",Sleep);


                if (hj){

                    result =mFairy.findPic(59,1002,669,1157,new String[]{"Royal family.png","Royal family2.png","hjxsl.png"});
                    mFairy.onTap(0.8f,result,"皇家犒赏令",Sleep);
                    if (result.sim > 0.8f){
                        hj=false;
                        setTaskName(2);return;
                    }

                }
                if (yz) {

                    result =mFairy.findPic(59,1002,669,1157,new String[]{"Brave.png","yongzhe.png"});
                    mFairy.onTap(0.8f,result,"勇者犒赏令",Sleep);
                    if (result.sim > 0.8f){
                        yz=false;
                        setTaskName(2);return;
                    }

                }
                if (lm) {
                    result =mFairy.findPic(59,1002,669,1157,new String[]{"Dream hunting.png","Dream hunting2.png"});
                    mFairy.onTap(0.8f,result,"猎梦犒赏令",Sleep);
                    if (result.sim > 0.8f){
                        lm=false;
                        setTaskName(2);return;
                    }

                }

                if (err >=2){
                    setTaskEnd();return;

                }

            }
            public void content_2() throws Exception {

                mFairy.sleep(2000);
                result =mFairy.findPic(397,930,608,1000,"zhuti.png");
                mFairy.onTap(0.8f,result,361,853,375,865,"确定",2000);

                result =mFairy.findPic(144,782,588,1068,"queren.png");
                mFairy.onTap(0.8f,result,"确定",2000);

                result =mFairy.findPic(510,342,714,1062,"Braveopen.png");
                mFairy.onTap(0.8f,result,"领取悬赏令1",2000);

                result =mFairy.findPic(504,329,720,1062,"xs.png");
                mFairy.onTap(0.8f,result,"领取悬赏令2",2000);
                if (result.sim > 0.8f){
                    err=0;
                }
                result =mFairy.findPic(504,329,720,1062,"lqxsl.png");
                mFairy.onTap(0.8f,result,"领取悬赏令",2000);
                if (result.sim > 0.8f){
                    err=0;
                }
                result =mFairy.findPic("quer.png");
                mFairy.onTap(0.8f,result,"确认领取悬赏令",2000);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                if (overtime(6,1))return;
            }

        }.taskContent(mFairy, "悬赏令");
    }


    /**
     * 限时奖励
     */
    public void xs() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,0))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Trading port.png");
                mFairy.onTap(0.8f,result,"贸易港",3000);

                result =mFairy.findPic("xssc.png");
                mFairy.onTap(0.8f,result,"限时商船",2000);

                result =mFairy.findPic(365,89,661,818,"Free Admission xs.png");
                mFairy.onTap(0.8f,result,"限时免费领取",Sleep);
                if (err >=2){
                    setTaskEnd();return;

                }

            }


        }.taskContent(mFairy, "限时奖励");
    }

    /**
     * 迷宫互助
     */
    public void mghz() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(20,99))return;

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(63,515,354,803,"hand3.png");
                mFairy.onTap(0.8f,result,"互助",3000);

                result =mFairy.findPic(77,186,673,496,"huzhu.png");
                mFairy.onTap(0.8f,result,350,1028,362,1035,"帮助他人",1000);
                mFairy.onTap(0.8f,result,467,931,476,940,"全部同意",500);
                mFairy.onTap(0.8f,result,647,288,655,299,"叉",500);

            }

        }.taskContent(mFairy, "迷宫互助");
    }

    /**
     *
     * 单独的战役
     */
    public void campaigns() throws Exception {
        new SingleTask(mFairy) {
            int zycs = 0;
            public void create() throws Exception{
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        zycs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                       zycs =1 ;
                    }
                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic("Challenge boss.png");
                mFairy.onTap(0.8f,result,"挑战boss",Sleep);

                result =mFairy.findPic(165,895,584,1085,"Challenge boss2.png");
                mFairy.onTap(0.8f,result,"挑战boss2",Sleep);

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Next chapter.png");
                mFairy.onTap(0.8f,result,"下一章",Sleep);

                result =mFairy.findPic(0,0,720,1080,"hand.png");
                mFairy.onTap(0.8f,result,"选择下一地图",Sleep);

                result =mFairy.findPic("Go to.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);

                result =mFairy.findPic("classq.png");
                mFairy.onTap(0.8f,result,"等级提升",Sleep);

                result =mFairy.findPic("zhucheng.png");
                mFairy.onTap(0.8f,result,68,1213,91,1234,"主城",Sleep);


                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    zycs --;
                    if (zycs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,366,1114,386,1127,"胜利继续",Sleep);

            }
        }.taskContent(mFairy, "战役");
    }

    /**
     * 单独的爬塔(王座之塔)
     */
    public void towerThrones() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {
//                if (AtFairyConfig.getOption("gzzj").equals("1")){
//                    gzzj=true;
//                }
//                if (AtFairyConfig.getOption("lczk").equals("1")){
//                    lczk =true;
//                }
//                if (AtFairyConfig.getOption("cczz").equals("1")){
//                    cczz=true;
//                }
//                if (AtFairyConfig.getOption("qhzm").equals("1")){
//                    qhzm =true;
//                }
                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    bd6=true;
                }
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        wzcs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                        wzcs =1 ;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(200,500,483,694,new String[]{"Pagoda.png","zuo.png","wzzt.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("wangzuo.png");
                mFairy.onTap(0.8f,result,"王座之塔",Sleep);

                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",2000);

                if (AtFairyConfig.getOption("wzbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("wzbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
//                result =mFairy.findPic("fight.png");
//                mFairy.onTap(0.8f,result,"战斗",3000);
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",1000);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);
//                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
//                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("combatjy.png");
                mFairy.onTap(0.8f,result,468,829,491,844,"战斗失败重试",Sleep);

                result =mFairy.findPic("chongz.png");
                mFairy.onTap(0.8f,result,318,1063,369,1087,"战斗失败重试",Sleep);

            }
        }.taskContent(mFairy, "王座之塔");
    }

    /**
     *
     * 光柱之阶
     */
    public void towerThronesgz() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    bd6=true;
                }
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        wzcs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                        wzcs =1 ;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(3);
            }
            public void content_3() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Beam.png");
                mFairy.onTap(0.8f,result,"光柱之阶",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启光柱之阶结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("week1.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启光柱之阶结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    setTaskEnd();return;
                }
                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs -- ;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);



            }
        }.taskContent(mFairy, "光柱之阶");
    }

    /**
     *
     * 裂齿之窟
     */
    public void towerThroneslk() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    bd6=true;
                }
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        wzcs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                        wzcs =1 ;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(4);
            }
            public void content_4() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Cracked tooth.png");
                mFairy.onTap(0.8f,result,"裂齿之窟",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启裂齿之窟结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("week2.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启裂齿之窟结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    setTaskEnd();return;
                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);



            }
        }.taskContent(mFairy, "裂齿之窟");
    }

    /**
     *
     * 苍翠之柱
     */
    public void towerThroneszz() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {

                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    bd6=true;
                }
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        wzcs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                        wzcs =1 ;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(5);
            }
            public void content_5() throws Exception {

                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }


                result =mFairy.findPic("Verdant.png");
                mFairy.onTap(0.8f,result,"苍翠之主",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启苍翠之主结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("week3.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启苍翠之主结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    setTaskEnd();return;
                }
                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs -- ;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);


            }
        }.taskContent(mFairy, "苍翠之柱");
    }

    /**
     *
     * 千骸之墓
     */
    public void towerThroneszm() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("tupabd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("tupabd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("tupabd").equals("6")){
                    bd6=true;
                }
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        wzcs=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定次数默认为一次");
                        wzcs =1 ;
                    }
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(6);
            }
            public void content_6() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Pagoda.png","zuo.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Thousand bones.png");
                mFairy.onTap(0.8f,result,"千骸之墓",500);
                result =mFairy.findPic("nointo.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启千骸之墓结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("week4.png");
                if (result.sim >0.8f){
                    LtLog.e("没开启千骸之墓结束");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",500);
                result =mFairy.findPic("notz.png");
                if (result.sim >0.8f){
                    LtLog.e("每天只能打10层结束");
                    setTaskEnd();return;
                }

                if (bd1){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",500);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd1=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd2){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd2=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd3){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd3=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd4){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd4=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd5){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd5=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                if (bd6){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);
                    result =mFairy.findPic("Dissatisfaction.png");
                    if (result.sim>0.8f){
                        bd6=false;
                        mFairy.onTap(0.8f,result,614,1212,633,1239,"关闭编队",Sleep);
                    }
                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);

                result =mFairy.findPic("check.png");
                mFairy.onTap(0.8f,result,467,835,477,846,"战斗校验失败确定",Sleep);


            }
        }.taskContent(mFairy, "千骸之墓");
    }


    /**
     * 战役(new)
     */
    public void campaignnew() throws Exception {
        new SingleTask(mFairy) {
            int zycs = 1;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic("Challenge boss.png");
                mFairy.onTap(0.8f,result,"挑战boss",Sleep);

                result =mFairy.findPic(165,895,584,1085,"Challenge boss2.png");
                mFairy.onTap(0.8f,result,"挑战boss2",Sleep);

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Next chapter.png");//336,557   374,605
                mFairy.onTap(0.8f,result,result.x+38,result.y+50,result.x+39,result.y+51,"下一章",Sleep);

                result =mFairy.findPic(0,0,720,1080,"hand.png");
                mFairy.onTap(0.8f,result,"选择下一地图",Sleep);

                result =mFairy.findPic("Go to.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);

                result =mFairy.findPic("classq.png");
                mFairy.onTap(0.8f,result,"等级提升",Sleep);

                result =mFairy.findPic("zhucheng.png");
                mFairy.onTap(0.8f,result,68,1213,91,1234,"主城",Sleep);

                if (AtFairyConfig.getOption("bd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    zycs --;
                    if (zycs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,366,1114,386,1127,"胜利继续",Sleep);

            }
        }.taskContent(mFairy, "战役");
    }


    /**
     * 快速挂机(new)
     */
    public void quickHangnew() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                if (overtime(30,0))return;
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic( 0,1160,718,1277,"fanhui.png");
                mFairy.onTap(0.8f,result,"返回",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result1 = mFairy.findPic("Quick hang up.png");
                mFairy.onTap(0.8f, result1, "快速挂机", Sleep);
                if (gjcs==0 || gjcs==1) {
                    result = mFairy.findPic(310,776,659,910,"Free collection.png");
                    mFairy.onTap(0.8f, result, "领取", Sleep);
                    if (result.sim>0.8f){
                        ksgjnum =1000;
                    }
                    result = mFairy.findPic(310,776,659,910,"make.png");
                    mFairy.onTap(0.8f, result, 224,833,251,853,"关闭", Sleep);
                    if (result.sim>0.8f){
                        ksgjnum =1000;
                    }
                }


                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

//                if (gjcs == ksgjnum){
//                    LtLog.e("快速挂机完成结束");
//                    setTaskEnd();return;
//                }
                if ( ksgjnum == 1000){
                    LtLog.e("快速挂机1次结束");
                    setTaskEnd();return;
                }
//                result =mFairy.findPic("In cooling.png");
//                if (result.sim > 0.8f){
//                    LtLog.e("快速挂机没次数了结束");
//                    setTaskEnd();return;
//                }
            }
        }.taskContent(mFairy, "快速挂机");
    }

    /**
     * 王座之塔(new)
     */
    public void towerThronenew() throws Exception {
        new SingleTask(mFairy) {
            int wzcs =0;
            boolean bd1 =false;
            boolean bd2 =false;
            boolean bd3 =false;
            boolean bd4 =false;
            boolean bd5 =false;
            boolean bd6 =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("bd").equals("1")){
                    bd1=true;
                }
                if (AtFairyConfig.getOption("bd").equals("2")){
                    bd2=true;
                }
                if (AtFairyConfig.getOption("bd").equals("3")){
                    bd3=true;

                }
                if (AtFairyConfig.getOption("bd").equals("4")){
                    bd4=true;
                }
                if (AtFairyConfig.getOption("bd").equals("5")){
                    bd5=true;
                }
                if (AtFairyConfig.getOption("bd").equals("6")){
                    bd6=true;
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(new String[]{"chaozhi.png","chongz.png"});
                mFairy.onTap(0.8f,result,338,1188,372,1213,"关闭限时充值",Sleep);

                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(200,500,483,694,new String[]{"Pagoda.png","zuo.png","wzzt.png"});
                mFairy.onTap(0.8f,result,323,603,334,612,"王座之塔",Sleep);

                result =mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"王座之塔还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("wangzuo.png");
                mFairy.onTap(0.8f,result,"王座之塔",Sleep);

                result =mFairy.findPic(254,645,469,1152,"Challenge.png");
                mFairy.onTap(0.8f,result,"挑战",2000);

                if (AtFairyConfig.getOption("bd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
//                result =mFairy.findPic("fight.png");
//                mFairy.onTap(0.8f,result,"战斗",3000);
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",1000);

                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                if(result.sim > 0.8f){
                    wzcs --;
                    if(wzcs <= 0){
                        mFairy.onTap(0.8f,result,"失败",Sleep);
                        setTaskEnd();return;
                    }
                    mFairy.onTap(0.8f,result,341,1131,362,1156,"再次挑战",3000);

                }
                result =mFairy.findPic(new String[]{"victory.png","victorywz.png","victoryzy.png"});
                mFairy.onTap(0.8f,result,"胜利继续",Sleep);
//                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
//                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("combatjy.png");
                mFairy.onTap(0.8f,result,468,829,491,844,"战斗失败重试",Sleep);

                result =mFairy.findPic("chongz.png");
                mFairy.onTap(0.8f,result,318,1063,369,1087,"战斗失败重试",Sleep);

            }
        }.taskContent(mFairy, "王座之塔");
    }

    /**
     * 异界迷宫(new)
     */
    public void raceTowernew() throws Exception {
        new SingleTask(mFairy) {
            int yjcs =0;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic("Alien maze.png");
                mFairy.onTap(0.8f,result,"异界迷宫",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(69,66,642,1034,"coordinate2.png");
                mFairy.onTap(0.8f,result,result.x-92,result.y-23,result.x-91,result.y-22,"左边",2000);//186,745 90,722

                result =mFairy.findPic("yjgg.png");
                mFairy.onTap(0.8f,result,643,261,656,279,"关闭说明",Sleep);

                result =mFairy.findPic(69,66,642,1034,"coordinate2.png");
                mFairy.onTap(0.9f,result,result.x+92,result.y+23,result.x+93,result.y+24,"右边",2000);//186,745 241,705

                result =mFairy.findPic(69,66,642,1034,"Carriage.png");
                mFairy.onTap(0.8f,result,147,608,170,622,"选择第一个英雄",Sleep);
                mFairy.onTap(0.8f,result,345,826,383,845,"确定选择",Sleep);

                result =mFairy.findPic("Hot spring.png");
                mFairy.onTap(0.8f,result,461,817,488,847,"温泉",Sleep);

                result =mFairy.findPic("Hot spring2.png");
                mFairy.onTap(0.8f,result,466,807,489,822,"使用温泉",Sleep);

                result =mFairy.findPic("mysterious.png");
                mFairy.onTap(0.8f,result,462,820,488,842,"随机复活队友",Sleep);

                result =mFairy.findPic("mysterious2.png");
                mFairy.onTap(0.8f,result,457,807,490,823,"随机复活队友",Sleep);

                result =mFairy.findPic("Travelling merchant.png");
                mFairy.onTap(0.8f,result,339,813,365,834,"前往旅行商人",Sleep);

                result =mFairy.findPic("Travelling merchant.png");
                mFairy.onTap(0.8f,result,339,813,365,834,"放弃旅行商人",Sleep);

                result =mFairy.findPic(3,3,720,754,"next.png");
                mFairy.onTap(0.8f,result,"进入下一关",Sleep);

                result =mFairy.findPic("Get into.png");
                mFairy.onTap(0.8f,result,"进入下一关",Sleep);

                result =mFairy.findPic(new String[]{"Go toyjmg.png"});
                mFairy.onTap(0.8f,result,"挑战",Sleep);
                result2 =mFairy.findPic("fight2.png");
                result1 =mFairy.findPic("Devil.png");
                if (result.sim<0.8f && result1.sim >0.8f && result2.sim < 0.8f){
                    mFairy.onTap(0.8f,result1,646,276,668,292,"关闭",Sleep);
                }

                result =mFairy.findPic(196,22,499,245,new String[]{"Ultimate.png","Ultimate2.png","Ultimate3.png"});
                mFairy.onTap(0.7f,result,"终极宝箱",Sleep);


                result =mFairy.findPic("Combat.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                if (AtFairyConfig.getOption("bd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("bd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
                result =mFairy.findPic("fight2.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic(19,44,669,1094,"yjbox.png");
                mFairy.onTap(0.8f,result,"遗物宝箱",Sleep);

                result =mFairy.findPic("Relic.png");
                mFairy.onTap(0.8f,result,104,566,120,584,"第一个遗物",Sleep);
                mFairy.onTap(0.8f,result,111,885,137,897,"确定第一个遗物",Sleep);

                result =mFairy.findPic(new String[]{"fail.png","fail2.png"});
                mFairy.onTap(0.8f,result,"失败",Sleep);
                if(result.sim > 0.8f){
                    yjcs --;
                    if (yjcs <= 0){
                        setTaskEnd();return;
                    }
                }

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("yjmg.png");
                result1 =mFairy.findPic(69,66,642,1034,"coordinate.png");
                LtLog.e("1111111111111111111111111"+result.sim+"2222222222222222222222222222222222222222"+result1.sim);
                if (result.sim >=0.8f&& result1.sim < 0.8f){
                    LtLog.e("-----------------------------进来了");
                    setTaskName(0);return;
                }
                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic("nohero.png");
                if(result.sim > 0.8f){
                    LtLog.e("没有英雄可以上阵结束任务");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("littlefive.png");
                mFairy.onTap(0.8f,result,462,834,476,857,"少于5名开始",Sleep);

                result1 =mFairy.findPic("threeceng.png");
                result2 =mFairy.findPic("first end.png");
                if (result2.sim > 0.8f && result1.sim >0.85f){
                    LtLog.e("刷完了");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "异界迷宫");
    }

    /**
     * 悬赏栏(new)
     */
    public void rewardColumnnew() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(231,772,556,1072,new String[]{"Reward column.png","Reward column3.png"});
                mFairy.onTap(0.8f,result,"悬赏栏",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(new String[]{"One key collection2.png","One key collection.png"});
                mFairy.onTap(0.8f,result,"一键领取派遣",Sleep);

                result =mFairy.findPic(504,276,698,392,"pqlingqu.png");
                mFairy.onTap(0.8f,result,"派遣领取",Sleep);

                result2 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result =mFairy.findPic("Battle array2.png");
                // result =mFairy.findPic(102,980,389,1185,new String[]{"teampq.png","Battle array2.png"});
                mFairy.onTap(0.8f,result,"一键派遣",Sleep);
                result1 =mFairy.findPic("Reward column2.png");
                result3 =mFairy.findPic("Battle array3.png");
                if(result.sim<0.8f && result1.sim >0.8f&& result2.sim>0.8f && result3.sim < 0.8f){
                    LtLog.e("没有一键上阵任务");
                    setTaskName(3);return;
                }

                result =mFairy.findPic("pqyes.png");
                mFairy.onTap(0.8f,result,"确定一键派遣",Sleep);

                result =mFairy.findPic("Reward column2.png");
                result1 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result2 =mFairy.findPic("pqlingqu.png");
                if (result.sim > 0.8f && result1.sim < 0.8f && result2.sim < 0.8f){
                    LtLog.e("派遣完成结束");
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception {
                result =mFairy.findPic("Team reward2.png");
                mFairy.onTap(0.8f,result,"团队悬赏",Sleep);

                result =mFairy.findPic("Team reward.png");
                mFairy.onTap(0.8f,result,"团队悬赏",Sleep);

                result =mFairy.findPic(372,954,676,1149,new String[]{"One key collection2.png","One key collection.png"});
                mFairy.onTap(0.8f,result,"一键领取团队派遣",Sleep);

                result =mFairy.findPic(511,271,703,411,"pqlingqu.png");
                mFairy.onTap(0.8f,result,"派遣领取",Sleep);

                result =mFairy.findPic(102,980,389,1185,new String[]{"teampq.png","Battle array2.png"});
                mFairy.onTap(0.8f,result,"一键团队派遣",Sleep);

                result =mFairy.findPic("pqyes.png");
                mFairy.onTap(0.8f,result,"确定一键派遣",Sleep);

                result1 =mFairy.findPic(new String[]{"no.png"});
                if(result1.sim >= 0.8f){
                    LtLog.e("英雄不够派遣");
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Reward column2.png");
                result1 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result2 =mFairy.findPic("pqlingqu.png");
                if (result.sim > 0.8f && result1.sim < 0.8f && result2.sim < 0.8f){
                    LtLog.e("派遣完成结束");
                    setTaskEnd();return;
                }
                result2 =mFairy.findPic(389,251,718,1111,"dispatch.png");
                result =mFairy.findPic("Battle array2.png");
                // result =mFairy.findPic(102,980,389,1185,new String[]{"teampq.png","Battle array2.png"});
                mFairy.onTap(0.8f,result,"一键派遣",Sleep);
                result1 =mFairy.findPic("Reward column2.png");
                result3 =mFairy.findPic("Battle array3.png");
                if(result.sim<0.8f && result1.sim >0.8f&& result2.sim>0.8f && result3.sim < 0.8f){
                    LtLog.e("没有一键上阵任务");
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "悬赏栏");
    }

    /**
     * 图书馆(new)
     */
    public void librarynew() throws Exception {
        new SingleTask(mFairy){
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic("Library.png");
                mFairy.onTap(0.8f,result,"图书馆",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Fetters2.png");
                mFairy.onTap(0.8f,result,"羁绊",Sleep);

                result =mFairy.findPic("Fetters.png");
                if (result.sim > 0.8f){
                    result =mFairy.findPic(584,136,712,1145,"kxfbtanhao.png");
                    mFairy.onTap(0.8f,result,"添加图书馆",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(3);return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 334,1102, 351,211, 2000, 1500);
                if (overtime(8,0))return;
                if (err == 7){
                    setTaskEnd();return;
                }
            }
            public void content_3() throws Exception {
                result1 =mFairy.findPic("Fetters.png");
                result =mFairy.findPic(102,1129,623,1245,"kxfbtanhao.png");
                mFairy.onTap(0.8f,result,result.x-17,result.y+36,result.x-16,result.y+37,"添加羁绊",Sleep);
                mFairy.onTap(0.8f,result,161,447,177,475,"添加羁绊",Sleep);
                mFairy.onTap(0.8f,result,481,1051,498,1079,"确定添加羁绊",Sleep);
                if (result.sim < 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(23,1212,44,1226,"返回",Sleep);
                }
                if (overtime(4,2))return;
            }
        }.taskContent(mFairy, "图书馆");
    }

    /**
     * 竞技场(new)
     */
    public void sportsnew() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Arena.png","Arena4.png","Arena5.png","jjc.png","Arena6.png"});
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(30,64,470,1141,"Arena3.png");
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic("Challengejingji.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result =mFairy.findPic("Challenge jj.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }

                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }


                if (AtFairyConfig.getOption("jjcbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("jjcbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("jjcbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("jjcbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("jjcbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("jjcbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","jixu.png"});
                mFairy.onTap(0.75f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
            }
            public void content_3() throws Exception {
                mFairy.taskSlid(err, new int[]{0, 1, 2}, 0, 355,802, 360,579, 1000, 1000);

                result =mFairy.findPic("Zero.png");
                LtLog.e("============================="+result.sim);
                if (result.sim >= 0.9f){
                    setTaskEnd();return;
                }

                if (AtFairyConfig.getOption("mfcs").equals("1")){
                    result =mFairy.findPic("Free Admission.png");
                    mFairy.onTap(0.8f,result,"挑战免费最后一个",Sleep);
                    if (result.sim >= 0.8f ){
                        setTaskName(2);return;
                    }
                    result =mFairy.findPic("Free Admission3.png");
                    mFairy.onTap(0.8f,result,"挑战免费倒数第二个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                    result =mFairy.findPic("mianfei3.png");
                    mFairy.onTap(0.8f,result,"挑战免费倒数第三个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                }
                if (AtFairyConfig.getOption("sycs").equals("1")){
                    result =mFairy.findPic(new String[]{"Free Admission.png","juanzi.png"});
                    mFairy.onTap(0.8f,result,"挑战花费卷子最后一个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                    result =mFairy.findPic(new String[]{"Free Admission2.png","juanzi2.png"});
                    mFairy.onTap(0.8f,result,"挑战花费卷子倒数第二个",Sleep);
                    if (result.sim >= 0.8f){
                        setTaskName(2);return;
                    }
                }


                result =mFairy.findPic(453,772,626,948,"juanzi.png");
                if (AtFairyConfig.getOption("mf").equals("1")&& result.sim > 0.8f ){
                    setTaskEnd();return;
                }
                if (overtime(6,2))return;
            }
        }.taskContent(mFairy, "竞技场");
    }

    /**
     * 工会狩猎(new)
     */
    public void huntingnew() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("hunting1.png");
                mFairy.onTap(0.8f,result,"工会狩猎",Sleep);

                if (AtFairyConfig.getOption("gbl").equals("1")){
                    result =mFairy.findPic("Sword soul.png");
                    if (result.sim > 0.8f){
                        result =mFairy.findPic("Left.png");
                        mFairy.onTap(0.8f,result,"左箭头",Sleep);
                    }
                    result =mFairy.findPic("Brother brin.png");
                    mFairy.onTap(0.8f,result,331,1213,363,1240,"挑战哥布林",Sleep);
                    result = mFairy.findPic("jhfer.png");
                    mFairy.onTap(0.8f, result,  "挑战哥布林", Sleep);

                }

                if (AtFairyConfig.getOption("ygjh").equals("1")){
                    result =mFairy.findPic("Brother brin.png");
                    if (result.sim > 0.8f){
                        result =mFairy.findPic("right.png");
                        mFairy.onTap(0.8f,result,"右箭头",Sleep);
                    }
                    result =mFairy.findPic("Not opened.png");
                    result1 =mFairy.findPic("openjh.png");
                    if (result.sim < 0.8f && result1.sim <0.8f) {
                        result = mFairy.findPic("Sword soul.png");
                        mFairy.onTap(0.8f, result, 331, 1213, 363, 1240, "挑战远古剑魂", Sleep);
                        result = mFairy.findPic("jhfer.png");
                        mFairy.onTap(0.8f, result,  "挑战远古剑魂", Sleep);
                    }

                }
                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                if (AtFairyConfig.getOption("ghbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }
                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","renyi3.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result1 = mFairy.findPic("Sword soul.png");
                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","openjh.png"});
                if (result.sim > 0.8f && result1.sim>0.8f){
                    LtLog.e("远古剑魂未开启或者没次数了结束任务");
                    setTaskEnd();return;
                }
                if (!AtFairyConfig.getOption("ygjh").equals("1") && AtFairyConfig.getOption("gbl").equals("1")){
                    result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png"});
                    if (result.sim > 0.8f ){
                        LtLog.e("打完哥布林结束任务");
                        setTaskEnd();return;
                    }
                }
                if (!AtFairyConfig.getOption("ygjh").equals("1") && !AtFairyConfig.getOption("gbl").equals("1")){
                    LtLog.e("没有选择哥布林个远古剑魂");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "工会狩猎");
    }

    /**
     *  扭曲梦境(new)
     */
    public void twistedDreamsnew() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(new String[]{"dreams.png","dreams2.png"});
                mFairy.onTap(0.8f,result,"扭曲梦境",Sleep);


                result =mFairy.findPic(180,447,563,634,"Unlock3.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("timeover.png");
                mFairy.onTap(0.8f,result,331,787,373,811,"boss时间到",Sleep);
                if (result.sim > 0.8f){
                    LtLog.e("等待boss刷新 结束任务");
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Challengemj.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                if (AtFairyConfig.getOption("ghbd").equals("1")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,161,792,203,806,"编队1",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("2")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,509,782,561,810,"编队2",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("3")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,180,924,194,938,"编队3",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("4")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,523,923,547,944,"编队4",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("5")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,168,1062,187,1084,"编队5",Sleep);

                }
                if (AtFairyConfig.getOption("ghbd").equals("6")){
                    result =mFairy.findPic("formation.png");
                    mFairy.onTap(0.8f,result,"编队",Sleep);
                    mFairy.onTap(0.8f,result,508,1063,552,1084,"编队6",Sleep);

                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic("frequency.png");
                mFairy.onTap(0.8f,result,244,724,263,742,"不再提示",Sleep);
                mFairy.onTap(0.8f,result,347,786,361,804,"确定",Sleep);

                result =mFairy.findPic("nqmj.png");
                mFairy.onTap(0.8f,result,244,724,263,742,"不再提示",Sleep);
                mFairy.onTap(0.8f,result,347,786,361,804,"确定",Sleep);

                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","Continue.png"});
                if (result.sim > 0.8f){
                    LtLog.e("扭曲梦境没次数了结束任务");
                    setTaskEnd();return;
                }

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","weizhi.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);
            }

        }.taskContent(mFairy, "扭曲梦境");
    }

    /**
     * 奖励(new)
     */
    int jss = 0;
    int xbb =0;
    int fbb =0;
    public void rewardnew() throws Exception {
        new SingleTask(mFairy) {
            boolean gjjl = false;
            boolean hyjl = false;
            boolean yjjl = false;
            boolean rwjl = false;
            boolean mrjl = false;
            boolean mrlq = false;
            boolean mzlq = false;
            boolean mylq = false;
            boolean hjxsl = false;
            boolean yzxsl = false;
            boolean lmksl = false;
            boolean cjjl = false;
            boolean xsllq = false;
            boolean gjjjb = false;
            boolean kqjh = false;
            boolean kxfb = false;
            boolean tjjl = false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("gjjl").equals("1")){
                    gjjl = true;
                }
                if (AtFairyConfig.getOption("hyjl").equals("1")){
                    hyjl = true;
                }
                if (AtFairyConfig.getOption("yjjl").equals("1")){
                    yjjl =true;
                }
                if (AtFairyConfig.getOption("rwjl").equals("1")){
                    rwjl =true;
                }
                if (AtFairyConfig.getOption("mrjl").equals("1")){
                    mrjl =true;
                }
                if (AtFairyConfig.getOption("mrlq").equals("1")){
                    mrlq =true;
                }
                if (AtFairyConfig.getOption("mzlq").equals("1")){
                    mzlq =true;
                }

                if (AtFairyConfig.getOption("mylq").equals("1")) {
                    mylq =true;

                }
                if (AtFairyConfig.getOption("hjxsl").equals("1")) {
                    hjxsl =true;

                }
                if (AtFairyConfig.getOption("yzxsl").equals("1")) {
                    yzxsl =true;

                }

                if (AtFairyConfig.getOption("lmksl").equals("1")) {
                    lmksl =true;

                }
                if (AtFairyConfig.getOption("cjjl").equals("1")) {
                    cjjl =true;

                }
                if (AtFairyConfig.getOption("xsllq").equals("1")) {
                    xsllq =true;

                }
                if (AtFairyConfig.getOption("gjjjb").equals("1")) {
                    gjjjb =true;

                }
                if (AtFairyConfig.getOption("kqjh").equals("1")) {
                    kqjh =true;

                }
                if (AtFairyConfig.getOption("kxfb").equals("1")) {
                    kxfb =true;

                }
                if (AtFairyConfig.getOption("tjjl").equals("1")) {
                    tjjl =true;

                }
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,3))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Drop-down box2.png");
                mFairy.onTap(0.8f,result,"右下拉框",Sleep);

                //挂机奖励
                if (gjjl){
                    setTaskName(2);return;
                }
                //好友奖励
                if (hyjl){
                    LtLog.e("进入好友奖励");
                    result =mFairy.findPic(new String[]{"Good friend.png","Good friend2.png"} );
                    mFairy.onTap(0.8f,result,"好友奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(8);return;
                    }

                }
                //邮件奖励
                if (yjjl){
                    LtLog.e("进入邮件奖励");
                    result =mFairy.findPic(new String[]{"email.png","email3.png"});
                    mFairy.onTap(0.8f,result,"邮件奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(7);return;
                    }
                }
                //活跃度奖励
                if (rwjl){
                    LtLog.e("进入任务奖励");
                    result =mFairy.findPic(new String[]{"task.png","task2.png"});
                    mFairy.onTap(0.8f,result,"任务奖励",Sleep);
                    if(result.sim > 0.8f){
                        jss=0;
                        setTaskName(6);return;
                    }
                }
                //新人任务奖励
                if (mrjl){
                    result =mFairy.findPic("Drop-down box.png");
                    mFairy.onTap(0.8f,result,"左下拉框",Sleep);

                    result =mFairy.findPic("activity.png");
                    mFairy.onTap(0.8f,result,"活动",Sleep);

                    if (xbb == 0) {
                        xbb ++;
                        result = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                        mFairy.onTap(0.8f, result, "光辉", Sleep);
                    }
                    if (xbb <6 && xbb != 0){
                        xbb ++;
                        result =mFairy.findPic(358,387,720,1091,"Recruit.png");
                        mFairy.onTap(0.8f,result,"新兵",Sleep);
                        if(result.sim > 0.8f){ //96,337 79,373
                            result =mFairy.findPic(67,324,720,389,"tanhao.png");
                            mFairy.onTap(0.8f,result,result.x-17,result.y+36,result.x-16,result.y+37,"可以领取的栏",Sleep);
                        }
                    }
                    if (xbb >= 6){
                        xbb =0;
                    }
                    setTaskName(4);return;
                }
                //每日免费
                if (mrlq){
                    mrlq=false;
                    dailyGiftPackage();
                }
                //每周免费
                if (mzlq){
                    mzlq=false;
                    dailyGiftPackage();
                }
                //每月免费
                if (mylq){
                    mylq=false;
                    dailyGiftPackage();
                }
                //皇家犒赏令
                if (hjxsl){
                    hjxsl=false;
                    brisk();
                }
                //勇者犒赏令
                if (yzxsl){
                    yzxsl=false;
                    brisk();
                }
                //成就奖励
                if (cjjl){
                    cjjl=false;
                    achievement();
                }
                //悬赏栏
                if (xsllq){
                    xsllq=false;
                    rewardColumn();
                }
                //高阶竞技币
                if (gjjjb){
                    gjjjb=false;
                    higherOrder();
                }

                if (kxfb){
                    gameUtil.close();
                    setTaskName(9);return;
                }
                if (tjjl){
                    result =mFairy.findPic("hero.png");
                    mFairy.onTap(0.8f,result,"英雄",Sleep);

                    result1 =mFairy.findPic("tjhero.png");
                    result =mFairy.findPic("handbook3.png");
                    mFairy.onTap(0.8f,result,"图鉴",Sleep);
                    // result =mFairy.findPic("handbook3.png");
                    if(result.sim > 0.8f){
                        fbb++;
                        setTaskName(5);return;
                    }
                    if (result1.sim>0.8f && result.sim<0.8f){
                        LtLog.e("没有可领取的图鉴");
                        tjjl=false;
                    }
                }
                if (err >= 4){
                    timekeepInit("任务循环");
                }

            }
            public void content_2() throws Exception {
                if (overtime(2,0))return;
                result =mFairy.findPic(new String[]{"Battle.png","Battle2.png"});
                mFairy.onTap(0.8f,result,"战役",3000);
                mFairy.onTap(0.8f,result,336,978,368,1007,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Treasure chest.png","Treasure chest2.png","boxgj1.png"});
                mFairy.onTap(0.8f,result,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Hang up lq.png","Hang up lq2.png"});
                mFairy.onTap(0.8f,result,"宝箱领取",Sleep);
                if (err == 1){
                    gjjl =false;
                }


            }
            public void content_3() throws Exception {
                boolean xh = timekeep(3,1800000,"任务循环");
                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);
                if (xh) {
                    LtLog.e("时间到 开始从开任务");
                    if (AtFairyConfig.getOption("gjjl").equals("1")) {
                        gjjl = true;
                    }
                    if (AtFairyConfig.getOption("hyjl").equals("1")) {
                        hyjl = true;
                    }
                    if (AtFairyConfig.getOption("kxfb").equals("1")) {
                        kxfb = true;
                    }
                    if (AtFairyConfig.getOption("tjjl").equals("1")) {
                        tjjl = true;
                    }
                    if (AtFairyConfig.getOption("rwjl").equals("1")){
                        jss =0;
                        rwjl =true;
                    }
                    if (AtFairyConfig.getOption("xsllq").equals("1")) {//悬赏栏
                        rewardColumn();
                    }
                    if (AtFairyConfig.getOption("kqjh").equals("1")) {//开启剑魂
                        swordSoul();
                    }
                    if (AtFairyConfig.getOption("gjjjb").equals("1")) {//高阶竞技币
                        higherOrder();
                    }

                    if (AtFairyConfig.getOption("cjjl").equals("1")) {
                        achievement();
                    }
                    if (AtFairyConfig.getOption("hjxsl").equals("1")) {
                        brisk();
                    }
                    if (AtFairyConfig.getOption("yzxsl").equals("1")) {
                        brisk();
                    }
                    setTaskName(0);return;
                }else {
                    if (result.sim<0.8f){
                        gameUtil.close();
                    }
                }

//                result =mFairy.findPic("territory.png");
//                mFairy.onTap(0.8f,result,"领地",Sleep);
//
//                result =mFairy.findPic("shops.png");
//                mFairy.onTap(0.8f,result,"商铺",Sleep);
//
//                result =mFairy.findPic("buyfc.png");
//                mFairy.onTap(0.8f,result,"购买",Sleep);
//
//                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
//                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//
//                result =mFairy.findPic("Sold out.png");
//                if (result.sim > 0.8f){
//                    fc =false;
//                    setTaskName(0);return;
//                }
//
//                result =mFairy.findPic(new String[]{"dust.png","dust2.png"});
//                mFairy.onTap(0.8f,result,"粉尘",Sleep);


            }
            public void content_4() throws Exception {
                result =mFairy.findPic(468,331,702,1158,"Receive dl.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(468,331,702,1158,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("Marvellous.png");
                result1 = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                result2 =mFairy.findPic(358,387,720,1091,"Recruit.png");
                if (result.sim>0.8f && result1.sim<0.8f&& result2.sim<0.8f){
                    xbb=6;
                }
                if (xbb >=6){
                    mrjl =false;
                }

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 343,772, 338,434, 2000, 1500);
                if (overtime(8,0))return;

            }
            public void content_5() throws Exception {

                if (fbb>=1){
                    tjjl=false;
                }
                result =mFairy.findPic(52,145,669,983,"tjtanhao.png");
                mFairy.onTap(0.8f,result,"没有领取钻石的图鉴",Sleep);

                result =mFairy.findPic("Story.png");
                mFairy.onTap(0.8f,result,"故事",Sleep);

                result =mFairy.findPic("open.png");
                mFairy.onTap(0.8f,result,"打开",Sleep);

                result =mFairy.findPic("Diamonds.png");
                mFairy.onTap(0.8f,result,"领取钻石",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8, 10 ,12}, 0, 348,982, 350,184, 2000, 1500);
                if (overtime(12,0))return;
            }
            public void content_6() throws Exception {
                result =mFairy.findPic("task lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(1,202,720,383,"task box.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("zxlingqu.png");
                mFairy.onTap(0.8f,result,"主线领取",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(new String[]{"go.png","Completed.png"});
                if (result.sim > 0.8f && jss == 2){
                    jss =1;
                    mFairy.onTap(0.8f,result,596,1075,633,1101,"主线",Sleep);
                }
                if (result.sim > 0.8f && jss == 0){
                    jss =2;
                    mFairy.onTap(0.8f,result,413,1072,446,1106,"周长",Sleep);
                }
                result =mFairy.findPic("Hang in the air.png");
                if (result.sim > 0.8f){
                    rwjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("renwu.png");
                if (result.sim < 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_7() throws Exception {
                if(overtime(10,0))return;

                result =mFairy.findPic("yjlqemail.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("yjlqemail2.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("yjdelemail.png");
//                mFairy.onTap(0.8f,result,"一键删除邮件",Sleep);

                result =mFairy.findPic(36,83,671,721,"Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//
//                result =mFairy.findPic(new String[]{"yes.png","yes2.png"});
//                mFairy.onTap(0.8f,result,"确认删除",Sleep);

                result =mFairy.findPic(554,177,712,965,"exclamation mark.png");
                mFairy.onTap(0.8f,result,"公告",Sleep);

                result =mFairy.findPic("email yes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result =mFairy.findPic("noemail.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }

                result =mFairy.findPic("email2.png");
                if (result.sim <0.8f){
                    LtLog.e("没进邮箱");
                    setTaskName(0);return;
                }
            }
            public void content_8() throws Exception {
                if (overtime(3,0))return;
                result =mFairy.findPic(new String[]{"One collection.png","One collection2.png"});
                mFairy.onTap(0.8f,result,"一键领取和赠送",Sleep);

                if (err == 2){
                    hyjl =false;
                }
            }
            public void content_9() throws Exception {
                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(411,642,707,1122,"Tabula Rasa.png");
                mFairy.onTap(0.8f,result,"凯旋丰碑",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    kxfb =false;
                    setTaskName(0);return;
                }

                result1 =mFairy.findPic("Triumph.png");
                if (result1.sim > 0.8f){
                    result =mFairy.findPic(221,91,713,948,"kxfbtanhao.png");
                    mFairy.onTap(0.8f,result,"可领取的榜",Sleep);
                    if (result.sim <0.8f){
                        kxfb =false;
                        setTaskName(0);return;
                    }
                }

                result =mFairy.findPic(2,1136,713,1274,"reward.png");
                mFairy.onTap(0.8f,result,"奖励",3000);
                if(result.sim > 0.8f){
                    setTaskName(10);return;
                }
                result =mFairy.findPic("renwu.png");
                mFairy.onTap(0.8f,result,26,1096,40,1106,"关闭",Sleep);
            }
            public void content_10() throws Exception{
                result =mFairy.findPic(343,359,645,1076,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 333,911, 344,322, 2000, 1500);
                if (overtime(8,0))return;
            }
        }.taskContent(mFairy, "奖励");
    }

    /**
     * 奖励(newtwo)
     */
    public void rewardnews() throws Exception {
        new SingleTask(mFairy) {
            boolean gjjl = false;
            boolean hyjl = false;
            boolean yjjl = false;
            boolean rwjl = false;
            boolean mrjl = false;
            boolean mrlq = false;
            boolean mzlq = false;
            boolean mylq = false;
            boolean hjxsl = false;
            boolean yzxsl = false;
            boolean lmksl = false;
            boolean cjjl = false;
            boolean xsllq = false;
            boolean gjjjb = false;
            boolean kqjh = false;
            boolean kxfb = false;
            boolean tjjl = false;
            public void create() throws Exception {
                gjjl = true;
                hyjl = true;
                yjjl =true;
                rwjl =true;
                mrjl =true;
                mrlq =true;
                mzlq =true;
                mylq =true;
                hjxsl =true;
                yzxsl =true;
                lmksl =true;
                cjjl =true;
                xsllq =true;
                gjjjb =true;
                kqjh =true;
                kxfb =true;
                tjjl =true;
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,3))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Drop-down box2.png");
                mFairy.onTap(0.8f,result,"右下拉框",Sleep);

                //挂机奖励
                if (gjjl){
                    setTaskName(2);return;
                }
                //好友奖励
                if (hyjl){
                    LtLog.e("进入好友奖励");
                    result =mFairy.findPic(new String[]{"Good friend.png","Good friend2.png"} );
                    mFairy.onTap(0.8f,result,"好友奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(8);return;
                    }

                }
                //邮件奖励
                if (yjjl){
                    LtLog.e("进入邮件奖励");
                    result =mFairy.findPic(new String[]{"email.png","email3.png"});
                    mFairy.onTap(0.8f,result,"邮件奖励",Sleep);
                    if (result.sim > 0.8f){
                        setTaskName(7);return;
                    }
                }
                //活跃度奖励
                if (rwjl){
                    LtLog.e("进入任务奖励");
                    result =mFairy.findPic(new String[]{"task.png","task2.png"});
                    mFairy.onTap(0.8f,result,"任务奖励",Sleep);
                    if(result.sim > 0.8f){
                        jss=0;
                        setTaskName(6);return;
                    }
                }
//                //新人任务奖励
//                if (mrjl){
//                    result =mFairy.findPic("Drop-down box.png");
//                    mFairy.onTap(0.8f,result,"左下拉框",Sleep);
//
//                    result =mFairy.findPic("activity.png");
//                    mFairy.onTap(0.8f,result,"活动",Sleep);
//
//                    if (xbb == 0) {
//                        xbb ++;
//                        result = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
//                        mFairy.onTap(0.8f, result, "光辉", Sleep);
//                    }
//                    if (xbb <6 && xbb != 0){
//                        xbb ++;
//                        result =mFairy.findPic(358,387,720,1091,"Recruit.png");
//                        mFairy.onTap(0.8f,result,"新兵",Sleep);
//                        if(result.sim > 0.8f){ //96,337 79,373
//                            result =mFairy.findPic(67,324,720,389,"tanhao.png");
//                            mFairy.onTap(0.8f,result,result.x-17,result.y+36,result.x-16,result.y+37,"可以领取的栏",Sleep);
//                        }
//                    }
//                    if (xbb >= 6){
//                        xbb =0;
//                    }
//                    setTaskName(4);return;
//                }
                //每日免费
                if (mrlq){
                    mrlq=false;
                    dailyGiftPackagenew();
                }
                //皇家犒赏令
                if (hjxsl){
                    hjxsl=false;
                    brisknew();
                }
                //成就奖励
                if (cjjl){
                    cjjl=false;
                    achievement();
                }
                //悬赏栏
                if (xsllq){
                    xsllq=false;
                    rewardColumn();
                }
                //高阶竞技币
                if (gjjjb){
                    gjjjb=false;
                    higherOrder();
                }

                if (kxfb){//凯旋丰碑
                    gameUtil.close();
                    setTaskName(9);return;
                }
                if (tjjl){
                    result =mFairy.findPic("hero.png");
                    mFairy.onTap(0.8f,result,"英雄",Sleep);

                    result1 =mFairy.findPic("tjhero.png");
                    result =mFairy.findPic("handbook3.png");
                    mFairy.onTap(0.8f,result,"图鉴",Sleep);
                    // result =mFairy.findPic("handbook3.png");
                    if(result.sim > 0.8f){
                        fbb++;
                        setTaskName(5);return;
                    }
                    if (result1.sim>0.8f && result.sim<0.8f){
                        LtLog.e("没有可领取的图鉴");
                        tjjl=false;
                    }
                }
                if (err >= 4){
                    LtLog.e("结束任务");
                   setTaskEnd();return;
                }

            }
            public void content_2() throws Exception {
                if (overtime(2,0))return;
                result =mFairy.findPic(new String[]{"Battle.png","Battle2.png"});
                mFairy.onTap(0.8f,result,"战役",3000);
                mFairy.onTap(0.8f,result,336,978,368,1007,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Treasure chest.png","Treasure chest2.png","boxgj1.png"});
                mFairy.onTap(0.8f,result,"宝箱",Sleep);

                result =mFairy.findPic(new String[]{"Hang up lq.png","Hang up lq2.png"});
                mFairy.onTap(0.8f,result,"宝箱领取",Sleep);
                if (err == 1){
                    gjjl =false;
                }


            }
            public void content_4() throws Exception {
                result =mFairy.findPic(468,331,702,1158,"Receive dl.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(468,331,702,1158,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("Marvellous.png");
                result1 = mFairy.findPic(353, 157, 719, 831, "guanghui.png");
                result2 =mFairy.findPic(358,387,720,1091,"Recruit.png");
                if (result.sim>0.8f && result1.sim<0.8f&& result2.sim<0.8f){
                    xbb=6;
                }
                if (xbb >=6){
                    mrjl =false;
                }

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 343,772, 338,434, 2000, 1500);
                if (overtime(8,0))return;

            }
            public void content_5() throws Exception {

                if (fbb>=1){
                    tjjl=false;
                }
                result =mFairy.findPic(52,145,669,983,"tjtanhao.png");
                mFairy.onTap(0.8f,result,"没有领取钻石的图鉴",Sleep);

                result =mFairy.findPic("Story.png");
                mFairy.onTap(0.8f,result,"故事",Sleep);

                result =mFairy.findPic("open.png");
                mFairy.onTap(0.8f,result,"打开",Sleep);

                result =mFairy.findPic("Diamonds.png");
                mFairy.onTap(0.8f,result,"领取钻石",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);
                mFairy.onTap(0.8f,result,20,1213,42,1229,"返回",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6 , 8, 10 ,12}, 0, 348,982, 350,184, 2000, 1500);
                if (overtime(12,0))return;
            }
            public void content_6() throws Exception {
                result =mFairy.findPic("task lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(1,202,720,383,"task box.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic("zxlingqu.png");
                mFairy.onTap(0.8f,result,"主线领取",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result =mFairy.findPic(new String[]{"go.png","Completed.png"});
                if (result.sim > 0.8f && jss == 2){
                    jss =1;
                    mFairy.onTap(0.8f,result,596,1075,633,1101,"主线",Sleep);
                }
                if (result.sim > 0.8f && jss == 0){
                    jss =2;
                    mFairy.onTap(0.8f,result,413,1072,446,1106,"周长",Sleep);
                }
                result =mFairy.findPic("Hang in the air.png");
                if (result.sim > 0.8f){
                    rwjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("renwu.png");
                if (result.sim < 0.8f){
                    setTaskName(0);return;
                }
            }
            public void content_7() throws Exception {
                result =mFairy.findPic("yjlqemail.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >=0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
                result =mFairy.findPic("yjlqemail2.png");
                mFairy.onTap(0.8f,result,"一键领取邮件",500);
                result =mFairy.findPic("emailjl.png");
                if (result.sim >=0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }
//                result =mFairy.findPic("yjdelemail.png");
//                mFairy.onTap(0.8f,result,"一键删除邮件",Sleep);

                result =mFairy.findPic(36,83,671,721,"Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
//
//                result =mFairy.findPic(new String[]{"yes.png","yes2.png"});
//                mFairy.onTap(0.8f,result,"确认删除",Sleep);

                result =mFairy.findPic(554,177,712,965,"exclamation mark.png");
                mFairy.onTap(0.8f,result,"公告",Sleep);

                result =mFairy.findPic("email yes.png");
                mFairy.onTap(0.8f,result,"确定",Sleep);

                result =mFairy.findPic("notice.png");
                mFairy.onTap(0.8f,result,655,227,668,239,"通知关闭",Sleep);


                result =mFairy.findPic("noemail.png");
                if (result.sim >0.8f){
                    yjjl =false;
                    setTaskName(0);return;
                }

//                result =mFairy.findPic("email2.png");
//                if (result.sim <0.8f){
//                    LtLog.e("没进邮箱");
//                    setTaskName(0);return;
//                }
            }
            public void content_8() throws Exception {
                if (overtime(3,0))return;
                result =mFairy.findPic(new String[]{"One collection.png","One collection2.png"});
                mFairy.onTap(0.8f,result,"一键领取和赠送",Sleep);

                if (err == 2){
                    hyjl =false;
                }
            }
            public void content_9() throws Exception {
                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(411,642,707,1122,"Tabula Rasa.png");
                mFairy.onTap(0.8f,result,"凯旋丰碑",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    kxfb =false;
                    setTaskName(0);return;
                }

                result1 =mFairy.findPic("Triumph.png");
                if (result1.sim > 0.8f){
                    result =mFairy.findPic(221,91,713,948,"kxfbtanhao.png");
                    mFairy.onTap(0.8f,result,"可领取的榜",Sleep);
                    if (result.sim <0.8f){
                        kxfb =false;
                        setTaskName(0);return;
                    }
                }

                result =mFairy.findPic(2,1136,713,1274,"reward.png");
                mFairy.onTap(0.8f,result,"奖励",3000);
                if(result.sim > 0.8f){
                    setTaskName(10);return;
                }
                result =mFairy.findPic("renwu.png");
                mFairy.onTap(0.8f,result,26,1096,40,1106,"关闭",Sleep);
            }
            public void content_10() throws Exception{
                result =mFairy.findPic(343,359,645,1076,"lingqu.png");
                mFairy.onTap(0.8f,result,"领取",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 333,911, 344,322, 2000, 1500);
                if (overtime(8,0))return;
            }
        }.taskContent(mFairy, "奖励");
    }

    /**
     * 皇家悬赏令/勇者悬赏令(new)
     */
    public void brisknew() throws Exception {
        new SingleTask(mFairy) {
            boolean yz =false;
            boolean hj =false;
            boolean lm = false;
            public void create() throws Exception {
                hj=true;
                yz=true;
                lm =true;
            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(6,0))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Trading port.png");
                mFairy.onTap(0.8f,result,"贸易港",3000);

                if (hj){

                    result =mFairy.findPic(59,1002,669,1157,new String[]{"Royal family.png","Royal family2.png","hjxsl.png"});
                    mFairy.onTap(0.8f,result,"皇家犒赏令",Sleep);
                    if (result.sim > 0.8f){
                        hj=false;
                        setTaskName(2);return;
                    }

                }
                if (yz) {

                    result =mFairy.findPic(59,1002,669,1157,new String[]{"Brave.png","yongzhe.png"});
                    mFairy.onTap(0.8f,result,"勇者犒赏令",Sleep);
                    if (result.sim > 0.8f){
                        yz=false;
                        setTaskName(2);return;
                    }

                }
                if (lm) {

                    result =mFairy.findPic(59,1002,669,1157,"Dream hunting.png");
                    mFairy.onTap(0.8f,result,"猎梦犒赏令",Sleep);
                    if (result.sim > 0.8f){
                        lm=false;
                        setTaskName(2);return;
                    }

                }

                if (err >=2){
                    setTaskEnd();return;

                }

            }
            public void content_2() throws Exception {
                mFairy.sleep(2000);
                result =mFairy.findPic(510,342,714,1062,"Braveopen.png");
                mFairy.onTap(0.8f,result,"领取悬赏令",Sleep);

                result =mFairy.findPic(510,342,714,1062,"xs.png");
                mFairy.onTap(0.8f,result,"领取悬赏令",Sleep);

                result =mFairy.findPic("quer.png");
                mFairy.onTap(0.8f,result,"确认领取悬赏令",2000);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                if (overtime(6,1))return;
            }

        }.taskContent(mFairy, "悬赏令");
    }
    /**
     *  周礼包月礼包日礼包(new)
     */
    public void dailyGiftPackagenew() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(10,0))return;

                result =mFairy.findPic("Battle.png");
                mFairy.onTap(0.8f,result,"战役",Sleep);

                result =mFairy.findPic("Trading port.png");
                mFairy.onTap(0.8f,result,"贸易港",3000);

                result =mFairy.findPic(172,1165,395,1280,"Merchant ship.png");
                mFairy.onTap(0.8f,result,"普通商船",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(6,0))return;

                result =mFairy.findPic(172,1165,395,1280,"Merchant ship.png");
                mFairy.onTap(0.8f,result,"普通商船",Sleep);

                result =mFairy.findPic(1,985,717,1166,new String[]{"daypackage.png","daypackage2.png"});
                mFairy.onTap(0.8f,result,"日礼包",3000);
                mFairy.onTap(0.8f,result,139,419,155,436,"领取日礼包",Sleep);


                result =mFairy.findPic(1,985,717,1166,"weekpackage.png");
                mFairy.onTap(0.8f,result,"周礼包",3000);
                mFairy.onTap(0.8f,result,122,416,150,434,"领取周礼包",Sleep);

                result =mFairy.findPic(1,985,717,1166,"monpackage.png");
                mFairy.onTap(0.8f,result,"月礼包",3000);
                mFairy.onTap(0.8f,result,110,445,132,461,"领取月礼包",Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
                if (err >1){
                    setTaskEnd();return;

                }
            }

        }.taskContent(mFairy, "礼包");
    }

    /**
     * 竞技场(newtwo)
     */
    public void sportsnews() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("Field.png");
                mFairy.onTap(0.8f,result,"野外",Sleep);

                result =mFairy.findPic(new String[]{"Arena.png","Arena4.png","Arena5.png","jjc.png","Arena6.png"});
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic(30,64,470,1141,"Arena3.png");
                mFairy.onTap(0.8f,result,"竞技场",Sleep);

                result =mFairy.findPic("Challengejingji.png");
                mFairy.onTap(0.8f,result,"挑战",Sleep);

                result =mFairy.findPic("Challenge jj.png");
                if (result.sim > 0.8f){
                    setTaskName(3);return;
                }

                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",Sleep);

                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","jixu.png"});
                mFairy.onTap(0.75f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);
            }
            public void content_3() throws Exception {
                if (overtime(6,2))return;
                mFairy.taskSlid(err, new int[]{0, 1, 2}, 0, 355,802, 360,579, 1000, 1000);

                result =mFairy.findPic("Zero.png");
                LtLog.e("============================="+result.sim);
                if (result.sim >= 0.9f){
                    setTaskEnd();return;
                }

                result =mFairy.findPic("Free Admission.png");
                mFairy.onTap(0.8f,result,"挑战免费最后一个",Sleep);
                if (result.sim >= 0.8f ){
                    setTaskName(2);return;
                }
                result =mFairy.findPic("Free Admission3.png");
                mFairy.onTap(0.8f,result,"挑战免费倒数第二个",Sleep);
                if (result.sim >= 0.8f){
                    setTaskName(2);return;
                }
                result =mFairy.findPic(447,655,621,758,"mianfei3.png");
                mFairy.onTap(0.8f,result,"挑战免费倒数第三个",Sleep);
                if (result.sim >= 0.8f){
                    setTaskName(2);return;
                }
                result =mFairy.findPic(455,529,624,627,"mianfei3.png");
                mFairy.onTap(0.8f,result,"挑战免费倒数第4个",Sleep);
                if (result.sim >= 0.8f){
                    setTaskName(2);return;
                }

                result =mFairy.findPic(456,416,622,509,"mianfei3.png");
                mFairy.onTap(0.8f,result,"挑战免费倒数第5个",Sleep);
                if (result.sim >= 0.8f){
                    setTaskName(2);return;
                }
//                if (AtFairyConfig.getOption("sycs").equals("1")){
//                    result =mFairy.findPic(new String[]{"Free Admission.png","juanzi.png"});
//                    mFairy.onTap(0.8f,result,"挑战花费卷子最后一个",Sleep);
//                    if (result.sim >= 0.8f){
//                        setTaskName(2);return;
//                    }
//                    result =mFairy.findPic(new String[]{"Free Admission2.png","juanzi2.png"});
//                    mFairy.onTap(0.8f,result,"挑战花费卷子倒数第二个",Sleep);
//                    if (result.sim >= 0.8f){
//                        setTaskName(2);return;
//                    }
//                }


                result =mFairy.findPic(453,772,626,948,"juanzi.png");
                if (result.sim > 0.8f ){
                    setTaskEnd();return;
                }

            }
        }.taskContent(mFairy, "竞技场");
    }

    /**
     * 工会狩猎(newtwo)
     */
    public void huntingnews() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(130,223,389,583,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("hunting1.png");
                mFairy.onTap(0.8f,result,"工会狩猎",Sleep);

                result =mFairy.findPic("Sword soul.png");
                if (result.sim > 0.8f){
                    result =mFairy.findPic("Left.png");
                    mFairy.onTap(0.8f,result,"左箭头",Sleep);
                }
                result =mFairy.findPic("Brother brin.png");
                mFairy.onTap(0.8f,result,331,1213,363,1240,"挑战哥布林",Sleep);
                result = mFairy.findPic("jhfer.png");
                mFairy.onTap(0.8f, result,  "挑战哥布林", Sleep);

//                result =mFairy.findPic("Brother brin.png");
//                if (result.sim > 0.8f){
//                    result =mFairy.findPic("right.png");
//                    mFairy.onTap(0.8f,result,"右箭头",Sleep);
//                }
//                result =mFairy.findPic("Not opened.png");
//                result1 =mFairy.findPic("openjh.png");
//                if (result.sim < 0.8f && result1.sim <0.8f) {
//                    result = mFairy.findPic("Sword soul.png");
//                    mFairy.onTap(0.8f, result, 331, 1213, 363, 1240, "挑战远古剑魂", Sleep);
//                    result = mFairy.findPic("jhfer.png");
//                    mFairy.onTap(0.8f, result,  "挑战远古剑魂", Sleep);
//                }


                result =mFairy.findPic("fist.png");
                if (result.sim >0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }

                result =mFairy.findPic("fight.png");
                mFairy.onTap(0.8f,result,"战斗",500);
                result =mFairy.findPic("szhero.png");
                if (result.sim>0.8f){
                    mFairy.onTap(0.8f,result,85,808,106,831,"上阵1",Sleep);
                    mFairy.onTap(0.8f,result,213,813,226,822,"上阵2",Sleep);
                    mFairy.onTap(0.8f,result,340,811,354,823,"上阵3",Sleep);
                    mFairy.onTap(0.8f,result,486,813,503,833,"上阵4",Sleep);
                    mFairy.onTap(0.8f,result,616,811,637,823,"上阵5",Sleep);
                }
                result =mFairy.findPic(new String[]{"Hurry up.png","renyi.png","renyi2.png","agin.png","renyi3.png"});
                mFairy.onTap(0.8f,result,"点击屏幕继续",Sleep);

                result =mFairy.findPic("Get rewards.png");
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                result1 = mFairy.findPic("Sword soul.png");
                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png","openjh.png"});
                if (result.sim > 0.8f && result1.sim>0.8f){
                    LtLog.e("远古剑魂未开启或者没次数了结束任务");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(new String[]{"Not opened.png","Run out of times.png"});
                if (result.sim > 0.8f ){
                    LtLog.e("打完哥布林结束任务");
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "工会狩猎");
    }

    /**
     * 异界旅店
     */
    public void hostel() throws Exception {
        new SingleTask(mFairy) {
            int count = 0 ;
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }
            public void content_2() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(304,69,702,640,new String[]{"hostel.png","hostel2.png"});
                mFairy.onTap(0.8f,result,"异界旅店",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("Go shopping.png");
                mFairy.onTap(0.8f,result,"去逛逛",Sleep);

                result1 =mFairy.findPic(300,403,720,785,"lvdian.png");
                result =mFairy.findPic(300,403,720,785,"firendgift.png");
                mFairy.onTap(0.8f,result,result.x+19,result.y+28,result.x+20,result.y+30,"好友列表",Sleep);
                if (result.sim < 0.8f && result1.sim > 0.8f){
                  setTaskName(4);return;
                }
                result = mFairy.findPic(523,122,713,1047,new String[]{"redbox.png","bluebox.png","boxx.png","bxnew.png","box2.png"});
                mFairy.onTap(0.8f, result,  "奖励", Sleep);
                if(result.sim > 0.8f){
                    setTaskName(3);return;
                }

                result =mFairy.findPic(133,390,623,633,"tanhaolv.png");
                mFairy.onTap(0.8f,result,650,220,660,232,"关闭",Sleep);

                result =mFairy.findPic(133,390,623,633,"room.png");
                mFairy.onTap(0.8f,result,650,220,660,232,"关闭",Sleep);
            }
            public void content_3() throws Exception {
                if (overtime(6,2)){count=0;return;}
                result = mFairy.findPic(96,127,601,999,new String[]{"red2box.png","blue2box.png","bx2.png","box3.png"});
                mFairy.onTap(0.8f, result,  "奖励", Sleep);

                result = mFairy.findPic(101,610,634,892,"lingqulvd.png");
                mFairy.onTap(0.8f, result,  "奖励", Sleep);

                result =mFairy.findPic(new String[]{"Get rewards.png","li.png"});
                mFairy.onTap(0.8f,result,"获得奖励",Sleep);

                mFairy.taskSlid(err, new int[]{0, 1, 2, 4}, 0, 352,538, 339,985, 1000, 1000);
            }
            public void content_4() throws Exception{
                if (overtime(8,2))return;
                result =mFairy.findPic("myhome.png");
                mFairy.onTap(0.8f,result,"返回我的家",Sleep);

                result =mFairy.findPic(96,127,601,999,"accomplish.png");
                mFairy.onTap(0.8f,result,"完成",Sleep);

                result =mFairy.findPic(96,127,601,999,"build.png");
                mFairy.onTap(0.8f,result,"建筑",Sleep);

                result =mFairy.findPic(69,462,643,733,"extension.png");
                mFairy.onTap(0.8f,result,463,855,479,865,"扩建",Sleep);

                mFairy.taskSlid(err, new int[]{0, 2, 5}, 0, 352,538, 339,985, 1000, 1000);

                if (err == 6){
                  /*  gameUtil.close();
                    setTaskEnd();return;*/
                    count++;
                    setTaskName(5);return;
                }
            }
            public void content_5() throws Exception{
                if (overtime(5,4))return;
                if (count>6){
                    setTaskEnd();return;
                }
                switch(count){
                    case 1:
                        result =mFairy.findPic(97,1174,553,1267,"B2.png");
                        mFairy.onTap(0.85f,result,"B2",Sleep);
                        if (result.sim > 0.8f){
                            setTaskName(4);return;
                        }else if (err >=3){
                            setTaskEnd();return;
                        }
                        break;
                    case 2:
                        result =mFairy.findPic(97,1174,553,1267,"B3.png");
                        mFairy.onTap(0.8f,result,"B3",Sleep);
                        if (result.sim > 0.8f){
                            setTaskName(4);return;
                        }else if (err >=3){
                            setTaskEnd();return;
                        }
                        break;
                    case 3:
                        result =mFairy.findPic(97,1174,553,1267,"B4.png");
                        mFairy.onTap(0.8f,result,"B4",Sleep);
                        if (result.sim > 0.8f){
                            setTaskName(4);return;
                        }else if (err >=3){
                            setTaskEnd();return;
                        }
                        break;
                    case 4:
                        mFairy.ranSwipe(422,1222,170,1218,500,1500);
                        result =mFairy.findPic(97,1174,553,1267,"B5.png");
                        mFairy.onTap(0.8f,result,"B5",Sleep);
                        if (result.sim > 0.8f){
                            setTaskName(4);return;
                        }else if (err >=3){
                            setTaskEnd();return;
                        }
                        break;
                    case 5:
                        mFairy.ranSwipe(422,1222,170,1218,500,1500);
                        result =mFairy.findPic(97,1174,553,1267,"B6.png");
                        mFairy.onTap(0.8f,result,"B6",Sleep);
                        if (result.sim > 0.8f){
                            setTaskName(4);return;
                        }else if (err >=3){
                            setTaskEnd();return;
                        }
                        break;
                    case 6:
                        mFairy.ranSwipe(422,1222,170,1218,500,1500);
                        result =mFairy.findPic(97,1174,553,1267,"B7.png");
                        mFairy.onTap(0.8f,result,"B7",Sleep);
                        if (result.sim > 0.8f){
                            setTaskName(4);return;
                        }else if (err >=3){
                            setTaskEnd();return;
                        }
                        break;

                }


            }

        }.taskContent(mFairy, "异界旅店");
    }

    /**
     * 幻池攻坚战
     */
    public void hcgjz() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                result =mFairy.findPic(2,396,139,1059,"Pull up box.png");
                mFairy.onTap(0.8f,result,"收起左拉框",Sleep);

                result =mFairy.findPic("Pull up box2.png");
                mFairy.onTap(0.8f,result,"收起右拉框",Sleep);

                result =mFairy.findPic("territory.png");
                mFairy.onTap(0.8f,result,"领地",Sleep);

                result =mFairy.findPic(252,384,475,529,"Labour Union.png");
                mFairy.onTap(0.8f,result,"工会",Sleep);

                result =mFairy.findPic(180,447,563,634,"Unlock2.png");
                mFairy.onTap(0.8f,result,357,840,370,847,"还没解锁",Sleep);
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }
                result =mFairy.findPic("zero2.png");
                if (result.sim > 0.8f){
                    LtLog.e("没有燃料了");
                    setTaskEnd();return;
                }
                result1 =mFairy.findPic("never gjz.png");
                result =mFairy.findPic("hcgjz.png");
                mFairy.onTap(0.8f,result,"幻池攻坚战",2000);
                if( result.sim < 0.8f &&  result1.sim > 0.8f){
                    LtLog.e("攻坚战活动结束了");
                    setTaskEnd();return;
                }
                result =mFairy.findPic(130,512,579,794,"fist2.png");
                mFairy.onTap(0.8f,result,621,1174,635,1187,"切换目标",Sleep);
                if (result.sim > 0.8f){

                }else {
                    result =mFairy.findPic("faer.png");
                    mFairy.onTap(0.8f,result,"进攻",1000);
                }
                result =mFairy.findPic("Diamonds2.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,231,837,243,845,"取消",Sleep);
                    setTaskEnd();return;
                }else {
                    result = mFairy.findPic("gjzyes.png");
                    mFairy.onTap(0.8f, result, "确认切换", Sleep);
                }

                result =mFairy.findPic("overtask.png");
                if (result.sim > 0.8f) {
                    setTaskName(2);return;
                }

                result = mFairy.findPic(new String[]{"Get rewards.png", "li.png", "li2.png"});
                mFairy.onTap(0.8f, result, "获得奖励", Sleep);


            }
            public void content_2() throws Exception {
                result = mFairy.findPic(2,551,714,1106,"fist2.png");
                mFairy.onTap(0.8f, result,  610,149,628,161,"结束", Sleep);

                result = mFairy.findPic("first.png");
                mFairy.onTap(0.8f, result, "第一个", Sleep);

                result = mFairy.findPic(545,461,709,761,"secend.png");
                mFairy.onTap(0.7f, result, "第二个", Sleep);

                result = mFairy.findPic(230,105,604,433,"third.png");
                mFairy.onTap(0.7f, result, "第三个", Sleep);

                result = mFairy.findPic(293,909,484,1033,"stone.png");
                if (result.sim > 0.8f){
                    mFairy.ranSwipe(105,1017,453,1024,1500,1500);
                }
                result = mFairy.findPic(6,646,442,1118,"first.png");
                mFairy.onTap(0.8f, result, "第四个", Sleep);

                result = mFairy.findPic("advance.png");
                mFairy.onTap(0.8f, result, 473,839,483,846,"提前结束", Sleep);

                result = mFairy.findPic(new String[]{"Get rewards.png", "li.png", "li2.png"});
                mFairy.onTap(0.8f, result, "获得奖励", Sleep);

                result =mFairy.findPic("goback.png");
                mFairy.onTap(0.8f,result,"返回营地",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(1);return;
                }
            }

        }.taskContent(mFairy, "幻池攻坚战");
    }
}

