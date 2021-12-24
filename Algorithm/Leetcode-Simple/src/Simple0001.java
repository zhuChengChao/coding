import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Simple0001 {

    // 暴力解法
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                int result = nums[i] + nums[j];
                if (result == target){
                    int[] indexs = new int[2];
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return null;
    }

    // hash解法
    public int[] twoSum_2(int[] nums, int target){
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target-nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        //int[] indexs = new Simple0001().twoSum(nums, target);
        int[] indexs = new Simple0001().twoSum_2(nums, target);
        System.out.println(Arrays.toString(indexs));
    }

}
