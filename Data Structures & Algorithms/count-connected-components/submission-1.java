class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int components = n;
        for(int[] edge : edges){
            if(uf.merge(edge[0], edge[1])){
                components--;
            }
        }
        return components;
    }
}
class UnionFind{
    int[] parent;
    int[] rank;

    UnionFind(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
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
        int rA = find(a);
        int rB = find(b);
        if(rA == rB){
            return false;
        }

        if(rank[rA] > rank[rB]){
            parent[rB] = rA;
        }else if(rank[rA] < rank[rB]){
            parent[rA] = rB;
        }else{
            parent[rB] = rA;
            rank[rA]++;
        }
        return true;
    }
}
