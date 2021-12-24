/**
 * 记录一下dfs的模版，摘录算法流程：
 *      1. 首先将根节点放入 stack** 中。
 *      2. 从 **stack** 中取出第一个节点，并检验它是否为目标。
 *          如果找到所有的节点，则结束搜寻并回传结果。
 *          否则将它某一个尚未检验过的直接子节点加入**stack**中。
 *      3. 重复步骤 2。
 *      4. 如果不存在未检测过的直接子节点。将上一级节点加入**stack**中，重复步骤 2。
 *      5. 重复步骤 4。
 *      6. 若**stack**为空，表示整张图都检查过了——亦即图中没有欲搜寻的目标。结束搜寻并回传“找不到目标”。
 */
public class DFS {

    // 一个典型的通用的 DFS 模板可能是这样的
    /**
    boolean[] visited;
    void dfs(int i) {
        if (满足特定条件）{
            // 返回结果 or 退出搜索空间
        }

        visited[i] = true // 将当前状态标为已搜索
        for (根据i能到达的下个状态j) {
            if (!visited[j]) { // 如果状态j没有被搜索过
                dfs(j)
            }
        }
    }
    */

    // 但是树不存在环，因此不需要visited，因此一个树的 DFS 更多是
    /**
    void dfs(TreeNode root) {
        if (满足特定条件）{
            // 返回结果 or 退出搜索空间
        }
        for (TreeNode child: root.children) {
            dfs(child)
        }
    }
     */

    // 而几乎所有的题目几乎都是二叉树，因此下面这个模板更常见
    /**
    void dfs(TreeNode root) {
        if (满足特定条件）{
            // 返回结果 or 退出搜索空间
        }
        // 主要处理逻辑在此：前序遍历
        dfs(root.left);
        dfs(root.right);
        // 主要处理逻辑在此：后续遍历
    }
     */
}
