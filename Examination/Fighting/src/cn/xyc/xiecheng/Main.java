package cn.xyc.xiecheng;

import java.util.Scanner;

/**
 * 完成任务
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }

            // 已经完成的任务
            boolean[] overed = new boolean[n];
            // 有体力则进行
            while(k > 0){

                // 最出划算的
                int max = Integer.MIN_VALUE;
                int idx = -1;
                for (int i = 0; i < n; i++) {
                    if(overed[i] || nums[i][0] > k) continue;
                    if(max < nums[i][1] - nums[i][0]){
                        idx = i;
                        max = nums[i][1] - nums[i][0];
                    }
                }

                if(idx == -1) break;
                overed[idx] = true;
                k -= nums[idx][0];
            }

            int res = 0;
            for (int i = 0; i < n; i++) {
                if(!overed[i]) res += nums[i][1];
            }

            System.out.println(res);
        }
    }

}


// 5 5
// 2 5
// 3 10
// 1 10
// 3 8
// 1 2