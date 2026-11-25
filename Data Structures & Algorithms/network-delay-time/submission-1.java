class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new List[n+1];
        for(int i=1;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];

            adjList[u].add(new int[]{v, t});
        }
        int[] d = new int[n+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[k] = 0;
        // d[0] = 0;
    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0, k}); //[0, 1]
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            // int d = curr[0];
            // int n = curr[1];
            // {{2, 1}, {4,4}}
            if(d[curr[1]] < curr[0]){
                continue;
            }
            for(int[] edge : adjList[curr[1]]){
                int dist = curr[0]+edge[1];
                if(d[edge[0]] > dist){
                    d[edge[0]] = dist;
                    pq.offer(new int[]{dist, edge[0]});
                }
            } 
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(d[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, d[i]);
        }
        return max;
    }
}
/**
1-> 2 4
2-> 3
3->4
4->[]

d[1] = 0
d = [-1, 0, -1, -1]

pq<dist, Node> -> 
{2, 0}, {3, 1}, {4, 2}
*/
