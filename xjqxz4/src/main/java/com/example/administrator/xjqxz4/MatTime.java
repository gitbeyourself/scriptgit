
package com.example.administrator.xjqxz4;

import com.script.opencvapi.LtLog;
import com.script.opencvapi.ScreenInfo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2018/6/27.
 */

public class MatTime {

    private xjqxz4 mFairy;
    private PublicFunction publicFunction;
    private Mat mat1, mat2;
    private long timex, time;

    public MatTime(xjqxz4 ypFairy) {
        mFairy = ypFairy;
        publicFunction = new PublicFunction(mFairy);

    }


    public long mMatTime() {
        boolean matSim = false;
        String pathNameMat3 = "/sdcard/mat3.png";
        String pathNameMat4 = "/sdcard/mat4.png";

        ScreenInfo screenInfo=mFairy.capture();
        if(screenInfo.height>720){
            LtLog.i(publicFunction.getLineInfo() + "----screenInfo error ---");
            return 0;
        }
//        if (mat1 != null) {
//            mat1.release();
//        }
        mat1 = mFairy.getScreenMat(1184,42,33,11, 1, 0, 0, 1);
        if (mat1 != null) {
            Imgcodecs.imwrite(pathNameMat3, mat1);
        }
//        if (mat2 != null) {
//            mat2.release();
//        }
        if (mat2 != null) {
            LtLog.i(publicFunction.getLineInfo() + "----------------------------mat>");
            mat1 = Imgcodecs.imread(pathNameMat3);
            mat2 = Imgcodecs.imread(pathNameMat4);
            matSim = judgeMatAndMatChange(0.9, mat1, mat2);
            //判断两个矩阵的相似度大于 sim 则返回 true;
        }
        if (matSim) {
            LtLog.i(publicFunction.getLineInfo() + "----------------------------matSim>" + matSim + ",timex=" + timex + ",time=" + time);
        } else {
            //如果两个矩阵不相等 重置时间
            LtLog.i(publicFunction.getLineInfo() + "----------------------------matSim>" + matSim);
            time = System.currentTimeMillis() / 1000;
            mat2 = mFairy.getScreenMat(1184,42,33,11, 1, 0, 0, 1);
            if (mat2 != null) {
                Imgcodecs.imwrite(pathNameMat4, mat2);
            }
        }
        timex = System.currentTimeMillis() / 1000 - time;
        return timex;
    }

    public long mMatTime(int x_1, int y_1, int width, int height) {
        boolean matSim = false;
        String pathNameMat1 = "/sdcard/mat1.png";
        String pathNameMat2 = "/sdcard/mat2.png";
        ScreenInfo screenInfo=mFairy.capture();
        if(screenInfo.height>720){
            LtLog.i(publicFunction.getLineInfo() + "----screenInfo error ---");
            return 0;
        }
        mat1 = mFairy.getScreenMat(x_1, y_1, width, height, 1, 0, 0, 1);
        if (mat1 != null) {
            Imgcodecs.imwrite(pathNameMat1, mat1);
        }
        if (mat2 != null) {
            LtLog.i(publicFunction.getLineInfo() + "----------------------------mat>");
            mat1 = Imgcodecs.imread(pathNameMat1);
            mat2 = Imgcodecs.imread(pathNameMat2);
            matSim = judgeMatAndMatChange(0.9, mat1, mat2);
            //判断两个矩阵的相似度大于 sim 则返回 true;
        }
        if (matSim) {
            LtLog.i(publicFunction.getLineInfo() + "----------------------------matSim>" + matSim + ",timex=" + timex + ",time=" + time);
        } else {
            //如果两个矩阵不相等 重置时间
            LtLog.i(publicFunction.getLineInfo() + "----------------------------matSim>" + matSim);
            time = System.currentTimeMillis() / 1000;
            mat2 = mFairy.getScreenMat(x_1, y_1, width, height, 1, 0, 0, 1);
            if (mat2 != null) {
                Imgcodecs.imwrite(pathNameMat2, mat2);
            }
        }
        timex = System.currentTimeMillis() / 1000 - time;
        return timex;
    }

    public void resetTime() {
        //重置时间
        time = System.currentTimeMillis() / 1000;
    }

    public String do_exec(String cmd) {
        String s = "/n";
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                s += line + "/n";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-------------------------" + cmd + "------" + s);
        return cmd;
    }

    private boolean judgeMatAndMatChange(double sim, Mat mat, Mat tempMat) {
        //判断两个矩阵的相似度大于 sim 则返回 true;
        boolean state = false;
        Mat dstMat = new Mat();
        if (mat.channels() == 3) {
            Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2HLS);
            Imgproc.cvtColor(tempMat, tempMat, Imgproc.COLOR_RGB2HLS);
        }
        Imgproc.matchTemplate(mat, tempMat, dstMat, Imgproc.TM_CCOEFF_NORMED);
        Core.MinMaxLocResult mmr;
        mmr = Core.minMaxLoc(dstMat);
        if (mmr.maxVal >= sim) {
            state = true;
        }

        dstMat.release();
        return state;
    }
}
