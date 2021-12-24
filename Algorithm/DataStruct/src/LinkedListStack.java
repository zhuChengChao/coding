/**
 * 基于链表的链式栈的实现
 */
public class LinkedListStack {

    // 栈大小
    private int size;
    // 存储链表尾结点
    private Node tail;

    public LinkedListStack() {
        this.tail = null;
    }

    // 入栈
    public boolean push(Object data){
        Node newNode = new Node(tail, data, null);
        if(size > 0){
            tail.next = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }

    // 出栈
    public Object pop(){
        if((size-1)<0){
            return null;
        }
        Object data = tail.getData();
        tail = tail.prev;
        if(tail != null){
            tail.next = null;
        }
        size--;
        return data;
    }


    // 节点定义
    private class Node{
        // 前驱节点
        public Node prev;
        // 节点数据
        private Object data;
        // 后继节点
        private  Node next;

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Object getData(){
            return data;
        }
    }

    // 测试代码
    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 13; i++) {
            boolean push = stack.push(i);
            System.out.println("第"+(i+1)+"次存储数据为："+i+"，存储结果是："+push);
        }

        System.out.println("\n");

        for (int i = 0; i < 11; i++) {
            Object pop = stack.pop();
            System.out.println("第"+(i+1)+"次出栈的数据为："+pop);
        }
    }

}
