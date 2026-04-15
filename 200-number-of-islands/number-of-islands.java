// sol link : https://www.youtube.com/watch?v=muncqlKJrH0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {

    public void bfs(int x, int y, char[][] g, int[][] vis){
        vis[x][y] = 1;
        int m = g.length;
        int n = g[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){

            Pair  node = q.poll();

            for(int i = 0; i < 4; i++){

                int nrow = node.row + drow[i];
                int ncol = node.col + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && g[nrow][ncol] == '1'){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        int cnt = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    bfs(i, j, grid, vis);
                    cnt++;
                }
            }
        }

        return cnt;
        
    }
}