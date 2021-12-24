import java.util.Arrays;

/**
 * 以下是基于数组的顺序栈的实现代码
 */
public class ArrayStack {
    // 栈大小
    private int size;
    // 默认栈容量
    private int DEFAULT_CAPACITY = 10;
    // 栈数据
    private Object[] elements;
    // 最大栈容量
    private int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    // 默认构造创建大小为10的栈
    public ArrayStack(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    // 通过制定大小创建栈
    public ArrayStack(int capacity){
        elements = new Object[capacity];
    }

    // 入栈
    public boolean push(Object element){
        try {
            checkCapacity(size+1);
            elements[size++]=element;
            return true;
        }catch (RuntimeException e){
            return false;
        }
    }

    // 检查栈容量
    private void checkCapacity(int minCapacity){
        if(elements.length - minCapacity < 0){
            // throw new RuntimeException("栈容量不够了");
            grow(elements.length);
        }
    }

    // 扩容
    private void grow(int oldCapacity){
        int newCapacity = oldCapacity + (oldCapacity>>1);
        if(newCapacity - oldCapacity < 0){
            newCapacity = DEFAULT_CAPACITY;
        }
        if(newCapacity - MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(newCapacity);
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private int hugeCapacity(int newCapacity){
        return (newCapacity>MAX_ARRAY_SIZE)?Integer.MAX_VALUE:newCapacity;
    }

    // 出栈
    public Object pop(){
        if(size <= 0){
            return null;
        }

        Object obj = elements[size-1];
        elements[--size] = null;
        return obj;
    }

    // 获取栈大小
    public int size(){
        return size;
    }


    // 测试代码
    public static void main(String[] args) {

        ArrayStack stack = new ArrayStack();
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
