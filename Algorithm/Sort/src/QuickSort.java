import java.util.Arrays;

public class QuickSort {

    public static void quickSort(Integer arr[], int begin, int end){
        // 判断递归截止条件
        if(arr.length <= 1 || begin >= end){
            return;
        }

        // 进行分区 得到分区下标
        int pivotIndex = partition(arr, begin, end);
        // 对分区左侧进行快排
        quickSort(arr, begin, pivotIndex-1);
        // 对分区右侧进行快排
        quickSort(arr, pivotIndex+1, end);
    }

    private static int partition(Integer[] arr, int begin, int end){
        // 默认数组中待分区区间的最后一个是 pivot 元素
        // 当然也可以随机指定 pivot 元素
        int pivot = arr[end];
        // 定义分区后 pivot 元素的下标
        int pivotIndex = begin;
        for (int i = begin; i < end; i++) {
            // 判断如果该区间内如果有元素小于 pivot 则将该元素从区间头开始一直向后填充
            if(arr[i] < pivot){
                if(i > pivotIndex){
                    swap(arr, i, pivotIndex);
                }
                pivotIndex++;
            }
        }
        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer [] array = new Integer[]{5, 2, 6, 9, 0, 3, 4};
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
