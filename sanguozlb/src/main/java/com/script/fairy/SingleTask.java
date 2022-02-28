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

    //主线 一 二 三 章
    public void main()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
                taskList=new ArrayList<String>();
                //创建角色
                if(AtFairyConfig.getOption("createRoll").equals("1")){
                    taskList.add("createRoll");
                }
                //主线第一章
                if(AtFairyConfig.getOption("nvoice_section1").equals("1")){
                    taskList.add("nvoice_section1");
                }
                //主线第二章
                if(AtFairyConfig.getOption("nvoice_section2").equals("1")){
                    taskList.add("nvoice_section2");
                }
                //主线第二章
                if(AtFairyConfig.getOption("nvoice_section3").equals("1")){
                    taskList.add("nvoice_section3");
                }
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有勾选任何任务，主线结束"));
                    setTaskEnd();
                    return;
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务完成，主线结束"));
                    setTaskEnd();
                    return;
                }
                //创建角色
                if(taskList.get(0).equals("createRoll")){
                    createRoll();
                    taskList.remove(0);
                    return;
                }

                //主线第一章
                if(taskList.get(0).equals("nvoice_section1")){
                    nvoice_section1();
                    taskList.remove(0);
                    return;
                }

                //主线第二章
                if(taskList.get(0).equals("nvoice_section2")){
                    nvoice_section2();
                    taskList.remove(0);
                    return;
                }

                //主线第三章
                if(taskList.get(0).equals("nvoice_section3")){
                    nvoice_section3();
                    taskList.remove(0);
                    return;
                }
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn at once.png");
                mFairy.onTap(0.8f,result,"城建立即",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"新手主线");
    }

    //创建角色
    public void createRoll()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                result=mFairy.findPic("pic people laozhe.png");
                mFairy.onTap(0.8f,result,960,583,973,596,"回应对话",1000);

                result1=mFairy.findPic(963,546,1010,581,"word novice answer.png");
                mFairy.onTap(0.8f,result1,810,216,820,229,"选项回答",1000);

                result=mFairy.findPic("word novice select.png");
                mFairy.onTap(0.8f,result,"确认选择",1000);

                result=mFairy.findPic("word novice enter.png");
                mFairy.onTap(0.8f,result,"进入乱世",1000);

                result=mFairy.findPic("word btn random.png");
                mFairy.onTap(0.8f,result,"随机名字",1000);

                result=mFairy.findPic("word novice enter1.png");
                mFairy.onTap(0.8f,result,"入驻起兵之地",1000);

                result=mFairy.findPic(629,163,682,207,"pic people laozhe.png");
                mFairy.onTap(0.8f,result,960,583,973,596,"回应对话",1000);

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                int colorNum=mFairy.getColorNum(1141,550,1173,583,0.9f,0,"255,253,231");
                if(colorNum>100)mFairy.onTap(849,545,850,546,"回应对话",1000);

                result=mFairy.findPic("word btn task.png");
                result1=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                if(result.sim>0.8f||result1.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("创建角色完成"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"创建角色");
    }

    //新手第一章
    public void nvoice_section1()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
                createRoll();
                setTaskName(1);
                return;
            }

            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                //大厅主界面
                result=mFairy.findPic("word btn task.png");
                int picCount=picCount(0.8f,result,"btn task");
                if(result.sim>0.8f){
                    if(picCount!=0&&picCount%5==0){
                        mFairy.onTap(0.8f,result,"进入任务界面",1000);
                    }

                    result=mFairy.findPic("word guide recruit.png");
                    mFairy.onTap(0.8f,result,920,651,933,663,"点击前往招募",1000);

                    result=mFairy.findPic(620,467,690,492,"word guide main city.png");
                    mFairy.onTap(0.8f,result,623,308,637,322,"选中主城",1000);

                    result=mFairy.findPic(655,409,722,449,"word guide main city.png");
                    mFairy.onTap(0.8f,result,634,318,642,329,"进入主城",1000);

                    result=mFairy.findPic("word guide award.png");
                    mFairy.onTap(0.8f,result,636,340,646,352,"领取首占奖励",1000);

                    result=mFairy.findPic("word guide back city.png");
                    mFairy.onTap(0.8f,result,1192,249,1199,258,"回城",1000);

                    result=mFairy.findPic("word guide yuan.png");
                    mFairy.onTap(0.8f,result,636,311,647,321,"支援义军",1000);

                    result=mFairy.findPic("pic attack.png");
                    mFairy.onTap(0.8f,result,"攻占",1000);

                    result=mFairy.findPic("pic walk.png");
                    mFairy.onTap(0.8f,result,"行军",1000);

                    result=mFairy.findPic("pic select place.png");
                    mFairy.onTap(0.8f,result,638,322,643,328,"选择一块地",1000);
                }

                //任务界面
                result=mFairy.findPic("word task interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(new String[]{"word section.png","word section1.png"});
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word zhuxian.png");
                        mFairy.onTap(0.8f,result,"切换主线分页",1000);
                    }else{
                        result=mFairy.findPic("word task section1.png");//第一章初出茅庐
                        if(result.sim<0.8f){
                            LtLog.e(mFairy.getLineInfo("不是第一章，结束任务"));
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("word btn get1.png");
                        mFairy.onTap(0.8f,result,"总任务奖励-领取",1000);

                        result=mFairy.findPic(1102,311,1215,621,"word btn get.png");
                        mFairy.onTap(0.8f,result,"任务奖励-领取",1000);

                        result=mFairy.findPic(1102,311,1215,621,"word btn go to.png");
                        mFairy.onTap(0.8f,result,"执行任务-前往",1000);
                    }
                }

                result=mFairy.findPic("word guide config.png");
                mFairy.onTap(0.8f,result,113,628,126,643,"编制队伍",1000);

                result=mFairy.findPic("pic select team.png");
                mFairy.onTap(0.8f,result,77,620,85,630,"选择部队",1000);
                //部队配置界面
                result=mFairy.findPic("word config interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(386,408,482,449,new String[]{"word guide config.png","word guide change.png"});
                    mFairy.onTap(0.8f,result,417,266,428,277,"配置/更换主将",1000);

                    result=mFairy.findPic(604,407,669,447,"word guide config.png");
                    mFairy.onTap(0.7f,result,628,263,641,276,"配置副将",1000);

                    result=mFairy.findPic("word guide fenbing.png");
                    mFairy.onTap(0.8f,result,156,668,164,679,"快速分兵",1000);

                    result=mFairy.findPic(1106,466,1180,515,"word guide fenbing.png");
                    mFairy.onTap(0.8f,result,1120,593,1130,603,"确认分兵",1000);

                    result=mFairy.findPic("word guide bingzhong.png");
                    mFairy.onTap(0.8f,result,1155,405,1161,413,"进入兵种选择界面",1000);

                    result=mFairy.findPic(678,289,738,324,"word guide bingzhong.png");
                    mFairy.onTap(0.8f,result,957,307,967,318,"切换兵种",1000);

                    result=mFairy.findPic("word guide xiazhen.png");
                    mFairy.onTap(0.8f,result,483,112,490,119,"下阵",1000);
                }

                result=mFairy.findPic("word recruit free.png");
                mFairy.onTap(0.8f,result,"新手免费招募",1000);

                result=mFairy.findPic("word recruit free1.png");
                mFairy.onTap(0.8f,result,"任务免费招募",1000);

                result=mFairy.findPic("word btn build.png");
                mFairy.onTap(0.8f,result,"建造",1000);

                result=mFairy.findPic("word btn walk.png");
                mFairy.onTap(0.8f,result,"行军确认",1000);

                result=mFairy.findPic("word btn attack.png");
                mFairy.onTap(0.8f,result,"攻占确认",1000);

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word team select.png");
                mFairy.onTap(0.8f,result,642,624,651,631,"选择部队",1000);

                result=mFairy.findPic("word tap tian.png");
                mFairy.onTap(0.8f,result,"点击跳过",1000);

                result=mFairy.findPic("word answer assart.png");
                mFairy.onTap(0.8f,result,"开垦农田",1000);

                result=mFairy.findPic("word btn continue.png");
                mFairy.onTap(0.8f,result,"跳过攻占详情",1000);

                result=mFairy.findPic(1189,190,1273,339,"word btn shangzhen.png");
                mFairy.onTap(0.8f,result,"上阵",1000);

                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                result1=mFairy.findPic("word affirm.png");
                if(result1.sim<0.8f)mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",500);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(588,311,690,343,"word hint remove.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word btn hint affirm.png");
                        mFairy.onTap(0.8f,result,"确认",1000);
                        return;
                    }
                }
                super.inOperation();
            }
        }.taskContent(mFairy,"新手主线第一章");
    }

    //新手第二章
    public void nvoice_section2()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);

                return;
            }

            @Override
            public void content_1() throws Exception {
                //大厅主界面
                result=mFairy.findPic("word btn task.png");
                int picCount=picCount(0.8f,result,"btn task");
                if(result.sim>0.8f){
                    if(picCount!=0&&picCount%5==0){
                        mFairy.onTap(0.8f,result,"进入任务界面",1000);
                    }
                    result=mFairy.findPic("pic attack.png");
                    mFairy.onTap(0.8f,result,"攻占",1000);

                    result=mFairy.findPic("pic walk.png");
                    mFairy.onTap(0.8f,result,"行军",1000);
                }

                //任务界面
                result=mFairy.findPic("word task interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(new String[]{"word section.png","word section1.png"});
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word zhuxian.png");
                        mFairy.onTap(0.8f,result,"切换主线分页",1000);
                    }else{
                        result=mFairy.findPic("word task section2.png");//第一章白废待兴
                        if(result.sim<0.8f){
                            LtLog.e(mFairy.getLineInfo("不是第二章，结束任务"));
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("word btn get1.png");
                        mFairy.onTap(0.8f,result,"总任务奖励-领取",1000);

                        result=mFairy.findPic(1107,318,1205,403,"word btn get.png");
                        mFairy.onTap(0.8f,result,"任务奖励-领取",1000);


                        int index=0;
                        //找前往 前三个
                        List<FindResult> findList = mFairy.findPic(1109, 319, 1199, 620, 0.8f, "word btn go to.png");
                        if(findList.size()!=0) {
                            //获取第一个
                            result1 = findList.get(0);

                            //攻占领地
                            result = mFairy.findPic(result1.x - 709, result1.y - 34, result1.x - 640, result1.y + 11, "word task attack.png");
                            if (result.sim > 0.8f) {
                                //三分钟攻占一次领地
                                boolean task_attack = timekeep(1, 3 * 60 * 1000, "task attack");
                                if (task_attack) {
                                    mFairy.onTap(0.8f, result1, "前往攻占领地", 1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }

                            //提升(君王殿)五分钟一次
                            result = mFairy.findPic(result1.x - 709, result1.y - 34, result1.x - 640, result1.y + 11, "word task up.png");
                            if (result.sim > 0.8f) {
                                if (timekeep(1, 5 * 60 * 1000, "city up")) {
                                    mFairy.onTap(0.8f, result1, "前往提升", 1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }


                            //建造 一分钟一次
                            result = mFairy.findPic(result1.x - 709, result1.y - 34, result1.x - 640, result1.y + 11, "word task build.png");
                            if (result.sim > 0.8f) {
                                if (timekeep(1, 1 * 60 * 1000, "city create")) {
                                    mFairy.onTap(0.8f, result1, "前往建造", 1000);
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }

                result=mFairy.findPic("word btn upgrade.png");
                mFairy.onTap(0.8f,result,"升级",1000);

                result=mFairy.findPic("word btn build.png");
                mFairy.onTap(0.8f,result,"建造",1000);

                result=mFairy.findPic("word btn walk.png");
                mFairy.onTap(0.8f,result,"行军确认",1000);

                result=mFairy.findPic("word btn attack.png");
                if(result.sim>0.8f){
                    timekeepInit("task attack");//三分钟占领一次
                    mFairy.onTap(0.8f,result,"攻占确认",1000);
                }

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word occupy.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("占领中..."));
                    return;
                }

                result=mFairy.findPic("word team select.png");
                mFairy.onTap(0.8f,result,78,633,88,644,"选择部队",200);
                mFairy.onTap(0.8f,result,642,624,651,631,"选择部队",1000);

                result=mFairy.findPic("word tap tian.png");
                mFairy.onTap(0.8f,result,"点击跳过",1000);

                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                picCount=picCount(0.8f,result,"return");
                if(picCount!=0&&picCount%5==0)mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);
            }
        }.taskContent(mFairy,"新手主线第二章");
    }

    //点击完攻占确认后 两分钟内不再去攻占
    //新手第三章
    public void nvoice_section3()throws Exception{
        new SingleTask(mFairy){
            int place=1;
            @Override
            public void content_0() throws Exception {
                util.close();
                setTaskName(1);
            }

            @Override
            public void content_1() throws Exception {
                //大厅主界面
                result=mFairy.findPic("word btn task.png");
                int picCount=picCount(0.8f,result,"btn task");
                if(result.sim>0.8f){
                    if(picCount!=0&&picCount%5==0){
                        mFairy.onTap(0.8f,result,"进入任务界面",1000);
                    }
                    result1=mFairy.findPic("pic attack.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"攻占",1000);
                    }else{
                        result=mFairy.findPic("pic walk.png");
                        mFairy.onTap(0.8f,result,result.x+10,result.y-54,result.x+18,result.y-45,"行军-先攻占",1000);
                    }
                }

                //只能攻占相邻土地
                result=mFairy.findPic(664,149,723,233,"word border.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("只能攻占相邻土地，前往攻占空地"));
                    int state=select_place(place);
                    if(state==1){
                        if(place++>16)place=1;
                    }
                    return;
                }

                //任务界面
                result=mFairy.findPic("word task interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(755,133,804,167,"word section.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word zhuxian.png");
                        mFairy.onTap(0.8f,result,"切换主线分页",1000);
                    }else{
                        result=mFairy.findPic("word task section3.png");//第三章招军买马
                        if(result.sim<0.8f){
                            LtLog.e(mFairy.getLineInfo("不是第三章，结束任务"));
                            setTaskEnd();
                            return;
                        }

                        result=mFairy.findPic("word btn get1.png");
                        mFairy.onTap(0.8f,result,"总任务奖励-领取",1000);

                        result=mFairy.findPic(1107,318,1205,403,"word btn get.png");
                        mFairy.onTap(0.8f,result,"任务奖励-领取",1000);


                        int index=0;
                        //找前往 前三个
                        List<FindResult> findList = mFairy.findPic(1109, 319, 1199, 620, 0.8f, "word btn go to.png");
                        if(findList.size()!=0){
                            //获取第一个
                            result1 = findList.get(0);

                            //攻占领地
                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task attack.png");
                            if(result.sim>0.8f){
                                //30秒攻占一次领地
                                if(timekeep(1,30*1000,"task attack")){
                                    mFairy.onTap(0.8f,result1,"前往攻占领地",1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }

                            //提升(君王殿)五分钟一次
                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task up.png");
                            if(result.sim>0.8f){
                                if(timekeep(1,5*60*1000,"city up")){
                                    mFairy.onTap(0.8f,result1,"前往提升",1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }

                            //征兵 立即前往
                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task draft.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"前往提升",1000);
                                return;
                            }

                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task build.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"前往建造",1000);
                                return;
                            }
                        }
                    }
                    return;
                }

                result=mFairy.findPic("word idle.png");
                mFairy.onTap(0.8f,result,"进入征兵界面",1000);

                //征兵界面
                result=mFairy.findPic("word draft interface.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1152,531,1161,541,"最大",1000);
                    mFairy.onTap(0.8f,result,624,664,632,673,"开始征兵",1000);
                }

                result=mFairy.findPic("word btn upgrade.png");
                mFairy.onTap(0.8f,result,"升级",1000);

                result=mFairy.findPic("word btn build.png");
                mFairy.onTap(0.8f,result,"建造",1000);

                result=mFairy.findPic("word btn walk.png");
                mFairy.onTap(0.8f,result,"行军确认",1000);

                result=mFairy.findPic("word btn attack.png");
                if(result.sim>0.8f){
                    timekeepInit("task attack");//三分钟占领一次
                    mFairy.onTap(0.8f,result,"攻占确认",1000);
                }

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word occupy.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("占领中..."));
                    return;
                }

                //选择部队
                result=mFairy.findPic("word team select.png");
                if(result.sim>0.8f){
                    //选中可用待命部队
                    result=mFairy.findPic(1243,197,1272,275,"pic selected.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word none use.png");//没有待命的部队
                        if(result.sim>0.8f){
                            //放弃出征
                            mFairy.onTap(1183,38,1192,46,"没有待命的部队，放弃出征，点击返回",1000);
                            timekeepInit("task attack");
                            return;
                        }
                        mFairy.onTap(642,624,651,631,"选择部队",1000);
                        return;
                    }else{
                        mFairy.onTap(1252,235,1260,244,"只显示待命部队",1000);
                    }
                }

                result=mFairy.findPic("word tap tian.png");
                mFairy.onTap(0.8f,result,"点击跳过",1000);

                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                picCount=picCount(0.8f,result,"return");
                if(picCount!=0&&picCount%5==0)mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn insist.png");
                mFairy.onTap(0.8f,result,"坚持出征",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"新手主线第三章");
    }

    //新手指引
    public void nvoice ()throws Exception{
        new SingleTask(mFairy){
            int place=1,taskSection=1;
            @Override
            public void create() throws Exception {
                createRoll();
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {

                if(taskSection==4){
                    LtLog.e(mFairy.getLineInfo("升到第四章了，结束新手指引"));
                    setTaskEnd();
                    return;
                }
                setTaskName(taskSection);

                if(overtime(3,0)){
                    if(++taskSection>=4)taskSection=1;
                    LtLog.e(mFairy.getLineInfo("初始化超时，taskSection="+taskSection));
                }
            }

            @Override
            public void content_1() throws Exception {
                //大厅主界面
                result=mFairy.findPic("word btn task.png");
                int picCount=picCount(0.8f,result,"btn task");
                if(result.sim>0.8f){
                    if(picCount!=0&&picCount%5==0){
                        mFairy.onTap(0.8f,result,"进入任务界面",1000);
                    }

                    result=mFairy.findPic("word guide recruit.png");
                    mFairy.onTap(0.8f,result,920,651,933,663,"点击前往招募",1000);

                    result=mFairy.findPic(620,467,690,492,"word guide main city.png");
                    mFairy.onTap(0.8f,result,623,308,637,322,"选中主城",1000);

                    result=mFairy.findPic(655,409,722,449,"word guide main city.png");
                    mFairy.onTap(0.8f,result,634,318,642,329,"进入主城",1000);

                    result=mFairy.findPic("word guide award.png");
                    mFairy.onTap(0.8f,result,636,340,646,352,"领取首占奖励",1000);

                    result=mFairy.findPic("word guide back city.png");
                    mFairy.onTap(0.8f,result,1192,249,1199,258,"回城",1000);

                    result=mFairy.findPic("word guide yuan.png");
                    mFairy.onTap(0.8f,result,636,311,647,321,"支援义军",1000);

                    result=mFairy.findPic("pic attack.png");
                    mFairy.onTap(0.8f,result,"攻占",1000);

                    result=mFairy.findPic("pic walk.png");
                    mFairy.onTap(0.8f,result,"行军",1000);

                    result=mFairy.findPic("pic select place.png");
                    mFairy.onTap(0.8f,result,638,322,643,328,"选择一块地",1000);
                }

                //任务界面
                result=mFairy.findPic("word task interface.png");
                if(result.sim>0.8f){
                    
                    result=mFairy.findPic(new String[]{"word section.png","word section1.png"});
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word zhuxian.png");
                        mFairy.onTap(0.8f,result,"切换主线分页",1000);
                    }else{
                        int currentSection=0;
                        for (int i=1;i<=4;i++){
                            result=mFairy.findPic("word task section"+i+".png");
                            if(result.sim>0.8f){
                                currentSection=i;
                                break;
                            }
                        }
                        if(currentSection!=taskSection){
                            taskSection=currentSection;
                            LtLog.e(mFairy.getLineInfo("不是当前章节"));
                            setTaskName(0);
                            return;
                        }

                        result=mFairy.findPic("word btn get1.png");
                        mFairy.onTap(0.8f,result,"总任务奖励-领取",1000);

                        result=mFairy.findPic(1102,311,1215,621,"word btn get.png");
                        mFairy.onTap(0.8f,result,"任务奖励-领取",1000);

                        result=mFairy.findPic(1102,311,1215,621,"word btn go to.png");
                        mFairy.onTap(0.8f,result,"执行任务-前往",1000);
                    }
                }

                result=mFairy.findPic("word guide config.png");
                mFairy.onTap(0.8f,result,113,628,126,643,"编制队伍",1000);

                result=mFairy.findPic("pic select team.png");
                mFairy.onTap(0.8f,result,77,620,85,630,"选择部队",1000);
                //部队配置界面
                result=mFairy.findPic("word config interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(386,408,482,449,new String[]{"word guide config.png","word guide change.png"});
                    mFairy.onTap(0.8f,result,417,266,428,277,"配置/更换主将",1000);

                    result=mFairy.findPic(604,407,669,447,"word guide config.png");
                    mFairy.onTap(0.7f,result,628,263,641,276,"配置副将",1000);

                    result=mFairy.findPic("word guide fenbing.png");
                    mFairy.onTap(0.8f,result,156,668,164,679,"快速分兵",1000);

                    result=mFairy.findPic(1106,466,1180,515,"word guide fenbing.png");
                    mFairy.onTap(0.8f,result,1120,593,1130,603,"确认分兵",1000);

                    result=mFairy.findPic("word guide bingzhong.png");
                    mFairy.onTap(0.8f,result,1155,405,1161,413,"进入兵种选择界面",1000);

                    result=mFairy.findPic(678,289,738,324,"word guide bingzhong.png");
                    mFairy.onTap(0.8f,result,957,307,967,318,"切换兵种",1000);

                    result=mFairy.findPic("word guide xiazhen.png");
                    mFairy.onTap(0.8f,result,483,112,490,119,"下阵",1000);
                }

                result=mFairy.findPic("word recruit free.png");
                mFairy.onTap(0.8f,result,"新手免费招募",1000);

                result=mFairy.findPic("word recruit free1.png");
                mFairy.onTap(0.8f,result,"任务免费招募",1000);

                result=mFairy.findPic("word btn build.png");
                mFairy.onTap(0.8f,result,"建造",1000);

                result=mFairy.findPic("word btn walk.png");
                mFairy.onTap(0.8f,result,"行军确认",1000);

                result=mFairy.findPic("word btn attack.png");
                mFairy.onTap(0.8f,result,"攻占确认",1000);

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word team select.png");
                mFairy.onTap(0.8f,result,642,624,651,631,"选择部队",1000);

                result=mFairy.findPic("word tap tian.png");
                mFairy.onTap(0.8f,result,"点击跳过",1000);

                result=mFairy.findPic("word answer assart.png");
                mFairy.onTap(0.8f,result,"开垦农田",1000);

                result=mFairy.findPic("word btn continue.png");
                mFairy.onTap(0.8f,result,"跳过攻占详情",1000);

                result=mFairy.findPic(1189,190,1273,339,"word btn shangzhen.png");
                mFairy.onTap(0.8f,result,"上阵",1000);

                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                result1=mFairy.findPic("word affirm.png");
                if(result1.sim<0.8f)mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",500);
            }

            @Override
            public void content_2() throws Exception {
                //大厅主界面
                result=mFairy.findPic("word btn task.png");
                int picCount=picCount(0.8f,result,"btn task");
                if(result.sim>0.8f){
                    if(picCount!=0&&picCount%5==0){
                        mFairy.onTap(0.8f,result,"进入任务界面",1000);
                    }
                    result=mFairy.findPic("pic attack.png");
                    mFairy.onTap(0.8f,result,"攻占",1000);

                    result=mFairy.findPic("pic walk.png");
                    mFairy.onTap(0.8f,result,"行军",1000);
                }

                //任务界面
                result=mFairy.findPic("word task interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(new String[]{"word section.png","word section1.png"});
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word zhuxian.png");
                        mFairy.onTap(0.8f,result,"切换主线分页",1000);
                    }else{
                        int currentSection=0;
                        for (int i=1;i<=4;i++){
                            result=mFairy.findPic("word task section"+i+".png");
                            if(result.sim>0.8f){
                                currentSection=i;
                                break;
                            }
                        }
                        if(currentSection!=taskSection){
                            taskSection=currentSection;
                            LtLog.e(mFairy.getLineInfo("不是当前章节"));
                            setTaskName(0);
                            return;
                        }

                        result=mFairy.findPic("word btn get1.png");
                        mFairy.onTap(0.8f,result,"总任务奖励-领取",1000);

                        result=mFairy.findPic(1107,318,1205,403,"word btn get.png");
                        mFairy.onTap(0.8f,result,"任务奖励-领取",1000);


                        int index=0;
                        //找前往 前三个
                        List<FindResult> findList = mFairy.findPic(1109, 319, 1199, 620, 0.8f, "word btn go to.png");
                        if(findList.size()!=0) {
                            //获取第一个
                            result1 = findList.get(0);

                            //攻占领地
                            result = mFairy.findPic(result1.x - 709, result1.y - 34, result1.x - 640, result1.y + 11, "word task attack.png");
                            if (result.sim > 0.8f) {
                                //三分钟攻占一次领地
                                boolean task_attack = timekeep(1, 3 * 60 * 1000, "task attack");
                                if (task_attack) {
                                    mFairy.onTap(0.8f, result1, "前往攻占领地", 1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }

                            //提升(君王殿)10秒一次
                            result = mFairy.findPic(result1.x - 709, result1.y - 34, result1.x - 640, result1.y + 11, "word task up.png");
                            if (result.sim > 0.8f) {
                                if (timekeep(1, 10  * 1000, "city up")) {
                                    mFairy.onTap(0.8f, result1, "前往提升", 1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }


                            //建造 10秒次
                            result = mFairy.findPic(result1.x - 709, result1.y - 34, result1.x - 640, result1.y + 11, "word task build.png");
                            if (result.sim > 0.8f) {
                                if (timekeep(1, 10* 1000, "city create")) {
                                    mFairy.onTap(0.8f, result1, "前往建造", 1000);
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }

                result=mFairy.findPic("word btn upgrade.png");
                mFairy.onTap(0.8f,result,"升级",1000);

                result=mFairy.findPic("word btn build.png");
                mFairy.onTap(0.8f,result,"建造",1000);

                result=mFairy.findPic("word btn walk.png");
                mFairy.onTap(0.8f,result,"行军确认",1000);

                result=mFairy.findPic("word btn attack.png");
                if(result.sim>0.8f){
                    timekeepInit("task attack");//三分钟占领一次
                    mFairy.onTap(0.8f,result,"攻占确认",1000);
                }

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word occupy.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("占领中..."));
                    return;
                }

                result=mFairy.findPic("word team select.png");
                mFairy.onTap(0.8f,result,78,633,88,644,"选择部队",200);
                mFairy.onTap(0.8f,result,642,624,651,631,"选择部队",1000);

                result=mFairy.findPic("word tap tian.png");
                mFairy.onTap(0.8f,result,"点击跳过",1000);

                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                picCount=picCount(0.8f,result,"return");
                if(picCount!=0&&picCount%5==0)mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);
            }

            @Override
            public void content_3() throws Exception {
                //大厅主界面
                result=mFairy.findPic("word btn task.png");
                int picCount=picCount(0.8f,result,"btn task");
                if(result.sim>0.8f){
                    if(picCount!=0&&picCount%5==0){
                        mFairy.onTap(0.8f,result,"进入任务界面",1000);
                    }
                    result1=mFairy.findPic("pic attack.png");
                    if(result1.sim>0.8f){
                        mFairy.onTap(0.8f,result1,"攻占",1000);
                    }else{
                        result=mFairy.findPic("pic walk.png");
                        mFairy.onTap(0.8f,result,result.x+10,result.y-54,result.x+18,result.y-45,"行军-先攻占",1000);
                    }
                }

                //只能攻占相邻土地
                result=mFairy.findPic(664,149,723,233,"word border.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("只能攻占相邻土地，前往攻占空地"));
                    int state=select_place(place);
                    if(state==1){
                        if(place++>16)place=1;
                    }
                    return;
                }

                //任务界面
                result=mFairy.findPic("word task interface.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(755,133,804,167,"word section.png");
                    if(result.sim<0.8f){
                        result=mFairy.findPic("word zhuxian.png");
                        mFairy.onTap(0.8f,result,"切换主线分页",1000);
                    }else{
                        int currentSection=0;
                        for (int i=1;i<=4;i++){
                            result=mFairy.findPic("word task section"+i+".png");
                            if(result.sim>0.8f){
                                currentSection=i;
                                break;
                            }
                        }
                        if(currentSection!=taskSection){
                            taskSection=currentSection;
                            LtLog.e(mFairy.getLineInfo("不是当前章节"));
                            setTaskName(0);
                            return;
                        }

                        result=mFairy.findPic("word btn get1.png");
                        mFairy.onTap(0.8f,result,"总任务奖励-领取",1000);

                        result=mFairy.findPic(1107,318,1205,403,"word btn get.png");
                        mFairy.onTap(0.8f,result,"任务奖励-领取",1000);


                        int index=0;
                        //找前往 前三个
                        List<FindResult> findList = mFairy.findPic(1109, 319, 1199, 620, 0.8f, "word btn go to.png");
                        if(findList.size()!=0){
                            //获取第一个
                            result1 = findList.get(0);

                            //攻占领地
                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task attack.png");
                            if(result.sim>0.8f){
                                //30秒攻占一次领地
                                if(timekeep(1,30*1000,"task attack")){
                                    mFairy.onTap(0.8f,result1,"前往攻占领地",1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }

                            //提升(君王殿)10秒一次
                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task up.png");
                            if(result.sim>0.8f){
                                if(timekeep(1,10*1000,"city up")){
                                    mFairy.onTap(0.8f,result1,"前往提升",1000);
                                    return;
                                }
                                if(index+1<findList.size()){
                                    index++;
                                    result1 = findList.get(index);
                                }
                            }

                            //征兵 立即前往
                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task draft.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"前往提升",1000);
                                return;
                            }

                            result=mFairy.findPic(result1.x-709,result1.y-34,result1.x-640,result1.y+11,"word task build.png");
                            if(result.sim>0.8f){
                                mFairy.onTap(0.8f,result1,"前往建造",1000);
                                return;
                            }
                        }
                    }
                    return;
                }

                result=mFairy.findPic("word idle.png");
                mFairy.onTap(0.8f,result,"进入征兵界面",1000);

                //征兵界面
                result=mFairy.findPic("word draft interface.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1152,531,1161,541,"最大",1000);
                    mFairy.onTap(0.8f,result,624,664,632,673,"开始征兵",1000);
                }

                result=mFairy.findPic("word btn upgrade.png");
                mFairy.onTap(0.8f,result,"升级",1000);

                result=mFairy.findPic("word btn build.png");
                mFairy.onTap(0.8f,result,"建造",1000);

                result=mFairy.findPic("word btn walk.png");
                mFairy.onTap(0.8f,result,"行军确认",1000);

                result=mFairy.findPic("word btn attack.png");
                if(result.sim>0.8f){
                    timekeepInit("task attack");//三分钟占领一次
                    mFairy.onTap(0.8f,result,"攻占确认",1000);
                }

                result=mFairy.findPic("pic next step.png");
                mFairy.onTap(0.8f,result,"下一步",1000);

                result=mFairy.findPic("word occupy.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("占领中..."));
                    return;
                }

                //选择部队
                result=mFairy.findPic("word team select.png");
                if(result.sim>0.8f){
                    //选中可用待命部队
                    result=mFairy.findPic(1243,197,1272,275,"pic selected.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word none use.png");//没有待命的部队
                        if(result.sim>0.8f){
                            //放弃出征
                            mFairy.onTap(1183,38,1192,46,"没有待命的部队，放弃出征，点击返回",1000);
                            timekeepInit("task attack");
                            return;
                        }
                        mFairy.onTap(642,624,651,631,"选择部队",1000);
                        return;
                    }else{
                        mFairy.onTap(1252,235,1260,244,"只显示待命部队",1000);
                    }
                }

                result=mFairy.findPic("word tap tian.png");
                mFairy.onTap(0.8f,result,"点击跳过",1000);

                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                picCount=picCount(0.8f,result,"return");
                if(picCount!=0&&picCount%5==0)mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);
            }

            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn at once.png");
                mFairy.onTap(0.8f,result,"城建立即",1000);
                mFairy.onTap(0.8f,result,1207,29,1215,33,"返回",1000);

                result=mFairy.findPic("word btn insist.png");
                mFairy.onTap(0.8f,result,"坚持出征",1000);

                result=mFairy.findPic(599,440,677,519,"word btn hint affirm.png");
                mFairy.onTap(0.8f,result,"确认",1000);

                result=mFairy.findPic("word hint.png");
                if(result.sim>0.8f){
                    result=mFairy.findPic(420,286,530,323,"word hint expend.png");
                    result1=mFairy.findPic(588,311,690,343,"word hint remove.png");
                    if(result.sim>0.8f||result1.sim>0.8f){
                        result=mFairy.findPic("word btn hint affirm.png");
                        mFairy.onTap(0.8f,result,"确认",1000);
                        return;
                    }

                    result=mFairy.findPic("word btn hint cancel.png");
                    mFairy.onTap(0.8f,result,"取消",1000);

                    if(result.sim<0.8f){
                        mFairy.onTap(751,469,759,478,"取消行动",1000);
                    }
                }
            }
        }.taskContent(mFairy,"新手指引");
    }

    //单人日常
    public void single()throws Exception{
        new SingleTask(mFairy){
            @Override
            public void create() throws Exception {
                taskList=new ArrayList();
                //免费招募
                if(AtFairyConfig.getOption("free recruit").equals("1")){
                    taskList.add("free recruit");
                }

                //半价招募
                if(AtFairyConfig.getOption("half recruit").equals("1")){
                    taskList.add("half recruit");
                }
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("没有勾选任何任务，日常完成"));
                    setTaskEnd();
                    return;
                }
                setTaskName(0);
            }

            @Override
            public void content_0() throws Exception {
                if(taskList.size()==0){
                    LtLog.e(mFairy.getLineInfo("所有任务完成，主线结束"));
                    setTaskEnd();
                    return;
                }
            }
        }.taskContent(mFairy,"单人日常");
    }

    int state=0;
    //选择土地
    public int select_place( final int place)throws Exception{
        new SingleTask(mFairy){
            int coordX=0,coordY=0;

            @Override
            public void content_0() throws Exception {
                state=0;
                util.close();
                setTaskName(1);
                util.resize(1);//镜头恢复
            }

            @Override
            public void content_1() throws Exception {
                //切换地标 ，点击队回城
                //点击行军 返回
                result=mFairy.findPic("word landmark.png");
                mFairy.onTap(0.8f,result,"切换地标分页",1000);

                result=mFairy.findPic("word team.png");
                mFairy.onTap(0.8f,result,"选中主城位置",1000);

                //行军
                result=mFairy.findPic(802,217,849,262,"pic walk.png");
                mFairy.onTap(0.8f,result,"行军",1000);

                result=mFairy.findPic("word team select.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1183,38,1192,46,"返回",1000);
                    setTaskName(2);
                    return;
                }
            }

            @Override
            public void content_2() throws Exception {
                result=mFairy.findPic("word btn task.png");
                if(result.sim>0.8f){
                    //第一斜竖
                    if(place<=5){
                        //(639,139)-97,+43
                        coordX=639-(place-1)*97;
                        coordY=139+(place-1)*43;
                    }
                    //左下
                    if(place==6) {
                        //(254,409)
                        coordX=254;
                        coordY=409;
                    }
                    if(place==7){
                        //(413,437)
                        coordX=413;
                        coordY=437;
                    }
                    if(place==8){
                        //(466,526)
                        coordX=466;
                        coordY=526;
                    }
                    //第二斜竖
                    if(place>=9&&place<=13){
                        //(638,556)+113,-61
                        coordX=638+(place-9)*113;
                        coordY=556-(place-9)*61;
                    }
                    //右上
                    if(place==14) {
                        //(997,252)
                        coordX=997;
                        coordY=252;
                    }
                    if(place==15){
                        //(840,230)
                        coordX=840;
                        coordY=230;
                    }
                    if(place==16){
                        //(788,160)
                        coordX=788;
                        coordY=160;
                    }
                    mFairy.onTap(coordX,coordY,coordX+1,coordY+1,"选中地块"+place,1500);
                    mFairy.onTap(coordX+175,coordY-136,coordX+184,coordY-125,"攻占",3000);
                    setTaskName(3);
                }
            }

            @Override
            public void content_3() throws Exception {
                result=mFairy.findPic("word team select.png");
                if(result.sim>0.8f){
                    //选中可用待命部队
                    result=mFairy.findPic(1243,197,1272,275,"pic selected.png");
                    if(result.sim>0.8f){
                        result=mFairy.findPic("word none use.png");//没有待命的部队
                        if(result.sim>0.8f){
                            mFairy.onTap(1204,37,1213,48,"没有待命的部队，确认攻占"+place+"土地完成",1000);
                            timekeepInit("task attack");
                            setTaskEnd();
                            return;
                        }

                        //攻占 2级土地 或者 空地
                        result=mFairy.findPic(new String[]{"word level 2.png","word level 0.png"});
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f,result,642,624,651,631,"选择部队",1000);
                        }else{
                            //放弃出征
                            mFairy.onTap(1183,38,1192,46,"放弃出征，点击返回",1000);
                            setTaskName(0);
                            state=1;
                            return;
                        }
                    }else{
                        mFairy.onTap(1252,235,1260,244,"只显示待命部队",1000);
                    }
                }else{
                    if(overtime(0,15)){
                        LtLog.e(mFairy.getLineInfo("确认攻占"+place+"土地完成"));
                        timekeepInit("task attack");
                        setTaskEnd();
                        return;
                    }
                }

                //攻占确认
                result=mFairy.findPic("word btn attack.png");
                mFairy.onTap(0.8f,result,"攻占确认",1000);
            }
            @Override
            public void inOperation() throws Exception {
                result=mFairy.findPic("word btn insist.png");
                mFairy.onTap(0.8f,result,"坚持出征",1000);
                super.inOperation();
            }
        }.taskContent(mFairy,"攻占土地"+place);
        return state;
    }

    @Override
    public void inOperation() throws Exception {
        result=mFairy.findPic(599,440,677,519,"word btn hint affirm.png");
        mFairy.onTap(0.8f,result,"确认",1000);

        result=mFairy.findPic("word hint.png");
        if(result.sim>0.8f){
            result=mFairy.findPic(420,286,530,323,"word hint expend.png");
            if(result.sim>0.8f){
                result=mFairy.findPic("word btn hint affirm.png");
                mFairy.onTap(0.8f,result,"确认",1000);
                return;
            }

            result=mFairy.findPic("word btn hint cancel.png");
            mFairy.onTap(0.8f,result,"取消",1000);

            if(result.sim<0.8f){
                mFairy.onTap(751,469,759,478,"取消行动",1000);
            }
        }
    }

    public void test()throws Exception{
        new TimingActivity(mFairy).single_fenbing();
        while(mFairy.condit()){
            mFairy.sleep(100);
            LtLog.e(mFairy.getLineInfo("**********************"));
            LtLog.e(mFairy.getLineInfo("selected="+mFairy.findPic(1243,197,1272,450,"pic selected.png").toString()));
            LtLog.e(mFairy.getLineInfo("unselect="+mFairy.findPic(1243,197,1272,450,"pic unselect.png").toString()));
        }
    }
}
