package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;
import com.script.opencvapi.utils.TemplateInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/25 0025.
 */

public class SingleTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    Util util;
    boolean energy_rebuild=false;
    int rebuild_num=0;
    public SingleTask(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        util = new Util(mFairy);
    }
    public void setTaskName(int taskContentNum) throws Exception {
        super.setTaskName(taskContentNum);
        mFairy.condit();
    }
    //新手指引 1至9级
    public void novice ()throws Exception{
        new SingleTask(mFairy){
            long daze=0;

            @Override
            public void content_0() throws Exception {
                util.close("新手指引");
                setTaskName(1);
                daze=util.initDaze("content_0初始化");
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("pic story continue.png");
                mFairy.onTap(0.8f,result,"跳过剧情",1000);
                if(result.sim<0.8f){
                    result=mFairy.findPic("pic story menu.png");
                    mFairy.onTap(0.8f,result,"打开菜单",1000);
                }

                result=mFairy.findPic("pic failed.png");
                mFairy.onTap(0.8f,result,1078,654,1087,661,"战斗失败，前往主页",1000);
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("一键9级完成"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word batong.png");
                mFairy.onTap(0.8f,result,1199,32,1203,36,"跳过初始战斗",1000);

                result=mFairy.findPic(new String[]{"word btn register.png","word btn ok.png","word btn ok1.png"});
                mFairy.onTap(0.8f,result,"登记名字/ok",1000);

                result=mFairy.findPic("word affirm name.png");
                mFairy.onTap(0.8f,result,782,490,790,498,"确认名字",1000);

                result=mFairy.findPic("word guide ok.png");
                mFairy.onTap(0.8f,result,953,590,962,600,"释放技能",1000);

                //指引 主菜单界面
                result=mFairy.findPic("pic guide main menu.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(43,567,1245,624,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"箭头指引",1000);

                    result=mFairy.findPic(728,44,770,96,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"进入主线关卡",1000);

                    result=mFairy.findPic("pic risk magnify.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(1184,424,1245,532,"pic guide arrows.png");
                        mFairy.onTap(0.9f,result,result.x+2,result.y+89,result.x+9,result.y+97,"进入任务",1000);

                        result=mFairy.findPic(121,145,158,240,"pic guide arrows.png");
                        mFairy.onTap(0.9f,result,result.x+2,result.y+89,result.x+9,result.y+97,"arrows 选择关卡1-1",1000);

                        result=mFairy.findPic(290,90,328,205,"pic guide arrows.png");
                        mFairy.onTap(0.9f,result,result.x+2,result.y+89,result.x+9,result.y+97,"arrows 选择关卡 1-2",1000);

                        result=mFairy.findPic(103,59,1199,619,"pic risk next.png");
                        mFairy.onTap(0.9f,result,result.x+2,result.y+89,result.x+9,result.y+97,"next 选择关卡",1000);
                    }

                    result=mFairy.findPic(1002,33,1046,94,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"进入角色详情关卡",1000);

                    result=mFairy.findPic(938,333,984,399,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"150扭蛋一次",1000);

                    result=mFairy.findPic(1103,454,1146,550,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"任务-全部收取",1000);

                    result=mFairy.findPic(1180,464,1218,526,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"公会之家-全部收取",1000);

                    result=mFairy.findPic(916,215,965,307,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"进入剧情公会",1000);

                    result=mFairy.findPic(897,19,942,100,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"读取第一个公会剧情",1000);

                    result=mFairy.findPic(900,181,941,256,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"公会详情剧情",1000);

                    result=mFairy.findPic(912,40,957,112,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"进入主线剧情",1000);

                    result=mFairy.findPic(902,343,937,414,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"进入主线剧情详情",1000);

                    result=mFairy.findPic(1104,140,1144,224,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"角色强化",1000);

                    result=mFairy.findPic("word risk.png");
                    mFairy.onTap(0.8f,result,"切换冒险页面",1000);

                    result=mFairy.findPic(675,378,756,433,"word main line.png");
                    mFairy.onTap(0.8f,result,"进入主线",1000);
                }

                result=mFairy.findPic("word role paging.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(89,70,196,258,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"选择装备",1000);

                    result=mFairy.findPic(1051,478,1106,548,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"装备",1000);
                }

                result=mFairy.findPic("pic fight reward box.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic btn fight auto.png");
                    mFairy.onTap(0.8f,result,"自动战斗",1000);

                    result=mFairy.findPic("pic btn fight speed.png");
                    mFairy.onTap(0.8f,result,"战斗加速",1000);
                }

                result=mFairy.findPic("word btn challenge.png");
                mFairy.onTap(0.8f,result,"挑战",1000);

                result=mFairy.findPic("word team edit.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("队伍编组");
                    result=mFairy.findPic(101,94,750,160,"pic guide arrows.png");
                    mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"编队",1000);

                    if(result.sim<0.8f){
                        result=mFairy.findPic("word btn fight start.png");
                        mFairy.onTap(0.8f,result,"战斗开始",1000);
                    }
                }

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word hint data download.png");
                mFairy.onTap(0.8f,result,625,485,638,495,"无语音",1000);

                result=mFairy.findPic("pic story continue.png");
                mFairy.onTap(0.8f,result,"跳过剧情",1000);
                mFairy.onTap(0.8f,result,782,491,788,497,"跳过",1000);
                if(result.sim<0.8f){
                    result=mFairy.findPic("pic story menu.png");
                    mFairy.onTap(0.8f,result,"打开菜单",1000);
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic(749,466,819,518,"word btn hint continue.png");
                mFairy.onTap(0.8f,result,"确认跳过剧情",1000);
                if(result.sim>0.8f)daze=util.initDaze("确认跳过剧情");

                result=mFairy.findPic("word hint continue.png");
                mFairy.onTap(0.8f,result,"跳过战斗-ok",1000);

                result=mFairy.findPic(597,455,677,623,"word btn close.png");
                mFairy.onTap(0.8f,result,"关闭",1000);

                if(daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，初始化"));
                    setTaskName(0);
                    return;
                }
                super.inOperation();
            }

        }.taskContent(mFairy,"新手指引");
    }

    //单人日常
    public void daily()throws Exception{
        new SingleTask(mFairy){
            List<String> taskList=new ArrayList();
            @Override
            public void create() throws Exception {
                //初始化参数
                energy_rebuild=false;
                rebuild_num=0;
                //体力回复
                if(AtFairyConfig.getOption("energy_rebuild").equals("1")){
                    energy_rebuild=true;
                }


                if(!AtFairyConfig.getOption("rebuild_num").equals("")){
                    ControlSplit split = strSplit(AtFairyConfig.getOption("rebuild_num"));
                    if(split.choice==1){
                        energy_rebuild=true;
                        rebuild_num=split.count;
                    }
                }

                //购买玛那
                if(AtFairyConfig.getOption("buy_mana").equals("1")){
                    taskList.add("buy_mana");
                }

                //免费扭蛋
                if(AtFairyConfig.getOption("niudan").equals("1")){
                    taskList.add("niudan");
                }

                //行会点赞
                if(AtFairyConfig.getOption("guild_like").equals("1")){
                    taskList.add("guild_like");
                }

                //公会点赞
                if(AtFairyConfig.getOption("society_like").equals("1")){
                    taskList.add("society_like");
                }

                //剧情奖励
                if(AtFairyConfig.getOption("story").equals("1")){
                    taskList.add("story");
                }

                //地下城
                if (AtFairyConfig.getOption("under_city").equals("1")){
                    taskList.add("under_city");
                }

                //地下城
                if (!AtFairyConfig.getOption("under_city hard").equals("")){
                    taskList.add("under_city");
                }

                //战斗竞技场
                if (!AtFairyConfig.getOption("cooling_type").equals("0")&&!AtFairyConfig.getOption("cooling_type").equals("")){
                    taskList.add("fight_arena");
                }

                //公主竞技场
                if (!AtFairyConfig.getOption("pa_cooling_type").equals("0")&&!AtFairyConfig.getOption("pa_cooling_type").equals("")){
                    taskList.add("princess_arena");
                }

                //探索4次
                if(AtFairyConfig.getOption("explore").equals("1")){
                    taskList.add("explore");
                }

                //主线推图
                if(AtFairyConfig.getOption("main").equals("1")){
                    taskList.add("main");
                }

                //困难关卡
                if(AtFairyConfig.getOption("6197").equals("1")){
                    taskList.add("difficult_pieces");
                }

                //团队战
                if (AtFairyConfig.getOption("team_battle").equals("1")){
                    taskList.add("team_battle");
                }

                //领取奖励
                if(AtFairyConfig.getOption("reward").equals("1")){
                    taskList.add("reward");
                }
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务做完，没有任务了"));
                    setTaskEnd();
                    return;
                }
                //剧情
                if(taskList.get(0).equals("story")){
                    story();
                    taskList.remove(0);
                    return;
                }

                //行会点赞
                if(taskList.get(0).equals("guild_like")){
                    guild_like();
                    taskList.remove(0);
                    return;
                }
                //公会点赞
                if(taskList.get(0).equals("society_like")){
                    society_like();
                    taskList.remove(0);
                    return;
                }

                //免费扭蛋
                if(taskList.get(0).equals("niudan")){
                    niudan();
                    taskList.remove(0);
                    return;
                }
                //主线
                if(taskList.get(0).equals("main")){
                    main();
                    taskList.remove(0);
                    return;
                }
                //强化
                if(taskList.get(0).equals("strong")){
                    strong();
                    taskList.remove(0);
                    return;
                }

                //购买玛那
                if(taskList.get(0).equals("buy_mana")){
                    buy_mana();
                    taskList.remove(0);
                    return;
                }

                //探索4次
                if(taskList.get(0).equals("explore")){
                    explore();
                    taskList.remove(0);
                    return;
                }

                //困难关卡
                if(taskList.get(0).equals("difficult_pieces")){
                    difficult_pieces();
                    taskList.remove(0);
                    return;
                }

                //地下城
                if(taskList.get(0).equals("under_city")){
                    under_city();
                    taskList.remove(0);
                    return;
                }

                //团队战
                if(taskList.get(0).equals("team_battle")){
                    team_battle();
                    taskList.remove(0);
                    return;
                }

                //战斗竞技场
                if(taskList.get(0).equals("fight_arena")){
                    fight_arena();
                    taskList.remove(0);
                    return;
                }

                //公主竞技场
                if(taskList.get(0).equals("princess_arena")){
                    princess_arena();
                    taskList.remove(0);
                    return;
                }

                //领取奖励
                if(taskList.get(0).equals("reward")){
                    reward();
                    taskList.remove(0);
                    return;
                }
            }
        }.taskContent(mFairy,"单人日常");
    }

    //购买玛那
    public void buy_mana()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close("购买玛那");
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word my.png");
                mFairy.onTap(0.8f,result,"切换我的分页",1000);

                result=mFairy.findPic("pic mana add.png");
                mFairy.onTap(0.8f,result,"进入玛那购买",1000);

                result=mFairy.findPic("word btn 10 free mana.png");
                mFairy.onTap(0.8f,result,"免费购买一次",1000);

                result=mFairy.findPic("word hint buy affirm.png");
                mFairy.onTap(0.8f,result,786,488,792,495,"购买确认",1000);

                result=mFairy.findPic(new String[]{"word btn 20 free mana.png","word btn 20 pay mana.png"});
                mFairy.onTap(0.8f,result,21,696,28,703,"关闭购买界面",1000);
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("玛那购买一次完成"));
                    setTaskEnd();
                    return;
                }
                overtime(15,0);
            }
        }.taskContent(mFairy,"购买玛那");
    }

    //免费扭蛋
    public void niudan()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close("免费扭蛋");
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word niudan.png");
                mFairy.onTap(0.8f,result,"切换扭蛋页面",1000);

                result=mFairy.findPic(1080,70,1250,120,new String[]{"word niudan common.png","word niudan common1.png"});
                mFairy.onTap(0.8f,result,"切换扭蛋普通页面",1000);

                result=mFairy.findPic("word btn setting.png");
                mFairy.onTap(0.8f,result,652,406,659,413,"不显示",1000);
                mFairy.onTap(0.8f,result,"设定",1000);

                result=mFairy.findPic("word niudan finish free.png");
                if(result.sim>0.8f){
                    util.close("免费扭蛋完成");
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(920,475,997,518,"word niudan free.png");
                mFairy.onTap(0.8f,result,"免费抽取",1000);

                result=mFairy.findPic("word hint free draw.png");
                mFairy.onTap(0.8f,result,779,486,787,495,"确定免费抽",1000);
                overtime(15,0);
            }
        }.taskContent(mFairy,"免费扭蛋");
    }

    //行会点赞
    public void guild_like()throws Exception {
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close("行会点赞");
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word my.png");
                mFairy.onTap(0.8f,result,"切换我的主页",1000);

                result=mFairy.findPic(885,522,932,567,"pic main difficult lock.png");
                result1=mFairy.findPic("word btn guild create.png");
                if(result.sim>0.8f||result1.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo(0.8f,result,"行会没有解锁，任务结束"));
                    LtLog.e(mFairy.getLineInfo(0.8f,result1,"没有加入行会，任务结束"));
                    setTaskEnd();
                    return;
                }



                result=mFairy.findPic("pic guild.png");
                mFairy.onTap(0.8f,result,"进入行会",3000);

                result=mFairy.findPic("word guild info.png");
                mFairy.onTap(0.8f,result,"成员信息",1000);

                result=mFairy.findPic(1013,223,1189,453,"word btn guild like.png");
                mFairy.onTap(0.8f,result,"点赞",1000);
                if(result.sim>0.8f){
                    util.close("行会点赞");
                    setTaskEnd();
                    return;
                }
                overtime(20,0);
            }

            @Override
            public void inOperation() throws Exception {
                super.inOperation();
            }
        }.taskContent(mFairy,"行会点赞");
    }

    //公会点赞
    public void society_like()throws Exception{
        new SingleTask(mFairy){
            long daze=0;//发呆时长
            @Override
            public void content_0() throws Exception {
                util.close("公会点赞");
                setTaskName(1);
                daze=util.initDaze("content_0初始化");
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word society.png");
                mFairy.onTap(0.8f,result,"切换公会之家页面",1000);

                result=mFairy.findPic("word btn society like.png");
                mFairy.onTap(0.8f,result,"点赞",1000);

                result=mFairy.findPic("word hint dont continue like.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,632,487,642,496,"无法继续点赞",1000);
                    mFairy.onTap(0.8f,result,72,359,80,368,"切换下一个",1000);
                    return;
                }

                result=mFairy.findPic("word btn society get.png");
                if (result.sim>0.8f){
                    result=mFairy.findPic(1210,511,1240,541,"pic red tip1.png");
                    mFairy.onTap(0.8f,result,"全部领取",1000);
                    if(result.sim>0.8f)return;
                }

                result=mFairy.findPic("word btn society get.png");
                result1=mFairy.findPic("word btn society like finish.png");
                if(result.sim>0.8f||result1.sim>0.8f){
                    result=mFairy.findPic("word btn society random visit.png");
                    mFairy.onTap(0.8f,result,"随机访问",1000);
                }

                result=mFairy.findPic("word hint visit affirm.png");
                mFairy.onTap(0.8f,result,782,490,787,495,"出行确认",1000);
                if(result.sim>0.8f)daze=util.initDaze("出行确认");

                result=mFairy.findPic("word society zero.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,637,489,646,496,"点赞报酬到达上限",1000);
                    util.close("点赞报酬完成");
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word hint like reward.png");
                mFairy.onTap(0.8f,result,637,489,646,496,"点赞报酬",1000);
                if(result.sim>0.8f)daze=util.initDaze("点赞报酬");

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint all gather.png");
                mFairy.onTap(0.8f,result,634,634,642,639,"全部收取，关闭",1000);

                super.inOperation();
            }
        }.taskContent(mFairy,"公会访问");
    }

    //剧情奖励
    public void story()throws Exception{
        new SingleTask(mFairy){
            long daze=0;//发呆的时长
            int end=0;//没有出现红点计次
            @Override
            public void content_0() throws Exception {
                util.close("剧情");
                daze=util.initDaze("content_0初始化");
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word story.png");
                mFairy.onTap(0.8f,result,"切换剧情页面",1000);

                result=mFairy.findPic("word hint data download.png");
                mFairy.onTap(0.8f,result,625,485,638,495,"无语音",1000);

                result=mFairy.findPic("pic story continue.png");
                mFairy.onTap(0.8f,result,"跳过剧情",1000);
                if(result.sim<0.8f){
                    result=mFairy.findPic("pic story menu.png");
                    mFairy.onTap(0.8f,result,"打开菜单",1000);
                }

                result=mFairy.findPic("word hint reward affirm.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(593,523,677,687,"word btn close.png");
                    mFairy.onTap(0.8f,result,"报酬确认",1000);
                }

                result=mFairy.findPic("word story paging.png");
                if(result.sim>0.9f){
                    result1=mFairy.findPic(500,650,526,677,"pic red tip.png");
                    if(result1.sim<0.8f){
                        //连续出现10次以上没有红点=没有未读剧情
                        if(++end>=10){
                            util.close("剧情完成");
                            setTaskEnd();
                            return;
                        }
                    }else{
                        result=mFairy.findPic("word story active.png");
                        mFairy.onTap(0.8f,result,"进入特别活动",1000);
                    }

                    result=mFairy.findPic("word new.png");
                    mFairy.onTap(0.8f,result,"进入主线剧情",1000);
                    if(result.sim>0.8f){end=0;return;}

                    result=mFairy.findPic(610,302,665,351,"word new.png");
                    mFairy.onTap(0.8f,result,"进入角色剧情",1000);
                    if(result.sim>0.8f){end=0;return;}

                    result=mFairy.findPic(830,303,882,352,"word new.png");
                    mFairy.onTap(0.8f,result,"进入公会剧情",1000);
                    if(result.sim>0.8f){end=0;return;}

                    result=mFairy.findPic(1050,308,1107,356,"word new.png");
                    mFairy.onTap(0.8f,result,"进入特别剧情",1000);
                    if(result.sim>0.8f){end=0;return;}


                    result=mFairy.findPic("pic return.png");
                    if(picCount(0.8f,result,"return")==1)return;
                    if(result.sim>0.8f){
                        //公会剧情
                        result=mFairy.findMultiColor(78,9,134,66,0.9f,"99,61,16",
                                "-7|9|99,61,16&13|3|99,61,8&16|7|99,61,16&21|12|99,65,16&3|13|99,61,16&-3|22|99,61,16&-2|29|99,61,16&14|23|99,61,16&18|28|99,61,16");
                        if(result.sim>0.85f){
                            LtLog.e(mFairy.getLineInfo("公会剧情"));

                            //滑到公会剧情底部了
                            result=mFairy.findPic("pic story slide bottom.png");
                            if(result.sim>0.8f){
                                result=mFairy.findPic(634,143,710,489,"word story new1.png");
                                mFairy.onTap(0.8f,result,result.x+48,result.y+69,result.x+53,result.y+75,"进入剧情",1000);
                                if (result.sim>0.8f) end=0;
                                else mFairy.onTap(40,35,47,42,"返回",1000);
                                return;
                            }

                            result=mFairy.findPic(639,82,712,451,"word story new1.png");
                            mFairy.onTap(0.8f,result,result.x+48,result.y+69,result.x+53,result.y+75,"进入剧情",1000);
                            if(result.sim>0.8f){
                                daze=util.initDaze("进入剧情");
                                end=0;
                            }else{
                                mFairy.ranSwipe(962,413,962,135,1000,1500l,0);//向下滑动
                                LtLog.e(mFairy.getLineInfo("没有未读剧情，向下滑动"));
                            }
                        }else{
                            result=mFairy.findPic(633,76,717,367,new String[]{"word story new.png","word story new1.png"});
                            mFairy.onTap(0.8f,result,result.x+48,result.y+69,result.x+53,result.y+75,"进入剧情",1000);
                            if (result.sim>0.8f)end=0;

                            if(result.sim>0.8f)daze=util.initDaze("进入剧情");
                            else mFairy.onTap(40,39,49,47,"没有未读剧情，返回",1000);
                        }
                    }
                }else{
                    if(daze>10)mFairy.onTap(1258,695,1265,702,"点击跳过视频",1000);
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }
            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word btn hint continue.png");
                mFairy.onTap(0.8f,result,"确认跳过剧情",1000);

                super.inOperation();
            }
        }.taskContent(mFairy,"剧情");
    }

    //公主竞技场
    public void princess_arena()throws Exception{
        new SingleTask(mFairy){
            long daze=0;//发呆时长
            Integer hard=3,cooling_type=2;//挑战难度，冷却等待:1等待 2跳过

            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("hard").equals("")){
                    hard=Integer.parseInt(AtFairyConfig.getOption("hard"));
                }
                if(!AtFairyConfig.getOption("pa_cooling_type").equals("")){
                    cooling_type=Integer.parseInt(AtFairyConfig.getOption("pa_cooling_type"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close("公主竞技场");
                setTaskName(1);
                daze=util.initDaze("content_0初始化");
            }

            @Override
            public void content_1() throws Exception {
                result = mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f, result, "切换冒险页面", 1000);

                result = mFairy.findPic(937, 462, 1009, 532, "pic lock.png");
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("公主竞技场没有解锁，任务结束"));
                    setTaskEnd();
                    return;
                }

                result = mFairy.findPic("word princess arena.png");
                mFairy.onTap(0.8f, result, "进入公主竞技场", 1000);

                result = mFairy.findPic("word fight arena zhanli zero.png");
                mFairy.onTap(0.8f, result, 890, 601, 900, 609, "战力为0，取消战斗", 1000);
                if (result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("战斗竞技场结束"));
                    setTaskEnd();
                    return;
                }

                //战斗竞技场界面
                result = mFairy.findPic("word princess arena interface.png");
                if (result.sim > 0.8f) {
                    result = mFairy.findPic("word btn receive HLS1.png");
                    mFairy.onTap(0.9f, result, "收取", 1000);

                    result = mFairy.findPic("word fight arena zero.png");
                    mFairy.onTap(0.9f, result, 43, 38, 54, 45, "没有挑战次数了，返回", 1000);
                    if (result.sim > 0.9f) {
                        LtLog.e(mFairy.getLineInfo("任务结束"));
                        setTaskEnd();
                        return;
                    }

                    //等待冷却
                    if (cooling_type == 1) {
                        result = mFairy.findPic(382,501,415,524, "word zdjjc cooling ing.png");
                        if (result.sim > 0.8f) {
                            daze = util.initDaze("冷却等待中...");
                            return;
                        }
                    }

                    result = mFairy.findPic("word princess arena select fight.png");
                    if (hard == 1) mFairy.onTap(0.8f, result, 666, 234, 674, 243, "选择上", 1000);
                    if (hard == 2) mFairy.onTap(0.8f, result, 669, 398, 677, 405, "选择中", 1000);
                    if (hard == 3) mFairy.onTap(0.8f, result, 800,510,812,521, "选择下", 1000);
                }else{
                    LtLog.e(mFairy.getLineInfo(0.0f,result,"princess arena interface"));
                }

                result = mFairy.findPic("word team setting interface.png");
                if (result.sim > 0.8f) {
                    daze = util.initDaze("队伍编组中。。");
                    result = mFairy.findPic("word princess arena zhanli zero.png");
                    mFairy.onTap(0.8f, result, "打开我的队伍", 1000);
                    if(result.sim>0.8f)return;

                    mFairy.onTap(1113,599,1124,609,"下一个队伍",1000);
                }

                //我的队伍一览界面
                result = mFairy.findPic("word my team interface.png");
                if (result.sim > 0.8f) {
                    daze = util.initDaze("选择合适队伍");
                    result = mFairy.findPic(968, 161, 1056, 579, "word btn breathe out.png");
                    if (result.sim > 0.9f) {
                        mFairy.onTap(0.9f, result, "呼出此编组", 1000);
                    } else {
                        result = mFairy.findPic("pic my team bottom.png");
                        mFairy.onTap(0.8f, result, 627, 632, 640, 644, "关闭", 1000);
                        if (result.sim > 0.8f) {
                            LtLog.e(mFairy.getLineInfo("滑到底部，没有合适的队伍，任务结束"));
                            util.close("地下城");
                            setTaskEnd();
                            return;
                        }

                        LtLog.e(mFairy.getLineInfo("没有合适队伍，往下滑动"));
                        mFairy.ranSwipe(920, 500, 920, 200, 1000, 1500l, 0);
                    }
                }
                result = mFairy.findPic("word btn fight start.png");
                mFairy.onTap(0.8f, result, "战斗开始", 1000);

                result = mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f, result, "自动战斗", 1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result = mFairy.findPic("pic btn fight auto ing.png");
                if (result.sim > 0.8f) daze = util.initDaze("自动战斗中..");

                result = mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f, result, "战斗加速", 1000);

                result = mFairy.findPic(1030, 627, 1157, 713, "word btn next.png");
                mFairy.onTap(0.8f, result, "下一步", 1000);

                if (daze > 30) {
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint ranking reward.png");
                mFairy.onTap(0.8f,result,634,634,638,639,"排名报酬",1000);

                result=mFairy.findPic("word hint over cooling.png");
                if(cooling_type==2){
                    mFairy.onTap(0.8f,result,780,488,786,497,"结束冷却",1000);
                }else{
                    mFairy.onTap(0.8f,result,480,490,490,497,"取消结束冷却",1000);
                }

                result=mFairy.findPic("word hint cooling time.png");
                mFairy.onTap(0.8f,result,780,488,786,497,"冷却时间",1000);

                super.inOperation();
            }
        }.taskContent(mFairy,"公主竞技场");
    }

    //战斗竞技场
    public void fight_arena()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            Integer hard=3,cooling_type=2;//挑战难度，冷却等待:1等待 2跳过

            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("hard").equals("")){
                    hard=Integer.parseInt(AtFairyConfig.getOption("hard"));
                }
                if(!AtFairyConfig.getOption("cooling_type").equals("")){
                    cooling_type=Integer.parseInt(AtFairyConfig.getOption("cooling_type"));
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close("战斗竞技场");
                setTaskName(1);
                daze=util.initDaze("content_0初始化");
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f,result,"切换冒险页面",1000);

                result=mFairy.findPic(620,468,691,538, "pic lock.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("战斗竞技场没有解锁，任务结束"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(729,558,800,602,"word fight arena.png");
                mFairy.onTap(0.8f,result,"进入战斗竞技场",1000);

                result=mFairy.findPic("word fight arena zhanli zero.png");
                mFairy.onTap(0.8f,result,890,601,900,609,"战力为0，取消战斗",1000);
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("战斗竞技场结束"));
                    setTaskEnd();
                    return;
                }

                //战斗竞技场界面
                result=mFairy.findPic("word fight arena interface.png");
                if(result.sim>0.8f){
                    int colorNum=mFairy.getColorNum(357,431,427,473,0.95f,0,"255,255,255");
                    if(colorNum>1000){
                        result=mFairy.findPic("word btn fight arena gather.png");
                        mFairy.onTap(0.8f,result,"收取",1000);
                    }

                    result=mFairy.findPic("word fight arena zero.png");
                    mFairy.onTap(0.9f,result,43,38,54,45,"没有挑战次数了，返回",1000);
                    if(result.sim>0.9f){
                        LtLog.e(mFairy.getLineInfo("任务结束"));
                        setTaskEnd();
                        return;
                    }

                    //等待冷却
                    if(cooling_type==1){
                        result=mFairy.findPic(382,501,415,524,"word zdjjc cooling ing.png");
                        if(result.sim>0.8f){
                            daze=util.initDaze("冷却等待中...");
                            return;
                        }
                    }

                    result=mFairy.findPic("word select fight.png");
                    if(hard==1)mFairy.onTap(0.8f,result,666,234,674,243,"选择上",1000);
                    if(hard==2)mFairy.onTap(0.8f,result,669,398,677,405,"选择中",1000);
                    if(hard==3)mFairy.onTap(0.8f,result,800,510,812,521,"选择下",1000);
                }

                result=mFairy.findPic("word btn fight start.png");
                mFairy.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f,result,"自动战斗",1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic("pic btn fight auto ing.png");
                if(result.sim>0.8f)daze=util.initDaze("自动战斗中..");

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint ranking reward.png");
                mFairy.onTap(0.8f,result,634,634,638,639,"排名报酬",1000);

                result=mFairy.findPic("word hint over cooling.png");
                if(cooling_type==2){
                    mFairy.onTap(0.8f,result,780,488,786,497,"结束冷却",1000);
                }else{
                    mFairy.onTap(0.8f,result,480,490,490,497,"取消结束冷却",1000);
                }

                result=mFairy.findPic("word hint cooling time.png");
                mFairy.onTap(0.8f,result,780,488,786,497,"冷却时间",1000);

                super.inOperation();
            }
        }.taskContent(mFairy,"战斗竞技场");
    }

    //探索 4次
    public void explore()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            int type=1,failCount=0;//探索的类型(经验和玛那)，挑战失败的次数(2次以上结束)
            boolean failure=false;
            @Override
            public void content_0() throws Exception {
                util.close("探索4次");
                setTaskName(1);
                daze=util.initDaze("content_0初始化");
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(893,95,954,158, "pic lock.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("探索没有解锁，任务结束"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f,result,"切换冒险界面",1000);

                result=mFairy.findPic("word explore.png");
                mFairy.onTap(0.8f,result,"进入探索界面",1000);

                result=mFairy.findPic("word explore paging.png");
                if(result.sim>0.8f){
                    if(type>2){
                        LtLog.e(mFairy.getLineInfo("探索4次完成，任务结束"));
                        setTaskEnd();
                        return;
                    }
                }
                if(type==1){
                    //经验关卡
                    result=mFairy.findPic(686,423,780,482,"word explore experience.png");
                    mFairy.onTap(0.8f,result,"进入经验关卡",1000);
                }
                if(type==2){
                    //玛那关卡
                    result=mFairy.findPic(992,415,1087,470,"word explore mana.png");
                    mFairy.onTap(0.8f,result,"进入玛那关卡",1000);
                }

                //剩余挑战次数
                result=mFairy.findPic("word explore challenge num.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("关卡选择界面");
                    result=mFairy.findPic("word explore zero.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,35,35,42,45,"次数不足，返回探索首页",1000);
                        type++;
                        return;
                    }

                    if(failure){
                        result=mFairy.findPic(907,355,942,534,"pic under city star.png");
                        mFairy.onTap(0.8f,result,"接取已过3星关卡",1000);
                        if(result.sim>0.8f)return;

                        result=mFairy.findPic(852,351,883,536,"pic under city star.png");
                        mFairy.onTap(0.8f,result,"接取已过关卡",1000);
                    }else{
                        result=mFairy.findPic(625,124,688,187,"pic main difficult lock.png");
                        mFairy.onTap(0.8f,result,1176,342,1182,348,"第二层",1000);
                        if(result.sim<0.8f)mFairy.onTap(1178,190,1184,198,"第一层",1000);
                    }
                }

                result=mFairy.findPic("word btn challenge.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("挑战选择界面");
                    result=mFairy.findPic("word saodang num zero.png");
                    mFairy.onTap(0.9f,result,1117,604,1126,611,"扫荡卷不足，执行挑战",2000);
                    if(result.sim>0.9f)return;

                    result1=mFairy.findPic(1163,27,1208,74,"pic challenge three star.png");
                    if(result1.sim>0.8f){
                        result=mFairy.findPic("word btn saodang use.png");
                        mFairy.onTap(0.8f,result,"扫荡 使用一次",1000);
                    }else{
                        mFairy.onTap(1117,604,1124,611,"挑战一次",1000);
                    }
                }

                result=mFairy.findPic("word btn fight start.png");
                mFairy.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("pic failed.png");
                mFairy.onTap(0.8f,result,1078,654,1087,661,"前往探索",1000);
                if(result.sim>0.8f){
                    failure=true;
                    if(++failCount>=2){
                        LtLog.e(mFairy.getLineInfo("失败两次，探索任务结束"));
                        type++;
                        return;
                    }
                    LtLog.e(mFairy.getLineInfo("战斗失败"+failCount+"次"));
                }

                if(daze>30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(new String[]{"word btn explore home.png","word btn explore home1.png"});
                mFairy.onTap(0.8f,result,"进入探索首页",1000);
                if(result.sim>0.8f){
                    failure=false;
                    failCount=0;
                    type++;
                }

                result=mFairy.findPic("word hint sao dang affirm.png");
                mFairy.onTap(0.8f,result,784,488,789,495,"扫荡 确认",2000);

                result=mFairy.findPic("word saodang get reward.png");
                mFairy.onTap(0.8f,result,630,633,638,643,"扫荡结果",1000);

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"探索4次");
    }

    //主线推图
    public void main()throws Exception{
        new SingleTask(mFairy){
            long daze=0;//发呆时长
            @Override
            public void content_0() throws Exception {
                util.close("主线推图");
                setTaskName(1);
                daze=util.initDaze("content_0初始化");

                result=mFairy.findPic(31,38,1248,693,"pic guide arrows.png");
                mFairy.onTap(0.8f,result,result.x+2,result.y+89,result.x+9,result.y+97,"箭头指引",1000);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f,result,"切换冒险页面",1000);

                result=mFairy.findPic(675,378,756,433,"word main line.png");
                mFairy.onTap(0.8f,result,"进入主线",1000);

                result=mFairy.findPic("pic risk shrink.png");
                mFairy.onTap(0.8f,result,"缩小地图",1000);

                result=mFairy.findPic("pic risk magnify.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn main normal.png");
                    mFairy.onTap(0.8f,result,"切换普通关卡",1000);
                    if(result.sim>0.8f)return;

                    result=mFairy.findPic(1220,338,1271,379,"pic next.png");
                    mFairy.onTap(0.8f,result,"下一关",1000);
                    if(result.sim>0.8f)return;

                    result=mFairy.findPic(103,59,1199,619,"pic risk next.png");
                    mFairy.onTap(0.9f,result,result.x+2,result.y+89,result.x+9,result.y+97,"选择关卡",1000);

                    if(result.sim<0.8f){
                        result=mFairy.findPic("word main end.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(43,38,51,45,"主线全部推完，任务结束",1000);
                            setTaskEnd();
                            return;
                        }
                    }
                }

                result=mFairy.findPic("word btn challenge.png");
                util.onTap(0.8f,result,"挑战",1000);

                result=mFairy.findPic("word btn fight start.png");
                util.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f,result,"自动战斗",1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                util.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word btn go main line.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"战斗失败，前往主线",1000);
                    setTaskEnd();
                    return;
                }

                if(daze>15){
                    LtLog.e(mFairy.getLineInfo("任务超时，任务重置"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic(597,455,677,623,"word btn close.png");
                mFairy.onTap(0.8f,result,"关闭",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"主线推图");
    }

    //困难关卡(记忆碎片)
    public void difficult_pieces()throws Exception{
        new SingleTask(mFairy){
            long daze=0;//发呆时长
            String level="";//要挑战的关卡(picName)
            boolean rebuild=false;//是否增加挑战次数
            int fail=0;//挑战失败的次数(3次以上结束)
            int goalFloor;//目标层数
            List<String> levelList;

            @Override
            public void create() throws Exception {
                levelList=new ArrayList();
                    if(AtFairyConfig.getOption("difficult_rebuild").equals("1")){
                    rebuild=true;
                }
                for(int i=1;i<=30;i++){
                    if(!AtFairyConfig.getOption("difficult_"+i).equals("")){
                        levelList.add(AtFairyConfig.getOption("difficult_"+i));
                    }
                }
            }

            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic("pic risk magnify.png");
                if(result.sim<0.8f)util.close("困难关卡");

                if(levelList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有关卡执行完成，任务结束"));
                    setTaskEnd();
                    return;
                }

                goalFloor=Integer.parseInt(levelList.get(0).split("-")[0]);
                level="pic main difficult "+levelList.get(0)+".png";
                setTaskName(1);
                daze=util.initDaze("content_0初始化");
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f,result,"切换冒险页面",1000);

                result=mFairy.findPic(675,378,756,433,"word main line.png");
                mFairy.onTap(0.8f,result,"进入主线",1000);

                //地图界面
                result=mFairy.findPic("pic risk magnify.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("挑战关卡界面");
                    result=mFairy.findPic("pic main hard lock.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("主线困难没有解锁，任务结束"));
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word btn main hard.png");
                    mFairy.onTap(0.8f,result,"切换困难关卡",1000);
                    if(result.sim>0.8f)return;

                    TemplateInfo mInfo = mFairy.getTemplateInfo(level);
//                    result=mFairy.findPic(level);
                    result=mFairy.findPic(mInfo.x-10 , mInfo.y-10,mInfo.x +10+ mInfo.width , mInfo.y+10 + mInfo.height,level);
                    mFairy.onTap(0.8f,result,result.x-61,result.y+70,result.x-41,result.y+88,"进入"+level+"关卡",1000);
                    LtLog.e("level信息"+level);
                    LtLog.e("范围"+(mInfo.x-10)+","+(mInfo.y-10)+","+(mInfo.x +10+ mInfo.width)+","+(mInfo.y+10 + mInfo.height));
                    LtLog.e("图片坐标"+(result.x)+","+(result.y));
                    if(result.sim>0.8f){
                        result1=mFairy.findPic(result.x-123,result.y+7,result.x-36,result.y+89,"pic main difficult lock.png");
                        if(result1.sim>0.8f){
                            levelList.clear();//移除所有
                            LtLog.e(mFairy.getLineInfo("没有通关前置关卡，执行下一项"));
                            setTaskName(0);
                            return;
                        }
                    }

//                    result1=mFairy.findPic(mInfo.x+14, mInfo.y-52, mInfo.x +14+ mInfo.width, mInfo.y-52 + mInfo.height,level);381,215,440,271
                    result1=mFairy.findPic(mInfo.x+4, mInfo.y-62, mInfo.x +24+ mInfo.width, mInfo.y-42 + mInfo.height,level);
                    mFairy.onTap(0.8f,result1,result1.x-72,result1.y+113,result1.x-62,result1.y+121,"进入"+level+"关卡",1000);
                   // result= mFairy.findPic("pic main difficult 4-1-kakaluo.png");
                    LtLog.e("------------");
                    LtLog.e("范围"+(mInfo.x+4)+","+(mInfo.y-62)+","+(mInfo.x +24+ mInfo.width)+","+(mInfo.y-42 + mInfo.height));
                    LtLog.e("图片坐标"+(result.x)+","+(result.y));
                    //没有找到下一页
                    if(result.sim<0.8f&&result1.sim<0.8f){
                        int currentFloor=0;
                        for (int i=1;i<=10;i++){
                            result=mFairy.findPic("word main difficult level "+i+".png");
                            if(result.sim>0.8f)currentFloor=i;
                        }

                        if(currentFloor!=0){
                            LtLog.e(mFairy.getLineInfo("当前楼层="+currentFloor));
                            if(currentFloor>goalFloor)mFairy.onTap(35,355,45,368,"向左翻一页",1500);
                            else if(currentFloor<goalFloor) mFairy.onTap(1233,353,1242,364,"向右翻一页",1500);
                        }
                    }
                }

                //挑战界面
                result=mFairy.findPic("word btn saodang use.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("挑战选择界面");

                    //剩余0次数 不回复次数
                    result=mFairy.findPic("word main difficult zero.png");
                    if(result.sim>0.8f&&!rebuild){
                        //剩余次数已达上限
                        LtLog.e(mFairy.getLineInfo("剩余挑战次数0，执行下一项"));
                        mFairy.onTap(886,600,893,609,"返回地图界面",2000);
                        levelList.remove(0);
                        fail=0;
                        setTaskName(0);
                        return;
                    }

                    int colorNum=mFairy.getColorNum(1031,583,1210,628,0.95f,0,"49,93,173");
                    if(colorNum>4000){
                        //恢复次数已达上限
                        LtLog.e(mFairy.getLineInfo("回复已达上限，执行下一项"));
                        mFairy.onTap(886,600,893,609,"返回地图界面",2000);
                        levelList.remove(0);
                        fail=0;
                        setTaskName(0);
                        return;
                    }

                    //connect会挡住星，识别误判
                    result=mFairy.findMultiColor(1000,45,1128,50,0.95f,"93,57,15",
                            "-14|7|93,65,24&2|7|93,57,15&19|7|101,69,31&-11|19|93,57,15&3|19|93,57,15&16|19|93,57,15&-15|32|93,57,15&2|32|93,57,15&20|32|93,57,15");
                    if(result.sim>0.9) return;

                    result=mFairy.findPic("word saodang num zero.png");//扫荡卷0张
                    mFairy.onTap(0.9f,result,1117,604,1126,611,"扫荡卷不足，执行挑战",2000);
                    if(result.sim>0.9f)return;

                    result1=mFairy.findPic(1163,27,1208,74,"pic challenge three star.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(1004,439,1009,444,"扫荡 使用一次",1000);
                    }else{
                        mFairy.onTap(1115,607,1121,613,"挑战一次",1000);
                    }
                }

                result=mFairy.findPic("word btn fight start.png");
                mFairy.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f,result,"自动战斗",1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                mFairy.onTap(0.8f,result,"下一步",1000);
                if(result.sim>0.8f)fail=0;

                result=mFairy.findPic("word btn go main line.png");
                mFairy.onTap(0.8f,result,"战斗失败，前往主线",1000);
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("失败次数="+fail));
                    if(++fail>=3){
                        LtLog.e(mFairy.getLineInfo("连续失败3次，执行下一项"));
                        levelList.remove(0);
                        fail=0;
                        setTaskName(0);
                    }
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，任务重置"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint sao dang affirm.png");
                mFairy.onTap(0.8f,result,784,488,789,495,"扫荡 确认",2000);

                result=mFairy.findPic("word saodang get reward.png");
                mFairy.onTap(0.8f,result,630,633,638,643,"扫荡结果",1000);

                //确认回复
                result=mFairy.findPic("word hint ask rebuild.png");
                mFairy.onTap(0.8f,result,783,489,789,497,"回复次数，确认回复",1000);

                //花费宝石
                result=mFairy.findPic("word hint difficult ask rebuild count.png");
                mFairy.onTap(0.8f,result,783,489,789,497,"回复次数，花费宝石",1000);

                result=mFairy.findPic(597,455,677,623,"word btn close.png");
                mFairy.onTap(0.8f,result,"关闭",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"困难关卡");
    }

    //领取奖励 公会之家,任务，礼物
    public void reward()throws Exception{
        new SingleTask(mFairy){
            int task=1;//正在执行第几项奖励领取(对应content几)
            @Override
            public void content_0() throws Exception {
                util.close("领取奖励");
                setTaskName(task);
            }

            //公会之家
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word society.png");
                mFairy.onTap(0.8f,result,"切换公会之家页面",1000);

                result=mFairy.findPic("word btn society get.png");
                if (result.sim>0.8f){
                    result=mFairy.findPic(1210,511,1240,541,"pic red tip1.png");
                    mFairy.onTap(0.8f,result,"全部领取",1000);
                    if(result.sim<0.8f){
                        LtLog.e(mFairy.getLineInfo("公会之家奖励领取完成"));
                        task++;
                        setTaskName(2);
                        return;
                    }
                }
                overtime(15,0);
            }

            //礼物
            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word hint none get.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1277,713,1278,714,"没有可收道具，任务结束",1000);
                    task++;
                    setTaskName(3);
                    return;
                }

                result=mFairy.findPic("word my.png");
                mFairy.onTap(0.8f,result,"切换我的主页",1000);

                result=mFairy.findPic("word gift.png");
                mFairy.onTap(0.8f,result,"进入礼物",1000);

                result=mFairy.findPic(1006,607,1149,660,"word btn all gather.png");
                mFairy.onTap(0.8f,result,"全部收取",2000);

                overtime(15,0);
            }

            //任务
            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word my.png");
                mFairy.onTap(0.8f,result,"切换我的主页",1000);

                result=mFairy.findPic("pic task.png");
                mFairy.onTap(0.8f,result,"进入任务",1000);

                //任务界面
                result=mFairy.findPic("word performance.png");
                if(result.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("在任务界面"));

                    result1=mFairy.findPic(1184,2,1207,38,"pic task reward tip.png");
                    mFairy.onTap(0.8f,result1,"普通",1000);
                    mFairy.onTap(0.8f,result1,1123,581,1131,589,"全部收取",1000);
                    if(result1.sim>0.8f)return;

                    result=mFairy.findPic(758,1,784,37,"pic task reward tip.png");
                    mFairy.onTap(0.8f,result,"切换每日",1000);
                    mFairy.onTap(0.8f,result,1123,581,1131,589,"全部收取",1000);
                    if(result.sim<0.8f&&result1.sim<0.8f){
                        LtLog.e(mFairy.getLineInfo("任务奖励领取完成"));
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word hint can gather.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("没有可以收取的，任务结束"));
                        setTaskEnd();
                        return;
                    }
                }
                overtime(15,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint hold limit.png");
                mFairy.onTap(0.8f,result,635,486,644,493,"体力持有上限",1000);
                if(result.sim>0.8f){
                    task=3;
                    setTaskName(3);
                    LtLog.e(mFairy.getLineInfo("礼物箱，道具持有上限，无法继续，转到每日任务"));
                    return;
                }

                result=mFairy.findPic("word hint all gather.png");
                mFairy.onTap(0.8f,result,634,634,642,639,"全部收取，关闭",1000);

                result=mFairy.findPic("word hint a key gather.png");
                mFairy.onTap(0.8f,result,784,632,790,638,"一键收取",1000);

                result=mFairy.findPic("word hint already gather.png");
                mFairy.onTap(0.8f,result,632,631,640,639,"收取了",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"领取奖励");
    }

    //地下城
    public void under_city()throws Exception{
        new SingleTask(mFairy){
            long daze=0;//发呆时长
            boolean failure=false;//第一次失败后撤退
            int hard=1;//选择要挑战的难度
            @Override
            public void create() throws Exception {
                hard=Integer.parseInt(AtFairyConfig.getOption("under_city hard"));
            }

            @Override
            public void content_0() throws Exception {
                daze=util.initDaze("content_0");
                util.close("地下城");
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(1092,109,1152,163, "pic lock.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("地下城没有解锁，任务结束"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f,result,"切换冒险页面",1000);

                result=mFairy.findPic(1120,218,1216,253,"word under city.png");
                mFairy.onTap(0.8f,result,"进入地下城",1000);

                if(hard==1){
                    result=mFairy.findPic(56,470,1250,553,"word under city common.png");
                    mFairy.onTap(0.8f,result,"进入普通",1000);
                }

                if(hard==2){
                    result=mFairy.findPic(56,470,1250,553,"word under city hard.png");
                    mFairy.onTap(0.8f,result,"进入困难",1000);

                    result1=mFairy.findPic(407,232,576,403,"pic main difficult lock.png");
                    if(result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("困难没有解锁，切换普通"));
                        hard=1;
                        return;
                    }
                }

                if(hard==3){
                    result=mFairy.findPic(56,470,1250,553,"word under city high hard.png");
                    mFairy.onTap(0.8f,result,"进入高难",1000);

                    result1=mFairy.findPic(709,235,872,396,"pic main difficult lock.png");
                    if(result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("高难没有解锁，切换困难"));
                        hard=2;
                        return;
                    }
                }
                if(hard==4){
                    result=mFairy.findPic(56,470,1250,553,"limit.png");//1121,515    1037,272,1177,378
                    mFairy.onTap(0.8f,result,"进入极限",1000);

                    result1=mFairy.findPic(1024,249,1182,402,"pic main difficult lock.png");
                    if(result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("极限难度没有解锁,切换高难"));
                        hard=3;
                        return;
                    }
                }
                result=mFairy.findPic("word current floor.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("在选择层数界面");
                    if(failure){
                        result=mFairy.findPic("word btn retreat.png");
                        mFairy.onTap(0.8f,result,"撤退",1000);
                    }else{
                        List<FindResult> list= mFairy.findPic(56, 260, 1099, 550, 0.85f, "word under city floor.png");
                        if(list.size()!=0){
                            LtLog.e(mFairy.getLineInfo("找到"+list.size()+"层"));
                            while(list.size()!=0){
                                result=mFairy.findPic(1074,581,1167,632,"word btn challenge.png");
                                if(result.sim>0.8f)break;
                                int index=list.size()-1;
                                result=list.get(index);
                                mFairy.onTap(0.85f,result,"选中地下城关卡"+(index+1),1000);
                                list.remove(index);
                            }
                        }
                    }
                }

                result=mFairy.findPic(1074,581,1167,632,"word btn challenge.png");
                mFairy.onTap(0.8f,result,"挑战",1000);

                result=mFairy.findPic("word btn fight start.png");
                mFairy.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f,result,"自动战斗",1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("pic btn fight auto ing.png");
                if(result.sim>0.8f)daze=util.initDaze("自动战斗中..");

                result=mFairy.findPic("word under city challenge zero.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("剩余挑战次数0次，任务结束"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word under city zhanli zero.png");
                mFairy.onTap(0.8f,result,1144,115,1151,123,"战力为0，打开我的队伍",1000);

                //我的队伍一览界面
                result=mFairy.findPic("word my team interface.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("选择合适队伍");
                    result=mFairy.findPic(968,161,1056,579,"word btn breathe out.png");
                    if(result.sim>0.9f){
                        mFairy.onTap(0.9f,result,"呼出此编组",1000);
                    }else{
                        result=mFairy.findPic("pic my team bottom.png");
                        mFairy.onTap(0.8f,result,627,632,640,644,"关闭",1000);
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("滑到底部，没有合适的队伍，任务结束"));
                            util.close("地下城");
                            setTaskEnd();
                            return;
                        }
                        LtLog.e(mFairy.getLineInfo("没有合适队伍，往下滑动"));
                        mFairy.ranSwipe(920,500,920,200,1000,1500l,0);
                    }
                }

                result=mFairy.findPic("pic failed.png");
                mFairy.onTap(0.8f,result,1078,654,1087,661,"战斗失败，前往地下城",1000);
                if(result.sim>0.8f){
                    failure=true;
                    return;
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint retreat affirm.png");
                mFairy.onTap(0.8f,result,775,488,785,497,"撤退确认",1000);

                result=mFairy.findPic("word hint already gather.png");
                mFairy.onTap(0.8f,result,632,631,640,639,"收取了",1000);

                result=mFairy.findPic("word hint area select.png");
                mFairy.onTap(0.8f,result,781,492,788,497,"区域选择ok",1000);

                result=mFairy.findPic("word my team interface.png");
                if(result.sim>0.8f)return;
                super.inOperation();
            }
        }.taskContent(mFairy,"地下城");
    }

    //团队战
    public void team_battle()throws Exception{
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                daze=util.initDaze("content_0");
                util.close("团队战");
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word risk.png");
                mFairy.onTap(0.8f,result,"切换冒险页面",1000);

                result=mFairy.findPic("word team battle.png");
                mFairy.onTap(0.8f,result,"进入团队战",1000);

                result=mFairy.findPic(1079,278,1154,346, "pic lock.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("团队战没有开启，任务结束"));
                    setTaskEnd();
                    return;
                }

                //团队战界面
                result=mFairy.findPic("word team battle interface.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("团队战界面");
                    //未开启
                    result=mFairy.findPic("word team battle info.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word team battle already over.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(42,39,51,49,"举办时间已结束，任务结束",1000);
                            setTaskEnd();
                            return;
                        }

                    }

                    //挑战次数
                    result=mFairy.findPic(new String[]{"word team battle zero.png","word team battle upper limit.png"});
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("挑战次数为0/已经达到上限，任务结束"));
                        mFairy.onTap(42,36,49,45,"返回",1000);
                        setTaskEnd();
                        return;
                    }else{
                        result=mFairy.findPic(86,22,1224,320,"pic team battle guide.png");
                        mFairy.onTap(0.8f,result,result.x-8,result.y+110,result.x+3,result.y+118,"选中boss",1000);
                    }
                }

                result=mFairy.findPic(1058,582,1162,642,"word btn challenge.png");
                mFairy.onTap(0.8f,result,"挑战",1000);

                result=mFairy.findPic("word btn fight start.png");
                util.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f,result,"自动战斗",1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic(1019,644,1136,703,"word btn next.png");
                util.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word team battle zhanli zero.png");
                mFairy.onTap(0.8f,result,1144,115,1151,123,"战力为0，打开我的队伍",1000);

                result = mFairy.findPic("pic btn fight auto ing.png");
                if (result.sim > 0.8f) daze = util.initDaze("自动战斗中..");

                //我的队伍一览界面
                result=mFairy.findPic("word my team interface.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("选择合适队伍");
                    result=mFairy.findPic(968,161,1056,579,"word btn breathe out.png");
                    if(result.sim>0.9f){
                        mFairy.onTap(0.9f,result,"呼出此编组",1000);
                    }else{
                        result=mFairy.findPic("pic my team bottom.png");
                        mFairy.onTap(0.8f,result,627,632,640,644,"关闭",1000);
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("滑到底部，没有合适的队伍，任务结束"));
                            util.close("地下城");
                            setTaskEnd();
                            return;
                        }
                        LtLog.e(mFairy.getLineInfo("没有合适队伍，往下滑动"));
                        mFairy.ranSwipe(920,500,920,200,1000,1500l,0);
                    }
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重置任务。"));
                    setTaskName(0);
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint ranking publish.png");
                mFairy.onTap(0.8f,result,"关闭排名公布",1000);

                result=mFairy.findPic("word btn battle.png");
                mFairy.onTap(0.8f,result,"确认团队战开始",1000);

                result=mFairy.findPic("word hint join guild.png");
                mFairy.onTap(0.8f,result,477,488,488,497,"取消加入行会",1000);
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("没有加入行会，无法参加团队战，任务结束"));
                    setTaskEnd();
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"团队战");
    }

    //角色强化
    public void strong()throws Exception{
        new SingleTask(mFairy){
            Integer strongNum=0;
            int index=1;//强化第几个人物
            String sortType="dengji";//按照什么排序
            boolean equipGet=false,rankStrong=false;//是否获取装备，是否rank升级
            long daze=0;
            @Override
            public void create() throws Exception {
                //初始化参数
                energy_rebuild=false;
                rebuild_num=0;
                //体力回复
                if(AtFairyConfig.getOption("energy_rebuild").equals("1")){
                    energy_rebuild=true;
                }

                //体力回复次数
                if(!AtFairyConfig.getOption("rebuild_num").equals("")){
                    ControlSplit split = strSplit(AtFairyConfig.getOption("rebuild_num"));
                    if(split.choice==1){
                        energy_rebuild=true;
                        rebuild_num=split.count;
                    }
                }

                //强化人数
                if(!AtFairyConfig.getOption("strongNum").equals("")){
                    strongNum= strSplit(AtFairyConfig.getOption("strongNum")).count;
                }

                //装备获取
                if(AtFairyConfig.getOption("equipGet").equals("1")){
                    equipGet=true;
                }

                //rank升级
                if(AtFairyConfig.getOption("rankStrong").equals("1")){
                    rankStrong=true;
                }

                //分类排行
                if(!AtFairyConfig.getOption("sortType").equals("")){
                    sortType=AtFairyConfig.getOption("sortType");
                }
            }

            @Override
            public void content_0() throws Exception {
                util.close("角色强化");
                setTaskName(1);
            }

            //自动强化
            @Override
            public void content_1() throws Exception {
                daze=util.initDaze();
                overtime(25,0);
                result=mFairy.findPic("word role.png");
                mFairy.onTap(0.8f,result,"切换角色页面",1000);

                //角色一览界面
                result=mFairy.findPic("word btn my team.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("角色一览界面"));
                    err=0;
                    result=mFairy.findPic("word strong sort " +sortType+".png");
                    if(result.sim<0.8f){
                        mFairy.onTap(901,34,907,42,"打开分类页面",1000);
                        return;
                    }

                    result=mFairy.findPic("word strong sort up.png");
                    mFairy.onTap(0.8f,result,"改为降序",1000);

                    result=mFairy.findPic(new String[]{"word strong sort down.png","word strong sort down1.png"});
                    mFairy.onTap(0.8f,result,216,183,225,192,"进入第1个角色",1000);
                    if(result.sim>0.8f)index=1;
                }


                //角色详情界面
                result=mFairy.findPic("word btn auto strong.png");
                int picCount=picCount(0.8f,result,"角色详情界面1");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("角色详情界面1"));
                    err=0;
                    result1=mFairy.findPic(559,541,583,564,"pic red tip1.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result,"自动强化",2000);
                        return;
                    }else{
                        if(picCount>=4){
                            LtLog.e(mFairy.getLineInfo("自动强化完成"));
                            setTaskName(2);
                            return;
                        }
                    }
                }
            }

            Integer equipIndex=0;//强化第几个装备
            //获取装备
            @Override
            public void content_2() throws Exception{
                //不获取装备
                if(!equipGet){
                    setTaskName(3);
                    return;
                }
                //角色详情界面
                result=mFairy.findPic("word btn auto strong.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("角色详情界面");
                    List<FindResult> list=mFairy.findPic(126,202,587,473,0.8f,"word strong can get.png");
                    if(list.size()!=0){
                        if(equipIndex>=list.size()){
                            setTaskName(3);
                            LtLog.e(mFairy.getLineInfo("没有可以扫荡获取的装备了"));
                            return;
                        }
                        result=list.get(equipIndex);
                        mFairy.onTap(0.8f,result,"切换可获得装备",1500);
                        mFairy.onTap(0.8f,result,773,579,782,588,"获取方法",1000);
                        setTaskName(2);
                    }
                    if(list.size()==0){
                        LtLog.e(mFairy.getLineInfo("没有可以获取的装备"));
                        result=mFairy.findPic(163,608,245,659,"word btn cancel.png");
                        mFairy.onTap(0.8f,result,"取消",1000);
                        setTaskName(3);
                        return;
                    }
                }

                //装备获取界面
                result=mFairy.findPic("word equip get interface.png");
                int picCount=picCount(0.8f,result,"equip get interface");
                if(result.sim>0.8f){
                    daze=util.initDaze("装备获取界面");
                    if(picCount<2){
                        mFairy.onTap(0.8f,result,727,133,735,143,"切换第一件装备",1000);
                        return;
                    }

                    result=mFairy.findPic("pic equip first.png");
                    result1=mFairy.findMultiColor(374,237,412,265,0.9f,
                            "58,65,82","5|0|66,65,82&0|5|58,65,82&6|5|58,65,82&21|-5|58,65,74&21|-1|58,65,74&21|3|58,65,74&21|8|66,65,82");
                    int colorNum=mFairy.getColorNum(349,232,414,266,0.95f,0,"58,65,74");
                    if(result.sim>0.8f&&colorNum>50){
                        mFairy.onTap(0.8f,result,200,631,209,640,"获得完成，取消返回",1000);
                        setTaskName(1);
                        return;
                    }

                    result=mFairy.findMultiColor(732,474,1180,513,0.95f,"181,121,132",
                            "0|1|181,117,123&0|3|173,109,123&-1|4|173,109,123&-1|5|173,109,132&-1|6|173,105,123&-2|7|173,101,123&-2|8|173,101,123&-2|9|173,105,132&-3|10|164,93,123");
                    mFairy.onTap(0.9f,result,"点击进入",1000);

                    result=mFairy.findPic("word btn equip make HLS.png");
                    mFairy.onTap(0.9f,result,"制作",3000);
                    mFairy.onTap(0.9f,result,722,131,731,142,"切第一件装备",1000);

                    //装备获取位置
                    result=mFairy.findPic("pic equip get mana.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic(695,179,769,201,"pic equip one down.png");//只有一件装备的情况
                        result1=mFairy.findMultiColor(354,236,390,264,0.95f,"57,65,82",
                                "-4|-4|57,65,82&-3|-3|57,65,82&3|-3|57,65,82&2|-2|57,65,82&-2|2|57,65,82&-3|3|57,65,82&-4|4|57,65,82&2|2|57,65,82&3|3|57,65,82");
                        if(result.sim>0.8f&&result1.sim>0.9f){
                            mFairy.onTap(192,631,203,639,"一级装备，数量够了",1000);
                        }

                        List<FindResult> list=mFairy.findPic(1132,240,1171,575,0.85f,"pic equip star.png");
                        if(list.size()!=0)result=list.get(list.size()-1);
                        else {
                            result=mFairy.findPic(new String[]{"pic equip get bottom.png","pic equip get bottom1.png"});
                            if(result.sim>0.8f){
                                //(三星数==0)没有可以扫荡的
                                mFairy.onTap(195,632,204,640,"取消",1000);
                                LtLog.e(mFairy.getLineInfo("没有可以扫荡的"));
                                equipIndex++;
                                return;
                            }
                            LtLog.e(mFairy.getLineInfo("没有可以获取的装备，往下滑动"));
                            mFairy.ranSwipe(1108,512,1108,250,1000,1500l,0);
                        }
                        mFairy.onTap(0.8f,result,"选择关卡",1000);
                    }
                }

                //扫荡获得报酬
                result=mFairy.findPic("word saodang get reward.png");
                if(result.sim>0.8f){
                    daze=util.initDaze("扫荡结果");
                    mFairy.sleep(1500);
                    //扫荡结果的 '/'
                    result=mFairy.findMultiColor(905,140,945,167,0.9f,"209,210,209",
                            "-1|1|232,232,232&-1|3|216,217,216&-2|5|232,232,232&-3|6|178,183,185&-3|7|224,224,224&-3|9|216,220,224&-4|10|209,214,216&-4|12|224,225,224&-5|13|201,201,201");
                    if(result.sim>=0.9f){
                        mFairy.onTap(630,633,638,643,"ok，数量满足，关闭扫荡",1000);
                        mFairy.onTap(924,599,935,610,"取消返回",1000);
                    }else{
                        mFairy.onTap(630,633,638,643,"ok，数量不足，继续扫荡",1000);
                    }
                    return;
                }

                result=mFairy.findPic("word saodang num zero.png");
                mFairy.onTap(0.9f,result,1117,604,1126,611,"扫荡卷不足，执行挑战",2000);

                result=mFairy.findPic("word btn fight start.png");
                mFairy.onTap(0.8f,result,"战斗开始",1000);

                result=mFairy.findPic(1057,627,1157,713,"word btn next.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("pic btn fight auto.png");
                mFairy.onTap(0.8f,result,"自动战斗",1000);

                result=mFairy.findPic("pic btn fight speed.png");
                mFairy.onTap(0.8f,result,"战斗加速",1000);

                result=mFairy.findPic("word btn saodang use.png");
                mFairy.onTap(0.8f,result,"扫荡 使用一次",1000);

                result=mFairy.findPic("word hint sao dang affirm.png");
                mFairy.onTap(0.8f,result,784,488,789,495,"扫荡 确认",2000);

                if(daze>30){
                    setTaskName(0);
                    LtLog.e(mFairy.getLineInfo("获取装备超时，重置任务"));
                    return;
                }
            }

            @Override
            public  void content_3()throws Exception{
                daze=util.initDaze();
                overtime(20,0);
                //角色详情界面
                result=mFairy.findPic("word btn auto strong.png");
                result1=mFairy.findPic(new String[]{"word equip.png","word come on stage.png"});
                int picCount=picCount(0.8f,result,"角色强化界面3");
                if(result.sim>0.8f&&result1.sim>0.8f){
                    err=0;
                    LtLog.e(mFairy.getLineInfo("角色强化界面3"));
                    result=mFairy.findPic(559,541,583,564,"pic red tip1.png");
                    if(result.sim>0.8f){setTaskName(1);return;}

                    if(rankStrong){
                        result=mFairy.findPic("word btn rank up.png");
                        mFairy.onTap(0.8f,result,"rank升级",2000);
                        if(result.sim>0.8f){setTaskName(1);return;}
                    }

                    if(picCount>=4){
                        equipIndex=0;
                        mFairy.onTap(1254,354,1265,369,"第"+index+"个强化完成，强化下一个",3000);
                        if(++index>strongNum){
                            LtLog.e(mFairy.getLineInfo("强化"+strongNum+"个完成，任务结束 "));
                            setTaskEnd();
                            return;
                        }
                        setTaskName(1);
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result=mFairy.findPic("word hint sort.png");
                if(result.sim>0.8f){
                    if(sortType.equals("dengji"))mFairy.onTap(0.8f,result,88,184,97,193,"选择等级",1000);
                    if(sortType.equals("zhanli"))mFairy.onTap(0.8f,result,383,185,392,192,"选择战力",1000);
                    if(sortType.equals("rank"))mFairy.onTap(0.8f,result,673,182,684,192,"选择rank",1000);
                    if(sortType.equals("xing"))mFairy.onTap(0.8f,result,968,182,976,191,"选择星数",1000);
                    mFairy.onTap(0.8f,result,778,633,787,643,"ok",1000);
                }

                result=mFairy.findPic(597,455,677,655,"word btn close.png");
                mFairy.onTap(0.8f,result,"关闭",1000);

                result=mFairy.findPic("word hint rank level.png");
                mFairy.onTap(0.8f,result,772,482,795,502,"rank等级提升确认",5000);

                result=mFairy.findPic(new String[]{"word hint auto strong.png","word hint rank up affirm.png"});
                mFairy.onTap(0.8f,result,777,633,785,640,"确认自动强化",2000);

                result=mFairy.findPic("word hint rank up.png");
                mFairy.onTap(0.8f,result,632,488,641,497,"rank提升完毕",3000);

                super.inOperation();
            }
        }.taskContent(mFairy,"角色强化");
    }

    @Override
    public void inOperation() throws Exception {
        result=mFairy.findPic("word hint level up.png");
        mFairy.onTap(0.8f,result,632,488,640,495,"等级提升完毕",1000);

        result=mFairy.findPic("word hint challenge team.png");
        mFairy.onTap(0.8f,result,482,574,490,581,"取消挑战团队战",1000);

        //体力不足 是否回复
        result=mFairy.findPic("word hint tili none.png");
        int picCount=picCount(0.8f,result,"tili none");
        if(result.sim>0.8f){
            if(energy_rebuild){
                if(picCount==1){
                    if(rebuild_num<=0){
                        LtLog.e(mFairy.getLineInfo("体力回复次数为0，不使用宝石"));
                        energy_rebuild=false;
                        return;
                    }
                    rebuild_num--;
                }
                mFairy.onTap(782,487,788,495,"回复体力，剩余次数"+rebuild_num,1000);
            }else{
                mFairy.onTap(486,488,494,497,"回复体力，取消",1000);
                util.close("体力不足");
                LtLog.e(mFairy.getLineInfo("体力不足，无法继续任务"));
                setTaskName(10);
                setTaskEnd();
                return;
            }
        }

        //花费宝石界面
        result=mFairy.findPic("word hint ask rebuild energy.png");
        mFairy.onTap(0.8f,result,782,487,788,495,"回复体力，花费宝石",1500);

        result=mFairy.findPic("word buy gem.png");
        mFairy.onTap(0.8f,result,630,631,639,639,"购买宝石，关闭",1000);
        if(result.sim>0.8f){
            LtLog.e(mFairy.getLineInfo("宝石不足，无法继续任务"));
            setTaskName(10);
            setTaskEnd();
            return;
        }

        result=mFairy.findPic("word hint buy gem.png");
        mFairy.onTap(0.8f,result,627,634,636,641,"关闭购买宝石",1000);
        if(result.sim>0.8f){
            LtLog.e(mFairy.getLineInfo("宝石不足，执行下一项任务"));
            util.close("购买宝石1");
            util.close("购买宝石2");
            setTaskName(10);
            setTaskEnd();
            return;
        }

        result=mFairy.findPic("word hint saodang result.png");
        if(result.sim>0.8f)return;

        result=mFairy.findPic(595,460,686,682,new String[]{"word btn ok.png","word btn ok1.png"});
        mFairy.onTap(0.8f,result,"ok",1000);

        result=mFairy.findPic(449,460,533,614,"word btn cancel.png");
        mFairy.onTap(0.8f,result,"取消",1000);

        result=mFairy.findPic("word my team interface.png");
        if(result.sim>0.8f)return;
        result=mFairy.findPic(596,585,675,671,"word btn close.png");
        mFairy.onTap(0.8f,result,"关闭",1000);
    }

    public void test()throws Exception{
        while(mFairy.condit()){
            mFairy.sleep(1000);
            LtLog.e(mFairy.getLineInfo("\n\ntest while..........."));
            result=mFairy.findPic("pic equip get bottom.png");
            LtLog.e(mFairy.getLineInfo("0 result="+result.toString()));

            result=mFairy.findPic("pic equip get bottom1.png");
            LtLog.e(mFairy.getLineInfo("1 result="+result.toString()));
        }
    }
}
