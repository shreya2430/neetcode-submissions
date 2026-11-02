class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n -1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.merge(edge[0], edge[1])){
              return false;
            }
        }
        return true;
    }
}
class UnionFind{
    int[] parent;
    int[] rank;

    UnionFind(int n){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i=0;i<n;i++){
            this.parent[i] = i;
        }
    }

    int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    boolean merge(int a, int b){
        int pA = find(a);
        int pB = find(b);

        if(pA == pB){
            return false;
        }
        if(rank[pA] > rank[pB]){
            parent[pB] = pA;
        }
        else if(rank[pA] < rank[pB]){
            parent[pA] = pB;
        }else{
            parent[pA] = pB;
            rank[pA]++;
        }
        return true;
    }
}

/**
one node can max have two edges 
two 
 */