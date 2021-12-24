import java.util.ArrayDeque;
import java.util.Queue;

public class PagerFolding {

    //结点类
    private static class Node<T>{
        public T item; //存储元素
        public Node left;
        public Node right;

        public Node(T item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    //通过模拟对折N次纸，产生树
    public static Node<String> createTree(int N){
        //定义根结点
        Node<String> root = null;

        for (int i = 0; i < N; i++) {
            //1.当前是第一次对折
            if (i == 0){
                root = new Node<>("down", null, null);
            }

            //2.当前不是第一次对折
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(root);

            //循环遍历队列
            while (!queue.isEmpty()){
                //从队列中弹出一个结点
                Node node = queue.poll();
                //如果有左子结点，则把左子结点放入到队列中
                if (node.left != null){
                    queue.add(node.left);
                }
                //如果有右子结点，则把右子结点放入到队列中
                if(node.right != null){
                    queue.add(node.right);
                }

                //如果同时没有左子结点和右子结点，那么证明该节点是叶子结点，只需要给该节点添加左子结点和右子结点即可
                if(node.right==null && node.left==null){
                    node.left = new Node<String>("down", null, null);
                    node.right = new Node<String>("up", null, null);
                }
            }
        }
        return root;
    }

    //打印树中每个结点到控制台
    public static void printTree(Node<String> root){
        //需要使用中序遍历完成
        if(root==null){
            return;
        }

        //打印左子树的每个结点
        if(root.left!=null){
            printTree(root.left);
        }
        //打印当前结点
        System.out.print(root.item+" ");
        //打印右子树的每个结点
        if(root.right!=null){
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        //模拟折纸过程，产生树
        Node<String> tree = createTree(3);

        //遍历树，打印每个结点
        printTree(tree);
    }

}
