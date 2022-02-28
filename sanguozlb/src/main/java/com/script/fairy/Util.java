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
            int closeNum=5;
            @Override
            public void content_0() throws Exception {
                LtLog.e(mFairy.getLineInfo("closeNum="+closeNum));
                //关闭5次
                if(--closeNum<=0){
                    LtLog.e(mFairy.getLineInfo("关闭结束"));
                    setTaskEnd();
                }

                result=mFairy.findPic(849,186,924,261,"pic close.png");
                mFairy.onTap(0.8f,result,"关闭",1000);

                result=mFairy.findPic("word hint.png");
                if(closeNum%2==1){
                    mFairy.onTap(0.8f,result,746,469,756,479,"取消",1000);
                }else{
                    mFairy.onTap(0.8f,result,511,465,522,475,"确认",1000);
                }

                //关闭
                List<FindResult> resultList = mFairy.findPic(1029, 7, 1273, 151, 0.8f, "pic close.png");
                if(resultList.size()!=0){
                    closeNum=5;
                    while(resultList.size()>0){
                        result=resultList.get(0);
                        resultList.remove(0);
                        mFairy.onTap(0.8f,result,"关闭",1000);
                    }
                }

                //返回
                result=mFairy.findPic(1162,4,1275,62,new String[]{"word return.png","word return1.png"});
                int picCount=picCount(0.8f,result,"close");
                if(picCount==1)closeNum=5;
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,1229,36,1234,42,"返回",1000);
                }
            }
        }.taskContent(mFairy,"关闭");
    }

    //镜头恢复 1镜头恢复 2放大
    public void resize(int type) throws Exception{
        //按住一个点，另一个点从右往左
        mFairy.touchDown(0,165,403);
        if(type==1){
            LtLog.e(mFairy.getLineInfo("镜头恢复 缩小"));
            mFairy.touchDown(1,1150,450);
            mFairy.touchMove(1,750,450,500);
        }
        if(type==2){
            LtLog.e(mFairy.getLineInfo("镜头恢复 放大"));
            mFairy.touchDown(1,750,450);
            mFairy.touchMove(1,1150,450,500);
        }
        mFairy.touchUp(0);
        mFairy.touchUp(1);
    }

    //前往坐标
    public void coord(final String coordStr)throws Exception{
        new Util(mFairy){
            @Override
            public void create() throws Exception {
                setTaskName(1);
            }

            @Override
            public void content_0() throws Exception {
                close();
                setTaskName(1);
                step=1;
            }

            int step=1;
            @Override
            public void content_1() throws Exception {
                result=mFairy.findPic("word map.png");
                mFairy.onTap(0.8f,result,"打开地图",1000);

                //输入第一个坐标
                if(step==1){
                    result=mFairy.findPic("pic coord.png");
                    mFairy.onTap(0.8f,result,result.x+20,result.y,result.x+21,result.y+1,"打开X坐标",1000);

                    //输入坐标
                    result=mFairy.findPic("word btn finish.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,70,106,71,107,"全选1",50);
                        mFairy.onTap(0.8f,result,70,106,71,107,"全选2",50);
                        mFairy.inputText(coordStr.split(",")[0]);
                        mFairy.sleep(1000);
                    }
                }

                //输入第二个坐标
                if(step==2){
                    result=mFairy.findPic(1043,527,1069,564,"pic coord.png");
                    mFairy.onTap(0.8f,result,result.x+20,result.y,result.x+21,result.y+1,"打开Y坐标",1000);

                    //输入坐标
                    result=mFairy.findPic("word btn finish.png");
                    if(result.sim>0.8f){
                        mFairy.onTap(0.8f,result,70,106,71,107,"全选1",50);
                        mFairy.onTap(0.8f,result,70,106,71,107,"全选2",50);
                        mFairy.inputText(coordStr.split(",")[1]);
                        mFairy.sleep(1000);
                    }
                }

                result=mFairy.findPic(1153,165,1223,212,"word btn finish.png");
                if(result.sim>0.8f){
                    mFairy.onTap(0.8f,result,"输入第"+step+"个坐标完成",1000);
                    step++;
                }

                if(step==3){
                    result=mFairy.findPic("word btn map go.png");
                    mFairy.onTap(0.8f,result,"前往",1000);

                    result=mFairy.findPic("word btn task.png");
                    if(result.sim>0.8f){
                        LtLog.e(mFairy.getLineInfo("前往坐标"+coordStr+"完成"));
                        setTaskEnd();
                        return;
                    }
                }
                overtime(20,0);
            }
        }.taskContent(mFairy,"前往指定坐标");
    }

    //回城
    public void back_city()throws Exception{
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
                result=mFairy.findPic("word btn task.png");
                int picCount = picCount(0.8f, result, "btn task");
                if(picCount==1){
                    mFairy.onTap(0.8f,result,1080,104,1092,114,"切换部队分页",1000);
                    mFairy.onTap(0.8f,result,1197,101,1207,114,"切换地标分页",1000);
                }

                if(picCount>1){
                    result=mFairy.findPic("word team.png");
                    mFairy.onTap(0.8f,result,"选中主城",1000);

                    result=mFairy.findPic("word btn enter city.png");
                    mFairy.onTap(0.8f,result,"入城",1000);
                }


                result=mFairy.findPic("word city build.png");
                if(result.sim>0.8f){
                    LtLog.e(mFairy.getLineInfo("已经回到城中"));
                    setTaskEnd();
                    return;
                }
                overtime(10,0);
            }
        }.taskContent(mFairy,"回城");

    }
}
