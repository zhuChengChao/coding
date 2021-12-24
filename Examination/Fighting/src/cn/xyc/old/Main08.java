package cn.xyc.old;

import java.util.*;

public class Main08 {

    static int res = 0;

    public static void main(String[] args) {

        int lines = 1;
        int[] nums = {2, 0, 0, 0, 1, 1, 1};

        int n = nums[0];
        int[] xyz_1 = Arrays.copyOfRange(nums, 1, 4);
        int[] xyz_2 = Arrays.copyOfRange(nums, 4, 7);

        int[] track = new int[3];
        backtrack(track, 0, xyz_1, xyz_2, n);

        System.out.println(res);
    }

    private static void backtrack(int[] track, int idx, int[] xyz_1, int[] xyz_2, int n) {

        if(track.toString().equals(xyz_1.toString())){
            // 失败
            res = 1;
        }

        if(track.toString().equals(xyz_2.toString())){
            // 可以存在
            res = 2;
        }

        if(track[0] > n || track[1] > n || track[2] > n) return;

        for(int i=0; i<4; i++){

            int[] temp_track = track;
            track = changes(track, i);
            backtrack(track, i+1, xyz_1, xyz_2, n);
            track = temp_track;
        }
    }

    /**
     * 可以进行的变换
     * @param arr
     * @param mode 0~3对应的4种变换
     * @return
     */
    private static int[] changes(int[] arr, int mode){

        int[] res = new int[3];
        switch (mode){
            case 0:
                res[0] = arr[1];
                res[1] = arr[0];
                res[2] = arr[2];
                break;
            case 1:
                res[0] = arr[0];
                res[1] = arr[2];
                res[2] = arr[1];
                break;
            case 2:
                res[0] = arr[2];
                res[1] = arr[1];
                res[2] = arr[0];
                break;
            case 3:
                res[0] = 2*arr[1] - arr[0] + 1;
                res[1] = 2*arr[0] - arr[1] - 1;
                res[2] = arr[2];
                break;
        }

        return res;
    }


}
