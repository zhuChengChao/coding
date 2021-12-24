import java.util.Arrays;

/**
 * 基于数组实现的顺序队列
 */
public class ArrayQueue {

    // 存储数据的数组
    private Object[] elements;
    // 队列大小
    private int size;
    // 默认队列容量
    private int DEFAULT_CAPACITY = 10;
    // 队列头指针
    private int head;
    // 队列尾指针
    private int tail;
    // 队列最多元素
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    // 默认构造函数 初始化大小为10的队列
    public ArrayQueue(){
        elements = new Object[DEFAULT_CAPACITY];
        initPointer(0, 0);
    }

    // 通过传入的容量大小创建队列
    public ArrayQueue(int capacity){
        elements = new Object[capacity];
        initPointer(0, 0);
    }

    // 初始化队列头尾指针
    private void initPointer(int head, int tail){
        this.head = head;
        this.tail = tail;
    }

    // 元素入队列
    public boolean enqueue(Object element){
        ensureCapacityHelper();
        elements[tail++]=element;  //在尾指针处存入元素且尾指针后移
        size++;  //队列元素个数加1
        return true;
    }

    // 容量确定
    private void ensureCapacityHelper(){
        // 尾指针已越过数组尾端
        if(tail==elements.length){
            // 判断队列是否已满即判断数组中是否还有可用存储空间
            if(head == 0){
                // 当队列头为0时，说明此时队列已满，需要进行扩容
                grow(elements.length);
            }else{
                // 否则，进行数据搬移操作将数组中的数据依次向前挪动直至顶部
                for (int i=head;i<tail;i++){
                    elements[i-head]=elements[i];
                }
                //数据搬移完后重新初始化头尾指针
                initPointer(0, tail-head);
            }
        }
    }

    // 扩容
    private void grow(int oldCapacity){
        int newCapacity = oldCapacity + (oldCapacity>>1);
        if(newCapacity - oldCapacity<0){
            newCapacity = DEFAULT_CAPACITY;
        }
        if(newCapacity-MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(newCapacity);
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }


    private int hugeCapacity(int newCapacity){
        return (newCapacity>MAX_ARRAY_SIZE)?Integer.MAX_VALUE:newCapacity;
    }

    //出队列
    public Object dequeue(){
        if(head==tail){
            return null;
        }
        Object obj = elements[head++];
        size--;
        return obj;
    }

    //测试代码
    public static void main(String[] args) {
        ArrayQueue queue =  new  ArrayQueue(4);
        //入队列
        queue.enqueue("itcast1");
        queue.enqueue("itcast2");
        queue.enqueue("itcast3");
        queue.enqueue("itcast4");
        //此时入队列应该走扩容的逻辑
        queue.enqueue("itcast5");
        queue.enqueue("itcast6");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //此时入队列应该走数据搬移逻辑
        queue.enqueue("itcast7");
        //出队列
        System.out.println(queue.dequeue());
        //入队列
        queue.enqueue("itcast8");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        //入队列
        queue.enqueue("itcat9");
        queue.enqueue("itcat10");
        queue.enqueue("itcat11");
        queue.enqueue("itcat12");
        //出队列
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
