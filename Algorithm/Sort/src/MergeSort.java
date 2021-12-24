import java.util.Arrays;

public class MergeSort {

    public static int[] mergeSort(int[] array){
        if(array.length < 2){
            return array;
        }

        //将数组从中间拆分成左右两部分
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        // 继续递归拆分left与right数组，直到len=1，后再进行merge
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right){
        //创建一个新数组,长度为两个有序数组的长度之和
        int[] newArray = new int[left.length + right.length];
        //定义两个指针,分别代表两个数组的下标
        int lindex = 0;
        int rindex = 0;
        for (int i = 0; i < newArray.length; i++) {
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
        int [] array = new int[]{5, 2, 6, 9, 0, 3};
        System.out.println(Arrays.toString(array));
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
