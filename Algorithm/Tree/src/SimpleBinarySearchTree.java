import sun.security.krb5.internal.APRep;

import java.util.ArrayDeque;

/**
 * 主要通过循环的方式进行树的操作
 */
public class SimpleBinarySearchTree {

    // 二叉查找树,指向根节
    private Node root;

    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        // 输出节点的值+左右孩子的值(如果有的话)
        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + (left==null?"null":left.value) +
                    ", right=" + (right==null?"null":right.value) +
                    '}';
        }
    }

    //将 value 值存入容器
    public boolean put(int value){
        if (root == null){
            // 根节点为空，创建树
            root = new Node(value, null, null);
            return true;
        }

        Node parent = root;
        while (parent != null){
            if(parent.value > value){
                // 当查找值大于该节点值：
                // 左子节点为空，直接插入
                if(parent.left == null){
                    parent.left = new Node(value, null, null);
                    return true;
                }
                // 左子节点不为空，继续查找该节点的左子节点
                parent = parent.left;
            }else if(parent.value < value){
                if (parent.right == null){
                    parent.right = new Node(value, null, null);
                    return true;
                }
                parent = parent.right;
            }else {
                parent.value = value;
                return true;
            }
        }
        return false;
    }

    //根据指定的值查找对应的节点
    public Node find(int value){
        // 从根节点开始遍历
        Node parent = root;

        while (parent != null){
            if(parent.value > value){
                // 当查找值大于该节点值，则往查找该节点的左子节点
                parent = parent.left;
            }else if(parent.value < value){
                // 当查找值小于该节点值，则往查找该节点的右子节点
                parent = parent.right;
            }else{
                // 相等时返回该节点
                return parent;
            }
        }
        return null;
    }

    // 删除节点
    public void remove(int value){
        // 记录要删除的节点
        Node current = root;
        // 记录要删除节点的父节点
        Node parent = null;
        // 先找到要删除的元素及其父元素
        while (current != null){
            if(current.value > value){
                // 当查找值大于该节点值，则往查找该节点的左子节点
                parent = current;
                current = current.left;
            }else if(current.value < value){
                // 当查找值小于该节点值，则往查找该节点的右子节点
                parent = current;
                current = current.right;
            }else {
                break;
            }
        }

        //如果没有找到则返回
        if (current == null){
            return;
        }

        //要删除的节点有两个子节点 这种情况要用右子树中最小节点的值替换当前要删除元素的值，然后删除右侧最小节点
        if (current.right != null && current.right != null){
            // 找到该节点右子树的最小节点----->最左侧的叶子节点
            Node rightTree = current.right;
            // rigthTree 的父节
            Node rightTree_parent = current;
            // 遍历找到要删除节点右子树的最左节点
            while (rightTree.left != null){
                rightTree_parent = current;
                rightTree = rightTree.left;
            }

            // 用右子树中最小的节点替换当前要删除的节点
            current.value = rightTree.value;

            // 要删除的节点与其父节点复制给current与parent，那么后续只需对current和parent进行删除操作即可
            current = rightTree;
            parent = rightTree_parent;
        }

        // 删除节点是叶子节点或者仅有一个子节点, 都是要删除该节点，将父节点的指针指向当前节点的子节点
        Node child = null;
        if (current.right != null){
            child = current.right;
        }else if (current.left != null){
            child = current.left;
        }else {
            child = null;
        }

        //执行删除
        if(parent == null){
            // 要删除的节点没有父节点，即要删除的节点为root节点
            root = child;
        }else if (parent.left == current){
            parent.left = child;
        }else if(parent.right == current){
            parent.right = child;
        }
    }

    public Node getMax(){
        // 从根节点开始遍历
        Node parent = root;

        if(parent == null){
            return null;
        }

        while (parent.right != null){
            parent = parent.right;
        }
        return parent;
    }

    public Node getMin(){
        // 从根节点开始遍历
        Node parent = root;

        if(parent == null){
            return null;
        }

        while (parent.left != null){
            parent = parent.left;
        }
        return parent;
    }


    public static void main(String[] args) {
        SimpleBinarySearchTree tree = new SimpleBinarySearchTree();
        //向容器中添加值
        tree.put(16);
        tree.put(14);
        tree.put(12);
        tree.put(15);
        tree.put(10);
        tree.put(35);
        tree.put(25);
        tree.put(20);
        tree.put(27);
        tree.put(26);
        tree.put(30);
        tree.put(40);
        tree.put(38);
        tree.put(41);
        tree.put(39);

        System.out.println(tree.getMax());
        System.out.println(tree.getMin());
    }
}
