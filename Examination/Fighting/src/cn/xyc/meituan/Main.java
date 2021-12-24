package cn.xyc.meituan;

import java.util.HashSet;
import java.util.Set;

/**
 * 丁香树
 */
public class Main {

    public static void main(String[] args) {

        int n = 10;
        int[] nums = {1,1,2,2,2,3,3,3,3,1};


        int solution = new Main().solution(n, nums);
        System.out.println(solution);

    }

    public int solution(int n, int[] nums){

        // 最大的芳香值
        int maxSmeil = nums[0];
        // 存所有出现过的
        Set<Integer> smeils = new HashSet<>();
        smeils.add(maxSmeil);

        // 最终结果
        int res = 0;

        // 开始遍历
        for (int i = 1; i < n; i++) {
            // 先把芳香值加入，set自动去重
            smeils.add(maxSmeil);
            if(nums[i] > maxSmeil){
                maxSmeil = nums[i];
                res += smeils.size();
            }else if(nums[i] == maxSmeil){
                res += smeils.size()-1;
            }
        }

        return res;
    }
}
