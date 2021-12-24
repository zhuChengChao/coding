package cn.xyc.wangyi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){

            // 获取输入数据
            int n = sc.nextInt();
            int ans = n;
            int res = 0;
            while(ans != 0){

                int tmp = ans % 10;
                ans /= 10;
                if(tmp == 0) continue;

                if(n % tmp == 0){
                    res ++;
                }
            }
            System.out.println(res);
        }
    }
}
