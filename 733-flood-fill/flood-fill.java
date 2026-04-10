import java.util.*;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();

        int originalcolor = image[sr][sc];

        if(originalcolor == color) return image;

        image[sr][sc] = color;

        q.add(new Pair(sr, sc));

        while(!q.isEmpty()){
            Pair curr = q.remove();

            for(int i = 0; i < 4; i++){

            int nextSR = curr.row + drow[i];
            int nextSC = curr.col + dcol[i];

            if(nextSR >= 0 && nextSR <n && nextSC >= 0 && nextSC < m && originalcolor == image[nextSR][nextSC]){
                q.add(new Pair(nextSR, nextSC));
                image[nextSR][nextSC] = color;
            }
        }
        }
        
        return image;
    }
}