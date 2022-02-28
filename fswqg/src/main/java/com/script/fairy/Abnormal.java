package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal  {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    int task_id;
    Util util=new Util(mFairy);
    static boolean tap=true;
    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

        task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
    }

    //全局处理
    public void erro() throws Exception {
        if(tap){
            result=mFairy.findPic(517,543,701,716,"word tap.png");
            mFairy.onTap(0.6f,result,971,690,982,699,"点击空白关闭",1000);

            result=mFairy.findPic("word tap1.png");
            mFairy.onTap(0.8f,result,971,690,982,699,"点击空白关闭",1000);
        }


        result=mFairy.findPic("word story.png");
        mFairy.onTap(0.8f,result,"跳过剧情",1000);

        result=mFairy.findPic(1119,16,1230,51,"pic btn continue.png");
        mFairy.onTap(0.8f,result,"跳过对话",1000);
        if(result.sim>0.8f)util.initDaze();

        result=mFairy.findPic(new String[]{"pic dialogue.png","pic dialogue1.png"});
        mFairy.onTap(0.8f,result,"跳过对话",500);
        if(result.sim>0.8f)util.initDaze();

        result=mFairy.findPic(new String[]{"pic dialogue2.png","pic dialogue3.png"});
        result1=mFairy.findMultiColor(830,504,890,534,
                0.9f,"107,138,161","6|0|107,137,161&8|0|106,138,160&13|0|109,139,161&18|0|119,148,177&20|2|140,172,200&20|4|136,167,197&22|4|140,170,194&22|5|142,173,197&22|6|143,173,199");
        if(result1.sim<0.8f){
            mFairy.onTap(0.8f,result,"跳过对话",500);
            if(result.sim>0.8f)util.initDaze();
        }

        result=mFairy.findPic("pic btn continue1.png");
        mFairy.onTap(0.8f,result,"跳过剧情加载",1000);

        result=mFairy.findPic("word select it.png");
        mFairy.onTap(0.8f,result,981,364,999,380,"普通画质",1000);
        mFairy.onTap(0.8f,result,"选择画质",1000);

        result=mFairy.findMultiColor(562,462,716,493,0.95,"170,179,179",
                "0|4|174,184,183&-5|8|193,189,187&7|8|190,186,183&-4|18|170,166,164&2|18|180,177,176&17|0|223,224,224&23|6|237,237,237&118|16|156,147,147&124|16|155,137,137");
        mFairy.onTap(0.8f,result,"退出省电模式_findMult",1000);

        result=mFairy.findPic(new String[]{"word sheng.png","word sheng1.png"});
        mFairy.onTap(0.75f,result,"退出省电模式",1000);
	}
}
