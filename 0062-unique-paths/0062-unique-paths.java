class Solution {
    int ans = 0;

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return fun(m, n, 0, 0, dp);
    }

    private int fun(int m, int n, int i, int j, int[][] dp) {
        if (m - 1 == i && n - 1 == j) {
            return 1;
        }
        if (i >= m || j >= n || i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = fun(m, n, i + 1, j, dp) + fun(m, n, i, j + 1, dp);
        return dp[i][j];
    }
}