package cn.xyc.kujiale;

import java.util.Arrays;

public class Kernal {


    /**
     * 卷积操作
     * @param A      输入的矩阵
     * @param kernel 卷积核
     * @return
     */
    private int[][] kernal(int[][] A, int[][] kernel){

        // A矩阵的行数列数
        int rows = A.length;
        int cols = A[0].length;

            // 卷积核的尺寸
            int kernalRows = kernel.length;
            int kernalCols = kernel[0].length;

            // 输出结果的封装
            int[][] res = new int[rows][cols];
            // 默认填充为1
            for (int i = 0; i < res.length; i++) {
                Arrays.fill(res[i], 1);
            }


            // 开始遍历A矩阵
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                // 从起始位置的确定
                int row = i - kernalRows / 2;
                int col = j - kernalCols / 2;
                // 和kernal的比较位置
                int idx = 0;
                for(int m = row; row < i + kernalRows; m++){
                    // 标志位：一旦不满足直接退出这个位置的判断
                    boolean unSatisfied = false;
                    for(int n = col; col < j + kernalRows; n++){
                        idx++;
                        if(m < 0 || n < 0 || m >= rows || n >= cols){
                            continue;
                        }

                        // kernal当前位置的值
                        int kernalValue = kernel[idx / kernalCols][idx % kernalCols];
                        if(kernalValue != A[m][n]){
                            res[m][n] = 0;
                            unSatisfied = true;
                            break;
                        }
                    }

                    if(unSatisfied){
                        // 不满足条件无需再进行比较了
                        break;
                    }
                }
            }
        }

        return res;

    }

}
