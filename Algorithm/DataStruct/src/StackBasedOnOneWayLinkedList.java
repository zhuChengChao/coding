/**
 * 基于单向链表的链式栈的实现
 */
public class StackBasedOnOneWayLinkedList {

    // 栈大小
    private int size;
    // 存储链头结点
    private Node head;

    public StackBasedOnOneWayLinkedList() {
        this.head = null;
    }

    // 入栈
    public boolean push(Object data){
        Node newNode = new Node(data, head);
        head = newNode;
        return true;
    }

    // 出栈
    public Object pop(){
        if(head == null){
            return null;
        }

        Node topNode = head;
        head = head.next;
        return topNode.data;
    }


    // 节点数据
    private class Node{
        // 节点数据
        private Object data;
        // 后继节点
        private  Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Object getData(){
            return data;
        }
    }

    // 测试
    public static void main(String[] args) {
        StackBasedOnOneWayLinkedList stack = new StackBasedOnOneWayLinkedList();
        for (int i = 0; i < 5; i++) {
            stack.push(i+"");
            System.out.println("第"+(i+1)+"次入栈，入栈值为："+i);
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("取出的结果为：" + stack.pop());
        }
    }
}
