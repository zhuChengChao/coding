package cn.xyc.old;

import java.util.*;

public class Main04 {

    public static void main(String[] args) {

        int[][] a = new int[][]{{0,1,3}, {1,2,2}, {0,2,1}};
        int i = new Main04().GetBestWarehouseLocate(a, 3);
        System.out.println(i);
    }

    public int GetBestWarehouseLocate (int[][] distancePairs, int CityNum) {
        // write code here

        List<Integer> vertexs = new ArrayList<>();

        int numEdges = distancePairs.length;

        int[][] edges = new int[CityNum][CityNum];

        int a, b, c, min = Integer.MAX_VALUE, index = -1, temp;

        for (int i = 0; i < numEdges; i++) {
            a = distancePairs[i][0];
            b = distancePairs[i][1];
            c = distancePairs[i][2];

            edges[a][b] = edges[b][a] = c;

        }

        Graph graph = new Graph(vertexs, edges, numEdges);

        for (int i = 0; i < CityNum; i++) {
            temp = graph.canku(i);
            if(temp < min){
                min = temp;
                index = i;
            }
        }

        return index;
    }

    public class Graph{

        public ArrayList<Integer> vertexs;
        public int[][] edges;
        public int numOfEdge;
        public boolean[] isKnow;
        public int[] path;
        public int[] dist;
        public int len;

        public Graph(){
            super();
        }

        public Graph(List<Integer> vertexs, int[][] edges, int numOfEdge){
            this.edges = edges;
            this.numOfEdge = numOfEdge;
            this.len = edges.length;
        }

        public int canku(int start){
            this.isKnow = new boolean[len];
            this.dist = new int[len];
            this.path = new int[len];

            for (int i=0; i<len; i++){
                dist[i] = Integer.MAX_VALUE;
            }
            dist[start] = 0;

            for (int i = 0; i < len - 1; i++) {
                int index = closed();
                if(index == -1){
                    break;
                }

                isKnow[index] = true;

                for (int j = 0; j < len; j++) {
                    if(edges[index][j] != 0 && !isKnow[j]){
                        if(dist[j] > dist[index] + edges[index][j]){
                            dist[j] = dist[index] + edges[index][j];
                            path[j] = index;
                        }
                    }
                }
            }

            int result = 0;
            for(int i=0; i<len; i++){
                result += dist[i];
            }

            return result;
        }

        private int closed(){
            int min = Integer.MAX_VALUE, index = -1;
            for (int j = 0; j < len; j++) {
                if(!isKnow[j] && dist[j] < min){
                    min = dist[j];
                    index = j;
                }

            }

            return index;
        }
    }
}
