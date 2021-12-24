package cn.xyc.dogdong;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()){

            // n服务数
            String[] nq = sc.nextLine().split(" ");
            int n = Integer.valueOf(nq[0]);
            int q = Integer.valueOf(nq[1]);

            // 依赖的服务
            List<List<Integer>> services = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> tmp = new LinkedList<>();
                String[] numStr = sc.nextLine().split(" ");
                int count = Integer.valueOf(numStr[0]);
                for (int j = 0; j < count; j++) {
                    tmp.add(Integer.valueOf(numStr[j+1]));
                }
                services.add(tmp);
            }

            // 询问情况
            int[][] querys = new int[q][2];
            for (int i = 0; i < q; i++) {
                String[] numStr = sc.nextLine().split(" ");
                querys[i][0] = Integer.valueOf(numStr[0]);
                querys[i][1] = Integer.valueOf(numStr[1]);
            }


            int[] states = new int[n];
            int[] running = new int[q];
            for (int i = 0; i < q; i++) {

                // 启动或停止
                int open = querys[i][0];
                int id = querys[i][1];

                if(open == 1){
                    // 开启服务
                    states[id] = 1;
                    // 找出那些服务会顺带被开启
                    Set<Integer> tmpSet = new HashSet<>();
                    for(Integer tmp: services.get(id)){
                        tmpSet.add(tmp);
                    }

                    for (int j = 0; j < n; j++) {
                        if(tmpSet.contains(j)){
                            tmpSet.addAll(services.get(j));
                        }
                    }

                    Iterator<Integer> iterator = tmpSet.iterator();
                    while (iterator.hasNext()){
                        states[iterator.next()] = 1;
                    }
                }else{
                    // 关闭服务
                    states[id] = 0;
                    // 找出那些服务会顺带被关闭
                    List<Integer> contiains = services.get(id);

                }
            }


        }
    }

}


//3 2
//1 2
//1 3
//0
//1 1
//0 2