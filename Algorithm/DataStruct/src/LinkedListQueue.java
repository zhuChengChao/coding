/**
 * 基于链表实现的顺序队列
 */
public class LinkedListQueue {

    // 队列元素个数
    private int size;
    // 头结点
    private Node head;
    // 头结点
    private Node tail;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    // 入队列
    public boolean enqueue(Object data){
        Node newNode = new Node(data, null);
        if(tail == null){
            tail = newNode;
            head = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    // 出队列
    public Object dequeue(){
        if(head==null){
            return null;
        }
        Object data = head.data;
        head = head.next;
        if(head==null){
            tail = null;
        }
        size--;
        return data;
    }

    // 获取队列size
    public int getSize(){
        return size;
    }

    // 节点定义
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
        LinkedListQueue queue =  new  LinkedListQueue();
        System.out.println(queue.dequeue());
        queue.enqueue("itcast1");
        queue.enqueue("itcast2");
        queue.enqueue("itcast3");
        queue.enqueue("itcast4");
        queue.enqueue("itcast5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue("itcast6");
        queue.enqueue("itcast7");
        queue.enqueue("itcast8");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
