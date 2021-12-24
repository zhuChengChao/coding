import java.util.Arrays;

/**
 *	数据序列中存在重复元素的二分查找的变形写法
 */
public class BinarySearch {

    /**
     * 查找数据序列中第一个等于给定值的元素的下标
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchFirst(int[] array, int value){
        // 定义查找边界 low high
        int low = 0;
        int high = array.length-1;

        // 循环的去判断
        while (low <= high){
            // 计算mid
            int mid = low + ((high-low) >> 1);

            if(array[mid] == value){
                // 由于数据序列是有序的,因此我们向前一位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回 mid
                if(mid == 0 || array[mid-1] != value){
                    return mid;
                }else{
                    high = mid - 1;
                }
            }else if(array[mid] > value){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 从数据序列中查找最后一个值等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchLast(int[] array, int value){
        // 定义查找边界 low high
        int low = 0;
        int high = array.length-1;

        // 循环的去判断
        while (low <= high){
            // 计算mid
            int mid = low + ((high-low) >> 1);

            if(array[mid] == value){
                // 由于数据序列是有序的,因此我们向后位查看一下是否也等于该值,如果相等则继续二分查找,否则直接返回 mid
                if(mid == (array.length - 1) || array[mid+1] != value){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(array[mid] > value){
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 从数据序列中查找第一个大于等于给定值的元素
     * @param array
     * @param value
     * @return
     */
    public static int binarySearchGreatEqual(int[] array, int value){
        // 定义查找边界 low high
        int low = 0;
        int high = array.length-1;

        // 循环的去判断
        while (low <= high) {
            // 计算mid
            int mid = low + ((high - low) >> 1);

            if (array[mid] >= value) {
                if (mid == 0 || array[mid - 1] < value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //准备一个 int 数组 6，12，15，19，24，26，29，29，29，67
        int[] array = new int[]{6, 12, 15, 19, 24, 29, 29, 29, 46, 67};
        System.out.println(Arrays.toString(array));
        // int i = binarySearchFirst(array, 29);
        // int i = binarySearchLast(array, 29);
        int i = binarySearchGreatEqual(array, 29);
        if(i!=-1){
            System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
        }else{
            System.out.println("没找到");
        }
    }
}
