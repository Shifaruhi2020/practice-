// solution link : https://www.youtube.com/watch?v=edXdVwkYHF8
// chatGPT fr solution

import java.util.*;

class Pair{
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] vis = new int[m][n];

        Queue<Pair> q = new LinkedList<>();

        int[][] dis = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    dis[i][j] = 0;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        bfs(mat, vis, dis, q, m , n);
        return dis;
    }

    public void bfs(int[][] mat, int[][] vis, int[][] dis, Queue<Pair> q, int m , int n){

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Pair item = q.remove();

            int src1 = item.row;
            int src2 = item.col;
            int dist = item.dist;

            for(int i = 0; i < 4; i++){

                int newRow = src1 + drow[i];
                int newCol = src2 + dcol[i];

                if( newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && vis[newRow][newCol] == 0){
                    q.add(new Pair(newRow, newCol, dist + 1));
                    vis[newRow][newCol] = 1;
                    dis[newRow][newCol] = dist + 1 ;
                }
            }

        }
    }
}