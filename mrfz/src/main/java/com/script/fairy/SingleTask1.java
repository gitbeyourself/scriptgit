package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask1 extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    final static int sleepTime = 100;
    Map<String, String> levelMap = null;

    public SingleTask1(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        util = new Util(mFairy);
    }

    //主线作战任务
    public void mainFight() throws Exception {
        new SingleTask(mFairy) {
            int fightCount;
            int type;
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
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
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
                result = mFairy.findPic( 714,95,1272,292,"fight1.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);
                result = mFairy.findPic( 1,619,1274,712,"taskchoice.png");
                mFairy.onTap(0.8f, result, "进入主线", 100);
                if (result.sim>0.8f){//进入指定章节
                    result = mFairy.findPic(8,125,1272,180, "level/word 0" + sonLevel + "level.png");
                    mFairy.onTap(0.8f, result,result.x,result.y+70,result.x+1,result.y+71,"找到指定章节", 100);
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
                            if(findSection>=5){
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
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
                        return;
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", sleepTime);
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

                //任务失败，需要重新进入关卡
                enterDetailLevel(levelInfo);

                result=mFairy.findPic( "start_action.png");//开始行动
                if(result.sim>0.8){
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
                        return;
                    }
                    mFairy.onTap(0.8f, result, "开始行动", 1500);
                }

                result=mFairy.findPic("level up.png");//等级提升
                mFairy.onTap(0.8f,result,"等级提升",200);

                result=mFairy.findPic("level/bao.png");//查看战报
                mFairy.onTap(0.8f,result,"查看战报",sleepTime);

                result = mFairy.findPic("action_over.png");//行动结束
                mFairy.onTap(0.8f,result,"行动结束",200);

                result=mFairy.findPic("li1.png");//理智不足
                if(result.sim>=0.8){
                    switch (type) {
                        //转下一项任务
                        case 1:
                            result=mFairy.findPic("li1.png");//理智不足
                            mFairy.onTap(0.8f,result,"退出",sleepTime);
                            setTaskEnd();
                            return;

                        //药剂恢复
                        case 2:
                            result = mFairy.findPic("yaoji.png");
                            mFairy.onTap(0.8f, result, "使用药剂恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f,result, "确认药剂恢复", 100);

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
                            mFairy.onTap(0.8f, result, "使用源石恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f, result, "确认源石恢复", 100);

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

        }.taskContent(mFairy,"主线");
    }

    //物资筹备作战任务
    public void wuZiFight() throws Exception{
        new SingleTask(mFairy){
            int fightCount;
            int type;
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
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
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
                result = mFairy.findPic( 714,95,1272,292,"fight1.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( 1,619,1274,712,"level/wuzi.png");
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
                    result = mFairy.findPic(1035,562,1257,621, new String[]{"proxy.png", "proxy1.png"});
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
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);;//勾选代理
                        return;
                    }

                    result=mFairy.findPic( 815,598,1273,713,"start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", sleepTime);
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

                //任务失败，需要重新进入关卡
                enterDetailLevel(levelInfo);

                result=mFairy.findPic( "start_action.png");//开始行动
                if(result.sim>0.8){
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
                        return;
                    }
                    mFairy.onTap(0.8f, result, "开始行动", 1500);
                }

                result=mFairy.findPic("level up.png");//等级提升
                mFairy.onTap(0.8f,result,"等级提升",200);

                result=mFairy.findPic("level/bao.png");//查看战报
                mFairy.onTap(0.8f,result,"查看战报",sleepTime);

                result = mFairy.findPic("action_over.png");//行动结束
                mFairy.onTap(0.8f,result,"行动结束",200);

                result=mFairy.findPic("li1.png");//理智不足
                if(result.sim>=0.8){
                    switch (type) {
                        //转下一项任务
                        case 1:
                            result=mFairy.findPic("li1.png");//理智不足
                            mFairy.onTap(0.8f,result,"退出",sleepTime);
                            setTaskEnd();
                            return;

                        //药剂恢复
                        case 2:
                            result = mFairy.findPic("yaoji.png");
                            mFairy.onTap(0.8f, result, "使用药剂恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f,result, "确认药剂恢复", 100);

                            result=mFairy.findPic("yaojibuzu.png");
                            if(result.sim>0.8){
                                LtLog.e(mFairy.getLineInfo("药剂不足，理智不够，无法继续战斗，结束任务"));
                                mFairy.onTap(0.8f,result,"回到大厅",500);
                                close();
                                setTaskEnd();
                                return;
                            }
                            break;

                        //源石恢复
                        case 3:
                            result = mFairy.findPic("yuanshi.png");
                            mFairy.onTap(0.8f, result, "使用源石恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f, result, "确认源石恢复", 100);

                            result=mFairy.findPic("yuanshibuzu.png");
                            if(result.sim>0.8){
                                LtLog.e(mFairy.getLineInfo("源石不足，理智不够，无法继续战斗，结束任务"));
                                mFairy.onTap(0.8f,result,"回到大厅",500);
                                close();
                                setTaskEnd();
                                return;
                            }
                            break;
                    }
                }
            }

        }.taskContent(mFairy,"物资筹备作战任务");
    }

    //芯片搜索作战任务
    public void xinPianFight() throws Exception{
        new SingleTask(mFairy){
            int fightCount;
            int type;
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
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
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
                result = mFairy.findPic( 714,95,1272,292,"fight1.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( 1,619,1274,712,"level/wuzi.png");
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
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);;//勾选代理
                        return;
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", sleepTime);
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

                //任务失败，需要重新进入关卡
                enterDetailLevel(levelInfo);

                result=mFairy.findPic( "start_action.png");//开始行动
                if(result.sim>0.8){
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
                        return;
                    }
                    mFairy.onTap(0.8f, result, "开始行动", 1500);
                }

                result=mFairy.findPic("level up.png");//等级提升
                mFairy.onTap(0.8f,result,"等级提升",200);

                result=mFairy.findPic("level/bao.png");//查看战报
                mFairy.onTap(0.8f,result,"查看战报",sleepTime);

                result = mFairy.findPic("action_over.png");//行动结束
                mFairy.onTap(0.8f,result,"行动结束",200);

                result=mFairy.findPic("li1.png");//理智不足
                if(result.sim>=0.8){
                    switch (type) {
                        //转下一项任务
                        case 1:
                            result=mFairy.findPic("li1.png");//理智不足
                            mFairy.onTap(0.8f,result,"退出",sleepTime);
                            setTaskEnd();
                            return;

                        //药剂恢复
                        case 2:
                            result = mFairy.findPic("yaoji.png");
                            mFairy.onTap(0.8f, result, "使用药剂恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f,result, "确认药剂恢复", 100);

                            result=mFairy.findPic("yaojibuzu.png");
                            if(result.sim>0.8){
                                LtLog.e(mFairy.getLineInfo("药剂不足，理智不够，无法继续战斗，结束任务"));
                                mFairy.onTap(0.8f,result,"回到大厅",500);
                                close();
                                setTaskEnd();
                                return;
                            }
                            break;

                        //源石恢复
                        case 3:
                            result = mFairy.findPic("yuanshi.png");
                            mFairy.onTap(0.8f, result, "使用源石恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f, result, "确认源石恢复", 100);

                            result=mFairy.findPic("yuanshibuzu.png");
                            if(result.sim>0.8){
                                LtLog.e(mFairy.getLineInfo("源石不足，理智不够，无法继续战斗，结束任务"));
                                mFairy.onTap(0.8f,result,"回到大厅",500);
                                close();
                                setTaskEnd();
                                return;
                            }
                            break;
                    }
                }
            }

        }.taskContent(mFairy,"芯片搜索作战任务");
    }

    //剿灭作战任务
    public  void jiaoMieFight() throws Exception{
        new SingleTask(mFairy){
            int fightCount;
            int type;
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
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
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
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( 1,619,1274,712,"level/jiaomie.png");
                mFairy.onTap(0.8f, result, "进入作战中心", 100);

                result = mFairy.findPic( 974,108,1161,290,"level/hechengyu.png");
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
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
                        return;
                    }

                    result=mFairy.findPic( "start_action.png");
                    if(result.sim>0.8){
                        mFairy.onTap(0.8F, result, "开始行动", sleepTime);
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


                result=mFairy.findPic( "start_action.png");//开始行动
                if(result.sim>0.8){
                    int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, "255,255,255", 0.9f);//判断是否勾选代理
                    if (colorNum < 100) {
                        mFairy.onTap(1096, 581, 1119, 600, "开启代理", 1000);//勾选代理
                        return;
                    }
                    mFairy.onTap(0.8f, result, "开始行动", 1500);
                }

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

                result=mFairy.findPic("level up.png");//等级提升
                mFairy.onTap(0.8f,result,"等级提升",200);

                result=mFairy.findPic(new String[]{"level/bao.png","level/bao1.png"});//查看战报
                mFairy.onTap(0.8f,result,633,665,642,674,"查看战报",200);

                result = mFairy.findPic("action_over.png");//行动结束
                mFairy.onTap(0.8f,result,"行动结束",200);

                result=mFairy.findPic("li1.png");//理智不足
                if(result.sim>=0.8){
                    switch (type) {
                        //转下一项任务
                        case 1:
                            result=mFairy.findPic("li1.png");//理智不足
                            mFairy.onTap(0.8f,result,"退出",sleepTime);
                            setTaskEnd();
                            return;

                        //药剂恢复
                        case 2:
                            result = mFairy.findPic("yaoji.png");
                            mFairy.onTap(0.8f, result, "使用药剂恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f,result, "确认药剂恢复", 100);

                            result=mFairy.findPic("yaojibuzu.png");
                            if(result.sim>0.8){
                                LtLog.e(mFairy.getLineInfo("药剂不足，理智不够，无法继续战斗，结束任务"));
                                mFairy.onTap(0.8f,result,"回到大厅",500);
                                close();
                                setTaskEnd();
                                return;
                            }
                            break;

                        //源石恢复
                        case 3:
                            result = mFairy.findPic("yuanshi.png");
                            mFairy.onTap(0.8f, result, "使用源石恢复", 1000);

                            result = mFairy.findPic( 1061,535,1115,658,"use ok.png");
                            mFairy.onTap(0.8f, result, "确认源石恢复", 100);

                            result=mFairy.findPic("yuanshibuzu.png");
                            if(result.sim>0.8){
                                LtLog.e(mFairy.getLineInfo("源石不足，理智不够，无法继续战斗，结束任务"));
                                mFairy.onTap(0.8f,result,"回到大厅",500);
                                close();
                                setTaskEnd();
                                return;
                            }
                            break;
                    }
                }
            }

        }.taskContent(mFairy,"剿灭作战任务");
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
                isReDorm=AtFairyConfig.getOption("remove").equals("1");
                isReTried=AtFairyConfig.getOption("tired").equals("1");
                isGetTrade=AtFairyConfig.getOption("trade").equals("1");
                isGetCreate=AtFairyConfig.getOption("create").equals("1");
                isGetTrust=AtFairyConfig.getOption("trust").equals("1");
                trade_UAV=AtFairyConfig.getOption("trade_UAV").equals("1");
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
                result=mFairy.findPic(906,544,1170,706,"jijian.png");//前往基建
                mFairy.onTap(0.8f,result,"打开基建",sleepTime);

                result = mFairy.findPic(10,59,263,179,"pandect.png");//如果在基建，向左滑动
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
                    mFairy.onTap(0.8f,result,"进入贸易站",2000);

                    if(result.sim<0.8){//贸易站为空
                        if(mFairy.findPic("pandect.png").sim>0.8){
                            trade_null=true;
                        }
                    }

                    result=mFairy.findPic(373,8,638,64,"trade.png");
                    if(result.sim>0.8){
                        result=mFairy.findPic(2,539,561,713,"guijinshu.png");
                        mFairy.onTap(0.8f,result,"进入交易",sleepTime);

                        result=mFairy.findPic(254,77,496,135,"order.png");
                        if(result.sim>0.8) {
                            while (mFairy.condit()) {
                                result = mFairy.findPic(292, 429, 689, 482, "kezhifu.png");
                                mFairy.onTap(0.8f, result, "支付", sleepTime);

                                result = mFairy.findPic(267,450,346,527,"wurenji.png");//无人机协助
                                mFairy.onTap(0.8f, result, "无人机协助", sleepTime);

                                if (mFairy.findPic(90,230,430,523,"wurenji1.png").sim > 0.8) {
                                    result = mFairy.findPic(912,294,1019,383,"max.png");
                                    mFairy.onTap(0.8f, result, "选择最多无人机协助", 1000);

                                    if(mFairy.findPic(220,425,290,491,"wurenji0.png").sim>0.8){
                                        trade_UAV=false;//没有无人机了,结束贸易站
                                    }

                                    result=mFairy.findPic(912,294,1019,383,"max1.png");
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
                                        mFairy.onTap(0.8f, result, "返回", 2000);
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
                result=mFairy.findPic(1166,56,1280,242,  new String[]{"bell.png","bell1.png"});
                if(result.sim<0.8){
                    LtLog.e(mFairy.getLineInfo("获取信赖 制造间完成"));
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic(1166,56,1280,242, "bell.png");
                mFairy.onTap(0.8f, result, "blue bell", 1000);//点击提示

                result=mFairy.findPic(148,666,948,714,"xinlai.png");
                mFairy.onTap(0.8f, result, "获取干员信赖", 1000);//获取干员信赖

                if(isGetCreate){
                    if ((result=mFairy.findPic(1166,56,1280,242, "bell1.png")).sim>0.8){
                        if(mFairy.findPic(148,666,948,714,new String []{"xinlai.png","shouhuo.png"}).sim<0.8){
                            mFairy.onTap(0.8f,result,"获取信赖 制造间完成",100);
                            setTaskName(3);
                            return;
                        }
                    }
                    result=mFairy.findPic(148,666,948,714,"shouhuo.png");
                    mFairy.onTap(0.8f, result, "收获制造间", 1000);//收获制造间
                }else{
                    if ((result=mFairy.findPic(1166,56,1280,242, "bell1.png")).sim>0.8){
                        if(mFairy.findPic(148,666,948,714,"shouhuo.png").sim<0.8){
                            mFairy.onTap(0.8f,result,"获取信赖 制造间完成",100);
                            setTaskName(3);
                            return;
                        }
                    }
                }

            }

            int ranNum=0;
            @Override
            public void content_3() throws Exception {
                overtime(25,0);
                result=mFairy.findPic(1166,56,1280,242, "bell1.png");
                mFairy.onTap(0.8f, result, "关闭提示", 500);

                result = mFairy.findPic(12,77,244,165,"pandect.png");
                mFairy.onTap(0.8f, result, "进入进驻总览", 500);

                result = mFairy.findPic(1057,14,1241,82,"remove button.png");
                mFairy.onTap(0.8f, result, "打开撤下干员模式", 1000);

                result = mFairy.findPic(1167,6,1232,87,"removing.png");
                if(result.sim>0.8f){
                    err=0;
                    //移除疲劳
                    if(isReTried){
                        List<FindResult> list =mFairy.findPic(409, 82, 1236, 715, 0.8f,"tired.png");//寻找疲劳干员
                        while (list.size()!=0){
                            result=list.get(0);
                            mFairy.onTap(0.8f, result, result.x + 81, result.y - 100, result.x + 98, result.y - 85, "撤下疲劳干员", 1500);
                            list.remove(0);
                        }
                    }

                    //移除满心情
                    if(isReDorm){
                        List<FindResult> dormList = mFairy.findPic(430,104,475,625, 0.8f,"dorm.png");//寻找宿舍
                        while (dormList.size()!=0){
                            result=dormList.get(0);
                            List<FindResult> list=
                                    mFairy.findPic(result.x+174, result.y+56, result.x+735, result.y+114, 0.8f,"smile.png");
                            while (list.size()!=0){
                                result1=list.get(0);
                                mFairy.onTap(0.8f,result1,result1.x+35,result1.y-29,result1.x+36,result1.y-28,"撤下满心情干员",1500);
                                list.remove(0);
                            }
                            dormList.remove(0);
                        }
                    }
                    if(++ranNum>10){
                        setTaskName(4);
                        return;
                    }
                    LtLog.e("第" + ranNum + "次寻找疲劳干员");
                    mFairy.ranSwipe(1000, 700, 1000, 400, 1000, (long) 1300,2);//往下滑
                }
            }

            @Override
            public void content_4() throws  Exception{
                overtime(50,0);
                int x=1;
                result=mFairy.findPic(1176,14,1227,69,"removing.png");
                mFairy.onTap(0.8f,result,"关闭撤下干员模式",1000);

                result=mFairy.findPic(416,107,620,207,"control.png");
                result1=mFairy.findPic(596,100,1187,713,"add.png");
                //已经滑到顶部,并且没有空位置
                if(result.sim>0.8f && result1.sim<0.8f){
                    LtLog.e(mFairy.getLineInfo("替换结束"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(1052,5,1243,96,"remove button.png");
                if(result.sim>0.8f){
                   /* result=mFairy.findPic(582,80,1253,712,"add.png");
                    if(result.sim>0.8f){
                        //训练位不能指定，可能造成死循环
                        result1=mFairy.findPic(result.x-20,result.y+50,result.x+80,result.y+77,"train place.png");
                        //result1=mFairy.findPic(582,80,1253,712,"train place.png");
                        if(result1.sim > 0.8f){
                            mFairy.onTap(0.8f,result,"进入替换界面",1000);
                        }else{
                            LtLog.e(mFairy.getLineInfo("查找训练位向上滑动寻找"));
                            mFairy.ranSwipe(1000, 700, 1000, 400, 1000, (long) 1300,2);//往下滑
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("加号否向上滑动寻找"));
                        mFairy.ranSwipe(1000, 400, 1000, 700, 1000, (long) 1300,2);//往下滑
                    }*/
                    result=mFairy.findPic(582,80,1253,712,"add.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"选择添加",1000);
                        result1=mFairy.findPic(427,result.y-40,488,result.y+43,"ss.png");
                        if(result.sim>0.8f){
                            LtLog.e("向上滑");
                            mFairy.ranSwipe(1000, 480, 1000, 600, 1000, (long) 1300,2);//往上滑
                        }
                    }else{
                        LtLog.e("向上滑");
                        mFairy.ranSwipe(1000, 400, 1000, 700, 1000, (long) 1300,2);//往上滑
                    }
                }

                //替换
                result=mFairy.findPic(998,3,1275,82,"sort.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("替换界面"));
                    //清空选择
                    result = mFairy.findPic(402,643,601,707,"clear.png");
                    mFairy.onTap(0.8f,result,"清空选择",1000);

                    //选择填补
                    result=mFairy.findPic(209,144,374,253,new String[]{"see.png","see1.png"});
                    if(result.sim > 0.8f) {
                        LtLog.e(mFairy.getLineInfo("有see"));
                        mFairy.onTap(472, 245, 496, 268, "干员替换1", 1000);//1
                        int colorNum = mFairy.getColorNum(528,90,537,102, 0.9f,0,"241,241,241" );
                        //判断是否需要五个
                        if(colorNum>100){
                            mFairy.onTap(475, 512, 496, 535, "干员替换2", 500);//2
                            mFairy.onTap(612, 261, 638, 286, "干员替换3", 500);//3
                            mFairy.onTap(620, 538, 642, 559, "干员替换4", 500);//4
                            mFairy.onTap(755, 246, 782, 270, "干员替换5", 500);//5
                        }
                    }

                    //确认替换
                    result= mFairy.findPic(902,647,1248,704,"affirm.png");
                    if (result.sim > 0.8){
                        err=0;
                    }
                    mFairy.onTap(0.8f,result,"确认",1000);

                    //训练师
                    result= mFairy.findPic(800,651,1106,714,"ok.png");
                    mFairy.onTap(0.8f,result,"确认",1000);
                }
            }
        }.taskContent(mFairy,"基建收菜");
    }

    //自选关卡
    public void customLevel()throws Exception{
        new SingleTask1(mFairy){
            int fightCount;
            int type;
            @Override
            public void create() throws Exception {
                ControlSplit strSplit = strSplit(AtFairyConfig.getOption("fightCount"));
                if(strSplit!=null&&strSplit.choice==1){
                    fightCount=strSplit.count;
                }
                type = Integer.parseInt(AtFairyConfig.getOption("type"));//理智不足处理方式
                if(fightCount==0)fightCount=-1;
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic( 871,358,1273,697,new String[]{"start_action1.png","start_action.png"} );
                int picCount=picCount(0.8f,result,"start_action1.png");
                if(picCount==1){
                    if(fightCount==0){
                        LtLog.e("任务结束");
                        setTaskEnd();
                        return;
                    }
                    fightCount--;//作战次数减一
                    LtLog.e(mFairy.getLineInfo("还需要战斗"+fightCount+"次"));
                }
                mFairy.onTap(0.8f, result, "开始作战", 500);

                result=mFairy.findPic("failure.png");
                mFairy.onTap(0.8f,result,"任务失败，点击继续",500);

                result=mFairy.findPic("level up.png");//等级提升
                mFairy.onTap(0.8f,result,"等级提升",500);

                result=mFairy.findPic("level/bao.png");//查看战报
                mFairy.onTap(0.8f,result,"查看战报",500);

                result=mFairy.findPic(531,636,769,688,"gou.png");
                mFairy.onTap(0.8f,result,"保存",500);

                result = mFairy.findPic("action_over.png");//行动结束
                mFairy.onTap(0.8f,result,"行动结束",500);
                content_2();
            }
        }.taskContent(mFairy,"自选关卡");
    }

    @Override
    public void content_2()throws Exception{
        result=mFairy.findPic(308,603,507,691,"word task over ing.png");
        int picCount=picCount(0.8f,result,"task over");
        if(picCount!=0&&picCount%4==0)LtLog.e(mFairy.getLineInfo("接管代理中"));

        result=mFairy.findPic( "start_action.png");//开始行动
        if(result.sim>0.8f){
            result1=mFairy.findPic("pic lock.png");
            if(result1.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("暂未解锁，无法代理"));
                setTaskEnd();
                return;
            }

            int colorNum = mFairy.getColorNum(1055, 580, 1077, 602, 0.9f,0,"255,255,255" );//判断是否勾选代理
            if (colorNum < 100) {
                mFairy.onTap(1060,583,1074,600, "开启代理", 1000);//勾选代理
            }else{
                mFairy.onTap(0.8f, result, "开始行动", 1500);
            }
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
                    mFairy.onTap(0.8f,result,"退出",1000);
                    LtLog.e(mFairy.getLineInfo("理智不足，结束任务"));
                    //防误点
                    for(int i=0;i<=2;i++)mFairy.onTap(52,32,67,47,"返回",1000);
                    setTaskName(10);
                    setTaskEnd();
                    return;

                //药剂恢复
                case 2:
                    result = mFairy.findPic("yaoji.png");
                    mFairy.onTap(0.8f, result, "使用药剂恢复", 100);

                    result = mFairy.findPic( "use ok.png");
                    mFairy.onTap(0.8f,result, "确认药剂恢复", 100);

                    result=mFairy.findPic("yaojibuzu.png");
                    if(result.sim>0.8){
                        LtLog.e(mFairy.getLineInfo("药剂不足，理智不够，无法继续战斗，结束任务"));
                        mFairy.onTap(0.8f,result,"回到大厅",500);
                        //防误点
                        for(int i=0;i<=2;i++)mFairy.onTap(52,32,67,47,"返回",1000);
                        setTaskName(10);
                        setTaskEnd();
                        return;
                    }
                    break;

                //源石恢复
                case 3:
                    result = mFairy.findPic("yuanshi.png");
                    mFairy.onTap(0.8f, result, "使用源石恢复", 100);

                    result = mFairy.findPic("use ok.png");
                    mFairy.onTap(0.8f, result, "确认源石恢复", 100);

                    result=mFairy.findPic("yuanshibuzu.png");
                    if(result.sim>0.8){
                        LtLog.e(mFairy.getLineInfo("源石不足，理智不够，无法继续战斗，结束任务"));
                        mFairy.onTap(0.8f,result,"回到大厅",500);
                        //防误点
                        for(int i=0;i<=2;i++)mFairy.onTap(52,32,67,47,"返回",1000);
                        setTaskName(10);
                        setTaskEnd();
                        return;
                    }
                    break;
            }
        }
    }

}
