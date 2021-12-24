package cn.xyc;

import java.util.Scanner;

public class Demo {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            // 获取输入数据
            int N = Integer.valueOf(sc.nextLine().split(" ")[0]);

            String[] numStr = sc.nextLine().split(" ");
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.valueOf(numStr[i]);
            }

        }
    }

}