import java.util.*;
import javafx.util.Pair;


public class Solution {

    public int maxArea(int[] a) {
        int max = 0;
        for(int i = 0, j = a.length - 1; i < j ; ){
            int minHeight = a[i] < a[j] ? a[i ++] : a[j --];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

    public static void main(String[] args) {

        // 字符数组定义
        /*char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };*/
        // String words = "ABCCED";

        char[][] board = {{'a'}};
        String words = "ab";

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{4,3,5,1,2};

        int trap = new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(trap);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
