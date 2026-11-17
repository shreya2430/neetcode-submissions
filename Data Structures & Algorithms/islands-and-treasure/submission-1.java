class Solution {
    int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> q = new ArrayDeque<>();
        int land = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                    land++;
                }
            }
        }
        if(land == 0){
            return;
        }
        int[][] dirn = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d : dirn){
                int newR = curr[0]+d[0];
                int newC = curr[1] + d[1];

                if(newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length || grid[newR][newC] == -1){
                    continue;
                }
                if(grid[newR][newC] == INF){
                    grid[newR][newC] =  grid[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{newR, newC});
                }
            }
        }
    }
}
