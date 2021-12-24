class UF {
    // 连通分量个数
    private int count;
    // 存储一棵树，用于记录节点x的父节点
    private int[] parent;
    // 记录树的“重量”，出于平衡的目的
    private int[] size;

    // 构造函数，n为图的节点总数
    public UF(int n) {
        // 初始状态：节点之间互不连通
        this.count = n;
        // 父节点指向自身
        parent = new int[n];
        // 重量都为1
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // 连通p节点与q节点
    public void union(int p, int q) {
        int rootP = find(p);  // 找到p节点的父节点
        int rootQ = find(q);  // 找到q节点的父节点
        if (rootP == rootQ)
            return;

        // 小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            // 让小树rootQ指向大树rootP
            parent[rootQ] = rootP;
            // 大树的尺寸要加上小树的尺寸
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        // 连通量-1
        count--;
    }

    // 判断p节点与q节点是否相连
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }

    // 获取此时连通量的个数
    public int getCount(){
        return this.count;
    }

    // 找x节点的父节点：带路径压缩的
    private int find(int x) {
        while (parent[x] != x) {
            // 进行路径压缩，使得整体的复杂度都降至O(1)
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    // 找x节点的父节点：不带路径压缩的
    // private int find(int x) {
    //     // 根节点的 parent[x] == x
    //     while (parent[x] != x){
    //         x = parent[x];
    //     }
    //     return x;
    // }
}
