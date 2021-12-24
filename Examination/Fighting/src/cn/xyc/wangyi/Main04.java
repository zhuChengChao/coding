package cn.xyc.wangyi;

import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){

            String[] split = sc.nextLine().split(" ");
            int n = Integer.valueOf(split[0]);
            int a = Integer.valueOf(split[1]);
            int b = Integer.valueOf(split[2]);

            char[][] migong = new char[n][n];
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < str.length(); j++) {
                    migong[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < migong.length; i++) {
                for (int j = 0; j < migong[0].length; j++) {

                }
            }

            System.out.println(0);
        }
    }
}
