import java.util.Arrays;

/**
 *	二分查找的简单实现
 */
public class SimpleBinarySearch {

    // 使用非递归的形式查找
    public static int cicleBinarySearch(int[] array, int value){
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            // 计算中间元素的下标
            int mid = (low + high) / 2;
            if(array[mid] == value){
                return mid;
            }else if(array[mid] > value){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        // 如果至此还未找到则返回-1 代表未找到匹配的元素
        return -1;
    }

    // 使用递归的形式查找
    public static int recursionBinarySearch(int[] array, int value, int low, int high){
        if(low > high){
            return -1;
        }
        // 计算中间元素的下标
        int mid = low + (high-low)>>2;
        if(array[mid] == value){
            return mid;
        }else if(array[mid] > value){
            return recursionBinarySearch(array, value, low, mid-1);
        }else {
            return recursionBinarySearch(array, value, mid+1, high);
        }
    }

    public static void main(String[] args) {
        //准备一个 int 数组 6，12，15，19，24，26，29，35，46，67
        int[] array = new int[]{6, 12, 15, 19, 24, 26, 29, 35, 46, 67};

        System.out.println(Arrays.toString(array));
        // int i = cicleBinarySearch(array, 15);
        int i = recursionBinarySearch(array, 15, 0, array.length-1);
        if(i!=-1){
            System.out.println("找到了目标元素的下标:"+i+"---对应的值为:"+array[i]);
        }else{
            System.out.println("没找到");
        }
    }
}
