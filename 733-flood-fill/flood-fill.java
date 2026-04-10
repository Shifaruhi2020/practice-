// chatGPT for code
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if(originalColor == color) return image;

        dfs(sr, sc, image, originalColor, color);

        return image;
    }
    
    public void dfs(int r, int c, int[][] image, int originalcolor, int color){

        int n = image.length;
        int m = image[0].length;

        if(r >=0 && r < n && c >= 0 && c < m && image[r][c] == originalcolor){
            image[r][c] = color;
            dfs(r - 1, c, image, originalcolor, color);
            dfs(r, c + 1, image, originalcolor, color);
            dfs(r + 1, c, image, originalcolor, color);
            dfs(r, c - 1, image, originalcolor, color);
        }
        return;
    }

}