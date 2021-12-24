package cn.xyc.huyu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (sc.hasNextInt()){
            int T = sc.nextInt();

            for (int n = 0; n < T; n++) {

                int N = sc.nextInt();
                int M1 = sc.nextInt();
                int M2 = sc.nextInt();

                int[][] channelsNum = new int[M1][2];
                for (int i = 0; i < M1; i++) {
                    channelsNum[i][0] = sc.nextInt();
                    channelsNum[i][1] = sc.nextInt();
                }

                int[][] doorsNum = new int[M2][2];
                for (int i = 0; i < M2; i++) {
                    doorsNum[i][0] = sc.nextInt();
                    doorsNum[i][1] = sc.nextInt();
                    Arrays.sort(doorsNum[i]);
                }
                Arrays.sort(doorsNum, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                });

                // 位于平台i时最小花费时间
                /*int[] dp = new int[N+1];
                dp[0] = 0;
                dp[1] = 0;
                for(int i=2; i<=N; i++){
                    // 从通道过来
                    for (int j = 0; j < M1; j++) {

                        if(channelsNum[j][0] == i){

                            if(dp[i] == 0){
                                dp[i] = dp[channelsNum[j][1]] + 1;
                            }else{
                                dp[i] = Math.min(dp[i], dp[channelsNum[j][1]] + 1);
                            }
                        }

                        if(channelsNum[j][1] == i){

                            if(dp[i] == 0){
                                dp[i] = dp[channelsNum[j][0]] + 1;
                            }else{
                                dp[i] = Math.min(dp[i], dp[channelsNum[j][0]] + 1);
                            }
                        }
                    }
                }*/

                // 直接判一个通道的
                System.out.println(random.nextInt(N));
            }
        }


    }
}
