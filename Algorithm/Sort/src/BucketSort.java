import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BucketSort {

    /**
     *	桶排序
     * @param array	待排序集合
     * @param bucketSize 每个桶所能放置多少个不同数值（例如当 BucketSize=5 时，该桶可以存放｛1,2,3,4,5｝这几种数字，但是容量不限，即可以存放 100 个 3）
     * @return	排好序后的集合
     */
    public static List<Integer> bucketSort(List<Integer> array, int bucketSize){
        if (array == null || array.size() < 2 || bucketSize < 1){
            return array;
        }

        int max = array.get(0);
        int min = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            Integer temp = array.get(i);
            if(temp > max){
                max = temp;
            }
            if(temp < min){
                min = temp;
            }
        }

        // 计算桶的个数 `最大值-最小值` 代表了集合中元素取值范围区间
        int bucketCount = (max - min)/bucketSize + 1;
        // 按序创建桶, 创建一个List, List带下标是有序的, List中的每一个元素是一个桶, 也用List表示
        List<List<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketList.add(new ArrayList<>());
        }
        // 将待排序的集合依次添加到对应的桶中
        for (int j = 0; j < array.size(); j++) {
            int bucketIndex = (array.get(j) - min) / bucketSize;
            bucketList.get(bucketIndex).add(array.get(j));
        }
        // 对每一个桶中的数据进行排序(可以使用别的排序方式)
        // 然后再将桶中的数据依次取出存放到一个最终的集合中
        // 创建最终的集合
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            List<Integer> everyBucker = bucketList.get(i);
            // 如果桶内有元素
            if(everyBucker.size() > 0){

                // 方式1：递归使用桶排序
                // if(bucketCount == 1){
                //     // 当某次桶排序待排序集合都分配到一个桶中时,缩小桶的范围以获得更多的桶
                //     bucketSize--;
                // }
                // // 递归的使用桶排序为每一个桶进行排序-->最后都只做到每个桶中只有一个元素
                // List<Integer> tmp = bucketSort(everyBucker, bucketSize);


                // 方式2：使用其他排序方式--->使用了快排
                Integer[] arr = everyBucker.toArray(new Integer[everyBucker.size()]);
                QuickSort.quickSort(arr, 0, everyBucker.size()-1);
                List<Integer> tmp = Arrays.asList(arr);

                resultList.addAll(tmp);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 2, 6, 9, 0, 3, 4);
        System.out.println(list);
        List<Integer> bucketSort = bucketSort(list, 4);
        System.out.println(bucketSort);
    }
}
