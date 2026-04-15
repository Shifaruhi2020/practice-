
class Solution {

    public void dfs(int x, int y, int[][] g, int[][] vis){
        vis[x][y] = 1;
        int m = g.length;
        int n = g[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};

        for(int i= 0; i < 4; i++){
            int nrow = x + drow[i];
            int ncol = y + dcol[i];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && g[nrow][ncol] == 1){
                dfs(nrow, ncol, g, vis);
            }
        }
    }


    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        for(int j = 0; j < n; j++){

            if(grid[0][j] == 1 && vis[0][j] == 0){
                dfs(0, j, grid, vis);
            }

            if(grid[m -1][j] == 1 && vis[m - 1][j] == 0){
                dfs(m - 1, j, grid, vis);
            }
        }

        for(int i = 0; i < m; i++){

            if(grid[i][0] == 1 && vis[i][0] == 0){
                dfs(i, 0, grid, vis);
            }

           if(grid[i][n - 1] == 1 && vis[i][n -1] == 0){
                dfs(i, n - 1, grid, vis);
        }
        }

        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;  
}
}