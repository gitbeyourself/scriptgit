package com.example.administrator.sh;

import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;
import com.script.opencvapi.AtFairyConfig;

/**
 * Created by Administrator on 2018/8/30 0030.
 */

public class Other {//其他任务
    sh mFairy;
    FindResult result;
    private CommonFunction comm;
    private GamePublicFunction gamePublicFunction;
    public static int JN = 0;

    public Other(sh ypFairy) {
        mFairy = ypFairy;
        comm = new CommonFunction(mFairy);
        gamePublicFunction = new GamePublicFunction(mFairy);
        JN = 0;
    }
    /*
         其他方法
     */

    public void kgAutoSkill() throws Exception {
        int bj = 0;
        JN = 0;
        int title = 0;
        while (true) {
            if (bj == 0) {
                result = mFairy.findPic2(391, 509, 787, 625, comm.setImg("jn2.png"));
                if (result.sim > 0.8f) {
                    comm.Click(0.8f, result, comm.getImg(), "技能", 2000);
                } else {
                    gamePublicFunction.init("home.png");

                    result = mFairy.findPic2(comm.setImg("home.png"));
                    comm.Click(0.85f, result, comm.getImg(), "切换", 3000);
                }
                result = mFairy.findPic2(comm.setImg("jn1.png"));
                if (result.sim > 0.85f) {
                    bj = 1;
                }
            }

            if (bj == 1) {
                if (AtFairyConfig.getOption("aa2").equals("1")) {
                    for (int i = 0; i < 5; i++) {
                        result = mFairy.findPic2(comm.setImg("jn3.png"));
                        if (result.sim > 0.85f) {
                            comm.Click(0.85f, result, comm.getImg(), "重置", 2000);
                            comm.spot(787, 427, "确定", 8000);
                            break;
                        }
                    }
                }
                for (int i = 0; i < 3; i++) {
                    comm.RanSwipe(228, 191, 261, 512, 0, 500, 2000);
                }

                result = mFairy.findPic2(comm.setImg("jnn.png"));
                if (result.sim > 0.85f) {
                    for (int i = 1; i <= 17; i++) {
                        LtLog.e(comm.getText("自动点技能>>>"));
                        switch (i) {
                            case 1:
                                comm.spot(663, 123, "", 200);
                                comm.spot(663, 123, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(0);
                                break;

                            case 2:
                                comm.spot(339, 241, "", 200);
                                comm.spot(339, 241, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(1);
                                break;

                            case 3:
                                comm.spot(441, 468, "", 200);
                                comm.spot(441, 468, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);
                                break;
                            case 4:
                                comm.spot(448, 588, "", 200);
                                comm.spot(448, 588, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);
                                break;
                            case 5:
                                mFairy.touchDown(1, 264, 434);
                                mFairy.touchMove(1, 255, 186, 200);
                                Thread.sleep(1500);
                                mFairy.touchUp(1);
                                Thread.sleep(2000);

                                comm.spot(444, 265, "", 200);
                                comm.spot(444, 265, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(0);
                                break;

                            case 6:

                                break;
                            case 7:
                                comm.spot(664, 377, "", 200);
                                comm.spot(664, 377, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);
                                break;
                            case 8:
                                comm.spot(445, 495, "", 200);
                                comm.spot(445, 495, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);
                                break;
                            case 9:
                                comm.spot(555, 496, "", 200);
                                comm.spot(555, 496, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(0);
                                break;
                            case 10:
                                comm.spot(336, 613, "", 200);
                                comm.spot(336, 613, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(0);
                                break;
                            case 11:
                                comm.spot(556, 613, "", 200);
                                comm.spot(556, 613, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);
                                break;

                            case 12:
                                comm.RanSwipe(228, 191, 261, 512, 2, 1000, 1000);
                                comm.RanSwipe(228, 191, 261, 512, 2, 1000, 2000);
                                comm.spot(663, 124, "", 200);
                                comm.spot(663, 124, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);
                                break;
                            case 13:
                                comm.spot(665, 239, "", 200);
                                comm.spot(665, 239, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(2);
                                break;
                            case 14:
                                /*comm.spot(340, 351, "", 200);
                                comm.spot(340, 351, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(0);*/
                                break;
                            case 15:
                                /*comm.spot(332, 472, "", 200);
                                comm.spot(332, 472, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(-1);*/
                                break;
                            case 16:
                                comm.spot(442, 472, "", 200);
                                comm.spot(442, 472, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(0);
                                break;
                            case 17:
                                comm.spot(669, 587, "", 200);
                                comm.spot(669, 587, "第 " + i + " 步", 200);
                                verificationSkill();
                                kgAutoSkillTools(1);
                                break;
                        }
                    }
                    LtLog.e(comm.getText("自动点技能已结束,End!"));
                    break;
                } else {
                    title++;
                    if (title > 2) {
                        LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                        return;
                    }
                }
            }
        }
    }//技能

    public boolean kgAutoSkillSets(int num) throws Exception {
        result = mFairy.findPic2(comm.setImg("njn6.png"));
        if (result.sim > 0.85f) {

            switch (num) {
                case 1:
                    comm.spot(863, 311, "觉醒 1 ", 1000);
                    break;
                case 2:
                    comm.spot(863, 227, "觉醒 2 ", 1000);
                    break;

                default:
                    JN++;
                    for (int i = 0; i < 3; i++) {
                        switch (JN) {
                            case 1:
                                comm.spot(950, 504, "设置 1 ", 1000);
                                break;
                            case 2:
                                comm.spot(944, 425, "设置 2 ", 1000);
                                break;
                            case 3:
                                comm.spot(1005, 309, "设置 3 ", 1000);
                                break;
                            case 4:
                                comm.spot(1088, 314, "设置 4 ", 1000);
                                break;
                            case 5:
                                comm.spot(864, 504, "设置 5 ", 1000);
                                break;
                            case 6:
                                comm.spot(862, 422, "设置 6 ", 1000);
                                break;
                            case 7:
                                comm.spot(1010, 226, "设置 7 ", 1000);
                                break;
                            case 8:
                                comm.spot(1094, 225, "设置 8 ", 1000);
                                break;
                        }
                    }
                    break;
            }

            comm.spot(1015, 615, "返回", 1000);
            return true;
        } else {
            return false;
        }
    }//设置技能

    public void kgAutoSkillTools(int num) throws Exception {
        int i = 0;
        int err = 0;
        while (true) {
            result = comm.arrayCompare(2f, 783, 562, 1272, 685, new String[]{
                    "njn3.png", "njn4.png"});
            if (result.sim > 0.85f) {
                comm.arrayClick(0.8f, result, "激活升级", 200);
                if (i == 0) {
                    if (verificationSkill()) {
                        return;
                    }
                    i = 1;
                }
            }

            err++;
            if (err > 30) {
                return;
            }

            result = mFairy.findPic2(comm.setImg("njn11.png"));
            if (result.sim > 0.85f) {
                return;
            }
            result = comm.arrayCompare(2f, 782, 488, 1272, 714, new String[]{
                    "njn5.png", "njn7.png"});
            if (result.sim > 0.85f) {
                LtLog.e(comm.getText("技能已点满"));
                if (num != -1) {
                    comm.spot(1164, 619, "装备", 2000);
                    if (kgAutoSkillSets(num)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

    }//技能工具

    public boolean verificationSkill() throws Exception {

        for (int i = 0; i < 10; i++) {
            result = comm.arrayCompare(2f, 694, 40, 816, 380, new String[]{
                    "njn8.png", "njn9.png", "njn10.png"});
            if (result.sim > 0.8f) {
                return true;
            }
        }
        return false;


    }//验证

    public void strengthenArms() throws Exception {
        LtLog.e(comm.getText("开始武器强化10次>>>"));
        int title = 0;
        while (true) {
            LtLog.e(comm.getText("武器强化>>>"));
            result = mFairy.findPic2(comm.setImg("zhuang1.png"));
            if (result.sim > 0.85f) {
                comm.spot(901, 669, "装备", 1000);
                comm.spot(697, 153, "点击武器", 2000);

                result = mFairy.findPic2(485, 15, 740, 375, comm.setImg("qiang1.png"));
                comm.Click(0.85f, result, comm.getImg(), "强化", 6000);

                result = mFairy.findPic2(comm.setImg("qiang2.png"));
                if (result.sim > 0.85f) {
                    int num = (int) (Math.random() * 5)+5;
                    for (int i = 0; i < num; i++) {
                        result = mFairy.findPic2(367, 256, 918, 378, comm.setImg("qiang4.png"));
                        if (result.sim > 0.85f) {
                            comm.spot(495, 424, "取消", 1000);
                            break;
                        }
                        result = comm.arrayCompare(2f, new String[]{"qiang3.png", "qiang5.png"});
                        if (result.sim > 0.85f) {
                            break;
                        }
                        comm.spot(1013, 567, "强化", 3000);
                    }
                }
                return;
            } else {
                gamePublicFunction.pakageTools(2);
                title++;
                if (title > 5) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }
            }
        }
    }//强化武器10次

    public void autoCang() throws Exception {
        int err = 0;
        int title = 0;
        while (true) {
            LtLog.e(comm.getText("自动存仓库>>>"));
            result = mFairy.findPic2(comm.setImg("package1.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "仓库", 2000);

                result = mFairy.findPic2(comm.setImg("jj.png"));
                if (result.sim > 0.85f) {

                    for (int i = 0; i < 2; ) {
                        comm.spot(524 + (i * 170), 63, "个人仓库", 500);
                        result = mFairy.findPic2(comm.setImg("package6.png"));
                        if (result.sim > 0.85f) {
                            if (i == 0) {
                                comm.spot(1225, 37, "消耗", 1000);
                                for (int j = 1; j <= 21; j++) {
                                    result = mFairy.findPic2(847, 59, 1274, 616, comm.setImg("cang" + j + ".png"));
                                    if (result.sim > 0.85f) {
                                        comm.Click(0.85f, result, comm.getImg(), "发现可以存入的物品", 1500);
                                    }
                                    result = mFairy.findPic2(549, 265, 824, 555, comm.setImg("ok1.png"));
                                    comm.Click(0.85f, result, comm.getImg(), "确认", 1000);
                                }
                            } else {
                                comm.spot(1225, 37, "消耗", 1000);
                                for (int j = 1; j <= 3; j++) {
                                    result = mFairy.findPic2(847, 59, 1274, 616, comm.setImg("canz" + j + ".png"));
                                    if (result.sim > 0.85f) {
                                        comm.Click(0.85f, result, comm.getImg(), "发现可以存入的物品", 1500);
                                    }
                                    result = mFairy.findPic2(549, 265, 824, 555, comm.setImg("ok1.png"));
                                    comm.Click(0.85f, result, comm.getImg(), "确认", 1000);
                                }

                                comm.spot(1115, 37, "材料", 1000);
                                for (int j = 5; j <= 16; j++) {
                                    result = mFairy.findPic2(847, 59, 1274, 616, comm.setImg("canz" + j + ".png"));
                                    if (result.sim > 0.85f) {
                                        comm.Click(0.85f, result, comm.getImg(), "发现可以存入的物品", 1500);
                                    }
                                    result = mFairy.findPic2(549, 265, 824, 555, comm.setImg("ok1.png"));
                                    comm.Click(0.85f, result, comm.getImg(), "确认", 1000);
                                }
                            }
                            i++;
                        } else {
                            i = 0;
                        }
                        err++;
                        if (err > 20) {
                            LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                            return;
                        }
                    }
                    comm.spot(809, 31, "关闭", 1000);
                    break;
                }
            } else {
                gamePublicFunction.pakageTools(1);
                title++;
                if (title > 5) {
                    LtLog.e(comm.getText("可能遇到封号机制>>> End!"));
                    return;
                }

            }
        }
    }//自动存仓库


    /*public void err() throws InterruptedException {

        gamePublicFunction.init("home.png");
        Abnormal.LOGIN = 1;
        while (true) {
            result = mFairy.findPic2(comm.setImg("home.png"));
            comm.RndClick(0.85f, 56, 56, result, "点击头像", 1000);

            result = mFairy.findPic2(comm.setImg("setUp.png"));
            comm.RndClick(0.85f, 142, 479, result, "基本设置", 1000);

            result = mFairy.findPic2(comm.setImg("qh.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "切换角色", 2000);
                comm.spot(789, 425, "确定", 1000);
            }
            result = mFairy.findPic2(comm.setImg("qhUI.png"));
            if (result.sim > 0.85f) {
                if (GamePublicFunction.QH6 == 2) {
                    comm.spot(83, 153, "", 1000);
                    comm.spot(83, 153, "角色6", 1000);
                } else if (GamePublicFunction.QH5 == 2) {
                    comm.spot(83, 245, "", 1000);
                    comm.spot(83, 245, "角色5", 1000);
                } else if (GamePublicFunction.QH4 == 2) {
                    comm.spot(83, 331, "", 1000);
                    comm.spot(83, 331, "角色4", 1000);
                } else if (GamePublicFunction.QH3 == 2) {
                    comm.spot(83, 427, "", 1000);
                    comm.spot(83, 427, "角色3", 1000);
                } else if (GamePublicFunction.QH2 == 2) {
                    comm.spot(83, 513, "", 1000);
                    comm.spot(83, 513, "角色2", 1000);
                } else if (GamePublicFunction.QH1 == 2) {
                    comm.RanSwipe(145, 221, 191, 482, 2, 500, 2000);
                    comm.spot(83, 513, "", 1000);
                    comm.spot(83, 513, "角色1", 1000);
                }
                result = mFairy.findPic2(comm.setImg("login1.png"));
                if (result.sim > 0.85f) {
                    comm.Click(0.85f, result, comm.getImg(), "进入游戏", 2000);
                    Abnormal.LOGIN = 0;
                    break;
                }
            }
            result = mFairy.findPic2(comm.setImg("create.png"));
            if (result.sim > 0.85f) {
                comm.Click(0.85f, result, comm.getImg(), "创建角色", 8000);
                while (true) {
                    result = mFairy.findPic2(comm.setImg("create1.png"));
                    if (result.sim > 0.85f) {
                        comm.spot(792, 654, "随机名字", 1000);
                        comm.spot(1137, 653, "进入游戏", 3000);
                    } else {
                        Abnormal.LOGIN = 0;
                        return;
                    }
                }
            }

        }


    }*/

}