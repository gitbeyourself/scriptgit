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
    Util util;
    List taskList=null;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        util = new Util(mFairy);
    }
    public void setTaskName(int taskContentNum) throws Exception {
        super.setTaskName(taskContentNum);
        mFairy.condit();
    }
    boolean tap=true;
    //新手指引
    public void novice ()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void create() throws Exception {
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
                util.initDaze();
                return;
            }
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic(new String []{"word btn dress.png","word btn dress1.png"});
                mFairy.onTap(0.8f,result,"梳妆",1000);

                result=mFairy.findPic("pic random.png");
                mFairy.onTap(0.8f,result,"随机名字",1000);
                mFairy.onTap(0.8f,result,1098,658,1112,674,"进入游戏",1000);

                result=mFairy.findPic(625,470,655,527,"word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic("word thread1.png");
                    mFairy.onTap(0.8f,result,585,219,599,236,"线索2",1000);

                    result=mFairy.findPic("word thread.png");
                    mFairy.onTap(0.8f,result,483,319,502,339,"线索2",1000);

                    result=mFairy.findPic("word draw.png");
                    mFairy.onTap(0.8f,result,"画一笔",1000);

                    result=mFairy.findPic(496,506,701,555,"word shangzhen.png");
                    mFairy.onTap(0.8f,result,835,546,845,556,"前往上阵",1000);

                    result=mFairy.findPic("word btn go.png");
                    mFairy.onTap(0.8f,result,"上阵 前往",1000);

                    result=mFairy.findPic("word guid btn go.png");
                    mFairy.onTap(0.8f,result,"前往",1000);

                    result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                    mFairy.onTap(0.8f,result,"事件按钮",1000);

                    result=mFairy.findPic(311,407,362,495,"pic guide clothing.png");
                    mFairy.onTap(0.8f,result,461,470,467,479,"选择一套衣服",1000);

                    result=mFairy.findPic(new String[]{"word clothing lingbo.png","word clothing yelan.png"});
                    mFairy.onTap(0.8f,result,"选择一套衣服",1000);

                    result=mFairy.findPic("word btn yitao.png");
                    mFairy.onTap(0.8f,result,"就穿这一套",1000);


                    result=mFairy.findPic("word one.png");
                    mFairy.onTap(0.8f,result,"单次招募",1000);

                    result=mFairy.findPic("pic ranswip.png");//拉动
                    if(result.sim>0.8f){
                        mFairy.ranSwipe(result.x,result.y,826,625,500,1000l,0);
                        LtLog.e(mFairy.getLineInfo("向下拉动"));
                    }


                    //随从布阵
                    result=mFairy.findPic("word suicong.png");
                    if(result.sim>0.8f){
                        mFairy.ranSwipe(194,307,1100,465,1000,1500l,0);
                        mFairy.ranSwipe(321,436,787,516,1000,1500l,0);
                        mFairy.onTap(0.8f,result,1223,33,1230,38,"返回",1000);
                        LtLog.e(mFairy.getLineInfo("选择随从位置"));
                    }

                    result=mFairy.findPic("word btn setting.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(1245,443,1279,507,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.76f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入浮生阁-手指引",1000);

                        result=mFairy.findPic(1251,306,1280,363,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.76f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入浮生阁-手指引",1000);

                        result=mFairy.findPic(1250,370,1280,436,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入时装-手指引",1000);

                        result=mFairy.findPic(1174,377,1215,434,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入时装1-手指引",1000);

                        result=mFairy.findPic(1172,520,1212,580,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入世家-手指引",1000);

                        result=mFairy.findPic(1175,593,1222,660,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入好友-手指引",1000);
                    }

                    result=mFairy.findPic(1182,690,1233,718,new String[]{"pic hand.png","pic hand1.png"});
                    mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入背包-手指引",1000);

                    result=mFairy.findPic(936,56,983,98,new String[]{"pic hand.png","pic hand1.png"});
                    mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入日常-手指引",1000);

                    result=mFairy.findPic(1006,48,1042,87,new String[]{"pic hand.png","pic hand1.png"});
                    mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"进入商城-手指引",1000);


                    result=mFairy.findPic(new String[]{"word jinsheng.png","word jinsheng1.png","word jinsheng2.png"});
                    mFairy.onTap(0.8f,result,905,31,908,36,"进入日常-指引",1000);

                    //日常界面
                    result=mFairy.findPic("word daily interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn jin.png");
                        mFairy.onTap(0.8f,result,"晋升",1000);

                        result=mFairy.findPic(1126,292,1158,342,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"切换品阶分页",1000);


                        result=mFairy.findPic("word guide xunbao.png");
//                        result=mFairy.findPic(924,334,997,384,"word daily go.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("寻宝开启，任务结束"));
                            util.close();
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("word guide jysl.png");
                        if(result.sim>0.8f){
                            single_jysl();
                            util.initDaze();
                            return;
                        }

                        result=mFairy.findPic("word guide lbsl.png");
                        if(result.sim>0.8f){
                            single_lbsl();
                            util.initDaze();
                            return;
                        }
                    }

                    result=mFairy.findPic(88,465,122,518,new String[]{"pic hand.png","pic hand1.png"});
                    mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"切换制衣分页",1000);

                    result=mFairy.findPic(671,664,698,705,new String[]{"pic hand.png","pic hand1.png"});
                    mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"开始制作",1000);

                    result=mFairy.findPic("word btn send.png");
                    mFairy.onTap(0.8f,result,"赠送礼物",1000);

                    result=mFairy.findPic(883,385,1080,424,"word dialogue ready.png");
                    mFairy.onTap(0.8f,result,"准备好了",1000);

                    result=mFairy.findPic("word any.png");
                    mFairy.onTap(0.8f,result,"点击任意区域",1000);

                    //刺绣1
                    result=mFairy.findPic("pic cixiu tip.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        LtLog.e(mFairy.getLineInfo("刺绣1"));
                        mFairy.touchDown(0,502,285);
                        mFairy.touchMove(358,324,1000);
                        mFairy.touchMove(487,421,1000);
                        mFairy.touchMove(502,285,1000);
                        mFairy.touchUp(0);
                    }

                    //刺绣2
                    result=mFairy.findPic("pic cixiu tip1.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        LtLog.e(mFairy.getLineInfo("刺绣2"));
                        mFairy.touchDown(0,778,472);
                        mFairy.touchMove(937,392,1000);
                        mFairy.touchMove(864,549,1000);
                        mFairy.touchMove(826,365,1000);
                        mFairy.touchMove(964,507,1000);
                        mFairy.touchMove(778,472,1000);
                        mFairy.touchUp(0);
                    }

                    //赠送礼物界面
                    result=mFairy.findPic("word send interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(1089,637,1127,680,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"赠送礼物 赠送礼物",1000);

                        result=mFairy.findPic("pic corner.png");
                        mFairy.onTap(0.8f,result,result.x+51,result.y+69,result.x+52,result.y+70,"赠送礼物 切换互动分页",1000);
                        mFairy.onTap(0.8f,result,1223,27,1235,38,"赠送礼物 返回",1000);
                    }


                    result=mFairy.findPic("word backage interface.png");
                    mFairy.onTap(0.8f,result,981,90,990,98,"进入礼物界面",1000);

                    result=mFairy.findPic("word gift interface.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,705,604,712,614,"赠送",1000);

                        result=mFairy.findPic("word affirm.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"赠送完成",1000);
                            util.close();
                            util.initDaze();
                        }
                    }


                    result=mFairy.findPic("word btn again.png");
                    mFairy.onTap(0.8f,result,"再来一次",1000);

                    result=mFairy.findPic("word btn lingzhi.png");
                    mFairy.onTap(0.8f,result,"领旨",1000);

                    result=mFairy.findPic("word btn jihuo.png");
                    mFairy.onTap(0.8f,result,"前往激活",1000);

                    result=mFairy.findPic(402,631,494,690,"word affirm.png");
                    mFairy.onTap(0.8f,result,"获得新随从",1000);

                    //称号界面
                    result=mFairy.findPic("word chenghao interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn jihuo1.png");
                        mFairy.onTap(0.8f,result,"激活",1000);
                        mFairy.onTap(1110,74,1129,89,"关闭称号界面",1000);
                    }

                    result=mFairy.findPic("word friend interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word friend recommend interface.png");
                        if(result.sim>0.8f){
                            List<FindResult> pic = mFairy.findPic(395, 177, 471, 587, 0.8f, "pic friend add.png");
                            if(pic.size()!=0){
                                int num=pic.size();
                                for (int i=0;i<=num-1;i++){
                                    mFairy.onTap(0.8f,pic.get(0),"添加",1000);
                                    pic.remove(0);
                                }
                            }else{
                                mFairy.onTap(0.8f,result,1143,84,1157,98,"关闭好友界面",1000);
                            }
                        }else{
                            mFairy.onTap(1100,272,1110,284,"切换添加好友分页",1000);
                        }
                    }

                    result=mFairy.findPic("word email.png");
                    mFairy.onTap(0.8f,result,"开启信件",2000);
                    mFairy.onTap(0.8f,result,"开启信件1",1000);

                    result=mFairy.findPic(new String[]{"word jing.png","word hint sui.png"});
                    mFairy.onTap(0.8f,result,1070,666,1077,676, "指引 进入随从",1000);

                    //随从界面
                    result=mFairy.findPic("pic position.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(184,61,234,109,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"切换第一个随从",1000);

                        //升级
                        result=mFairy.findPic("word btn upgrade.png");
                        if(result.sim>0.8f){
                            result1=mFairy.findPic(776,76,831,271,"word hint operation.png");
                            FindResult result2=mFairy.findPic(661,90,716,210,"word hint none.png");
                            if(result1.sim>0.8f||result2.sim>0.8f){
                                mFairy.onTap(871,104,879,116,"关闭升级",1000);
                            }else{
                                mFairy.onTap(0.8f,result,"升级五次",1000);
                            }
                            util.initDaze();
                            return;
                        }

                        //可升级
                        result=mFairy.findPic("pic red tip.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"打开升级",1000);
                            return;
                        }

                        //确认强化
                        result=mFairy.findPic("word hint hint.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,529,607,536,618,"不再提醒",1000);
                            mFairy.onTap(0.8f,result,778,523,782,528,"确定",1000);
                            return;
                        }

                        //一键穿戴
                        result=mFairy.findPic(992,583,1013,607,"pic red tip.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,968,617,981,627,"一键穿戴",1000);
                            return;
                        }

                        //一键强化
                        result=mFairy.findPic(1110,583,1130,607,"pic red tip.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,1085,620,1093,632,"一键强化",1000);
                            return;
                        }

                        for(int i=1;i<=4;i++){
                            result=mFairy.findPic(196+(i-1)*84,6,222+(i-1)*84,30,"pic red tip.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"切换第"+i+"个随从",1000);
                                break;
                            }
                        }
                        if(result.sim<0.8f){
                            mFairy.onTap(1226,29,1232,36,"返回",1000);
                        }
                    }

                    //答题 晋升考核
                    result=mFairy.findPic(new String[]{"word jia.png","word bing.png"});
                    if(result.sim>0.8f){
                        util.initDaze();
                        mFairy.onTap(0.8f,result,"答题 甲/丙",1000);
                        mFairy.onTap(0.8f,result,1073,664,1085,674,"确定",1000);
                    }

                    //商城界面
                    result=mFairy.findPic("word shop interface.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(1245,358,1278,437,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"商城 切换材料分页",1000);

                        result=mFairy.findPic(365,119,407,182,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"商城 切换图纸商店分页",1000);

                        result=mFairy.findPic(557,117,590,165,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"商城 切换图纸商店分页",1000);

                        result=mFairy.findPic(227,209,256,255,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"商城 选择图纸",1000);

                        result=mFairy.findPic(971,654,1005,708,new String[]{"pic hand.png","pic hand1.png"});
                        mFairy.onTap(0.8f,result,result.x-52,result.y-45,result.x-51,result.y-44,"商城 点击购买",1000);
                        mFairy.onTap(0.8f,result,1228,24,1235,33,"返回",1000);
                    }

                    result=mFairy.findMultiColor(830,504,890,534,
                            0.9f,"107,138,161","6|0|107,137,161&8|0|106,138,160&13|0|109,139,161&18|0|119,148,177&20|2|140,172,200&20|4|136,167,197&22|4|140,170,194&22|5|142,173,197&22|6|143,173,199");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic("word dialogue exit talk.png");
                        if(result1.sim>0.8f){
                            mFairy.onTap(0.8f,result1,1037,400,1044,411,"再想想",1000);
                        }else{
                            mFairy.onTap(0.8f,result,"对话选择",1000);
                        }
                    }

                    result=mFairy.findPic("word btn wear.png");
                    mFairy.onTap(0.8f,result,"前往穿戴",1000);

                    result=mFairy.findPic("word btn main get.png");
                    mFairy.onTap(0.8f,result,"领取",1000);

                    result=mFairy.findPic("word btn apply.png");
                    mFairy.onTap(0.8f,result,"一键申请",1000);
                    mFairy.onTap(0.8f,result,1145,90,1157,100,"关闭",1000);

                    result=mFairy.findPic("word btn know.png");
                    mFairy.onTap(0.8f,result,"世家 了解",1000);

                    result=mFairy.findPic("word btn restore.png");
                    mFairy.onTap(0.8f,result,1226,27,1235,38,"返回",1000);

                    result=mFairy.findPic(500,600,600,640,"word open.png");
                    mFairy.onTap(0.7f,result,"解锁对象",1000);

                    result=mFairy.findPic(new String[]{"pic gift.png","pic gift1.png"});
                    mFairy.onTap(0.8f,result,"点击领取礼物",1000);

                    result=mFairy.findPic("word go.png");
                    mFairy.onTap(0.8f,result,"前往教学任务",1000);

                    result=mFairy.findPic("word btn up.png");
                    mFairy.onTap(0.8f,result,"提升实力",1000);

                    result=mFairy.findPic("word teach.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"教学引导",2000);
                        return;
                    }


                    result=mFairy.findPic("word yuan.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"缘分任务引导",2000);
                        return;
                    }

                    result=mFairy.findPic(3,196,48,299,new String[]{"word main.png","word main1.png"});
                    mFairy.onTap(0.8f,result,"主线",2000);
                }else{
                    LtLog.e(mFairy.getLineInfo("自动寻路中"));
                }

            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                if(daze>40){
                    LtLog.e(mFairy.getLineInfo("超时，初始化"));
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
                //品阶
                if(AtFairyConfig.getOption("pinjie").equals("1")){
                    taskList.add("pinjie");
                }

                //世家任务
                if(AtFairyConfig.getOption("sjrw").equals("1")){
                    taskList.add("sjrw");
                }

                //六部试炼
                if(AtFairyConfig.getOption("lbsl").equals("1")){
                    taskList.add("lbsl");
                }

                //竞技场
                if(AtFairyConfig.getOption("jjc").equals("1")){
                    taskList.add("jjc");
                }


                //结缘送礼
                if(AtFairyConfig.getOption("jysl").equals("1")){
                    taskList.add("jysl");
                }

                //闯殿策
                if(AtFairyConfig.getOption("cdc").equals("1")){
                    taskList.add("cdc");
                }

                //议事殿
                if(AtFairyConfig.getOption("ysd").equals("1")){
                    taskList.add("ysd");
                }

                //拙政园钓鱼
                if(AtFairyConfig.getOption("zzydy").equals("1")){
                    taskList.add("zzydy");
                }

                //拙政园环任务
                if(AtFairyConfig.getOption("zzyhrw").equals("1")){
                    taskList.add("zzyhrw");
                }

                //寻宝
                if(AtFairyConfig.getOption("xunbao").equals("1")){
                    taskList.add("xunbao");
                }

                //随从传记
                if(!AtFairyConfig.getOption("scObj").equals("")&&!AtFairyConfig.getOption("scObj").equals("0")){
                    taskList.add("sczj");
                }

                //王城漫步
                if(!AtFairyConfig.getOption("wcLevel").equals("")&&!AtFairyConfig.getOption("wcLevel").equals("0")){
                    taskList.add("wcmb");
                }

                //精英试炼
                if(AtFairyConfig.getOption("5989").equals("1")){
                    taskList.add("jysl");
                }
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务做完，没有任务了"));
                    setTaskEnd();
                    return;
                }
                //品阶
                if(taskList.get(0).equals("pinjie")){
                    single_pinjie();
                    taskList.remove(0);
                    return;
                }

                //世家任务
                if(taskList.get(0).equals("sjrw")){
                    single_sjrw();
                    taskList.remove(0);
                    return;
                }

                //六部试炼
                if(taskList.get(0).equals("lbsl")){
                    single_lbsl();
                    taskList.remove(0);
                    return;
                }

                //竞技场
                if(taskList.get(0).equals("jjc")){
                    single_jjc();
                    taskList.remove(0);
                    return;
                }

                //结缘送礼
                if(taskList.get(0).equals("jysl")){
                    single_jysl();
                    taskList.remove(0);
                    return;
                }

                //议事殿
                if(taskList.get(0).equals("ysd")){
                    single_ysd();
                    taskList.remove(0);
                    return;
                }

                //闯殿策
                if(taskList.get(0).equals("cdc")){
                    single_cdc();
                    taskList.remove(0);
                    return;
                }

                //随从传记
                if(taskList.get(0).equals("sczj")){
                    single_sczj();
                    taskList.remove(0);
                    return;
                }

                //拙政园 钓鱼
                if(taskList.get(0).equals("zzyhrw")){
                    single_zzyhrw();
                    taskList.remove(0);
                    return;
                }

                //拙政园 钓鱼
                if(taskList.get(0).equals("zzydy")){
                    single_zzydy();
                    taskList.remove(0);
                    return;
                }

                //寻宝
                if(taskList.get(0).equals("xunbao")){
                    single_xunbao();
                    taskList.remove(0);
                    return;
                }

                //王城漫步
                if(taskList.get(0).equals("wcmb")){
                    single_wcmb();
                    taskList.remove(0);
                    return;
                }

                //精英试炼
                if(taskList.get(0).equals("jysl")){
                    new TeamTask(mFairy).jysl();;
                    taskList.remove(0);
                    return;
                }
            }
        }.taskContent(mFairy,"单人日常");
    }

    //寻宝
    public void single_xunbao()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                setTaskName(2);
                util.initDaze();
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily xb.png",2);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                result=mFairy.findPic("word xunbao interface.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word xunbao zero.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,955,158,963,168,"没有藏宝图了，任务结束",1000);
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f,result,422,298,430,306,"地图前往寻宝",1000);
                }

                result=mFairy.findPic(555,69,614,206,"word hint already full.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,957,159,963,168,"背包已满，无法继续,任务结束",1000);
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word qi.png");
                mFairy.onTap(0.8f,result,1117,78,1131,91,"关闭奇遇",1000);

                result=mFairy.findPic("word treasure map.png");
                mFairy.onTap(0.8f,result,1043,556,1052,567,"使用藏宝图",1000);

                if(daze>12){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"寻宝");
    }

    //品阶任务
    public void single_pinjie()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            int currentIndex=0,picCount=0;
            boolean abandon=false;
            List<String> taskList;
            List<Integer> abandonList=new ArrayList();
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                abandon=false;
                return;
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result=mFairy.findPic("word pinjie interface.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("品阶界面，跳转到3"));
                    setTaskName(3);
                    return;
                }

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(3,244,50,442,"word task pinjie.png");
                mFairy.onTap(0.8f,result,"品阶指引",Sleep);
                if (result.sim>0.8f){
                    util.initDaze();
                    setTaskName(3);
                    return;
                }
                /**
                    1.initSlidCount初始化滑动次数
                 */
                mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 4, 125,400,125,320, 1000, 1500,1);
            }
            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily pjrw.png",1);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word pinjie qin.png");
                if(result.sim>0.8f){
                    util.initDaze();
                    result=mFairy.findPic(34,395,1264,450,"pic qin tap1.png");
                    mFairy.onTap(0.8f,result,result.x,495,result.x+1,496,"品阶-弹琴",100);
                    return;
                }

                result=mFairy.findPic("pic fashion interface.png");
                if(result.sim>0.8f)util.initDaze();


                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                result=mFairy.findPic("pic huaquan.png");
                mFairy.onTap(0.8f,result,"划拳",1000);

                result= mFairy.findPic("word btn submit.png");
                mFairy.onTap(0.8f,result,"提交",1000);

                result=mFairy.findPic("word btn receive.png");
                mFairy.onTap(0.8f,result,"接取任务",1000);

                result=mFairy.findPic("word btn talk.png");
                mFairy.onTap(0.8f,result,"交谈",1000);

                result=mFairy.findPic("pic camera.png");
                mFairy.onTap(0.8f,result,1132,346,1137,353,"拍照",2000);
                mFairy.onTap(0.8f,result,1214,46,1224,57,"关闭图片分享",1000);

                if(daze>5){
                    result=mFairy.findPic(227,239,275,443,"word pinjie jiaofu.png");
                    mFairy.onTap(0.8f,result,"交付",1000);

                    result=mFairy.findPic(3,244,50,442,"word task pinjie.png");
                    mFairy.onTap(0.8f,result,"品阶指引",Sleep);
                }

                //需要放弃，放弃后不能再接这个任务
                result=mFairy.findPic("word btn exit.png");
                if(result.sim>0.8f){
                    if(!abandonList.contains(currentIndex)){
                        abandonList.add(currentIndex);
                    }
                    mFairy.onTap(0.8f,result,"退出关卡",1000);
                    abandon=true;//放弃该任务
                    setTaskName(2);
                    return;
                }

                //品阶界面
                result=mFairy.findPic("word pinjie interface.png");
                picCount = picCount(0.8f, result, "pinjie");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn pinjie jiaofu.png");
                    mFairy.onTap(0.8f,result,"交付任务",1000);

                    //先选择任务
                    taskList=new ArrayList();
                    int index=0;
                    //可执行任务数量 i横 n竖
                    for(int i=1;i<=3;i++){
                        for(int n=1;n<=3;n++){
                            index++;
                            result=mFairy.findPic(209+(n-1)*184,203+(i-1)*162,252+(n-1)*184,246+(i-1)*162,"word pinjie finish.png");
                            if(result.sim<0.8f){
                                taskList.add(index+":"+i+":"+n);
                            }
                        }
                    }
                    int size=taskList.size();
                    if(size!=0){
                        for(int count=3;count>0;count--){
                            if(size==0){
                                LtLog.e(mFairy.getLineInfo("没有可以执行的任务了，结束任务"));
                                setTaskEnd();
                                return;
                            }
                            String taskInfo=taskList.get(0);
                            index=Integer.parseInt(taskInfo.split(":")[0]);
                            int i=Integer.parseInt(taskInfo.split(":")[1]);//横
                            int n=Integer.parseInt(taskInfo.split(":")[2]);//竖
                            if(abandonList.contains(index)){
                                taskList.remove(0);
                                continue;
                            }

                            //已完成 寻找任务
                            if(abandon){
                                result=mFairy.findPic("word btn give up.png");
                                if(result.sim>0.8f){
                                    mFairy.onTap(0.8f,result,"放弃任务",1000);
                                    abandon=false;
                                    return;
                                }
                            }

                            currentIndex=index;
                            mFairy.onTap(209+(n-1)*184,203+(i-1)*162,252+(n-1)*184,246+(i-1)*162,"点击"+index+"个任务",1000);
                            break;
                        }
                    }
                }

                result=mFairy.findPic("word btn pinjie buy.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1146,88,1154,97,"接取6次 品阶任务完成，任务结束",1000);
                    setTaskEnd();
                    return;
                }

                //已完成 寻找任务
                if(abandon){
                    result=mFairy.findPic("word btn give up.png");
                    int picCount=picCount(0.8f,result,"give up");
                    if(picCount==1){
                        mFairy.onTap(0.8f,result,"放弃任务",1000);
                        abandon=false;
                        return;
                    }
                }
                result=mFairy.findPic(1030,603,1102,651,"word btn task.png");
                mFairy.onTap(0.8f,result,"接取/继续/交付/重置任务",1000);

                result=mFairy.findPic("word btn get.png");
                mFairy.onTap(0.8f,result,"获取任务",1000);

                if(daze>20){
                    util.initDaze();
                    setTaskName(0);
                    LtLog.e(mFairy.getLineInfo("品阶任务超时，重启任务"));
                    return;
                }
            }


            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn affirm reset.png");
                mFairy.onTap(0.8f,result,"确认重置任务",1000);

                result=mFairy.findPic("word pinjie guide.png");
                mFairy.onTap(0.8f,result,960,698,966,702,"跳过引导",1000);

                daze=util.dazeTime();
                super.inOperation();
                result=mFairy.findPic(601,450,677,628,"word hint affirm.png");
                mFairy.onTap(0.8f,result,"确认",1000);
            }
        }.taskContent(mFairy,"品阶任务");
    }

    //六部试炼
    public void single_lbsl()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            boolean speed_up=true;
            @Override
            public void content_0() throws Exception {
                daze=0;
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily lbsl.png",1);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn enter.png");
                mFairy.onTap(0.8f,result,"立即进入",1000);

                result=mFairy.findPic(625,470,655,527,"word way.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(new String[]{"word teach1.png","word teach.png"});
                    mFairy.onTap(0.8f,result,"教程指引",1000);

                    result=mFairy.findPic("pic dialogue select.png");
                    if(result.sim>0.85f){
                        util.initDaze();
                        List<FindResult> list=mFairy.findPic(830,200,890,540,0.77f,"pic dialogue select.png");
                        int size=list.size();
                        if(size!=0){
                            if(size==1){
                                result=list.get(0);
                                mFairy.onTap(0.77f,result,"选择对话",1000);
                            }else{
                                int ran=(int)(Math.random()*size);
                                result=list.get(ran);
                                mFairy.onTap(0.77f,result,"选择对话"+ran,1000);
                            }
                        }
                    }

                    result=mFairy.findPic("word lbsl btn clear.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,639,497,650,505,"下次再说",1000);
                        mFairy.onTap(0.8f,result,872,183,888,199,"关闭加速",1000);
                        speed_up=false;
                    }

                    result=mFairy.findPic("pic huaquan.png");
                    mFairy.onTap(0.8f,result,"划拳",1000);

                    result=mFairy.findPic("word btn submit.png");
                    mFairy.onTap(0.8f,result,"提交",1000);

                    result=mFairy.findPic(668,583,776,640,"word btn send.png");
                    mFairy.onTap(0.8f,result,"赠送",1000);

                    result=mFairy.findPic("word btn up.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"战力不足，提升实力",1000);
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word btn exit.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"任务失败，无法继续",1000);
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic("pic lbsl interface.png");
                if(result.sim>0.8f){
                    if(speed_up){
                        result=mFairy.findPic("pic speed up.png");
                        mFairy.onTap(0.8f,result,"进入加速",1000);
                    }

                    result=mFairy.findPic("word btn speed up.png");
                    mFairy.onTap(0.8f,result,"加速",1000);

                    result=mFairy.findPic("word btn think.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        mFairy.onTap(0.8f,result,"再想想",1000);
                        speed_up=false;
                        return;
                    }

                    //上一页
                    result=mFairy.findPic(50,314,72,338,"pic red tip1.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        mFairy.onTap(0.8f,result,"奖励未领取-上一页",2000);
                        return;
                    }

                    //下一页
                    result=mFairy.findPic(1206,355,1228,377,"pic red tip1.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        mFairy.onTap(0.8f,result,"奖励未领取-下一页",2000);
                        return;
                    }

                    result=mFairy.findPic("word get award.png");
                    mFairy.onTap(0.8f,result,"领取奖励",1000);

                    //完成奖励
                    for(int i=1;i<=3;i++){
                        if(i==1)result=mFairy.findPic(941,617,957,635,"pic red tip1.png");
                        if(i==2)result=mFairy.findPic(1085,617,1106,636,"pic red tip1.png");
                        if(i==3)result=mFairy.findPic(1223,616,1243,636,"pic red tip1.png");
                        if(result.sim>0.73f){
                            util.initDaze();
                            mFairy.onTap(0.73f,result,"领取活跃奖励",1000);
                            mFairy.onTap(0.73f,result,633,498,644,509,"领取奖励",1000);
                            return;
                        }
                    }

                    result=mFairy.findPic("pic lbsl geted.png");
                    mFairy.onTap(0.8f,result,1238,339,1251,350,"当前章节完成，下一页",2000);

                    result=mFairy.findPic("word level reach.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"等级不足，无法继续",1000);
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    List<FindResult> list=mFairy.findPic(118,96,1212,667,0.85f,"pic lbsl challenge1.png");
                    int size=list.size();
                    if(size!=0){
                        for(int i=0;i<=size-1;i++){
                            result=list.get(i);
                            int colorNum=mFairy.getColorNum(result.x+26,result.y-167,result.x+65,result.y-105,0.98f,0,"255,253,202");
                            if(colorNum>60)mFairy.onTap(0.8f,result,result.x+45,result.y-70,result.x+56,result.y-58,"挑战",1000);
                        }
                    }
                }

                result=mFairy.findPic("pic camera.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("无法继续执行，任务结束"));
                    util.close();
                    setTaskEnd();
                    return;
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(619,522,717,587,"word btn know1.png");
                mFairy.onTap(0.8f,result,"新章节开启-知道",1000);

                result=mFairy.findPic("word btn know1.png");
                mFairy.onTap(0.8f,result,"挂机收益-知道",1000);

                result=mFairy.findPic(583,488,675,549,"word btn know1.png");
                mFairy.onTap(0.8f,result,"挂机收益提升-知道",1000);

                result=mFairy.findPic("pic success.png");
                mFairy.onTap(0.8f,result,"挑战成功",1000);

                result=mFairy.findPic("word to strong.png");
                if(result.sim>0.8f){
                    mFairy.sleep(1000);
                    mFairy.onTap(0.8f,result,971,690,982,699,"挑战失败，任务结束",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"六部试炼");
    }

    //竞技场
    public void single_jjc()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily jingjichang.png");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                result=mFairy.findPic("word jjc zero.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1225,24,1233,34,"次数用尽",1000);
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic("word btn change.png");
                mFairy.onTap(0.8f,result,"换一批",1000);

                result=mFairy.findPic(406,564,1097,626,"word btn challenge.png");
                mFairy.onTap(0.8f,result,"挑战",1000);

                result=mFairy.findPic(596,635,683,692,"word btn exit.png");
                mFairy.onTap(0.8f,result,"退出",1000);

                if(daze>20){
                    setTaskName(0);
                    LtLog.e(mFairy.getLineInfo("任务超时，任务重置"));
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"竞技场");
    }

    //世家任务
    public void single_sjrw()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            int current=0,buy=0,buy1=0,picCount=0,xfIndex=1;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                setTaskName(2);
                buy=0;
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily sjrw.png",1);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                //世家
                result=mFairy.findPic("word sjrw interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word sjrw btn get.png");
                    mFairy.onTap(0.8f,result,"世家总任务-领取",1000);

                    result=mFairy.findPic("word sj finish.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("世家任务完成，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word sjrw get award.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"领取奖励",1000);
                        current=0;
                    }

                    List<FindResult> list=mFairy.findPic(980,192,1062,578,0.8f,"word go.png");
                    if(list.size()!=0){
                        if(current>list.size()-1){
                            LtLog.e(mFairy.getLineInfo("没有可执行任务了，任务结束"));
                            util.close();
                            setTaskEnd();
                            return;
                        }else{
                            result=list.get(current);
                            mFairy.onTap(0.8f,result,"前往",1000);
                        }
                    }
                }

                //世家商店
                result=mFairy.findPic("word sjsd interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(new String[]{"pic sjgx.png","pic yuanbao.png"});
                    mFairy.onTap(0.8f,result,"选中商品",1000);

                    result=mFairy.findPic(592,479,673,530,"word btn pinjie buy.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"购买",1000);
                        if(++buy>=3){
                            current++;
                            LtLog.e(mFairy.getLineInfo("世家贡献不足，执行下一个任务"));
                            setTaskName(0);
                            return;
                        }
                    }


                    result=mFairy.findPic("pic sjgx1.png");
                    mFairy.onTap(0.8f,result,1102,84,1116,96,"购买完成",1000);
                }

                result=mFairy.findPic("word list.png");
                mFairy.onTap(0.8f,result,67,311,77,321,"选择世家成员",1000);

                result=mFairy.findPic("word btn donate.png");
                mFairy.onTap(0.8f,result,"捐献",1000);
                mFairy.onTap(0.8f,result,1103,85,1114,97,"关闭捐献界面",1000);

                result=mFairy.findPic("word sjrw btn buy and donate.png");
                mFairy.onTap(0.8f,result,"购买并捐献",1000);

                result=mFairy.findPic("word sjrw btn buy and donate1.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"购买并捐献",1000);
                    mFairy.onTap(0.8f,result,1102,82,1113,94,"关闭捐献界面",1000);
                    if(++buy1>=3){
                        current++;
                        mFairy.onTap(0.8f,result,875,182,888,196,"银币不足，执行下一个任务",1000);
                        setTaskName(0);
                        return;
                    }
                }

                result=mFairy.findPic(new String[]{"word btn hualianmiao.png","word btn hualianmiao1.png"});
                mFairy.onTap(0.8f,result,"花脸喵",1000);

                result=mFairy.findPic("word btn hudong.png");
                mFairy.onTap(0.8f,result,"互动",1000);

                result=mFairy.findPic("pic sjrw thing.png");
//                mFairy.onTap(0.8f,result,639,368,647,377,"选择互动事件",1000);
                //不执行互动
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1225,25,1235,36,"不执行互动,返回",1000);
                    current++;
                    return;
                }

                result=mFairy.findPic("word sjrw select obj interface.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word qingan zero.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,1100,96,1111,105,"次数用尽,无法互动",1000);
                        current++;
                        return;
                    }
                    mFairy.onTap(0.8f,result,700,151,712,164,"切换世家",1000);
                    mFairy.onTap(0.8f,result,998,257,1006,267,"互动",1000);
                    setTaskName(0);
                }

                result=mFairy.findPic("word btn qingan.png");
                mFairy.onTap(0.8f,result,"请安",1000);

                result=mFairy.findPic("word btn examine.png");
                mFairy.onTap(0.8f,result,"查看",1000);

                result=mFairy.findPic("pic camera1.png");
                mFairy.onTap(0.8f,result,"拍照",1000);

                result=mFairy.findPic("pic picture pindao.png");
                mFairy.onTap(0.8f,result,"打开频道",1000);

                result=mFairy.findPic("word btn share shijia.png");
                mFairy.onTap(0.8f,result,"分享到世家",1000);
                mFairy.onTap(0.8f,result,1214,44,1228,58,"关闭图片",1000);
                mFairy.onTap(0.8f,result,1221,34,1229,45,"关闭拍照",1000);

                result=mFairy.findPic("word btn execute.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"实行",1000);
                    setTaskName(0);
                    return;
                }

                result=mFairy.findPic("word sjxf interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(796,585,879,640,"word btn upgrade.png");
                    mFairy.onTap(0.8f,result,"升级心法",1000);
                    mFairy.onTap(0.8f,result,1099,91,1110,105,"关闭心法界面",1000);

                    result=mFairy.findPic(new String[]{"word level upper limit.png","word btn sjrw advance.png"});
                    if(result.sim>0.8f){
                        if(++xfIndex>=5){
                            mFairy.onTap(0.8f,result,1099,91,1110,105,"关闭心法界面",1000);
                            current++;
                            setTaskName(0);
                            return;
                        }
                        mFairy.onTap(0.8f,result,338,220+(xfIndex-1)*122,352,234+(xfIndex-1)*122,"达到上限，进阶,切换心法"+xfIndex,1000);
                    }
                }

                //礼物界面
                result=mFairy.findPic("word gift interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic sj send selected.png");
                    if(result.sim<0.8f){
                        mFairy.onTap(355,312,360,320,"选择送花对象",1000);
                    }

                    result=mFairy.findPic(678,580,742,642,"word btn send.png");
                    mFairy.onTap(0.8f,result,"赠送",1000);
                    picCount=picCount(0.8f,result,"sjrw send");
                    if(picCount>=3){
                        mFairy.onTap(0.8f,result,1147,81,1158,94,"鲜花不足，无法继续任务",1000);
                        current++;
                    }
                }

                //选择界面
                result=mFairy.findPic("word select use interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word sjrw off line.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("没有人在线，执行下一个任务"));
                        current++;
                        util.close();
                        return;
                    }

                    result=mFairy.findPic("word select he.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"就选他",1000);
                        setTaskName(0);
                        return;
                    }
                }

                result=mFairy.findPic("word shijia info.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word stay upload.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,1225,28,1230,39,"没有照片，待上传",1000);
                        current++;
                        return;
                    }else{
                        mFairy.onTap(0.8f,result,361,524,369,533,"选中成员相册",1000);
                    }
                }

                result=mFairy.findPic("word btn sj youhao.png");
                mFairy.onTap(0.8f,result,"友好",1000);

                result=mFairy.findPic("word btn youhao.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"友好",1000);
                    mFairy.onTap(0.8f,result,965,125,980,139,"关闭",1000);
                    setTaskName(0);
                    return;
                }

                //相册点赞
                result=mFairy.findPic("word sj close.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1090,585,1095,590,"点赞",1000);
                    mFairy.onTap(0.8f,result,"关闭",1000);
                    setTaskName(0);
                    return;
                }

                if(daze>20){
                    setTaskName(0);
                    LtLog.e(mFairy.getLineInfo("任务超时，任务重置"));
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(667,87,723,299,"word sjgx not enough.png");
                if(result.sim>0.8f){
                    current++;
                    LtLog.e(mFairy.getLineInfo("世家贡献不足"));
                    setTaskName(0);
                    return;
                }

                result=mFairy.findPic("word hint send interface.png");
                mFairy.onTap(0.8f,result,634,469,647,482,"确定赠送",1000);
                mFairy.onTap(0.8f,result,1150,83,1162,94,"关闭送礼界面",1000);

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"世家任务");
    }

    //王城漫步
    public void single_wcmb()throws Exception{
        Abnormal.tap=false;
        new SingleTask(mFairy){
            long daze=0;
            int failureCount=0,wcLevel=0,exeCount=0;

            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("wcLevel").equals("")){
                    wcLevel=Integer.parseInt(AtFairyConfig.getOption("wcLevel"));
                }

                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
                failureCount=0;
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(3,244,50,442,"word task man.png");
                mFairy.onTap(0.8f,result,"漫步指引",Sleep);
                if (result.sim>0.8f){
                    util.initDaze();
                    setTaskName(3);
                    return;
                }
                /**
                 1.initSlidCount初始化滑动次数
                 */
                mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 4, 125,400,125,320, 1000, 1500,1);
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily wcmb.png",1);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn start task.png");
                mFairy.onTap(0.8f,result,"开始任务",1000);

                result=mFairy.findPic("word btn start fight.png");
                mFairy.onTap(0.8f,result,"开始战斗",1000);

                //王城漫步界面
                result=mFairy.findPic("word wcmb interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic wcmb relax selected.png");
                    mFairy.onTap(0.8f,result,"取消休闲战斗",1000);

                    result=mFairy.findPic(898,549,978,599,"word btn give up.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1116,85,1127,92,"已接任务，点击指引继续",1000);
                        setTaskName(1);
                        return;
                    }

                    result1=mFairy.findPic(274,155,336,640,"word wcmb level "+wcLevel+".png");
                    if(result1.sim>0.8f){
                        result=mFairy.findPic(result1.x-104,result1.y-40,result1.x-69,result1.y-2,"pic wcmb selected.png");
                        if(result.sim>0.8f){
                            //没有解锁
                            result=mFairy.findPic("word open lock.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,1117,79,1128,93,"关卡没有解锁，任务结束",1000);
                                setTaskEnd();
                                return;
                            }

                            result=mFairy.findPic("word start.png");
                            mFairy.onTap(0.8f,result,"开始漫步",1000);
                        }else{
                            mFairy.onTap(0.8f,result1,"选中等级"+wcLevel,1000);
                        }
                    }else{
                        //滑动
                        mFairy.ranSwipe(429,553,424,172,1000,1500l,1);
                        result=mFairy.findPic("word wcmb level 15.png");
                        if(result.sim>0.8f){
                            if(wcLevel==15){
                                mFairy.onTap(0.8f,result1,"选中等级"+wcLevel,1000);
                                return;
                            }
                            LtLog.e(mFairy.getLineInfo("初始化滑动"));
                            //初始化滑动
                            for(int i=1;i<=4;i++){
                                mFairy.ranSwipe(429,172,424,553,500,1000l,1);
                            }
                        }
                    }
                 }

                result=mFairy.findPic(594,454,632,533,"word auto fight.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("自动战斗中"));
                    util.initDaze();
                }

                result=mFairy.findPic("word speed up.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word speed three.png");
                    if(result1.sim<0.8f)mFairy.onTap(0.8f,result,"更改倍速",1000);
                }

                result=mFairy.findPic("pic failure.png");
                int picCount=picCount(0.8f,result,"failure");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"失败"+failureCount+"次",1000);
                    if(picCount==1&&++failureCount>=3){
                        LtLog.e(mFairy.getLineInfo("连续失败三次，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic("pic success.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"成功",1000);
                    failureCount=0;
                }

                if(daze>5){
                    result=mFairy.findPic(3,244,50,442,"word task man.png");
                    mFairy.onTap(0.8f,result,"漫步指引",Sleep);
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint already 30.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,883,180,895,189,"已经完成30次，任务结束",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(605,456,672,595,"word hint affirm.png");
                mFairy.onTap(0.8f,result,"确认",1000);

                result=mFairy.findPic("word btn hint continue.png");
                mFairy.onTap(0.8f,result,"继续",1000);
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"王城漫步");
    }

    //结缘送礼
    public void single_jysl()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            boolean executeTask=true;
            @Override
            public void content_0() throws Exception {
                daze=0;
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily jysl.png",4);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn start fight.png");
                mFairy.onTap(0.8f,result,"开始战斗",1000);

                result=mFairy.findPic("word btn clothing grade.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,841,691,847,697,"不执行时装评分",1000);
                    executeTask=false;
                    setTaskName(0);
                    return;
                }

                if(daze>=5){
                    result=mFairy.findPic(8,288,44,396,"word task yuan.png");
                    mFairy.onTap(0.8f,result,"结缘指引",1000);
                }

                result=mFairy.findPic("word tujian.png");
                if(result.sim>0.8f){
                    //互动界面
                    result=mFairy.findPic("word hudong interface.png");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic(1240,102,1263,129,"pic jysl red tip.png");
                        mFairy.onTap(0.8f,result1,"切换互动分页",1000);

                        result=mFairy.findPic("word jysl one.png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic("word btn date.png");
                            mFairy.onTap(0.8f,result,"约会",1000);
                        }

                        result=mFairy.findPic(942,250,980,283,"word jysl one.png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic("word btn Intimacy.png");
                            mFairy.onTap(0.8f,result,"亲昵",1000);
                        }

                        result=mFairy.findPic(1139,375,1163,402,"pic jysl red tip.png");
                        mFairy.onTap(0.8f,result,"拜访前往",1000);

                        if(executeTask){
                            result=mFairy.findPic(802,445,865,620,"pic jysl task.png");
                            mFairy.onTap(0.8f,result,result.x+286,result.y+43,result.x+293,result.y+54,"结缘任务前往",1000);
                        }

                        result=mFairy.findPic("pic jysl send paging.png");
                        if(result.sim>0.8f&&result1.sim<0.8f) {
                            util.initDaze();
                            mFairy.onTap(0.8f,result,"切换送礼分页",1000);
                        }
                    }

                    //赠送礼物界面
                    result=mFairy.findPic("word send interface.png");
                    if(result.sim>0.8f){
                        util.initDaze();
                        result=mFairy.findPic("word jysl zero.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,1224,28,1230,35,"送礼达到上限，任务结束",1000);
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("word jysl go get.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("礼物不足，前往获得，任务结束"));
                            util.close();
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("pic jy unlike.png");
                        mFairy.onTap(0.8f,result,924,252,933,262,"换下个礼物",1000);

                        result=mFairy.findPic(1038,607,1083,659,"word btn send.png");
                        mFairy.onTap(0.8f,result,"赠送",1000);
                    }
                }

                result=mFairy.findPic("word jy dorm.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(404,609,464,688,"pic button.png");
                    mFairy.onTap(0.8f,result,"话题-选择",1000);
                }

                result=mFairy.findPic("word topic interface.png");
                if(result.sim>0.8f){
                    //有话题
                    result=mFairy.findPic(895,160,959,200,"word go.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"话题 前往",1000);
                        util.initDaze();
                    }else{
                    //没有
                        mFairy.onTap(1051,74,1061,86,"话题界面 关闭",1000);
                    }
                }else{
                    result=mFairy.findPic("word btn topic.png");
                    if(result.sim>0.8f){
                        //有没未完成话题
                        result1=mFairy.findPic(573,627,595,651,"pic jysl red tip.png");
                        if(result1.sim>0.8f){
                            mFairy.onTap(0.8f,result,"话题",1000);
                            util.initDaze();
                        }else{
                            //没有，退出副本
                            result=mFairy.findPic("pic copy leave1.png");
                            mFairy.onTap(0.8f,result,"离开副本",1000);
                        }
                    }
                }

                result=mFairy.findPic(500,600,600,640,"word open.png");
                mFairy.onTap(0.7f,result,"解锁对象",1000);

                result=mFairy.findPic(new String[]{"pic gift.png","pic gift1.png"});
                mFairy.onTap(0.8f,result,"点击领取礼物",1000);

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result = mFairy.findPic("pic task.png");
                mFairy.onTap(0.8f,result,"切换任务栏",Sleep);
                super.inOperation();
            }
        }.taskContent(mFairy,"结缘送礼");
    }

    //随从传记
    public void single_sczj()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            String obj="sunce";
            int step=0;
            boolean zero=false;
            @Override
            public void create() throws Exception {
                if(!AtFairyConfig.getOption("scObj").equals("")){
                    obj=AtFairyConfig.getOption("scObj");
                }
            }

            @Override
            public void content_0() throws Exception {
                step=0;
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily sczj.png",2);
                if (ret==1){
                    util.initDaze();
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                if(daze>=30){
                    LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                    setTaskName(0);
                    return;
                }

                //随从传记界面
                result=mFairy.findPic(new String[]{"word sczj interface.png","word sczj interface1.png"});
                if(result.sim>0.8f){
                    //选择随从 界面
                    result=mFairy.findPic("pic sczj left.png");
                    if(result.sim>0.8f){
                        //初始化滑动，至到找到周瑜
                        if(step==0){
                            result=mFairy.findPic(162,165,1139,272,"word sczj "+obj+".png");
                            if(result.sim>0.8f){
                                step++;
                                return;
                            }

                            for(int i=1;i<=8;i++){
                                mFairy.ranSwipe(253,353,1037,353,1000,1000l,1);
                                LtLog.e(mFairy.getLineInfo("第"+i+"次滑动"));
                                result=mFairy.findPic(287,184,421,256,"word sczj zhouyu.png");
                                if(result.sim>0.8f){
                                    LtLog.e(mFairy.getLineInfo("初始化滑动结束"));
                                    break;
                                }
                            }
                            step++;
                        }

                        result=mFairy.findPic(162,165,1139,272,"word sczj "+obj+".png");
                        if(result.sim>0.8f){
                            result1=mFairy.findPic(result.x-104,result.y+360,result.x-43,result.y+426,"pic sczj main flower.png");
                            if(result1.sim<0.8f){
                                LtLog.e(mFairy.getLineInfo("上一章节没有开启"));
                                util.close();
                                setTaskEnd();
                                return;
                            }else{
                                mFairy.onTap(0.8f,result,"选中"+obj,1000);
                            }
                            return;
                        }else{
                            result=mFairy.findPic(133,540,441,604,"pic sczj main flower.png");
                            if(result.sim<0.8f){
                                LtLog.e(mFairy.getLineInfo("上一章节没有开启"));
                                util.close();
                                setTaskEnd();
                                return;
                            }

                            //向右滑动
                            mFairy.ranSwipe(737,353,253,353,1000,1000l,1);
                        }
                        overtime(20,0);
                    }


                    //选中任务 界面
                    result=mFairy.findPic(23,615,88,669,"pic position.png");
                    if(result.sim>0.8f){
                        //没有次数了
                        result=mFairy.findPic("word sczj zero1.png");
                        if(result.sim>0.8f)zero=true;

                        if(zero){
                            //没次数
                            result=mFairy.findPic(682,176,742,228,"pic none flower.png");
                            mFairy.onTap(0.8f,result,"选择第一个为过关的",1000);

                            result=mFairy.findPic(682,176,742,228,"pic flower.png");
                            if(result.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("没有次数了，任务结束"));
                                util.close();
                                setTaskEnd();
                                return;
                            }
                        }else{
                            //有次数
                            result=mFairy.findPic(682,176,742,228,"pic none flower.png");
                            if(result.sim>0.8f){
                                result1=mFairy.findPic(849,178,906,229,"pic flower.png");
                                if(result1.sim>0.8f){
                                    mFairy.onTap(0.8f,result1,"选择第二个已通关的",1000);
                                }else{
                                    mFairy.onTap(682,176,742,228,"选择第一个已通关的",1000);
                                }
                            }else{
                                mFairy.onTap(682,176,742,228,"选择第一个已通关的",1000);
                            }
                        }

                        result=mFairy.findPic("word sczj zero.png");
                        result1=mFairy.findPic(540,241,575,276,"word sczj zero.png");
                        if(result1.sim<0.75f){
                            mFairy.onTap(0.8f,result,908,151,915,160,"次数0，关闭挑战",1000);
                        }

                        if(!zero){
                            result=mFairy.findPic("word btn carnet.png");
                            mFairy.onTap(0.8f,result,"通关3次",1000);
                        }

                        result=mFairy.findPic("word btn challenge1.png");
                        mFairy.onTap(0.8f,result,"挑战",1000);
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word to strong.png");
                if(result.sim>0.8f){
                    mFairy.sleep(1000);
                    mFairy.onTap(0.8f,result,517,543,701,716,"挑战失败，任务结束",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"随从传记");
    }

    //归墟山庄
    public void single_gxsz()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                daze=0;
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily gxsz.png",4);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);
            }

            @Override
            public void inOperation() throws Exception {
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"归墟山庄");
    }

    //议事殿
    public void single_ysd()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                daze=0;
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily ysd.png");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word ysd zero.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1229,28,1234,36,"次数不够，任务结束",1000);
                    setTaskEnd();
                    return;
                }


                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                result=mFairy.findPic("word fenglu.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(175,532,1079,632,"word ysd challenge.png");
                    mFairy.onTap(0.8f,result,"挑战",1000);
                    if(result.sim<0.8f){
                        result=mFairy.findPic("pic left.png");
                        mFairy.onTap(0.8f,result,"向左",1000);
                    }
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("发呆超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("pic failure.png");
                mFairy.onTap(0.8f,result,"失败关闭",1000);


                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"议事殿");
    }

    //闯殿策
    public void single_cdc()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                daze=0;
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily cdc.png",2);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.9f,result,"事件按钮",1000);

                result=mFairy.findPic(780,581,860,627,"word btn challenge.png");
                mFairy.onTap(0.8f,result,"挑战",1000);

                result=mFairy.findPic(new String[]{"word btn next level.png","word btn ccd next level.png"});
                mFairy.onTap(0.8f,result,"下一关",1000);

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("发呆超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word to strong.png");
                if(result.sim>0.8f){
                    mFairy.sleep(1000);
                    mFairy.onTap(0.8f,result,517,543,701,716,"挑战失败，任务结束",1000);
                    util.close();
                    setTaskEnd();
                    return;
                }
                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"闯殿策");
    }

    //拙政园 钓鱼
    public void single_zzydy()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            @Override
            public void content_0() throws Exception {
                daze=0;
                util.close();
                setTaskName(2);
            }

            @Override
            public void content_1() throws Exception {
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily zzydy.png");
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn diaoyu.png");
                mFairy.onTap(0.8f,result,"前往钓鱼",1000);

                result=mFairy.findPic("word fish.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word zzy zero.png");
                    if(result1.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("钓鱼次数用尽，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                    util.initDaze();
                    mFairy.onTap(0.8f,result,735,476,743,482,"钓鱼",1000);
                }

                result=mFairy.findPic("word btn shougan.png");
                mFairy.onTap(0.8f,result,"收杆",2000);

                result=mFairy.findPic("word fish submit.png");
                mFairy.onTap(0.8f,result,1193,234,1207,242,"可提交订单",100);

                result=mFairy.findPic("word fish order.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(247,585,329,635,"word btn submit.png");
                    mFairy.onTap(0.8f,result,"提交",1000);
                    if(result.sim<0.8f)mFairy.onTap(1143,85,1156,99,"关闭",1000);
                }

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("发呆超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("pic failure.png");
                mFairy.onTap(0.8f,result,"失败关闭",1000);


                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"拙政园 钓鱼");
    }

    //拙政园 环任务
    public void single_zzyhrw()throws Exception{
        Abnormal.tap=true;
        new SingleTask(mFairy){
            long daze=0;
            int failureCount=0;
            @Override
            public void content_0() throws Exception {
                util.initDaze();
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;

                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(3,244,50,442,"word task huan.png");
                mFairy.onTap(0.8f,result,"环任务指引",Sleep);
                if (result.sim>0.8f){
                    util.initDaze();
                    setTaskName(3);
                    return;
                }
                /**
                 1.initSlidCount初始化滑动次数
                 */
                mFairy.taskSlid(err, new int[]{1, 2, 4, 6}, 4, 125,400,125,320, 1000, 1500,1);
            }

            @Override
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =util.mission("word daily zzyhrw.png",1);
                if (ret==1){
                    util.initDaze();
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word btn get task.png");
                mFairy.onTap(0.8f,result,"接取任务",1000);

                result=mFairy.findPic(960,530,1038,585,"word go.png");
                mFairy.onTap(0.8f,result,"前往目标",1000);

                result=mFairy.findPic("word btn hand in.png");
                mFairy.onTap(0.8f,result,"上交",1000);

                if(daze>5){
                    result=mFairy.findPic(74,281,187,395,"word zzyhrw pindao fayan.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"执行频道发言",1000);
                        setTaskName(4);
                        return;
                    }

                    result=mFairy.findPic(3,244,50,442,"word task huan.png");
                    mFairy.onTap(0.8f,result,"环任务指引",Sleep);
                }

                result=mFairy.findPic("word btn start fight.png");
                mFairy.onTap(0.8f,result,"开始战斗",1000);

                result=mFairy.findPic("pic speak take back.png");
                mFairy.onTap(0.8f,result,"收回频道",1000);

                if(daze>20){
                    LtLog.e(mFairy.getLineInfo("发呆超时，重启任务"));
                    setTaskName(0);
                    return;
                }
            }

            //频道发言
            public void content_4()throws Exception{
                result=mFairy.findPic("pic speak take back.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(489,649,565,700,"word btn speak send.png");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic("word input word.png");
                        if(result1.sim>0.8f){
                            mFairy.onTap(0.8f,result1,"点击算入文字",1000);
                        }else{
                            mFairy.onTap(0.8f,result,"发送",1000);
                            mFairy.onTap(0.8f,result,608,346,614,364,"收回发言框",1000);
                            setTaskName(3);
                            util.initDaze();
                        }
                    }
                }else{
                    mFairy.onTap(737,639,740,645,"打开频道",1000);
                }

                result=mFairy.findPic("word btn speak send.png");
                if(result.sim>0.8f){
                    mFairy.inputText("拙政园 环任务 发言");
                    mFairy.onTap(0.8f,result,"发送",1000);
                }
                overtime(10,0);
            }
            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word main city.png");
                mFairy.onTap(0.8f,result,635,519,644,528,"确定",1000);

                result=mFairy.findPic("word to strong.png");
                int picCount=picCount(0.8f,result,"failure");
                if(result.sim>0.8f){
                    mFairy.sleep(1000);
                    mFairy.onTap(0.8f,result,971,690,982,691,"失败"+failureCount+"次",1000);
                    if(picCount==1&&++failureCount>=3){
                        LtLog.e(mFairy.getLineInfo("连续失败三次，任务结束"));
                        util.close();
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic("pic success.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"成功",1000);
                    failureCount=0;
                }

                daze=util.dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"拙政园 环任务");
    }



    @Override
    public void inOperation() throws Exception {
        //战斗中
        result=mFairy.findPic("word fight auto.png");
        if(result.sim>0.8f){
            util.initDaze();
            LtLog.e(mFairy.getLineInfo("战斗中"));
        }

        //跳过剧情
        result=mFairy.findPic("word btn continue.png");
        mFairy.onTap(0.8f,result,826,398,839,413,"今日不再提醒",1000);
        mFairy.onTap(0.8f,result,634,518,646,529,"确认跳过剧情",1000);

        //跳过对话
        result=mFairy.findPic("word hint dialogue.png");
        mFairy.onTap(0.8f,result,822,428,838,443,"今日不再提醒",1000);
        mFairy.onTap(0.8f,result,634,518,646,529,"确认跳过对话",1000);

        //关闭画面设置
        result=mFairy.findPic("word hint kadun.png");
        mFairy.onTap(0.8f,result,828,433,835,444,"今日不再提醒",1000);
        mFairy.onTap(0.8f,result,877,174,897,193,"关闭设置",1000);

        result=mFairy.findPic("word fight continue.png");
        mFairy.onTap(0.8f,result,"战斗跳过",1000);

        result=mFairy.findPic("word hand.png");
        mFairy.onTap(0.8f,result,"改为自动",1000);

        result=mFairy.findPic("word cancel.png");
        mFairy.onTap(0.8f,result,"取消",1000);
    }

    public void test()throws Exception{
        while(mFairy.condit()){
            mFairy.sleep(1000);
            LtLog.e(mFairy.getLineInfo("\ntest while..........."));
//            result=mFairy.findPic("pic dialogue select.png");
//            if(result.sim>0.65f){
//                util.initDaze();
//                List<FindResult> list=mFairy.findPic(830,200,890,540,0.77f,"pic dialogue select.png");
//                int size=list.size();
//                if(size!=0){
//                    if(size==1){
//                        result=list.get(0);
//                        mFairy.onTap(0.77f,result,"选择对话",1000);
//                    }else{
//                        int ran=(int)(Math.random()*size);
//                        result=list.get(ran);
//                        mFairy.onTap(0.77f,result,"选择对话"+ran,1000);
//                    }
//                }
//            }

//            result=mFairy.findPic("pic copy leave1.png");
//            LtLog.e(mFairy.getLineInfo(result.toString()));

//            result=mFairy.findPic("word jzxy shizhuang.png");
//            LtLog.e(mFairy.getLineInfo(result.toString()));
//
//            result=mFairy.findPic(573,627,595,651,"pic jysl red tip.png");
//            LtLog.e(mFairy.getLineInfo(result.toString()));
//
//            result=mFairy.findPic(1245,216,1261,235,"pic red tip2.png");
//            LtLog.e(mFairy.getLineInfo(result.toString()));
            LtLog.e(mFairy.getLineInfo(mFairy.getColorNum(126,115,164,128,0.95f,0,"255,241,207")+""));
            LtLog.e(mFairy.getLineInfo(mFairy.getColorNum(124,254,162,271,0.95f,0,"255,241,207")+""));
//            LtLog.e(mFairy.getLineInfo(mFairy.getColorNum(124,254,162,271,0.95f,0,"255,241,207")+""));
        }
    }
}
