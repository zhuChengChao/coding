public class Simple1480 {
    public static int[] runningSum(int[] nums) {
        for (int i=1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

    }
}
