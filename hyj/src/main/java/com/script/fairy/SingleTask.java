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

    YxdUtil yxdUtil_1;
    YxdUtil yxdUtil_2;
    YxdUtil yxdUtil_3;
    int count;

    public SingleTask(AtFairyImpl ypFairy) throws Exception {
        Sleep = 2000;
        mFairy = ypFairy;
        gameUtil = new GameUtil(mFairy);
        yxdUtil = new YxdUtil(mFairy);
        yxdUtil_1 = new YxdUtil(mFairy);
        yxdUtil_2 = new YxdUtil(mFairy);
        yxdUtil_3 = new YxdUtil(mFairy);
    }
    /**
     * 第一阶段新手主线任务
     *
     * @throws Exception
     */
    int sate = 0;
    int sate2 = 0;
    int zhouli = 0;
    public void novice() throws Exception {
        new SingleTask(mFairy) {
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic(1100,8,1275,198,"automatic2.png");
                mFairy.onTap(0.8f,result,"自动聊天",Sleep);

                result = mFairy.findPic("pinkgirl.png");
                mFairy.onTap(0.75f, result, 451,654,475,673,"粉色女孩", Sleep);

                 result = mFairy.findPic("Li Mu Fan.png");
                 if (result.sim > 0.8f){
                     sate =1;
                 }
                 if (sate ==0) {
                     result = mFairy.findPic("Closing the conversation.png");
                     mFairy.onTap(0.75f, result, "结束对话", Sleep);
                 }else {
                     result = mFairy.findPic(new String[]{"Next step.png","Next step2.png","Next step3.png"});
                     mFairy.onTap(0.75f, result, "下一步", Sleep);
                     mFairy.onTap(0.75f, result, "下一步", Sleep);
                     mFairy.onTap(0.75f, result, "下一步", Sleep);
                     mFairy.onTap(0.75f, result, "下一步", Sleep);
                 }
                result = mFairy.findPic("Camera lens.png");
                mFairy.onTap(0.8f,result,837,283,871,321,"2.5D镜头",Sleep);
                mFairy.onTap(0.8f,result,1002,166,1015,183,"关闭",Sleep);

                result = mFairy.findPic(new String[]{"Thread.png","Thread2.png","Thread3.png","Thread4.png"});
                mFairy.onTap(0.8f,result,25,166,41,182,"主线",5000);
                if (result.sim > 0.8f){
                    sate2 = 0;
                    sate = 0;
                }
                result1 = mFairy.findPic(new String[]{"Marriage.png","Marriage2.png"});
                mFairy.onTap(0.8f,result1,25,166,41,182,"姻缘任务",5000);
                if (result1.sim > 0.8f){
                    sate2 = 1;
                }
                result = mFairy.findPic(1,2,177,59,"Acquaintance.png");
                if (result.sim > 0.8f  && sate2 ==1){
                    setTaskName(4);
                    return;
                }else if (result.sim > 0.8f){
                    setTaskName(6);
                    return;
                }
                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",Sleep);

                result = mFairy.findPic("go.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);

                result = mFairy.findPic(new String[]{"Entrusted.png","Understand.png","Safekeeping.png","xiao zhi.png","long.png","condensation.png","du.png","ky.png"});
                mFairy.onTap(0.8f,result,"对话中选项",Sleep);

                result = mFairy.findPic("Appearance.png");
                mFairy.onTap(0.95f,result,1161,140,1187,169,"选择颜色",Sleep);

                result = mFairy.findPic(1025,602,1237,684,  "Wounds.png");
                mFairy.onTap(0.8f,result,"染色",Sleep);
                mFairy.onTap(0.8f,result,1240,21,1259,42,"染色完退出",Sleep);
                mFairy.onTap(0.8f,result,1240,21,1259,42,"染色完关闭",Sleep);

                result = mFairy.findPic("Clap.png");
                if (result.sim > 0.8f) {
                    mFairy.touchDown(result.x, result.y);
                    Thread.sleep(3000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("gift.png");
                if (result.sim > 0.8f) {
                    gameUtil.close();
                }
                result = mFairy.findPic("cha3.png");
                mFairy.onTap(0.8f,result,"叉",Sleep);

                result = mFairy.findPic("Bamboo raft.png");
                mFairy.onTap(0.8f,result,"竹筏",2000);

                result = mFairy.findPic("Make.png");
                mFairy.onTap(0.8f,result,"开始制作",5000);
                mFairy.onTap(0.8f,result,1183,35,1209,66,"制作关闭",Sleep);

                result = mFairy.findPic("Enable.png");
                mFairy.onTap(0.8f,result,1183,35,1209,66,"启用完竹筏关闭关闭",Sleep);

                result = mFairy.findPic("email cha.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",5000);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f && sate2 == 0){
                    setTaskName(5);
                    return;
                }

                result = mFairy.findPic(1010,575,1211,671,"Unlock.png");
                mFairy.onTap(0.8f,result,"解锁启用",Sleep);

                result = mFairy.findPic("two Zhang.png");
                mFairy.onTap(0.8f,result,"第二章",Sleep);

                result = mFairy.findPic("Birthday.png");
                mFairy.onTap(0.8f,result,"生日确定",Sleep);

                result = mFairy.findPic(73,57,545,363,"Kite.png");
                mFairy.onTap(0.8f,result,"纸鸢",2000);

                result = mFairy.findPic(73,57,545,363,"Fireworks.png");
                mFairy.onTap(0.8f,result,"放烟花",2000);

                result = mFairy.findPic("Shi De.png");
                mFairy.onTap(0.8f,result,"是的",Sleep);

                result = mFairy.findPic("red Fireworks.png");
                mFairy.onTap(0.8f,result,"红色烟花",Sleep);

                result = mFairy.findPic("end.png");
                mFairy.onTap(0.8f,result,"快速升级结束主线",Sleep);

                result = mFairy.findPic(new String[]{"chart1.png","chart12.png","chart13.png","chart14.png"});
                mFairy.onTap(0.8f,result,"第一块图",Sleep);
                mFairy.onTap(0.8f,result,345,382,375,421,"第一块图",Sleep);

                result = mFairy.findPic(new String[]{"chart21.png","chart22.png","chart23.png","chart24.png"});
                mFairy.onTap(0.8f,result,"第二块图",Sleep);
                mFairy.onTap(0.8f,result,455,288,505,336,"第二块图",Sleep);

                result = mFairy.findPic(new String[]{"chart31.png","chart32.png","chart33.png","chart34.png"});
                mFairy.onTap(0.8f,result,"第三块图",Sleep);
                mFairy.onTap(0.8f,result,600,265,656,311,"第三块图",Sleep);

                result = mFairy.findPic(new String[]{"chart41.png","chart42.png","chart43.png","chart44.png"});
                mFairy.onTap(0.8f,result,"第四块图",Sleep);
                mFairy.onTap(0.8f,result,780,297,806,346,"第四块图",Sleep);

                LtLog.e("发呆时间==========="+dazeTime);

                if (dazeTime > 15){
                    result = mFairy.findPic(new String[]{"leave.png","leave3.png"});
                    LtLog.e("离开相似度=="+result.sim);
                    mFairy.onTap(0.8f,result,"离开船",3000);
                    mFairy.initMatTime();
                    gameUtil.close();
                }
                result = mFairy.findPic("Zhou Li.png");
                mFairy.onTap(0.8f,result,1207,95,1229,121,"关闭活动页面",Sleep);

                result = mFairy.findPic(0,145,180,371,"adventure.png");
                if (result.sim > 0.8f){
                    setTaskName(7);
                    return;
                }
                result = mFairy.findPic("Tiao Guo.png");
                mFairy.onTap(0.8f,result,798,476,831,491,"跳过指引",Sleep);

                result = mFairy.findPic(328,442,792,692,"throw away.png");
                mFairy.onTap(0.8f,result,"扔掉",2000);

            }
            public void content_2() throws Exception {
                if (overtime(15,1))return;
                result = mFairy.findPic("Chatting.png");
                mFairy.onTap(0.8f,result,"闲谈",2000);

                result = mFairy.findPic(new String[]{"liao.png","liao2.png"});
                mFairy.onTap(0.8f,result,"npc聊天",1000);

                result = mFairy.findPic(new String[]{"where.png","where2.png"});
                mFairy.onTap(0.8f,result,"这是哪里",Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.8f, result, "结束对话", Sleep);

                result = mFairy.findPic(new String[]{"Next step.png","Next step2.png","Next step3.png"});
                mFairy.onTap(0.75f, result, "下一步", Sleep);

                result = mFairy.findPic("Tiao Guo.png");
                mFairy.onTap(0.8f,result,798,476,831,491,"跳过指引",Sleep);

                result = mFairy.findPic(new String[]{"Thread.png","Thread2.png","Thread3.png","Thread4.png"});
                if (result.sim > 0.8f){
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic(210,78,749,667,"Tired.png");
                LtLog.e("累了相似度"+result.sim);
                if (result.sim > 0.7f){
                    setTaskName(3);
                    return;
                }
            }
            public void content_3() throws Exception {
                long dazeTime=mFairy.mMatTime(80,30,36,8,0.9f);
                result = mFairy.findPic(new String[]{"liao.png","liao2.png"});
                mFairy.onTap(0.8f,result,1165,189,1195,213,"返回上一级",2000);

                result = mFairy.findPic("Compare notes.png");
                mFairy.onTap(0.8f,result,"切磋",2000);

                result = mFairy.findPic("beast.png");
                mFairy.onTap(0.8f,result,"斗兽棋",1000);

                result = mFairy.findPic("Explain.png");
                mFairy.onTap(0.8f,result,1135,78,1156,110,"关闭",2000);

                result = mFairy.findPic("start.png");
                mFairy.onTap(0.8f,result,"开始",2000);

                result = mFairy.findPic(new String[]{"Tong Wu Ji.png","80bu.png"});
                mFairy.onTap(0.8f,result,1220,36,1237,58,"关闭",2000);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.8f, result, "结束对话", Sleep);

                result = mFairy.findPic(new String[]{"Next step.png","Next step2.png","Next step3.png"});
                mFairy.onTap(0.75f, result, "下一步", Sleep);

                result = mFairy.findPic(new String[]{"Thread.png","Thread2.png","Thread3.png","Thread4.png"});
                if (result.sim > 0.8f){
                    setTaskName(1);
                    return;
                }
                result1 = mFairy.findPic(new String[]{"Marriage.png","Marriage2.png"});
                mFairy.onTap(0.8f,result1,25,166,41,182,"姻缘任务",5000);
                if (result1.sim > 0.8f){
                    setTaskName(1);
                    return;
                }
                LtLog.e("content_3 发呆时间=="+dazeTime);
                if(dazeTime > 30){
                    setTaskName(0);
                    return;
                }

            }
            public void content_4() throws Exception {
                if (overtime(20,0))return;
//                result = mFairy.findPic(new String[]{"Marriage.png","Marriage2.png"});
//                mFairy.onTap(0.8f,result,"姻缘任务",5000);

                result = mFairy.findPic("beast.png");
                mFairy.onTap(0.8f,result,1165,189,1195,213,"返回上一级",2000);

                result = mFairy.findPic(new String[]{"Outing.png","taqing.png"});
                mFairy.onTap(0.7f,result,"踏青",2000);

                result = mFairy.findPic("taqing2.png");
                mFairy.onTap(0.7f,result,1090,585,1100,598,"踏青",2000);

                result = mFairy.findPic("yuan.png");
                mFairy.onTap(0.8f,result,"情缘岛",2000);
                if (result.sim > 0.8f){
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.8f, result, "结束对话", Sleep);

                result = mFairy.findPic(new String[]{"Next step.png","Next step2.png","Next step3.png"});
                mFairy.onTap(0.75f, result, "下一步", Sleep);

                result = mFairy.findPic(new String[]{"Thread.png","Thread2.png","Thread3.png","Thread4.png","Marriage.png","Marriage2.png"});
                if (result.sim > 0.8f){
                    setTaskName(1);
                    return;
                }

            }
            public void content_5() throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic(new String[]{"Thread.png","Thread2.png","Thread3.png","Thread4.png"});
                mFairy.onTap(0.8f,result,25,166,41,182,"主线",5000);
                if (result.sim > 0.8f){
                    sate2 = 0;
                }

                result = mFairy.findPic(new String[]{"Manual.png","Manual2.png"});
                mFairy.onTap(0.7f,result,"开启自动",Sleep);
                if (result.sim >= 0.7f){
                    sate2 = 1;
                }
                result = mFairy.findPic(new String[]{"automatic.png","auto2.png"});
                if (result.sim >= 0.75f){
                    sate2 = 1;
                }

                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",5000);

                result = mFairy.findPic("tuoguan.png");
                if (result.sim > 0.8f){
                    sate2 = 1;
                }
                result = mFairy.findPic(new String[]{"launch.png","launch2.png","launch3.png"});
                mFairy.onTap(0.8f,result,"扔炸弹",Sleep);
                if (result.sim > 0.8f){
                    sate2 = 1;
                }

                result3 = mFairy.findPic("Xuan ice.png");
                result2 = mFairy.findPic("Assassination.png");
                if(result2.sim>0.8f){
                    sate2 = 1;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                result = mFairy.findPic("Axe.png");
                if (result.sim > 0.8f){
                    sate2 =1;
                    mFairy.onTap(0.8f,result,"砍竹子",20000);
                }
                if (result1.sim > 0.8f && result.sim < 0.8f && sate2 == 0 && result2.sim < 0.8f){
                    mFairy.onTap(0.8f, result1, 1156, 573, 1205, 614, "攻击", 2000);

                    mFairy.onTap(0.8f,result1,1020,639,1046,661,"释放技能1",Sleep);
                    mFairy.onTap(0.8f,result1,1020,639,1046,661,"释放技能1",2000);

                    mFairy.onTap(0.8f,result1,1020,532,1043,554,"释放技能2",Sleep);
                    mFairy.onTap(0.8f,result1,1020,532,1043,554,"释放技能2",2000);

                    if (result3.sim > 0.8f) {
                        mFairy.onTap(0.8f, result1, 1098, 455, 1115, 474, "释放技能3", Sleep);
                        mFairy.onTap(0.8f, result1, 1098, 455, 1115, 474, "释放技能3", 2000);
                    }
                    mFairy.onTap(0.8f,result1,1198,454,1215,479,"释放技能4",2000);
                }else if (result1.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("Drive.png");
                mFairy.onTap(0.8f,result,"驾驶",2000);

                LtLog.e("发呆时间==========="+dazeTime);
                if (dazeTime > 30){
                    mFairy.initMatTime();
                    gameUtil.close();
                }
                if (dazeTime > 20){
                    result = mFairy.findPic("activity.png");
                    if(result.sim > 0.8f){
                        mFairy.initMatTime();
                    }
                    mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",2000);
                    mFairy.onTap(0.8f,result,660,315,678,331,"点击地图",2000);
                    mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",2000);
                }
                result = mFairy.findPic("fight again.png");
                mFairy.onTap(0.8f,result,"奋起再战",Sleep);
            }
            public void content_6() throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Tiao Guo.png");
                mFairy.onTap(0.8f,result,798,476,831,491,"跳过指引",Sleep);

                result = mFairy.findPic(new String[]{"Entrusted.png","Understand.png","Safekeeping.png","xiao zhi.png","long.png","condensation.png","du.png"});
                mFairy.onTap(0.8f,result,"对话中选项",Sleep);

                result = mFairy.findPic("Cheng Er.png");
                mFairy.onTap(0.8f,result,1015,321,1060,349,"散播流言",Sleep);

                result = mFairy.findPic("Zhao Da Li.png");
                mFairy.onTap(0.8f,result,1009,398,1050,462,"点击赵大力",Sleep);

                result= mFairy.findPic(new String[]{"Eight years old.png","niao.png","Not change.png"});
                mFairy.onTap(0.8f,result,"尿裤子八岁不愿改",Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);
                LtLog.e("发呆时间==========="+dazeTime);
                if (dazeTime > 30){
                    mFairy.initMatTime();
                    setTaskName(1);
                }

                result = mFairy.findPic(new String[]{"Chatting.png","liao.png","liao2.png"});
                if (result.sim > 0.8f){
                    setTaskName(2);
                    return;
                }
            }
            public void content_7() throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(0,145,180,371,"adventure.png");
                mFairy.onTap(0.8f,result,"奇遇任务",Sleep);

                result = mFairy.findPic(215,6,1125,204,"Message.png");
                mFairy.onTap(0.8f,result,439,235,553,321,"写寄语",Sleep);
                if (result.sim > 0.8f) {
                    mFairy.inputText("我来了");
                }
                result = mFairy.findPic(526,302,1144,593,"Book lamp.png");
                mFairy.onTap(0.8f,result,"放文书灯",Sleep);

                result = mFairy.findPic(591,3,810,109,"Festive lantern.png");
                mFairy.onTap(0.8f,result,"花灯",Sleep);

                result = mFairy.findPic("Fishing lantern.png");
                mFairy.onTap(0.8f,result,"捞灯",Sleep);

                result = mFairy.findPic("Fetters.png");
                mFairy.onTap(0.8f,result,663,166,702,187,"羁绊花灯对话",Sleep);
                mFairy.onTap(0.8f,result,631,215,696,238,"选择对话",Sleep);
                mFairy.onTap(0.8f,result,893,540,924,564,"回应",Sleep);

                result = mFairy.findPic("flower.png");
                mFairy.onTap(0.8f,result,605,96,641,113,"羁绊花灯对话",Sleep);
                mFairy.onTap(0.8f,result,600,131,646,149,"选择对话",Sleep);

                result = mFairy.findPic("echo.png");
                if (result.sim > 0.8f){
                    gameUtil.close();
                }

                result = mFairy.findPic(new String[]{"ky.png"});
                mFairy.onTap(0.8f,result,"对话中选项",Sleep);

                result = mFairy.findPic(1,2,177,59,"Acquaintance.png");
                if (result.sim > 0.8f){
                    setTaskEnd();
                    return;
                }
                LtLog.e("发呆时间==========="+dazeTime);
                if (dazeTime > 30){
                    mFairy.initMatTime();
                    setTaskName(1);
                }
                result = mFairy.findPic(328,442,792,692,"throw away.png");
                LtLog.e("扔掉相似度=="+result.sim);
                mFairy.onTap(0.8f,result,"扔掉",2000);
            }
            public void yurew() throws Exception {
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Li Mu Fan.png");
                if (result.sim > 0.8f){
                    sate =1;
                }
                if (sate ==0) {
                    result = mFairy.findPic("Closing the conversation.png");
                    if (result.sim > 0.75f) {
                        mFairy.onTap(0.75f, result, "结束对话", Sleep);
                    } else {
                        result = mFairy.findPic(new String[]{"Next step.png","Next step2.png","Next step3.png"});
                        mFairy.onTap(0.75f, result, "下一步", Sleep);
                    }
                }else {
                    result = mFairy.findPic(new String[]{"Next step.png","Next step2.png","Next step3.png"});
                    mFairy.onTap(0.75f, result, "下一步", Sleep);
                }
                result = mFairy.findPic("Camera lens.png");
                mFairy.onTap(0.8f,result,470,304,502,339,"3D镜头",Sleep);
                mFairy.onTap(0.8f,result,1002,166,1015,183,"关闭",Sleep);

                result = mFairy.findPic(new String[]{"Thread.png","Thread2.png","Thread3.png","Thread4.png"});
                mFairy.onTap(0.8f,result,25,166,41,182,"主线",5000);
                if (result.sim > 0.8f){
                    sate2 = 0;
                }
                result = mFairy.findPic(new String[]{"Marriage.png","Marriage2.png"});
                mFairy.onTap(0.8f,result,"姻缘任务",5000);
                if (result.sim > 0.8f){
                    sate2 = 1;
                }
                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",Sleep);

                result = mFairy.findPic("go.png");
                mFairy.onTap(0.8f,result,"前往",Sleep);

                result = mFairy.findPic(new String[]{"Entrusted.png","Understand.png","Safekeeping.png","xiao zhi.png","long.png","condensation.png","du.png"});
                mFairy.onTap(0.8f,result,"对话中选项",Sleep);

                result = mFairy.findPic("Cheng Er.png");
                mFairy.onTap(0.8f,result,1015,321,1060,349,"散播流言",Sleep);

                result = mFairy.findPic("Zhao Da Li.png");
                mFairy.onTap(0.8f,result,1009,398,1050,462,"点击赵大力",Sleep);

                result= mFairy.findPic(new String[]{"Eight years old.png","niao.png","Not change.png"});
                mFairy.onTap(0.8f,result,"尿裤子八岁不愿改",Sleep);

                result = mFairy.findPic("Appearance.png");
                mFairy.onTap(0.95f,result,1161,140,1187,169,"外观",Sleep);

                result = mFairy.findPic("Wounds.png");
                mFairy.onTap(0.8f,result,"染色",Sleep);
                mFairy.onTap(0.8f,result,1240,21,1259,42,"染色完退出",Sleep);

//                result = mFairy.findPic(new String[]{"launch.png","launch2.png"});
//                mFairy.onTap(0.8f,result,"扔炸弹",Sleep);
//                if (result.sim > 0.8f){
//                    sate2 = 1;
//                }
                result = mFairy.findPic("Clap.png");
                if (result.sim > 0.8f) {
                    mFairy.touchDown(result.x, result.y);
                    Thread.sleep(3000);
                    mFairy.touchUp();
                }
                result = mFairy.findPic("gift.png");
                if (result.sim > 0.8f) {
                    gameUtil.close();
                }
                result = mFairy.findPic("cha3.png");
                mFairy.onTap(0.8f,result,"叉",Sleep);

                result = mFairy.findPic("Make.png");
                mFairy.onTap(0.8f,result,"开始制作",5000);
                mFairy.onTap(0.8f,result,1183,35,1209,66,"关闭",Sleep);

                result = mFairy.findPic("Enable.png");
                mFairy.onTap(0.8f,result,1183,35,1209,66,"关闭",Sleep);

                result = mFairy.findPic("email cha.png");
                mFairy.onTap(0.8f,result,"关闭",Sleep);

                result = mFairy.findPic("Manual.png");
                mFairy.onTap(0.7f,result,"开启自动",Sleep);
                if (result.sim >= 0.7f){
                    sate2 = 1;
                }
                result = mFairy.findPic("automatic.png");
                if (result.sim >= 0.8f){
                    sate2 = 1;
                }
                result = mFairy.findPic("hand.png");
                mFairy.onTap(0.8f,result,"万能手",5000);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                result = mFairy.findPic("Axe.png");
                if (result.sim > 0.8f){
                    sate2 =1;
                    mFairy.onTap(0.8f,result,"砍竹子",15000);
                }
                if (result1.sim > 0.8f && result.sim < 0.8f && sate2 == 0){
                    result = mFairy.findPic("Skill1.png");
                    mFairy.onTap(0.8f,result,"释放技能",Sleep);
                    result = mFairy.findPic("Skill2.png");
                    mFairy.onTap(0.8f,result,"释放技能",2000);
                    result = mFairy.findPic("Skill3.png");
                    mFairy.onTap(0.8f,result,"释放技能",2000);
                    result = mFairy.findPic("Skill4.png");
                    mFairy.onTap(0.8f,result,"释放技能",2000);
                    for (int i = 0; i < 20; i++) {
                        mFairy.onTap(0.8f, result1, 1156, 573, 1205, 614, "攻击", Sleep);
                    }
                }

                result = mFairy.findPic("Unlock.png");
                mFairy.onTap(0.8f,result,"解锁启用",Sleep);

                result = mFairy.findPic(new String[]{"Chatting.png","liao.png","liao2.png"});
                if (result.sim > 0.8f){
                    setTaskName(2);
                    return;
                }

                result = mFairy.findPic("two Zhang.png");
                mFairy.onTap(0.8f,result,"第二章",Sleep);

                result = mFairy.findPic("Birthday.png");
                mFairy.onTap(0.8f,result,"生日确定",Sleep);

                result = mFairy.findPic("Kite.png");
                mFairy.onTap(0.8f,result,"纸鸢",2000);

                result = mFairy.findPic(73,57,545,363,"Fireworks.png");
                mFairy.onTap(0.8f,result,"放烟花",2000);

                result = mFairy.findPic("Shi De.png");
                mFairy.onTap(0.8f,result,"是的",Sleep);

                result = mFairy.findPic("red Fireworks.png");
                mFairy.onTap(0.8f,result,"红色烟花",Sleep);

                result = mFairy.findPic("end.png");
                mFairy.onTap(0.8f,result,"快速升级结束主线",Sleep);

                result = mFairy.findPic(new String[]{"chart1.png","chart12.png","chart13.png","chart14.png"});
                mFairy.onTap(0.8f,result,"第一块图",Sleep);
                mFairy.onTap(0.8f,result,345,382,375,421,"第一块图",Sleep);

                result = mFairy.findPic(new String[]{"chart21.png","chart22.png","chart23.png","chart24.png"});
                mFairy.onTap(0.8f,result,"第二块图",Sleep);
                mFairy.onTap(0.8f,result,455,288,505,336,"第二块图",Sleep);

                result = mFairy.findPic(new String[]{"chart31.png","chart32.png","chart33.png","chart34.png"});
                mFairy.onTap(0.8f,result,"第三块图",Sleep);
                mFairy.onTap(0.8f,result,600,265,656,311,"第三块图",Sleep);

                result = mFairy.findPic(new String[]{"chart41.png","chart42.png","chart43.png","chart44.png"});
                mFairy.onTap(0.8f,result,"第四块图",Sleep);
                mFairy.onTap(0.8f,result,780,297,806,346,"第四块图",Sleep);

                LtLog.e("发呆时间==========="+dazeTime);
                if (dazeTime > 30){
                    mFairy.initMatTime();
                    gameUtil.close();
                }
                if (dazeTime > 20){
                    result = mFairy.findPic("activity.png");
                    if(result.sim > 0.8f){
                        mFairy.initMatTime();
                    }
                    mFairy.onTap(0.8f,result,1166,72,1201,100,"打开地图",Sleep);
                    mFairy.onTap(0.8f,result,660,315,678,331,"点击地图",Sleep);
                    mFairy.onTap(0.8f,result,1225,48,1252,72,"关闭",Sleep);
                }
                result = mFairy.findPic("fight again.png");
                mFairy.onTap(0.8f,result,"奋起再战",Sleep);

                result = mFairy.findPic("Zhou Li.png");
                if (result.sim > 0.8f){
                    zhouli += 1;
                }
                if (zhouli >=2){
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic("Tiao Guo.png");
                mFairy.onTap(0.8f,result,798,476,831,491,"跳过指引",Sleep);

            }
        }.taskContent(mFairy, "主线任务");
    }

    /**
     * 科举
     * @throws Exception
     */

    public void imperialExamination()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("KeJu.png",0);
                if (ret==1){
                    setTaskName(2);return;
                }else {
                    setTaskEnd();return;
                }

            }
            public void content_2()throws Exception{
                if (overtime(30,0))return;
                result = mFairy.findPic(470,201,640,289,"first.png");
                mFairy.onTap(0.8f,result,"科举选1",Sleep);
                if (result.sim >0.8f){
                    err=0;
                }
                result = mFairy.findPic("box.png");
                mFairy.onTap(0.7f,result ,"领取科举考试奖励",Sleep);

            }
        }.taskContent(mFairy,"科举");
    }

    /**
     * 侠义悬赏
     * @throws Exception
     */
    int rw =0;
    public void chivalrous()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if(err == 1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);

                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("display.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);
               if (rw == 0) {
                   result = mFairy.findPic("task.png");
                   mFairy.onTap(0.8f, result, "回到任务栏", 2000);
               }
                result = mFairy.findPic("task2.png");
                mFairy.onTap(0.8f,result,1181,63,1203,88,"关闭",Sleep);
                if (result.sim > 0.8f){
                    rw =1;
                }
                result = mFairy.findPic(0,137,213,384,"Xia.png");
                mFairy.onTap(0.7f,result,"左侧侠义悬赏",3000);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 4, 6, 8}, 4, 96,330, 109,193, 1000, 1500);
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("Chivalrous.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Chang An.png");
                if (dazeTime >=15 && result.sim>0.8f){
                    setTaskName(1);
                    return;
                }else if (dazeTime >=20){
                    mFairy.initMatTime();
                    mFairy.onTap(642,641,683,671,"点击空白处",Sleep);
                    setTaskName(0);
                    return;
                }
                result = mFairy.findPic("Reward list.png");
                if (result.sim > 0.8f) {
                    result1 = mFairy.findPic(164,150,1125,637,"Golden list.png");
                    mFairy.onTap(0.8f,result1,"金榜",2000);
                    result = mFairy.findPic("Golden jb.png");
                    mFairy.onTap(0.8f, result, "金榜揭榜", 2000);
                    mFairy.onTap(0.8f,result,1181,62,1203,91,"关闭",2000);

                    result2 = mFairy.findPic(164,150,1125,637,"nail.png");
                    mFairy.onTap(0.8f, result2, "选择甲任务",2000);
                    result = mFairy.findPic("Announce.png");
                    mFairy.onTap(0.8f, result, "揭榜", 2000);
                    mFairy.onTap(0.8f,result,1181,62,1203,91,"关闭",2000);

                    if (result1.sim < 0.8 && result2.sim < 0.8f){
                        result = mFairy.findPic(155,142,1131,642,new String[]{"bang.png","puto.png"});
                        mFairy.onTap(0.8f, result, "选择普通任务",2000);
                        result = mFairy.findPic("Announce.png");
                        mFairy.onTap(0.8f, result, "揭榜", 2000);
                        mFairy.onTap(0.8f,result,1181,62,1203,91,"关闭",2000);
                    }

                }
                result = mFairy.findPic(0,137,213,384,"Xia.png");
                mFairy.onTap(0.7f,result,"左侧侠义悬赏",3000);

                result = mFairy.findPic("buy.png");
                mFairy.onTap(0.8f,result,"购买",2000);
                mFairy.onTap(0.8f,result,1165,60,1193,87,"买完叉",Sleep);

                result = mFairy.findPic("submit.png");
                mFairy.onTap(0.8f,result,"提交",2000);
                mFairy.onTap(0.8f,result,337,647,404,669,"提交完点击空白点",2000);

                result = mFairy.findPic(new String[]{"Photograph.png","Photograph2.png"});
                mFairy.onTap(0.8f,result,"照相",2000);

                result = mFairy.findPic("kb.png");
                mFairy.onTap(0.8f,result,"完成照相",Sleep);
                mFairy.onTap(0.8f,result,1216,37,1239,62,"完成照相叉",Sleep);
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                    setTaskName(7);
                    return;
                }


                result = mFairy.findPic("shanzi.png");
                if(result.sim > 0.7f){
                    result = mFairy.findPic(130,82,1097,611,new String[]{"xsbtu1_1.png","xsbtu1_2.png","xsbtu1_3.png","xsbtu1_4.png"});
                    mFairy.onTap(0.7f,result,"第一块图",Sleep);
                    mFairy.onTap(0.7f,result,776,295,808,328,"第一块图",Sleep);

                    result = mFairy.findPic(130,82,1097,611,new String[]{"xsbtu2_1.png","xsbtu2_2.png","xsbtu2_3.png","xsbtu2_4.png"});
                    mFairy.onTap(0.7f,result,"第二块图",Sleep);
                    mFairy.onTap(0.7f,result,893,402,927,442,"第二块图",Sleep);

                    result = mFairy.findPic(130,82,1097,611,new String[]{"xsbtu3_1.png","xsbtu3_2.png","xsbtu3_3.png","xsbtu3_4.png"});
                    mFairy.onTap(0.7f,result,"第三块图",Sleep);
                    mFairy.onTap(0.7f,result,619,247,645,274,"第三块图",Sleep);

                    result = mFairy.findPic(130,82,1097,611,new String[]{"xsbtu4_1.png","xsbtu4_2.png","xsbtu4_3.png","xsbtu4_4.png"});
                    mFairy.onTap(0.7f,result,"第四块图",Sleep);
                    mFairy.onTap(0.7f,result,476,313,496,332,"第四块图",Sleep);




                    result = mFairy.findPic(new String[]{"chart1.png","chart12.png","chart13.png","chart14.png"});
                    mFairy.onTap(0.8f,result,"第一块图",Sleep);
                    mFairy.onTap(0.8f,result,345,382,375,421,"第一块图",Sleep);

                    result = mFairy.findPic(new String[]{"chart21.png","chart22.png","chart23.png","chart24.png"});
                    mFairy.onTap(0.8f,result,"第二块图",Sleep);
                    mFairy.onTap(0.8f,result,455,288,505,336,"第二块图",Sleep);

                    result = mFairy.findPic(new String[]{"chart31.png","chart32.png","chart33.png","chart34.png"});
                    mFairy.onTap(0.8f,result,"第三块图",Sleep);
                    mFairy.onTap(0.8f,result,600,265,656,311,"第三块图",Sleep);

                    result = mFairy.findPic(new String[]{"chart41.png","chart42.png","chart43.png","chart44.png"});
                    mFairy.onTap(0.8f,result,"第四块图",Sleep);
                    mFairy.onTap(0.8f,result,780,297,806,346,"第四块图",Sleep);


                }

                result = mFairy.findPic(939,421,1162,637,"Dance.png");
                mFairy.onTap(0.8f,result,"跳舞",Sleep);
                if (result.sim > 0.8f){
                    LtLog.e("进入跳舞");
                    setTaskName(4);
                    return;
                }
                result = mFairy.findPic("Jade clothing.png");
                if(result.sim > 0.8f){
                    setTaskName(8);return;
                }

                result = mFairy.findPic("Repeatedly.png");
                if (result.sim > 0.8f){
                    LtLog.e("进入消消乐");
                    setTaskName(5);
                    return;
                }
               result = mFairy.findPic("Working.png");
                if (result.sim > 0.8f){
                    setTaskName(6);return;
                }
                result = mFairy.findPic("jie.png");
                mFairy.onTap(0.8f,result,1243,174,1258,200,"打开帮会界面",2000);

                result = mFairy.findPic("gang.png");
                mFairy.onTap(0.8f,result,"帮会",2000);
                result = mFairy.findPic("yijian.png");
                mFairy.onTap(0.8f,result,"一键申请帮会",2000);
                mFairy.onTap(0.8f,result,1178,58,1207,93,"一键申请帮会完了关闭",2000);
                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",2000);
               // mFairy.onTap(175,645,196,665,"空白处",1000);

                result = mFairy.findPic(new String[]{"Teacher selection.png","Word filling.png"});
                if (result.sim >= 0.8f){
                    LtLog.e("填字游戏没法做关闭");
                    setTaskEnd();return;
                }
            }
            public void content_4()throws Exception{
                boolean tw = timekeep(0,240000,"侠义悬赏跳舞");
                if (tw){
                    timekeepInit("侠义悬赏跳舞");
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("Dance2.png");
                mFairy.onTap(0.8f,result,"跳舞",200);

                result = mFairy.findPic("Dance3.png");
                mFairy.onTap(0.8f,result,"跳舞",200);

                result = mFairy.findPic(0,137,213,384,"Xia.png");
                mFairy.onTap(0.7f,result,"左侧侠义悬赏",2000);
            }
            public void content_5()throws Exception{
                mFairy.condit();
                List<FindResult> findResults3 = mFairy.findPic(372,66,864,554,0.9f,"blue ball.png");
                List<FindResult> findResults2 = mFairy.findPic(372,66,864,554,0.9f,"green ball.png");
                if(findResults2.size() >=8){
                    LtLog.e("进入绿球");
                    xxl(findResults2);
                    findResults2.clear();
                }else if (findResults3.size() >= 8){
                    LtLog.e("进入蓝球");
                    xxl(findResults3);
                    findResults3.clear();

                }else {
                    mFairy.condit();
                    List<FindResult> findResults4 = mFairy.findPic(372,66,864,554,0.9f,"Ash ball.png");
                    List<FindResult> findResults = mFairy.findPic(372,66,864,554,0.9f,"red ball.png");
                    if (findResults4.size() > findResults.size()){
                        LtLog.e("进入灰球");
                        xxl(findResults4);
                        findResults4.clear();
                    }else {
                        LtLog.e("进入红球");
                        xxl(findResults);
                        findResults.clear();
                    }
                }

//
//                int[] arr = {findResults.size(),findResults2.size(),findResults3.size(),findResults4.size()};
//                int max = arr[0];
//                for (int i = 1 ; i <arr.length;i++){
//                    LtLog.e("红="+findResults.size()+"   绿="+findResults2.size()+"   蓝="+findResults3.size()+"   灰="+findResults4.size());
//                    if (max < arr[i]){
//                        max = arr[i];
//                    }
//                }
//                LtLog.e("max="+max);
//                if (max == findResults.size()){
//                    LtLog.e("进入红球");
//                    xxl(findResults);
//                    findResults.clear();
//                }else if (max == findResults2.size()){
//                    LtLog.e("进入绿球");
//                    xxl(findResults2);
//                    findResults2.clear();
//                }else if (max == findResults3.size()){
//                    LtLog.e("进入蓝球");
//                    xxl(findResults3);
//                    findResults3.clear();
//                }else {
//                    LtLog.e("进入灰球");
//                    xxl(findResults4);
//                    findResults4.clear();
//
//                }
//                result = mFairy.findPic(0,137,213,384,"Xia.png");
//                mFairy.onTap(0.7f,result,"左侧侠义悬赏",2000);

                result = mFairy.findPic("Repeatedly.png");
                if (result.sim < 0.8f){
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("xxlyes.png");
                mFairy.onTap(0.8f,result,"失败了继续",Sleep);

            }
            public void content_6()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result1 = mFairy.findPic("make2.png");
                mFairy.onTap(0.8f,result1,"点击制作",Sleep);
                mFairy.condit();
                result = mFairy.findPic(475,167,582,204,"vitality.png");
                if (result.sim > 0.8f){
                    mFairy.onTap(0.8f,result,830,610,862,634,"没有活力去摆摊购买",2000);
                }else {
                    mFairy.onTap(0.8f,result1,1178,59,1204,88,"制作完叉",Sleep);
                }

                result = mFairy.findPic(505,173,1140,614,"buysign.png");
                mFairy.onTap(0.8f,result,result.x,result.y+14,result.x+1,result.y+15,"购买道具",2000);


                result = mFairy.findPic(112,278,514,707,"djbuy.png");
                mFairy.onTap(0.8f,result,"摆摊道具购买",2000);
                mFairy.onTap(0.8f,result,1168,58,1191,86,"买完叉",Sleep);
                result = mFairy.findPic("submit.png");
                mFairy.onTap(0.8f,result,"提交",2000);
                mFairy.onTap(0.8f,result,337,647,404,669,"提交完点击空白点",2000);
                if (result.sim>0.8f){
                    setTaskName(1);return;
                }

                if (dazeTime >= 180){
                    setTaskName(1);return;
                }
                result = mFairy.findPic("Gold coin.png");
                if (result.sim>0.8f){
                    setTaskEnd();return;
                }
                result = mFairy.findPic(0,137,213,384,"Xia.png");
                mFairy.onTap(0.7f,result,"左侧侠义悬赏",2000);
            }
            public void content_7()throws Exception{
                boolean  dg= timekeep(0,600000,"悬赏打怪");
                if (dg){
                    LtLog.e("打怪超时应该是打不过直接结束");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    timekeepInit("悬赏打怪");
                    setTaskEnd();return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim < 0.8f){
                    timekeepInit("悬赏打怪");
                    setTaskName(3);
                    return;
                }
            }
            public void content_8()throws Exception{
                if (overtime(6,3))return;
                result = mFairy.findPic("Jade clothing1.png");
                if(result.sim > 0.8f){
                    mFairy.touchDown(3,962,259);
                    mFairy.touchMove(3,681,226,2000);
                    mFairy.touchUp(3);
                    mFairy.condit();
                }
                result = mFairy.findPic("Jade clothing2.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(6,947,511);
                    mFairy.touchMove(6,725,362,2000);
                    mFairy.touchUp(6);
                    mFairy.condit();
                }
                result = mFairy.findPic("Jade clothing3.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(7,273,300);
                    mFairy.touchMove(7,609,261,2000);
                    mFairy.touchUp(7);
                    mFairy.condit();
                }
                result = mFairy.findPic("Jade clothing4.png");
                if (result.sim > 0.8f){
                    mFairy.touchDown(5,232,526);
                    mFairy.touchMove(5,572,366,2000);
                    mFairy.touchUp(5);
                    mFairy.condit();
                }

            }

        }.taskContent(mFairy,"侠义悬赏");
    }
    public void xxl(List<FindResult> findResults)throws Exception{
        mFairy.condit();
        List<Integer> x1 = new ArrayList<>();
        List<Integer> y1 = new ArrayList<>();
        int x = findResults.get(0).x;
        int y = findResults.get(0).y;
        x1.add(x);
        y1.add(y);
        int b = x;
        int c = y;
        int l = findResults.size();
      //  LtLog.e("球个数=" + findResults.size());
        findResults.remove(findResults.get(0));
        for (int i = 0; i < l; i++) {
           // LtLog.e("x1集合"+x1.size()+"个球坐标" + x + "，" + y);
           // LtLog.e("以球为中心搜索连接的范围"+(x-75)+","+(y-72)+","+(x+141)+","+(y+142));
            for (int k = 0 ; k < findResults.size(); k++) {
                //LtLog.e("球坐标" + findResults.get(k).x+ "，" +findResults.get(k).y);
                if (findResults.get(k).x > (x - 75) && findResults.get(k).x < (x + 141) && findResults.get(k).y > (y - 72) && findResults.get(k).y < (y + 142)) {
             //       LtLog.e("可连接的坐标==" + findResults.get(k).x + " ，" + findResults.get(k).y);
                    x1.add(findResults.get(k).x);
                    y1.add(findResults.get(k).y);
                    x = findResults.get(k).x;
                    y = findResults.get(k).y;
                    findResults.remove(findResults.get(k));
                    break;
                }
            }
          //  LtLog.e("b=="+b+",c=="+c+"  x=="+x+"  ,y=="+y);
            if (c==y && b == x && x1.size() <= 2){
                x1.clear();
                y1.clear();
                x = findResults.get(0).x;
                y = findResults.get(0).y;
                b = x ;
                c = y ;
                x1.add(x);
                y1.add(y);
                findResults.remove(findResults.get(0));
              //  LtLog.e("新的第一个球的坐标"+x+","+y);
            }else {
                b = x ;
                c = y ;
            }
        }
      //  LtLog.e("集合x1的长度"+x1.size());
        if (x1.size() >=3 && y1.size() >= 3){
            mFairy.touchDown(0,x1.get(0)+35,y1.get(0)+33);
         //   LtLog.e("连接的球坐标"+x1.get(0)+","+y1.get(0));
            for (int j = 1 ; j< x1.size();j++){
            //    LtLog.e("连接的球坐标"+x1.get(j)+","+y1.get(j));
                mFairy.touchMove(0,x1.get(j)+35,y1.get(j)+33,500);
            }
            mFairy.touchUp(0);
        }
        x1.clear();
        y1.clear();
    }

    /**
     * 七日志
     */
    public void sevenLog()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                boolean  dg= timekeep(0,100000,"七日志");
                //寻找任务并且前往
                result = mFairy.findPic(new String[]{"Open.png","Open2.png"});
                mFairy.onTap(0.8f,result,"展开任务栏",2000);

                result = mFairy.findPic(372,10,1095,172,"sevenlog2.png");
                mFairy.onTap(0.8f,result,"打开七日志",2000);

                if (dg && result.sim < 0.8f){
                    setTaskEnd();return;
                }

                result = mFairy.findPic("read.png");
                mFairy.onTap(0.8f,result,"开始阅读",2000);
                if (result.sim > 0.8f){
                    setTaskName(2);
                    return;
                }
                result = mFairy.findPic(501,578,815,626,"sevenred.png");
                mFairy.onTap(0.8f,result,"阅读领奖",2000);
                mFairy.onTap(0.8f,result,1093,579,1101,590,"阅读领奖",2000);

                result = mFairy.findPic(new String[]{"readend.png","Unlock3.png"});
                if (result.sim > 0.8f){
                    setTaskEnd();return;
                }

            }
            public void content_2()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);

                result = mFairy.findPic("Headset.png");
                mFairy.onTap(0.8f,result,453,486,505,529,"序言画面点击",2000);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", 2000);

                result = mFairy.findPic(new String[]{"No push.png","diao.png"});
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(310,201,1232,388,"read2.png");
                mFairy.onTap(0.8f, result, "下一个故事", 2000);
                if (result.sim < 0.8f && dazeTime >= 10){
                    result = mFairy.findPic(229,111,338,626,"xyz.png");
                    mFairy.onTap(0.8f, result,result.x-75,result.y+70,result.x-74,result.y+71, "下一章", 2000);
                }
                result = mFairy.findPic("sevendayend.png");
                if (result.sim > 0.8f){
                    LtLog.e("《花与剑》阅读完");
                    setTaskName(0);return;
                }
                result = mFairy.findPic("secendend.png");
                if (result.sim > 0.8f){
                    LtLog.e("《生魂乱》阅读完");
                    setTaskEnd();return;
                }
                result = mFairy.findPic("Unlock2.png");
                if (result.sim > 0.8f){
                    LtLog.e("今天阅读上限");
                    setTaskEnd();return;
                }

            }
        }.taskContent(mFairy,"七日志");
    }

    /**
     *  摸金校尉
     */
    public void feelGold()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1()throws Exception{
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                result = mFairy.findPic("knapsack.png");
                mFairy.onTap(0.8f,result,"打开背包",1500);

                result = mFairy.findPic(778,21,1170,631,"Feel gold2.png");
                mFairy.onTap(0.8f,result,"摸金符",Sleep);

                result = mFairy.findPic("momo.png");
                mFairy.onTap(0.8f,result,"摸摸",Sleep);
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
                mFairy.taskSlid(err, new int[]{0, 1, 3, 5, 7}, 0, 967,569, 968,125, 2000, 1500);
                if (overtime(10, 3)) return;//计次并跳转
            }
            public void content_2()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("bbcha.png");
                mFairy.onTap(0.8f,result,"关掉背包",Sleep);
                if (dazeTime >= 30){
                    setTaskName(0);return;
                }

                result = mFairy.findPic("mjdf.png");
                mFairy.onTap(0.8f,result,866,69,892,105,"古人洞府",Sleep);

            }
            public void content_3()throws Exception{
                setTaskEnd();return;
            }

        }.taskContent(mFairy,"摸金校尉");
    }

    /**
     * 帮派建设
     */

    public void gangbuild()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("display.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);
                if (rw == 0) {
                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("task2.png");
                mFairy.onTap(0.8f,result,1181,63,1203,88,"关闭",Sleep);
                if (result.sim > 0.8f){
                    rw =1;
                }
                result = mFairy.findPic(0,137,213,384,"bp.png");
                mFairy.onTap(0.7f,result,"左侧帮派任务",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 4, 96,330, 109,193, 1000, 1500);
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("build.png",0);
                result = mFairy.findPic("bangpai.png");
                if (ret==1 && result.sim < 0.8f){
                    setTaskName(3);return;
                }else {
                    LtLog.e("任务完成了或者没有加入帮派");
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);

                result = mFairy.findPic("buy.png");
                mFairy.onTap(0.8f,result,"购买",2000);
                mFairy.onTap(0.8f,result,1165,60,1193,87,"买完叉",Sleep);

                result = mFairy.findPic("submit.png");
                mFairy.onTap(0.8f,result,"提交",2000);
                mFairy.onTap(0.8f,result,337,647,404,669,"提交完点击空白点",2000);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                    timekeepInit("帮会任务打怪");
                    setTaskName(4);
                    return;
                }

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", 2000);

                result = mFairy.findPic("bptask.png");
                mFairy.onTap(0.8f,result,"接取帮会任务",Sleep);

                result = mFairy.findPic(0,137,213,384,"bp.png");
                mFairy.onTap(0.7f,result,"左侧帮派任务",5000);

                if (dazeTime > 20){
                    gameUtil.close();
                }
                if (dazeTime > 120){
                    mFairy.initMatTime();
                    setTaskName(0);return;
                }

                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",2000);
            }
            public void content_4()throws Exception{
                boolean  dg= timekeep(0,600000,"帮会任务打怪");
                if (dg){
                    LtLog.e("打怪超时应该是打不过直接结束");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    timekeepInit("帮会任务打怪");
                    setTaskEnd();return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim < 0.8f){
                    setTaskName(3);
                    return;
                }
            }
        }.taskContent(mFairy,"帮派建设");
    }

    /**
     * 乱世奇谭
     */
    public void troubledTimes()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err == 1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);

                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("display.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);
                if (rw == 0) {
                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("task2.png");
                mFairy.onTap(0.8f,result,1181,63,1203,88,"关闭",Sleep);
                if (result.sim > 0.8f){
                    rw =1;
                }
                result = mFairy.findPic(0,137,213,384,"huan.png");
                mFairy.onTap(0.7f,result,result.x+10,result.y+10,result.x+12,result.y+12,"左侧跑环",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 4, 96,330, 109,193, 1000, 1500);
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("Troubled times.png",0);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);

                result = mFairy.findPic("begin ls.png");
                mFairy.onTap(0.8f,result,"开启跑环",2000);

                result = mFairy.findPic(0,137,213,384,"huan.png");
                mFairy.onTap(0.7f,result,result.x+10,result.y+10,result.x+12,result.y+12,"左侧跑环",5000);

                result = mFairy.findPic("btbuy.png");
                mFairy.onTap(0.8f,result,"摆摊购买道具",2000);

                result = mFairy.findPic(505,173,1140,614,"buysign.png");
                mFairy.onTap(0.8f,result,result.x,result.y+14,result.x+1,result.y+15,"购买道具",2000);

                result = mFairy.findPic(112,278,514,707,"djbuy.png");
                mFairy.onTap(0.8f,result,"摆摊道具购买",5000);
                mFairy.onTap(0.8f,result,1168,58,1191,86,"买完叉",5000);
                mFairy.onTap(0.8f,result,1184,66,1199,87,"买完叉",5000);

                result = mFairy.findPic("submit.png");
                mFairy.onTap(0.8f,result,"提交",2000);

                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim > 0.8f){
                    result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                    mFairy.onTap(0.7f,result,"开启自动",Sleep);
                    timekeepInit("跑环打怪");
                    setTaskName(4);
                    return;
                }

                result = mFairy.findPic("Gold coin.png");
                if (result.sim>0.8f){
                    setTaskEnd();return;
                }

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", 2000);

                if (dazeTime > 60){
                    mFairy.initMatTime();
                    //gameUtil.close();
                    setTaskName(0);return;
                }

                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",2000);


            }
            public void content_4()throws Exception{
                boolean  dg= timekeep(0,650000,"跑环打怪");
                if (dg){
                    LtLog.e("打怪超时应该是打不过直接结束");
                    result = mFairy.findPic("Count down.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic("leave2.png");
                    mFairy.onTap(0.8f,result,"退出副本",2000);
                    result = mFairy.findPic(new String[]{"yes.png","yes2.png"});
                    mFairy.onTap(0.8f,result,"err确定",Sleep);
                    timekeepInit("跑环打怪");
                    setTaskEnd();return;
                }
                result1 = mFairy.findPic(new String[]{"Count down.png", "War situation.png", "Count down2.png", "War situation2.png"});
                if (result1.sim < 0.8f){
                    setTaskName(3);
                    return;
                }
            }
        }.taskContent(mFairy,"乱世奇谭");
    }

    /**
     * 蓬莱之战
     */
    public void battlePenglai()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);

                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("display.png");
                mFairy.onTap(0.8f,result,"显示任务",Sleep);
                if (rw == 0) {
                    result = mFairy.findPic("task.png");
                    mFairy.onTap(0.8f, result, "回到任务栏", 2000);
                }
                result = mFairy.findPic("task2.png");
                mFairy.onTap(0.8f,result,1181,63,1203,88,"关闭",Sleep);
                if (result.sim > 0.8f){
                    rw =1;
                }
                result = mFairy.findPic(0,137,213,384,"plxia.png");
                mFairy.onTap(0.7f,result,"左侧蓬莱任务",Sleep);
                if (result.sim>0.7f){
                    setTaskName(3);return;
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6}, 2, 96,330, 109,193, 1000, 1500);
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("Battle of Penglai.png",1);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    LtLog.e("任务完成了");
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1205,54,26,12,0.9f);
                result = mFairy.findPic("into pl.png");
                mFairy.onTap(0.8f,result,"进入",2000);

                result = mFairy.findPic("Camp revival.png");
                mFairy.onTap(0.8f,result,"大本营复活",2000);

                result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
                mFairy.onTap(0.7f,result,"开启自动",Sleep);

                result1 = mFairy.findPic(0,137,213,384,"plxia.png");
                mFairy.onTap(0.7f,result1,"左侧蓬莱任务",Sleep);

                result = mFairy.findPic("Working part-time.png");
                if (result.sim > 0.8f){
                    setTaskName(2);return;
                }
                if (dazeTime > 60 && result1.sim < 0.8f){
                    mFairy.initMatTime();
                    setTaskName(0);return;
                }
//                if (dazeTime > 20 && result1.sim>0.8f) {
//                    result = mFairy.findPic("activity.png");
//                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
//                    mFairy.onTap(0.8f, result, 763, 405, 780, 424, "去打怪", 2000);
//                    mFairy.onTap(0.8f, result, 1232,49,1243,60, "关闭", 2000);
//                }
                result = mFairy.findPic(new String[]{"Team platform.png","team3.png"});
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);

                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",2000);
            }
        }.taskContent(mFairy,"蓬莱之战");
    }

   /**
   * Faction martial arts  门派演武
    */
   public void  factionMartial()throws Exception{
       new SingleTask(mFairy){
           /**
            * 调用工具类初始化接任务
            * @throws Exception
            */
           public void content_0() throws Exception {
               gameUtil.close();
               setTaskName(1);
           }
           public  void content_1() throws Exception {
               if (err ==1) {
                   mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                   result = mFairy.findPic("right list.png");
                   mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                   result = mFairy.findPic(3, 85, 251, 156, "team.png");
                   LtLog.e("=====================================组队栏相似度" + result.sim);
                   mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                   result = mFairy.findPic("Team platform.png");
                   mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                   result = mFairy.findPic("Sign out Team.png");
                   mFairy.onTap(0.8f, result, "退出队伍", Sleep);
               }
               if (overtime(8, 2)) return;
           }
           /**
            * 寻找任务并且前往
            * @throws Exception
            */
           public void content_2() throws Exception {
               //寻找任务并且前往
               int ret =gameUtil.mission("Faction martial arts.png",1);
               if (ret==1){
                   setTaskName(3);return;
               }else {
                   LtLog.e("任务完成了");
                   setTaskEnd();return;
               }

           }
           public void content_3()throws Exception{
               long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
               result = mFairy.findPic("into mpyl.png");
               mFairy.onTap(0.8f,result,"进入门派演练",2000);

               result = mFairy.findPic("Challenge mpyl.png");
               mFairy.onTap(0.8f,result,"挑战",2000);

               result = mFairy.findPic("Challenge mpyl2.png");
               mFairy.onTap(0.8f,result,"挑战2",2000);

               result = mFairy.findPic("yanwuend.png");
               if (result.sim > 0.8f){
                   mFairy.onTap(0.8f,result,492,517,519,539,"取消",2000);
                   setTaskName(0);return;
               }
               result = mFairy.findPic("mpyl yes.png");
               mFairy.onTap(0.8f,result,"确定",2000);

               result = mFairy.findPic("tzsb.png");
               mFairy.onTap(0.8f,result,"确定",2000);

               result = mFairy.findPic(new String[]{"Manual.png","Manual2.png","Manual3.png"});
               mFairy.onTap(0.7f,result,"开启自动",Sleep);

               if (dazeTime > 30){
                   mFairy.initMatTime();
                   setTaskName(0);return;
               }
               result = mFairy.findPic(new String[]{"Team platform.png","team3.png"});
               mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);

               result = mFairy.findPic("right list.png");
               mFairy.onTap(0.8f,result,"左侧列表",2000);
           }
       }.taskContent(mFairy,"门派演武");
   }

    /**
     *  今日运势 Fortune
     */
    public void  fortune()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("Fortune.png",3);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    LtLog.e("任务完成了");
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Calculation ys.png");
                mFairy.onTap(0.8f,result,"运势测算",2000);

                result = mFairy.findPic("Fortune2.png");
                mFairy.onTap(0.8f,result,931,400,954,424,"测算完成关闭",2000);

                if (dazeTime > 30 || result.sim > 0.8f){
                    mFairy.initMatTime();
                    setTaskName(0);return;
                }
                result = mFairy.findPic(new String[]{"Team platform.png","team3.png"});
                mFairy.onTap(0.8f,result,1176,59,1200,90,"关闭队伍界面",Sleep);

                result = mFairy.findPic("right list.png");
                mFairy.onTap(0.8f,result,"左侧列表",2000);
            }
        }.taskContent(mFairy,"今日运势");
    }

    /**
     *  霖铃别院
     */
    public void  hospital()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                //寻找任务并且前往
                int ret =gameUtil.mission("hospital liling.png",3);
                if (ret==1){
                    setTaskName(3);return;
                }else {
                    LtLog.e("任务完成了");
                    setTaskEnd();return;
                }

            }
            public void content_3()throws Exception{
                result = mFairy.findPic(939,421,1162,637,"Dance.png");
                mFairy.onTap(0.8f,result,"跳舞",Sleep);
                if(result.sim > 0.8f){
                    timekeepInit("跳舞");
                    setTaskName(4);return;
                }
                boolean tw = timekeep(0,180000,"去跳舞");
                if (tw){
                    timekeepInit("去跳舞");
                    setTaskName(1);
                    return;
                }
            }
            public void content_4()throws Exception{
                boolean tw = timekeep(0,240000,"跳舞");
                if (tw){
                    setTaskName(1);
                    return;
                }
                result = mFairy.findPic("Dance2.png");
                mFairy.onTap(0.8f,result,"跳舞",200);

                result = mFairy.findPic("Dance3.png");
                mFairy.onTap(0.8f,result,"跳舞",200);

                result = mFairy.findPic("Fortune3.png");
                mFairy.onTap(0.8f,result,"领取礼物",2000);

                result = mFairy.findPic("To accept.png");
                mFairy.onTap(0.8f,result,"领取礼物2",2000);
            }
        }.taskContent(mFairy,"霖铃别院");
    }

    /**
     * 采集
     */
    int number = 0 ;
    int coord_y=0;
    int place = 0;
    public void  collection()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                if(!AtFairyConfig.getOption("opcount1").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount1")).choice==1){
                        coord_y=strSplit(AtFairyConfig.getOption("opcount1")).count;
                    }else {
                        LtLog.e("没有设定采集次数结束");
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("16")||AtFairyConfig.getOption("cj").equals("17")||AtFairyConfig.getOption("cj").equals("15")||AtFairyConfig.getOption("cj").equals("1")||AtFairyConfig.getOption("cj").equals("2")||AtFairyConfig.getOption("cj").equals("3")||AtFairyConfig.getOption("cj").equals("4")||AtFairyConfig.getOption("cj").equals("5")||AtFairyConfig.getOption("cj").equals("6")){
                   gameUtil.goCity("韦剑山庄");
                }
                if (AtFairyConfig.getOption("cj").equals("7")){
                    gameUtil.goCity("长安");
                }
                if (AtFairyConfig.getOption("cj").equals("8") ||AtFairyConfig.getOption("cj").equals("9")||AtFairyConfig.getOption("cj").equals("10") || AtFairyConfig.getOption("cj").equals("14")){
                    gameUtil.goCity("墨圣山庄");
                }
                if (AtFairyConfig.getOption("cj").equals("11") ||AtFairyConfig.getOption("cj").equals("12")){
                    gameUtil.goCity("雪域幻境");
                }
                if (AtFairyConfig.getOption("cj").equals("13")){
                    gameUtil.goCity("文墨轩");
                }
                setTaskName(3);
            }
            public void content_3()throws Exception{
                if (AtFairyConfig.getOption("cj").equals("1") || AtFairyConfig.getOption("cj").equals("2") || AtFairyConfig.getOption("cj").equals("3")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);

                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x+60,result.y+60,result.x+61,result.y+61,"青虫茅草棉花位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                if (AtFairyConfig.getOption("cj").equals("4")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 818,301
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x+90,result.y+48,result.x+91,result.y+49,"石块位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                if (AtFairyConfig.getOption("cj").equals("5")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 666  508
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x-70,result.y+255,result.x-69,result.y+256,"楠竹位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }

                if (AtFairyConfig.getOption("cj").equals("6")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x+181,result.y+37,result.x+182,result.y+38,"大理石位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }

                if (AtFairyConfig.getOption("cj").equals("7") && place == 0){
                    result = mFairy.findPic("Chang An map.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f,result,974,549,983,560,"玫瑰位置1",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",30000);
                    place=1;
                }else if (AtFairyConfig.getOption("cj").equals("7") && place == 1){
                    result = mFairy.findPic("Chang An map.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f,result,969,535,978,541,"玫瑰位置2",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",5000);
                    place=2;
                }else if (AtFairyConfig.getOption("cj").equals("7") && place == 2){
                    result = mFairy.findPic("Chang An map.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f,result,1012,534,1021,539,"玫瑰位置3",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",5000);
                    place=3;
                }else if (AtFairyConfig.getOption("cj").equals("7") && place == 3){
                    result = mFairy.findPic("Chang An map.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f,result,957,535,964,543,"玫瑰位置4",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",5000);
                    place=4;
                }else if (AtFairyConfig.getOption("cj").equals("7") && place == 4){
                    result = mFairy.findPic("Chang An map.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
                    mFairy.onTap(0.8f,result,1005,528,1009,534,"玫瑰位置5",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",5000);
                    place=0;
                }


                if (AtFairyConfig.getOption("cj").equals("8") || AtFairyConfig.getOption("cj").equals("9") || AtFairyConfig.getOption("cj").equals("10")){
                    result = mFairy.findPic("mo.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);

                    mFairy.onTap(0.7f,result,687,375,693,380,"树脂树皮桐木位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",15000);
                }
                if (AtFairyConfig.getOption("cj").equals("11") && place ==0){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,829,294,835,301,"雪莲位置1",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",15000);
                    place =1;
                }else if (AtFairyConfig.getOption("cj").equals("11") && place ==1){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,838,242,843,247,"雪莲位置2",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",20000);
                    place = 2;
                }else if (AtFairyConfig.getOption("cj").equals("11") && place ==2){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,808,104,814,110,"雪莲位置3",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",20000);
                    place=3;
                }else if (AtFairyConfig.getOption("cj").equals("11") && place ==3){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,763,184,769,190,"雪莲位置4",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",25000);
                    place=4;
                }else if (AtFairyConfig.getOption("cj").equals("11") && place ==4){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,683,279,690,284,"雪莲位置5",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",20000);
                    place=5;
                }else if (AtFairyConfig.getOption("cj").equals("11") && place ==5){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,645,298,651,306,"雪莲位置6",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",8000);
                    place=0;
                }
                if (AtFairyConfig.getOption("cj").equals("12") && place ==0){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,723,289,727,296,"精矿位置1",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",20000);
                    place=1;
                }else if (AtFairyConfig.getOption("cj").equals("12") && place ==1){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,843,301,851,309,"精矿位置2",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",10000);
                    place=2;
                }else if (AtFairyConfig.getOption("cj").equals("12") && place ==2){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,787,304,797,316,"精矿位置3",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",10000);
                    place=3;
                }else if (AtFairyConfig.getOption("cj").equals("12") && place ==3){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 916 290
                    mFairy.onTap(0.8f,result,639,171,646,180,"精矿位置4",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",10000);
                    place=0;
                }

                if (AtFairyConfig.getOption("cj").equals("13")){
                    result = mFairy.findPic("wen.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);

                    mFairy.onTap(0.8f,result,598,312,606,321,"枫木位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",20000);
                }
                if (AtFairyConfig.getOption("cj").equals("14")){
                    result = mFairy.findPic("mo.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);

                    mFairy.onTap(0.8f,result,664,380,670,389,"铁矿位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",20000);
                }

                if (AtFairyConfig.getOption("cj").equals("15")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 506,406
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x-229,result.y+148,result.x-228,result.y+150,"鹅膏菌竹荪菌夜光菌位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                if (AtFairyConfig.getOption("cj").equals("16")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 643,419
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x-92,result.y+166,result.x-91,result.y+167,"荷叶位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                if (AtFairyConfig.getOption("cj").equals("17")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 614,393
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x-121,result.y+140,result.x-120,result.y+141,"荷花位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                result = mFairy.findPic(974,418,1201,678,new String[]{"hand.png","Axe.png","Pickaxe.png"});
                if (result.sim > 0.8f){
                    setTaskName(4);return;
                }

            }
            public void content_4()throws Exception{
                if (AtFairyConfig.getOption("cj").equals("1")){
                    result = mFairy.findPic(974,418,1201,678,"Green worm.png");
                    mFairy.onTap(0.8f,result,"捉青虫",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                }

                if (AtFairyConfig.getOption("cj").equals("2")){
                    result = mFairy.findPic(974,418,1201,678,"Thatch grass.png");
                    mFairy.onTap(0.8f,result,"采茅草",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }

                }
                if (AtFairyConfig.getOption("cj").equals("3")){
                    result = mFairy.findPic(974,418,1201,678,"cotton.png");
                    mFairy.onTap(0.8f,result,"采棉花",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("4")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"stone.png");
                    mFairy.onTap(0.8f,result,"采石块",2000);
                    LtLog.e("采石头计时"+dazeTime);
                   if (dazeTime >= coord_y*3){
                       mFairy.touchDown(4,278,514);
                       mFairy.touchMove(4,234,617,1000);
                       mFairy.touchUp(4);
                       setTaskEnd();return;
                   }
                }
                if (AtFairyConfig.getOption("cj").equals("5")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Axe.png");
                    mFairy.onTap(0.8f,result,"砍楠竹",2000);
                    LtLog.e("砍楠竹计时"+dazeTime);
                    if (dazeTime >= coord_y*5 ){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("6")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,new String[]{"Marble.png","Marble2.png"});
                    mFairy.onTap(0.8f,result,"挖大理石",2000);
                    result = mFairy.findPic("Upper.png");
                    if (result.sim > 0.8f){
                        LtLog.e("挖大理石上限");
                        setTaskEnd();return;
                    }
                    if(result.sim > 0.8f){
                        number++;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("7")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"hand.png");
                    mFairy.onTap(0.7f,result,"采玫瑰",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                    if (dazeTime >= 10){
                        //place++;
                        setTaskName(3);return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("8")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"bark.png");
                    mFairy.onTap(0.8f,result,"扒树皮",2000);
                    LtLog.e("扒树皮计时"+dazeTime);
                    if (dazeTime >= coord_y*3){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("9")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Axe.png");
                    mFairy.onTap(0.8f,result,"砍桐木",2000);
                    LtLog.e("砍桐木计时"+dazeTime);
                    if (dazeTime >= coord_y*5){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("10")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Pocket knife.png");
                    mFairy.onTap(0.8f,result,"刮树脂",2000);
                    LtLog.e("刮树脂计时"+dazeTime);
                    if (dazeTime >= coord_y*5){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("11")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result1 = mFairy.findPic(974,418,1201,678,"hand.png");
                    mFairy.onTap(0.7f,result1,"采雪莲",2000);
                    if(result1.sim > 0.8f){
                        mFairy.initMatTime();
                        number++;
                    }
                    //result = mFairy.findPic("Collection.png");
                    if (dazeTime >= 10){
                        //place++;
                        setTaskName(3);return;
                    }

                }
                if (AtFairyConfig.getOption("cj").equals("12")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Pickaxe.png");
                    mFairy.onTap(0.7f,result,"挖精矿",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                    if (dazeTime >= 10){
                        //place++;
                        setTaskName(3);return;
                    }

                }
                if (AtFairyConfig.getOption("cj").equals("13")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Axe.png");
                    mFairy.onTap(0.8f,result,"砍枫木",2000);
                    LtLog.e("砍枫木计时"+dazeTime);
                    if (dazeTime >= coord_y*5){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("14")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Pickaxe.png");
                    mFairy.onTap(0.8f,result,"挖铁矿",2000);
                    LtLog.e("挖铁矿计时"+dazeTime);
                    if (dazeTime >= coord_y*5){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("15")){
                    result = mFairy.findPic(974,418,1201,678,"hand.png");
                    mFairy.onTap(0.8f,result,"夜光菌竹荪菌鹅膏菌",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("16")){
                    result = mFairy.findPic(974,418,1201,678,"hand.png");
                    mFairy.onTap(0.8f,result,"荷叶",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                }
                if (AtFairyConfig.getOption("cj").equals("17")){
                    result = mFairy.findPic(974,418,1201,678,"hand.png");
                    mFairy.onTap(0.8f,result,"荷叶",2000);
                    if(result.sim > 0.8f){
                        number++;
                    }
                }
                LtLog.e("========================================="+coord_y+"==================================number"+number);
                if(number >=coord_y){
                    number=0;
                    setTaskEnd();return;
                }


            }
        }.taskContent(mFairy,"采集");
    }

    /**
     * 垂钓
     */
    int coord_x = 0;
    int number2 = 0;
    public void  goFishing()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                if(!AtFairyConfig.getOption("opcount2").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount2")).choice==1){
                        coord_x=strSplit(AtFairyConfig.getOption("opcount2")).count;
                    }else {
                        LtLog.e("没有设定垂钓次数结束");
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cd").equals("1")||AtFairyConfig.getOption("cd").equals("2")){
                    gameUtil.goCity("韦剑山庄");
                }
                if (AtFairyConfig.getOption("cd").equals("3")||AtFairyConfig.getOption("cd").equals("4")){
                    gameUtil.goCity("长安");
                }
                if (AtFairyConfig.getOption("cd").equals("5") ){
                    gameUtil.goCity("雪域幻境");
                }
                if (AtFairyConfig.getOption("cd").equals("13")){
                    gameUtil.goCity("文墨轩");
                }
                setTaskName(3);
            }
            public void content_3()throws Exception{
                if (AtFairyConfig.getOption("cd").equals("1") || AtFairyConfig.getOption("cd").equals("2")){
                    result = mFairy.findPic("jianwei.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 522,388
                    result = mFairy.findPic(649,226,854,685,"worm.png");
                    mFairy.onTap(0.7f,result,result.x-213,result.y+135,result.x-212,result.y+136,"青蛙青鱼位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                if (AtFairyConfig.getOption("cd").equals("3") || AtFairyConfig.getOption("cd").equals("4")){
                    result = mFairy.findPic("Chang An map.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 522,388
                    mFairy.onTap(0.7f,result,400,567,405,571,"草鱼锦鲤位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                if (AtFairyConfig.getOption("cd").equals("5") ){
                    result = mFairy.findPic("xue.png");
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",2000);
                    result = mFairy.findPic(953,8,1067,74,"activity.png");
                    mFairy.onTap(0.8f, result, 1166, 72, 1201, 100, "打开地图", 2000);
// 735  253 522,388
                    mFairy.onTap(0.7f,result,616,242,621,245,"鲢鱼鳙鱼位置",2000);
                    mFairy.onTap(0.8f,result,1232,54,1248,65,"关闭",6000);
                }
                result = mFairy.findPic(974,418,1201,678,new String[]{"lantern.png","Fishing rod.png"});
                if (result.sim > 0.8f){
                    setTaskName(4);return;
                }

            }
            public void content_4()throws Exception{
                if (AtFairyConfig.getOption("cd").equals("1")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,new String[]{"lantern.png","Frog fishing.png"});
                    mFairy.onTap(0.8f,result,"抓青蛙",2000);
                    LtLog.e("抓青蛙计时"+dazeTime);
                    if (dazeTime >= coord_x*7){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cd").equals("2")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"qing yu.png");
                    mFairy.onTap(0.8f,result,"钓青鱼",2000);
                    LtLog.e("钓青鱼计时"+dazeTime);
                    if (dazeTime >= coord_x*8){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cd").equals("3")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Grass Carp.png");
                    mFairy.onTap(0.8f,result,"钓草鱼",2000);
                    LtLog.e("钓草鱼计时"+dazeTime);
                    if (dazeTime >= coord_x*8){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cd").equals("4")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Lucky charm.png");
                    mFairy.onTap(0.8f,result,"钓锦鲤",2000);
                    LtLog.e("钓锦鲤计时"+dazeTime);
                    if (dazeTime >= coord_x*16){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                if (AtFairyConfig.getOption("cd").equals("5")){
                    long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                    result = mFairy.findPic(974,418,1201,678,"Fishing rod.png");
                    mFairy.onTap(0.8f,result,"钓鱼",2000);
                    LtLog.e("钓鱼计时"+dazeTime);
                    if (dazeTime >= coord_x*8){
                        mFairy.touchDown(4,278,514);
                        mFairy.touchMove(4,234,617,1000);
                        mFairy.touchUp(4);
                        setTaskEnd();return;
                    }
                }
                LtLog.e("========================================="+coord_x+"==================================number"+number2);
                if(number2 >=coord_x){
                    number2=0;
                    setTaskEnd();return;
                }


            }
        }.taskContent(mFairy,"垂钓");
    }

    /**
     * 工艺制作
     */

    public void  technology()throws Exception{
        new SingleTask(mFairy){
            boolean ft = false;
            boolean hzc = false;
            boolean yg = false;
            boolean bcw = false;
            boolean tzdl = false;
            boolean xd = false;
            boolean xr = false;
            boolean xyr = false;
            boolean sz = false;
            boolean xx = false;
            boolean bb = false;
            boolean lg = false;
            boolean gs = false;
            boolean gss = false;
            boolean ygf = false;
            boolean zt = false;
            boolean zmie = false;
            boolean zq = false;
            boolean zgpz = false;
            boolean zgcz = false;
            boolean st = false;
            boolean sg = false;
            boolean sang = false;
            boolean sd = false;
            boolean sj =false;
            boolean pz = false;
            boolean ym = false;
            boolean ty = false;
            boolean htstb = false;
            boolean htssm = false;
            boolean yzstb = false;
            boolean yzssm =false;
            boolean axstb =false;
            boolean axssm =false;
            boolean yrstb =false;
            boolean yrssm =false;
            boolean jlstb =false;
            boolean jlssm =false;
            boolean ffjtb =false;
            boolean ffjsm =false;
            boolean sqqtb =false;
            boolean sqqsm =false;
            boolean cxwtb =false;
            boolean cxwsm =false;
            boolean lyxtb =false;
            boolean lyxsm =false;
            boolean zyytb =false;
            boolean zyysm =false;
            boolean hyjtb =false;
            boolean hyjsm =false;
            boolean ct =false;
            boolean mj =false;
            boolean wg =false;
            boolean cf =false;
            boolean cd =false;
            boolean hyzj =false;
            boolean dxct =false;
            boolean chuand =false;
            boolean szgj =false;
            boolean sm =false;
            boolean bzdzg =false;
            boolean zzdz =false;
            boolean wj =false;
            boolean pzsz =false;
            boolean xgx =false;
            boolean lxst =false;
            boolean ljx =false;
            boolean bash =false;
            boolean yyxx =false;
            boolean hkyy =false;
            boolean mytj =false;
            boolean bycm =false;
            boolean zanjuan =false;
            boolean zanjujian =false;
            boolean zanjult =false;
            boolean zanjud =false;
            boolean zanjupx =false;
            boolean janjuan =false;
            boolean janjujian =false;
            boolean janjult =false;
            boolean janjud =false;
            boolean janjupx =false;
            boolean jzzagj =false;
            boolean anjuan =false;
            boolean anjujian =false;
            boolean anjult =false;
            boolean anjud =false;
            boolean anjupx =false;
            boolean xwly =false;
            boolean yzhd =false;
            boolean syky =false;
            boolean xdl =false;
            boolean qph =false;
            boolean dqph =false;
            boolean qwfan =false;
            boolean xxmg =false;
            boolean mtmg =false;
            boolean fife =false;
            boolean zouzheng =false;

            boolean yzcw =false;
            boolean cjhy =false;
            boolean xrhx =false;
            boolean mygx =false;
            boolean hts =false;
            boolean yzs =false;
            boolean axs =false;
            boolean yrs =false;
            boolean jls =false;
            boolean sqq =false;
            boolean cxw =false;
            boolean zyy =false;
            boolean ffj =false;
            boolean lyx =false;
            boolean hyj =false;
            boolean qd =false;
            boolean nz =false;
            boolean yz =false;
            boolean bzsl = false;
            boolean lwmj =false;
            boolean cxs =false;
            boolean mm =false;
            boolean qxw =false;
            boolean mgxx =false;
            boolean bfjs =false;
            boolean zzpf =false;
            boolean spbt =false;
            boolean cbh =false;
            boolean jsbj =false;


            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void create() throws Exception {
                LtLog.e("进来了+++++++++++++++++++++++++++");
                if (AtFairyConfig.getOption("ft").equals("1")){
                    ft = true;
                }
                if (AtFairyConfig.getOption("hzc").equals("1")){
                    hzc = true;
                }
                if (AtFairyConfig.getOption("yg").equals("1")){
                    yg = true;
                }
                if (AtFairyConfig.getOption("bcw").equals("1")){
                    bcw = true;
                }
                if (AtFairyConfig.getOption("tzdl").equals("1")){
                    tzdl = true;
                }
                if (AtFairyConfig.getOption("xd").equals("1")){
                    xd = true;
                }
                if (AtFairyConfig.getOption("xr").equals("1")){
                    xr = true;
                }
                if (AtFairyConfig.getOption("xyr").equals("1")){
                    xyr = true;
                }
                if (AtFairyConfig.getOption("sz").equals("1")){
                    sz = true;
                }
                if (AtFairyConfig.getOption("xx").equals("1")){
                    xx = true;
                }
                if (AtFairyConfig.getOption("bb").equals("1")){
                    bb = true;
                }
                if (AtFairyConfig.getOption("lg").equals("1")){
                    lg = true;
                }
                if (AtFairyConfig.getOption("gs").equals("1")){
                    gs = true;
                }
                if (AtFairyConfig.getOption("gss").equals("1")){
                    gss = true;
                }
                if (AtFairyConfig.getOption("ygf").equals("1")){
                    ygf = true;
                }
                if (AtFairyConfig.getOption("zt").equals("1")){
                    zt = true;
                }
                if (AtFairyConfig.getOption("zmie").equals("1")){
                    zmie = true;
                }
                if (AtFairyConfig.getOption("zq").equals("1")){
                    zq = true;
                }
                if (AtFairyConfig.getOption("zgpz").equals("1")){
                    zgpz = true;
                }
                if (AtFairyConfig.getOption("zgcz").equals("1")){
                    zgcz = true;
                }
                if (AtFairyConfig.getOption("st").equals("1")){
                    st = true;
                }
                if (AtFairyConfig.getOption("sg").equals("1")){
                    sg = true;
                }
                if (AtFairyConfig.getOption("sang").equals("1")){
                    sang = true;
                }
                if (AtFairyConfig.getOption("sd").equals("1")){
                    sd = true;
                }
                if (AtFairyConfig.getOption("sj").equals("1")){
                    sj = true;
                }
                if (AtFairyConfig.getOption("pz").equals("1")){
                    pz = true;
                }
                if (AtFairyConfig.getOption("ym").equals("1")){
                    ym = true;
                }

                if (AtFairyConfig.getOption("ty").equals("1")){
                    ty = true;
                }
                if (AtFairyConfig.getOption("htstb").equals("1")){
                    htstb = true;
                }
                if (AtFairyConfig.getOption("htssm").equals("1")){
                    htssm = true;
                }
                if (AtFairyConfig.getOption("yzstb").equals("1")){
                    yzstb = true;
                }
                if (AtFairyConfig.getOption("yzssm").equals("1")){
                    yzssm = true;
                }
                if (AtFairyConfig.getOption("axstb").equals("1")){
                    axstb = true;
                }
                if (AtFairyConfig.getOption("axssm").equals("1")){
                    axssm = true;
                }
                if (AtFairyConfig.getOption("yrstb").equals("1")){
                    yrstb = true;
                }
                if (AtFairyConfig.getOption("yrssm").equals("1")){
                    yrssm = true;
                }
                if (AtFairyConfig.getOption("jlstb").equals("1")){
                    jlstb = true;
                }
                if (AtFairyConfig.getOption("jlssm").equals("1")){
                    jlssm = true;
                }
                if (AtFairyConfig.getOption("ffjtb").equals("1")){
                    ffjtb = true;
                }
                if (AtFairyConfig.getOption("ffjsm").equals("1")){
                    ffjsm = true;
                }
                if (AtFairyConfig.getOption("sqqtb").equals("1")){
                    sqqtb = true;
                }
                if (AtFairyConfig.getOption("sqqsm").equals("1")){
                    sqqsm = true;
                }
                if (AtFairyConfig.getOption("cxwtb").equals("1")){
                    cxwtb = true;
                }
                if (AtFairyConfig.getOption("cxwsm").equals("1")){
                    cxwsm = true;
                }
                if (AtFairyConfig.getOption("lyxtb").equals("1")){
                    lyxtb = true;
                }
                if (AtFairyConfig.getOption("lyxsm").equals("1")){
                    lyxsm = true;
                }
                if (AtFairyConfig.getOption("zyytb").equals("1")){
                    zyytb = true;
                }
                if (AtFairyConfig.getOption("zyysm").equals("1")){
                    zyysm = true;
                }
                if (AtFairyConfig.getOption("hyjtb").equals("1")){
                    hyjtb = true;
                }
                if (AtFairyConfig.getOption("hyjsm").equals("1")){
                    hyjsm = true;
                }
                if (AtFairyConfig.getOption("ct").equals("1")){
                    ct = true;
                }
                if (AtFairyConfig.getOption("mj").equals("1")){
                    mj = true;
                }
                if (AtFairyConfig.getOption("wg").equals("1")){
                    wg = true;
                }
                if (AtFairyConfig.getOption("cf").equals("1")){
                    cf = true;
                }
                if (AtFairyConfig.getOption("cd").equals("1")){
                    cd = true;
                }
                if (AtFairyConfig.getOption("hyzj").equals("1")){
                    hyzj = true;
                }
                if (AtFairyConfig.getOption("dxct").equals("1")){
                    dxct = true;
                }
                if (AtFairyConfig.getOption("chuand").equals("1")){
                    chuand = true;
                }
                if (AtFairyConfig.getOption("szgj").equals("1")){
                    szgj = true;
                }
                if (AtFairyConfig.getOption("sm").equals("1")){
                    sm = true;
                }
                if (AtFairyConfig.getOption("bzdzg").equals("1")){
                    bzdzg = true;
                }
                if (AtFairyConfig.getOption("zzdz").equals("1")){
                    zzdz = true;
                }
                if (AtFairyConfig.getOption("wj").equals("1")){
                    wj =true;
                }
                if (AtFairyConfig.getOption("pzsz").equals("1")){
                    pzsz = true;
                }
                if (AtFairyConfig.getOption("xgx").equals("1")){
                    xgx = true;
                }
                if (AtFairyConfig.getOption("lxst").equals("1")){
                    lxst = true;
                }
                if (AtFairyConfig.getOption("ljx").equals("1")){
                    ljx = true;
                }
                if (AtFairyConfig.getOption("bash").equals("1")){
                    bash = true;
                }
                if (AtFairyConfig.getOption("yyxx").equals("1")){
                    yyxx = true;
                }
                if (AtFairyConfig.getOption("hkyy").equals("1")){
                    hkyy = true;
                }
                if (AtFairyConfig.getOption("mytj").equals("1")){
                    mytj = true;
                }
                if (AtFairyConfig.getOption("bycm").equals("1")){
                    bycm = true;
                }

                if (AtFairyConfig.getOption("zanjuan").equals("1")){
                    zanjuan = true;
                }
                if (AtFairyConfig.getOption("zanjujian").equals("1")){
                    zanjujian = true;
                }
                if (AtFairyConfig.getOption("zanjult").equals("1")){
                    zanjult = true;
                }
                if (AtFairyConfig.getOption("zanjud").equals("1")){
                    zanjud = true;
                }
                if (AtFairyConfig.getOption("zanjupx").equals("1")){
                    zanjupx = true;
                }
                if (AtFairyConfig.getOption("janjuan").equals("1")){
                    janjuan = true;
                }
                if (AtFairyConfig.getOption("janjujian").equals("1")){
                    janjujian = true;
                }
                if (AtFairyConfig.getOption("janjult").equals("1")){
                    janjult = true;
                }
                if (AtFairyConfig.getOption("janjud").equals("1")){
                    janjud = true;
                }
                if (AtFairyConfig.getOption("janjupx").equals("1")){
                    janjupx = true;
                }
                if (AtFairyConfig.getOption("jzzagj").equals("1")){
                    jzzagj = true;
                }
                if (AtFairyConfig.getOption("anjuan").equals("1")){
                    anjuan = true;
                }
                if (AtFairyConfig.getOption("anjujian").equals("1")){
                    anjujian = true;
                }
                if (AtFairyConfig.getOption("anjult").equals("1")){
                    anjult = true;
                }
                if (AtFairyConfig.getOption("anjud").equals("1")){
                    anjud = true;
                }
                if (AtFairyConfig.getOption("anjupx").equals("1")){
                    anjupx = true;
                }
                if (AtFairyConfig.getOption("xwly").equals("1")){
                    xwly = true;
                }
                if (AtFairyConfig.getOption("yzhd").equals("1")){
                    yzhd = true;
                }
                if (AtFairyConfig.getOption("syky").equals("1")){
                    syky = true;
                }
                if (AtFairyConfig.getOption("xdl").equals("1")){
                    xdl = true;
                }
                if (AtFairyConfig.getOption("qph").equals("1")){
                    qph = true;
                }
                if (AtFairyConfig.getOption("dqph").equals("1")){
                    dqph = true;
                }
                if (AtFairyConfig.getOption("qwfan").equals("1")){
                    qwfan = true;
                }
                if (AtFairyConfig.getOption("xxmg").equals("1")){
                    xxmg = true;
                }
                if (AtFairyConfig.getOption("mtmg").equals("1")){
                    mtmg = true;
                }
                if (AtFairyConfig.getOption("fife").equals("1")){
                    fife = true;
                }
                if (AtFairyConfig.getOption("zouzheng").equals("1")){
                    zouzheng = true;
                }
                if (AtFairyConfig.getOption("yzcw").equals("1")){
                    yzcw = true;
                }
                if (AtFairyConfig.getOption("cjhy").equals("1")){
                    cjhy = true;
                }
                if (AtFairyConfig.getOption("xrhx").equals("1")){
                    xrhx = true;
                }
                if (AtFairyConfig.getOption("mygx").equals("1")){
                    mygx = true;
                }

                if (AtFairyConfig.getOption("hts").equals("1")){
                    hts = true;
                }
                if (AtFairyConfig.getOption("yzs").equals("1")){
                    yzs = true;
                }
                if (AtFairyConfig.getOption("axs").equals("1")){
                    axs = true;
                }
                if (AtFairyConfig.getOption("yrs").equals("1")){
                    yrs = true;
                }
                if (AtFairyConfig.getOption("jls").equals("1")){
                    jls = true;
                }
                if (AtFairyConfig.getOption("sqq").equals("1")){
                    sqq = true;
                }
                if (AtFairyConfig.getOption("cxw").equals("1")){
                    cxw = true;
                }
                if (AtFairyConfig.getOption("zyy").equals("1")){
                    zyy = true;
                }
                if (AtFairyConfig.getOption("ffj").equals("1")){
                    ffj = true;
                }
                if (AtFairyConfig.getOption("lyx").equals("1")){
                    lyx = true;
                }
                if (AtFairyConfig.getOption("hyj").equals("1")){
                    hyj = true;
                }
                if (AtFairyConfig.getOption("qd").equals("1")){
                    qd = true;
                }
                if (AtFairyConfig.getOption("nz").equals("1")){
                    nz = true;
                }
                if (AtFairyConfig.getOption("yz").equals("1")){
                    yz = true;
                }
                if (AtFairyConfig.getOption("bzsl").equals("1")){
                    bzsl = true;
                }
                if (AtFairyConfig.getOption("lwmj").equals("1")){
                    lwmj = true;
                }
                if (AtFairyConfig.getOption("cxs").equals("1")){
                    cxs = true;
                }
                if (AtFairyConfig.getOption("mm").equals("1")){
                    mm = true;
                }
                if (AtFairyConfig.getOption("qxw").equals("1")){
                    qxw = true;
                }
                if (AtFairyConfig.getOption("mgxx").equals("1")){
                    mgxx = true;
                }
                if (AtFairyConfig.getOption("bfjs").equals("1")){
                    bfjs = true;
                }
                if (AtFairyConfig.getOption("zzpf").equals("1")){
                    zzpf = true;
                }
                if (AtFairyConfig.getOption("spbt").equals("1")){
                    spbt = true;
                }
                if (AtFairyConfig.getOption("cbh").equals("1")){
                    cbh = true;
                }
                if (AtFairyConfig.getOption("jsbj").equals("1")){
                    jsbj = true;
                }

            }
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public  void content_1() throws Exception {
                if (err ==1) {
                    mFairy.onTap(155, 114, 195, 133, "组队蓝", 2000);
                    result = mFairy.findPic("right list.png");
                    mFairy.onTap(0.8f, result, "任务收纳栏", Sleep + 1000);
                    result = mFairy.findPic(3, 85, 251, 156, "team.png");
                    LtLog.e("=====================================组队栏相似度" + result.sim);
                    mFairy.onTap(0.70f, result, "打开组队栏", 2000);

                    result = mFairy.findPic("Team platform.png");
                    mFairy.onTap(0.8f, result, 1179, 59, 1196, 86, "没队伍关闭", Sleep);

                    result = mFairy.findPic("Sign out Team.png");
                    mFairy.onTap(0.8f, result, "退出队伍", Sleep);
                }
                if (overtime(8, 2)) return;
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_2() throws Exception {
                if(!AtFairyConfig.getOption("opcount3").equals("")){
                    if(strSplit(AtFairyConfig.getOption("opcount3")).choice==1){
                        coord_x=strSplit(AtFairyConfig.getOption("opcount3")).count;
                    }else {
                        LtLog.e("没有设定制作次数结束");
                        setTaskEnd();return;
                    }
                }
               // gameUtil.makingMedicine(0);
                setTaskName(3);
            }
            public void content_3()throws Exception{
                if (overtime(6,0))return;
                if (ft){
                    ft = false;
                    gameUtil.woodWork("makeAxe.png",1);
                    setTaskName(4);return;

                }else if (hzc){
                    hzc=false;
                    gameUtil.woodWork("makegao.png",1);
                    setTaskName(4);return;
                }else if (yg){
                    yg=false;
                    gameUtil.woodWork("makefinsh.png",1);
                    setTaskName(4);return;
                }else if (bcw){
                    bcw=false;
                    gameUtil.woodWork("Insect catching.png",1);
                    setTaskName(4);return;
                }else if (tzdl){
                    tzdl=false;
                    gameUtil.woodWork("makelantern.png",1);
                    setTaskName(4);return;
                }else if (xd){
                    xd=false;
                    gameUtil.woodWork("makexiaodao.png",1);
                    setTaskName(4);return;
                }
                if (xr){
                    xr=false;
                    gameUtil.woodWork("bait.png",0);
                    setTaskName(4);return;
                }else if (xyr){
                    xyr=false;
                    gameUtil.woodWork("Fishy bait.png",0);
                    setTaskName(4);return;
                }

                if (sz){
                    sz = false;
                    gameUtil.woodWork("Rope.png",0);
                    setTaskName(4);return;
                }
                if (xx){
                    xx = false;
                    gameUtil.woodWork("Line5.png",0);
                    setTaskName(4);return;
                }
                if (bb){
                    bb = false;
                    gameUtil.woodWork("cloth.png",0);
                    setTaskName(4);return;
                }
                if (lg){
                    lg = false;
                    gameUtil.woodWork("steel-making.png",0);
                    setTaskName(4);return;
                }
                if (gs){
                    gs = false;
                    gameUtil.woodWork("steel wire.png",0);
                    setTaskName(4);return;
                }
                if (gss){
                    gss = false;
                    gameUtil.woodWork("Wire rope.png",0);
                    setTaskName(4);return;
                }
                if (ygf){
                    ygf = false;
                    gameUtil.woodWork("Phosphor.png",0);
                    setTaskName(4);return;
                }
                if (zt){
                    zt = false;
                    gameUtil.woodWork("Bamboo tube.png",0);
                    setTaskName(4);return;
                }
                if (zmie){
                    zmie = false;
                    gameUtil.woodWork("Bamboo strips.png",0);
                    setTaskName(4);return;
                }
                if (zq){
                    zq = false;
                    gameUtil.woodWork("Bamboo ball.png",0);
                    setTaskName(4);return;
                }
                if (zgpz){
                    zgpz = false;
                    gameUtil.woodWork("Umbrella lining.png",0);
                    setTaskName(4);return;
                }
                if (zgcz){
                    zgcz = false;
                    gameUtil.woodWork("Umbrella rib.png",0);
                    setTaskName(4);return;
                }
                if (st){
                    st = false;
                    gameUtil.woodWork("Umbrella bracket.png",0);
                    setTaskName(4);return;
                }
                if (sg){
                    sg = false;
                    gameUtil.woodWork("Umbrella bone.png",0);
                    setTaskName(4);return;
                }
                if (sang){
                    sang = false;
                    gameUtil.woodWork("Umbrella rod.png",0);
                    setTaskName(4);return;
                }
                if (sd){
                    sd = false;
                    gameUtil.woodWork("Umbrella top.png",0);
                    setTaskName(4);return;
                }
                if (sj){
                    sj = false;
                    gameUtil.woodWork("Umbrella stand.png",0);
                    setTaskName(4);return;
                }
                if (pz){
                    pz = false;
                    gameUtil.woodWork("Leather paper.png",0);
                    setTaskName(4);return;
                }
                if (ym){
                    ym = false;
                    gameUtil.woodWork("Medicine ink.png",0);
                    setTaskName(4);return;
                }

                if (ty){
                    ty = false;
                    gameUtil.woodWork("tung oil.png",0);
                    setTaskName(4);return;
                }
                if (htstb){
                    htstb = false;
                    gameUtil.woodWork("htstb.png",0);
                    setTaskName(4);return;
                }
                if (htssm){
                    htssm = false;
                    gameUtil.woodWork("htssm.png",0);
                    setTaskName(4);return;
                }
                if (yzstb){
                    yzstb = false;
                    gameUtil.woodWork("yzstb.png",0);
                    setTaskName(4);return;
                }
                if (yzssm){
                    yzssm = false;
                    gameUtil.woodWork("yzssm.png",0);
                    setTaskName(4);return;
                }
                if (axstb){
                    axstb = false;
                    gameUtil.woodWork("axstb.png",0);
                    setTaskName(4);return;
                }
                if (axssm){
                    axssm = false;
                    gameUtil.woodWork("axssm.png",0);
                    setTaskName(4);return;
                }
                if (yrstb){
                    yrstb = false;
                    gameUtil.woodWork("yrstb.png",0);
                    setTaskName(4);return;
                }
                if (yrssm){
                    yrssm = false;
                    gameUtil.woodWork("yrssm.png",0);
                    setTaskName(4);return;
                }
                if (jlstb){
                    jlstb = false;
                    gameUtil.woodWork("jlstb.png",0);
                    setTaskName(4);return;
                }
                if (jlssm){
                    jlssm = false;
                    gameUtil.woodWork("jlssm.png",0);
                    setTaskName(4);return;
                }
                if (ffjtb){
                    ffjtb = false;
                    gameUtil.woodWork("ffjtb.png",0);
                    setTaskName(4);return;
                }
                if (ffjsm){
                    ffjsm = false;
                    gameUtil.woodWork("ffjsm.png",0);
                    setTaskName(4);return;
                }
                if (sqqtb){
                    sqqtb = false;
                    gameUtil.woodWork("sqqtb.png",0);
                    setTaskName(4);return;
                }
                if (sqqsm){
                    sqqsm = false;
                    gameUtil.woodWork("sqqsm.png",0);
                    setTaskName(4);return;
                }
                if (cxwtb){
                    cxwtb = false;
                    gameUtil.woodWork("cxwtb.png",0);
                    setTaskName(4);return;
                }
                if (cxwsm){
                    cxwsm = false;
                    gameUtil.woodWork("cxwsm.png",0);
                    setTaskName(4);return;
                }
                if (lyxtb){
                    lyxtb = false;
                    gameUtil.woodWork("lyxtb.png",0);
                    setTaskName(4);return;
                }
                if (lyxsm){
                    lyxsm = false;
                    gameUtil.woodWork("lyxsm.png",0);
                    setTaskName(4);return;
                }
                if (zyytb){
                    zyytb = false;
                    gameUtil.woodWork("zyytb.png",0);
                    setTaskName(4);return;
                }
                if (zyysm){
                    zyysm = false;
                    gameUtil.woodWork("zyysm.png",0);
                    setTaskName(4);return;
                }
                if (hyjtb){
                    hyjtb = false;
                    gameUtil.woodWork("hyjtb.png",0);
                    setTaskName(4);return;
                }
                if (hyjsm){
                    hyjsm = false;
                    gameUtil.woodWork("hyjsm.png",0);
                    setTaskName(4);return;
                }

                if (ct){
                    ct = false;
                    gameUtil.woodWork("hull.png",0);
                    setTaskName(4);return;
                }
                if (mj){
                    mj = false;
                    gameUtil.woodWork("wood pulp.png",0);
                    setTaskName(4);return;
                }
                if (wg){
                    wg = false;
                    gameUtil.woodWork("mast.png",0);
                    setTaskName(4);return;
                }
                if (cf){
                    cf = false;
                    gameUtil.woodWork("Sail.png",0);
                    setTaskName(4);return;
                }
                if (cd){
                    cd = false;
                    gameUtil.woodWork("Ship lights.png",0);
                    setTaskName(4);return;
                }
                if (hyzj){
                    hyzj = false;
                    gameUtil.woodWork("Red leaf bracket.png",0);
                    setTaskName(4);return;
                }
                if (dxct){
                    dxct = false;
                    gameUtil.woodWork("Large Hull.png",0);
                    setTaskName(4);return;
                }
                if (chuand){
                    chuand = false;
                    gameUtil.woodWork("Top of ship.png",0);
                    setTaskName(4);return;
                }
                if (szgj){
                    szgj = false;
                    gameUtil.woodWork("Fan skeleton.png",0);
                    setTaskName(4);return;
                }
                if (sm){
                    sm = false;
                    gameUtil.woodWork("Fan.png",0);
                    setTaskName(4);return;
                }
                if (bzdzg){
                    bzdzg = false;
                    gameUtil.woodWork("Straight bamboo pole.png",0);
                    setTaskName(4);return;
                }
                if (zzdz){
                    zzdz = false;
                    gameUtil.woodWork("Zither.png",0);
                    setTaskName(4);return;
                }

                if (wj){
                    wj = false;
                    gameUtil.woodWork("wj.png",2);
                    setTaskName(4);return;
                }
                if (pzsz){
                    pzsz = false;
                    gameUtil.woodWork("pzsz.png",2);
                    setTaskName(4);return;
                }
                if (xgx){
                    xgx = false;
                    gameUtil.woodWork("xgx.png",2);
                    setTaskName(4);return;
                }
                if (lxst){
                    lxst = false;
                    gameUtil.woodWork("lxst.png",2);
                    setTaskName(4);return;
                }
                if (ljx){
                    ljx = false;
                    gameUtil.woodWork("ljx.png",2);
                    setTaskName(4);return;
                }
                if (bash){
                    bash = false;
                    gameUtil.woodWork("bash.png",2);
                    setTaskName(4);return;
                }
                if (yyxx){
                    yyxx = false;
                    gameUtil.woodWork("yyxx.png",2);
                    setTaskName(4);return;
                }
                if (hkyy){
                    hkyy = false;
                    gameUtil.woodWork("hkyy.png",2);
                    setTaskName(4);return;
                }
                if (mytj){
                    mytj = false;
                    gameUtil.woodWork("mytj.png",2);
                    setTaskName(4);return;
                }
                if (bycm){
                    bycm = false;
                    gameUtil.woodWork("bycm.png",2);
                    setTaskName(4);return;
                }
                if (zanjuan){
                    zanjuan = false;
                    gameUtil.woodWork("zanjuan.png",3);
                    setTaskName(4);return;
                }
                if (zanjujian){
                    zanjujian = false;
                    gameUtil.woodWork("zanjujian.png",3);
                    setTaskName(4);return;
                }
                if (zanjult){
                    zanjult = false;
                    gameUtil.woodWork("zanjult.png",3);
                    setTaskName(4);return;
                }
                if (zanjud){
                    zanjud = false;
                    gameUtil.woodWork("zanjud.png",3);
                    setTaskName(4);return;
                }
                if (zanjupx){
                    zanjupx = false;
                    gameUtil.woodWork("zanjupx.png",3);
                    setTaskName(4);return;
                }
                if (janjuan){
                    janjuan = false;
                    gameUtil.woodWork("janjuan.png",3);
                    setTaskName(4);return;
                }
                if (janjujian){
                    janjujian = false;
                    gameUtil.woodWork("janjujian.png",3);
                    setTaskName(4);return;
                }
                if (janjult){
                    janjult = false;
                    LtLog.e("l螺头");
                    gameUtil.woodWork("janjult.png",3);
                    setTaskName(4);return;
                }
                if (janjud){
                    janjud = false;
                    gameUtil.woodWork("janjud.png",3);
                    setTaskName(4);return;
                }
                if (janjupx){
                    janjupx = false;
                    gameUtil.woodWork("janjupx.png",3);
                    setTaskName(4);return;
                }
                if (jzzagj){
                    jzzagj = false;
                    gameUtil.woodWork("jzzagj.png",3);
                    setTaskName(4);return;
                }
                if (anjuan){
                    anjuan = false;
                    gameUtil.woodWork("anjuan.png",3);
                    setTaskName(4);return;
                }
                if (anjujian){
                    anjujian = false;
                    gameUtil.woodWork("anjujian.png",3);
                    setTaskName(4);return;
                }
                if (anjult){
                    anjult = false;
                    gameUtil.woodWork("anjult.png",3);
                    setTaskName(4);return;
                }
                if (anjud){
                    anjud = false;
                    gameUtil.woodWork("anjud.png",3);
                    setTaskName(4);return;
                }
                if (anjupx){
                    anjupx = false;
                    gameUtil.woodWork("anjupx.png",3);
                    setTaskName(4);return;
                }
                if (xwly){
                    xwly = false;
                    gameUtil.woodWork("xwly.png",4);
                    setTaskName(4);return;
                }
                if (yzhd){
                    yzhd = false;
                    gameUtil.woodWork("yzhd.png",4);
                    setTaskName(4);return;
                }
                if (syky){
                    syky = false;
                    gameUtil.woodWork("syky.png",4);
                    setTaskName(4);return;
                }
                if (xdl){
                    xdl = false;
                    gameUtil.woodWork("xdl.png",4);
                    setTaskName(4);return;
                }
                if (qph){
                    qph = false;
                    gameUtil.woodWork("qph.png",4);
                    setTaskName(4);return;
                }
                if (dqph) {
                    dqph = false;
                    gameUtil.woodWork("dqph.png", 4);
                    setTaskName(4);
                    return;
                }
                if (qwfan){
                    qwfan = false;
                    gameUtil.woodWork("qwFan.png",4);
                    setTaskName(4);return;
                }
                if (xxmg){
                    xxmg = false;
                    gameUtil.woodWork("xxmg.png",4);
                    setTaskName(4);return;
                }
                if (mtmg){
                    mtmg = false;
                    gameUtil.woodWork("mtmg.png",4);
                    setTaskName(4);return;
                }
                if (fife){
                    fife = false;
                    gameUtil.woodWork("Fife.png",4);
                    setTaskName(4);return;
                }
                if (zouzheng){
                    zouzheng = false;
                    gameUtil.woodWork("zouzheng.png",4);
                    setTaskName(4);return;
                }

                if (yzcw){
                    yzcw = false;
                    gameUtil.woodWork("yzcw.png",5);
                    setTaskName(4);return;
                }
                if (cjhy){
                    cjhy = false;
                    gameUtil.woodWork("cjhy.png",5);
                    setTaskName(4);return;
                }
                if (xrhx) {
                    xrhx = false;
                    gameUtil.woodWork("xrhx.png", 5);
                    setTaskName(4);
                    return;
                }
                if (mygx){
                    mygx = false;
                    gameUtil.woodWork("mygx.png",5);
                    setTaskName(4);return;
                }
                if (hts){
                    hts = false;
                    gameUtil.woodWork("hts.png",6);
                    setTaskName(4);return;
                }
                if (yzs){
                    yzs = false;
                    gameUtil.woodWork("yzs.png",6);
                    setTaskName(4);return;
                }
                if (axs){
                    axs = false;
                    gameUtil.woodWork("axs.png",6);
                    setTaskName(4);return;
                }
                if (yrs){
                    yrs = false;
                    gameUtil.woodWork("yrs.png",6);
                    setTaskName(4);return;
                }
                if (jls){
                    jls = false;
                    gameUtil.woodWork("jls.png",6);
                    setTaskName(4);return;
                }
                if (sqq){
                    sqq = false;
                    gameUtil.woodWork("sqq.png",6);
                    setTaskName(4);return;
                }
                if (cxw){
                    cxw = false;
                    gameUtil.woodWork("cxw.png",6);
                    setTaskName(4);return;
                }
                if (zyy){
                    zyy = false;
                    gameUtil.woodWork("zyy.png",6);
                    setTaskName(4);return;
                }
                if (ffj){
                    ffj = false;
                    gameUtil.woodWork("ffj.png",6);
                    setTaskName(4);return;
                }
                if (lyx){
                    lyx = false;
                    gameUtil.woodWork("lyx.png",6);
                    setTaskName(4);return;
                }
                if (hyj){
                    hyj = false;
                    gameUtil.woodWork("hyj.png",6);
                    setTaskName(4);return;
                }

                if (qd){
                    qd = false;
                    LtLog.e("=================================================================钱袋");
                    gameUtil.woodWork("Purse.png",7);
                    setTaskName(4);return;
                }
                if (nz){
                    nz = false;
                    gameUtil.woodWork("Beads.png",7);
                    setTaskName(4);return;
                }
                if (yz){
                    yz = false;
                    gameUtil.woodWork("seal.png",7);
                    setTaskName(4);return;
                }
                if (bzsl){
                    bzsl = false;
                    gameUtil.woodWork("Bracelet.png",7);
                    setTaskName(4);return;
                }
                if (lwmj){
                    lwmj = false;
                    gameUtil.woodWork("Wooden sword.png",7);
                    setTaskName(4);return;
                }
                if (cxs){
                    cxs = false;
                    gameUtil.woodWork("Cricket.png",7);
                    setTaskName(4);return;
                }
                if (mm){
                    mm = false;
                    gameUtil.woodWork("Trojan horse.png",7);
                    setTaskName(4);return;
                }
                if (qxw){
                    qxw = false;
                    gameUtil.woodWork("Qingxin pill.png",7);
                    setTaskName(4);return;
                }
                if (mgxx){
                    mgxx = false;
                    gameUtil.woodWork("Aromatherapy.png",7);
                    setTaskName(4);return;
                }
                if (bfjs){
                    bfjs = false;
                    gameUtil.woodWork("Art of war.png",7);
                    setTaskName(4);return;
                }
                if (zzpf){
                    zzpf = false;
                    gameUtil.woodWork("screen.png",7);
                    setTaskName(4);return;
                }
                if (spbt){
                    spbt = false;
                    gameUtil.woodWork("Pen container.png",7);
                    setTaskName(4);return;
                }
                if (cbh){
                    cbh = false;
                    gameUtil.woodWork("Straw weaving.png",7);
                    setTaskName(4);return;
                }
                if (jsbj){
                    jsbj = false;
                    gameUtil.woodWork("Ornament.png",7);
                    setTaskName(4);return;
                }
               if (err == 5) {
                   setTaskEnd();
                   return;
               }

            }
            public void content_4()throws Exception{
                long dazeTime=mFairy.mMatTime(1213,70,46,17,0.9f);
                result = mFairy.findPic("Make.png");
                mFairy.onTap(0.8f,result,"开始制作",2000);
                if (result.sim > 0.8f){
                    number2++;
                }
                result = mFairy.findPic("Study recipes.png");
                mFairy.onTap(0.8f,result,"研习配方",1000);
                result = mFairy.findPic(410,152,934,226,new String[]{"zzxuyao2.png","zzxuyao.png","Craftsman value.png","que.png"});
                if (result.sim >= 0.8f){
                   LtLog.e("缺少材料结束或者巧匠值不够或者没有配方");
                   number2=0;
                   setTaskName(3);return;
                }
                LtLog.e("========================================="+coord_x+"==================================number"+number2);
                if(number2 >=coord_x){
                    number2=0;
                    setTaskName(3);return;
                }
                result = mFairy.findPic(new String[]{"makegongyi.png","cooking.png","makequipment.png"});
                if (dazeTime >=300 && result.sim < 0.8f){
                    setTaskName(0);return;
                }
            }
        }.taskContent(mFairy,"工艺制作");
    }

    /**
     * 提升亲密度  闲谈
     */
    int tyu=0;
    public void  intimacy()throws Exception{
        new SingleTask(mFairy){
            boolean lt =false;
            boolean hzg =false;
            boolean lxy =false;
            boolean lsm =false;
            boolean lsq =false;
            boolean pagz =false;
            boolean lmf =false;
            boolean lqh =false;
            boolean jh =false;
            boolean lzr =false;
            boolean lq =false;
            boolean ner =false;
            boolean xly =false;
            boolean wm =false;
            boolean yc =false;
            boolean rqq =false;
            boolean rl =false;
            boolean tsxg =false;
            boolean mskk =false;
            boolean gzm =false;
            boolean ls =false;
            boolean mg =false;
            boolean qc =false;
            boolean lj =false;
            boolean jy =false;
            boolean ylb =false;
            boolean hjj =false;
            boolean jyy =false;
            boolean gj =false;
            boolean liuli =false;
            boolean lyz =false;
            boolean twj =false;
            boolean rxl =false;
            boolean yq =false;
            boolean fhms =false;
            boolean hwy =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("hzg").equals("1")){
                    hzg =true;
                }
                if (AtFairyConfig.getOption("lxy").equals("1")){
                    lxy =true;
                }
                if (AtFairyConfig.getOption("lsm").equals("1")){
                    lsm =true;
                }
                if (AtFairyConfig.getOption("lsq").equals("1")){
                    lsq =true;
                }
                if (AtFairyConfig.getOption("pagz").equals("1")){
                    pagz =true;
                }
                if (AtFairyConfig.getOption("lmf").equals("1")){
                    lmf =true;
                }
                if (AtFairyConfig.getOption("lqh").equals("1")){
                    lqh =true;
                }
                if (AtFairyConfig.getOption("jh").equals("1")){
                    jh =true;
                }
                if (AtFairyConfig.getOption("lzr").equals("1")){
                     lzr =true;
                }
                if (AtFairyConfig.getOption("lq").equals("1")){
                     lq =true;
                }
                if (AtFairyConfig.getOption("ner").equals("1")){
                    ner =true;
                }
                if (AtFairyConfig.getOption("xly").equals("1")){
                     xly =true;
                }
                if (AtFairyConfig.getOption("wm").equals("1")){
                    wm =true;
                }
                if (AtFairyConfig.getOption("yc").equals("1")){
                    yc =true;
                }
                if (AtFairyConfig.getOption("rqq").equals("1")){
                    rqq =true;
                }
                if (AtFairyConfig.getOption("rl").equals("1")){
                    rl =true;
                }
                if (AtFairyConfig.getOption("tsxg").equals("1")){
                    tsxg =true;
                }
                if (AtFairyConfig.getOption("mskk").equals("1")){
                    mskk =true;
                }
                if (AtFairyConfig.getOption("gzm").equals("1")){
                    gzm =true;
                }
                if (AtFairyConfig.getOption("ls").equals("1")){
                   ls =true;
                }
                if (AtFairyConfig.getOption("mg").equals("1")){
                    mg =true;
                }
                if (AtFairyConfig.getOption("qc").equals("1")){
                    qc =true;
                }
                if (AtFairyConfig.getOption("lj").equals("1")){
                    lj =true;
                }
                if (AtFairyConfig.getOption("jy").equals("1")){
                    jy =true;
                }
                if (AtFairyConfig.getOption("ylb").equals("1")){
                    ylb =true;
                }
                if (AtFairyConfig.getOption("hjj").equals("1")){
                    hjj =true;
                }
                if (AtFairyConfig.getOption("jyy").equals("1")){
                    jyy =true;
                }
                if (AtFairyConfig.getOption("gj").equals("1")){
                    gj =true;
                }
                if (AtFairyConfig.getOption("liuli").equals("1")){
                    liuli =true;
                }
                if (AtFairyConfig.getOption("lyz").equals("1")){
                    lyz =true;
                }
                if (AtFairyConfig.getOption("twj").equals("1")){
                    twj =true;
                }
                if (AtFairyConfig.getOption("rxl").equals("1")){
                    rxl =true;
                }
                if (AtFairyConfig.getOption("yq").equals("1")){
                    yq =true;
                }
                if (AtFairyConfig.getOption("fhms").equals("1")){
                    fhms =true;
                }
                if (AtFairyConfig.getOption("hwy").equals("1")){
                    hwy =true;
                }

            }
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            /**
             * 寻找任务并且前往
             * @throws Exception
             */
            public void content_1() throws Exception {
                if (overtime(8,0))return;
                if (!AtFairyConfig.getOption("lt").equals("1")){
                    LtLog.e("没有选择动作结束任务");
                    setTaskEnd();return;
                }

                //寻找任务并且前往
                if (hzg){

                    int ret =gameUtil.findnpc("HanZiGao.png",0);
                    if (ret==1){
                        hzg =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lxy){

                    int ret =gameUtil.findnpc("LingXueYao.png",0);
                    if (ret==1){
                        lxy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lsm){

                    int ret =gameUtil.findnpc("LiShiMin.png",0);
                    if (ret==1){
                        lsm=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lsq){

                    int ret =gameUtil.findnpc("LiShouQian.png",0);
                    if (ret==1){
                        lsq =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (pagz){

                    int ret =gameUtil.findnpc("PingAn.png",0);
                    if (ret==1){
                        pagz =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lmf){
                    int ret =gameUtil.findnpc("LiMuFan.png",0);
                    if (ret==1){
                        lmf=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lqh){

                    int ret =gameUtil.findnpc("LiQingHe.png",0);
                    if (ret==1){
                        lqh =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (jh){

                    int ret =gameUtil.findnpc("JingHuai.png",0);
                    if (ret==1){
                        jh=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lzr){

                    int ret =gameUtil.findnpc("LiuZhuiEr.png",0);
                    if (ret==1){
                        lzr=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lq){

                    int ret =gameUtil.findnpc("LiangQiu.png",0);
                    if (ret==1){
                        lq=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (ner){

                    int ret =gameUtil.findnpc("NingEr.png",0);
                    if (ret==1){
                        ner=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (xly){

                    int ret =gameUtil.findnpc("XieLingYue.png",0);
                    if (ret==1){
                        xly=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (wm){
                    int ret =gameUtil.findnpc("WuMing.png",1);
                    if (ret==1){
                        wm=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (yc){

                    int ret =gameUtil.findnpc("YunChu.png",1);
                    if (ret==1){
                        yc=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (rqq){

                    int ret =gameUtil.findnpc("RenQianQian.png",1);
                    if (ret==1){
                        rqq=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (rl){

                    int ret =gameUtil.findnpc("RuoLi.png",1);
                    if (ret==1){
                        rl=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (tsxg){

                    int ret =gameUtil.findnpc("TianShui.png",1);
                    if (ret==1){
                        tsxg=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (mskk){

                    int ret =gameUtil.findnpc("MiaoShou.png",1);
                    if (ret==1){
                        mskk=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (gzm){
                    int ret =gameUtil.findnpc("GongZiMei.png",1);
                    if (ret==1){
                        gzm=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (ls){
                    int ret =gameUtil.findnpc("LingShuang.png",1);
                    if (ret==1){
                        ls=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (mg){

                    int ret =gameUtil.findnpc("MoGong.png",1);
                    if (ret==1){
                        mg=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (qc){

                    int ret =gameUtil.findnpc("QingCi.png",1);
                    if (ret==1){
                        qc=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lj){

                    int ret =gameUtil.findnpc("LiJi.png",1);
                    if (ret==1){
                        lj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (jy){

                    int ret =gameUtil.findnpc("JianYi.png",1);
                    if (ret==1){
                        jy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (ylb){

                    int ret =gameUtil.findnpc("YanLiBen.png",1);
                    if (ret==1){
                        ylb=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (hjj){

                    int ret =gameUtil.findnpc("HouJunJi.png",1);
                    if (ret==1){
                        hjj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (jyy){

                    int ret =gameUtil.findnpc("JiangYuYan.png",1);
                    if (ret==1){
                        jyy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (gj){

                    int ret =gameUtil.findnpc("GuiJian.png",1);
                    if (ret==1){
                        gj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (liuli){

                    int ret =gameUtil.findnpc("LiuLi.png",1);
                    if (ret==1){
                        liuli=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lyz){

                    int ret =gameUtil.findnpc("LiuYingZe.png",1);
                    if (ret==1){
                        lyz=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (twj){

                    int ret =gameUtil.findnpc("TongWuJi.png",1);
                    if (ret==1){
                        twj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (rxl){

                    int ret =gameUtil.findnpc("RuoXiaoLan.png",1);
                    if (ret==1){
                        rxl=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (yq){

                    int ret =gameUtil.findnpc("YaQie.png",1);
                    if (ret==1){
                        yq=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (fhms){

                    int ret =gameUtil.findnpc("FuHu.png",1);
                    if (ret==1){
                        fhms=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (hwy){
                    int ret =gameUtil.findnpc("HuaWuYi.png",1);
                    if (ret==1){
                        hwy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }

                if (err ==7){
                    setTaskEnd();return;
                }
            }
            public void content_2()throws Exception{
                //if (overtime(200,0))return;
                long dazeTime=mFairy.mMatTime(1205,54,26,12,0.9f);

                result = mFairy.findPic("Return.png");
                mFairy.onTap(0.75f, result, "返回", Sleep);

                result = mFairy.findPic(934,223,1250,604,"visit2.png");
                mFairy.onTap(0.75f, result, "拜访", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(4,2,178,55,"Acquaintance.png");
                if(result.sim>0.8f){
                    LtLog.e("npc界面");
                    setTaskName(3);return;
                }
                if (dazeTime >= 120 && result.sim < 0.8f){

                    setTaskName(0);return;
                }

            }
            public void content_3()throws Exception{
                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(951,281,1162,566,"Chatting.png");
                mFairy.onTap(0.8f,result,"闲谈",2000);

                result = mFairy.findPic(new String[]{"liao.png","liao2.png"});
                mFairy.onTap(0.8f,result,"npc聊天",1000);
                result = mFairy.findPic(210,78,749,667,"Tired.png");
                if (result.sim > 0.7f){
                    LtLog.e("聊天次数没了");
                    setTaskName(0);
                    return;
                }
            }

        }.taskContent(mFairy,"提升亲密度.闲谈");
    }

    /**
     * 提升亲密度 送礼
     */
    public void  giveGift()throws Exception{
        new SingleTask(mFairy){
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (AtFairyConfig.getOption("hzgsl").equals("1")){
                    int ret =gameUtil.findnpc("HanZiGao.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lxysl").equals("1")){
                    int ret =gameUtil.findnpc("LingXueYao.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }




                if (AtFairyConfig.getOption("lsmsl").equals("1")){
                    int ret =gameUtil.findnpc("LiShiMin.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }

                if (AtFairyConfig.getOption("lsqsl").equals("1")){
                    int ret =gameUtil.findnpc("LiShouQian.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }




                if (AtFairyConfig.getOption("pagzsl").equals("1")){
                    int ret =gameUtil.findnpc("PingAn.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lmfsl").equals("1")){
                    int ret =gameUtil.findnpc("LiMuFan.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lqhsl").equals("1")){
                    int ret =gameUtil.findnpc("LiQingHe.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("jhsl").equals("1")){
                    int ret =gameUtil.findnpc("JingHuai.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lzrsl").equals("1")){
                    int ret =gameUtil.findnpc("LiuZhuiEr.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lqsl").equals("1")){
                    int ret =gameUtil.findnpc("LiangQiu.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("nersl").equals("1")){
                    int ret =gameUtil.findnpc("NingEr.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("xlysl").equals("1")){
                    int ret =gameUtil.findnpc("XieLingYue.png",0);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("wmsl").equals("1")){
                    int ret =gameUtil.findnpc("WuMing.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }

                if (AtFairyConfig.getOption("ycsl").equals("1")){
                    int ret =gameUtil.findnpc("YunChu.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("rqqsl").equals("1")){
                    int ret =gameUtil.findnpc("RenQianQian.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("rlsl").equals("1")){
                    int ret =gameUtil.findnpc("RuoLi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("tsxgsl").equals("1")){
                    int ret =gameUtil.findnpc("TianShui.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("mskksl").equals("1")){
                    int ret =gameUtil.findnpc("MiaoShou.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("gzmsl").equals("1")){
                    int ret =gameUtil.findnpc("GongZiMei.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lssl").equals("1")){
                    int ret =gameUtil.findnpc("LingShuang.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("mgsl").equals("1")){
                    int ret =gameUtil.findnpc("MoGong.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }



                if (AtFairyConfig.getOption("qcsl").equals("1")){
                    int ret =gameUtil.findnpc("QingCi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("ljsl").equals("1")){
                    int ret =gameUtil.findnpc("LiJi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("jysl").equals("1")){
                    int ret =gameUtil.findnpc("JianYi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("ylbsl").equals("1")){
                    int ret =gameUtil.findnpc("YanLiBen.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("hjjsl").equals("1")){
                    int ret =gameUtil.findnpc("HouJunJi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("jyysl").equals("1")){
                    int ret =gameUtil.findnpc("JiangYuYan.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("gjsl").equals("1")){
                    int ret =gameUtil.findnpc("GuiJian.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("liulisl").equals("1")){
                    int ret =gameUtil.findnpc("LiuLi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("lyzsl").equals("1")){
                    int ret =gameUtil.findnpc("LiuYingZe.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("twjsl").equals("1")){
                    int ret =gameUtil.findnpc("TongWuJi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("rxlsl").equals("1")){
                    int ret =gameUtil.findnpc("RuoXiaoLan.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("yqsl").equals("1")){
                    int ret =gameUtil.findnpc("YaQie.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("fhmssl").equals("1")){
                    int ret =gameUtil.findnpc("FuHu.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }


                if (AtFairyConfig.getOption("hwysl").equals("1")){
                    int ret =gameUtil.findnpc("HuaWuYi.png",1);
                    if (ret==1){
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }

            }
            public void content_2()throws Exception{
                //if (overtime(200,0))return;
                long dazeTime=mFairy.mMatTime(1205,54,26,12,0.9f);

                result = mFairy.findPic("Return.png");
                mFairy.onTap(0.75f, result, "返回", Sleep);

                result = mFairy.findPic(934,223,1250,604,"visit2.png");
                mFairy.onTap(0.75f, result, "拜访", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(4,2,178,55,"Acquaintance.png");
                if(result.sim>0.8f){
                    LtLog.e("npc界面");
                    setTaskName(4);return;
                }
                if (dazeTime >= 200 && result.sim < 0.8f){

                    setTaskName(0);return;
                }

            }
            public void content_4()throws Exception{
                mFairy.sleep(2000);
                result = mFairy.findPic(951,281,1162,566,"Gift giving.png");
                mFairy.onTap(0.75f, result, "送礼", Sleep);

                result = mFairy.findPic(1090,109,1232,576,"Give.png");
                mFairy.onTap(0.8f,result,"赠送",2000);
                if (result.sim <0.8f){
                    mFairy.touchDown(1057,522);
                    mFairy.touchMove(1057,160,1000);
                    mFairy.touchUp();
                }else {
                    err =0;
                }
                if (overtime(20, 0)) return;//计次并跳转
                if (err ==19){
                 setTaskEnd();return;
                }
            }
        }.taskContent(mFairy,"提升亲密度.送礼");
    }

    /**
     *  提升亲密度  切磋
     */
    public void  duel()throws Exception{
        new SingleTask(mFairy){
            boolean hzg =false;
            boolean lxy =false;
            boolean lsm =false;
            boolean lsq =false;
            boolean pagz =false;
            boolean lmf =false;
            boolean lqh =false;
            boolean jh =false;
            boolean lzr =false;
            boolean lq =false;
            boolean ner =false;
            boolean xly =false;
            boolean wm =false;
            boolean yc =false;
            boolean rqq =false;
            boolean rl =false;
            boolean tsxg =false;
            boolean mskk =false;
            boolean gzm =false;
            boolean ls =false;
            boolean mg =false;
            boolean qc =false;
            boolean lj =false;
            boolean jy =false;
            boolean ylb =false;
            boolean hjj =false;
            boolean jyy =false;
            boolean gj =false;
            boolean liuli =false;
            boolean lyz =false;
            boolean twj =false;
            boolean rxl =false;
            boolean yq =false;
            boolean fhms =false;
            boolean hwy =false;
            public void create() throws Exception {
                if (AtFairyConfig.getOption("hzgqc").equals("1")){
                    hzg =true;
                }
                if (AtFairyConfig.getOption("lxyqc").equals("1")){
                    lxy =true;
                }
                if (AtFairyConfig.getOption("lsmqc").equals("1")){
                    lsm =true;
                }
                if (AtFairyConfig.getOption("lsqqc").equals("1")){
                    lsq =true;
                }
                if (AtFairyConfig.getOption("pagzqc").equals("1")){
                    pagz =true;
                }
                if (AtFairyConfig.getOption("lmfqc").equals("1")){
                    lmf =true;
                }
                if (AtFairyConfig.getOption("lqhqc").equals("1")){
                    lqh =true;
                }
                if (AtFairyConfig.getOption("jhqc").equals("1")){
                    jh =true;
                }
                if (AtFairyConfig.getOption("lzrqc").equals("1")){
                    lzr =true;
                }
                if (AtFairyConfig.getOption("lqqc").equals("1")){
                    lq =true;
                }
                if (AtFairyConfig.getOption("nerqc").equals("1")){
                    ner =true;
                }
                if (AtFairyConfig.getOption("xlyqc").equals("1")){
                    xly =true;
                }
                if (AtFairyConfig.getOption("wmqc").equals("1")){
                    wm =true;
                }
                if (AtFairyConfig.getOption("ycqc").equals("1")){
                    yc =true;
                }
                if (AtFairyConfig.getOption("rqqqc").equals("1")){
                    rqq =true;
                }
                if (AtFairyConfig.getOption("rlqc").equals("1")){
                    rl =true;
                }
                if (AtFairyConfig.getOption("tsxgqc").equals("1")){
                    tsxg =true;
                }
                if (AtFairyConfig.getOption("mskkqc").equals("1")){
                    mskk =true;
                }
                if (AtFairyConfig.getOption("gzmqc").equals("1")){
                    gzm =true;
                }
                if (AtFairyConfig.getOption("lsqc").equals("1")){
                    ls =true;
                }
                if (AtFairyConfig.getOption("mgqc").equals("1")){
                    mg =true;
                }
                if (AtFairyConfig.getOption("qcqc").equals("1")){
                    qc =true;
                }
                if (AtFairyConfig.getOption("ljqc").equals("1")){
                    lj =true;
                }
                if (AtFairyConfig.getOption("jyqc").equals("1")){
                    jy =true;
                }
                if (AtFairyConfig.getOption("ylbqc").equals("1")){
                    ylb =true;
                }
                if (AtFairyConfig.getOption("hjjqc").equals("1")){
                    hjj =true;
                }
                if (AtFairyConfig.getOption("jyyqc").equals("1")){
                    jyy =true;
                }
                if (AtFairyConfig.getOption("gjqc").equals("1")){
                    gj =true;
                }
                if (AtFairyConfig.getOption("liuliqc").equals("1")){
                    liuli =true;
                }
                if (AtFairyConfig.getOption("lyzqc").equals("1")){
                    lyz =true;
                }
                if (AtFairyConfig.getOption("twjqc").equals("1")){
                    twj =true;
                }
                if (AtFairyConfig.getOption("rxlqc").equals("1")){
                    rxl =true;
                }
                if (AtFairyConfig.getOption("yqqc").equals("1")){
                    yq =true;
                }
                if (AtFairyConfig.getOption("fhmsqc").equals("1")){
                    fhms =true;
                }
                if (AtFairyConfig.getOption("hwyqc").equals("1")){
                    hwy =true;
                }

            }
            /**
             * 调用工具类初始化接任务
             * @throws Exception
             */
            public void content_0() throws Exception {
                gameUtil.close();
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(8,0))return;
                //寻找任务并且前往
                if (hzg){
                    int ret =gameUtil.findnpc("HanZiGao.png",0);
                    if (ret==1){
                        hzg =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lxy){

                    int ret =gameUtil.findnpc("LingXueYao.png",0);
                    if (ret==1){
                        lxy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lsm){

                    int ret =gameUtil.findnpc("LiShiMin.png",0);
                    if (ret==1){
                        lsm=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lsq){

                    int ret =gameUtil.findnpc("LiShouQian.png",0);
                    if (ret==1){
                        lsq =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (pagz){

                    int ret =gameUtil.findnpc("PingAn.png",0);
                    if (ret==1){
                        pagz =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lmf){
                    int ret =gameUtil.findnpc("LiMuFan.png",0);
                    if (ret==1){
                        lmf=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lqh){

                    int ret =gameUtil.findnpc("LiQingHe.png",0);
                    if (ret==1){
                        lqh =false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (jh){

                    int ret =gameUtil.findnpc("JingHuai.png",0);
                    if (ret==1){
                        jh=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lzr){

                    int ret =gameUtil.findnpc("LiuZhuiEr.png",0);
                    if (ret==1){
                        lzr=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lq){

                    int ret =gameUtil.findnpc("LiangQiu.png",0);
                    if (ret==1){
                        lq=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (ner){

                    int ret =gameUtil.findnpc("NingEr.png",0);
                    if (ret==1){
                        ner=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (xly){

                    int ret =gameUtil.findnpc("XieLingYue.png",0);
                    if (ret==1){
                        xly=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (wm){
                    int ret =gameUtil.findnpc("WuMing.png",1);
                    if (ret==1){
                        wm=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (yc){

                    int ret =gameUtil.findnpc("YunChu.png",1);
                    if (ret==1){
                        yc=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (rqq){

                    int ret =gameUtil.findnpc("RenQianQian.png",1);
                    if (ret==1){
                        rqq=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (rl){

                    int ret =gameUtil.findnpc("RuoLi.png",1);
                    if (ret==1){
                        rl=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (tsxg){

                    int ret =gameUtil.findnpc("TianShui.png",1);
                    if (ret==1){
                        tsxg=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (mskk){

                    int ret =gameUtil.findnpc("MiaoShou.png",1);
                    if (ret==1){
                        mskk=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (gzm){
                    int ret =gameUtil.findnpc("GongZiMei.png",1);
                    if (ret==1){
                        gzm=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (ls){
                    int ret =gameUtil.findnpc("LingShuang.png",1);
                    if (ret==1){
                        ls=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (mg){

                    int ret =gameUtil.findnpc("MoGong.png",1);
                    if (ret==1){
                        mg=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (qc){

                    int ret =gameUtil.findnpc("QingCi.png",1);
                    if (ret==1){
                        qc=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lj){

                    int ret =gameUtil.findnpc("LiJi.png",1);
                    if (ret==1){
                        lj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (jy){

                    int ret =gameUtil.findnpc("JianYi.png",1);
                    if (ret==1){
                        jy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (ylb){

                    int ret =gameUtil.findnpc("YanLiBen.png",1);
                    if (ret==1){
                        ylb=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (hjj){

                    int ret =gameUtil.findnpc("HouJunJi.png",1);
                    if (ret==1){
                        hjj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (jyy){

                    int ret =gameUtil.findnpc("JiangYuYan.png",1);
                    if (ret==1){
                        jyy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (gj){

                    int ret =gameUtil.findnpc("GuiJian.png",1);
                    if (ret==1){
                        gj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (liuli){

                    int ret =gameUtil.findnpc("LiuLi.png",1);
                    if (ret==1){
                        liuli=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (lyz){

                    int ret =gameUtil.findnpc("LiuYingZe.png",1);
                    if (ret==1){
                        lyz=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (twj){

                    int ret =gameUtil.findnpc("TongWuJi.png",1);
                    if (ret==1){
                        twj=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (rxl){

                    int ret =gameUtil.findnpc("RuoXiaoLan.png",1);
                    if (ret==1){
                        rxl=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (yq){

                    int ret =gameUtil.findnpc("YaQie.png",1);
                    if (ret==1){
                        yq=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (fhms){

                    int ret =gameUtil.findnpc("FuHu.png",1);
                    if (ret==1){
                        fhms=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }
                if (hwy){
                    int ret =gameUtil.findnpc("HuaWuYi.png",1);
                    if (ret==1){
                        hwy=false;
                        setTaskName(2);return;
                    }else {
                        LtLog.e("没找到npc");
                        setTaskEnd();return;
                    }
                }

                if (err ==7){
                    setTaskEnd();return;
                }
            }
            public void content_2()throws  Exception {
                //if (overtime(200,0))return;
                long dazeTime=mFairy.mMatTime(1205,54,26,12,0.9f);

                result = mFairy.findPic("Return.png");
                mFairy.onTap(0.75f, result, "返回", Sleep);

                result = mFairy.findPic(934,223,1250,604,"visit2.png");
                mFairy.onTap(0.75f, result, "拜访", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic(4,2,178,55,"Acquaintance.png");
                if(result.sim>0.8f){
                    LtLog.e("npc界面");
                    setTaskName(4);return;
                }
                if (dazeTime >= 200 && result.sim < 0.8f){

                    setTaskName(0);return;
                }

            }
            public void content_4()throws  Exception{
                result = mFairy.findPic(951,281,1162,566,"Duel.png");
                mFairy.onTap(0.75f, result, "切磋", Sleep);

                result = mFairy.findPic(905,193,1180,431,"Planning.png");
                mFairy.onTap(0.75f, result, "筹算", Sleep);
                if (result.sim > 0.8f){
                    setTaskName(5);return;
                }
                result = mFairy.findPic(905,193,1180,431,"Animal fighting chess.png");
                mFairy.onTap(0.75f, result, "斗兽棋", Sleep);
                if (result.sim > 0.8f){
                    setTaskName(6);return;
                }
                result = mFairy.findPic(905,193,1180,431,"Decor.png");
                mFairy.onTap(0.75f, result, "大话色", Sleep);
                if (result.sim > 0.8f){
                    setTaskName(7);return;
                }
                if (overtime(16, 0)) return;//计次并跳转

            }
            public void content_5()throws  Exception{
               // mFairy.sleep(1500);
                LtLog.e("********************筹算***********************");
                result = mFairy.findPic(951,281,1162,566,"Duel.png");
                mFairy.onTap(0.75f, result, "切磋", Sleep);

                result = mFairy.findPic(905,193,1180,431,"Planning.png");
                mFairy.onTap(0.75f, result, "筹算", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic("Explain.png");
                mFairy.onTap(0.8f,result,1135,78,1156,110,"关闭",2000);

                result = mFairy.findPic("Planning begin.png");
                mFairy.onTap(0.75f, result, "筹算开始", Sleep);

//                result = mFairy.findPic("rule.png");
//                mFairy.onTap(0.75f, result, "筹算开始", Sleep);

                result = mFairy.findPic(327,511,956,646,new String[]{"Planning one.png","Planning two.png","Planning three.png","Planning four.png","Planning five.png","Planning six.png","Planning seven.png","Planning eight.png","Planning nine.png"});
                mFairy.onTap(0.75f, result, "放数字", Sleep);

                result = mFairy.findPic(464,378,791,669,"leave cs.png");
                mFairy.onTap(0.75f, result, "离开", Sleep);

                result = mFairy.findPic(210,78,749,667,"Tired.png");
                if (result.sim > 0.7f){
                    LtLog.e("筹算次数没了");
                    setTaskName(0);
                    return;
                }
            }
            public void content_6()throws  Exception{
                LtLog.e("*****************斗兽棋*****************");
                result = mFairy.findPic(951,281,1162,566,"Duel.png");
                mFairy.onTap(0.75f, result, "切磋", Sleep);

                result = mFairy.findPic(905,193,1180,431,"Animal fighting chess.png");
                mFairy.onTap(0.75f, result, "斗兽棋", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic("Explain.png");
                mFairy.onTap(0.8f,result,1135,78,1156,110,"关闭",2000);

                result = mFairy.findPic(476,370,810,573,"Planning begin.png");
                mFairy.onTap(0.8f, result, "斗兽棋开始", Sleep);

                result1 = mFairy.findPic("rule.png");
                result = mFairy.findPic(224,122,1032,512,"Turn Qi.png");
                mFairy.onTap(0.8f, result, "翻旗", Sleep);
                if(result.sim < 0.8f && result1.sim > 0.8f) {
                    result = mFairy.findPic(277, 116, 1031, 517, "xq.png");// 606,455  722,447  342,446
                    mFairy.onTap(0.8f, result, "走位", Sleep);
                    mFairy.onTap(0.8f, result,result.x+122,result.y+1,result.x+123,result.y+2, "走位", Sleep);
                    mFairy.onTap(0.8f, result, result.x-222,result.y-2,result.x-221,result.y-1,"走位", Sleep);
                }
                result = mFairy.findPic("dsq leave.png");
                mFairy.onTap(0.75f, result, "离开", Sleep);

                result = mFairy.findPic(210,78,749,667,"Tired.png");
                if (result.sim > 0.7f){
                    LtLog.e("次数没了");
                    setTaskName(0);
                    return;
                }

            }
            public void content_7()throws  Exception{
                LtLog.e("*********************大话色***********************");
                result = mFairy.findPic(951,281,1162,566,"Duel.png");
                mFairy.onTap(0.75f, result, "切磋", Sleep);

                result = mFairy.findPic(905,193,1180,431,"Decor.png");
                mFairy.onTap(0.75f, result, "大话色", Sleep);

                result = mFairy.findPic("Closing the conversation.png");
                mFairy.onTap(0.75f, result, "结束对话", Sleep);

                result = mFairy.findPic("Explain.png");
                mFairy.onTap(0.8f,result,1135,78,1156,110,"关闭",2000);

                result = mFairy.findPic(476,370,810,573,"Planning begin.png");
                mFairy.onTap(0.75f, result, "大话色开始", Sleep);

                result = mFairy.findPic("believe it.png");
                mFairy.onTap(0.75f, result, "不信", Sleep);

                result = mFairy.findPic("dhs yes.png");
                mFairy.onTap(0.75f, result, "确定", Sleep);

                result = mFairy.findPic(464,378,791,669,"leave cs.png");
                mFairy.onTap(0.75f, result, "离开", Sleep);

                result = mFairy.findPic(210,78,749,667,"Tired.png");
                if (result.sim > 0.7f){
                    LtLog.e("次数没了");
                    setTaskName(0);
                    return;
                }
            }
        }.taskContent(mFairy,"提升亲密度.切磋");
    }
}

