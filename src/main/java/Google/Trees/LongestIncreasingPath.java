package Google.Trees;

public class LongestIncreasingPath {

    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static int m;
    private static int n;

    public static void main(String[] args) {

        int[][] input = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        int longestIncreasingPath = findLongestIncreasingPath(input);
        System.out.println(longestIncreasingPath);
    }

    private static int findLongestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j));
        return ans;
    }

    private static int dfs(int[][] matrix, int i, int j) {
        int ans = 0;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < m && 0 <= y && y < n && matrix[x][y] > matrix[i][j])
                ans = Math.max(ans, dfs(matrix, x, y));
        }
        return ++ans;
    }
}
