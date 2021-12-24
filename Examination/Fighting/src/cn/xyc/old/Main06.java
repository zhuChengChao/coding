package cn.xyc.old;

import java.util.*;

public class Main06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];

            int meiHouse = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if(a[i] == 0){
                    meiHouse = i;
                }
            }

            int left_dist = 0, right_dist = 0;

            for(int i=meiHouse+1; i<n; i++){
                if(a[i] <= k){
                    right_dist = i;
                    break;
                }
            }

            for(int i=meiHouse-1; i>=0; i--){
                if(a[i] <= k){
                    left_dist = i;
                    break;
                }
            }

            if( right_dist - meiHouse < meiHouse - left_dist){
                System.out.println(right_dist+1);
            }else{
                System.out.println(left_dist+1);
            }
        }
    }
}
