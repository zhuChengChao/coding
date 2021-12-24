import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort1(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j=0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    Integer temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] array){
        if(array.length<=1){
            return;
        }

        // 开始冒泡
        for (int i = 0; i < array.length; i++){
            // 是否需要提前结束冒泡的标识
            boolean flag = true;
            for (int j = 0; j < array.length-i-1; j++){
                if(array[j] > array[j+1]){
                    Integer temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                    flag = false;
                }
            }
            // 在当前这次冒泡中如果所有元素都不需要进行交换则证明所有元素都已有序,则无需进行后续的冒泡操作了
            if(flag){
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {4, 5, 6, 3, 2, 1};
        // bubbleSort1(a);
        bubbleSort2(a);
        System.out.println(Arrays.toString(a));
    }

}
