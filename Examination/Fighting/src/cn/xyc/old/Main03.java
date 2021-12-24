package cn.xyc.old;

public class Main03 {

    public static void main(String[] args) {
        System.out.println(new Main03().canCompleteRace(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public int canCompleteRace (int[] e, int[] c) {
        // write code here
        int[] arr1 = new int[e.length*2];
        int[] arr2 = new int[c.length*2];
        for (int i = 0; i < e.length; i++) {
            arr1[i]=e[i];
            arr1[e.length*2-i-1]=e[e.length-i-1];
        }
        for (int i = 0; i < e.length; i++) {
            arr2[i]=c[i];
            arr2[c.length*2-i-1]=c[c.length-i-1];
        }
        return getResult(arr1,arr2,e.length);
    }

    private int getResult(int[] arr1, int[] arr2, int length) {
        for (int i = 0; i < arr1.length; i++) {
            int init = 0;
            for (int j = i; j <arr2.length ; j++) {
                int temp = init+arr1[j]-arr2[j];
                if (temp<0){
                    break;
                }else {
                    init=temp;
                }
                if (j-i==length-1){
                    return i;
                }
            }
        }
        return -1;
    }

}
