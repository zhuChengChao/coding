package cn.xyc.old;

import java.util.*;


public class Solution {

    Map<Integer, Integer> cache = new HashMap<>();

    public int coinChange(int[] coins, int amount) {

        return dp(amount, coins);
    }

    private int dp(int amount, int[] coins){

        if(cache.containsKey(amount)){
            return cache.get(amount);
        }

        if(amount == 0){
            return 0;
        }

        int res = 100000;
        for(int i=0; i<coins.length; i++){
            if(amount < coins[i]){
                continue;
            }

            int temp = dp(amount-coins[i], coins);

            res = Math.min(res, temp);
        }

        int result = res==100000 ? -1: res;
        cache.put(amount, result);
        return result;
    }

    public static void main(String[] args) {

        // int[][] arrays = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        // int[][] arrays = new int[][]{{-5}};
        int[] array = new int[]{1,2,5};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        int res = new Solution().coinChange(array, 11);
        System.out.println(res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}