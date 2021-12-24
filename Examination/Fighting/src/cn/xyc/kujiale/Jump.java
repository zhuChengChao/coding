package cn.xyc.kujiale;

public class Jump {


    /**
     * 判断是否能达到最后的位置
     * @param nums  输入的数组
     * @return      是否能到达
     */
    public boolean isGet(int[] nums){

        // 获取数组长度
        int n = nums.length;

        // 记录初始能到达的位置
        int step = nums[0];

        for(int i=1; i<n; i++){
            // 跳到下一个位置
            step -= 1;

            if(step < 0){
                // 无法到达了
                return false;
            }

            if(step < nums[i]){
                // 当前位置能跳的距离比持有的大，则更新
                step = nums[i];
            }
        }

        return step > 0 ? true : false;
    }


    public static void main(String[] args) {

        int[] nums = {2,2,1,1,0,5};
        boolean get = new Jump().isGet(nums);

        System.out.println("是否能到：" + get);
    }
}
