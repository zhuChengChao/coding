package cn.xyc.sanll;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();
            int[] ai = new int[n];

            for(int i=0; i<n; i++){
                ai[i] = sc.nextInt();
            }

            if(n >= 100) System.out.println(100);
            int solution = new Main().solution(n, m, x, k, ai);
            System.out.println(solution);

        }
    }


    /**
     * 计算最小战力返回
     * @param n    总共n个人
     * @param m    总共m个将军
     * @param x    将军的影响范围
     * @param k    将军的影响值
     * @param ai   士兵
     * @return
     */
    private int solution(int n, int m, int x, int k, int[] ai) {

        int[] newAiResult = new int[n];
        int minValue = getMinStrongValue(ai);
        int tmp = n >= x ? 0 :x;

        for (int i = 0; i < m; i++) {
            for (int j = tmp; j < n-tmp; j++) {

                int[] newTmp = helper(ai, j, x, k);
                int tmpValue = getMinStrongValue(newTmp);
                if(tmpValue > minValue){
                    minValue = tmpValue;
                    newAiResult = newTmp;
                }
            }
            ai = newAiResult;
        }
        return minValue;
    }

    private int[] helper(int[] ai, int j, int x, int k) {

        int[] res = new int[ai.length];
        System.arraycopy(ai, 0, res, 0, res.length);
        for (int i = Math.max((j-x), 0); i <= Math.min(j+x, ai.length-1) ; i++) {
            res[i] += k;
        }
        return res;
    }

    private int getMinStrongValue(int[] ai) {

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ai.length; i++) {
            min = Math.min(min, ai[i]);
        }
        return min;
    }

}


// 5 2 1 2
// 4 4 2 4 4
//
//
