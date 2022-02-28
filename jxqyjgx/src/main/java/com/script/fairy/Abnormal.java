package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.FindResult;

/**
 * Created by Administrator on 2019/3/22 0022.
 */

public class Abnormal extends TaskContent {
    AtFairyImpl mFairy;
    FindResult result;
    FindResult result1;

    public Abnormal(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;

    }

   /* public String CMD(String[] mString) {
        Context mContext = mFairy.getContext();
        Runtime cmd = Runtime.getRuntime();
        String inline = "";
        String header = "";
        try {
            Process p = cmd.exec(mString);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while ((inline = br.readLine()) != null) {
                String mStr = inline;
                if ( mStr.contains("CPU")|| mStr.contains("cpu")) {
                    header = mStr;
                    if(sb.length() > 0) {

                         sb.delete(0, sb.length());
                    }
                    continue;
                   // LtLog.i("haha123: " + mFairy.getLineInfo("============================") + mStr);
                }



                if(mStr.contains(mContext.getPackageName())){
//                    sb.append(inline);
                    LtLog.i("CPU USAGE-INFO-HEADER : "  + header);
                    LtLog.i("CPU USAGE-INFO-BODY   : "  + mStr);
                }

//                }
            }
            inline = br.readLine();
            br.close();
            p.waitFor();

        } catch (Exception e) {

        }
        return inline;
    }*/
    //全局处理
    public void erro() throws Exception {
        result = mFairy.findPic("shanhfinish.png");
        mFairy .onTap(0.8f,result,622,517,638,525,"完成商会任务",2000);
        //LtLog.e( "-----------"+CMD(new String[]{"top"/*, "-m", "10", "-n", "1"*/})+"---------------");
        //CMD(new String[]{"top", "-m", "10", "-n", "1"});
        result = mFairy.findPic("red bag.png");
        mFairy.onTap(0.8f,result,"err红包",Sleep);

        result = mFairy.findPic("blessing.png");
        mFairy.onTap(0.8f,result,"err祝福",Sleep);

        result = mFairy.findPic("blessingdown.png");
        mFairy.onTap(0.8f,result,1010,141,1024,150,"err已祝福关闭",Sleep);

        result = mFairy.findPic("nowfuhuo.png");
        mFairy.onTap(0.8f,result,"err立即复活",Sleep);

        result = mFairy.findPic("ascend the stairs.png");
        mFairy.onTap(0.8f,result,"err立即升阶",Sleep);

        result = mFairy.findPic("consume.png");
        mFairy.onTap(0.8f,result,796,465,808,473,"err升阶消耗",Sleep);

        result = mFairy.findPic("shengjie.png");
        mFairy.onTap(0.8f,result,"err升阶完成",Sleep);

        result = mFairy.findPic("set.png");
        mFairy.onTap(0.8f,result,"err镶嵌",Sleep);

        result = mFairy.findPic("equipment.png");
        mFairy.onTap(0.8f,result,"err装备",Sleep);

        result = mFairy.findPic(new String[]{"use.png","use2.png"});
        mFairy.onTap(0.8f,result,"err使用",2000);

        result = mFairy.findPic("xianshi.png");
        mFairy.onTap(0.8f,result,515,464,524,470,"err关闭限时提醒",Sleep);

        result = mFairy.findPic("repair.png");
        mFairy.onTap(0.8f,result,"err修理",2000);
        mFairy.onTap(0.8f,result,740,460,753,466,"err确定修理",2000);

        result = mFairy.findPic("advertisement.png");
        mFairy.onTap(0.8f,result,"err关闭广告",Sleep);

        result = mFairy.findPic(new String[]{"start-up.png","start-up2.png"});
        mFairy.onTap(0.8f,result,"err启动游戏",Sleep);

        result = mFairy.findPic("Notice.png");
        mFairy.onTap(0.8f,result,1062,110,1069,121,"err公告关闭",Sleep);

        result = mFairy.findPic("agerr.png");
        mFairy.onTap(0.8f,result,"err同意腾讯隐私保护",Sleep);

        result = mFairy.findPic("resources.png");
        mFairy.onTap(0.8f,result,634,458,648,466,"err资源下载完毕",Sleep);

        result = mFairy.findPic("QQlogin.png");
        mFairy.onTap(0.8f,result,"errQQ登陆",Sleep);

        result = mFairy.findPic(110,913,594,1246,new String[]{"authorization.png","authorization2.png"});
        mFairy.onTap(0.8f,result,"errQQ登陆授权",Sleep);

        result = mFairy.findPic(new String[]{"authorization3.png","authorization4.png"});
        mFairy.onTap(0.8f,result,"err完成QQ登陆授权",Sleep);

        result = mFairy.findPic("login.png");
        mFairy.onTap(0.8f,result,"err登陆游戏",2000);

        result = mFairy.findPic("begin2.png");
        mFairy.onTap(0.8f,result,"err开始游戏",Sleep);

        result = mFairy.findPic("new sure.png");
        mFairy.onTap(0.8f, result, "err新版qq隐私政策同意", Sleep);

        result = mFairy.findPic("new authorization.png");
        mFairy.onTap(0.8f, result, "err新版qq授权", Sleep);

        result = mFairy.findPic(new String[]{"new login.png","new login2.png","new login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", Sleep);

        result = mFairy.findPic("xinyong.png");
        mFairy.onTap(0.8f,result,669,483,681,490,"err信用分确定",Sleep);

        result = mFairy.findPic("te.png");
        mFairy.onTap(0.8f,result,640,409,649,416,"err七夕特殊窗口",Sleep);

        result = mFairy.findPic(396,174,911,449,"mapcs.png");
        mFairy .onTap(0.8f,result,749,470,760,478,"确定地图传送",5000);

        result1 = mFairy.findPic("ljkaiqi.png");
        mFairy .onTap(0.8f,result1,629,523,642,537,"err开启",3000);

        result = mFairy.findPic("yes.png");
        mFairy .onTap(0.8f,result,"err确定",2000);

        result = mFairy.findPic("egg.png");
        mFairy .onTap(0.8f,result,526,462,537,473,"err取消七夕任务弹窗",2000);

        result = mFairy.findPic("Reconnection.png");
        mFairy .onTap(0.8f,result,533,463,542,471,"返回登陆",2000);
    }


}
