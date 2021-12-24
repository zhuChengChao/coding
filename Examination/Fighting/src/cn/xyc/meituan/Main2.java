package cn.xyc.meituan;

import java.util.Scanner;

/**
 * 文件流
 */
public class Main2 {

    public static void main(String[] args) {

         String s = "meituan";
         String a = "uta";

        int res = new Main2().solution(s, a);
        System.out.println(res);

        /*Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            String s = sc.nextLine();
            String a = sc.nextLine();

            int res = new Main2().solution(s, a);
            System.out.println(res);
        }*/


    }

    private int solution(String rand, String need) {

        for(char c: need.toCharArray()){
            if(rand.indexOf(c) < 0){
                return -1;
            }
        }

        int count = 0;
        int res = 0;
        char[] chars = rand.toCharArray();
        while (count != need.length()){

            for(char c: chars){
                if(need.charAt(count) == c){
                    count++;
                    if(count == need.length()){
                        return res;
                    }
                }else{
                    res ++;
                }
            }
        }

        return res;
    }
}
