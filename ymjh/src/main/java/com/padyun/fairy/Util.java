package com.padyun.fairy;

import android.renderscript.Matrix2f;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.utils.TemplateInfo;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util extends  TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    int picCount=0;
    static int state=0;
    long fadTime = 0L;
    public Util(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    //无法指引 脱离卡死
    public void reset_place()throws Exception{
        new Util(mFairy){
            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(10,0);
                result=mFairy.findPic("pic up tip.png");
                mFairy.onTap(0.8f,result,53,661,61,668,"展开更多",1000);

                result=mFairy.findPic(177,508,252,552,"word leave pause.png");
                mFairy.onTap(0.8f,result,"脱离卡死",1000);

                result=mFairy.findPic("word leave pause cooling.png");
                if(result.sim>0.8f)setTaskEnd();

                result=mFairy.findPic("word hint return scene.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,850,506,857,515,"回到传送点",3000);
                    setTaskEnd();
                }
            }
        }.taskContent(mFairy,"脱离卡死");
    }

    //前往世界场景
    public void to_world()throws Exception{
        new Util(mFairy){
            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(10,0);
                result=mFairy.findPic("pic up tip.png");
                mFairy.onTap(0.8f,result,1200,65,1206,74,"打开地图",1000);

                result=mFairy.findPic("pic world map.png");
                mFairy.onTap(0.8f,result,793,453,799,461,"打开云梦门派",1000);

                result=mFairy.findPic("pic area map.png");
                if(result.sim>0.8f){
                    result1=mFairy.findPic("pic map car.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"前往云梦",500);
                        mFairy.onTap(0.8f,result1,"前往云梦",1000);
                        mFairy.onTap(0.8f,result1,1233,38,1240,47,"关闭地图",1000);
                        setTaskEnd();
                        return;
                    }else{
                        mFairy.onTap(0.8f,result,"打开世界地图",1000);
                    }
                }
            }
        }.taskContent(mFairy,"前往世界");
    }

    //恢复血量
    public void renew()throws Exception{
        new Util(mFairy){
            long daze;
            @Override
            public void create() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){
                    //满血902
                    int currentBlood=mFairy.getColorNum(89,35,272,39,0.95f,0,"178,70,69");//当前血量值
                    double perBlood=currentBlood/900;//当前百分比血量值
                    //恢复满80停止打坐
                    if(perBlood>0.8d){
                        setTaskEnd();
                    }

                    result=mFairy.findPic("pic action sit ing.png");
                    if(result.sim>0.8f){
                        initDaze();
                        LtLog.e(mFairy.getLineInfo("打坐调息中"));
                        return;
                    }

                    result=mFairy.findPic("pic action sit.png");
                    mFairy.onTap(0.8f,result,"打坐",1000);

                    if(daze>10){
                        LtLog.e(mFairy.getLineInfo("任务超时，重启任务"));
                        setTaskName(0);
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                daze=dazeTime();
                super.inOperation();
            }
        }.taskContent(mFairy,"恢复血量");
    }

    //退队
    /**
    @param header 带队/跟队
     */
    public void exitTeam(final boolean header)throws Exception{
        new Util(mFairy){
            @Override
            public void create() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(15,0);

                result=mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"打开任务栏",1000);

                result=mFairy.findPic(new String[]{"pic change team.png","pic team paging.png"});
                mFairy.onTap(0.8f,result,"打开队伍界面",1000);

                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word team none.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1111,62,1126,76,"尚未创建队伍",1000);
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word btn exit team.png");
                    if(result.sim>0.8f){
                        result1=mFairy.findPic("word btn a key call.png");
                        if(result1.sim>0.8f&&!header)mFairy.onTap(0.8f,result,"退出队伍",1000);

                        result1=mFairy.findPic(new String[]{"word btn team cancel follow.png","word btn team follow header.png"});
                        if(result1.sim>0.8f&&header)mFairy.onTap(0.8f,result,"退出队伍",1000);
                    }
                }

                result=mFairy.findPic("word hint leave team.png");
                mFairy.onTap(0.8f,result,849,506,856,515,"确定离开队伍",1000);
            }
        }.taskContent(mFairy,"退出队伍");
    }

    //退队
    public void exitTeam()throws Exception{
        new Util(mFairy){
            @Override
            public void create() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(15,0);

                result=mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"打开任务栏",1000);

                result=mFairy.findPic(new String[]{"pic change team.png","pic team paging.png"});
                mFairy.onTap(0.8f,result,"打开队伍界面",1000);

                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word team none.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,1111,62,1126,76,"尚未创建队伍",1000);
                        setTaskEnd();
                        return;
                    }

                    result=mFairy.findPic("word btn exit team.png");
                    mFairy.onTap(0.8f,result,"退出队伍",1000);
                }

                result=mFairy.findPic("word hint leave team.png");
                mFairy.onTap(0.8f,result,849,506,856,515,"确定离开队伍",1000);
            }
        }.taskContent(mFairy,"退出队伍");
    }

    //回大厅
    public void close()throws Exception{
        new Util(mFairy){
            boolean increa=true;
            int closeNum=5,task_id;

            @Override
            public void create() throws Exception {
                task_id=Integer.parseInt(AtFairyConfig.getOption("task_id"));
            }

            @Override
            public void content_0() throws Exception {
                LtLog.e(mFairy.getLineInfo("closeNum="+closeNum));
                //关闭5次
                if(--closeNum<=0){
                    LtLog.e(mFairy.getLineInfo("关闭结束"));
                    setTaskEnd();
                }

                //单人日常 和 采集任务
                if(task_id==1945||task_id==2043){
                    result=mFairy.findPic("pic exit copy.png");
                    mFairy.onTap(0.8f,result,"退出副本",1000);
                    mFairy.onTap(0.8f,result,846,503,858,516,"确定退出",1000);
                }

                result=mFairy.findPic(300,145,396,203,"pic hint1.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word hint affirm.png");
                    mFairy.onTap(0.8f,result,"确定",1000);
                    if(result.sim>0.8f)return;

                    mFairy.onTap(411,504,420,513,"取消",1000);
                }

                result=mFairy.findPic(841,1,1280,246,"pic close1.png");
                mFairy.onTap(0.8f,result,"关闭1",1000);

                result=mFairy.findPic(841,1,1280,246,"pic close2.png");
                mFairy.onTap(0.8f,result,"关闭2",1000);

                //关闭
                try{
                    List<FindResult> resultList = mFairy.findPic(860,0,1280,293, 0.8f, "pic close.png");
                    if(resultList.size()!=0){
                        if(increa){
                            closeNum=5;
                            increa=false;
                        }
                        while(resultList.size()>0){
                            result=resultList.get(0);
                            resultList.remove(0);
                            mFairy.onTap(0.8f,result,"list关闭",1000);
                        }
                    }
                }catch (Exception e){
                    LtLog.e(mFairy.getLineInfo("识图出错"));
                    LtLog.e(mFairy.getLineInfo(e.getMessage()));
                }

                if(closeNum==1){
                    mFairy.onTap(971,690,982,699,"点击关闭",500);

                    //新手指引
                    if(task_id==2111||task_id==2105){
                        result=mFairy.findPic("pic up tip.png");
                        result1=mFairy.findPic("word way.png");
                        if(result.sim>0.8f&&result1.sim<0.8f){
                            mFairy.ranSwipe(199,591,199,511,200,200l,1);
                        }
                    }
                }

            }
        }.taskContent(mFairy,"关闭");
    }

    //发呆超时
    public long dazeTime()throws Exception{
        long pastTime=fadTime;
        if(pastTime!=0L){
            //自动寻路中
            result=mFairy.findPic("word way.png");
            if(result.sim>0.8){
                LtLog.e(mFairy.getLineInfo("自动寻路中"));
                initDaze();
                return 0L;
            }

            //战斗加载
            result=mFairy.findPic("word fight.png");
            if(result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("自动战斗中"));
                initDaze();
                return 0L;
            }

            //传送
            result=mFairy.findPic(new String[]{"pic load.png"});
            if(result.sim>0.9f){
                LtLog.e(mFairy.getLineInfo("地图传送中"));
                initDaze();
                return 0L;
            }

            //不可跳过剧情
            result=mFairy.findPic(new String[]{"pic plot load.png","pic plot load1.png"});
            if(result.sim>0.9f){
                LtLog.e(mFairy.getLineInfo("剧情加载中"));
                initDaze();
                return 0L;
            }

            long dazeTime=System.currentTimeMillis()/ 1000L;//获取现在时间
            dazeTime=dazeTime-pastTime;//现在-之前
            LtLog.e(mFairy.getLineInfo("发呆时间dazeTime="+dazeTime));
            return dazeTime;
        }else{
            fadTime=System.currentTimeMillis() / 1000L;//获取当前时间
            return  0L;
        }
    }

    //初始化发呆
    public long initDaze ()throws Exception{
        fadTime=0L;
        return  0L;
    }

    static int tastState = 0;

    //日常活动
    //str 查找的任务图标
    //option 类型
    public int mission(final String str,final String option) throws Exception{
        tastState=mission(str,option,null);
        return  tastState;
    }

    public int mission(final String str,final String option,final String stopPic) throws Exception{
        tastState=0;
        new Util(mFairy){
            int findTask=0;
            @Override
            public void create() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic("pic activity interface.png");
                if(result.sim>0.8f){
                    close();
                    if(findTask++>2){
                        tastState=2;
                        mFairy.onTap(0.8f,result,1142,90,1150,96,"没有找到这个任务"+str,1000);
                        setTaskEnd();
                    }else{
                        setTaskName(1);
                    }
                }else{
                    close();
                    setTaskName(1);
                }
            }
            @Override
            public void content_1() throws Exception {
                if(stopPic!=null&&stopPic.equals("")){
                    result=mFairy.findPic(stopPic);
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("找到"+stopPic+"，停止任务"));
                        tastState=1;
                        setTaskEnd();
                        return;
                    }
                }

                //进入活动界面
               /* result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){*/
                    result=mFairy.findPic(780,6,1125,150,"pic activity.png");
                    mFairy.onTap(0.8f,result,"进入活动",1000);
                    if(result.sim<0.8f){
                        result=mFairy.findPic("pic activity1.png");
                        mFairy.onTap(0.8f,result,"进入活动1",1000);

                        result=mFairy.findPic("pic open system.png");
                        mFairy.onTap(0.8f,result,"展开系统",1000);
                    }
             //   }

                //活动界面
                result=mFairy.findPic("pic activity interface.png");
                if(result.sim>0.8f){
                    //领取活跃奖励1
                    result=mFairy.findPic(new String[]{"pic reward box1.png","pic reward box2.png"});
                    if(result.sim>0.8f){
                        int colorNum=mFairy.getColorNum(1161,633,1261,714,0.9f,0,"81,162,195");
                        if(colorNum>400){
                            mFairy.onTap(1201,665,1206,673,"领取奖励",1000);
                            return;
                        }
                    }

                    //领取活跃奖励2
                    result=mFairy.findPic("pic reward box3.png");
                    if(result.sim>0.8f){
                        int colorNum=mFairy.getColorNum(1161,633,1261,714,0.95f,0,"81,162,195");
                        if(colorNum>150){
                            mFairy.onTap(1201,665,1206,673,"领取奖励",1000);
                            return;
                        }
                    }

                    //类型分页
                    result=mFairy.findPic(118,635,999,720,"word activity "+option+".png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic(str);
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("找到"+str));

                            //前往
                            result1=mFairy.findPic(result.x-8,result.y+89,result.x+43,result.y+149,new String[]{"word task go.png","word task receive.png"});
                            if(result1.sim>0.8f){
                                tastState=1;
                                mFairy.onTap(0.8f,result1,"前往",1000);
                                setTaskEnd();
                            }

                            //打开
                            result1=mFairy.findPic(result.x-8,result.y+89,result.x+43,result.y+149,"word task open1.png");
                            if(result1.sim>0.8f){
                                tastState=1;
                                mFairy.onTap(0.8f,result1,"打开",1000);
                                setTaskEnd();
                            }

                            //匹配
                            result1=mFairy.findPic(result.x-7,result.y+105,result.x+48,result.y+155,"word task match.png");
                            if(result1.sim>0.8f){
                                tastState=1;
                                mFairy.onTap(0.8f,result1,"匹配",1000);
                                setTaskEnd();
                            }

                            //未开启
                            result1=mFairy.findPic(result.x-29,result.y+91,result.x+13,result.y+135,"pic task lock.png");
                            if(result1.sim>0.8f){
                                tastState=0;
                                mFairy.onTap(0.8f,result1,1213,44,1225,57,"未开启",1000);
                                setTaskEnd();
                            }
                        }else{

                            TemplateInfo info = mFairy.getTemplateInfo(str);
                            //前往 课业
                            result1=mFairy.findPic(info.x-8,info.y+89,info.x+43,info.y+149,new String[]{"word task go.png"});
                            if(result1.sim>0.8f){
                                tastState=1;
                                mFairy.onTap(0.8f,result1,"前往",1000);
                                setTaskEnd();
                            }

                            //已完成
                            result1=mFairy.findPic(info.x+15,info.y+20,info.x+61,info.y+81,"word task finish.png");
                            if(result1.sim>0.8f){
                                tastState=0;
                                mFairy.onTap(0.8f,result1,1213,44,1225,57,"已完成",1000);
                                setTaskEnd();
                            }
                        }
                    }else{
                        switch (option){
                            case "jianghu":
                                mFairy.onTap(190,677,197,683,"切换"+option,1000);
                                break;
                            case "bangpai":
                                mFairy.onTap(327,678,340,686,"切换"+option,1000);
                                break;
                            case "fenzheng":
                                mFairy.onTap(468,673,480,683,"切换"+option,1000);
                                break;
                            case "hangdang":
                                mFairy.onTap(604,675,616,684,"切换"+option,1000);
                                break;
                            case "shejiao":
                                mFairy.onTap(882,674,894,681,"切换"+option,1000);
                                break;
                            case "youli":
                                mFairy.onTap(749,673,761,682,"切换"+option,1000);
                                break;
                        }
                    }
                }
                overtime(20,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn use.png");
                mFairy.onTap(0.8f,result,"使用",1000);

                result=mFairy.findPic("word hint btn affirm use.png");
                mFairy.onTap(0.8f,result,"确认使用",1000);
            }
        }.taskContent(mFairy,"找任务中");
        return  tastState;
    }

    //队长 切换/查找队伍目标
    public void task(final String goal,final String detail)throws Exception{
        new Util(mFairy){
            boolean findDetail=false;
            @Override
            public void create() throws Exception {
                if(detail!=null&&!detail.equals(""))findDetail=true;
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(10,0);
                result=mFairy.findPic("pic dialogue select.png");
                mFairy.onTap(0.8f,result,1234,21,1247,38,"关闭-对话",1000);

                result=mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"打开任务栏",1000);

                result=mFairy.findPic(new String[]{"pic change team.png","pic team paging.png"});
                mFairy.onTap(0.8f,result,"打开队伍界面",1000);

                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn create.png");
                    mFairy.onTap(0.8f,result,"创建队伍",1000);
                    if (result.sim > 0.8f){
                        err=0;
                    }
                    result=mFairy.findPic(new String[]{"word btn follow header.png","word btn cancel follow.png"});
                    mFairy.onTap(0.8f,result,1095,581,1105,593,"退出队伍",1000);

                    result=mFairy.findPic("word btn a key call.png");
                    if(result.sim>0.8f)setTaskName(2);
                }
            }

            @Override
            public void content_2() throws Exception {
                overtime(20,0);
                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){

                    result=mFairy.findPic("word team goal level.png");
                    if(picCount(0.8f,result,"goal level")==1)initRan();//初始化滑动
                    if(result.sim>0.8f){
                        if(findDetail){
                            result=mFairy.findPic(445,189,587,515,"word team goal "+goal+".png");
                            if(result.sim>0.8f){
                                result=mFairy.findPic(result.x+128,result.y-5,result.x+170,result.y+30,"pic team goal open1.png");
                                mFairy.onTap(0.8f,result,"打开"+goal,1000);
                            }

                            result=mFairy.findPic(445,189,587,515,"word team detail "+detail+".png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"找到"+detail,1000);
                                mFairy.onTap(0.8f,result,1035,570,1041,579,"确定",1000);
                                return;
                            }
                            mFairy.ranSwipe(543,440,552,290,1000,1500l,1);//没找到 滑动
                        }else{
                            result=mFairy.findPic(445,189,587,515,"word team goal "+goal+".png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result,"找到"+goal,1000);
                                mFairy.onTap(0.8f,result,1035,570,1041,579,"确定",1000);
                                return;
                            }
                        }
                    }else{
                        if(!findDetail)result=mFairy.findPic("word team selected "+goal+".png");
                        if(findDetail)result=mFairy.findPic("word team selected "+detail+".png");
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("切换目标完成"));
                            setTaskEnd();
                        }else{
                            mFairy.onTap(205,146,209,153,"打开队伍目标",3000);
                            return;
                        }

                        //目标为空 或 目标不符
                        result=mFairy.findPic("word team goal none.png");
                        mFairy.onTap(0.8f,result,"打开队伍目标",3000);
                    }
                }
            }

            //初始化滑动
            public void initRan() throws Exception{
                LtLog.e(mFairy.getLineInfo("初始化滑动"));
                for(int i=1;i<=4;i++){
                    result=mFairy.findPic(new String[]{"word team goal init none.png","word team goal init none1.png"});
                    if(result.sim>0.8f)break;
                    mFairy.ranSwipe(578,239,584,496,500,1500l,1);
                }
                LtLog.e(mFairy.getLineInfo("初始化滑动完成"));
            }
            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint leave team.png");
                mFairy.onTap(0.8f,result,848,504,858,514,"确定离开队伍",1000);
            }
        }.taskContent(mFairy,"切换队伍目标");
    }

    public void task(final String goal)throws Exception{
        task(goal,null);
    }

    //跟队
    public void task1(final String goal,final String detail)throws Exception{
        new Util(mFairy){
            boolean findDetail=false;
            @Override
            public void create() throws Exception {
                if(detail!=null&&!detail.equals(""))findDetail=true;
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                overtime(10,0);
                result=mFairy.findPic("pic open task.png");
                mFairy.onTap(0.8f,result,"打开任务栏",1000);

                result=mFairy.findPic(new String[]{"pic change team.png","pic team paging.png"});
                mFairy.onTap(0.8f,result,"打开队伍界面",1000);

                result=mFairy.findPic("word team interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word btn speedy form.png");
                    mFairy.onTap(0.8f,result,"便捷组队",1000);

                    result=mFairy.findPic("word btn refresh list.png");
                    if(result.sim>0.8f)setTaskName(2);
                }
            }

            @Override
            public void content_2() throws Exception {
                overtime(20,0);
                result=mFairy.findPic("word btn refresh list.png");
                if(picCount(0.8f,result,"goal level")==1)initRan();
                if(result.sim>0.8f){
                    if(findDetail){
                        result=mFairy.findPic(185,134,317,611,"word team goal "+goal+".png");
                        if(result.sim>0.8f){
                            result=mFairy.findPic(result.x+128,result.y-5,result.x+170,result.y+30,"pic team goal open.png");
                            mFairy.onTap(0.8f,result,"打开"+goal,1000);
                        }

                        result=mFairy.findPic(185,134,317,611,"word team detail "+detail+".png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"找到"+detail,1000);
                            mFairy.onTap(0.8f,result,911,582,917,589,"自动匹配",1000);
                            setTaskEnd();
                            return;
                        }
                        mFairy.ranSwipe(275,434,275,334,1000,1500l,1);//没找到 滑动
                    }else{
                        result=mFairy.findPic(185,134,317,611,"word team goal "+goal+".png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"找到"+goal,1000);
                            mFairy.onTap(0.8f,result,911,582,917,589,"自动匹配",1000);
                            setTaskEnd();
                            return;
                        }
                    }
                }
            }

            //初始化滑动
            public void initRan() throws Exception{
                LtLog.e(mFairy.getLineInfo("初始化滑动"));
                for(int i=1;i<=4;i++){
                    result=mFairy.findPic(new String[]{"word team join total.png","word team join total1.png"});
                    if(result.sim>0.8f)break;
                    mFairy.ranSwipe(275,239,275,496,500,1500l,1);
                }
                LtLog.e(mFairy.getLineInfo("初始化滑动完成"));
            }
            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint leave team.png");
                mFairy.onTap(0.8f,result,848,504,858,514,"确定离开队伍",1000);
            }
        }.taskContent(mFairy,"切换队伍目标");
    }

    //画面设置
    public void init_picture()throws Exception{
        new Util(mFairy){
            int task=1;

            @Override
            public void create() throws Exception {
                super.create();
                if(AtFairyConfig.getOption("test").equals("1"))setTaskEnd();
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(task);
                return;
            }

            @Override
            public void content_1() throws Exception {
                overtime(6,0);
              /*  result=mFairy.findPic("pic up tip.png");
                if(result.sim>0.8f){*/
                result=mFairy.findPic("word lu.png");
                LtLog.e("***"+result.sim);
                if(result.sim>0.8f){
                    result=mFairy.findPic("pic open system.png");
                    mFairy.onTap(0.8f,result,"展开系统",1000);
                    LtLog.e("/////"+result.sim);
                }
            //mFairy.ranSwipe(1121,653,1112,331,500,500l,0);
                result=mFairy.findPic(944,226,1270,708,"pic setting.png");
                mFairy.onTap(0.8f,result,"进入设置",1000);
                if (result.sim < 0.8f){
                    LtLog.e("滑动");
                    mFairy.ranSwipe(1144,502,1137,330,500,1000);
                }
 //               }

                result=mFairy.findPic(108,186,467,568,new String[]{"word setting model.png","word setting model1.png","word setting mode2.png"});
                mFairy.onTap(0.8f,result,"打开界面模式",1000);

                result=mFairy.findPic("word select interface.png");
                mFairy.onTap(0.8f,result,732,350,744,362,"夜泊模式",1000);
                mFairy.onTap(0.8f,result,625,488,645,505,"确定",1000);
                mFairy.onTap(0.8f,result,1109,64,1125,82,"关闭",1000);
                if(result.sim>0.8f)setTaskEnd();
            }


        }.taskContent(mFairy,"画面设置");
    }
}
