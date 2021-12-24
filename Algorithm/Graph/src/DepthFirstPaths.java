import java.util.Stack;

public class DepthFirstPaths {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
    public DepthFirstPaths(Graph graph, int s){
        //初始化marked数组
        this.marked = new boolean[graph.V()];
        //初始化起点
        this.s = s;
        //初始化edgeTo数组
        this.edgeTo = new int[graph.V()];

        dfs(graph, s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs(Graph graph, int v){
        //把v表示为已搜索
        marked[v] = true;

        //如果顶点w没有被搜索，则继续递归搜索
        for (Integer w: graph.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    //判断v顶点与s顶点是否存在路径
    public boolean hasPathTo(int v){
        return marked[v];
    }

    //找出从起点s到顶点v的路径(就是该路径经过的顶点)
    public Stack<Integer> pathTo(int v){
        //该点不在路径中，直接返回空栈
        if(!hasPathTo(v)){
            return null;
        }

        //创建栈对象，保存路径中的所有顶点
        Stack<Integer> stack = new Stack<>();

        //通过循环，从顶点v开始，一直往前找，到找到起点为止
        for (int x = v; x != this.s ; x = edgeTo[x]) {
            stack.push(x);
        }

        //放入起点
        stack.push(this.s);
        return stack;
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

        DepthFirstPaths dfp = new DepthFirstPaths(graph, 0);
        //调用 pathTo(4)，找到从起点0到终点4的路径，返回Stack
        Stack<Integer> paths = dfp.pathTo(4);

        StringBuffer sb = new StringBuffer();
        for(Integer path: paths){
            sb.append(path+"->");
        }

        System.out.println(sb.substring(0, sb.length()-2).toString());
    }

}
