class Solution {

    static long[][][] dp = new long[1001][501][3];

    public long maximumProfit(int[] prices, int k) {

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l < 3; l++) {
                    dp[i][j][l] = Long.MIN_VALUE;
                }
            }
        }
        return solve(0, k, 0, prices);
    }

    static long solve(int i, int k, int temp, int[] prices) {

        if (i >= prices.length) {
            if (temp == 0) return 0;
            else return Long.MIN_VALUE/2;
        }

        if (dp[i][k][temp] != Long.MIN_VALUE)
            return dp[i][k][temp];

        long take = Long.MIN_VALUE;
        long skip = solve(i + 1, k, temp, prices);

        if (k > 0) {
            if (temp == 1) {
                take = prices[i] + solve(i + 1, k - 1, 0, prices);
            } else if (temp == 2) {
                take = -prices[i] + solve(i + 1, k - 1, 0, prices);
            } else {
                take = Math.max(
                        prices[i] + solve(i + 1, k, 2, prices),
                        -prices[i] + solve(i + 1, k, 1, prices)
                );
            }
        }

        return dp[i][k][temp] = Math.max(take, skip);
    }
}
