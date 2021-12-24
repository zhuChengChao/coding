import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] array){

        int len = array.length;
        if (len <= 1){
            return;
        }

        //开始排序
        for (int i = 0; i < len; i++) {
            // 取出未排序的下一个元素，及当前参与比较的元素
            int current = array[i];
            // 在已经排序的元素序列中从后向前扫描,定义前置索引
            int preIndex = i - 1;
            // 从后向前依次和当前元素进行比较
            while (preIndex >= 0 && current < array[preIndex]){
                // 比较过程中如果排序数组元素大于待排序元素则将元素后移一位
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            // 比较过程中如果该元素小于等于当前元素,则将当前元素放在该元素后面
            array[preIndex+1] = current;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 3, 2, 1};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
