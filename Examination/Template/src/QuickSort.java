import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序算法
     * 1：从数列中挑出一个元素，称为 “基准”（pivot）；
     * 2：重新排序数列，所有元素比基准值小的摆放在基准前面，
     *    所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
     *    在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     */
    // 快排 借助递归和分区的思想来实现
    public static void quickSort(int arr[], int begin, int end){
        // 判断递归截止条件
        if(arr.length <= 1 || begin>=end){
            return;
        }

        // 进行分区 得到分区下标
        int pivotIndex = partition(arr, begin, end);
        // 对分区左侧进行快排
        quickSort(arr, begin, pivotIndex-1);
        // 对分区右侧进行快排
        quickSort(arr, pivotIndex+1, end);
    }

    private static int partition(int[] arr, int begin, int end){
        // 默认数组中待分区区间的最后一个是 pivot 元素
        // 当然也可以随机指定 pivot 元素
        int	pivot = arr[end];
        // 定义分区后 pivot 元素的下标
        int pivotIndex = begin;
        for(int i=begin; i<end; i++){
            // 判断如果该区间内如果有元素小于 pivot 则将该元素从区间头开始一直向后填充 有点类似选择排序
            if(arr[i] < pivot){
                if(i>pivotIndex){
                    swap(arr, i, pivotIndex);
                }
                pivotIndex++;
            }
        }

        swap(arr, pivotIndex, end);
        return pivotIndex;
    }

    // 交换数组内下标为 i j 的两个元素
    private static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        //准备一个 int 数组
        int[] array = new int[]{3,2,3,1,2,4,5,5,6};
        //进行排序
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}