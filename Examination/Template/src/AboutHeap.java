import java.util.PriorityQueue;

public class AboutHeap {

    public static void main(String[] args) {

        // 1.java中有优先队列的实现：默认是小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);

        // 2.修改一下：变成大顶堆
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3, (a, b) -> b-a);
        // 或者
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        maxHeap.offer(1);
        maxHeap.offer(2);
        maxHeap.offer(3);

        System.out.println(maxHeap.poll());  // 1
        System.out.println(maxHeap.poll());  // 2
        System.out.println(maxHeap.poll());  // 3


        // 3.构造函数如下：
        // public PriorityQueue(int initialCapacity,
        //                      Comparator<? super E> comparator) {
        //     // Note: This restriction of at least one is not actually needed,
        //     // but continues for 1.5 compatibility
        //     if (initialCapacity < 1)
        //         throw new IllegalArgumentException();
        //     this.queue = new Object[initialCapacity];
        //     this.comparator = comparator;
        // }
    }
}
