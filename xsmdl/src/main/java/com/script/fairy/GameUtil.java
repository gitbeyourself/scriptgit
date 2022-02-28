package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;
    FindResult result3;
    FindResult result4;
    int tastState;
    long fadTime = 0L;
    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }

    /**
     * * 活动初始化
     * @throws Exception
     */
    public void init() throws Exception {
        result = mFairy.findPic("zidong.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result,737,614,749,621, "自动攻击关闭", 2000);
        }
        result = mFairy.findPic(new String[]{"close66.png","closes6.png","closes7.png","closes8.png","YinglinHall_close.png","Secret_close.png","offs3.png","yous2.png","right_close.png"});
        mFairy.onTap(0.8f, result,"活动关闭右", 1000);
        result = mFairy.findPic("into.png");
        if(result.sim>0.8f){

        }else{
            result = mFairy.findPic(new String[]{"lefts1.png"});
            mFairy.onTap(0.8f, result,"活动关闭左", 1000);
        }

        result = mFairy.findPic("change.png");
        mFairy.onTap(0.8f, result,1160,38,1181,62,"关闭", 2000);
        result = mFairy.findPic("ok000.png");
        if(result.sim>0.8f){
            mFairy.onTap(0.8f, result, 633,444,678,466,"确定", 1000);
        }
        result = mFairy.findPic("activitys1.png");
        if(result.sim>0.8f){
            setTaskName(1);
            return;
        }
        result = mFairy.findPic("shis1.png");
        if(result.sim>0.8f){
            result = mFairy.findPic(new String[]{"rights2.png"});
            mFairy.onTap(0.8f, result,"右关闭", 1000);
        }
    }


    public int mission(final String str, final int option) throws Exception {
        new GameUtil(mFairy) {
            int findtask = 0;
            /**
             * content_0流程控制
             * @throws Exception
             */
            public  void content_0() throws Exception {
                LtLog.e("=====================================findtask"+findtask);
                if (findtask >= 2) {
                    LtLog.e("没有这个任务");
                    GameUtil.this.tastState = 0;
                    setTaskEnd();
                }
               init();
            }
            /**
             * 打开日常并且寻找任务
             */

            public  void content_1() throws Exception {
                if (overtime(8, 0)) return;
                result = mFairy.findPic("activitys1.png");
                result1 = mFairy.findPic(414,109,893,296,"cishu.png");
                result2 = mFairy.findPic("zidongss3.png");
                    if (result1.sim<0.8f&&result2.sim>0.9f){
                        if(result.sim>0.8f){
                            mFairy.onTap(0.8f, result,"活动进入", 5000);
                        }
                    }

                result = mFairy.findPic("huodongs1.png");
                if (result.sim > 0.8f) {
                    Thread.sleep(1000);
                    mFairy.condit();
                    result = mFairy.findPic(117,135,1092,527,str);
                    if (result.sim > 0.8f) {

                    } else {
                        if (option == 0){
                            mFairy.onTap(270,97,322,126, "日常活动", Sleep);
                        }
                        if (option == 1) {
                            mFairy.onTap(400,100,447,123, "限时", Sleep);
                        }
                        if (option == 2) {
                            mFairy.onTap(522,98,583,122, "挑战", Sleep);
                        }
                        if(option == 3){
                            mFairy.onTap(652,102,708,123, "休闲", Sleep);
                        }
                    }
                    findtask++;
                    if (findtask > 2){
                        setTaskName(0);
                    }
                    setTaskName(2);
                }
            }
            /***
             * str对应任务名称，周到并判断任务是否完成
             * @throws Exception
             */
            public void content_2() throws Exception {
                result = mFairy.findPic(508,621,1086,649,"Receives1.png");
                if(result.sim>0.85f){
                    mFairy.onTap(0.8f,result,result.x-20, result.y -87, result.x +12, result.y -58,"领取活跃值奖励",2000);//571,638  551,551,583,580
                }

                result1 = mFairy.findPic(127,139,1089,525,str);
                LtLog.e("*****************str****"+result.sim);
                if (result1.sim >= 0.8f) {
                    result = mFairy.findPic(result1.x + 200, result1.y -16, result1.x +341, result1.y +33, "joins3.png");

                    String werewolf="Lion.png";
                    if(werewolf==str){
                        result2 = mFairy.findPic(result1.x + 279, result1.y -62, result1.x +300, result1.y +63,"ones1.png");//744,163  1023,201,1044,226
                        LtLog.e("/*******/"+(result1.x+279)+","+(result1.y-62)+","+(result1.x+300)+","+(result1.y+63));
                        if(result2.sim>0.8f && result.sim<0.8f){
                            LtLog.e("***********hello");
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;

                        }
                        result3 = mFairy.findPic(result1.x + 39, result1.y +36, result1.x +83, result1.y +66,"twos5.png");//744,163  783,199,827,229
                        LtLog.e("/*******/"+(result1.x+39)+","+(result1.y+36)+","+(result1.x+83)+","+(result1.y+66));
                        if(result3.sim>0.8f&&result2.sim<0.8f){
                            LtLog.e("****************2/2");
                            GameUtil.this.tastState = 0;
                            setTaskEnd();
                            return;
                        }
                    }
                    mFairy.onTap(0.8f, result, "参与", 2000);
//                    result4 = mFairy.findPic(138,137,1084,528,"jieshou.png");
                    result4 = mFairy.findPic(result1.x + 200, result1.y -16, result1.x +341, result1.y +33, "jieshou.png");
                    LtLog.e("************result*****"+result.sim);
                    LtLog.e("************result4*****"+result4.sim);
//                    result2 = mFairy.findPic(result1.x + 200, result1.y -16, result1.x +341, result1.y +33, "accept.png");
                    if (result.sim >= 0.8f||result4.sim>=0.8f) {
                        LtLog.e("*******************参与");
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 1;
                        setTaskEnd();
                        return;
                    }
                    if(result.sim<0.8f&&result4.sim<0.8f){
                        LtLog.e("***************找不到参与");
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                    result = mFairy.findPic(result1.x + 200, result1.y -16, result1.x +341, result1.y +33, "Finish.png");
                    LtLog.e("************完成*****"+result.sim);
                    if (result.sim >= 0.8f ) {
                        LtLog.e("*******************完成");
                        mFairy.initMatTime();
                        GameUtil.this.tastState = 0;
                        setTaskEnd();
                        return;
                    }
                }
                mFairy.taskSlid(err, new int[]{0, 2, 4, 6,8}, 0, 536,456,453,165,  2000, 1500);
                if (overtime(10, 0)) return;//计次并跳转
            }
        }.taskContent(mFairy, "找任务中");
        return tastState;
    }


    //发呆超时
    public long dazeTime()throws Exception{
        if(fadTime!=0L){
            //自动寻路中
//            result=mFairy.findPic(625,470,655,527,"word way.png");
//            if(result.sim>0.8){
//                LtLog.e(mFairy.getLineInfo("自动寻路中"));
//                initDaze();
//                return 0L;
//            }
//            //传送
//            result=mFairy.findPic(new String[]{"pic load.png","pic transfer.png"});
//            if(result.sim>0.8f){
//                LtLog.e(mFairy.getLineInfo("地图传送中"));
//                initDaze();
//                return 0L;
//            }
//            //战斗加载
//            result=mFairy.findPic(new String[]{"pic fight load.png"});
//            if(result.sim>0.8f){
//                LtLog.e(mFairy.getLineInfo("战斗加载中"));
//                initDaze();
//                return 0L;
//            }
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
}
