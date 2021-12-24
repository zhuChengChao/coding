import java.util.*;

public class BFS {

    /*
        对于树的bfs
     */
    void bfs(TreeNode root){
        // 使用双端队列，而不是数组
        Queue<TreeNode> queue = new LinkedList<>();
        // 记录层数
        int steps = 0;
        // 记录遍历的节点
        List<TreeNode> result = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            // 当前层的节点数
            int size = queue.size();
            // 遍历当前层的所有节点数
            for (int i=0; i<size; i++){
                TreeNode node = queue.poll();
                result.add(node);
                // 判断节点是否满足，而决定是否返回等操作
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            steps += 1; // 遍历完一层，层数+1
        }
        return;
    }


    /*
     *  对于图的bfs
     */
    void bfs(Node start, Node target){
        // 使用双端队列，而不是数组
        Queue<Node> queue = new ArrayDeque<>();
        // 注意：ArrayDeque不允许null值，LinkedList允许null值
        // Queue<TreeNode> queue = new LinkedList<>();
        // 记录层数
        int steps = 0;
        // 记录访问过的节点
        Set<Node> visited = new HashSet<>();
        List<Node> result = new LinkedList<>();

        queue.offer(start);
        while(!queue.isEmpty()){
            // 当前层的节点数
            int size = queue.size();
            // 遍历当前层的所有节点数
            for (int i=0; i<size; i++){
                Node node = queue.poll();
                result.add(node);
                // 判断节点是否满足，而决定是否返回等操作
                if(node.val == target.val){
                    // return steps;
                    // return result;
                    return;
                }
                // 将node周围的还未访问过的节点都加入队列中
                for(Node tmp: node.adj())
                    if (!visited.contains(tmp)) {
                        queue.offer(tmp);
                        visited.add(tmp);
                    }
            }
            steps += 1; // 遍历完一层，层数+1
        }
        return;
    }

    public class Node{
        int val;
        Node[] adj;

        public Node(int val, Node[] adj) {
            this.val = val;
            this.adj = adj;
        }

        public Node[] adj() {
            return this.adj;
        }
    }

    // Definition for a binary tree node.
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
}
