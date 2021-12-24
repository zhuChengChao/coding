public class Simple0035 {

    public int searchInsert(int[] nums, int target) {

//        if(nums[0] >= target){
//            return 0;
//        }
//        if (nums[nums.length-1] <= target){
//            return nums.length;
//        }
//
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i] >= target){
//                if (nums[i-1] == target){
//                    return i-1;
//                }else {
//                    return i;
//                }
//            }
//        }
//
//        return 0;

        // 二分查找法
        int n = nums.length;
        int l = 0, r = n-1;
        while (l <= r){
            int mid = (l+r)/2;
            if (nums[mid] < target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3};
        int i = new Simple0035().searchInsert(nums, 3);
        System.out.println(i);
    }

}
