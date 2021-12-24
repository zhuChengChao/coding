import java.util.Arrays;

public class MinHeap{

    // 堆
    private int[] datas;
    // 堆中已存储的元素个数
    private int size = 0;

    public MinHeap(int initialCapacity){
        if (initialCapacity < 1)
            throw new IllegalArgumentException();

        this.datas = new int[initialCapacity + 1];
    }

    public MinHeap(int[] array){
        this.size = array.length;
        this.datas = new int[array.length + 1];

        int i=1;
        for(int val: array){
            this.datas[i++] = val;
        }
    }

    // 向堆中插入元素
    public void push(int val){
        if(size == this.datas.length-1){
            this.datas = Arrays.copyOf(this.datas, size*2 + 1);
        }
        this.datas[++size] = val;
        swim(size);
    }

    // 堆中取出元素
    public int peek(){
        return this.datas[1];
    }

    // 弹出堆中元素
    public int pop(){
        // 弹出堆顶元素
        int res = this.datas[1];
        // 移除完成后要保证堆的完整性，需要寻找第二大的元素放到堆顶
        // 1.将最后一个元素直接放在堆顶，并减少数据
        this.datas[1] = this.datas[size--];
        // 2.堆化让其继续成为一个合格的堆，此时需要自上而下堆化
        sink(1);

        return res;
    }

    // 建堆
    public void buildHeap(){
        // 对堆中的元素做下沉调整(从长度的一半处开始，往索引1处扫描)
        for (int i = (this.datas.length)/2; i > 0; i--) {
            sink(i);
        }
    }

    // 上浮操作
    private void swim(int end){
        int i = end;
        while( i/2 >0 && this.datas[i/2] > this.datas[i]){
            // 有父节点，且父节点的值大于该节点，则交换
            swap(i, i/2);
            i /= 2;
        }
    }

    // 下沉操作
    private void sink(int start){

        // 通过循环不断的对比当前k结点和其左子结点2*k以及右子结点2k+1处中的较大值的元素大小，
        // 如果当前结点大，则需要交换位置
        while (2*start <= size){

            int min;
            if(2*start+1 <= size){
                // 有右节点的情况
                if(this.datas[2*start] < this.datas[2*start+1]){
                    // 左节点更小
                    min = 2*start;
                }else{
                    // 右节点更小
                    min = 2*start+1;
                }
            }else{
                // 无右节点的情况
                min = 2*start;
            }

            // 与当前节点比较判断是否需要交换
            if(this.datas[start] < this.datas[min]){
                break;
            }
            // 需要交换
            swap(start, min);
            start = min;
        }
    }

    private void swap(int i, int j){
        int tmp = this.datas[i];
        this.datas[i] = this.datas[j];
        this.datas[j] = tmp;
    }

    public static void main(String[] args) {

        int arr[] = new int[]{2,7,4,1,8,1};
        MinHeap heap = new MinHeap(arr);
        heap.buildHeap();
        System.out.println(heap.peek());
        heap.push(5);
        heap.push(10);
        heap.push(3);
        while (heap.size > 0) {
            int num = heap.pop();
            System.out.printf(num + "");
        }
    }
}