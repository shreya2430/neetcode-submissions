class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights.length == 0){
            return res;
        }
        int m = heights.length;
        int n = heights[0].length;
        //visited arr
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n-1, atlantic);
        }
        for(int i=0;i<n;i++){
            dfs(heights, 0, i, pacific);
            dfs(heights, m-1, i, atlantic);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(List.of(i, j));
                }
            }
        }
        return res;
    }
    int[][] dirn = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private void dfs(int[][] heights, int r, int c, boolean[][] visited){
        if(visited[r][c]){
            return;
        }
        visited[r][c] = true;
        for(int[] d : dirn){
            int newR = r+d[0];
            int newC = c+d[1];

            if(newR < 0 || newR >= heights.length || newC < 0 || newC >= heights[0].length){
                continue;
            }
            if(heights[newR][newC] >= heights[r][c]){
                dfs(heights, newR, newC, visited);
            }
        }
    }

}
