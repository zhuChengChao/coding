import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> {

    //判断heap堆中索引i处的元素是否小于索引j处的元素
    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    //交换heap堆中i索引和j索引处的值
    private static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //根据原数组source，构造出堆heap
    private static void createHeap(Comparable[] source, Comparable[] heap){
        //把source中的元素拷贝到heap中，heap中的元素就形成一个无序的堆
        System.arraycopy(source, 0, heap, 1, source.length);

        //对堆中的元素做下沉调整(从长度的一半处开始，往索引1处扫描)
        for (int i = (heap.length)/2; i > 0 ; i--) {
            sink(heap, i, heap.length-1);
        }
    }

    //在heap堆中，对target处的元素做下沉，范围是0~range
    private static void sink(Comparable[] heap, int target, int range){
        while (2*target <=range){
            //1.找出当前结点的较大的子结点
            int max;
            if(2*target+1 <= range){
                if(less(heap,2*target, 2*target+1)){
                    max = 2*target+1;
                }else{
                    max = 2*target;
                }
            }else{
                max = 2*target;
            }

            //2.比较当前结点的值和较大子结点的值
            if(!less(heap, target, max)){
                break;
            }

            // 3. 交换元素
            exch(heap, target, max);
            // 4. 继续后续遍历
            target = max;
        }
    }

    //对source数组中的数据从小到大排序
    public static void sort(Comparable[] source){
        //构建堆
        Comparable[] heap = new Comparable[source.length+1];
        createHeap(source, heap);

        //定义一个变量，记录未排序的元素中最大的索引
        int N = heap.length - 1;
        while (N != 1){
            //交换元素
            exch(heap, 1, N);
            //排序交换后最大元素所在的索引，让它不要参与堆的下沉调整
            N--;
            //需要对索引1处的元素进行对的下沉调整
            sink(heap, 1, N);
        }
        //把heap中的数据复制到原数组source中
        System.arraycopy(heap, 1, source, 0, source.length);
    }


    public static void main(String[] args) {
        // 待排序数组
        String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"};
        // 通过HeapSort对数组中的元素进行排序
        HeapSort.sort(arr);
        // 打印排序后数组中的元素
        System.out.println(Arrays.toString(arr));
    }
}
