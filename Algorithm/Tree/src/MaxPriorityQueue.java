public class MaxPriorityQueue<T extends Comparable<T>> {

    //存储堆中的元素
    private T[] items;
    //记录堆中元素的个数
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity+1];
        this.N = 0;
    }

    //获取队列中元素的个数
    public int size(){
        return this.N;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return this.N == 0;
    }

    private boolean less(int i, int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换堆中i索引和j索引处的值
    private void exch(int i, int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }

    //删除堆中最大的元素,并返回这个最大元素
    public T delMax(){
        T max = items[1];
        exch(1, N);
        N--;
        sink(1);

        return max;
    }

    //使用上浮算法，使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while (k > 1){
            if (less(k, k/2)){
                return;
            }
            exch(k, k/2);
            k = k/2;
        }
    }

    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //通过循环不断的对比当前k结点和其左子结点2*k以及右子结点2k+1处中的较大值的元素大小，如果当前结点小，则需要交换位置
        while (2*k <= N){
            //获取当前结点的子结点中的较大结点
            int max;
            // 有右节点
            if(2*k+1 <= N){
                if(less(2*k, 2*k+1)){
                    max = 2*k+1;
                }else{
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }

            if(!less(k, max)){
                break;
            }

            exch(k, max);
            k = max;
        }
    }

    public static void main(String[] args) {
        //创建优先队列
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<>(10);
        //往队列中存储元素
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        queue.insert("E");
        queue.insert("F");
        queue.insert("G");

        while (!queue.isEmpty()){
            String max = queue.delMax();
            System.out.print(max + " ");
        }
    }

}
