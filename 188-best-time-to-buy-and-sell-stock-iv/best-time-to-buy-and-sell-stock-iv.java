class Solution {

    int[][][] dp;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(0, 0, 1, k, prices);
    }

    int solve(int day, int transactions, int buy,
              int k, int[] prices) {

        // End of array
        if (day == prices.length) {
            return 0;
        }

        // Maximum transactions completed
        if (transactions == k && buy == 0) {
            return 0;
        }

        if (dp[day][transactions][buy] != -1) {
            return dp[day][transactions][buy];
        }

        int profit;

        if (buy == 1) {

            // Buy
            int buying = -prices[day]
                    + solve(day + 1, transactions, 0, k, prices);

            // Don't buy
            int skip = solve(day + 1, transactions, 1, k, prices);

            profit = Math.max(buying, skip);

        } else {

            // Sell
            int selling = prices[day]
                    + solve(day + 1, transactions + 1, 1, k, prices);

            // Don't sell
            int skip = solve(day + 1, transactions, 0, k, prices);

            profit = Math.max(selling, skip);
        }

        return dp[day][transactions][buy] = profit;
    }
}