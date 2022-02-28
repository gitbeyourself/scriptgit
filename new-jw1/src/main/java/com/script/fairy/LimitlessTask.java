package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import java.util.List;


/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class LimitlessTask extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    TimingActivity timingActivity;
    GameUtil gameUtil;
    OtherGame otherGame;
    SingleTask singleTask;
    TeamTask teamTask;

    public LimitlessTask(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        singleTask = new SingleTask(mFairy);
        teamTask = new TeamTask(mFairy);
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("smOverGraph.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(447,493,855,566,new String[]{"In transmission.png","In transmission1.png"});
        if (result.sim > 0.7f) {
            LtLog.e(mFairy.getLineInfo("传送中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic("road.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("寻路中"));
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "complete.png");
        mFairy.onTap(0.8f, result, "完成", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
        result = mFairy.findPic(188, 533, 369, 592, "accept.png");
        mFairy.onTap(0.8f, result, "接受", Sleep);
        if (result.sim > 0.8f) {
            mFairy.initMatTime();
            err = 0;
            picCountMapS.clear();
            picCountMap.clear();
        }
    }

    static int szmap = 0;

    public void fieldHangMachine() throws Exception {
        new LimitlessTask(mFairy) {

            int gmx = 0, gmy = 0, yhsr = 0;//地图
            ControlSplit back =null, sywp = null;
            //xzdt 选择地图 totem图腾 zb坐标 ditunum地图NO
            @Override
            public void create() throws Exception {
                timingActivity.timingActivity();
                //定位坐标
                if (!AtFairyConfig.getOption("back").equals("")) {
                    back = strSplit(AtFairyConfig.getOption("back"));
                }
/*
                //使用物品
                if (AtFairyConfig.getOption("7876").equals("1")) {
                    if (!AtFairyConfig.getOption("shijian").equals("")) {
                        sywp = strSplit(AtFairyConfig.getOption("shijian"));
                    }
                }
                //七星炼宝
                if (AtFairyConfig.getOption("qxlb").equals("1")) {
                    gameUtil.goCity("轩辕");
                    sevenStar();
                }*/

            }

            public void inOperation() throws Exception {
                super.inOperation();
                result = mFairy.findPic(91,234,1038,551,new String[]{"death.png","death2.png"});
                result1 = mFairy.findPic(415,333,577,419,"ky.png");
                if(result.sim > 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(0.8f, result, "复活", Sleep);
                    setTaskName(0);
                    return;
                }

                result1 = mFairy.findPic(40,457,395,697,"tcsdms.png");
                mFairy.onTap(0.8f, result1, "退出省电模式", Sleep);

            }

            public void content_0() throws Exception {

                while (mFairy.condit()){
                    if (!(AtFairyConfig.getOption("xzdt").equals("") || AtFairyConfig.getOption("zb1").equals("") || AtFairyConfig.getOption("xzdt").equals("0"))){
                        yhsr = Integer.parseInt(AtFairyConfig.getOption("xzdt"));
                        String[] arr = AtFairyConfig.getOption("zb1").split(",");
                        gmx = Integer.parseInt(arr[0]);
                        gmy = Integer.parseInt(arr[1]);
                        LtLog.e(mFairy.getLineInfo("哪个地图=" + yhsr + ",坐标=" + gmx + "," + gmy));
                        break;
                    }else{

                    }
                }
                gameUtil.close(1);
                setTaskName(1);
                return;
            }

            int tu1 = 0, ceng1 = 0;
            String tu="";
            public void content_1() throws Exception {
                if (overtime(10, 0)) return;
                mFairy.sleep(1000);
                tu1 = 0;
                ceng1 = 0;

                result = mFairy.findPic(1053,1,1101,88,"hdkzl.png");
                mFairy.onTap(0.8f, result, "活动展开", Sleep);

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, 1188,83,1193,93, "打开地图", 3000);

                //查看当前的位置
                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim > 0.8f) {
                    LtLog.e("地图内");
                    Thread.sleep(2000);
                    mFairy.condit();
                    for (int i = 0; i < 32; i++) {
                        result1 = mFairy.findPic(139,18,403,117,"gjdigong" + i + ".png");
                        if (result1.sim > 0.9f) {
                            switch (i) {
                                case 0:
                                    LtLog.e(mFairy.getLineInfo("帮会"));
                                    tu1 = 50;
                                    break;
                                case 1:
                                    LtLog.e(mFairy.getLineInfo("少林"));
                                    tu1 = 1;
                                    break;
                                case 2:
                                    LtLog.e(mFairy.getLineInfo("天王帮"));
                                    tu1 = 2;
                                    break;
                                case 3:
                                    LtLog.e(mFairy.getLineInfo("唐门"));
                                    tu1 = 3;
                                    break;
                                case 4:
                                    LtLog.e(mFairy.getLineInfo("五毒"));
                                    tu1 = 4;
                                    break;
                                case 5:
                                    LtLog.e(mFairy.getLineInfo("峨眉"));
                                    tu1 = 5;
                                    break;
                                case 6:
                                    LtLog.e(mFairy.getLineInfo("翠烟"));
                                    tu1 = 6;
                                    break;
                                case 7:
                                    LtLog.e(mFairy.getLineInfo("丐帮"));
                                    tu1 = 7;
                                    break;
                                case 8:
                                    LtLog.e(mFairy.getLineInfo("天忍教"));
                                    tu1 = 8;
                                    break;
                                case 9:
                                    LtLog.e(mFairy.getLineInfo("武当"));
                                    tu1 = 9;
                                    break;
                                case 10:
                                    LtLog.e(mFairy.getLineInfo("昆仑"));
                                    tu1 = 10;
                                    break;
                                case 11:
                                    LtLog.e(mFairy.getLineInfo("风陵渡渡口"));
                                    tu1 = 11;
                                    break;
                                case 12:
                                    LtLog.e(mFairy.getLineInfo("漠北草原180"));
                                    tu1 = 12;
                                    break;
                                case 13:
                                    LtLog.e(mFairy.getLineInfo("剑门关160"));
                                    tu1 = 13;
                                    break;
                                case 14:
                                    LtLog.e(mFairy.getLineInfo("千寻塔140"));
                                    tu1 = 14;
                                    break;
                                case 15:
                                    LtLog.e(mFairy.getLineInfo("长白山120"));
                                    tu1 = 15;
                                    break;
                                case 16:
                                    LtLog.e(mFairy.getLineInfo("沙漠山洞100"));
                                    tu1 = 16;
                                    break;
                                case 17:
                                    LtLog.e(mFairy.getLineInfo("青螺岛100"));
                                    tu1 = 17;
                                    break;
                                case 18:
                                    LtLog.e(mFairy.getLineInfo("老虎洞80"));
                                    tu1 = 18;
                                    break;
                                case 19:
                                    LtLog.e(mFairy.getLineInfo("桃花源80"));
                                    tu1 = 19;
                                    break;
                                case 20:
                                    LtLog.e(mFairy.getLineInfo("药王谷60"));
                                    tu1 = 20;
                                    break;
                                case 21:
                                    LtLog.e(mFairy.getLineInfo("莫高窟60"));
                                    tu1 = 21;
                                    break;
                                case 22:
                                    LtLog.e(mFairy.getLineInfo("秦始皇陵60"));
                                    tu1 = 22;
                                    break;
                                case 23:
                                    LtLog.e(mFairy.getLineInfo("古战场80"));
                                    tu1 = 23;
                                    break;
                                case 24:
                                    LtLog.e(mFairy.getLineInfo("临渝关40"));
                                    tu1 = 24;
                                    break;
                                case 25:
                                    LtLog.e(mFairy.getLineInfo("华山40"));
                                    tu1 = 25;
                                    break;
                                case 26:
                                    LtLog.e(mFairy.getLineInfo("火狼词40"));
                                    tu1 = 26;
                                    break;
                                case 27:
                                    LtLog.e(mFairy.getLineInfo("武夷山40"));
                                    tu1 = 27;
                                    break;
                                case 28:
                                    LtLog.e(mFairy.getLineInfo("响水洞20"));
                                    tu1 = 28;
                                    break;
                                case 29:
                                    LtLog.e(mFairy.getLineInfo("青城山20"));
                                    tu1 = 29;
                                    break;
                                case 30:
                                    LtLog.e(mFairy.getLineInfo("伏牛山20"));
                                    tu1 = 30;
                                    break;
                                case 31:
                                    LtLog.e(mFairy.getLineInfo("荐菊洞20"));
                                    tu1 = 31;
                                    break;
                                case 32:
                                    LtLog.e(mFairy.getLineInfo("点苍山20"));
                                    tu1 = 32;
                                    break;

                            }
                            break;
                        }
                    }
                    LtLog.e("查看地图位于："+tu1);
                    if (tu1==0 || yhsr != tu1) {

                        LtLog.e(mFairy.getLineInfo("不在一个地图"));
                        gameUtil.goCity(yhsr);
                        setTaskName(7);
                        return;
                    }else{
                        setTaskName(7);
                        return;
                    }
                }
            }

            public void content_7() throws Exception {

                gameUtil.moshi();

                result = mFairy.findPic(612,4,1103,176,"activity.png");
                mFairy.onTap(0.8f, result, 1188,83,1193,93, "打开地图", 3000);

                result = mFairy.findPic(856,579,1121,670,"hcWorld.png");
                if (result.sim > 0.8f) {
                    gameUtil.coordinate(yhsr, gmx, gmy);
                    timekeepInit("定位坐标");
                    mFairy.initMatTime();
                    setTaskName(8);
                    return;
                }

            }//定位到坐标 到8开始挂机

            public void content_8() throws Exception {
                int h = mFairy.dateHour();
                int m = mFairy.dateMinute();
                result = mFairy.findPic(1091,636,1184,718, new String[]{"sdzd.png", "sdzd1.png"});
                mFairy.onTap(0.8f,result, "开启自动战斗", Sleep);
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 40) {
                    mFairy.initMatTime();
                    setTaskName(7);
                    return;
                }
                if (AtFairyConfig.getOption("gxrc").equals("1")  && h==5  && m==1){
                    timingActivity.hjsl=true;timingActivity.ywsl=true;timingActivity.fldc=true;timingActivity.bhkh=true;timingActivity.sjsl=true;
                    timingActivity.sjzc=true;timingActivity.mpjj=true;timingActivity.wlls=true;timingActivity.zjjy=true;timingActivity.gcz=true;
                    timingActivity.xflj=true;timingActivity.elrq=true;timingActivity.ydbz=true;timingActivity.hjsl1=true;
                    eliminate = false;
                    sevenStar = false;
                    LtLog.e("5点重置任务" );
                    create();
                    setTaskName(0);
                    return;
                }
                //限时任务
                if (timingActivity.timingActivity() == 1) {
                    setTaskName(0);
                    return;
                }
                if (mFairy.dateHour()==0 && mFairy.dateMinute()==1){
                    timingActivity = new TimingActivity(mFairy);
                    Thread.sleep(60000);
                }
                if (back != null && back.choice == 1 && timekeep(0, back.timeMillis, "定位坐标")) {
                    LtLog.e(mFairy.getLineInfo("定位坐标一次"));
                    setTaskName(7);//每隔多少分定位坐标一次
                    return;
                }
                LtLog.e("使用物品"+(sywp != null  && timekeep(0, sywp.timeMillis, "野外挂机使用物品")));
                if (taskand() == 1) {
                    setTaskName(3);
                    return;
                }

            }

            public void content_9() throws Exception {
                gameUtil.moshi();
                if (timingActivity.timingActivity() == 1) {
                    setTaskName(0);
                    return;
                }
                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 40) {
                    mFairy.initMatTime();
                    for (int i = 0; i < 20; i++) {
                        mFairy.condit();

                        if (i == 19) {
                            LtLog.e(mFairy.getLineInfo("发呆40秒了重置"));
                            setTaskName(0);
                            return;
                        }
                        Thread.sleep(1000);
                    }
                }
                if (mFairy.dateHour()==0 && mFairy.dateMinute()==1){
                    timingActivity = new TimingActivity(mFairy);
                    Thread.sleep(60000);
                }
                if (taskand() == 1) {
                    setTaskName(0);
                    return;
                }
                result1 = mFairy.findPic("bagM1.png");
                result = mFairy.findPic(575, 98, 711, 233, "bagM.png");
                if (result1.sim > 0.8f && result.sim > 0.8f) {
                    LtLog.e(mFairy.getLineInfo("背包满了炼宝清剿结束"));
                    LimitlessTask.this.eliminate = true;
                    LimitlessTask.this.sevenStar = true;
                }
            }

        }.taskContent(mFairy, "定点挂机中");
    }//定点挂机

    boolean eliminate = false;
    public void eliminate() throws Exception {
        new LimitlessTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("eliminate.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    LimitlessTask.this.eliminate = true;
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(25, 99)) return;
                List<FindResult> listResult = mFairy.findPic(601, 145, 1133, 530, 0.8f, "xmqjOrder.png");
                if (listResult.size() != 0) {//1076,465   888,448
                    mFairy.onTap(0.8f, listResult.get(listResult.size() - 1), listResult.get(listResult.size() - 1).x, listResult.get(listResult.size() - 1).y, listResult.get(listResult.size() - 1).x + 1, listResult.get(listResult.size() - 1).y + 1, "找到清剿令", Sleep);
                    mFairy.onTap(0.8f, listResult.get(listResult.size() - 1), listResult.get(listResult.size() - 1).x-180, listResult.get(listResult.size() - 1).y-13, listResult.get(listResult.size() - 1).x-179 , listResult.get(listResult.size() - 1).y -12, "找到清剿令", Sleep);
                }

             /*   result = mFairy.findPic( 389,55,1260,701,"shiyong.png");
                mFairy.onTap(0.8f,result,"使用",Sleep);*/

                result = mFairy.findPic( "only.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic( "num.png");
                if (result.sim > 0.8f) {
                    LimitlessTask.this.eliminate = true;
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "血盟清剿任务中");
    }//血盟清剿

    public void eliminate22() throws Exception {
        new LimitlessTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                int ret = gameUtil.mission("eliminate.png", 1);
                if (ret == 1) {
                    setTaskName(2);
                    return;
                } else {
                    LimitlessTask.this.eliminate = true;
                    setTaskEnd();
                    return;
                }
            }

            public void content_2() throws Exception {
                if (overtime(5, 99)) return;
                List<FindResult> listResult = mFairy.findPic(601, 145, 1133, 530, 0.8f, "xmqjOrder.png");
                if (listResult.size() != 0) {//1076,465   888,448
                    mFairy.onTap(0.8f, listResult.get(listResult.size() - 1), listResult.get(listResult.size() - 1).x, listResult.get(listResult.size() - 1).y, listResult.get(listResult.size() - 1).x + 1, listResult.get(listResult.size() - 1).y + 1, "找到清剿令", Sleep);
                    mFairy.onTap(0.8f, listResult.get(listResult.size() - 1), listResult.get(listResult.size() - 1).x-180, listResult.get(listResult.size() - 1).y-13, listResult.get(listResult.size() - 1).x-179 , listResult.get(listResult.size() - 1).y -12, "找到清剿令", Sleep);
                }
                result = mFairy.findPic( 389,55,1260,701,"shiyong.png");
                mFairy.onTap(0.8f,result,"使用",Sleep);

                result = mFairy.findPic( "only.png");
                if (result.sim > 0.8f) {
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy, "血盟清剿任务中");
    }//血盟清剿

    boolean sevenStar = false;
    public void sevenStar() throws Exception {
        new LimitlessTask(mFairy) {
            @Override
            public void content_0() throws Exception {
                gameUtil.close(0);
                setTaskName(1);
                return;
            }

            public void content_1() throws Exception {
                result = mFairy.findPic("team.png");
                mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);

                result = mFairy.findPic("shizu3.png");
                mFairy.onTap(0.95f, result, 117,177,126,184, "在氏族栏切到普通栏", Sleep);

                result = mFairy.findPic("beibao2.png");
                mFairy.onTap(0.8f, result, 1194,39,1202,52, "cha", Sleep);

                result = mFairy.findPic(0,161,42,431,"taskseven.png");
                mFairy.onTap(0.8f, result, "打开任务栏", Sleep);

                result = mFairy.findPic("yijie.png");
                mFairy.onTap(0.8f, result, "已接", 1500);
                //mFairy.onTap(0.8f, result, 219,123,229,132,"收纳主线", Sleep);
                result = mFairy.findPic("huan.png");

                result1 = mFairy.findPic("intask.png");
                if (result.sim <0.8f && result1.sim > 0.8f){
                    mFairy.onTap(0.8f, result1, 219,123,229,132,"收纳主线", Sleep);
                }

                result = mFairy.findPic(77,217,387,585, new String[]{ "zuoceTreasure2.png","zuoceTreasure3.png"});
                if (result.sim > 0.7f) {
                    LtLog.e(mFairy.getLineInfo("已经接取了炼宝任务"));
                    setTaskEnd();
                    return;
                }

            /*    result = mFairy.findPic(18, 116, 532, 607, "zuoceTreasure.png");
                if (result.sim > 0.7f) {
                    LtLog.e(mFairy.getLineInfo("已经接取了炼宝任务"));
                    setTaskEnd();
                    return;
                }*/

                if (result1.sim > 0.8f) {
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 0, 228, 400, 228, 126, 500, 1500, 2);
                }

                if (overtime(12, 2)) return;

            }

            public void content_2() throws Exception {
                int ret = gameUtil.mission("qxTreasure1.png", 1);
                if (ret == 1) {
                    setTaskName(3);
                    return;
                } else {
                    ret = gameUtil.mission("qxTreasure.png", 1);
                    if (ret == 1) {
                        setTaskName(3);
                        return;
                    } else {
                        LimitlessTask.this.sevenStar = true;
                        setTaskEnd();
                        return;
                    }
                }
            }

            public void content_3() throws Exception {
                if (overtime(12, 1)) return;

                result = mFairy.findPic(new String[]{"Activeinterface.png", "Activeinterface1.png"});
                mFairy.onTap(0.8f, result, 1191, 92, 1209, 108, "前往关闭", Sleep);

                result = mFairy.findPic( "tuteng3.png");
                mFairy.onTap(0.8f, result, 988,120,1000,131, "关闭", Sleep);

                result = mFairy.findPic(91,234,1038,551,new String[]{"death.png","death2.png"});
                result1 = mFairy.findPic(415,333,577,419,"ky.png");
                if(result.sim > 0.8f && result1.sim < 0.8f){
                    mFairy.onTap(0.8f, result, "复活", Sleep);
                    mFairy.sleep(30000);
                }

                result = mFairy.findPic(1099, 277, 1173, 348,"Hangup1.png");
                mFairy.onTap(0.8f, result, "关闭挂机", Sleep);

                long dazeTime = mFairy.mMatTime(1215, 128, 61, 16, 0.9f);
                LtLog.e(mFairy.getLineInfo("发呆时间=" + dazeTime));
                if (dazeTime > 15) {
                    setTaskName(1);return;
                   // mFairy.initMatTime();
                  /*  LtLog.e(mFairy.getLineInfo("炼宝接取任务完毕"));
                    setTaskEnd();
                    return;*/
                  /*  result = mFairy.findPic(18, 116, 532, 607, "zuoceTreasure.png");
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("炼宝接取任务完毕"));
                        setTaskEnd();
                        return;
                    }
                    mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8,10,12,14,16}, 0, 116, 426, 116, 245, 500, 1500, 2);
                    if (overtime(16, 2)) return;*/
                }

            }

        }.taskContent(mFairy, "七星炼宝任务中");

    }//七星炼宝

    int lbcount = 0;
    public int taskand() throws Exception {
        lbcount++;
        if (lbcount > 10000) {
            lbcount = 0;
        }
        LtLog.e(mFairy.getLineInfo("eliminate=" + LimitlessTask.this.eliminate + ",sevenStar=" + LimitlessTask.this.sevenStar));

        result = mFairy.findPic("beibao2.png");
        mFairy.onTap(0.8f, result, 1194,39,1202,52, "cha", Sleep);
        //七星炼宝  && 血盟清剿 && (sevenStar==false || eliminate==false)
        if (AtFairyConfig.getOption("qxlb").equals("1") && AtFairyConfig.getOption("xmqj").equals("1") && (!LimitlessTask.this.eliminate || !LimitlessTask.this.sevenStar)) {

            LtLog.e(mFairy.getLineInfo("炼宝和清剿任务中"));



            result = mFairy.findPic("team.png");
            mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);


            result=mFairy.findPic("put.png");
            mFairy.onTap(0.8f,result,"普通",Sleep);

            result = mFairy.findPic(46, 177, 274, 469, "zuoceTreasure.png");
            if (result.sim > 0.65f) {
                lbcount = 0;
                result1 = mFairy.findPic(result.x + 171, result.y - 15, result.x + 372, result.y + 53, "lbLeftCompletion.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "左侧炼宝完成", Sleep);
                }
            }



            result = mFairy.findPic(46, 177, 274, 469, "zuoceEliminate.png");
            if (result.sim > 0.7f) {
                lbcount = 0;
                result1 = mFairy.findPic(result.x + 171, result.y - 15, result.x + 372, result.y + 53, "lbLeftCompletion.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "左侧血盟清剿完成", Sleep);
                }
            }



            result = mFairy.findPic2("qxlbtask.png");
            if (result.sim > 0.8f) {
                mFairy.taskSlid(lbcount, new int[]{0, 2, 4, 6 ,8,10,12,14}, 1, 76, 400, 76, 220, 500, 1500, 2);
            } else {
                lbcount = 0;
            }
            if (lbcount > 14) {
                lbcount = 0;
                if (!LimitlessTask.this.eliminate) {
                    result = mFairy.findPic("taskseven.png");
                    mFairy.onTap(0.8f, result, "打开任务栏", Sleep);

                    result = mFairy.findPic("yijie.png");
                    mFairy.onTap(0.8f, result, "已接", 1500);
                    //mFairy.onTap(0.8f, result, 219,123,229,132,"收纳主线", Sleep);
                    result = mFairy.findPic("huan.png");
                    result1 = mFairy.findPic("intask.png");
                    if (result.sim <0.8f && result1.sim > 0.8f){
                        mFairy.onTap(0.8f, result1, 219,123,229,132,"收纳主线", Sleep);
                    }

                    result = mFairy.findPic(77,217,387,585, "zuoceEliminate2.png");
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("已经接取了清剿任务"));
                        mFairy.onTap(0.7f, result, 1155,58,1165,65,"cha", Sleep);
                    }else {
                        eliminate();
                    }

                }
                if (!LimitlessTask.this.sevenStar) {
                    result = mFairy.findPic("taskseven.png");
                    mFairy.onTap(0.8f, result, "打开任务栏", Sleep);

                    result = mFairy.findPic("yijie.png");
                    mFairy.onTap(0.8f, result, "已接", 1500);
                    //mFairy.onTap(0.8f, result, 219,123,229,132,"收纳主线", Sleep);
                    result = mFairy.findPic("huan.png");
                    result1 = mFairy.findPic("intask.png");
                    if (result.sim <0.8f && result1.sim > 0.8f){
                        mFairy.onTap(0.8f, result1, 219,123,229,132,"收纳主线", Sleep);
                    }

                    result = mFairy.findPic(77,217,387,585, "zuoceTreasure2.png");
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("已经接取了炼宝任务"));
                        mFairy.onTap(0.7f, result1, 1155,58,1165,65,"cha", Sleep);
                    }else {
                        sevenStar();
                        return 1;
                    }

                }
            }
        }
        //七星炼宝  && 血盟清剿 && sevenStar==false
        if (AtFairyConfig.getOption("qxlb").equals("1") && !AtFairyConfig.getOption("xmqj").equals("1") && !LimitlessTask.this.sevenStar) {
            LtLog.e(mFairy.getLineInfo("炼宝任务中"));
            result = mFairy.findPic("team.png");
            mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);
            result=mFairy.findPic("put.png");
            mFairy.onTap(0.8f,result,"普通",Sleep);

            result = mFairy.findPic(46, 177, 274, 469, "zuoceTreasure.png");
            if (result.sim > 0.7f) {
                lbcount = 0;
                result1 = mFairy.findPic(result.x + 171, result.y - 15, result.x + 372, result.y + 53, "lbLeftCompletion.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "左侧炼宝完成", Sleep);
                }
            }
            result = mFairy.findPic2("qxlbtask.png");
            if (result.sim > 0.8f) {
                mFairy.taskSlid(lbcount, new int[]{0, 2, 4, 6 ,8,10,12,14}, 0, 76, 400, 76, 220, 500, 1500, 2);
            } else {
                lbcount = 0;
            }
            if (lbcount > 8) {
                lbcount = 0;
                if (!LimitlessTask.this.sevenStar) {
                    result = mFairy.findPic("taskseven.png");
                    mFairy.onTap(0.8f, result, "打开任务栏", Sleep);

                    result = mFairy.findPic("yijie.png");
                    mFairy.onTap(0.8f, result, "已接", 1500);
                    //mFairy.onTap(0.8f, result, 219,123,229,132,"收纳主线", Sleep);
                    result = mFairy.findPic("huan.png");
                    result1 = mFairy.findPic("intask.png");
                    if (result.sim <0.8f && result1.sim > 0.8f){
                        mFairy.onTap(0.8f, result1, 219,123,229,132,"收纳主线", Sleep);
                    }

                    result = mFairy.findPic(77,217,387,585, "zuoceTreasure2.png");
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("已经接取了炼宝任务"));
                        mFairy.onTap(0.8f, result1, 1155,58,1165,65,"cha", Sleep);
                    }else {
                        sevenStar();
                        return 1;
                    }

                }
            }
        }
        //七星炼宝  && 血盟清剿 && eliminate==false
        if (!AtFairyConfig.getOption("qxlb").equals("1") && AtFairyConfig.getOption("xmqj").equals("1") && !LimitlessTask.this.eliminate) {
            LtLog.e(mFairy.getLineInfo("清剿任务中"));
            result = mFairy.findPic("team.png");
            mFairy.onTap(0.95f, result, 15, 234, 29, 262, "在队伍栏切换到任务栏", Sleep);
            result=mFairy.findPic("put.png");
            mFairy.onTap(0.8f,result,"普通",Sleep);

            result = mFairy.findPic(46, 177, 274, 469, "zuoceEliminate.png");
            if (result.sim > 0.7f) {
                lbcount = 0;
                result1 = mFairy.findPic(result.x + 171, result.y - 15, result.x + 372, result.y + 53, "lbLeftCompletion.png");
                if (result1.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, "左侧血盟清剿完成", Sleep);
                }
            }
            result = mFairy.findPic2("qxlbtask.png");
            if (result.sim > 0.8f) {
                mFairy.taskSlid(lbcount, new int[]{0, 2, 4, 6 ,8,10,12,14}, 0, 76, 400, 76, 220, 500, 1500, 2);
            } else {
                lbcount = 0;
            }
            if (lbcount > 8) {
                if (!LimitlessTask.this.eliminate) {
                    result = mFairy.findPic("taskseven.png");
                    mFairy.onTap(0.8f, result, "打开任务栏", Sleep);

                    result = mFairy.findPic("yijie.png");
                    mFairy.onTap(0.8f, result, "已接", 1500);
                    //mFairy.onTap(0.8f, result, 219,123,229,132,"收纳主线", Sleep);
                    result = mFairy.findPic("huan.png");
                    result1 = mFairy.findPic("intask.png");
                    if (result.sim <0.8f && result1.sim > 0.8f){
                        mFairy.onTap(0.8f, result1, 219,123,229,132,"收纳主线", Sleep);
                    }

                    result = mFairy.findPic(77,217,387,585, "zuoceEliminate2.png");
                    if (result.sim > 0.7f) {
                        LtLog.e(mFairy.getLineInfo("已经接取了清剿任务"));
                        mFairy.onTap(0.8f, result1, 1155,58,1165,65,"cha", Sleep);

                    }else {
                        eliminate();
                    }
                }
                lbcount = 0;
            }
        }
        return 0;
    }//野外挂机中的七星与清剿

}
