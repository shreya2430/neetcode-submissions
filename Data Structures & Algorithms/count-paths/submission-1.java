class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return 1;
        }
        int[][] memo = new int[m][n];
        return dfs(0,0, m, n, memo);
    }
    private int dfs(int i, int j, int m, int n, int[][] memo){
        if(i<0 || i>= m || j<0 || j>= n){
            return 0;
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        if(i >= m-1 || j >= n-1){
            return memo[i][j] = 1;
        }
        return memo[i][j] = dfs(i+1, j, m, n, memo) + dfs(i, j+1, m, n, memo);
    }
}
