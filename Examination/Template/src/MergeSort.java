import java.util.Arrays;

public class MergeSort {

    /**
     *	归并排序算法
     *	归并排序的核心思想还是蛮简单的。
     *	如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，
     *	再将排好序的两部分合并在一起，这样整个数组就都有序了
     */
    private static int[] mergeSort(int[] arr){
        if(arr.length < 2){
            return arr;
        }
        //将数组从中间拆分成左右两部分
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    // 合并两个有序数组并返回新的数组
    private static int[] merge(int[] left, int[] right){
        //创建一个新数组,长度为两个有序数组的长度之和
        int[] newArray = new int[left.length+right.length];
        //定义两个指针,分别代表两个数组的下标
        int lindex = 0;
        int rindex = 0;
        for(int i=0; i<newArray.length;i++){
            if(lindex >= left.length){
                newArray[i] = right[rindex++];
            }else if(rindex >= right.length){
                newArray[i] = left[lindex++];
            }else if(left[lindex] > right[rindex]){
                newArray[i] = right[rindex++];
            }else{
                newArray[i] = left[lindex++];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        //准备一个 int 数组
        int[] array = new int[]{5, 2, 6, 9, 0, 3};
        //进行排序
        System.out.println(Arrays.toString(array));
        array = mergeSort(array);
        //输出排序结果
        System.out.println(Arrays.toString(array));
    }
}