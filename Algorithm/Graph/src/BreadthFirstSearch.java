import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s顶点相通
    private int count;
    //用来存储待搜索邻接表的点
    private Queue<Integer> waitSearch;

    //构造广度优先搜索对象，使用广度优先搜索找出G图中s顶点的所有相邻顶点
    public BreadthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.count=0;
        this.waitSearch = new ArrayDeque<>();

        bfs(graph, s);
    }

    //使用广度优先搜索找出G图中v顶点的所有相邻顶点
    private void bfs(Graph graph, int v){
        //把当前顶点v标识为已搜索
        marked[v] = true;
        //让顶点v进入队列，待搜索
        waitSearch.add(v);
        System.out.print("节点"+v+"广度遍历顺序为："+v);
        //通过循环，如果队列不为空，则从队列中弹出一个待搜索的顶点进行搜索
        while (!waitSearch.isEmpty()){
            //弹出一个待搜索的顶点
            Integer wait = waitSearch.remove();

            //遍历wait顶点的邻接表
            for(Integer w: graph.adj(wait)){
                // 该顶点还没被搜索过 对其进行搜索
                if(!marked[w]){
                    marked[w] = true;
                    // 将节点放入堆栈中，用于后续的获取该节点的子节点
                    waitSearch.add(w);
                    //让相通的顶点+1；
                    count++;
                    System.out.print(" "+w);
                }
            }
        }
        System.out.println();
    }

    //判断w顶点与s顶点是否相通
    private boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return this.count;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0,5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,6);
        graph.addEdge(3,4);
        graph.addEdge(4,6);
        graph.addEdge(5,3);
        graph.addEdge(5,4);
        graph.addEdge(7,8);
        graph.addEdge(9,10);
        graph.addEdge(9,11);
        graph.addEdge(9,12);
        graph.addEdge(11,12);

        // 广度优先遍历:节点0广度遍历顺序为：0 1 3 4 2
        BreadthFirstSearch bfSearch = new BreadthFirstSearch(graph, 0);

        // 深度优先遍历：0 1 2 3 4
        DepthFirstSearch dfSearch = new DepthFirstSearch(graph, 0);

        //测试与某个顶点相通的顶点数量
        int count = bfSearch.count();
        System.out.println("与起点0相通的顶点的数量为:"+count);
    }
}
