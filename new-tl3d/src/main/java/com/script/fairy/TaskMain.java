package com.script.fairy;

import com.script.content.ScProxy;
import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.FindResult;
import com.script.opencvapi.LtLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


/**
 * Created by Administrator on 2019/1/24 0024.
 */

public class TaskMain {
    AtFairyImpl mFairy;
    GameUtil gameUtil;
    TeamTask teamTask;
    SingleTask singleTask;
    FindResult result;
    LimitlessTask limitlessTask;
    TimingActivity timingActivity;
    OtherGame otherGame;
    static List<String> list = new ArrayList<>();
    public TaskMain(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        mFairy.setGameName("new天龙3d");
        mFairy.setGameVersion(80);
        init();
        gameUtil = new GameUtil(mFairy);
        teamTask = new TeamTask(mFairy);
        singleTask = new SingleTask(mFairy);
        limitlessTask = new LimitlessTask(mFairy);
        timingActivity = new TimingActivity(mFairy);
        otherGame = new OtherGame(mFairy);
        mFairy.initMatTime();
        list.clear();
    }

    public void main() throws Exception {

        if(!AtFairyConfig.getOption("task_id").equals("")){
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }

        ScProxy.config().Level().capturing(4);

        if (task_id != 2085 && task_id != 2099 && task_id != 2089) {
            gameUtil.setUp();
            if (AtFairyConfig.getOption("qb1").equals("1")) {
                gameUtil.xtclearbag();
            }
            if (AtFairyConfig.getOption("qb").equals("1")) {
                gameUtil.clearbag();
            }
        }

        switch (task_id) {
            case 2091:
                if (AtFairyConfig.getOption("juese_1").equals("1")) {
                    list.add("1");
                }
                if (AtFairyConfig.getOption("juese_2").equals("1")) {
                    list.add("2");
                }
                if (AtFairyConfig.getOption("juese_3").equals("1")) {
                    list.add("3");
                }
                if (AtFairyConfig.getOption("juese_4").equals("1")) {
                    list.add("4");
                }
                if (AtFairyConfig.getOption("jues_1").equals("1")) {
                    list.add("1");
                }
                if (AtFairyConfig.getOption("jues_2").equals("1")) {
                    list.add("2");
                }
                if (AtFairyConfig.getOption("jues_3").equals("1")) {
                    list.add("3");
                }
                if (AtFairyConfig.getOption("jues_4").equals("1")) {
                    list.add("4");
                }

                for (int i = 0; i < 10; i++) {
                    if (AtFairyConfig.getOption("lcj").equals("1") == true) {
                        LtLog.e(mFairy.getLineInfo("勾选了领成就"));
                        singleTask.achievement();
                    }
                   /* if (AtFairyConfig.getOption("sw144").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了声望144"));
                        singleTask.mhy();
                    }*/
                    if (AtFairyConfig.getOption("mhy").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("满活跃"));
                        singleTask.mhy();
                    }
                   /* if (AtFairyConfig.getOption("8fb12mp").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了副本门派"));
                        singleTask.fbrc();
                        singleTask.menpai();
                    }
                    if (AtFairyConfig.getOption("fbmp").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了副本藏宝阁"));
                        singleTask.fbrc();
                        singleTask.fbrc1();
                    }
                    if (AtFairyConfig.getOption("cbgcz").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了副本藏宝阁"));
                        singleTask.fbrc();
                        singleTask.fbrc1();
                    }*/
                    if (AtFairyConfig.getOption("sgfb").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了杀怪日常"));
                        singleTask.blaming();
                    }
                    if (AtFairyConfig.getOption("ksfb").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了快速活跃副本"));
                        singleTask.fbrc_ks();
                        singleTask.fbrc1_ks();
                    }
                    if (AtFairyConfig.getOption("ksfb140").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了快速活跃副本"));
                        singleTask.fbrc_ks140();
                    }

                    if (!AtFairyConfig.getOption("sggw").equals("") && !AtFairyConfig.getOption("sggw").equals("0")) {
                        LtLog.e(mFairy.getLineInfo("勾选了定点杀怪副本"));
                        singleTask.blaming1();
                    }
                    if (AtFairyConfig.getOption("huoyue").equals("1")) {
                        gameUtil.clearbag();
                        singleTask.cactivity();
                    }

                    if (AtFairyConfig.getOption("fuben1").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了江湖名人录"));
                        singleTask.drfb("drfbjjc.png");

                    }

                    if (AtFairyConfig.getOption("fuben2").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了聚贤庄"));
                        singleTask.drfb("drfbjxz.png");

                    }
                    if (AtFairyConfig.getOption("fuben4").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了燕子坞"));
                        singleTask.drfb("drfbyzw.png");
                    }

                    if (AtFairyConfig.getOption("fuben5").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了珍珑棋局"));
                        singleTask.drfb("drfbzlqj.png");
                    }

                    if (AtFairyConfig.getOption("fuben6").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了日常答题"));
                        singleTask.drfb("drfbrcdt.png");
                    }
                    if (AtFairyConfig.getOption("fuben7").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了燕王古墓"));
                        singleTask.drfb("drfbywgm.png");
                    }
                    if (AtFairyConfig.getOption("fuben8").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了怒海锄奸"));
                        singleTask.drfb("drfbnhcj.png");
                    }

                    if (AtFairyConfig.getOption("fuben10").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了勇闯灵鹫宫"));
                        singleTask.drfb("drfbycljg.png");
                    }

                    if (AtFairyConfig.getOption("fuben9").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了惩奸除恶"));
                        singleTask.drfb_cjce("drfbcjce.png");
                    }

                    if (AtFairyConfig.getOption("paoshang").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了跑商"));
                        singleTask.sportsBusiness();
                    }
                    if (AtFairyConfig.getOption("paohuan").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了跑环"));
                        singleTask.sportsBusiness1();
                    }
                    if (AtFairyConfig.getOption("lingjing").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了领奖"));
                        gameUtil.prize();
                    }
                    if (AtFairyConfig.getOption("lingjing1").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了伙伴美人酒楼"));
                        gameUtil.prize1();
                    }
                    if (AtFairyConfig.getOption("lingjing1").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了伙伴美人酒楼"));
                        gameUtil.prize4();
                    }
                    if (AtFairyConfig.getOption("lingjing2").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了神翼"));
                        gameUtil.prize2();
                    }
                    if (AtFairyConfig.getOption("bhrw").equals("1")) {
                        LtLog.e(mFairy.getLineInfo("勾选了帮会任务"));
                        singleTask.bhrw();
                    }
                    LtLog.e(mFairy.getLineInfo("list===" + list.toString()));
                    if (list.size() != 0) {
                        singleTask.switchedRoles1();
                        if (list.size() != 0) {
                            list.remove(0);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            case 2087:
                //固定队副本
                if (AtFairyConfig.getOption("gdfb1").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了聚贤庄"));
                    singleTask.gddfb("drfbjxz.png");
                }
                if (AtFairyConfig.getOption("gdfb2").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了燕子坞"));
                    singleTask.gddfb("drfbyzw.png");
                }
                if (AtFairyConfig.getOption("gdfb3").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了珍珑棋局"));
                    singleTask.gddfb("drfbzlqj.png");
                }

                if (AtFairyConfig.getOption("gdfb4").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了燕王古墓"));
                    singleTask.gddfb("drfbywgm.png");
                }
                if (AtFairyConfig.getOption("gdfb5").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了少室山"));
                    singleTask.gddfb1("gdfbsss.png");
                }

                if (AtFairyConfig.getOption("gdfb8").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了炼狱少室山"));
                    singleTask.gddfb1("gdfblysss.png");
                }
                if (AtFairyConfig.getOption("gdfb6").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了守护雁门关"));
                    singleTask.gddfb1("gdfbswymg.png");
                }
                if (AtFairyConfig.getOption("gdfb7").equals("1")) {
                    LtLog.e(mFairy.getLineInfo("勾选了炼狱雁门关"));
                    singleTask.gddfb1("gdfblyymg.png");
                }
                break;
            case 2089:
                singleTask.guest();
                break;
            case 2085:
                singleTask.novice();
                break;
            case 2093:
                if (AtFairyConfig.getOption("xwd").equals("1")) {
                    limitlessTask.xwd();
                }
                limitlessTask.fixedPoint();
                break;
            case 2095:

                if (AtFairyConfig.getOption("juese_1").equals("1")) {
                    list.add("1");
                }
                if (AtFairyConfig.getOption("juese_2").equals("1")) {
                    list.add("2");
                }
                if (AtFairyConfig.getOption("juese_3").equals("1")) {
                    list.add("3");
                }
                if (AtFairyConfig.getOption("juese_4").equals("1")) {
                    list.add("4");
                }
                if (AtFairyConfig.getOption("jues_1").equals("1")) {
                    list.add("1");
                }
                if (AtFairyConfig.getOption("jues_2").equals("1")) {
                    list.add("2");
                }
                if (AtFairyConfig.getOption("jues_3").equals("1")) {
                    list.add("3");
                }
                if (AtFairyConfig.getOption("jues_4").equals("1")) {
                    list.add("4");
                }

                for (int i = 0; i < 10; i++) {
                    limitlessTask.banditHead();
                    LtLog.e(mFairy.getLineInfo("list===" + list.toString()));
                    if (list.size() != 0) {
                        singleTask.switchedRoles1();
                        if (list.size() != 0) {
                            list.remove(0);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            case 2099:
                if (AtFairyConfig.getOption("juese_1").equals("1")) {
                    list.add("1");
                }
                if (AtFairyConfig.getOption("juese_2").equals("1")) {
                    list.add("2");
                }
                if (AtFairyConfig.getOption("juese_3").equals("1")) {
                    list.add("3");
                }
                if (AtFairyConfig.getOption("juese_4").equals("1")) {
                    list.add("4");
                }

                if (AtFairyConfig.getOption("jues_1").equals("1")) {
                    list.add("1");
                }
                if (AtFairyConfig.getOption("jues_2").equals("1")) {
                    list.add("2");
                }
                if (AtFairyConfig.getOption("jues_3").equals("1")) {
                    list.add("3");
                }
                if (AtFairyConfig.getOption("jues_4").equals("1")) {
                    list.add("4");
                }
                for (int i = 0; i < 10; i++) {
                    LtLog.e(mFairy.getLineInfo("list===" + list.toString()));

                    if (list.size() != 0) {


                        singleTask.switchedRoles();

                        if (list.size() != 0) {
                            list.remove(0);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                break;
            case 2101:
                  singleTask.novice1();
                break;


        }
        mFairy.finish(AtFairyConfig.getTaskID(), TASK_STATE_FINISH);
        Thread.sleep(2000);
    }

    private int task_id;

    public void init() throws Exception {
        task_id = 0;
        try {
            JSONObject optionJson = new JSONObject(AtFairyConfig.getUserTaskConfig());
            LtLog.e(mFairy.getLineInfo("选项列表" + optionJson));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }
    }

}
