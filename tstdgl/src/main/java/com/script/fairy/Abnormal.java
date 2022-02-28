package com.script.fairy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    GameUtil gameUtil;
    AtFairyImpl mFairy;
    FindResult result;

    int x=0;

    public Abnormal(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;

    }

    int count_1 = 0;
    long i = 0;
    String task_id = AtFairyConfig.getOption("task_id");

    //全局处理
    public void erro() throws Exception {

        result = mFairy.findPic(252,510,1170,684,"dengru.png");
        mFairy.onTap( 0.8f, result,"err登入", 10000);

        result = mFairy.findPic(294,153,987,575,"qd.png");//迁马
        mFairy.onTap( 0.8f, result,"err奖励确定", 500);

        result = mFairy.findPic(269,519,1172,687,"guoqiao.png");//
        mFairy.onTap( 0.8f, result,"直接过桥！", Sleep);


    }

}
