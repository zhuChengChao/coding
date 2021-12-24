public class Simple0027 {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0)
            return 0;

        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[p] = nums[i];
                p++;
            }
        }

        return p;
    }

    public int removeElement2(int[] nums, int val) {

        int i = 0;
        int n = nums.length;

        while (i<n){
            if (nums[i] == val){
                nums[i] = nums[n-1];
                n--;
            }else {
                i++;
            }
        }
        return i;
    }

        public static void main(String[] args) {
        int[] nums = new int[] {3,2,2,3};
        // int index = new Simple0027().removeElement(nums, 3);
        int index = new Simple0027().removeElement2(nums, 3);
        for (int i = 0; i < index; i++) {
            System.out.println(nums[i]);
        }
    }

}
