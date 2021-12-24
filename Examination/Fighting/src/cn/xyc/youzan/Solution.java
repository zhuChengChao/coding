package cn.xyc.youzan;

import java.util.*;


public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param s string字符串
//     * @return int整型
//     */
//    public int numDecodings (String s) {
//        // write code here
//
//        int n = s.length();
//
//        // 1.明确状态，dp[i] 表示字符串s[0..i]中能解码的总数
//        int[] dp = new int[n+1];
//
//        // 2.base case
//        if(s.charAt(0) == '0'){
//            return 0;
//        }else{
//            dp[0] = 1;
//            dp[1] = 1;
//        }
//
//        // 3.开始状态转移
//        for (int i = 2; i <=n ; i++) {
//
//            int s1 = (int)s.charAt(i-1) - '0';
//            int s2 = ((int)s.charAt(i-2) - '0') * 10 + s1;
//
//            if(s1 != 0 && (s2 <= 26 && s2 >= 10)){
//                // s1 s2 都能解码
//                dp[i] = dp[i-1] + dp[i-2];
//            }else if(s1 != 0){
//                // s2 不能解码  s1 能解码
//                dp[i] = dp[i-1];
//            }else if(s2 <= 26 && s2 >= 10){
//                // s1 不能解码  s2 能解码
//                dp[i] = dp[i-2];
//            }else{
//                // 存在不能解码的情况出现
//                return 0;
//            }
//        }
//
//        // 4.最终的输出状态的确定
//        return dp[n];
//
//    }

    public boolean method1 (int num) {
        // write code here

        String str = String.valueOf(num);

        // 判断str是否是回文串
        int left = 0, right = str.length()-1;

        while(left < right){

            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        boolean res = new Solution().method1(22622);
        System.out.println(res);
    }
}