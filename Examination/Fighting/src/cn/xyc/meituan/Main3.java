package cn.xyc.meituan;


/**
 * 文件流
 */
public class Main3 {

    public static void main(String[] args) {

        int m = 6;
        int n = 6;
        int k = 3;
        int[][] nums = {
                {4,4,2},
                {3,3,2},
                {2,4,1}
        };

        int res = new Main3().Solution(m, n, k, nums);
        System.out.println(res);
    }

    private int Solution(int m, int n, int k, int[][] nums) {
        // 初始草
        int[][] gass = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                gass[i][j] = 1;
            }
        }
        // 开始早上除草
        int res = 0;
        for(int day=0; day<k; day++){
            // 判断坐标是否在原的位置中
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Double dis1 =
                            Math.pow(Math.abs(nums[day][0]-1-i),2) +
                            Math.pow(Math.abs(nums[day][1]-1-j),2);
                    Double dis2 = Math.pow(nums[day][2], 2);
                    if(dis1.intValue() <= dis2.intValue()){
                        gass[i][j] = 0;
                    }

                    if(day<k-1){
                        // 最后一天不长了
                        gass[i][j] += 1;
                    }

                    if(day == k-1){
                        res += gass[i][j];
                    }
                }
            }
        }
        return res;
    }
}
