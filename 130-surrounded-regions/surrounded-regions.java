class Solution {

    public void dfs(int x, int y, char[][] b, int[][] vis) {
        // comment below if using STRAT - 1
        vis[x][y] = 1;

        int m = b.length;
        int n = b[0].length;

        // below was my approach of the code
        // but this same thing can be written in other way which is more 
        // good way of writing the code

        // STRAT -1 
        // if(x < 0 || x >= m || y < 0 || y >= n){
        //     return;
        // }

        // if(vis[x][y] == 0 && b[x][y] == 'O'){
        //     vis[x][y] = 1;
        //     dfs(x -1, y, b, vis);
        //     dfs(x, y + 1, b, vis);
        //     dfs(x + 1, y, b, vis);
        //     dfs(x, y - 1, b, vis);
        // }

        // this is the best way
        // STRAT - 2
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nrow = x + drow[i];
            int ncol = y + dcol[i];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && b[nrow][ncol] == 'O'){
                dfs(nrow, ncol, b, vis);
                // if using this loop we will mark vis in the begining of 
                // the code
            }
        }
    }
    public void solve(char[][] board) {
            int m = board.length;
            int n = board[0].length;

            int[][] vis = new int[m][n];

            for(int y = 0; y < n; y++){
                if(board[0][y] == 'O' && vis[0][y] != 1){
                    dfs(0, y, board, vis);
                }

                if(board[m - 1][y] == 'O' && vis[m - 1][y] != 1){
                    dfs(m - 1, y, board, vis);
                }
            }

             for(int i = 0; i < m; i++){
                if(board[i][0] == 'O' && vis[i][0] != 1){
                    dfs(i, 0, board, vis);
                }

                if(board[i][n - 1] == 'O' && vis[i][n - 1] != 1){
                    dfs(i, n - 1, board, vis);
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(vis[i][j] == 0 && board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }

            

    }
}