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
    Util gameUtil;
    List<String> taskList=null;
    String change="";
    int picCount=0,colorNum=0;
    int successCount=0,failureCount=0,daze=0;//发呆计次
    long dazeTime=0;
    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new Util(mFairy);
    }

    @Override
    public void inOperation() throws Exception {
        //战斗场景
        result=mFairy.findPic(new String[]{"direction.png","direction1.png"});
        picCount=picCount(0.8f,result,"direction");
        if(result.sim>0.8f){
            mFairy.initDaze();
            daze=0;
            if(picCount<=3)mFairy.onTap(821,188,835,203,"锁定优先攻击",200);

            result=mFairy.findPic("word hand.png");
            picCount=picCount(0.8f,result,"manual");
            if(picCount==1){
                mFairy.onTap(0.8f,result,"打开自动",100);
            }

            result=mFairy.findPic("pic x1.png");
            picCount=picCount(0.8f,result,"x1");
            if(picCount==1){
                mFairy.onTap(0.8f,result,"开启2倍速",100);
            }
        }

        result=mFairy.findPic("pic word award.png");
        mFairy.onTap(0.8f,result,"获得奖励",200);

        //银两不足，结束当前任务
        result=mFairy.findPic("word money none1.png");
        if(result.sim>0.8f){
            LtLog.e(mFairy.getLineInfo(taskList.get(0)+"银两不足,结束当前任务"));
            setTaskEnd();
        }

        //使用道具
        result=mFairy.findPic("word use2.png");
        if(result.sim>0.8){
            result=mFairy.findPic("word max.png");
            mFairy.onTap(0.8f,result,"最大",200);

            result=mFairy.findPic("word affirm use.png");
            mFairy.onTap(0.8f,result,"确认使用",200);
        }

        //确定和取消选择
        result=mFairy.findPic("word hint.png");
        if(result.sim>0.8){
            //不做处理
//            result=mFairy.findPic(400,306,870,396,new String[]{"word hint already finish.png"});
//            if(result.sim>0.8f){
//                return;
//            }

            //点击确定，退出，退出战斗，最后一环
            result=gameUtil.findPic(400,306,870,396,new String[]{"word weituo1.png","word jiequ.png","word exit.png",
                    "word wangluo.png","word hint exit fight.png","word none over.png","word hint schedule.png"});
            if(result.sim>0.8f){
                result=mFairy.findPic(705,453,811,528,"word affirm.png");
                mFairy.onTap(0.8f,result,"点击确定",200);
                return;
            }

            result=mFairy.findPic(new String[]{"word cancel.png","word cancel1.png"});
            mFairy.onTap(0.8f,result,"点击取消",200);
        }

        result=mFairy.findPic("pic open task.png");
        mFairy.onTap(0.8f,result,"打开任务列表",200);

        //使用
        result=mFairy.findPic("word use.png");
        if(result.sim>0.8f){
            result1=gameUtil.findPic(972,489,1112,524,new String[]{"word use zixuanhe.png","word use zixuan.png","word use baoxiang.png"});
            if(result1.sim>0.8f){
                result = mFairy.findPic(1111, 342, 1167, 403, "pic close1.png");
                mFairy.onTap(0.8f,result,"不使用",100);
            }else{
                mFairy.onTap(0.8f,result,"使用",100);
            }
        }
    }

    //一键到28级
    public void novice() throws Exception {
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
//                gameUtil.close("create_回到大厅");
            }

            @Override
            public void content_0() throws Exception {
                result1=mFairy.findPic("word zhu.png");
                picCount=picCount(0.8f,result,"main");
                if(result1.sim>0.8&&picCount%5==0){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic(new String[]{"word zhi.png","word zhi1.png"});
                        if(result.sim>0.8){
                            mFairy.onTap(0.8f,result,"点击支线指引",200);
                        }else {
                            mFairy.onTap(0.8f,result1,"点击主线指引",200);
                        }
                    }else{
                        LtLog.e(mFairy.getLineInfo("自动寻路中"));
                    }
                }

                result=mFairy.findPic("word mubiao.png");
                mFairy.onTap(0.8f,result,"目标指引",100);

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    result1=mFairy.findPic(new String[]{"word dati.png","word weituo.png"});
                    if(result1.sim<0.8){
                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                    }else{
                        mFairy.onTap(0.8f,result1,"开始答题,委托战斗",100);
                    }
                }

                result=mFairy.findPic(new String[]{"affirm.png","affirm1.png"});
                mFairy.onTap(0.8f,result,"确定",100);

                result=mFairy.findPic(0,0,1280,720,"hand.png");
                mFairy.onTap(0.85f,result,result.x-27,result.y-28,result.x-26,result.y-27,"点击手势提醒",100);

                result=mFairy.findPic("pic chouqian.png");
                mFairy.onTap(0.8f,result,"抽签",100);

                result=mFairy.findPic("next.png");
                mFairy.onTap(0.8f,result,"下一步",100);

                result=mFairy.findPic("word wear.png");
                mFairy.onTap(0.8f,result,"点击装备",100);

                result=mFairy.findPic("word use.png");
                if(result.sim>0.8f){
                    result1=gameUtil.findPic(972,489,1112,524,new String[]{"word use zixuanhe.png","word use zixuan.png"});
                    if(result1.sim>0.8f){
                        result = mFairy.findPic(1111, 342, 1167, 403, "pic close1.png");
                        mFairy.onTap(0.8f,result,"不使用",100);
                    }else{
                        mFairy.onTap(0.8f,result,"使用",100);
                    }
                }

                result=mFairy.findPic("word use2.png");
                if(result.sim>0.8){
                    result=mFairy.findPic("word max.png");
                    mFairy.onTap(0.8f,result,"最大",200);

                    result=mFairy.findPic("word affirm use.png");
                    mFairy.onTap(0.8f,result,"确认使用",200);
                }

                result=mFairy.findPic("word save.png");
                mFairy.onTap(0.8f,result,"点击保存",100);

                result=mFairy.findPic("word yijie.png");
                mFairy.onTap(0.8f,result,762,478,781,491,"已接任务,立即前往",100);

                result=mFairy.findPic("pic close3.png");
                mFairy.onTap(0.8f,result,"社区结束",200);

                result=mFairy.findPic(new String[]{"pic jiemeng.png","word ce.png"});
                mFairy.onTap(0.8f,result,"解梦测试",200);

                result=mFairy.findPic(353,425,428,492,"word bing.png");
                mFairy.onTap(0.8f,result,"解梦答题 丙",200);

                result=mFairy.findPic(new String []{"pic bird.png","word bendi.png","word da.png","word qianwang.png","word guang.png","pic tszl.png"});
                if(result.sim>0.8){
                    gameUtil.close("结束");
                }

                result=mFairy.findPic("pic caiji.png");
                mFairy.onTap(0.8f,result,"采集",4000);

                //确定和取消选择
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8){
                    result=mFairy.findPic(453,316,813,396,new String[]{"word overflow.png"});
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word cancel.png");
                        mFairy.onTap(0.8f,result,"点击取消",200);
                    }

                    result=mFairy.findPic(453,316,813,396,new String[]{"word weituo1.png","word wangluo.png"});
                    if(result.sim>0.8f){
                        result=mFairy.findPic(719,453,811,528,"word affirm1.png");
                        mFairy.onTap(0.8f,result,"点击确定",200);
                    }
                }

                result=mFairy.findPic(new String[]{"word xunmeng.png","word room.png"});
                picCount=picCount(0.8f,result,"return");
                if(picCount>=5){
                    mFairy.onTap(0.8f,result,33,17,51,40,"退出客栈房间",1000);
                }

                //战斗场景
                result=mFairy.findPic(new String[]{"direction.png","direction1.png"});
                picCount=picCount(0.8f,result,"direction");
                if(result.sim>0.8f){
                    result=mFairy.findPic("direction1.png");
                    mFairy.onTap(0.8f,result,"锁定方向",200);

                    if(picCount<=3)mFairy.onTap(821,188,835,203,"锁定优先攻击",200);
                    result=mFairy.findPic("word hand.png");
                    if (result.sim>0.8){
                        gameUtil.change(514,92,1053,346,"点击攻击");
                    }

                    result=mFairy.findPic("word hand.png");
                    picCount=picCount(0.8f,result,"manual");
                    if(picCount<=4){
                        mFairy.onTap(0.8f,result,"打开自动",100);
                    }

                    result=mFairy.findPic("pic x1.png");
                    picCount=picCount(0.8f,result,"x1");
                    if(picCount==1){
                        mFairy.onTap(0.8f,result,"开启2倍速",100);
                    }
                }

                //运势场景
                result=mFairy.findPic("word yun.png");
                if(result.sim>0.8){
                    mFairy.onTap(0.8f,result,"点击运势,跳过场景",100);

                    result=mFairy.findPic("pic chouqian.png");
                    mFairy.onTap(0.8f,result,"点击抽签",100);

                    result=mFairy.findPic("word jieqian.png");
                    mFairy.onTap(0.8f,result,1018,548,1030,559,"点击解签",100);

                    result=mFairy.findPic("word xiaban.png");
                    if(result.sim>0.8f)gameUtil.close("抽签结束");
                }

                //召唤场景
                result=mFairy.findPic("word zhao.png");
                if(result.sim>0.8){
                    result=mFairy.findPic("pic friend help.png");
                    if(result.sim>0.8){
                        mFairy.sleep(500);
                        mFairy.touchDown(0,397,135);
                        mFairy.touchMove(0,856,135,1000);
                        mFairy.touchUp(0);
                        LtLog.e(mFairy.getLineInfo("花开花瓣"));

                        while(mFairy.condit()){
                            result=mFairy.findPic(new String[]{"affirm.png","affirm1.png"});
                            mFairy.onTap(0.8f,result,"确定",100);

                            result=mFairy.findPic("word affirm.png");
                            mFairy.onTap(0.8f,result,"确定",100);

                            result=mFairy.findPic(0,0,93,71,"return.png");
                            mFairy.onTap(0.8f,result,"util_return",500);

                            result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                            mFairy.onTap(0.8f,result,"关闭窗口",500);

                            result=mFairy.findPic( 535,600,620,700,"tap.png");
                            mFairy.onTap(0.8f,result,"util_点击跳过",200);

                            result=mFairy.findPic("word cancel1.png");
                            mFairy.onTap(0.8f,result,"点击取消",200);

                            result=mFairy.findPic("pic main open.png");
                            picCount=picCount(0.8f,result,"main open");
                            if(picCount>=3){
                                LtLog.e(mFairy.getLineInfo("召唤结束,回到大厅"));
                                return;
                            }
                        }
                    }
                }

                //红线场景
                result=mFairy.findPic("word red.png");
                if(result.sim>0.8){
                    result=mFairy.findPic(1179,123,1265,394,"word xuyuan.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word wang.png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic(1024,134,1104,597,new String[]{"word xuyuan1.png","word xuyuan2.png"});
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"续缘",200);
                            }else{
                                result=mFairy.findPic(687,136,1099,447,"pic susu.png");
                                if(result.sim<0.8f){
                                    gameUtil.close("红尘 续缘结束");
                                }
                            }
                        }
                    }

                    result=mFairy.findPic("word red daily.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(177,173,633,606,"pic daily csgxs.png");
                        if(result.sim>0.8f){
                            result1=mFairy.findPic(177,173,633,606,"pic daily yqcel.png");
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"选中一气惩恶令",200);
                            }else{
                                mFairy.onTap(0.8f,result,"选中藏书阁小试",200);
                            }
                            result=mFairy.findPic("word join.png");
                            mFairy.onTap(0.8f,result,"参加",1000);
                        }
                    }
                }

                //客栈场景
                result=mFairy.findPic("word ke.png");
                if(result.sim>0.8){
                    result=mFairy.findPic("word meet.png");
                    if(result.sim>0.8){
                        result=mFairy.findPic("pic tip.png");
                        if(result.sim>0.8){
                            mFairy.onTap(0.8f,result,"点击提示",200);
                        }else{
                            change=mFairy.change(232,409,265,446);
                            if(!change.equals("0,0")){
                                mFairy.onTap(223,494,234,506,"点击去送礼",200);
                            }else{
                                result=mFairy.findPic(174,154,1096,639,"pic susu.png");
                                if(result.sim<0.8f) {
                                    gameUtil.close("客栈场景结束");
                                }
                            }
                        }
                    }
                }

                //送礼场景
                result=mFairy.findPic("word send1.png");
                if (result.sim>0.8){
                    result=mFairy.findPic("word send.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"点击送礼",200);
                    }else{
                        result=mFairy.findPic(0,0,93,71,"return.png");
                        mFairy.onTap(0.8f,result,"返回客栈",200);
                    }
                }

                //登天门场景
                result=mFairy.findPic(new String[]{"word deng.png","word deng1.png"});
                if(result.sim>0.8){
                    result=mFairy.findPic("pic deng tree.png");
                    if(result.sim>0.8){
                        change=gameUtil.change(443,326,1142,435,"点击解锁关卡");
                        if(!change.equals("0,0")){
                            mFairy.sleep(200);
                            int coordX=Integer.parseInt(change.split(",")[0]);
                            int coordY=Integer.parseInt(change.split(",")[1]);
                            mFairy.onTap(coordX,coordY,coordX+1,coordY+1,"点击挑战关卡",300);
                        }else{
                            gameUtil.close("登天门场景结束");
                        }
                    }

                    result=mFairy.findPic("word tiao.png");
                    if(result.sim>0.8f){
                        colorNum=mFairy.getColorNum(801,559,976,618,0.9f,0,"160,160,160");
                        if(colorNum<2000){
                            mFairy.onTap(0.8f,result,"登天门 点击挑战",5000);
                        }else{
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("登天门选关错误，重新任务"));
                            return;
                        }
                    }
                }

                //武器场景
                result=mFairy.findPic("word wu.png");
                if(result.sim>0.8){
                    result=mFairy.findPic("word shengji.png");
                    if(result.sim>0.8){
                        change = mFairy.change(844, 542, 885, 565);
                        if(!change.equals("0,0")){
                            mFairy.touchDown(0,864,552);
                        }else{
                            mFairy.touchUp(0);
                            gameUtil.close("武器升级结束");
                        }
                    }

                    result=mFairy.findPic("word shengjie.png");
                    if(result.sim>0.8){
                        result=mFairy.findPic("word tupo.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"点击突破",300);
                        }
                        gameUtil.change(891,610,939,635,"点击突破");
                    }
                }

                //好友场景
                result=mFairy.findPic("word hao.png");
                if(result.sim>0.8){
                    change=gameUtil.change(332,643,375,666,"进入社区");
                    if(change.equals("0,0")){
                        gameUtil.close("好友场景结束");
                    }
                }

                //忆梦锤场景
                result=mFairy.findPic("pic yichui.png");
                if(result.sim>0.8){
                    while(mFairy.condit()){
                        mFairy.onTap(113,622,133,640,"左边 忆梦锤",100);
                        mFairy.onTap(1145,632,1159,649,"右边 忆梦锤",100);
                        result=mFairy.findPic("pic yichui.png");
                        if(result.sim<0.8)return;
                    }
                }

                //伙伴详情场景
                result=mFairy.findPic("word huoban.png");
                if(result.sim>0.8){
                    gameUtil.change(1200,357,1228,374,"选择觉醒分页");
                    gameUtil.change(30,16,55,49,"返回主界面");
                }

                //主角场景
                result=mFairy.findPic("word zhujue.png");
                picCount=picCount(0.8f,result,"zhujie");
                if(result.sim>0.8){
                    if(picCount<3)return;
                    result=mFairy.findPic(69,35,1230,709,"pic susu.png");
                    if(result.sim<0.8f){
                        gameUtil.close("情结提升结束");
                    }
                    gameUtil.change(33,173,67,205,"点击提示1");
                    gameUtil.change(99,287,120,307,"点击提示2");
                    gameUtil.change(88,399,115,425,"点击提示3");
                    gameUtil.change(44,523,57,536,"点击提示4");

                    result=mFairy.findPic(1043,111,1122,578,"pic qingjiedian.png");
                    mFairy.onTap(0.8f,result,"情结提升",300);
                }

                //杂货铺场景
                result=mFairy.findPic("word za.png");
                if(result.sim>0.8){
                    gameUtil.change(343,136,371,149,"选中兑换分页");
                    gameUtil.change(200,214,552,479,"选中要兑换的物品");
                    change=gameUtil.change(967,621,1025,651,"兑换");
                    if(!change.equals("0,0")){
                        gameUtil.close("杂货铺兑换结束");
                    }
                }

                //藏书阁小试场景
                result=mFairy.findPic("pic cangshuge.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word huodong yiwancheng.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result,"完成答题,退出藏书阁",200);
                        return;
                    }

                    result=mFairy.findPic("word bing.png");
                    mFairy.onTap(0.8f,result,"答题 丙",200);
                }

                //修行场景
                result=mFairy.findPic("word xiu.png");
                if(result.sim>0.8f){
                    gameUtil.change(324,129,366,153,"伙伴培养");
                    change=gameUtil.change(406,507,446,532,"提升");
                    if(change.equals("0,0")){
                        gameUtil.close("修行场景结束");
                    }
                }

                result=mFairy.findPic("word picture.png");
                mFairy.onTap(0.8f,result,377,582,393,597,"拍照",1000);
                //拍照场景
                result=mFairy.findPic("pic eye.png");
                if(result.sim>0.8){
                    gameUtil.change(25,419,40,433,"预设");
                    gameUtil.change(198,549,211,564,"写真");
                    gameUtil.change(22,479,39,496,"位置");

                    gameUtil.change(1175,204,1193,224,"滤镜");
                    gameUtil.change(850,626,869,649,"对比");
                    gameUtil.change(1171,443,1193,459,"动作");
                    gameUtil.change(1165,329,1192,348,"拍照");

                    mFairy.sleep(200);
                    result=mFairy.findPic(0,0,93,71,"return.png");
                    mFairy.onTap(0.8f,result,"拍照_返回",500);
                }

                //装备场景
                result=mFairy.findPic("word zhuang.png");
                if(result.sim>0.8){
                    gameUtil.change(169,261,189,281,"选择一个伙伴");
                    gameUtil.change(773,268,805,296,"选择一件装备");
                    change=gameUtil.change(640,514,665,528,"装备");
                    if(!change.equals("0,0")){
                        gameUtil.close("装备完毕");
                        return;
                    }
                }

                //涂山比武场景
                result=mFairy.findPic(new String[]{"word tu.png","pic jifen.png"});
                if(result.sim>0.8){
                    mFairy.onTap(30,682,49,696,"新手指引结束",200);
                    gameUtil.close("新手指引完成,任务结束");
                    setTaskEnd();
                    return;
                }

                //进入拼图关卡
                result=mFairy.findPic("pintu.png");
                if(result.sim>0.8f){
                    setTaskName(1);
                    LtLog.e(mFairy.getLineInfo("进入拼图关卡"));
                    return;
                }

                //进入答题关卡
                result=mFairy.findPic("pic dialogue.png");
                if(result.sim>0.8){
                    result=mFairy.findPic(1202,273,1232,354,"dialogue.png");
                    if(result.sim>0.8){
                        setTaskName(2);
                        LtLog.e(mFairy.getLineInfo("进入答题关卡"));
                    }
                    return;
                }

                //风庭云探案关卡
                result=mFairy.findPic("word fengtingyun.png");
                if(result.sim>0.8){
                    setTaskName(3);
                    LtLog.e(mFairy.getLineInfo("进入风庭云探案"));
                    return;
                }
            }

            /**
             * 拼图关卡
             * 完成后，返回主线 content0
             */
            @Override
            public void content_1() throws Exception {
                boolean left=true;
                result=mFairy.findPic("pintu.png");
                if(result.sim>0.8f){
                    for(int i=1;i<=9;i++){
                        result=mFairy.findPic(10,15,282,700,"pin"+i+".png");
                        if(result.sim>0.85f){
                            left=true;
                        }else{
                            result=mFairy.findPic(1035,60,1280,720,"pin"+i+".png");
                            left=false;
                        }
                        if(result.sim>0.85f){
                            int ranX=i%3==0?3:i%3;
                            ranX=(ranX-1)*238+450;
                            if(!left){
                                ranX=ranX-100;
                            }
                            int ranY=i/3;
                            if(i%3!=0)ranY++;
                            ranY=(ranY-1)*143+200;
//                            if(result.y>ranY){
//                                ranY-=20;
//                            }else{
//                                ranY+=20;
//                            }
                            LtLog.e(mFairy.getLineInfo("移动拼图"+i));
                            LtLog.e("移动坐标,"+result.x+","+result.y+",1280,720");
                            LtLog.e("移动坐标到,"+ranX+","+ranY+",1280,720");
                            mFairy.touchDown(0,result.x,result.y);
                            mFairy.touchMove(0,ranX,ranY,750);
                            mFairy.touchUp(0);
                        }
                    }
                }else{
                    setTaskName(0);
                    mFairy.onTap(0.8f,result,"拼图结束",100);
                    return;
                }
            }

            /**
             * 答题关卡
             * @param ansewer 选择第几个回答，每点一下+1，到4后赋为1
             * 完成后，返回主线 content0
             */
            int ansewer=1;
            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("pic dialogue.png");
                if(result.sim>0.8f){
                    mFairy.onTap(1120,300+(ansewer-1)*60,1121,301+(ansewer-1)*60,"回答题目",200);
                    ansewer++;
                    ansewer=ansewer==5?1:ansewer;//等于五则归一
                }else{
                    setTaskName(0);
                    return;
                }
            }

            /**
             * 风庭云探案
             * @throws Exception
             * 完成后，返回主线 content0
             */
            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word huodong.png");
                picCount=picCount(0.8f,result,"activity");
                if(picCount%4==0){
                    mFairy.onTap(0.8f,result,"活动指引",200);
                }

                result=mFairy.findPic(230,115,1083,311,"pic duel.png");
                mFairy.onTap(0.8f,result,"决斗",200);

                result=mFairy.findPic(230,166,1083,311,"pic zhiren.png");
                mFairy.onTap(0.8f,result,"指认凶手",200);

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"点击回应对话",100);

                //战斗场景
                result=mFairy.findPic(new String[]{"direction.png","direction1.png"});
                picCount=picCount(0.8f,result,"direction");
                if(result.sim>0.8f){
                    result=mFairy.findPic("direction1.png");
                    mFairy.onTap(0.8f,result,"锁定方向",200);

                    if(picCount<=3)mFairy.onTap(821,188,835,203,"锁定优先攻击",200);
                    result=mFairy.findPic("word hand.png");
                    if (result.sim>0.8){
                        gameUtil.change(514,92,1053,346,"点击攻击");
                    }

                    result=mFairy.findPic("word hand.png");
                    picCount=picCount(0.8f,result,"manual");
                    if(picCount==1){
                        mFairy.onTap(0.8f,result,"打开自动",100);
                    }

                    result=mFairy.findPic("pic x1.png");
                    picCount=picCount(0.8f,result,"x1");
                    if(picCount==1){
                        mFairy.onTap(0.8f,result,"开启2倍速",100);
                    }
                }

                result=mFairy.findPic("word task.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word fengtingyun.png");
                    if (result.sim<0.8f){
                        gameUtil.close("风庭云探案结束");
                        setTaskName(0);
                    }
                }

                result=mFairy.findPic("word close.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"风庭云探案结束",200);
                    gameUtil.close("风庭云探案结束");
                    setTaskName(0);
                    return;
                }
            }

            public void inOperation() throws Exception {

            }
        }.taskContent(mFairy,"新手指引");
    }

    //日常任务
    public void daily() throws Exception{
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
                taskList=new ArrayList();
                String str= "";
                String arr []=null;
                //每日运势
                String option=AtFairyConfig.getOption("mrys open");
                if(!option.equals("")){
                    if(!option.equals("2")){
                        taskList.add("mrys");
                    }
                }

                //藏书阁小试
                if(AtFairyConfig.getOption("csgxs").equals("1")){
                    taskList.add("csgxs");
                }

                //客栈委托
                if(AtFairyConfig.getOption("kzwt").equals("1")){
                    taskList.add("kzwt");
                }

                //涂山比武
                if(AtFairyConfig.getOption("tsbw").equals("1")){
                    taskList.add("tsbw");
                }

                //登天门
                if(AtFairyConfig.getOption("dtm").equals("1")){
                    taskList.add("dtm");
                }

                //混天典狱
                if(AtFairyConfig.getOption("htdy").equals("1")){
                    taskList.add("htdy");
                }

                //一气惩恶令
                if(AtFairyConfig.getOption("yqcel").equals("1")){
                    taskList.add("yqcel");
                }

                //幕后黑狐
                if(AtFairyConfig.getOption("mhhh").equals("1")){
                    taskList.add("mhhh");
                }

                //除虫行动
                if(AtFairyConfig.getOption("ccxd").equals("1")){
                    taskList.add("ccxd");
                }

                //土狗快递
                if(AtFairyConfig.getOption("tgkd").equals("1")){
                    taskList.add("tgkd");
                }

                //灵猫探宝
                option=AtFairyConfig.getOption("lmtb common");
                if(!option.equals("")){
                    if(!option.equals("2")){
                        taskList.add("lmtb");
                    }
                }

                //每日领奖
                if(AtFairyConfig.getOption("mrlj").equals("1")){
                    taskList.add("mrlj");
                }

                //主线
                if(AtFairyConfig.getOption("main").equals("1")){
                    taskList.add("main");
                }

                //没有任务
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有任务,结束日常"));
                    setTaskEnd();
                    return;
                }
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有日常完成，没有任务了"));
                    setTaskEnd();
                    return;
                }
                successCount=failureCount=daze=0;
                LtLog.e(mFairy.getLineInfo("当前任务="+taskList.get(0)));
                //每日运势
                if(taskList.get(0).equals("mrys")){
                    daily_mrys();
                    taskList.remove(0);
                    return;
                }
                //灵猫探宝
                if(taskList.get(0).equals("lmtb")){
                    daily_lmtb();
                    taskList.remove(0);
                    return;
                }
                //藏书阁小试
                if(taskList.get(0).equals("csgxs")){
                    daily_csgxs();
                    taskList.remove(0);
                    return;
                }
                //客栈委托
                if(taskList.get(0).equals("kzwt")){
                    daily_kzwt();
                    taskList.remove(0);
                    return;
                }
                //涂山比武
                if(taskList.get(0).equals("tsbw")){
                    daily_tsbw();
                    taskList.remove(0);
                    return;
                }
                //登天门
                if(taskList.get(0).equals("dtm")){
                    daily_dtm();
                    taskList.remove(0);
                    return;
                }
                //混天典狱
                if(taskList.get(0).equals("htdy")){
                    daily_htdy();
                    taskList.remove(0);
                    return;
                }
                //一气惩恶令
                if(taskList.get(0).equals("yqcel")){
                    daily_yqcel();
                    taskList.remove(0);
                    return;
                }
                //土狗快递
                if(taskList.get(0).equals("tgkd")){
                    daily_tgkd();
                    taskList.remove(0);
                    return;
                }
                //幕后黑狐
                if(taskList.get(0).equals("mhhh")){
                    daily_mhhh();
                    taskList.remove(0);
                    return;
                }
                //除虫行动
                if(taskList.get(0).equals("ccxd")){
                    daily_ccxd();
                    taskList.remove(0);
                    return;
                }

                //每日领奖
                if(taskList.get(0).equals("mrlj")){
                    daily_mrlj();
                    taskList.remove(0);
                    return;
                }

                //主线
                if(taskList.get(0).equals("main")){
                    daily_main();
                    taskList.remove(0);
                    return;
                }
            }
        }.taskContent(mFairy,"日常任务");
    }

    //每日运势
    public void daily_mrys()throws Exception{
        new SingleTask(mFairy) {
            boolean mrys_open=false;
            public void create(){
                String option=AtFairyConfig.getOption("mrys open");
                if(!option.equals("")){
                    if(!option.equals("2")){
                        mrys_open=option.equals("1")?true:false;
                    }
                }
            }
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,4,204,32,251,"回到任务栏",Sleep);

                result = mFairy.findPic(1,133,41,192,"display.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result = mFairy.findPic(46,152,240,289,"Daily cultivation.png");
                mFairy.onTap(0.7f,result,"左侧种植",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily mrys.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                result=mFairy.findPic("word yun.png");
                if(result.sim>0.8){
                    picCount=picCount(0.8f,result,"yun");
                    if(picCount%5==0)mFairy.onTap(0.8f,result,"点击运势,跳过场景",100);

                    result=mFairy.findPic("pic chouqian.png");
                    mFairy.onTap(0.8f,result,"点击抽签",100);

                    result=mFairy.findPic("word jieqian.png");
                    mFairy.onTap(0.8f,result,1018,548,1030,559,"点击解签",100);

                    //是否解签
                    if(mrys_open){
                        result=mFairy.findPic("word fengshang.png");
                        mFairy.onTap(0.8f,result,"奉上一万铜钱",200);
                        result=mFairy.findPic(new String[]{"word xiaban.png","word jiaban.png"});
                    }else{
                        result=mFairy.findPic("word fengshang.png");
                    }
                    if(result.sim>0.8f){
                        setTaskEnd();
                        return;
                    }
                }

                result=mFairy.findPic( 535,600,620,700,"tap.png");
                mFairy.onTap(0.8f,result,"每日运势_点击跳过",200);
            }
        }.taskContent(mFairy, "每日运势");
    }

    //灵猫探宝
    public void daily_lmtb()throws Exception{
        new SingleTask(mFairy) {
            boolean lmtb_common=true;
            @Override
            public void create() throws Exception {
                //灵猫探宝
                 String option=AtFairyConfig.getOption("lmtb common");
                if(!option.equals("")){
                    if(!option.equals("2")){
                        lmtb_common=option.equals("0")?false:true;
                    }
                }
            }

            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,"word kzwt entrust.png");
                mFairy.onTap(0.7f,result,"客栈委托指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily lmtb.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                result=mFairy.findPic("pic yemei.png");
                if(result.sim>0.8f){
                    if(lmtb_common){
                        result=mFairy.findPic("pic common clues none.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("普通寻宝符不足，任务结束"));
                            result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                            mFairy.onTap(0.8f,result,"关闭窗口",200);
                            setTaskEnd();
                            return;
                        }else{
                            result=mFairy.findPic(76,101,1187,674,"pic common clues.png");
                            mFairy.onTap(0.8f,result,"普通线索",1000);
                        }
                    }else{
                        result=mFairy.findPic("pic rare clues none.png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("稀有寻宝符不足，任务结束"));
                            result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                            mFairy.onTap(0.8f,result,"关闭窗口",200);
                            setTaskEnd();
                            return;
                        }else{
                            result=mFairy.findPic(76,101,1187,674,"pic rare clues.png");
                            mFairy.onTap(0.8f,result,"稀有线索",1000);
                        }
                    }
                }

                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8f){
                        daze=0;
                        mFairy.sleep(1000);
                        LtLog.e(mFairy.getLineInfo("自动寻路中"));
                    }else{
                        if(daze++>=14){
                            LtLog.e(mFairy.getLineInfo("灵猫探宝发呆超时，重启任务"));
                            setTaskName(0);
                            return;
                        }
                        LtLog.e(mFairy.getLineInfo("灵猫探宝发呆超时="+daze));
                        mFairy.sleep(200);
                    }
                }

                result=mFairy.findPic(535,625,704,705,"tap.png");
                mFairy.onTap(0.8f,result,"灵猫探宝_点击屏幕继续",200);

                result=mFairy.findPic("word exit copy.png");
                if(result.sim>0.8f){
                    setTaskName(0);
                    mFairy.onTap(0.8f,result,"退出副本，继续寻宝",200);
                    return;
                }

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    if(lmtb_common){
                        //1000铜钱
                        result=mFairy.findPic("word lmtb common.png");
                        mFairy.onTap(0.8f,result,"打探普通线索",200);
                    }else{
                        //2000铜钱
                        result=mFairy.findPic("word lmtb rare.png");
                        mFairy.onTap(0.8f,result,"打探稀有线索",200);
                    }
                    if(result.sim<0.8){
                        mFairy.onTap(0.8f,result,"点击回应对话",200);
                    }
                }

                result=mFairy.findPic(new String[]{"pic common xunbaofu.png","pic rare xunbaofu.png"});
                picCount=picCount(0.8f,result,"xunbao");
                if(picCount==1){
                    mFairy.onTap(0.8f,result,"寻宝",200);
                }

                if(picCount>=10){
                    LtLog.e(mFairy.getLineInfo("夜魅寻宝符不足，灵猫探宝结束"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "灵猫探宝");
    }

    //藏书阁小试
    public void daily_csgxs()throws Exception{
        new SingleTask(mFairy) {
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("organize a team.png");
                mFairy.onTap(0.8f,result,4,204,32,251,"回到任务栏",Sleep);

                result = mFairy.findPic(1,133,41,192,"display.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result = mFairy.findPic(46,152,240,289,"Daily cultivation.png");
                mFairy.onTap(0.7f,result,"左侧种植",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily csgxs.png",0);
                if (ret==1){
                    daze=0;
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                //回应对话
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    result1=mFairy.findPic(1071,341,1157,508,"word cangshuge.png");
                    if(result1.sim<0.8){
                        mFairy.onTap(0.8f,result,"点击回应对话",200);
                    }else{
                        mFairy.onTap(0.8f,result,"进入藏书阁小试",200);
                    }
                }

                //计算发呆超时
                result=mFairy.findPic("word task.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic cangshuge.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic(550,527,585,620,"word auto.png");
                        if(result.sim>0.8f){
                            daze=0;
                            LtLog.e(mFairy.getLineInfo("藏书阁小试自动寻路中..."));
                            mFairy.sleep(1000);
                        }else{
                            daze++;
                            if(daze>=10){
                                setTaskName(0);
                                LtLog.e(mFairy.getLineInfo("发呆超时，重启任务"));
                            }else{
                                mFairy.sleep(500);
                                LtLog.e(mFairy.getLineInfo("藏书阁小试发呆超时="+daze));
                            }
                        }
                    }
                }

                result=mFairy.findPic("word bing.png");
                mFairy.onTap(0.8f,result,"答题 丙",200);

                result=mFairy.findPic("word huodong yiwancheng.png");
                if(result.sim>0.8f){
                    while(mFairy.condit()){
                        result=mFairy.findPic("pic cangshuge.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"完成答题,退出藏书阁",200);
                        }else{
                            setTaskEnd();
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy, "藏书阁小试");
    }

    //客栈委托
    public void daily_kzwt()throws Exception{
        new SingleTask(mFairy) {
            boolean fight=false;
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,"word kzwt entrust.png");
                mFairy.onTap(0.7f,result,"客栈委托指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily kzwt.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                result=mFairy.findPic("word ke.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic kezhan tip.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"接取任务",200);
                    }else{
                        dazeTime=mFairy.dazeTime(371,638,417,673,0.8f,0,"125,109,82");
                        if(dazeTime>=20){
                            setTaskName(0);
                            LtLog.e(mFairy.getLineInfo("客栈没有任务，前往天书获取"));
                        }
                    }
                }

                result=mFairy.findPic("pic dialogue.png");
                if(result.sim>0.8){
                    result=mFairy.findPic(1202,273,1232,354,"dialogue.png");
                    if(result.sim>0.8){
                        setTaskName(4);
                        LtLog.e(mFairy.getLineInfo("进入答题关卡"));
                        return;
                    }
                }

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"点击回应对话",200);

                result=mFairy.findPic("pic caiji.png");
                mFairy.onTap(0.9f,result,"采集",4000);

                //进入战斗的状态
                result=mFairy.findPic("pic yu.png");
                if(result.sim>0.8f){
                    fight=true;
                    daze=0;
                    LtLog.e(mFairy.getLineInfo("进入战斗中"));
                    mFairy.sleep(1000);
                }

                //主界面
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8f){
                        daze=0;
                        failureCount=0;
                        LtLog.e(mFairy.getLineInfo("客栈委托自动寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>=7){
                            if(fight){
                                if(failureCount++>=3){
                                    gameUtil.close();
                                    LtLog.e(mFairy.getLineInfo("客栈委托连续失败三次以上，任务结束"));
                                    setTaskEnd();
                                    return;
                                }else{
                                    LtLog.e(mFairy.getLineInfo("客栈委托连续失败"+failureCount+"次"));
                                }
                            }
                            LtLog.e(mFairy.getLineInfo("客栈委托发呆超时，重启任务"));
                            setTaskName(0);
                        }else{
                            LtLog.e(mFairy.getLineInfo("客栈委托发呆超时="+daze));
                            mFairy.sleep(200);
                        }
                    }
                }

                //进入拼图关卡
                result=mFairy.findPic("pintu.png");
                if(result.sim>0.8f){
                    failureCount=0;
                    setTaskName(5);
                    LtLog.e(mFairy.getLineInfo("进入拼图关卡"));
                    return;
                }

                //购买后上交
                result=mFairy.findPic("pic money1.png");
                picCount=picCount(0.8f,result,"money1");
                if(picCount==1){
                    mFairy.onTap(0.8f,result,"点击购买",200);
                    while(mFairy.condit()){
                        result=mFairy.findPic(466,480,1250,633,"word buy.png");
                        mFairy.onTap(0.8f,result,"点击购买",200);

                        result=mFairy.findPic(0,0,93,71,"return.png");
                        mFairy.onTap(0.8f,result,"util_return",500);

                        result=mFairy.findPic(753,0,1280,317,new String[]{"pic close1.png","pic close3.png"});
                        mFairy.onTap(0.8f,result,"关闭窗口",500);

                        result=mFairy.findPic( 535,600,620,700,"tap.png");
                        mFairy.onTap(0.8f,result,"util_点击跳过",200);

                        result=mFairy.findPic("word cancel1.png");
                        mFairy.onTap(0.8f,result,"点击取消",200);

                        result=mFairy.findPic("pic main open.png");
                        picCount=picCount(0.8f,result,"main open");
                        if(picCount>=3){
                            LtLog.e(mFairy.getLineInfo("close结束,回到大厅"));
                            return;
                        }

                    }
                }

                //交易行
                result=mFairy.findPic("word jiao.png");
                picCount=picCount(0.8f,result,"deal");
                if(result.sim>0.8f){
                    if(picCount<=2){
                        mFairy.onTap(670,232,685,246,"选中要购买的东西",200);
                    }

                    result=mFairy.findPic(466,480,1250,633,"word buy.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"点击购买",200);

                        LtLog.e(mFairy.getLineInfo("回到大厅"));
                        while(mFairy.condit()){
                            result=mFairy.findPic(0,0,93,71,"return.png");
                            mFairy.onTap(0.8f,result,"util_return",500);

                            result=mFairy.findPic(753,0,1280,317,"pic close1.png");
                            mFairy.onTap(0.8f,result,"关闭窗口",500);

                            result=mFairy.findPic("word money none.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(498,477,522,496,"银两不足，任务无法继续，取消前往",200);
                                setTaskEnd();
                                return;
                            }

                            result=mFairy.findPic("pic tianshu.png");
                            picCount=picCount(0.8f,result,"sky book");
                            if(picCount>=3){
                                LtLog.e(mFairy.getLineInfo("close结束,回到大厅"));
                                return;
                            }
                        }
                    }
                }

                result=mFairy.findPic("word shangjiao.png");
                mFairy.onTap(0.8f,result,"上交",200);

            }

            /**
             * 答题关卡
             * 完成后，返回主线 content3
             */
            @Override
            public void content_4() throws Exception {
                int ansewer=1;
                while(mFairy.condit()){
                    result=mFairy.findPic("pic dialogue.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(1120,300+(ansewer-1)*60,1121,301+(ansewer-1)*60,"回答题目",200);
                        ansewer++;
                        ansewer=ansewer==5?1:ansewer;//等于五则归一
                    }else{
                        LtLog.e(mFairy.getLineInfo("答题结束"));
                        setTaskName(3);
                        return;
                    }
                }
            }

            /**
             * 拼图关卡
             * 完成后，返回主线 content3
             */
            @Override
            public void content_5() throws Exception {
                mFairy.sleep(200);
                mFairy.condit();
                int type=0;
                for(int i=1;i<=3;i++){
                        result=mFairy.findPic("kzwt"+i+" pin.png");
                        if(result.sim>0.7f){
                            type=i;
                            break;
                        }
                }
                //1白尾红霞(白尾青芳) 2王权富贵(清瞳) 3颜如玉(律笺文)
                if(type==0){
                    setTaskEnd();
                    LtLog.e(mFairy.getLineInfo("没有该拼图"));
                    return;
                }
                LtLog.e(mFairy.getLineInfo("拼图type="+type));
                boolean left=true;
                while(mFairy.condit()){
                    result=mFairy.findPic("pintu.png");
                    if(result.sim>0.8f){
                        for(int i=1;i<=9;i++){
                            result=mFairy.findPic(10,15,282,700,"kzwt"+type+" pin"+i+".png");
                            if(result.sim>0.85f){
                                left=true;
                            }else{
                                result=mFairy.findPic(1035,60,1280,720,"kzwt"+type+" pin"+i+".png");
                                left=false;
                            }
                            if(result.sim>0.85f){
                                int ranX=i%3==0?3:i%3;
                                ranX=(ranX-1)*238+450;
                                if(!left){
                                    ranX=ranX-100;
                                }
                                int ranY=i/3;
                                if(i%3!=0)ranY++;
                                ranY=(ranY-1)*143+200;
//                                LtLog.e(mFairy.getLineInfo("移动拼图"+i));
//                                LtLog.e("移动坐标,"+result.x+","+result.y+",1280,720");
//                                LtLog.e("移动坐标到,"+ranX+","+ranY+",1280,720");
                                mFairy.touchDown(0,result.x,result.y);
                                mFairy.touchMove(0,ranX,ranY,750);
                                mFairy.sleep(250);
                                mFairy.touchUp(0);
                            }
                        }
                    }else{
                        setTaskName(0);
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "客栈委托");
    }

    //涂山比武
    public void daily_tsbw() throws Exception{
        new SingleTask(mFairy) {
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(5,201,217,366,"word huodong deal worm action.png");
                mFairy.onTap(0.7f,result,"除虫行动活动指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 160,214, 160,346, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily tsbw.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                //计算作战胜利的次数
                result1=mFairy.findPic(new String []{"pic victory.png","pic victory1.png"});
                picCount=picCount(0.8f,result1,"success");
                if(result1.sim>0.8f&&picCount==1){
                    failureCount=0;
                    successCount++;
                    mFairy.onTap(0.8f,result1,"胜利次数="+successCount,200);
                }else{
                    //计算作战失败的次数
                    result1=mFairy.findPic("pic failure.png");
                    picCount=picCount(0.8f,result1,"failure");
                    if(result1.sim>0.8f&&picCount==1){
                        failureCount++;
                        mFairy.onTap(0.8f,result1,"失败次数="+failureCount,200);
                    }
                }
                if(result1.sim<0.8f){
                    result=mFairy.findPic(535,625,704,705,"tap.png");
                    mFairy.onTap(0.8f,result,"点击屏幕继续",200);
                }

                if(failureCount>=1){
                    gameUtil.close("涂山比武结束");
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(653,3,724,55,"word lun.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("word xuan.png");
                    if(result1.sim>0.8f){
                        result=mFairy.findPic("word tiao1.png");
                        mFairy.onTap(0.8f,result,"挑战",1000);
                    }else{
                        switch (failureCount){
                            case 0:
                                mFairy.onTap(351,363,367,380,"挑选对手1",1000);
                                break;
                            case 1:
                                mFairy.onTap(617,407,634,424,"挑选对手2",1000);
                                break;
                            case 2:
                                mFairy.onTap(914,399,932,414,"挑选对手3",1000);
                                break;
                        }
                    }
                }

                //阵容编辑
                result=mFairy.findPic("word zhen.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(638,662,1139,710,"word fuhuo.png");
                    if(result.sim>0.8f){
                        gameUtil.close("涂山比武结束");
                        setTaskEnd();
//                        mFairy.onTap(0.8f,result,"复活",500);
                    }else{
                        result=mFairy.findPic(1148,594,1264,687,"word chuzhan.png");
                        mFairy.onTap(0.8f,result,"出战",500);
                    }
                }
            }
        }.taskContent(mFairy, "涂山比武");
    }

    //除虫行动
    public void daily_ccxd() throws Exception{
        new SingleTask(mFairy) {
            boolean fight=false;
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(5,201,217,366,"word huodong deal worm action.png");
                mFairy.onTap(0.7f,result,"除虫行动活动指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 160,214, 160,346, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily ccxd.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                //回应对话
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    result1=mFairy.findPic(1070,383,1190,504,new String[]{"word chuchongxingdong.png","word dialogue jiequ.png"});
                    if(result1.sim<0.8){
                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                    }else{
                        mFairy.onTap(0.8f,result1,"除虫行动,接取除虫行动",100);
                    }
                }

                //已经完成20次
                result=mFairy.findPic(400,306,870,396,"word hint already finish.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(458,442,562,523,"word cancel1.png");
                    mFairy.onTap(0.8f,result,"取消",200);
                }

                //进入战斗的状态
                result=mFairy.findPic("pic yu.png");
                if(result.sim>0.8f){
                    fight=true;
                    daze=0;
                    LtLog.e(mFairy.getLineInfo("进入战斗中"));
                    mFairy.sleep(1000);
                }

                //主界面
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8f){
                        daze=0;
                        failureCount=0;
                        LtLog.e(mFairy.getLineInfo("除虫行动自动寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        if(daze++>=7){
                            if(fight){
                                if(failureCount++>=3){
                                    gameUtil.close();
                                    LtLog.e(mFairy.getLineInfo("除虫行动连续失败三次以上，任务结束"));
                                    setTaskEnd();
                                    return;
                                }else{
                                    LtLog.e(mFairy.getLineInfo("除虫行动连续失败"+failureCount+"次"));
                                }
                            }
                            LtLog.e(mFairy.getLineInfo("除虫行动发呆超时，重启任务"));
                            setTaskName(0);
                        }else{
                            LtLog.e(mFairy.getLineInfo("除虫行动发呆超时="+daze));
                            mFairy.sleep(200);
                        }
                    }
                }
            }

        }.taskContent(mFairy, "除虫行动");
    }

    //一气惩恶令
    public void daily_yqcel()throws Exception{
        new SingleTask(mFairy) {
            long dazeTime=0;
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,"word kzwt entrust.png");
                mFairy.onTap(0.7f,result,"客栈委托指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily yqcel.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    result1=mFairy.findPic("word weituo.png");
                    if(result1.sim<0.8){
                        mFairy.onTap(0.8f,result,"点击回应对话",1000);
                    }else{
                        mFairy.onTap(0.8f,result1,"委托战斗",1000);
                    }
                }

                //一气惩恶令 取消
                result=mFairy.findPic("word yqcel cancel.png");
                picCount=picCount(0.8f,result,"yqcel cancel");
                if(result.sim>0.8f){
                    if(successCount>=10){
                        mFairy.onTap(0.8f,result,"停止一气惩恶令，一气惩恶令完成",200);
                        setTaskEnd();
                        return;
                    }
                    daze=0;
                    if(picCount==1){
                        LtLog.e(mFairy.getLineInfo("进入一气惩恶令,作战胜利次数="+successCount));
                    }
                }

                //计算作战胜利的次数
                result1=mFairy.findPic("pic victory.png");
                picCount=picCount(0.8f,result1,"success");
                if(result1.sim>0.8f&&picCount==1){
                    failureCount=0;
                    successCount++;
                    mFairy.onTap(0.8f,result1,"胜利次数="+successCount,200);
                }else{
                    //计算作战失败的次数
                    result1=mFairy.findPic("pic failure.png");
                    picCount=picCount(0.8f,result1,"failure");
                    if(result1.sim>0.8f&&picCount==1){
                        failureCount++;
                        mFairy.onTap(0.8f,result1,"失败次数="+failureCount,200);
                    }
                }
                if(result1.sim<0.8f){
                    result=mFairy.findPic(535,625,704,705,"tap.png");
                    mFairy.onTap(0.8f,result,"点击屏幕继续",200);
                }

                //连续失败3次结束任务
                if(failureCount>=3){
                    setTaskEnd();
                    LtLog.e(mFairy.getLineInfo("一气惩恶令连续失败3次，结束任务"));
                    return;
                }

                //计算超时
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8f){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("一气惩恶令自动寻路中"));
                        mFairy.sleep(1000);
                        return;
                    }else{
                        if(daze++>=10){
                            LtLog.e(mFairy.getLineInfo("一气惩恶令_发呆超时="+daze));
                            setTaskName(0);
                            return;
                        }else{
                            mFairy.sleep(300);
                            LtLog.e(mFairy.getLineInfo("一气惩恶令_发呆超时="+daze));
                        }
                    }
                }
            }
        }.taskContent(mFairy, "一气惩恶令");
    }

    //土狗快递
    public void daily_tgkd()throws Exception{
        new SingleTask(mFairy) {
            int successCount=0,failureCount=0;
            long dazeTime=0;
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,"word kzwt entrust.png");
                mFairy.onTap(0.7f,result,"客栈委托指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily tgkd.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                //土狗快递场景
                result=mFairy.findPic("word huodong.png");
                mFairy.onTap(0.8f,result,"活动指引",200);

                result=mFairy.findPic("word chuzhan.png");
                mFairy.onTap(0.8f,result,"出战",200);

                result=mFairy.findPic(550,527,585,620,"word auto.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic("pic shahucheng.png");
                    picCount=picCount(0.8f,result,"shahucheng");
                    if(picCount>=7){
                        LtLog.e(mFairy.getLineInfo("忆梦锤不足，无法继续任务，结束任务"));
                        setTaskEnd();
                        return;
                    }
                }

                //计算作战胜利的次数
                result1=mFairy.findPic("pic victory.png");
                picCount=picCount(0.8f,result1,"success");
                if(result1.sim>0.8f&&picCount==1){
                    failureCount=0;
                    successCount++;
                    mFairy.onTap(0.8f,result1,"胜利次数="+successCount,200);
                }else{
                    //计算作战失败的次数
                    result1=mFairy.findPic("pic failure.png");
                    picCount=picCount(0.8f,result1,"failure");
                    if(result1.sim>0.8f&&picCount==1){
                        failureCount++;
                        mFairy.onTap(0.8f,result1,"失败次数="+failureCount,200);
                    }
                }
                if(result1.sim<0.8f){
                    result=mFairy.findPic(535,625,704,705,"tap.png");
                    mFairy.onTap(0.8f,result,"点击屏幕继续",200);
                }

                //连续失败3次结束任务
                if(failureCount>=3){
                    LtLog.e(mFairy.getLineInfo("土狗快递失败3次，结束任务"));
                    setTaskEnd();
                    return;
                }

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    result1=mFairy.findPic(new String[]{"word kuaidi.png"});
                    if(result1.sim<0.8){
                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                    }else{
                        mFairy.onTap(0.8f,result1,"土狗快递",100);
                    }
                }

                result=mFairy.findPic("pic yichui.png");
                if(result.sim>0.8){
                    while(mFairy.condit()){
                        mFairy.onTap(113,622,133,640,"左边 忆梦锤",100);
                        mFairy.onTap(1145,632,1159,649,"右边 忆梦锤",100);
                        result=mFairy.findPic("pic yichui.png");
                        if(result.sim<0.8)break;
                    }
                }

                result=mFairy.findPic("word get.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"领取奖励",200);
                    setTaskName(0);
                    return;
                }
            }
        }.taskContent(mFairy, "土狗快递");
    }

    //登天门
    public void daily_dtm()throws Exception{
        new SingleTask(mFairy) {
            int state=0;
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(2);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,"word kzwt entrust.png");
                mFairy.onTap(0.7f,result,"客栈委托指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily dtm.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                //回应对话
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8) {
                    result1 = mFairy.findPic(1070, 383, 1190, 504,"word dialogue dtm.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"登天门",200);
                    }else{
                        mFairy.onTap(0.8f,result1,"登天门_回应对话",200);
                    }
                }

                result=mFairy.findPic("word deng.png");
                picCount=picCount(0.8f,result,"deng");
                if(result.sim>0.8){
                    if(picCount==1){
                        mFairy.sleep(500);
                        state=0;
                    }

                    if(state==0){
                        for (int i=0;i<=4;i++){
                            result=mFairy.findPic(1070-i*156,510,1130-i*156,570,"pic lock2.png");
                            if(result.sim<0.8){
                                mFairy.onTap(1070-i*156,550,1130-i*156,551,"选中"+(5-i)+"关卡",500);
                                state=2;
                                return;
                            }
                        }
                    }

                    result=mFairy.findPic(875,562,943,621,"word tiao.png");
                    mFairy.onTap(0.8f,result,"开始挑战",500);
                }

                result=mFairy.findPic( 535,600,620,700,"tap.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("pic failure.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result,"登天门_挑战失败，任务结束",200);
                        setTaskEnd();
                        return;
                    }
                    mFairy.onTap(0.8f,result,"登天门_点击跳过",200);
                }

                result=mFairy.findPic( 670,652,790,707 ,"tap.png");
                mFairy.onTap(0.8f,result,"登天门_胜利跳过",200);

                result=mFairy.findPic("word tiao.png");
                if(result.sim>0.8f){
                    colorNum=mFairy.getColorNum(801,559,976,618,0.9f,0,"160,160,160");
                    if(colorNum<2000){
                        mFairy.onTap(0.8f,result,"登天门 点击挑战",5000);
                    }else{
                        setTaskName(0);
                        LtLog.e(mFairy.getLineInfo("登天门选关错误，重新任务"));
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "登天门");
    }

    //混天典狱
    public void daily_htdy()throws Exception{
        new SingleTask(mFairy) {
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,130,250,187,"word huodong htdy.png");
                mFairy.onTap(0.7f,result,"混天典狱指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }else{
                    setTaskName(2);return;
                }
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily htdy.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"点击回应对话",200);

                //计算超时
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8f){
                        daze=0;
                        LtLog.e(mFairy.getLineInfo("混天典狱自动寻路中"));
                        mFairy.sleep(1000);
                        return;
                    }else{
                        if(daze++>=7){
                            LtLog.e(mFairy.getLineInfo("混天典狱_发呆超时="+daze));
                            setTaskName(0);
                            return;
                        }else{
                            LtLog.e(mFairy.getLineInfo("混天典狱_发呆超时="+daze));
                        }
                    }
                }

                result=mFairy.findPic("word get1.png");
                mFairy.onTap(0.8f,result,"每日奖励领取",200);

                result=mFairy.findPic("word kaizhan.png");
                mFairy.onTap(0.8f,result,"开战",200);

                result=mFairy.findPic("word huodong.png");
                mFairy.onTap(0.8f,result,"活动指引",200);

                result=mFairy.findPic( 670,652,790,707 ,"tap.png");
                mFairy.onTap(0.8f,result,"混天典狱_胜利跳过",200);

                result1=mFairy.findPic( 535,600,620,700,"tap.png");
                if(result1.sim>0.8f){
                    result=mFairy.findPic("pic failure.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,"挑战失败,点击继续",100);
                        //完成副本,退出任务
                        LtLog.e(mFairy.getLineInfo("混天典狱完成"));
                        while(mFairy.condit()){
                            result=mFairy.findPic("word exit copy.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"退出副本",200);
                                result=mFairy.findPic(730,469,795,507,"word affirm.png");
                                mFairy.onTap(0.8f,result,"确定退出副本",200);
                            }else{
                                break;
                            }
                        }
                        setTaskEnd();
                        return;
                    }else{
                        mFairy.onTap(0.8f,result1,"混天典狱_点击跳过",200);
                    }
                }
            }
        }.taskContent(mFairy, "混天典狱");
    }

    //幕后黑狐
    public void daily_mhhh()throws Exception{
        new SingleTask(mFairy) {
            boolean fight=false;
            int hhCount=0;
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,new String []{"word huodong muhou.png","word huodong deal worm action.png"});
                mFairy.onTap(0.75f,result,"幕后黑狐指引",Sleep);
                if (result.sim>0.75f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("pic daily mhhh.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                //回应对话
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8){
                    result1=mFairy.findPic("word dialogue sanweiheiliang.png");
                    if(result1.sim>0.8f){
                        if(hhCount++>3){
                            mFairy.onTap(0.8f,result,718,361,729,372,"已经对战黑狐3次，结束幕后黑狐任务",200);
                            setTaskEnd();
                            return;
                        }else{
                            mFairy.onTap(0.8f,result,"对战黑狐，降服妖怪次数="+hhCount,1000);
                        }
                        mFairy.onTap(0.8f,result,"除虫行动_回应对话",1000);
                    }

                    result1=mFairy.findPic(1070,383,1190,504,new String[]{"word chuchongxingdong.png","word dialogue jiequ.png"});
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"接取除虫行动",200);
                    }else{
                        mFairy.onTap(0.8f,result,"除虫行动_回应对话",200);
                    }
                }

                //已经完成20次
                result=mFairy.findPic(400,306,870,396,"word hint already finish.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(458,442,562,523,"word cancel1.png");
                    mFairy.onTap(0.8f,result,"取消",200);
                }


                //进入战斗的状态
                result=mFairy.findPic("pic yu.png");
                if(result.sim>0.8f){
                    fight=true;
                    daze=0;
                    LtLog.e(mFairy.getLineInfo("进入战斗中"));
                    mFairy.sleep(1000);
                }

                //主界面
                result=mFairy.findPic("pic main open.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim>0.8f){
                        daze=0;
                        failureCount=0;
                        LtLog.e(mFairy.getLineInfo("除虫行动自动寻路中"));
                        mFairy.sleep(1000);
                    }else{
                        //累计发呆次数
                        if(daze++>=7){
                            if(fight){
                                //累计失败次数
                                if(failureCount++>=3){
                                    gameUtil.close();
                                    LtLog.e(mFairy.getLineInfo("除虫行动连续失败三次以上，任务结束"));
                                    setTaskEnd();
                                    return;
                                }else{
                                    LtLog.e(mFairy.getLineInfo("除虫行动连续失败"+failureCount+"次"));
                                }
                            }
                            LtLog.e(mFairy.getLineInfo("除虫行动发呆超时，重启任务"));
                            setTaskName(0);
                        }else{
                            LtLog.e(mFairy.getLineInfo("除虫行动发呆超时="+daze));
                            mFairy.sleep(200);
                        }
                    }
                }
            }
        }.taskContent(mFairy, "幕后黑狐");
    }

    //每日领奖
    public void daily_mrlj()throws Exception{
        new SingleTask(mFairy){
            List<String> taskList=new ArrayList<String>();
            @Override
            public void create() throws Exception {
                super.create();
                taskList.add("mrzg");
                taskList.add("zxjl");
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("每日领奖完成"));
                    setTaskEnd();
                    return;
                }
                gameUtil.close("content_回到大厅");
                setTaskName(1);
            }
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("pic activity.png");
                mFairy.onTap(0.8f,result,"打开活动",500);

                //每日直购
                if(taskList.get(0).equals("mrzg")){
                    result=mFairy.findPic("word huo.png");
                    mFairy.onTap(0.8f,result,"活动",200);

                    result=mFairy.findPic(127,119,284,516,"word zhigou.png");
                    mFairy.onTap(0.8f,result,"每日直购",200);

                    result=mFairy.findPic("word lingqu.png");
                    mFairy.onTap(0.8f,result,"领取每日免费礼包",200);

                    result=mFairy.findPic("word get2.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("免费礼包已经领完"));
                        setTaskName(0);
                        taskList.remove(0);
                        return;
                    }
                }
                //在线领奖
                if(taskList.get(0).equals("zxjl")){
                    result=mFairy.findPic("word fu.png");
                    mFairy.onTap(0.8f,result,"福利",200);

                    result=mFairy.findPic(127,119,284,516,"word zaixian.png");
                    mFairy.onTap(0.8f,result,"在线奖励",200);

                    result=mFairy.findPic("word zaixian.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word lingqu1.png");
                        mFairy.onTap(0.8f,result,"领取在线奖励",300);
                        if(result.sim<0.8f){
                            LtLog.e(mFairy.getLineInfo(""));
                            setTaskName(0);
                            taskList.remove(0);
                            return;
                        }
                    }
                }
            }
        }.taskContent(mFairy,"每日领奖");
    }

    //主线
    public void daily_main()throws Exception{
        new SingleTask(mFairy) {
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(3);
                daze=0;
            }

            /**
             * 如果任务已经接取，不需要继续执行工具类中找任务方法，直接开始setTaskName(3)
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8, 2)) return;
                result = mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);

                result=mFairy.findPic(1,200,239,363,"word kzwt entrust.png");
                mFairy.onTap(0.7f,result,"客栈委托指引",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 3, 139,319, 132,195, 1000, 1500);
            }

            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                setTaskName(3);return;
            }

            /**
             * 任务执行过程
             * @throws Exception
             */
            public void content_3() throws Exception {
                result=mFairy.findPic("word start new trip.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("主线结束"));
                    successCount=failureCount=0;
                    setTaskEnd();
                    return;
                }

                result1=mFairy.findPic("word zhu.png");
                picCount=picCount(0.8f,result,"main");
                if(result1.sim>0.8&&picCount%7==0){
                    colorNum=mFairy.getColorNum(553,575,723,605,"102,102,204",0.9f);
                    if(colorNum<100){
                        mFairy.onTap(0.8f,result1,"点击主线指引",200);
                    }else{
                        LtLog.e(mFairy.getLineInfo("自动寻路中"));
                    }
                }

                result=mFairy.findPic("word mubiao.png");
                mFairy.onTap(0.8f,result,"目标指引",100);

                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic(964,284,1213,500,new String[]{"word yimengchui.png","word dialogue start answer.png"});
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"使用忆梦锤,开始答题",200);
                    }else{
                        result1=mFairy.findPic(1202,273,1232,354,"dialogue.png");
                        if(result1.sim>0.8){
                            setTaskName(4);
                            LtLog.e(mFairy.getLineInfo("进入答题关卡"));
                            return;
                        }
                        mFairy.onTap(0.8f,result,"点击回应对话",100);
                    }
                }

                result=mFairy.findPic("pic take back.png");
                mFairy.onTap(0.8f,result,"main_收回",100);

                //计算作战胜利的次数
                result1=mFairy.findPic("pic victory.png");
                picCount=picCount(0.8f,result1,"success");
                if(result1.sim>0.8f&&picCount==1){
                    failureCount=0;
                    successCount++;
                    mFairy.onTap(0.8f,result1,"胜利次数="+successCount,200);
                }else{
                    //计算作战失败的次数
                    result1=mFairy.findPic("pic failure.png");
                    picCount=picCount(0.8f,result1,"failure");
                    if(result1.sim>0.8f&&picCount==1){
                        failureCount++;
                        mFairy.onTap(0.8f,result1,"失败次数="+failureCount,200);
                    }
                }
                if(result1.sim<0.8f){
                    result=mFairy.findPic(535,625,704,705,"tap.png");
                    mFairy.onTap(0.8f,result,"点击屏幕继续",200);
                }

                //连续失败3次结束任务
                if(failureCount>=3){
                    setTaskName(0);
                    taskList.remove(0);
                    successCount=failureCount=0;
                    LtLog.e(mFairy.getLineInfo("日常主线连续失败3次，结束任务"));
                    return;
                }

                result=mFairy.findPic(new String[]{"pic caiji.png","pic rare xunbaofu.png"});
                mFairy.onTap(0.9f,result,"采集",4000);

                result=mFairy.findPic("pic yichui.png");
                if(result.sim>0.8){
                    while(mFairy.condit()){
                        mFairy.onTap(113,622,133,640,"左边 忆梦锤",100);
                        mFairy.onTap(1145,632,1159,649,"右边 忆梦锤",100);
                        result=mFairy.findPic("pic yichui.png");
                        if(result.sim<0.8)break;
                    }
                }
            }

            /**
             * 答题关卡
             * 完成后，返回主线 content3
             */
            @Override
            public void content_4() throws Exception {
                int ansewer=1;
                while(mFairy.condit()){
                    result=mFairy.findPic("pic dialogue.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(1120,300+(ansewer-1)*60,1121,301+(ansewer-1)*60,"回答题目",200);
                        ansewer++;
                        ansewer=ansewer==5?1:ansewer;//等于五则归一
                    }else{
                        LtLog.e(mFairy.getLineInfo("答题结束"));
                        setTaskName(3);
                        return;
                    }
                }
            }
        }.taskContent(mFairy, "主线任务");
    }

    //初始化画质
    public void init_image() throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(25,0);
                result=mFairy.findPic("pic main open.png");
                mFairy.onTap(0.8f,result,"主界面 展开",200);


                result=mFairy.findPic("pic setting.png");
                if(result.sim<0.8f){
                    result=mFairy.findPic(891,562,960,631,"pic setting.png");
                }
                mFairy.onTap(0.8f,result,"打开设置",1000);

                result=mFairy.findPic("word frames.png");
                mFairy.onTap(0.8f,result,"切换画面设置",1000);

                result=mFairy.findPic("pic init_image.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"流畅画质1",200);
                    mFairy.onTap(0.8f,result,"流畅画质2",200);
                    LtLog.e(mFairy.getLineInfo("初始化画质完成"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"初始化画质");

    }

    public void test() throws Exception{
        daily_ccxd();
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
            }
            @Override
            public void content_0() throws Exception {
                mFairy.sleep(1000);
                LtLog.e("\n");
                LtLog.e(mFairy.getLineInfo("result1="+mFairy.findPic("word xiaban.png").toString()));
//                LtLog.e(mFairy.getLineInfo("result2="+mFairy.findPic(1,200,239,363,"word huodong deal worm action.png").toString()));
//                LtLog.e(mFairy.getLineInfo("result1="+mFairy.findPic(787,629,828,658,"pic tsbw_box.png").toString()));
//                LtLog.e(mFairy.getLineInfo("result2="+mFairy.findPic(900,629,940,658,"pic tsbw_box.png").toString()));
//                LtLog.e(mFairy.getLineInfo("result3="+mFairy.findPic(1010,625,1051,658,"pic tsbw_box.png").toString()));
                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
                mFairy.onTap(0.8f,result,"回应对话",200);

                //在副本中
                result=mFairy.findPic("word exit copy.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(550,527,585,620,"word auto.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic(new String[]{"word huodong.png","word huodong1.png"});
                        mFairy.onTap(0.8f,result,"活动指引",1000);

                        //选择法阵继续追击
                        result=mFairy.findPic("word huodong csfz.png");
                        if(result.sim>0.8f){
                            String change=gameUtil.change(173,198,1144,470,"选中一个法阵");
                            if(!change.equals("0,0")){
                                mFairy.sleep(2000);
                            }
                        }

                        result=mFairy.findPic("word huodong baowuku.png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic(639,69,1255,657,"pic caiji1.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"打开宝箱",2000);
                            }else{
                                String change=gameUtil.change(173,198,1144,470,"选中一个法阵");
                                if(!change.equals("0,0")){
                                    mFairy.sleep(2000);
                                }
                            }
                        }
                    }
                }

                //计算作战胜利的次数
                result1=mFairy.findPic(new String[]{"pic victory.png","pic victory1.png"});
                picCount=picCount(0.8f,result1,"success");
                if(result1.sim>0.8f&&picCount==1){
                    failureCount=0;
                    successCount++;
                    mFairy.onTap(0.8f,result1,"胜利次数="+successCount,200);
                }else{
                    //计算作战失败的次数
                    result1=mFairy.findPic("pic failure.png");
                    picCount=picCount(0.8f,result1,"failure");
                    if(result1.sim>0.8f&&picCount==1){
                        failureCount++;
                        mFairy.onTap(0.8f,result1,"失败次数="+failureCount,200);
                    }
                }
                if(result1.sim<0.8f){
                    result=mFairy.findPic(535,625,704,705,"tap.png");
                    mFairy.onTap(0.8f,result,"点击屏幕继续",200);
                }

                result=mFairy.findPic("word chuzhan.png");
                mFairy.onTap(0.8f,result,"出战",200);

//                result=mFairy.findPic(1205,400,1219,495,"dialogue.png");
//                mFairy.onTap(0.8f,result,"点击回应对话",200);
//
//                //进入拼图关卡
//                result=mFairy.findPic("pintu.png");
//                if(result.sim>0.8f){
//                    setTaskName(1);
//                    LtLog.e(mFairy.getLineInfo("进入拼图关卡"));
//                    return;
//                }
            }
            @Override
            public void content_1() throws Exception {
                int type=0;
                for(int i=1;i<=3;i++){
                    result=mFairy.findPic("kzwt"+i+" pin.png");
                    if(result.sim>0.8f){
                        type=i;
                        break;
                    }
                }
                //1白尾红霞(白尾青芳) 2王权富贵(清瞳) 3颜如玉(律笺文)
                if(type==0){
                    LtLog.e(mFairy.getLineInfo("没有该拼图"));
                    return;
                }
                boolean left=true;
                while(mFairy.condit()) {
                    result = mFairy.findPic("pintu.png");
                    if (result.sim > 0.8f) {
                        for (int i = 1; i <= 9; i++) {
                            result = mFairy.findPic(10, 15, 282, 700, "kzwt" + type + " pin" + i + ".png");
                            if (result.sim > 0.85f) {
                                left = true;
                            } else {
                                result = mFairy.findPic(1035, 60, 1280, 720, "kzwt" + type + " pin" + i + ".png");
                                left = false;
                            }
                            if (result.sim > 0.85f) {
                                int ranX = i % 3 == 0 ? 3 : i % 3;
                                ranX = (ranX - 1) * 238 + 450;
                                if (!left) {
                                    ranX = ranX - 100;
                                }
                                int ranY = i / 3;
                                if (i % 3 != 0) ranY++;
                                ranY = (ranY - 1) * 143 + 200;
                                LtLog.e(mFairy.getLineInfo("移动拼图" + i));
                                LtLog.e("移动坐标," + result.x + "," + result.y + ",1280,720");
                                LtLog.e("移动坐标到," + ranX + "," + ranY + ",1280,720");
                                mFairy.touchDown(0, result.x, result.y);
                                mFairy.touchMove(0, ranX, ranY, 750);
                                mFairy.sleep(250);
                                mFairy.touchUp(0);
                            }
                        }
                    } else {
                        setTaskName(0);
                        mFairy.onTap(0.8f, result, "拼图结束", 100);
                        return;
                    }
                }
            }
        }.taskContent(mFairy,"测试");
    }
}
