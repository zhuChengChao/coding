import java.util.LinkedList;
import java.util.Queue;

public class EdgeWeightedGraph {

    //顶点总数
    private final int V;
    //边的总数
    private int E;
    //邻接表
    private Queue<Edge>[] adj;

    //创建一个含有V个顶点的空加权无向图
    public EdgeWeightedGraph(int V) {
        //初始化顶点数量
        this.V = V;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[V];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new LinkedList<>();
        }
    }

    //获取图中顶点的数量
    public int V(){
        return V;
    }

    //获取图中边的数量
    public int E(){
        return E;
    }

    //向加权无向图中添加一条边e
    public void addEdge(Edge e){
        //需要让边e同时出现在e这个边的两个顶点的邻接表中
        int v = e.either();
        int w = e.other(v);
        //添加边到点的邻接表中
        adj[v].add(e);
        adj[w].add(e);
        //边的数量+1
        this.E++;
    }

    //获取和顶点v关联的所有边
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    //获取加权无向图的所有边
    public Queue<Edge> edges(){
        //创建一个队列对象，存储所有的边
        Queue<Edge> allEdges = new LinkedList<>();
        //遍历图中的每一个顶点，找到该顶点的邻接表，邻接表中存储了该顶点关联的每一条边
        //因为这是无向图，所以同一条边同时出现在了它关联的两个顶点的邻接表中，需要让一条边只记录一次；
        for (int v = 0; v < this.V; v++) {
            //遍历v顶点的邻接表，找到每一条和v关联的边
            for(Edge e: adj(v)){
                if(v < e.other(v)){
                    allEdges.add(e);
                }
            }
        }
        return allEdges;
    }
}
