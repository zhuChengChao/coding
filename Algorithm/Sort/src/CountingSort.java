import java.util.Arrays;

public class CountingSort {


    public static void countingSort(Integer[] array){
        // 求出待排序数组的最大值,最小值,找出取值区间
        int max = array[0];
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }

        // 定义一个额外的数组 C
        int bucketSize = max - min + 1;
        int[] bucket = new int[bucketSize];
        // 统计对应元素的个数,数组的下标不是单纯的值
        for (int i = 0; i < array.length; i++) {
            bucket[array[i]-min]++;
        }
        // 对数组 C 内元素进行累加
        for (int i = 1; i < bucketSize; i++) {
            bucket[i] += bucket[i-1];
        }
        // 创建临时数组R存储最终有序的数据列表
        int[] temp = new int[array.length];
        // 逆序扫描待排序数组 可保证元素的稳定性
        for (int i=array.length-1; i >= 0; i--) {
            int count = --bucket[array[i] - min];
            temp[count] = array[i];
        }

        //将临时数据列表依次放入原始数组
        for(int i=0;i<temp.length;i++){
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 6, 9, 0, 3, 3, 4};
        System.out.println(Arrays.toString(array));
        countingSort(array);
        System.out.println(Arrays.toString(array));
    }
}
