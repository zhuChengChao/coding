import java.util.*;

public class TopKHeap {

    // 1.java中有优先队列的实现：默认是小顶堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);

    // 2.修改一下：变成大顶堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, (a, b) -> b-a);

    // 3.有如下：固定一个大小为 k 的大顶堆可以快速求第 k 小的数
    // 4.固定一个大小为 k 的小顶堆可以快速求第 k 大的数

    /*  以下为固定一个大小为k的大顶堆可以找出最小的k个数
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b-a);

    for(int i=0; i<arr.length; i++){

    if(minHeap.size() < k){
            minHeap.offer(arr[i]);
        }else{
            if(minHeap.peek() > arr[i]){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
    }

    int[] res = new int[minHeap.size()];
    int idx = 0;
        while(!minHeap.isEmpty()){
        res[idx++] = minHeap.poll();
    }
    return res;*/

}
