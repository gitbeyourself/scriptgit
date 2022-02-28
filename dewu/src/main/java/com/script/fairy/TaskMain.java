package com.script.fairy;

import com.script.framework.AtFairyImpl;
import com.script.framework.TaskContent;
import com.script.opencvapi.AtFairyConfig;
import com.script.opencvapi.LtLog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.script.opencvapi.AtFairy2.TASK_STATE_FINISH;


public class TaskMain extends TaskContent{
    AtFairyImpl mFairy;
    GameUtil gameUtil;
    TeamTask teamTask;
    SingleTask singleTask;
    LimitlessTask limitlessTask;
    OtherGame otherGame;
    static List<String> list = new ArrayList<>();
    public TaskMain(AtFairyImpl ypFairy) throws Exception {
        mFairy = ypFairy;
        mFairy.setGameName("得物");
        mFairy.setGameVersion(8);
        init();
        gameUtil = new GameUtil(mFairy);
        teamTask = new TeamTask(mFairy);
        singleTask = new SingleTask(mFairy);
        limitlessTask = new LimitlessTask(mFairy);
        otherGame = new OtherGame(mFairy);
        mFairy.initMatTime();
        list.clear();
    }

    public void main() throws Exception {

        if (!AtFairyConfig.getOption("task_id").equals("")) {
            task_id = Integer.parseInt(AtFairyConfig.getOption("task_id"));
        }

        if (task_id != 2029 && task_id != 100) {
            gameUtil.close();
        }

        switch (task_id) {
            case 2727:
                singleTask.novice();
                break;
            case 2729:
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
