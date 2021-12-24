import java.util.ArrayDeque;
import java.util.Queue;

public class Graph {

    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int v) {
        //初始化顶点数量
        this.V = v;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[this.V];

        for (int i=0; i<V; i++){
            adj[i] = new ArrayDeque<Integer>();
        }
    }

    //获取顶点数目
    public int V(){
        return this.V;
    }

    //获取边的数目
    public int E(){
        return this.E;
    }

    //向图中添加一条边 v-w
    public void addEdge(int v, int w){
        //在无向图中，边是没有方向的，所以该边既可以说是从v到w的边，又可以说是从w到v的边，
        // 因此，需要让w出现在v的邻接表中，并且还要让v出现在w的邻接表中
        adj[v].add(w);
        adj[w].add(v);
        //边的数量+1
        this.E++;
    }

    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(6, 4);

        System.out.println("图中的边数目" + graph.E());

        System.out.println("节点0相邻的节点有:");
        for(Integer v: graph.adj(0)){
            System.out.print(v + " ");
        }
    }

}
