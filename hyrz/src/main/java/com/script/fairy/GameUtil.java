package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

import java.util.List;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class GameUtil extends TaskContent{
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;
    FindResult result2;

    public GameUtil(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
    }
    public  void close()throws Exception{
        for (int i=0;i<2;i++){
            mFairy.condit();
            result = mFairy.findPic( 564,36,997,339,new String[]{"fork1.png","fork.png"});
            mFairy.onTap(0.8f,result, "叉1", 1000);
            if (result.sim>0.8f){
                i=0;
            }

            List<FindResult> list = mFairy.findPic( 676,11,1271,312,0.8f,"fork.png");
            if(list.size()!=0){
                i=0;
                for(int n=0;n<list.size();n++){
                    result=list.get(n);
                    mFairy.onTap(0.8f,result, "叉", 1000);
                }
            }

            list = mFairy.findPic( 676,11,1271,312,0.8f,"fork1.png");
            if(list.size()!=0){
                i=0;
                for(int n=0;n<list.size();n++){
                    result=list.get(n);
                    mFairy.onTap(0.8f,result, "叉1", 1000);
                }
            }

            result = mFairy.findPic(303, 290, 1271, 709, new String[]{"zmsure.png", "sure1.png", "sure2.png"});
            mFairy.onTap(0.8f, result, "err确定", 100);
            if (result.sim>0.8f){
                i=0;
            }
        }
    }

}
