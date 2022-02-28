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

    public GameUtil(AtFairyImpl ATFairy) throws Exception {
        mFairy = ATFairy;
        Sleep = 1000;
        SleepWhile = 200;
    }

    public void inOperation() throws Exception {
        result = mFairy.findPic("guotu.png");
        if (result.sim > 0.8f) {
            LtLog.e(mFairy.getLineInfo("过图中"));
            err = 0;
        }
        for (int i = 0; i < 1; i++) {
            result = mFairy.findPic("Dialogbox.png");
            mFairy.onTap(0.8f, result, result.x, result.y + 50, result.x + 1, result.y + 51, "对话框", Sleep);
            if (result.sim > 0.8f) {
                err = 0;
                i = 0;
            }
        }
        result = mFairy.findPic("death.png");
        if (result.sim > 0.8f) {
            err = 0;
        }
    }

    public void close(final int close) throws Exception {
        new GameUtil(mFairy) {
            int j = 1;

            public void content_0() throws Exception {
                for (int i = 0; i < 2; i++) {
                    mFairy.condit();
                    result = mFairy.findPic(395, 14, 1262, 360, new String[]{"fork.png","fork1.png","fork6.png","fork7.png","fork2.png","fork3.png","fork4.png","fork8.png","fork9.png"});
                    mFairy.onTap(0.9f, result, "叉", 1500);

                    result = mFairy.findPic(707,56,854,173, "yqs.png");
                    mFairy.onTap(0.8f, result, 918,79,936,103,"摇钱树误开关闭", Sleep);

                    result = mFairy.findPic("return1.png");
                    mFairy.onTap(0.8f, result, "返回", Sleep);

                    result = mFairy.findPic("fbcomplete.png");
                    mFairy.onTap(0.8f, result, "副本完成", Sleep);

                    result = mFairy.findPic(205, 375, 1131, 644, "Copylottery.png");
                    mFairy.onTap(0.8f, result, "副本奖励", Sleep);

                    result = mFairy.findPic("zhankai.png");
                    mFairy.onTap(0.8f, result, "展开扩展栏", Sleep);

                    result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                    if (result.sim > 0.8f) {
                        setTaskEnd();
                        return;
                    }
                }
                setTaskEnd();
            }
        }.taskContent(mFairy, "-----------------------------------关叉中");
    }

    //清包
    public void clearbag() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(8, 0)){
                    close(0);
                    setTaskEnd();
                    return;
                }
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(327,72,957,647,"qbStrengthen.png");
                mFairy.onTap(0.8f, result, "强化", Sleep);

                result = mFairy.findPic(720,571,959,699,"qbChoice.png");
                mFairy.onTap(0.8f, result, "智能选择", Sleep);
                mFairy.onTap(0.8f, result, 817, 505, 818, 506, "橙色以下", Sleep);
                mFairy.onTap(0.8f, result, 1052, 551, 1053, 552, "强化10级", Sleep);
                mFairy.onTap(0.8f, result, 1035, 641, 1036, 642, "强化", Sleep);
                if (result.sim > 0.8f) {
                    close(0);
                    setTaskEnd();
                    return;
                }
            }

        }.taskContent(mFairy, "--清包中");
    }

    //去指定地图
    public void backCity(final  int mapnum, final int num) throws Exception {
        new GameUtil(mFairy) {
            int ditu = 0;
            String str;

            public void create() throws Exception {
                str = map(mapnum, num);
            }
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);return;
            }

            public void content_1() throws Exception {
                if (overtime(6, 0)) return;

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);


                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
               // LtLog.e("===="+result.sim);
                if (result.sim > 0.8f) {
                    err=0;
                    for (int i = 1; i < 25; i++) {

                        mFairy.condit();
                        result = mFairy.findPic("dt" + i + ".png");
                        LtLog.e("====="+result.sim);
                        LtLog.e(mFairy.getLineInfo(0.75f, result, "dt" + i + ".png===="));
                        if (result.sim > 0.75f) {
                            ditu = i;
                            break;
                        }
                    }
                    if (ditu == mapnum) {
                        LtLog.e(mFairy.getLineInfo("在同一个地图，直接去怪物地点"));
                        setTaskName(4);return;
                    } else {
                        LtLog.e(mFairy.getLineInfo("不在同一个地图，开启传送机制"));
                        close(0);
                        setTaskName(2);return;
                    }
                }

            }

            public void content_2() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(903, 41, 1162, 246, new String[]{"HangUpin.png", "HangUpin1.png"});
                mFairy.onTap(0.8f, result, "挂机中取消", Sleep);

                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);


                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                mFairy.onTap(0.8f, result, "地图界面", Sleep);

                result = mFairy.findPic("Mapworld.png");
                if (result.sim > 0.8f) {
                    err=0;
                    tapMap(mapnum, num);
                    Thread.sleep(3000);
                    mFairy.condit();
                    result = mFairy.findPic("OverGraph.png");
                    mFairy.onTap(0.8f, result,   536, 451, 537, 452,"过图提醒", 2000);

                    result = mFairy.findPic(373, 271, 907, 392,"Delivery.png");
                    mFairy.onTap(0.8f, result, 538, 454,539, 455,"传送确定", Sleep);

                    if (result.sim > 0.8f) {
                        Thread.sleep(8000);
                        setTaskName(3);return;
                    } else {
                        setTaskName(0);return;
                    }
                }
            }
            public void content_3() throws Exception {
                if (overtime(6, 0)) return;
                result = mFairy.findPic(688,2,1274,173,"jj3.png");
                mFairy.onTap(0.8f, result, "收起", Sleep);

                result = mFairy.findPic("jj2.png");
                mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);


                result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                if (result.sim > 0.8f) {
                    err=0;
                    for (int i = 1; i < 25; i++) {
                        mFairy.condit();
                        result = mFairy.findPic("dt" + i + ".png");
                        LtLog.e(mFairy.getLineInfo(0.75f, result, "dt" + i + ".png"));
                        if (result.sim > 0.75f) {
                            ditu = i;
                            break;
                        }
                    }
                    if (ditu == mapnum) {
                        LtLog.e(mFairy.getLineInfo("在同一个地图，直接去怪物地点"));
                        setTaskName(4);return;
                    } else {
                        for (int i = 0; i < 5; i++) {
                            mFairy.condit();
                            LtLog.e(mFairy.getLineInfo("还不在同一个地图，去上个地图的安全区吧"));
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            mFairy.onTap(0.8f, result, 1085, 195, 1086, 196, "地图界面", 2000);
                            result = mFairy.findPic(688,2,1274,173,"jj3.png");
                            mFairy.onTap(0.8f, result, "收起", Sleep);

                            result = mFairy.findPic("jj2.png");
                            mFairy.onTap(0.8f, result, 1199, 87, 1200, 88, "点击地图", Sleep);

                            if (result.sim > 0.8f) {
                                break;
                            }
                        }
                        for (int i = 0; i < 50; i++) {
                            mFairy.condit();
                            result = mFairy.findPic(108,546,366,703,"mapInterface.png");
                            LtLog.e(mFairy.getLineInfo(0.9f, result, "地图界面"));
                            if (result.sim < 0.9f) {
                                break;
                            }
                            Thread.sleep(2000);
                        }

                        setTaskName(2);return;
                    }
                }

            }
            public void content_4() throws Exception {
               close(0);
               setTaskEnd();return;
            }
        }.taskContent(mFairy, "去指定地图中");
    }

    //获取地图
    public String map(int mapnum, int num) throws Exception {
        String str = "";
        if ((mapnum / num) == 1) {
            str = "苏州";
        }
        if ((mapnum / num) == 2) {
            str = "万劫谷";
        }
        if ((mapnum / num) == 3) {
            str = "无量山";
        }
        if ((mapnum / num) == 4) {
            str = "洱海";
        }
        if ((mapnum / num) == 5) {
            str = "燕子坞";
        }
        if ((mapnum / num) == 6) {
            str = "小镜湖";
        }
        if ((mapnum / num) == 7) {
            str = "杏子林";
        }
        if ((mapnum / num) == 8) {
            str = "聚贤庄";
        }
        if ((mapnum / num) == 9) {
            str = "丐帮";
        }
        if ((mapnum / num) == 10) {
            str = "少室山";
        }
        if ((mapnum / num) == 11) {
            str = "雁门关野外";
        }
        if ((mapnum / num) == 12) {
            str = "敦煌";
        }
        if ((mapnum / num) == 13) {
            str = "唐门";
        }
        if ((mapnum / num) == 14) {
            str = "雪原";
        }
        if ((mapnum / num) == 15) {
            str = "峨嵋山";
        }
        if ((mapnum / num) == 16) {
            str = "楼兰";
        }
        if ((mapnum / num) == 17) {
            str = "星宿草海";
        }
        if ((mapnum / num) == 18) {
            str = "光明顶";
        }
        if ((mapnum / num) == 19) {
            str = "缥缈峰";
        }
        if ((mapnum / num) == 20) {
            str = "琅嬛福地";
        }
        if ((mapnum / num) == 21) {
            str = "秦皇地宫1";
        }
        if ((mapnum / num) == 22) {
            str = "秦皇地宫2";
        }
        if ((mapnum / num) == 23) {
            str = "秦皇地宫3";
        }
        if ((mapnum / num) == 24) {
            str = "玄武岛";
        }
        return str;
    }

    //点地图坐标
    public void tapMap(int mapnum, int num) throws   Exception {
        String str = "";
        LtLog.e("下滑动1");
        mFairy.ranSwipe(624,163, 624,583, 500, (long) 1000, 3);
        mFairy.ranSwipe(624,163, 624,583, 500, (long) 1000, 2);
        LtLog.e("滑动2");
        mFairy.ranSwipe(388,462, 488,462, 500, (long) 1500, 3);
        if ((mapnum / num) == 1) {
            mFairy.tap(694,397);
            str = "苏州";
        }
        if ((mapnum / num) == 2) {
            mFairy.tap(753,620);
            str = "万劫谷";
        }
        if ((mapnum / num) == 3) {
            mFairy.tap(764,568);
            str = "无量山";
        }
        if ((mapnum / num) == 4) {
            mFairy.tap(557,640);
            str = "洱海";
        }
        if ((mapnum / num) == 5) {
            mFairy.tap(961,551);
            str = "燕子坞";
        }
        if ((mapnum / num) == 6) {
            mFairy.tap(427,445);
            str = "小镜湖";
        }
        if ((mapnum / num) == 7) {
            mFairy.tap(248,458);
            str = "杏子林";
        }
        if ((mapnum / num) == 8) {
            mFairy.tap(187,590);
            str = "聚贤庄";
        }
        if ((mapnum / num) == 9) {
            mFairy.tap(359,570);
            str = "丐帮";
        }
        if ((mapnum / num) == 10) {
            mFairy.tap(467,335);
            str = "少室山";
        }
        if ((mapnum / num) == 11) {
            mFairy.tap(300,221);
            str = "雁门关野外";
        }
        if ((mapnum / num) == 12) {
            mFairy.tap(593,255);
            str = "敦煌";
        }
        if ((mapnum / num) == 13) {
            mFairy.tap(314,651);
            str = "唐门";
        }
        if ((mapnum / num) == 14) {
            mFairy.tap(836,251);
            str = "雪原";
        }
        if ((mapnum / num) == 15) {
            mFairy.tap(189,347);
            str = "峨嵋山";
        }
        if ((mapnum / num) == 16) {
            mFairy.tap(404,150);
            str = "楼兰";
        }
        if ((mapnum / num) == 17) {
            mFairy.tap(567,191);
            str = "星宿草海";
        }
        if ((mapnum / num) == 18) {
            mFairy.tap(757,168);
            str = "光明顶";
        }
        if ((mapnum / num) == 19) {
            mFairy.tap(1072,208);
            str = "缥缈峰";
        }
        if ((mapnum / num) == 20) {
            mFairy.tap(1086,338);

            str = "琅嬛福地";
        }
        if ((mapnum / num) == 21) {
            mFairy.tap(1093,475);

            str = "秦皇地宫1";
        }
        if ((mapnum / num) == 22) {
            mFairy.tap(1093,475);

            str = "秦皇地宫2";
        }
        if ((mapnum / num) == 23) {
            mFairy.tap(1093,475);

            str = "秦皇地宫3";
        }
        if ((mapnum / num) == 24) {
            mFairy.ranSwipe(624,583,624,195,  500, (long) 1500, 3);
            mFairy.tap(1103,601);
            mFairy.onTap(409, 401, 427, 415, "", 500);
            str = "玄武岛";
        }
        LtLog.e("地图："+str);
    }

    //怪物坐标monster
    public void monster(int mapnum, int num) throws Exception {
        String str = "";
        if ((mapnum / num) == 1) {
            str = "苏州";
        }
        if ((mapnum / num) == 2) {
            str = "万劫谷";
        }
        if ((mapnum / num) == 3) {
            str = "无量山";
        }
        if ((mapnum / num) == 4) {
            str = "洱海";
        }
        if ((mapnum / num) == 5) {
            str = "燕子坞";
        }
        if ((mapnum / num) == 6) {
            str = "小镜湖";
        }
        if ((mapnum / num) == 7) {
            str = "杏子林";
        }
        if ((mapnum / num) == 8) {
            str = "聚贤庄";
            if ((mapnum % 10) == 1) {
                mFairy.onTap(358, 371,359, 372,"家丁", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 390, 205,391, 206,"剑客", Sleep);

            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(569, 233,570, 234,"刀客", Sleep);
            }
        }
        if ((mapnum / num) == 9) {
            str = "丐帮";
        }
        if ((mapnum / num) == 10) {
            str = "少室山";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 612, 510,613, 511,"猛虎", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap(566, 416, 567, 417, "少林铜人", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap( 361, 223,362, 224,"星宿弟子", Sleep);
            }
        }
        if ((mapnum / num) == 11) {
            str = "雁门关野外";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 444, 446, 445, 447, "戈壁马匪", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap(602, 470,603, 471,"宋兵", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap( 622, 274,623, 275,"荒原豹", Sleep);
            }
        }
        if ((mapnum / num) == 12) {
            str = "敦煌";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 627, 271,628, 272,"盗贼", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 487, 205,488, 206,"辽兵", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(382, 392,383, 393,"西夏兵", Sleep);
            }
        }
        if ((mapnum / num) == 13) {
            str = "唐门";
            if ((mapnum % 10) == 1) {
                mFairy.onTap(630, 530,631, 531,"苗裔士卒", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap(396, 489,397, 490,"苗巫", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(398, 271, 399, 272, "唐门叛徒", Sleep);
            }
        }
        if ((mapnum / num) == 14) {
            str = "雪原";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 509, 298, 510, 299, "雪豹", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 638, 425,639, 426,"冰原狼", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(527, 510,528, 511,"女真猎手", Sleep);

            }
        }
        if ((mapnum / num) == 15) {
            str = "峨嵋山";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 321, 496,322, 497,"闹事的香客", Sleep);

            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 526, 490,527, 491,"叛教弟子", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(660, 270,661, 271,"青城内奸", Sleep);
            }
            if ((mapnum % 10) == 4) {
                mFairy.onTap( 450, 239,451, 240,"苗越刺客", Sleep);
            }
            if ((mapnum % 10) == 5) {
                mFairy.onTap(597, 181,598, 182,"凌白塔", Sleep);

            }

        }
        if ((mapnum / num) == 16) {
            str = "楼兰";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 442, 296,443, 297,"江湖散人", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap(345, 449,346, 450,"楼兰恶人", Sleep);

            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap( 546, 528,547, 529,"楼兰鬼卫", Sleep);

            }
        }
        if ((mapnum / num) == 17) {
            str = "星宿草海";
        }
        if ((mapnum / num) == 18) {
            str = "光明顶";
        }
        if ((mapnum / num) == 19) {
            str = "缥缈峰";
            if ((mapnum % 10) == 1) {
                mFairy.onTap(370, 443,371, 444,"叛乱洞主", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 599, 263,600, 264,"昊天部众", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(589, 535,590, 536,"玄天部众", Sleep);
            }
        }
        if ((mapnum / num) == 20) {
            str = "琅嬛福地";
            if ((mapnum % 10) == 1) {
                mFairy.onTap(355, 520, 356, 521, "伏地武士", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap(663, 277, 664, 278, "灵兽", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap( 382, 297,383, 298,"巫灵", Sleep);
            }
        }
        if ((mapnum / num) == 21) {
            str = "秦皇地宫1";
            if ((mapnum % 10) == 1) {
                mFairy.onTap(354, 371,355, 372,"寻宝恶人", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 541, 483,542, 484,"盗墓贼", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap( 593, 231,594, 232,"boss幽灵守卫", Sleep);
            }

        }
        if ((mapnum / num) == 22) {
            str = "秦皇地宫2";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 608, 369,609, 370,"兵马俑", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 399, 449,400, 450,"机关石人", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap(660, 270,661, 271,"boss祭祀怨灵", Sleep);

            }
        }
        if ((mapnum / num) == 23) {
            str = "秦皇地宫3";
            if ((mapnum % 10) == 1) {
                mFairy.onTap( 628, 346, 629, 347, "地3随机怪", Sleep);
            }
        }
        if ((mapnum / num) == 24) {
            str = "玄武岛";
            if ((mapnum % 10) == 1) {
                mFairy.onTap(422, 302, 423, 303, "灵犀灵隼", Sleep);
            }
            if ((mapnum % 10) == 2) {
                mFairy.onTap( 400, 501,401, 502,"镇岛灵鸟", Sleep);
            }
            if ((mapnum % 10) == 3) {
                mFairy.onTap( 591, 504,592, 505,"灵猫", Sleep);
            }
        }

    }

    //设置
    public void setUp() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 2)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "setup.png");
                mFairy.onTap(0.8f, result, "设置", Sleep);

                result = mFairy.findPic(59,15,348,173,new String[]{"Settinginterface.png","jia3.png"});
                if (result.sim > 0.8f) {
                    mFairy.ranSwipe(432, 218,458, 537, 500, (long) 500,2);
                    mFairy.ranSwipe(432, 218, 458, 537,500, (long) 500,2);
                    mFairy.onTap(0.8f, result, 178, 610,  179, 611, "设置界面", 500);
                   /* mFairy.onTap(166,213,175,218,"",500);
                    mFairy.onTap(164,291,179,301,"",500);*/
                    setTaskName(2);return;
                }

            }

            public void content_2() throws Exception {
                if (overtime(7, 3)) return;
                for (int i = 0; i < 8; i++) {
                    mFairy.condit();
                    result = mFairy.findPic(320, 164, 887, 620,"setTick.png");
                    mFairy.onTap(0.8f, result, "勾选", 500);
                }

                result = mFairy.findPic(59,15,348,173,new String[]{"Settinginterface.png","jia3.png"});
                if (result.sim > 0.8f) {
                    if (AtFairyConfig.getOption("jjzd").equals("1")) {
                           mFairy.onTap(0.8f, result, 459, 285,460, 286,"勾选", 500);
                    }
                    mFairy.onTap(0.8f, result, 470, 433,471, 434,"勾选", 500);
                    mFairy.onTap(0.8f, result,  470, 505, 471, 506,"勾选", 500);
                    mFairy.ranSwipe(458, 537,432, 218, 500, (long) 500,2);
                    mFairy.ranSwipe(458, 537,432, 218, 500, (long) 1500,2);
                    for (int i = 0; i < 5; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(320, 164, 887, 620,"setTick.png");
                        mFairy.onTap(0.8f, result, "勾选", 500);
                    }
                    if (AtFairyConfig.getOption("zdjb").equals("1")) {
                        mFairy.onTap(627, 290,  628, 291, "勾选", 500);
                    }
                    mFairy.onTap(  348,353,364,368,"勾选", 500);
                    mFairy.onTap(  622, 360, 623, 361,"勾选", 500);
                    mFairy.onTap( 627, 435,628,436, "勾选", 500);
                    mFairy.onTap(  348, 507,   349, 508, "勾选", 500);
                    setTaskName(3);return;
                }

            }
            public void content_3() throws Exception {
                close(0);
                setTaskEnd();
            }
        }.taskContent(mFairy, "设置中");
    }

    //系统清包
    public void xtclearbag() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
                close(0);
                setTaskName(1);
            }
            public void content_1() throws Exception {
                if (overtime(7, 2)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "setup.png");
                mFairy.onTap(0.8f, result, "设置", Sleep);

                result = mFairy.findPic(59,15,348,173,new String[]{"Settinginterface.png","jia3.png"});
                mFairy.onTap(0.8f, result,  535, 94, 536, 95,"设置界面", Sleep);
                if (result.sim > 0.8f) {
                    for (int i = 0; i < 5; i++) {
                        mFairy.condit();
                        result = mFairy.findPic(1015, 193, 1111, 434,"setTick.png");
                        mFairy.onTap(0.82f, result, "勾选", 500);
                    }

                    mFairy.onTap(1064, 249, 1065, 250,"设置界面", 500);
                    mFairy.onTap(1065, 328, 1066, 329,"设置界面", 500);
                    mFairy.onTap( 1065, 402, 1066, 403, "设置界面", 500);
                    close(0);
                    setTaskEnd();return;
                }
            }
            public void content_2() throws Exception {
                close(0);
                setTaskEnd();
            }
        }.taskContent(mFairy, "系统清包中");
    }

    //抽奖
    public void prize() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
               close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic("zhankai.png");
                mFairy.onTap(0.8f, result, "展开扩展栏", Sleep);

                result = mFairy.findPic(1107, 5, 1276, 187, "ljred.png");
                if (result.sim > 0.8f) {
                    setTaskName(2);
                    return;
                }

            }

            public void content_2() throws Exception {
                if (overtime(10, 99)) return;
                result = mFairy.findPic(1107, 5, 1276, 187, "ljred.png");
                mFairy.onTap(0.8f, result, "抽奖红点", Sleep);

                result = mFairy.findPic(688,216,942,349,"Luckdrawone.png");
                mFairy.onTap(0.8f, result, "抽奖一次", Sleep);


                result = mFairy.findPic(349,245,598,401,"Lacklottery.png");
                if (result.sim > 0.8f) {
                    mFairy.onTap(0.8f, result, 741, 453, 742, 454, "error抽奖卷不足", Sleep);
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(748,578,974,702,"Luckdrawsure.png");
                mFairy.onTap(0.8f, result, "抽奖确定", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(359,511,612,630,"yqsFree.png");
                mFairy.onTap(0.8f, result, "摇钱树免费", Sleep);
                if (result.sim > 0.8f) {

                    result = mFairy.findPic(707,56,854,173, "yqs.png");
                    mFairy.onTap(0.8f, result, 918,79,936,103,"摇钱树误开关闭", Sleep);

                    setTaskName(0);
                    return;
                }

                result = mFairy.findPic(901,580,1146,692,"Signin.png");
                mFairy.onTap(0.8f, result, "领取", Sleep);


                result = mFairy.findPic("Acceptanceinterface.png");
                if (result.sim > 0.8f) {
                    for (int i1 = 0; i1 < 13; i1++) {
                        mFairy.condit();
                        if (i1 <= 1) {
                            result = mFairy.findPic(264, 46, 410, 125, "Havereward.png");
                            mFairy.onTap(0.8f, result, "有奖励", Sleep);
                        } else if (i1 > 1 && i1 <= 3) {
                            result = mFairy.findPic(425, 49, 541, 125, "Havereward.png");
                            mFairy.onTap(0.8f, result, "有奖励", Sleep);
                        } else if (i1 > 3 && i1 <= 5) {
                            result = mFairy.findPic(537, 43, 648, 128, "Havereward.png");
                            mFairy.onTap(0.8f, result, "有奖励", Sleep);
                        } else if (i1 > 6 && i1 <= 8) {
                            result = mFairy.findPic(682, 40, 772, 126, "Havereward.png");
                            mFairy.onTap(0.8f, result, "有奖励", Sleep);
                        } else if (i1 > 8 && i1 <= 10) {
                            result = mFairy.findPic(794, 41, 899, 131, "Havereward.png");
                            mFairy.onTap(0.8f, result, "有奖励", Sleep);
                        } else if (i1 > 10 && i1 <= 12) {
                            result = mFairy.findPic(982, 46, 1100, 137, "Havereward.png");
                            mFairy.onTap(0.8f, result, "有奖励", Sleep);
                        }

                        result = mFairy.findPic("szlq.png");
                        mFairy.onTap(0.8f, result, "首周领取", Sleep);

                        result = mFairy.findPic(706, 199, 1137, 629, "zlkhlq.png");
                        mFairy.onTap(0.8f, result, "战力狂欢领取", Sleep);

                        result = mFairy.findPic(770,578,969,690,"mwlq.png");
                        mFairy.onTap(0.8f, result, "秘闻领取", Sleep);


                        result = mFairy.findPic("novip.png");
                        mFairy.onTap(0.8f, result, 639, 452, 640, 453, "签到不是VIP确定", Sleep);

                        result = mFairy.findPic("novip1.png");
                        mFairy.onTap(0.8f, result, 639, 452, 640, 453, "签到不是VIP确定", Sleep);

                        result = mFairy.findPic(868,512,1143,641,"Onlinecollection.png");
                        mFairy.onTap(0.8f, result, "在线奖励领取", Sleep);


                        result = mFairy.findPic("regressionReceive.png");
                        mFairy.onTap(0.8f, result, "回归领取", Sleep);

                        result = mFairy.findPic(363, 122, 1151, 668, "hglq.png");
                        mFairy.onTap(0.8f, result, "回归领取", Sleep);
                    }
                  close(0);
                }
            }
        }.taskContent(mFairy, "抽奖");
    }

    ///美人伙伴
    public void prize1() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
              close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "beauty.png");
                mFairy.onTap(0.8f, result, "美人", 5000);


                result = mFairy.findPic("Beautyinterface.png");
                mFairy.onTap(0.8f, result, 319, 368,320, 369,"美人界面", Sleep);
                if (result.sim > 0.8f) {
                    for (int i= 0; i < 6; i++) {
                        mFairy.onTap(803, 600, 804, 601, "亲密", Sleep);
                    }
                    mFairy.onTap(742, 452,743, 453,"亲密", Sleep);
                    mFairy.onTap(1129,52,1149,70,"",1000);
                    close(0);
                    setTaskName(2);return;
                }
            }
            public void content_2() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "Partner.png");
                mFairy.onTap(0.8f, result, "伙伴", 5000);


                result = mFairy.findPic("Partnerinterface.png");
                mFairy.onTap(0.8f, result, 970, 93, 971, 94, "伙伴界面", Sleep);
                if (result.sim > 0.8f) {
                    for (int i= 0; i < 12; i++) {
                        mFairy.onTap(568, 563, 569, 564,"抽一下", Sleep);
                    }
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "/美人伙伴");
    }

    ///神翼
    public void prize2() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
              close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "Wing.png");
                mFairy.onTap(0.8f, result, "神翼", 5000);


                result = mFairy.findPic("Winginterface.png");
                mFairy.onTap(0.8f, result, 625, 94,626, 95,"神翼界面", Sleep);
                if (result.sim > 0.8f) {
                    for (int i= 0; i < 6; i++) {
                        mFairy.onTap( 1046, 414, 1047, 415, "神翼供养", Sleep);
                    }
                    setTaskEnd();return;
                }
            }

        }.taskContent(mFairy, "神翼");
    }
    ///普通酒楼
    public void prize3() throws Exception {
        new GameUtil(mFairy) {
            public void content_0() throws Exception {
             close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "WineHouse.png");
                mFairy.onTap(0.8f, result, "酒楼", 5000);

                result = mFairy.findPic(915,568,1170,698,"Restaurantinterface.png");
                mFairy.onTap(0.8f, result, "酒楼界面", Sleep);
                mFairy.onTap(0.8f, result, 244, 633,245, 634,"酒楼界面", Sleep);
                mFairy.onTap(0.8f, result, 1060, 547,1061, 548,"酒楼界面", Sleep);
                mFairy.onTap(0.8f, result, "酒楼界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskEnd();return;
                }
            }
        }.taskContent(mFairy, "普通酒楼");
    }

    ///材料酒楼
    public void prize4() throws Exception {
        new GameUtil(mFairy) {
            int jlnum = 1;
            String str = "";
            @Override
            public void create() throws Exception {
                if (AtFairyConfig.getOption("caipin").equals("")) {
                } else {
                    jlnum = Integer.parseInt(AtFairyConfig.getOption("caipin"));
                }
                if (jlnum == 2) {
                    str = "jljinbi.png";
                }
                if (jlnum == 3) {
                    str = "jlduanshi.png";
                }
                if (jlnum == 4) {
                    str = "jlpuyu.png";
                }
                if (jlnum == 5) {
                    str = "jlyaocai.png";
                }
            }

            public void content_0() throws Exception {
               close(0);
                setTaskName(1);
            }

            public void content_1() throws Exception {
                if (overtime(7, 99)) return;
                result = mFairy.findPic(737, 1, 1278, 207, "ShopMall.png");
                mFairy.onTap(0.8f, result, 74, 65, 75, 66, "商场", Sleep);

                result = mFairy.findPic(133, 65, 1149, 654, "WineHouse.png");
                mFairy.onTap(0.8f, result, "酒楼", 5000);

                result = mFairy.findPic(915,568,1170,698,"Restaurantinterface.png");
                mFairy.onTap(0.8f, result, "酒楼界面", Sleep);
                mFairy.onTap(0.8f, result, 244, 633,245, 634,"酒楼界面", Sleep);
                mFairy.onTap(0.8f, result, 543, 133,544, 134,"酒楼界面", Sleep);
                if (result.sim > 0.8f) {
                    setTaskName(2);return;
                }
            }
            int  jlcount=0;
            public void content_2() throws Exception {
                if (overtime(20, 99)){
                    prize3();
                    return;
                }
                result = mFairy.findPic(921,476,1151,601,"Dothisdish.png");
                if (result.sim > 0.8f) {

                    result = mFairy.findPic(486,79,595,182,"cai.png");
                    mFairy.onTap(0.85f,result,"关闭筛选",1000);


                    if (jlnum == 1) {
                        mFairy.onTap(0.8f, result, 1034, 545,1035, 546,"制作这道菜", Sleep);
                        setTaskEnd();return;
                    }
                    if (jlnum == 2) {
                        mFairy.onTap(0.8f, result, 707, 544,708, 545,"下一页", Sleep);
                        mFairy.onTap(0.8f, result, "制作这道菜", Sleep);
                        setTaskEnd();return;
                    }
                    if (jlnum >= 3) {
                        mFairy.onTap(0.8f, result, 707, 544,708, 545,"下一页", Sleep);
                        result = mFairy.findPic(str);
                        if (result.sim > 0.8f) {
                            jlcount=1;
                        }else {
                            if (jlcount==1) {
                                mFairy.onTap(557, 545,558, 546,"上一层", Sleep);
                                mFairy.onTap(1034, 545,1035, 546,"制作这道菜", Sleep);
                                setTaskEnd();return;
                            }
                        }
                    }
                }

            }
        }.taskContent(mFairy, "材料酒楼");
    }
}
