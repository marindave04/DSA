class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long max = Long.MIN_VALUE;
        long profit = 0;
        int m = strategy.length;

        long[] prefix = new long[m];
        long[] prefix1 = new long[m];

        prefix1[0] = 1L * prices[0];
        for (int z = 1; z < m; z++) {
            prefix1[z] = prefix1[z - 1] + 1L * prices[z];
        }

        prefix[0] = 1L * prices[0] * strategy[0];
        for (int z = 1; z < m; z++) {
            prefix[z] = prefix[z - 1] + 1L * prices[z] * strategy[z];
        }

        for (int t = 0; t < m; t++) {
            profit += 1L * prices[t] * strategy[t];
        }

        int i = 0, j = 0;
        int mid = k / 2;

        while (j < m) {
            if (j - i + 1 < k) {
                j++;
            } else {
                long y = prefix1[j] - prefix1[mid + i - 1];
                long x = (i > 0) ? prefix[j] - prefix[i - 1] : prefix[j];
                max = Math.max(max, profit - x + y);
                i++;
            }
        }
        return Math.max(max, profit);
    }
}
