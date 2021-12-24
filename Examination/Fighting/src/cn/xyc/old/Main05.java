package cn.xyc.old;

import java.util.Arrays;
import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] M = new int[n];
            int[] T = new int[m];

            for (int i = 0; i < n; i++) {
                M[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                T[i] = sc.nextInt();
            }

            Arrays.sort(M);
            Arrays.sort(T);

            // int res = Math.max(m*2 - n*2, m - 2);
            int res = 0, init_M = 0, init_T = 0;
            for (int i = 0; i < n; i++) {
                if(M[i] > 1){
                    init_M = i + (n-i)*2;
                    break;
                }
            }

            for (int i = 0; i < m; i++) {
                if(T[i] > 1){
                    init_T = i + (m-i)*2;
                    break;
                }
            }
            res = Math.max(init_T-init_M, res);

            init_M = 0;
            init_T = 0;
            for (int i = 0; i < n; i++) {
                if(M[i] > 1000){
                    init_M = i + (n-i)*2;
                    break;
                }
            }

            for (int i = 0; i < m; i++) {
                if(T[i] > 1000){
                    init_T = i + (m-i)*2;
                    break;
                }
            }
            res = Math.max(init_T-init_M, res);


            int idx = 0;
            for(int i=0; i<m; i++){
                int dist = T[i];

                while (i+1<m && T[i+1] == dist){
                    i++;
                }
                int M_score = 0;
                int T_score = i+1 + (m-i-1)*2;

                for(int j=idx; j<n; j++){
                    if(M[j] > dist){
                        idx = j;
                        break;
                    }
                }

                M_score = idx + (n-idx)*2;
                Math.max(T_score - M_score, res);
            }

            System.out.println(res);
        }
    }
}


//2 3
//585 375
//936 317 185