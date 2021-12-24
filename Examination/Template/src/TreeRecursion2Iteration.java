import java.util.*;

/**
 * 树的迭代遍历写法：从递归写法 转换为 迭代写法
 *      使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
 *      如果遇到的节点为白色，则将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈。
 *      如果遇到的节点为灰色，则将节点的值输出。
 */
public class TreeRecursion2Iteration {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 树的迭代遍历写法：从递归写法 转换为 迭代写法
    public List<Integer> xxxorderTraversal(TreeNode root){

        // 遍历的结果
        List<Integer> result = new LinkedList<>();
        // 递归体现的栈，在迭代中需要自己来实现了
        Stack<TreeNode> stack = new Stack<>();
        // 标记作用：参数Integer：1-已经被遍历了  0-还没有被遍历  ---> 双色
        Map<TreeNode, Integer> map = new HashMap<>();
        // 根节点入栈
        stack.push(root);
        map.put(root, 0);

        while(!stack.isEmpty()){
            // 节点出栈
            TreeNode node = stack.pop();
            if (node == null){
                continue;
            }

            if (map.get(node) == 0){
                // 这个节点还没有被遍历过
                // 将其标记为灰色，然后将其右子节点、自身、左子节点依次入栈(中序遍历了)

                // ----前序遍历 144 题---- //
                stack.push(node.right);
                stack.push(node.left);
                stack.push(node);

                // ---- 中序遍历 94 题---- //
                // stack.push(node.right);  // 右子节点
                // stack.push(node);        // 自身节点
                // stack.push(node.left);   // 左子节点

                // ----后续遍历 145 题---- //
                // stack.push(node);
                // stack.push(node.right);
                // stack.push(node.left);

                // 标记一下，下一次就是要处理这个节点了
                map.put(node, 1);
                map.put(node.right, 0);
                map.put(node.left, 0);
            }else{
                // 这个已经被遍历过了，则加入result结果中
                // 即：如果遇到的节点为灰色，则将节点的值输出
                result.add(node.val);
            }
        }
        return result;
    }
}
