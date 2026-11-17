class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.merge(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];
    }
}
class UnionFind{
    int[] parent;
    int[] rank;

    UnionFind(int n){
        this.parent = new int[n+1];
        this.rank = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
    }

    int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean merge(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }

        if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }else if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        }else{
            parent[rootB] = rootA;
            rank[rootA]++;
        }
        return true;
    }
}