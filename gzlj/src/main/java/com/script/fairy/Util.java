package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Util extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    static long fadTime = 0L;//发呆总时长
    public Util(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
    }

    //回大厅
    public void close(String info)throws Exception{
        new Util(mFairy){
            boolean increa=true;
            int closeNum=5,task_id;//关闭的次数

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

                result=mFairy.findPic("pic return.png");
                mFairy.onTap(0.8f,result,"返回",1000);
                if(result.sim>0.8f&&increa){
                    increa=false;
                    closeNum=5;
                }

                result=mFairy.findPic("word btn cancel.png");
                mFairy.onTap(0.8f,result,"取消",1000);

                result=mFairy.findPic("word btn close.png");
                mFairy.onTap(0.8f,result,"关闭",1000);

                result=mFairy.findPic("pic failed.png");
                mFairy.onTap(0.8f,result,1078,654,1087,661,"战斗失败，前往主页",1000);

                if(closeNum==1){
                    result=mFairy.findPic(0,0,1280,720,"pic guide arrows.png");
                    mFairy.onTap(0.9f,result,result.x+2,result.y+89,result.x+9,result.y+97,"arrows指引",1000);

                    result=mFairy.findPic("pic main interface.png");
                    if(result.sim<0.8f)mFairy.onTap(1274,710,1277,714,"点击关闭",1000);
                }
            }
        }.taskContent(mFairy,info+"关闭");
    }

    //发呆超时
    public long dazeTime()throws Exception{
        if(fadTime!=0L){
            //自动寻路中
            result=mFairy.findMultiColor(1000,45,1128,50,0.95f,"93,57,15",
                    "-14|7|93,65,24&2|7|93,57,15&19|7|101,69,31&-11|19|93,57,15&3|19|93,57,15&16|19|93,57,15&-15|32|93,57,15&2|32|93,57,15&20|32|93,57,15");
            if(result.sim>0.9){
                initDaze("connecting(连接中)...");
                return 0L;
            }

            //战斗加载
            result=mFairy.findPic(1092,612,1122,676,"word load-l.png");
            if(result.sim>0.8f){
                initDaze("now loading(加载中)...");
                return 0L;
            }

            //战斗
            result=mFairy.findPic(new String[]{"word wave.png"});
            if(result.sim>0.9f){
                initDaze("wave (战斗中)...");
                return 0L;
            }

            long dazeTime=System.currentTimeMillis()/ 1000L;//获取现在时间
            dazeTime=dazeTime-fadTime;// 发呆时长=现在-之前
            LtLog.e(mFairy.getLineInfo("发呆时间dazeTime="+dazeTime));
            return dazeTime;
        }else{
            fadTime=System.currentTimeMillis() / 1000L;//获取当前时间
            return  0L;
        }
    }

    //初始化发呆
    public long initDaze (String info)throws Exception{
        LtLog.e(mFairy.getLineInfo("initDaze--"+info));
        fadTime=0L;
        return  fadTime;
    }
    //初始化发呆
    public long initDaze()throws Exception{
        fadTime=0L;
        return  fadTime;
    }

    //初始化画面设置
    public void initPicture()throws Exception{

    }

    public void onTap(float sim, FindResult result, String string, long time)throws Exception{
        mFairy.onTap(sim,result,string,time);
        if(result.sim>sim)initDaze(string);
    }

    //自适应点击
    public void customTop(float sim, FindResult result, String string)throws Exception{

    }

    static int tastState = 0;
}
