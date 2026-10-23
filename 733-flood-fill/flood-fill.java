
class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldC = image[sr][sc];

        if (oldC == color) {
            return image;
        }

        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        dfs(image, sr, sc, x, y, oldC, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc,
                     int[] x, int[] y, int oldC, int color) {

        if (sr < 0 || sc < 0 ||
            sr >= image.length || sc >= image[0].length ||
            image[sr][sc] != oldC) {
            return;
        }

        image[sr][sc] = color;

        for (int i = 0; i < 4; i++) {
            int newRow = sr + x[i];
            int newCol = sc + y[i];

            dfs(image, newRow, newCol, x, y, oldC, color);
        }
    }
}
