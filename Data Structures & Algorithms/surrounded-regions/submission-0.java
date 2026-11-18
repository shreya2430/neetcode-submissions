//check all 4 boundary and if there's cell 0 increase its kingdown in all 4 dirn using dfs
//mark those 0 to '#'
//loop through board, 0 kingdom will be capture using X and '#' kingdom are safe
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        //check each boundary
        for(int i=0;i<m;i++){
            safeRegions(board, i, 0);
             safeRegions(board, i, n-1);
        }  
        for(int i=0;i<n;i++){
            safeRegions(board, 0, i);
            safeRegions(board, m-1, i);
        }     

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void safeRegions(char[][] board, int r, int c){
        if(r<0 || r>= board.length || c <0 || c>= board[0].length || board[r][c] != 'O'){
            return;
        }
        board[r][c] = '#';
        safeRegions(board, r+1, c);
        safeRegions(board, r-1, c);
        safeRegions(board, r, c+1);
        safeRegions(board, r, c-1);
    }
}
