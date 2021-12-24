package cn.xyc.old;

import java.util.*;

public class Main02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] a = new int[n];

            List<Integer> meiHouses = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();

                if(a[i] == 0){
                    meiHouses.add(i);
                }
            }

            int res = Integer.MAX_VALUE;
            int tuanHouse = 0;
            for(int meiHouse: meiHouses){
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

                int temp_index = 0;
                if( right_dist - meiHouse < meiHouse - left_dist){
                    // System.out.println(right_dist+1);
                    temp_index = right_dist;
                }else{
                    // System.out.println(left_dist+1);
                    temp_index = left_dist;
                }

                if(Math.abs(meiHouse - temp_index) < res){
                    res = Math.abs(meiHouse - temp_index);
                    tuanHouse = temp_index;
                }
            }

            System.out.println(tuanHouse+1);
        }
    }
}

