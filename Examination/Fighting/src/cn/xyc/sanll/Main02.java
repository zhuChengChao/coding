package cn.xyc.sanll;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            int[] nums = new int[n];

            for(int i=0; i<n; i++){
                nums[i] = sc.nextInt();
            }

            int res = new Main02().solution(n, p, q, nums);
            System.out.println(res);
        }
    }

    /**
     * 求及格人数
     * @param n     n个学生
     * @param p     平时成绩占比
     * @param q     期末占比
     * @param scores  学生的成绩
     * @return
     */
    private int solution(int n, int p, int q, int[] scores) {

        Arrays.sort(scores);
        // 期末的最大成绩
        int maxQscore = scores[n-1];
        // 最大的平时成绩
        int maxPScore = (10000- maxQscore * q) / p;

        // 限定一下平时成绩
        if(maxPScore > 100){
            maxPScore = 100;
            double finalScore = (maxQscore * q + maxPScore * p) / 100.0;

            if(finalScore < 60.0){
                // 最好的成绩都小于60，直接返回0
                return 0;
            }
        }

        int res = 0;
        int k = 0;
        for (int i = scores.length-1; i >= 0 ; i--) {

            if(scores[i] != scores[i+1]){
                k++;
            }

            double finalSocre = (scores[i] * q + (maxPScore-k) * p) / 100.0;

            if(finalSocre >= 60.0){
                res++;
            }else{
                break;
            }

        }

        return res;
    }
}
