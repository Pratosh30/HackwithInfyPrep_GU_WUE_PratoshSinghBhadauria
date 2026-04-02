class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int INF = 1000000000;

        int[][] dp = new int[n + 1][3];
        for (int j = 0; j <= n; j++) {
            for (int k = 0; k < 3; k++) {
                dp[j][k] = -INF;
            }
        }

        for (int k = 0; k < 3; k++) {
            dp[1][k] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = coins[i][j];
                int col = j + 1;

                int next2 = Math.max(Math.max(dp[col - 1][2] + x, dp[col][2] + x),
                                     Math.max(dp[col - 1][1], dp[col][1]));

                int next1 = Math.max(Math.max(dp[col - 1][1] + x, dp[col][1] + x),
                                     Math.max(dp[col - 1][0], dp[col][0]));

                int next0 = Math.max(dp[col - 1][0], dp[col][0]) + x;

                dp[col][2] = next2;
                dp[col][1] = next1;
                dp[col][0] = next0;
            }
        }

        return dp[n][2];
    }
}