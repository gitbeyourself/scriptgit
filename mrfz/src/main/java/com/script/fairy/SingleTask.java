package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    final static int sleepTime = 100;
    Map<String, String> levelMap = null;

    public SingleTask(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        util = new Util(mFairy);
    }

    /**
     * 新手指引，过完0-2关
     */
    public void novice() throws Exception {
        int find=0;
        while (mFairy.condit()) {
            LtLog.e(mFairy.getLineInfo("新手引导中"));
            //第一个教程关卡
            result = mFairy.findPic(486, 448, 659, 598, "sign_drag.png");
            if (result.sim >= 0.8) {

                //拖动一:释放第一个干员教程
                result = mFairy.findPic(1072, 626, 1136, 688, "tip_yellow.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 585, 420, sleepTime, 500);
                }
                //拖动二:调整第一个干员方向
                result = mFairy.findPic(528, 360, 642, 461, "tip_yellow.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 872, 404, sleepTime, sleepTime);
                }

                //拖动三:释放第二个干员教程
                result = mFairy.findPic(1177, 608, 1265, 696, "tip_yellow.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 682, 311, sleepTime, 100);
                }
                //拖动四：调整第二个干员方向
                result = mFairy.findPic(642, 244, 758, 357, "tip_yellow.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 982, 305, sleepTime, sleepTime);
                }
                continue;
            }

            //第二关教学关卡
            result = mFairy.findPic(486, 448, 659, 598, new String[]{"sign_drag.png", "sign_drag1.png"});
            if (result.sim >= 0.8) {
                //调整为两倍速度
                result = mFairy.findPic(1056, 13, 1146, 95, "2speed.png");
                mFairy.onTap(0.8F, result, "调整为两倍速度", SingleTask.sleepTime);
                continue;
            }

            //第TR-1关教程
            result = mFairy.findPic(372, 442, 417, 479, "sign_TR-1.png");
            if (result.sim >= 0.8) {
                result = mFairy.findPic(834, 557, 1275, 713, "hero_yedao.png");
                //放第一个
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 521, 221, 500, SingleTask.sleepTime);
                    mFairy.ranSwipe(521, 221, 325, 226, sleepTime, SingleTask.sleepTime);//改方向
                }
                //放第二个
                result = mFairy.findPic(834, 557, 1275, 713, "hero_xunlinzhe.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 508, 365, 172, SingleTask.sleepTime);
                    mFairy.ranSwipe(525, 364, 539, 202, 500, SingleTask.sleepTime);//改方向
                }
                //调整为两倍速度
                result = mFairy.findPic(1056, 13, 1146, 95, "2speed.png");
                mFairy.onTap(0.8F, result, "调整为两倍速度", SingleTask.sleepTime);
                continue;
            }


            //匹配所有手势提示
            //83,47
            result = mFairy.findPic(0, 0, 1280, 720, "tip_hand2.png");
            mFairy.onTap(0.8F, result, result.x - 85, result.y - 50, result.x - 83, result.y - 47, "匹配手势所有提示", SingleTask.sleepTime);


            //获取东西确认
            result = mFairy.findPic(485, 583, 800, 696, "get_ok.png");
            mFairy.onTap(0.8F, result, "获取东西确认", SingleTask.sleepTime);

            //寻访干员教程
            result = mFairy.findPic("find_once.png");
            mFairy.onTap(0.8F, result, "寻访一次", SingleTask.sleepTime);

            //确认编队
            result = mFairy.findPic(844, 566, 1273, 716, "group_ok.png");
            mFairy.onTap(0.8F, result, "确认编队", SingleTask.sleepTime);

            //第0-1关教程
            result = mFairy.findPic(121, 307, 225, 391, "sign_0-1.png");
            if (result.sim >= 0.8) {
                //放第一个
                result = mFairy.findPic(627, 567, 1271, 716, "hero_yedao.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 1040, 337, 500, sleepTime);
                    mFairy.ranSwipe(1040, 337, 1255, 309, 500, 2000);//调整方向
                }
                //调整为两倍速度
                result = mFairy.findPic(1056, 13, 1146, 95, "2speed.png");
                mFairy.onTap(0.8F, result, "调整为两倍速度", SingleTask.sleepTime);
                continue;
            }


            //进入0-2关卡
            result = mFairy.findPic(883, 416, 1008, 445, "level/0-2.png");
            mFairy.onTap(0.8F, result, "进入0-2关卡", sleepTime);

            //0-2关
            if (mFairy.findPic(1177, 268, 1279, 418, "sign_0-2.png").sim > 0.8) {
                result = mFairy.findPic(86, 559, 1276, 715, "hero_heijiao.png");
                if (result.sim >= 0.8) {
                    //0-3关
                    if (mFairy.findPic(105, 216, 175, 284, "origin.png").sim >= 0.8) {
                        mFairy.ranSwipe(result.x + 5, result.y + 5, 976, 262, 500, sleepTime);
                        mFairy.ranSwipe(976, 262, 822, 277, 500, sleepTime);
                    } else {
                        mFairy.ranSwipe(result.x + 5, result.y + 5, 988, 346, 500, sleepTime);
                        mFairy.ranSwipe(988, 346, 1200, 323, 500, sleepTime);
                    }
                }

                result = mFairy.findPic(86, 559, 1276, 715, "hero_xunlinzhe.png");
                if (result.sim >= 0.8) {
                    mFairy.ranSwipe(result.x + 5, result.y + 5, 1010, 425, 500, sleepTime);
                    mFairy.ranSwipe(1010, 425, 975, 224, 500, sleepTime);
                }
            }

            //打开寻访结果
            result = mFairy.findPic(990, 129, 1098, 210, "find_result.png");
            if (result.sim >= 0.8) {
                mFairy.ranSwipe(result.x, result.y, 99, 360, 1000, 1500);
                mFairy.onTap(175, 324, 218, 366, "打开寻访结果", 5000);
                mFairy.onTap(623, 366, 658, 396, "点击跳过寻访", SingleTask.sleepTime);
            }

            //开始行动
            result = mFairy.findPic(1045, 625, 1247, 687, "start_action.png");
            mFairy.onTap(0.8F, result, "开始行动", SingleTask.sleepTime);

            //行动结束
            result = mFairy.findPic(306, 572, 401, 678, "action_over.png");
            if (result.sim >= 0.8) {
                mFairy.onTap(444, 321, 508, 377, "行动结束", sleepTime);
                Thread.sleep(1000);
            }

            //首次获得奖励
            result = mFairy.findPic(1166, 456, 1255, 493, "first_award.png");
            mFairy.onTap(0.8F, result, 527, 390, 573, 441, "首次获得奖励", sleepTime);

            //开始行动 red
            result = mFairy.findPic(1041, 455, 1111, 532, "start_action1.png");
            mFairy.onTap(0.8F, result, "red开始行动", sleepTime);

            //返回
            result = mFairy.findPic(28, 16, 66, 61, "return.png");
            if (result.sim >= 0.8 && mFairy.findPic(203, 120, 239, 156, "mu.png").sim >= 0.8) {
                mFairy.onTap(0.8F, result, "返回", sleepTime);
            }

            //调整为两倍速度
            result = mFairy.findPic(1067, 23, 1128, 63, "2speed.png");
            mFairy.onTap(0.8F, result, "调整为两倍速度", SingleTask.sleepTime);


            //任务结束
            result = mFairy.findPic("settings.png");
            if(result.sim>0.8){
                find++;
                LtLog.e("setting="+find);
                Thread.sleep(500);
                if (find >= 30) {
                    LtLog.e("新手指引完成");
                    setTaskEnd();
                    return;
                }
            }
        }
    }

    //初始化关卡
    public void initLevel() {
        LtLog.e("初始化关卡信息");
        Properties props = new Properties();
        Map<String, String> map=new HashMap<String, String>();
        try {
            InputStream in= SingleTask.class.getResourceAsStream("/assets/level/levelInfo.properties");
            props.load(in);
            Enumeration en=props.propertyNames();
            while (en.hasMoreElements()) {
                String key=(String) en.nextElement();
                String property=props.getProperty(key);
                map.put(key, property);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        levelMap=map;
    }

    //进入具体关卡
    boolean enterDetailLevel( String levelInfo) throws Exception {
        LtLog.e(mFairy.getLineInfo("levelInfo="+levelInfo));
        levelInfo=levelMap.get(levelInfo);
        if(levelInfo==null){
            setTaskEnd();
            LtLog.e(mFairy.getLineInfo("没有指定关卡,请重新选择，任务结束"));
            return false;
        }
        String str1[] = levelInfo.split(",");

        if (str1.length>1){
            for(int i=1;i<=6;i++){
                result = mFairy.findPic((i-1)*200, 0,i*200, 720, "level/" + str1[0]);
                if (result.sim>0.8f){
                    result=mFairy.findPic(result.x,result.y,result.x+130,result.y+40,"level/"+str1[1]);
                    if(result.sim>0.8f)break;
                }
            }
        } else {
            result = mFairy.findPic(0, 0, 1280, 720,"level/" + str1[0]);
        }
        mFairy.onTap(0.8f, result, "进入关卡", 1000);
        if(result.sim<0.8f){
            return false;
        }
        return true;
    }

    //回到主界面
    public void close() throws Exception{
        while(mFairy.condit()){
            result = mFairy.findPic(new String[]{"return.png","return1.png"});
            mFairy.onTap(0.8F, result, "返回", 500);

            result1 = mFairy.findPic( 657,31,1279,308,"fight1.png");
            if(result1.sim > 0.8f){
                return;
            }
        }
    }

    //主线作战任务
    public void mainFight() throws Exception {
        new SingleTask(mFairy) {
            int fightCount;
            int sonLevel;
            int detailLevel;
            String levelInfo ;
            int findSection=0;//查找章节的次数，超过五次则没有开通

            @Override
            public void create() throws Exception {
                initLevel();//初始化
                sonLevel = Integer.parseInt(AtFairyConfig.getOption("sonLevel"));//子关数
                detailLevel = Integer.parseInt(AtFairyConfig.getOption("detailLevel"));//具体关卡
                if(AtFairyConfig.getOption("fightCount").equals("")){
                    fightCount=0;
                }else{
                    fightCount = Integer.parseInt(AtFairyConfig.getOption("fightCount"));//作战次数
                }
                if (AtFairyConfig.getOption("s").equals("1")) {//拼接关卡信息
                    levelInfo = "S" + sonLevel + "-" + detailLevel;
                } else {
                    levelInfo = sonLevel + "-" + detailLevel;
                }
                if(fightCount==0){
                    fightCount=-1;
                }
                setTaskName(0);
            }

            public void content_0() throws Exception {
                close();
                findSection=0;//超时操作，回到起点，重新赋值
                setTaskName(1);
            }

            int count=0;
            public void content_1() throws Exception {
                overtime(20,0);
                result = mFairy.findPic( "fight.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);
                result = mFairy.findPic( "taskchoice.png");
                mFairy.onTap(0.8f, result, "进入主线", 100);
                if (result.sim>0.8f){//进入指定章节
                    result = mFairy.findPic(8,125,1272,180, "level/word 0" + sonLevel + "level.png");
                    mFairy.onTap(0.8f, result,result.x-49,result.y+213,result.x+12,result.y+267,"找到指定章节", 100);
                    if (result.sim<0.8f){
                        if (count==0){
                            LtLog.e(mFairy.getLineInfo("没有找到章节，初始化滑动"));
                            for(int i=1;i<=10;i++){
                                mFairy.ranSwipe(500, 400, 1000, 400, 1000, 2000l,0);
                                result=mFairy.findPic("word xuzhang.png");
                                if(result.sim>0.8f){LtLog.e(mFairy.getLineInfo("初始化滑动完成"));break;}
                            }
                            count=1;
                        }else {
                            if(findSection>=8){
                                LtLog.e(mFairy.getLineInfo("没有开通指定章节，无法继续游戏，任务结束"));
                                setTaskEnd();
                                return;
                            }
                            LtLog.e("右滑动一次");
                            mFairy.ranSwipe(900, 90, 500, 90, 500, 200);
                            findSection++;
                        }
                    }else {
                        count=0;
                    }
                }

                result = mFairy.findPic("Level interface.png");
                if (result.sim>0.8f){
                    boolean isFind=enterDetailLevel(levelInfo);
                    if (!isFind){
                        if (count==0){
                            LtLog.e(mFairy.getLineInfo("没有找到关卡，初始化滑动"));
                            mFairy.ranSwipe(500, 400, 1000, 400, 200, 200);
                            mFairy.ranSwipe(500, 400, 1000, 400, 200, 200);
                            mFairy.ranSwipe(500, 400, 1000, 400, 200, 200);
                            mFairy.ranSwipe(500, 400, 1000, 400, 200, 200);
                            mFairy.ranSwipe(500, 400, 1000, 400, 200, 200);
                            count=1;
                        }else {
                            LtLog.e("右滑动一次");
                            mFairy.ranSwipe(900, 90, 580, 90, 500, 1000);
                        }
                    }else{
                        LtLog.e("找到指定关卡");
                    }
                }

                result1 = mFairy.findPic( "start_action.png");
                if (result1.sim>0.8f){
                    result = mFairy.findPic(1132, 573, 1186, 612, new String[]{"proxy.png", "proxy1.png"});
                    if ( result.sim<0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(1045, 573, 1089, 612, "lock.png");
                    if ( result.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        setTaskEnd();
                        return;
                    }
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 100);//勾选代理
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", SingleTask.sleepTime);
                        setTaskName(2);
                    }
                }
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic( "start_action1.png");
                if(result.sim>0.8){
                    if(fightCount==0){
                        LtLog.e("任务结束");
                        setTaskEnd();
                        return;
                    }
                    fightCount--;//作战次数减一
                    LtLog.e(mFairy.getLineInfo("还需要战斗"+fightCount+"次"));
                    while(mFairy.condit()){
                        result=mFairy.findPic( "start_action1.png");
                        mFairy.onTap(0.8F, result, "开始作战", 100);//开始行动有一定延迟
                        if(result.sim<0.8){
                            break;
                        }
                    }
                }

                result=mFairy.findPic("failure.png");
                mFairy.onTap(0.8f,result,"任务失败，点击继续",100);

                result=mFairy.findPic("return.png");
                result1=mFairy.findPic("word task over ing.png");
                if(result.sim>0.8f&&result1.sim<0.8f){
                    //任务失败，需要重新进入关卡
                    enterDetailLevel(levelInfo);
                }
                super.content_2();
            }

        }.taskContent(mFairy,"主线作战任务");
    }

    //物资筹备作战任务
    public void wuZiFight() throws Exception{
        new SingleTask(mFairy){
            int fightCount;
            int sonLevel;
            int detailLevel;
            String levelInfo ;
            int notFind=0;
            @Override
            public void create() throws Exception {
                initLevel();//初始化
                sonLevel = Integer.parseInt(AtFairyConfig.getOption("sonLevel"));//子关数
                detailLevel = Integer.parseInt(AtFairyConfig.getOption("detailLevel"));//具体关卡
                if(AtFairyConfig.getOption("fightCount").equals("")){
                    fightCount=0;
                }else{
                    fightCount = Integer.parseInt(AtFairyConfig.getOption("fightCount"));//作战次数
                }

                if(fightCount==0){//作战次数为-2，达不到条件，一直执行
                    fightCount=-1;
                }
                //拼接关卡信息
                switch (sonLevel){
                    case 1:
                        levelInfo="LS-"+detailLevel;
                        break;
                    case 2:
                        levelInfo="CA-"+detailLevel;
                        break;
                    case 3:
                        levelInfo="SK-"+detailLevel;
                        break;
                    case 4:
                        levelInfo="AP-"+detailLevel;
                        break;
                    case 5:
                        levelInfo="CE-"+detailLevel;
                        break;
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic( "fight.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( "level/wuzi.png");
                mFairy.onTap(0.8f, result, "进入物资筹备", 100);
                if(result.sim>=0.8){
                    if(sonLevel==1){//战术演练

                        result=mFairy.findPic(16,449,1269,544,"level/zhan.png");
                        mFairy.onTap(0.8f,result,"进入战术演练",100);
                    }
                    if(sonLevel==2){//空中威胁
                        result=mFairy.findPic(16,449,1269,544,"level/kong.png");
                        mFairy.onTap(0.8f,result,"进入空中威胁",100);
                    }
                    if(sonLevel==3){//资源保障
                        result=mFairy.findPic(16,449,1269,544,"level/zi.png");
                        mFairy.onTap(0.8f,result,"进入资源保障",100);
                    }
                    if(sonLevel==4){//粉碎防御
                        result=mFairy.findPic(16,449,1269,544,"level/fen.png");
                        mFairy.onTap(0.8f,result,"进入粉碎防御",100);
                    }
                    if(sonLevel==5){//货物运送
                        result=mFairy.findPic(16,449,1269,544,"level/huo.png");
                        mFairy.onTap(0.8f,result,"进入货物运送",100);
                    }

                    if(result.sim<=0.8){
                        notFind++;
                        if(notFind>=5){
                            LtLog.e(mFairy.getLineInfo("该关卡没有开放,任务结束"));
                            setTaskEnd();
                            return;
                        }
                    }

                    result=mFairy.findPic("not open.png");
                    if(result.sim>0.8){
                        LtLog.e(mFairy.getLineInfo("该关卡没有开放,任务结束"));
                        setTaskEnd();
                        return;
                    }
                }else{
                    //不用初始化滑动
                    enterDetailLevel(levelInfo);
                }

                result1 = mFairy.findPic( "start_action.png");
                if (result1.sim>0.8f){
                    result = mFairy.findPic(1132, 573, 1186, 612, new String[]{"proxy.png", "proxy1.png"});
                    if ( result.sim<0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(1045, 573, 1089, 612, "lock.png");
                    if ( result.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        setTaskEnd();
                        return;
                    }
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 100);//勾选代理
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", SingleTask.sleepTime);
                        setTaskName(2);
                    }
                }

            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic( "start_action1.png");
                if(result.sim>0.8){
                    if(fightCount==0){
                        LtLog.e("任务结束");
                        setTaskEnd();
                        return;
                    }

                    fightCount--;//作战次数减一
                    LtLog.e(mFairy.getLineInfo("还需要战斗"+fightCount+"次"));
                    while(mFairy.condit()){
                        result=mFairy.findPic( "start_action1.png");
                        mFairy.onTap(0.8F, result, "开始作战", 100);//开始行动有一定延迟
                        if(result.sim<0.8){
                            break;
                        }
                    }
                }
                result=mFairy.findPic("failure.png");
                mFairy.onTap(0.8f,result,"任务失败，点击继续",100);

                result=mFairy.findPic("return.png");
                result1=mFairy.findPic("word task over ing.png");
                if(result.sim>0.8f&&result1.sim<0.8f){
                    //任务失败，需要重新进入关卡
                    enterDetailLevel(levelInfo);
                }
                super.content_2();
            }

        }.taskContent(mFairy,"物资筹备作战任务");
    }

    //芯片搜索作战任务
    public void xinPianFight() throws Exception{
        new SingleTask(mFairy){
            int fightCount;

            int sonLevel;
            int detailLevel;
            String levelInfo ;
            int notFind=0;
            @Override
            public void create() throws Exception {
                initLevel();//初始化
                sonLevel = Integer.parseInt(AtFairyConfig.getOption("sonLevel"));//子关数
                detailLevel = Integer.parseInt(AtFairyConfig.getOption("detailLevel"));//具体关卡
                if(AtFairyConfig.getOption("fightCount").equals("")){
                    fightCount=0;
                }else{
                    fightCount = Integer.parseInt(AtFairyConfig.getOption("fightCount"));//作战次数
                }


                if(fightCount==0){//作战次数为-2，达不到条件，一直执行
                    fightCount=-2;
                }
                //拼接关卡信息
                switch (sonLevel){
                    case 1:
                        levelInfo="PR-A-"+detailLevel;
                        break;
                    case 2:
                        levelInfo="PR-B-"+detailLevel;
                        break;
                    case 3:
                        levelInfo="PR-C-"+detailLevel;
                        break;
                    case 4:
                        levelInfo="PR-D-"+detailLevel;
                        break;
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);

            }

            @Override
            public void content_1() throws Exception {
                overtime(20,0);
                result = mFairy.findPic( "fight.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( "level/xinpian.png");
                mFairy.onTap(0.8f, result, "进入物芯片搜索", 100);
                if(result.sim>=0.8){
                    if(sonLevel==1){//固若金汤
                        result=mFairy.findPic(29,444,1231,526,"level/gu.png");
                        mFairy.onTap(0.8f,result,"进入固若金汤",100);
                    }
                    if(sonLevel==2){//摧枯拉朽
                        result=mFairy.findPic(29,444,1231,526,"level/cui.png");
                        mFairy.onTap(0.8f,result,"进入摧枯拉朽",100);
                    }
                    if(sonLevel==3){//势不可挡
                        result=mFairy.findPic(29,444,1231,526,"level/shi.png");
                        mFairy.onTap(0.8f,result,"进入势不可挡",100);
                    }
                    if(sonLevel==4){//身先士卒
                        result=mFairy.findPic(29,444,1231,526,"level/shen.png");
                        mFairy.onTap(0.8f,result,"进入身先士卒",100);
                    }
                }else{
                    //不用初始化滑动
                    enterDetailLevel(levelInfo);
                }

                if(result.sim<=0.8){
                    notFind++;
                    if(notFind>=5){
                        LtLog.e(mFairy.getLineInfo("该关卡没有开放,任务结束"));
                        close();
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic("not open.png");
                if(result.sim>0.8){
                    LtLog.e(mFairy.getLineInfo("该关卡没有开放,任务结束"));
                    close();
                    setTaskEnd();
                    return;
                }

                result1 = mFairy.findPic( "start_action.png");
                if (result1.sim>0.8f){
                    result = mFairy.findPic(1132, 573, 1186, 612, new String[]{"proxy.png", "proxy1.png"});
                    if ( result.sim<0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        close();
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(1045, 573, 1089, 612, "lock.png");
                    if ( result.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        close();
                        setTaskEnd();
                        return;
                    }
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 100);//勾选代理
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", SingleTask.sleepTime);
                        setTaskName(2);
                    }
                }

            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic( "start_action1.png");
                if(result.sim>0.8){
                    if(fightCount==0){
                        LtLog.e("任务结束");
                        setTaskEnd();
                        return;
                    }

                    fightCount--;//作战次数减一
                    LtLog.e(mFairy.getLineInfo("还需要战斗"+fightCount+"次"));
                    while(mFairy.condit()){
                        result=mFairy.findPic( "start_action1.png");
                        mFairy.onTap(0.8F, result, "开始作战", 100);//开始行动有一定延迟
                        if(result.sim<0.8){
                            break;
                        }
                    }
                }
                result=mFairy.findPic("failure.png");
                mFairy.onTap(0.8f,result,"任务失败，点击继续",100);

                result=mFairy.findPic("return.png");
                result1=mFairy.findPic("word task over ing.png");
                if(result.sim>0.8f&&result1.sim<0.8f){
                    //任务失败，需要重新进入关卡
                    enterDetailLevel(levelInfo);
                }




                super.content_2();
            }

        }.taskContent(mFairy,"芯片搜索作战任务");
    }

    //剿灭作战任务
    public void jiaoMieFight() throws Exception{
        new SingleTask(mFairy){
            int fightCount;

            int detailLevel;
            @Override
            public void create() throws Exception {
                initLevel();//初始化
                detailLevel = Integer.parseInt(AtFairyConfig.getOption("detailLevel"));//具体关卡
                if(AtFairyConfig.getOption("fightCount").equals("")){
                    fightCount=0;
                }else{
                    fightCount = Integer.parseInt(AtFairyConfig.getOption("fightCount"));//作战次数
                }

                if(fightCount==0){//作战次数为-2，达不到条件，一直执行
                    fightCount=-2;
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);

            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic( "fight.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( "level/jiaomie.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( "level/hechengyu.png");
                if(result.sim>=0.8){
                    if(detailLevel==1){//切尔诺伯格
                        result=mFairy.findPic("level/qieer.png");
                        mFairy.onTap(0.8f,result,"进入切尔诺伯格",100);
                    }
                    if(detailLevel==2){//龙门外环
                        result=mFairy.findPic("level/LMWH.png");
                        mFairy.onTap(0.8f,result,"进入龙门外环",100);
                    }
                    if(detailLevel==3){//龙门市区
                        result=mFairy.findPic("level/LMSQ.png");
                        mFairy.onTap(0.8f,result,"进入龙门市区",100);
                    }
                }

                result1 = mFairy.findPic( "start_action.png");
                if (result1.sim>0.8f){
                    result = mFairy.findPic(1132, 573, 1186, 612, new String[]{"proxy.png", "proxy1.png"});
                    if ( result.sim<0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        close();
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic("lock.png");
                    if ( result.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        close();
                        setTaskEnd();
                        return;
                    }

                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 100);//勾选代理
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", SingleTask.sleepTime);
                        setTaskName(2);
                    }
                }

            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic( "start_action1.png");
                if(result.sim>0.8){
                    if(fightCount==0){
                        LtLog.e("任务结束");
                        setTaskEnd();
                        return;
                    }

                    fightCount--;//作战次数减一
                    LtLog.e(mFairy.getLineInfo("还需要战斗"+fightCount+"次"));
                    while(mFairy.condit()){
                        result=mFairy.findPic( "start_action1.png");
                        mFairy.onTap(0.8F, result, "开始作战", 100);//开始行动有一定延迟
                        if(result.sim<0.8){
                            break;
                        }
                    }
                }

                result=mFairy.findPic("failure.png");
                mFairy.onTap(0.8f,result,"任务失败，点击继续",100);

                result = mFairy.findPic( "level/hechengyu.png");
                if(result.sim>=0.8){
                    if(detailLevel==1){//切尔诺伯格
                        result=mFairy.findPic("level/qieer.png");
                        mFairy.onTap(0.8f,result,"进入切尔诺伯格",100);
                    }
                    if(detailLevel==2){//龙门外环
                        result=mFairy.findPic("level/LMWH.png");
                        mFairy.onTap(0.8f,result,"进入龙门外环",100);
                    }
                    if(detailLevel==3){//龙门市区
                        result=mFairy.findPic("level/LMSQ.png");
                        mFairy.onTap(0.8f,result,"进入龙门市区",100);
                    }
                }

                super.content_2();
            }


        }.taskContent(mFairy,"剿灭作战任务");
    }

    //生于黑夜 限时活动
    public void dark()throws Exception{
        new SingleTask(mFairy){
            int fightCount=1;
            int type=1;
            int sonLevel=1;
            int detailLevel=1;
            String levelInfo ;
            @Override
            public void create() throws Exception {
                initLevel();//初始化
                detailLevel = Integer.parseInt(AtFairyConfig.getOption("detailLevel"));//具体关卡
                if(!AtFairyConfig.getOption("sonLevel").equals("")){
                    sonLevel=Integer.parseInt(AtFairyConfig.getOption("sonLevel"));
                }
                if(AtFairyConfig.getOption("fightCount").equals("")){
                    fightCount=0;
                }else{
                    fightCount = Integer.parseInt(AtFairyConfig.getOption("fightCount"));//作战次数
                }
                switch (sonLevel){
                    case 1:
                        levelInfo="DM-"+detailLevel;
                        break;
                }

                if(!AtFairyConfig.getOption("type").equals("")){

                }
                if(fightCount==0){//作战次数为-2，达不到条件，一直执行
                    fightCount=-2;
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic( 714,95,1272,292,"fight1.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word accrue night.png");
                    mFairy.onTap(0.8f,result,"进入生于黑夜",1000);
                    if(result.sim<0.8f){
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic("word accrue night zhws.png");
                mFairy.onTap(0.8f,result,"进入阵中往事",1000);

                result=mFairy.findPic("pic zzws interface.png");
                if(result.sim>0.8f){
                    enterDetailLevel(levelInfo);
                }

                result1 = mFairy.findPic( "start_action.png");
                if (result1.sim>0.8f){
                    result = mFairy.findPic(1132, 573, 1186, 612, new String[]{"proxy.png", "proxy1.png"});
                    if ( result.sim<0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(1045, 573, 1089, 612, "lock.png");
                    if ( result.sim>0.8f) {
                        LtLog.e(mFairy.getLineInfo("该关卡不能代理,请重新选择"));
                        setTaskEnd();
                        return;
                    }
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 100);//勾选代理
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", SingleTask.sleepTime);
                        setTaskName(2);
                    }
                }

            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic( "start_action1.png");
                if(result.sim>0.8){
                    if(fightCount==0){
                        LtLog.e("任务结束");
                        setTaskEnd();
                        return;
                    }

                    fightCount--;//作战次数减一
                    LtLog.e(mFairy.getLineInfo("还需要战斗"+fightCount+"次"));
                    while(mFairy.condit()){
                        result=mFairy.findPic( "start_action1.png");
                        mFairy.onTap(0.8F, result, "开始作战", 100);//开始行动有一定延迟
                        if(result.sim<0.8){
                            break;
                        }
                    }
                }
                result=mFairy.findPic("failure.png");
                mFairy.onTap(0.8f,result,"任务失败，点击继续",100);

                result=mFairy.findPic("return.png");
                result1=mFairy.findPic("word task over ing.png");
                if(result.sim>0.8f&&result1.sim<0.8f){
                    //任务失败，需要重新进入关卡
                    enterDetailLevel(levelInfo);
                }




                super.content_2();
            }
        }.taskContent(mFairy,"生于黑夜");
    }

    //访问基建
    public void visitJiJian() throws Exception {
        new SingleTask(mFairy){
            boolean isReDorm;//移除宿舍满心情的干员
            boolean isReTried;//执行疲劳替换
            boolean isGetTrade;//执行收获贸易站
            boolean isGetCreate;//执行收获制造站
            boolean isGetTrust;//执行收获信赖
            boolean trade_UAV;//是否使用无人机


            @Override
            public void create() throws Exception {//获取需要的参数
                isReDorm=AtFairyConfig.getOption("remove").equals("true");
                isReTried=AtFairyConfig.getOption("tired").equals("true");
                isGetTrade=AtFairyConfig.getOption("trade").equals("true");
                isGetCreate=AtFairyConfig.getOption("create").equals("true");
                isGetTrust=AtFairyConfig.getOption("trust").equals("true");
                trade_UAV=AtFairyConfig.getOption("trade_UAV").equals("true");
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            boolean trade_null=false,create_null;//判断贸易间是否为空
            @Override
            public void content_1() throws Exception {//收获贸易站,制造站
                overtime(35,0);
                result=mFairy.findPic("jijian.png");//前往基建
                mFairy.onTap(0.8f,result,"打开基建",sleepTime);

                result = mFairy.findPic("pandect.png");//如果在基建，向左滑动
                if(result.sim>0.8){
                    mFairy.ranSwipe(250, 210, 750, 210, 500, 200);//向左滑动
                }

                //基建里贸易站和制造间都没东西了
                if(trade_null&&create_null&&result.sim>0.8){
                    setTaskName(2);
                    LtLog.e(mFairy.getLineInfo("贸易间和制造间收获完成，转2获取干员信赖"));
                    return;
                }

                //是否收获制造站
                if(isGetCreate){
                    result=mFairy.findPic(5,184,758,685,"zhizaozhan.png");
                    mFairy.onTap(0.8f,result,"收获制造站",100);
                    if(result.sim<0.8){
                        if(mFairy.findPic("pandect.png").sim>0.8){
                            create_null=true;
                        }
                    }
                }else{
                    create_null=true;
                }

                //是否收获贸易站
                if(isGetTrade){
                    result = mFairy.findPic(5,184,758,685, "maoyizhan.png");//进入贸易站
                    mFairy.onTap(0.8f,result,"进入贸易站",1000);

                    if(result.sim<0.8){//贸易站为空
                        if(mFairy.findPic("pandect.png").sim>0.8){
                            trade_null=true;
                        }
                    }

                    result=mFairy.findPic("trade.png");
                    if(result.sim>0.8){
                        result=mFairy.findPic("guijinshu.png");
                        mFairy.onTap(0.8f,result,"进入交易",sleepTime);

                        result=mFairy.findPic("order.png");
                        if(result.sim>0.8) {
                            while (mFairy.condit()) {
                                result = mFairy.findPic(292, 429, 689, 482, "kezhifu.png");
                                mFairy.onTap(0.8f, result, "支付", sleepTime);

                                result = mFairy.findPic(267,450,346,527,"wurenji.png");//无人机协助
                                mFairy.onTap(0.8f, result, "无人机协助", sleepTime);

                                if (mFairy.findPic("wurenji1.png").sim > 0.8) {
                                    result = mFairy.findPic("max.png");
                                    mFairy.onTap(0.8f, result, "选择最多无人机协助", 500);

                                    if(mFairy.findPic("wurenji0.png").sim>0.8){
                                        trade_UAV=false;//没有无人机了,结束贸易站
                                    }

                                    result=mFairy.findPic("max1.png");
                                    if(result.sim>0.8){
                                        mFairy.onTap(921, 566, 971, 595, "确认使用无人机", sleepTime);
                                    }
                                }

                                if(trade_UAV){
                                    continue;
                                }

                                //没有可支付订单了，回到基建
                                if (mFairy.findPic(292, 429, 689, 482, "kezhifu.png").sim < 0.8) {
                                    while (mFairy.condit()) {
                                        result = mFairy.findPic("return.png");
                                        mFairy.onTap(0.8F, result, "返回", 1000);
                                        if (mFairy.findPic("pandect.png").sim > 0.8) {
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else{
                    trade_null=true;
                }

            }

            @Override
            public void content_2() throws Exception {//获取干员信赖和制造间
                overtime(25,0);
                if(!isGetTrust){
                    LtLog.e(mFairy.getLineInfo("不执行获取信赖,跳转到4撤下疲劳干员"));
                    setTaskName(3);
                    return;
                }
                if(mFairy.findPic(1161, 64, 1278, 170,  new String[]{"bell.png","bell1.png"}).sim<0.8){
                    LtLog.e(mFairy.getLineInfo("获取信赖 制造间完成"));
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic(1161, 64, 1278, 170, "bell.png");
                mFairy.onTap(0.8f, result, "blue bell", 1000);//点击提示

                result=mFairy.findPic(148,666,948,714,"xinlai.png");
                mFairy.onTap(0.8f, result, "获取干员信赖", 1000);//获取干员信赖

                if(isGetCreate){
                    if ((result=mFairy.findPic(1161, 64, 1278, 170, "bell1.png")).sim>0.8){
                        if(mFairy.findPic(148,666,948,714,new String []{"xinlai.png","shouhuo.png"}).sim<0.8){
                            mFairy.onTap(0.8f,result,"获取信赖 制造间完成",100);
                            setTaskName(3);
                            return;
                        }
                    }
                    result=mFairy.findPic(148,666,948,714,"shouhuo.png");
                    mFairy.onTap(0.8f, result, "收获制造间", 1000);//收获制造间
                }else{
                    if ((result=mFairy.findPic(1161, 64, 1278, 170, "bell1.png")).sim>0.8){
                        if(mFairy.findPic(148,666,948,714,"shouhuo.png").sim<0.8){
                            mFairy.onTap(0.8f,result,"获取信赖 制造间完成",100);
                            setTaskName(3);
                            return;
                        }
                    }
                }

            }

            @Override
            public void content_3() throws Exception {//撤下疲劳干员
                overtime(25,0);
                result=mFairy.findPic(1161, 64, 1278, 170, "bell1.png");
                mFairy.onTap(0.8f, result, "关闭提示", 100);

                result = mFairy.findPic("pandect.png");//进驻总览
                mFairy.onTap(0.8f, result, "进入进驻总览", 100);

                result = mFairy.findPic("remove button.png");//打开撤下干员模式
                mFairy.onTap(0.8f, result, "打开撤下干员模式", 100);

                result = mFairy.findPic("removing.png");//正在撤下干员模式
                //撤下所有疲劳干员
                if (result.sim >= 0.8) {
                    for (int i = 1; i <= 10; i++) {
                        //执行撤下疲劳干员
                        if(isReTried){
                            //撤下疲劳干员
                            while (mFairy.condit()) {
                                result = mFairy.findPic(409, 82, 1236, 715, "tired.png");//寻找疲劳干员
                                if (result.sim >= 0.8) {
                                    mFairy.onTap(0.8f, result, result.x + 40, result.y - 45, result.x + 41, result.y - 44, "撤下疲劳干员", 1000);
                                } else {
                                    break;
                                }
                            }
                        }

                        //执行撤下满心情干员
                        if(isReDorm){
                            //撤下宿舍满心情干员
                            while(mFairy.condit()){
                                result = mFairy.findPic(430,104,475,420, "dorm.png");//寻找宿舍
                                if (result.sim >= 0.8) {
                                    while(true){
                                        result1 = mFairy.findPic(result.x+174, result.y+56, result.x+735, result.y+114, "smile.png");//寻找满心情干员
                                        if(result1.sim<0.8)break;
                                        mFairy.onTap(0.8f,result1,result1.x+35,result1.y-29,result1.x+36,result1.y-28,"撤下满心情干员",1000);
                                    }
                                }

                                boolean isFind=false;
                                //避免"宿舍"屏出现
                                result = mFairy.findPic(430,420,475,625, "dorm.png");//寻找宿舍
                                if (result.sim >= 0.8f) {
                                    isFind=true;
                                    while(true){
                                        result1 = mFairy.findPic(result.x+174, result.y+56, result.x+735, result.y+114, "smile.png");//寻找满心情干员
                                        if(result1.sim<0.8)break;
                                        mFairy.onTap(0.8f,result1,result1.x+35,result1.y-29,result1.x+36,result1.y-28,"撤下满心情干员",1000);
                                    }
                                    if(isFind)break;
                                }else{
                                    break;
                                }
                            }
                        }
                        LtLog.e("第" + i + "次寻找疲劳干员");
                        mFairy.ranSwipe(1000, 700, 1000, 400, 300, 500);//往下滑
                    }
                    result = mFairy.findPic("removing.png");//关闭撤下干员模式
                    mFairy.onTap(0.8f, result, "关闭撤下模式", 100);
                    setTaskName(4);
                    return;
                }
            }

            @Override
            public void content_4() throws  Exception{
                overtime(50,0);
                result=mFairy.findPic("control.png");
                //已经滑到顶部,并且没有空位置
                if(result.sim>0.8&&mFairy.findPic(596,100,1187,713,"add.png").sim<0.8){
                    LtLog.e(mFairy.getLineInfo("替换结束"));
                    setTaskEnd();
                    return;
                }
                //是否在进驻中心
                if(mFairy.findPic("remove button.png").sim>0.8){
                    //填补
                    result=mFairy.findPic(596,100,1187,713,"add.png");
                    if(result.sim>0.8){
                        //765,373
                        //745,423  -20,+50
                        //825,450  +80,+77
                        //训练位不能指定，可能造成死循环
                        if(mFairy.findPic(result.x-20,result.y+50,result.x+80,result.y+77,"train place.png").sim<0.8){
                            mFairy.onTap(0.8f,result,"进入替换界面",1000);
                        }else{
                            LtLog.e(mFairy.getLineInfo("向上滑动寻找"));
                            mFairy.ranSwipe(1000, 400, 1000, 700, 500, 1000);//往上滑
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("向上滑动寻找"));
                        mFairy.ranSwipe(1000, 400, 1000, 700, 500, 1000);//往上滑
                    }
                }

                //替换
                result=mFairy.findPic(1106,0,1249,58,"sort.png");
                if(result.sim>0.8){
                    //清空选择
                    result = mFairy.findPic("clear.png");
                    mFairy.onTap(0.8f,result,"清空选择",1000);

                    //选择填补
                    if(mFairy.findPic(209,144,374,253,"see.png").sim>0.8) {
                        mFairy.onTap(472, 245, 496, 268, "干员替换1", 1000);//1
                        int colorNum = mFairy.getColorNum(528,90,537,102, "241,241,241", 0.9f);
                        //判断是否需要五个
                        if(colorNum>100){
                            mFairy.onTap(475, 512, 496, 535, "干员替换2", 500);//2
                            mFairy.onTap(612, 261, 638, 286, "干员替换3", 500);//3
                            mFairy.onTap(620, 538, 642, 559, "干员替换4", 500);//4
                            mFairy.onTap(755, 246, 782, 270, "干员替换5", 500);//5
                        }
                    }

                    //确认替换
                    result= mFairy.findPic("affirm.png");
                    mFairy.onTap(0.8f,result,"确认",1000);

                    //训练师
                    result= mFairy.findPic("ok.png");
                    mFairy.onTap(0.8f,result,"确认",1000);
                }
            }
        }.taskContent(mFairy,"访问基建");
    }

    //访问好友基建
    public void haoyouJiJian() throws Exception {
        //前往好友列表
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
                //获取需要的参数
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                //初始化
                close();
                setTaskName(1);
            }


            @Override
            public void content_1() throws Exception {
                overtime(20,0);
                result=mFairy.findPic(261,525,467,683,"friend3.png");
                mFairy.onTap(0.8f,result,"主页点击进入我的信息界面",sleepTime);

                result=mFairy.findPic(6,78,226,466,"friend.png");//基建里会客室的好友图标
                mFairy.onTap(0.8f,result,"会客室点击进入我的信息界面",sleepTime);

                result=mFairy.findPic("friend1.png");//个人信息的好友图标
                mFairy.onTap(0.8f,result,"点击进入好友列表界面",1000);

                result=mFairy.findPic(910,91,1083,659,"jijian pic.png");
                if(result.sim>0.8){
                    mFairy.onTap(0.8f,result,"访问好友基建",sleepTime);
                    setTaskName(2);
                    return;
                }else{
                    if(mFairy.findPic(6,78,226,466,"friend list.png").sim>0.8){
                        LtLog.e(mFairy.getLineInfo("没有好友基建可以访问，任务结束"));
                        setTaskEnd();
                        return;
                    }
                }
            }

            @Override
            public void content_2() throws Exception {
                overtime(40,1);
                result = mFairy.findPic(1060,549,1278,708,"visit.png");
                mFairy.onTap(0.8f,result,"访问下位",sleepTime);
                if(result.sim<0.8&& mFairy.findPic(5,97,194,297,"thread.png").sim>0.8){
                    setTaskEnd();
                    LtLog.e(mFairy.getLineInfo("访问好友基建完成，任务结束"));
                    return;
                }
            }
        }.taskContent(mFairy,"访问好友基建");
    }

    @Override
    public void content_2()throws Exception{
        result=mFairy.findPic("word task over ing.png");
        int picCount=picCount(0.8f,result,"task over");
        if(picCount!=0&&picCount%4==0)LtLog.e(mFairy.getLineInfo("接管代理中"));

        result=mFairy.findPic( "start_action.png");//开始行动
        if(result.sim>0.8){
            int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, 0.9f,0,"255,255,255");//判断是否勾选代理
            if (colorNum < 100) {
                mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
            }
            mFairy.onTap(0.8F, result, "开始行动", 1500);
        }

        result=mFairy.findPic("level up.png");//等级提升
        mFairy.onTap(0.8f,result,"等级提升",500);

        result=mFairy.findPic("level/bao.png");//查看战报
        mFairy.onTap(0.8f,result,"查看战报",500);

        result = mFairy.findPic("action_over.png");//行动结束
        mFairy.onTap(0.8f,result,"行动结束",500);

        result=mFairy.findPic("li1.png");//理智不足
        if(result.sim>=0.8){
            int type=1;
            if(!AtFairyConfig.getOption("type").equals(""))
                type = Integer.parseInt(AtFairyConfig.getOption("type"));
            switch (type) {
                //转下一项任务
                case 1:
                    result=mFairy.findPic("li.png");
                    mFairy.onTap(0.8f,result,"退出",500);
                    LtLog.e(mFairy.getLineInfo("理智不足，结束任务"));
                    setTaskEnd();
                    return;

                //药剂恢复
                case 2:
                    result = mFairy.findPic("yaoji.png");
                    mFairy.onTap(0.8f, result, "使用药剂恢复", 500);

                    result = mFairy.findPic( "use ok.png");
                    mFairy.onTap(0.8f,result, "确认药剂恢复", 500);

                    result=mFairy.findPic("yaojibuzu.png");
                    if(result.sim>0.8){
                        LtLog.e(mFairy.getLineInfo("药剂不足，理智不够，无法继续战斗，结束任务"));
                        mFairy.onTap(0.8f,result,"回到大厅",500);
                        setTaskEnd();
                        return;
                    }
                    break;

                //源石恢复
                case 3:
                    result = mFairy.findPic("yuanshi.png");
                    mFairy.onTap(0.8f, result, "使用源石恢复", 500);

                    result = mFairy.findPic("use ok.png");
                    mFairy.onTap(0.8f, result, "确认源石恢复", 500);

                    result=mFairy.findPic("yuanshibuzu.png");
                    if(result.sim>0.8){
                        LtLog.e(mFairy.getLineInfo("源石不足，理智不够，无法继续战斗，结束任务"));
                        mFairy.onTap(0.8f,result,"回到大厅",500);
                        setTaskEnd();
                        return;
                    }
                    break;
            }
        }
    }

    //每日签到
    public void sign()throws Exception{
        new SingleTask(mFairy){
            boolean sign;
            boolean gather;
            @Override
            public void create() throws Exception {
                sign=AtFairyConfig.getOption("sign").equals("1");
                gather=AtFairyConfig.getOption("gather").equals("1");
            }

            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic(1016,5,1271,129,"close.png");
                mFairy.onTap(0.8F,result,"关闭活动",SingleTask.sleepTime);//关闭活动提示
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(15,0);
                if(sign){
                    result=mFairy.findPic(7,8,315,70,"calendar.png");
                    mFairy.onTap(0.8f,result,"点击日历，进入签到界面",sleepTime);

                    if(mFairy.findPic(876,553,1171,660,"yiqiandao.png").sim>0.8){
                        sign=false;
                        LtLog.e("每日签到完成");
                        return;
                    }
                }else{
                    result=mFairy.findPic(1016,5,1271,129,"close.png");
                    mFairy.onTap(0.8F,result,"关闭活动",SingleTask.sleepTime);
                    LtLog.e("已签到完成或不进行签到,跳转到2");
                    setTaskName(2);
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                overtime(15,0);
                if(gather){
                    result=mFairy.findPic(7,8,315,70,"email.png");
                    mFairy.onTap(0.8f,result,"点击进入邮件",sleepTime);

                    result =mFairy.findPic(1013,611,1271,718,"gather.png");
                    mFairy.onTap(0.8f,result,"收取所有邮件",sleepTime);

                    result =mFairy.findPic(527,9,793,199,"hdwz.png");
                    mFairy.onTap(0.8f,result,630,633,653,649,"物资确认",sleepTime);

                    result=mFairy.findPic(935,49,1277,291,"none.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8f,result,40,25,68,64,"没有邮件可以收取了",sleepTime);
                        setTaskEnd();
                        return;
                    }
                }else{
                    LtLog.e("不收取邮件或收取完成,任务结束");
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"每日签到");
    }

    public void test() throws Exception {
        while (mFairy.condit()){
            int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, 0.9f,0,"255,255,255" );
            LtLog.e(mFairy.getLineInfo("colorNum="+colorNum));
            Thread.sleep(1000);
        }
    }
}
