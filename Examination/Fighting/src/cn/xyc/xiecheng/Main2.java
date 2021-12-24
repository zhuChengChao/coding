package cn.xyc.xiecheng;

import javafx.util.Pair;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 完成任务
 */
public class Main2 {

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

            PriorityQueue<Pair<Double, Integer>> minHeap = new PriorityQueue<>(
                    (a, b) ->{
                        return a.getKey().compareTo(b.getKey());
                    }
            );

            for (int i = 0; i < n; i++) {
                Pair<Double, Integer> pair = new Pair(nums[i][0]*1.0/nums[i][1]*1.0, i);
                minHeap.offer(pair);
            }

            // 有体力则进行
            while(k > 0){

                Pair<Double, Integer> peek = minHeap.peek();
                Integer idx = peek.getValue();
                if(nums[idx][0] <= k){
                    minHeap.poll();
                    k -= nums[idx][0];
                }else{
                    break;
                }
            }

            int res = 0;
            while (!minHeap.isEmpty()){
                int tmp = minHeap.poll().getValue();
                if(nums[tmp][0] <= k && k >= 0){
                    k -= nums[tmp][0];
                }else{
                    res += nums[tmp][1];
                }
            }
            System.out.println(res);
        }
    }
}
