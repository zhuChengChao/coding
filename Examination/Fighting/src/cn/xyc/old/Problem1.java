package cn.xyc.old;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    static int x2,y2,z2,n;
    public static void main(String[] args) {
        //需要变换成的坐标
        x2 = 0;
        y2 = 1;
        z2 = 5;
        n = 10;
        System.out.println(backtracking(3, 1, 2, new HashSet<String>()));
    }

    public static boolean backtracking(int x1, int y1, int z1, Set<String> set){

        if(x1 == x2 && y1==y2 && z1==z2){
            return true;
        }

        if(x1>n||y1>n||z1>n){
            return false;
        }

        if(set.contains(""+x1+y1+z1)){
            return false;
        }else{
            set.add(""+x1+y1+z1);
        }

        return backtracking(y1,x1,z1,set)||backtracking(x1,z1,y1,set)||backtracking(z1,y1,x1,set)||backtracking(2*y1-x1+1,2*x1-y1-1,z1,set);
    }
}