public class Simple0026 {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i=1; i<nums.length; i++){
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }

        return index+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        int index = new Simple0026().removeDuplicates(nums);
        for (int i = 0; i < index; i++) {
            System.out.println(nums[i]);
        }
    }

}
