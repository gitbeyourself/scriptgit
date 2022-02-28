package com.script.fairy;


import com.script.framework.AtFairyImpl;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;


/**
 * Created by Administrator on 2019/3/22 0022.
 */
public class Abnormal {
    AtFairyImpl mFairy;
    FindResult result;
    PublicFunction publicFunction;
    GamePublicFuntion gamePublicFuntion;
    private int login = 1;
    public static boolean HONG = false;
    public Abnormal(AtFairyImpl atFairy) throws Exception {
        mFairy = atFairy;
        publicFunction = new PublicFunction(mFairy);
        gamePublicFuntion = new GamePublicFuntion(mFairy);

        if(!AtFairyConfig.getOption("login").equals("")){
            login=Integer.parseInt(AtFairyConfig.getOption("login"));
        }

        if(AtFairyConfig.getOption("hong").equals("1")){
            HONG=true;
        }
    }

    public void erro() throws Exception {

        result = mFairy.findPic("chakan.png");
        mFairy.onTap(0.85f, result, "前往查看", 2000);
        mFairy.onTap(0.85f, result, 1226,23,1240,34,"前往查看关闭", 2000);

        result = mFairy.findPic("use2.png");
        mFairy.onTap(0.85f, result, "使用", 1000);

        result = mFairy.findPic("jia2.png");
        mFairy.onTap(0.85f, result, 1228,21,1248,47,"关闭超级巨星", 1000);

        result= mFairy.findPic("beiman.png");
        mFairy.onTap(0.8f,result,617,431,656,446,"背包空间不足",500);

        result = mFairy.findPic(79,435,613,1244, "qqlogin1.png");
        mFairy.onTap(0.85f, result, "errQQ登录重新获取", 1000);

        result = mFairy.findPic(654,314,829,557,"gengxin.png");
        mFairy.onTap(0.85f, result, "立刻更新", 1000);

        result = mFairy.findPic( 559,332,721,580,"chongqi.png");
        mFairy.onTap(0.85f, result, "确定退出 - 重启", 1000);

        result = mFairy.findPic(583,273,862,387, "lianjie.png");
        mFairy.onTap(0.85f, result,714,430,740,444, "err 继续连接服务器", 1000);

        result = mFairy.findPic(79,435,613,1244, "qqlogin.png");
        mFairy.onTap(0.85f, result, "errQQ登录", 1000);

        result = mFairy.findPic("erryp.png");
        mFairy.onTap(0.85f, result, "err云派启动", 1000);

        result = mFairy.findPic("err4.png");
        mFairy.onTap(0.85f, result, "无法获取经验", 500);

        result = mFairy.findPic("err3.png");
        mFairy.onTap(0.85f, result, 621,430,652,444,"腾讯信用", 1000);

        result = mFairy.findPic("fanhui.png");
        mFairy.onTap(0.85f, result, "err返回游戏", 1000);

        result = mFairy.findPic("xuan.png");
        mFairy.onTap(0.85f,result,1024,116,1052,135,"选择方案",500);

        result = mFairy.findPic("xuan2.png");
        mFairy.onTap(0.85f,result,1027,125,1038,137,"活动介绍",500);

        result = mFairy.findPic("errmap.png");
        if(result.sim>0.85f) {
            mFairy.onTap(1218,30,1248,42,"地图引导",2000);
            mFairy.onTap(1175,614,1205,645,"",1000);
            mFairy.onTap(1216,18,1245,45,"",500);
        }

        result = mFairy.findPic("zhidao.png");
        mFairy.onTap(0.85f, result, "err知道了", 1000);

        result = mFairy.findPic("wifi.png");
        mFairy.onTap(0.85f, result, 709,429,746,447,"确定下载", 1000);

        result = mFairy.findPic("chatBox.png");
        mFairy.onTap(0.85f, result, "err 聊天窗口", 1000);

        result = mFairy.findPic("tongguo.png");
        mFairy.onTap(0.85f, result, 624,433,662,446,"通过", 1000);

        result = mFairy.findPic("chong.png");
        mFairy.onTap(0.85f, result, 1208,44,1234,62,"err 充值界面", 1000);

        if(HONG) {
            result = mFairy.findPic(new String[]{"hong1.png","hong4.png","hong6.png"});
            if(result.sim>0.8f) {
                mFairy.onTap(0.8f, result, "err 红包", 800);
                TaskContent.err=0;
            }
        }

        result = mFairy.findPic(451,179,854,658,"hong3.png");
        if(result.sim>0.8f) {
            mFairy.onTap(0.8f, result, "err 红包>>打开", 200);
            TaskContent.err=0;
        }

        result = mFairy.findPic(new String[]{"hong2.png","hong5.png"});
        if(result.sim>0.8f) {
            mFairy.onTap(0.8f, result, "err 红包>>打开", 200);
            TaskContent.err=0;
        }

        result = mFairy.findPic("ok2.png");
        mFairy.onTap(0.85f, result, "err 确认2", 1000);

        result = mFairy.findPic(250,370,440,482,"xiazai4.png");
        if(result.sim>0.85f){
            result = mFairy.findPic(249,398,1023,582,"xiazai5.png");
            mFairy.onTap(0.85f, result,"err 隐藏下载界面", 1000);
        }


        result = mFairy.findPic("zoom.png");
        mFairy.onTap(0.85f, result, "err 聊天窗口", 1000);

        result = mFairy.findPic("err1.png");
        mFairy.onTap(0.85f, result, 618,430,651,442,"err 卡顿", 300);

        result = mFairy.findPic(561,405,726,689,"zhidao1.png");
        mFairy.onTap(0.85f, result, "err知道了 游戏介绍", 1000);

        result = mFairy.findPic(134, 742, 572, 1129, "qqlogin2.png");
        mFairy.onTap(0.85f, result, "errQQ登录授权登录", 2000);

        result = mFairy.findPic(134, 742, 572, 1129, "qqShouQuan.png");
        mFairy.onTap(0.85f, result, "errQQ登录授权登录", 2000);

        result = mFairy.findPic(98,475,640,952,"wx1.png");
        mFairy.onTap(0.85f, result, "err微信同意", 1000);

        result = mFairy.findPic("new sure.png");
        mFairy.onTap(0.8f, result, "err新版qq隐私政策同意", 1000);

        result = mFairy.findPic("new authorization.png");
        mFairy.onTap(0.8f, result, "err新版qq授权", 1000);

        result = mFairy.findPic(new String[]{"new login.png","new login2.png","new login3.png"});
        mFairy.onTap(0.8f, result, "err新版qq登陆", 1000);

        result = mFairy.findPic("tongyi1.png");
        mFairy.onTap(0.85f, result, "err 获取服务1", 300);

        result = mFairy.findPic("tongyi2.png");
        mFairy.onTap(0.85f, result, "err 获取服务2", 300);

        result = mFairy.findPic("tongyi4.png");
        mFairy.onTap(0.85f, result, "err 获取服务2", 300);

        result = mFairy.findPic("QQ.png");
        if(result.sim>0.85f){
            result = mFairy.findPic("tongyi3.png");
            mFairy.onTap(0.85f, result, "err 同意许可证", 300);
        }

        result = mFairy.findPic(337,296,643,645,"xaizai.png");
        mFairy.onTap(0.85f, result, "err 开始下载", 1000);

        result = mFairy.findPic(399,340,670,584,"err2.png");
        mFairy.onTap(0.85f, result, "err 知道了", 1000);

        result = mFairy.findPic(558,270,717,645,"xaizai2.png");
        mFairy.onTap(0.85f, result, "err 隐藏界面", 1000);

        if(TaskMain.QHBOOLS==false) {
            result = mFairy.findPic(337, 296, 643, 645, "xaizai1.png");
            if (result.sim < 0.85f) {
                result = mFairy.findPic("kaishi.png");
                mFairy.onTap(0.85f, result, "err 开始", 1000);
            }
        }

        FindResult r2 = mFairy.findPic("login1.png");
        if(r2.sim>0.85f){
            result = mFairy.findPic("tongyi3.png");
            mFairy.onTap(0.85f, result, "err 同意许可证", 500);

            mFairy.onTap(0.85f, r2, 1089,505,1118,537,"err 进入游戏", 300);
        }

        switch (login){
            case 1:
                result = mFairy.findPic("QQ.png");
                mFairy.onTap(0.85f, result, "err QQ登录", 1000);
                break;
            case 2:
                result = mFairy.findPic("WX.png");
                mFairy.onTap(0.85f, result, "err WX登录", 1000);
                break;
        }




    }
}