class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j, 0});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }

        int bestTime = 0;
        int[][] dirn = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int t = curr[2];
            for(int[] d : dirn){
                int newR = curr[0] + d[0];
                int newC = curr[1] + d[1];

                if(newR < 0 || newR >= m || newC < 0 || newC >= n || grid[newR][newC] != 1){
                    continue;
                }
                grid[newR][newC] = 2;
                fresh--;
                q.offer(new int[]{newR, newC, t+1});
                // bestTime = Math.max(bestTime, t+1);

                if(fresh == 0){
                    return t+1;
                }
            }
        }
        return -1;
    }
}
