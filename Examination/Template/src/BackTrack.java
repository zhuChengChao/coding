import java.util.*;

public class BackTrack {

    /*
        List<List<...>> res = new LinkedList<>();
        // List<...> res = new LinkedList<>();

        void backtrack(路径, 选择列表){
            if(满足结束条件){
                res.add(路径);
                return;
            }

            for(选择 :选择列表){
                // 做选择
                backtrack(路径, 选择列表)
                // 撤销选择
            }
        }
     */


    // 全排列的例子
    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 输入：选择列表, 路径
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 前序：做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 后序：取消选择
            track.removeLast();
            // 注意：若要用reomve的话，track.remove(i)是错误的，应该是track.remove(Integer.valueOf(i));
        }
    }
}
