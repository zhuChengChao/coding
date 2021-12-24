import java.util.*;


/**
  * 带权最短距离
  *     使用优先队列的 BFS 实现典型的就是 dijkstra 算法。
  *     dijkstra 算法主要解决的是图中任意两点的最短距离。
  *     算法的基本思想是贪心，每次都遍历所有邻居，并从中找到距离最小的，本质上是一种广度优先遍历。
  */
public class Dijkstra {

    public static void main(String[] args) {
        // 伪代码
        // 定义邻接表
        // 邻接表，key:源节点，value:源节点连接的目标节点，其中的int[]中存储了点和权值
        Map<Integer, List<int[]>> graph = new HashMap<>();

        int[][] times = new int[1][3];
        times[0] = new int[]{1,2,1};

        for(int[] t: times){
            // 构建邻接表
            if(!graph.containsKey(t[0])){
                // 这个源节点还没有加入邻接表，则加入
                graph.put(t[0], new ArrayList<>());
            }
            // 放入目标点和权值
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }
    }

    // dijkstra，输入：邻接表，节点数，开始节点，结束节点
    public int dijkstra(Map<Integer, List<int[]>> graph, int N, int start, int end){

        // 如果走完所有点，那么不会有 Integer.MAX_VALUE，否则就是没走完
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        // 标记节点是否已经被访问过
        boolean[] visited = new boolean[N + 1];

        // 将起点和冗余点的距离设为0
        dis[start] = 0;
        dis[0] = 0; // 这里节点是从1开始标号的

        // 建立优先队列，长度大的会自动排到后面
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> dis[o1] - dis[o2]);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            // 该节点是否访问过
            if (visited[node]) continue;
            visited[node] = true;

            if(node == end){
                // 后面开始访问这个节点的相邻节点了，没必要了，可以直接返回了
                return dis[node];
            }

            // 邻接表中有这个key时，就弹出相邻节点，否则弹出空的
            List<int[]> list = graph.getOrDefault(node, Collections.emptyList());
            for (int[] arr : list) {  // 遍历相邻节点
                int next = arr[0];
                if (visited[next]) continue;
                // 如果长度较长，那么会自动移到后面
                // 贪心思想。如果d[1] > d[2]，那么不可能会有0 -> 2 -> 1的距离大于0 -> 1的距离
                // 所以可以直接在满足条件的基础上入队
                dis[next] = Math.min(dis[next], dis[node] + arr[1]);
                queue.offer(next);
            }
        }
        return -1;
    }
}
