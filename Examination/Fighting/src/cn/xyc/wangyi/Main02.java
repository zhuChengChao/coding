package cn.xyc.wangyi;

import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            // 获取输入数据
            long s = sc.nextLong();

            String sbinary = Long.toBinaryString(s);


            if(s == 0){
                System.out.println(-1);
                continue;
            }

            int addRes = 0, subRes = 1;
            for (int i = 0; i < sbinary.length(); i++) {
                if(sbinary.charAt(i) == '0'){
                    subRes ++;
                }else if(sbinary.charAt(i) == '1'){
                    addRes ++;
                }
            }

            System.out.println(Math.min(addRes, subRes));
        }
    }

}
