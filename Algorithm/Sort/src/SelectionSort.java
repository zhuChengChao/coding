import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(Integer[] array){
        int len = array.length;
        if(len <= 1){
            return;
        }

        for (int i = 0; i < len; i++) {
            // 接下来找到未排序区间的最小值的下标
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Integer[] a = {4, 5, 6, 3, 2, 1};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
