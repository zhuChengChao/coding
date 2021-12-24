import java.util.Arrays;

/**
 * 希尔排序算法：https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class ShellSort {

    /**
     * 希尔排序 针对有序序列在插入时采用交换法
     * @param arr
     */
    public static void sortCmp(int []arr){
        // 增量gap，并逐步缩小增量
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for(int i = gap; i < arr.length; i++){
                int j = i;
                while(j-gap >= 0 && arr[j] < arr[j-gap]){
                    // 插入排序采用交换法
                    swap(arr, j, j-gap);
                    j -= gap;
                }
            }
        }
    }

    /**
     * 希尔排序 针对有序序列在插入时采用移动法。
     * @param arr
     */
    public static void sortMove(int arr[]){
        // 增量gap，并逐步缩小增量
        for(int gap = arr.length/2; gap > 0; gap /= 2){
            // 从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i < arr.length; i++){
                int j = i;
                int temp = arr[j];
                if(arr[j] < arr[j-gap]){
                    while (j-gap >= 0 && arr[j-gap] > arr[j]) {
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                }
                arr[j] = temp;
            }
        }
    }


    public static void swap(int[] arr, int a, int b){
        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    // 测试代码
    public static void main(String[] args) {
        int[] a = {9,1,2,5,7,4,8,6,3,5};
        // sortCmp(a);
        sortMove(a);
        System.out.println(Arrays.toString(a));
    }
}
