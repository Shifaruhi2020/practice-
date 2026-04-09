// vid link : https://www.youtube.com/watch?v=yf3oUhkvqA0
// chatGPT for understanding the code

import java.util.*;

class Pair{
    int row ;
    int col;
    int tm;

    Pair(int row, int col, int tm){
        this.row = row;
        this.col = col; 
        this.tm = tm;
    }
    }

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[m][n];
        int cntFresh = 0;

// checking for the number of fresh oranges 
// hence the var cntFresh
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                // where we have 2 in grid we
                if(grid[i][j] == 2){
                    // add the rotten organes grid coordinates
                    q.add(new Pair(i, j, 0));
                    // and vis array in the place of these coordinates get 2
                    vis[i][j] = 2;
                }
                // and wherever we have fresh oranges we put 0 in the vis array
                else vis[i][j] = 0;
                // whenever we encounter fresh orange we update and remember the
                // number
                if(grid[i][j] == 1) cntFresh++;
            }
        }

        //  we will note down the time and this is the time we will return 
        int tm = 0;
        // coordinates - direction array
        // | Index | Move   | Meaning |
        // | ----- | ------ | ------- |
        // | 0     | (-1,0) | Up      |
        // | 1     | (0,1)  | Right   |
        // | 2     | (1,0)  | Down    |
        // | 3     | (0,-1) | Left    |

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0,1, 0 , -1};

        int cnt = 0;

        // here we are implmenting the actual bfs logic 
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            tm = Math.max(tm, t);
            q.remove();

            for(int i = 0; i < 4 ; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow, ncol, tm + 1));
                    vis[nrow][ncol] = 2;
                    cnt++; 
                }
            }
        }

        // checking if all the fresh oranges have been turned to rotten 
        // if not turned return -1
        if(cntFresh != cnt) return -1;
        // else return tm
        return tm;   
    }
}