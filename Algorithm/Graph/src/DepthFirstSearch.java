import java.io.PrintWriter;

public class DepthFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与s顶点相通
    private int count;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
    public DepthFirstSearch(Graph graph, int s) {
        //初始化marked数组
        this.marked = new boolean[graph.V()];
        //初始化跟顶点s相通的顶点的数量
        this.count = 0;

        dfs(graph, s);
        System.out.println();
    }

    //使用深度优先搜索找出G图中v顶点的所有相通顶点
    private void dfs(Graph graph, int v){
        //把v顶点标识为已搜索
        marked[v] = true;
        System.out.print(v + "  ");

        for (Integer w: graph.adj(v)){
            //判断当前w顶点有没有被搜索过，如果没有被搜索过，则递归调用dfs方法进行深度搜索
            if (!marked[w]){
                dfs(graph, w);
                this.count++;
            }
        }

    }

    //判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }

    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return this.count;
    }

    public static void main(String[] args) {
        //准备Graph对象
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

        //准备深度优先搜索对象
        DepthFirstSearch dfSearch = new DepthFirstSearch(graph, 0);
        //测试与某个顶点相通的顶点数量
        int count = dfSearch.count();
        System.out.println("与起点0相通的顶点的数量为:"+count);

        //测试某个顶点与起点是否相同
        System.out.println("顶点5和顶点0是否相通："+dfSearch.marked(5));
        dfSearch.marked(5);
        System.out.println("顶点7和顶点0是否相通："+dfSearch.marked(7));
    }

}
