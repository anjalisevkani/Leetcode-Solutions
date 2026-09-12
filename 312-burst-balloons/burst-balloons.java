class Solution {

    int[][] dp;

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        dp = new int[n + 2][n + 2];

        return solve(0, n + 1, arr);
    }

    int solve(int left, int right, int[] arr) {

        // No balloon between left and right
        if (left + 1 == right) {
            return 0;
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int max = 0;

        // Choose k as the LAST balloon
        for (int k = left + 1; k < right; k++) {

            int coins =
                solve(left, k, arr)
                + solve(k, right, arr)
                + arr[left] * arr[k] * arr[right];

            max = Math.max(max, coins);
        }

        return dp[left][right] = max;
    }
}