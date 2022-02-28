package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

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
    List<String> colorList=new ArrayList<String>();
    public Util(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    //回大厅
    public void close()throws Exception{
        new Util(mFairy){
            boolean increa=true;
            int closeNum=5;
            @Override
            public void content_0() throws Exception {
                LtLog.e(mFairy.getLineInfo("closeNum="+closeNum));
                //关闭5次
                if(--closeNum<=0){
                    LtLog.e(mFairy.getLineInfo("关闭结束"));
                    setTaskEnd();
                }

                result=mFairy.findPic(1194,0,1268,64,"pic return.png");
                mFairy.onTap(0.75f,result,"返回",1000);

                result=mFairy.findPic(1074,50,1277,197,"pic close1.png");
                mFairy.onTap(0.8f,result,"活动 关闭",1000);

                result=mFairy.findPic("pic close2.png");
                mFairy.onTap(0.8f,result,"活动 关闭",1000);

                result=mFairy.findPic("word continue.png");
                mFairy.onTap(0.8f,result,"跳过",1000);

                result=mFairy.findPic(new String[]{"pic copy leave.png","pic copy leave1.png"});
                mFairy.onTap(0.8f,result,"离开副本",1000);
                mFairy.onTap(0.8f,result,633,519,640,528,"确定离开副本",1000);

                result=mFairy.findPic(1014,35,1062,92,new String[]{"pic copy leave.png","pic copy leave1.png"});
                mFairy.onTap(0.8f,result,"离开副本",1000);
                mFairy.onTap(0.8f,result,633,519,640,528,"确定离开副本",1000);

                result=mFairy.findPic("pic xb close.png");
                mFairy.onTap(0.8f,result,"寻宝关闭",1000);

                result= mFairy.findPic(1153,517,1213,610,"pic btn hudong.png");
                mFairy.onTap(0.8f,result,517,543,701,716,"关闭事件按钮",1000);

                result=mFairy.findPic(1130,5,1276,161,"pic picture close.png");
                mFairy.onTap(0.8f,result,"图片",1000);

                result=mFairy.findPic(520,450,620,650,new String[]{"pic button.png","pic button1.png"});
                mFairy.onTap(0.8f,result,"close 确认",1000);

                result=mFairy.findPic(830,150,933,223,"pic hint close.png");
                mFairy.onTap(0.8f,result,"关闭提示",1000);

                result=mFairy.findMultiColor(830,504,890,534,
                        0.95f,"107,138,161","6|0|107,137,161&8|0|106,138,160&13|0|109,139,161&18|0|119,148,177&20|2|140,172,200&20|4|136,167,197&22|4|140,170,194&22|5|142,173,197&22|6|143,173,199");
                mFairy.onTap(0.8f,result,"对话选择",1000);

                //关闭
                List<FindResult> resultList = mFairy.findPic(850,1,1276,294, 0.8f, "pic close.png");
                if(resultList.size()!=0){
                    if(increa){
                        closeNum=5;
                        increa=false;
                    }
                    while(resultList.size()>0){
                        result=resultList.get(0);
                        resultList.remove(0);
                        mFairy.onTap(0.8f,result,"关闭",1000);
                    }
                }

                if(closeNum==1){
                    mFairy.onTap(971,690,982,699,"点击关闭",500);
                }

            }
        }.taskContent(mFairy,"关闭");
    }

    //发呆超时
    public long dazeTime()throws Exception{
        if(fadTime!=0L){
            //自动寻路中
            result=mFairy.findPic(625,470,655,527,"word way.png");
            if(result.sim>0.8){
                LtLog.e(mFairy.getLineInfo("自动寻路中"));
                initDaze();
                return 0L;
            }
            //传送
            result=mFairy.findPic(new String[]{"pic load.png","pic transfer.png"});
            if(result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("地图传送中"));
                initDaze();
                return 0L;
            }
            //战斗加载
            result=mFairy.findPic(new String[]{"pic fight load.png"});
            if(result.sim>0.8f){
                LtLog.e(mFairy.getLineInfo("战斗加载中"));
                initDaze();
                return 0L;
            }

            long dazeTime=System.currentTimeMillis()/ 1000L;//获取现在时间
            dazeTime=dazeTime-fadTime;//现在-之前
            LtLog.e(mFairy.getLineInfo("发呆时间dazeTime="+dazeTime));
            return dazeTime;
        }else{
            fadTime=System.currentTimeMillis() / 1000L;//获取当前时间
            return  0L;
        }
    }

    //初始化发呆
    public void initDaze ()throws Exception{
        fadTime=0L;
    }

    static int tastState = 0;

    //日常活动
    //str 查找的任务图标
    //option 类型
    public int mission(final String str,final int option) throws Exception{
        tastState=0;
        new Util(mFairy){
            int findTask=0;
            boolean award=true;
            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic("word daily interface.png");
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
                result=mFairy.findPic(new String[]{"pic btn daily.png","pic btn daily1.png"});
//                result=mFairy.findPic(812,51,934,74,"word btn daily.png");
                mFairy.onTap(0.7f,result,"进入日常",1000);

                //日常界面
                result=mFairy.findPic("word daily interface.png");
                if(result.sim>0.8f){
                    //日常分页
                    result=mFairy.findPic("word daily type.png");
                    if(result.sim>0.8f){

                        if(award){
                            //领取日常奖励
                            for (int i=1;i<=5;i++){
                                String change = mFairy.change(532+(i-1)*115, 613, 544+(i-1)*115, 626);
                                if(i==5)award=false;
                                if(!change.equals("0,0")){
                                    mFairy.onTap(532+(i-1)*115, 613, 544+(i-1)*115, 626,"领取活跃奖励",1000);
                                    mFairy.onTap(532+(i-1)*115, 613, 544+(i-1)*115, 626,"确认领取",1000);
                                    return;
                                }

                            }
                        }


                        //类型选项
                        result=mFairy.findPic(372+(option-1)*108,112,422+(option-1)*108,162,"pic task select.png");
                        if(result.sim>0.8f){
                            //具体任务
                            result=mFairy.findPic(229,186,815,544,str);
                            if(result.sim>0.8f){
                                LtLog.e(mFairy.getLineInfo("找到"+str+"任务"));
                                //已经完成
                                result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word task already finish.png");
                                if(result1.sim>0.8f){
                                    mFairy.onTap(0.8f,result1,1142,90,1150,96,"任务已经完成",1000);
                                    setTaskEnd();
                                    return;
                                }

                                //任务没开启
                                result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word task open.png");
                                if(result1.sim>0.8f){
                                    mFairy.onTap(0.8f,result1,1142,90,1150,96,"任务没有开启",1000);
                                    setTaskEnd();
                                    return;
                                }

                                //未完成 点击前往
                                result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word daily go.png");
                                if(result1.sim>0.8f){
                                    mFairy.onTap(0.8f,result1,"找到任务，前往",1000);
                                    tastState=1;
                                    setTaskEnd();
                                    return;
                                }
                            }
                        }else{
                            mFairy.onTap(393+(option-1)*108,136,402+(option-1)*108,145,"勾选"+option+"类型",1000);
                        }
                    }else{
                        result=mFairy.findPic("word daily.png");
                        mFairy.onTap(0.8f,result,"切换日常分页",1000);
                    }
                }
                overtime(20,0);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(557,95,613,318,"word backage already full.png");
                if(result.sim>0.8f)award=false;

                result=mFairy.findPic("word hint power full.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,623,513,638,525,"体力值已满",1000);
                    award=false;
                }

                result=mFairy.findPic("word hint title preview.png");
                mFairy.onTap(0.8f,result,626,493,641,508,"奖励预览",1000);
            }
        }.taskContent(mFairy,"找任务中");
        return  tastState;
    }

    //日常活动
    //str 查找的任务图标
    public int mission(final String str) throws Exception{
        tastState=0;
        new Util(mFairy){
            int findTask=0;
            int ran=0;
            boolean award=true;
            @Override
            public void content_0() throws Exception {
                ran=0;
                result=mFairy.findPic("word daily interface.png");
                if(result.sim>0.8f){
                    if(findTask++>2){
                        tastState=2;
                        mFairy.onTap(0.8f,result,1142,90,1150,96,"没有找到这个任务"+str,1000);
                        setTaskEnd();
                    }
                }else{
                    close();
                    setTaskName(1);
                }
            }
            @Override
            public void content_1() throws Exception {
//                result=mFairy.findPic(812,51,934,74,"word btn daily.png");
                result=mFairy.findPic(new String[]{"pic btn daily.png","pic btn daily1.png"});
                mFairy.onTap(0.7f,result,"进入日常",1000);
                //日常界面
                result=mFairy.findPic("word daily interface.png");
                if(result.sim>0.8f){
                    //日常分页
                    result=mFairy.findPic("word daily type.png");
                    if(result.sim>0.8f){
                        if(award){
                            //领取日常奖励
                            for (int i=1;i<=5;i++){
                                String change = mFairy.change(532+(i-1)*115, 613, 544+(i-1)*115, 626);
                                if(i==5)award=false;
                                if(!change.equals("0,0")){
                                    mFairy.onTap(532+(i-1)*115, 613, 544+(i-1)*115, 626,"领取活跃奖励",1000);
                                    mFairy.onTap(532+(i-1)*115, 613, 544+(i-1)*115, 626,"确认领取",1000);
                                    return;
                                }

                            }
                        }


                        //具体任务
                        result=mFairy.findPic(229,186,774,544,str);
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("找到"+str+"任务"));
                            //已经完成
                            result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word task already finish.png");
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,1142,90,1150,96,"任务已经完成",1000);
                                setTaskEnd();
                                return;
                            }

                            //任务没开启
                            result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word task open.png");
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,1142,90,1150,96,"任务没有开启",1000);
                                setTaskEnd();
                                return;
                            }

                            //未完成 点击前往
                            result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word daily go.png");
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"找到任务，前往",1000);
                                tastState=1;
                                setTaskEnd();
                                return;
                            }
                        }else{
                            if(ran++>=2){
                                setTaskName(0);
                                return;
                            }
                            //没找到，往下滑
                            mFairy.ranSwipe(655,551,655,224,1000,1500l,0);
                        }
                    }else{
                        result=mFairy.findPic("word daily.png");
                        mFairy.onTap(0.8f,result,"切换日常分页",1000);
                        ran=0;
                    }
                }
                overtime(20,0);
            }
            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(557,95,613,318,"word backage already full.png");
                if(result.sim>0.8f)award=false;

                result=mFairy.findPic("word hint power full.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,623,513,638,525,"体力值已满",1000);
                    award=false;
                }

                result=mFairy.findPic("word hint title preview.png");
                mFairy.onTap(0.8f,result,626,493,641,508,"奖励预览",1000);
            }
        }.taskContent(mFairy,"找任务中");
        return  tastState;
    }

    //限时活动
    //str 查找的任务图标
    public int mission1(final String str) throws Exception{
        tastState=0;
        new Util(mFairy){
            int findTask=0;
            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic("word daily interface.png");
                if(result.sim>0.8f){
                    if(findTask++>2){
                        tastState=2;
                        mFairy.onTap(0.8f,result,1142,90,1150,96,"没有找到这个任务"+str,1000);
                        setTaskEnd();
                    }
                }else{
                    close();
                    setTaskName(1);
                }
            }
            @Override
            public void content_1() throws Exception {
//                result=mFairy.findPic(812,51,934,74,"word btn daily.png");
                result=mFairy.findPic(new String[]{"pic btn daily.png","pic btn daily1.png"});
                mFairy.onTap(0.7f,result,"进入日常",1000);

                //日常界面
                result=mFairy.findPic("word daily interface.png");
                if(result.sim>0.8f){

                    //限时活动分页
                    result=mFairy.findPic("word timing activity1.png");
                    if(result.sim>0.8f){

                        //寻找活动
                        result=mFairy.findPic(225,163,856,457,str);
                        if(result.sim>0.8f){
                            LtLog.e(mFairy.getLineInfo("找到"+str+"任务"));
                            //已经完成
                            result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,new String[]{"word task already finish.png","word timing baoming1.png"});
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,1142,90,1150,96,"任务已经完成/已经报名过",1000);
                                setTaskEnd();
                                return;
                            }

                            //任务没开启
                            result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,"word task open.png");
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,1142,90,1150,96,"任务没有开启",1000);
                                setTaskEnd();
                                return;
                            }

                            //未完成 点击前往
                            result1=mFairy.findPic(result.x+233,result.y+24,result.x+332,result.y+72,new String[]{"word timing baoming.png","word daily go.png"});
                            if(result1.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"找到任务，报名/前往",1000);
                                tastState=1;
                                setTaskEnd();
                                return;
                            }
                        }
                    }else{
                        result=mFairy.findPic("word timing activity.png");
                        mFairy.onTap(0.8f,result,"切换限时活动分页",1000);
                    }
                }
                overtime(20,0);
            }
        }.taskContent(mFairy,"找任务中");
        return  tastState;
    }

    //画面设置
    public void init_picture()throws Exception{
        new Util(mFairy){
            int task=1;
            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(task);
                return;
            }

            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word setting interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word image paging.png");
                    if(result.sim>0.8){
                        result=mFairy.findPic("pic unselect.png");
                        mFairy.onTap(0.8f,result,"选中省电模式",1000);

                        result=mFairy.findPic("pic selected.png");
                        if(result.sim>0.8f){
                            task=2;
                            setTaskName(2);
                            return;
                        }
                    }else{
                        mFairy.onTap(521,170,528,181,"切换画面分页",1000);
                    }
                }
                overtime(15,0);
            }

            @Override
            public void content_2() throws Exception {
                overtime(15,0);
                result=mFairy.findPic("word setting interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic("word preference paging.png");
                    if(result.sim>0.8){

                        result=mFairy.findPic(863,333,898,369,"pic on button.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"自动提交道具",1000);
                            return;
                        }


                        result=mFairy.findPic(598,382,631,416,"pic on button.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"关闭屏蔽圆角适配",1000);
                            return;
                        }

                        result=mFairy.findPic(603,428,634,464,"pic on button.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"关闭战斗休闲",1000);
                            return;
                        }

                        result=mFairy.findPic(655,474,691,513,"pic on button.png");
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,"屏蔽无关特效",1000);
                            return;
                        }
                        mFairy.onTap(943,98,951,107,"画面设置完成",1000);
                        setTaskEnd();
                    }else{
                        mFairy.onTap(782,163,789,170,"切换偏好分页",1000);
                    }
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic(new String[]{"pic open more.png","pic open more1.png"});
                mFairy.onTap(0.8f,result,"展开更多",1000);

                result=mFairy.findPic(new String[]{"word btn setting.png","word btn setting1.png"});
                mFairy.onTap(0.8f,result,"进入设置",1000);
            }
        }.taskContent(mFairy,"画面设置");
    }
}
